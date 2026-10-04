package org.apache.commons.lang3.function;

import androidx.appcompat.animation.C0422b;
import androidx.transition.C3970a;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.vladsch.flexmark.util.ast.C11836a;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.C13883h;
import org.apache.commons.lang3.C13893r;
import org.apache.commons.lang3.C13898s;
import org.apache.commons.lang3.event.C13832a;
import org.apache.commons.lang3.exception.C13834b;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.stream.Streams;
import p012C1.CallableC0046b;
import p074R1.C0230b;
import p092W3.C0332a;
import p122b2.C4192o;
import p188i3.RunnableC12034a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Failable {
    private Failable() {
    }

    public static <T, U, E extends Throwable> void accept(final FailableBiConsumer<T, U, E> failableBiConsumer, final T t, final U u) {
        run(failableBiConsumer, new FailableRunnable() { // from class: org.apache.commons.lang3.function.i
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                failableBiConsumer.accept(t, u);
            }
        });
    }

    public static <T, U, R, E extends Throwable> R apply(final FailableBiFunction<T, U, R, E> failableBiFunction, final T t, final U u) {
        return (R) get(new FailableSupplier() { // from class: org.apache.commons.lang3.function.j
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                return failableBiFunction.apply(t, u);
            }
        });
    }

    public static <E extends Throwable> double applyAsDouble(final FailableDoubleBinaryOperator<E> failableDoubleBinaryOperator, final double d, final double d2) {
        return getAsDouble(new FailableDoubleSupplier() { // from class: org.apache.commons.lang3.function.e
            @Override // org.apache.commons.lang3.function.FailableDoubleSupplier
            public final double getAsDouble() {
                return failableDoubleBinaryOperator.applyAsDouble(d, d2);
            }
        });
    }

    public static <T, U> BiConsumer<T, U> asBiConsumer(FailableBiConsumer<T, U, ?> failableBiConsumer) {
        return new C11836a(failableBiConsumer, 5);
    }

    public static <T, U, R> BiFunction<T, U, R> asBiFunction(FailableBiFunction<T, U, R, ?> failableBiFunction) {
        return new C4192o(failableBiFunction, 5);
    }

    public static <T, U> BiPredicate<T, U> asBiPredicate(FailableBiPredicate<T, U, ?> failableBiPredicate) {
        return new C13893r(failableBiPredicate, 1);
    }

    public static <V> Callable<V> asCallable(FailableCallable<V, ?> failableCallable) {
        return new CallableC0046b(failableCallable, 6);
    }

    public static <T> Consumer<T> asConsumer(FailableConsumer<T, ?> failableConsumer) {
        return new C13834b(failableConsumer, 3);
    }

    public static <T, R> Function<T, R> asFunction(FailableFunction<T, R, ?> failableFunction) {
        return new C0332a(failableFunction, 20);
    }

    public static <T> Predicate<T> asPredicate(FailablePredicate<T, ?> failablePredicate) {
        return new C7233a(failablePredicate, 15);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return new RunnableC12034a(failableRunnable, 10);
    }

    public static <T> Supplier<T> asSupplier(FailableSupplier<T, ?> failableSupplier) {
        return new C0230b(failableSupplier, 7);
    }

    public static <V, E extends Throwable> V call(final FailableCallable<V, E> failableCallable) {
        Objects.requireNonNull(failableCallable);
        return (V) get(new FailableSupplier() { // from class: org.apache.commons.lang3.function.g
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                return failableCallable.call();
            }
        });
    }

    public static <T, E extends Throwable> T get(FailableSupplier<T, E> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<E> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> double getAsDouble(FailableDoubleSupplier<E> failableDoubleSupplier) {
        try {
            return failableDoubleSupplier.getAsDouble();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> int getAsInt(FailableIntSupplier<E> failableIntSupplier) {
        try {
            return failableIntSupplier.getAsInt();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> long getAsLong(FailableLongSupplier<E> failableLongSupplier) {
        try {
            return failableLongSupplier.getAsLong();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> short getAsShort(FailableShortSupplier<E> failableShortSupplier) {
        try {
            return failableShortSupplier.getAsShort();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static RuntimeException rethrow(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        ExceptionUtils.throwUnchecked(th);
        if (th instanceof IOException) {
            throw new UncheckedIOException((IOException) th);
        }
        throw new UndeclaredThrowableException(th);
    }

    public static <E extends Throwable> void run(FailableRunnable<E> failableRunnable) {
        if (failableRunnable != null) {
            try {
                failableRunnable.run();
            } catch (Throwable th) {
                throw rethrow(th);
            }
        }
    }

    public static <E> Streams.FailableStream<E> stream(Collection<E> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <T, U, E extends Throwable> boolean test(FailableBiPredicate<T, U, E> failableBiPredicate, T t, U u) {
        return getAsBoolean(new C3970a(failableBiPredicate, 11, t, u));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            failableConsumer = new C13832a(1);
        }
        Streams.m14874of(failableRunnableArr).forEach(new C0422b(4));
        try {
            failableRunnable.run();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable2 : failableRunnableArr) {
                try {
                    failableRunnable2.run();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
            }
        }
        if (th != null) {
            try {
                failableConsumer.accept(th);
            } catch (Throwable th3) {
                throw rethrow(th3);
            }
        }
    }

    public static <T, E extends Throwable> void accept(final FailableConsumer<T, E> failableConsumer, final T t) {
        run(failableConsumer, new FailableRunnable() { // from class: org.apache.commons.lang3.function.f
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                failableConsumer.accept(t);
            }
        });
    }

    public static <T, R, E extends Throwable> R apply(final FailableFunction<T, R, E> failableFunction, final T t) {
        return (R) get(new FailableSupplier() { // from class: org.apache.commons.lang3.function.h
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                return failableFunction.apply(t);
            }
        });
    }

    public static <T> Streams.FailableStream<T> stream(Stream<T> stream) {
        return new Streams.FailableStream<>(stream);
    }

    public static <T, E extends Throwable> boolean test(FailablePredicate<T, E> failablePredicate, T t) {
        return getAsBoolean(new C13883h(failablePredicate, t, 4));
    }

    public static <E extends Throwable> void accept(final FailableDoubleConsumer<E> failableDoubleConsumer, final double d) {
        run(failableDoubleConsumer, new FailableRunnable() { // from class: org.apache.commons.lang3.function.d
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                failableDoubleConsumer.accept(d);
            }
        });
    }

    private static <E extends Throwable> void run(Object obj, FailableRunnable<E> failableRunnable) {
        if (failableRunnable == null || obj == null) {
            return;
        }
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> void accept(FailableIntConsumer<E> failableIntConsumer, int i) {
        run(failableIntConsumer, new C13898s(failableIntConsumer, i, 1));
    }

    public static <E extends Throwable> void accept(final FailableLongConsumer<E> failableLongConsumer, final long j) {
        run(failableLongConsumer, new FailableRunnable() { // from class: org.apache.commons.lang3.function.c
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                failableLongConsumer.accept(j);
            }
        });
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, null, failableRunnableArr);
    }
}
