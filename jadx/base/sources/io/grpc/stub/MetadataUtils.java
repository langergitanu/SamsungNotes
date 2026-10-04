package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.InlineMe;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class MetadataUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HeaderAttachingClientInterceptor implements ClientInterceptor {
        private final Metadata extraHeaders;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class HeaderAttachingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
            public HeaderAttachingClientCall(ClientCall<ReqT, RespT> clientCall) {
                super(clientCall);
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                metadata.merge(HeaderAttachingClientInterceptor.this.extraHeaders);
                super.start(listener, metadata);
            }
        }

        public HeaderAttachingClientInterceptor(Metadata metadata) {
            this.extraHeaders = (Metadata) Preconditions.checkNotNull(metadata, "extraHeaders");
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new HeaderAttachingClientCall(channel.newCall(methodDescriptor, callOptions));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MetadataCapturingClientInterceptor implements ClientInterceptor {
        final AtomicReference<Metadata> headersCapture;
        final AtomicReference<Metadata> trailersCapture;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class MetadataCapturingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public final class MetadataCapturingClientCallListener extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
                public MetadataCapturingClientCallListener(ClientCall.Listener<RespT> listener) {
                    super(listener);
                }

                @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                public void onClose(Status status, Metadata metadata) {
                    MetadataCapturingClientInterceptor.this.trailersCapture.set(metadata);
                    super.onClose(status, metadata);
                }

                @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                public void onHeaders(Metadata metadata) {
                    MetadataCapturingClientInterceptor.this.headersCapture.set(metadata);
                    super.onHeaders(metadata);
                }
            }

            public MetadataCapturingClientCall(ClientCall<ReqT, RespT> clientCall) {
                super(clientCall);
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                MetadataCapturingClientInterceptor.this.headersCapture.set(null);
                MetadataCapturingClientInterceptor.this.trailersCapture.set(null);
                super.start(new MetadataCapturingClientCallListener(listener), metadata);
            }
        }

        public MetadataCapturingClientInterceptor(AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
            this.headersCapture = (AtomicReference) Preconditions.checkNotNull(atomicReference, "headersCapture");
            this.trailersCapture = (AtomicReference) Preconditions.checkNotNull(atomicReference2, "trailersCapture");
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new MetadataCapturingClientCall(channel.newCall(methodDescriptor, callOptions));
        }
    }

    private MetadataUtils() {
    }

    @InlineMe(imports = {"io.grpc.stub.MetadataUtils"}, replacement = "stub.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(extraHeaders))")
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
    @Deprecated
    public static <T extends AbstractStub<T>> T attachHeaders(T t, Metadata metadata) {
        return (T) t.withInterceptors(newAttachHeadersInterceptor(metadata));
    }

    @InlineMe(imports = {"io.grpc.stub.MetadataUtils"}, replacement = "stub.withInterceptors(MetadataUtils.newCaptureMetadataInterceptor(headersCapture, trailersCapture))")
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
    @Deprecated
    public static <T extends AbstractStub<T>> T captureMetadata(T t, AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return (T) t.withInterceptors(newCaptureMetadataInterceptor(atomicReference, atomicReference2));
    }

    public static ClientInterceptor newAttachHeadersInterceptor(Metadata metadata) {
        return new HeaderAttachingClientInterceptor(metadata);
    }

    public static ClientInterceptor newCaptureMetadataInterceptor(AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return new MetadataCapturingClientInterceptor(atomicReference, atomicReference2);
    }
}
