package androidx.compose.p109ui.node;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.modifier.ModifierLocal;
import androidx.compose.p109ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0001\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"DetachedModifierLocalReadScope", "androidx/compose/ui/node/BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1", "Landroidx/compose/ui/node/BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1;", "onDrawCacheReadsChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "", "updateModifierLocalConsumer", "isChainUpdate", "", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BackwardsCompatNodeKt {

    @NotNull
    private static final BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 DetachedModifierLocalReadScope = new ModifierLocalReadScope() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1
        @Override // androidx.compose.p109ui.modifier.ModifierLocalReadScope
        public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
            return modifierLocal.getDefaultFactory$ui_release().invoke();
        }
    };

    @NotNull
    private static final Function1<BackwardsCompatNode, Unit> onDrawCacheReadsChanged = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$onDrawCacheReadsChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BackwardsCompatNode backwardsCompatNode) {
            invoke2(backwardsCompatNode);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.onDrawCacheReadsChanged$ui_release();
        }
    };

    @NotNull
    private static final Function1<BackwardsCompatNode, Unit> updateModifierLocalConsumer = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$updateModifierLocalConsumer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BackwardsCompatNode backwardsCompatNode) {
            invoke2(backwardsCompatNode);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.updateModifierLocalConsumer();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isChainUpdate(BackwardsCompatNode backwardsCompatNode) {
        Modifier.Node tail = DelegatableNodeKt.requireLayoutNode(backwardsCompatNode).getNodes().getTail();
        Intrinsics.checkNotNull(tail, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return ((TailModifierNode) tail).getAttachHasBeenRun();
    }
}
