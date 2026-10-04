package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableLongPredicate<E extends Throwable> {
    public static final FailableLongPredicate FALSE;
    public static final FailableLongPredicate TRUE;

    static {
        final int i = 0;
        FALSE = new FailableLongPredicate() { // from class: org.apache.commons.lang3.function.M
            @Override // org.apache.commons.lang3.function.FailableLongPredicate
            public final boolean test(long j) {
                switch (i) {
                    case 0:
                        return FailableLongPredicate.lambda$static$0(j);
                    default:
                        return FailableLongPredicate.lambda$static$1(j);
                }
            }
        };
        final int i2 = 1;
        TRUE = new FailableLongPredicate() { // from class: org.apache.commons.lang3.function.M
            @Override // org.apache.commons.lang3.function.FailableLongPredicate
            public final boolean test(long j) {
                switch (i2) {
                    case 0:
                        return FailableLongPredicate.lambda$static$0(j);
                    default:
                        return FailableLongPredicate.lambda$static$1(j);
                }
            }
        };
    }

    static <E extends Throwable> FailableLongPredicate<E> falsePredicate() {
        return FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$and$2(FailableLongPredicate failableLongPredicate, long j) {
        return test(j) && failableLongPredicate.test(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$negate$3(long j) {
        return !test(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$or$4(FailableLongPredicate failableLongPredicate, long j) {
        return test(j) || failableLongPredicate.test(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(long j) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(long j) {
        return true;
    }

    static <E extends Throwable> FailableLongPredicate<E> truePredicate() {
        return TRUE;
    }

    default FailableLongPredicate<E> and(FailableLongPredicate<E> failableLongPredicate) {
        Objects.requireNonNull(failableLongPredicate);
        return new C13846K(this, failableLongPredicate, 0);
    }

    default FailableLongPredicate<E> negate() {
        return new FailableLongPredicate() { // from class: org.apache.commons.lang3.function.L
            @Override // org.apache.commons.lang3.function.FailableLongPredicate
            public final boolean test(long j) {
                return this.f9844a.lambda$negate$3(j);
            }
        };
    }

    /* JADX INFO: renamed from: or */
    default FailableLongPredicate<E> m14819or(FailableLongPredicate<E> failableLongPredicate) {
        Objects.requireNonNull(failableLongPredicate);
        return new C13846K(this, failableLongPredicate, 1);
    }

    boolean test(long j);
}
