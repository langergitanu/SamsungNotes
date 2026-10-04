package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IterableUtils {
    static final FluentIterable EMPTY_ITERABLE = new FluentIterable<Object>() { // from class: org.apache.commons.collections4.IterableUtils.1
        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<Object> iterator() {
            return IteratorUtils.emptyIterator();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UnmodifiableIterable<E> extends FluentIterable<E> {
        private final Iterable<E> iterable;

        public UnmodifiableIterable(Iterable<E> iterable) {
            this.iterable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(this.iterable.iterator());
        }
    }

    @Deprecated
    public IterableUtils() {
    }

    public static <E> Iterable<E> boundedIterable(final Iterable<E> iterable, final long j) {
        Objects.requireNonNull(iterable, "iterable");
        if (j >= 0) {
            return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.2
                @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
                public Iterator<E> iterator() {
                    return IteratorUtils.boundedIterator(iterable.iterator(), j);
                }
            };
        }
        throw new IllegalArgumentException("MaxSize parameter must not be negative.");
    }

    public static <E> Iterable<E> chainedIterable(final Iterable<? extends E>... iterableArr) {
        checkNotNull(iterableArr);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.3
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.3.1
                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    public Iterator<? extends E> nextIterator(int i) {
                        Iterable[] iterableArr2 = iterableArr;
                        if (i > iterableArr2.length) {
                            return null;
                        }
                        return iterableArr2[i - 1].iterator();
                    }
                };
            }
        };
    }

    public static void checkNotNull(Iterable<?>... iterableArr) {
        Objects.requireNonNull(iterableArr, "iterables");
        for (Iterable<?> iterable : iterableArr) {
            Objects.requireNonNull(iterable, "iterable");
        }
    }

    public static <E> Iterable<E> collatedIterable(final Comparator<? super E> comparator, final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull(iterable, iterable2);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.4
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.collatedIterator(comparator, iterable.iterator(), iterable2.iterator());
            }
        };
    }

    public static <E> boolean contains(Iterable<? extends E> iterable, E e, Equator<? super E> equator) {
        Objects.requireNonNull(equator, "equator");
        return matchesAny(iterable, EqualPredicate.equalPredicate(e, equator));
    }

    public static <E> long countMatches(Iterable<E> iterable, Predicate<? super E> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return size(filteredIterable(emptyIfNull(iterable), predicate));
    }

    public static <E> List<E> duplicateList(Iterable<E> iterable) {
        return new ArrayList(duplicateSequencedSet(iterable));
    }

    public static <E> Set<E> duplicateSequencedSet(Iterable<E> iterable) {
        return (Set) duplicateSet(iterable, new LinkedHashSet());
    }

    public static <E> Set<E> duplicateSet(Iterable<E> iterable) {
        return (Set) duplicateSet(iterable, new HashSet());
    }

    public static <E> Iterable<E> emptyIfNull(Iterable<E> iterable) {
        return iterable == null ? emptyIterable() : iterable;
    }

    public static <E> Iterable<E> emptyIterable() {
        return EMPTY_ITERABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> emptyIteratorIfNull(Iterable<E> iterable) {
        return iterable != null ? iterable.iterator() : IteratorUtils.emptyIterator();
    }

    public static <E> Iterable<E> filteredIterable(final Iterable<E> iterable, final Predicate<? super E> predicate) {
        Objects.requireNonNull(iterable, "iterable");
        Objects.requireNonNull(predicate, "predicate");
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.6
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(iterable), predicate);
            }
        };
    }

    public static <E> E find(Iterable<E> iterable, Predicate<? super E> predicate) {
        return (E) IteratorUtils.find(emptyIteratorIfNull(iterable), predicate);
    }

    public static <T> T first(Iterable<T> iterable) {
        return (T) get(iterable, 0);
    }

    public static <E> void forEach(Iterable<E> iterable, Closure<? super E> closure) {
        IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
    }

    public static <E> E forEachButLast(Iterable<E> iterable, Closure<? super E> closure) {
        return (E) IteratorUtils.forEachButLast(emptyIteratorIfNull(iterable), closure);
    }

    public static <E, T extends E> int frequency(Iterable<E> iterable, T t) {
        return iterable instanceof Set ? ((Set) iterable).contains(t) ? 1 : 0 : iterable instanceof Bag ? ((Bag) iterable).getCount(t) : size(filteredIterable(emptyIfNull(iterable), EqualPredicate.equalPredicate(t)));
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        CollectionUtils.checkIndexBounds(i);
        return iterable instanceof List ? (T) ((List) iterable).get(i) : (T) IteratorUtils.get(emptyIteratorIfNull(iterable), i);
    }

    public static <E> int indexOf(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.indexOf(emptyIteratorIfNull(iterable), predicate);
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : IteratorUtils.isEmpty(emptyIteratorIfNull(iterable));
    }

    public static <E> Iterable<E> loopingIterable(final Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.7
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.7.1
                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    public Iterator<? extends E> nextIterator(int i) {
                        if (IterableUtils.isEmpty(iterable)) {
                            return null;
                        }
                        return iterable.iterator();
                    }
                };
            }
        };
    }

    public static <E> boolean matchesAll(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAll(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> boolean matchesAny(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAny(emptyIteratorIfNull(iterable), predicate);
    }

    public static <O, R extends Collection<O>> List<R> partition(Iterable<? extends O> iterable, Factory<R> factory, Predicate<? super O>... predicateArr) {
        if (iterable == null) {
            return partition(emptyIterable(), factory, predicateArr);
        }
        Objects.requireNonNull(predicateArr, "predicates");
        for (Predicate<? super O> predicate : predicateArr) {
            Objects.requireNonNull(predicate, "predicate");
        }
        if (predicateArr.length < 1) {
            R r = factory.get();
            CollectionUtils.addAll(r, iterable);
            return Collections.singletonList(r);
        }
        int length = predicateArr.length;
        int i = length + 1;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(factory.get());
        }
        for (O o : iterable) {
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    ((Collection) arrayList.get(length)).add(o);
                    break;
                }
                if (predicateArr[i4].test(o)) {
                    ((Collection) arrayList.get(i4)).add(o);
                    break;
                }
                i4++;
            }
        }
        return arrayList;
    }

    public static <E> Iterable<E> reversedIterable(final Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.8
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                Iterable iterable2 = iterable;
                return new ReverseListIterator(iterable2 instanceof List ? (List) iterable2 : IteratorUtils.toList(iterable2.iterator()));
            }
        };
    }

    public static int size(Iterable<?> iterable) {
        if (iterable == null) {
            return 0;
        }
        return iterable instanceof Collection ? ((Collection) iterable).size() : IteratorUtils.size(emptyIteratorIfNull(iterable));
    }

    public static <E> Iterable<E> skippingIterable(final Iterable<E> iterable, final long j) {
        Objects.requireNonNull(iterable, "iterable");
        if (j >= 0) {
            return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.9
                @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
                public Iterator<E> iterator() {
                    return IteratorUtils.skippingIterator(iterable.iterator(), j);
                }
            };
        }
        throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        return IteratorUtils.toList(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable));
    }

    public static <I, O> Iterable<O> transformedIterable(final Iterable<I> iterable, final Transformer<? super I, ? extends O> transformer) {
        Objects.requireNonNull(iterable, "iterable");
        Objects.requireNonNull(transformer, "transformer");
        return new FluentIterable<O>() { // from class: org.apache.commons.collections4.IterableUtils.10
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<O> iterator() {
                return IteratorUtils.transformedIterator(iterable.iterator(), transformer);
            }
        };
    }

    public static <E> Iterable<E> uniqueIterable(final Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.11
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new UniqueFilterIterator(iterable.iterator());
            }
        };
    }

    public static <E> Iterable<E> unmodifiableIterable(Iterable<E> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return iterable instanceof UnmodifiableIterable ? iterable : new UnmodifiableIterable(iterable);
    }

    public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        Objects.requireNonNull(iterable, "iterable");
        Objects.requireNonNull(iterable2, "iterable");
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.12
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.zippingIterator(iterable.iterator(), iterable2.iterator());
            }
        };
    }

    public static <C extends Collection<E>, E> C duplicateSet(Iterable<E> iterable, C c) {
        HashSet hashSet = new HashSet();
        for (E e : iterable) {
            (hashSet.contains(e) ? c : hashSet).add(e);
        }
        return c;
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer) {
        Objects.requireNonNull(transformer, "transformer");
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        return chainedIterable(iterable, iterable2);
    }

    public static <E> Iterable<E> collatedIterable(final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull(iterable, iterable2);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.5
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.collatedIterator(null, iterable.iterator(), iterable2.iterator());
            }
        };
    }

    public static <E> boolean contains(Iterable<E> iterable, Object obj) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return IteratorUtils.contains(emptyIteratorIfNull(iterable), obj);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3) {
        return chainedIterable(iterable, iterable2, iterable3);
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer, String str, String str2, String str3) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer, str, str2, str3);
    }

    public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> iterable, final Iterable<? extends E>... iterableArr) {
        Objects.requireNonNull(iterable, "iterable");
        checkNotNull(iterableArr);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.13
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                Iterator[] itArr = new Iterator[iterableArr.length + 1];
                int i = 0;
                itArr[0] = iterable.iterator();
                while (true) {
                    Iterable[] iterableArr2 = iterableArr;
                    if (i >= iterableArr2.length) {
                        return IteratorUtils.zippingIterator(itArr);
                    }
                    int i2 = i + 1;
                    itArr[i2] = iterableArr2[i].iterator();
                    i = i2;
                }
            }
        };
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3, Iterable<? extends E> iterable4) {
        return chainedIterable(iterable, iterable2, iterable3, iterable4);
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicate);
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O>... predicateArr) {
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicateArr);
    }
}
