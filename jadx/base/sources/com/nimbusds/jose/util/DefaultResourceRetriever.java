package com.nimbusds.jose.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class DefaultResourceRetriever extends AbstractRestrictedResourceRetriever implements RestrictedResourceRetriever {
    private boolean disconnectAfterUse;
    private Proxy proxy;
    private final SSLSocketFactory sslSocketFactory;

    public DefaultResourceRetriever() {
        this(0, 0);
    }

    private InputStream getInputStream(URLConnection uRLConnection, int i) throws IOException {
        InputStream inputStream = uRLConnection.getInputStream();
        return i > 0 ? new BoundedInputStream(inputStream, getSizeLimit()) : inputStream;
    }

    public boolean disconnectsAfterUse() {
        return this.disconnectAfterUse;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Deprecated
    public HttpURLConnection openConnection(URL url) {
        return openHTTPConnection(url);
    }

    public URLConnection openFileConnection(URL url) {
        return url.openConnection();
    }

    public HttpURLConnection openHTTPConnection(URL url) {
        Proxy proxy = this.proxy;
        return proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
    }

    @Override // com.nimbusds.jose.util.ResourceRetriever
    public Resource retrieveResource(URL url) throws Throwable {
        URLConnection uRLConnectionOpenFileConnection;
        SSLSocketFactory sSLSocketFactory;
        URLConnection uRLConnection = null;
        try {
            try {
                uRLConnectionOpenFileConnection = "file".equals(url.getProtocol()) ? openFileConnection(url) : openConnection(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            uRLConnectionOpenFileConnection.setConnectTimeout(getConnectTimeout());
            uRLConnectionOpenFileConnection.setReadTimeout(getReadTimeout());
            if ((uRLConnectionOpenFileConnection instanceof HttpsURLConnection) && (sSLSocketFactory = this.sslSocketFactory) != null) {
                ((HttpsURLConnection) uRLConnectionOpenFileConnection).setSSLSocketFactory(sSLSocketFactory);
            }
            if ((uRLConnectionOpenFileConnection instanceof HttpURLConnection) && getHeaders() != null && !getHeaders().isEmpty()) {
                for (Map.Entry<String, List<String>> entry : getHeaders().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        uRLConnectionOpenFileConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            InputStream inputStream = getInputStream(uRLConnectionOpenFileConnection, getSizeLimit());
            try {
                String inputStreamToString = IOUtils.readInputStreamToString(inputStream, StandardCharset.UTF_8);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (uRLConnectionOpenFileConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenFileConnection;
                    int responseCode = httpURLConnection.getResponseCode();
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseCode > 299 || responseCode < 200) {
                        throw new IOException("HTTP " + responseCode + ": " + responseMessage);
                    }
                }
                Resource resource = new Resource(inputStreamToString, uRLConnectionOpenFileConnection instanceof HttpURLConnection ? uRLConnectionOpenFileConnection.getContentType() : null);
                if (this.disconnectAfterUse && (uRLConnectionOpenFileConnection instanceof HttpURLConnection)) {
                    ((HttpURLConnection) uRLConnectionOpenFileConnection).disconnect();
                }
                return resource;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (Exception e2) {
            e = e2;
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException("Couldn't open URL connection: " + e.getMessage(), e);
        } catch (Throwable th4) {
            uRLConnection = uRLConnectionOpenFileConnection;
            th = th4;
            if (this.disconnectAfterUse && (uRLConnection instanceof HttpURLConnection)) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            throw th;
        }
    }

    public void setDisconnectsAfterUse(boolean z) {
        this.disconnectAfterUse = z;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public DefaultResourceRetriever(int i, int i2) {
        this(i, i2, 0);
    }

    public DefaultResourceRetriever(int i, int i2, int i4) {
        this(i, i2, i4, true);
    }

    public DefaultResourceRetriever(int i, int i2, int i4, boolean z) {
        this(i, i2, i4, z, null);
    }

    public DefaultResourceRetriever(int i, int i2, int i4, boolean z, SSLSocketFactory sSLSocketFactory) {
        super(i, i2, i4);
        this.disconnectAfterUse = z;
        this.sslSocketFactory = sSLSocketFactory;
    }
}
