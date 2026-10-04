package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0002J2\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u000e0\u0017H\u0016J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0096\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u001a\u0010\u001b\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "T", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "()V", "intervals", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "lastInterval", "<set-?>", "", "size", "getSize", "()I", "addInterval", "", "value", "(ILjava/lang/Object;)V", "checkIndexBounds", "index", "forEach", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "get", "getIntervalForIndex", "itemIndex", "contains", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@ExperimentalFoundationApi
@SourceDebugExtension({"SMAP\nIntervalList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntervalList.kt\nandroidx/compose/foundation/lazy/layout/MutableIntervalList\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,222:1\n1208#2:223\n1187#2,2:224\n523#3:226\n523#3:227\n523#3:228\n*S KotlinDebug\n*F\n+ 1 IntervalList.kt\nandroidx/compose/foundation/lazy/layout/MutableIntervalList\n*L\n104#1:223\n104#1:224,2\n156#1:226\n158#1:227\n175#1:228\n*E\n"})
public final class MutableIntervalList<T> implements IntervalList<T> {
    public static final int $stable = 8;

    @NotNull
    private final MutableVector<IntervalList.Interval<T>> intervals = new MutableVector<>(new IntervalList.Interval[16], 0);

    @Nullable
    private IntervalList.Interval<? extends T> lastInterval;
    private int size;

    private final void checkIndexBounds(int index) {
        if (index < 0 || index >= getSize()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(index, "Index ", ", size ");
            sbM778t.append(getSize());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
    }

    private final boolean contains(IntervalList.Interval<? extends T> interval, int i) {
        return i < interval.getSize() + interval.getStartIndex() && interval.getStartIndex() <= i;
    }

    private final IntervalList.Interval<T> getIntervalForIndex(int itemIndex) {
        IntervalList.Interval<? extends T> interval = this.lastInterval;
        if (interval != null && contains(interval, itemIndex)) {
            return interval;
        }
        MutableVector<IntervalList.Interval<T>> mutableVector = this.intervals;
        IntervalList.Interval interval2 = (IntervalList.Interval<? extends T>) mutableVector.getContent()[IntervalListKt.binarySearch(mutableVector, itemIndex)];
        this.lastInterval = interval2;
        return interval2;
    }

    public final void addInterval(int size, T value) {
        if (size < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(size, "size should be >=0, but was ").toString());
        }
        if (size == 0) {
            return;
        }
        IntervalList.Interval<T> interval = new IntervalList.Interval<>(getSize(), size, value);
        this.size = getSize() + size;
        this.intervals.add(interval);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public void forEach(int fromIndex, int toIndex, @NotNull Function1<? super IntervalList.Interval<? extends T>, Unit> block) {
        checkIndexBounds(fromIndex);
        checkIndexBounds(toIndex);
        if (toIndex < fromIndex) {
            throw new IllegalArgumentException(AbstractC0622a.m1168n("toIndex (", toIndex, ") should be not smaller than fromIndex (", fromIndex, PropertyUtils.MAPPED_DELIM2).toString());
        }
        int iBinarySearch = IntervalListKt.binarySearch(this.intervals, fromIndex);
        int startIndex = this.intervals.getContent()[iBinarySearch].getStartIndex();
        while (startIndex <= toIndex) {
            IntervalList.Interval<T> interval = this.intervals.getContent()[iBinarySearch];
            block.invoke(interval);
            startIndex += interval.getSize();
            iBinarySearch++;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    @NotNull
    public IntervalList.Interval<T> get(int index) {
        checkIndexBounds(index);
        return getIntervalForIndex(index);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public int getSize() {
        return this.size;
    }
}
