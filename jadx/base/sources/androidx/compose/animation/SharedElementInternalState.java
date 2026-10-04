package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.ClipOp;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0013\u0010a\u001a\u00020bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u00101J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\b\u0010h\u001a\u00020eH\u0016J\b\u0010i\u001a\u00020eH\u0016J\b\u0010j\u001a\u00020eH\u0016R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010.\u001a\u00020/8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b0\u00101R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0019\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u00010\u0000X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0019\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R+\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0019\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR+\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u0019\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010\u0019\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010BR\u0014\u0010P\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010BR\u0011\u0010R\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bS\u0010BR\u0011\u0010T\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bU\u0010BR+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\u0019\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006k"}, m13886d2 = {"Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "sharedElement", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "", "overlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "renderInOverlayDuringTransition", "userState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "zIndex", "", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "<set-?>", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "boundsAnimation$delegate", "Landroidx/compose/runtime/MutableState;", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation_release", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation_release", "(Landroidx/compose/ui/graphics/Path;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layer$delegate", "lookaheadCoords", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLookaheadCoords", "()Lkotlin/jvm/functions/Function0;", "setLookaheadCoords", "(Lkotlin/jvm/functions/Function0;)V", "nonNullLookaheadSize", "Landroidx/compose/ui/geometry/Size;", "getNonNullLookaheadSize-NH-jbRc", "()J", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "overlayClip$delegate", "parentState", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "setParentState", "(Landroidx/compose/animation/SharedElementInternalState;)V", "getPlaceHolderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "setPlaceHolderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;)V", "placeHolderSize$delegate", "getRenderInOverlayDuringTransition", "()Z", "setRenderInOverlayDuringTransition", "(Z)V", "renderInOverlayDuringTransition$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "renderOnlyWhenVisible$delegate", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "sharedElement$delegate", "shouldRenderBasedOnTarget", "getShouldRenderBasedOnTarget", "shouldRenderInOverlay", "getShouldRenderInOverlay$animation_release", "shouldRenderInPlace", "getShouldRenderInPlace", "target", "getTarget", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "userState$delegate", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "calculateLookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "calculateLookaheadOffset-F1C5BW0", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSharedElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedElement.kt\nandroidx/compose/animation/SharedElementInternalState\n+ 2 SnapshotFloatState.kt\nandroidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 4 Offset.kt\nandroidx/compose/ui/geometry/Offset\n+ 5 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,254:1\n79#2:255\n112#2,2:256\n81#3:258\n107#3,2:259\n81#3:261\n107#3,2:262\n81#3:264\n107#3,2:265\n81#3:267\n107#3,2:268\n81#3:270\n107#3,2:271\n81#3:273\n107#3,2:274\n81#3:276\n107#3,2:277\n81#3:315\n107#3,2:316\n70#4,4:279\n244#5,5:283\n272#5,9:288\n128#5,7:297\n282#5,4:304\n128#5,7:308\n*S KotlinDebug\n*F\n+ 1 SharedElement.kt\nandroidx/compose/animation/SharedElementInternalState\n*L\n180#1:255\n180#1:256,2\n182#1:258\n182#1:259,2\n183#1:261\n183#1:262,2\n184#1:264\n184#1:265,2\n185#1:267\n185#1:268,2\n186#1:270\n186#1:271,2\n187#1:273\n187#1:274,2\n188#1:276\n188#1:277,2\n230#1:315\n230#1:316,2\n199#1:279,4\n201#1:283,5\n201#1:288,9\n202#1:297,7\n201#1:304,4\n206#1:308,7\n*E\n"})
public final class SharedElementInternalState implements LayerRenderer, RememberObserver {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: boundsAnimation$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState boundsAnimation;

    @Nullable
    private Path clipPathInOverlay;

