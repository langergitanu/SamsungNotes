package org.apache.commons.collections4.bloomfilter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13748g implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9728a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9729b;

    public /* synthetic */ C13748g(Object obj, int i) {
        this.f9728a = i;
        this.f9729b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9728a) {
            case 0:
                return BloomFilterExtractor.lambda$flatten$1((AtomicReference) this.f9729b, (BloomFilter) obj);
            case 1:
                return BloomFilterExtractor.lambda$asBloomFilterArray$0((ArrayList) this.f9729b, (BloomFilter) obj);
            case 2:
                return ((SimpleBloomFilter) this.f9729b).merge((BloomFilter<?>) obj);
            default:
                return LayeredBloomFilter.lambda$contains$0((BloomFilter) this.f9729b, (BloomFilter) obj);
        }
    }
}
