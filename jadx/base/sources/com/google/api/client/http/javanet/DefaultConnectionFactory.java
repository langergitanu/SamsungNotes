package com.google.api.client.http.javanet;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DefaultConnectionFactory implements ConnectionFactory {
    private final Proxy proxy;

    public DefaultConnectionFactory() {
        this(null);
    }

    @Override // com.google.api.client.http.javanet.ConnectionFactory
    public HttpURLConnection openConnection(URL url) {
        Proxy proxy = this.proxy;
        return (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
    }

    public DefaultConnectionFactory(Proxy proxy) {
        this.proxy = proxy;
    }
}
