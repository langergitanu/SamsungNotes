package cz.msebera.android.httpclient.impl.client.cache;

import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.util.Args;
import io.grpc.internal.GrpcUtil;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import opennlp.tools.parser.Parse;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
class CacheKeyGenerator {
    private static final URI BASE_URI = URI.create("http://example.com/");

    public static URI getRequestUri(HttpRequest httpRequest, HttpHost httpHost) {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpHost, PackageRelationship.TARGET_ATTRIBUTE_NAME);
        URIBuilder requestUriBuilder = getRequestUriBuilder(httpRequest);
        String path = requestUriBuilder.getPath();
        if (path != null) {
            requestUriBuilder.setPathSegments(URLEncodedUtils.parsePathSegments(path));
        }
        if (!requestUriBuilder.isAbsolute()) {
            requestUriBuilder.setScheme(httpHost.getSchemeName());
            requestUriBuilder.setHost(httpHost.getHostName());
            requestUriBuilder.setPort(httpHost.getPort());
        }
        return requestUriBuilder.build();
    }

    public static URIBuilder getRequestUriBuilder(HttpRequest httpRequest) {
        URI uri;
        return (!(httpRequest instanceof HttpUriRequest) || (uri = ((HttpUriRequest) httpRequest).getURI()) == null) ? new URIBuilder(httpRequest.getRequestLine().getUri()) : new URIBuilder(uri);
    }

    public static URI normalize(URI uri) {
        Args.notNull(uri, "URI");
        if (uri.isAbsolute()) {
            uri = URIUtils.resolve(BASE_URI, uri);
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (uRIBuilder.getHost() != null) {
            if (uRIBuilder.getScheme() == null) {
                uRIBuilder.setScheme("http");
            }
            if (uRIBuilder.getPort() <= -1) {
                if ("http".equalsIgnoreCase(uRIBuilder.getScheme())) {
                    uRIBuilder.setPort(80);
                } else if (AuthenticationConstants.HTTPS_PROTOCOL_STRING.equalsIgnoreCase(uRIBuilder.getScheme())) {
                    uRIBuilder.setPort(GrpcUtil.DEFAULT_PORT_SSL);
                }
            }
        }
        uRIBuilder.setFragment(null);
        return uRIBuilder.build();
    }

    public String canonicalizeUri(String str) {
        try {
            return normalize(URIUtils.resolve(BASE_URI, str)).toASCIIString();
        } catch (URISyntaxException unused) {
            return str;
        }
    }

    public String getFullHeaderValue(Header[] headerArr) {
        if (headerArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        int length = headerArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            Header header = headerArr[i];
            if (!z) {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(header.getValue().trim());
            i++;
            z = false;
        }
        return sb.toString();
    }

    public String getURI(HttpHost httpHost, HttpRequest httpRequest) {
        try {
            return normalize(getRequestUri(httpRequest, httpHost)).toASCIIString();
        } catch (URISyntaxException unused) {
            return httpRequest.getRequestLine().getUri();
        }
    }

    public String getVariantKey(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        ArrayList<String> arrayList = new ArrayList();
        for (Header header : httpCacheEntry.getHeaders("Vary")) {
            for (HeaderElement headerElement : header.getElements()) {
                arrayList.add(headerElement.getName());
            }
        }
        Collections.sort(arrayList);
        try {
            StringBuilder sb = new StringBuilder(Parse.BRACKET_LCB);
            boolean z = true;
            for (String str : arrayList) {
                if (!z) {
                    sb.append(MsalUtils.QUERY_STRING_DELIMITER);
                }
                Charset charset = Consts.UTF_8;
                sb.append(URLEncoder.encode(str, charset.name()));
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(URLEncoder.encode(getFullHeaderValue(httpRequest.getHeaders(str)), charset.name()));
                z = false;
            }
            sb.append("}");
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("couldn't encode to UTF-8", e);
        }
    }

    public String getVariantURI(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        if (!httpCacheEntry.hasVariants()) {
            return getURI(httpHost, httpRequest);
        }
        return getVariantKey(httpRequest, httpCacheEntry) + getURI(httpHost, httpRequest);
    }
}
