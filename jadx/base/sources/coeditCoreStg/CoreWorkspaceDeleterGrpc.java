package coeditCoreStg;

import coeditCoreInternalMessage.DeleteRequest;
import coeditCoreInternalMessage.DeleteResponse;
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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@GrpcGenerated
public final class CoreWorkspaceDeleterGrpc {
    private static final int METHODID_DELETE_WORKSPACE = 0;
    public static final String SERVICE_NAME = "coeditCoreStg.CoreWorkspaceDeleter";
    private static volatile MethodDescriptor<DeleteRequest, DeleteResponse> getDeleteWorkspaceMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CoreWorkspaceDeleterBlockingStub extends AbstractBlockingStub<CoreWorkspaceDeleterBlockingStub> {
        public /* synthetic */ CoreWorkspaceDeleterBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public DeleteResponse deleteWorkspace(DeleteRequest deleteRequest) {
            return (DeleteResponse) ClientCalls.blockingUnaryCall(getChannel(), CoreWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), getCallOptions(), deleteRequest);
        }

        private CoreWorkspaceDeleterBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CoreWorkspaceDeleterBlockingStub build(Channel channel, CallOptions callOptions) {
            return new CoreWorkspaceDeleterBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CoreWorkspaceDeleterFutureStub extends AbstractFutureStub<CoreWorkspaceDeleterFutureStub> {
        public /* synthetic */ CoreWorkspaceDeleterFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<DeleteResponse> deleteWorkspace(DeleteRequest deleteRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(CoreWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), getCallOptions()), deleteRequest);
        }

        private CoreWorkspaceDeleterFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CoreWorkspaceDeleterFutureStub build(Channel channel, CallOptions callOptions) {
            return new CoreWorkspaceDeleterFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class CoreWorkspaceDeleterImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(CoreWorkspaceDeleterGrpc.getServiceDescriptor()).addMethod(CoreWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void deleteWorkspace(DeleteRequest deleteRequest, StreamObserver<DeleteResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(CoreWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CoreWorkspaceDeleterStub extends AbstractAsyncStub<CoreWorkspaceDeleterStub> {
        public /* synthetic */ CoreWorkspaceDeleterStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void deleteWorkspace(DeleteRequest deleteRequest, StreamObserver<DeleteResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(CoreWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), getCallOptions()), deleteRequest, streamObserver);
        }

        private CoreWorkspaceDeleterStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CoreWorkspaceDeleterStub build(Channel channel, CallOptions callOptions) {
            return new CoreWorkspaceDeleterStub(channel, callOptions);
        }
    }

    private CoreWorkspaceDeleterGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditCoreStg.CoreWorkspaceDeleter/DeleteWorkspace", methodType = MethodDescriptor.MethodType.UNARY, requestType = DeleteRequest.class, responseType = DeleteResponse.class)
    public static MethodDescriptor<DeleteRequest, DeleteResponse> getDeleteWorkspaceMethod() {
        MethodDescriptor<DeleteRequest, DeleteResponse> methodDescriptorBuild;
        MethodDescriptor<DeleteRequest, DeleteResponse> methodDescriptor = getDeleteWorkspaceMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (CoreWorkspaceDeleterGrpc.class) {
            try {
                methodDescriptorBuild = getDeleteWorkspaceMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DeleteWorkspace")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(DeleteRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(DeleteResponse.getDefaultInstance())).build();
                    getDeleteWorkspaceMethod = methodDescriptorBuild;
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
        synchronized (CoreWorkspaceDeleterGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getDeleteWorkspaceMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static CoreWorkspaceDeleterBlockingStub newBlockingStub(Channel channel) {
        return (CoreWorkspaceDeleterBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<CoreWorkspaceDeleterBlockingStub>() { // from class: coeditCoreStg.CoreWorkspaceDeleterGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CoreWorkspaceDeleterBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new CoreWorkspaceDeleterBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static CoreWorkspaceDeleterFutureStub newFutureStub(Channel channel) {
        return (CoreWorkspaceDeleterFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<CoreWorkspaceDeleterFutureStub>() { // from class: coeditCoreStg.CoreWorkspaceDeleterGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CoreWorkspaceDeleterFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new CoreWorkspaceDeleterFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static CoreWorkspaceDeleterStub newStub(Channel channel) {
        return (CoreWorkspaceDeleterStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<CoreWorkspaceDeleterStub>() { // from class: coeditCoreStg.CoreWorkspaceDeleterGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CoreWorkspaceDeleterStub newStub(Channel channel2, CallOptions callOptions) {
                return new CoreWorkspaceDeleterStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final CoreWorkspaceDeleterImplBase serviceImpl;

        public MethodHandlers(CoreWorkspaceDeleterImplBase coreWorkspaceDeleterImplBase, int i) {
            this.serviceImpl = coreWorkspaceDeleterImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.deleteWorkspace((DeleteRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
