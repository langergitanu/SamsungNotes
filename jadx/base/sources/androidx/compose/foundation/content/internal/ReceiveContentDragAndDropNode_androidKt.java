package androidx.compose.foundation.content.internal;

import android.view.DragEvent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.p109ui.draganddrop.DragAndDropEvent;
import androidx.compose.p109ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.p109ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.p109ui.draganddrop.DragAndDropTarget;
import androidx.compose.p109ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.p109ui.platform.AndroidClipboardManager_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0000¨\u0006\n"}, m13886d2 = {"ReceiveContentDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ReceiveContentDragAndDropNode_androidKt {
    @NotNull
    public static final DragAndDropModifierNode ReceiveContentDragAndDropNode(@NotNull final ReceiveContentConfiguration receiveContentConfiguration, @NotNull final Function1<? super DragAndDropEvent, Unit> function1) {
        return DragAndDropNodeKt.DragAndDropModifierNode(new Function1<DragAndDropEvent, Boolean>() { // from class: androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull DragAndDropEvent dragAndDropEvent) {
                return Boolean.TRUE;
            }
        }, new DragAndDropTarget() { // from class: androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode.2
            @Override // androidx.compose.p109ui.draganddrop.DragAndDropTarget
            public boolean onDrop(@NotNull DragAndDropEvent event) {
                function1.invoke(event);
                TransferableContent transferableContent = ReceiveContentDragAndDropNode_androidKt.toTransferableContent(event);
                return !Intrinsics.areEqual(transferableContent, receiveContentConfiguration.getReceiveContentListener().onReceive(transferableContent));
            }

            @Override // androidx.compose.p109ui.draganddrop.DragAndDropTarget
            public void onEnded(@NotNull DragAndDropEvent event) {
                receiveContentConfiguration.getReceiveContentListener().onDragEnd();
            }

            @Override // androidx.compose.p109ui.draganddrop.DragAndDropTarget
            public void onEntered(@NotNull DragAndDropEvent event) {
                receiveContentConfiguration.getReceiveContentListener().onDragEnter();
            }

            @Override // androidx.compose.p109ui.draganddrop.DragAndDropTarget
            public void onExited(@NotNull DragAndDropEvent event) {
                receiveContentConfiguration.getReceiveContentListener().onDragExit();
            }

            @Override // androidx.compose.p109ui.draganddrop.DragAndDropTarget
            public void onStarted(@NotNull DragAndDropEvent event) {
                receiveContentConfiguration.getReceiveContentListener().onDragStart();
            }
        });
    }

    @NotNull
    public static final TransferableContent toTransferableContent(@NotNull DragAndDropEvent dragAndDropEvent) {
        DragEvent androidDragEvent = DragAndDrop_androidKt.toAndroidDragEvent(dragAndDropEvent);
        return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(androidDragEvent.getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(androidDragEvent.getClipDescription()), TransferableContent.Source.INSTANCE.m15510getDragAndDropkB6V9T0(), null, 8, null);
    }
}
