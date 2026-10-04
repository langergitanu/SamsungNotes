package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ManagedChannelProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public abstract class ServerProvider {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NewServerBuilderResult {
        private final String error;
        private final ServerBuilder<?> serverBuilder;

        private NewServerBuilderResult(ServerBuilder<?> serverBuilder, String str) {
            this.serverBuilder = serverBuilder;
            this.error = str;
        }

        public static NewServerBuilderResult error(String str) {
            return new NewServerBuilderResult(null, (String) Preconditions.checkNotNull(str));
        }

        public static NewServerBuilderResult serverBuilder(ServerBuilder<?> serverBuilder) {
            return new NewServerBuilderResult((ServerBuilder) Preconditions.checkNotNull(serverBuilder), null);
        }

        public String getError() {
            return this.error;
        }

        public ServerBuilder<?> getServerBuilder() {
            return this.serverBuilder;
        }
    }

    public static ServerProvider provider() {
        ServerProvider serverProviderProvider = ServerRegistry.getDefaultRegistry().provider();
        if (serverProviderProvider != null) {
            return serverProviderProvider;
        }
        throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
    }

    public abstract ServerBuilder<?> builderForPort(int i);

    public abstract boolean isAvailable();

    public NewServerBuilderResult newServerBuilderForPort(int i, ServerCredentials serverCredentials) {
        return NewServerBuilderResult.error("ServerCredentials are unsupported");
    }

    public abstract int priority();
}
