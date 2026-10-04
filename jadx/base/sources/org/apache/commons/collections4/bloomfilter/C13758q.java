package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13758q implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9741a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ IntPredicate f9742b;

    public /* synthetic */ C13758q(IntPredicate intPredicate, int i) {
        this.f9741a = i;
        this.f9742b = intPredicate;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9741a) {
            case 0:
                return LayeredBloomFilter.lambda$processIndices$2(this.f9742b, (BloomFilter) obj);
            default:
                return this.f9742b.test(((Integer) obj).intValue());
        }
    }
}
