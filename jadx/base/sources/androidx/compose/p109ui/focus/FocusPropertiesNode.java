package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\r"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusPropertiesNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusPropertiesScope", "Landroidx/compose/ui/focus/FocusPropertiesScope;", "(Landroidx/compose/ui/focus/FocusPropertiesScope;)V", "getFocusPropertiesScope", "()Landroidx/compose/ui/focus/FocusPropertiesScope;", "setFocusPropertiesScope", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class FocusPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {

    @NotNull
    private FocusPropertiesScope focusPropertiesScope;

    public FocusPropertiesNode(@NotNull FocusPropertiesScope focusPropertiesScope) {
        this.focusPropertiesScope = focusPropertiesScope;
    }

    @Override // androidx.compose.p109ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(@NotNull FocusProperties focusProperties) {
        this.focusPropertiesScope.apply(focusProperties);
    }

    @NotNull
    public final FocusPropertiesScope getFocusPropertiesScope() {
        return this.focusPropertiesScope;
    }

    public final void setFocusPropertiesScope(@NotNull FocusPropertiesScope focusPropertiesScope) {
        this.focusPropertiesScope = focusPropertiesScope;
    }
}
