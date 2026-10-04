package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksAuthStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8914b;

    SocksAuthStatus(byte b) {
        this.f8914b = b;
    }

    @Deprecated
    public static SocksAuthStatus fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f8914b;
    }

    public static SocksAuthStatus valueOf(byte b) {
        for (SocksAuthStatus socksAuthStatus : values()) {
            if (socksAuthStatus.f8914b == b) {
                return socksAuthStatus;
            }
        }
        return FAILURE;
    }
}
