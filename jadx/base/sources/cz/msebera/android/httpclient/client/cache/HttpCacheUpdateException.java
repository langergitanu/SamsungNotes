package cz.msebera.android.httpclient.client.cache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HttpCacheUpdateException extends Exception {
    private static final long serialVersionUID = 823573584868632876L;

    public HttpCacheUpdateException(String str) {
        super(str);
    }

    public HttpCacheUpdateException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
