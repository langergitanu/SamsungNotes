package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoverThumbnailCreator {
    public static final String COVER_PATH_PREFIX = "cover_temp_";
    private static final String TAG = "CoverThumbnailCreator";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ThumbnailType {
        RECT,
        SQUARE
    }

    public static void convertCoverPath(Context context, String str) {
        convertCoverPath(context, str, COVER_PATH_PREFIX + str);
    }

    public static void deleteCoverFile(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        File file = new File(getCoverFolderPath(context, str));
        if (file.exists()) {
            Logger.m8697d(TAG, "deleteCoverFile# coverPath : ".concat(str));
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e) {
                Logger.m8698e(TAG, "deleteCoverFile# e: " + e.getMessage());
            }
        }
    }

    public static void deleteCoverFileByUuid(Context context, String str) {
        deleteCoverFile(context, COVER_PATH_PREFIX + str);
    }

    private static void deleteCoverTempDirectory(File file) {
        if (file == null) {
            return;
        }
        File parentFile = file.getParentFile();
        while (parentFile != null && !parentFile.getName().startsWith(COVER_PATH_PREFIX)) {
            parentFile = parentFile.getParentFile();
        }
        if (parentFile == null) {
            Logger.m8703w(TAG, "deleteCoverTempDirectory# COVER_PATH_PREFIX dir not found for: " + file.getAbsolutePath());
        } else {
            Logger.m8697d(TAG, "deleteCoverTempDirectory# deleting dir: " + parentFile.getAbsolutePath());
            deleteDirectory(parentFile);
        }
    }

    private static void deleteDirectory(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    deleteDirectory(file2);
                } else if (!file2.delete()) {
                    Logger.m8703w(TAG, "deleteDirectory# failed to delete file: " + file2.getAbsolutePath());
                }
            }
        }
        if (file.delete()) {
            Logger.m8697d(TAG, "deleteDirectory# deleted dir: " + file.getAbsolutePath());
        } else {
            Logger.m8703w(TAG, "deleteDirectory# failed to delete dir: " + file.getAbsolutePath());
        }
    }

    public static String getCoverFolderPath(Context context, String str) {
        return PageCacheUtils.getCoverDirectory(context, str);
    }

    public static String getCoverPath(Context context, String str, ThumbnailType thumbnailType) {
        return thumbnailType == ThumbnailType.SQUARE ? PageCacheUtils.getCoverCacheDirectory(context, str) : PageCacheUtils.getCoverGridCacheDirectory(context, str);
    }

    public static Drawable getCoverThumbnail(Context context, String str, ThumbnailType thumbnailType) {
        String coverPath = getCoverPath(context, str, thumbnailType);
        Logger.m8697d(TAG, "getCoverThumbnail# coverPath : " + coverPath);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = 1;
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeFile(coverPath, options));
    }

    public static boolean isExistCoverFile(Context context, String str, ThumbnailType thumbnailType) {
        if (context == null || str == null) {
            return false;
        }
        String coverPath = getCoverPath(context, str, thumbnailType);
        if (TextUtils.isEmpty(coverPath)) {
            return false;
        }
        File file = new File(coverPath);
        if (file.exists()) {
            return true;
        }
        AbstractC4539a.m3214x("isExistCoverFile# file not exist : ", coverPath, TAG);
        deleteCoverTempDirectory(file);
        return false;
    }

    public static void renameCoverFile(String str, String str2) {
        try {
            FileUtils.forceRenameTo(str, str2);
        } catch (IOException e) {
            Logger.m8698e(TAG, "renameCoverFile# Failed to rename file. " + e.getMessage());
        }
    }

    public static void saveCoverFile(Context context, String str, View view, ThumbnailType thumbnailType) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.layout(0, 0, measuredWidth, measuredHeight);
        view.draw(canvas);
        String coverPath = getCoverPath(context, str, thumbnailType);
        StringBuilder sbM2229t = AbstractC2821a.m2229t("saveCoverFile# noteUuid : ", str, ", result : ", ImageUtils.makeJpg(bitmapCreateBitmap, coverPath, 100, true), ", coverPath : ");
        sbM2229t.append(coverPath);
        sbM2229t.append(", previewWidth : ");
        sbM2229t.append(measuredWidth);
        sbM2229t.append(", previewHeight : ");
        sbM2229t.append(measuredHeight);
        Logger.m8697d(TAG, sbM2229t.toString());
    }

    public static void convertCoverPath(Context context, String str, String str2) {
        Logger.m8697d(TAG, "convertCoverPath# noteUuid : " + str + ", coverPath : " + str2);
        if (context == null || str == null) {
            return;
        }
        for (ThumbnailType thumbnailType : ThumbnailType.values()) {
            renameCoverFile(getCoverPath(context, str2, thumbnailType), getCoverPath(context, str, thumbnailType));
        }
        deleteCoverFile(context, str2);
    }
}
