package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ExperimentalApi("There is no plan to make this API stable, given transport API instability")
public final class SslSocketFactoryChannelCredentials {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ChannelCredentials extends io.grpc.ChannelCredentials {
        private final SSLSocketFactory factory;

        public SSLSocketFactory getFactory() {
            return this.factory;
        }

        private ChannelCredentials(SSLSocketFactory sSLSocketFactory) {
            this.factory = (SSLSocketFactory) Preconditions.checkNotNull(sSLSocketFactory, "factory");
        }

        @Override // io.grpc.ChannelCredentials
        public io.grpc.ChannelCredentials withoutBearerTokens() {
            return this;
        }
    }

    private SslSocketFactoryChannelCredentials() {
    }

    public static io.grpc.ChannelCredentials create(SSLSocketFactory sSLSocketFactory) {
        return new ChannelCredentials(sSLSocketFactory);
    }
}
