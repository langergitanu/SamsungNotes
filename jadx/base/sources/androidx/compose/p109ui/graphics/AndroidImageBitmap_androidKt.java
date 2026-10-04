package androidx.compose.p109ui.graphics;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import androidx.compose.p109ui.graphics.ImageBitmapConfig;
import androidx.compose.p109ui.graphics.colorspace.ColorSpace;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000e\u001a\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0006*\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"ActualImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", ExternalDataConstants.EmbeddingConfig.KEY, "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "Landroid/graphics/Bitmap;", "asImageBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidImageBitmap_androidKt {
    @NotNull
    /* JADX INFO: renamed from: ActualImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m18393ActualImageBitmapx__hDU(int i, int i2, int i4, boolean z, @NotNull ColorSpace colorSpace) {
        m18394toBitmapConfig1JJdX4A(i4);
        return new AndroidImageBitmap(Bitmap.createBitmap((DisplayMetrics) null, i, i2, m18394toBitmapConfig1JJdX4A(i4), z, AndroidColorSpace_androidKt.toAndroidColorSpace(colorSpace)));
    }

    @NotNull
    public static final Bitmap asAndroidBitmap(@NotNull ImageBitmap imageBitmap) {
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).getBitmap();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    @NotNull
    public static final ImageBitmap asImageBitmap(@NotNull Bitmap bitmap) {
        return new AndroidImageBitmap(bitmap);
    }

    @NotNull
    /* JADX INFO: renamed from: toBitmapConfig-1JJdX4A, reason: not valid java name */
    public static final Bitmap.Config m18394toBitmapConfig1JJdX4A(int i) {
        ImageBitmapConfig.Companion companion = ImageBitmapConfig.INSTANCE;
        return ImageBitmapConfig.m18741equalsimpl0(i, companion.m18746getArgb8888_sVssgQ()) ? Bitmap.Config.ARGB_8888 : ImageBitmapConfig.m18741equalsimpl0(i, companion.m18745getAlpha8_sVssgQ()) ? Bitmap.Config.ALPHA_8 : ImageBitmapConfig.m18741equalsimpl0(i, companion.m18749getRgb565_sVssgQ()) ? Bitmap.Config.RGB_565 : ImageBitmapConfig.m18741equalsimpl0(i, companion.m18747getF16_sVssgQ()) ? Bitmap.Config.RGBA_F16 : ImageBitmapConfig.m18741equalsimpl0(i, companion.m18748getGpu_sVssgQ()) ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public static final int toImageConfig(@NotNull Bitmap.Config config) {
        return config == Bitmap.Config.ALPHA_8 ? ImageBitmapConfig.INSTANCE.m18745getAlpha8_sVssgQ() : config == Bitmap.Config.RGB_565 ? ImageBitmapConfig.INSTANCE.m18749getRgb565_sVssgQ() : config == Bitmap.Config.ARGB_4444 ? ImageBitmapConfig.INSTANCE.m18746getArgb8888_sVssgQ() : config == Bitmap.Config.RGBA_F16 ? ImageBitmapConfig.INSTANCE.m18747getF16_sVssgQ() : config == Bitmap.Config.HARDWARE ? ImageBitmapConfig.INSTANCE.m18748getGpu_sVssgQ() : ImageBitmapConfig.INSTANCE.m18746getArgb8888_sVssgQ();
    }
}
