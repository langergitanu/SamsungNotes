package androidx.compose.p109ui.platform;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.node.SemanticsModifierNode;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/platform/TestTagNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "setTag", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class TestTagNode extends Modifier.Node implements SemanticsModifierNode {

    @NotNull
    private String tag;

    public TestTagNode(@NotNull String str) {
        this.tag = str;
    }

    @Override // androidx.compose.p109ui.node.SemanticsModifierNode
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, this.tag);
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public final void setTag(@NotNull String str) {
        this.tag = str;
    }
}
