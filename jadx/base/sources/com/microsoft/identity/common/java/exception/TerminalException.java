package com.microsoft.identity.common.java.exception;

import javax.annotation.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TerminalException extends RuntimeException implements IErrorInformation {
    private final String mErrorCode;

    public TerminalException(@Nullable String str, @NonNull Throwable th, @NonNull String str2) {
        super(str, th);
        if (th == null) {
            throw new NullPointerException("cause is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        this.mErrorCode = str2;
    }

    @Override // com.microsoft.identity.common.java.exception.IErrorInformation
    public String getErrorCode() {
        return this.mErrorCode;
    }

    public TerminalException(@NonNull Throwable th, @NonNull String str) {
        super(th);
        if (th == null) {
            throw new NullPointerException("cause is marked non-null but is null");
        }
        if (str != null) {
            this.mErrorCode = str;
            return;
        }
        throw new NullPointerException("errorCode is marked non-null but is null");
    }

    public TerminalException(@NonNull String str) {
        if (str != null) {
            this.mErrorCode = str;
            return;
        }
        throw new NullPointerException("errorCode is marked non-null but is null");
    }

    public TerminalException(@Nullable String str, @NonNull String str2) {
        super(str);
        if (str2 != null) {
            this.mErrorCode = str2;
            return;
        }
        throw new NullPointerException("errorCode is marked non-null but is null");
    }
}
