package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0007J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000eH\u0007J0\u0010\u001e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0005H\u0002J*\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u001a\u0010&\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010'\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/PageCacheUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CACHE_FOLDER", "PAGE_CACHE_FOLDER", "DARK_MODE_THUMBNAIL_PREFIX", "createPageThumbnailCacheDirectory", "context", "Landroid/content/Context;", "uuid", "size", "", "getRootCacheDirectoryPath", "getRootCacheDirectory", "Ljava/io/File;", "getCacheDirectory", "ifEmptyCreate", "", "makeCacheDirectory", "rootCacheDir", "getCacheDirectoryPath", "folderName", "getThumbnailImagePath", "THUMBNAIL_TAG", "THUMBNAIL_FINDER", "getExportThumbnailPath", "appType", "getScaledThumbnail", "sourceBitmap", "Landroid/graphics/Bitmap;", "maxWidth", "scaled", "cacheDir", "makeExportThumbnail", "bitmapSize", "getCoverGridCacheDirectory", "getCoverCacheDirectory", "getCoverDirectory", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageCacheUtils {

    @NotNull
    private static final String CACHE_FOLDER = "attach";

    @NotNull
    public static final String DARK_MODE_THUMBNAIL_PREFIX = "d_";

    @NotNull
    public static final PageCacheUtils INSTANCE = new PageCacheUtils();

    @NotNull
    public static final String PAGE_CACHE_FOLDER = "thumbnail";

    @NotNull
    public static final String TAG = "PageCacheUtils";
    public static final int THUMBNAIL_FINDER = 2;
    public static final int THUMBNAIL_TAG = 1;

    private PageCacheUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String createPageThumbnailCacheDirectory(@NotNull Context context, @NotNull String uuid, int size) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        String strM757C = AbstractC0541b.m757C(getCacheDirectory(context, uuid, size), File.separator, "thumbnail");
        File file = new File(strM757C);
        if (!file.exists() && !file.mkdir()) {
            Logger.m8702i(TAG, "createPageThumbnailCacheDirectory, mkdir fail");
        }
        return strM757C;
    }

    @JvmStatic
    @NotNull
    public static final String getCacheDirectory(@NotNull Context context, @NotNull String uuid, int size) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return INSTANCE.makeCacheDirectory(getRootCacheDirectoryPath(context), uuid, size);
    }

    private final String getCacheDirectoryPath(String rootCacheDir, String uuid) {
        return AbstractC0541b.m757C(rootCacheDir, File.separator, uuid);
    }

    @JvmStatic
    @NotNull
    public static final String getCoverCacheDirectory(@NotNull Context context, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        return uuid == null ? "" : AbstractC0541b.m757C(getCacheDirectory(context, uuid, Constants.MAIN_THUMBNAIL_PATH), File.separator, Constants.MAIN_THUMBNAIL_FILE_NAME_COVER);
    }

    @JvmStatic
    @NotNull
    public static final String getCoverDirectory(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return getCacheDirectory(context, uuid);
    }

    @JvmStatic
    @NotNull
    public static final String getCoverGridCacheDirectory(@NotNull Context context, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        return uuid == null ? "" : AbstractC0541b.m757C(getCacheDirectory(context, uuid, Constants.MAIN_THUMBNAIL_PATH), File.separator, Constants.MAIN_THUMBNAIL_FILE_NAME_COVER_GRID);
    }

    @JvmStatic
    @Nullable
    public static final String getExportThumbnailPath(@NotNull Context context, @NotNull String uuid, int appType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        String thumbnailImagePath = getThumbnailImagePath(context, uuid);
        if (thumbnailImagePath == null || thumbnailImagePath.length() == 0) {
            return "";
        }
        String strM756B = AbstractC0541b.m756B(getCacheDirectory(context, uuid, Constants.MAIN_THUMBNAIL_PATH), File.separator);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inJustDecodeBounds = false;
        Bitmap bitmapCopy = BitmapFactory.decodeFile(thumbnailImagePath, options).copy(Bitmap.Config.ARGB_8888, true);
        int i = appType == 2 ? 2 : 1;
        PageCacheUtils pageCacheUtils = INSTANCE;
        Intrinsics.checkNotNull(bitmapCopy);
        return pageCacheUtils.getScaledThumbnail(context, bitmapCopy, bitmapCopy.getWidth(), i, strM756B);
    }

    @JvmStatic
    @NotNull
    public static final File getRootCacheDirectory(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File dir = context.getDir(CACHE_FOLDER, 0);
        Intrinsics.checkNotNullExpressionValue(dir, "getDir(...)");
        return dir;
    }

    @JvmStatic
    @NotNull
    public static final String getRootCacheDirectoryPath(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String absolutePath = getRootCacheDirectory(context).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    private final String getScaledThumbnail(Context context, Bitmap sourceBitmap, int maxWidth, int scaled, String cacheDir) {
        int i = maxWidth / scaled;
        if (sourceBitmap.getHeight() < maxWidth) {
            String strMakeExportThumbnail = makeExportThumbnail(context, sourceBitmap, i, cacheDir);
            Intrinsics.checkNotNull(strMakeExportThumbnail);
            return strMakeExportThumbnail;
        }
        String strM756B = AbstractC0541b.m756B(cacheDir, Constants.MAIN_THUMBNAIL_EXPORT_FILE_NAME);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(sourceBitmap, i, i, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        if (ImageUtils.makeJpg(bitmapCreateScaledBitmap, strM756B, 100, true)) {
            Logger.m8697d(TAG, "makeBitmap, success");
        } else {
            Logger.m8697d(TAG, "makeBitmap, fail");
        }
        if (!sourceBitmap.isRecycled()) {
            sourceBitmap.recycle();
        }
        if (!bitmapCreateScaledBitmap.isRecycled()) {
            bitmapCreateScaledBitmap.recycle();
        }
        return strM756B;
    }

    @JvmStatic
    @Nullable
    public static final String getThumbnailImagePath(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        String strM756B = AbstractC0541b.m756B(getCacheDirectory(context, uuid, Constants.MAIN_THUMBNAIL_PATH), File.separator);
        String strM756B2 = AbstractC0541b.m756B(strM756B, "thumbnail");
        if (AbstractC2322a.m1607A(strM756B2)) {
            return strM756B2;
        }
        String str = ContextUtils.isNightMode(context) ? "d_" : "";
        Logger.m8697d(TAG, "getThumbnailImagePath, main thumbnail file does not exist");
        String str2 = strM756B + str + "thumbnail_text";
        if (!AbstractC2322a.m1607A(str2)) {
            Logger.m8697d(TAG, "getThumbnailImagePath, main text thumbnail file does not exist");
            str2 = strM756B + "image";
            if (!AbstractC2322a.m1607A(str2)) {
                Logger.m8697d(TAG, "getThumbnailImagePath, image file does not exist");
                return "";
            }
        }
        return str2;
    }

    private final String makeCacheDirectory(String rootCacheDir, String uuid) {
        String cacheDirectoryPath = getCacheDirectoryPath(rootCacheDir, uuid);
        File file = new File(cacheDirectoryPath);
        if (!file.exists() && !file.mkdir()) {
            Logger.m8702i(TAG, "makeCacheDirectory, mkdir fail");
        }
        return cacheDirectoryPath;
    }

    private final String makeExportThumbnail(Context context, Bitmap sourceBitmap, int bitmapSize, String cacheDir) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(bitmapSize, bitmapSize));
        frameLayout.layout(0, 0, bitmapSize, bitmapSize);
        frameLayout.setBackgroundColor(context.getColor(C8875R.color.mainlist_default_thumbnail_bg));
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(sourceBitmap);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(bitmapSize, bitmapSize));
        frameLayout.addView(imageView);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(bitmapSize, 1073741824);
        frameLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(frameLayout.getWidth(), frameLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        frameLayout.setBackgroundColor(context.getColor(C8875R.color.mainlist_noteslist_backgroud_color));
        frameLayout.draw(canvasM4740a);
        String str = cacheDir + Constants.MAIN_THUMBNAIL_EXPORT_FILE_NAME;
        if (ImageUtils.makeJpg(bitmapCreateBitmap, String.valueOf(str), 100, true)) {
            Logger.m8697d(TAG, "makeExportThumbnail, success");
        } else {
            Logger.m8697d(TAG, "makeExportThumbnail, fail");
            str = null;
        }
        if (!sourceBitmap.isRecycled()) {
            sourceBitmap.recycle();
        }
        if (!bitmapCreateBitmap.isRecycled()) {
            bitmapCreateBitmap.recycle();
        }
        return str;
    }

    @JvmStatic
    @NotNull
    public static final String getCacheDirectory(@NotNull Context context, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return getCacheDirectory(context, uuid, true);
    }

    @JvmStatic
    @NotNull
    public static final String getCacheDirectory(@NotNull Context context, @NotNull String uuid, boolean ifEmptyCreate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (ifEmptyCreate) {
            return INSTANCE.makeCacheDirectory(getRootCacheDirectoryPath(context), uuid);
        }
        return INSTANCE.getCacheDirectoryPath(getRootCacheDirectoryPath(context), uuid);
    }

    @JvmStatic
    @NotNull
    public static final String getCacheDirectory(@NotNull Context context, @NotNull String uuid, @NotNull String folderName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        String strM757C = AbstractC0541b.m757C(INSTANCE.makeCacheDirectory(getRootCacheDirectoryPath(context), uuid), File.separator, folderName);
        File file = new File(strM757C);
        if (!file.exists() && !file.mkdir()) {
            Logger.m8702i(TAG, "getCacheDirectory, mkdir fail");
        }
        return strM757C;
    }

    private final String makeCacheDirectory(String rootCacheDir, String uuid, int size) {
        String strM2218i = AbstractC2821a.m2218i(size, makeCacheDirectory(rootCacheDir, uuid), File.separator);
        File file = new File(strM2218i);
        if (!file.exists() && !file.mkdir()) {
            Logger.m8702i(TAG, "makeCacheDirectory, mkdir fail");
        }
        return strM2218i;
    }
}
