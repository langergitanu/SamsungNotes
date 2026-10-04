package com.samsung.android.kmxservice.sdk.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxFaultBarrier {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ThrowableRunnable {
        void run();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ThrowableSupplier<T> {
        T get();
    }

    public static <T> T get(ThrowableSupplier<T> throwableSupplier, T t, boolean z) {
        try {
            return throwableSupplier.get();
        } catch (Throwable th) {
            if (!z) {
                th.printStackTrace();
            }
            return t;
        }
    }

    public static void run(ThrowableRunnable throwableRunnable) {
        run(throwableRunnable, false);
    }

    public static void run(ThrowableRunnable throwableRunnable, boolean z) {
        try {
            throwableRunnable.run();
        } catch (Throwable th) {
            if (z) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static <T> T get(ThrowableSupplier<T> throwableSupplier, T t) {
        return (T) get(throwableSupplier, t, false);
    }
}
