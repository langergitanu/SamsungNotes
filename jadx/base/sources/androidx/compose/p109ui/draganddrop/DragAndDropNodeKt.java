package androidx.compose.p109ui.draganddrop;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.TraversableNode;
import androidx.compose.p109ui.node.TraversableNodeKt;
import androidx.compose.p109ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a1\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u000b\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a4\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u0002H\u00132\u0014\b\u0004\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\b0\u0003H\u0082\b¢\u0006\u0002\u0010\u0016\u001a/\u0010\u0017\u001a\u00020\u0011\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u0002H\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00190\u0003H\u0002¢\u0006\u0002\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"DragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "contains", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;J)Z", "dispatchEntered", "", "firstDescendantOrNull", "T", "Landroidx/compose/ui/node/TraversableNode;", "predicate", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/node/TraversableNode;", "traverseSelfAndDescendants", "block", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDragAndDropNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DragAndDropNode.kt\nandroidx/compose/ui/draganddrop/DragAndDropNodeKt\n+ 2 IntSize.kt\nandroidx/compose/ui/unit/IntSize\n+ 3 Offset.kt\nandroidx/compose/ui/geometry/Offset\n*L\n1#1,317:1\n56#2,4:318\n70#3,4:322\n*S KotlinDebug\n*F\n+ 1 DragAndDropNode.kt\nandroidx/compose/ui/draganddrop/DragAndDropNodeKt\n*L\n286#1:318,4\n287#1:322,4\n*E\n"})
public final class DragAndDropNodeKt {
    @NotNull
    public static final DragAndDropModifierNode DragAndDropModifierNode() {
        return new DragAndDropNode(new Function1<DragAndDropEvent, DragAndDropTarget>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.DragAndDropModifierNode.1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final DragAndDropTarget invoke(@NotNull DragAndDropEvent dragAndDropEvent) {
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: contains-Uv8p0NA, reason: not valid java name */
    public static final boolean m18158containsUv8p0NA(DragAndDropModifierNode dragAndDropModifierNode, long j) {
        if (!dragAndDropModifierNode.getNode().getIsAttached()) {
            return false;
        }
        LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutNode(dragAndDropModifierNode).getCoordinates();
        if (!coordinates.isAttached()) {
            return false;
        }
        long jMo19863getSizeYbymL2g = coordinates.mo19863getSizeYbymL2g();
        int iM21138getWidthimpl = IntSize.m21138getWidthimpl(jMo19863getSizeYbymL2g);
        int iM21137getHeightimpl = IntSize.m21137getHeightimpl(jMo19863getSizeYbymL2g);
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        float fM18284getXimpl = Offset.m18284getXimpl(jPositionInRoot);
        float fM18285getYimpl = Offset.m18285getYimpl(jPositionInRoot);
        float f = iM21138getWidthimpl + fM18284getXimpl;
        float f4 = iM21137getHeightimpl + fM18285getYimpl;
        float fM18284getXimpl2 = Offset.m18284getXimpl(j);
        if (fM18284getXimpl <= fM18284getXimpl2 && fM18284getXimpl2 <= f) {
            float fM18285getYimpl2 = Offset.m18285getYimpl(j);
            if (fM18285getYimpl <= fM18285getYimpl2 && fM18285getYimpl2 <= f4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchEntered(DragAndDropTarget dragAndDropTarget, DragAndDropEvent dragAndDropEvent) {
        dragAndDropTarget.onEntered(dragAndDropEvent);
        dragAndDropTarget.onMoved(dragAndDropEvent);
    }

    private static final <T extends TraversableNode> T firstDescendantOrNull(T t, final Function1<? super T, Boolean> function1) {
        if (!t.getNode().getIsAttached()) {
            return null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TraversableNodeKt.traverseDescendants(t, new Function1<T, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.firstDescendantOrNull.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction; */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(@NotNull TraversableNode traversableNode) {
                if (!function1.invoke(traversableNode).booleanValue()) {
                    return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                }
                objectRef.element = traversableNode;
                return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
            }
        });
        return (T) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends TraversableNode> void traverseSelfAndDescendants(T t, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        if (function1.invoke(t) != TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal) {
            return;
        }
        TraversableNodeKt.traverseDescendants(t, function1);
    }

    @NotNull
    public static final DragAndDropModifierNode DragAndDropModifierNode(@NotNull final Function1<? super DragAndDropEvent, Boolean> function1, @NotNull final DragAndDropTarget dragAndDropTarget) {
        return new DragAndDropNode(new Function1<DragAndDropEvent, DragAndDropTarget>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.DragAndDropModifierNode.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final DragAndDropTarget invoke(@NotNull DragAndDropEvent dragAndDropEvent) {
                if (function1.invoke(dragAndDropEvent).booleanValue()) {
                    return dragAndDropTarget;
                }
                return null;
            }
        });
    }
}
