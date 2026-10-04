package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksCmdType {
    CONNECT((byte) 1),
    BIND((byte) 2),
    UDP((byte) 3),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8918b;

    SocksCmdType(byte b) {
        this.f8918b = b;
    }

    @Deprecated
    public static SocksCmdType fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f8918b;
    }

    public static SocksCmdType valueOf(byte b) {
        for (SocksCmdType socksCmdType : values()) {
            if (socksCmdType.f8918b == b) {
                return socksCmdType;
            }
        }
        return UNKNOWN;
    }
}
