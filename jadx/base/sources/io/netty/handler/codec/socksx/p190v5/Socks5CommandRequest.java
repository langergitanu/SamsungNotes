package io.netty.handler.codec.socksx.p190v5;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Socks5CommandRequest extends Socks5Message {
    String dstAddr();

    Socks5AddressType dstAddrType();

    int dstPort();

    Socks5CommandType type();
}
