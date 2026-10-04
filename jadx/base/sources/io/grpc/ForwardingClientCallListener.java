package io.grpc;

import io.grpc.ClientCall;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ForwardingClientCallListener<RespT> extends PartialForwardingClientCallListener<RespT> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SimpleForwardingClientCallListener<RespT> extends ForwardingClientCallListener<RespT> {
        private final ClientCall.Listener<RespT> delegate;

        public SimpleForwardingClientCallListener(ClientCall.Listener<RespT> listener) {
            this.delegate = listener;
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener
        public ClientCall.Listener<RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onClose(Status status, Metadata metadata) {
            super.onClose(status, metadata);
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onHeaders(Metadata metadata) {
            super.onHeaders(metadata);
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
        public /* bridge */ /* synthetic */ void onReady() {
            super.onReady();
        }

        @Override // io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingClientCallListener
    public abstract ClientCall.Listener<RespT> delegate();

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onClose(Status status, Metadata metadata) {
        super.onClose(status, metadata);
    }

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onHeaders(Metadata metadata) {
        super.onHeaders(metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onMessage(RespT respt) {
        delegate().onMessage(respt);
    }

    @Override // io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
    public /* bridge */ /* synthetic */ void onReady() {
        super.onReady();
    }

    @Override // io.grpc.PartialForwardingClientCallListener
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
