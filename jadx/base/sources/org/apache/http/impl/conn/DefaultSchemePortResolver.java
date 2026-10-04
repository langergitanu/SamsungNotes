package org.apache.http.impl.conn;

import com.microsoft.identity.common.java.AuthenticationConstants;
import io.grpc.internal.GrpcUtil;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class DefaultSchemePortResolver implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

    @Override // org.apache.http.conn.SchemePortResolver
    public int resolve(HttpHost httpHost) throws UnsupportedSchemeException {
        Args.notNull(httpHost, "HTTP host");
        int port = httpHost.getPort();
        if (port > 0) {
            return port;
        }
        String schemeName = httpHost.getSchemeName();
        if (schemeName.equalsIgnoreCase("http")) {
            return 80;
        }
        if (schemeName.equalsIgnoreCase(AuthenticationConstants.HTTPS_PROTOCOL_STRING)) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        throw new UnsupportedSchemeException(schemeName.concat(" protocol is not supported"));
    }
}
