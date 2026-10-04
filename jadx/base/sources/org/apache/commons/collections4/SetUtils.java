package org.apache.commons.collections4;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.collections4.set.PredicatedNavigableSet;
import org.apache.commons.collections4.set.PredicatedSet;
import org.apache.commons.collections4.set.PredicatedSortedSet;
import org.apache.commons.collections4.set.TransformedNavigableSet;
import org.apache.commons.collections4.set.TransformedSet;
import org.apache.commons.collections4.set.TransformedSortedSet;
import org.apache.commons.collections4.set.UnmodifiableNavigableSet;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.apache.commons.collections4.set.UnmodifiableSortedSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SetUtils {
    public static final SortedSet EMPTY_SORTED_SET = UnmodifiableSortedSet.unmodifiableSortedSet(new TreeSet());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SetView<E> extends AbstractSet<E> {
        public <S extends Set<E>> void copyInto(S s) {
            CollectionUtils.addAll(s, this);
        }

        public abstract Iterator<E> createIterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(createIterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IteratorUtils.size(iterator());
        }

        public Set<E> toSet() {
            HashSet hashSet = new HashSet(size());
            copyInto(hashSet);
            return hashSet;
        }
    }

    private SetUtils() {
    }

    public static <E> SetView<E> difference(final Set<? extends E> set, final Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        final C13732b c13732b = new C13732b(set2, 0);
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.filteredIterator(set.iterator(), c13732b);
            }
        };
    }

    public static <E> SetView<E> disjunction(final Set<? extends E> set, final Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        final SetView setViewDifference = difference(set, set2);
        final SetView setViewDifference2 = difference(set2, set);
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set2.contains(obj) ^ set.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.chainedIterator(setViewDifference.iterator(), setViewDifference2.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return setViewDifference.isEmpty() && setViewDifference2.isEmpty();
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return setViewDifference2.size() + setViewDifference.size();
            }
        };
    }

    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.EMPTY_SET : set;
    }

    public static <E> Set<E> emptySet() {
        return Collections.EMPTY_SET;
    }

    public static <E> SortedSet<E> emptySortedSet() {
        return EMPTY_SORTED_SET;
    }

    public static <T> int hashCodeForSet(Collection<T> collection) {
        int iHashCode = 0;
        if (collection == null) {
            return 0;
        }
        for (T t : collection) {
            if (t != null) {
                iHashCode = t.hashCode() + iHashCode;
            }
        }
        return iHashCode;
    }

    public static <E> HashSet<E> hashSet(E... eArr) {
        if (eArr == null) {
            return null;
        }
        return new HashSet<>(Arrays.asList(eArr));
    }

    public static <E> SetView<E> intersection(final Set<? extends E> set, final Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                Iterator<E> it = set.iterator();
                Set set3 = set2;
                Objects.requireNonNull(set3);
                return IteratorUtils.filteredIterator(it, new C13732b(set3, 1));
            }
        };
    }

    public static boolean isEqualSet(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        return collection.containsAll(collection2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$difference$0(Set set, Object obj) {
        return !set.contains(obj);
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> orderedSet(Set<E> set) {
        return ListOrderedSet.listOrderedSet(set);
    }

    public static <E> SortedSet<E> predicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        return PredicatedNavigableSet.predicatedNavigableSet(navigableSet, predicate);
    }

    public static <E> Set<E> predicatedSet(Set<E> set, Predicate<? super E> predicate) {
        return PredicatedSet.predicatedSet(set, predicate);
    }

    public static <E> SortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return PredicatedSortedSet.predicatedSortedSet(sortedSet, predicate);
    }

    public static <E> Set<E> synchronizedSet(Set<E> set) {
        return Collections.synchronizedSet(set);
    }

    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> sortedSet) {
        return Collections.synchronizedSortedSet(sortedSet);
    }

    public static <E> SortedSet<E> transformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedNavigableSet.transformingNavigableSet(navigableSet, transformer);
    }

    public static <E> Set<E> transformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        return TransformedSet.transformingSet(set, transformer);
    }

    public static <E> SortedSet<E> transformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedSortedSet.transformingSortedSet(sortedSet, transformer);
    }

    public static <E> SetView<E> union(final Set<? extends E> set, final Set<? extends E> set2) {
        Objects.requireNonNull(set, "setA");
        Objects.requireNonNull(set2, "setB");
        final SetView setViewDifference = difference(set2, set);
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.4
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.chainedIterator(set.iterator(), setViewDifference.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return setViewDifference.size() + set.size();
            }
        };
    }

    public static <E> SortedSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return UnmodifiableNavigableSet.unmodifiableNavigableSet(navigableSet);
    }

    public static <E> Set<E> unmodifiableSet(E... eArr) {
        if (eArr == null) {
            return null;
        }
        return UnmodifiableSet.unmodifiableSet(hashSet(eArr));
    }

    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> sortedSet) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(sortedSet);
    }

    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        return UnmodifiableSet.unmodifiableSet(set);
    }
}
