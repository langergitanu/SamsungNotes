package androidx.compose.foundation.content;

import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.DynamicReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt;
import androidx.compose.p109ui.draganddrop.DragAndDropEvent;
import androidx.compose.p109ui.modifier.ModifierLocalMap;
import androidx.compose.p109ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p109ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/content/ReceiveContentNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "setReceiveContentListener", "updateNode", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ReceiveContentNode extends DelegatingNode implements ModifierLocalModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;

    @NotNull
    private final ModifierLocalMap providedValues;

    @NotNull
    private final ReceiveContentConfiguration receiveContentConfiguration;

    @NotNull
    private ReceiveContentListener receiveContentListener;

    public ReceiveContentNode(@NotNull ReceiveContentListener receiveContentListener) {
        this.receiveContentListener = receiveContentListener;
        DynamicReceiveContentConfiguration dynamicReceiveContentConfiguration = new DynamicReceiveContentConfiguration(this);
        this.receiveContentConfiguration = dynamicReceiveContentConfiguration;
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.m13893to(ReceiveContentConfigurationKt.getModifierLocalReceiveContent(), dynamicReceiveContentConfiguration));
        delegate(ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode(dynamicReceiveContentConfiguration, new Function1<DragAndDropEvent, Unit>() { // from class: androidx.compose.foundation.content.ReceiveContentNode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DragAndDropEvent dragAndDropEvent) {
                invoke2(dragAndDropEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DragAndDropEvent dragAndDropEvent) {
                DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(ReceiveContentNode.this, dragAndDropEvent);
            }
        }));
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalModifierNode
    @NotNull
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @NotNull
    public final ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public final void setReceiveContentListener(@NotNull ReceiveContentListener receiveContentListener) {
        this.receiveContentListener = receiveContentListener;
    }

    public final void updateNode(@NotNull ReceiveContentListener receiveContentListener) {
        this.receiveContentListener = receiveContentListener;
    }
}
