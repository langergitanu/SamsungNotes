package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m13886d2 = {"invalidateFocusProperties", "", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FocusPropertiesModifierNodeKt {
    public static final void invalidateFocusProperties(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        DelegatableNodeKt.requireOwner(focusPropertiesModifierNode).getFocusOwner().scheduleInvalidation(focusPropertiesModifierNode);
    }
}
