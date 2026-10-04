package androidx.compose.foundation;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.node.TraversableNode;
import androidx.compose.p109ui.node.TraversableNodeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R(\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "onPositioned", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnPositioned", "()Lkotlin/jvm/functions/Function1;", "setOnPositioned", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onFocusBoundsChanged", "focusedBounds", "TraverseKey", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FocusedBoundsObserverNode extends Modifier.Node implements TraversableNode {

    @NotNull
    private Function1<? super LayoutCoordinates, Unit> onPositioned;

    @NotNull
    private final Object traverseKey = INSTANCE;

    /* JADX INFO: renamed from: TraverseKey, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusedBoundsObserverNode$TraverseKey, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode$TraverseKey;", "", "()V", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FocusedBoundsObserverNode(@NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        this.onPositioned = function1;
    }

    @NotNull
    public final Function1<LayoutCoordinates, Unit> getOnPositioned() {
        return this.onPositioned;
    }

    @Override // androidx.compose.p109ui.node.TraversableNode
    @NotNull
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public final void onFocusBoundsChanged(@Nullable LayoutCoordinates focusedBounds) {
        this.onPositioned.invoke(focusedBounds);
        FocusedBoundsObserverNode focusedBoundsObserverNode = (FocusedBoundsObserverNode) TraversableNodeKt.findNearestAncestor(this);
        if (focusedBoundsObserverNode != null) {
            focusedBoundsObserverNode.onFocusBoundsChanged(focusedBounds);
        }
    }

    public final void setOnPositioned(@NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        this.onPositioned = function1;
    }
}
