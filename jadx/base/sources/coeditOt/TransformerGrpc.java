package coeditOt;

import coeditOtMessage.MultipleTransformRequest;
import coeditOtMessage.MultipleTransformResponse;
import coeditOtMessage.TransformRequest;
import coeditOtMessage.TransformResponse;
import coeditOtMessage.TransformWithMultipleRequest;
import coeditOtMessage.TransformWithMultipleResponse;
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
public final class TransformerGrpc {
    private static final int METHODID_MULTIPLE_TRANSFORM = 1;
    private static final int METHODID_TRANSFORM = 0;
    private static final int METHODID_TRANSFORM_WITH_MULTIPLE = 2;
    public static final String SERVICE_NAME = "coeditOt.Transformer";
    private static volatile MethodDescriptor<MultipleTransformRequest, MultipleTransformResponse> getMultipleTransformMethod;
    private static volatile MethodDescriptor<TransformRequest, TransformResponse> getTransformMethod;
    private static volatile MethodDescriptor<TransformWithMultipleRequest, TransformWithMultipleResponse> getTransformWithMultipleMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TransformerBlockingStub extends AbstractBlockingStub<TransformerBlockingStub> {
        public /* synthetic */ TransformerBlockingStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public MultipleTransformResponse multipleTransform(MultipleTransformRequest multipleTransformRequest) {
            return (MultipleTransformResponse) ClientCalls.blockingUnaryCall(getChannel(), TransformerGrpc.getMultipleTransformMethod(), getCallOptions(), multipleTransformRequest);
        }

        public TransformResponse transform(TransformRequest transformRequest) {
            return (TransformResponse) ClientCalls.blockingUnaryCall(getChannel(), TransformerGrpc.getTransformMethod(), getCallOptions(), transformRequest);
        }

        public TransformWithMultipleResponse transformWithMultiple(TransformWithMultipleRequest transformWithMultipleRequest) {
            return (TransformWithMultipleResponse) ClientCalls.blockingUnaryCall(getChannel(), TransformerGrpc.getTransformWithMultipleMethod(), getCallOptions(), transformWithMultipleRequest);
        }

        private TransformerBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public TransformerBlockingStub build(Channel channel, CallOptions callOptions) {
            return new TransformerBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TransformerFutureStub extends AbstractFutureStub<TransformerFutureStub> {
        public /* synthetic */ TransformerFutureStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public ListenableFuture<MultipleTransformResponse> multipleTransform(MultipleTransformRequest multipleTransformRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(TransformerGrpc.getMultipleTransformMethod(), getCallOptions()), multipleTransformRequest);
        }

        public ListenableFuture<TransformResponse> transform(TransformRequest transformRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(TransformerGrpc.getTransformMethod(), getCallOptions()), transformRequest);
        }

        public ListenableFuture<TransformWithMultipleResponse> transformWithMultiple(TransformWithMultipleRequest transformWithMultipleRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(TransformerGrpc.getTransformWithMultipleMethod(), getCallOptions()), transformWithMultipleRequest);
        }

