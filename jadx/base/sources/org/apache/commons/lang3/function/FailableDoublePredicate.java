package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableDoublePredicate<E extends Throwable> {
    public static final FailableDoublePredicate FALSE;
    public static final FailableDoublePredicate TRUE;

    static {
        final int i = 0;
        FALSE = new FailableDoublePredicate() { // from class: org.apache.commons.lang3.function.w
            @Override // org.apache.commons.lang3.function.FailableDoublePredicate
            public final boolean test(double d) {
                switch (i) {
                    case 0:
                        return FailableDoublePredicate.lambda$static$0(d);
                    default:
                        return FailableDoublePredicate.lambda$static$1(d);
                }
            }
        };
        final int i2 = 1;
        TRUE = new FailableDoublePredicate() { // from class: org.apache.commons.lang3.function.w
            @Override // org.apache.commons.lang3.function.FailableDoublePredicate
            public final boolean test(double d) {
                switch (i2) {
                    case 0:
                        return FailableDoublePredicate.lambda$static$0(d);
                    default:
                        return FailableDoublePredicate.lambda$static$1(d);
                }
            }
        };
    }

    static <E extends Throwable> FailableDoublePredicate<E> falsePredicate() {
        return FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$and$2(FailableDoublePredicate failableDoublePredicate, double d) {
        return test(d) && failableDoublePredicate.test(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$negate$3(double d) {
        return !test(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$or$4(FailableDoublePredicate failableDoublePredicate, double d) {
        return test(d) || failableDoublePredicate.test(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(double d) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(double d) {
        return true;
    }

    static <E extends Throwable> FailableDoublePredicate<E> truePredicate() {
        return TRUE;
    }

    default FailableDoublePredicate<E> and(FailableDoublePredicate<E> failableDoublePredicate) {
        Objects.requireNonNull(failableDoublePredicate);
        return new C13876u(this, failableDoublePredicate, 1);
    }

    default FailableDoublePredicate<E> negate() {
        return new FailableDoublePredicate() { // from class: org.apache.commons.lang3.function.v
            @Override // org.apache.commons.lang3.function.FailableDoublePredicate
            public final boolean test(double d) {
                return this.f9893a.lambda$negate$3(d);
            }
        };
    }

    /* JADX INFO: renamed from: or */
    default FailableDoublePredicate<E> m14784or(FailableDoublePredicate<E> failableDoublePredicate) {
        Objects.requireNonNull(failableDoublePredicate);
        return new C13876u(this, failableDoublePredicate, 0);
    }

    boolean test(double d);
}
