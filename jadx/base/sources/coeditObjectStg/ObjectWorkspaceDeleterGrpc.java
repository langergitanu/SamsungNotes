package coeditObjectStg;

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
public final class ObjectWorkspaceDeleterGrpc {
    private static final int METHODID_DELETE_WORKSPACE = 0;
    public static final String SERVICE_NAME = "coeditObjectStg.ObjectWorkspaceDeleter";
    private static volatile MethodDescriptor<DeleteRequest, DeleteResponse> getDeleteWorkspaceMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ObjectWorkspaceDeleterBlockingStub extends AbstractBlockingStub<ObjectWorkspaceDeleterBlockingStub> {
        public /* synthetic */ ObjectWorkspaceDeleterBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public DeleteResponse deleteWorkspace(DeleteRequest deleteRequest) {
            return (DeleteResponse) ClientCalls.blockingUnaryCall(getChannel(), ObjectWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), getCallOptions(), deleteRequest);
        }

        private ObjectWorkspaceDeleterBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ObjectWorkspaceDeleterBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ObjectWorkspaceDeleterBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ObjectWorkspaceDeleterFutureStub extends AbstractFutureStub<ObjectWorkspaceDeleterFutureStub> {
        public /* synthetic */ ObjectWorkspaceDeleterFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<DeleteResponse> deleteWorkspace(DeleteRequest deleteRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ObjectWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), getCallOptions()), deleteRequest);
        }

        private ObjectWorkspaceDeleterFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ObjectWorkspaceDeleterFutureStub build(Channel channel, CallOptions callOptions) {
            return new ObjectWorkspaceDeleterFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ObjectWorkspaceDeleterImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ObjectWorkspaceDeleterGrpc.getServiceDescriptor()).addMethod(ObjectWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void deleteWorkspace(DeleteRequest deleteRequest, StreamObserver<DeleteResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ObjectWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ObjectWorkspaceDeleterStub extends AbstractAsyncStub<ObjectWorkspaceDeleterStub> {
        public /* synthetic */ ObjectWorkspaceDeleterStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void deleteWorkspace(DeleteRequest deleteRequest, StreamObserver<DeleteResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ObjectWorkspaceDeleterGrpc.getDeleteWorkspaceMethod(), getCallOptions()), deleteRequest, streamObserver);
        }

        private ObjectWorkspaceDeleterStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ObjectWorkspaceDeleterStub build(Channel channel, CallOptions callOptions) {
            return new ObjectWorkspaceDeleterStub(channel, callOptions);
        }
    }

    private ObjectWorkspaceDeleterGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditObjectStg.ObjectWorkspaceDeleter/DeleteWorkspace", methodType = MethodDescriptor.MethodType.UNARY, requestType = DeleteRequest.class, responseType = DeleteResponse.class)
    public static MethodDescriptor<DeleteRequest, DeleteResponse> getDeleteWorkspaceMethod() {
        MethodDescriptor<DeleteRequest, DeleteResponse> methodDescriptorBuild;
        MethodDescriptor<DeleteRequest, DeleteResponse> methodDescriptor = getDeleteWorkspaceMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (ObjectWorkspaceDeleterGrpc.class) {
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
        synchronized (ObjectWorkspaceDeleterGrpc.class) {
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

    public static ObjectWorkspaceDeleterBlockingStub newBlockingStub(Channel channel) {
        return (ObjectWorkspaceDeleterBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<ObjectWorkspaceDeleterBlockingStub>() { // from class: coeditObjectStg.ObjectWorkspaceDeleterGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ObjectWorkspaceDeleterBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new ObjectWorkspaceDeleterBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static ObjectWorkspaceDeleterFutureStub newFutureStub(Channel channel) {
        return (ObjectWorkspaceDeleterFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<ObjectWorkspaceDeleterFutureStub>() { // from class: coeditObjectStg.ObjectWorkspaceDeleterGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ObjectWorkspaceDeleterFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new ObjectWorkspaceDeleterFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static ObjectWorkspaceDeleterStub newStub(Channel channel) {
        return (ObjectWorkspaceDeleterStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<ObjectWorkspaceDeleterStub>() { // from class: coeditObjectStg.ObjectWorkspaceDeleterGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ObjectWorkspaceDeleterStub newStub(Channel channel2, CallOptions callOptions) {
                return new ObjectWorkspaceDeleterStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final ObjectWorkspaceDeleterImplBase serviceImpl;

        public MethodHandlers(ObjectWorkspaceDeleterImplBase objectWorkspaceDeleterImplBase, int i) {
            this.serviceImpl = objectWorkspaceDeleterImplBase;
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
