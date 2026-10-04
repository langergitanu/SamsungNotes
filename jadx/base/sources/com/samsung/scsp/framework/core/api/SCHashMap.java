package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.error.FaultBarrier;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SCHashMap extends HashMap<String, Object> {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$getAsBoolean$2(Object obj) {
        if (obj instanceof CharSequence) {
            return Boolean.valueOf(obj.toString());
        }
        if (obj != null) {
            return (Boolean) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getAsInteger$1(Object obj) {
        if (obj instanceof CharSequence) {
            return Integer.valueOf(obj.toString());
        }
        if (obj != null) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getAsLong$0(Object obj) {
        if (obj instanceof CharSequence) {
            return Long.valueOf(obj.toString());
        }
        if (obj != null) {
            return Long.valueOf(((Number) obj).longValue());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Boolean getAsBoolean(String str) {
        return (Boolean) FaultBarrier.get(new C11643g(get(str), 2), null).obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Integer getAsInteger(String str) {
        return (Integer) FaultBarrier.get(new C11643g(get(str), 0), null).obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Long getAsLong(String str) {
        return (Long) FaultBarrier.get(new C11643g(get(str), 1), null).obj;
    }

    public String getAsString(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }
}
