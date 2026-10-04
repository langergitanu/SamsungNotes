package org.apache.http.impl.client;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class StandardHttpRequestRetryHandler extends DefaultHttpRequestRetryHandlerHC4 {
    private final Map<String, Boolean> idempotentMethods;

    public StandardHttpRequestRetryHandler(int i, boolean z) {
        super(i, z);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.idempotentMethods = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("GET", bool);
        concurrentHashMap.put("HEAD", bool);
        concurrentHashMap.put("PUT", bool);
        concurrentHashMap.put("DELETE", bool);
        concurrentHashMap.put("OPTIONS", bool);
        concurrentHashMap.put("TRACE", bool);
    }

    @Override // org.apache.http.impl.client.DefaultHttpRequestRetryHandlerHC4
    public boolean handleAsIdempotent(HttpRequest httpRequest) {
        Boolean bool = this.idempotentMethods.get(httpRequest.getRequestLine().getMethod().toUpperCase(Locale.ENGLISH));
        return bool != null && bool.booleanValue();
    }

    public StandardHttpRequestRetryHandler() {
        this(3, false);
    }
}
