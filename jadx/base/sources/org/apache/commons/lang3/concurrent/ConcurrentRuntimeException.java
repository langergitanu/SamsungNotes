package org.apache.commons.lang3.concurrent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConcurrentRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6582182735562919670L;

    public ConcurrentRuntimeException() {
    }

    public ConcurrentRuntimeException(String str, Throwable th) {
        super(str, ConcurrentUtils.checkedException(th));
    }

    public ConcurrentRuntimeException(Throwable th) {
        super(ConcurrentUtils.checkedException(th));
    }
}
