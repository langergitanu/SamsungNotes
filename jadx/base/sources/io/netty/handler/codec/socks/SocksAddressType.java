package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksAddressType {
    IPv4((byte) 1),
    DOMAIN((byte) 3),
    IPv6((byte) 4),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8910b;

    SocksAddressType(byte b) {
        this.f8910b = b;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f8910b;
    }

    public static SocksAddressType valueOf(byte b) {
        for (SocksAddressType socksAddressType : values()) {
            if (socksAddressType.f8910b == b) {
                return socksAddressType;
            }
        }
        return UNKNOWN;
    }
}
