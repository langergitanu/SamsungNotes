package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksSubnegotiationVersion {
    AUTH_PASSWORD((byte) 1),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8922b;

    SocksSubnegotiationVersion(byte b) {
        this.f8922b = b;
    }

    @Deprecated
    public static SocksSubnegotiationVersion fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f8922b;
    }

    public static SocksSubnegotiationVersion valueOf(byte b) {
        for (SocksSubnegotiationVersion socksSubnegotiationVersion : values()) {
            if (socksSubnegotiationVersion.f8922b == b) {
                return socksSubnegotiationVersion;
            }
        }
        return UNKNOWN;
    }
}
