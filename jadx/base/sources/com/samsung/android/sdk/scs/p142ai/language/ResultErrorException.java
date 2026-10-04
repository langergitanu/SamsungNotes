package com.samsung.android.sdk.scs.p142ai.language;

import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.p142ai.language.ErrorClassifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResultErrorException extends ResultException {
    public final int mErrorCode;

    public ResultErrorException(int i) {
        super(i);
        this.mErrorCode = ErrorClassifier.ErrorCode.DEVICE_UNKNOWN_ERROR.ordinal();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public ErrorClassifier.ErrorCode getErrorCodeClassified() {
        return ErrorClassifier.getErrorCode(this.mErrorCode);
    }

    public ResultErrorException(int i, String str) {
        super(i, str);
        this.mErrorCode = ErrorClassifier.ErrorCode.DEVICE_UNKNOWN_ERROR.ordinal();
    }

    public ResultErrorException(int i, int i2, String str) {
        super(i2, str);
        this.mErrorCode = i2;
    }
}
