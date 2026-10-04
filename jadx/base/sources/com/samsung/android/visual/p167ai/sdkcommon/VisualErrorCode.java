package com.samsung.android.visual.p167ai.sdkcommon;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import p074R1.C0231c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public enum VisualErrorCode {
    MODEL_NOT_FOUND(-2),
    NOT_SPECIFIED(2),
    RESOURCE_BUSY(16),
    REQUEST_CANCELED(17),
    TIME_OUT(101),
    NETWORK_ERROR(102),
    INPUT_DATA_ERROR(103),
    EXCEED_RATE_LIMIT(250),
    MISSING_MANDATORY_FIELD(300),
    SERVICE_EXCEPTION(500),
    CLIENT_ERROR(1000),
    AUTH_ERROR(2000),
    AUTH_SA_ERROR(2200),
    SERVER_QUOTA_ERROR(4000),
    SAFETY_FILTER_ERROR(5000),
    SERVER_ERROR(9000);

    private final int code;

    VisualErrorCode(int i) {
        this.code = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toCoreErrorCode$0(int i, VisualErrorCode visualErrorCode) {
        return visualErrorCode.code == i;
    }

    public static VisualErrorCode toCoreErrorCode(int i) {
        return (VisualErrorCode) Arrays.stream(values()).filter(new C0231c(i, 4)).findFirst().orElse(SERVER_ERROR);
    }

    public static VisualErrorCode toErrorCode(int i) {
        int i2 = i / 1000;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 5 ? (i2 == 8 || i2 == 9) ? SERVER_ERROR : SERVER_ERROR : SAFETY_FILTER_ERROR : SERVER_QUOTA_ERROR : (i == 2200 || i == 2201) ? AUTH_SA_ERROR : AUTH_ERROR : CLIENT_ERROR : toCoreErrorCode(i);
    }

    public int getCode() {
        return this.code;
    }
}
