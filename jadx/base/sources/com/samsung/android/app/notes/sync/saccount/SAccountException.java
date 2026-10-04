package com.samsung.android.app.notes.sync.saccount;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SAccountException extends Exception {
    private String mExceptionCode;

    public SAccountException(String str) {
        this.mExceptionCode = str;
    }

    public String getExceptionCode() {
        return this.mExceptionCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ", eCode : " + this.mExceptionCode;
    }

    public SAccountException(String str, String str2) {
        super(str2);
        this.mExceptionCode = str;
    }

    public SAccountException(String str, Throwable th) {
        super(th);
        this.mExceptionCode = str;
    }

    private SAccountException() {
    }

    public SAccountException(String str, String str2, Throwable th) {
        super(str2, th);
        this.mExceptionCode = str;
    }
}
