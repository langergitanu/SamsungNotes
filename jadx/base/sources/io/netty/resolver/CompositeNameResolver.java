package io.netty.resolver;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class CompositeNameResolver<T> extends SimpleNameResolver<T> {
    private final NameResolver<T>[] resolvers;

    public CompositeNameResolver(EventExecutor eventExecutor, NameResolver<T>... nameResolverArr) {
        super(eventExecutor);
        ObjectUtil.checkNotNull(nameResolverArr, "resolvers");
        for (int i = 0; i < nameResolverArr.length; i++) {
            ObjectUtil.checkNotNull(nameResolverArr[i], "resolvers[" + i + PropertyUtils.INDEXED_DELIM2);
        }
        if (nameResolverArr.length < 2) {
            throw new IllegalArgumentException(AbstractC0541b.m777s(new StringBuilder("resolvers: "), Arrays.asList(nameResolverArr), " (expected: at least 2 resolvers)"));
        }
        this.resolvers = (NameResolver[]) nameResolverArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllRec(final String str, final Promise<List<T>> promise, final int i, Throwable th) {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolveAll(str).addListener(new FutureListener<List<T>>() { // from class: io.netty.resolver.CompositeNameResolver.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<List<T>> future) {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveAllRec(str, promise, i + 1, future.cause());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveRec(final String str, final Promise<T> promise, final int i, Throwable th) {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolve(str).addListener(new FutureListener<T>() { // from class: io.netty.resolver.CompositeNameResolver.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveRec(str, promise, i + 1, future.cause());
                    }
                }
            });
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolve(String str, Promise<T> promise) {
        doResolveRec(str, promise, 0, null);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolveAll(String str, Promise<List<T>> promise) {
        doResolveAllRec(str, promise, 0, null);
    }
}
