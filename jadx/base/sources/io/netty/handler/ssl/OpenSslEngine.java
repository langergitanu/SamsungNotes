package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    public OpenSslEngine(OpenSslContext openSslContext, ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        super(openSslContext, byteBufAllocator, str, i, z, false);
    }

    public void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
