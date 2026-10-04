package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface FailableDoubleUnaryOperator<E extends Throwable> {
    public static final FailableDoubleUnaryOperator NOP = new C13879x(1);

    static <E extends Throwable> FailableDoubleUnaryOperator<E> identity() {
        return new C13879x(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default double lambda$andThen$2(FailableDoubleUnaryOperator failableDoubleUnaryOperator, double d) {
        return failableDoubleUnaryOperator.applyAsDouble(applyAsDouble(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default double lambda$compose$3(FailableDoubleUnaryOperator failableDoubleUnaryOperator, double d) {
        return applyAsDouble(failableDoubleUnaryOperator.applyAsDouble(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ double lambda$static$0(double d) {
        return 0.0d;
    }

    static <E extends Throwable> FailableDoubleUnaryOperator<E> nop() {
        return NOP;
    }

    default FailableDoubleUnaryOperator<E> andThen(FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new C13880y(this, failableDoubleUnaryOperator, 1);
    }

    double applyAsDouble(double d);

    default FailableDoubleUnaryOperator<E> compose(FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new C13880y(this, failableDoubleUnaryOperator, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ double lambda$identity$1(double d) {
        return d;
    }
}
