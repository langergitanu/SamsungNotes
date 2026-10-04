package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0086\bJ\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "forEach", "", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Node;", "remove", "", "isRemoved", "", "()Z", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final void forEach(@NotNull Function1<? super LockFreeLinkedListNode, Unit> block) {
        Object next = getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, this); nextNode = nextNode.getNextNode()) {
            block.invoke(nextNode);
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean isRemoved() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    /* JADX INFO: renamed from: remove, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ boolean mo23762remove() {
        return ((Boolean) remove()).booleanValue();
    }

    @NotNull
    public final Void remove() {
        throw new IllegalStateException("head cannot be removed");
    }
}
