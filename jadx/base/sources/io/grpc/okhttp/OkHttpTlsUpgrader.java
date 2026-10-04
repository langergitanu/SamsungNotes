package io.grpc.okhttp;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.OkHostnameVerifier;
import io.grpc.okhttp.internal.Protocol;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class OkHttpTlsUpgrader {

    @VisibleForTesting
    static final List<Protocol> TLS_PROTOCOLS = Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_2));

    @VisibleForTesting
    public static String canonicalizeHost(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? AbstractC2322a.m1614d(1, 1, str) : str;
    }

    public static SSLSocket upgrade(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i, ConnectionSpec connectionSpec) throws SSLPeerUnverifiedException {
        Preconditions.checkNotNull(sSLSocketFactory, "sslSocketFactory");
        Preconditions.checkNotNull(socket, "socket");
        Preconditions.checkNotNull(connectionSpec, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i, true);
        connectionSpec.apply(sSLSocket, false);
        String strNegotiate = OkHttpProtocolNegotiator.get().negotiate(sSLSocket, str, connectionSpec.supportsTlsExtensions() ? TLS_PROTOCOLS : null);
        List<Protocol> list = TLS_PROTOCOLS;
        Preconditions.checkState(list.contains(Protocol.get(strNegotiate)), "Only " + list + " are supported, but negotiated protocol is %s", strNegotiate);
        if (hostnameVerifier == null) {
            hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        if (hostnameVerifier.verify(canonicalizeHost(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException(AbstractC0541b.m772n("Cannot verify hostname: ", str));
    }
}
