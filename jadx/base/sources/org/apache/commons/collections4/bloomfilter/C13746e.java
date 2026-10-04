package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13746e implements LongPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9727a;

    public /* synthetic */ C13746e(int i) {
        this.f9727a = i;
    }

    @Override // java.util.function.LongPredicate
    public final boolean test(long j) {
        switch (this.f9727a) {
            case 0:
                return BloomFilter.lambda$isEmpty$1(j);
            default:
                return SimpleBloomFilter.lambda$isEmpty$1(j);
        }
    }
}
