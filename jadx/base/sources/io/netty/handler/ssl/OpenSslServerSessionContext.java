package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    public OpenSslServerSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        super(referenceCountedOpenSslContext, openSslKeyMaterialProvider, SSL.SSL_SESS_CACHE_SERVER, new OpenSslSessionCache(referenceCountedOpenSslContext.engineMap));
    }

    public boolean setSessionIdContext(byte[] bArr) {
        Lock lockWriteLock = this.context.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            return SSLContext.setSessionIdContext(this.context.ctx, bArr);
        } finally {
            lockWriteLock.unlock();
        }
    }
}
