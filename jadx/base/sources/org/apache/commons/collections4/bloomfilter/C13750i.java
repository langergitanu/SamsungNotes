package org.apache.commons.collections4.bloomfilter;

import java.util.BitSet;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import org.apache.commons.collections4.bloomfilter.CellExtractor;
import org.apache.commons.collections4.bloomfilter.IndexExtractor;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13750i implements IntPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9731a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9732b;

    public /* synthetic */ C13750i(Object obj, int i) {
        this.f9731a = i;
        this.f9732b = obj;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f9731a) {
            case 0:
                return ((CellExtractor.C137351) this.f9732b).lambda$populate$1(i);
            case 1:
                return ((IndexExtractor.C1Indices) this.f9732b).add(i);
            case 2:
                return BitMapExtractor.lambda$fromIndexExtractor$0((long[]) this.f9732b, i);
            case 3:
                return IndexExtractor.lambda$uniqueIndices$1((BitSet) this.f9732b, i);
            case 4:
                return ((IndexFilter) this.f9732b).test(i);
            case 5:
                return ((SparseBloomFilter) this.f9732b).add(i);
            default:
                return ((TreeSet) this.f9732b).contains(Integer.valueOf(i));
        }
    }
}
