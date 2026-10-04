package coeditCore;

import coeditCoreMessage.CatchupRequest;
import coeditCoreMessage.CatchupResponse;
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
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@GrpcGenerated
public final class CatcherGrpc {
    private static final int METHODID_CATCHUP = 0;
    public static final String SERVICE_NAME = "coeditCore.Catcher";
    private static volatile MethodDescriptor<CatchupRequest, CatchupResponse> getCatchupMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CatcherBlockingStub extends AbstractBlockingStub<CatcherBlockingStub> {
        public /* synthetic */ CatcherBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public Iterator<CatchupResponse> catchup(CatchupRequest catchupRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), CatcherGrpc.getCatchupMethod(), getCallOptions(), catchupRequest);
        }

        private CatcherBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CatcherBlockingStub build(Channel channel, CallOptions callOptions) {
            return new CatcherBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CatcherFutureStub extends AbstractFutureStub<CatcherFutureStub> {
        public /* synthetic */ CatcherFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        private CatcherFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CatcherFutureStub build(Channel channel, CallOptions callOptions) {
            return new CatcherFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class CatcherImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(CatcherGrpc.getServiceDescriptor()).addMethod(CatcherGrpc.getCatchupMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 0))).build();
        }

        public void catchup(CatchupRequest catchupRequest, StreamObserver<CatchupResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(CatcherGrpc.getCatchupMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CatcherStub extends AbstractAsyncStub<CatcherStub> {
        public /* synthetic */ CatcherStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void catchup(CatchupRequest catchupRequest, StreamObserver<CatchupResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(CatcherGrpc.getCatchupMethod(), getCallOptions()), catchupRequest, streamObserver);
        }

        private CatcherStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CatcherStub build(Channel channel, CallOptions callOptions) {
            return new CatcherStub(channel, callOptions);
        }
    }

    private CatcherGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditCore.Catcher/Catchup", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = CatchupRequest.class, responseType = CatchupResponse.class)
    public static MethodDescriptor<CatchupRequest, CatchupResponse> getCatchupMethod() {
        MethodDescriptor<CatchupRequest, CatchupResponse> methodDescriptorBuild;
        MethodDescriptor<CatchupRequest, CatchupResponse> methodDescriptor = getCatchupMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (CatcherGrpc.class) {
            try {
                methodDescriptorBuild = getCatchupMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Catchup")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(CatchupRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(CatchupResponse.getDefaultInstance())).build();
                    getCatchupMethod = methodDescriptorBuild;
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
        synchronized (CatcherGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getCatchupMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static CatcherBlockingStub newBlockingStub(Channel channel) {
        return (CatcherBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<CatcherBlockingStub>() { // from class: coeditCore.CatcherGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CatcherBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new CatcherBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static CatcherFutureStub newFutureStub(Channel channel) {
        return (CatcherFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<CatcherFutureStub>() { // from class: coeditCore.CatcherGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CatcherFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new CatcherFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static CatcherStub newStub(Channel channel) {
        return (CatcherStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<CatcherStub>() { // from class: coeditCore.CatcherGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CatcherStub newStub(Channel channel2, CallOptions callOptions) {
                return new CatcherStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final CatcherImplBase serviceImpl;

        public MethodHandlers(CatcherImplBase catcherImplBase, int i) {
            this.serviceImpl = catcherImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.catchup((CatchupRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
