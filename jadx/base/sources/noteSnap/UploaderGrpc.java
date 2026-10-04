package noteSnap;

import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractFutureStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.GrpcGenerated;
import io.grpc.stub.annotations.RpcMethod;
import noteSnapMessage.UploadRequest;
import noteSnapMessage.UploadResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@GrpcGenerated
public final class UploaderGrpc {
    private static final int METHODID_UPLOAD_NOTE = 0;
    public static final String SERVICE_NAME = "noteSnap.Uploader";
    private static volatile MethodDescriptor<UploadRequest, UploadResponse> getUploadNoteMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final UploaderImplBase serviceImpl;

        public MethodHandlers(UploaderImplBase uploaderImplBase, int i) {
            this.serviceImpl = uploaderImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            if (this.methodId == 0) {
                return (StreamObserver<Req>) this.serviceImpl.uploadNote(streamObserver);
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UploaderBlockingStub extends AbstractBlockingStub<UploaderBlockingStub> {
        public /* synthetic */ UploaderBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        private UploaderBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public UploaderBlockingStub build(Channel channel, CallOptions callOptions) {
            return new UploaderBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UploaderFutureStub extends AbstractFutureStub<UploaderFutureStub> {
        public /* synthetic */ UploaderFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        private UploaderFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public UploaderFutureStub build(Channel channel, CallOptions callOptions) {
            return new UploaderFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class UploaderImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(UploaderGrpc.getServiceDescriptor()).addMethod(UploaderGrpc.getUploadNoteMethod(), ServerCalls.asyncClientStreamingCall(new MethodHandlers(this, 0))).build();
        }

        public StreamObserver<UploadRequest> uploadNote(StreamObserver<UploadResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(UploaderGrpc.getUploadNoteMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UploaderStub extends AbstractAsyncStub<UploaderStub> {
        public /* synthetic */ UploaderStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public StreamObserver<UploadRequest> uploadNote(StreamObserver<UploadResponse> streamObserver) {
            return ClientCalls.asyncClientStreamingCall(getChannel().newCall(UploaderGrpc.getUploadNoteMethod(), getCallOptions()), streamObserver);
        }

        private UploaderStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public UploaderStub build(Channel channel, CallOptions callOptions) {
            return new UploaderStub(channel, callOptions);
        }
    }

    private UploaderGrpc() {
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptorBuild;
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 != null) {
            return serviceDescriptor2;
        }
        synchronized (UploaderGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getUploadNoteMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    @RpcMethod(fullMethodName = "noteSnap.Uploader/UploadNote", methodType = MethodDescriptor.MethodType.CLIENT_STREAMING, requestType = UploadRequest.class, responseType = UploadResponse.class)
    public static MethodDescriptor<UploadRequest, UploadResponse> getUploadNoteMethod() {
        MethodDescriptor<UploadRequest, UploadResponse> methodDescriptorBuild;
        MethodDescriptor<UploadRequest, UploadResponse> methodDescriptor = getUploadNoteMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (UploaderGrpc.class) {
            try {
                methodDescriptorBuild = getUploadNoteMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.CLIENT_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "UploadNote")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(UploadRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(UploadResponse.getDefaultInstance())).build();
                    getUploadNoteMethod = methodDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return methodDescriptorBuild;
    }

    public static UploaderBlockingStub newBlockingStub(Channel channel) {
        return (UploaderBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<UploaderBlockingStub>() { // from class: noteSnap.UploaderGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public UploaderBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new UploaderBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static UploaderFutureStub newFutureStub(Channel channel) {
        return (UploaderFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<UploaderFutureStub>() { // from class: noteSnap.UploaderGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public UploaderFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new UploaderFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static UploaderStub newStub(Channel channel) {
        return (UploaderStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<UploaderStub>() { // from class: noteSnap.UploaderGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public UploaderStub newStub(Channel channel2, CallOptions callOptions) {
                return new UploaderStub(channel2, callOptions, 0);
            }
        }, channel);
    }
}
