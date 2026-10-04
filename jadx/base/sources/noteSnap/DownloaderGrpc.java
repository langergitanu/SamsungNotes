package noteSnap;

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
import noteSnapMessage.DownloadRequest;
import noteSnapMessage.DownloadResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@GrpcGenerated
public final class DownloaderGrpc {
    private static final int METHODID_DOWNLOAD_NOTE = 0;
    public static final String SERVICE_NAME = "noteSnap.Downloader";
    private static volatile MethodDescriptor<DownloadRequest, DownloadResponse> getDownloadNoteMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DownloaderBlockingStub extends AbstractBlockingStub<DownloaderBlockingStub> {
        public /* synthetic */ DownloaderBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public Iterator<DownloadResponse> downloadNote(DownloadRequest downloadRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), DownloaderGrpc.getDownloadNoteMethod(), getCallOptions(), downloadRequest);
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
            return ServerServiceDefinition.builder(DownloaderGrpc.getServiceDescriptor()).addMethod(DownloaderGrpc.getDownloadNoteMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 0))).build();
        }

        public void downloadNote(DownloadRequest downloadRequest, StreamObserver<DownloadResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(DownloaderGrpc.getDownloadNoteMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DownloaderStub extends AbstractAsyncStub<DownloaderStub> {
        public /* synthetic */ DownloaderStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void downloadNote(DownloadRequest downloadRequest, StreamObserver<DownloadResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(DownloaderGrpc.getDownloadNoteMethod(), getCallOptions()), downloadRequest, streamObserver);
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

    @RpcMethod(fullMethodName = "noteSnap.Downloader/DownloadNote", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = DownloadRequest.class, responseType = DownloadResponse.class)
    public static MethodDescriptor<DownloadRequest, DownloadResponse> getDownloadNoteMethod() {
        MethodDescriptor<DownloadRequest, DownloadResponse> methodDescriptorBuild;
        MethodDescriptor<DownloadRequest, DownloadResponse> methodDescriptor = getDownloadNoteMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (DownloaderGrpc.class) {
            try {
                methodDescriptorBuild = getDownloadNoteMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DownloadNote")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(DownloadRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(DownloadResponse.getDefaultInstance())).build();
                    getDownloadNoteMethod = methodDescriptorBuild;
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
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getDownloadNoteMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    public static DownloaderBlockingStub newBlockingStub(Channel channel) {
        return (DownloaderBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<DownloaderBlockingStub>() { // from class: noteSnap.DownloaderGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public DownloaderBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new DownloaderBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static DownloaderFutureStub newFutureStub(Channel channel) {
        return (DownloaderFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<DownloaderFutureStub>() { // from class: noteSnap.DownloaderGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public DownloaderFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new DownloaderFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static DownloaderStub newStub(Channel channel) {
        return (DownloaderStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<DownloaderStub>() { // from class: noteSnap.DownloaderGrpc.1
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
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.downloadNote((DownloadRequest) req, streamObserver);
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
