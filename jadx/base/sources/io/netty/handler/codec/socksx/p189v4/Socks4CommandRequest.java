package io.netty.handler.codec.socksx.p189v4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Socks4CommandRequest extends Socks4Message {
    String dstAddr();

    int dstPort();

    Socks4CommandType type();

    String userId();
}
