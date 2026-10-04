package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
@ThreadSafe
public abstract class ClientStreamTracer extends StreamTracer {
    public static final CallOptions.Key<Boolean> NAME_RESOLUTION_DELAYED = CallOptions.Key.createWithDefault("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED", Boolean.FALSE);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Factory {
        public ClientStreamTracer newClientStreamTracer(StreamInfo streamInfo, Metadata metadata) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
    public static final class StreamInfo {
        private final CallOptions callOptions;
        private final boolean isTransparentRetry;
        private final int previousAttempts;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder {
            private CallOptions callOptions = CallOptions.DEFAULT;
            private boolean isTransparentRetry;
            private int previousAttempts;

            public StreamInfo build() {
                return new StreamInfo(this.callOptions, this.previousAttempts, this.isTransparentRetry);
            }

            public Builder setCallOptions(CallOptions callOptions) {
                this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions cannot be null");
                return this;
            }

            public Builder setIsTransparentRetry(boolean z) {
                this.isTransparentRetry = z;
                return this;
            }

            public Builder setPreviousAttempts(int i) {
                this.previousAttempts = i;
                return this;
            }
        }

        public StreamInfo(CallOptions callOptions, int i, boolean z) {
            this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
            this.previousAttempts = i;
            this.isTransparentRetry = z;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public CallOptions getCallOptions() {
            return this.callOptions;
        }

        public int getPreviousAttempts() {
            return this.previousAttempts;
        }

        public boolean isTransparentRetry() {
            return this.isTransparentRetry;
        }

        public Builder toBuilder() {
            return new Builder().setCallOptions(this.callOptions).setPreviousAttempts(this.previousAttempts).setIsTransparentRetry(this.isTransparentRetry);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("callOptions", this.callOptions).add("previousAttempts", this.previousAttempts).add("isTransparentRetry", this.isTransparentRetry).toString();
        }
    }

    public void createPendingStream() {
    }

    public void inboundHeaders() {
    }

    public void inboundTrailers(Metadata metadata) {
    }

    public void outboundHeaders() {
    }

    public void streamCreated(Attributes attributes, Metadata metadata) {
    }
}
