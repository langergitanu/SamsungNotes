package coeditObject;

import coeditObjectMessage.ObjUploadUrlRequest;
import coeditObjectMessage.ObjUploadUrlResponse;
import coeditObjectMessage.UploadStrokeRequest;
import coeditObjectMessage.UploadStrokeResponse;
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
public final class UploaderGrpc {
    private static final int METHODID_GET_OBJECT_UPLOAD_URL = 0;
    private static final int METHODID_UPLOAD_STROKE = 1;
    public static final String SERVICE_NAME = "coeditObject.Uploader";
    private static volatile MethodDescriptor<ObjUploadUrlRequest, ObjUploadUrlResponse> getGetObjectUploadUrlMethod;
    private static volatile MethodDescriptor<UploadStrokeRequest, UploadStrokeResponse> getUploadStrokeMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UploaderBlockingStub extends AbstractBlockingStub<UploaderBlockingStub> {
        public /* synthetic */ UploaderBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ObjUploadUrlResponse getObjectUploadUrl(ObjUploadUrlRequest objUploadUrlRequest) {
            return (ObjUploadUrlResponse) ClientCalls.blockingUnaryCall(getChannel(), UploaderGrpc.getGetObjectUploadUrlMethod(), getCallOptions(), objUploadUrlRequest);
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

        public ListenableFuture<ObjUploadUrlResponse> getObjectUploadUrl(ObjUploadUrlRequest objUploadUrlRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(UploaderGrpc.getGetObjectUploadUrlMethod(), getCallOptions()), objUploadUrlRequest);
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
            return ServerServiceDefinition.builder(UploaderGrpc.getServiceDescriptor()).addMethod(UploaderGrpc.getGetObjectUploadUrlMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(UploaderGrpc.getUploadStrokeMethod(), ServerCalls.asyncClientStreamingCall(new MethodHandlers(this, 1))).build();
        }

        public void getObjectUploadUrl(ObjUploadUrlRequest objUploadUrlRequest, StreamObserver<ObjUploadUrlResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(UploaderGrpc.getGetObjectUploadUrlMethod(), streamObserver);
        }

        public StreamObserver<UploadStrokeRequest> uploadStroke(StreamObserver<UploadStrokeResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(UploaderGrpc.getUploadStrokeMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UploaderStub extends AbstractAsyncStub<UploaderStub> {
        public /* synthetic */ UploaderStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void getObjectUploadUrl(ObjUploadUrlRequest objUploadUrlRequest, StreamObserver<ObjUploadUrlResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(UploaderGrpc.getGetObjectUploadUrlMethod(), getCallOptions()), objUploadUrlRequest, streamObserver);
        }

        public StreamObserver<UploadStrokeRequest> uploadStroke(StreamObserver<UploadStrokeResponse> streamObserver) {
            return ClientCalls.asyncClientStreamingCall(getChannel().newCall(UploaderGrpc.getUploadStrokeMethod(), getCallOptions()), streamObserver);
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

    @RpcMethod(fullMethodName = "coeditObject.Uploader/GetObjectUploadUrl", methodType = MethodDescriptor.MethodType.UNARY, requestType = ObjUploadUrlRequest.class, responseType = ObjUploadUrlResponse.class)
    public static MethodDescriptor<ObjUploadUrlRequest, ObjUploadUrlResponse> getGetObjectUploadUrlMethod() {
        MethodDescriptor<ObjUploadUrlRequest, ObjUploadUrlResponse> methodDescriptorBuild;
        MethodDescriptor<ObjUploadUrlRequest, ObjUploadUrlResponse> methodDescriptor = getGetObjectUploadUrlMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (UploaderGrpc.class) {
            try {
                methodDescriptorBuild = getGetObjectUploadUrlMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.GetObjectUploadUrl)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ObjUploadUrlRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ObjUploadUrlResponse.getDefaultInstance())).build();
                    getGetObjectUploadUrlMethod = methodDescriptorBuild;
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
        synchronized (UploaderGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getGetObjectUploadUrlMethod()).addMethod(getUploadStrokeMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    @RpcMethod(fullMethodName = "coeditObject.Uploader/UploadStroke", methodType = MethodDescriptor.MethodType.CLIENT_STREAMING, requestType = UploadStrokeRequest.class, responseType = UploadStrokeResponse.class)
    public static MethodDescriptor<UploadStrokeRequest, UploadStrokeResponse> getUploadStrokeMethod() {
        MethodDescriptor<UploadStrokeRequest, UploadStrokeResponse> methodDescriptorBuild;
        MethodDescriptor<UploadStrokeRequest, UploadStrokeResponse> methodDescriptor = getUploadStrokeMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (UploaderGrpc.class) {
            try {
                methodDescriptorBuild = getUploadStrokeMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.CLIENT_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.UploadStroke)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(UploadStrokeRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(UploadStrokeResponse.getDefaultInstance())).build();
                    getUploadStrokeMethod = methodDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return methodDescriptorBuild;
    }

    public static UploaderBlockingStub newBlockingStub(Channel channel) {
        return (UploaderBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<UploaderBlockingStub>() { // from class: coeditObject.UploaderGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public UploaderBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new UploaderBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static UploaderFutureStub newFutureStub(Channel channel) {
        return (UploaderFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<UploaderFutureStub>() { // from class: coeditObject.UploaderGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public UploaderFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new UploaderFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static UploaderStub newStub(Channel channel) {
        return (UploaderStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<UploaderStub>() { // from class: coeditObject.UploaderGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public UploaderStub newStub(Channel channel2, CallOptions callOptions) {
                return new UploaderStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final UploaderImplBase serviceImpl;

        public MethodHandlers(UploaderImplBase uploaderImplBase, int i) {
            this.serviceImpl = uploaderImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.getObjectUploadUrl((ObjUploadUrlRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            if (this.methodId == 1) {
                return (StreamObserver<Req>) this.serviceImpl.uploadStroke(streamObserver);
            }
            throw new AssertionError();
        }
    }
}
