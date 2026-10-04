package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusChangedNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onFocusChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusState", "getOnFocusChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFocusChanged", "onFocusEvent", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class FocusChangedNode extends Modifier.Node implements FocusEventModifierNode {

    @Nullable
    private FocusState focusState;

    @NotNull
    private Function1<? super FocusState, Unit> onFocusChanged;

    public FocusChangedNode(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusChanged = function1;
    }

    @NotNull
    public final Function1<FocusState, Unit> getOnFocusChanged() {
        return this.onFocusChanged;
    }

    @Override // androidx.compose.p109ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        if (Intrinsics.areEqual(this.focusState, focusState)) {
            return;
        }
        this.focusState = focusState;
        this.onFocusChanged.invoke(focusState);
    }

    public final void setOnFocusChanged(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusChanged = function1;
    }
}
