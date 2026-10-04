package com.samsung.android.support.senl.document.component;

import android.graphics.Rect;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil;
import com.samsung.android.support.senl.document.data.SearchData;
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
public class SDocSearchData extends SDocComponent {
    private static final String DATA_FILE_NAME_SEARCH_DATA = "searchData.dat";
    private static final String TAG = "SDocSearchData";
    private String mFilePath;
    private ArrayList<SearchData> mSearchDataSet = null;

    public SDocSearchData(String str) {
        this.mFilePath = null;
        this.mFilePath = AbstractC0541b.m756B(str, "/searchData.dat");
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void changeCacheDir(String str) {
        if (str == null) {
            DocumentLogger.m7181i(TAG, "changeCacheDir() - newPath is null");
        } else {
            this.mFilePath = str.concat("/searchData.dat");
        }
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public String[] getFileNames() {
        return new String[]{this.mFilePath};
    }

    public ArrayList<SearchData> getSearchData() {
        return this.mSearchDataSet;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void readFile() throws IOException {
        DocumentLogger.m7178d(TAG, "readFile() start");
        this.mSearchDataSet = new ArrayList<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.mFilePath, "r");
        try {
            randomAccessFile.seek(randomAccessFile.length() - 3);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append((char) randomAccessFile.readByte());
            }
            if (!sb.toString().equals(ComponentUtil.END_FILE_TAG_DATA)) {
                throw new IOException("Fail to load text data file. It is invalid.");
            }
            randomAccessFile.seek(0L);
            int i2 = randomAccessFile.readInt();
            this.mCurrentFormatVersion = i2;
            if (i2 < 6) {
                throw new UnsupportedFileException("Unsupported format version[" + this.mCurrentFormatVersion + "]!!");
            }
            int i4 = randomAccessFile.readInt();
            for (int i5 = 0; i5 < i4; i5++) {
                SearchData searchData = new SearchData();
                long filePointer = randomAccessFile.getFilePointer();
                int i6 = randomAccessFile.readInt();
                Rect rect = new Rect();
                searchData.rect = rect;
                rect.left = randomAccessFile.readInt();
                searchData.rect.top = randomAccessFile.readInt();
                searchData.rect.right = randomAccessFile.readInt();
                searchData.rect.bottom = randomAccessFile.readInt();
                searchData.text = readString(randomAccessFile);
                searchData.filePath = readString(randomAccessFile);
                searchData.pageWidth = randomAccessFile.readInt();
                if (this.mCurrentFormatVersion >= 14) {
                    searchData.hasVisualCue = randomAccessFile.readBoolean();
                }
                int i7 = randomAccessFile.readInt();
                if (i7 > 0) {
                    searchData.customData = new HashMap<>();
                    for (int i8 = 0; i8 < i7; i8++) {
                        searchData.customData.put(Integer.valueOf(randomAccessFile.readInt()), readString(randomAccessFile));
                    }
                }
                this.mSearchDataSet.add(searchData);
                randomAccessFile.seek(filePointer + ((long) i6));
            }
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "readFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public void setSearchData(ArrayList<SearchData> arrayList) {
        this.mSearchDataSet = arrayList;
        this.mIsChanged = true;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void writeFile() throws IOException {
        DocumentLogger.m7178d(TAG, "writeFile() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0622a.m1170p(this.mFilePath, ".bak", new StringBuilder()), InternalZipConstants.WRITE_MODE);
        try {
            randomAccessFile.writeInt(18);
            ArrayList<SearchData> arrayList = this.mSearchDataSet;
            if (arrayList == null) {
                randomAccessFile.writeInt(0);
            } else {
                randomAccessFile.writeInt(arrayList.size());
                for (SearchData searchData : this.mSearchDataSet) {
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.writeInt(0);
                    Rect rect = searchData.rect;
                    if (rect != null) {
                        randomAccessFile.writeInt(rect.left);
                        randomAccessFile.writeInt(searchData.rect.top);
                        randomAccessFile.writeInt(searchData.rect.right);
                        randomAccessFile.writeInt(searchData.rect.bottom);
                    } else {
                        randomAccessFile.writeInt(0);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.writeInt(0);
                    }
                    writeString(randomAccessFile, searchData.text);
                    writeString(randomAccessFile, searchData.filePath);
                    randomAccessFile.writeInt(searchData.pageWidth);
                    randomAccessFile.writeBoolean(searchData.hasVisualCue);
                    HashMap<Integer, String> map = searchData.customData;
                    int size = (map == null || map.size() <= 0) ? 0 : searchData.customData.size();
                    randomAccessFile.writeInt(size);
                    if (size > 0) {
                        for (Map.Entry<Integer, String> entry : searchData.customData.entrySet()) {
                            randomAccessFile.writeInt(entry.getKey().intValue());
                            writeString(randomAccessFile, entry.getValue());
                        }
                    }
                    long filePointer2 = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(filePointer);
                    randomAccessFile.writeInt((int) (filePointer2 - filePointer));
                    randomAccessFile.seek(filePointer2);
                }
            }
            randomAccessFile.writeBytes(ComponentUtil.END_FILE_TAG_DATA);
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "writeFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }
}
