package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.p109ui.node.DelegatableNode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState$annotations", "()V", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "Landroidx/compose/ui/focus/FocusTargetNode;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface FocusTargetModifierNode extends DelegatableNode {
    @NotNull
    FocusState getFocusState();

    @ExperimentalComposeUiApi
    static /* synthetic */ void getFocusState$annotations() {
    }
}
