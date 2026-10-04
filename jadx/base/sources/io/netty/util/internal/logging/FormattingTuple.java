package io.netty.util.internal.logging;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class FormattingTuple {
    private final String message;
    private final Throwable throwable;

    public FormattingTuple(String str, Throwable th) {
        this.message = str;
        this.throwable = th;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
