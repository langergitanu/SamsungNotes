package org.apache.http.protocol;

import com.google.api.client.http.HttpMethods;
import java.net.InetAddress;
import org.apache.http.HttpConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class RequestTargetHostHC4 implements HttpRequestInterceptor {
    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        HttpCoreContext httpCoreContextAdapt = HttpCoreContext.adapt(httpContext);
        ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
        if ((httpRequest.getRequestLine().getMethod().equalsIgnoreCase(HttpMethods.CONNECT) && protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) || httpRequest.containsHeader("Host")) {
            return;
        }
        HttpHost targetHost = httpCoreContextAdapt.getTargetHost();
        if (targetHost == null) {
            HttpConnection connection = httpCoreContextAdapt.getConnection();
            if (connection instanceof HttpInetConnection) {
                HttpInetConnection httpInetConnection = (HttpInetConnection) connection;
                InetAddress remoteAddress = httpInetConnection.getRemoteAddress();
                int remotePort = httpInetConnection.getRemotePort();
                if (remoteAddress != null) {
                    targetHost = new HttpHost(remoteAddress.getHostName(), remotePort);
                }
            }
            if (targetHost == null) {
                if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                    throw new ProtocolException("Target host missing");
                }
                return;
            }
        }
        httpRequest.addHeader("Host", targetHost.toHostString());
    }
}
