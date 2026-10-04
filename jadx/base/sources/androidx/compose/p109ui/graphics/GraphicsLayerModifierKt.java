package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.runtime.Stable;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a¤\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a¸\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aÂ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\f\u0010'\u001a\u00020\u0001*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, m13886d2 = {"graphicsLayer", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "graphicsLayer-pANQ8Wg", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJ)Landroidx/compose/ui/Modifier;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "graphicsLayer-Ap8cVGQ", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class GraphicsLayerModifierKt {
    @Stable
    @NotNull
    public static final Modifier graphicsLayer(@NotNull Modifier modifier, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
        return modifier.then(new BlockGraphicsLayerElement(function1));
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* JADX INFO: renamed from: graphicsLayer-2Xn7asI, reason: not valid java name */
    public static final /* synthetic */ Modifier m18683graphicsLayer2Xn7asI(Modifier modifier, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z, RenderEffect renderEffect) {
        return m18685graphicsLayerAp8cVGQ(modifier, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, j, shape, z, renderEffect, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor(), CompositingStrategy.INSTANCE.m18614getAutoNrFUSI());
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: graphicsLayer-Ap8cVGQ, reason: not valid java name */
    public static final Modifier m18685graphicsLayerAp8cVGQ(@NotNull Modifier modifier, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, @NotNull Shape shape, boolean z, @Nullable RenderEffect renderEffect, long j2, long j3, int i) {
        return modifier.then(new GraphicsLayerElement(f, f4, f5, f6, f7, f8, f9, f10, f11, f12, j, shape, z, renderEffect, j2, j3, i, null));
    }

    /* JADX INFO: renamed from: graphicsLayer-Ap8cVGQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m18686graphicsLayerAp8cVGQ$default(Modifier modifier, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, int i2, Object obj) {
        return m18685graphicsLayerAp8cVGQ(modifier, (i2 & 1) != 0 ? 1.0f : f, (i2 & 2) != 0 ? 1.0f : f4, (i2 & 4) == 0 ? f5 : 1.0f, (i2 & 8) != 0 ? 0.0f : f6, (i2 & 16) != 0 ? 0.0f : f7, (i2 & 32) != 0 ? 0.0f : f8, (i2 & 64) != 0 ? 0.0f : f9, (i2 & 128) != 0 ? 0.0f : f10, (i2 & 256) == 0 ? f11 : 0.0f, (i2 & 512) != 0 ? 8.0f : f12, (i2 & 1024) != 0 ? TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ() : j, (i2 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i2 & 4096) != 0 ? false : z, (i2 & 8192) != 0 ? null : renderEffect, (i2 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j2, (32768 & i2) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j3, (i2 & 65536) != 0 ? CompositingStrategy.INSTANCE.m18614getAutoNrFUSI() : i);
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes a compositing strategy", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor, CompositingStrategy.Auto)", imports = {"androidx.compose.ui.graphics"}))
    /* JADX INFO: renamed from: graphicsLayer-pANQ8Wg, reason: not valid java name */
    public static final /* synthetic */ Modifier m18687graphicsLayerpANQ8Wg(Modifier modifier, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3) {
        return m18685graphicsLayerAp8cVGQ(modifier, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, j, shape, z, renderEffect, j2, j3, CompositingStrategy.INSTANCE.m18614getAutoNrFUSI());
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes an optional RenderEffect parameter and shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* JADX INFO: renamed from: graphicsLayer-sKFY_QE, reason: not valid java name */
    public static final /* synthetic */ Modifier m18689graphicsLayersKFY_QE(Modifier modifier, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z) {
        return m18686graphicsLayerAp8cVGQ$default(modifier, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, j, shape, z, null, 0L, 0L, 0, 114688, null);
    }

    /* JADX INFO: renamed from: graphicsLayer-sKFY_QE$default, reason: not valid java name */
    public static /* synthetic */ Modifier m18690graphicsLayersKFY_QE$default(Modifier modifier, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return m18689graphicsLayersKFY_QE(modifier, f, (i & 2) != 0 ? 1.0f : f4, (i & 4) == 0 ? f5 : 1.0f, (i & 8) != 0 ? 0.0f : f6, (i & 16) != 0 ? 0.0f : f7, (i & 32) != 0 ? 0.0f : f8, (i & 64) != 0 ? 0.0f : f9, (i & 128) != 0 ? 0.0f : f10, (i & 256) == 0 ? f11 : 0.0f, (i & 512) != 0 ? 8.0f : f12, (i & 1024) != 0 ? TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ() : j, (i & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i & 4096) != 0 ? false : z);
    }

    @Stable
    @NotNull
    public static final Modifier toolingGraphicsLayer(@NotNull Modifier modifier) {
        return InspectableValueKt.isDebugInspectorInfoEnabled() ? modifier.then(m18686graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null)) : modifier;
    }
}
