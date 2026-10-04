package com.adobe.internal.xmp;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPException extends Exception {
    private int errorCode;

    public XMPException(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public XMPException(String str, int i, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }
}
