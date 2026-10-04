package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableIntPredicate<E extends Throwable> {
    public static final FailableIntPredicate FALSE;
    public static final FailableIntPredicate TRUE;

    static {
        final int i = 0;
        FALSE = new FailableIntPredicate() { // from class: org.apache.commons.lang3.function.E
            @Override // org.apache.commons.lang3.function.FailableIntPredicate
            public final boolean test(int i2) {
                switch (i) {
                    case 0:
                        return FailableIntPredicate.lambda$static$0(i2);
                    default:
                        return FailableIntPredicate.lambda$static$1(i2);
                }
            }
        };
        final int i2 = 1;
        TRUE = new FailableIntPredicate() { // from class: org.apache.commons.lang3.function.E
            @Override // org.apache.commons.lang3.function.FailableIntPredicate
            public final boolean test(int i22) {
                switch (i2) {
                    case 0:
                        return FailableIntPredicate.lambda$static$0(i22);
                    default:
                        return FailableIntPredicate.lambda$static$1(i22);
                }
            }
        };
    }

    static <E extends Throwable> FailableIntPredicate<E> falsePredicate() {
        return FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$and$2(FailableIntPredicate failableIntPredicate, int i) {
        return test(i) && failableIntPredicate.test(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$negate$3(int i) {
        return !test(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$or$4(FailableIntPredicate failableIntPredicate, int i) {
        return test(i) || failableIntPredicate.test(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(int i) {
        return true;
    }

    static <E extends Throwable> FailableIntPredicate<E> truePredicate() {
        return TRUE;
    }

    default FailableIntPredicate<E> and(FailableIntPredicate<E> failableIntPredicate) {
        Objects.requireNonNull(failableIntPredicate);
        return new C13839D(this, failableIntPredicate, 0);
    }

    default FailableIntPredicate<E> negate() {
        return new FailableIntPredicate() { // from class: org.apache.commons.lang3.function.F
            @Override // org.apache.commons.lang3.function.FailableIntPredicate
            public final boolean test(int i) {
                return this.f9834a.lambda$negate$3(i);
            }
        };
    }

    /* JADX INFO: renamed from: or */
    default FailableIntPredicate<E> m14803or(FailableIntPredicate<E> failableIntPredicate) {
        Objects.requireNonNull(failableIntPredicate);
        return new C13839D(this, failableIntPredicate, 1);
    }

    boolean test(int i);
}
