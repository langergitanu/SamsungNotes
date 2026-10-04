package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.graphics.ClipOp;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.p109ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DrawModifierNode;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\u0010\u0010J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\f\u00101\u001a\u00020/*\u000202H\u0016R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00064"}, m13886d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "sharedScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "clipInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;FLkotlin/jvm/functions/Function2;)V", "getClipInOverlay", "()Lkotlin/jvm/functions/Function2;", "setClipInOverlay", "(Lkotlin/jvm/functions/Function2;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layerWithRenderer", "Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getSharedScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "<set-?>", "getZIndexInOverlay", "()F", "setZIndexInOverlay", "(F)V", "zIndexInOverlay$delegate", "Landroidx/compose/runtime/MutableFloatState;", "onAttach", "", "onDetach", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "LayerWithRenderer", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRenderInTransitionOverlayNodeElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderInTransitionOverlayNodeElement.kt\nandroidx/compose/animation/RenderInTransitionOverlayNode\n+ 2 SnapshotFloatState.kt\nandroidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt\n*L\n1#1,157:1\n79#2:158\n112#2,2:159\n*S KotlinDebug\n*F\n+ 1 RenderInTransitionOverlayNodeElement.kt\nandroidx/compose/animation/RenderInTransitionOverlayNode\n*L\n91#1:158\n91#1:159,2\n*E\n"})
public final class RenderInTransitionOverlayNode extends Modifier.Node implements DrawModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;

    @NotNull
    private Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlay;

    @Nullable
    private LayerWithRenderer layerWithRenderer;

    @NotNull
    private Function0<Boolean> renderInOverlay;

    @NotNull
    private SharedTransitionScopeImpl sharedScope;

    /* JADX INFO: renamed from: zIndexInOverlay$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableFloatState zIndexInOverlay;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "Landroidx/compose/animation/LayerRenderer;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/animation/RenderInTransitionOverlayNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "zIndex", "", "getZIndex", "()F", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nRenderInTransitionOverlayNodeElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderInTransitionOverlayNodeElement.kt\nandroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer\n+ 2 Offset.kt\nandroidx/compose/ui/geometry/Offset\n+ 3 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,157:1\n70#2,4:158\n244#3,5:162\n272#3,9:167\n128#3,7:176\n282#3,4:183\n128#3,7:187\n*S KotlinDebug\n*F\n+ 1 RenderInTransitionOverlayNodeElement.kt\nandroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer\n*L\n106#1:158,4\n111#1:162,5\n111#1:167,9\n112#1:176,7\n111#1:183,4\n117#1:187,7\n*E\n"})
    public final class LayerWithRenderer implements LayerRenderer {

        @NotNull
        private final GraphicsLayer layer;

        public LayerWithRenderer(@NotNull GraphicsLayer graphicsLayer) {
            this.layer = graphicsLayer;
        }

        @Override // androidx.compose.animation.LayerRenderer
        public void drawInOverlay(@NotNull DrawScope drawScope) {
            if (RenderInTransitionOverlayNode.this.getRenderInOverlay().invoke().booleanValue()) {
                RenderInTransitionOverlayNode renderInTransitionOverlayNode = RenderInTransitionOverlayNode.this;
                long jMo19864localPositionOfR5De75A = renderInTransitionOverlayNode.getSharedScope().getRoot$animation_release().mo19864localPositionOfR5De75A(DelegatableNodeKt.requireLayoutCoordinates(renderInTransitionOverlayNode), Offset.INSTANCE.m18300getZeroF1C5BW0());
                float fM18284getXimpl = Offset.m18284getXimpl(jMo19864localPositionOfR5De75A);
                float fM18285getYimpl = Offset.m18285getYimpl(jMo19864localPositionOfR5De75A);
                Path pathInvoke = renderInTransitionOverlayNode.getClipInOverlay().invoke(drawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(renderInTransitionOverlayNode));
                if (pathInvoke == null) {
                    drawScope.getDrawContext().getTransform().translate(fM18284getXimpl, fM18285getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(drawScope, this.layer);
                        return;
                    } finally {
                    }
                }
                int iM18514getIntersectrtfAjoo = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo18999clipPathmtrdDE(pathInvoke, iM18514getIntersectrtfAjoo);
                    drawScope.getDrawContext().getTransform().translate(fM18284getXimpl, fM18285getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(drawScope, this.layer);
                    } finally {
                    }
                } finally {
                    AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
                }
            }
        }

        @NotNull
        public final GraphicsLayer getLayer() {
            return this.layer;
        }

        @Override // androidx.compose.animation.LayerRenderer
        @Nullable
        public SharedElementInternalState getParentState() {
            return RenderInTransitionOverlayNode.this.getParentState();
        }

        @Override // androidx.compose.animation.LayerRenderer
        public float getZIndex() {
            return RenderInTransitionOverlayNode.this.getZIndexInOverlay();
        }
    }

    public RenderInTransitionOverlayNode(@NotNull SharedTransitionScopeImpl sharedTransitionScopeImpl, @NotNull Function0<Boolean> function0, float f, @NotNull Function2<? super LayoutDirection, ? super Density, ? extends Path> function2) {
        this.sharedScope = sharedTransitionScopeImpl;
        this.renderInOverlay = function0;
        this.clipInOverlay = function2;
        this.zIndexInOverlay = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
    }

    @Override // androidx.compose.p109ui.node.DrawModifierNode
    public void draw(@NotNull final ContentDrawScope contentDrawScope) {
        GraphicsLayer layer = getLayer();
        if (layer == null) {
            throw new IllegalArgumentException("Error: layer never initialized");
        }
        DrawScope.m19074recordJVtK1S4$default(contentDrawScope, layer, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.RenderInTransitionOverlayNode.draw.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DrawScope drawScope) {
                contentDrawScope.drawContent();
            }
        }, 1, null);
        if (this.renderInOverlay.invoke().booleanValue()) {
            return;
        }
        GraphicsLayerKt.drawLayer(contentDrawScope, layer);
    }

    @NotNull
    public final Function2<LayoutDirection, Density, Path> getClipInOverlay() {
        return this.clipInOverlay;
    }

    @Nullable
    public final GraphicsLayer getLayer() {
        LayerWithRenderer layerWithRenderer = this.layerWithRenderer;
        if (layerWithRenderer != null) {
            return layerWithRenderer.getLayer();
        }
        return null;
    }

    @Nullable
    public final SharedElementInternalState getParentState() {
        return (SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState());
    }

    @NotNull
    public final Function0<Boolean> getRenderInOverlay() {
        return this.renderInOverlay;
    }

    @NotNull
    public final SharedTransitionScopeImpl getSharedScope() {
        return this.sharedScope;
    }

    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay.getFloatValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        LayerWithRenderer layerWithRenderer = new LayerWithRenderer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.sharedScope.onLayerRendererCreated$animation_release(layerWithRenderer);
        this.layerWithRenderer = layerWithRenderer;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        LayerWithRenderer layerWithRenderer = this.layerWithRenderer;
        if (layerWithRenderer != null) {
            this.sharedScope.onLayerRendererRemoved$animation_release(layerWithRenderer);
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(layerWithRenderer.getLayer());
        }
    }

    public final void setClipInOverlay(@NotNull Function2<? super LayoutDirection, ? super Density, ? extends Path> function2) {
        this.clipInOverlay = function2;
    }

    public final void setRenderInOverlay(@NotNull Function0<Boolean> function0) {
        this.renderInOverlay = function0;
    }

    public final void setSharedScope(@NotNull SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.sharedScope = sharedTransitionScopeImpl;
    }

    public final void setZIndexInOverlay(float f) {
        this.zIndexInOverlay.setFloatValue(f);
    }
}
