package io.grpc.internal;

import io.grpc.internal.SharedResourceHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class SharedResourcePool<T> implements ObjectPool<T> {
    private final SharedResourceHolder.Resource<T> resource;

    private SharedResourcePool(SharedResourceHolder.Resource<T> resource) {
        this.resource = resource;
    }

    public static <T> SharedResourcePool<T> forResource(SharedResourceHolder.Resource<T> resource) {
        return new SharedResourcePool<>(resource);
    }

    @Override // io.grpc.internal.ObjectPool
    public T getObject() {
        return (T) SharedResourceHolder.get(this.resource);
    }

    @Override // io.grpc.internal.ObjectPool
    public T returnObject(Object obj) {
        SharedResourceHolder.release(this.resource, obj);
        return null;
    }
}
