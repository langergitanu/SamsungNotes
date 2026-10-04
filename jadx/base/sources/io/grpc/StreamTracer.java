package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
@ThreadSafe
public abstract class StreamTracer {
    public void inboundMessage(int i) {
    }

    public void inboundMessageRead(int i, long j, long j2) {
    }

    public void inboundUncompressedSize(long j) {
    }

    public void inboundWireSize(long j) {
    }

    public void outboundMessage(int i) {
    }

    public void outboundMessageSent(int i, long j, long j2) {
    }

    public void outboundUncompressedSize(long j) {
    }

    public void outboundWireSize(long j) {
    }

    public void streamClosed(Status status) {
    }
}
