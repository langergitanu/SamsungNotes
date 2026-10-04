package androidx.compose.p109ui.node;

import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\f\u0010\b\u001a\u00020\t*\u00020\nH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "shouldClearDescendantSemantics", "", "getShouldClearDescendantSemantics", "()Z", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface SemanticsModifierNode extends DelegatableNode {
    void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver);

    default boolean getShouldClearDescendantSemantics() {
        return false;
    }

    default boolean getShouldMergeDescendantSemantics() {
        return false;
    }
}