    /* JADX INFO: renamed from: overlayClip$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState overlayClip;

    @Nullable
    private SharedElementInternalState parentState;

    /* JADX INFO: renamed from: placeHolderSize$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState placeHolderSize;

    /* JADX INFO: renamed from: renderInOverlayDuringTransition$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState renderInOverlayDuringTransition;

    /* JADX INFO: renamed from: renderOnlyWhenVisible$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState renderOnlyWhenVisible;

    /* JADX INFO: renamed from: sharedElement$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState sharedElement;

    /* JADX INFO: renamed from: userState$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState userState;

    /* JADX INFO: renamed from: zIndex$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableFloatState zIndex;

    @NotNull
    private Function0<? extends LayoutCoordinates> lookaheadCoords = new Function0() { // from class: androidx.compose.animation.SharedElementInternalState$lookaheadCoords$1
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Void invoke() {
            return null;
        }
    };

    /* JADX INFO: renamed from: layer$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState layer = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public SharedElementInternalState(@NotNull SharedElement sharedElement, @NotNull BoundsAnimation boundsAnimation, @NotNull SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, @NotNull SharedTransitionScope.OverlayClip overlayClip, boolean z2, @NotNull SharedTransitionScope.SharedContentState sharedContentState, float f) {
        this.zIndex = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.renderInOverlayDuringTransition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
        this.sharedElement = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedElement, null, 2, null);
        this.boundsAnimation = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsAnimation, null, 2, null);
        this.placeHolderSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(placeHolderSize, null, 2, null);
        this.renderOnlyWhenVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.overlayClip = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(overlayClip, null, 2, null);
        this.userState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedContentState, null, 2, null);
    }

    private final boolean getShouldRenderBasedOnTarget() {
        return Intrinsics.areEqual(getSharedElement().getTargetBoundsProvider(), this) || !getRenderOnlyWhenVisible();
    }

    /* JADX INFO: renamed from: calculateLookaheadOffset-F1C5BW0, reason: not valid java name */
    public final long m15281calculateLookaheadOffsetF1C5BW0() {
        LayoutCoordinates layoutCoordinatesInvoke = this.lookaheadCoords.invoke();
        if (layoutCoordinatesInvoke == null) {
            throw new IllegalArgumentException("Error: lookahead coordinates is null.");
        }
        return getSharedElement().getScope().getLookaheadRoot$animation_release().mo19864localPositionOfR5De75A(layoutCoordinatesInvoke, Offset.INSTANCE.m18300getZeroF1C5BW0());
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void drawInOverlay(@NotNull DrawScope drawScope) {
        GraphicsLayer layer = getLayer();
        if (layer != null && getShouldRenderInOverlay$animation_release()) {
            if (getSharedElement().getCurrentBounds() == null) {
                throw new IllegalArgumentException("Error: current bounds not set yet.");
            }
            Rect currentBounds = getSharedElement().getCurrentBounds();
            Unit unit = null;
            Offset offsetM18273boximpl = currentBounds != null ? Offset.m18273boximpl(currentBounds.m18319getTopLeftF1C5BW0()) : null;
            Intrinsics.checkNotNull(offsetM18273boximpl);
            long packedValue = offsetM18273boximpl.getPackedValue();
            float fM18284getXimpl = Offset.m18284getXimpl(packedValue);
            float fM18285getYimpl = Offset.m18285getYimpl(packedValue);
            Path path = this.clipPathInOverlay;
            if (path != null) {
                int iM18514getIntersectrtfAjoo = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo18999clipPathmtrdDE(path, iM18514getIntersectrtfAjoo);
                    drawScope.getDrawContext().getTransform().translate(fM18284getXimpl, fM18285getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(drawScope, layer);
                        AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
                        unit = Unit.INSTANCE;
                    } finally {
                    }
                } catch (Throwable th) {
                    AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
                    throw th;
                }
            }
            if (unit == null) {
                drawScope.getDrawContext().getTransform().translate(fM18284getXimpl, fM18285getYimpl);
                try {
                    GraphicsLayerKt.drawLayer(drawScope, layer);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final BoundsAnimation getBoundsAnimation() {
        return (BoundsAnimation) this.boundsAnimation.getValue();
    }

    @Nullable
    /* JADX INFO: renamed from: getClipPathInOverlay$animation_release, reason: from getter */
    public final Path getClipPathInOverlay() {
        return this.clipPathInOverlay;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final GraphicsLayer getLayer() {
        return (GraphicsLayer) this.layer.getValue();
    }

    @NotNull
    public final Function0<LayoutCoordinates> getLookaheadCoords() {
        return this.lookaheadCoords;
    }

    /* JADX INFO: renamed from: getNonNullLookaheadSize-NH-jbRc, reason: not valid java name */
    public final long m15282getNonNullLookaheadSizeNHjbRc() {
        LayoutCoordinates layoutCoordinatesInvoke = this.lookaheadCoords.invoke();
        if (layoutCoordinatesInvoke != null) {
            return IntSizeKt.m21150toSizeozmzZPI(layoutCoordinatesInvoke.mo19863getSizeYbymL2g());
        }
        throw new IllegalArgumentException(("Error: lookahead coordinates is null for " + getSharedElement().getKey() + '.').toString());
    }

    @NotNull
    public final SharedTransitionScope.OverlayClip getOverlayClip() {
        return (SharedTransitionScope.OverlayClip) this.overlayClip.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    @Nullable
    public SharedElementInternalState getParentState() {
        return this.parentState;
    }

    @NotNull
    public final SharedTransitionScope.PlaceHolderSize getPlaceHolderSize() {
        return (SharedTransitionScope.PlaceHolderSize) this.placeHolderSize.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderInOverlayDuringTransition() {
        return ((Boolean) this.renderInOverlayDuringTransition.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderOnlyWhenVisible() {
        return ((Boolean) this.renderOnlyWhenVisible.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final SharedElement getSharedElement() {
        return (SharedElement) this.sharedElement.getValue();
    }

    public final boolean getShouldRenderInOverlay$animation_release() {
        return getShouldRenderBasedOnTarget() && getSharedElement().getFoundMatch() && getRenderInOverlayDuringTransition();
    }

    public final boolean getShouldRenderInPlace() {
        if (getSharedElement().getFoundMatch()) {
            return !getShouldRenderInOverlay$animation_release() && getShouldRenderBasedOnTarget();
        }
        return true;
    }

    public final boolean getTarget() {
        return getBoundsAnimation().getTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final SharedTransitionScope.SharedContentState getUserState() {
        return (SharedTransitionScope.SharedContentState) this.userState.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public float getZIndex() {
        return this.zIndex.getFloatValue();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        getSharedElement().getScope().onStateRemoved$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        getSharedElement().getScope().onStateAdded$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    public final void setBoundsAnimation(@NotNull BoundsAnimation boundsAnimation) {
        this.boundsAnimation.setValue(boundsAnimation);
    }

    public final void setClipPathInOverlay$animation_release(@Nullable Path path) {
        this.clipPathInOverlay = path;
    }

    public final void setLayer(@Nullable GraphicsLayer graphicsLayer) {
        this.layer.setValue(graphicsLayer);
    }

    public final void setLookaheadCoords(@NotNull Function0<? extends LayoutCoordinates> function0) {
        this.lookaheadCoords = function0;
    }

    public final void setOverlayClip(@NotNull SharedTransitionScope.OverlayClip overlayClip) {
        this.overlayClip.setValue(overlayClip);
    }

    public void setParentState(@Nullable SharedElementInternalState sharedElementInternalState) {
        this.parentState = sharedElementInternalState;
    }

    public final void setPlaceHolderSize(@NotNull SharedTransitionScope.PlaceHolderSize placeHolderSize) {
        this.placeHolderSize.setValue(placeHolderSize);
    }

    public final void setRenderInOverlayDuringTransition(boolean z) {
        this.renderInOverlayDuringTransition.setValue(Boolean.valueOf(z));
    }

    public final void setRenderOnlyWhenVisible(boolean z) {
        this.renderOnlyWhenVisible.setValue(Boolean.valueOf(z));
    }

    public final void setSharedElement(@NotNull SharedElement sharedElement) {
        this.sharedElement.setValue(sharedElement);
    }

    public final void setUserState(@NotNull SharedTransitionScope.SharedContentState sharedContentState) {
        this.userState.setValue(sharedContentState);
    }

    public void setZIndex(float f) {
        this.zIndex.setFloatValue(f);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }
}
