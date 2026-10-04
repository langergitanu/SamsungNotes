package com.samsung.android.sdk.scs.p142ai.visual;

import java.util.Arrays;
import p074R1.C0231c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum VisualErrorCode {
    MODEL_NOT_FOUND(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.MODEL_NOT_FOUND.getCode()),
    NOT_SPECIFIED(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.NOT_SPECIFIED.getCode()),
    RESOURCE_BUSY(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.RESOURCE_BUSY.getCode()),
    REQUEST_CANCELED(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.REQUEST_CANCELED.getCode()),
    TIME_OUT(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.TIME_OUT.getCode()),
    NETWORK_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.NETWORK_ERROR.getCode()),
    INPUT_DATA_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.INPUT_DATA_ERROR.getCode()),
    MISSING_MANDATORY_FIELD(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.MISSING_MANDATORY_FIELD.getCode()),
    EXCEED_RATE_LIMIT(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.EXCEED_RATE_LIMIT.getCode()),
    SERVICE_EXCEPTION(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.SERVICE_EXCEPTION.getCode()),
    CLIENT_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.CLIENT_ERROR.getCode()),
    AUTH_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.AUTH_ERROR.getCode()),
    AUTH_SA_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.AUTH_SA_ERROR.getCode()),
    SERVER_QUOTA_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.SERVER_QUOTA_ERROR.getCode()),
    SAFETY_FILTER_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.SAFETY_FILTER_ERROR.getCode()),
    SERVER_ERROR(com.samsung.android.visual.p167ai.sdkcommon.VisualErrorCode.SERVER_ERROR.getCode());

    private final int code;

    VisualErrorCode(int i) {
        this.code = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$toCoreErrorCode$0(int i, VisualErrorCode visualErrorCode) {
        return visualErrorCode.code == i;
    }

    public static VisualErrorCode toCoreErrorCode(int i) {
        return (VisualErrorCode) Arrays.stream(values()).filter(new C0231c(i, 3)).findFirst().orElse(SERVER_ERROR);
    }

    public static VisualErrorCode toErrorCode(int i) {
        int i2 = i / 1000;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 5 ? (i2 == 8 || i2 == 9) ? SERVER_ERROR : SERVER_ERROR : SAFETY_FILTER_ERROR : SERVER_QUOTA_ERROR : (i == 2200 || i == 2201) ? AUTH_SA_ERROR : AUTH_ERROR : CLIENT_ERROR : toCoreErrorCode(i);
    }

    public int getCode() {
        return this.code;
    }
}
