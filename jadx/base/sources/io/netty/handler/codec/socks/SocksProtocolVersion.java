package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksProtocolVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8921b;

    SocksProtocolVersion(byte b) {
        this.f8921b = b;
    }

    @Deprecated
    public static SocksProtocolVersion fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f8921b;
    }

    public static SocksProtocolVersion valueOf(byte b) {
        for (SocksProtocolVersion socksProtocolVersion : values()) {
            if (socksProtocolVersion.f8921b == b) {
                return socksProtocolVersion;
            }
        }
        return UNKNOWN;
    }
}
