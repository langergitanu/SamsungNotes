package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface FailableLongUnaryOperator<E extends Throwable> {
    public static final FailableLongUnaryOperator NOP = new C13850O(1);

    static <E extends Throwable> FailableLongUnaryOperator<E> identity() {
        return new C13850O(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default long lambda$andThen$2(FailableLongUnaryOperator failableLongUnaryOperator, long j) {
        return failableLongUnaryOperator.applyAsLong(applyAsLong(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default long lambda$compose$3(FailableLongUnaryOperator failableLongUnaryOperator, long j) {
        return applyAsLong(failableLongUnaryOperator.applyAsLong(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(long j) {
        return 0L;
    }

    static <E extends Throwable> FailableLongUnaryOperator<E> nop() {
        return NOP;
    }

    default FailableLongUnaryOperator<E> andThen(FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return new C13851P(this, failableLongUnaryOperator, 0);
    }

    long applyAsLong(long j);

    default FailableLongUnaryOperator<E> compose(FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return new C13851P(this, failableLongUnaryOperator, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$identity$1(long j) {
        return j;
    }
}
