package cz.msebera.android.httpclient.protocol;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext httpContext) {
        super(httpContext);
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext
    public synchronized void clear() {
        super.clear();
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext, cz.msebera.android.httpclient.protocol.HttpContext
    public synchronized Object getAttribute(String str) {
        return super.getAttribute(str);
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext, cz.msebera.android.httpclient.protocol.HttpContext
    public synchronized Object removeAttribute(String str) {
        return super.removeAttribute(str);
    }

    @Override // cz.msebera.android.httpclient.protocol.BasicHttpContext, cz.msebera.android.httpclient.protocol.HttpContext
    public synchronized void setAttribute(String str, Object obj) {
        super.setAttribute(str, obj);
    }

    public SyncBasicHttpContext() {
    }
}
