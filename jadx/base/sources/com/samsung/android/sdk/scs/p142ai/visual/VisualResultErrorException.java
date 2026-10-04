package com.samsung.android.sdk.scs.p142ai.visual;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.ResultException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class VisualResultErrorException extends ResultException {
    private final VisualErrorCode mErrorCode;

    public VisualResultErrorException(int i, String str) {
        super(i, str);
        this.mErrorCode = VisualErrorCode.toErrorCode(i);
    }

    public VisualErrorCode getErrorCode() {
        return this.mErrorCode;
    }

    public int getServerErrorCode() {
        return getResultCode();
    }

    @Override // java.lang.Throwable
    @NonNull
    public String toString() {
        return super.toString() + ", errorCode=" + this.mErrorCode + ", serverErrorCode=" + getServerErrorCode();
    }
}
