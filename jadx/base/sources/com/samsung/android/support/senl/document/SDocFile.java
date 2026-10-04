package com.samsung.android.support.senl.document;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.document.component.SDocEndTag;
import com.samsung.android.support.senl.document.data.ReminderData;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class SDocFile {
    private static final String CACHE_SIZE_FILE = "size.dat";
    private static final int CACHE_STATE_EDIT = 1;
    private static final String CACHE_STATE_FILE = "state.dat";
    private static final int CACHE_STATE_NONE = 0;
    private static final int CACHE_STATE_OPEN = 2;
    private static final int DEFAULT_CACHE_LIMIT_COUNT = 3000;
    public static final int DEFAULT_CACHE_LIMIT_SIZE = 524288000;
    private static final int LIMIT_FILENAME_IN_CACHE_PATH = 128;
    private static final String ROOT_CACHE_DIRECTORY_NAME = "document";
    private static final String TAG = "SDocFile";

    public static void checkValidity(String str) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("checkValidity() - the file isn't exist. [")));
        }
        new SDocEndTag(null).parse(str, true);
    }

    public static String convertPathToHashedName(String str) {
        DocumentLogger.m7178d(TAG, " convertPathToHashedPath() - fileFullPath = [" + SDocUtil.logPath(str) + "]");
        if (str == null) {
            DocumentLogger.m7179e(TAG, " convertPathToHashedPath() - fileFullPath is invalid.");
            return null;
        }
        String strSubstring = str.substring(str.lastIndexOf(47) + 1, str.length());
        String str2 = Integer.toHexString(str.hashCode()) + Log.TAG_SEPARATOR;
        if (strSubstring.length() <= 128) {
            return AbstractC0541b.m756B(str2, strSubstring);
        }
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str2);
        sbM1324q.append(Integer.toHexString(strSubstring.hashCode()));
        sbM1324q.append("...");
        sbM1324q.append(strSubstring.substring(strSubstring.length() - 128, strSubstring.length()));
        return sbM1324q.toString();
    }

    public static void deleteCacheDirectory(Context context, String str) {
        DocumentLogger.m7178d(TAG, "deleteCacheDirectory() - fileFullPath = [" + SDocUtil.logPath(str) + "]");
        String strConvertPathToHashedName = convertPathToHashedName(str);
        if (strConvertPathToHashedName == null) {
            DocumentLogger.m7179e(TAG, "deleteCacheDirectory() - hash directory is null.");
            return;
        }
        String rootCacheDirectoryPath = getRootCacheDirectoryPath(context);
        if (rootCacheDirectoryPath == null) {
            DocumentLogger.m7179e(TAG, "deleteCacheDirectory() - cache directory is null.");
            return;
        }
        File file = new File(rootCacheDirectoryPath);
        if (!file.exists() || !file.isDirectory()) {
            DocumentLogger.m7178d(TAG, "deleteCacheDirectory() - root cache directory is invalid.");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            DocumentLogger.m7178d(TAG, "deleteCacheDirectory() - rootCacheDirFileList is null.");
            return;
        }
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            if (name.contains(strConvertPathToHashedName) && file2.isDirectory()) {
                DocumentLogger.m7178d(TAG, "deleteCacheDirectory() - delete [" + SDocUtil.logPath(name) + "]");
                FileUtil.deleteFile(file2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x004c A[EXC_TOP_SPLITTER, PHI: r5
      0x004c: PHI (r5v5 java.io.RandomAccessFile) = (r5v4 java.io.RandomAccessFile), (r5v6 java.io.RandomAccessFile) binds: [B:17:0x004a, B:22:0x006a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getCacheState(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        String strM756B = AbstractC0541b.m756B(str, "/state.dat");
        if (AbstractC2322a.m1607A(strM756B)) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(strM756B, InternalZipConstants.WRITE_MODE);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            }
            try {
                int i = randomAccessFile.readInt();
                try {
                    randomAccessFile.close();
                    return i;
                } catch (IOException unused3) {
                    DocumentLogger.m7179e(TAG, "setCacheState() - Fail close file.");
                    return i;
                }
            } catch (FileNotFoundException unused4) {
                randomAccessFile2 = randomAccessFile;
                DocumentLogger.m7179e(TAG, "setCacheState() - Fail to create raf!! [" + SDocUtil.logPath(strM756B) + "]");
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused5) {
                        DocumentLogger.m7179e(TAG, "setCacheState() - Fail close file.");
                    }
                }
                return 0;
            } catch (IOException unused6) {
                randomAccessFile2 = randomAccessFile;
                DocumentLogger.m7179e(TAG, "setCacheState() - Fail to writeInt()!! [" + SDocUtil.logPath(strM756B) + "]");
                if (randomAccessFile2 != null) {
                }
                return 0;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused7) {
                        DocumentLogger.m7179e(TAG, "setCacheState() - Fail close file.");
                    }
                }
                throw th;
            }
        }
        return 0;
    }

    public static long getCreatedTime(String str, boolean z) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("getCreatedTime() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, z);
        return sDocEndTag.getCreatedTime();
    }

    public static long getDirSize(File file) {
        long dirSize = 0;
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                DocumentLogger.m7179e(TAG, "getDirSize() - dirFileList is null.");
                return 0L;
            }
            for (File file2 : fileArrListFiles) {
                if (file2 != null) {
                    dirSize = (file2.isDirectory() ? getDirSize(file2) : file2.length()) + dirSize;
                }
            }
        }
        return dirSize;
    }

    public static int getDocumentType(String str) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("getDocumentType() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        return sDocEndTag.getDocumentType();
    }

    public static long getModifiedTime(String str, boolean z) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("getModifiedTime() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, z);
        return sDocEndTag.getModifiedTime();
    }

    public static ArrayList<ReminderData> getReminderData(String str) throws IOException {
        DocumentLogger.m7178d(TAG, "getReminderData()");
        if (!new File(str).exists()) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("getTitle() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        return sDocEndTag.getReminderData();
    }

    public static String getRootCacheDirectoryPath(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null || !filesDir.exists()) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + "/document";
    }

    public static String getTitle(String str, boolean z) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("getTitle() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, z);
        return sDocEndTag.getTitle();
    }

    public static long getUncompressedSize(String str) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("getUncompressedSize() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        return sDocEndTag.getUncompressedSize();
    }

    public static boolean hasSDocCache(Context context, String str, int i) throws IOException {
        if (context == null || str == null) {
            return false;
        }
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("hasCache() - the file isn't exist.[")));
        }
        String rootCacheDirectoryPath = getRootCacheDirectoryPath(context);
        if (rootCacheDirectoryPath == null) {
            throw new IOException("checkCacheDirectory() - rootCacheDirPath is invalid. [null]");
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(rootCacheDirectoryPath, "/");
        sbM781w.append(convertPathToHashedName(str));
        String string = sbM781w.toString();
        if (i > 0) {
            string = AbstractC2821a.m2218i(i, string, "_");
        }
        if (!new File(AbstractC0541b.m756B(string, "/endtag.dat")).exists()) {
            DocumentLogger.m7181i(TAG, "hasSDocCache() - cache directory does not exist.");
            return false;
        }
        SDocEndTag sDocEndTag = new SDocEndTag(string);
        sDocEndTag.readFile();
        SDocEndTag sDocEndTag2 = new SDocEndTag(null);
        sDocEndTag2.parse(str, true);
        if (sDocEndTag2.getModifiedTime() == sDocEndTag.getModifiedTime()) {
            DocumentLogger.m7181i(TAG, "hasSDocCache() - cache has same time.");
            return true;
        }
        DocumentLogger.m7181i(TAG, "hasSDocCache() - cache need update.");
        return false;
    }

    public static boolean hasUnsavedData(Context context, String str) {
        String strM757C = AbstractC0541b.m757C(getRootCacheDirectoryPath(context), "/", convertPathToHashedName(str));
        return AbstractC2322a.m1607A(strM757C) && getCacheState(strM757C) == 1;
    }

    public static boolean isEncrypted(String str) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("isEncrypted() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        return sDocEndTag.isEncrypted();
    }

    public static boolean isFavorite(String str) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("isFavorite() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        return sDocEndTag.isFavorite();
    }

    public static boolean isLocked(String str) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("isLocked() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        return sDocEndTag.getDocumentType() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveCacheSize(String str, long j) throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        IOException e;
        File file = new File(AbstractC0541b.m756B(str, "/size.dat"));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                DocumentLogger.m7179e(TAG, "saveCacheSize() " + e2.toString());
                return;
            }
        }
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                    try {
                        randomAccessFile.writeLong(j);
                        randomAccessFile.close();
                    } catch (IOException e3) {
                        e = e3;
                        DocumentLogger.m7179e(TAG, "saveCacheSize() " + e.toString());
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                            DocumentLogger.m7179e(TAG, "saveCacheSize() - Fail close file.");
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                randomAccessFile = null;
                e = e5;
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
                if (randomAccessFile != null) {
                }
                throw th;
            }
        } catch (IOException unused2) {
            DocumentLogger.m7179e(TAG, "saveCacheSize() - Fail close file.");
        }
    }

    public static void setReminderData(String str, ArrayList<ReminderData> arrayList) throws IOException {
        DocumentLogger.m7178d(TAG, "setReminderData()");
        if (!new File(str).exists()) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("getTitle() - the file isn't exist.[")));
        }
        SDocEndTag sDocEndTag = new SDocEndTag(null);
        sDocEndTag.parse(str, true);
        sDocEndTag.setReminderData(arrayList);
        sDocEndTag.setCreatedTime(sDocEndTag.getCreatedTime());
        sDocEndTag.setModifiedTime(sDocEndTag.getModifiedTime());
        sDocEndTag.update(str);
    }

    private static HashMap<String, Date> sortByComparator(HashMap<String, Date> map) {
        LinkedList<Map.Entry> linkedList = new LinkedList(map.entrySet());
        Collections.sort(linkedList, new Comparator<Map.Entry<String, Date>>() { // from class: com.samsung.android.support.senl.document.SDocFile.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, Date> entry, Map.Entry<String, Date> entry2) {
                return entry.getValue().compareTo(entry2.getValue());
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedList) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static void trimCache(Context context, int i) throws Throwable {
        trimCache(context, i, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0183 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void trimCache(Context context, int i, ArrayList<String> arrayList) throws Throwable {
        String str;
        File[] fileArr;
        int i2;
        int i4;
        RandomAccessFile randomAccessFile;
        long dirSize;
        DocumentLogger.m7178d(TAG, "trimCache() start");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        String rootCacheDirectoryPath = getRootCacheDirectoryPath(context);
        if (rootCacheDirectoryPath == null) {
            DocumentLogger.m7179e(TAG, "trimCache() - cache directory is null.");
            return;
        }
        File file = new File(rootCacheDirectoryPath);
        if (!file.isDirectory()) {
            DocumentLogger.m7179e(TAG, "trimCache() - cache directory is invalid.");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            DocumentLogger.m7179e(TAG, "trimCache() - topDirFileList is null.");
            return;
        }
        int length = fileArrListFiles.length;
        int i5 = 0;
        long jLongValue = 0;
        while (i5 < length) {
            File file2 = fileArrListFiles[i5];
            if (file2.isDirectory()) {
                if (file2.toString().lastIndexOf(".sdoc") == -1 && file2.toString().lastIndexOf(DiskFileUpload.postfix) == -1) {
                    DocumentLogger.m7178d(TAG, "trimCache() - [" + SDocUtil.logPath(file2.getName()) + "] is not a cache directory");
                }
                String str2 = file2.toString() + "/size.dat";
                File[] fileArr2 = fileArrListFiles;
                i2 = length;
                Date date = new Date(file2.lastModified());
                File file3 = new File(str2);
                fileArr = fileArr2;
                i4 = i5;
                if (file3.exists()) {
                    try {
                        randomAccessFile = new RandomAccessFile(file3, "r");
                        str = rootCacheDirectoryPath;
                        try {
                            try {
                                dirSize = randomAccessFile.readLong();
                            } catch (Throwable th) {
                                th = th;
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException unused) {
                                        DocumentLogger.m7179e(TAG, "trimCache() - Fail close file.");
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e) {
                            e = e;
                            dirSize = 0;
                        }
                        try {
                            DocumentLogger.m7178d(TAG, "trimCache() - child file [" + SDocUtil.logPath(file2.getName()) + "] size = " + dirSize);
                        } catch (IOException e2) {
                            e = e2;
                            DocumentLogger.m7179e(TAG, "trimCache() - " + e.toString());
                            if (randomAccessFile != null) {
                            }
                            map.put(file2.toString(), Long.valueOf(dirSize));
                            map2.put(file2.toString(), date);
                            jLongValue += dirSize;
                            if (AppDelegator.getInstance().isAllActivityFinished()) {
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        str = rootCacheDirectoryPath;
                        dirSize = 0;
                        randomAccessFile = null;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = null;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                        DocumentLogger.m7179e(TAG, "trimCache() - Fail close file.");
                    }
                } else {
                    str = rootCacheDirectoryPath;
                    dirSize = getDirSize(file2);
                    saveCacheSize(file2.toString(), dirSize);
                    DocumentLogger.m7178d(TAG, "trimCache() - child file [" + SDocUtil.logPath(file2.getName()) + "] size = " + dirSize);
                }
                map.put(file2.toString(), Long.valueOf(dirSize));
                map2.put(file2.toString(), date);
                jLongValue += dirSize;
                if (AppDelegator.getInstance().isAllActivityFinished()) {
                    DocumentLogger.m7179e(TAG, "trimCache() - stop trimCache.");
                    return;
                }
            } else {
                str = rootCacheDirectoryPath;
                fileArr = fileArrListFiles;
                i2 = length;
                i4 = i5;
            }
            i5 = i4 + 1;
            length = i2;
            fileArrListFiles = fileArr;
            rootCacheDirectoryPath = str;
        }
        String str3 = rootCacheDirectoryPath;
        DocumentLogger.m7178d(TAG, "trimCache() - Total Cache count [" + map2.size() + "], size [" + jLongValue + "]");
        if (jLongValue <= i && map2.size() <= 3000) {
            DocumentLogger.m7178d(TAG, "trimCache() end.");
            return;
        }
        HashMap<String, Date> mapSortByComparator = sortByComparator(map2);
        if (arrayList != null) {
            String strConcat = str3.concat("/");
            for (String str4 : arrayList) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q(strConcat);
                sbM1324q.append(convertPathToHashedName(str4));
                String string = sbM1324q.toString();
                if (string == null) {
                    DocumentLogger.m7179e(TAG, "trimCache() - can not convert ignore file path.");
                } else {
                    StringBuilder sbM1324q2 = AbstractC1974b.m1324q(string.concat("_"));
                    sbM1324q2.append(AppDelegator.getInstance().getDocInitModeAppWidget());
                    mapSortByComparator.remove(sbM1324q2.toString());
                }
            }
        }
        DocumentLogger.m7178d(TAG, "trimCache() - cache map size = " + mapSortByComparator.size());
        int size = mapSortByComparator.size();
        for (Map.Entry<String, Date> entry : mapSortByComparator.entrySet()) {
            if (!AppDelegator.getInstance().isAllActivityFinished()) {
                DocumentLogger.m7179e(TAG, "trimCache() - stop trimCache.");
                return;
            }
            String key = entry.getKey();
            File file4 = new File(key);
            if (file4.exists() && getCacheState(file4.toString()) == 0) {
                try {
                    FileUtil.deleteFile(file4);
                    size--;
                } catch (IOException unused3) {
                    DocumentLogger.m7179e(TAG, "trimCache() - Fail to delete cache directory.");
                }
                DocumentLogger.m7178d(TAG, "trimCache() - Delete - [" + SDocUtil.logPath(key) + "]");
                jLongValue -= ((Long) map.get(key)).longValue();
                if (jLongValue < ((int) (((double) i) * 0.8d)) && size <= 3000) {
                    break;
                }
            } else {
                DocumentLogger.m7178d(TAG, "trimCache() - No cache directory or cache is using - [" + SDocUtil.logPath(key) + "]");
            }
        }
        DocumentLogger.m7178d(TAG, "trimCache() end. Remain Cache count [" + size + "], size [" + jLongValue + "]");
    }

    public static long getCreatedTime(String str) {
        return getCreatedTime(str, true);
    }

    public static long getModifiedTime(String str) {
        return getModifiedTime(str, true);
    }

    public static String getTitle(String str) {
        return getTitle(str, true);
    }

    public static boolean hasSDocCache(Context context, String str) {
        return hasSDocCache(context, str, 0);
    }
}
