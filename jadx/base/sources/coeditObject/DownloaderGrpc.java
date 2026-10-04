package coeditObject;

import coeditObjectMessage.DownloadStrokeRequest;
import coeditObjectMessage.DownloadStrokeResponse;
import coeditObjectMessage.SignedDownloadUrlRequest;
import coeditObjectMessage.SignedDownloadUrlResponse;
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
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@GrpcGenerated
public final class DownloaderGrpc {
    private static final int METHODID_DOWNLOAD_STROKE = 1;
    private static final int METHODID_GET_SIGNED_DOWNLOAD_URL = 0;
    public static final String SERVICE_NAME = "coeditObject.Downloader";
    private static volatile MethodDescriptor<DownloadStrokeRequest, DownloadStrokeResponse> getDownloadStrokeMethod;
    private static volatile MethodDescriptor<SignedDownloadUrlRequest, SignedDownloadUrlResponse> getGetSignedDownloadUrlMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DownloaderBlockingStub extends AbstractBlockingStub<DownloaderBlockingStub> {
        public /* synthetic */ DownloaderBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public Iterator<DownloadStrokeResponse> downloadStroke(DownloadStrokeRequest downloadStrokeRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), DownloaderGrpc.getDownloadStrokeMethod(), getCallOptions(), downloadStrokeRequest);
        }

        public SignedDownloadUrlResponse getSignedDownloadUrl(SignedDownloadUrlRequest signedDownloadUrlRequest) {
            return (SignedDownloadUrlResponse) ClientCalls.blockingUnaryCall(getChannel(), DownloaderGrpc.getGetSignedDownloadUrlMethod(), getCallOptions(), signedDownloadUrlRequest);
        }

        private DownloaderBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public DownloaderBlockingStub build(Channel channel, CallOptions callOptions) {
            return new DownloaderBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DownloaderFutureStub extends AbstractFutureStub<DownloaderFutureStub> {
        public /* synthetic */ DownloaderFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<SignedDownloadUrlResponse> getSignedDownloadUrl(SignedDownloadUrlRequest signedDownloadUrlRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(DownloaderGrpc.getGetSignedDownloadUrlMethod(), getCallOptions()), signedDownloadUrlRequest);
        }

        private DownloaderFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public DownloaderFutureStub build(Channel channel, CallOptions callOptions) {
            return new DownloaderFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class DownloaderImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(DownloaderGrpc.getServiceDescriptor()).addMethod(DownloaderGrpc.getGetSignedDownloadUrlMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(DownloaderGrpc.getDownloadStrokeMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 1))).build();
        }

        public void downloadStroke(DownloadStrokeRequest downloadStrokeRequest, StreamObserver<DownloadStrokeResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(DownloaderGrpc.getDownloadStrokeMethod(), streamObserver);
        }

        public void getSignedDownloadUrl(SignedDownloadUrlRequest signedDownloadUrlRequest, StreamObserver<SignedDownloadUrlResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(DownloaderGrpc.getGetSignedDownloadUrlMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DownloaderStub extends AbstractAsyncStub<DownloaderStub> {
        public /* synthetic */ DownloaderStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void downloadStroke(DownloadStrokeRequest downloadStrokeRequest, StreamObserver<DownloadStrokeResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(DownloaderGrpc.getDownloadStrokeMethod(), getCallOptions()), downloadStrokeRequest, streamObserver);
        }

        public void getSignedDownloadUrl(SignedDownloadUrlRequest signedDownloadUrlRequest, StreamObserver<SignedDownloadUrlResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(DownloaderGrpc.getGetSignedDownloadUrlMethod(), getCallOptions()), signedDownloadUrlRequest, streamObserver);
        }

        private DownloaderStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public DownloaderStub build(Channel channel, CallOptions callOptions) {
            return new DownloaderStub(channel, callOptions);
        }
    }

    private DownloaderGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditObject.Downloader/DownloadStroke", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = DownloadStrokeRequest.class, responseType = DownloadStrokeResponse.class)
    public static MethodDescriptor<DownloadStrokeRequest, DownloadStrokeResponse> getDownloadStrokeMethod() {
        MethodDescriptor<DownloadStrokeRequest, DownloadStrokeResponse> methodDescriptorBuild;
        MethodDescriptor<DownloadStrokeRequest, DownloadStrokeResponse> methodDescriptor = getDownloadStrokeMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (DownloaderGrpc.class) {
            try {
                methodDescriptorBuild = getDownloadStrokeMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.DownloadStroke)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(DownloadStrokeRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(DownloadStrokeResponse.getDefaultInstance())).build();
                    getDownloadStrokeMethod = methodDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return methodDescriptorBuild;
    }

    @RpcMethod(fullMethodName = "coeditObject.Downloader/GetSignedDownloadUrl", methodType = MethodDescriptor.MethodType.UNARY, requestType = SignedDownloadUrlRequest.class, responseType = SignedDownloadUrlResponse.class)
    public static MethodDescriptor<SignedDownloadUrlRequest, SignedDownloadUrlResponse> getGetSignedDownloadUrlMethod() {
        MethodDescriptor<SignedDownloadUrlRequest, SignedDownloadUrlResponse> methodDescriptorBuild;
        MethodDescriptor<SignedDownloadUrlRequest, SignedDownloadUrlResponse> methodDescriptor = getGetSignedDownloadUrlMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (DownloaderGrpc.class) {
            try {
                methodDescriptorBuild = getGetSignedDownloadUrlMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.GetSignedDownloadUrl)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(SignedDownloadUrlRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(SignedDownloadUrlResponse.getDefaultInstance())).build();
                    getGetSignedDownloadUrlMethod = methodDescriptorBuild;
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
        synchronized (DownloaderGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getGetSignedDownloadUrlMethod()).addMethod(getDownloadStrokeMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static DownloaderBlockingStub newBlockingStub(Channel channel) {
        return (DownloaderBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<DownloaderBlockingStub>() { // from class: coeditObject.DownloaderGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public DownloaderBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new DownloaderBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static DownloaderFutureStub newFutureStub(Channel channel) {
        return (DownloaderFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<DownloaderFutureStub>() { // from class: coeditObject.DownloaderGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public DownloaderFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new DownloaderFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static DownloaderStub newStub(Channel channel) {
        return (DownloaderStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<DownloaderStub>() { // from class: coeditObject.DownloaderGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public DownloaderStub newStub(Channel channel2, CallOptions callOptions) {
                return new DownloaderStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final DownloaderImplBase serviceImpl;

        public MethodHandlers(DownloaderImplBase downloaderImplBase, int i) {
            this.serviceImpl = downloaderImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 0) {
                this.serviceImpl.getSignedDownloadUrl((SignedDownloadUrlRequest) req, streamObserver);
            } else {
                if (i != 1) {
                    throw new AssertionError();
                }
                this.serviceImpl.downloadStroke((DownloadStrokeRequest) req, streamObserver);
            }
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
