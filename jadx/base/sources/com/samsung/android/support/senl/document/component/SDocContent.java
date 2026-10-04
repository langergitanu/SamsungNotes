package com.samsung.android.support.senl.document.component;

import android.graphics.RectF;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil;
import com.samsung.android.support.senl.document.data.ContentData;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.UnsupportedFileException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocContent extends SDocComponent {
    private static final String DATA_FILE_NAME_CONTENT = "content.dat";
    private static final String DATA_FILE_NAME_TEXT = "text.dat";
    private static final int FIELD_FLAG_EXPAND = Integer.MIN_VALUE;
    private static final int FIELD_FLAG_EXTRA_MAP = 64;
    private static final int FIELD_FLAG_OBJECT_FILE_ID = 2;
    private static final int FIELD_FLAG_OBJECT_RECT = 4;
    private static final int FIELD_FLAG_SPAN = 1;
    private static final int FIELD_FLAG_WEB_BODY = 16;
    private static final int FIELD_FLAG_WEB_TITLE = 8;
    private static final int FIELD_FLAG_WEB_URI = 32;
    private static final String TAG = "SDocContent";
    private String mContentFilePath;
    private String mTextFilePath;
    private ArrayList<ContentData> mContentDataList = null;
    private String mTitle = null;

    public SDocContent(String str) {
        this.mTextFilePath = null;
        this.mContentFilePath = null;
        this.mTextFilePath = AbstractC0541b.m756B(str, "/text.dat");
        this.mContentFilePath = AbstractC0541b.m756B(str, "/content.dat");
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void changeCacheDir(String str) {
        if (str == null) {
            DocumentLogger.m7181i(TAG, "changeCacheDir() - newPath is null");
        } else {
            this.mTextFilePath = str.concat("/text.dat");
            this.mContentFilePath = str.concat("/content.dat");
        }
    }

    public ArrayList<ContentData> getContentData() {
        return this.mContentDataList;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public String[] getFileNames() {
        return new String[]{this.mTextFilePath, this.mContentFilePath};
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void readFile() throws Throwable {
        RandomAccessFile randomAccessFile;
        int i;
        int i2;
        int i4;
        int i5;
        DocumentLogger.m7178d(TAG, "readFile() start");
        this.mContentDataList = new ArrayList<>();
        RandomAccessFile randomAccessFile2 = null;
        try {
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.mTextFilePath, "r");
            try {
                randomAccessFile = new RandomAccessFile(this.mContentFilePath, "r");
                try {
                    randomAccessFile3.seek(randomAccessFile3.length() - 3);
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < 3; i6++) {
                        sb.append((char) randomAccessFile3.readByte());
                    }
                    if (!sb.toString().equals(ComponentUtil.END_FILE_TAG_DATA)) {
                        throw new IOException("Fail to load text data file. It is invalid.");
                    }
                    randomAccessFile3.seek(0L);
                    randomAccessFile.seek(randomAccessFile.length() - 3);
                    StringBuilder sb2 = new StringBuilder();
                    for (int i7 = 0; i7 < 3; i7++) {
                        sb2.append((char) randomAccessFile.readByte());
                    }
                    if (!sb2.toString().equals(ComponentUtil.END_FILE_TAG_DATA)) {
                        throw new IOException("Fail to load span data file. It is invalid.");
                    }
                    randomAccessFile.seek(0L);
                    int i8 = randomAccessFile.readInt();
                    this.mCurrentFormatVersion = i8;
                    if (i8 < 6) {
                        throw new UnsupportedFileException("Unsupported format version[" + this.mCurrentFormatVersion + "]!!");
                    }
                    int i9 = randomAccessFile.readInt();
                    int i10 = 0;
                    while (i10 < i9) {
                        ContentData contentData = new ContentData();
                        long filePointer = randomAccessFile.getFilePointer();
                        int i11 = randomAccessFile.readInt();
                        int i12 = randomAccessFile.readInt();
                        int i13 = randomAccessFile.readInt();
                        contentData.contentType = randomAccessFile.readInt();
                        contentData.contentId = randomAccessFile.readInt();
                        contentData.thumbnailId = randomAccessFile.readInt();
                        contentData.taskId = randomAccessFile.readInt();
                        contentData.taskState = randomAccessFile.readInt();
                        int i14 = i10;
                        randomAccessFile.seek(((long) i12) + filePointer);
                        if ((i13 & 1) != 0 && (i4 = randomAccessFile.readInt()) > 0) {
                            contentData.spans = new ArrayList<>();
                            int i15 = 0;
                            while (i15 < i4) {
                                ContentData.SpanData spanData = new ContentData.SpanData();
                                long filePointer2 = randomAccessFile.getFilePointer();
                                int i16 = randomAccessFile.readInt();
                                int i17 = i9;
                                spanData.spanType = randomAccessFile.readInt();
                                spanData.startPosition = randomAccessFile.readInt();
                                spanData.endPosition = randomAccessFile.readInt();
                                spanData.intervalType = randomAccessFile.readInt();
                                spanData.spanVersion = randomAccessFile.readInt();
                                spanData.arg1 = randomAccessFile.readInt();
                                spanData.arg2 = randomAccessFile.readInt();
                                int i18 = randomAccessFile.readInt();
                                if (i18 > 0) {
                                    i5 = i4;
                                    spanData.customData = new HashMap<>();
                                    int i19 = 0;
                                    while (i19 < i18) {
                                        spanData.customData.put(Integer.valueOf(randomAccessFile.readInt()), readString(randomAccessFile));
                                        i19++;
                                        i18 = i18;
                                        i15 = i15;
                                    }
                                } else {
                                    i5 = i4;
                                }
                                int i20 = i15;
                                contentData.spans.add(spanData);
                                randomAccessFile.seek(filePointer2 + ((long) i16));
                                i15 = i20 + 1;
                                i9 = i17;
                                i4 = i5;
                            }
                        }
                        int i21 = i9;
                        if ((i13 & 2) != 0 && (i2 = randomAccessFile.readInt()) > 0) {
                            contentData.objectFileId = new ArrayList<>();
                            for (int i22 = 0; i22 < i2; i22++) {
                                contentData.objectFileId.add(Integer.valueOf(randomAccessFile.readInt()));
                            }
                        }
                        if ((i13 & 4) != 0) {
                            RectF rectF = new RectF();
                            contentData.objectRect = rectF;
                            rectF.left = randomAccessFile.readFloat();
                            contentData.objectRect.top = randomAccessFile.readFloat();
                            contentData.objectRect.right = randomAccessFile.readFloat();
                            contentData.objectRect.bottom = randomAccessFile.readFloat();
                        }
                        if ((i13 & 8) != 0) {
                            contentData.title = readString(randomAccessFile);
                        }
                        if ((i13 & 16) != 0) {
                            contentData.body = readString(randomAccessFile);
                        }
                        if ((i13 & 32) != 0) {
                            contentData.uri = readString(randomAccessFile);
                        }
                        if ((i13 & 64) != 0 && (i = randomAccessFile.readInt()) > 0) {
                            contentData.extraMap = new HashMap<>();
                            for (int i23 = 0; i23 < i; i23++) {
                                contentData.extraMap.put(Integer.valueOf(randomAccessFile.readInt()), readString(randomAccessFile));
                            }
                        }
                        this.mContentDataList.add(contentData);
                        randomAccessFile.seek(filePointer + ((long) i11));
                        i10 = i14 + 1;
                        i9 = i21;
                    }
                    int i24 = randomAccessFile3.readInt();
                    this.mCurrentFormatVersion = i24;
                    if (i24 < 6) {
                        throw new UnsupportedFileException("Unsupported format version[" + this.mCurrentFormatVersion + "]!!");
                    }
                    this.mTitle = readString(randomAccessFile3);
                    int i25 = randomAccessFile3.readInt();
                    int size = this.mContentDataList.size();
                    int i26 = 0;
                    int i27 = 0;
                    while (i26 < i25) {
                        int i28 = randomAccessFile3.readInt();
                        int i29 = i27;
                        while (true) {
                            if (i29 < size) {
                                ContentData contentData2 = this.mContentDataList.get(i29);
                                if (contentData2.contentId == i28) {
                                    contentData2.text = readString(randomAccessFile3);
                                    break;
                                }
                                i29++;
                            }
                        }
                        i26++;
                        i27 = i29;
                    }
                    randomAccessFile3.close();
                    randomAccessFile.close();
                    DocumentLogger.m7178d(TAG, "readFile() end");
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile3;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public void setContentData(ArrayList<ContentData> arrayList) {
        DocumentLogger.m7178d(TAG, "setContentData() start!");
        this.mContentDataList = arrayList;
        this.mIsChanged = true;
    }

    public void setTitle(String str) {
        DocumentLogger.m7178d(TAG, " setTitle() start!");
        this.mTitle = str;
        this.mIsChanged = true;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void writeFile() throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        Iterator<ContentData> it;
        int i;
        long j;
        int i2;
        DocumentLogger.m7178d(TAG, "writeFile() start");
        RandomAccessFile randomAccessFile3 = null;
        try {
            randomAccessFile2 = new RandomAccessFile(this.mTextFilePath + ".bak", InternalZipConstants.WRITE_MODE);
            try {
                randomAccessFile = new RandomAccessFile(this.mContentFilePath + ".bak", InternalZipConstants.WRITE_MODE);
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            randomAccessFile2.writeInt(18);
            writeString(randomAccessFile2, this.mTitle);
            long filePointer = randomAccessFile2.getFilePointer();
            int i4 = 0;
            randomAccessFile2.writeInt(0);
            randomAccessFile.writeInt(18);
            ArrayList<ContentData> arrayList = this.mContentDataList;
            if (arrayList == null) {
                randomAccessFile.writeInt(0);
            } else {
                randomAccessFile.writeInt(arrayList.size());
                Iterator<ContentData> it2 = this.mContentDataList.iterator();
                int i5 = 0;
                while (it2.hasNext()) {
                    ContentData next = it2.next();
                    if (next.text != null) {
                        randomAccessFile2.writeInt(next.contentId);
                        writeString(randomAccessFile2, next.text);
                        i5++;
                    }
                    long filePointer2 = randomAccessFile.getFilePointer();
                    randomAccessFile.writeInt(i4);
                    randomAccessFile.writeInt(i4);
                    randomAccessFile.writeInt(i4);
                    randomAccessFile.writeInt(next.contentType);
                    randomAccessFile.writeInt(next.contentId);
                    randomAccessFile.writeInt(next.thumbnailId);
                    randomAccessFile.writeInt(next.taskId);
                    randomAccessFile.writeInt(next.taskState);
                    long filePointer3 = randomAccessFile.getFilePointer();
                    ArrayList<ContentData.SpanData> arrayList2 = next.spans;
                    if (arrayList2 != null) {
                        randomAccessFile.writeInt(arrayList2.size());
                        for (ContentData.SpanData spanData : next.spans) {
                            long j2 = filePointer3;
                            long filePointer4 = randomAccessFile.getFilePointer();
                            Iterator<ContentData> it3 = it2;
                            randomAccessFile.writeInt(0);
                            randomAccessFile.writeInt(spanData.spanType);
                            randomAccessFile.writeInt(spanData.startPosition);
                            randomAccessFile.writeInt(spanData.endPosition);
                            randomAccessFile.writeInt(spanData.intervalType);
                            randomAccessFile.writeInt(spanData.spanVersion);
                            randomAccessFile.writeInt(spanData.arg1);
                            randomAccessFile.writeInt(spanData.arg2);
                            HashMap<Integer, String> map = spanData.customData;
                            if (map == null) {
                                randomAccessFile.writeInt(0);
                            } else {
                                randomAccessFile.writeInt(map.size());
                                for (Iterator<Map.Entry<Integer, String>> it4 = spanData.customData.entrySet().iterator(); it4.hasNext(); it4 = it4) {
                                    Map.Entry<Integer, String> next2 = it4.next();
                                    randomAccessFile.writeInt(next2.getKey().intValue());
                                    writeString(randomAccessFile, next2.getValue());
                                }
                            }
                            int i6 = i5;
                            long filePointer5 = randomAccessFile.getFilePointer();
                            randomAccessFile.seek(filePointer4);
                            randomAccessFile.writeInt((int) (filePointer5 - filePointer4));
                            randomAccessFile.seek(filePointer5);
                            i5 = i6;
                            it2 = it3;
                            filePointer3 = j2;
                        }
                        it = it2;
                        i = i5;
                        j = filePointer3;
                        i2 = 1;
                    } else {
                        it = it2;
                        i = i5;
                        j = filePointer3;
                        i2 = 0;
                    }
                    ArrayList<Integer> arrayList3 = next.objectFileId;
                    if (arrayList3 != null) {
                        i2 |= 2;
                        randomAccessFile.writeInt(arrayList3.size());
                        Iterator<Integer> it5 = next.objectFileId.iterator();
                        while (it5.hasNext()) {
                            randomAccessFile.writeInt(it5.next().intValue());
                        }
                    }
                    RectF rectF = next.objectRect;
                    if (rectF != null) {
                        i2 |= 4;
                        randomAccessFile.writeFloat(rectF.left);
                        randomAccessFile.writeFloat(next.objectRect.top);
                        randomAccessFile.writeFloat(next.objectRect.right);
                        randomAccessFile.writeFloat(next.objectRect.bottom);
                    }
                    String str = next.title;
                    if (str != null) {
                        i2 |= 8;
                        writeString(randomAccessFile, str);
                    }
                    String str2 = next.body;
                    if (str2 != null) {
                        i2 |= 16;
                        writeString(randomAccessFile, str2);
                    }
                    String str3 = next.uri;
                    if (str3 != null) {
                        i2 |= 32;
                        writeString(randomAccessFile, str3);
                    }
                    HashMap<Integer, String> map2 = next.extraMap;
                    if (map2 != null) {
                        i2 |= 64;
                        randomAccessFile.writeInt(map2.size());
                        for (Map.Entry<Integer, String> entry : next.extraMap.entrySet()) {
                            randomAccessFile.writeInt(entry.getKey().intValue());
                            writeString(randomAccessFile, entry.getValue());
                        }
                    }
                    long filePointer6 = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(filePointer2);
                    randomAccessFile.writeInt((int) (filePointer6 - filePointer2));
                    randomAccessFile.writeInt((int) (j - filePointer2));
                    randomAccessFile.writeInt(i2);
                    randomAccessFile.seek(filePointer6);
                    i5 = i;
                    it2 = it;
                    i4 = 0;
                }
                i4 = i5;
            }
            long filePointer7 = randomAccessFile2.getFilePointer();
            randomAccessFile2.seek(filePointer);
            randomAccessFile2.writeInt(i4);
            randomAccessFile2.seek(filePointer7);
            randomAccessFile2.writeBytes(ComponentUtil.END_FILE_TAG_DATA);
            randomAccessFile.writeBytes(ComponentUtil.END_FILE_TAG_DATA);
            randomAccessFile2.close();
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "writeFile() end");
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile3 = randomAccessFile2;
            if (randomAccessFile3 != null) {
                randomAccessFile3.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }
}
