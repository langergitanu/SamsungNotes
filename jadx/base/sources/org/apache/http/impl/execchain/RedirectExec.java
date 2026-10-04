package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
public class RedirectExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain clientExecChain, HttpRoutePlanner httpRoutePlanner, RedirectStrategy redirectStrategy) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        Args.notNull(redirectStrategy, "HTTP redirect strategy");
        this.requestExecutor = clientExecChain;
        this.routePlanner = httpRoutePlanner;
        this.redirectStrategy = redirectStrategy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x011f, code lost:
    
        return r5;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.apache.http.HttpRequest, org.apache.http.client.methods.HttpRequestWrapper] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.apache.http.impl.execchain.ClientExecChain] */
    /* JADX WARN: Type inference failed for: r7v1, types: [org.apache.http.client.RedirectStrategy] */
    /* JADX WARN: Type inference failed for: r7v3, types: [org.apache.http.client.RedirectStrategy] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.apache.http.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        AuthScheme authScheme;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        List<URI> redirectLocations = httpClientContext.getRedirectLocations();
        if (redirectLocations != null) {
            redirectLocations.clear();
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int maxRedirects = requestConfig.getMaxRedirects() > 0 ? requestConfig.getMaxRedirects() : 50;
        int i = 0;
        ?? r4 = httpRequestWrapper;
        while (true) {
            CloseableHttpResponse closeableHttpResponseExecute = this.requestExecutor.execute(httpRoute, r4, httpClientContext, httpExecutionAware);
            try {
                if (!requestConfig.isRedirectsEnabled() || !this.redirectStrategy.isRedirected(r4, closeableHttpResponseExecute, httpClientContext)) {
                    break;
                }
                if (i >= maxRedirects) {
                    throw new RedirectException("Maximum redirects (" + maxRedirects + ") exceeded");
                }
                i++;
                HttpUriRequest redirect = this.redirectStrategy.getRedirect(r4, closeableHttpResponseExecute, httpClientContext);
                if (!redirect.headerIterator().hasNext()) {
                    redirect.setHeaders(httpRequestWrapper.getOriginal().getAllHeaders());
                }
                HttpUriRequest httpUriRequestWrap = HttpRequestWrapper.wrap(redirect);
                if (httpUriRequestWrap instanceof HttpEntityEnclosingRequest) {
                    RequestEntityProxy.enhance((HttpEntityEnclosingRequest) httpUriRequestWrap);
                }
                URI uri = httpUriRequestWrap.getURI();
                HttpHost httpHostExtractHost = URIUtilsHC4.extractHost(uri);
                if (httpHostExtractHost == null) {
                    throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
                }
                if (!httpRoute.getTargetHost().equals(httpHostExtractHost)) {
                    AuthStateHC4 targetAuthState = httpClientContext.getTargetAuthState();
                    if (targetAuthState != null) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Resetting target auth state");
                        }
                        targetAuthState.reset();
                    }
                    AuthStateHC4 proxyAuthState = httpClientContext.getProxyAuthState();
                    if (proxyAuthState != null && (authScheme = proxyAuthState.getAuthScheme()) != null && authScheme.isConnectionBased()) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Resetting proxy auth state");
                        }
                        proxyAuthState.reset();
                    }
                }
                httpRoute = this.routePlanner.determineRoute(httpHostExtractHost, httpUriRequestWrap, httpClientContext);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Redirecting to '" + uri + "' via " + httpRoute);
                }
                EntityUtilsHC4.consume(closeableHttpResponseExecute.getEntity());
                closeableHttpResponseExecute.close();
                r4 = httpUriRequestWrap;
            } catch (IOException e) {
                closeableHttpResponseExecute.close();
                throw e;
            } catch (RuntimeException e2) {
                closeableHttpResponseExecute.close();
                throw e2;
            } catch (HttpException e3) {
                try {
                    try {
                        EntityUtilsHC4.consume(closeableHttpResponseExecute.getEntity());
                    } catch (IOException e5) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "I/O error while releasing connection", e5);
                        }
                    }
                    closeableHttpResponseExecute.close();
                    throw e3;
                } catch (Throwable th) {
                    closeableHttpResponseExecute.close();
                    throw th;
                }
            }
        }
    }
}
