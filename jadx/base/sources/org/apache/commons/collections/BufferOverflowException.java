package org.apache.commons.collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BufferOverflowException extends RuntimeException {
    private final Throwable throwable;

    public BufferOverflowException() {
        this.throwable = null;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.throwable;
    }

    public BufferOverflowException(String str) {
        this(str, null);
    }

    public BufferOverflowException(String str, Throwable th) {
        super(str);
        this.throwable = th;
    }
}
