package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface FailableIntUnaryOperator<E extends Throwable> {
    public static final FailableIntUnaryOperator NOP = new C13842G(0);

    static <E extends Throwable> FailableIntUnaryOperator<E> identity() {
        return new C13842G(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default int lambda$andThen$2(FailableIntUnaryOperator failableIntUnaryOperator, int i) {
        return failableIntUnaryOperator.applyAsInt(applyAsInt(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default int lambda$compose$3(FailableIntUnaryOperator failableIntUnaryOperator, int i) {
        return applyAsInt(failableIntUnaryOperator.applyAsInt(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(int i) {
        return 0;
    }

    static <E extends Throwable> FailableIntUnaryOperator<E> nop() {
        return NOP;
    }

    default FailableIntUnaryOperator<E> andThen(FailableIntUnaryOperator<E> failableIntUnaryOperator) {
        Objects.requireNonNull(failableIntUnaryOperator);
        return new C13843H(this, failableIntUnaryOperator, 1);
    }

    int applyAsInt(int i);

    default FailableIntUnaryOperator<E> compose(FailableIntUnaryOperator<E> failableIntUnaryOperator) {
        Objects.requireNonNull(failableIntUnaryOperator);
        return new C13843H(this, failableIntUnaryOperator, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ int lambda$identity$1(int i) {
        return i;
    }
}
