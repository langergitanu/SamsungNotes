package androidx.compose.foundation.gestures;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002BI\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0013\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\f\u0010\u001b\u001a\u00020\u0019*\u00020\u001cH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableElement;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLandroidx/compose/foundation/OverscrollEffect;)V", "Ljava/lang/Boolean;", "create", "equals", "other", "", "hashCode", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class AnchoredDraggableElement<T> extends ModifierNodeElement<AnchoredDraggableNode<T>> {
    private final boolean enabled;

    @Nullable
    private final MutableInteractionSource interactionSource;

    @NotNull
    private final Orientation orientation;

    @Nullable
    private final OverscrollEffect overscrollEffect;

    @Nullable
    private final Boolean reverseDirection;
    private final boolean startDragImmediately;

    @NotNull
    private final AnchoredDraggableState<T> state;

    public AnchoredDraggableElement(@NotNull AnchoredDraggableState<T> anchoredDraggableState, @NotNull Orientation orientation, boolean z, @Nullable Boolean bool, @Nullable MutableInteractionSource mutableInteractionSource, boolean z2, @Nullable OverscrollEffect overscrollEffect) {
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.enabled = z;
        this.reverseDirection = bool;
        this.interactionSource = mutableInteractionSource;
        this.startDragImmediately = z2;
        this.overscrollEffect = overscrollEffect;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnchoredDraggableElement)) {
            return false;
        }
        AnchoredDraggableElement anchoredDraggableElement = (AnchoredDraggableElement) other;
        return Intrinsics.areEqual(this.state, anchoredDraggableElement.state) && this.orientation == anchoredDraggableElement.orientation && this.enabled == anchoredDraggableElement.enabled && Intrinsics.areEqual(this.reverseDirection, anchoredDraggableElement.reverseDirection) && Intrinsics.areEqual(this.interactionSource, anchoredDraggableElement.interactionSource) && this.startDragImmediately == anchoredDraggableElement.startDragImmediately && Intrinsics.areEqual(this.overscrollEffect, anchoredDraggableElement.overscrollEffect);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        int iM1160f = AbstractC0622a.m1160f(this.enabled, (this.orientation.hashCode() + (this.state.hashCode() * 31)) * 31, 31);
        Boolean bool = this.reverseDirection;
        int iHashCode = (iM1160f + (bool != null ? bool.hashCode() : 0)) * 31;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        int iM1160f2 = AbstractC0622a.m1160f(this.startDragImmediately, (iHashCode + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31, 31);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return iM1160f2 + (overscrollEffect != null ? overscrollEffect.hashCode() : 0);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("anchoredDraggable");
        inspectorInfo.getProperties().set("state", this.state);
        inspectorInfo.getProperties().set("orientation", this.orientation);
        AbstractC0622a.m1163i(this.enabled, inspectorInfo.getProperties(), "enabled", inspectorInfo).set("reverseDirection", this.reverseDirection);
        inspectorInfo.getProperties().set("interactionSource", this.interactionSource);
        AbstractC0622a.m1163i(this.startDragImmediately, inspectorInfo.getProperties(), "startDragImmediately", inspectorInfo).set("overscrollEffect", this.overscrollEffect);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public AnchoredDraggableNode<T> getNode() {
        return new AnchoredDraggableNode<>(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.overscrollEffect, this.startDragImmediately);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull AnchoredDraggableNode<T> node) {
        node.update(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.overscrollEffect, this.startDragImmediately);
    }
}
