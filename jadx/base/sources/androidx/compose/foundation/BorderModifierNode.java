package androidx.compose.foundation;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.draw.CacheDrawModifierNode;
import androidx.compose.p109ui.draw.CacheDrawScope;
import androidx.compose.p109ui.draw.DrawModifierKt;
import androidx.compose.p109ui.draw.DrawResult;
import androidx.compose.p109ui.geometry.CornerRadius;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RoundRectKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.ClipOp;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.ImageBitmapConfig;
import androidx.compose.p109ui.graphics.ImageBitmapKt;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathOperation;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, m13886d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", VMetaDataKey.META_KEY_SHAPE, "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", TokenizerME.NO_SPLIT, "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Border.kt\nandroidx/compose/foundation/BorderModifierNode\n+ 2 Border.kt\nandroidx/compose/foundation/BorderCache\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CanvasDrawScope.kt\nandroidx/compose/ui/graphics/drawscope/CanvasDrawScope\n+ 5 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,516:1\n386#2,26:517\n412#2,4:544\n421#2,6:557\n427#2:589\n428#2,2:598\n1#3:543\n546#4,9:548\n555#4,8:590\n128#5,3:563\n184#5,6:566\n272#5,14:572\n132#5,3:586\n*S KotlinDebug\n*F\n+ 1 Border.kt\nandroidx/compose/foundation/BorderModifierNode\n*L\n263#1:517,26\n263#1:544,4\n263#1:557,6\n263#1:589\n263#1:598,2\n263#1:543\n263#1:548,9\n263#1:590,8\n269#1:563,3\n281#1:566,6\n281#1:572,14\n269#1:586,3\n*E\n"})
public final class BorderModifierNode extends DelegatingNode {
    public static final int $stable = 8;

    @Nullable
    private BorderCache borderCache;

    @NotNull
    private Brush brush;

    @NotNull
    private final CacheDrawModifierNode drawWithCacheModifierNode;

