package androidx.compose.p109ui.focus;

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
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\u0015*\u00020\u0018H\u0016R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusRestorerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusRestorerNode;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "(Lkotlin/jvm/functions/Function0;)V", "getOnRestoreFailed", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class FocusRestorerElement extends ModifierNodeElement<FocusRestorerNode> {

    @Nullable
    private final Function0<FocusRequester> onRestoreFailed;

    public FocusRestorerElement(@Nullable Function0<FocusRequester> function0) {
        this.onRestoreFailed = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FocusRestorerElement copy$default(FocusRestorerElement focusRestorerElement, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = focusRestorerElement.onRestoreFailed;
        }
        return focusRestorerElement.copy(function0);
    }

    @Nullable
    public final Function0<FocusRequester> component1() {
        return this.onRestoreFailed;
    }

    @NotNull
    public final FocusRestorerElement copy(@Nullable Function0<FocusRequester> onRestoreFailed) {
        return new FocusRestorerElement(onRestoreFailed);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FocusRestorerElement) && Intrinsics.areEqual(this.onRestoreFailed, ((FocusRestorerElement) other).onRestoreFailed);
    }

    @Nullable
    public final Function0<FocusRequester> getOnRestoreFailed() {
        return this.onRestoreFailed;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        Function0<FocusRequester> function0 = this.onRestoreFailed;
        if (function0 == null) {
            return 0;
        }
        return function0.hashCode();
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("focusRestorer");
        inspectorInfo.getProperties().set("onRestoreFailed", this.onRestoreFailed);
    }

    @NotNull
    public String toString() {
        return "FocusRestorerElement(onRestoreFailed=" + this.onRestoreFailed + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public FocusRestorerNode getNode() {
        return new FocusRestorerNode(this.onRestoreFailed);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull FocusRestorerNode node) {
        node.setOnRestoreFailed(this.onRestoreFailed);
    }
}
