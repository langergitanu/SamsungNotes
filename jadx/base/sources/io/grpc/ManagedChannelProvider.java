package io.grpc;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public abstract class ManagedChannelProvider {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NewChannelBuilderResult {
        private final ManagedChannelBuilder<?> channelBuilder;
        private final String error;

        private NewChannelBuilderResult(ManagedChannelBuilder<?> managedChannelBuilder, String str) {
            this.channelBuilder = managedChannelBuilder;
            this.error = str;
        }

        public static NewChannelBuilderResult channelBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
            return new NewChannelBuilderResult((ManagedChannelBuilder) Preconditions.checkNotNull(managedChannelBuilder), null);
        }

        public static NewChannelBuilderResult error(String str) {
            return new NewChannelBuilderResult(null, (String) Preconditions.checkNotNull(str));
        }

        public ManagedChannelBuilder<?> getChannelBuilder() {
            return this.channelBuilder;
        }

        public String getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    public static ManagedChannelProvider provider() {
        ManagedChannelProvider managedChannelProviderProvider = ManagedChannelRegistry.getDefaultRegistry().provider();
        if (managedChannelProviderProvider != null) {
            return managedChannelProviderProvider;
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract ManagedChannelBuilder<?> builderForAddress(String str, int i);

    public abstract ManagedChannelBuilder<?> builderForTarget(String str);

    public abstract Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes();

    public abstract boolean isAvailable();

    public NewChannelBuilderResult newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        return NewChannelBuilderResult.error("ChannelCredentials are unsupported");
    }

    public abstract int priority();
}
