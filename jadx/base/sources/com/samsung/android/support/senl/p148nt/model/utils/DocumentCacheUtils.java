package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.WritingMode;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentCacheUtils {
    private static final int DELETE_DUMMY_CACHE_DIR_UNIT = 1;
    private static final String TAG = ModelLogger.createTag("DocumentCacheUtils");

    public static void deleteDocumentDat(@NonNull Context context, @NonNull String str) {
        DataLogger.m12307i(TAG, "deleteDocumentDat, uuid : " + str);
        deleteDocumentDat(getCacheFolder(context), str);
    }

    public static void deletePDFWriterCacheDat(@NonNull Context context, @NonNull String str) {
        DataLogger.m12307i(TAG, "deletePDFWritingCacheDat, uuid : " + str);
        deleteDocumentDat(getPDFWriterCacheFolder(context), str);
    }

    public static boolean existAnyCacheFiles(@NonNull Context context) {
        DataLogger.m12302d(TAG, "existAnyCacheFiles");
        return existCacheFiles(getCacheFolderFile(context));
    }

    public static boolean existAnyPDFWriterCacheFiles(@NonNull Context context) {
        DataLogger.m12302d(TAG, "existAnyPDFWriterCacheFiles");
        return existCacheFiles(getPDFWriterCacheFolderFile(context));
    }

    private static boolean existCacheFiles(File file) {
        File[] fileArrListFiles = file.listFiles(new C0035a(15));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            DataLogger.m12302d(TAG, "existCacheFiles, cache dir is not exist.");
            return false;
        }
        DataLogger.m12302d(TAG, "existCacheFiles, exist!!");
        return true;
    }

    public static int getCacheCount(@NonNull Context context, @WritingMode int i) {
        File[] fileArrListFiles = (i == 0 ? getCacheFolderFile(context) : getPDFWriterCacheFolderFile(context)).listFiles(new C0035a(16));
        if (fileArrListFiles == null) {
            return 0;
        }
        return fileArrListFiles.length;
    }

    public static String getCacheFolder(@NonNull Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir());
        String strM1170p = AbstractC0622a.m1170p(File.separator, DocumentServiceConstants.Cache.CACHE_DIR, sb);
        DataLogger.m12302d(TAG, "getCacheFolder, path : " + DataLogger.getEncode(strM1170p));
        return strM1170p;
    }

    public static File getCacheFolderFile(@NonNull Context context) {
        return new File(getCacheFolder(context));
    }

    public static String getCachePath(@NonNull Context context, @NonNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getCacheFolder(context));
        String strM1626p = AbstractC2322a.m1626p(sb, File.separator, str, ".dat");
        DataLogger.m12302d(TAG, "getCacheFile, path : " + DataLogger.getEncode(strM1626p));
        return strM1626p;
    }

    @NonNull
    public static String getConvertedCacheFolderPath(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir());
        String strM1170p = AbstractC0622a.m1170p(File.separator, "converted", sb);
        File file = new File(strM1170p);
        if (file.exists() || file.mkdir()) {
            return strM1170p;
        }
        DataLogger.m12303e(TAG, "getConvertedCacheFolderPath, the directory was not created.");
        return "";
    }

    public static String getFileName(String str, boolean z) {
        return !z ? str.substring(str.lastIndexOf(File.separator) + 1, str.lastIndexOf(46)) : str.substring(str.lastIndexOf(File.separator) + 1);
    }

    public static String getPDFWriterCacheFolder(@NonNull Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir());
        String strM1170p = AbstractC0622a.m1170p(File.separator, DocumentServiceConstants.Cache.CACHE_DIR_PDF_WRITIER, sb);
        DataLogger.m12302d(TAG, "getPDFWriterCacheFolder, path : " + DataLogger.getEncode(strM1170p));
        return strM1170p;
    }

    public static File getPDFWriterCacheFolderFile(@NonNull Context context) {
        return new File(getPDFWriterCacheFolder(context));
    }

    public static String getPDFWriterCachePath(@NonNull Context context, @NonNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPDFWriterCacheFolder(context));
        String strM1626p = AbstractC2322a.m1626p(sb, File.separator, str, ".dat");
        DataLogger.m12302d(TAG, "getPDFWriterCachePath, path : " + DataLogger.getEncode(strM1626p));
        return strM1626p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$existCacheFiles$0(File file, String str) {
        return str.endsWith(".dat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getCacheCount$1(File file, String str) {
        return str.endsWith(".dat");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x002d: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:46), block:B:10:0x002d */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readFile(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        byte[] bArr;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    bArr = new byte[(int) file.length()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        if (fileInputStream.read(bArr) == -1) {
                            DataLogger.m12303e(TAG, "there is no more data because the end of the file has been reached.");
                        }
                        if (file.delete()) {
                            DataLogger.m12307i(TAG, "delete cache file after load, path: " + DataLogger.getEncode(file.getPath()));
                        } else {
                            DataLogger.m12303e(TAG, "Fail to delete readFile.");
                        }
                        fileInputStream3 = fileInputStream;
                    } catch (IOException e) {
                        e = e;
                        DataLogger.m12304e(TAG, "readFile", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                DataLogger.m12304e(TAG, "readFile", e2);
                            }
                        }
                        return null;
                    }
                } else {
                    bArr = null;
                }
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        return bArr;
                    } catch (IOException e3) {
                        DataLogger.m12304e(TAG, "readFile", e3);
                    }
                }
                return bArr;
            } catch (Throwable th) {
                th = th;
                fileInputStream3 = fileInputStream2;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e5) {
                        DataLogger.m12304e(TAG, "readFile", e5);
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream3 != null) {
            }
            throw th;
        }
    }

    public static <T extends Parcelable> T readParcelableFromFile(String str, ClassLoader classLoader) throws Throwable {
        byte[] file = readFile(str);
        if (file == null || file.length == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(file, 0, file.length);
            parcelObtain.setDataPosition(0);
            return (T) parcelObtain.readParcelable(classLoader);
        } catch (Exception e) {
            DataLogger.m12304e(TAG, "readParcelableFromFile", e);
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public static void removeDummyCacheDirectories(@NonNull Context context) {
        String str = TAG;
        DataLogger.m12308p(str, "removeDummyCacheDirectories, start");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SpenWNoteFile.removeCacheDirectory(context, 1);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (jCurrentTimeMillis2 > 1000) {
                DataLogger.m12305f(str, "removeDummyCacheDirectories, duration : " + jCurrentTimeMillis2 + "ms");
                return;
            }
            DataLogger.m12308p(str, "removeDummyCacheDirectories, end : " + jCurrentTimeMillis2 + "ms");
        } catch (RuntimeException e) {
            DataLogger.m12306f(TAG, "removeDummyCacheDirectories, e: ", e);
        }
    }

    public static boolean saveCache(String str, Parcelable parcelable) {
        DataLogger.m12307i(TAG, "saveCache, path: " + DataLogger.getEncode(str));
        return writeFile(str, parcelable);
    }

    public static File saveDocumentDat(@NonNull Context context, @NonNull String str, @NonNull Parcelable parcelable) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir());
        return saveDocumentDat(new File(AbstractC0622a.m1170p(File.separator, DocumentServiceConstants.Cache.CACHE_DIR, sb)), str, parcelable);
    }

    public static File savePDFWriterCacheDat(@NonNull Context context, @NonNull String str, @NonNull Parcelable parcelable) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir());
        return saveDocumentDat(new File(AbstractC0622a.m1170p(File.separator, DocumentServiceConstants.Cache.CACHE_DIR_PDF_WRITIER, sb)), str, parcelable);
    }

    public static void stopTrimCache(@NonNull Context context) {
        if (SpenSdkInitializer.initialize(context.getApplicationContext())) {
            if (!SpenSDocFile.isTrimmingCache()) {
                DataLogger.m12302d(TAG, "stopTrimCache, isTrimmingCache : false");
                return;
            }
            DataLogger.m12302d(TAG, "stopTrimCache");
            SpenSDocFile.stopTrimCache();
            while (SpenSDocFile.isTrimmingCache()) {
                try {
                    DataLogger.m12302d(TAG, "stopTrimCache waiting");
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    DataLogger.m12303e(TAG, "stopTrimCache, e : " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static boolean writeFile(String str, Parcelable parcelable) throws Throwable {
        FileOutputStream fileOutputStream;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeParcelable(parcelable, 0);
        parcelObtain.setDataPosition(0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists() && !file.delete()) {
                    DataLogger.m12303e(TAG, "Fail to delete readFile.");
                }
                if (!file.createNewFile()) {
                    DataLogger.m12303e(TAG, "File already exists.");
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArrMarshall);
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e2) {
                DataLogger.m12304e(TAG, "createFile", e2);
                return true;
            }
        } catch (IOException e3) {
            fileOutputStream2 = fileOutputStream;
            e = e3;
            DataLogger.m12304e(TAG, "createFile", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    DataLogger.m12304e(TAG, "createFile", e5);
                }
            }
            return false;
        } catch (Throwable th2) {
            fileOutputStream2 = fileOutputStream;
            th = th2;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    DataLogger.m12304e(TAG, "createFile", e6);
                }
            }
            throw th;
        }
    }

    private static void deleteDocumentDat(String str, @NonNull String str2) {
        File file = new File(str);
        if (!file.exists() && !file.mkdir()) {
            DataLogger.m12303e(TAG, "deleteDocumentDat, the directory was not created.");
            return;
        }
        File file2 = new File(AbstractC0541b.m756B(AbstractC0622a.m1170p(File.separator, str2, AbstractC1974b.m1324q(str)), ".dat"));
        if (file2.exists()) {
            if (file2.delete()) {
                DataLogger.m12307i(TAG, "deleteDocumentDat, success: " + DataLogger.getEncode(file2.getPath()));
                return;
            }
            DataLogger.m12303e(TAG, "deleteDocumentDat, fail: " + DataLogger.getEncode(file2.getPath()));
        }
    }

    private static File saveDocumentDat(File file, @NonNull String str, @NonNull Parcelable parcelable) {
        if (!file.exists() && !file.mkdir()) {
            DataLogger.m12303e(TAG, "saveDocumentDat, the directory was not created.");
        }
        File file2 = new File(file, AbstractC0541b.m756B(str, ".dat"));
        String str2 = TAG;
        DataLogger.m12307i(str2, "saveDocumentDat, path: " + DataLogger.getEncode(file2.getCanonicalPath()));
        AbstractC11014a.m12335t("saveDocumentDat, dat file creation success : ", str2, saveCache(file2.getCanonicalPath(), parcelable));
        return file2;
    }
}
