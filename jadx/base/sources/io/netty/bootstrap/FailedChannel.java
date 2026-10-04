package io.netty.bootstrap;

import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class FailedChannel extends AbstractChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private final ChannelConfig config;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class FailedChannelUnsafe extends AbstractChannel.AbstractUnsafe {
        private FailedChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        }
    }

    public FailedChannel() {
        super(null);
        this.config = new DefaultChannelConfig(this);
    }

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBeginRead() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doClose() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return false;
    }

    @Override // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop) {
        return false;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return false;
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return null;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel
    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new FailedChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return null;
    }
}
