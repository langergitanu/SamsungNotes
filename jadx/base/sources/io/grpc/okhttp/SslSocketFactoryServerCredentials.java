package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import io.grpc.okhttp.internal.ConnectionSpec;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1785")
public final class SslSocketFactoryServerCredentials {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ServerCredentials extends io.grpc.ServerCredentials {
        private final ConnectionSpec connectionSpec;
        private final SSLSocketFactory factory;

        public ServerCredentials(SSLSocketFactory sSLSocketFactory) {
            this(sSLSocketFactory, OkHttpChannelBuilder.INTERNAL_DEFAULT_CONNECTION_SPEC);
        }

        public ConnectionSpec getConnectionSpec() {
            return this.connectionSpec;
        }

        public SSLSocketFactory getFactory() {
            return this.factory;
        }

        public ServerCredentials(SSLSocketFactory sSLSocketFactory, ConnectionSpec connectionSpec) {
            this.factory = (SSLSocketFactory) Preconditions.checkNotNull(sSLSocketFactory, "factory");
            this.connectionSpec = (ConnectionSpec) Preconditions.checkNotNull(connectionSpec, "connectionSpec");
        }
    }

    private SslSocketFactoryServerCredentials() {
    }

    public static io.grpc.ServerCredentials create(SSLSocketFactory sSLSocketFactory) {
        return new ServerCredentials(sSLSocketFactory);
    }

    public static io.grpc.ServerCredentials create(SSLSocketFactory sSLSocketFactory, com.squareup.okhttp.ConnectionSpec connectionSpec) {
        return new ServerCredentials(sSLSocketFactory, Utils.convertSpec(connectionSpec));
    }
}
