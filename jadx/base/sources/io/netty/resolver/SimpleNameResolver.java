package io.netty.resolver;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SimpleNameResolver<T> implements NameResolver<T> {
    private final EventExecutor executor;

    public SimpleNameResolver(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    public abstract void doResolve(String str, Promise<T> promise);

    public abstract void doResolveAll(String str, Promise<List<T>> promise);

    public EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.resolver.NameResolver
    public final Future<T> resolve(String str) {
        return resolve(str, executor().newPromise());
    }

    @Override // io.netty.resolver.NameResolver
    public final Future<List<T>> resolveAll(String str) {
        return resolveAll(str, executor().newPromise());
    }

    @Override // io.netty.resolver.NameResolver
    public Future<T> resolve(String str, Promise<T> promise) {
        ObjectUtil.checkNotNull(promise, Contract.PROMISE);
        try {
            doResolve(str, promise);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    @Override // io.netty.resolver.NameResolver
    public Future<List<T>> resolveAll(String str, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(promise, Contract.PROMISE);
        try {
            doResolveAll(str, promise);
            return promise;
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    @Override // io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
