package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailablePredicate<T, E extends Throwable> {
    public static final FailablePredicate FALSE;
    public static final FailablePredicate TRUE;

    static {
        final int i = 0;
        FALSE = new FailablePredicate() { // from class: org.apache.commons.lang3.function.S
            @Override // org.apache.commons.lang3.function.FailablePredicate
            public final boolean test(Object obj) {
                switch (i) {
                    case 0:
                        return FailablePredicate.lambda$static$0(obj);
                    default:
                        return FailablePredicate.lambda$static$1(obj);
                }
            }
        };
        final int i2 = 1;
        TRUE = new FailablePredicate() { // from class: org.apache.commons.lang3.function.S
            @Override // org.apache.commons.lang3.function.FailablePredicate
            public final boolean test(Object obj) {
                switch (i2) {
                    case 0:
                        return FailablePredicate.lambda$static$0(obj);
                    default:
                        return FailablePredicate.lambda$static$1(obj);
                }
            }
        };
    }

    static <T, E extends Throwable> FailablePredicate<T, E> falsePredicate() {
        return FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$and$2(FailablePredicate failablePredicate, Object obj) {
        return test(obj) && failablePredicate.test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$negate$3(Object obj) {
        return !test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$or$4(FailablePredicate failablePredicate, Object obj) {
        return test(obj) || failablePredicate.test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(Object obj) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(Object obj) {
        return true;
    }

    static <T, E extends Throwable> FailablePredicate<T, E> truePredicate() {
        return TRUE;
    }

    default FailablePredicate<T, E> and(FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return new C13852Q(this, failablePredicate, 1);
    }

    default FailablePredicate<T, E> negate() {
        return new FailablePredicate() { // from class: org.apache.commons.lang3.function.T
            @Override // org.apache.commons.lang3.function.FailablePredicate
            public final boolean test(Object obj) {
                return this.f9855a.lambda$negate$3(obj);
            }
        };
    }

    /* JADX INFO: renamed from: or */
    default FailablePredicate<T, E> m14834or(FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return new C13852Q(this, failablePredicate, 0);
    }

    boolean test(T t);
}
