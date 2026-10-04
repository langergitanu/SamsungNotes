package io.grpc;

import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class Grpc {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR");

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_LOCAL_ADDR = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_LOCAL_ADDR");

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
    public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_SSL_SESSION");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransportAttr {
    }

    private Grpc() {
    }

    private static String authorityFromHostAndPort(String str, int i) {
        String str2;
        int i2;
        try {
            str2 = str;
            i2 = i;
            try {
                return new URI(null, null, str2, i2, null, null, null).getAuthority();
            } catch (URISyntaxException e) {
                e = e;
                throw new IllegalArgumentException("Invalid host or port: " + str2 + " " + i2, e);
            }
        } catch (URISyntaxException e2) {
            e = e2;
            str2 = str;
            i2 = i;
        }
    }

    public static ManagedChannelBuilder<?> newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        return ManagedChannelRegistry.getDefaultRegistry().newChannelBuilder(str, channelCredentials);
    }

    public static ManagedChannelBuilder<?> newChannelBuilderForAddress(String str, int i, ChannelCredentials channelCredentials) {
        return newChannelBuilder(authorityFromHostAndPort(str, i), channelCredentials);
    }

    public static ServerBuilder<?> newServerBuilderForPort(int i, ServerCredentials serverCredentials) {
        return ServerRegistry.getDefaultRegistry().newServerBuilderForPort(i, serverCredentials);
    }
}
