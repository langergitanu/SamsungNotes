package com.samsung.android.support.senl.document.component;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SDocComponent {
    public static final int BASE_FORMAT_VERSION = 6;
    static final String END_FILE_TAG_DATA = "EOF";
    static final int END_FILE_TAG_DATA_SIZE = 3;
    static final String END_FILE_TAG_SDOC = "Document for SAMSUNG Note";
    static final int END_FILE_TAG_SDOC_SIZE = 25;
    public static final int FORMAT_VERSION = 18;
    private static final String TAG = "SDocComponent";
    boolean mIsChanged = false;
    int mCurrentFormatVersion = 0;

    public abstract void changeCacheDir(String str);

    public int getCurrentFormatVersion() {
        return this.mCurrentFormatVersion;
    }

    public abstract String[] getFileNames();

    public boolean isChanged() {
        return this.mIsChanged;
    }

    public abstract void readFile();

    public String readString(RandomAccessFile randomAccessFile) throws IOException {
        StringBuilder sb;
        int i = randomAccessFile.readInt();
        if (i > 0) {
            byte[] bArr = new byte[1026];
            sb = new StringBuilder(i);
            int i2 = i * 2;
            while (i2 > 1024) {
                int i4 = randomAccessFile.read(bArr, 0, 1024);
                i2 -= 1024;
                if (((bArr[1022] & 255) >> 2) == 54 && i2 >= 2) {
                    int i5 = randomAccessFile.read(bArr, 1024, 2);
                    i4 += i5;
                    i2 -= i5;
                }
                sb.append(new String(bArr, 0, i4, StandardCharsets.UTF_16BE));
            }
            if (i2 > 0) {
                sb.append(new String(bArr, 0, randomAccessFile.read(bArr, 0, i2), StandardCharsets.UTF_16BE));
            }
        } else {
            sb = null;
        }
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public void resetIsChanged() {
        this.mIsChanged = false;
    }

    public abstract void writeFile();

    public void writeString(RandomAccessFile randomAccessFile, String str) throws IOException {
        int length = (str == null || str.length() <= 0) ? 0 : str.length();
        randomAccessFile.writeInt(length);
        if (length > 0) {
            randomAccessFile.writeChars(str);
        }
    }
}
