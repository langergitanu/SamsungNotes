package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusEventNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onFocusEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnFocusEvent", "()Lkotlin/jvm/functions/Function1;", "setOnFocusEvent", "focusState", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class FocusEventNode extends Modifier.Node implements FocusEventModifierNode {

    @NotNull
    private Function1<? super FocusState, Unit> onFocusEvent;

    public FocusEventNode(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusEvent = function1;
    }

    @NotNull
    public final Function1<FocusState, Unit> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    @Override // androidx.compose.p109ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        this.onFocusEvent.invoke(focusState);
    }

    public final void setOnFocusEvent(@NotNull Function1<? super FocusState, Unit> function1) {
        this.onFocusEvent = function1;
    }
}
