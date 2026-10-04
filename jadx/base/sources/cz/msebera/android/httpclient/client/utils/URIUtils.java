package cz.msebera.android.httpclient.client.utils;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class URIUtils {
    public static final EnumSet<UriFlag> DROP_FRAGMENT;
    public static final EnumSet<UriFlag> DROP_FRAGMENT_AND_NORMALIZE;
    public static final EnumSet<UriFlag> NORMALIZE;
    public static final EnumSet<UriFlag> NO_FLAGS = EnumSet.noneOf(UriFlag.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum UriFlag {
        DROP_FRAGMENT,
        NORMALIZE
    }

    static {
        UriFlag uriFlag = UriFlag.DROP_FRAGMENT;
        DROP_FRAGMENT = EnumSet.of(uriFlag);
        UriFlag uriFlag2 = UriFlag.NORMALIZE;
        NORMALIZE = EnumSet.of(uriFlag2);
        DROP_FRAGMENT_AND_NORMALIZE = EnumSet.of(uriFlag, uriFlag2);
    }

    private URIUtils() {
    }

    @Deprecated
    public static URI createURI(String str, String str2, int i, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(':');
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return new URI(sb.toString());
    }

    public static HttpHost extractHost(URI uri) {
        int iIndexOf;
        if (uri == null || !uri.isAbsolute()) {
            return null;
        }
        int port = uri.getPort();
        String host = uri.getHost();
        if (host == null && (host = uri.getAuthority()) != null) {
            int iIndexOf2 = host.indexOf(64);
            if (iIndexOf2 >= 0) {
                int i = iIndexOf2 + 1;
                host = host.length() > i ? host.substring(i) : null;
            }
            if (host != null && (iIndexOf = host.indexOf(58)) >= 0) {
                int i2 = iIndexOf + 1;
                int i4 = 0;
                for (int i5 = i2; i5 < host.length() && Character.isDigit(host.charAt(i5)); i5++) {
                    i4++;
                }
                if (i4 > 0) {
                    try {
                        port = Integer.parseInt(host.substring(i2, i4 + i2));
                    } catch (NumberFormatException unused) {
                    }
                }
                host = host.substring(0, iIndexOf);
            }
        }
        String scheme = uri.getScheme();
        if (TextUtils.isBlank(host)) {
            return null;
        }
        try {
            return new HttpHost(host, port, scheme);
        } catch (IllegalArgumentException unused2) {
            return null;
        }
    }

    public static URI normalizeSyntax(URI uri) {
        if (uri.isOpaque() || uri.getAuthority() == null) {
            return uri;
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        List<String> pathSegments = uRIBuilder.getPathSegments();
        Stack stack = new Stack();
        for (String str : pathSegments) {
            if (!Extension.DOT.equals(str)) {
                if (!"..".equals(str)) {
                    stack.push(str);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        if (stack.size() == 0) {
            stack.add("");
        }
        uRIBuilder.setPathSegments(stack);
        if (uRIBuilder.getScheme() != null) {
            uRIBuilder.setScheme(uRIBuilder.getScheme().toLowerCase(Locale.ROOT));
        }
        if (uRIBuilder.getHost() != null) {
            uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ROOT));
        }
        return uRIBuilder.build();
    }

    public static URI resolve(URI uri, String str) {
        return resolve(uri, URI.create(str));
    }

    @Deprecated
    public static URI rewriteURI(URI uri, HttpHost httpHost, boolean z) {
        return rewriteURI(uri, httpHost, z ? DROP_FRAGMENT : NO_FLAGS);
    }

    public static URI rewriteURIForRoute(URI uri, RouteInfo routeInfo) {
        return rewriteURIForRoute(uri, routeInfo, true);
    }

    public static URI resolve(URI uri, URI uri2) {
        URI uriResolve;
        Args.notNull(uri, "Base URI");
        Args.notNull(uri2, "Reference URI");
        String aSCIIString = uri2.toASCIIString();
        if (!aSCIIString.startsWith(MsalUtils.QUERY_STRING_SYMBOL)) {
            if (aSCIIString.isEmpty()) {
                String aSCIIString2 = uri.resolve(URI.create(ContentUtils.HASH_SYMBOL)).toASCIIString();
                uriResolve = URI.create(aSCIIString2.substring(0, aSCIIString2.indexOf(35)));
            } else {
                uriResolve = uri.resolve(uri2);
            }
            try {
                return normalizeSyntax(uriResolve);
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException(e);
            }
        }
        String aSCIIString3 = uri.toASCIIString();
        int iIndexOf = aSCIIString3.indexOf(63);
        if (iIndexOf > -1) {
            aSCIIString3 = aSCIIString3.substring(0, iIndexOf);
        }
        return URI.create(aSCIIString3 + aSCIIString);
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost, EnumSet<UriFlag> enumSet) {
        Args.notNull(uri, "URI");
        Args.notNull(enumSet, "URI flags");
        if (uri.isOpaque()) {
            return uri;
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (httpHost != null) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        } else {
            uRIBuilder.setScheme(null);
            uRIBuilder.setHost(null);
            uRIBuilder.setPort(-1);
        }
        if (enumSet.contains(UriFlag.DROP_FRAGMENT)) {
            uRIBuilder.setFragment(null);
        }
        if (enumSet.contains(UriFlag.NORMALIZE)) {
            ArrayList arrayList = new ArrayList(uRIBuilder.getPathSegments());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).isEmpty() && it.hasNext()) {
                    it.remove();
                }
            }
            uRIBuilder.setPathSegments(arrayList);
        }
        if (uRIBuilder.isPathEmpty()) {
            uRIBuilder.setPathSegments("");
        }
        return uRIBuilder.build();
    }

    public static URI rewriteURIForRoute(URI uri, RouteInfo routeInfo, boolean z) {
        if (uri == null) {
            return null;
        }
        if (routeInfo.getProxyHost() == null || routeInfo.isTunnelled()) {
            if (uri.isAbsolute()) {
                return rewriteURI(uri, (HttpHost) null, z ? DROP_FRAGMENT_AND_NORMALIZE : DROP_FRAGMENT);
            }
            return rewriteURI(uri);
        }
        if (uri.isAbsolute()) {
            return rewriteURI(uri);
        }
        return rewriteURI(uri, routeInfo.getTargetHost(), z ? DROP_FRAGMENT_AND_NORMALIZE : DROP_FRAGMENT);
    }

    public static URI resolve(URI uri, HttpHost httpHost, List<URI> list) {
        URIBuilder uRIBuilder;
        Args.notNull(uri, "Request URI");
        if (list != null && !list.isEmpty()) {
            uRIBuilder = new URIBuilder((URI) AbstractC0000a.m10g(list, 1));
            String fragment = uRIBuilder.getFragment();
            for (int size = list.size() - 1; fragment == null && size >= 0; size--) {
                fragment = list.get(size).getFragment();
            }
            uRIBuilder.setFragment(fragment);
        } else {
            uRIBuilder = new URIBuilder(uri);
        }
        if (uRIBuilder.getFragment() == null) {
            uRIBuilder.setFragment(uri.getFragment());
        }
        if (httpHost != null && !uRIBuilder.isAbsolute()) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        }
        return uRIBuilder.build();
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost) {
        return rewriteURI(uri, httpHost, NORMALIZE);
    }

    public static URI rewriteURI(URI uri) {
        Args.notNull(uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (uRIBuilder.getUserInfo() != null) {
            uRIBuilder.setUserInfo(null);
        }
        if (uRIBuilder.getPathSegments().isEmpty()) {
            uRIBuilder.setPathSegments("");
        }
        if (TextUtils.isEmpty(uRIBuilder.getPath())) {
            uRIBuilder.setPath("/");
        }
        if (uRIBuilder.getHost() != null) {
            uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ROOT));
        }
        uRIBuilder.setFragment(null);
        return uRIBuilder.build();
    }
}
