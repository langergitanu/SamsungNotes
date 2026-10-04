package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class CountingLongPredicate implements LongPredicate {
    private final long[] ary;
    private final LongBiPredicate func;
    private int idx;

    public CountingLongPredicate(long[] jArr, LongBiPredicate longBiPredicate) {
        this.ary = jArr;
        this.func = longBiPredicate;
    }

    public boolean processRemaining() {
        int i = this.idx;
        long[] jArr = this.ary;
        int length = jArr.length;
        while (i != length && this.func.test(jArr[i], 0L)) {
            i++;
        }
        return i == length;
    }

    @Override // java.util.function.LongPredicate
    public boolean test(long j) {
        long j2;
        LongBiPredicate longBiPredicate = this.func;
        int i = this.idx;
        long[] jArr = this.ary;
        if (i == jArr.length) {
            j2 = 0;
        } else {
            this.idx = i + 1;
            j2 = jArr[i];
        }
        return longBiPredicate.test(j2, j);
    }
}
