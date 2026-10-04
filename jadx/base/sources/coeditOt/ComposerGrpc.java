package coeditOt;

import coeditOtMessage.ComposeRequest;
import coeditOtMessage.ComposeResponse;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
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
/* JADX INFO: loaded from: classes5.dex */
@GrpcGenerated
public final class ComposerGrpc {
    private static final int METHODID_COMPOSE = 0;
    public static final String SERVICE_NAME = "coeditOt.Composer";
    private static volatile MethodDescriptor<ComposeRequest, ComposeResponse> getComposeMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ComposerBlockingStub extends AbstractBlockingStub<ComposerBlockingStub> {
        public /* synthetic */ ComposerBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ComposeResponse compose(ComposeRequest composeRequest) {
            return (ComposeResponse) ClientCalls.blockingUnaryCall(getChannel(), ComposerGrpc.getComposeMethod(), getCallOptions(), composeRequest);
        }

        private ComposerBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ComposerBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ComposerBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ComposerFutureStub extends AbstractFutureStub<ComposerFutureStub> {
        public /* synthetic */ ComposerFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<ComposeResponse> compose(ComposeRequest composeRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ComposerGrpc.getComposeMethod(), getCallOptions()), composeRequest);
        }

        private ComposerFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ComposerFutureStub build(Channel channel, CallOptions callOptions) {
            return new ComposerFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ComposerImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ComposerGrpc.getServiceDescriptor()).addMethod(ComposerGrpc.getComposeMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void compose(ComposeRequest composeRequest, StreamObserver<ComposeResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ComposerGrpc.getComposeMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ComposerStub extends AbstractAsyncStub<ComposerStub> {
        public /* synthetic */ ComposerStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void compose(ComposeRequest composeRequest, StreamObserver<ComposeResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ComposerGrpc.getComposeMethod(), getCallOptions()), composeRequest, streamObserver);
        }

        private ComposerStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ComposerStub build(Channel channel, CallOptions callOptions) {
            return new ComposerStub(channel, callOptions);
        }
    }

    private ComposerGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditOt.Composer/Compose", methodType = MethodDescriptor.MethodType.UNARY, requestType = ComposeRequest.class, responseType = ComposeResponse.class)
    public static MethodDescriptor<ComposeRequest, ComposeResponse> getComposeMethod() {
        MethodDescriptor<ComposeRequest, ComposeResponse> methodDescriptorBuild;
        MethodDescriptor<ComposeRequest, ComposeResponse> methodDescriptor = getComposeMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (ComposerGrpc.class) {
            try {
                methodDescriptorBuild = getComposeMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.Compose)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ComposeRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ComposeResponse.getDefaultInstance())).build();
                    getComposeMethod = methodDescriptorBuild;
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
        synchronized (ComposerGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getComposeMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static ComposerBlockingStub newBlockingStub(Channel channel) {
        return (ComposerBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<ComposerBlockingStub>() { // from class: coeditOt.ComposerGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ComposerBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new ComposerBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static ComposerFutureStub newFutureStub(Channel channel) {
        return (ComposerFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<ComposerFutureStub>() { // from class: coeditOt.ComposerGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ComposerFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new ComposerFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static ComposerStub newStub(Channel channel) {
        return (ComposerStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<ComposerStub>() { // from class: coeditOt.ComposerGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ComposerStub newStub(Channel channel2, CallOptions callOptions) {
                return new ComposerStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final ComposerImplBase serviceImpl;

        public MethodHandlers(ComposerImplBase composerImplBase, int i) {
            this.serviceImpl = composerImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.compose((ComposeRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
