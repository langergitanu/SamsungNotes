package io.netty.handler.codec.socksx;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8923b;

    SocksVersion(byte b) {
        this.f8923b = b;
    }

    public byte byteValue() {
        return this.f8923b;
    }

    public static SocksVersion valueOf(byte b) {
        SocksVersion socksVersion = SOCKS4a;
        if (b == socksVersion.byteValue()) {
            return socksVersion;
        }
        SocksVersion socksVersion2 = SOCKS5;
        return b == socksVersion2.byteValue() ? socksVersion2 : UNKNOWN;
    }
}
