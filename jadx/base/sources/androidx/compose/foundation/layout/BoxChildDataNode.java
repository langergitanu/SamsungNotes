package androidx.compose.foundation.layout;

import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.node.ParentDataModifierNode;
import androidx.compose.p109ui.unit.Density;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0000*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/foundation/layout/BoxChildDataNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "", "(Landroidx/compose/ui/Alignment;Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getMatchParentSize", "()Z", "setMatchParentSize", "(Z)V", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class BoxChildDataNode extends Modifier.Node implements ParentDataModifierNode {

    @NotNull
    private Alignment alignment;
    private boolean matchParentSize;

    public BoxChildDataNode(@NotNull Alignment alignment, boolean z) {
        this.alignment = alignment;
        this.matchParentSize = z;
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }

    @Override // androidx.compose.p109ui.node.ParentDataModifierNode
    @NotNull
    public BoxChildDataNode modifyParentData(@NotNull Density density, @Nullable Object obj) {
        return this;
    }

    public final void setAlignment(@NotNull Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setMatchParentSize(boolean z) {
        this.matchParentSize = z;
    }
}
