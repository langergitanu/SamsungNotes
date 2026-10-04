package com.samsung.scsp.framework.core.listeners;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ResponseListener<T> {
    void onResponse(T t);

    default void onResponse(T t, Map<String, List<String>> map) {
        onResponse(t);
    }
}
