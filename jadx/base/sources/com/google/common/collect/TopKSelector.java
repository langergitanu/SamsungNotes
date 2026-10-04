package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;

    /* JADX INFO: renamed from: k */
    private final int f3344k;

    @CheckForNull
    private T threshold;

    private TopKSelector(Comparator<? super T> comparator, int i) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator, "comparator");
        this.f3344k = i;
        Preconditions.checkArgument(i >= 0, "k (%s) must be >= 0", i);
        Preconditions.checkArgument(i <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i);
        this.buffer = (T[]) new Object[IntMath.checkedMultiply(i, 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i) {
        return greatest(i, Ordering.natural());
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i) {
        return least(i, Ordering.natural());
    }

    private int partition(int i, int i2, int i4) {
        Object objUncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i4]);
        T[] tArr = this.buffer;
        tArr[i4] = tArr[i2];
        int i5 = i;
        while (i < i2) {
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i]), objUncheckedCastNullableTToT) < 0) {
                swap(i5, i);
                i5++;
            }
            i++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i2] = tArr2[i5];
        tArr2[i5] = objUncheckedCastNullableTToT;
        return i5;
    }

    private void swap(int i, int i2) {
        T[] tArr = this.buffer;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    private void trim() {
        int i = (this.f3344k * 2) - 1;
        int iLog2 = IntMath.log2(i, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i2 = 0;
        int i4 = 0;
        while (true) {
            if (iMax >= i) {
                break;
            }
            int iPartition = partition(iMax, i, ((iMax + i) + 1) >>> 1);
            int i5 = this.f3344k;
            if (iPartition <= i5) {
                if (iPartition >= i5) {
                    break;
                }
                iMax = Math.max(iPartition, iMax + 1);
                i4 = iPartition;
            } else {
                i = iPartition - 1;
            }
            i2++;
            if (i2 >= iLog2) {
                Arrays.sort(this.buffer, iMax, i + 1, this.comparator);
                break;
            }
        }
        this.bufferSize = this.f3344k;
        this.threshold = (T) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i4]);
        while (true) {
            i4++;
            if (i4 >= this.f3344k) {
                return;
            }
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i4]), (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = this.buffer[i4];
            }
        }
    }

    public void offer(@ParametricNullness T t) {
        int i = this.f3344k;
        if (i == 0) {
            return;
        }
        int i2 = this.bufferSize;
        if (i2 == 0) {
            this.buffer[0] = t;
            this.threshold = t;
            this.bufferSize = 1;
            return;
        }
        if (i2 < i) {
            T[] tArr = this.buffer;
            this.bufferSize = i2 + 1;
            tArr[i2] = t;
            if (this.comparator.compare(t, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = t;
                return;
            }
            return;
        }
        if (this.comparator.compare(t, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) < 0) {
            T[] tArr2 = this.buffer;
            int i4 = this.bufferSize;
            int i5 = i4 + 1;
            this.bufferSize = i5;
            tArr2[i4] = t;
            if (i5 == this.f3344k * 2) {
                trim();
            }
        }
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public List<T> topK() {
        T[] tArr = this.buffer;
        Arrays.sort(tArr, 0, this.bufferSize, this.comparator);
        int i = this.bufferSize;
        int i2 = this.f3344k;
        if (i > i2) {
            T[] tArr2 = this.buffer;
            Arrays.fill(tArr2, i2, tArr2.length, (Object) null);
            int i4 = this.f3344k;
            this.bufferSize = i4;
            this.threshold = this.buffer[i4 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(tArr, this.bufferSize)));
    }

    public static <T> TopKSelector<T> greatest(int i, Comparator<? super T> comparator) {
        return new TopKSelector<>(Ordering.from(comparator).reverse(), i);
    }

    public static <T> TopKSelector<T> least(int i, Comparator<? super T> comparator) {
        return new TopKSelector<>(comparator, i);
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }
}
