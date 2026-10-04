package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSslSessionStats {
    private final ReferenceCountedOpenSslContext context;

    public OpenSslSessionStats(ReferenceCountedOpenSslContext referenceCountedOpenSslContext) {
        this.context = referenceCountedOpenSslContext;
    }

    public long accept() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionAccept(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long acceptGood() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionAcceptGood(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long acceptRenegotiate() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionAcceptRenegotiate(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long cacheFull() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionCacheFull(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long cbHits() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionCbHits(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long connect() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionConnect(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long connectGood() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionConnectGood(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long connectRenegotiate() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionConnectRenegotiate(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long hits() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionHits(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long misses() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionMisses(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long number() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionNumber(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long ticketKeyFail() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionTicketKeyFail(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long ticketKeyNew() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionTicketKeyNew(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long ticketKeyRenew() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionTicketKeyRenew(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long ticketKeyResume() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionTicketKeyResume(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }

    public long timeouts() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.sessionTimeouts(this.context.ctx);
        } finally {
            lock.unlock();
        }
    }
}
