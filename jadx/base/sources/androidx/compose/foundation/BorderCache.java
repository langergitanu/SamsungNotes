package androidx.compose.foundation;

import androidx.compose.p109ui.draw.CacheDrawScope;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.ImageBitmapConfig;
import androidx.compose.p109ui.graphics.ImageBitmapKt;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\tJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J@\u0010\u0018\u001a\u00020\u0003*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, m13886d2 = {"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "obtainPath", "toString", "", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", ExternalDataConstants.EmbeddingConfig.KEY, "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Border.kt\nandroidx/compose/foundation/BorderCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CanvasDrawScope.kt\nandroidx/compose/ui/graphics/drawscope/CanvasDrawScope\n*L\n1#1,516:1\n1#2:517\n546#3,17:518\n*S KotlinDebug\n*F\n+ 1 Border.kt\nandroidx/compose/foundation/BorderCache\n*L\n413#1:518,17\n*E\n"})
final /* data */ class BorderCache {

    @Nullable
    private Path borderPath;

    @Nullable
    private Canvas canvas;

    @Nullable
    private CanvasDrawScope canvasDrawScope;

    @Nullable
    private ImageBitmap imageBitmap;

    public BorderCache() {
        this(null, null, null, null, 15, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ImageBitmap getImageBitmap() {
        return this.imageBitmap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Canvas getCanvas() {
        return this.canvas;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Path getBorderPath() {
        return this.borderPath;
    }

    public static /* synthetic */ BorderCache copy$default(BorderCache borderCache, ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBitmap = borderCache.imageBitmap;
        }
        if ((i & 2) != 0) {
            canvas = borderCache.canvas;
        }
        if ((i & 4) != 0) {
            canvasDrawScope = borderCache.canvasDrawScope;
        }
        if ((i & 8) != 0) {
            path = borderCache.borderPath;
        }
        return borderCache.copy(imageBitmap, canvas, canvasDrawScope, path);
    }

    @NotNull
    public final BorderCache copy(@Nullable ImageBitmap imageBitmap, @Nullable Canvas canvas, @Nullable CanvasDrawScope canvasDrawScope, @Nullable Path borderPath) {
        return new BorderCache(imageBitmap, canvas, canvasDrawScope, borderPath);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    @NotNull
    /* JADX INFO: renamed from: drawBorderCache-EMwLDEs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ImageBitmap m15417drawBorderCacheEMwLDEs(@NotNull CacheDrawScope cacheDrawScope, long j, int i, @NotNull Function1<? super DrawScope, Unit> function1) {
        int i2;
        CanvasDrawScope canvasDrawScope;
        ImageBitmap imageBitmapM18751ImageBitmapx__hDU$default = this.imageBitmap;
        Canvas Canvas = this.canvas;
        ImageBitmapConfig imageBitmapConfigM18738boximpl = imageBitmapM18751ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m18738boximpl(imageBitmapM18751ImageBitmapx__hDU$default.mo18392getConfig_sVssgQ()) : null;
        boolean z = false;
        if (!(imageBitmapConfigM18738boximpl == null ? false : ImageBitmapConfig.m18741equalsimpl0(imageBitmapConfigM18738boximpl.m18744unboximpl(), ImageBitmapConfig.INSTANCE.m18746getArgb8888_sVssgQ()))) {
            i2 = i;
            if (ImageBitmapConfig.m18740equalsimpl(i2, imageBitmapM18751ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m18738boximpl(imageBitmapM18751ImageBitmapx__hDU$default.mo18392getConfig_sVssgQ()) : null)) {
            }
            if (imageBitmapM18751ImageBitmapx__hDU$default != null || Canvas == null || Size.m18353getWidthimpl(cacheDrawScope.m18174getSizeNHjbRc()) > imageBitmapM18751ImageBitmapx__hDU$default.getWidth() || Size.m18350getHeightimpl(cacheDrawScope.m18174getSizeNHjbRc()) > imageBitmapM18751ImageBitmapx__hDU$default.getHeight() || !z) {
                imageBitmapM18751ImageBitmapx__hDU$default = ImageBitmapKt.m18751ImageBitmapx__hDU$default(IntSize.m21138getWidthimpl(j), IntSize.m21137getHeightimpl(j), i2, false, null, 24, null);
                this.imageBitmap = imageBitmapM18751ImageBitmapx__hDU$default;
                Canvas = androidx.compose.p109ui.graphics.CanvasKt.Canvas(imageBitmapM18751ImageBitmapx__hDU$default);
                this.canvas = Canvas;
            }
            canvasDrawScope = this.canvasDrawScope;
            if (canvasDrawScope == null) {
                canvasDrawScope = new CanvasDrawScope();
                this.canvasDrawScope = canvasDrawScope;
            }
            CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
            long jM21150toSizeozmzZPI = IntSizeKt.m21150toSizeozmzZPI(j);
            LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
            CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
            Density density = drawParams.getDensity();
            LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
            Canvas canvas = drawParams.getCanvas();
            long size = drawParams.getSize();
            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
            drawParams2.setDensity(cacheDrawScope);
            drawParams2.setLayoutDirection(layoutDirection);
            drawParams2.setCanvas(Canvas);
            drawParams2.m18996setSizeuvyYCjk(jM21150toSizeozmzZPI);
            Canvas.save();
            ImageBitmap imageBitmap = imageBitmapM18751ImageBitmapx__hDU$default;
            DrawScope.m19070drawRectnJ9OG0$default(canvasDrawScope2, Color.INSTANCE.m18551getBlack0d7_KjU(), 0L, jM21150toSizeozmzZPI, 0.0f, null, null, BlendMode.INSTANCE.m18440getClear0nO6VwU(), 58, null);
            function1.invoke(canvasDrawScope2);
            Canvas.restore();
            CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
            drawParams3.setDensity(density);
            drawParams3.setLayoutDirection(layoutDirection2);
            drawParams3.setCanvas(canvas);
            drawParams3.m18996setSizeuvyYCjk(size);
            imageBitmap.prepareToDraw();
            return imageBitmap;
        }
        i2 = i;
        z = true;
        if (imageBitmapM18751ImageBitmapx__hDU$default != null) {
            imageBitmapM18751ImageBitmapx__hDU$default = ImageBitmapKt.m18751ImageBitmapx__hDU$default(IntSize.m21138getWidthimpl(j), IntSize.m21137getHeightimpl(j), i2, false, null, 24, null);
            this.imageBitmap = imageBitmapM18751ImageBitmapx__hDU$default;
            Canvas = androidx.compose.p109ui.graphics.CanvasKt.Canvas(imageBitmapM18751ImageBitmapx__hDU$default);
            this.canvas = Canvas;
        }
        canvasDrawScope = this.canvasDrawScope;
        if (canvasDrawScope == null) {
        }
        CanvasDrawScope canvasDrawScope22 = canvasDrawScope;
        long jM21150toSizeozmzZPI2 = IntSizeKt.m21150toSizeozmzZPI(j);
        LayoutDirection layoutDirection3 = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams4 = canvasDrawScope22.getDrawParams();
        Density density2 = drawParams4.getDensity();
        LayoutDirection layoutDirection22 = drawParams4.getLayoutDirection();
        Canvas canvas2 = drawParams4.getCanvas();
        long size2 = drawParams4.getSize();
        CanvasDrawScope.DrawParams drawParams22 = canvasDrawScope22.getDrawParams();
        drawParams22.setDensity(cacheDrawScope);
        drawParams22.setLayoutDirection(layoutDirection3);
        drawParams22.setCanvas(Canvas);
        drawParams22.m18996setSizeuvyYCjk(jM21150toSizeozmzZPI2);
        Canvas.save();
        ImageBitmap imageBitmap2 = imageBitmapM18751ImageBitmapx__hDU$default;
        DrawScope.m19070drawRectnJ9OG0$default(canvasDrawScope22, Color.INSTANCE.m18551getBlack0d7_KjU(), 0L, jM21150toSizeozmzZPI2, 0.0f, null, null, BlendMode.INSTANCE.m18440getClear0nO6VwU(), 58, null);
        function1.invoke(canvasDrawScope22);
        Canvas.restore();
        CanvasDrawScope.DrawParams drawParams32 = canvasDrawScope22.getDrawParams();
        drawParams32.setDensity(density2);
        drawParams32.setLayoutDirection(layoutDirection22);
        drawParams32.setCanvas(canvas2);
        drawParams32.m18996setSizeuvyYCjk(size2);
        imageBitmap2.prepareToDraw();
        return imageBitmap2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) other;
        return Intrinsics.areEqual(this.imageBitmap, borderCache.imageBitmap) && Intrinsics.areEqual(this.canvas, borderCache.canvas) && Intrinsics.areEqual(this.canvasDrawScope, borderCache.canvasDrawScope) && Intrinsics.areEqual(this.borderPath, borderCache.borderPath);
    }

    public int hashCode() {
        ImageBitmap imageBitmap = this.imageBitmap;
        int iHashCode = (imageBitmap == null ? 0 : imageBitmap.hashCode()) * 31;
        Canvas canvas = this.canvas;
        int iHashCode2 = (iHashCode + (canvas == null ? 0 : canvas.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        int iHashCode3 = (iHashCode2 + (canvasDrawScope == null ? 0 : canvasDrawScope.hashCode())) * 31;
        Path path = this.borderPath;
        return iHashCode3 + (path != null ? path.hashCode() : 0);
    }

    @NotNull
    public final Path obtainPath() {
        Path path = this.borderPath;
        if (path != null) {
            return path;
        }
        Path Path = AndroidPath_androidKt.Path();
        this.borderPath = Path;
        return Path;
    }

    @NotNull
    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + PropertyUtils.MAPPED_DELIM2;
    }

    public BorderCache(@Nullable ImageBitmap imageBitmap, @Nullable Canvas canvas, @Nullable CanvasDrawScope canvasDrawScope, @Nullable Path path) {
        this.imageBitmap = imageBitmap;
        this.canvas = canvas;
        this.canvasDrawScope = canvasDrawScope;
        this.borderPath = path;
    }

    public /* synthetic */ BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageBitmap, (i & 2) != 0 ? null : canvas, (i & 4) != 0 ? null : canvasDrawScope, (i & 8) != 0 ? null : path);
    }
}
