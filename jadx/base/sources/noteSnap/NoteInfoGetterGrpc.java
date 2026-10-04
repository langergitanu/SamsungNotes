package noteSnap;

import com.google.common.util.concurrent.ListenableFuture;
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
import noteSnapMessage.NoteInfoRequest;
import noteSnapMessage.NoteInfoResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@GrpcGenerated
public final class NoteInfoGetterGrpc {
    private static final int METHODID_GET_LATEST_NOTE_INFO = 0;
    public static final String SERVICE_NAME = "noteSnap.NoteInfoGetter";
    private static volatile MethodDescriptor<NoteInfoRequest, NoteInfoResponse> getGetLatestNoteInfoMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NoteInfoGetterBlockingStub extends AbstractBlockingStub<NoteInfoGetterBlockingStub> {
        public /* synthetic */ NoteInfoGetterBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public NoteInfoResponse getLatestNoteInfo(NoteInfoRequest noteInfoRequest) {
            return (NoteInfoResponse) ClientCalls.blockingUnaryCall(getChannel(), NoteInfoGetterGrpc.getGetLatestNoteInfoMethod(), getCallOptions(), noteInfoRequest);
        }

        private NoteInfoGetterBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public NoteInfoGetterBlockingStub build(Channel channel, CallOptions callOptions) {
            return new NoteInfoGetterBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NoteInfoGetterFutureStub extends AbstractFutureStub<NoteInfoGetterFutureStub> {
        public /* synthetic */ NoteInfoGetterFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<NoteInfoResponse> getLatestNoteInfo(NoteInfoRequest noteInfoRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(NoteInfoGetterGrpc.getGetLatestNoteInfoMethod(), getCallOptions()), noteInfoRequest);
        }

        private NoteInfoGetterFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public NoteInfoGetterFutureStub build(Channel channel, CallOptions callOptions) {
            return new NoteInfoGetterFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class NoteInfoGetterImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(NoteInfoGetterGrpc.getServiceDescriptor()).addMethod(NoteInfoGetterGrpc.getGetLatestNoteInfoMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void getLatestNoteInfo(NoteInfoRequest noteInfoRequest, StreamObserver<NoteInfoResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(NoteInfoGetterGrpc.getGetLatestNoteInfoMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NoteInfoGetterStub extends AbstractAsyncStub<NoteInfoGetterStub> {
        public /* synthetic */ NoteInfoGetterStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void getLatestNoteInfo(NoteInfoRequest noteInfoRequest, StreamObserver<NoteInfoResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(NoteInfoGetterGrpc.getGetLatestNoteInfoMethod(), getCallOptions()), noteInfoRequest, streamObserver);
        }

        private NoteInfoGetterStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public NoteInfoGetterStub build(Channel channel, CallOptions callOptions) {
            return new NoteInfoGetterStub(channel, callOptions);
        }
    }

    private NoteInfoGetterGrpc() {
    }

    @RpcMethod(fullMethodName = "noteSnap.NoteInfoGetter/GetLatestNoteInfo", methodType = MethodDescriptor.MethodType.UNARY, requestType = NoteInfoRequest.class, responseType = NoteInfoResponse.class)
    public static MethodDescriptor<NoteInfoRequest, NoteInfoResponse> getGetLatestNoteInfoMethod() {
        MethodDescriptor<NoteInfoRequest, NoteInfoResponse> methodDescriptorBuild;
        MethodDescriptor<NoteInfoRequest, NoteInfoResponse> methodDescriptor = getGetLatestNoteInfoMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (NoteInfoGetterGrpc.class) {
            try {
                methodDescriptorBuild = getGetLatestNoteInfoMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "GetLatestNoteInfo")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(NoteInfoRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(NoteInfoResponse.getDefaultInstance())).build();
                    getGetLatestNoteInfoMethod = methodDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return methodDescriptorBuild;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptorBuild;
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 != null) {
            return serviceDescriptor2;
        }
        synchronized (NoteInfoGetterGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getGetLatestNoteInfoMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static NoteInfoGetterBlockingStub newBlockingStub(Channel channel) {
        return (NoteInfoGetterBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<NoteInfoGetterBlockingStub>() { // from class: noteSnap.NoteInfoGetterGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public NoteInfoGetterBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new NoteInfoGetterBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static NoteInfoGetterFutureStub newFutureStub(Channel channel) {
        return (NoteInfoGetterFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<NoteInfoGetterFutureStub>() { // from class: noteSnap.NoteInfoGetterGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public NoteInfoGetterFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new NoteInfoGetterFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static NoteInfoGetterStub newStub(Channel channel) {
        return (NoteInfoGetterStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<NoteInfoGetterStub>() { // from class: noteSnap.NoteInfoGetterGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public NoteInfoGetterStub newStub(Channel channel2, CallOptions callOptions) {
                return new NoteInfoGetterStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final NoteInfoGetterImplBase serviceImpl;

        public MethodHandlers(NoteInfoGetterImplBase noteInfoGetterImplBase, int i) {
            this.serviceImpl = noteInfoGetterImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.getLatestNoteInfo((NoteInfoRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
