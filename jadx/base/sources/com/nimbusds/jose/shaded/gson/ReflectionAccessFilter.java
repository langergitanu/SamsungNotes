package com.nimbusds.jose.shaded.gson;

import com.nimbusds.jose.shaded.gson.internal.ReflectionAccessFilterHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new ReflectionAccessFilter() { // from class: com.nimbusds.jose.shaded.gson.ReflectionAccessFilter.1
        @Override // com.nimbusds.jose.shaded.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            return ReflectionAccessFilterHelper.isJavaType(cls) ? FilterResult.BLOCK_INACCESSIBLE : FilterResult.INDECISIVE;
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new ReflectionAccessFilter() { // from class: com.nimbusds.jose.shaded.gson.ReflectionAccessFilter.2
        @Override // com.nimbusds.jose.shaded.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            return ReflectionAccessFilterHelper.isJavaType(cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new ReflectionAccessFilter() { // from class: com.nimbusds.jose.shaded.gson.ReflectionAccessFilter.3
        @Override // com.nimbusds.jose.shaded.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            return ReflectionAccessFilterHelper.isAndroidType(cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new ReflectionAccessFilter() { // from class: com.nimbusds.jose.shaded.gson.ReflectionAccessFilter.4
        @Override // com.nimbusds.jose.shaded.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            return ReflectionAccessFilterHelper.isAnyPlatformType(cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    FilterResult check(Class<?> cls);
}
