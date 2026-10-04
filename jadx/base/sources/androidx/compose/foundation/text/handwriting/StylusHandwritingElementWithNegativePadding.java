package androidx.compose.foundation.text.handwriting;

import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingElementWithNegativePadding;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnHandwritingSlopExceeded", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class StylusHandwritingElementWithNegativePadding extends ModifierNodeElement<StylusHandwritingNodeWithNegativePadding> {

    @NotNull
    private final Function0<Boolean> onHandwritingSlopExceeded;

    public StylusHandwritingElementWithNegativePadding(@NotNull Function0<Boolean> function0) {
        this.onHandwritingSlopExceeded = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StylusHandwritingElementWithNegativePadding copy$default(StylusHandwritingElementWithNegativePadding stylusHandwritingElementWithNegativePadding, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = stylusHandwritingElementWithNegativePadding.onHandwritingSlopExceeded;
        }
        return stylusHandwritingElementWithNegativePadding.copy(function0);
    }

    @NotNull
    public final Function0<Boolean> component1() {
        return this.onHandwritingSlopExceeded;
    }

    @NotNull
    public final StylusHandwritingElementWithNegativePadding copy(@NotNull Function0<Boolean> onHandwritingSlopExceeded) {
        return new StylusHandwritingElementWithNegativePadding(onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StylusHandwritingElementWithNegativePadding) && Intrinsics.areEqual(this.onHandwritingSlopExceeded, ((StylusHandwritingElementWithNegativePadding) other).onHandwritingSlopExceeded);
    }

    @NotNull
    public final Function0<Boolean> getOnHandwritingSlopExceeded() {
        return this.onHandwritingSlopExceeded;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onHandwritingSlopExceeded.hashCode();
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("stylusHandwriting");
        inspectorInfo.getProperties().set("onHandwritingSlopExceeded", this.onHandwritingSlopExceeded);
    }

    @NotNull
    public String toString() {
        return "StylusHandwritingElementWithNegativePadding(onHandwritingSlopExceeded=" + this.onHandwritingSlopExceeded + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public StylusHandwritingNodeWithNegativePadding getNode() {
        return new StylusHandwritingNodeWithNegativePadding(this.onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull StylusHandwritingNodeWithNegativePadding node) {
        node.setOnHandwritingSlopExceeded(this.onHandwritingSlopExceeded);
    }
}
