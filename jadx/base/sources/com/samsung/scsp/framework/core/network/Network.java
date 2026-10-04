package com.samsung.scsp.framework.core.network;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Network {
    public static final int DEFAULT_TIMEOUT = 60000;
    public static final String HTTP_STATUS = "HTTP_STATUS";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ErrorListener {
        void onError(HttpRequest httpRequest, Map<String, List<String>> map, int i, InputStream inputStream);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StreamListener {
        void onStream(HttpRequest httpRequest, Map<String, List<String>> map, InputStream inputStream);
    }

    void close();

    void close(int i);

    void delete(HttpRequest httpRequest, StreamListener streamListener);

    void get(HttpRequest httpRequest, StreamListener streamListener);

    void head(HttpRequest httpRequest, StreamListener streamListener);

    void patch(HttpRequest httpRequest, StreamListener streamListener);

    void post(HttpRequest httpRequest, StreamListener streamListener);

    void put(HttpRequest httpRequest, StreamListener streamListener);
}
