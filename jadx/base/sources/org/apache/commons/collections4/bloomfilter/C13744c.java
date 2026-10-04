package org.apache.commons.collections4.bloomfilter;

import org.apache.commons.collections4.bloomfilter.CellExtractor;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13744c implements CellExtractor.CellPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9723a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayCountingBloomFilter f9724b;

    public /* synthetic */ C13744c(ArrayCountingBloomFilter arrayCountingBloomFilter, int i) {
        this.f9723a = i;
        this.f9724b = arrayCountingBloomFilter;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public final boolean test(int i, int i2) {
        switch (this.f9723a) {
            case 0:
                return this.f9724b.add(i, i2);
            default:
                return this.f9724b.subtract(i, i2);
        }
    }
}
