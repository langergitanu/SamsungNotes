package org.apache.commons.lang3.compare;

import java.util.function.Predicate;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComparableUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ComparableCheckBuilder<A extends Comparable<A>> {

        /* JADX INFO: renamed from: a */
        private final A f9805a;

        private boolean betweenOrdered(A a, A a3) {
            return greaterThanOrEqualTo(a) && lessThanOrEqualTo(a3);
        }

        private boolean betweenOrderedExclusive(A a, A a3) {
            return greaterThan(a) && lessThan(a3);
        }

        public boolean between(A a, A a3) {
            return betweenOrdered(a, a3) || betweenOrdered(a3, a);
        }

        public boolean betweenExclusive(A a, A a3) {
            return betweenOrderedExclusive(a, a3) || betweenOrderedExclusive(a3, a);
        }

        public boolean equalTo(A a) {
            A a3 = this.f9805a;
            return a3 != null && a3.compareTo(a) == 0;
        }

        public boolean greaterThan(A a) {
            A a3 = this.f9805a;
            return a3 != null && a3.compareTo(a) > 0;
        }

        public boolean greaterThanOrEqualTo(A a) {
            A a3 = this.f9805a;
            return a3 != null && a3.compareTo(a) >= 0;
        }

        public boolean lessThan(A a) {
            A a3 = this.f9805a;
            return a3 != null && a3.compareTo(a) < 0;
        }

        public boolean lessThanOrEqualTo(A a) {
            A a3 = this.f9805a;
            return a3 != null && a3.compareTo(a) <= 0;
        }

        private ComparableCheckBuilder(A a) {
            this.f9805a = a;
        }
    }

    private ComparableUtils() {
    }

    public static <A extends Comparable<A>> Predicate<A> between(A a, A a3) {
        return new C13815b(a, a3, 0);
    }

    public static <A extends Comparable<A>> Predicate<A> betweenExclusive(A a, A a3) {
        return new C13815b(a, a3, 1);
    }

    /* JADX INFO: renamed from: ge */
    public static <A extends Comparable<A>> Predicate<A> m14722ge(A a) {
        return new C13814a(a, 0);
    }

    /* JADX INFO: renamed from: gt */
    public static <A extends Comparable<A>> Predicate<A> m14723gt(A a) {
        return new C13814a(a, 1);
    }

    /* JADX INFO: renamed from: is */
    public static <A extends Comparable<A>> ComparableCheckBuilder<A> m14724is(A a) {
        return new ComparableCheckBuilder<>(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$between$0(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return m14724is(comparable3).between(comparable, comparable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$betweenExclusive$1(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return m14724is(comparable3).betweenExclusive(comparable, comparable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$ge$2(Comparable comparable, Comparable comparable2) {
        return m14724is(comparable2).greaterThanOrEqualTo(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$gt$3(Comparable comparable, Comparable comparable2) {
        return m14724is(comparable2).greaterThan(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$le$4(Comparable comparable, Comparable comparable2) {
        return m14724is(comparable2).lessThanOrEqualTo(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$lt$5(Comparable comparable, Comparable comparable2) {
        return m14724is(comparable2).lessThan(comparable);
    }

    /* JADX INFO: renamed from: le */
    public static <A extends Comparable<A>> Predicate<A> m14725le(A a) {
        return new C13814a(a, 3);
    }

    /* JADX INFO: renamed from: lt */
    public static <A extends Comparable<A>> Predicate<A> m14726lt(A a) {
        return new C13814a(a, 2);
    }

    public static <A extends Comparable<A>> A max(A a, A a3) {
        return ObjectUtils.compare(a, a3, false) > 0 ? a : a3;
    }

    public static <A extends Comparable<A>> A min(A a, A a3) {
        return ObjectUtils.compare(a, a3, true) < 0 ? a : a3;
    }
}
