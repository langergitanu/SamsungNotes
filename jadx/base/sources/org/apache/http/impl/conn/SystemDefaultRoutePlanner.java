package org.apache.http.impl.conn;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class SystemDefaultRoutePlanner extends DefaultRoutePlanner {
    private static /* synthetic */ int[] $SWITCH_TABLE$java$net$Proxy$Type;
    private final ProxySelector proxySelector;

    public static /* synthetic */ int[] $SWITCH_TABLE$java$net$Proxy$Type() {
        int[] iArr = $SWITCH_TABLE$java$net$Proxy$Type;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Proxy.Type.values().length];
        try {
            iArr2[Proxy.Type.DIRECT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Proxy.Type.HTTP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Proxy.Type.SOCKS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$java$net$Proxy$Type = iArr2;
        return iArr2;
    }

    public SystemDefaultRoutePlanner(SchemePortResolver schemePortResolver, ProxySelector proxySelector) {
        super(schemePortResolver);
        this.proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
    }

    private Proxy chooseProxy(List<Proxy> list) {
        Proxy proxy = null;
        for (int i = 0; proxy == null && i < list.size(); i++) {
            Proxy proxy2 = list.get(i);
            int i2 = $SWITCH_TABLE$java$net$Proxy$Type()[proxy2.type().ordinal()];
            if (i2 == 1 || i2 == 2) {
                proxy = proxy2;
            }
        }
        return proxy == null ? Proxy.NO_PROXY : proxy;
    }

    private String getHost(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.isUnresolved() ? inetSocketAddress.getHostName() : inetSocketAddress.getAddress().getHostAddress();
    }

    @Override // org.apache.http.impl.conn.DefaultRoutePlanner
    public HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        try {
            Proxy proxyChooseProxy = chooseProxy(this.proxySelector.select(new URI(httpHost.toURI())));
            if (proxyChooseProxy.type() != Proxy.Type.HTTP) {
                return null;
            }
            if (proxyChooseProxy.address() instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyChooseProxy.address();
                return new HttpHost(getHost(inetSocketAddress), inetSocketAddress.getPort());
            }
            throw new HttpException("Unable to handle non-Inet proxy address: " + proxyChooseProxy.address());
        } catch (URISyntaxException e) {
            throw new HttpException("Cannot convert host to URI: " + httpHost, e);
        }
    }

    public SystemDefaultRoutePlanner(ProxySelector proxySelector) {
        this(null, proxySelector);
    }
}
