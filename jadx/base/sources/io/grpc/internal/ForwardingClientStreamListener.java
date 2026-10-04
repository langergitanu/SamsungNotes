package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class ForwardingClientStreamListener implements ClientStreamListener {
    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
        delegate().closed(status, rpcProgress, metadata);
    }

    public abstract ClientStreamListener delegate();

    @Override // io.grpc.internal.ClientStreamListener
    public void headersRead(Metadata metadata) {
        delegate().headersRead(metadata);
    }

    @Override // io.grpc.internal.StreamListener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        delegate().messagesAvailable(messageProducer);
    }

    @Override // io.grpc.internal.StreamListener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
