package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareErrorCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.SdocXDocumentLocker;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareCacheHelper {
    public static final String CACHE_PATH = "share";
    private static final String TAG = Logger.createTag("ShareCacheHelper");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReturnValueForShareDir {
        public String mDir;
        public boolean mUseFileProvider;

        public ReturnValueForShareDir(boolean z, String str) {
            this.mUseFileProvider = z;
            this.mDir = str;
        }
    }

    private void deleteUriByHour(final Context context, final long j) {
        if (!isStoragePermissionGranted(context)) {
            Logger.m10999d(TAG, "deleteUriByHour, storage permission is not granted.");
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "deleteUriByHour, start thread.");
        new SenlThreadFactory(str).newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.ShareCacheHelper.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(ShareCacheHelper.TAG, "deleteUriByHour$run, submit.");
                Future<?> futureSubmit = Executors.newSingleThreadExecutor(new SenlThreadFactory(ShareCacheHelper.TAG)).submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.ShareCacheHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.m10999d(ShareCacheHelper.TAG, "deleteUriByHour$run$run, start.");
                        try {
                            int iDelete = context.getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "name = ? AND date_added < ?", new String[]{UriHelper.SHARE_TAG, String.valueOf(j)});
                            int iDelete2 = context.getContentResolver().delete(MediaStore.Files.getContentUri("external"), "name = ? AND date_added < ?", new String[]{UriHelper.SHARE_TAG, String.valueOf(j)});
                            Logger.m10999d(ShareCacheHelper.TAG, "deleteUriByHour$run$run, resultMedia : " + iDelete + ", resultFile: " + iDelete2);
                            Logger.m11002f(ShareCacheHelper.TAG, "deleteUriByHour$run$run, resultMedia : " + iDelete + ", resultFile: " + iDelete2);
                        } catch (Exception e) {
                            Logger.m10999d(ShareCacheHelper.TAG, "deleteUriByHour$run$run, " + e.getMessage());
                        }
                        Logger.m10999d(ShareCacheHelper.TAG, "deleteUriByHour$run$run, end.");
                    }
                });
                try {
                    Logger.m10999d(ShareCacheHelper.TAG, "deleteUriByHour$run, wait.");
                    futureSubmit.get(10L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e = e;
                    Logger.m11001e(ShareCacheHelper.TAG, "deleteUriByHour$run", e);
                    futureSubmit.cancel(true);
                } catch (CancellationException e2) {
                    e = e2;
                    Logger.m11001e(ShareCacheHelper.TAG, "deleteUriByHour$run", e);
                    futureSubmit.cancel(true);
                } catch (ExecutionException e3) {
                    Logger.m11001e(ShareCacheHelper.TAG, "deleteUriByHour$run", e3);
                } catch (TimeoutException e5) {
                    e = e5;
                    Logger.m11001e(ShareCacheHelper.TAG, "deleteUriByHour$run", e);
                    futureSubmit.cancel(true);
                }
                Logger.m10999d(ShareCacheHelper.TAG, "deleteUriByHour$run, done");
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeInnerCache$0(File file) {
        String str = TAG;
        Logger.m10999d(str, "removeInnerCache, start.");
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.ShareCacheHelper.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return !file2.getName().contains(Constants.CLIPBOARD_FILE_PREFIX);
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            Logger.m10999d(str, "removeInnerCache, there is no files");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(10, -24);
        for (File file2 : fileArrListFiles) {
            if (new Date(file2.lastModified()).before(calendar.getTime()) && !file2.delete()) {
                Logger.m11000e(TAG, "file delete error");
            }
        }
        Logger.m10999d(TAG, "removeInnerCache, done.");
    }

    private void removeInnerCache(Context context) {
        File shareDir = ShareFileProvider.getShareDir(context);
        if (shareDir.exists()) {
            new SenlThreadFactory(TAG).newThread(new RunnableC9844c(this, shareDir, 7)).start();
        }
    }

    private void removeUnderDirByHour(Context context, File file, int i) {
        int i2;
        String str = TAG;
        Logger.m10999d(str, "removeUnderDirByHour, path: " + file.getAbsolutePath() + ", hour: " + i);
        Calendar calendar = Calendar.getInstance();
        calendar.add(10, -i);
        int i4 = 0;
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                Logger.m11000e(str, "removeUnderDirByHour# directory is null");
                return;
            }
            int length = list.length;
            int i5 = 0;
            i2 = 0;
            while (i4 < length) {
                File file2 = new File(file, list[i4]);
                if (!new Date(file2.lastModified()).before(calendar.getTime()) || file2.getName().equals(".nomedia")) {
                    i2++;
                } else {
                    Logger.m10999d(TAG, "removeUnderDirByHour# " + Logger.getEncode(file2.getAbsolutePath()) + "   r: " + file2.delete());
                    i5++;
                }
                i4++;
            }
            i4 = i5;
        } else {
            i2 = 0;
        }
        AbstractC8014b.m7216r(i4, i2, "removeUnderDirByHour, removeCnt: ", ", skipCnt: ", TAG);
        deleteUriByHour(context, calendar.getTimeInMillis() / 1000);
    }

    @Nullable
    public ReturnValueForShareDir getContextShareDir(Context context, boolean z) {
        if (!z && (ShareUtils.isNotSupportedFileProviderForChina() || !DeviceUtils.isSupportedFileProvider())) {
            try {
                return new ReturnValueForShareDir(false, getImageExternalCacheFile(context).getAbsolutePath());
            } catch (ShareException e) {
                Logger.m11000e(TAG, "getContextShareDir: ShareException] " + e.getMessage());
            }
        }
        try {
            return new ReturnValueForShareDir(true, ShareFileProvider.getShareDir(context).getCanonicalPath());
        } catch (IOException e2) {
            AbstractC8014b.m7204f(e2, new StringBuilder("getContextShareDir: IOException] "), TAG);
            return null;
        }
    }

    public String getFileExt(String str) {
        if (!str.contains(Extension.DOT)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46) + 1;
        return iLastIndexOf == str.length() ? "" : str.substring(iLastIndexOf, str.length());
    }

    public File getImageExternalCacheFile(Context context) throws ShareException {
        File imageExternalCacheFile = getImageExternalCacheFile(context, true);
        if (imageExternalCacheFile != null) {
            return imageExternalCacheFile;
        }
        throw new ShareException(ShareErrorCode.CreateFileFailed, "getImageExternalCacheFile return is null");
    }

    @Nullable
    public String getShareFilePath(Context context, String str, String str2) throws ShareException {
        if (TextUtils.isEmpty(str) || !AbstractC2322a.m1607A(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UUID.randomUUID().toString();
        }
        String fileExt = getFileExt(str);
        if (!TextUtils.isEmpty(fileExt)) {
            str2 = str2.concat(Extension.DOT + fileExt);
        }
        try {
            String str3 = getImageExternalCacheFile(context).getAbsolutePath() + "/" + str2;
            BaseUtils.copyFile(str, str3);
            if (new File(str3).exists()) {
                return str3;
            }
            throw new ShareException(ShareErrorCode.CreateFileFailed, "failed to make share copy");
        } catch (IOException e) {
            throw new ShareException(ShareErrorCode.CreateFileFailed, e.getMessage() != null ? e.getMessage() : "");
        }
    }

    public boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean isStoragePermissionGranted(Context context) {
        String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
        ArrayList arrayList = new ArrayList();
        for (String str : storagePermissions) {
            if (!PermissionHelper.isPermissionGrantedWithoutNotice(context, str)) {
                arrayList.add(str);
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        AbstractC8014b.m7220v("isStoragePermissionGranted ret: ", TAG, zIsEmpty);
        return zIsEmpty;
    }

    public void removeCache(Context context) {
        removeInnerCache(context);
        if (isStoragePermissionGranted(context)) {
            if (!isExternalStorageWritable()) {
                Logger.m10999d(TAG, "removeCache, external storage is not writable.");
                return;
            }
            Logger.m10999d(TAG, "removeCache, start.");
            try {
                File imageExternalCacheFile = getImageExternalCacheFile(context, false);
                if (imageExternalCacheFile != null && imageExternalCacheFile.exists()) {
                    removeUnderDirByHour(context, imageExternalCacheFile, 24);
                }
            } catch (ShareException e) {
                Logger.m11001e(TAG, "removeCache", e);
            }
            Logger.m10999d(TAG, "removeCache, done.");
        }
    }

    public boolean unlockSpenWNote(Context context, String str, String str2, boolean z) {
        if (CommonUtil.initSpenSdk(context) && LockUtils.isLocked(str)) {
            try {
                DocumentCopyUtils.copy(context, str, str2, z);
                return SdocXDocumentLocker.unlockSdocXFile(str2);
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("unlockSpenWNote: IOException] "), TAG);
            }
        }
        return false;
    }

    @Nullable
    public File getImageExternalCacheFile(Context context, boolean z) throws ShareException {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir.getAbsoluteFile() + "/share");
            if (!file.exists()) {
                if (!z) {
                    return null;
                }
                if (!file.mkdir()) {
                    throw new ShareException(ShareErrorCode.CreateFileFailed, "failed to create share path");
                }
            }
            int userId = UserHandleCompat.getInstance().getUserId(0);
            File file2 = new File(externalFilesDir.getAbsoluteFile() + "/share/" + userId);
            if (!file2.exists()) {
                if (!z) {
                    return null;
                }
                if (!file2.mkdir()) {
                    throw new ShareException(ShareErrorCode.CreateFileFailed, AbstractC0000a.m11h(userId, "failed to create share path userid:"));
                }
            }
            File file3 = new File(file2, ".nomedia");
            if (!file3.exists()) {
                try {
                    boolean zCreateNewFile = file3.createNewFile();
                    Logger.m10999d(TAG, "getImageExternalCacheFile, create no media file. result: " + zCreateNewFile);
                    return file2;
                } catch (IOException unused) {
                    Logger.m10999d(TAG, "getImageExternalCacheFile, failed to make nomedia");
                }
            }
            return file2;
        }
        throw new ShareException(ShareErrorCode.FileNotFound, "external files dir is not exists");
    }
}
