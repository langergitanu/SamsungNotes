package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
class HttpConnPool extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();
    private final HttpClientAndroidLog log;
    private final long timeToLive;
    private final TimeUnit timeUnit;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InternalConnFactory implements ConnFactory<HttpRoute, OperatedClientConnection> {
        private final ClientConnectionOperator connOperator;

        public InternalConnFactory(ClientConnectionOperator clientConnectionOperator) {
            this.connOperator = clientConnectionOperator;
        }

        @Override // cz.msebera.android.httpclient.pool.ConnFactory
        public OperatedClientConnection create(HttpRoute httpRoute) {
            return this.connOperator.createConnection();
        }
    }

    public HttpConnPool(HttpClientAndroidLog httpClientAndroidLog, ClientConnectionOperator clientConnectionOperator, int i, int i2, long j, TimeUnit timeUnit) {
        super(new InternalConnFactory(clientConnectionOperator), i, i2);
        this.log = httpClientAndroidLog;
        this.timeToLive = j;
        this.timeUnit = timeUnit;
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    public HttpPoolEntry createEntry(HttpRoute httpRoute, OperatedClientConnection operatedClientConnection) {
        return new HttpPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), httpRoute, operatedClientConnection, this.timeToLive, this.timeUnit);
    }
}
