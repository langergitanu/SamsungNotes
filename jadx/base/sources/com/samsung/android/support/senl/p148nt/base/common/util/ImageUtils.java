package com.samsung.android.support.senl.p148nt.base.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J.\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J$\u0010\u001d\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0007J*\u0010\u001d\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0016H\u0007J\u0012\u0010!\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010#\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u0011J\u0012\u0010%\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u0005H\u0007J(\u0010(\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0007J:\u0010(\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0016H\u0007J\u001c\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ImageUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "maxTextureSize", "", "getMaxTextureSize$annotations", "getMaxTextureSize", "()I", "resizeBitmapFitingToScreen", "Landroid/graphics/Bitmap;", "source", "screenMinSize", "resizeBitmapImage", "maxWidth", "", "convertDrawableToBitmap", "drawable", "Landroid/graphics/drawable/Drawable;", "make", "", "bitmap", "destFile", "Ljava/io/File;", "quality", "format", "Landroid/graphics/Bitmap$CompressFormat;", "makeJpg", "dstFile", "filePath", "recycle", "getImageSize", "Landroid/graphics/Rect;", "getScaledImageSize", "ratio", "getImageRatio", "decodeSpi", "path", "saveBitmapToFileCache", "backgroundColor", "canOverwrite", "createBitmap", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageUtils {

    @NotNull
    public static final ImageUtils INSTANCE = new ImageUtils();

    @NotNull
    private static final String TAG = "ImageUtils";

    private ImageUtils() {
    }

    @JvmStatic
    @NotNull
    public static final Bitmap convertDrawableToBitmap(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvasM4740a.getWidth(), canvasM4740a.getHeight());
        drawable.draw(canvasM4740a);
        return bitmapCreateBitmap;
    }

    @JvmStatic
    @Nullable
    public static final Bitmap createBitmap(@Nullable Bitmap bitmap, int backgroundColor) {
        if (bitmap == null || bitmap.getHeight() == 0 || bitmap.getWidth() == 0) {
            Logger.m8698e(TAG, "createBitmap, bitmap is null");
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        if (backgroundColor == 0) {
            backgroundColor = -197380;
        }
        canvasM4740a.drawColor(backgroundColor);
        canvasM4740a.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapCreateBitmap;
    }

    @JvmStatic
    @Nullable
    public static final Bitmap decodeSpi(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return StringsKt.m14131E(".spi", 0, 6, path) >= 0 ? SpenScreenCodecDecoder.INSTANCE.decodeFile(path) : BitmapFactory.decodeFile(path);
    }

    @JvmStatic
    public static final float getImageRatio(@Nullable String filePath) {
        if (filePath == null) {
            return 1.0f;
        }
        if (getImageSize(filePath).isEmpty()) {
            return 1.0f;
        }
        return r2.height() / r2.width();
    }

    @JvmStatic
    @NotNull
    public static final Rect getImageSize(@Nullable String filePath) {
        Rect rect = new Rect(0, 0, 0, 0);
        if (!TextUtils.isEmpty(filePath) && FileUtils.exists(String.valueOf(filePath))) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, options);
            rect.set(0, 0, options.outWidth, options.outHeight);
            Logger.m8697d(TAG, "getImageSize, size : " + rect);
        }
        return rect;
    }

    public static final int getMaxTextureSize() {
        return BaseImageUtils.getMaxTextureSize();
    }

    @JvmStatic
    public static /* synthetic */ void getMaxTextureSize$annotations() {
    }

    @JvmStatic
    public static final boolean make(@Nullable Bitmap bitmap, @Nullable File destFile, int quality, @Nullable Bitmap.CompressFormat format) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            if (format != null && bitmap != null) {
                try {
                    bitmap.compress(format, quality, fileOutputStream);
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            return true;
        } catch (IOException e) {
            AbstractC4539a.m3188B("make : e", e.getMessage(), TAG);
            return false;
        } catch (NullPointerException e2) {
            AbstractC4539a.m3188B("make : e", e2.getMessage(), TAG);
            return false;
        }
    }

    @JvmStatic
    public static final boolean makeJpg(@Nullable Bitmap bitmap, @Nullable File dstFile, int quality) {
        return make(bitmap, dstFile, quality, Bitmap.CompressFormat.JPEG);
    }

    @JvmStatic
    @NotNull
    public static final Bitmap resizeBitmapFitingToScreen(@NotNull Bitmap source, int screenMinSize) {
        int i;
        int i2;
        boolean z;
        Intrinsics.checkNotNullParameter(source, "source");
        int width = source.getWidth();
        int height = source.getHeight();
        int iMin = (int) Math.min(width, height);
        if (iMin > screenMinSize) {
            float f = screenMinSize / iMin;
            i = (int) (width * f);
            i2 = (int) (height * f);
            Logger.m8697d(TAG, "resizeBitmapFitingToScreen# screenMinSize - newWidth: " + i + ", newHeight: " + i2);
        } else {
            i = width;
            i2 = height;
        }
        int iMax = Math.max(i, i2);
        int maxTextureSize = getMaxTextureSize();
        if (iMax > maxTextureSize) {
            float f4 = maxTextureSize / iMax;
            i = (int) (i * f4);
            i2 = (int) (i2 * f4);
            Logger.m8697d(TAG, "resizeBitmapFitingToScreen# maxTextureSize - newWidth: " + i + ", newHeight: " + i2);
            z = false;
        } else {
            z = true;
        }
        if (width == i && height == i2) {
            return source;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(source, i, i2, z);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    @JvmStatic
    @NotNull
    public static final Bitmap resizeBitmapImage(@NotNull Bitmap source, float maxWidth) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(source, "source");
        int maxTextureSize = getMaxTextureSize();
        Logger.m8702i(TAG, "resizeBitmapImage, maxWidth: " + maxWidth + ", maxHeight: " + maxTextureSize);
        int width = source.getWidth();
        int height = source.getHeight();
        float f = (float) width;
        if (maxWidth < f) {
            float f4 = maxWidth / f;
            i2 = (int) (height * f4);
            i = (int) (f * f4);
            Logger.m8702i(TAG, "resizeBitmapImage, width newWidth: " + i + ", newHeight: " + i2);
        } else {
            i = width;
            i2 = height;
        }
        if (maxTextureSize < i2) {
            float f5 = maxTextureSize / height;
            i = (int) (i * f5);
            i2 = (int) (i2 * f5);
            Logger.m8702i(TAG, "resizeBitmapImage, height newWidth: " + i + ", newHeight: " + i2);
        }
        if (width == i && height == i2) {
            return source;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(source, i, i2, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    @NotNull
    public final Rect getScaledImageSize(@Nullable String filePath, float ratio) {
        Rect imageSize = getImageSize(String.valueOf(filePath));
        imageSize.set(0, 0, Math.round(imageSize.width() * ratio), Math.round(imageSize.height() * ratio));
        Logger.m8697d(TAG, "getScaledImageSize, ratio : " + ratio + ", size : " + imageSize);
        return imageSize;
    }

    public final boolean saveBitmapToFileCache(@Nullable Bitmap bitmap, @NotNull String path, @NotNull Bitmap.CompressFormat format, int quality) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(format, "format");
        return saveBitmapToFileCache(bitmap, path, format, quality, 0, false);
    }

    @JvmStatic
    public static final boolean makeJpg(@Nullable Bitmap bitmap, @NotNull String filePath, int quality, boolean recycle) throws Throwable {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (bitmap == null) {
            Logger.m8698e(TAG, "makeJpg# bitmap is null");
            return false;
        }
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            Logger.m8698e(TAG, "makeJpg# fail to make directory");
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists() && !file.createNewFile()) {
                    Logger.m8698e(TAG, "makeJpg# fail to make new file");
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream2);
                    if (recycle) {
                        bitmap.recycle();
                    }
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e) {
                        Logger.m8699e(TAG, e.getMessage(), e);
                        return true;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    Logger.m8699e(TAG, e.getMessage(), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            Logger.m8699e(TAG, e3.getMessage(), e3);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            Logger.m8699e(TAG, e5.getMessage(), e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5 A[Catch: all -> 0x009d, TryCatch #3 {all -> 0x009d, blocks: (B:27:0x0071, B:29:0x0096, B:36:0x00a5, B:38:0x00ad, B:40:0x00b1, B:42:0x00b7, B:52:0x00d3, B:43:0x00be, B:49:0x00cc, B:51:0x00d0, B:34:0x009f), top: B:80:0x0071 }] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean saveBitmapToFileCache(@Nullable Bitmap bitmap, @NotNull String path, @NotNull Bitmap.CompressFormat format, int quality, int backgroundColor, boolean canOverwrite) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(format, "format");
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        if (TextUtils.isEmpty(path)) {
            Logger.m8698e(TAG, "saveBitmapToFileCache# failed - The path is empty");
            return false;
        }
        File file = new File(path);
        if (file.getParentFile() == null) {
            Logger.m8698e(TAG, "saveBitmapToFileCache# failed - getParentFile is null.");
            return false;
        }
        File parentFile = file.getParentFile();
        Intrinsics.checkNotNull(parentFile);
        if (!parentFile.exists()) {
            File parentFile2 = file.getParentFile();
            Intrinsics.checkNotNull(parentFile2);
            if (!parentFile2.mkdir()) {
                AbstractC4539a.m3214x("saveBitmapToFileCache# failed - getParentFile is not exist and mkdir failed. path:", Logger.getEncode(path), TAG);
                return false;
            }
        }
        if (!canOverwrite && file.exists()) {
            AbstractC4539a.m3214x("saveBitmapToFileCache# failed - The file exists.", Logger.getEncode(path), TAG);
            return false;
        }
        try {
            Logger.m8702i(TAG, "saveBitmapToFileCache, start path: " + Logger.getEncode(path) + ", format: " + format + ", quality: " + quality);
            if (!canOverwrite || !file.exists()) {
                fileOutputStream = file.createNewFile() ? new FileOutputStream(file) : null;
                if (fileOutputStream != null) {
                    if (Bitmap.CompressFormat.JPEG == format) {
                        Bitmap bitmapCreateBitmap = createBitmap(bitmap, backgroundColor);
                        if (bitmapCreateBitmap == null) {
                            Logger.m8698e(TAG, "saveBitmapToFileCache, failed to create bitmap.");
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (IOException e) {
                                Logger.m8699e(TAG, "IOException", e);
                                return false;
                            }
                        }
                        bitmapCreateBitmap.compress(format, quality, fileOutputStream);
                        bitmapCreateBitmap.recycle();
                    } else if (Bitmap.CompressFormat.PNG == format) {
                        bitmap.compress(format, quality, fileOutputStream);
                    }
                    Logger.m8702i(TAG, "saveBitmapToFileCache, done path: " + Logger.getEncode(path));
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e2) {
                        Logger.m8699e(TAG, "IOException", e2);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                Logger.m8699e(TAG, "saveBitmapToFileCache", th);
            } finally {
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        Logger.m8699e(TAG, "IOException", e3);
                    }
                }
            }
        }
        return false;
    }
}
