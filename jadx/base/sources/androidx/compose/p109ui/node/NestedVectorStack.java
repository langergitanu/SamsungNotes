package androidx.compose.p109ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/ui/node/NestedVectorStack;", "T", "", "()V", "currentIndexes", "", "size", "", "vectors", "", "Landroidx/compose/runtime/collection/MutableVector;", "[Landroidx/compose/runtime/collection/MutableVector;", "isNotEmpty", "", "pop", "()Ljava/lang/Object;", "push", "", "vector", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNestedVectorStack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NestedVectorStack.kt\nandroidx/compose/ui/node/NestedVectorStack\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,61:1\n523#2:62\n*S KotlinDebug\n*F\n+ 1 NestedVectorStack.kt\nandroidx/compose/ui/node/NestedVectorStack\n*L\n44#1:62\n*E\n"})
public final class NestedVectorStack<T> {
    public static final int $stable = 8;
    private int size;

    @NotNull
    private int[] currentIndexes = new int[16];

    @NotNull
    private MutableVector<T>[] vectors = new MutableVector[16];

    public final boolean isNotEmpty() {
        int i = this.size;
        return i > 0 && this.currentIndexes[i - 1] >= 0;
    }

    public final T pop() {
        int i = this.size;
        if (i <= 0) {
            throw new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()");
        }
        int i2 = i - 1;
        int i4 = this.currentIndexes[i2];
        MutableVector<T> mutableVector = this.vectors[i2];
        Intrinsics.checkNotNull(mutableVector);
        if (i4 > 0) {
            this.currentIndexes[i2] = r3[i2] - 1;
        } else if (i4 == 0) {
            this.vectors[i2] = null;
            this.size--;
        }
        return mutableVector.getContent()[i4];
    }

    public final void push(@NotNull MutableVector<T> vector) {
        if (vector.isEmpty()) {
            return;
        }
        int i = this.size;
        int[] iArr = this.currentIndexes;
        if (i >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.currentIndexes = iArrCopyOf;
            MutableVector<T>[] mutableVectorArr = this.vectors;
            Object[] objArrCopyOf = Arrays.copyOf(mutableVectorArr, mutableVectorArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.vectors = (MutableVector[]) objArrCopyOf;
        }
        this.currentIndexes[i] = vector.getSize() - 1;
        this.vectors[i] = vector;
        this.size++;
    }
}
