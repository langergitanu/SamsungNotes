package com.samsung.android.app.notes.sync.modelerror;

import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ShareException extends Exception {
    private static final long serialVersionUID = 1;
    private ShareConstants$ResultCode mExceptionCode;

    public ShareException(ShareConstants$ResultCode shareConstants$ResultCode) {
        this.mExceptionCode = shareConstants$ResultCode;
    }

    public ShareConstants$ResultCode getExceptionCode() {
        return this.mExceptionCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ", eCode : " + this.mExceptionCode;
    }

    public ShareException(ShareConstants$ResultCode shareConstants$ResultCode, String str) {
        super(str);
        this.mExceptionCode = shareConstants$ResultCode;
    }

    public ShareException(ShareConstants$ResultCode shareConstants$ResultCode, Throwable th) {
        super(th);
        this.mExceptionCode = shareConstants$ResultCode;
    }

    public ShareException(ShareConstants$ResultCode shareConstants$ResultCode, String str, Throwable th) {
        super(str, th);
        this.mExceptionCode = shareConstants$ResultCode;
    }
}
