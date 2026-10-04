package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/utils/ImageUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "saveBitmapToFileCache", "", "bitmap", "Landroid/graphics/Bitmap;", "path", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "backgroundColor", "createBitmap", "resizeBitmapImage", "source", "maxWidth", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageUtils.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/utils/ImageUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class ImageUtils {

    @NotNull
    public static final ImageUtils INSTANCE = new ImageUtils();

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$ImageUtils";

    private ImageUtils() {
    }

    @JvmStatic
    @Nullable
    public static final Bitmap createBitmap(@Nullable Bitmap bitmap, int backgroundColor) {
        if (bitmap == null || bitmap.getHeight() == 0 || bitmap.getWidth() == 0) {
            LoggerBase.INSTANCE.m7133e(TAG, "createBitmap, bitmap is null");
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
    @NotNull
    public static final Bitmap resizeBitmapImage(@NotNull Bitmap source, float maxWidth) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(source, "source");
        int maxTextureSize = BaseImageUtils.getMaxTextureSize();
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "resizeBitmapImage, maxWidth: " + maxWidth + ", maxHeight: " + maxTextureSize);
        int width = source.getWidth();
        int height = source.getHeight();
        float f = (float) width;
        if (maxWidth < f) {
            float f4 = maxWidth / f;
            i2 = (int) (height * f4);
            i = (int) (f * f4);
            companion.m7132d(TAG, AbstractC1038a.m1214o(i, i2, "resizeBitmapImage, width newWidth: ", ", newHeight: "));
        } else {
            i = width;
            i2 = height;
        }
        if (maxTextureSize < i2) {
            float f5 = maxTextureSize / height;
            i = (int) (i * f5);
            i2 = (int) (i2 * f5);
            companion.m7132d(TAG, AbstractC1038a.m1214o(i, i2, "resizeBitmapImage, height newWidth: ", ", newHeight: "));
        }
        if (width == i && height == i2) {
            return source;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(source, i, i2, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    @JvmStatic
    public static final boolean saveBitmapToFileCache(@Nullable Bitmap bitmap, @Nullable String path, @Nullable Bitmap.CompressFormat format, int quality, int backgroundColor) {
        File parentFile;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (TextUtils.isEmpty(path)) {
                LoggerBase.INSTANCE.m7133e(TAG, "saveBitmapToFileCache# failed - The path is empty");
                return false;
            }
            File file = path != null ? new File(path) : null;
            if ((file != null ? file.getParentFile() : null) == null || !((parentFile = file.getParentFile()) == null || parentFile.exists())) {
                LoggerBase.Companion companion = LoggerBase.INSTANCE;
                AbstractC0000a.m23t("saveBitmapToFileCache# failed - getParentFile is null. path:", companion.getEncode(path), companion, TAG);
            } else {
                if (file.exists()) {
                    LoggerBase.Companion companion2 = LoggerBase.INSTANCE;
                    AbstractC0000a.m23t("saveBitmapToFileCache# failed - The file exists.", companion2.getEncode(path), companion2, TAG);
                    return false;
                }
                try {
                    LoggerBase.Companion companion3 = LoggerBase.INSTANCE;
                    companion3.m7137i(TAG, "saveBitmapToFileCache, start path: " + companion3.getEncode(path) + ", format: " + format + ", quality: " + quality);
                    if (!file.createNewFile()) {
                        return false;
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            if (Bitmap.CompressFormat.JPEG == format) {
                                Bitmap bitmapCreateBitmap = createBitmap(bitmap, backgroundColor);
                                if (bitmapCreateBitmap == null) {
                                    companion3.m7133e(TAG, "saveBitmapToFileCache, failed to create bitmap.");
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    return false;
                                }
                                bitmapCreateBitmap.compress(format, quality, fileOutputStream);
                                bitmapCreateBitmap.recycle();
                            } else if (Bitmap.CompressFormat.PNG == format) {
                                bitmap.compress(format, quality, fileOutputStream);
                            }
                            companion3.m7137i(TAG, "saveBitmapToFileCache, done path: " + companion3.getEncode(path));
                            CloseableKt.closeFinally(fileOutputStream, null);
                            return true;
                        } finally {
                        }
                    } catch (FileNotFoundException e) {
                        LoggerBase.INSTANCE.m7134e(TAG, "saveBitmapToFileCache FileNotFoundException ", e);
                        return false;
                    } catch (IOException e2) {
                        LoggerBase.INSTANCE.m7134e(TAG, "saveBitmapToFileCache IOException ", e2);
                        return false;
                    }
                } catch (IOException e3) {
                    LoggerBase.INSTANCE.m7134e(TAG, "saveBitmapToFileCache IOException ", e3);
                    return false;
                }
            }
        }
        return false;
    }
}
