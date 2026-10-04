package io.netty.handler.codec.compression;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class GzipOptions extends DeflateOptions {
    static final GzipOptions DEFAULT = new GzipOptions(6, 15, 8);

    public GzipOptions(int i, int i2, int i4) {
        super(i, i2, i4);
    }
}
