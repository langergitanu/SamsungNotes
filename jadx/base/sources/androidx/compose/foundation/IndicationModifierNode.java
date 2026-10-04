package androidx.compose.foundation;

import androidx.compose.p109ui.node.DelegatableNode;
import androidx.compose.p109ui.node.DelegatingNode;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/foundation/IndicationModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)V", Constants.ARG_UPDATE, "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class IndicationModifierNode extends DelegatingNode {

    @NotNull
    private DelegatableNode indicationNode;

    public IndicationModifierNode(@NotNull DelegatableNode delegatableNode) {
        this.indicationNode = delegatableNode;
        delegate(delegatableNode);
    }

    public final void update(@NotNull DelegatableNode indicationNode) {
        undelegate(this.indicationNode);
        this.indicationNode = indicationNode;
        delegate(indicationNode);
    }
}
