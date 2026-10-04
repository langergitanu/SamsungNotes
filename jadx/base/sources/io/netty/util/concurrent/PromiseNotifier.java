package io.netty.util.concurrent;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PromiseNotifier.class);
    private final boolean logNotifyFailure;
    private final Promise<? super V>[] promises;

    @SafeVarargs
    public PromiseNotifier(Promise<? super V>... promiseArr) {
        this(true, promiseArr);
    }

    public static <V, F extends Future<V>> F cascade(F f, Promise<? super V> promise) {
        return (F) cascade(true, f, promise);
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(F f) throws ExecutionException, InterruptedException {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        int i = 0;
        if (f.isSuccess()) {
            Object obj = f.get();
            Promise<? super V>[] promiseArr = this.promises;
            int length = promiseArr.length;
            while (i < length) {
                PromiseNotificationUtil.trySuccess(promiseArr[i], obj, internalLogger);
                i++;
            }
            return;
        }
        if (f.isCancelled()) {
            Promise<? super V>[] promiseArr2 = this.promises;
            int length2 = promiseArr2.length;
            while (i < length2) {
                PromiseNotificationUtil.tryCancel(promiseArr2[i], internalLogger);
                i++;
            }
            return;
        }
        Throwable thCause = f.cause();
        Promise<? super V>[] promiseArr3 = this.promises;
        int length3 = promiseArr3.length;
        while (i < length3) {
            PromiseNotificationUtil.tryFailure(promiseArr3[i], thCause, internalLogger);
            i++;
        }
    }

    @SafeVarargs
    public PromiseNotifier(boolean z, Promise<? super V>... promiseArr) {
        ObjectUtil.checkNotNull(promiseArr, "promises");
        for (Promise<? super V> promise : promiseArr) {
            ObjectUtil.checkNotNullWithIAE(promise, Contract.PROMISE);
        }
        this.promises = (Promise[]) promiseArr.clone();
        this.logNotifyFailure = z;
    }

    public static <V, F extends Future<V>> F cascade(boolean z, final F f, final Promise<? super V> promise) {
        promise.addListener((GenericFutureListener<? extends Future<? super Object>>) new FutureListener() { // from class: io.netty.util.concurrent.PromiseNotifier.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future) {
                if (future.isCancelled()) {
                    f.cancel(false);
                }
            }
        });
        f.addListener(new PromiseNotifier(z, new Promise[]{promise}) { // from class: io.netty.util.concurrent.PromiseNotifier.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.netty.util.concurrent.PromiseNotifier, io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future) throws ExecutionException, InterruptedException {
                if (promise.isCancelled() && future.isCancelled()) {
                    return;
                }
                super.operationComplete(f);
            }
        });
        return f;
    }
}
