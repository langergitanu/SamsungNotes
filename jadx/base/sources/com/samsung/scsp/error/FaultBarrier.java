package com.samsung.scsp.error;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FaultBarrier {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ThrowableFunction<T, R> {
        R apply(T t);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ThrowableRunnable {
        void run();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ThrowableSupplier<T> {
        T get();
    }

    public static <T> Response<T> get(ThrowableSupplier<T> throwableSupplier, T t, boolean z) {
        try {
            return new Response<>(throwableSupplier.get());
        } catch (Throwable th) {
            if (!z) {
                th.printStackTrace();
            }
            return new Response<>(t, ErrorSupplier.get(th));
        }
    }

    public static Result run(ThrowableRunnable throwableRunnable) {
        return run(throwableRunnable, false);
    }

    public static Result run(ThrowableRunnable throwableRunnable, boolean z) {
        try {
            throwableRunnable.run();
            return new Result();
        } catch (Throwable th) {
            if (!z) {
                th.printStackTrace();
            }
            return ErrorSupplier.get(th);
        }
    }

    public static <T> Response<T> get(ThrowableSupplier<T> throwableSupplier, T t) {
        return get(throwableSupplier, t, false);
    }
}
