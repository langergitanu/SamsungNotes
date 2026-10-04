package org.apache.http.impl.client;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.client.methods.HttpHeadHC4;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class DefaultRedirectStrategy implements RedirectStrategy {

    @Deprecated
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private static final String TAG = "HttpClient";
    public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
    private static final String[] REDIRECT_METHODS = {"GET", "HEAD"};

    public URI createLocationURI(String str) throws ProtocolException {
        try {
            URIBuilder uRIBuilder = new URIBuilder(new URI(str).normalize());
            String host = uRIBuilder.getHost();
            if (host != null) {
                uRIBuilder.setHost(host.toLowerCase(Locale.ENGLISH));
            }
            if (TextUtils.isEmpty(uRIBuilder.getPath())) {
                uRIBuilder.setPath("/");
            }
            return uRIBuilder.build();
        } catch (URISyntaxException e) {
            throw new ProtocolException(AbstractC0541b.m772n("Invalid redirect URI: ", str), e);
        }
    }

    public URI getLocationURI(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext httpClientContextAdapt = HttpClientContext.adapt(httpContext);
        Header firstHeader = httpResponse.getFirstHeader(com.samsung.scsp.common.Header.LOCATION);
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
        String value = firstHeader.getValue();
        if (Log.isLoggable(TAG, 3)) {
            AbstractC6670b.m4757r("Redirect requested to location '", value, "'", TAG);
        }
        RequestConfig requestConfig = httpClientContextAdapt.getRequestConfig();
        URI uriCreateLocationURI = createLocationURI(value);
        try {
            if (!uriCreateLocationURI.isAbsolute()) {
                if (!requestConfig.isRelativeRedirectsAllowed()) {
                    throw new ProtocolException("Relative redirect location '" + uriCreateLocationURI + "' not allowed");
                }
                HttpHost targetHost = httpClientContextAdapt.getTargetHost();
                Asserts.notNull(targetHost, "Target host");
                uriCreateLocationURI = URIUtilsHC4.resolve(URIUtilsHC4.rewriteURI(new URI(httpRequest.getRequestLine().getUri()), targetHost, false), uriCreateLocationURI);
            }
            RedirectLocationsHC4 redirectLocationsHC4 = (RedirectLocationsHC4) httpClientContextAdapt.getAttribute("http.protocol.redirect-locations");
            if (redirectLocationsHC4 == null) {
                redirectLocationsHC4 = new RedirectLocationsHC4();
                httpContext.setAttribute("http.protocol.redirect-locations", redirectLocationsHC4);
            }
            if (requestConfig.isCircularRedirectsAllowed() || !redirectLocationsHC4.contains(uriCreateLocationURI)) {
                redirectLocationsHC4.add(uriCreateLocationURI);
                return uriCreateLocationURI;
            }
            throw new CircularRedirectException("Circular redirect to '" + uriCreateLocationURI + "'");
        } catch (URISyntaxException e) {
            throw new ProtocolException(e.getMessage(), e);
        }
    }

    @Override // org.apache.http.client.RedirectStrategy
    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI locationURI = getLocationURI(httpRequest, httpResponse, httpContext);
        String method = httpRequest.getRequestLine().getMethod();
        return method.equalsIgnoreCase("HEAD") ? new HttpHeadHC4(locationURI) : method.equalsIgnoreCase("GET") ? new HttpGetHC4(locationURI) : httpResponse.getStatusLine().getStatusCode() == 307 ? RequestBuilder.copy(httpRequest).setUri(locationURI).build() : new HttpGetHC4(locationURI);
    }

    public boolean isRedirectable(String str) {
        for (String str2 : REDIRECT_METHODS) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.http.client.RedirectStrategy
    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String method = httpRequest.getRequestLine().getMethod();
        Header firstHeader = httpResponse.getFirstHeader(com.samsung.scsp.common.Header.LOCATION);
        if (statusCode != 307) {
            switch (statusCode) {
                case 301:
                    break;
                case 302:
                    return isRedirectable(method) && firstHeader != null;
                case 303:
                    return true;
                default:
                    return false;
            }
        }
        return isRedirectable(method);
    }
}
