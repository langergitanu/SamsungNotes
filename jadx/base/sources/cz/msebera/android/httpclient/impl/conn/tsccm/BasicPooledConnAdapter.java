package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import cz.msebera.android.httpclient.impl.conn.AbstractPooledConnAdapter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
    public BasicPooledConnAdapter(ThreadSafeClientConnManager threadSafeClientConnManager, AbstractPoolEntry abstractPoolEntry) {
        super(threadSafeClientConnManager, abstractPoolEntry);
        markReusable();
    }

    @Override // cz.msebera.android.httpclient.impl.conn.AbstractPooledConnAdapter, cz.msebera.android.httpclient.impl.conn.AbstractClientConnAdapter
    public void detach() {
        super.detach();
    }

    @Override // cz.msebera.android.httpclient.impl.conn.AbstractClientConnAdapter
    public ClientConnectionManager getManager() {
        return super.getManager();
    }

    @Override // cz.msebera.android.httpclient.impl.conn.AbstractPooledConnAdapter
    public AbstractPoolEntry getPoolEntry() {
        return super.getPoolEntry();
    }
}
