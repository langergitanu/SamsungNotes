package io.netty.channel.unix;

import io.netty.util.CharsetUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DomainDatagramSocketAddress extends DomainSocketAddress {
    private static final long serialVersionUID = -5925732678737768223L;
    private final DomainDatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DomainDatagramSocketAddress(byte[] bArr, int i, DomainDatagramSocketAddress domainDatagramSocketAddress) {
        super(new String(bArr, CharsetUtil.UTF_8));
        this.localAddress = domainDatagramSocketAddress;
        this.receivedAmount = i;
    }

    public DomainDatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
