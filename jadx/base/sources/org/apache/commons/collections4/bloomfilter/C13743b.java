package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13743b implements IntPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9721a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayCountingBloomFilter f9722b;

    public /* synthetic */ C13743b(ArrayCountingBloomFilter arrayCountingBloomFilter, int i) {
        this.f9721a = i;
        this.f9722b = arrayCountingBloomFilter;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f9721a) {
            case 0:
                return this.f9722b.lambda$contains$2(i);
            case 1:
                return this.f9722b.lambda$asIndexArray$0(i);
            default:
                return this.f9722b.lambda$cardinality$1(i);
        }
    }
}
