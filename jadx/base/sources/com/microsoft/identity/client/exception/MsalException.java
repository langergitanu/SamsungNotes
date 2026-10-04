package com.microsoft.identity.client.exception;

import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.exception.BaseException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MsalException extends BaseException {
    public MsalException() {
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException, com.microsoft.identity.common.java.exception.IErrorInformation
    public String getErrorCode() {
        return super.getErrorCode();
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException, java.lang.Throwable
    public String getMessage() {
        return !MsalUtils.isEmpty(super.getMessage()) ? super.getMessage() : "";
    }

    public MsalException(String str) {
        super(str);
    }

    public MsalException(String str, String str2) {
        super(str, str2);
    }

    public MsalException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }
}
