package androidx.compose.p109ui.node;

import androidx.compose.p109ui.internal.InlineClassHelperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u0011\u001a\u00020\fJ \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J&\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J \u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010!\u001a\u00020\u0018J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Landroidx/compose/ui/node/IntStack;", "", "initialCapacity", "", "(I)V", "lastIndex", "size", "getSize", "()I", "stack", "", "compareDiagonal", "", "a", "b", "get", "index", "isNotEmpty", "partition", "start", "end", "elSize", "pop", "pushDiagonal", "", "x", "y", "pushRange", "oldStart", "oldEnd", "newStart", "newEnd", "quickSort", "sortDiagonals", "swapDiagonal", "i", "j", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMyersDiff.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyersDiff.kt\nandroidx/compose/ui/node/IntStack\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,512:1\n42#2,7:513\n*S KotlinDebug\n*F\n+ 1 MyersDiff.kt\nandroidx/compose/ui/node/IntStack\n*L\n464#1:513,7\n*E\n"})
final class IntStack {
    private int lastIndex;

    @NotNull
    private int[] stack;

    public IntStack(int i) {
        this.stack = new int[i];
    }

    private final boolean compareDiagonal(int a, int b) {
        int[] iArr = this.stack;
        int i = iArr[a];
        int i2 = iArr[b];
        return i < i2 || (i == i2 && iArr[a + 1] <= iArr[b + 1]);
    }

    private final int partition(int start, int end, int elSize) {
        int i = start - elSize;
        while (start < end) {
            if (compareDiagonal(start, end)) {
                i += elSize;
                swapDiagonal(i, start);
            }
            start += elSize;
        }
        int i2 = i + elSize;
        swapDiagonal(i2, end);
        return i2;
    }

    private final void quickSort(int start, int end, int elSize) {
        if (start < end) {
            int iPartition = partition(start, end, elSize);
            quickSort(start, iPartition - elSize, elSize);
            quickSort(iPartition + elSize, end, elSize);
        }
    }

    private final void swapDiagonal(int i, int j) {
        int[] iArr = this.stack;
        MyersDiffKt.swap(iArr, i, j);
        MyersDiffKt.swap(iArr, i + 1, j + 1);
        MyersDiffKt.swap(iArr, i + 2, j + 2);
    }

    public final int get(int index) {
        return this.stack[index];
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    public final boolean isNotEmpty() {
        return this.lastIndex != 0;
    }

    public final int pop() {
        int[] iArr = this.stack;
        int i = this.lastIndex - 1;
        this.lastIndex = i;
        return iArr[i];
    }

    public final void pushDiagonal(int x, int y2, int size) {
        int i = this.lastIndex;
        int i2 = i + 3;
        int[] iArr = this.stack;
        if (i2 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.stack = iArrCopyOf;
        }
        int[] iArr2 = this.stack;
        iArr2[i] = x + size;
        iArr2[i + 1] = y2 + size;
        iArr2[i + 2] = size;
        this.lastIndex = i2;
    }

    public final void pushRange(int oldStart, int oldEnd, int newStart, int newEnd) {
        int i = this.lastIndex;
        int i2 = i + 4;
        int[] iArr = this.stack;
        if (i2 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.stack = iArrCopyOf;
        }
        int[] iArr2 = this.stack;
        iArr2[i] = oldStart;
        iArr2[i + 1] = oldEnd;
        iArr2[i + 2] = newStart;
        iArr2[i + 3] = newEnd;
        this.lastIndex = i2;
    }

    public final void sortDiagonals() {
        int i = this.lastIndex;
        if (!(i % 3 == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Array size not a multiple of 3");
        }
        if (i > 3) {
            quickSort(0, i - 3, 3);
        }
    }
}
