package org.apache.commons.beanutils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConversionException extends RuntimeException {
    private static final long serialVersionUID = 1;

    @Deprecated
    protected Throwable cause;

    public ConversionException(String str) {
        super(str);
    }

    public ConversionException(String str, Throwable th) {
        super(str, th);
        this.cause = th;
    }

    public ConversionException(Throwable th) {
        super(th);
        this.cause = th;
    }
}
