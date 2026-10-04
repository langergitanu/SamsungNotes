package io.netty.util.concurrent;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class UnaryPromiseNotifier<T> implements FutureListener<T> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) UnaryPromiseNotifier.class);
    private final Promise<? super T> promise;

    public UnaryPromiseNotifier(Promise<? super T> promise) {
        this.promise = (Promise) ObjectUtil.checkNotNull(promise, Contract.PROMISE);
    }

    public static <X> void cascadeTo(Future<X> future, Promise<? super X> promise) {
        if (future.isSuccess()) {
            if (promise.trySuccess(future.getNow())) {
                return;
            }
            logger.warn("Failed to mark a promise as success because it is done already: {}", promise);
        } else if (future.isCancelled()) {
            if (promise.cancel(false)) {
                return;
            }
            logger.warn("Failed to cancel a promise because it is done already: {}", promise);
        } else {
            if (promise.tryFailure(future.cause())) {
                return;
            }
            logger.warn("Failed to mark a promise as failure because it's done already: {}", promise, future.cause());
        }
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future<T> future) {
        cascadeTo(future, this.promise);
    }
}
