package com.samsung.android.support.senl.p148nt.base.composer.clipboard;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ClipboardCacheManager {
    public static final String CLIPBOARD_BODY_TEXT_PREFIX = "clipdata_bodytext";
    public static final String CLIPBOARD_CONTENT_PREFIX = "clipdata_content";
    public static final String CLIPBOARD_HW_OBJECT_PREFIX = "clipdata_object";
    private static final int CLIPBOARD_MAX_DATA_COUNT = 20;
    public static final String CLIPBOARD_PAGE_PREFIX = "clipdata_page";
    private static final String TAG = Logger.createTag("CPLog$ClipboardCacheManager");
    private static CacheManagerDelegateImpl mCacheManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CacheManagerDefaultImpl implements CacheManagerDelegateImpl {
        @Override // com.samsung.android.support.senl.nt.base.composer.clipboard.ClipboardCacheManager.CacheManagerDelegateImpl
        public void trimCache(Context context) {
            ArrayList<File> clipDataFiles = ClipboardCacheManager.getClipDataFiles(context, true, true, false);
            if (clipDataFiles == null) {
                return;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(10, -72);
            ArrayList arrayList = new ArrayList();
            for (File file : clipDataFiles) {
                if (new Date(file.lastModified()).before(calendar.getTime())) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
            String absolutePath = ClipboardCacheManager.getClipboardPath(context).getAbsolutePath();
            for (File file2 : clipDataFiles) {
                if (arrayList.contains(file2.getAbsolutePath())) {
                    ClipboardCacheManager.deleteFileWithSDoc(file2, absolutePath);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CacheManagerDelegateImpl {
        void trimCache(Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CacheManagerSemImpl implements CacheManagerDelegateImpl {
        @Override // com.samsung.android.support.senl.nt.base.composer.clipboard.ClipboardCacheManager.CacheManagerDelegateImpl
        public void trimCache(Context context) {
            ArrayList<File> clipDataFiles = ClipboardCacheManager.getClipDataFiles(context, true, true, false);
            if (clipDataFiles == null) {
                return;
            }
            List<ClipData> clips = ClipboardManagerCompat.INSTANCE.getInstance().getClips(context);
            if (clips == null) {
                Logger.m8697d(ClipboardCacheManager.TAG, "trimCache - failed to get clips");
                return;
            }
            ArrayList arrayList = new ArrayList();
            int size = clips.size();
            for (int i = 0; i < size; i++) {
                String htmlText = clips.get(i).getItemAt(0).getHtmlText();
                if (!TextUtils.isEmpty(htmlText)) {
                    arrayList.addAll(ClipboardCacheManager.getBackupPathsFromHtml(htmlText));
                }
            }
            ClipboardCacheManager.clearClipboardPath(context, clipDataFiles, arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CacheManagerSemSOsImpl implements CacheManagerDelegateImpl {
        private static final String AUTHORITY = "com.samsung.android.honeyboard.provider.RichcontentProvider";
        private static final String PATH_CLIPBOARD = "clipboard";
        private static final String QUERY_PARAM_GET_PACKAGE_CLIPS = "GetPackageClips";

        @NonNull
        private ArrayList<String> getClips(Context context) {
            Logger.m8702i(ClipboardCacheManager.TAG, "getClips");
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("content").authority(AUTHORITY).appendPath(PATH_CLIPBOARD).appendQueryParameter(QUERY_PARAM_GET_PACKAGE_CLIPS, String.valueOf(Binder.getCallingUid()));
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor cursorQuery = context.getContentResolver().query(UserHandleCompat.getInstance().getUriWithUserId(builderAppendQueryParameter.build(), 0), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                int columnIndex = cursorQuery.getColumnIndex("html");
                                if (columnIndex >= 0) {
                                    String string = cursorQuery.getString(columnIndex);
                                    if (string == null) {
                                        string = "";
                                    }
                                    arrayList.add(string);
                                }
                            } while (cursorQuery.moveToNext());
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (Exception e) {
                Logger.m8698e(ClipboardCacheManager.TAG, "getClips# " + e);
                return arrayList;
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.clipboard.ClipboardCacheManager.CacheManagerDelegateImpl
        public void trimCache(Context context) {
            ClipData primaryClip;
            ArrayList<File> clipDataFiles = ClipboardCacheManager.getClipDataFiles(context, false, false, true);
            if (clipDataFiles == null) {
                Logger.m8702i(ClipboardCacheManager.TAG, "trimCache - clipDataFiles is null");
                return;
            }
            ArrayList<String> clips = getClips(context);
            ArrayList arrayList = new ArrayList();
            for (String str : clips) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.addAll(ClipboardCacheManager.getBackupPathsFromHtml(str));
                }
            }
            ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
            if (companion.getInstance().hasPrimaryClip(context, companion.getInstance().getTypeAll()) && (primaryClip = companion.getInstance().getPrimaryClip(context)) != null) {
                String htmlText = primaryClip.getItemAt(0).getHtmlText();
                if (!TextUtils.isEmpty(htmlText)) {
                    arrayList.addAll(ClipboardCacheManager.getBackupPathsFromHtml(htmlText));
                }
            }
            ClipboardCacheManager.clearClipboardPath(context, clipDataFiles, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearClipboardPath(Context context, ArrayList<File> arrayList, List<String> list) {
        String absolutePath = getClipboardPath(context).getAbsolutePath();
        for (File file : arrayList) {
            if (!list.contains(file.getAbsolutePath())) {
                deleteFileWithSDoc(file, absolutePath);
            }
        }
    }

    private static boolean deleteFile(String str) {
        File[] fileArrListFiles;
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (!deleteFile(file2.getAbsolutePath())) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteFileWithSDoc(File file, String str) {
        String name;
        int iLastIndexOf;
        deleteFile(file.getAbsolutePath());
        if (TextUtils.isEmpty(str) || (iLastIndexOf = (name = file.getName()).lastIndexOf(".sdocx")) <= 0) {
            return;
        }
        deleteFile(AbstractC0622a.m1170p(File.separator, name.substring(0, iLastIndexOf), AbstractC1974b.m1324q(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> getBackupPathsFromHtml(String str) {
        ArrayList arrayList = new ArrayList();
        String backupPathFromHtml = ClipDataBackupPath.getBackupPathFromHtml(str);
        if (!TextUtils.isEmpty(backupPathFromHtml)) {
            arrayList.add(backupPathFromHtml);
            int iLastIndexOf = backupPathFromHtml.lastIndexOf(".sdocx");
            if (iLastIndexOf > 0) {
                String strSubstring = backupPathFromHtml.substring(0, iLastIndexOf);
                if (AbstractC2322a.m1607A(strSubstring)) {
                    arrayList.add(strSubstring);
                }
                Logger.m8702i(TAG, "getBackupPathsFromHtml# backup file is not exists" + Logger.getEncode(strSubstring));
            }
        }
        return arrayList;
    }

    public static ArrayList<File> getClipDataFiles(Context context, boolean z, final boolean z2, boolean z3) {
        File[] fileArrListFiles;
        File file = new File(getClipboardPath(context).getAbsolutePath());
        if (!file.exists()) {
            Logger.m8702i(TAG, "getClipDataFiles - cache directory is not existed");
            return null;
        }
        File[] fileArrListFiles2 = file.listFiles();
        if (fileArrListFiles2 == null) {
            return null;
        }
        ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(fileArrListFiles2));
        ArrayList<File> oldClipDataFiles = getOldClipDataFiles(context);
        if (!oldClipDataFiles.isEmpty()) {
            arrayList.addAll(oldClipDataFiles);
        }
        if (arrayList.isEmpty()) {
            Logger.m8702i(TAG, "getClipDataFiles - no clip data");
            return null;
        }
        if (!z || ((fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.samsung.android.support.senl.nt.base.composer.clipboard.ClipboardCacheManager.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return z2 ? str.endsWith(".sdocx") : str.endsWith(".sdocx") && !str.contains(ClipboardCacheManager.CLIPBOARD_CONTENT_PREFIX);
            }
        })) != null && fileArrListFiles.length > 20)) {
            if (z3) {
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.samsung.android.support.senl.nt.base.composer.clipboard.ClipboardCacheManager.2
                    @Override // java.util.Comparator
                    public int compare(File file2, File file3) {
                        long jLastModified = file2.lastModified() - file3.lastModified();
                        if (jLastModified > 0) {
                            return 1;
                        }
                        return jLastModified == 0 ? 0 : -1;
                    }
                });
            }
            return arrayList;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("getClipDataFiles - clip data files ");
        sb.append(fileArrListFiles == null ? null : Integer.valueOf(fileArrListFiles.length));
        Logger.m8702i(str, sb.toString());
        return null;
    }

    public static String getClipboardFileName(Context context, String str, String str2) {
        File clipboardPath = getClipboardPath(context);
        if (!clipboardPath.exists()) {
            Logger.m8697d(TAG, "getClipboardFileName - cache directory is not existed");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(clipboardPath.getAbsolutePath());
        String str3 = File.separator;
        File file = new File(AbstractC0622a.m1170p(str3, str, sb));
        if (!file.exists() && !file.mkdir()) {
            Logger.m8698e(TAG, "getClipboardFileName, failed to create baseFolder");
            return null;
        }
        return file.getAbsolutePath() + str3 + str2;
    }

    public static File getClipboardPath(Context context) {
        File file = new File(context.getFilesDir(), Constants.CLIPBOARD_FILE_PREFIX);
        if (!file.exists() && !file.mkdir()) {
            Logger.m8698e(TAG, "fail getClipboardPath");
        }
        return file;
    }

    public static String getDateString() {
        return new SimpleDateFormat("_yyMMdd_HHmmss_SSS", Locale.ENGLISH).format(new Date());
    }

    private static ArrayList<File> getOldClipDataFiles(Context context) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File(ShareFileProvider.getShareDir(context).getAbsolutePath());
        if (file.exists() && (fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.samsung.android.support.senl.nt.base.composer.clipboard.ClipboardCacheManager.3
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().contains(Constants.CLIPBOARD_FILE_PREFIX);
            }
        })) != null) {
            Collections.addAll(arrayList, fileArrListFiles2);
        }
        File file2 = new File(context.getExternalFilesDir(null), ShareCacheHelper.CACHE_PATH);
        if (file2.exists() && (fileArrListFiles = file2.listFiles()) != null) {
            Collections.addAll(arrayList, fileArrListFiles);
        }
        return arrayList;
    }

    public static boolean isPageData(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains(CLIPBOARD_PAGE_PREFIX);
        }
        Logger.m8697d(TAG, "isPageData# filePath is empty");
        return false;
    }

    public static void trimCache(Context context) {
        if (mCacheManager == null) {
            if (!DeviceInfo.isSemDevice()) {
                mCacheManager = new CacheManagerDefaultImpl();
            } else if (Build.VERSION.SDK_INT > 30 || DeviceInfo.getSemPlatformVersionInt(0) >= 130000) {
                mCacheManager = new CacheManagerSemSOsImpl();
            } else {
                mCacheManager = new CacheManagerSemImpl();
            }
        }
        mCacheManager.trimCache(context);
    }
}
