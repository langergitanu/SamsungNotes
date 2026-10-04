package coeditCore;

import coeditCoreMessage.ResetWorkspaceRequest;
import coeditCoreMessage.ResetWorkspaceResponse;
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
public final class WorkspaceManagerGrpc {
    private static final int METHODID_RESET_WORKSPACE = 0;
    public static final String SERVICE_NAME = "coeditCore.WorkspaceManager";
    private static volatile MethodDescriptor<ResetWorkspaceRequest, ResetWorkspaceResponse> getResetWorkspaceMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WorkspaceManagerBlockingStub extends AbstractBlockingStub<WorkspaceManagerBlockingStub> {
        public /* synthetic */ WorkspaceManagerBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ResetWorkspaceResponse resetWorkspace(ResetWorkspaceRequest resetWorkspaceRequest) {
            return (ResetWorkspaceResponse) ClientCalls.blockingUnaryCall(getChannel(), WorkspaceManagerGrpc.getResetWorkspaceMethod(), getCallOptions(), resetWorkspaceRequest);
        }

        private WorkspaceManagerBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public WorkspaceManagerBlockingStub build(Channel channel, CallOptions callOptions) {
            return new WorkspaceManagerBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WorkspaceManagerFutureStub extends AbstractFutureStub<WorkspaceManagerFutureStub> {
        public /* synthetic */ WorkspaceManagerFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<ResetWorkspaceResponse> resetWorkspace(ResetWorkspaceRequest resetWorkspaceRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(WorkspaceManagerGrpc.getResetWorkspaceMethod(), getCallOptions()), resetWorkspaceRequest);
        }

        private WorkspaceManagerFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public WorkspaceManagerFutureStub build(Channel channel, CallOptions callOptions) {
            return new WorkspaceManagerFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class WorkspaceManagerImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(WorkspaceManagerGrpc.getServiceDescriptor()).addMethod(WorkspaceManagerGrpc.getResetWorkspaceMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void resetWorkspace(ResetWorkspaceRequest resetWorkspaceRequest, StreamObserver<ResetWorkspaceResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(WorkspaceManagerGrpc.getResetWorkspaceMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WorkspaceManagerStub extends AbstractAsyncStub<WorkspaceManagerStub> {
        public /* synthetic */ WorkspaceManagerStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void resetWorkspace(ResetWorkspaceRequest resetWorkspaceRequest, StreamObserver<ResetWorkspaceResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(WorkspaceManagerGrpc.getResetWorkspaceMethod(), getCallOptions()), resetWorkspaceRequest, streamObserver);
        }

        private WorkspaceManagerStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public WorkspaceManagerStub build(Channel channel, CallOptions callOptions) {
            return new WorkspaceManagerStub(channel, callOptions);
        }
    }

    private WorkspaceManagerGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditCore.WorkspaceManager/ResetWorkspace", methodType = MethodDescriptor.MethodType.UNARY, requestType = ResetWorkspaceRequest.class, responseType = ResetWorkspaceResponse.class)
    public static MethodDescriptor<ResetWorkspaceRequest, ResetWorkspaceResponse> getResetWorkspaceMethod() {
        MethodDescriptor<ResetWorkspaceRequest, ResetWorkspaceResponse> methodDescriptorBuild;
        MethodDescriptor<ResetWorkspaceRequest, ResetWorkspaceResponse> methodDescriptor = getResetWorkspaceMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (WorkspaceManagerGrpc.class) {
            try {
                methodDescriptorBuild = getResetWorkspaceMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.ResetWorkspace)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ResetWorkspaceRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ResetWorkspaceResponse.getDefaultInstance())).build();
                    getResetWorkspaceMethod = methodDescriptorBuild;
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
        synchronized (WorkspaceManagerGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getResetWorkspaceMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static WorkspaceManagerBlockingStub newBlockingStub(Channel channel) {
        return (WorkspaceManagerBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<WorkspaceManagerBlockingStub>() { // from class: coeditCore.WorkspaceManagerGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public WorkspaceManagerBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new WorkspaceManagerBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static WorkspaceManagerFutureStub newFutureStub(Channel channel) {
        return (WorkspaceManagerFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<WorkspaceManagerFutureStub>() { // from class: coeditCore.WorkspaceManagerGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public WorkspaceManagerFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new WorkspaceManagerFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static WorkspaceManagerStub newStub(Channel channel) {
        return (WorkspaceManagerStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<WorkspaceManagerStub>() { // from class: coeditCore.WorkspaceManagerGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public WorkspaceManagerStub newStub(Channel channel2, CallOptions callOptions) {
                return new WorkspaceManagerStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final WorkspaceManagerImplBase serviceImpl;

        public MethodHandlers(WorkspaceManagerImplBase workspaceManagerImplBase, int i) {
            this.serviceImpl = workspaceManagerImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.resetWorkspace((ResetWorkspaceRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
