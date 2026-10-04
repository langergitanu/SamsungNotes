package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareErrorCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareUriHelper {
    private static final int SHAREVIA_MAXIMUM_URI_COUNT = 40;
    private static final String TAG = Logger.createTag("ShareUriHelper");
    private final ShareCacheHelper mShareCacheHelper;

    public ShareUriHelper(ShareCacheHelper shareCacheHelper) {
        this.mShareCacheHelper = shareCacheHelper;
    }

    public ArrayList<Uri> cutOverMaxUriCount(ArrayList<Uri> arrayList) {
        int size = arrayList.size();
        String str = TAG;
        AbstractC0000a.m3D(size, "cutOverMaxUriCount# contentUris size: ", str);
        if (size <= 40) {
            return arrayList;
        }
        ArrayList<Uri> arrayList2 = new ArrayList<>(arrayList.subList(0, 40));
        AbstractC0000a.m3D(arrayList2.size(), "cutOverMaxUriCount# out of maximum. resize: ", str);
        return arrayList2;
    }

    @Nullable
    public Uri getContextShareUri(Context context, String str, boolean z, @Nullable String str2) {
        return z ? UriHelper.getFileProviderUri(context, str) : UriHelper.getMediaUri(context, MediaStore.Files.getContentUri("external"), str, str2);
    }

    @Nullable
    public Uri getDocumentUri(Context context, String str, String str2, @Nullable String str3, long j) {
        if (this.mShareCacheHelper.isStoragePermissionGranted(context) && !TextUtils.isEmpty(str) && AbstractC2322a.m1607A(str) && CommonUtil.initSpenSdk(context)) {
            try {
                boolean zIsLocked = LockUtils.isLocked(str);
                if (!zIsLocked || !TextUtils.isEmpty(str3)) {
                    return getContextShareUri(zIsLocked, context, str, ShareUtils.generateNewFileName(str2, j), null);
                }
                Logger.m10999d(TAG, "getDocumentUri, need to lock confirm result.");
                return null;
            } catch (Exception e) {
                Logger.m11001e(TAG, "getDocumentUri", e);
            }
        }
        return null;
    }

    @Nullable
    public Uri getShareContentsFileProviderUri(Context context, Bitmap bitmap, @Nullable String str) throws ShareException {
        String str2 = TAG;
        AbstractC8014b.m7196B("getShareContentsFileProviderUri newFileName: ", str, str2);
        if (bitmap == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = ShareUtils.getDocumentTimeName("");
        }
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(ShareFileProvider.getShareDir(context).getAbsolutePath(), str, "jpg");
        Logger.m10999d(str2, "getShareContentsFileProviderUri, sharePath: " + Logger.getEncode(strGenerateUniqueFilePath));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(strGenerateUniqueFilePath);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                if (!new File(strGenerateUniqueFilePath).exists()) {
                    throw new ShareException(ShareErrorCode.CreateFileFailed, "failed to make share copy");
                }
                Uri uri = ShareFileProvider.getUri(context, strGenerateUniqueFilePath);
                Logger.m10999d(str2, "getShareContentsFileProviderUri, uri: " + uri);
                fileOutputStream.close();
                return uri;
            } finally {
            }
        } catch (IOException e) {
            throw new ShareException(ShareErrorCode.CreateFileFailed, e.getMessage() != null ? e.getMessage() : "");
        }
    }

    @Nullable
    public Uri getShareUri(Context context, String str, String str2, @Nullable String str3) throws ShareException {
        Logger.m10999d(TAG, "getShareUri, path : " + Logger.getEncode(str) + ", newFileName: " + str2);
        if (TextUtils.isEmpty(str) || !AbstractC2322a.m1607A(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = ShareUtils.getDocumentTimeName("");
        }
        try {
            String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(this.mShareCacheHelper.getImageExternalCacheFile(context).getAbsolutePath(), str2, FileUtils.getFileExt(str));
            if (FileUtils.getFileExt(str).equals("sdocx")) {
                DocumentCopyUtils.copy(context, str, strGenerateUniqueFilePath);
            } else {
                BaseUtils.copyFile(str, strGenerateUniqueFilePath);
            }
            File file = new File(strGenerateUniqueFilePath);
            if (file.exists()) {
                return UriHelper.getMediaUri(context, MediaStore.Files.getContentUri("external"), file.getAbsolutePath(), str3);
            }
            throw new ShareException(ShareErrorCode.CreateFileFailed, "failed to make share copy");
        } catch (IOException e) {
            throw new ShareException(ShareErrorCode.CreateFileFailed, e.getMessage() != null ? e.getMessage() : "");
        }
    }

    @Nullable
    public ArrayList<Uri> getContextShareUri(Context context, ArrayList<String> arrayList, boolean z, @Nullable String str) {
        Uri contextShareUri;
        ArrayList<Uri> arrayList2 = new ArrayList<>();
        for (String str2 : arrayList) {
            if (AbstractC2322a.m1607A(str2) && (contextShareUri = getContextShareUri(context, str2, z, str)) != null) {
                arrayList2.add(contextShareUri);
            }
        }
        return arrayList2;
    }

    @Nullable
    public Uri getContextShareUri(boolean z, Context context, Bitmap bitmap, @Nullable String str) {
        if (!z && (ShareUtils.isNotSupportedFileProviderForChina() || !DeviceUtils.isSupportedFileProvider())) {
            return getShareUri(context, bitmap, str);
        }
        return getShareContentsFileProviderUri(context, bitmap, str);
    }

    @Nullable
    public Uri getContextShareUri(boolean z, Context context, String str, String str2, @Nullable String str3) {
        if (!z && (ShareUtils.isNotSupportedFileProviderForChina() || !DeviceUtils.isSupportedFileProvider())) {
            return getShareUri(context, str, str2, str3);
        }
        return getShareContentsFileProviderUri(context, str, str2);
    }

    @Nullable
    public Uri getShareUri(Context context, Bitmap bitmap, @Nullable String str) throws ShareException {
        String str2 = TAG;
        AbstractC8014b.m7196B("getShareUri newFileName: ", str, str2);
        if (bitmap == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = ShareUtils.getDocumentTimeName("");
        }
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(this.mShareCacheHelper.getImageExternalCacheFile(context).getAbsolutePath(), str, "jpg");
        Logger.m10999d(str2, "getShareUri, sharePath: " + Logger.getEncode(strGenerateUniqueFilePath));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(strGenerateUniqueFilePath);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                File file = new File(strGenerateUniqueFilePath);
                if (file.exists()) {
                    Uri mediaUri = UriHelper.getMediaUri(context, MediaStore.Files.getContentUri("external"), file.getAbsolutePath(), null);
                    Logger.m10999d(str2, "getShareUri, uri: " + mediaUri);
                    fileOutputStream.close();
                    return mediaUri;
                }
                throw new ShareException(ShareErrorCode.CreateFileFailed, "failed to make share copy");
            } finally {
            }
        } catch (IOException e) {
            throw new ShareException(ShareErrorCode.CreateFileFailed, e.getMessage() != null ? e.getMessage() : "");
        }
    }

    @Nullable
    public Uri getShareContentsFileProviderUri(Context context, String str, String str2) {
        Logger.m10999d(TAG, "getShareContentsFileProviderUri, path : " + Logger.getEncode(str) + ", newFileName: " + str2);
        if (TextUtils.isEmpty(str) || !AbstractC2322a.m1607A(str)) {
            return null;
        }
        if (FileUtils.getFileExt(str).equals("sdocx") && LockUtils.isLocked(str)) {
            String fileExt = FileUtils.getFileExt(str);
            String strReplace = str.replace(fileExt, "unlocked." + fileExt);
            if (this.mShareCacheHelper.unlockSpenWNote(context, str, strReplace, false)) {
                return ShareFileProvider.getUri(context, strReplace, str2);
            }
        }
        return ShareFileProvider.getUri(context, str, str2);
    }
}
