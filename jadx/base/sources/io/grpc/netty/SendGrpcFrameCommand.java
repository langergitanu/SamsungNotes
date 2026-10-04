package io.grpc.netty;

import io.grpc.netty.WriteQueue;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;
import io.perfmark.Link;
import io.perfmark.PerfMark;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class SendGrpcFrameCommand extends DefaultByteBufHolder implements WriteQueue.QueuedCommand {
    private final boolean endStream;
    private final Link link;
    private ChannelPromise promise;
    private final StreamIdHolder stream;

    public SendGrpcFrameCommand(StreamIdHolder streamIdHolder, ByteBuf byteBuf, boolean z) {
        super(byteBuf);
        this.stream = streamIdHolder;
        this.endStream = z;
        this.link = PerfMark.linkOut();
    }

    public boolean endStream() {
        return this.endStream;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(SendGrpcFrameCommand.class)) {
            SendGrpcFrameCommand sendGrpcFrameCommand = (SendGrpcFrameCommand) obj;
            if (sendGrpcFrameCommand.stream.equals(this.stream) && sendGrpcFrameCommand.endStream == this.endStream && sendGrpcFrameCommand.content().equals(content())) {
                return true;
            }
        }
        return false;
    }

    @Override // io.grpc.netty.WriteQueue.QueuedCommand
    public Link getLink() {
        return this.link;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        int iHashCode = this.stream.hashCode() + (content().hashCode() * 31);
        return this.endStream ? -iHashCode : iHashCode;
    }

    @Override // io.grpc.netty.WriteQueue.QueuedCommand
    public ChannelPromise promise() {
        return this.promise;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf) {
        return new SendGrpcFrameCommand(this.stream, byteBuf, this.endStream);
    }

    @Override // io.grpc.netty.WriteQueue.QueuedCommand
    public final void run(Channel channel) {
        channel.write(this, this.promise);
    }

    public StreamIdHolder stream() {
        return this.stream;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return "SendGrpcFrameCommand(streamId=" + this.stream.mo13754id() + ", endStream=" + this.endStream + ", content=" + content() + ")";
    }

    @Override // io.grpc.netty.WriteQueue.QueuedCommand
    public void promise(ChannelPromise channelPromise) {
        this.promise = channelPromise;
    }
}
