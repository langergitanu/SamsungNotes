package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.ServiceProviders;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalServiceProviders {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PriorityAccessor<T> extends ServiceProviders.PriorityAccessor<T> {
    }

    private InternalServiceProviders() {
    }

    @VisibleForTesting
    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> cls, Iterable<Class<?>> iterable) {
        return ServiceProviders.getCandidatesViaHardCoded(cls, iterable);
    }

    @VisibleForTesting
    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> cls, ClassLoader classLoader) {
        return ServiceProviders.getCandidatesViaServiceLoader(cls, classLoader);
    }

    public static boolean isAndroid(ClassLoader classLoader) {
        return ServiceProviders.isAndroid(classLoader);
    }

    public static <T> T load(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        return (T) ServiceProviders.load(cls, iterable, classLoader, priorityAccessor);
    }

    public static <T> List<T> loadAll(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        return ServiceProviders.loadAll(cls, iterable, classLoader, priorityAccessor);
    }
}
