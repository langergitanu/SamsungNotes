package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.graphics.colorspace.ColorSpace;
import androidx.compose.p109ui.graphics.colorspace.ColorSpaces;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aP\u0010\r\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m13886d2 = {"ImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", ExternalDataConstants.EmbeddingConfig.KEY, "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "toPixelMap", "Landroidx/compose/ui/graphics/PixelMap;", "startX", "startY", "buffer", "", "bufferOffset", "stride", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ImageBitmapKt {
    @NotNull
    /* JADX INFO: renamed from: ImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m18750ImageBitmapx__hDU(int i, int i2, int i4, boolean z, @NotNull ColorSpace colorSpace) {
        return AndroidImageBitmap_androidKt.m18393ActualImageBitmapx__hDU(i, i2, i4, z, colorSpace);
    }

    /* JADX INFO: renamed from: ImageBitmap-x__-hDU$default, reason: not valid java name */
    public static /* synthetic */ ImageBitmap m18751ImageBitmapx__hDU$default(int i, int i2, int i4, boolean z, ColorSpace colorSpace, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = ImageBitmapConfig.INSTANCE.m18746getArgb8888_sVssgQ();
        }
        if ((i5 & 8) != 0) {
            z = true;
        }
        if ((i5 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return m18750ImageBitmapx__hDU(i, i2, i4, z, colorSpace);
    }

    @NotNull
    public static final PixelMap toPixelMap(@NotNull ImageBitmap imageBitmap, int i, int i2, int i4, int i5, @NotNull int[] iArr, int i6, int i7) {
        imageBitmap.readPixels(iArr, i, i2, i4, i5, i6, i7);
        return new PixelMap(iArr, i4, i5, i6, i7);
    }

    public static /* synthetic */ PixelMap toPixelMap$default(ImageBitmap imageBitmap, int i, int i2, int i4, int i5, int[] iArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = 0;
        }
        if ((i8 & 2) != 0) {
            i2 = 0;
        }
        if ((i8 & 4) != 0) {
            i4 = imageBitmap.getWidth();
        }
        if ((i8 & 8) != 0) {
            i5 = imageBitmap.getHeight();
        }
        if ((i8 & 16) != 0) {
            iArr = new int[i4 * i5];
        }
        if ((i8 & 32) != 0) {
            i6 = 0;
        }
        if ((i8 & 64) != 0) {
            i7 = i4;
        }
        return toPixelMap(imageBitmap, i, i2, i4, i5, iArr, i6, i7);
    }
}
