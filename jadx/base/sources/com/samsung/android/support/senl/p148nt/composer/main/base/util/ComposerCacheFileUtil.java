package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.data.repository.pdfwriter.PDFWriterRepository;
import com.samsung.android.support.senl.p148nt.model.repository.pdfwriter.PDFWriterRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import p005A3.C0016a;
import p009B3.C0035a;
import p200l4.C13519a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerCacheFileUtil {
    public static final String ADD_TEXT_FOLDER_NAME = "addText";
    public static final String CONFLICT_TEMP_FOLDER_NAME = "conflict";
    public static final String CONVERTED_TEMP_FOLDER_NAME = "converted";
    public static final String DOCUMENT_SCAN_CACHE_FOLDER_NAME = "docScanCache";
    public static final String DOCUMENT_SCAN_FOLDER_NAME = "docScan";
    private static final int MAX_COUNT_PDFWRITER_MAINTAIN = 10;
    private static final int MAX_DAYS_PDFWRITER_MAINTAIN = 7;
    private static final int MAX_PAGE_THUMBNAIL_COUNT = 1500;
    public static final String MERGE_TEMP_FOLDER_NAME = "merge";
    public static final String PAGE_CACHE_INFO_DAT = "info.dat";
    public static final String PAGE_SEARCH_FOLDER_NAME = "pageSearch";
    public static final String PAINTING_FOLDER_NAME = "painting";
    public static final String RECENT_SEARCH_KEYWORD_DAT = "searchInfo.dat";
    public static final String SAVE_INSTANCES_FOLDER_NAME = "saveInstances";
    private static final String TAG = Logger.createTag("ComposerCacheFileUtil");

    public static void deleteNoteAppAttachFolder(Context context, String str) {
        File[] fileArrListFiles;
        File file = new File(PageCacheUtils.getRootCacheDirectoryPath(context));
        if (!file.exists() || (fileArrListFiles = file.listFiles(new C10065b(str, 0))) == null || fileArrListFiles.length == 0) {
            return;
        }
        File[] fileArrListFiles2 = fileArrListFiles[0].listFiles(new C0035a(9));
        if (fileArrListFiles2 != null) {
            for (File file2 : fileArrListFiles2) {
                try {
                    FileUtils.deleteFile(file2);
                } catch (IOException e) {
                    AbstractC8014b.m7204f(e, new StringBuilder("removeNoteAppAttachFolder# sub: "), TAG);
                }
            }
        }
        File[] fileArrListFiles3 = fileArrListFiles[0].listFiles();
        if (fileArrListFiles3 == null || fileArrListFiles3.length == 0) {
            try {
                FileUtils.deleteFile(fileArrListFiles[0]);
            } catch (IOException e2) {
                AbstractC8014b.m7204f(e2, new StringBuilder("removeNoteAppAttachFolder# dir: "), TAG);
            }
        }
    }

    private static boolean deleteThumbnailDir(File file) {
        try {
            FileUtils.deleteFile(file);
            return true;
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("trimPageThumbnail# "), TAG);
            return false;
        }
    }

    public static String getAddTextDir(Context context) {
        return getDir(context, ADD_TEXT_FOLDER_NAME);
    }

    private static File getCacheInfoData(File file, FilenameFilter filenameFilter) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    public static String getConflictTempDir(Context context) {
        return getDir(context, "conflict");
    }

    public static String getConvertedTempDir(Context context) {
        return getDir(context, "converted");
    }

    private static long getDayFromLast(long j, long j2) {
        return (j - j2) / 86400000;
    }

    private static String getDir(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            Logger.m11000e(TAG, "getDir# fail to get cacheDir");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir.getPath());
        File file = new File(AbstractC0622a.m1170p(File.separator, str, sb));
        if (file.exists() || file.mkdir()) {
            return file.getPath();
        }
        AbstractC8014b.m7198D("getDir# fail to get dir ", str, TAG);
        return null;
    }

    public static String getDocScanDir(Context context) {
        return getDir(context, DOCUMENT_SCAN_FOLDER_NAME);
    }

    public static String getMergeTempDir(Context context) {
        return getDir(context, "merge");
    }

    public static String getPageSearchDir(Context context) {
        return getDir(context, PAGE_SEARCH_FOLDER_NAME);
    }

    public static String getPaintingDir(Context context) {
        return getDir(context, PAINTING_FOLDER_NAME);
    }

    public static String getSaveInstancesFolderName(Context context) {
        return getDir(context, SAVE_INSTANCES_FOLDER_NAME);
    }

    public static String getScanDir(Context context) {
        return getDir(context, "docScanCache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteNoteAppAttachFolder$6(String str, File file, String str2) {
        return str2.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteNoteAppAttachFolder$7(File file, String str) {
        return !Constants.MAIN_THUMBNAIL_PATH.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$trimPageThumbnail$2(File file, String str) {
        return PAGE_CACHE_INFO_DAT.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long lambda$trimPageThumbnail$3(Pair pair) {
        return ((Long) pair.second).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$trimPageThumbnail$4(Pattern pattern, File file, String str) {
        if (PAGE_CACHE_INFO_DAT.equals(str) || Constants.MAIN_THUMBNAIL_PATH.equals(str) || RECENT_SEARCH_KEYWORD_DAT.equals(str)) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$trimPageThumbnail$5(File[] fileArr, Context context) {
        Logger.m11003i(TAG, "trimPageThumbnail# start");
        C0035a c0035a = new C0035a(8);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (File file : fileArr) {
            File cacheInfoData = getCacheInfoData(file, c0035a);
            if (cacheInfoData == null) {
                linkedList2.add(file);
            } else {
                linkedList.add(new Pair(file, Long.valueOf(cacheInfoData.lastModified())));
            }
        }
        try {
            linkedList.sort(Comparator.comparingLong(new C10064a()));
        } catch (Exception e) {
            Logger.m11003i(TAG, "trimPageThumbnail# ex " + e);
        }
        C13519a c13519a = new C13519a(Pattern.compile("[0-9]{3,5}"), 2);
        trimScreenSizeDir(context, linkedList, c13519a);
        trimAbnormalUuidDir(linkedList2, c13519a);
        Logger.m11003i(TAG, "trimPageThumbnail# end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$trimPdfWriterDir$0(File file, String str) {
        return str.endsWith(".sdocx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$trimPdfWriterDir$1(File file, File file2) {
        long jLastModified = file.lastModified() - file2.lastModified();
        if (jLastModified < 0) {
            return 1;
        }
        return jLastModified == 0 ? 0 : -1;
    }

    public static File makeConflictTempDir(Context context, String str) {
        String conflictTempDir = getConflictTempDir(context);
        if (conflictTempDir == null) {
            Logger.m11000e(TAG, "makeConflictTempDir# fail to make conflictFolderPath");
            return null;
        }
        File file = new File(AbstractC2322a.m1626p(AbstractC1974b.m1324q(conflictTempDir), File.separator, str, ".sdocx"));
        if (file.exists() || file.mkdir()) {
            return file;
        }
        Logger.m11000e(TAG, "makeConflictTempDir# fail to make dir");
        return null;
    }

    @Nullable
    public static File makeMergeTempDir(Context context, String str) {
        String mergeTempDir = getMergeTempDir(context);
        if (mergeTempDir == null) {
            Logger.m11000e(TAG, "makeMergeTempDir# fail to make conflictFolderPath");
            return null;
        }
        File file = new File(AbstractC2322a.m1626p(AbstractC1974b.m1324q(mergeTempDir), File.separator, str, ".sdocx"));
        if (file.exists() || file.mkdir()) {
            return file;
        }
        Logger.m11000e(TAG, "makeConflictTempDir# fail to make dir");
        return null;
    }

    private static void trimAbnormalUuidDir(List<File> list, FilenameFilter filenameFilter) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            File[] fileArrListFiles = it.next().listFiles(filenameFilter);
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    try {
                        FileUtils.deleteFile(file);
                    } catch (IOException e) {
                        AbstractC8014b.m7204f(e, new StringBuilder("trimPageThumbnail# fail to delete noCacheInfoDirs "), TAG);
                    }
                }
            }
        }
    }

    public static void trimCache(Context context) {
        String str = TAG;
        Logger.m10999d(str, "trimCache# start");
        long jCurrentTimeMillis = System.currentTimeMillis();
        String downloadDir = FileUtils.getDownloadDir(context);
        if (downloadDir != null) {
            trimDir(downloadDir, jCurrentTimeMillis, 1);
        }
        String pageSearchDir = getPageSearchDir(context);
        if (pageSearchDir != null) {
            trimDir(pageSearchDir, jCurrentTimeMillis, 7);
        }
        String paintingDir = getPaintingDir(context);
        if (paintingDir != null) {
            trimDir(paintingDir, jCurrentTimeMillis, 1);
        }
        trimPdfWriterDir(context, jCurrentTimeMillis);
        String docScanDir = getDocScanDir(context);
        if (docScanDir != null) {
            trimDir(docScanDir, jCurrentTimeMillis, 0);
        }
        String scanDir = getScanDir(context);
        if (scanDir != null) {
            trimDir(scanDir, jCurrentTimeMillis, 0);
        }
        String saveInstancesFolderName = getSaveInstancesFolderName(context);
        if (saveInstancesFolderName != null) {
            trimDir(saveInstancesFolderName, jCurrentTimeMillis, 7);
        }
        trimPageThumbnail(context);
        String conflictTempDir = getConflictTempDir(context);
        if (conflictTempDir != null) {
            trimDir(conflictTempDir, jCurrentTimeMillis, 1);
        }
        String convertedTempDir = getConvertedTempDir(context);
        if (convertedTempDir != null) {
            trimDir(convertedTempDir, jCurrentTimeMillis, 1);
        }
        Logger.m10999d(str, "trimCache# end");
    }

    private static void trimDir(String str, long j, int i) {
        File[] fileArrListFiles;
        if (str == null || (fileArrListFiles = new File(str).listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (getDayFromLast(j, file.lastModified()) >= i) {
                try {
                    FileUtils.deleteFile(file);
                } catch (IOException e) {
                    Logger.m11004w(TAG, e.getMessage());
                }
            }
        }
    }

    private static void trimPageThumbnail(Context context) {
        File[] fileArrListFiles;
        File file = new File(PageCacheUtils.getRootCacheDirectoryPath(context));
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            String str = TAG;
            Logger.m11003i(str, "trimPageThumbnail# execute");
            Executors.newSingleThreadExecutor(new SenlThreadFactory(str)).execute(new RunnableC9844c(fileArrListFiles, context, 15));
        }
    }

    private static void trimPdfWriterDir(Context context, long j) {
        File pDFWriterCacheFolderFile = DocumentCacheUtils.getPDFWriterCacheFolderFile(context);
        if (!pDFWriterCacheFolderFile.exists()) {
            if (pDFWriterCacheFolderFile.mkdirs()) {
                return;
            }
            Logger.m11000e(TAG, "trimPdfWriterDir(), fail to make a directory");
            return;
        }
        File[] fileArrListFiles = pDFWriterCacheFolderFile.listFiles(new C0035a(7));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        ArrayList<File> arrayList = new ArrayList(Arrays.asList(fileArrListFiles));
        arrayList.sort(new C0016a(9));
        PDFWriterRepository pDFWriterRepositoryCreatePDFWriterRepository = PDFWriterRepositoryFactory.createPDFWriterRepository();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (File file : arrayList) {
            if (i >= 10 || getDayFromLast(j, file.lastModified()) >= 7) {
                String strExtractFileName = FileUtils.extractFileName(file.getName());
                String filePath = pDFWriterRepositoryCreatePDFWriterRepository.getFilePath(strExtractFileName);
                pDFWriterRepositoryCreatePDFWriterRepository.delete(strExtractFileName);
                try {
                    FileUtils.deleteFile(file);
                    sb.append(" p: ");
                    sb.append(Logger.getEncode(filePath));
                } catch (IOException e) {
                    Logger.m11000e(TAG, "trimPdfWriterDir# p: " + Logger.getEncode(filePath) + " e: " + e.getMessage());
                }
            } else {
                i++;
            }
        }
        if (sb.toString().isEmpty()) {
            return;
        }
        String string = sb.toString();
        Logger.m11002f(TAG, "trimPdfWriterDir:" + string);
    }

    private static void trimScreenSizeDir(Context context, List<Pair<File, Long>> list, FilenameFilter filenameFilter) {
        String strValueOf = String.valueOf(SpenDocumentDisplayUtils.getScreenWidth(context));
        int iTrimThumbnailDir = 0;
        for (Pair<File, Long> pair : list) {
            File[] fileArrListFiles = ((File) pair.first).listFiles(filenameFilter);
            if (fileArrListFiles != null) {
                iTrimThumbnailDir = trimThumbnailDir(fileArrListFiles, iTrimThumbnailDir, strValueOf, ((File) pair.first).getName());
            }
        }
    }

    private static int trimThumbnailDir(File[] fileArr, int i, String str, String str2) {
        File[] fileArrListFiles;
        boolean z = false;
        for (File file : fileArr) {
            if (i < 1500 && file.getName().contains(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(file.getAbsolutePath());
                File file2 = new File(AbstractC0622a.m1170p(File.separator, "thumbnail", sb));
                if (file2.exists() && (fileArrListFiles = file2.listFiles()) != null) {
                    if (fileArrListFiles.length + i <= 1500) {
                        i += fileArrListFiles.length;
                    } else {
                        long length = (fileArrListFiles.length + i) - 1500;
                        for (int i2 = 0; i2 < length; i2++) {
                            FileUtils.deleteFile(fileArrListFiles[i2].getAbsolutePath());
                        }
                        if (length > 0) {
                            z = true;
                        }
                        i = 1500;
                    }
                }
            } else if (deleteThumbnailDir(file)) {
                z = true;
            }
        }
        if (z) {
            Logger.m11003i(TAG, "trimPageThumbnail# trim " + Logger.getEncode(str2));
        }
        return i;
    }
}
