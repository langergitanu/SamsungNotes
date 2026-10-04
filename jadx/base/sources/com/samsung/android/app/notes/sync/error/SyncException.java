package com.samsung.android.app.notes.sync.error;

import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SyncException extends Exception {
    private static final long serialVersionUID = 1;
    private final int mExceptionCode;
    private SpenUnsupportedTypeException mSpenUnsupportedTypeException;
    private int mStatusCode;

    public SyncException(int i) {
        this.mExceptionCode = i;
    }

    public int getExceptionCode() {
        return this.mExceptionCode;
    }

    public SpenUnsupportedTypeException getSpenUnsupportedTypeException() {
        return this.mSpenUnsupportedTypeException;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setSpenUnsupportedTypeException(SpenUnsupportedTypeException spenUnsupportedTypeException) {
        this.mSpenUnsupportedTypeException = spenUnsupportedTypeException;
    }

    public void setStatusCode(int i) {
        this.mStatusCode = i;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ", eCode : " + this.mExceptionCode;
    }

    public SyncException(int i, String str) {
        super(str);
        this.mExceptionCode = i;
    }

    public SyncException(int i, Throwable th) {
        super(th);
        this.mExceptionCode = i;
    }

    public SyncException(int i, String str, Throwable th) {
        super(str, th);
        this.mExceptionCode = i;
    }
}
