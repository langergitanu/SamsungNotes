package io.netty.handler.ssl;

import io.netty.util.internal.ThrowableUtil;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class StacklessSSLHandshakeException extends SSLHandshakeException {
    private static final long serialVersionUID = -1244781947804415549L;

    private StacklessSSLHandshakeException(String str) {
        super(str);
    }

    public static StacklessSSLHandshakeException newInstance(String str, Class<?> cls, String str2) {
        return (StacklessSSLHandshakeException) ThrowableUtil.unknownStackTrace(new StacklessSSLHandshakeException(str), cls, str2);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
