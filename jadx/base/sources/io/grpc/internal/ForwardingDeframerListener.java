package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class ForwardingDeframerListener implements MessageDeframer.Listener {
    @Override // io.grpc.internal.MessageDeframer.Listener
    public void bytesRead(int i) {
        delegate().bytesRead(i);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable th) {
        delegate().deframeFailed(th);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean z) {
        delegate().deframerClosed(z);
    }

    public abstract MessageDeframer.Listener delegate();

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        delegate().messagesAvailable(messageProducer);
    }
}
