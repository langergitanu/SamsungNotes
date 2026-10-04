package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class SquelchLateMessagesAvailableDeframerListener extends ForwardingDeframerListener {
    private boolean closed;
    private final MessageDeframer.Listener delegate;

    public SquelchLateMessagesAvailableDeframerListener(MessageDeframer.Listener listener) {
        this.delegate = listener;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable th) {
        this.closed = true;
        super.deframeFailed(th);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean z) {
        this.closed = true;
        super.deframerClosed(z);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener
    public MessageDeframer.Listener delegate() {
        return this.delegate;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        if (!this.closed) {
            super.messagesAvailable(messageProducer);
        } else if (messageProducer instanceof Closeable) {
            GrpcUtil.closeQuietly((Closeable) messageProducer);
        }
    }
}
