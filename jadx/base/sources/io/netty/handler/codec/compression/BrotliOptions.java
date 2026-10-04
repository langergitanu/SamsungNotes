package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class BrotliOptions implements CompressionOptions {
    static final BrotliOptions DEFAULT = new BrotliOptions(new Encoder.Parameters().setQuality(4).setMode(Encoder.Mode.TEXT));
    private final Encoder.Parameters parameters;

    public BrotliOptions(Encoder.Parameters parameters) {
        if (!Brotli.isAvailable()) {
            throw new IllegalStateException("Brotli is not available", Brotli.cause());
        }
        this.parameters = (Encoder.Parameters) ObjectUtil.checkNotNull(parameters, "Parameters");
    }

    public Encoder.Parameters parameters() {
        return this.parameters;
    }
}
