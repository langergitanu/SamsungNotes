package org.apache.commons.lang3.concurrent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConcurrentException extends Exception {
    private static final long serialVersionUID = 6622707671812226130L;

    public ConcurrentException() {
    }

    public ConcurrentException(String str, Throwable th) {
        super(str, ConcurrentUtils.checkedException(th));
    }

    public ConcurrentException(Throwable th) {
        super(ConcurrentUtils.checkedException(th));
    }
}
