package com.microsoft.identity.common.java.exception;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class UserCancelException extends BaseException {
    public static final String sName = "com.microsoft.identity.common.exception.UserCancelException";
    private static final long serialVersionUID = 5184560527352649832L;

    public UserCancelException() {
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }

    public UserCancelException(String str, String str2) {
        super(str, str2);
    }
}
