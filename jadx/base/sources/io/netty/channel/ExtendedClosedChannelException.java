package io.netty.channel;

import java.nio.channels.ClosedChannelException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class ExtendedClosedChannelException extends ClosedChannelException {
    public ExtendedClosedChannelException(Throwable th) {
        if (th != null) {
            initCause(th);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
