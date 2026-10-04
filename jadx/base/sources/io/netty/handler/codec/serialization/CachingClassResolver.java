package io.netty.handler.codec.serialization;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class CachingClassResolver implements ClassResolver {
    private final Map<String, Class<?>> classCache;
    private final ClassResolver delegate;

    public CachingClassResolver(ClassResolver classResolver, Map<String, Class<?>> map) {
        this.delegate = classResolver;
        this.classCache = map;
    }

    @Override // io.netty.handler.codec.serialization.ClassResolver
    public Class<?> resolve(String str) {
        Class<?> cls = this.classCache.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> clsResolve = this.delegate.resolve(str);
        this.classCache.put(str, clsResolve);
        return clsResolve;
    }
}
