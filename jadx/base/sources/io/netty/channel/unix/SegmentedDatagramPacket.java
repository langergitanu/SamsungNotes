package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SegmentedDatagramPacket extends DatagramPacket {
    private final int segmentSize;

    public SegmentedDatagramPacket(ByteBuf byteBuf, int i, InetSocketAddress inetSocketAddress) {
        super(byteBuf, inetSocketAddress);
        this.segmentSize = ObjectUtil.checkPositive(i, "segmentSize");
    }

    public int segmentSize() {
        return this.segmentSize;
    }

    public SegmentedDatagramPacket(ByteBuf byteBuf, int i, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super(byteBuf, inetSocketAddress, inetSocketAddress2);
        this.segmentSize = ObjectUtil.checkPositive(i, "segmentSize");
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket copy() {
        return new SegmentedDatagramPacket(content().copy(), this.segmentSize, recipient(), sender());
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket duplicate() {
        return new SegmentedDatagramPacket(content().duplicate(), this.segmentSize, recipient(), sender());
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket replace(ByteBuf byteBuf) {
        return new SegmentedDatagramPacket(byteBuf, this.segmentSize, recipient(), sender());
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket retainedDuplicate() {
        return new SegmentedDatagramPacket(content().retainedDuplicate(), this.segmentSize, recipient(), sender());
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.channel.socket.DatagramPacket, io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
