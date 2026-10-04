package com.microsoft.identity.common.internal.logging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({"NM_SAME_SIMPLE_NAME_AS_SUPERCLASS"})
@Deprecated
public final class DiagnosticContext extends com.microsoft.identity.common.logging.DiagnosticContext {
    private static final String TAG = "DiagnosticContext";
    private static boolean sLogDeprecationWarning = true;

    public static void clear() {
        logDeprecationWarning();
        com.microsoft.identity.common.logging.DiagnosticContext.clear();
    }

    public static IRequestContext getRequestContext() {
        logDeprecationWarning();
        final com.microsoft.identity.common.java.logging.IRequestContext requestContext = com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.getRequestContext();
        return new IRequestContext() { // from class: com.microsoft.identity.common.internal.logging.DiagnosticContext.1
            @Override // java.util.Map
            public void clear() {
                requestContext.clear();
            }

            @Override // java.util.Map
            public boolean containsKey(@Nullable Object obj) {
                return requestContext.containsKey(obj);
            }

            @Override // java.util.Map
            public boolean containsValue(@Nullable Object obj) {
                return requestContext.containsValue(obj);
            }

            @Override // java.util.Map
            @NonNull
            public Set<Map.Entry<String, String>> entrySet() {
                return requestContext.entrySet();
            }

            @Override // java.util.Map
            public boolean isEmpty() {
                return requestContext.isEmpty();
            }

            @Override // java.util.Map
            @NonNull
            public Set<String> keySet() {
                return requestContext.keySet();
            }

            @Override // java.util.Map
            public void putAll(@NonNull Map<? extends String, ? extends String> map) {
                requestContext.putAll(map);
            }

            @Override // java.util.Map
            public int size() {
                return requestContext.size();
            }

            @Override // com.microsoft.identity.common.java.logging.IRequestContext
            public String toJsonString() {
                return requestContext.toJsonString();
            }

            @Override // java.util.Map
            @NonNull
            public Collection<String> values() {
                return requestContext.values();
            }

            @Override // java.util.Map
            @Nullable
            public String get(@Nullable Object obj) {
                return requestContext.get(obj);
            }

            @Override // java.util.Map
            @Nullable
            public String put(String str, String str2) {
                return requestContext.put(str, str2);
            }

            @Override // java.util.Map
            @Nullable
            public String remove(@Nullable Object obj) {
                return requestContext.remove(obj);
            }
        };
    }

    private static void logDeprecationWarning() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":logDeprecationWarning", new StringBuilder());
        if (sLogDeprecationWarning) {
            sLogDeprecationWarning = false;
            com.microsoft.identity.common.logging.Logger.warn(strM1170p, "This class is deprecated. Migrate usage to: com.microsoft.identity.common.logging.DiagnosticContext");
        }
    }

    public static void setRequestContext(IRequestContext iRequestContext) {
        com.microsoft.identity.common.logging.DiagnosticContext.setRequestContext(iRequestContext);
        logDeprecationWarning();
    }
}
