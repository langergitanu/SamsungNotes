package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class WriteTimeoutException extends TimeoutException {
    public static final WriteTimeoutException INSTANCE;
    private static final long serialVersionUID = -144786655770296065L;

    static {
        INSTANCE = PlatformDependent.javaVersion() >= 7 ? new WriteTimeoutException(true) : new WriteTimeoutException();
    }

    public WriteTimeoutException() {
    }

    public WriteTimeoutException(String str) {
        super(str, false);
    }

    private WriteTimeoutException(boolean z) {
        super(null, z);
    }
}
