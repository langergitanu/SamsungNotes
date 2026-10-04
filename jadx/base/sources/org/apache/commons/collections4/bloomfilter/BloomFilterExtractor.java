package org.apache.commons.collections4.bloomfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface BloomFilterExtractor {
    static <T extends BloomFilter<T>> BloomFilterExtractor fromBloomFilterArray(final BloomFilter<?>... bloomFilterArr) {
        Objects.requireNonNull(bloomFilterArr, "filters");
        return new BloomFilterExtractor() { // from class: org.apache.commons.collections4.bloomfilter.BloomFilterExtractor.1
            @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
            public BloomFilter[] asBloomFilterArray() {
                return (BloomFilter[]) bloomFilterArr.clone();
            }

            @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
            public boolean processBloomFilterPair(BloomFilterExtractor bloomFilterExtractor, BiPredicate<BloomFilter, BloomFilter> biPredicate) {
                CountingPredicate countingPredicate = new CountingPredicate(bloomFilterArr, biPredicate);
                return bloomFilterExtractor.processBloomFilters(countingPredicate) && countingPredicate.processRemaining();
            }

            @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
            public boolean processBloomFilters(Predicate<BloomFilter> predicate) {
                return Arrays.stream(bloomFilterArr).allMatch(predicate);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$asBloomFilterArray$0(List list, BloomFilter bloomFilter) {
        return list.add(bloomFilter.copy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$flatten$1(AtomicReference atomicReference, BloomFilter bloomFilter) {
        if (atomicReference.get() == null) {
            atomicReference.set(new SimpleBloomFilter(bloomFilter.getShape()));
        }
        return ((BloomFilter) atomicReference.get()).merge((BloomFilter<?>) bloomFilter);
    }

    default BloomFilter[] asBloomFilterArray() {
        ArrayList arrayList = new ArrayList();
        processBloomFilters(new C13748g(arrayList, 1));
        return (BloomFilter[]) arrayList.toArray(new BloomFilter[0]);
    }

    default BloomFilter flatten() {
        AtomicReference atomicReference = new AtomicReference();
        processBloomFilters(new C13748g(atomicReference, 0));
        BloomFilter bloomFilter = (BloomFilter) atomicReference.get();
        Objects.requireNonNull(bloomFilter, "No filters.");
        return bloomFilter;
    }

    default boolean processBloomFilterPair(BloomFilterExtractor bloomFilterExtractor, BiPredicate<BloomFilter, BloomFilter> biPredicate) {
        CountingPredicate countingPredicate = new CountingPredicate(asBloomFilterArray(), biPredicate);
        return bloomFilterExtractor.processBloomFilters(countingPredicate) && countingPredicate.processRemaining();
    }

    boolean processBloomFilters(Predicate<BloomFilter> predicate);
}
