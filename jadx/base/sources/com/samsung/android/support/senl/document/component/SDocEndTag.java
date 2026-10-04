package com.samsung.android.support.senl.document.component;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil;
import com.samsung.android.support.senl.document.data.ReminderData;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.UnsupportedFileException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocEndTag extends SDocComponent {
    public static final String DATA_FILE_NAME_END_TAG = "endtag.dat";
    private static final int FIELD_FLAG_DOCUMENT_TYPE = 2;
    private static final int FIELD_FLAG_ENCRYPTION_INFO = 1;
    private static final int FIELD_FLAG_REMINDER_DATA = 4;
    private static final int MINIMUM_FORMAT_VERSION = 12;
    private static final int PROPERTY_FLAG_FAVORITE = 2;
    private static final int PROPERTY_FLAG_LOCK = 1;
    private static final String TAG = "SDocEndTag";
    private String mFilePath;
    private boolean mSetModifiedTime = false;
    private boolean mSetCreatedTime = false;
    private long mStartPosition = 0;
    private int mSizeOfEndTag = 0;
    private int mPropertyFlag = 0;
    private int mFieldCheckFlag = 0;
    private int mFileRevision = 0;
    private long mModifiedTime = 0;
    private int mMinimumFormatVersion = 0;
    private long mCreatedTime = 0;
    private long mUncompressedSize = 0;
    private String mTitle = null;
    private boolean mFavoriteFlag = false;
    private int mEncryptionSize = 0;
    private byte[] mEncryptionIv = null;
    private byte[] mEncryptionSalt = null;
    private byte[] mEncryptionKey = null;
    private int mDocumentType = 0;
    private ArrayList<ReminderData> mReminderDataSet = null;

    public SDocEndTag(String str) {
        this.mFilePath = null;
        this.mFilePath = AbstractC0541b.m756B(str, "/endtag.dat");
    }

    private int getFieldCheckFlag() {
        this.mFieldCheckFlag = 0;
        if (this.mEncryptionIv != null && this.mEncryptionSalt != null && this.mEncryptionKey != null) {
            this.mFieldCheckFlag = 1;
        }
        if (this.mDocumentType != 0) {
            this.mFieldCheckFlag |= 2;
        }
        ArrayList<ReminderData> arrayList = this.mReminderDataSet;
        if (arrayList != null && arrayList.size() > 0) {
            this.mFieldCheckFlag |= 4;
        }
        return this.mFieldCheckFlag;
    }

    private int getPropertyFlag() {
        this.mPropertyFlag = 0;
        if (this.mFavoriteFlag) {
            this.mPropertyFlag = 2;
        }
        return this.mPropertyFlag;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0044 A[EDGE_INSN: B:39:0x0044->B:22:0x0044 BREAK  A[LOOP:1: B:12:0x0029->B:42:?], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0042 -> B:10:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void makeFile(byte[] r7, int r8, java.lang.String r9) throws com.samsung.android.support.senl.document.exception.UnsupportedFileException, java.io.IOException {
        /*
            int r0 = r8 + (-25)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = r0
        L8:
            if (r2 >= r8) goto L13
            r3 = r7[r2]
            char r3 = (char) r3
            r1.append(r3)
            int r2 = r2 + 1
            goto L8
        L13:
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "Document for SAMSUNG Note"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L50
            int r0 = r8 + (-1024)
            r1 = 0
            if (r0 >= 0) goto L27
            r3 = r8
        L25:
            r0 = r1
            goto L29
        L27:
            r3 = 1024(0x400, float:1.435E-42)
        L29:
            r4 = -1
            if (r0 <= r4) goto L44
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.US_ASCII
            r5.<init>(r7, r0, r3, r6)
            int r5 = r5.lastIndexOf(r2)
            if (r5 == r4) goto L3b
            int r0 = r0 + r5
            goto L45
        L3b:
            if (r0 != 0) goto L3f
            r0 = r4
            goto L45
        L3f:
            int r0 = r0 - r3
            if (r0 >= 0) goto L29
            int r3 = r3 + r0
            goto L25
        L44:
            r0 = r1
        L45:
            if (r0 < 0) goto L48
            goto L50
        L48:
            com.samsung.android.support.senl.document.exception.UnsupportedFileException r7 = new com.samsung.android.support.senl.document.exception.UnsupportedFileException
            java.lang.String r8 = "Fail to load sdoc file. It is invalid file type."
            r7.<init>(r8)
            throw r7
        L50:
            int r1 = r0 + (-4)
            r1 = r7[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 24
            int r2 = r0 + (-3)
            r2 = r7[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 16
            r1 = r1 | r2
            int r2 = r0 + (-2)
            r2 = r7[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r1 = r1 | r2
            int r2 = r0 + (-1)
            r2 = r7[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r1 = r1 | r2
            int r0 = r0 - r1
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r9)
            int r8 = r8 - r0
            r1.write(r7, r0, r8)     // Catch: java.lang.Throwable -> L7f
            r1.close()
            return
        L7f:
            r7 = move-exception
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.support.senl.document.component.SDocEndTag.makeFile(byte[], int, java.lang.String):void");
    }

    private long searchStringOfFile(RandomAccessFile randomAccessFile, String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[1024];
            long length2 = randomAccessFile.length() - ((long) 1024);
            long j = 0;
            if (length2 < 0) {
                length2 = 0;
            }
            randomAccessFile.seek(length2);
            while (randomAccessFile.read(bArr, 0, 1024) > -1) {
                int iLastIndexOf = new String(bArr, StandardCharsets.US_ASCII).lastIndexOf(str);
                if (iLastIndexOf != -1) {
                    if (length2 >= 0) {
                        j = length2;
                    }
                    return j + ((long) iLastIndexOf);
                }
                if (length2 <= 0) {
                    break;
                }
                length2 -= (long) (1025 - length);
                if (length2 < 0) {
                    length2 = 0;
                }
                randomAccessFile.seek(length2);
            }
            return -1L;
        } catch (Exception e) {
            DocumentLogger.m7179e(TAG, "searchStringofFile()" + e.toString());
            return -1L;
        }
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void changeCacheDir(String str) {
        if (str == null) {
            DocumentLogger.m7181i(TAG, "changeCacheDir() - newPath is null");
        } else {
            this.mFilePath = str.concat("/endtag.dat");
        }
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public int getDocumentType() {
        return this.mDocumentType;
    }

    public byte[] getEncryptionIv() {
        return this.mEncryptionIv;
    }

    public byte[] getEncryptionKey() {
        return this.mEncryptionKey;
    }

    public byte[] getEncryptionSalt() {
        return this.mEncryptionSalt;
    }

    public int getEncryptionSize() {
        return this.mEncryptionSize;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public String[] getFileNames() {
        return new String[]{this.mFilePath};
    }

    public int getFileRevision() {
        return this.mFileRevision;
    }

    public int getMinimumFormatVersion() {
        return this.mMinimumFormatVersion;
    }

    public long getModifiedTime() {
        return this.mModifiedTime;
    }

    public ArrayList<ReminderData> getReminderData() {
        DocumentLogger.m7178d(TAG, "getReminderData() start! " + getCurrentFormatVersion());
        return this.mReminderDataSet;
    }

    public int getSize() {
        return this.mSizeOfEndTag;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getUncompressedSize() {
        return this.mUncompressedSize;
    }

    public void increaseFileRevision() {
        this.mFileRevision++;
        this.mIsChanged = true;
    }

    public boolean isEncrypted() {
        return this.mEncryptionSize > 0 && this.mEncryptionKey != null;
    }

    public boolean isFavorite() {
        return this.mFavoriteFlag;
    }

    public void parse(String str, boolean z) throws IOException {
        long length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            randomAccessFile.seek(randomAccessFile.length() - 25);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 25; i++) {
                sb.append((char) randomAccessFile.readByte());
            }
            if (sb.toString().equals(ComponentUtil.END_FILE_TAG_SDOC)) {
                length = randomAccessFile.length() - 25;
            } else {
                length = searchStringOfFile(randomAccessFile, ComponentUtil.END_FILE_TAG_SDOC);
                if (length < 0) {
                    throw new UnsupportedFileException("Fail to load sdoc file. It is invalid file type.");
                }
            }
            randomAccessFile.seek(length - 4);
            randomAccessFile.seek(length - ((long) randomAccessFile.readInt()));
            parse(randomAccessFile, z);
            randomAccessFile.close();
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void readFile() throws IOException {
        DocumentLogger.m7178d(TAG, "readFile() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.mFilePath, "r");
        try {
            randomAccessFile.seek(randomAccessFile.length() - 25);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 25; i++) {
                sb.append((char) randomAccessFile.readByte());
            }
            if (!sb.toString().equals(ComponentUtil.END_FILE_TAG_SDOC)) {
                throw new IOException("Fail to load end tag data file. It is invalid.");
            }
            randomAccessFile.seek(0L);
            parse(randomAccessFile, true);
            randomAccessFile.close();
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public void removeEncryptionInfo() {
        this.mEncryptionSize = 0;
        this.mEncryptionSalt = null;
        this.mEncryptionIv = null;
        this.mEncryptionKey = null;
    }

    public void resetFileRevision() {
        this.mFileRevision = 0;
        this.mIsChanged = true;
    }

    public void resetStartPosition(String str) throws IOException {
        long length;
        DocumentLogger.m7178d(TAG, "resetStartPosition() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            randomAccessFile.seek(randomAccessFile.length() - 25);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 25; i++) {
                sb.append((char) randomAccessFile.readByte());
            }
            if (sb.toString().equals(ComponentUtil.END_FILE_TAG_SDOC)) {
                length = randomAccessFile.length() - 25;
            } else {
                length = searchStringOfFile(randomAccessFile, ComponentUtil.END_FILE_TAG_SDOC);
                if (length < 0) {
                    throw new UnsupportedFileException("Fail to load sdoc file. It is invalid file type.");
                }
            }
            randomAccessFile.seek(length - 4);
            randomAccessFile.seek(length - ((long) randomAccessFile.readInt()));
            this.mStartPosition = randomAccessFile.getFilePointer();
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "resetStartPosition() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public void setCreatedTime(long j) {
        if (j < 0) {
            return;
        }
        this.mSetCreatedTime = true;
        this.mCreatedTime = j;
        this.mIsChanged = true;
    }

    public void setDocumentType(int i) {
        this.mDocumentType = i;
        this.mIsChanged = true;
    }

    public void setEncryptionInfo(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.mEncryptionSize = i;
        this.mEncryptionSalt = bArr;
        this.mEncryptionIv = bArr2;
        this.mEncryptionKey = bArr3;
        this.mIsChanged = true;
    }

    public void setFavorite(boolean z) {
        if (this.mFavoriteFlag == z) {
            return;
        }
        this.mFavoriteFlag = z;
        this.mIsChanged = true;
    }

    public void setModifiedTime(long j) {
        if (j < 0) {
            return;
        }
        this.mSetModifiedTime = true;
        this.mModifiedTime = j;
        this.mIsChanged = true;
    }

    public void setReminderData(ArrayList<ReminderData> arrayList) {
        DocumentLogger.m7178d(TAG, "setReminderData() start! " + getCurrentFormatVersion());
        this.mReminderDataSet = arrayList;
        this.mIsChanged = true;
    }

    public void setTitle(String str) {
        DocumentLogger.m7178d(TAG, "setTitle() start!");
        this.mTitle = str;
        this.mIsChanged = true;
    }

    public void setUncompressedSize(long j) {
        this.mUncompressedSize = j;
    }

    public void update(String str) throws IOException {
        DocumentLogger.m7178d(TAG, "update() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, InternalZipConstants.WRITE_MODE);
        long j = this.mStartPosition;
        if (j != 0) {
            randomAccessFile.setLength(j);
        }
        try {
            writeBytes(randomAccessFile);
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "update() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public void writeBytes(String str, boolean z) throws IOException {
        DocumentLogger.m7178d(TAG, "writeBytes() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, InternalZipConstants.WRITE_MODE);
        if (z) {
            this.mStartPosition = randomAccessFile.length();
        } else {
            this.mStartPosition = 0L;
        }
        try {
            writeBytes(randomAccessFile);
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "writeBytes() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void writeFile() throws IOException {
        DocumentLogger.m7178d(TAG, "writeFile() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0622a.m1170p(this.mFilePath, ".bak", new StringBuilder()), InternalZipConstants.WRITE_MODE);
        this.mStartPosition = 0L;
        try {
            writeBytes(randomAccessFile);
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "writeFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    private void writeBytes(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.seek(this.mStartPosition);
        randomAccessFile.writeInt(0);
        randomAccessFile.writeInt(0);
        randomAccessFile.writeInt(0);
        randomAccessFile.writeInt(getPropertyFlag());
        randomAccessFile.writeInt(getFieldCheckFlag());
        randomAccessFile.writeInt(this.mFileRevision);
        if (this.mSetModifiedTime) {
            this.mSetModifiedTime = false;
        } else {
            this.mModifiedTime = System.currentTimeMillis();
        }
        randomAccessFile.writeLong(this.mModifiedTime);
        randomAccessFile.writeInt(12);
        if (!this.mSetCreatedTime && this.mFileRevision <= 1) {
            this.mCreatedTime = this.mModifiedTime;
        } else {
            this.mSetCreatedTime = false;
        }
        randomAccessFile.writeLong(this.mCreatedTime);
        randomAccessFile.writeLong(this.mUncompressedSize);
        writeString(randomAccessFile, this.mTitle);
        long filePointer = randomAccessFile.getFilePointer() - this.mStartPosition;
        int i = this.mEncryptionSize;
        if (i > 0 && this.mEncryptionIv != null && this.mEncryptionSalt != null && this.mEncryptionKey != null) {
            randomAccessFile.writeInt(i);
            randomAccessFile.writeInt(this.mEncryptionSalt.length);
            randomAccessFile.write(this.mEncryptionSalt);
            randomAccessFile.writeInt(this.mEncryptionIv.length);
            randomAccessFile.write(this.mEncryptionIv);
            randomAccessFile.writeInt(this.mEncryptionKey.length);
            randomAccessFile.write(this.mEncryptionKey);
        }
        int i2 = this.mDocumentType;
        if (i2 != 0) {
            randomAccessFile.writeInt(i2);
        }
        ArrayList<ReminderData> arrayList = this.mReminderDataSet;
        if (arrayList != null && arrayList.size() > 0) {
            randomAccessFile.writeInt(this.mReminderDataSet.size());
            for (ReminderData reminderData : this.mReminderDataSet) {
                long filePointer2 = randomAccessFile.getFilePointer();
                randomAccessFile.writeInt(0);
                writeString(randomAccessFile, reminderData.reminderUuid);
                randomAccessFile.writeLong(reminderData.time);
                long filePointer3 = randomAccessFile.getFilePointer();
                randomAccessFile.seek(filePointer2);
                randomAccessFile.writeInt((int) (filePointer3 - filePointer2));
                randomAccessFile.seek(filePointer3);
            }
        }
        randomAccessFile.writeInt(((int) (randomAccessFile.getFilePointer() - this.mStartPosition)) + 4);
        randomAccessFile.writeBytes(ComponentUtil.END_FILE_TAG_SDOC);
        randomAccessFile.seek(this.mStartPosition);
        int length = (int) (randomAccessFile.length() - this.mStartPosition);
        this.mSizeOfEndTag = length;
        randomAccessFile.writeInt(length);
        randomAccessFile.writeInt(18);
        randomAccessFile.writeInt((int) filePointer);
    }

    private void parse(RandomAccessFile randomAccessFile, boolean z) throws UnsupportedFileException, IOException {
        DocumentLogger.m7178d(TAG, "parse() - check [" + z + "]");
        this.mReminderDataSet = new ArrayList<>();
        this.mStartPosition = randomAccessFile.getFilePointer();
        this.mSizeOfEndTag = randomAccessFile.readInt();
        int i = randomAccessFile.readInt();
        this.mCurrentFormatVersion = i;
        if (i >= 6) {
            int i2 = randomAccessFile.readInt();
            int i4 = randomAccessFile.readInt();
            this.mPropertyFlag = i4;
            if ((i4 & 1) != 0) {
                this.mDocumentType = 1;
            }
            if ((i4 & 2) != 0) {
                this.mFavoriteFlag = true;
            } else {
                this.mFavoriteFlag = false;
            }
            this.mFieldCheckFlag = randomAccessFile.readInt();
            this.mFileRevision = randomAccessFile.readInt();
            this.mModifiedTime = randomAccessFile.readLong();
            int i5 = randomAccessFile.readInt();
            this.mMinimumFormatVersion = i5;
            if (z && 18 < i5) {
                DocumentLogger.m7179e(TAG, "parse() - current code version[18] can not support this file[" + this.mMinimumFormatVersion + "].");
            }
            if (this.mCurrentFormatVersion >= 8) {
                this.mCreatedTime = randomAccessFile.readLong();
            }
            if (this.mCurrentFormatVersion >= 9) {
                this.mUncompressedSize = randomAccessFile.readLong();
            }
            if (this.mCurrentFormatVersion >= 11) {
                this.mTitle = readString(randomAccessFile);
            }
            randomAccessFile.seek(this.mStartPosition + ((long) i2));
            if ((this.mFieldCheckFlag & 1) != 0) {
                this.mEncryptionSize = randomAccessFile.readInt();
                int i6 = randomAccessFile.readInt();
                byte[] bArr = new byte[i6];
                this.mEncryptionSalt = bArr;
                int i7 = randomAccessFile.read(bArr);
                if (i7 != i6) {
                    DocumentLogger.m7178d(TAG, AbstractC0622a.m1164j(i6, i7, "readFile() - E1 read fail. expected [", "], actually [", "]"));
                }
                int i8 = randomAccessFile.readInt();
                byte[] bArr2 = new byte[i8];
                this.mEncryptionIv = bArr2;
                int i9 = randomAccessFile.read(bArr2);
                if (i9 != i8) {
                    DocumentLogger.m7178d(TAG, AbstractC0622a.m1164j(i8, i9, "readFile() - E2 read fail. expected [", "], actually [", "]"));
                }
                int i10 = randomAccessFile.readInt();
                byte[] bArr3 = new byte[i10];
                this.mEncryptionKey = bArr3;
                int i11 = randomAccessFile.read(bArr3);
                if (i11 != i10) {
                    DocumentLogger.m7178d(TAG, AbstractC0622a.m1164j(i10, i11, "readFile() - E3 read fail. expected [", "], actually [", "]"));
                }
            }
            if ((this.mFieldCheckFlag & 2) != 0) {
                int i12 = randomAccessFile.readInt();
                this.mDocumentType = i12;
                if (this.mCurrentFormatVersion < 12) {
                    this.mDocumentType = i12 + 1;
                }
            }
            if ((this.mFieldCheckFlag & 4) == 4) {
                int i13 = randomAccessFile.readInt();
                for (int i14 = 0; i14 < i13; i14++) {
                    ReminderData reminderData = new ReminderData();
                    long filePointer = randomAccessFile.getFilePointer();
                    int i15 = randomAccessFile.readInt();
                    reminderData.reminderUuid = readString(randomAccessFile);
                    reminderData.time = randomAccessFile.readLong();
                    this.mReminderDataSet.add(reminderData);
                    randomAccessFile.seek(filePointer + ((long) i15));
                }
            }
            DocumentLogger.m7178d(TAG, "readFile() end");
            return;
        }
        throw new UnsupportedFileException(AbstractC2821a.m2223n(new StringBuilder("Unsupported format version["), "]!!", this.mCurrentFormatVersion));
    }
}
