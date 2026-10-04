package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.C10065b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.repository.pdfwriter.PDFWriterRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p005A3.C0016a;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwFileManager {
    public static final String KEY_FILE_NAME_BY_MYFILES = "key_filename";
    private static final int MAX_CACHE_COUNT = 5;
    private static final String MEDIA_AUTHORITY = "0@media";
    private static final String TAG = Logger.createTag("PwFileManager");
    public static final String URI_FILE_PROVIDER_MYFILES = "content://com.sec.android.app.myfiles.FileProvider/";
    public static final String URI_ONEDRIVE = "/cache/tempDownload/ONE_DRIVE_";
    private ThreadPoolExecutor mThreadPoolExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CacheInfo {
        private final File mCacheFile;
        private final String mOriginPdfFilePath;
        private final String mUuid;

        public CacheInfo(String str, String str2, File file) {
            this.mUuid = str;
            this.mOriginPdfFilePath = str2;
            this.mCacheFile = file;
        }

        public File getCacheFile() {
            return this.mCacheFile;
        }

        public String getOriginPdfFilePath() {
            return this.mOriginPdfFilePath;
        }

        public String getUuid() {
            return this.mUuid;
        }
    }

    private void deleteCacheFile(File file, String str, boolean z) {
        RunnableC10960a runnableC10960a = new RunnableC10960a(file, str, 0);
        if (z) {
            getThreadPoolExecutor().execute(runnableC10960a);
        } else {
            runnableC10960a.run();
        }
    }

    private void fillInfo(Context context, Uri uri, String[] strArr, PdfFileInfo pdfFileInfo) {
        if (strArr == null) {
            return;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
            try {
                if (cursorQuery == null) {
                    Logger.m11000e(TAG, "fillInfo# cursor is null");
                    if (cursorQuery == null) {
                        return;
                    }
                } else {
                    cursorQuery.moveToFirst();
                    int columnIndex = cursorQuery.getColumnIndex(strArr[0]);
                    String string = columnIndex > -1 ? cursorQuery.getString(columnIndex) : null;
                    if (!TextUtils.isEmpty(string)) {
                        if (pdfFileInfo.isSaveAs()) {
                            pdfFileInfo.setName(string);
                        } else {
                            pdfFileInfo.setPath(string);
                        }
                    }
                }
                cursorQuery.close();
            } finally {
            }
        } catch (Exception e) {
            AbstractC8014b.m7207i("fillInfo# e = ", e, TAG);
        }
    }

    private PdfFileInfo getFileInfoAfterSEP115(Context context, Uri uri) throws Throwable {
        Exception exc;
        Throwable th;
        Exception exc2;
        PdfFileInfo pdfFileInfo = null;
        try {
            if (DeviceInfo.getSemPlatformVersionInt(0) < 110500) {
                return null;
            }
            String str = "";
            if (MEDIA_AUTHORITY.equals(uri.getAuthority())) {
                try {
                    Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data", "_display_name"}, null, null, null, null);
                    try {
                        if (cursorQuery == null) {
                            Logger.m11000e(TAG, "MEDIA_AUTHORITY : cursor is null");
                            if (cursorQuery == null) {
                                return null;
                            }
                            cursorQuery.close();
                            return null;
                        }
                        cursorQuery.moveToFirst();
                        PdfFileInfo pdfFileInfo2 = new PdfFileInfo();
                        try {
                            int columnIndex = cursorQuery.getColumnIndex("_data");
                            int columnIndex2 = cursorQuery.getColumnIndex("_display_name");
                            String string = columnIndex2 >= 0 ? cursorQuery.getString(columnIndex2) : "";
                            String string2 = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : "";
                            if (string == null) {
                                string = "";
                            }
                            pdfFileInfo2.setName(string);
                            if (string2 != null) {
                                str = string2;
                            }
                            pdfFileInfo2.setPath(str);
                            pdfFileInfo2.setSaveAs(false);
                            try {
                                cursorQuery.close();
                                return pdfFileInfo2;
                            } catch (Exception e) {
                                exc2 = e;
                                pdfFileInfo = pdfFileInfo2;
                                AbstractC8014b.m7207i("getFileInfoAfterSEP115# MEDIA_AUTHORITY : e = ", exc2, TAG);
                                return pdfFileInfo;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            pdfFileInfo = pdfFileInfo2;
                            Throwable th3 = th;
                            if (cursorQuery == null) {
                                throw th3;
                            }
                            try {
                                cursorQuery.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                            AbstractC8014b.m7207i("getFileInfoAfterSEP115# MEDIA_AUTHORITY : e = ", exc2, TAG);
                            return pdfFileInfo;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e2) {
                    exc2 = e2;
                }
            } else {
                if (!UriFileUtils.MY_FILES_PROVIDER.equals(uri.getAuthority()) || uri.toString().contains(URI_ONEDRIVE)) {
                    return null;
                }
                try {
                    Cursor cursorQuery2 = context.getContentResolver().query(uri, new String[]{"_display_name", "_path"}, null, null, null);
                    try {
                        if (cursorQuery2 == null) {
                            Logger.m11000e(TAG, "MY_FILES_PROVIDER : cursor is null");
                            if (cursorQuery2 == null) {
                                return null;
                            }
                            cursorQuery2.close();
                            return null;
                        }
                        int columnIndex3 = cursorQuery2.getColumnIndex("_display_name");
                        int columnIndex4 = cursorQuery2.getColumnIndex("_path");
                        cursorQuery2.moveToFirst();
                        PdfFileInfo pdfFileInfo3 = new PdfFileInfo();
                        try {
                            String string3 = cursorQuery2.getString(columnIndex3);
                            String string4 = cursorQuery2.getString(columnIndex4);
                            if (string3 == null) {
                                string3 = "";
                            }
                            pdfFileInfo3.setName(string3);
                            if (string4 != null) {
                                str = string4;
                            }
                            pdfFileInfo3.setPath(str);
                            pdfFileInfo3.setSaveAs(false);
                            try {
                                cursorQuery2.close();
                                return pdfFileInfo3;
                            } catch (Exception e3) {
                                exc = e3;
                                pdfFileInfo = pdfFileInfo3;
                                AbstractC8014b.m7207i("getFileInfoAfterSEP115# MY_FILES_PROVIDER : e = ", exc, TAG);
                                return pdfFileInfo;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            pdfFileInfo = pdfFileInfo3;
                            if (cursorQuery2 == null) {
                                throw th;
                            }
                            try {
                                cursorQuery2.close();
                                throw th;
                            } catch (Throwable th7) {
                                th.addSuppressed(th7);
                                throw th;
                            }
                            AbstractC8014b.m7207i("getFileInfoAfterSEP115# MY_FILES_PROVIDER : e = ", exc, TAG);
                            return pdfFileInfo;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (Exception e5) {
                    exc = e5;
                }
            }
            return pdfFileInfo;
        } catch (NoSuchFieldError e6) {
            Logger.m11000e(TAG, "getFileInfoAfterSEP115# " + e6.getMessage());
            return null;
        }
    }

    private PdfFileInfo getFileInfoFromContentProvider(Context context, Uri uri, String str) {
        String[] strArr;
        PdfFileInfo pdfFileInfo = new PdfFileInfo();
        try {
            String string = uri.toString();
            if (string.startsWith(UriFileUtils.URI_SUFFIX_EVERNOTE)) {
                strArr = new String[]{UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME};
            } else {
                if (string.contains(UriFileUtils.URI_CHROME_DOWNLOAD)) {
                    pdfFileInfo.setName(uri.getLastPathSegment() + Constants.PDF_EXTENSION_WITH_DOT);
                } else if (string.startsWith(UriFileUtils.URI_SUFFIX_ONENOTE)) {
                    pdfFileInfo.setName(string.substring(48) + Constants.PDF_EXTENSION_WITH_DOT);
                } else if (string.startsWith(UriFileUtils.URI_SUFFIX_OPTICAL_READER)) {
                    pdfFileInfo.setSaveAs(false);
                    pdfFileInfo.setPath(string.substring(54));
                } else if (string.contains(UriFileUtils.URI_PART_OF_MEDIA_EXTERNAL) || string.contains(UriFileUtils.URI_PART_OF_MEDIA_EXTERNAL_PRIMARY)) {
                    strArr = new String[]{"_data"};
                    pdfFileInfo.setSaveAs(false);
                } else if (string.startsWith(UriFileUtils.URI_SUFFIX_MESSAGE)) {
                    strArr = new String[]{"_display_name"};
                    pdfFileInfo.setSaveAs(false);
                } else if (string.contains(URI_ONEDRIVE)) {
                    strArr = new String[]{"_display_name"};
                } else if (string.startsWith(URI_FILE_PROVIDER_MYFILES)) {
                    pdfFileInfo.setSaveAs(false);
                    pdfFileInfo.setPath(str);
                    if (string.contains("content://com.sec.android.app.myfiles.FileProvider/external")) {
                        pdfFileInfo.setPath(uri.getPath().replace("external", BundleContract.STORAGE));
                    }
                } else if (string.startsWith(UriFileUtils.URI_SUFFIX_ASTRO)) {
                    pdfFileInfo.setSaveAs(false);
                    pdfFileInfo.setPath(string.substring(43));
                } else {
                    strArr = new String[]{"_display_name"};
                }
                strArr = null;
            }
            fillInfo(context, uri, strArr, pdfFileInfo);
            return pdfFileInfo;
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("getFileInfoFromContentProvider# "), TAG);
            return pdfFileInfo;
        }
    }

    private ThreadPoolExecutor getThreadPoolExecutor() {
        if (this.mThreadPoolExecutor == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 50L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            this.mThreadPoolExecutor = threadPoolExecutor;
            threadPoolExecutor.setThreadFactory(new SenlThreadFactory(TAG));
        }
        return this.mThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteCacheFile$4(File file, String str) {
        try {
            boolean zDeleteFile = FileUtils.deleteFile(file);
            Logger.m11002f(TAG, "deleteCacheFile, uuid : " + str + ", delete : " + zDeleteFile + ", path: " + Logger.getEncode(file.getPath()) + ", backtrace: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("deleteCacheFile# "), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteUnexpectedFile$3(String str, File file, String str2) {
        return str2.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getValidCacheFiles$0(File file, String str) {
        return str.endsWith(".sdocx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortDescByTime$2(CacheInfo cacheInfo, CacheInfo cacheInfo2) {
        return (int) (cacheInfo2.getCacheFile().lastModified() - cacheInfo.getCacheFile().lastModified());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$trimDummy$1(File file, String str) {
        return str.endsWith(".sdocx") || str.endsWith(".dat");
    }

    private void sortDescByTime(List<CacheInfo> list) {
        list.sort(new C0016a(10));
    }

    private void trimDummy(File file) {
        File[] fileArrListFiles = file.listFiles(new C0035a(11));
        if (fileArrListFiles == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (File file2 : fileArrListFiles) {
            hashSet.add(FileUtils.extractFileName(file2.getName()));
        }
        PDFWriterRepositoryFactory.createPDFWriterRepository().trimDummy(hashSet);
    }

    public void deleteCache(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            deleteCacheInfo(str2);
            deleteCacheFile(file, str2, true);
        }
    }

    public void deleteCacheInfo(String str) {
        PDFWriterRepositoryFactory.createPDFWriterRepository().delete(str);
    }

    public void deleteUnexpectedFile(String str, String str2) {
        String str3 = File.separator;
        File file = new File(str.substring(0, str.lastIndexOf(str3)));
        String[] list = file.list(new C10065b(str2, 1));
        if (list == null || list.length == 0) {
            return;
        }
        File file2 = new File(file, AbstractC0541b.m776r(new StringBuilder(), list[0], str3, str2, ".dat"));
        if (file2.exists()) {
            Logger.m10999d(TAG, "deleteUnexpectedFile# dat");
            file2.delete();
            return;
        }
        File file3 = new File(file, list[0]);
        if (file3.exists()) {
            Logger.m10999d(TAG, "deleteUnexpectedFile# delete savedFile");
            deleteCacheFile(file3, str2, true);
        }
    }

    public List<CacheInfo> getDeleteTargetList(List<CacheInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() >= 5) {
            sortDescByTime(list);
            for (int i = 5; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public File getDirectory(Context context) {
        File file = new File(DocumentCacheUtils.getPDFWriterCacheFolder(context));
        if (file.exists() || file.mkdir()) {
            return file;
        }
        return null;
    }

    public PdfFileInfo getPdfFileInfo(Context context, Uri uri, String str) throws Throwable {
        PdfFileInfo fileInfoAfterSEP115 = getFileInfoAfterSEP115(context, uri);
        if (fileInfoAfterSEP115 != null) {
            if (!fileInfoAfterSEP115.getName().isEmpty() || !fileInfoAfterSEP115.getPath().isEmpty()) {
                return fileInfoAfterSEP115;
            }
            fileInfoAfterSEP115 = null;
        }
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            fileInfoAfterSEP115 = new PdfFileInfo();
            fileInfoAfterSEP115.setPath(uri.getPath());
            fileInfoAfterSEP115.setSaveAs(false);
        } else if ("content".equals(scheme)) {
            fileInfoAfterSEP115 = getFileInfoFromContentProvider(context, uri, str);
        }
        setNameFromPathWhenEmptyName(fileInfoAfterSEP115);
        return fileInfoAfterSEP115;
    }

    public String getSavePath(Context context, String str) {
        File directory = getDirectory(context);
        if (directory == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(directory.getAbsolutePath());
        return AbstractC0622a.m1170p(File.separator, str, sb);
    }

    public void getValidCacheFiles(@NonNull Context context, boolean z) {
        getValidCacheFiles(context, z, null);
    }

    public void setNameFromPathWhenEmptyName(PdfFileInfo pdfFileInfo) {
        if (pdfFileInfo == null || !pdfFileInfo.getName().isEmpty() || pdfFileInfo.getPath().isEmpty()) {
            return;
        }
        try {
            pdfFileInfo.setName(FileUtils.getFileNameFromFilePath(pdfFileInfo.getPath()));
        } catch (StringIndexOutOfBoundsException e) {
            Logger.m11000e(TAG, "getPdfFileInfo# error = " + e);
        }
    }

    @Nullable
    public List<CacheInfo> getValidCacheFiles(@NonNull Context context, boolean z, @Nullable Fragment fragment) {
        File directory = getDirectory(context);
        if (directory == null) {
            return null;
        }
        trimDummy(directory);
        File[] fileArrListFiles = directory.listFiles(new C0035a(10));
        if (fileArrListFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file : fileArrListFiles) {
            String strExtractFileName = FileUtils.extractFileName(file.getName());
            String filePath = PDFWriterRepositoryFactory.createPDFWriterRepository().getFilePath(strExtractFileName);
            if (!filePath.isEmpty()) {
                String str = TAG;
                StringBuilder sbM15l = AbstractC0000a.m15l("getValidCacheFiles# uuid: ", strExtractFileName, ", filePath: ");
                sbM15l.append(Logger.getEncode(filePath));
                sbM15l.append(", modifiedTime: ");
                sbM15l.append(file.lastModified());
                Logger.m10999d(str, sbM15l.toString());
                arrayList.add(new CacheInfo(strExtractFileName, filePath, file));
            } else if (!ComposerManager.getInstance().isOpen(strExtractFileName, fragment)) {
                deleteCacheFile(file, strExtractFileName, z);
            }
        }
        return arrayList;
    }
}
