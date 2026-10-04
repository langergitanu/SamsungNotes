package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksAuthScheme {
    NO_AUTH((byte) 0),
    AUTH_GSSAPI((byte) 1),
    AUTH_PASSWORD((byte) 2),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8913b;

    SocksAuthScheme(byte b) {
        this.f8913b = b;
    }

    @Deprecated
    public static SocksAuthScheme fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f8913b;
    }

    public static SocksAuthScheme valueOf(byte b) {
        for (SocksAuthScheme socksAuthScheme : values()) {
            if (socksAuthScheme.f8913b == b) {
                return socksAuthScheme;
            }
        }
        return UNKNOWN;
    }
}
