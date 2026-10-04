package org.apache.commons.text.similarity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IntersectionSimilarity<T> implements SimilarityScore<IntersectionResult> {
    private final Function<CharSequence, Collection<T>> converter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BagCount {
        private static final BagCount ZERO = new BagCount();
        private int count;

        public static /* synthetic */ int access$008(BagCount bagCount) {
            int i = bagCount.count;
            bagCount.count = i + 1;
            return i;
        }

        private BagCount() {
            this.count = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class TinyBag {
        private final Map<T, BagCount> map;

        public static /* synthetic */ void access$700(TinyBag tinyBag, Object obj) {
            tinyBag.add(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void add(T t) {
            BagCount.access$008(this.map.computeIfAbsent(t, new C13966c()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Set<Map.Entry<T, BagCount>> entrySet() {
            return this.map.entrySet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getCount(Object obj) {
            return this.map.getOrDefault(obj, BagCount.ZERO).count;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ BagCount lambda$add$0(Object obj) {
            return new BagCount();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int uniqueElementSize() {
            return this.map.size();
        }

        private TinyBag(int i) {
            this.map = new HashMap(i);
        }
    }

    public IntersectionSimilarity(Function<CharSequence, Collection<T>> function) {
        if (function == null) {
            throw new IllegalArgumentException("Converter must not be null");
        }
        this.converter = function;
    }

    private static <T> int getIntersection(Set<T> set, Set<T> set2) {
        Iterator<T> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (set2.contains(it.next())) {
                i++;
            }
        }
        return i;
    }

    private IntersectionSimilarity<T>.TinyBag toBag(Collection<T> collection) {
        IntersectionSimilarity<T>.TinyBag tinyBag = new TinyBag(collection.size());
        collection.forEach(new C13965b(tinyBag, 1));
        return tinyBag;
    }

    private int getIntersection(IntersectionSimilarity<T>.TinyBag tinyBag, IntersectionSimilarity<T>.TinyBag tinyBag2) {
        int iMin = 0;
        for (Map.Entry entry : tinyBag.entrySet()) {
            iMin += Math.min(((BagCount) entry.getValue()).count, tinyBag2.getCount(entry.getKey()));
        }
        return iMin;
    }

    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public IntersectionResult apply(CharSequence charSequence, CharSequence charSequence2) {
        int intersection;
        if (charSequence != null && charSequence2 != null) {
            Collection<T> collectionApply = this.converter.apply(charSequence);
            Collection<T> collectionApply2 = this.converter.apply(charSequence2);
            int size = collectionApply.size();
            int size2 = collectionApply2.size();
            if (Math.min(size, size2) == 0) {
                return new IntersectionResult(size, size2, 0);
            }
            if (!(collectionApply instanceof Set) || !(collectionApply2 instanceof Set)) {
                IntersectionSimilarity<T>.TinyBag bag = toBag(collectionApply);
                IntersectionSimilarity<T>.TinyBag bag2 = toBag(collectionApply2);
                if (bag.uniqueElementSize() < bag2.uniqueElementSize()) {
                    intersection = getIntersection(bag, bag2);
                } else {
                    intersection = getIntersection(bag2, bag);
                }
            } else if (size < size2) {
                intersection = getIntersection((Set) collectionApply, (Set) collectionApply2);
            } else {
                intersection = getIntersection((Set) collectionApply2, (Set) collectionApply);
            }
            return new IntersectionResult(size, size2, intersection);
        }
        throw new IllegalArgumentException("Input cannot be null");
    }
}
