package io.netty.handler.codec.spdy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum SpdyVersion {
    SPDY_3_1(3, 1);

    private final int minorVersion;
    private final int version;

    SpdyVersion(int i, int i2) {
        this.version = i;
        this.minorVersion = i2;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getVersion() {
        return this.version;
    }
}
