package com.samsung.android.support.senl.p148nt.stt.base.filedata;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AudioFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class M4aReader {
    private static final String INVALID_NAME = "Invalid_name";
    private static final String TAG = "M4aReader";
    private ByteBuffer mBuffer;
    private FileChannel mChannel;
    private final String mPath;
    private String mUpdatePath;
    private final byte[] UDTA_ATOM_HEADER = {0, 0, 0, 0, 117, 100, 116, SprAttributeBase.TYPE_ANIMATOR_SET};
    private final byte[] SMTA_ATOM_HEADER = {0, 0, 0, 0, 115, 109, 116, SprAttributeBase.TYPE_ANIMATOR_SET, 0, 0, 0, 0};

    public M4aReader(String str) {
        this.mPath = str;
    }

    private String arrToAscii(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            if (b < 0) {
                return INVALID_NAME;
            }
            sb.append((char) b);
        }
        return sb.toString();
    }

    private void correctChunkOffsets(FileChannel fileChannel, int i, M4aInfo m4aInfo) {
        try {
            if (m4aInfo.getMoovPos() < m4aInfo.getAtomPosition(M4aConsts.MDAT)) {
                Logger.m12701d(TAG, "correctChunkOffsets# moovPos < mdat pos: " + m4aInfo.getMoovPos() + " < " + m4aInfo.getAtomPosition(M4aConsts.MDAT));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                if (!m4aInfo.hasAtom("co64")) {
                    if (m4aInfo.hasAtom("st64")) {
                        Logger.m12701d(TAG, "correctChunkOffsets# found st64 box");
                    }
                    if (m4aInfo.hasAtom("stco")) {
                        Logger.m12701d(TAG, "correctChunkOffsets# found stco box");
                    }
                    Logger.m12702e(TAG, "correctChunkOffsets# not found co64 box");
                    return;
                }
                Logger.m12701d(TAG, "correctChunkOffsets# co64 box# pos: " + m4aInfo.getAtomPosition("co64") + " # length: " + m4aInfo.getAtomLength("co64"));
                fileChannel.position(m4aInfo.getAtomPosition("co64") + 12);
                byteBufferAllocate.rewind();
                if (fileChannel.read(byteBufferAllocate) < 0) {
                    Logger.m12702e(TAG, "correctChunkOffsets# co64 box not have any offsets");
                    return;
                }
                byteBufferAllocate.rewind();
                int i2 = byteBufferAllocate.getInt();
                Logger.m12701d(TAG, "correctChunkOffsets# co64 box offsets #total chunk: " + i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    long atomPosition = m4aInfo.getAtomPosition("co64") + 16 + ((long) (i4 * 8));
                    fileChannel.position(atomPosition);
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(8);
                    if (fileChannel.read(byteBufferAllocate2) < 0) {
                        Logger.m12702e(TAG, "correctChunkOffsets# co64 box offsets not found offset index " + i4);
                        return;
                    }
                    byteBufferAllocate2.rewind();
                    long j = byteBufferAllocate2.getLong();
                    byteBufferAllocate2.rewind();
                    long j2 = ((long) i) + j;
                    byteBufferAllocate2.putLong(j2);
                    byteBufferAllocate2.rewind();
                    fileChannel.position(atomPosition);
                    fileChannel.write(byteBufferAllocate2);
                    Logger.m12701d(TAG, "correctChunkOffsets# co64 box offsets: " + i4 + " #oldOffset: " + j + " #new offset: " + j2);
                }
            }
        } catch (Exception e) {
            Logger.m12702e(TAG, "correctChunkOffsets# error " + e);
        }
    }

    private void findCustomAtom(M4aInfo m4aInfo, String str, long j) throws IOException {
        try {
            this.mChannel.position(j + 8);
            this.mBuffer.rewind();
            String str2 = "";
            while (!str2.equals(str)) {
                if (this.mChannel.read(this.mBuffer) == -1) {
                    return;
                }
                this.mBuffer.rewind();
                long j2 = this.mBuffer.getInt();
                this.mBuffer.rewind();
                if (this.mChannel.read(this.mBuffer) < 0) {
                    return;
                }
                this.mBuffer.rewind();
                String strArrToAscii = arrToAscii(this.mBuffer.array());
                if (!strArrToAscii.equals(str)) {
                    long j3 = j2 - 8;
                    if (j3 < 0 || this.mChannel.position() + j3 > this.mChannel.size()) {
                        return;
                    }
                    FileChannel fileChannel = this.mChannel;
                    fileChannel.position(fileChannel.position() + j3);
                }
                str2 = strArrToAscii;
            }
            m4aInfo.customAtomPosition.put(str, Long.valueOf(this.mChannel.position() - 8));
            long jPosition = this.mChannel.position() - 8;
            long jPosition2 = this.mChannel.position();
            this.mChannel.position(jPosition);
            if (this.mChannel.read(this.mBuffer) < 0) {
                return;
            }
            this.mBuffer.rewind();
            int i = this.mBuffer.getInt();
            this.mBuffer.rewind();
            this.mChannel.position(jPosition2);
            m4aInfo.putAtom(str, i, jPosition);
        } catch (IOException e) {
            Logger.m12702e(TAG, "findSTTDAtom: Error reading the file " + e.getMessage());
            throw e;
        }
    }

    private File getTempFile(String str) {
        int i;
        File file;
        int iLastIndexOf = str.lastIndexOf(46);
        try {
            i = Integer.parseInt(str.substring(iLastIndexOf - 1, iLastIndexOf)) + 1;
            iLastIndexOf--;
        } catch (Exception e) {
            Logger.m12701d(TAG, "getTempFile last index is not number: " + e.getMessage());
            i = 0;
        }
        do {
            this.mUpdatePath = str.substring(0, iLastIndexOf) + i + AudioFormat.ExtType.EXT_M4A;
            file = new File(this.mUpdatePath);
            i++;
        } while (file.exists());
        return file;
    }

    private boolean isM4A() {
        return isM4A(this.mPath);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[Catch: all -> 0x00e4, SYNTHETIC, TRY_LEAVE, TryCatch #3 {all -> 0x00e4, blocks: (B:19:0x00d4, B:47:0x0106, B:46:0x0103, B:43:0x00fe), top: B:69:0x002c, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.samsung.android.support.senl.nt.stt.base.filedata.M4aReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean makeUDTABox(M4aInfo m4aInfo) throws Throwable {
        Throwable th;
        Throwable th2;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.UDTA_ATOM_HEADER);
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(this.SMTA_ATOM_HEADER);
        File tempFile = getTempFile(this.mPath);
        try {
            ?? r10 = "r";
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.mPath, "r");
            try {
                try {
                    r10 = InternalZipConstants.WRITE_MODE;
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(tempFile, InternalZipConstants.WRITE_MODE);
                    try {
                        try {
                            FileChannel channel = randomAccessFile.getChannel();
                            try {
                                try {
                                    FileChannel channel2 = randomAccessFile2.getChannel();
                                    try {
                                        r10 = randomAccessFile;
                                        long moovPos = m4aInfo.getMoovPos() + ((long) m4aInfo.getFileMoovLength());
                                        try {
                                            channel.position(0L);
                                            long jTransferFrom = channel2.transferFrom(channel, 0L, moovPos);
                                            if (jTransferFrom < 0) {
                                                Logger.m12702e(TAG, "makeUDTABox: transfer from first of new udta position : " + jTransferFrom);
                                            }
                                            byteBufferWrap.putInt(20);
                                            byteBufferWrap.rewind();
                                            channel2.position(moovPos);
                                            channel2.write(byteBufferWrap);
                                            byteBufferWrap2.putInt(12);
                                            byteBufferWrap2.rewind();
                                            channel2.write(byteBufferWrap2);
                                            channel2.position(((long) 20) + moovPos);
                                            long jTransferFrom2 = channel2.transferFrom(channel, channel2.position(), channel.size() - moovPos);
                                            if (jTransferFrom2 < 0) {
                                                Logger.m12702e(TAG, "makeUDTABox: transfer from end of sttd to smta : " + jTransferFrom2);
                                            }
                                            int fileMoovLength = m4aInfo.getFileMoovLength() + 20;
                                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                                            byteBufferAllocate.putInt(fileMoovLength);
                                            byteBufferAllocate.rewind();
                                            channel2.position(m4aInfo.getMoovPos());
                                            channel2.write(byteBufferAllocate);
                                            byteBufferAllocate.rewind();
                                            m4aInfo.setFileMoovLength(fileMoovLength);
                                            m4aInfo.setFileUdtaLength(20);
                                            m4aInfo.setUdtaPos(moovPos);
                                            readChunkOffsets(channel2, m4aInfo);
                                            correctChunkOffsets(channel2, 20, m4aInfo);
                                            channel2.close();
                                            channel.close();
                                            randomAccessFile2.close();
                                            r10.close();
                                            return true;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            Throwable th4 = th;
                                            if (channel2 == null) {
                                                throw th4;
                                            }
                                            try {
                                                channel2.close();
                                                throw th4;
                                            } catch (Throwable th5) {
                                                th4.addSuppressed(th5);
                                                throw th4;
                                            }
                                            Throwable th6 = th;
                                            if (channel == null) {
                                                throw th6;
                                            }
                                            try {
                                                channel.close();
                                                throw th6;
                                            } catch (Throwable th7) {
                                                th6.addSuppressed(th7);
                                                throw th6;
                                            }
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        r10 = randomAccessFile;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    Throwable th62 = th;
                                    if (channel == null) {
                                    }
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                r10 = randomAccessFile;
                                Throwable th622 = th;
                                if (channel == null) {
                                }
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            th2 = th;
                            try {
                                randomAccessFile2.close();
                                throw th2;
                            } catch (Throwable th12) {
                                th2.addSuppressed(th12);
                                throw th2;
                            }
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        r10 = randomAccessFile;
                        th2 = th;
                        randomAccessFile2.close();
                        throw th2;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    th = th;
                    try {
                        r10.close();
                        throw th;
                    } catch (Throwable th15) {
                        th.addSuppressed(th15);
                        throw th;
                    }
                }
            } catch (Throwable th16) {
                th = th16;
                r10 = randomAccessFile;
                th = th;
                r10.close();
                throw th;
            }
        } catch (IOException e) {
            Logger.m12702e(TAG, "makeUDTABox: " + e.getMessage());
            return false;
        }
    }

    private void writeSMTAAtom(M4aInfo m4aInfo) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        Throwable th2;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.SMTA_ATOM_HEADER);
        int fileUdtaLength = m4aInfo.getFileUdtaLength();
        long udtaPos = m4aInfo.getUdtaPos();
        File tempFile = getTempFile(this.mPath);
        try {
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.mPath, "r");
            try {
                try {
                    RandomAccessFile randomAccessFile4 = new RandomAccessFile(tempFile, InternalZipConstants.WRITE_MODE);
                    try {
                        try {
                            FileChannel channel = randomAccessFile3.getChannel();
                            try {
                                FileChannel channel2 = randomAccessFile4.getChannel();
                                try {
                                    try {
                                        channel.position(0L);
                                        long j = udtaPos + ((long) fileUdtaLength);
                                        long jTransferFrom = channel2.transferFrom(channel, 0L, j);
                                        randomAccessFile2 = randomAccessFile4;
                                        randomAccessFile = randomAccessFile3;
                                        if (jTransferFrom < 0) {
                                            try {
                                                Logger.m12702e(TAG, "writeSMTAAtom: transfer from first of new udta position : " + jTransferFrom);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                Throwable th4 = th;
                                                if (channel2 == null) {
                                                    throw th4;
                                                }
                                                try {
                                                    channel2.close();
                                                    throw th4;
                                                } catch (Throwable th5) {
                                                    th4.addSuppressed(th5);
                                                    throw th4;
                                                }
                                            }
                                        }
                                        channel2.position(udtaPos);
                                        int i = fileUdtaLength + 12;
                                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                                        byteBufferAllocate.putInt(i);
                                        byteBufferAllocate.rewind();
                                        channel2.write(byteBufferAllocate);
                                        channel2.position(j);
                                        byteBufferWrap.putInt(12);
                                        byteBufferWrap.rewind();
                                        channel2.write(byteBufferWrap);
                                        channel2.position(udtaPos + ((long) i));
                                        channel.position(j);
                                        long jTransferFrom2 = channel2.transferFrom(channel, channel2.position(), channel.size() - j);
                                        if (jTransferFrom2 < 0) {
                                            Logger.m12702e(TAG, "writeSMTAAtom: transfer from end of sttd to smta : " + jTransferFrom2);
                                        }
                                        int fileMoovLength = m4aInfo.getFileMoovLength() + 12;
                                        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                                        byteBufferAllocate2.putInt(fileMoovLength);
                                        byteBufferAllocate2.rewind();
                                        channel2.position(m4aInfo.getMoovPos());
                                        channel2.write(byteBufferAllocate2);
                                        byteBufferAllocate2.rewind();
                                        m4aInfo.setFileMoovLength(fileMoovLength);
                                        m4aInfo.setFileUdtaLength(i);
                                        readChunkOffsets(channel2, m4aInfo);
                                        correctChunkOffsets(channel2, 12, m4aInfo);
                                        channel2.close();
                                        channel.close();
                                        randomAccessFile2.close();
                                        randomAccessFile.close();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        Throwable th7 = th;
                                        if (channel == null) {
                                            throw th7;
                                        }
                                        try {
                                            channel.close();
                                            throw th7;
                                        } catch (Throwable th8) {
                                            th7.addSuppressed(th8);
                                            throw th7;
                                        }
                                        th2 = th;
                                        try {
                                            randomAccessFile2.close();
                                            throw th2;
                                        } catch (Throwable th9) {
                                            th2.addSuppressed(th9);
                                            throw th2;
                                        }
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    randomAccessFile2 = randomAccessFile4;
                                    randomAccessFile = randomAccessFile3;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                randomAccessFile = randomAccessFile3;
                                randomAccessFile2 = randomAccessFile4;
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            th2 = th;
                            randomAccessFile2.close();
                            throw th2;
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        randomAccessFile = randomAccessFile3;
                        randomAccessFile2 = randomAccessFile4;
                        th2 = th;
                        randomAccessFile2.close();
                        throw th2;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    randomAccessFile = randomAccessFile3;
                    th = th;
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (Throwable th15) {
                        th.addSuppressed(th15);
                        throw th;
                    }
                }
            } catch (Throwable th16) {
                th = th16;
                th = th;
                randomAccessFile.close();
                throw th;
            }
        } catch (IOException e) {
            Logger.m12702e(TAG, "writeSMTAAtom: " + e.getMessage());
        }
    }

    public AtomProperties findOuterAtoms(String str) {
        int i;
        synchronized (M4aConsts.FILE_LOCK) {
            String strArrToAscii = "";
            AtomProperties atomProperties = new AtomProperties();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            while (!strArrToAscii.equals(str)) {
                try {
                    if (this.mChannel.read(this.mBuffer) < 0) {
                        return null;
                    }
                    this.mBuffer.rewind();
                    long j = this.mBuffer.getInt();
                    this.mBuffer.rewind();
                    if (this.mChannel.read(this.mBuffer) < 0) {
                        return null;
                    }
                    this.mBuffer.rewind();
                    strArrToAscii = arrToAscii(this.mBuffer.array());
                    if (!M4aConsts.MDAT.equals(strArrToAscii) || j != 1) {
                        i = 1;
                    } else {
                        if (this.mChannel.read(byteBufferAllocate) < 0) {
                            return null;
                        }
                        byteBufferAllocate.rewind();
                        j = byteBufferAllocate.getLong();
                        byteBufferAllocate.rewind();
                        if (strArrToAscii.equals(str)) {
                            atomProperties.setPosition(this.mChannel.position() - 8);
                            atomProperties.setLength((int) j);
                            this.mChannel.position(atomProperties.getPosition());
                            return atomProperties;
                        }
                        i = 2;
                    }
                    if (!strArrToAscii.equals(str)) {
                        long j2 = j - ((long) (i * 8));
                        if (j2 > 0 && this.mChannel.position() + j2 <= this.mChannel.size()) {
                            FileChannel fileChannel = this.mChannel;
                            fileChannel.position(fileChannel.position() + j2);
                        } else {
                            if (j2 != 0) {
                                Logger.m12704w(TAG, "Wrong skip value finding OuterAtom: " + str + " ! Returning from function");
                                return null;
                            }
                            Logger.m12704w(TAG, "skip value is 0 : " + str);
                        }
                    }
                } catch (IOException e) {
                    Logger.m12702e(TAG, "Error reading the file " + e.getMessage());
                    throw e;
                }
            }
            atomProperties.setPosition(this.mChannel.position() - 8);
            this.mBuffer.rewind();
            this.mChannel.position(atomProperties.getPosition());
            if (this.mChannel.read(this.mBuffer) < 0) {
                return null;
            }
            this.mBuffer.rewind();
            atomProperties.setLength(this.mBuffer.getInt());
            this.mBuffer.rewind();
            this.mChannel.position(atomProperties.getPosition() + 8);
            return atomProperties;
        }
    }

    public final String getPath() {
        return this.mPath;
    }

    public String getUpdatePath() {
        return this.mUpdatePath;
    }

    public void readChunkOffsets(M4aInfo m4aInfo) {
        readChunkOffsets(this.mChannel, m4aInfo);
    }

    public M4aInfo readFile() {
        FileInputStream fileInputStream;
        M4aInfo m4aInfo;
        AtomProperties atomPropertiesFindOuterAtoms;
        synchronized (M4aConsts.FILE_LOCK) {
            try {
                M4aInfo m4aInfo2 = null;
                if (!isM4A()) {
                    return null;
                }
                this.mBuffer = ByteBuffer.allocate(4);
                try {
                    fileInputStream = new FileInputStream(new File(this.mPath));
                    this.mChannel = fileInputStream.getChannel();
                    m4aInfo = new M4aInfo(this.mPath);
                    atomPropertiesFindOuterAtoms = findOuterAtoms(M4aConsts.MOOV);
                } catch (FileNotFoundException e) {
                    Logger.m12702e(TAG, "readFile: FileNotFoundException " + e.getMessage());
                } catch (IOException e2) {
                    Logger.m12702e(TAG, "readFile: IOException " + e2.getMessage());
                }
                if (atomPropertiesFindOuterAtoms == null) {
                    Logger.m12702e(TAG, "readFile# moov box null");
                    return null;
                }
                m4aInfo.setFileMoovLength(atomPropertiesFindOuterAtoms.getLength());
                m4aInfo.setMoovPos(atomPropertiesFindOuterAtoms.getPosition());
                AtomProperties atomPropertiesFindOuterAtoms2 = findOuterAtoms(M4aConsts.UDTA);
                if (atomPropertiesFindOuterAtoms2 == null) {
                    Logger.m12702e(TAG, "readFile# udat box null");
                    if (!makeUDTABox(m4aInfo)) {
                        Logger.m12702e(TAG, "readFile# can not make udat box");
                        return null;
                    }
                    Logger.m12702e(TAG, "readFile# make udat box success");
                    this.mChannel.close();
                    fileInputStream.close();
                    return m4aInfo;
                }
                readChunkOffsets(m4aInfo);
                m4aInfo.setFileUdtaLength(atomPropertiesFindOuterAtoms2.getLength());
                m4aInfo.setUdtaPos(atomPropertiesFindOuterAtoms2.getPosition());
                findCustomAtom(m4aInfo, M4aConsts.STTD, m4aInfo.getUdtaPos());
                findCustomAtom(m4aInfo, M4aConsts.SMDT, m4aInfo.getUdtaPos());
                findCustomAtom(m4aInfo, M4aConsts.SPDT, m4aInfo.getUdtaPos());
                findCustomAtom(m4aInfo, M4aConsts.SMTA, m4aInfo.getUdtaPos());
                findCustomAtom(m4aInfo, M4aConsts.PGDT, m4aInfo.getUdtaPos());
                if (!m4aInfo.hasAtom(M4aConsts.SMTA)) {
                    Logger.m12702e(TAG, "readFile# Cannot read SMTA box, make it");
                    writeSMTAAtom(m4aInfo);
                    return m4aInfo;
                }
                findCustomAtom(m4aInfo, M4aConsts.SAUT, m4aInfo.getAtomPosition(M4aConsts.SMTA) + 4);
                if (m4aInfo.hasAtom(M4aConsts.SAUT)) {
                    long jLongValue = m4aInfo.customAtomPosition.get(M4aConsts.SAUT).longValue() + 8;
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                    this.mChannel.position(jLongValue);
                    if (this.mChannel.read(byteBufferAllocate) >= 0) {
                        byteBufferAllocate.rewind();
                        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2);
                        while (true) {
                            if (this.mChannel.read(byteBufferAllocate2) < 0) {
                                Logger.m12702e(TAG, "countRead is under 0");
                                break;
                            }
                            byteBufferAllocate2.rewind();
                            byte[] bArrArray = byteBufferAllocate2.array();
                            if (bArrArray[0] == 0) {
                                m4aInfo.setRecordingMode(Byte.toUnsignedInt(bArrArray[1]));
                                this.mChannel.close();
                                fileInputStream.close();
                                break;
                            }
                            byteBufferAllocate2.rewind();
                        }
                    }
                } else {
                    this.mChannel.close();
                    fileInputStream.close();
                }
                m4aInfo2 = m4aInfo;
                return m4aInfo2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isM4A(String str) {
        return str != null && str.toLowerCase().endsWith(AudioFormat.ExtType.EXT_M4A);
    }

    public void readChunkOffsets(FileChannel fileChannel, M4aInfo m4aInfo) {
        try {
            this.mChannel = fileChannel;
            fileChannel.position(0L);
            AtomProperties atomPropertiesFindOuterAtoms = findOuterAtoms(M4aConsts.MDAT);
            if (atomPropertiesFindOuterAtoms != null) {
                m4aInfo.customAtomPosition.put(M4aConsts.MDAT, Long.valueOf(atomPropertiesFindOuterAtoms.getPosition()));
                m4aInfo.putAtom(M4aConsts.MDAT, atomPropertiesFindOuterAtoms.getLength(), atomPropertiesFindOuterAtoms.getPosition());
            }
            findCustomAtom(m4aInfo, "trak", m4aInfo.getMoovPos());
            if (m4aInfo.hasAtom("trak")) {
                findCustomAtom(m4aInfo, "mdia", m4aInfo.getAtomPosition("trak"));
            } else {
                Logger.m12702e(TAG, "readChunkOffset# not found trak box");
            }
            if (m4aInfo.hasAtom("mdia")) {
                findCustomAtom(m4aInfo, "minf", m4aInfo.getAtomPosition("mdia"));
            } else {
                Logger.m12702e(TAG, "readChunkOffset# not found mdia box");
            }
            if (m4aInfo.hasAtom("minf")) {
                findCustomAtom(m4aInfo, "stbl", m4aInfo.getAtomPosition("minf"));
            } else {
                Logger.m12702e(TAG, "readChunkOffset# not found minf box");
            }
            if (!m4aInfo.hasAtom("stbl")) {
                Logger.m12702e(TAG, "readChunkOffset# not found stbl box");
            } else {
                findCustomAtom(m4aInfo, "co64", m4aInfo.getAtomPosition("stbl"));
                findCustomAtom(m4aInfo, "st64", m4aInfo.getAtomPosition("stbl"));
            }
        } catch (Exception e) {
            Logger.m12702e(TAG, "readChunkOffset# " + e);
        }
    }
}
