package androidx.compose.foundation.layout;

import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\f\u0010\u001b\u001a\u00020\n*\u00020\tH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/foundation/layout/IntrinsicWidthElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/IntrinsicWidthNode;", "width", "Landroidx/compose/foundation/layout/IntrinsicSize;", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/IntrinsicSize;ZLkotlin/jvm/functions/Function1;)V", "getEnforceIncoming", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getWidth", "()Landroidx/compose/foundation/layout/IntrinsicSize;", "create", "equals", "other", "", "hashCode", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class IntrinsicWidthElement extends ModifierNodeElement<IntrinsicWidthNode> {
    private final boolean enforceIncoming;

    @NotNull
    private final Function1<InspectorInfo, Unit> inspectorInfo;

    @NotNull
    private final IntrinsicSize width;

    /* JADX WARN: Multi-variable type inference failed */
    public IntrinsicWidthElement(@NotNull IntrinsicSize intrinsicSize, boolean z, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        this.width = intrinsicSize;
        this.enforceIncoming = z;
        this.inspectorInfo = function1;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        IntrinsicWidthElement intrinsicWidthElement = other instanceof IntrinsicWidthElement ? (IntrinsicWidthElement) other : null;
        return intrinsicWidthElement != null && this.width == intrinsicWidthElement.width && this.enforceIncoming == intrinsicWidthElement.enforceIncoming;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    @NotNull
    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    @NotNull
    public final IntrinsicSize getWidth() {
        return this.width;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return Boolean.hashCode(this.enforceIncoming) + (this.width.hashCode() * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public IntrinsicWidthNode getNode() {
        return new IntrinsicWidthNode(this.width, this.enforceIncoming);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull IntrinsicWidthNode node) {
        node.setWidth(this.width);
        node.setEnforceIncoming(this.enforceIncoming);
    }
}
