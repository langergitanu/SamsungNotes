package org.apache.http.params;

import java.nio.charset.Charset;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.SocketConfig;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public final class HttpParamConfig {
    private HttpParamConfig() {
    }

    public static ConnectionConfig getConnectionConfig(HttpParams httpParams) {
        MessageConstraints messageConstraints = getMessageConstraints(httpParams);
        String str = (String) httpParams.getParameter(cz.msebera.android.httpclient.params.CoreProtocolPNames.HTTP_ELEMENT_CHARSET);
        return ConnectionConfig.custom().setCharset(str != null ? Charset.forName(str) : null).setMessageConstraints(messageConstraints).build();
    }

    public static MessageConstraints getMessageConstraints(HttpParams httpParams) {
        return MessageConstraints.custom().setMaxHeaderCount(httpParams.getIntParameter(cz.msebera.android.httpclient.params.CoreConnectionPNames.MAX_HEADER_COUNT, -1)).setMaxLineLength(httpParams.getIntParameter(cz.msebera.android.httpclient.params.CoreConnectionPNames.MAX_LINE_LENGTH, -1)).build();
    }

    public static SocketConfig getSocketConfig(HttpParams httpParams) {
        return SocketConfig.custom().setSoTimeout(httpParams.getIntParameter(cz.msebera.android.httpclient.params.CoreConnectionPNames.SO_TIMEOUT, 0)).setSoLinger(httpParams.getIntParameter(cz.msebera.android.httpclient.params.CoreConnectionPNames.SO_LINGER, -1)).setTcpNoDelay(httpParams.getBooleanParameter(cz.msebera.android.httpclient.params.CoreConnectionPNames.TCP_NODELAY, true)).build();
    }
}