        private TransformerFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public TransformerFutureStub build(Channel channel, CallOptions callOptions) {
            return new TransformerFutureStub(channel, callOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TransformerImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(TransformerGrpc.getServiceDescriptor()).addMethod(TransformerGrpc.getTransformMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(TransformerGrpc.getMultipleTransformMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 1))).addMethod(TransformerGrpc.getTransformWithMultipleMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 2))).build();
        }

        public void multipleTransform(MultipleTransformRequest multipleTransformRequest, StreamObserver<MultipleTransformResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(TransformerGrpc.getMultipleTransformMethod(), streamObserver);
        }

        public void transform(TransformRequest transformRequest, StreamObserver<TransformResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(TransformerGrpc.getTransformMethod(), streamObserver);
        }

        public void transformWithMultiple(TransformWithMultipleRequest transformWithMultipleRequest, StreamObserver<TransformWithMultipleResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(TransformerGrpc.getTransformWithMultipleMethod(), streamObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TransformerStub extends AbstractAsyncStub<TransformerStub> {
        public /* synthetic */ TransformerStub(Channel channel, CallOptions callOptions, int i) {
            this(channel, callOptions);
        }

        public void multipleTransform(MultipleTransformRequest multipleTransformRequest, StreamObserver<MultipleTransformResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(TransformerGrpc.getMultipleTransformMethod(), getCallOptions()), multipleTransformRequest, streamObserver);
        }

        public void transform(TransformRequest transformRequest, StreamObserver<TransformResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(TransformerGrpc.getTransformMethod(), getCallOptions()), transformRequest, streamObserver);
        }

        public void transformWithMultiple(TransformWithMultipleRequest transformWithMultipleRequest, StreamObserver<TransformWithMultipleResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(TransformerGrpc.getTransformWithMultipleMethod(), getCallOptions()), transformWithMultipleRequest, streamObserver);
        }

        private TransformerStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public TransformerStub build(Channel channel, CallOptions callOptions) {
            return new TransformerStub(channel, callOptions);
        }
    }

    private TransformerGrpc() {
    }

    @RpcMethod(fullMethodName = "coeditOt.Transformer/MultipleTransform", methodType = MethodDescriptor.MethodType.UNARY, requestType = MultipleTransformRequest.class, responseType = MultipleTransformResponse.class)
    public static MethodDescriptor<MultipleTransformRequest, MultipleTransformResponse> getMultipleTransformMethod() {
        MethodDescriptor<MultipleTransformRequest, MultipleTransformResponse> methodDescriptorBuild;
        MethodDescriptor<MultipleTransformRequest, MultipleTransformResponse> methodDescriptor = getMultipleTransformMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (TransformerGrpc.class) {
            try {
                methodDescriptorBuild = getMultipleTransformMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.MultipleTransform)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(MultipleTransformRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(MultipleTransformResponse.getDefaultInstance())).build();
                    getMultipleTransformMethod = methodDescriptorBuild;
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
        synchronized (TransformerGrpc.class) {
            try {
                serviceDescriptorBuild = serviceDescriptor;
                if (serviceDescriptorBuild == null) {
                    serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getTransformMethod()).addMethod(getMultipleTransformMethod()).addMethod(getTransformWithMultipleMethod()).build();
                    serviceDescriptor = serviceDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceDescriptorBuild;
    }

    @RpcMethod(fullMethodName = "coeditOt.Transformer/Transform", methodType = MethodDescriptor.MethodType.UNARY, requestType = TransformRequest.class, responseType = TransformResponse.class)
    public static MethodDescriptor<TransformRequest, TransformResponse> getTransformMethod() {
        MethodDescriptor<TransformRequest, TransformResponse> methodDescriptorBuild;
        MethodDescriptor<TransformRequest, TransformResponse> methodDescriptor = getTransformMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (TransformerGrpc.class) {
            try {
                methodDescriptorBuild = getTransformMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.Transform)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(TransformRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(TransformResponse.getDefaultInstance())).build();
                    getTransformMethod = methodDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return methodDescriptorBuild;
    }

    @RpcMethod(fullMethodName = "coeditOt.Transformer/TransformWithMultiple", methodType = MethodDescriptor.MethodType.UNARY, requestType = TransformWithMultipleRequest.class, responseType = TransformWithMultipleResponse.class)
    public static MethodDescriptor<TransformWithMultipleRequest, TransformWithMultipleResponse> getTransformWithMultipleMethod() {
        MethodDescriptor<TransformWithMultipleRequest, TransformWithMultipleResponse> methodDescriptorBuild;
        MethodDescriptor<TransformWithMultipleRequest, TransformWithMultipleResponse> methodDescriptor = getTransformWithMultipleMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (TransformerGrpc.class) {
            try {
                methodDescriptorBuild = getTransformWithMultipleMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, CoeditGrpcMethod.Caller.TransformWithMultiple)).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(TransformWithMultipleRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(TransformWithMultipleResponse.getDefaultInstance())).build();
                    getTransformWithMultipleMethod = methodDescriptorBuild;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return methodDescriptorBuild;
    }

    public static TransformerBlockingStub newBlockingStub(Channel channel) {
        return (TransformerBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<TransformerBlockingStub>() { // from class: coeditOt.TransformerGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public TransformerBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new TransformerBlockingStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static TransformerFutureStub newFutureStub(Channel channel) {
        return (TransformerFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<TransformerFutureStub>() { // from class: coeditOt.TransformerGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public TransformerFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new TransformerFutureStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    public static TransformerStub newStub(Channel channel) {
        return (TransformerStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<TransformerStub>() { // from class: coeditOt.TransformerGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public TransformerStub newStub(Channel channel2, CallOptions callOptions) {
                return new TransformerStub(channel2, callOptions, 0);
            }
        }, channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final TransformerImplBase serviceImpl;

        public MethodHandlers(TransformerImplBase transformerImplBase, int i) {
            this.serviceImpl = transformerImplBase;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 0) {
                this.serviceImpl.transform((TransformRequest) req, streamObserver);
            } else if (i == 1) {
                this.serviceImpl.multipleTransform((MultipleTransformRequest) req, streamObserver);
            } else {
                if (i != 2) {
                    throw new AssertionError();
                }
                this.serviceImpl.transformWithMultiple((TransformWithMultipleRequest) req, streamObserver);
            }
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
