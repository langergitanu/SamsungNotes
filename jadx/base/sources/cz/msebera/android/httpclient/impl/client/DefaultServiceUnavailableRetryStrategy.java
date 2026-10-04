package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class DefaultServiceUnavailableRetryStrategy implements ServiceUnavailableRetryStrategy {
    private final int maxRetries;
    private final long retryInterval;

    public DefaultServiceUnavailableRetryStrategy(int i, int i2) {
        Args.positive(i, "Max retries");
        Args.positive(i2, "Retry interval");
        this.maxRetries = i;
        this.retryInterval = i2;
    }

    @Override // cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy
    public long getRetryInterval() {
        return this.retryInterval;
    }

    @Override // cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy
    public boolean retryRequest(HttpResponse httpResponse, int i, HttpContext httpContext) {
        return i <= this.maxRetries && httpResponse.getStatusLine().getStatusCode() == 503;
    }

    public DefaultServiceUnavailableRetryStrategy() {
        this(1, 1000);
    }
}
