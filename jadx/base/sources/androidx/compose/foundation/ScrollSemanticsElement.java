package androidx.compose.foundation;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\f\u0010#\u001a\u00020!*\u00020$H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, m13886d2 = {"Landroidx/compose/foundation/ScrollSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "state", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "isScrollable", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "()Z", "getReverseScrolling", "getState", "()Landroidx/compose/foundation/ScrollState;", "component1", "component2", "component3", "component4", "component5", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class ScrollSemanticsElement extends ModifierNodeElement<ScrollSemanticsModifierNode> {

    @Nullable
    private final FlingBehavior flingBehavior;
    private final boolean isScrollable;
    private final boolean isVertical;
    private final boolean reverseScrolling;

    @NotNull
    private final ScrollState state;

    public ScrollSemanticsElement(@NotNull ScrollState scrollState, boolean z, @Nullable FlingBehavior flingBehavior, boolean z2, boolean z3) {
        this.state = scrollState;
        this.reverseScrolling = z;
        this.flingBehavior = flingBehavior;
        this.isScrollable = z2;
        this.isVertical = z3;
    }

    public static /* synthetic */ ScrollSemanticsElement copy$default(ScrollSemanticsElement scrollSemanticsElement, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            scrollState = scrollSemanticsElement.state;
        }
        if ((i & 2) != 0) {
            z = scrollSemanticsElement.reverseScrolling;
        }
        if ((i & 4) != 0) {
            flingBehavior = scrollSemanticsElement.flingBehavior;
        }
        if ((i & 8) != 0) {
            z2 = scrollSemanticsElement.isScrollable;
        }
        if ((i & 16) != 0) {
            z3 = scrollSemanticsElement.isVertical;
        }
        boolean z4 = z3;
        FlingBehavior flingBehavior2 = flingBehavior;
        return scrollSemanticsElement.copy(scrollState, z, flingBehavior2, z2, z4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ScrollState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsScrollable() {
        return this.isScrollable;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    @NotNull
    public final ScrollSemanticsElement copy(@NotNull ScrollState state, boolean reverseScrolling, @Nullable FlingBehavior flingBehavior, boolean isScrollable, boolean isVertical) {
        return new ScrollSemanticsElement(state, reverseScrolling, flingBehavior, isScrollable, isVertical);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollSemanticsElement)) {
            return false;
        }
        ScrollSemanticsElement scrollSemanticsElement = (ScrollSemanticsElement) other;
        return Intrinsics.areEqual(this.state, scrollSemanticsElement.state) && this.reverseScrolling == scrollSemanticsElement.reverseScrolling && Intrinsics.areEqual(this.flingBehavior, scrollSemanticsElement.flingBehavior) && this.isScrollable == scrollSemanticsElement.isScrollable && this.isVertical == scrollSemanticsElement.isVertical;
    }

    @Nullable
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    @NotNull
    public final ScrollState getState() {
        return this.state;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        int iM1160f = AbstractC0622a.m1160f(this.reverseScrolling, this.state.hashCode() * 31, 31);
        FlingBehavior flingBehavior = this.flingBehavior;
        return Boolean.hashCode(this.isVertical) + AbstractC0622a.m1160f(this.isScrollable, (iM1160f + (flingBehavior == null ? 0 : flingBehavior.hashCode())) * 31, 31);
    }

    public final boolean isScrollable() {
        return this.isScrollable;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ScrollSemanticsElement(state=");
        sb.append(this.state);
        sb.append(", reverseScrolling=");
        sb.append(this.reverseScrolling);
        sb.append(", flingBehavior=");
        sb.append(this.flingBehavior);
        sb.append(", isScrollable=");
        sb.append(this.isScrollable);
        sb.append(", isVertical=");
        return AbstractC0622a.m1172r(sb, this.isVertical, PropertyUtils.MAPPED_DELIM2);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public ScrollSemanticsModifierNode getNode() {
        return new ScrollSemanticsModifierNode(this.state, this.reverseScrolling, this.flingBehavior, this.isScrollable, this.isVertical);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull ScrollSemanticsModifierNode node) {
        node.setState(this.state);
        node.setReverseScrolling(this.reverseScrolling);
        node.setFlingBehavior(this.flingBehavior);
        node.setScrollable(this.isScrollable);
        node.setVertical(this.isVertical);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
    }
}
