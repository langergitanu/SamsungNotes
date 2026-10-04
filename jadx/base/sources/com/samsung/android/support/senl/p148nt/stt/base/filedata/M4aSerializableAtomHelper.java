package com.samsung.android.support.senl.p148nt.stt.base.filedata;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.sec.android.app.voicenote.common.util.TextData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class M4aSerializableAtomHelper {
    private static final String TAG = "M4aSerializableAtom";
    protected M4aInfo mInfo;
    protected String mJsonString;
    private M4aReader mM4aReader;
    private String mUpdatePath;
    private int[] mVoiceSpeakerIDs;
    private long[] mVoiceTextEndTimes;
    private int[] mVoiceTextLengths;
    private long[] mVoiceTextStartTimes;
    private String[] mVoiceTexts;
    private int mNewAtomLength = 0;
    private int mOldAtomLength = 0;
    private int mNewSttdAtomLength = 0;
    private int mOldSttdAtomLength = 0;
    private int mNewSmtaAtomLength = 0;
    private int mOldSmtaAtomLength = 0;
    private final byte[] mSTTDLengthHeaderBytes = {0, 0, 0, 0, 115, 116, 116, 100};
    private int SAMSUNG_NOTE_RECORDER_MODE_NORMAL = 200;
    private int SAMSUNG_NOTE_RECORDER_MODE_STT_DATA = 201;
    private final byte[] mSautDataBytesNormal = {0, 0, 0, 14, 115, SprAttributeBase.TYPE_ANIMATOR_SET, 117, 116, 0, 0, 0, 1, 0, (byte) 200};
    private final byte[] mSautDataBytesWithSTT = {0, 0, 0, 14, 115, SprAttributeBase.TYPE_ANIMATOR_SET, 117, 116, 0, 0, 0, 1, 0, (byte) 201};
    private ArrayList<TextData> mTextDataList = new ArrayList<>();
    protected boolean isExtracted = false;
    private boolean isExtractedSTTData = false;

    public M4aSerializableAtomHelper(String str) {
        M4aReader m4aReader = new M4aReader(str);
        this.mM4aReader = m4aReader;
        this.mInfo = m4aReader.readFile();
        this.mUpdatePath = this.mM4aReader.getUpdatePath();
    }

    private void correctChunkOffsets(FileChannel fileChannel, int i) {
        try {
            if (this.mInfo.getMoovPos() < this.mInfo.getAtomPosition(M4aConsts.MDAT)) {
                Logger.m12701d(TAG, "correctChunkOffsets# moovPos < mdat pos: " + this.mInfo.getMoovPos() + " < " + this.mInfo.getAtomPosition(M4aConsts.MDAT));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                if (!this.mInfo.hasAtom("co64")) {
                    if (this.mInfo.hasAtom("st64")) {
                        Logger.m12701d(TAG, "correctChunkOffsets# found st64 box");
                    }
                    if (this.mInfo.hasAtom("stco")) {
                        Logger.m12701d(TAG, "correctChunkOffsets# found stco box");
                    }
                    Logger.m12702e(TAG, "correctChunkOffsets# not found co64 box");
                    return;
                }
                Logger.m12701d(TAG, "correctChunkOffsets# co64 box# pos: " + this.mInfo.getAtomPosition("co64") + " # length: " + this.mInfo.getAtomLength("co64"));
                fileChannel.position(this.mInfo.getAtomPosition("co64") + 12);
                byteBufferAllocate.rewind();
                if (fileChannel.read(byteBufferAllocate) < 0) {
                    Logger.m12702e(TAG, "correctChunkOffsets# co64 box not have any offsets");
                    return;
                }
                byteBufferAllocate.rewind();
                int i2 = byteBufferAllocate.getInt();
                Logger.m12701d(TAG, "correctChunkOffsets# co64 box offsets #total chunk: " + i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    long atomPosition = this.mInfo.getAtomPosition("co64") + 16 + ((long) (i4 * 8));
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

    private void extractSTTData() {
        ArrayList<TextData> sTTData = readSTTData();
        this.mTextDataList = sTTData;
        if (sTTData == null) {
            return;
        }
        int size = sTTData.size();
        this.mVoiceTexts = new String[size];
        this.mVoiceTextLengths = new int[size];
        this.mVoiceTextStartTimes = new long[size];
        this.mVoiceTextEndTimes = new long[size];
        this.mVoiceSpeakerIDs = new int[size];
        for (int i = 0; i < size; i++) {
            TextData textData = this.mTextDataList.get(i);
            String[] strArr = this.mVoiceTexts;
            String str = textData.mText[0];
            strArr[i] = str;
            this.mVoiceTextLengths[i] = str.length();
            long j = textData.timeStamp;
            long j2 = textData.duration + j;
            this.mVoiceTextStartTimes[i] = j;
            this.mVoiceTextEndTimes[i] = j2;
            this.mVoiceSpeakerIDs[i] = textData.speakerId;
        }
        this.isExtractedSTTData = true;
    }

    private ArrayList<TextData> readSTTData() {
        M4aInfo m4aInfo = this.mInfo;
        if (m4aInfo == null || !m4aInfo.hasAtom(M4aConsts.STTD)) {
            return null;
        }
        return (ArrayList) readAtom(this.mInfo.getAtomPosition(M4aConsts.STTD));
    }

    private void updateOuterAtomsLengths(FileChannel fileChannel) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        int fileUdtaLength = (((this.mInfo.getFileUdtaLength() - this.mOldSttdAtomLength) - this.mOldAtomLength) - this.mOldSmtaAtomLength) + this.mNewSttdAtomLength + this.mNewAtomLength + this.mNewSmtaAtomLength;
        int fileMoovLength = (this.mInfo.getFileMoovLength() - this.mInfo.getFileUdtaLength()) + fileUdtaLength;
        int fileMoovLength2 = fileMoovLength - this.mInfo.getFileMoovLength();
        Logger.m12701d(TAG, "updateOuterAtomsLengths: mAtomSizeChanged: " + fileMoovLength2);
        this.mInfo.setFileUdtaLength(fileUdtaLength);
        this.mInfo.setFileMoovLength(fileMoovLength);
        try {
            byteBufferAllocate.putInt(fileUdtaLength);
            byteBufferAllocate.rewind();
            fileChannel.position(this.mInfo.getUdtaPos());
            fileChannel.write(byteBufferAllocate);
            byteBufferAllocate.rewind();
            byteBufferAllocate.putInt(fileMoovLength);
            byteBufferAllocate.rewind();
            fileChannel.position(this.mInfo.getMoovPos());
            fileChannel.write(byteBufferAllocate);
            byteBufferAllocate.rewind();
        } catch (IOException e) {
            Logger.m12702e(TAG, "updateOuterAtomsLengths: " + e.getMessage());
        }
        this.mM4aReader.readChunkOffsets(fileChannel, this.mInfo);
        correctChunkOffsets(fileChannel, fileMoovLength2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[Catch: all -> 0x027e, SYNTHETIC, TRY_LEAVE, TryCatch #21 {all -> 0x027e, blocks: (B:94:0x0262, B:117:0x02a0, B:116:0x029d, B:113:0x0298), top: B:144:0x00ee, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[Catch: all -> 0x027b, SYNTHETIC, TRY_LEAVE, TryCatch #17 {all -> 0x027b, blocks: (B:95:0x0265, B:125:0x02b2, B:124:0x02af, B:121:0x02aa), top: B:163:0x00ea, inners: #8 }] */
    /* JADX WARN: Type inference failed for: r0v15, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.nio.channels.FileChannel, java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r16v26 */
    /* JADX WARN: Type inference failed for: r16v27 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r17v14 */
    /* JADX WARN: Type inference failed for: r17v15, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r27v1, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v4, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r28v0, types: [java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v3, types: [java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.samsung.android.support.senl.nt.stt.base.filedata.M4aSerializableAtomHelper] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel, java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean writeSTTDataAndAuth(ArrayList<TextData> arrayList, String str) throws Throwable {
        ByteBuffer byteBuffer;
        ?? r16;
        Throwable th;
        ?? r17;
        Throwable th2;
        ?? r13;
        String str2;
        ?? r28;
        ?? r27;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.mSTTDLengthHeaderBytes);
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(this.mSautDataBytesWithSTT);
        if (!this.mInfo.hasAtom(M4aConsts.SMTA)) {
            Logger.m12702e(TAG, "writeSTTDataAndAuth: cannot parse m4a smta data");
            return false;
        }
        long atomPosition = this.mInfo.hasAtom(M4aConsts.STTD) ? this.mInfo.getAtomPosition(M4aConsts.STTD) : this.mInfo.getUdtaPos() + 8;
        long atomPosition2 = this.mInfo.getAtomPosition(M4aConsts.SMTA);
        this.mOldSmtaAtomLength = this.mInfo.getAtomLength(M4aConsts.SMTA);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byte[] byteArray = null;
        byteArray = null;
        byteArray = null;
        byteArray = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            byteBuffer = byteBufferWrap2;
        } catch (IOException e) {
            e = e;
            byteBuffer = byteBufferWrap2;
        }
        try {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(arrayList);
                    byteArray = byteArrayOutputStream.toByteArray();
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    r16 = byteArray;
                } catch (Throwable th3) {
                    r17 = byteArrayOutputStream;
                    try {
                        try {
                            objectOutputStream.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        Throwable th6 = th;
                        try {
                            r17.close();
                            throw th6;
                        } catch (Throwable th7) {
                            th6.addSuppressed(th7);
                            throw th6;
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                r17 = byteArrayOutputStream;
            }
        } catch (IOException e2) {
            e = e2;
            Logger.m12702e(TAG, "writeSTTDataAndAuth: cannot read serializable " + e.getMessage());
            r16 = byteArray;
        }
        ?? r02 = r16;
        if (r02 == 0) {
            Logger.m12702e(TAG, "writeSTTDataAndAuth: sttdBytes is null");
            return false;
        }
        this.mNewSttdAtomLength = r02.length + 8;
        File file = new File(str);
        ByteBuffer byteBufferWrap3 = ByteBuffer.wrap(r02);
        try {
            ?? randomAccessFile = new RandomAccessFile(this.mInfo.getPath(), "r");
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                    try {
                        try {
                            FileChannel channel = randomAccessFile.getChannel();
                            try {
                                try {
                                    FileChannel channel2 = randomAccessFile2.getChannel();
                                    try {
                                        this.mOldSttdAtomLength = this.mInfo.getAtomLength(M4aConsts.STTD);
                                        this.mOldSmtaAtomLength = this.mInfo.getAtomLength(M4aConsts.SMTA);
                                        channel.position(0L);
                                        try {
                                            long jTransferFrom = channel2.transferFrom(channel, 0L, atomPosition);
                                            r13 = channel2;
                                            r16 = randomAccessFile;
                                            randomAccessFile = channel;
                                            r17 = randomAccessFile2;
                                            if (jTransferFrom < 0) {
                                                str2 = "writeSTTDataAndAuth: transfer Smta size, Header, ReservedData size : ";
                                                try {
                                                    Logger.m12702e(TAG, "writeSTTDataAndAuth: transfer from start to sttd: " + jTransferFrom);
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    Throwable th10 = th;
                                                    if (r13 != 0) {
                                                        throw th10;
                                                    }
                                                    try {
                                                        r13.close();
                                                        throw th10;
                                                    } catch (Throwable th11) {
                                                        th10.addSuppressed(th11);
                                                        throw th10;
                                                    }
                                                }
                                            } else {
                                                str2 = "writeSTTDataAndAuth: transfer Smta size, Header, ReservedData size : ";
                                            }
                                            byteBufferWrap.rewind();
                                            byteBufferWrap.putInt(this.mNewSttdAtomLength);
                                            byteBufferWrap.rewind();
                                            r13.position(atomPosition);
                                            r13.write(byteBufferWrap);
                                            byteBufferWrap.rewind();
                                            r13.write(byteBufferWrap3);
                                            randomAccessFile.position(atomPosition + ((long) this.mOldSttdAtomLength));
                                            r28 = randomAccessFile;
                                            r27 = r13;
                                        } catch (Throwable th12) {
                                            th = th12;
                                            r13 = channel2;
                                            r16 = randomAccessFile;
                                            randomAccessFile = channel;
                                            r17 = randomAccessFile2;
                                        }
                                    } catch (Throwable th13) {
                                        th = th13;
                                        r17 = randomAccessFile2;
                                        r16 = randomAccessFile;
                                        r13 = channel2;
                                        randomAccessFile = channel;
                                    }
                                    try {
                                        long jTransferFrom2 = r27.transferFrom(r28, r13.position(), atomPosition2 - randomAccessFile.position());
                                        if (jTransferFrom2 < 0) {
                                            Logger.m12702e(TAG, "writeSTTDataAndAuth: transfer from end of sttd to smta : " + jTransferFrom2);
                                        }
                                        randomAccessFile.position(atomPosition2);
                                        r13.position(r13.size());
                                        if (this.mInfo.hasAtom(M4aConsts.SAUT) && this.mInfo.getAtomLength(M4aConsts.SAUT) == this.mSautDataBytesWithSTT.length) {
                                            this.mNewSmtaAtomLength = this.mOldSmtaAtomLength;
                                            long atomPosition3 = this.mInfo.getAtomPosition(M4aConsts.SAUT);
                                            long jTransferFrom3 = r13.transferFrom(randomAccessFile, r13.position(), atomPosition3 - randomAccessFile.position());
                                            if (jTransferFrom3 < 0) {
                                                Logger.m12702e(TAG, str2 + jTransferFrom3);
                                            }
                                            randomAccessFile.position(atomPosition3 + ((long) this.mSautDataBytesWithSTT.length));
                                        } else {
                                            this.mNewSmtaAtomLength = this.mOldSmtaAtomLength + this.mSautDataBytesWithSTT.length;
                                            byteBufferAllocate.rewind();
                                            byteBufferAllocate.putInt(this.mNewSmtaAtomLength);
                                            byteBufferAllocate.rewind();
                                            r13.write(byteBufferAllocate);
                                            byteBufferAllocate.rewind();
                                            randomAccessFile.position(4 + atomPosition2);
                                            long jTransferFrom4 = r13.transferFrom(randomAccessFile, r13.position(), 8L);
                                            if (jTransferFrom4 < 0) {
                                                Logger.m12702e(TAG, "writeSTTDataAndAuth: transfer Smta Header,ReservedData size : " + jTransferFrom4);
                                            }
                                            randomAccessFile.position(atomPosition2 + 12);
                                        }
                                        byteBuffer.rewind();
                                        r13.position(r13.size());
                                        r13.write(byteBuffer);
                                        r28 = randomAccessFile;
                                        r27 = r13;
                                        long jTransferFrom5 = r27.transferFrom(r28, r13.position(), randomAccessFile.size() - randomAccessFile.position());
                                        if (jTransferFrom5 < 0) {
                                            Logger.m12702e(TAG, "writeSTTDataAndAuth: transfer remaining bytes: " + jTransferFrom5);
                                        }
                                        updateOuterAtomsLengths(r13);
                                        r13.close();
                                        randomAccessFile.close();
                                        r17.close();
                                        r16.close();
                                        Logger.m12703i(TAG, "writeSTTDataAndAuth: end");
                                        return true;
                                    } catch (Throwable th14) {
                                        th = th14;
                                        r13 = r27;
                                        randomAccessFile = r28;
                                        Throwable th102 = th;
                                        if (r13 != 0) {
                                        }
                                    }
                                } catch (Throwable th15) {
                                    th = th15;
                                    r17 = randomAccessFile2;
                                    r16 = randomAccessFile;
                                    randomAccessFile = channel;
                                    Throwable th16 = th;
                                    if (randomAccessFile != 0) {
                                        throw th16;
                                    }
                                    try {
                                        randomAccessFile.close();
                                        throw th16;
                                    } catch (Throwable th17) {
                                        th16.addSuppressed(th17);
                                        throw th16;
                                    }
                                }
                            } catch (Throwable th18) {
                                th = th18;
                                Throwable th162 = th;
                                if (randomAccessFile != 0) {
                                }
                            }
                        } catch (Throwable th19) {
                            th = th19;
                            r17 = randomAccessFile2;
                            r16 = randomAccessFile;
                            th2 = th;
                            try {
                                r17.close();
                                throw th2;
                            } catch (Throwable th20) {
                                th2.addSuppressed(th20);
                                throw th2;
                            }
                        }
                    } catch (Throwable th21) {
                        th = th21;
                        th2 = th;
                        r17.close();
                        throw th2;
                    }
                } catch (Throwable th22) {
                    th = th22;
                    r16 = randomAccessFile;
                    th = th;
                    try {
                        r16.close();
                        throw th;
                    } catch (Throwable th23) {
                        th.addSuppressed(th23);
                        throw th;
                    }
                }
            } catch (Throwable th24) {
                th = th24;
                th = th;
                r16.close();
                throw th;
            }
        } catch (IOException e3) {
            Logger.m12702e(TAG, "writeSTTDataAndAuth: Error writing atom to file " + e3.getMessage());
            return false;
        }
    }

    public String getUpdatePath() {
        return this.mUpdatePath;
    }

    public int[] getVoiceSpeakerIDs() {
        if (!this.isExtractedSTTData) {
            extractSTTData();
        }
        return this.mVoiceSpeakerIDs;
    }

    public long[] getVoiceTextEndTimes() {
        if (!this.isExtractedSTTData) {
            extractSTTData();
        }
        return this.mVoiceTextEndTimes;
    }

    public int[] getVoiceTextLengths() {
        if (!this.isExtractedSTTData) {
            extractSTTData();
        }
        return this.mVoiceTextLengths;
    }

    public long[] getVoiceTextStartTimes() {
        if (!this.isExtractedSTTData) {
            extractSTTData();
        }
        return this.mVoiceTextStartTimes;
    }

    public String[] getVoiceTexts() {
        if (!this.isExtractedSTTData) {
            extractSTTData();
        }
        return this.mVoiceTexts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[Catch: all -> 0x0140, SYNTHETIC, TRY_LEAVE, TryCatch #0 {all -> 0x0140, blocks: (B:60:0x012a, B:83:0x0158, B:82:0x0155, B:79:0x0150), top: B:106:0x0094, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[Catch: all -> 0x013d, SYNTHETIC, TRY_LEAVE, TryCatch #18 {all -> 0x013d, blocks: (B:61:0x012d, B:91:0x0168, B:90:0x0165, B:87:0x0160), top: B:136:0x0094, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r16v10, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.samsung.android.support.senl.nt.stt.base.filedata.M4aSerializableAtomHelper] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean makeFile(Serializable serializable, long j, ByteBuffer byteBuffer, String str, String str2) {
        ?? r16;
        FileChannel channel;
        ?? r4;
        FileChannel channel2;
        FileChannel fileChannel;
        ?? r162;
        ?? r163;
        ByteArrayOutputStream byteArrayOutputStream;
        if (this.mInfo == null) {
            Logger.m12702e(TAG, "write info is null !!!");
            return false;
        }
        byte[] byteArray = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException e) {
            e = e;
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(serializable);
                byteArray = byteArrayOutputStream.toByteArray();
                objectOutputStream.close();
                byteArrayOutputStream.close();
                if (byteArray != null) {
                    Logger.m12702e(TAG, "makeFile: dataBytes is null");
                    return false;
                }
                this.mNewAtomLength = byteArray.length + 8;
                File file = new File(str);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArray);
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.mInfo.getPath(), "r");
                    try {
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                        try {
                            channel = randomAccessFile.getChannel();
                            r4 = randomAccessFile2;
                        } catch (Throwable th) {
                            th = th;
                            r16 = randomAccessFile2;
                        }
                        try {
                            try {
                                try {
                                    channel2 = r4.getChannel();
                                    try {
                                        this.mOldAtomLength = this.mInfo.getAtomLength(str2);
                                        channel.position(0L);
                                        r163 = r4;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileChannel = channel2;
                                        r162 = r4;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    Throwable th4 = th;
                                    if (r4 != 0) {
                                        throw th4;
                                    }
                                    try {
                                        r4.close();
                                        throw th4;
                                    } catch (Throwable th5) {
                                        th4.addSuppressed(th5);
                                        throw th4;
                                    }
                                }
                                try {
                                    long jTransferFrom = channel2.transferFrom(channel, 0L, j);
                                    if (jTransferFrom < 0) {
                                        Logger.m12702e(TAG, "makeFile: transfer from start to " + str2 + ": " + jTransferFrom);
                                    }
                                    byteBuffer.rewind();
                                    byteBuffer.putInt(this.mNewAtomLength);
                                    byteBuffer.rewind();
                                    channel2.position(j);
                                    channel2.write(byteBuffer);
                                    byteBuffer.rewind();
                                    channel2.write(byteBufferWrap);
                                    channel.position(((long) this.mOldAtomLength) + j);
                                    try {
                                        long jTransferFrom2 = channel2.transferFrom(channel, channel2.position(), channel.size() - channel.position());
                                        fileChannel = channel2;
                                        FileChannel fileChannel2 = channel;
                                        if (jTransferFrom2 < 0) {
                                            try {
                                                Logger.m12702e(TAG, "writeSTTDataAndAuth: transfer remaining bytes: " + jTransferFrom2);
                                            } catch (Throwable th6) {
                                                th = th6;
                                                r4 = fileChannel2;
                                                r16 = r163;
                                                Throwable th7 = th;
                                                if (fileChannel != null) {
                                                    throw th7;
                                                }
                                                try {
                                                    fileChannel.close();
                                                    throw th7;
                                                } catch (Throwable th8) {
                                                    th7.addSuppressed(th8);
                                                    throw th7;
                                                }
                                                Throwable th42 = th;
                                                if (r4 != 0) {
                                                }
                                            }
                                        }
                                        updateOuterAtomsLengths(fileChannel);
                                        fileChannel.close();
                                        fileChannel2.close();
                                        r163.close();
                                        randomAccessFile.close();
                                        return true;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        fileChannel = channel2;
                                        r4 = channel;
                                        r16 = r163;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    fileChannel = channel2;
                                    r162 = r163;
                                    r4 = channel;
                                    r16 = r162;
                                    Throwable th72 = th;
                                    if (fileChannel != null) {
                                    }
                                    Throwable th422 = th;
                                    if (r4 != 0) {
                                    }
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                r16 = r4;
                                r4 = channel;
                                Throwable th4222 = th;
                                if (r4 != 0) {
                                }
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            Throwable th13 = th;
                            try {
                                r16.close();
                                throw th13;
                            } catch (Throwable th14) {
                                th13.addSuppressed(th14);
                                throw th13;
                            }
                        }
                    } finally {
                    }
                } catch (IOException e2) {
                    Logger.m12702e(TAG, "makeFile: Error writing atom to file " + e2.getMessage());
                    return false;
                }
            } finally {
            }
        } catch (Throwable th15) {
            byte[] bArr = byteArray;
            try {
                try {
                    byteArrayOutputStream.close();
                    throw th15;
                } catch (Throwable th16) {
                    th15.addSuppressed(th16);
                    throw th15;
                }
            } catch (IOException e3) {
                e = e3;
                byteArray = bArr;
                Logger.m12702e(TAG, "makeFile: cannot read serializable " + e.getMessage());
                if (byteArray != null) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[Catch: all -> 0x016a, SYNTHETIC, TRY_LEAVE, TryCatch #6 {all -> 0x016a, blocks: (B:39:0x0154, B:69:0x0195, B:68:0x0192, B:65:0x018d), top: B:98:0x0042, inners: #10 }] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.samsung.android.support.senl.nt.stt.base.filedata.M4aSerializableAtomHelper] */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean makeFileForVoiceRecordingApp(String str) throws Throwable {
        String str2;
        Throwable th;
        Throwable th2;
        FileChannel channel;
        M4aInfo m4aInfo = this.mInfo;
        if (m4aInfo == null) {
            Logger.m12702e(TAG, "write info is null !!!");
            return false;
        }
        if (!m4aInfo.hasAtom(M4aConsts.SMTA)) {
            Logger.m12702e(TAG, "writeSTTDataAndAuth: cannot parse m4a smta data");
            return false;
        }
        File file = new File((String) str);
        try {
            try {
                str2 = "r";
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.mInfo.getPath(), "r");
                try {
                    try {
                        str2 = InternalZipConstants.WRITE_MODE;
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                        try {
                            try {
                                channel = randomAccessFile.getChannel();
                            } catch (Throwable th3) {
                                th = th3;
                                th2 = th;
                                try {
                                    randomAccessFile2.close();
                                    throw th2;
                                } catch (Throwable th4) {
                                    th2.addSuppressed(th4);
                                    throw th2;
                                }
                            }
                            try {
                                try {
                                    FileChannel channel2 = randomAccessFile2.getChannel();
                                    try {
                                        this.mOldSmtaAtomLength = this.mInfo.getAtomLength(M4aConsts.SMTA);
                                        str2 = TAG;
                                        try {
                                            channel.position(0L);
                                            str = 0;
                                            try {
                                                long atomPosition = this.mInfo.getAtomPosition(M4aConsts.SMTA);
                                                long jTransferFrom = channel2.transferFrom(channel, channel2.position(), atomPosition - channel.position());
                                                if (jTransferFrom < 0) {
                                                    Logger.m12702e(str2, "writeSTTDataAndAuth: transfer from end of sttd to smta : " + jTransferFrom);
                                                }
                                                channel.position(atomPosition);
                                                channel2.position(channel2.size());
                                                if (this.mInfo.hasAtom(M4aConsts.SAUT)) {
                                                    this.mNewSmtaAtomLength = this.mOldSmtaAtomLength;
                                                    long atomPosition2 = this.mInfo.getAtomPosition(M4aConsts.SAUT);
                                                    long jTransferFrom2 = channel2.transferFrom(channel, channel2.position(), atomPosition2 - channel.position());
                                                    if (jTransferFrom2 < 0) {
                                                        Logger.m12702e(str2, "writeSTTDataAndAuth: transfer Smta size, Header, ReservedData size : " + jTransferFrom2);
                                                    }
                                                    channel.position(atomPosition2 + ((long) this.mSautDataBytesNormal.length));
                                                } else {
                                                    this.mNewSmtaAtomLength = this.mOldSmtaAtomLength + this.mSautDataBytesNormal.length;
                                                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                                                    byteBufferAllocate.rewind();
                                                    byteBufferAllocate.putInt(this.mNewSmtaAtomLength);
                                                    byteBufferAllocate.rewind();
                                                    channel2.write(byteBufferAllocate);
                                                    byteBufferAllocate.rewind();
                                                    channel.position(4 + atomPosition);
                                                    long jTransferFrom3 = channel2.transferFrom(channel, channel2.position(), 8L);
                                                    if (jTransferFrom3 < 0) {
                                                        Logger.m12702e(str2, "writeSTTDataAndAuth: transfer Smta Header,ReservedData size : " + jTransferFrom3);
                                                    }
                                                    channel.position(atomPosition + 12);
                                                }
                                                ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.mSautDataBytesNormal);
                                                byteBufferWrap.rewind();
                                                channel2.position(channel2.size());
                                                channel2.write(byteBufferWrap);
                                                long jTransferFrom4 = channel2.transferFrom(channel, channel2.position(), channel.size() - channel.position());
                                                if (jTransferFrom4 < 0) {
                                                    Logger.m12702e(str2, "writeSTTDataAndAuth: transfer remaining bytes: " + jTransferFrom4);
                                                }
                                                updateOuterAtomsLengths(channel2);
                                                channel2.close();
                                                channel.close();
                                                randomAccessFile2.close();
                                                randomAccessFile.close();
                                                Logger.m12703i(str2, "writeSTTDataAndAuth: end");
                                                return true;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                Throwable th6 = th;
                                                if (channel2 == null) {
                                                    throw th6;
                                                }
                                                try {
                                                    channel2.close();
                                                    throw th6;
                                                } catch (Throwable th7) {
                                                    th6.addSuppressed(th7);
                                                    throw th6;
                                                }
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            str = 0;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        str = 0;
                                        str2 = TAG;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    str = 0;
                                    str2 = TAG;
                                    Throwable th11 = th;
                                    if (channel != null) {
                                        throw th11;
                                    }
                                    try {
                                        channel.close();
                                        throw th11;
                                    } catch (Throwable th12) {
                                        th11.addSuppressed(th12);
                                        throw th11;
                                    }
                                    th2 = th;
                                    randomAccessFile2.close();
                                    throw th2;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                Throwable th112 = th;
                                if (channel != null) {
                                }
                                th2 = th;
                                randomAccessFile2.close();
                                throw th2;
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            str = 0;
                            str2 = TAG;
                            th2 = th;
                            randomAccessFile2.close();
                            throw th2;
                        }
                    } catch (Throwable th15) {
                        th = th15;
                        str = 0;
                        str2 = TAG;
                        th = th;
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (Throwable th16) {
                            th.addSuppressed(th16);
                            throw th;
                        }
                    }
                } catch (Throwable th17) {
                    th = th17;
                    th = th;
                    randomAccessFile.close();
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                str = 0;
                str2 = TAG;
                Logger.m12702e(str2, "writeSTTDataAndAuth: Error writing atom to file " + e.getMessage());
                return str;
            }
        } catch (IOException e2) {
            e = e2;
            Logger.m12702e(str2, "writeSTTDataAndAuth: Error writing atom to file " + e.getMessage());
            return str;
        }
    }

    public boolean makeFileWithSTTData(ArrayList<TextData> arrayList, String str) {
        if (this.mInfo != null) {
            return writeSTTDataAndAuth(arrayList, str);
        }
        Logger.m12702e(TAG, "write info is null !!!");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Serializable] */
    public Serializable readAtom(long j) {
        Object obj;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.mInfo.getPath(), "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                    channel.position(j);
                    if (channel.read(byteBufferAllocate) < 0) {
                        Logger.m12702e(TAG, "readAtom: countRead is under 0");
                    } else {
                        byteBufferAllocate.rewind();
                        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(byteBufferAllocate.getInt() - 8);
                        channel.position(j + 8);
                        if (channel.read(byteBufferAllocate2) >= 0) {
                            byteBufferAllocate2.rewind();
                            try {
                                try {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBufferAllocate2.array());
                                    try {
                                        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                        try {
                                            Serializable serializable = (Serializable) objectInputStream.readObject();
                                            try {
                                                objectInputStream.close();
                                                byteArrayInputStream.close();
                                                obj = serializable;
                                            } catch (Throwable th) {
                                                th = th;
                                                try {
                                                    byteArrayInputStream.close();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                                throw th;
                                            }
                                        } finally {
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (ClassNotFoundException e) {
                                    e = e;
                                    Logger.m12702e(TAG, e.toString());
                                    obj = byteBufferAllocate2;
                                    channel.close();
                                    randomAccessFile.close();
                                    return obj;
                                }
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                                byteBufferAllocate2 = null;
                                Logger.m12702e(TAG, e.toString());
                                obj = byteBufferAllocate2;
                                channel.close();
                                randomAccessFile.close();
                                return obj;
                            }
                            channel.close();
                            randomAccessFile.close();
                            return obj;
                        }
                        Logger.m12702e(TAG, "readAtom: read2() countRead is under 0");
                    }
                    channel.close();
                    randomAccessFile.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (IOException e3) {
            Logger.m12702e(TAG, "readAtom: Error reading data from file " + e3.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[Catch: all -> 0x0139, SYNTHETIC, TRY_LEAVE, TryCatch #13 {all -> 0x0139, blocks: (B:50:0x0124, B:72:0x014e, B:71:0x014b, B:68:0x0146), top: B:118:0x005a, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean removeAtom(String str, String str2, boolean z) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileChannel channel;
        FileChannel channel2;
        Throwable th2;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        M4aInfo m4aInfo = this.mInfo;
        if (m4aInfo == null) {
            Logger.m12702e(TAG, "write info is null !!!");
            return false;
        }
        if (!m4aInfo.hasAtom(str2)) {
            return true;
        }
        long atomPosition = this.mInfo.getAtomPosition(str2);
        this.mOldAtomLength = this.mInfo.getAtomLength(str2);
        File file = new File(str);
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.mInfo.getPath(), "r");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                try {
                    try {
                        channel = randomAccessFile2.getChannel();
                        try {
                            randomAccessFile = randomAccessFile3;
                            channel2 = randomAccessFile3.getChannel();
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile = randomAccessFile3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (Throwable th5) {
                            th.addSuppressed(th5);
                            throw th;
                        }
                    }
                    try {
                        try {
                            long jTransferFrom = channel2.transferFrom(channel, 0L, atomPosition);
                            if (jTransferFrom < 0) {
                                try {
                                    Logger.m12702e(TAG, "removeAtom: transfer from start to atom position transferSize: " + jTransferFrom);
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    channel = channel;
                                    if (channel2 == null) {
                                    }
                                }
                            }
                            channel.position(atomPosition + ((long) this.mOldAtomLength));
                            channel2.position(channel2.size());
                            if (this.mInfo.hasAtom(M4aConsts.SAUT) && z) {
                                try {
                                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.mSautDataBytesNormal);
                                    long atomPosition2 = this.mInfo.getAtomPosition(M4aConsts.SAUT);
                                    long jPosition = channel2.position();
                                    long jPosition2 = atomPosition2 - channel.position();
                                    channel = channel;
                                    try {
                                        long jTransferFrom2 = channel2.transferFrom(channel, jPosition, jPosition2);
                                        fileChannel = channel2;
                                        fileChannel2 = channel;
                                        if (jTransferFrom2 < 0) {
                                            try {
                                                Logger.m12702e(TAG, "removeAtom: transfer SAUT atom transferSize: " + jTransferFrom2);
                                            } catch (Throwable th7) {
                                                th = th7;
                                                channel = fileChannel2;
                                                channel2 = fileChannel;
                                                th2 = th;
                                                if (channel2 == null) {
                                                }
                                            }
                                        }
                                        fileChannel2.position(atomPosition2 + ((long) this.mSautDataBytesNormal.length));
                                        byteBufferWrap.rewind();
                                        fileChannel.position(fileChannel.size());
                                        fileChannel.write(byteBufferWrap);
                                    } catch (Throwable th8) {
                                        th = th8;
                                        fileChannel = channel2;
                                        channel2 = fileChannel;
                                        th2 = th;
                                        if (channel2 == null) {
                                            throw th2;
                                        }
                                        try {
                                            channel2.close();
                                            throw th2;
                                        } catch (Throwable th9) {
                                            th2.addSuppressed(th9);
                                            throw th2;
                                        }
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    channel = channel;
                                    th2 = th;
                                    if (channel2 == null) {
                                    }
                                }
                            } else {
                                fileChannel = channel2;
                                fileChannel2 = channel;
                            }
                            channel = fileChannel2;
                            FileChannel fileChannel3 = fileChannel;
                            try {
                                long jTransferFrom3 = fileChannel3.transferFrom(channel, fileChannel.position(), fileChannel2.size() - fileChannel2.position());
                                channel2 = fileChannel3;
                                if (jTransferFrom3 < 0) {
                                    try {
                                        Logger.m12702e(TAG, "removeAtom: transfer to end position transferSize: " + jTransferFrom3);
                                    } catch (Throwable th11) {
                                        th = th11;
                                        th2 = th;
                                        if (channel2 == null) {
                                        }
                                    }
                                }
                                updateOuterAtomsLengths(channel2);
                                channel2.close();
                                channel.close();
                                randomAccessFile.close();
                                randomAccessFile2.close();
                                return true;
                            } catch (Throwable th12) {
                                th = th12;
                                channel2 = fileChannel3;
                            }
                        } catch (Throwable th13) {
                            th = th13;
                            channel = channel;
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        Throwable th15 = th;
                        if (channel == null) {
                            throw th15;
                        }
                        try {
                            channel.close();
                            throw th15;
                        } catch (Throwable th16) {
                            th15.addSuppressed(th16);
                            throw th15;
                        }
                        th = th;
                        randomAccessFile.close();
                        throw th;
                    }
                } catch (Throwable th17) {
                    th = th17;
                    randomAccessFile = randomAccessFile3;
                    th = th;
                    randomAccessFile.close();
                    throw th;
                }
            } finally {
            }
        } catch (IOException e) {
            Logger.m12702e(TAG, "makeFile: Error writing atom to file " + e.getMessage());
            return false;
        }
    }

    public final boolean removeSTTData(String str) {
        return removeAtom(str, M4aConsts.STTD, true);
    }
}
