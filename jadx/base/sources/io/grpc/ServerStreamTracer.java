package io.grpc;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
@ThreadSafe
public abstract class ServerStreamTracer extends StreamTracer {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Factory {
        public abstract ServerStreamTracer newServerStreamTracer(String str, Metadata metadata);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public static final class ReadOnlyServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
        private final ServerCallInfo<ReqT, RespT> callInfo;

        private ReadOnlyServerCall(ServerCallInfo<ReqT, RespT> serverCallInfo) {
            this.callInfo = serverCallInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <ReqT, RespT> ReadOnlyServerCall<ReqT, RespT> create(ServerCallInfo<ReqT, RespT> serverCallInfo) {
            return new ReadOnlyServerCall<>(serverCallInfo);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall
        public ServerCall<ReqT, RespT> delegate() {
            throw new UnsupportedOperationException();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public Attributes getAttributes() {
            return this.callInfo.getAttributes();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public String getAuthority() {
            return this.callInfo.getAuthority();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.ServerCall
        public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
            return this.callInfo.getMethodDescriptor();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isCancelled() {
            return false;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isReady() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ServerCallInfo<ReqT, RespT> {
        public abstract Attributes getAttributes();

        @Nullable
        public abstract String getAuthority();

        public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();
    }

    public Context filterContext(Context context) {
        return context;
    }

    @Deprecated
    public void serverCallStarted(ServerCall<?, ?> serverCall) {
    }

    public void serverCallStarted(ServerCallInfo<?, ?> serverCallInfo) {
        serverCallStarted(ReadOnlyServerCall.create(serverCallInfo));
    }
}
