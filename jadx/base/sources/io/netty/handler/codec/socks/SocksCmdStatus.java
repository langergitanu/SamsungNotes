package io.netty.handler.codec.socks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SocksCmdStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) 1),
    FORBIDDEN((byte) 2),
    NETWORK_UNREACHABLE((byte) 3),
    HOST_UNREACHABLE((byte) 4),
    REFUSED((byte) 5),
    TTL_EXPIRED((byte) 6),
    COMMAND_NOT_SUPPORTED((byte) 7),
    ADDRESS_NOT_SUPPORTED((byte) 8),
    UNASSIGNED((byte) -1);


    /* JADX INFO: renamed from: b */
    private final byte f8917b;

    SocksCmdStatus(byte b) {
        this.f8917b = b;
    }

    @Deprecated
    public static SocksCmdStatus fromByte(byte b) {
        return valueOf(b);
    }

    public byte byteValue() {
        return this.f8917b;
    }

    public static SocksCmdStatus valueOf(byte b) {
        for (SocksCmdStatus socksCmdStatus : values()) {
            if (socksCmdStatus.f8917b == b) {
                return socksCmdStatus;
            }
        }
        return UNASSIGNED;
    }
}
