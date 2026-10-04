package io.netty.handler.codec.compression;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DeflateOptions implements CompressionOptions {
    static final DeflateOptions DEFAULT = new DeflateOptions(6, 15, 8);
    private final int compressionLevel;
    private final int memLevel;
    private final int windowBits;

    public DeflateOptions(int i, int i2, int i4) {
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        this.windowBits = ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        this.memLevel = ObjectUtil.checkInRange(i4, 1, 9, "memLevel");
    }

    public int compressionLevel() {
        return this.compressionLevel;
    }

    public int memLevel() {
        return this.memLevel;
    }

    public int windowBits() {
        return this.windowBits;
    }
}