    @NotNull
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Type inference failed for: r24v3, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, final Brush brush, final Outline.Generic generic, boolean z, float f) throws Throwable {
        int iM18746getArgb8888_sVssgQ;
        ColorFilter colorFilterM18566tintxETnrds$default;
        BorderCache borderCache;
        Ref.ObjectRef objectRef;
        ImageBitmap imageBitmap;
        Canvas canvas;
        float f4;
        float f5;
        DrawContext drawContext;
        long j;
        if (z) {
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode.drawGenericBorder.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ContentDrawScope contentDrawScope) {
                    contentDrawScope.drawContent();
                    DrawScope.m19065drawPathGBMwjPU$default(contentDrawScope, generic.getPath(), brush, 0.0f, null, null, 0, 60, null);
                }
            });
        }
        if (brush instanceof SolidColor) {
            iM18746getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m18745getAlpha8_sVssgQ();
            colorFilterM18566tintxETnrds$default = ColorFilter.Companion.m18566tintxETnrds$default(ColorFilter.INSTANCE, ((SolidColor) brush).getValue(), 0, 2, null);
        } else {
            iM18746getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m18746getArgb8888_sVssgQ();
            colorFilterM18566tintxETnrds$default = null;
        }
        int i = iM18746getArgb8888_sVssgQ;
        final Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        Path pathObtainPath = borderCache2.obtainPath();
        pathObtainPath.reset();
        Path.addRect$default(pathObtainPath, bounds, null, 2, null);
        pathObtainPath.mo18417opN5in7k0(pathObtainPath, generic.getPath(), PathOperation.INSTANCE.m18817getDifferenceb3I0S0c());
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final long jIntSize = IntSizeKt.IntSize((int) Math.ceil(bounds.getWidth()), (int) Math.ceil(bounds.getHeight()));
        BorderCache borderCache3 = this.borderCache;
        Intrinsics.checkNotNull(borderCache3);
        ImageBitmap imageBitmap2 = borderCache3.imageBitmap;
        Canvas canvas2 = borderCache3.canvas;
        ImageBitmapConfig imageBitmapConfigM18738boximpl = imageBitmap2 != null ? ImageBitmapConfig.m18738boximpl(imageBitmap2.mo18392getConfig_sVssgQ()) : null;
        boolean z2 = false;
        if (imageBitmapConfigM18738boximpl == null ? false : ImageBitmapConfig.m18741equalsimpl0(imageBitmapConfigM18738boximpl.m18744unboximpl(), ImageBitmapConfig.INSTANCE.m18746getArgb8888_sVssgQ())) {
            z2 = true;
        } else {
            if (ImageBitmapConfig.m18740equalsimpl(i, imageBitmap2 != null ? ImageBitmapConfig.m18738boximpl(imageBitmap2.mo18392getConfig_sVssgQ()) : null)) {
            }
        }
        if (imageBitmap2 == null || canvas2 == null || Size.m18353getWidthimpl(cacheDrawScope.m18174getSizeNHjbRc()) > imageBitmap2.getWidth() || Size.m18350getHeightimpl(cacheDrawScope.m18174getSizeNHjbRc()) > imageBitmap2.getHeight() || !z2) {
            borderCache = borderCache3;
            objectRef = objectRef2;
            ImageBitmap imageBitmapM18751ImageBitmapx__hDU$default = ImageBitmapKt.m18751ImageBitmapx__hDU$default(IntSize.m21138getWidthimpl(jIntSize), IntSize.m21137getHeightimpl(jIntSize), i, false, null, 24, null);
            borderCache.imageBitmap = imageBitmapM18751ImageBitmapx__hDU$default;
            Canvas Canvas = androidx.compose.p109ui.graphics.CanvasKt.Canvas(imageBitmapM18751ImageBitmapx__hDU$default);
            borderCache.canvas = Canvas;
            imageBitmap = imageBitmapM18751ImageBitmapx__hDU$default;
            canvas = Canvas;
        } else {
            borderCache = borderCache3;
            objectRef = objectRef2;
            canvas = canvas2;
            imageBitmap = imageBitmap2;
        }
        CanvasDrawScope canvasDrawScope = borderCache.canvasDrawScope;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            borderCache.canvasDrawScope = canvasDrawScope;
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        long jM21150toSizeozmzZPI = IntSizeKt.m21150toSizeozmzZPI(jIntSize);
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m18996setSizeuvyYCjk(jM21150toSizeozmzZPI);
        canvas.save();
        long jM18551getBlack0d7_KjU = Color.INSTANCE.m18551getBlack0d7_KjU();
        BlendMode.Companion companion = BlendMode.INSTANCE;
        DrawScope.m19070drawRectnJ9OG0$default(canvasDrawScope2, jM18551getBlack0d7_KjU, 0L, jM21150toSizeozmzZPI, 0.0f, null, null, companion.m18440getClear0nO6VwU(), 58, null);
        float f6 = -bounds.getLeft();
        float f7 = -bounds.getTop();
        canvasDrawScope2.getDrawContext().getTransform().translate(f6, f7);
        try {
            final Ref.ObjectRef objectRef3 = objectRef;
            Canvas canvas4 = canvas;
            final ColorFilter colorFilter = colorFilterM18566tintxETnrds$default;
            ?? r24 = imageBitmap;
            f5 = f7;
            f4 = f6;
            try {
                DrawScope.m19065drawPathGBMwjPU$default(canvasDrawScope2, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f8 = 1;
                float fM18353getWidthimpl = (Size.m18353getWidthimpl(canvasDrawScope2.mo19076getSizeNHjbRc()) + f8) / Size.m18353getWidthimpl(canvasDrawScope2.mo19076getSizeNHjbRc());
                float fM18350getHeightimpl = (Size.m18350getHeightimpl(canvasDrawScope2.mo19076getSizeNHjbRc()) + f8) / Size.m18350getHeightimpl(canvasDrawScope2.mo19076getSizeNHjbRc());
                long jMo19075getCenterF1C5BW0 = canvasDrawScope2.mo19075getCenterF1C5BW0();
                DrawContext drawContext2 = canvasDrawScope2.getDrawContext();
                long jMo18997getSizeNHjbRc = drawContext2.mo18997getSizeNHjbRc();
                drawContext2.getCanvas().save();
                try {
                    drawContext2.getTransform().mo19004scale0AR0LA0(fM18353getWidthimpl, fM18350getHeightimpl, jMo19075getCenterF1C5BW0);
                    j = jMo18997getSizeNHjbRc;
                    try {
                        DrawScope.m19065drawPathGBMwjPU$default(canvasDrawScope2, pathObtainPath, brush, 0.0f, null, null, companion.m18440getClear0nO6VwU(), 28, null);
                        drawContext2.getCanvas().restore();
                        drawContext2.mo18998setSizeuvyYCjk(j);
                        canvasDrawScope2.getDrawContext().getTransform().translate(-f4, -f5);
                        canvas4.restore();
                        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
                        drawParams3.setDensity(density);
                        drawParams3.setLayoutDirection(layoutDirection2);
                        drawParams3.setCanvas(canvas3);
                        drawParams3.m18996setSizeuvyYCjk(size);
                        r24.prepareToDraw();
                        objectRef3.element = r24;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode.drawGenericBorder.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                invoke2(contentDrawScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull ContentDrawScope contentDrawScope) {
                                contentDrawScope.drawContent();
                                float left = bounds.getLeft();
                                float top = bounds.getTop();
                                Ref.ObjectRef<ImageBitmap> objectRef4 = objectRef3;
                                long j2 = jIntSize;
                                ColorFilter colorFilter2 = colorFilter;
                                contentDrawScope.getDrawContext().getTransform().translate(left, top);
                                try {
                                    DrawScope.m19059drawImageAZ2fEMs$default(contentDrawScope, objectRef4.element, 0L, j2, 0L, 0L, 0.0f, null, colorFilter2, 0, 0, 890, null);
                                } finally {
                                    contentDrawScope.getDrawContext().getTransform().translate(-left, -top);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        th = th;
                        drawContext = drawContext2;
                        drawContext.getCanvas().restore();
                        drawContext.mo18998setSizeuvyYCjk(j);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    drawContext = drawContext2;
                    j = jMo18997getSizeNHjbRc;
                }
            } catch (Throwable th3) {
                th = th3;
                canvasDrawScope2.getDrawContext().getTransform().translate(-f4, -f5);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            f4 = f6;
            f5 = f7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    public final DrawResult m15426drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long jM18334getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m18334getTopLeftCornerRadiuskKHJgLs();
            final float f4 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ContentDrawScope contentDrawScope) {
                    contentDrawScope.drawContent();
                    if (z) {
                        DrawScope.m19071drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, jM18334getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float fM18259getXimpl = CornerRadius.m18259getXimpl(jM18334getTopLeftCornerRadiuskKHJgLs);
                    float f5 = f4;
                    if (fM18259getXimpl >= f5) {
                        DrawScope.m19071drawRoundRectZuiqVtQ$default(contentDrawScope, brush, j, j2, BorderKt.m15424shrinkKibmq7A(jM18334getTopLeftCornerRadiuskKHJgLs, f5), 0.0f, stroke, null, 0, JPEG.RST0, null);
                        return;
                    }
                    float f6 = f;
                    float fM18353getWidthimpl = Size.m18353getWidthimpl(contentDrawScope.mo19076getSizeNHjbRc()) - f;
                    float fM18350getHeightimpl = Size.m18350getHeightimpl(contentDrawScope.mo19076getSizeNHjbRc()) - f;
                    int iM18513getDifferencertfAjoo = ClipOp.INSTANCE.m18513getDifferencertfAjoo();
                    Brush brush2 = brush;
                    long j3 = jM18334getTopLeftCornerRadiuskKHJgLs;
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        drawContext.getTransform().mo19000clipRectN_I0leg(f6, f6, fM18353getWidthimpl, fM18350getHeightimpl, iM18513getDifferencertfAjoo);
                        DrawScope.m19071drawRoundRectZuiqVtQ$default(contentDrawScope, brush2, 0L, 0L, j3, 0.0f, null, null, 0, 246, null);
                    } finally {
                        AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
                    }
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        final Path pathCreateRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                DrawScope.m19065drawPathGBMwjPU$default(contentDrawScope, pathCreateRoundRectPath, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }

    @NotNull
    public final Brush getBrush() {
        return this.brush;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    public final void setBrush(@NotNull Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setShape(@NotNull Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* JADX INFO: renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m15428setWidth0680j_4(float f) {
        if (C2256Dp.m20973equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
                if (cacheDrawScope.mo15546toPx0680j_4(this.this$0.getWidth()) < 0.0f || Size.m18352getMinDimensionimpl(cacheDrawScope.m18174getSizeNHjbRc()) <= 0.0f) {
                    return BorderKt.drawContentWithoutBorder(cacheDrawScope);
                }
                float f4 = 2;
                float fMin = Math.min(C2256Dp.m20973equalsimpl0(this.this$0.getWidth(), C2256Dp.INSTANCE.m20986getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo15546toPx0680j_4(this.this$0.getWidth())), (float) Math.ceil(Size.m18352getMinDimensionimpl(cacheDrawScope.m18174getSizeNHjbRc()) / f4));
                float f5 = fMin / f4;
                long jOffset = OffsetKt.Offset(f5, f5);
                long jSize = SizeKt.Size(Size.m18353getWidthimpl(cacheDrawScope.m18174getSizeNHjbRc()) - fMin, Size.m18350getHeightimpl(cacheDrawScope.m18174getSizeNHjbRc()) - fMin);
                boolean z = f4 * fMin > Size.m18352getMinDimensionimpl(cacheDrawScope.m18174getSizeNHjbRc());
                Outline outlineMo15457createOutlinePq9zytI = this.this$0.getShape().mo15457createOutlinePq9zytI(cacheDrawScope.m18174getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                if (outlineMo15457createOutlinePq9zytI instanceof Outline.Generic) {
                    BorderModifierNode borderModifierNode = this.this$0;
                    return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.getBrush(), (Outline.Generic) outlineMo15457createOutlinePq9zytI, z, fMin);
                }
                if (outlineMo15457createOutlinePq9zytI instanceof Outline.Rounded) {
                    BorderModifierNode borderModifierNode2 = this.this$0;
                    return borderModifierNode2.m15426drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode2.getBrush(), (Outline.Rounded) outlineMo15457createOutlinePq9zytI, jOffset, jSize, z, fMin);
                }
                if (outlineMo15457createOutlinePq9zytI instanceof Outline.Rectangle) {
                    return BorderKt.m15423drawRectBorderNsqcLGU(cacheDrawScope, this.this$0.getBrush(), jOffset, jSize, z, fMin);
                }
                throw new NoWhenBranchMatchedException();
            }
        }));
    }
}
