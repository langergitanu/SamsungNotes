package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class NoopUserTokenHandler implements UserTokenHandler {
    public static final NoopUserTokenHandler INSTANCE = new NoopUserTokenHandler();

    @Override // cz.msebera.android.httpclient.client.UserTokenHandler
    public Object getUserToken(HttpContext httpContext) {
        return null;
    }
}
