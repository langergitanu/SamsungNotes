package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13760s implements IntPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9744a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SimpleBloomFilter f9745b;

    public /* synthetic */ C13760s(SimpleBloomFilter simpleBloomFilter, int i) {
        this.f9744a = i;
        this.f9745b = simpleBloomFilter;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f9744a) {
            case 0:
                return this.f9745b.lambda$contains$0(i);
            default:
                return this.f9745b.lambda$merge$3(i);
        }
    }
}
