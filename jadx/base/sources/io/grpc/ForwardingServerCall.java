package io.grpc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ForwardingServerCall<ReqT, RespT> extends PartialForwardingServerCall<ReqT, RespT> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SimpleForwardingServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
        private final ServerCall<ReqT, RespT> delegate;

        public SimpleForwardingServerCall(ServerCall<ReqT, RespT> serverCall) {
            this.delegate = serverCall;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
            super.close(status, metadata);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall
        public ServerCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
        public /* bridge */ /* synthetic */ Attributes getAttributes() {
            return super.getAttributes();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ String getAuthority() {
            return super.getAuthority();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
        public /* bridge */ /* synthetic */ SecurityLevel getSecurityLevel() {
            return super.getSecurityLevel();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ boolean isReady() {
            return super.isReady();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void request(int i) {
            super.request(i);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
            super.sendHeaders(metadata);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
        public /* bridge */ /* synthetic */ void setCompression(String str) {
            super.setCompression(str);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
        public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
            super.setMessageCompression(z);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
        super.close(status, metadata);
    }

    @Override // io.grpc.PartialForwardingServerCall
    public abstract ServerCall<ReqT, RespT> delegate();

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public /* bridge */ /* synthetic */ Attributes getAttributes() {
        return super.getAttributes();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ String getAuthority() {
        return super.getAuthority();
    }

    @Override // io.grpc.ServerCall
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return delegate().getMethodDescriptor();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
    public /* bridge */ /* synthetic */ SecurityLevel getSecurityLevel() {
        return super.getSecurityLevel();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void request(int i) {
        super.request(i);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
        super.sendHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    public void sendMessage(RespT respt) {
        delegate().sendMessage(respt);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public /* bridge */ /* synthetic */ void setCompression(String str) {
        super.setCompression(str);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
        super.setMessageCompression(z);
    }

    @Override // io.grpc.PartialForwardingServerCall
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
