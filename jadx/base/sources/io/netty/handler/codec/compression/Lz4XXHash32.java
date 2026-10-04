package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Lz4XXHash32 extends ByteBufChecksum {
    private static final XXHash32 XXHASH32 = XXHashFactory.fastestInstance().hash32();
    private final int seed;
    private boolean used;
    private int value;

    public Lz4XXHash32(int i) {
        this.seed = i;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        if (this.used) {
            return ((long) this.value) & 268435455;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.used = false;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        if (this.used) {
            throw new IllegalStateException();
        }
        this.value = XXHASH32.hash(bArr, i, i2, this.seed);
        this.used = true;
    }

    @Override // io.netty.handler.codec.compression.ByteBufChecksum
    public void update(ByteBuf byteBuf, int i, int i2) {
        if (!this.used) {
            if (byteBuf.hasArray()) {
                this.value = XXHASH32.hash(byteBuf.array(), byteBuf.arrayOffset() + i, i2, this.seed);
            } else {
                this.value = XXHASH32.hash(CompressionUtil.safeNioBuffer(byteBuf, i, i2), this.seed);
            }
            this.used = true;
            return;
        }
        throw new IllegalStateException();
    }
}
