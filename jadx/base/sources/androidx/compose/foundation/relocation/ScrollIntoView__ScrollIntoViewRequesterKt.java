package androidx.compose.foundation.relocation;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.node.DelegatableNode;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0080@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"scrollIntoView", "", "Landroidx/compose/ui/node/DelegatableNode;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 5, m13888mv = {1, 8, 0}, m13890xi = 48, m13891xs = "androidx/compose/foundation/relocation/ScrollIntoView")
public final /* synthetic */ class ScrollIntoView__ScrollIntoViewRequesterKt {
    @Nullable
    public static final Object scrollIntoView(@NotNull DelegatableNode delegatableNode, @Nullable final Rect rect, @NotNull Continuation<? super Unit> continuation) {
        if (!delegatableNode.getNode().getIsAttached()) {
            return Unit.INSTANCE;
        }
        final LayoutCoordinates layoutCoordinatesRequireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(delegatableNode);
        BringIntoViewParent bringIntoViewParentFindBringIntoViewParent = BringIntoViewRequesterKt.findBringIntoViewParent(delegatableNode);
        if (bringIntoViewParentFindBringIntoViewParent == null) {
            return Unit.INSTANCE;
        }
        Object objBringChildIntoView = bringIntoViewParentFindBringIntoViewParent.bringChildIntoView(layoutCoordinatesRequireLayoutCoordinates, new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Rect invoke() {
                Rect rect2 = rect;
                if (rect2 != null) {
                    return rect2;
                }
                LayoutCoordinates layoutCoordinates = layoutCoordinatesRequireLayoutCoordinates;
                if (!layoutCoordinates.isAttached()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return SizeKt.m18374toRectuvyYCjk(IntSizeKt.m21150toSizeozmzZPI(layoutCoordinates.mo19863getSizeYbymL2g()));
                }
                return null;
            }
        }, continuation);
        return objBringChildIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringChildIntoView : Unit.INSTANCE;
    }

    public static /* synthetic */ Object scrollIntoView$default(DelegatableNode delegatableNode, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return ScrollIntoView.scrollIntoView(delegatableNode, rect, continuation);
    }
}
