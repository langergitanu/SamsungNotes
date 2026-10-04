package com.microsoft.identity.common.java.util.ported;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.Serializable;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PropertyBag {
    private final INameValueStorage<Object> mMap = new InMemoryStorage();

    @NonNull
    private <T extends Serializable> T getOrDefaultInternal(@NonNull String str, @Nullable T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return t;
        }
        try {
            return (T) obj;
        } catch (ClassCastException unused) {
            return t;
        }
    }

    @Nullable
    public <T extends Serializable> T get(@NonNull String str) {
        if (str != null) {
            return (T) getOrDefaultInternal(str, null);
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @NonNull
    public <T extends Serializable> T getOrDefault(@NonNull String str, @NonNull T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (t != null) {
            return (T) getOrDefaultInternal(str, t);
        }
        throw new NullPointerException("defaultValue is marked non-null but is null");
    }

    public Set<String> keySet() {
        return this.mMap.keySet();
    }

    public <T extends Serializable> void put(@NonNull String str, @Nullable T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mMap.put(str, t);
    }
}
