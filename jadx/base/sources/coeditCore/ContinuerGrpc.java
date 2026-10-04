package coeditCore;

import coeditCoreMessage.ClientMsg;
import coeditCoreMessage.ServerMsg;
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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@GrpcGenerated
public final class ContinuerGrpc {
    private static final int METHODID_CONTINUOUS_MESSAGE = 0;
    public static final String SERVICE_NAME = "coeditCore.Continuer";
    private static volatile MethodDescriptor<ClientMsg, ServerMsg> getContinuousMessageMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ContinuerBlockingStub extends AbstractBlockingStub<ContinuerBlockingStub> {
        public /* synthetic */ ContinuerBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        private ContinuerBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ContinuerBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ContinuerBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ContinuerFutureStub extends AbstractFutureStub<ContinuerFutureStub> {
        public /* synthetic */ ContinuerFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        private ContinuerFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ContinuerFutureStub build(Channel channel, CallOptions callOptions) {
            return new ContinuerFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ContinuerImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ContinuerGrpc.getServiceDescriptor()).addMethod(ContinuerGrpc.getContinuousMessageMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 0))).build();
        }

        public StreamObserver<ClientMsg> continuousMessage(StreamObserver<ServerMsg> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(ContinuerGrpc.getContinuousMessageMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ContinuerStub extends AbstractAsyncStub<ContinuerStub> {
        public /* synthetic */ ContinuerStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public StreamObserver<ClientMsg> continuousMessage(StreamObserver<ServerMsg> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(ContinuerGrpc.getContinuousMessageMethod(), getCallOptions()), streamObserver);
        }

        private ContinuerStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ContinuerStub build(Channel channel, CallOptions callOptions) {
            return new ContinuerStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final ContinuerImplBase serviceImpl;

        public MethodHandlers(ContinuerImplBase continuerImplBase, int i) {
            this.serviceImpl = continuerImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            if (this.methodId == 0) {
                return (StreamObserver<Req>) this.serviceImpl.continuousMessage(streamObserver);
            }
            throw new AssertionError();
        }
    }

    private ContinuerGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditCore.Continuer/ContinuousMessage", methodType = MethodDescriptor.MethodType.BIDI_STREAMING, requestType = ClientMsg.class, responseType = ServerMsg.class)
    public static MethodDescriptor<ClientMsg, ServerMsg> getContinuousMessageMethod() {
        MethodDescriptor<ClientMsg, ServerMsg> methodDescriptorBuild;
        MethodDescriptor<ClientMsg, ServerMsg> methodDescriptor = getContinuousMessageMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (ContinuerGrpc.class) {
            try {
                methodDescriptorBuild = getContinuousMessageMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "ContinuousMessage")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ClientMsg.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ServerMsg.getDefaultInstance())).build();
                    getContinuousMessageMethod = methodDescriptorBuild;
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
        synchronized (ContinuerGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getContinuousMessageMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static ContinuerBlockingStub newBlockingStub(Channel channel) {
        return (ContinuerBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<ContinuerBlockingStub>() { // from class: coeditCore.ContinuerGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ContinuerBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new ContinuerBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static ContinuerFutureStub newFutureStub(Channel channel) {
        return (ContinuerFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<ContinuerFutureStub>() { // from class: coeditCore.ContinuerGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ContinuerFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new ContinuerFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static ContinuerStub newStub(Channel channel) {
        return (ContinuerStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<ContinuerStub>() { // from class: coeditCore.ContinuerGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ContinuerStub newStub(Channel channel2, CallOptions callOptions) {
                return new ContinuerStub(channel2, callOptions, 0);
            }
        }, channel);
    }
}
