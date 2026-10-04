package cz.msebera.android.httpclient.impl.conn;

import com.microsoft.identity.common.java.AuthenticationConstants;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.util.Args;
import io.grpc.internal.GrpcUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class DefaultSchemePortResolver implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

    @Override // cz.msebera.android.httpclient.conn.SchemePortResolver
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
