package com.microsoft.identity.client.exception;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class MsalUiRequiredException extends MsalException {
    public static final String INVALID_GRANT = "invalid_grant";
    public static final String NO_ACCOUNT_FOUND = "no_account_found";
    public static final String NO_TOKENS_FOUND = "no_tokens_found";

    @Nullable
    private String mOauthSubErrorCode;

    public MsalUiRequiredException(String str) {
        super(str);
    }

    @Nullable
    public String getOauthSubErrorCode() {
        return this.mOauthSubErrorCode;
    }

    public MsalUiRequiredException(String str, String str2) {
        super(str, str2);
    }

    public MsalUiRequiredException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public MsalUiRequiredException(String str, @Nullable String str2, String str3) {
        super(str, str3);
        this.mOauthSubErrorCode = str2;
    }
}
