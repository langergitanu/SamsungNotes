package io.netty.handler.codec.compression;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ZstdOptions implements CompressionOptions {
    static final ZstdOptions DEFAULT = new ZstdOptions(3, 65536, 33554432);
    private final int blockSize;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdOptions(int i, int i2, int i4) {
        if (!Zstd.isAvailable()) {
            throw new IllegalStateException("zstd-jni is not available", Zstd.cause());
        }
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(i2, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(i4, "maxEncodeSize");
    }

    public int blockSize() {
        return this.blockSize;
    }

    public int compressionLevel() {
        return this.compressionLevel;
    }

    public int maxEncodeSize() {
        return this.maxEncodeSize;
    }
}
