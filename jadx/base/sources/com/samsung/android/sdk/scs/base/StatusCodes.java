package com.samsung.android.sdk.scs.base;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class StatusCodes {
    public static final int EMERGENCY_MODE = 8;
    public static final int ERROR = 2000;
    public static final int FEATURE_UNAVAILABLE = 5;
    public static final int INPUT_INVALID = 700;
    public static final int INPUT_MISSING = 300;
    public static final int REMOTE_EXCEPTION = 500;
    public static final int SERVICE_DISABLED = 2;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 6;
    public static final int SERVICE_UPDATING = 4;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 3;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 7;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int UNDEFINED = -1000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.CLASS)
    public @interface checkFeatureResult {
    }
}
