package androidx.compose.p109ui.node;

import androidx.compose.p109ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"isAttached", "", "Landroidx/compose/ui/node/PointerInputModifierNode;", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Z", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPointerInputModifierNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointerInputModifierNode.kt\nandroidx/compose/ui/node/PointerInputModifierNodeKt\n+ 2 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n*L\n1#1,127:1\n84#2:128\n*S KotlinDebug\n*F\n+ 1 PointerInputModifierNode.kt\nandroidx/compose/ui/node/PointerInputModifierNodeKt\n*L\n126#1:128\n*E\n"})
public final class PointerInputModifierNodeKt {
    @NotNull
    public static final LayoutCoordinates getLayoutCoordinates(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        return DelegatableNodeKt.m19977requireCoordinator64DMado(pointerInputModifierNode, NodeKind.m20090constructorimpl(16));
    }

    public static final boolean isAttached(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        return pointerInputModifierNode.getNode().getIsAttached();
    }
}
