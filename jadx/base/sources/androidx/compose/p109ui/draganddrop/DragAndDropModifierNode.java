package androidx.compose.p109ui.draganddrop;

import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J;\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0010H&ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "acceptDragAndDropTransfer", "", "startEvent", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "drag", "", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface DragAndDropModifierNode extends DelegatableNode, DragAndDropTarget {
    boolean acceptDragAndDropTransfer(@NotNull DragAndDropEvent startEvent);

    /* JADX INFO: renamed from: drag-12SF9DM, reason: not valid java name */
    void mo18156drag12SF9DM(@NotNull DragAndDropTransferData transferData, long decorationSize, @NotNull Function1<? super DrawScope, Unit> drawDragDecoration);
}
