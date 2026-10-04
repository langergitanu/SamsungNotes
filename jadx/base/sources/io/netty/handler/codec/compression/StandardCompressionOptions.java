package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class StandardCompressionOptions {
    private StandardCompressionOptions() {
    }

    public static BrotliOptions brotli() {
        return BrotliOptions.DEFAULT;
    }

    public static DeflateOptions deflate() {
        return DeflateOptions.DEFAULT;
    }

    public static GzipOptions gzip() {
        return GzipOptions.DEFAULT;
    }

    public static ZstdOptions zstd() {
        return ZstdOptions.DEFAULT;
    }

    public static BrotliOptions brotli(Encoder.Parameters parameters) {
        return new BrotliOptions(parameters);
    }

    public static DeflateOptions deflate(int i, int i2, int i4) {
        return new DeflateOptions(i, i2, i4);
    }

    public static GzipOptions gzip(int i, int i2, int i4) {
        return new GzipOptions(i, i2, i4);
    }

    public static ZstdOptions zstd(int i, int i2, int i4) {
        return new ZstdOptions(i, i2, i4);
    }
}
