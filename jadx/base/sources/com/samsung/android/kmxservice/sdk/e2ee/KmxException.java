package com.samsung.android.kmxservice.sdk.e2ee;

import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxException extends Exception {
    private int mErrorCode;

    public KmxException() {
        this.mErrorCode = -1;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public KmxException(String str) {
        super(str);
        this.mErrorCode = -1;
    }

    public KmxException(String str, Throwable th) {
        super(str, th);
        this.mErrorCode = -1;
    }

    public KmxException(Throwable th) {
        super(th);
        this.mErrorCode = -1;
    }

    public KmxException(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    @RequiresApi(api = 24)
    public KmxException(String str, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
        this.mErrorCode = -1;
    }
}
