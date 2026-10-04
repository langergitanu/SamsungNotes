package com.samsung.android.support.senl.p148nt.model.importer.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PDFException extends RuntimeException {
    private final int mErrorCode;

    public PDFException(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
