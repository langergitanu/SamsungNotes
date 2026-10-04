package org.apache.commons.lang3.concurrent;

import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface UncheckedFuture<V> extends Future<V> {
    static <T> Stream<UncheckedFuture<T>> map(Collection<Future<T>> collection) {
        return (Stream<UncheckedFuture<T>>) collection.stream().map(new C11419a(29));
    }

    /* JADX INFO: renamed from: on */
    static <T> Collection<UncheckedFuture<T>> m14733on(Collection<Future<T>> collection) {
        return (Collection) map(collection).collect(Collectors.toList());
    }

    @Override // java.util.concurrent.Future
    V get();

    @Override // java.util.concurrent.Future
    V get(long j, TimeUnit timeUnit);

    /* JADX INFO: renamed from: on */
    static <T> UncheckedFuture<T> m14734on(Future<T> future) {
        return new UncheckedFutureImpl(future);
    }
}
