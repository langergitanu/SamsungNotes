package androidx.compose.p109ui.graphics.vector;

import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.CanvasKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.ImageBitmapConfig;
import androidx.compose.p109ui.graphics.ImageBitmapKt;
import androidx.compose.p109ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JI\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190\u001c¢\u0006\u0002\b\u001eø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J$\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\f\u0010'\u001a\u00020\u0019*\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/DrawCache;", "", "()V", "cacheScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "cachedCanvas", "Landroidx/compose/ui/graphics/Canvas;", ExternalDataConstants.EmbeddingConfig.KEY, "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "I", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "mCachedImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMCachedImage$annotations", "getMCachedImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setMCachedImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "scopeDensity", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "drawCachedImage", "", "density", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drawCachedImage-FqjB98A", "(IJLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)V", "drawInto", "target", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clear", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDrawCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawCache.kt\nandroidx/compose/ui/graphics/vector/DrawCache\n+ 2 CanvasDrawScope.kt\nandroidx/compose/ui/graphics/drawscope/CanvasDrawScope\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,113:1\n546#2,17:114\n42#3,7:131\n*S KotlinDebug\n*F\n+ 1 DrawCache.kt\nandroidx/compose/ui/graphics/vector/DrawCache\n*L\n82#1:114,17\n98#1:131,7\n*E\n"})
public final class DrawCache {
    public static final int $stable = 8;

    @Nullable
    private Canvas cachedCanvas;

    @Nullable
    private ImageBitmap mCachedImage;

    @Nullable
    private Density scopeDensity;

    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private long size = IntSize.INSTANCE.m21143getZeroYbymL2g();
    private int config = ImageBitmapConfig.INSTANCE.m18746getArgb8888_sVssgQ();

    @NotNull
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();

    private final void clear(DrawScope drawScope) {
        DrawScope.m19070drawRectnJ9OG0$default(drawScope, Color.INSTANCE.m18551getBlack0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.INSTANCE.m18440getClear0nO6VwU(), 62, null);
    }

    public static /* synthetic */ void drawInto$default(DrawCache drawCache, DrawScope drawScope, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            colorFilter = null;
        }
        drawCache.drawInto(drawScope, f, colorFilter);
    }

    /* JADX INFO: renamed from: drawCachedImage-FqjB98A, reason: not valid java name */
    public final void m19203drawCachedImageFqjB98A(int config, long size, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Function1<? super DrawScope, Unit> block) {
        this.scopeDensity = density;
        this.layoutDirection = layoutDirection;
        ImageBitmap imageBitmapM18751ImageBitmapx__hDU$default = this.mCachedImage;
        Canvas Canvas = this.cachedCanvas;
        if (imageBitmapM18751ImageBitmapx__hDU$default == null || Canvas == null || IntSize.m21138getWidthimpl(size) > imageBitmapM18751ImageBitmapx__hDU$default.getWidth() || IntSize.m21137getHeightimpl(size) > imageBitmapM18751ImageBitmapx__hDU$default.getHeight() || !ImageBitmapConfig.m18741equalsimpl0(this.config, config)) {
            imageBitmapM18751ImageBitmapx__hDU$default = ImageBitmapKt.m18751ImageBitmapx__hDU$default(IntSize.m21138getWidthimpl(size), IntSize.m21137getHeightimpl(size), config, false, null, 24, null);
            Canvas = CanvasKt.Canvas(imageBitmapM18751ImageBitmapx__hDU$default);
            this.mCachedImage = imageBitmapM18751ImageBitmapx__hDU$default;
            this.cachedCanvas = Canvas;
            this.config = config;
        }
        this.size = size;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long jM21150toSizeozmzZPI = IntSizeKt.m21150toSizeozmzZPI(size);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density density2 = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas = drawParams.getCanvas();
        long size2 = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(Canvas);
        drawParams2.m18996setSizeuvyYCjk(jM21150toSizeozmzZPI);
        Canvas.save();
        clear(canvasDrawScope);
        block.invoke(canvasDrawScope);
        Canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(density2);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas);
        drawParams3.m18996setSizeuvyYCjk(size2);
        imageBitmapM18751ImageBitmapx__hDU$default.prepareToDraw();
    }

    public final void drawInto(@NotNull DrawScope target, float alpha, @Nullable ColorFilter colorFilter) {
        ImageBitmap imageBitmap = this.mCachedImage;
        if (!(imageBitmap != null)) {
            InlineClassHelperKt.throwIllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        DrawScope.m19059drawImageAZ2fEMs$default(target, imageBitmap, 0L, this.size, 0L, 0L, alpha, null, colorFilter, 0, 0, 858, null);
    }

    @Nullable
    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(@Nullable ImageBitmap imageBitmap) {
        this.mCachedImage = imageBitmap;
    }

    @PublishedApi
    public static /* synthetic */ void getMCachedImage$annotations() {
    }
}
