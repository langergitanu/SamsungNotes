package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.InlineMe;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
public abstract class NameResolver {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static final class Args {

        @Nullable
        private final ChannelLogger channelLogger;
        private final int defaultPort;

        @Nullable
        private final Executor executor;

        @Nullable
        private final String overrideAuthority;
        private final ProxyDetector proxyDetector;

        @Nullable
        private final ScheduledExecutorService scheduledExecutorService;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder {
            private ChannelLogger channelLogger;
            private Integer defaultPort;
            private Executor executor;
            private String overrideAuthority;
            private ProxyDetector proxyDetector;
            private ScheduledExecutorService scheduledExecutorService;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            public Args build() {
                return new Args(this.defaultPort, this.proxyDetector, this.syncContext, this.serviceConfigParser, this.scheduledExecutorService, this.channelLogger, this.executor, this.overrideAuthority);
            }

            @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6438")
            public Builder setChannelLogger(ChannelLogger channelLogger) {
                this.channelLogger = (ChannelLogger) Preconditions.checkNotNull(channelLogger);
                return this;
            }

            public Builder setDefaultPort(int i) {
                this.defaultPort = Integer.valueOf(i);
                return this;
            }

            public Builder setOffloadExecutor(Executor executor) {
                this.executor = executor;
                return this;
            }

            @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9406")
            public Builder setOverrideAuthority(String str) {
                this.overrideAuthority = str;
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector) {
                this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector);
                return this;
            }

            @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6454")
            public Builder setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
                this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser serviceConfigParser) {
                this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext synchronizationContext) {
                this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext);
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6438")
        public ChannelLogger getChannelLogger() {
            ChannelLogger channelLogger = this.channelLogger;
            if (channelLogger != null) {
                return channelLogger;
            }
            throw new IllegalStateException("ChannelLogger is not set in Builder");
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        @Nullable
        public Executor getOffloadExecutor() {
            return this.executor;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9406")
        @Nullable
        public String getOverrideAuthority() {
            return this.overrideAuthority;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6454")
        public ScheduledExecutorService getScheduledExecutorService() {
            ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            builder.setScheduledExecutorService(this.scheduledExecutorService);
            builder.setChannelLogger(this.channelLogger);
            builder.setOffloadExecutor(this.executor);
            builder.setOverrideAuthority(this.overrideAuthority);
            return builder;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("defaultPort", this.defaultPort).add("proxyDetector", this.proxyDetector).add("syncContext", this.syncContext).add("serviceConfigParser", this.serviceConfigParser).add("scheduledExecutorService", this.scheduledExecutorService).add("channelLogger", this.channelLogger).add("executor", this.executor).add("overrideAuthority", this.overrideAuthority).toString();
        }

        private Args(Integer num, ProxyDetector proxyDetector, SynchronizationContext synchronizationContext, ServiceConfigParser serviceConfigParser, @Nullable ScheduledExecutorService scheduledExecutorService, @Nullable ChannelLogger channelLogger, @Nullable Executor executor, @Nullable String str) {
            this.defaultPort = ((Integer) Preconditions.checkNotNull(num, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser, "serviceConfigParser not set");
            this.scheduledExecutorService = scheduledExecutorService;
            this.channelLogger = channelLogger;
            this.executor = executor;
            this.overrideAuthority = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class Factory {
        public abstract String getDefaultScheme();

        public abstract NameResolver newNameResolver(URI uri, Args args);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    @ThreadSafe
    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class Listener2 implements Listener {
        @Override // io.grpc.NameResolver.Listener
        @InlineMe(imports = {"io.grpc.NameResolver.ResolutionResult"}, replacement = "this.onResult(ResolutionResult.newBuilder().setAddresses(servers).setAttributes(attributes).build())")
        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddresses(list).setAttributes(attributes).build());
        }

        @Override // io.grpc.NameResolver.Listener
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static final class ResolutionResult {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;

        @Nullable
        private final ConfigOrError serviceConfig;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses = Collections.EMPTY_LIST;
            private Attributes attributes = Attributes.EMPTY;

            @Nullable
            private ConfigOrError serviceConfig;

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setServiceConfig(@Nullable ConfigOrError configOrError) {
                this.serviceConfig = configOrError;
                return this;
            }
        }

        public ResolutionResult(List<EquivalentAddressGroup> list, Attributes attributes, ConfigOrError configOrError) {
            this.addresses = Collections.unmodifiableList(new ArrayList(list));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
            this.serviceConfig = configOrError;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolutionResult)) {
                return false;
            }
            ResolutionResult resolutionResult = (ResolutionResult) obj;
            return Objects.equal(this.addresses, resolutionResult.addresses) && Objects.equal(this.attributes, resolutionResult.attributes) && Objects.equal(this.serviceConfig, resolutionResult.serviceConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.serviceConfig);
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.addresses).add(NativeAuthConstants.GrantType.ATTRIBUTES, this.attributes).add("serviceConfig", this.serviceConfig).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionResultAttr {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public void refresh() {
    }

    public abstract void shutdown();

    public void start(final Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start(new Listener2() { // from class: io.grpc.NameResolver.1
                @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
                public void onError(Status status) {
                    listener.onError(status);
                }

                @Override // io.grpc.NameResolver.Listener2
                public void onResult(ResolutionResult resolutionResult) {
                    listener.onAddresses(resolutionResult.getAddresses(), resolutionResult.getAttributes());
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static final class ConfigOrError {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Object config;
        private final Status status;

        private ConfigOrError(Object obj) {
            this.config = Preconditions.checkNotNull(obj, ExternalDataConstants.EmbeddingConfig.KEY);
            this.status = null;
        }

        public static ConfigOrError fromConfig(Object obj) {
            return new ConfigOrError(obj);
        }

        public static ConfigOrError fromError(Status status) {
            return new ConfigOrError(status);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ConfigOrError.class == obj.getClass()) {
                ConfigOrError configOrError = (ConfigOrError) obj;
                if (Objects.equal(this.status, configOrError.status) && Objects.equal(this.config, configOrError.config)) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public Status getError() {
            return this.status;
        }

        public int hashCode() {
            return Objects.hashCode(this.status, this.config);
        }

        public String toString() {
            return this.config != null ? MoreObjects.toStringHelper(this).add(ExternalDataConstants.EmbeddingConfig.KEY, this.config).toString() : MoreObjects.toStringHelper(this).add("error", this.status).toString();
        }

        private ConfigOrError(Status status) {
            this.config = null;
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            Preconditions.checkArgument(!status.isOk(), "cannot use OK status: %s", status);
        }
    }

    public void start(Listener2 listener2) {
        start((Listener) listener2);
    }
}
