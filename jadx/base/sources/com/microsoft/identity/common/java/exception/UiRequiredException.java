package com.microsoft.identity.common.java.exception;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class UiRequiredException extends ServiceException {
    public static final String sName = "com.microsoft.identity.common.exception.UiRequiredException";
    private static final long serialVersionUID = 3039442374738287255L;

    public UiRequiredException(String str, String str2) {
        super(str, str2, null);
    }

    @Override // com.microsoft.identity.common.java.exception.ServiceException, com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }

    public UiRequiredException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }
}
