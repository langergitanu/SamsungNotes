package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.DefaultAddressedEnvelope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DomainDatagramPacket extends DefaultAddressedEnvelope<ByteBuf, DomainSocketAddress> implements ByteBufHolder {
    public DomainDatagramPacket(ByteBuf byteBuf, DomainSocketAddress domainSocketAddress) {
        super(byteBuf, domainSocketAddress);
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.channel.AddressedEnvelope
    public /* bridge */ /* synthetic */ ByteBuf content() {
        return (ByteBuf) super.content();
    }

    public DomainDatagramPacket(ByteBuf byteBuf, DomainSocketAddress domainSocketAddress, DomainSocketAddress domainSocketAddress2) {
        super(byteBuf, domainSocketAddress, domainSocketAddress2);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket replace(ByteBuf byteBuf) {
        return new DomainDatagramPacket(byteBuf, recipient(), sender());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DomainDatagramPacket retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DomainDatagramPacket touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DomainDatagramPacket retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.channel.DefaultAddressedEnvelope, io.netty.util.ReferenceCounted
    public DomainDatagramPacket touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
