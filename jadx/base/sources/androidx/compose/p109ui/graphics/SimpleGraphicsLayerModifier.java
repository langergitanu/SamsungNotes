package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.node.NodeCoordinator;
import androidx.compose.p109ui.node.NodeKind;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0006\u0010S\u001a\u000203J\b\u0010T\u001a\u00020UH\u0016J&\u0010V\u001a\u00020W*\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010^R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0016\u001a\u00020\u0017X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0019\u001a\u00020\u001aX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001f\u00100\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301¢\u0006\u0002\b4X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001d\"\u0004\bB\u0010\u001fR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001d\"\u0004\bD\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010(R\"\u0010\u0018\u001a\u00020\u0017X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\"\u0010\u000e\u001a\u00020\u000fX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001d\"\u0004\bP\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001d\"\u0004\bR\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, m13886d2 = {"Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "getCameraDistance", "setCameraDistance", "getClip", "()Z", "setClip", "(Z)V", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "I", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getRotationZ", "setRotationZ", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getShadowElevation", "setShadowElevation", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "invalidateLayerBlock", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGraphicsLayerModifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphicsLayerModifier.kt\nandroidx/compose/ui/graphics/SimpleGraphicsLayerModifier\n+ 2 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n*L\n1#1,672:1\n78#2:673\n*S KotlinDebug\n*F\n+ 1 GraphicsLayerModifier.kt\nandroidx/compose/ui/graphics/SimpleGraphicsLayerModifier\n*L\n636#1:673\n*E\n"})
final class SimpleGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode {
    private float alpha;
    private long ambientShadowColor;
    private float cameraDistance;
    private boolean clip;
    private int compositingStrategy;

    @NotNull
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;

    @Nullable
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;

    @NotNull
    private Shape shape;
    private long spotShadowColor;
    private long transformOrigin;
    private float translationX;
    private float translationY;

    public /* synthetic */ SimpleGraphicsLayerModifier(float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, f7, f8, f9, f10, f11, f12, j, shape, z, renderEffect, j2, j3, i);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final boolean getClip() {
        return this.clip;
    }

    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name and from getter */
    public final int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    @Nullable
    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name and from getter */
    public final long getTransformOrigin() {
        return this.transformOrigin;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void invalidateLayerBlock() {
        NodeCoordinator wrapped = DelegatableNodeKt.m19977requireCoordinator64DMado(this, NodeKind.m20090constructorimpl(2)).getWrapped();
        if (wrapped != null) {
            wrapped.updateLayerBlock(this.layerBlock, true);
        }
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, this.layerBlock, 4, (Object) null);
            }
        }, 4, null);
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m18856setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
    }

    public final void setCameraDistance(float f) {
        this.cameraDistance = f;
    }

    public final void setClip(boolean z) {
        this.clip = z;
    }

    /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    public final void m18857setCompositingStrategyaDBOjCE(int i) {
        this.compositingStrategy = i;
    }

    public final void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public final void setRotationX(float f) {
        this.rotationX = f;
    }

    public final void setRotationY(float f) {
        this.rotationY = f;
    }

    public final void setRotationZ(float f) {
        this.rotationZ = f;
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
    }

    public final void setShadowElevation(float f) {
        this.shadowElevation = f;
    }

    public final void setShape(@NotNull Shape shape) {
        this.shape = shape;
    }

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m18858setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
    }

    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    public final void m18859setTransformOrigin__ExYCQ(long j) {
        this.transformOrigin = j;
    }

    public final void setTranslationX(float f) {
        this.translationX = f;
    }

    public final void setTranslationY(float f) {
        this.translationY = f;
    }

    @NotNull
    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", alpha = " + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", shadowElevation=" + this.shadowElevation + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", rotationZ=" + this.rotationZ + ", cameraDistance=" + this.cameraDistance + ", transformOrigin=" + ((Object) TransformOrigin.m18914toStringimpl(this.transformOrigin)) + ", shape=" + this.shape + ", clip=" + this.clip + ", renderEffect=" + this.renderEffect + ", ambientShadowColor=" + ((Object) Color.m18533toStringimpl(this.ambientShadowColor)) + ", spotShadowColor=" + ((Object) Color.m18533toStringimpl(this.spotShadowColor)) + ", compositingStrategy=" + ((Object) CompositingStrategy.m18612toStringimpl(this.compositingStrategy)) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ SimpleGraphicsLayerModifier(float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, f7, f8, f9, f10, f11, f12, j, shape, z, renderEffect, j2, j3, (i2 & 65536) != 0 ? CompositingStrategy.INSTANCE.m18614getAutoNrFUSI() : i, null);
    }

    private SimpleGraphicsLayerModifier(float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i) {
        this.scaleX = f;
        this.scaleY = f4;
        this.alpha = f5;
        this.translationX = f6;
        this.translationY = f7;
        this.shadowElevation = f8;
        this.rotationX = f9;
        this.rotationY = f10;
        this.rotationZ = f11;
        this.cameraDistance = f12;
        this.transformOrigin = j;
        this.shape = shape;
        this.clip = z;
        this.renderEffect = renderEffect;
        this.ambientShadowColor = j2;
        this.spotShadowColor = j3;
        this.compositingStrategy = i;
        this.layerBlock = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1
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
                graphicsLayerScope.setScaleX(this.this$0.getScaleX());
                graphicsLayerScope.setScaleY(this.this$0.getScaleY());
                graphicsLayerScope.setAlpha(this.this$0.getAlpha());
                graphicsLayerScope.setTranslationX(this.this$0.getTranslationX());
                graphicsLayerScope.setTranslationY(this.this$0.getTranslationY());
                graphicsLayerScope.setShadowElevation(this.this$0.getShadowElevation());
                graphicsLayerScope.setRotationX(this.this$0.getRotationX());
                graphicsLayerScope.setRotationY(this.this$0.getRotationY());
                graphicsLayerScope.setRotationZ(this.this$0.getRotationZ());
                graphicsLayerScope.setCameraDistance(this.this$0.getCameraDistance());
                graphicsLayerScope.mo18718setTransformOrigin__ExYCQ(this.this$0.getTransformOrigin());
                graphicsLayerScope.setShape(this.this$0.getShape());
                graphicsLayerScope.setClip(this.this$0.getClip());
                graphicsLayerScope.setRenderEffect(this.this$0.getRenderEffect());
                graphicsLayerScope.mo18715setAmbientShadowColor8_81llA(this.this$0.getAmbientShadowColor());
                graphicsLayerScope.mo18717setSpotShadowColor8_81llA(this.this$0.getSpotShadowColor());
                graphicsLayerScope.mo18716setCompositingStrategyaDBOjCE(this.this$0.getCompositingStrategy());
            }
        };
    }
}
