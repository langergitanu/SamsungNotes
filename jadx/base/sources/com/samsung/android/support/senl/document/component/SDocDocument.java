package com.samsung.android.support.senl.document.component;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil;
import com.samsung.android.support.senl.document.data.ReminderData;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.UnsupportedFileException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocDocument extends SDocComponent {
    private static final String DATA_FILE_NAME_DOCUMENT = "doc.dat";
    private static final int FLEXIBLE_EXTRADATA_BYTE_ARR = 4;
    private static final int FLEXIBLE_EXTRADATA_INT = 1;
    private static final int FLEXIBLE_EXTRADATA_REMINDER = 8;
    private static final int FLEXIBLE_EXTRADATA_STR = 2;
    private static final String TAG = "SDocDocument";
    private HashMap<String, byte[]> mByteArrMap;
    private String mFilePath;
    private HashMap<String, Integer> mIntMap;
    private HashMap<String, String> mStrMap;
    private int mPropertyFlag = 0;
    private int mCursorPosition = 0;
    private int mDBVersion = 0;
    private ArrayList<ReminderData> mReminderDataSet = null;

    public SDocDocument(String str) {
        this.mFilePath = null;
        this.mIntMap = null;
        this.mStrMap = null;
        this.mByteArrMap = null;
        this.mFilePath = AbstractC0541b.m756B(str, "/doc.dat");
        this.mIntMap = new HashMap<>();
        this.mStrMap = new HashMap<>();
        this.mByteArrMap = new HashMap<>();
    }

    private int getFieldCheckFlag() {
        HashMap<String, Integer> map = this.mIntMap;
        int i = (map == null || map.size() <= 0) ? 0 : 1;
        HashMap<String, String> map2 = this.mStrMap;
        if (map2 != null && map2.size() > 0) {
            i |= 2;
        }
        HashMap<String, byte[]> map3 = this.mByteArrMap;
        return (map3 == null || map3.size() <= 0) ? i : i | 4;
    }

    private void readExtraData(RandomAccessFile randomAccessFile, int i) {
        this.mIntMap.clear();
        this.mStrMap.clear();
        this.mByteArrMap.clear();
        if ((i & 1) == 1) {
            try {
                int i2 = randomAccessFile.readInt();
                for (int i4 = 0; i4 < i2; i4++) {
                    int i5 = randomAccessFile.readInt();
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < i5; i6++) {
                        sb.append(randomAccessFile.readChar());
                    }
                    this.mIntMap.put(sb.toString(), Integer.valueOf(randomAccessFile.readInt()));
                }
            } catch (IOException e) {
                DocumentLogger.m7179e(TAG, "Read Extra Data!!" + e.toString());
                return;
            }
        }
        if ((i & 2) == 2) {
            int i7 = randomAccessFile.readInt();
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = randomAccessFile.readInt();
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < i9; i10++) {
                    sb2.append(randomAccessFile.readChar());
                }
                this.mStrMap.put(sb2.toString(), readString(randomAccessFile));
            }
        }
        if ((i & 4) == 4) {
            int i11 = randomAccessFile.readInt();
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = randomAccessFile.readInt();
                StringBuilder sb3 = new StringBuilder();
                for (int i14 = 0; i14 < i13; i14++) {
                    sb3.append(randomAccessFile.readChar());
                }
                int i15 = randomAccessFile.readInt();
                byte[] bArr = new byte[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    bArr[i16] = randomAccessFile.readByte();
                }
                this.mByteArrMap.put(sb3.toString(), bArr);
            }
        }
    }

    private void writeExtraData(RandomAccessFile randomAccessFile, int i) {
        try {
            HashMap<String, Integer> map = this.mIntMap;
            if (map != null && map.size() > 0) {
                randomAccessFile.writeInt(this.mIntMap.size());
                for (Map.Entry<String, Integer> entry : this.mIntMap.entrySet()) {
                    String key = entry.getKey();
                    randomAccessFile.writeInt(key.length());
                    randomAccessFile.writeChars(key);
                    randomAccessFile.writeInt(entry.getValue().intValue());
                }
            }
            HashMap<String, String> map2 = this.mStrMap;
            if (map2 != null && map2.size() > 0) {
                randomAccessFile.writeInt(this.mStrMap.size());
                for (Map.Entry<String, String> entry2 : this.mStrMap.entrySet()) {
                    String key2 = entry2.getKey();
                    randomAccessFile.writeInt(key2.length());
                    randomAccessFile.writeChars(key2);
                    writeString(randomAccessFile, entry2.getValue());
                }
            }
            HashMap<String, byte[]> map3 = this.mByteArrMap;
            if (map3 == null || map3.size() <= 0) {
                return;
            }
            randomAccessFile.writeInt(this.mByteArrMap.size());
            for (Map.Entry<String, byte[]> entry3 : this.mByteArrMap.entrySet()) {
                String key3 = entry3.getKey();
                randomAccessFile.writeInt(key3.length());
                randomAccessFile.writeChars(key3);
                byte[] value = entry3.getValue();
                randomAccessFile.writeInt(value.length);
                for (byte b : value) {
                    randomAccessFile.writeByte(b);
                }
            }
        } catch (IOException e) {
            DocumentLogger.m7179e(TAG, "Write Extra Data!!" + e.toString());
        }
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void changeCacheDir(String str) {
        if (str == null) {
            DocumentLogger.m7181i(TAG, "changeCacheDir() - newPath is null");
        } else {
            this.mFilePath = str.concat("/doc.dat");
        }
    }

    public int getCursorPosition() {
        return this.mCursorPosition;
    }

    public int getDBVersion() {
        return this.mDBVersion;
    }

    public byte[] getExtraDataByteArray(String str) {
        HashMap<String, byte[]> map = this.mByteArrMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public int getExtraDataInt(String str) {
        HashMap<String, Integer> map = this.mIntMap;
        if (map == null || str == null) {
            return -1;
        }
        return map.get(str).intValue();
    }

    public String getExtraDataString(String str) {
        HashMap<String, String> map = this.mStrMap;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public String[] getFileNames() {
        return new String[]{this.mFilePath};
    }

    public int getPropertyFlag() {
        return this.mPropertyFlag;
    }

    public ArrayList<ReminderData> getReminderData() {
        DocumentLogger.m7178d(TAG, "getReminderData() start! " + getCurrentFormatVersion());
        return this.mReminderDataSet;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void readFile() throws IOException {
        DocumentLogger.m7178d(TAG, "readFile() start");
        this.mReminderDataSet = new ArrayList<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.mFilePath, "r");
        try {
            randomAccessFile.seek(randomAccessFile.length() - 3);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append((char) randomAccessFile.readByte());
            }
            if (!sb.toString().equals(ComponentUtil.END_FILE_TAG_DATA)) {
                throw new IOException("Fail to load document data file. It is invalid.");
            }
            randomAccessFile.seek(0L);
            int i2 = randomAccessFile.readInt();
            this.mCurrentFormatVersion = i2;
            if (i2 < 6) {
                throw new UnsupportedFileException("Unsupported format version[" + this.mCurrentFormatVersion + "]!!");
            }
            long filePointer = randomAccessFile.getFilePointer();
            int i4 = randomAccessFile.readInt();
            int i5 = randomAccessFile.readInt();
            this.mPropertyFlag = randomAccessFile.readInt();
            int i6 = randomAccessFile.readInt();
            this.mCursorPosition = randomAccessFile.readInt();
            this.mDBVersion = randomAccessFile.readInt();
            randomAccessFile.seek(((long) i5) + filePointer);
            readExtraData(randomAccessFile, i6);
            if (this.mCurrentFormatVersion < 15 && (i6 & 8) == 8) {
                int i7 = randomAccessFile.readInt();
                for (int i8 = 0; i8 < i7; i8++) {
                    ReminderData reminderData = new ReminderData();
                    long filePointer2 = randomAccessFile.getFilePointer();
                    int i9 = randomAccessFile.readInt();
                    reminderData.reminderUuid = readString(randomAccessFile);
                    reminderData.time = randomAccessFile.readLong();
                    this.mReminderDataSet.add(reminderData);
                    randomAccessFile.seek(filePointer2 + ((long) i9));
                }
            }
            randomAccessFile.seek(filePointer + ((long) i4));
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "readFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public void setCursorPosition(int i) {
        this.mCursorPosition = i;
        this.mIsChanged = true;
    }

    public void setDBVersion(int i) {
        this.mDBVersion = i;
        this.mIsChanged = true;
    }

    public void setExtraDataByteArray(String str, byte[] bArr) {
        HashMap<String, byte[]> map = this.mByteArrMap;
        if (map != null) {
            map.put(str, bArr);
            this.mIsChanged = true;
        }
    }

    public void setExtraDataInt(String str, Integer num) {
        HashMap<String, Integer> map = this.mIntMap;
        if (map != null) {
            map.put(str, num);
            this.mIsChanged = true;
        }
    }

    public void setExtraDataString(String str, String str2) {
        HashMap<String, String> map = this.mStrMap;
        if (map != null) {
            map.put(str, str2);
            this.mIsChanged = true;
        }
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void writeFile() throws IOException {
        DocumentLogger.m7178d(TAG, "writeFile() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0622a.m1170p(this.mFilePath, ".bak", new StringBuilder()), InternalZipConstants.WRITE_MODE);
        try {
            randomAccessFile.writeInt(18);
            long filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(this.mPropertyFlag);
            int fieldCheckFlag = getFieldCheckFlag();
            randomAccessFile.writeInt(fieldCheckFlag);
            randomAccessFile.writeInt(this.mCursorPosition);
            randomAccessFile.writeInt(this.mDBVersion);
            long filePointer2 = randomAccessFile.getFilePointer();
            writeExtraData(randomAccessFile, fieldCheckFlag);
            long filePointer3 = randomAccessFile.getFilePointer();
            randomAccessFile.writeBytes(ComponentUtil.END_FILE_TAG_DATA);
            randomAccessFile.seek(filePointer);
            randomAccessFile.writeInt((int) (filePointer3 - filePointer));
            randomAccessFile.writeInt((int) (filePointer2 - filePointer));
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "writeFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }
}
