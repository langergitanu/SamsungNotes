package org.apache.commons.collections4.bloomfilter;

import androidx.appcompat.widget.AbstractC0541b;
import com.opencsv.bean.C6629l;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.apache.commons.collections4.bloomfilter.BloomFilter;
import org.apache.commons.collections4.bloomfilter.LayerManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LayerManager<T extends BloomFilter<T>> implements BloomFilterExtractor {
    private final Predicate<LayerManager<T>> extendCheck;
    private final Consumer<Deque<T>> filterCleanup;
    private final Supplier<T> filterSupplier;
    private final LinkedList<T> filters;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder<T extends BloomFilter<T>> implements Supplier<LayerManager<T>> {
        private Consumer<Deque<T>> cleanup;
        private Predicate<LayerManager<T>> extendCheck;
        private Supplier<T> supplier;

        public Builder<T> setCleanup(Consumer<Deque<T>> consumer) {
            this.cleanup = consumer;
            return this;
        }

        public Builder<T> setExtendCheck(Predicate<LayerManager<T>> predicate) {
            this.extendCheck = predicate;
            return this;
        }

        public Builder<T> setSupplier(Supplier<T> supplier) {
            this.supplier = supplier;
            return this;
        }

        private Builder() {
            this.extendCheck = ExtendCheck.neverAdvance();
            this.cleanup = Cleanup.noCleanup();
        }

        @Override // java.util.function.Supplier
        public LayerManager<T> get() {
            return new LayerManager<>(this.supplier, this.extendCheck, this.cleanup, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ExtendCheck {
        private ExtendCheck() {
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> advanceOnCount(final int i) {
            if (i > 0) {
                return (Predicate<LayerManager<T>>) new Predicate<LayerManager<T>>() { // from class: org.apache.commons.collections4.bloomfilter.LayerManager.ExtendCheck.1
                    int count;

                    @Override // java.util.function.Predicate
                    public boolean test(LayerManager<T> layerManager) {
                        int i2 = this.count + 1;
                        this.count = i2;
                        if (i2 != i) {
                            return false;
                        }
                        this.count = 0;
                        return true;
                    }
                };
            }
            throw new IllegalArgumentException("'breakAt' must be greater than 0");
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> advanceOnPopulated() {
            return new C13756o(1);
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> advanceOnSaturation(final double d) {
            if (d > 0.0d) {
                return new Predicate() { // from class: org.apache.commons.collections4.bloomfilter.n
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return LayerManager.ExtendCheck.lambda$advanceOnSaturation$1(d, (LayerManager) obj);
                    }
                };
            }
            throw new IllegalArgumentException("'maxN' must be greater than 0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$advanceOnPopulated$0(LayerManager layerManager) {
            return !layerManager.last().isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$advanceOnSaturation$1(double d, LayerManager layerManager) {
            BloomFilter bloomFilterLast = layerManager.last();
            return d <= bloomFilterLast.getShape().estimateN(bloomFilterLast.cardinality());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$neverAdvance$2(LayerManager layerManager) {
            return false;
        }

        public static <T extends BloomFilter<T>> Predicate<LayerManager<T>> neverAdvance() {
            return new C13756o(0);
        }
    }

    private void addFilter() {
        LinkedList<T> linkedList = this.filters;
        T t = this.filterSupplier.get();
        Objects.requireNonNull(t, "filterSupplier.get() returned null.");
        linkedList.add(t);
    }

    public static <T extends BloomFilter<T>> Builder<T> builder() {
        return new Builder<>();
    }

    public void cleanup() {
        this.filterCleanup.accept(this.filters);
        if (this.filters.isEmpty()) {
            addFilter();
        }
    }

    public final void clear() {
        this.filters.clear();
        addFilter();
    }

    public LayerManager<T> copy() {
        LayerManager<T> layerManager = new LayerManager<>(this.filterSupplier, this.extendCheck, this.filterCleanup, false);
        Iterator<T> it = this.filters.iterator();
        while (it.hasNext()) {
            layerManager.filters.add((T) it.next().copy());
        }
        return layerManager;
    }

    public final T first() {
        return this.filters.getFirst();
    }

    public final T get(int i) {
        if (i < 0 || i >= this.filters.size()) {
            throw new NoSuchElementException(AbstractC0541b.m767i(this.filters.size(), "Depth must be in the range [0,", ")"));
        }
        return this.filters.get(i);
    }

    public final int getDepth() {
        return this.filters.size();
    }

    public final T getTarget() {
        if (this.extendCheck.test(this)) {
            next();
        }
        return (T) last();
    }

    public final T last() {
        return this.filters.getLast();
    }

    public void next() {
        this.filterCleanup.accept(this.filters);
        addFilter();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilterExtractor
    public boolean processBloomFilters(Predicate<BloomFilter> predicate) {
        return this.filters.stream().allMatch(predicate);
    }

    private LayerManager(Supplier<T> supplier, Predicate<LayerManager<T>> predicate, Consumer<Deque<T>> consumer, boolean z) {
        this.filters = new LinkedList<>();
        Objects.requireNonNull(supplier, "filterSupplier");
        this.filterSupplier = supplier;
        Objects.requireNonNull(predicate, "extendCheck");
        this.extendCheck = predicate;
        Objects.requireNonNull(consumer, "filterCleanup");
        this.filterCleanup = consumer;
        if (z) {
            addFilter();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Cleanup {
        private Cleanup() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onMaxSize$1(int i, Deque deque) {
            while (deque.size() > i) {
                deque.removeFirst();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$removeEmptyTarget$2(Deque deque) {
            if (deque.isEmpty() || !((BloomFilter) deque.getLast()).isEmpty()) {
                return;
            }
            deque.removeLast();
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> noCleanup() {
            return new C13754m(0);
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> onMaxSize(int i) {
            if (i > 0) {
                return new C6629l(i, 1);
            }
            throw new IllegalArgumentException("'maxSize' must be greater than 0");
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> removeEmptyTarget() {
            return new C13754m(1);
        }

        public static <T extends BloomFilter<T>> Consumer<Deque<T>> removeIf(final Predicate<? super T> predicate) {
            return new Consumer() { // from class: org.apache.commons.collections4.bloomfilter.l
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Deque) obj).removeIf(predicate);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$noCleanup$0(Deque deque) {
        }
    }
}
