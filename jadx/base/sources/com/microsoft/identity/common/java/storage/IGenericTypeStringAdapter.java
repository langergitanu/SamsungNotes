package com.microsoft.identity.common.java.storage;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IGenericTypeStringAdapter<T> {
    public static final IGenericTypeStringAdapter<Long> LongStringAdapter = new IGenericTypeStringAdapter<Long>() { // from class: com.microsoft.identity.common.java.storage.IGenericTypeStringAdapter.1
        @Override // com.microsoft.identity.common.java.storage.IGenericTypeStringAdapter
        @NonNull
        public String adapt(@NonNull Long l) {
            if (l != null) {
                return String.valueOf(l);
            }
            throw new NullPointerException("value is marked non-null but is null");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microsoft.identity.common.java.storage.IGenericTypeStringAdapter
        @NonNull
        public Long adapt(@NonNull String str) {
            if (str != null) {
                return Long.valueOf(Long.parseLong(str));
            }
            throw new NullPointerException("value is marked non-null but is null");
        }
    };

    T adapt(String str);

    String adapt(T t);
}
