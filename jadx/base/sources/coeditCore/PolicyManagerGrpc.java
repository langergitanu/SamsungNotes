package coeditCore;

import coeditCoreMessage.PermissionRequest;
import coeditCoreMessage.PermissionResponse;
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
public final class PolicyManagerGrpc {
    private static final int METHODID_REQUEST_PERMISSION = 0;
    public static final String SERVICE_NAME = "coeditCore.PolicyManager";
    private static volatile MethodDescriptor<PermissionRequest, PermissionResponse> getRequestPermissionMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PolicyManagerBlockingStub extends AbstractBlockingStub<PolicyManagerBlockingStub> {
        public /* synthetic */ PolicyManagerBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public PermissionResponse requestPermission(PermissionRequest permissionRequest) {
            return (PermissionResponse) ClientCalls.blockingUnaryCall(getChannel(), PolicyManagerGrpc.getRequestPermissionMethod(), getCallOptions(), permissionRequest);
        }

        private PolicyManagerBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public PolicyManagerBlockingStub build(Channel channel, CallOptions callOptions) {
            return new PolicyManagerBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PolicyManagerFutureStub extends AbstractFutureStub<PolicyManagerFutureStub> {
        public /* synthetic */ PolicyManagerFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<PermissionResponse> requestPermission(PermissionRequest permissionRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(PolicyManagerGrpc.getRequestPermissionMethod(), getCallOptions()), permissionRequest);
        }

        private PolicyManagerFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public PolicyManagerFutureStub build(Channel channel, CallOptions callOptions) {
            return new PolicyManagerFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PolicyManagerImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(PolicyManagerGrpc.getServiceDescriptor()).addMethod(PolicyManagerGrpc.getRequestPermissionMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void requestPermission(PermissionRequest permissionRequest, StreamObserver<PermissionResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(PolicyManagerGrpc.getRequestPermissionMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PolicyManagerStub extends AbstractAsyncStub<PolicyManagerStub> {
        public /* synthetic */ PolicyManagerStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void requestPermission(PermissionRequest permissionRequest, StreamObserver<PermissionResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(PolicyManagerGrpc.getRequestPermissionMethod(), getCallOptions()), permissionRequest, streamObserver);
        }

        private PolicyManagerStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public PolicyManagerStub build(Channel channel, CallOptions callOptions) {
            return new PolicyManagerStub(channel, callOptions);
        }
    }

    private PolicyManagerGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditCore.PolicyManager/RequestPermission", methodType = MethodDescriptor.MethodType.UNARY, requestType = PermissionRequest.class, responseType = PermissionResponse.class)
    public static MethodDescriptor<PermissionRequest, PermissionResponse> getRequestPermissionMethod() {
        MethodDescriptor<PermissionRequest, PermissionResponse> methodDescriptorBuild;
        MethodDescriptor<PermissionRequest, PermissionResponse> methodDescriptor = getRequestPermissionMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (PolicyManagerGrpc.class) {
            try {
                methodDescriptorBuild = getRequestPermissionMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.RequestPermission)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(PermissionRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(PermissionResponse.getDefaultInstance())).build();
                    getRequestPermissionMethod = methodDescriptorBuild;
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
        synchronized (PolicyManagerGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getRequestPermissionMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static PolicyManagerBlockingStub newBlockingStub(Channel channel) {
        return (PolicyManagerBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<PolicyManagerBlockingStub>() { // from class: coeditCore.PolicyManagerGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public PolicyManagerBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new PolicyManagerBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static PolicyManagerFutureStub newFutureStub(Channel channel) {
        return (PolicyManagerFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<PolicyManagerFutureStub>() { // from class: coeditCore.PolicyManagerGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public PolicyManagerFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new PolicyManagerFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static PolicyManagerStub newStub(Channel channel) {
        return (PolicyManagerStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<PolicyManagerStub>() { // from class: coeditCore.PolicyManagerGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public PolicyManagerStub newStub(Channel channel2, CallOptions callOptions) {
                return new PolicyManagerStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final PolicyManagerImplBase serviceImpl;

        public MethodHandlers(PolicyManagerImplBase policyManagerImplBase, int i) {
            this.serviceImpl = policyManagerImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.requestPermission((PermissionRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
