package com.samsung.android.support.senl.document.component;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.UnsupportedFileException;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.document.util.ZipUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocFileManager extends SDocComponent {
    private static final String DATA_FILE_NAME_FILE_INFO = "fileinfo.dat";
    private static final String FILE_DIR_PATH = "/files/";
    private static final boolean KH_DEBUG = true;
    private static final int MAX_ID = Integer.MAX_VALUE;
    private static final String TAG = "SDocFileManager";
    private HashMap<Long, Integer> mCrcIdMap;
    private String mFilePath;
    private HashMap<Integer, FileInfo> mIdInfoMap;
    private String mCacheDir = null;
    private String mFilesDir = null;
    private ArrayList<String> mAttachedFileList = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FileInfo {
        long crc;
        String name;
        int ref;

        private FileInfo() {
        }
    }

    public SDocFileManager(String str) {
        this.mCrcIdMap = null;
        this.mIdInfoMap = null;
        this.mFilePath = null;
        changeCacheDir(str);
        this.mFilePath = str + "/fileinfo.dat";
        this.mCrcIdMap = new HashMap<>();
        this.mIdInfoMap = new HashMap<>();
    }

    private void printDebugLogger(String str) {
        DocumentLogger.m7178d(TAG, str);
    }

    public int bind(int i) {
        printDebugLogger(AbstractC0541b.m767i(i, "bind2 - id = [", "]"));
        if (i < 0) {
            DocumentLogger.m7179e(TAG, "bind2() - id is invalid. [" + i + "] < 0");
            return -1;
        }
        FileInfo fileInfo = this.mIdInfoMap.get(Integer.valueOf(i));
        if (fileInfo == null) {
            DocumentLogger.m7179e(TAG, "bind2() - id is not found. [" + i + "]");
            return -1;
        }
        fileInfo.ref++;
        printDebugLogger(AbstractC6670b.m4743d(fileInfo.name, "]", new StringBuilder("bind2() - filePath = [")));
        printDebugLogger(AbstractC2821a.m2224o(new StringBuilder("bind2() - crc = ["), "]", fileInfo.crc));
        printDebugLogger(AbstractC2821a.m2223n(new StringBuilder("bind2() - ref = ["), "]", fileInfo.ref));
        this.mIdInfoMap.put(Integer.valueOf(i), fileInfo);
        printDebugLogger("bind2() end ");
        this.mIsChanged = true;
        return i;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void changeCacheDir(String str) {
        if (str == null) {
            DocumentLogger.m7181i(TAG, "changeCacheDir() - newPath is null");
            return;
        }
        this.mCacheDir = str;
        this.mFilesDir = str.concat(FILE_DIR_PATH);
        this.mFilePath = str.concat("/fileinfo.dat");
        File file = new File(this.mFilesDir);
        if (file.exists() || file.mkdir()) {
            return;
        }
        DocumentLogger.m7178d(TAG, "changeCacheDir() - fail to make files directory. [" + SDocUtil.logPath(this.mFilesDir) + "]");
    }

    public void clearBindData() {
        printDebugLogger("clearBindData() - count - [" + this.mIdInfoMap.size() + "]");
        this.mCrcIdMap.clear();
        this.mIdInfoMap.clear();
        this.mIsChanged = true;
    }

    public void close() {
        int i;
        String strSubstring;
        File file = new File(this.mFilesDir);
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                printDebugLogger("close() - filesDirFileList is null.");
                return;
            }
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                try {
                    i = Integer.parseInt(name.substring(0, name.indexOf(64)));
                    strSubstring = name.substring(name.indexOf(64) + 1, name.length());
                } catch (RuntimeException unused) {
                    printDebugLogger("close() - Found untracking file. [" + SDocUtil.logPath(file2.getPath()) + "]");
                    i = -1;
                    strSubstring = null;
                }
                if ((!this.mIdInfoMap.containsKey(Integer.valueOf(i)) || !this.mIdInfoMap.get(Integer.valueOf(i)).name.equals(strSubstring) || this.mIdInfoMap.get(Integer.valueOf(i)).ref <= 0) && !file2.delete()) {
                    printDebugLogger("close() - Fail to delete untracking file. [" + SDocUtil.logPath(file2.getPath()) + "]");
                }
            }
        }
    }

    public void discard(long j) {
        for (Map.Entry<Integer, FileInfo> entry : this.mIdInfoMap.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            FileInfo value = entry.getValue();
            StringBuilder sbM1322o = AbstractC1974b.m1322o(iIntValue, Log.TAG_SEPARATOR);
            sbM1322o.append(value.name);
            String string = sbM1322o.toString();
            File file = new File(AbstractC0622a.m1170p(this.mFilesDir, string, new StringBuilder()));
            if (file.exists() && file.lastModified() > j) {
                if (file.delete()) {
                    DocumentLogger.m7178d(TAG, "discard() - [" + SDocUtil.logPath(string) + "] is deleted");
                } else {
                    DocumentLogger.m7178d(TAG, "discard() - fail to delete. [" + SDocUtil.logPath(string) + "]");
                }
            }
        }
    }

    public ArrayList<String> getAttachedFileList() {
        printDebugLogger("getAttachedFileList() - start!");
        if (this.mAttachedFileList == null) {
            this.mAttachedFileList = new ArrayList<>();
            for (Map.Entry<Integer, FileInfo> entry : this.mIdInfoMap.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().ref > 0) {
                    String filePath = getFilePath(iIntValue);
                    this.mAttachedFileList.add(filePath);
                    printDebugLogger(AbstractC6670b.m4743d(filePath, "]", new StringBuilder("getAttachedFileList() - [")));
                }
            }
        }
        return this.mAttachedFileList;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public String[] getFileNames() {
        return new String[]{this.mFilePath};
    }

    public String getFilePath(int i) {
        printDebugLogger(AbstractC0541b.m767i(i, "getFilePath() - id = [", "]"));
        FileInfo fileInfo = this.mIdInfoMap.get(Integer.valueOf(i));
        if (fileInfo == null) {
            DocumentLogger.m7179e(TAG, "getFilePath() - id is not found. [" + i + "]");
            return null;
        }
        StringBuilder sb = new StringBuilder("getFilePath() - path = [");
        StringBuilder sb2 = new StringBuilder();
        AbstractC1974b.m1330w(i, this.mFilesDir, Log.TAG_SEPARATOR, sb2);
        sb2.append(fileInfo.name);
        sb.append(SDocUtil.logPath(sb2.toString()));
        sb.append("]");
        printDebugLogger(sb.toString());
        StringBuilder sb3 = new StringBuilder();
        AbstractC1974b.m1330w(i, this.mFilesDir, Log.TAG_SEPARATOR, sb3);
        sb3.append(fileInfo.name);
        return sb3.toString();
    }

    public String getRepositoryPath() {
        printDebugLogger("getRepositoryPath()");
        return this.mFilesDir;
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void readFile() throws IOException {
        DocumentLogger.m7178d(TAG, "readFile() start");
        HashMap<Long, Integer> map = new HashMap<>();
        HashMap<Integer, FileInfo> map2 = new HashMap<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0622a.m1170p(this.mCacheDir, "/fileinfo.dat", new StringBuilder()), "r");
        try {
            randomAccessFile.seek(randomAccessFile.length() - 3);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append((char) randomAccessFile.readByte());
            }
            if (!sb.toString().equals(ComponentUtil.END_FILE_TAG_DATA)) {
                throw new IOException("Fail to load file info data file. It is invalid.");
            }
            randomAccessFile.seek(0L);
            int i2 = randomAccessFile.readInt();
            this.mCurrentFormatVersion = i2;
            if (i2 < 6) {
                throw new UnsupportedFileException("Unsupported format version[" + this.mCurrentFormatVersion + "]!!");
            }
            int i4 = randomAccessFile.readInt();
            for (int i5 = 0; i5 < i4; i5++) {
                FileInfo fileInfo = new FileInfo();
                int i6 = randomAccessFile.readInt();
                fileInfo.name = readString(randomAccessFile);
                fileInfo.crc = randomAccessFile.readLong();
                fileInfo.ref = randomAccessFile.readInt();
                map.put(Long.valueOf(fileInfo.crc), Integer.valueOf(i6));
                map2.put(Integer.valueOf(i6), fileInfo);
            }
            this.mCrcIdMap.clear();
            this.mIdInfoMap.clear();
            this.mCrcIdMap = map;
            this.mIdInfoMap = map2;
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "readFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public void refresh(int i) throws Throwable {
        printDebugLogger(AbstractC0541b.m767i(i, "refresh(id = ", ")"));
        FileInfo fileInfo = this.mIdInfoMap.get(Integer.valueOf(i));
        if (fileInfo == null) {
            DocumentLogger.m7179e(TAG, "refresh() - id is not found. [" + i + "]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        AbstractC1974b.m1330w(i, this.mFilesDir, Log.TAG_SEPARATOR, sb);
        sb.append(fileInfo.name);
        String string = sb.toString();
        File file = new File(string);
        if (!file.exists()) {
            throw new IOException(AbstractC6670b.m4743d(string, "]", new StringBuilder("refresh() - File not exist. [")));
        }
        long crc = ZipUtil.getCRC(file);
        if (crc == fileInfo.crc || this.mCrcIdMap.containsKey(Long.valueOf(crc))) {
            DocumentLogger.m7179e(TAG, "refresh() - there has duplicated crc value");
            return;
        }
        long j = fileInfo.crc;
        if (this.mCrcIdMap.containsKey(Long.valueOf(j))) {
            this.mCrcIdMap.remove(Long.valueOf(j));
        }
        this.mCrcIdMap.put(Long.valueOf(crc), Integer.valueOf(i));
        fileInfo.crc = crc;
        this.mIdInfoMap.put(Integer.valueOf(i), fileInfo);
        this.mIsChanged = true;
    }

    public void release(int i) {
        int i2;
        printDebugLogger(AbstractC0541b.m767i(i, "release() - id = [", "]"));
        FileInfo fileInfo = this.mIdInfoMap.get(Integer.valueOf(i));
        if (fileInfo != null && (i2 = fileInfo.ref) > 0) {
            fileInfo.ref = i2 - 1;
            this.mIdInfoMap.put(Integer.valueOf(i), fileInfo);
            printDebugLogger(AbstractC6670b.m4743d(fileInfo.name, "]", new StringBuilder("release() - filePath = [")));
            printDebugLogger(AbstractC2821a.m2224o(new StringBuilder("release() - crc = ["), "]", fileInfo.crc));
            printDebugLogger(AbstractC2821a.m2223n(new StringBuilder("release() - ref = ["), "]", fileInfo.ref));
            this.mIsChanged = true;
        }
        printDebugLogger("release() end ");
    }

    @Override // com.samsung.android.support.senl.document.component.SDocComponent
    public void writeFile() throws IOException {
        DocumentLogger.m7178d(TAG, "writeFile() start");
        this.mAttachedFileList = new ArrayList<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0622a.m1170p(this.mCacheDir, "/fileinfo.dat.bak", new StringBuilder()), InternalZipConstants.WRITE_MODE);
        try {
            randomAccessFile.writeInt(18);
            long filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.writeInt(0);
            for (Map.Entry<Integer, FileInfo> entry : this.mIdInfoMap.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                FileInfo value = entry.getValue();
                if (value.ref > 0) {
                    randomAccessFile.writeInt(iIntValue);
                    writeString(randomAccessFile, value.name);
                    randomAccessFile.writeLong(value.crc);
                    randomAccessFile.writeInt(value.ref);
                    this.mAttachedFileList.add(getFilePath(iIntValue));
                }
            }
            randomAccessFile.writeBytes(ComponentUtil.END_FILE_TAG_DATA);
            randomAccessFile.seek(filePointer);
            randomAccessFile.writeInt(this.mAttachedFileList.size());
            randomAccessFile.close();
            DocumentLogger.m7178d(TAG, "writeFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public void release(String str) throws Throwable {
        printDebugLogger(AbstractC6670b.m4743d(str, "]", new StringBuilder("release2() - filePath = [")));
        if (str == null) {
            DocumentLogger.m7179e(TAG, "release2() - filePath is null");
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            long crc = ZipUtil.getCRC(file);
            printDebugLogger(AbstractC1974b.m1317j(crc, "release2() - crc = [", "]"));
            if (this.mCrcIdMap.containsKey(Long.valueOf(crc))) {
                Integer num = this.mCrcIdMap.get(Long.valueOf(crc));
                FileInfo fileInfo = this.mIdInfoMap.get(num);
                if (fileInfo == null) {
                    DocumentLogger.m7179e(TAG, "release2() - id is not found. [" + num + "]");
                    return;
                }
                if (str.contains(fileInfo.name)) {
                    release(num.intValue());
                }
                printDebugLogger("release2() end ");
                return;
            }
            return;
        }
        throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("release2() - File not exist. [")));
    }

    public int bind(String str) throws Throwable {
        int iIntValue;
        printDebugLogger(AbstractC6670b.m4743d(str, "]", new StringBuilder("bind1() - filePath = [")));
        if (str == null) {
            DocumentLogger.m7179e(TAG, "bind1() - filePath is null");
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            long crc = ZipUtil.getCRC(file);
            printDebugLogger(AbstractC1974b.m1317j(crc, "bind1() - crc = [", "]"));
            if (!this.mCrcIdMap.containsKey(Long.valueOf(crc))) {
                iIntValue = 0;
                while (true) {
                    if (iIntValue >= Integer.MAX_VALUE) {
                        iIntValue = -1;
                        break;
                    }
                    if (!this.mIdInfoMap.containsKey(Integer.valueOf(iIntValue))) {
                        break;
                    }
                    iIntValue++;
                }
                String name = file.getName();
                int iLastIndexOf = name.lastIndexOf(Log.TAG_SEPARATOR);
                if (iLastIndexOf != -1 && iLastIndexOf < name.length() - 1) {
                    name = name.substring(iLastIndexOf + 1, name.length());
                }
                File file2 = new File(AbstractC0622a.m1170p(this.mFilesDir, iIntValue + Log.TAG_SEPARATOR + name, new StringBuilder()));
                String parent = file.getParent();
                String parent2 = file2.getParent();
                if (parent != null && parent2 != null) {
                    if (parent.compareToIgnoreCase(parent2) == 0) {
                        if (file.renameTo(file2)) {
                            printDebugLogger("bind1() - rename [" + SDocUtil.logPath(file.getPath()) + "] -> [" + SDocUtil.logPath(file2.getPath()) + "]");
                        } else {
                            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("bind1() - Fail to rename the file. [")));
                        }
                    } else {
                        printDebugLogger("bind1() - copy to [" + SDocUtil.logPath(file2.getAbsolutePath()) + "] start");
                        FileUtil.copyFile(file, file2);
                        printDebugLogger("bind1() - copy end ");
                    }
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.crc = crc;
                    fileInfo.ref = 1;
                    fileInfo.name = name;
                    this.mIdInfoMap.put(Integer.valueOf(iIntValue), fileInfo);
                    this.mCrcIdMap.put(Long.valueOf(crc), Integer.valueOf(iIntValue));
                    printDebugLogger(AbstractC2821a.m2223n(new StringBuilder("bind1() - ref = ["), "]", fileInfo.ref));
                    printDebugLogger(AbstractC0541b.m767i(iIntValue, "bind1() - id = [", "]"));
                } else {
                    throw new IOException("bind1() - srcParent or destParent can not be null.");
                }
            } else {
                Integer num = this.mCrcIdMap.get(Long.valueOf(crc));
                FileInfo fileInfo2 = this.mIdInfoMap.get(num);
                fileInfo2.ref++;
                this.mIdInfoMap.put(num, fileInfo2);
                iIntValue = num.intValue();
                printDebugLogger(AbstractC2821a.m2223n(new StringBuilder("bind1() - ref = ["), "]", fileInfo2.ref));
                printDebugLogger(AbstractC0541b.m767i(iIntValue, "bind1() - id = [", "]"));
            }
            this.mIsChanged = true;
            printDebugLogger("bind1() end ");
            return iIntValue;
        }
        throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("bind1() - File not exist. [")));
    }
}
