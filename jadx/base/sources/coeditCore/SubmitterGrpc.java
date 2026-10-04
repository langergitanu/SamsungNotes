package coeditCore;

import coeditCoreMessage.SubmitRequest;
import coeditCoreMessage.SubmitResponse;
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
/* JADX INFO: loaded from: classes.dex */
@GrpcGenerated
public final class SubmitterGrpc {
    private static final int METHODID_SUBMIT = 0;
    public static final String SERVICE_NAME = "coeditCore.Submitter";
    private static volatile MethodDescriptor<SubmitRequest, SubmitResponse> getSubmitMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SubmitterBlockingStub extends AbstractBlockingStub<SubmitterBlockingStub> {
        public /* synthetic */ SubmitterBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public SubmitResponse submit(SubmitRequest submitRequest) {
            return (SubmitResponse) ClientCalls.blockingUnaryCall(getChannel(), SubmitterGrpc.getSubmitMethod(), getCallOptions(), submitRequest);
        }

        private SubmitterBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public SubmitterBlockingStub build(Channel channel, CallOptions callOptions) {
            return new SubmitterBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SubmitterFutureStub extends AbstractFutureStub<SubmitterFutureStub> {
        public /* synthetic */ SubmitterFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<SubmitResponse> submit(SubmitRequest submitRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(SubmitterGrpc.getSubmitMethod(), getCallOptions()), submitRequest);
        }

        private SubmitterFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public SubmitterFutureStub build(Channel channel, CallOptions callOptions) {
            return new SubmitterFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SubmitterImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(SubmitterGrpc.getServiceDescriptor()).addMethod(SubmitterGrpc.getSubmitMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void submit(SubmitRequest submitRequest, StreamObserver<SubmitResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(SubmitterGrpc.getSubmitMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SubmitterStub extends AbstractAsyncStub<SubmitterStub> {
        public /* synthetic */ SubmitterStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void submit(SubmitRequest submitRequest, StreamObserver<SubmitResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(SubmitterGrpc.getSubmitMethod(), getCallOptions()), submitRequest, streamObserver);
        }

        private SubmitterStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public SubmitterStub build(Channel channel, CallOptions callOptions) {
            return new SubmitterStub(channel, callOptions);
        }
    }

    private SubmitterGrpc() {
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptorBuild;
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 != null) {
            return serviceDescriptor2;
        }
        synchronized (SubmitterGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getSubmitMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    @RpcMethod(fullMethodName = "coeditCore.Submitter/Submit", methodType = MethodDescriptor.MethodType.UNARY, requestType = SubmitRequest.class, responseType = SubmitResponse.class)
    public static MethodDescriptor<SubmitRequest, SubmitResponse> getSubmitMethod() {
        MethodDescriptor<SubmitRequest, SubmitResponse> methodDescriptorBuild;
        MethodDescriptor<SubmitRequest, SubmitResponse> methodDescriptor = getSubmitMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (SubmitterGrpc.class) {
            try {
                methodDescriptorBuild = getSubmitMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.Submit)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(SubmitRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(SubmitResponse.getDefaultInstance())).build();
                    getSubmitMethod = methodDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return methodDescriptorBuild;
    }

    public static SubmitterBlockingStub newBlockingStub(Channel channel) {
        return (SubmitterBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<SubmitterBlockingStub>() { // from class: coeditCore.SubmitterGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public SubmitterBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new SubmitterBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static SubmitterFutureStub newFutureStub(Channel channel) {
        return (SubmitterFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<SubmitterFutureStub>() { // from class: coeditCore.SubmitterGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public SubmitterFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new SubmitterFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static SubmitterStub newStub(Channel channel) {
        return (SubmitterStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<SubmitterStub>() { // from class: coeditCore.SubmitterGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public SubmitterStub newStub(Channel channel2, CallOptions callOptions) {
                return new SubmitterStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final SubmitterImplBase serviceImpl;

        public MethodHandlers(SubmitterImplBase submitterImplBase, int i) {
            this.serviceImpl = submitterImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.submit((SubmitRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
