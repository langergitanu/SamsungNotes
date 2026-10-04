package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000b\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ%\u0010\u0014\u001a\u00020\u00122\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u0015R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", ExifInterface.LONGITUDE_EAST, "", "()V", "buffer", "", "[Ljava/lang/Object;", "index", "", "currentElement", "()Ljava/lang/Object;", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "hasNextCell", "", "hasNextElement", "hasNextNode", "moveToNextCell", "", "nextElement", "reset", "([Ljava/lang/Object;I)V", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TrieNodeIterator<E> {
    public static final int $stable = 8;

    @NotNull
    private Object[] buffer = TrieNode.INSTANCE.getEMPTY$runtime_release().getBuffer();
    private int index;

    public static /* synthetic */ void reset$default(TrieNodeIterator trieNodeIterator, Object[] objArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        trieNodeIterator.reset(objArr, i);
    }

    public final E currentElement() {
        CommonFunctionsKt.m18110assert(hasNextElement());
        return (E) this.buffer[this.index];
    }

    @NotNull
    public final TrieNode<? extends E> currentNode() {
        CommonFunctionsKt.m18110assert(hasNextNode());
        Object obj = this.buffer[this.index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator>");
        return (TrieNode) obj;
    }

    public final boolean hasNextCell() {
        return this.index < this.buffer.length;
    }

    public final boolean hasNextElement() {
        return hasNextCell() && !(this.buffer[this.index] instanceof TrieNode);
    }

    public final boolean hasNextNode() {
        return hasNextCell() && (this.buffer[this.index] instanceof TrieNode);
    }

    public final void moveToNextCell() {
        CommonFunctionsKt.m18110assert(hasNextCell());
        this.index++;
    }

    public final E nextElement() {
        CommonFunctionsKt.m18110assert(hasNextElement());
        Object[] objArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        return (E) objArr[i];
    }

    public final void reset(@NotNull Object[] buffer, int index) {
        this.buffer = buffer;
        this.index = index;
    }
}
