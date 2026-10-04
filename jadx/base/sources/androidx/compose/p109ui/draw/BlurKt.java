package androidx.compose.p109ui.draw;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.RenderEffectKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.TileMode;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m13886d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBlur.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blur.kt\nandroidx/compose/ui/draw/BlurKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,154:1\n149#2:155\n*S KotlinDebug\n*F\n+ 1 Blur.kt\nandroidx/compose/ui/draw/BlurKt\n*L\n112#1:155\n*E\n"})
public final class BlurKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m18159blur1fqSgw(@NotNull Modifier modifier, final float f, final float f4, @NotNull final Shape shape) {
        int iM18899getDecal3opZhB0;
        final boolean z;
        if (shape != null) {
            iM18899getDecal3opZhB0 = TileMode.INSTANCE.m18898getClamp3opZhB0();
            z = true;
        } else {
            iM18899getDecal3opZhB0 = TileMode.INSTANCE.m18899getDecal3opZhB0();
            z = false;
        }
        final int i = iM18899getDecal3opZhB0;
        float f5 = 0;
        return ((C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl(f5)) <= 0 || C2256Dp.m20967compareTo0680j_4(f4, C2256Dp.m20968constructorimpl(f5)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
                float fMo15546toPx0680j_4 = graphicsLayerScope.mo15546toPx0680j_4(f);
                float fMo15546toPx0680j_42 = graphicsLayerScope.mo15546toPx0680j_4(f4);
                graphicsLayerScope.setRenderEffect((fMo15546toPx0680j_4 <= 0.0f || fMo15546toPx0680j_42 <= 0.0f) ? null : RenderEffectKt.m18833BlurEffect3YTHUZs(fMo15546toPx0680j_4, fMo15546toPx0680j_42, i));
                Shape rectangleShape = shape;
                if (rectangleShape == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(rectangleShape);
                graphicsLayerScope.setClip(z);
            }
        });
    }

    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m18160blur1fqSgw$default(Modifier modifier, float f, float f4, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m18163boximpl(BlurredEdgeTreatment.INSTANCE.m18170getRectangleGoahg());
        }
        return m18159blur1fqSgw(modifier, f, f4, blurredEdgeTreatment.m18169unboximpl());
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m18161blurF8QBwvs(@NotNull Modifier modifier, float f, @NotNull Shape shape) {
        return m18159blur1fqSgw(modifier, f, f, shape);
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m18162blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m18163boximpl(BlurredEdgeTreatment.INSTANCE.m18170getRectangleGoahg());
        }
        return m18161blurF8QBwvs(modifier, f, blurredEdgeTreatment.m18169unboximpl());
    }
}
