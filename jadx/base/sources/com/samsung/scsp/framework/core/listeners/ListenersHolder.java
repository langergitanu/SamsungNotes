package com.samsung.scsp.framework.core.listeners;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ListenersHolder<T> {
    private Map<String, List<String>> headers;
    private final Listeners listeners;
    private T result;

    private ListenersHolder(NetworkStatusListener networkStatusListener, ProgressListener progressListener) {
        Listeners listeners = new Listeners();
        this.listeners = listeners;
        listeners.networkStatusListener = networkStatusListener;
        listeners.progressListener = progressListener;
        listeners.responseListener = new ResponseListener<T>() { // from class: com.samsung.scsp.framework.core.listeners.ListenersHolder.1
            @Override // com.samsung.scsp.framework.core.listeners.ResponseListener
            public void onResponse(T t) {
                ListenersHolder.this.result = t;
            }

            @Override // com.samsung.scsp.framework.core.listeners.ResponseListener
            public void onResponse(T t, Map<String, List<String>> map) {
                ListenersHolder.this.result = t;
                ListenersHolder.this.headers = map;
            }
        };
    }

    public static <T> ListenersHolder<T> create() {
        return new ListenersHolder<>(null, null);
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public Listeners getListeners() {
        return this.listeners;
    }

    public T getResult() {
        return this.result;
    }

    public static <T> ListenersHolder<T> create(NetworkStatusListener networkStatusListener, ProgressListener progressListener) {
        return new ListenersHolder<>(networkStatusListener, progressListener);
    }
}
