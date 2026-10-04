package org.apache.commons.lang3;

import androidx.transition.C3970a;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.vladsch.flexmark.util.ast.C11836a;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
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
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import p012C1.CallableC0046b;
import p074R1.C0230b;
import p092W3.C0332a;
import p122b2.C4191n;
import p122b2.C4192o;
import p188i3.RunnableC12034a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class Functions {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableBiConsumer<O1, O2, T extends Throwable> {
        void accept(O1 o12, O2 o22);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableBiFunction<O1, O2, R, T extends Throwable> {
        R apply(O1 o12, O2 o22);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableBiPredicate<O1, O2, T extends Throwable> {
        boolean test(O1 o12, O2 o22);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableCallable<R, T extends Throwable> {
        R call();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableConsumer<O, T extends Throwable> {
        void accept(O o);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableFunction<I, R, T extends Throwable> {
        R apply(I i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailablePredicate<I, T extends Throwable> {
        boolean test(I i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableRunnable<T extends Throwable> {
        void run();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    @Deprecated
    public interface FailableSupplier<R, T extends Throwable> {
        R get();
    }

    public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> failableBiConsumer, O1 o12, O2 o22) {
        run(new C3970a(failableBiConsumer, 8, o12, o22));
    }

    public static <O1, O2, O, T extends Throwable> O apply(FailableBiFunction<O1, O2, O, T> failableBiFunction, O1 o12, O2 o22) {
        return (O) get(new C3970a(failableBiFunction, 9, o12, o22));
    }

    public static <O1, O2> BiConsumer<O1, O2> asBiConsumer(FailableBiConsumer<O1, O2, ?> failableBiConsumer) {
        return new C11836a(failableBiConsumer, 4);
    }

    public static <O1, O2, O> BiFunction<O1, O2, O> asBiFunction(FailableBiFunction<O1, O2, O, ?> failableBiFunction) {
        return new C4192o(failableBiFunction, 4);
    }

    public static <O1, O2> BiPredicate<O1, O2> asBiPredicate(FailableBiPredicate<O1, O2, ?> failableBiPredicate) {
        return new C13893r(failableBiPredicate, 0);
    }

    public static <O> Callable<O> asCallable(FailableCallable<O, ?> failableCallable) {
        return new CallableC0046b(failableCallable, 5);
    }

    public static <I> Consumer<I> asConsumer(FailableConsumer<I, ?> failableConsumer) {
        return new C4191n(failableConsumer, 28);
    }

    public static <I, O> Function<I, O> asFunction(FailableFunction<I, O, ?> failableFunction) {
        return new C0332a(failableFunction, 16);
    }

    public static <I> Predicate<I> asPredicate(FailablePredicate<I, ?> failablePredicate) {
        return new C7233a(failablePredicate, 12);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return new RunnableC12034a(failableRunnable, 8);
    }

    public static <O> Supplier<O> asSupplier(FailableSupplier<O, ?> failableSupplier) {
        return new C0230b(failableSupplier, 6);
    }

    public static <O, T extends Throwable> O call(FailableCallable<O, T> failableCallable) {
        Objects.requireNonNull(failableCallable);
        return (O) get(new C11253j(failableCallable, 23));
    }

    public static <O, T extends Throwable> O get(FailableSupplier<O, T> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    private static <T extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<T> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$tryWithResources$15(FailableRunnable[] failableRunnableArr, int i) {
        failableRunnableArr[i].run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ org.apache.commons.lang3.function.FailableRunnable lambda$tryWithResources$16(FailableRunnable[] failableRunnableArr, int i) {
        return new C13898s(failableRunnableArr, i, 0);
    }

    public static RuntimeException rethrow(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        ExceptionUtils.throwUnchecked(th);
        if (th instanceof IOException) {
            throw new UncheckedIOException((IOException) th);
        }
        throw new UndeclaredThrowableException(th);
    }

    public static <T extends Throwable> void run(FailableRunnable<T> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O> Streams.FailableStream<O> stream(Collection<O> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> failableBiPredicate, O1 o12, O2 o22) {
        return getAsBoolean(new C3970a(failableBiPredicate, 10, o12, o22));
    }

    @SafeVarargs
    public static void tryWithResources(final FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        org.apache.commons.lang3.function.FailableRunnable[] failableRunnableArr2 = new org.apache.commons.lang3.function.FailableRunnable[failableRunnableArr.length];
        Arrays.setAll(failableRunnableArr2, new C13831e(failableRunnableArr, 9));
        Objects.requireNonNull(failableRunnable);
        Failable.tryWithResources(new org.apache.commons.lang3.function.FailableRunnable() { // from class: org.apache.commons.lang3.t
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                failableRunnable.run();
            }
        }, failableConsumer != null ? new C13926u(failableConsumer, 0) : null, failableRunnableArr2);
    }

    public static <O, T extends Throwable> void accept(FailableConsumer<O, T> failableConsumer, O o) {
        run(new C13883h(failableConsumer, o, 3));
    }

    public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> failableFunction, I i) {
        return (O) get(new C13883h(failableFunction, i, 2));
    }

    public static <O> Streams.FailableStream<O> stream(Stream<O> stream) {
        return new Streams.FailableStream<>(stream);
    }

    public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> failablePredicate, O o) {
        return getAsBoolean(new C13883h(failablePredicate, o, 1));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, null, failableRunnableArr);
    }
}
