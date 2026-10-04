package androidx.compose.foundation.lazy;

import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.runtime.State;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\f\u0010\u001c\u001a\u00020\u001a*\u00020\u001dH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/foundation/lazy/ParentSizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/ParentSizeNode;", "fraction", "", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "inspectorName", "", "(FLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Ljava/lang/String;)V", "getFraction", "()F", "getHeightState", "()Landroidx/compose/runtime/State;", "getInspectorName", "()Ljava/lang/String;", "getWidthState", "create", "equals", "", "other", "", "hashCode", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class ParentSizeElement extends ModifierNodeElement<ParentSizeNode> {
    private final float fraction;

    @Nullable
    private final State<Integer> heightState;

    @NotNull
    private final String inspectorName;

    @Nullable
    private final State<Integer> widthState;

    public /* synthetic */ ParentSizeElement(float f, State state, State state2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? null : state, (i & 4) != 0 ? null : state2, str);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParentSizeElement)) {
            return false;
        }
        ParentSizeElement parentSizeElement = (ParentSizeElement) other;
        return this.fraction == parentSizeElement.fraction && Intrinsics.areEqual(this.widthState, parentSizeElement.widthState) && Intrinsics.areEqual(this.heightState, parentSizeElement.heightState);
    }

    public final float getFraction() {
        return this.fraction;
    }

    @Nullable
    public final State<Integer> getHeightState() {
        return this.heightState;
    }

    @NotNull
    public final String getInspectorName() {
        return this.inspectorName;
    }

    @Nullable
    public final State<Integer> getWidthState() {
        return this.widthState;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        State<Integer> state = this.widthState;
        int iHashCode = (state != null ? state.hashCode() : 0) * 31;
        State<Integer> state2 = this.heightState;
        return Float.hashCode(this.fraction) + ((iHashCode + (state2 != null ? state2.hashCode() : 0)) * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName(this.inspectorName);
        inspectorInfo.setValue(Float.valueOf(this.fraction));
    }

    public ParentSizeElement(float f, @Nullable State<Integer> state, @Nullable State<Integer> state2, @NotNull String str) {
        this.fraction = f;
        this.widthState = state;
        this.heightState = state2;
        this.inspectorName = str;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public ParentSizeNode getNode() {
        return new ParentSizeNode(this.fraction, this.widthState, this.heightState);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull ParentSizeNode node) {
        node.setFraction(this.fraction);
        node.setWidthState(this.widthState);
        node.setHeightState(this.heightState);
    }
}
