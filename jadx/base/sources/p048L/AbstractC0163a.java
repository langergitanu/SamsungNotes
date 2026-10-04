package p048L;

import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/* JADX INFO: renamed from: L.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0163a {

    /* JADX INFO: renamed from: a */
    public Future f501a;

    /* JADX INFO: renamed from: b */
    public final ExecutorService f502b = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: d */
    public static final ConnectionConfig f499d = ConnectionConfig.custom().setCharset(Charset.forName("UTF-8")).setBufferSize(524288).build();

    /* JADX INFO: renamed from: e */
    public static final SocketConfig f500e = SocketConfig.custom().setSoTimeout(120000).build();

    /* JADX INFO: renamed from: c */
    public static final RequestConfig f498c = RequestConfig.custom().setConnectionRequestTimeout(29000).setConnectTimeout(29000).setSocketTimeout(120000).setExpectContinueEnabled(false).setStaleConnectionCheckEnabled(true).setRedirectsEnabled(false).build();

    /* JADX INFO: renamed from: a */
    public abstract void mo419a(HttpRequestBase httpRequestBase);

    /* JADX INFO: renamed from: b */
    public final void m420b() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("executeGetRequest() : Thread interrupted!");
        }
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        try {
            poolingHttpClientConnectionManager.setDefaultConnectionConfig(f499d);
            poolingHttpClientConnectionManager.setDefaultSocketConfig(f500e);
            CloseableHttpClient closeableHttpClientBuild = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).setDefaultRequestConfig(f498c).build();
            try {
                HttpGet httpGet = new HttpGet(mo422d());
                mo419a(httpGet);
                CloseableHttpResponse closeableHttpResponseExecute = closeableHttpClientBuild.execute((HttpUriRequest) httpGet);
                int statusCode = closeableHttpResponseExecute.getStatusLine().getStatusCode();
                if (statusCode < 200 || statusCode >= 300) {
                    mo426h(statusCode, EntityUtils.toString(closeableHttpResponseExecute.getEntity()));
                } else if (closeableHttpResponseExecute.getEntity() != null) {
                    mo427i(statusCode, EntityUtils.toString(closeableHttpResponseExecute.getEntity()));
                } else {
                    mo427i(statusCode, "");
                }
                closeableHttpClientBuild.close();
                poolingHttpClientConnectionManager.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                poolingHttpClientConnectionManager.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m421c() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("executePostRequest() : Thread interrupted!");
        }
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        try {
            poolingHttpClientConnectionManager.setDefaultConnectionConfig(f499d);
            poolingHttpClientConnectionManager.setDefaultSocketConfig(f500e);
            CloseableHttpClient closeableHttpClientBuild = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).setDefaultRequestConfig(f498c).build();
            try {
                HttpPost httpPost = new HttpPost(mo422d());
                httpPost.setHeader("Content-Type", "application/json");
                httpPost.setEntity(new StringEntity(mo423e(), "UTF-8"));
                mo419a(httpPost);
                httpPost.setHeader("Accept", "application/json");
                CloseableHttpResponse closeableHttpResponseExecute = closeableHttpClientBuild.execute((HttpUriRequest) httpPost);
                int statusCode = closeableHttpResponseExecute.getStatusLine().getStatusCode();
                if (statusCode < 200 || statusCode >= 300) {
                    mo426h(statusCode, EntityUtils.toString(closeableHttpResponseExecute.getEntity()));
                } else {
                    mo427i(statusCode, EntityUtils.toString(closeableHttpResponseExecute.getEntity()));
                }
                closeableHttpClientBuild.close();
                poolingHttpClientConnectionManager.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                poolingHttpClientConnectionManager.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    public abstract String mo422d();

    /* JADX INFO: renamed from: e */
    public abstract String mo423e();

    /* JADX INFO: renamed from: f */
    public abstract void mo424f();

    /* JADX INFO: renamed from: g */
    public abstract void mo425g(int i, String str);

    /* JADX INFO: renamed from: h */
    public abstract void mo426h(int i, String str);

    /* JADX INFO: renamed from: i */
    public abstract void mo427i(int i, String str);
}
