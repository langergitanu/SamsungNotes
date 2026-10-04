package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.node.DelegatableNode;
import androidx.compose.p109ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, m13886d2 = {"defaultBringIntoViewParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "Landroidx/compose/ui/node/DelegatableNode;", "toRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BringIntoViewResponder_androidKt {
    @NotNull
    public static final BringIntoViewParent defaultBringIntoViewParent(@NotNull final DelegatableNode delegatableNode) {
        return new BringIntoViewParent() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponder_androidKt.defaultBringIntoViewParent.1
            @Override // androidx.compose.foundation.relocation.BringIntoViewParent
            @Nullable
            public final Object bringChildIntoView(@NotNull LayoutCoordinates layoutCoordinates, @NotNull Function0<Rect> function0, @NotNull Continuation<? super Unit> continuation) {
                View viewRequireView = DelegatableNode_androidKt.requireView(delegatableNode);
                long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
                Rect rectInvoke = function0.invoke();
                Rect rectM18321translatek4lQ0M = rectInvoke != null ? rectInvoke.m18321translatek4lQ0M(jPositionInRoot) : null;
                if (rectM18321translatek4lQ0M != null) {
                    viewRequireView.requestRectangleOnScreen(BringIntoViewResponder_androidKt.toRect(rectM18321translatek4lQ0M), false);
                }
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Rect toRect(Rect rect) {
        return new android.graphics.Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }
}
