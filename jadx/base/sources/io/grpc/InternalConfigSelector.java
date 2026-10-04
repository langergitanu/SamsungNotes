package io.grpc;

import com.google.common.base.Preconditions;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import io.grpc.Attributes;
import io.grpc.LoadBalancer;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public abstract class InternalConfigSelector {
    public static final Attributes.Key<InternalConfigSelector> KEY = Attributes.Key.create("internal:io.grpc.config-selector");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Result {
        private final Object config;

        @Nullable
        public ClientInterceptor interceptor;
        private final Status status;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder {
            private Object config;
            private ClientInterceptor interceptor;

            public Result build() {
                Preconditions.checkState(this.config != null, "config is not set");
                return new Result(Status.f8817OK, this.config, this.interceptor);
            }

            public Builder setConfig(Object obj) {
                this.config = Preconditions.checkNotNull(obj, ExternalDataConstants.EmbeddingConfig.KEY);
                return this;
            }

            public Builder setInterceptor(ClientInterceptor clientInterceptor) {
                this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(clientInterceptor, "interceptor");
                return this;
            }

            private Builder() {
            }
        }

        public static Result forError(Status status) {
            Preconditions.checkArgument(!status.isOk(), "status is OK");
            return new Result(status, null, null);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public ClientInterceptor getInterceptor() {
            return this.interceptor;
        }

        public Status getStatus() {
            return this.status;
        }

        private Result(Status status, Object obj, ClientInterceptor clientInterceptor) {
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            this.config = obj;
            this.interceptor = clientInterceptor;
        }
    }

    public abstract Result selectConfig(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);
}
