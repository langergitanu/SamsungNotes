package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class BlockingOperationException extends IllegalStateException {
    private static final long serialVersionUID = 2462223247762460301L;

    public BlockingOperationException() {
    }

    public BlockingOperationException(String str) {
        super(str);
    }

    public BlockingOperationException(Throwable th) {
        super(th);
    }

    public BlockingOperationException(String str, Throwable th) {
        super(str, th);
    }
}
