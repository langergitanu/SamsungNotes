package com.microsoft.identity.common.java.exception;

import javax.annotation.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UnsupportedBrokerException extends BaseException {

    @NonNull
    private final String mActiveBrokerPackageName;

    public UnsupportedBrokerException(@NonNull String str) {
        this(str, ErrorStrings.UNSUPPORTED_BROKER_VERSION_ERROR_CODE, ErrorStrings.UNSUPPORTED_BROKER_VERSION_ERROR_MESSAGE);
        if (str == null) {
            throw new NullPointerException("activeBrokerPackageName is marked non-null but is null");
        }
    }

    @NonNull
    public String getActiveBrokerPackageName() {
        return this.mActiveBrokerPackageName;
    }

    public UnsupportedBrokerException(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        super(str2, str3);
        if (str == null) {
            throw new NullPointerException("activeBrokerPackageName is marked non-null but is null");
        }
        if (str2 != null) {
            this.mActiveBrokerPackageName = str;
            return;
        }
        throw new NullPointerException("errorCode is marked non-null but is null");
    }
}
