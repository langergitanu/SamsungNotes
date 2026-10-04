package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class NTLMSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
    @Override // cz.msebera.android.httpclient.auth.AuthSchemeProvider
    public AuthScheme create(HttpContext httpContext) {
        return new NTLMScheme();
    }

    @Override // cz.msebera.android.httpclient.auth.AuthSchemeFactory
    public AuthScheme newInstance(HttpParams httpParams) {
        return new NTLMScheme();
    }
}
