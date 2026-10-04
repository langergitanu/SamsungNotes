package com.samsung.android.sdk.scs.base;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResultException extends RuntimeException {
    public final int mResultCode;

    public ResultException(int i) {
        this.mResultCode = i;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public ResultException(int i, String str) {
        super(str);
        this.mResultCode = i;
    }
}
