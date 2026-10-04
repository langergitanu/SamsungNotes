package com.samsung.android.sdk.scs.p142ai.language;

import com.sun.imageio.plugins.jpeg.JPEG;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ErrorClassifier {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorCode {
        DEVICE_ERROR(100),
        DEVICE_NETWORK_ERROR(101),
        DEVICE_INIT_ERROR(102),
        DEVICE_WATCH_CONNECTION_ERROR(180),
        DEVICE_WATCH_DATA_LAYER_ERROR(181),
        DEVICE_WATCH_ON_DEVICE_PACKAGE_ERROR(182),
        DEVICE_WATCH_INTERNAL_ERROR(183),
        DEVICE_WATCH_NOT_SUPPORT_TASK_ERROR(184),
        DEVICE_UNKNOWN_ERROR(199),
        DEVICE_EXCEED_RATE_LIMIT(250),
        CLIENT_ERROR(200),
        CLIENT_ERROR_INVALID_REQUEST_TYPE(201),
        CLIENT_ERROR_MANDATORY_FIELD_MISSING(210),
        CLIENT_ERROR_INPUT_TOO_LONG(211),
        CLIENT_ERROR_UNSUPPORTED_DEVICE(220),
        CLIENT_ERROR_BUSY(JPEG.DRI),
        CLIENT_ERROR_CANCEL(JPEG.DHP),
        CLIENT_ERROR_UNSUPPORTED_LANGUAGE(230),
        CLIENT_ERROR_KERNEL_UPDATE_REQUIRED(240),
        CLIENT_ERROR_MODEL_UPDATE_REQUIRED(241),
        AUTH_ERROR(300),
        AUTH_SA_ERROR(301),
        SAFETY_FILTER_ERROR(400),
        SAFETY_FILTER_UNSUPPORTED_LANGUAGE_ERROR(401),
        SAFETY_FILTER_RECITATION_ERROR(402),
        SAFETY_FILTER_TOXIC_ERROR(403),
        SERVER_ERROR(500),
        SERVER_QUOTA_ERROR(501),
        SERVER_INTERNAL_ERROR(502),
        SERVER_UNVAILABLE(503);

        private final int mError;

        ErrorCode(int i) {
            this.mError = i;
        }
    }

    public static ErrorCode getErrorCode(int i) {
        int i2 = i / 1000;
        if (i >= 1 && i <= 16) {
            return ErrorCode.DEVICE_NETWORK_ERROR;
        }
        if (i == 102) {
            return ErrorCode.DEVICE_INIT_ERROR;
        }
        if (i == 180) {
            return ErrorCode.DEVICE_WATCH_CONNECTION_ERROR;
        }
        if (i == 181) {
            return ErrorCode.DEVICE_WATCH_DATA_LAYER_ERROR;
        }
        if (i == 182) {
            return ErrorCode.DEVICE_WATCH_ON_DEVICE_PACKAGE_ERROR;
        }
        if (i == 183) {
            return ErrorCode.DEVICE_WATCH_INTERNAL_ERROR;
        }
        if (i == 184) {
            return ErrorCode.DEVICE_WATCH_NOT_SUPPORT_TASK_ERROR;
        }
        if (i == 250) {
            return ErrorCode.DEVICE_EXCEED_RATE_LIMIT;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return (i == 2200 || i == 2201) ? ErrorCode.AUTH_SA_ERROR : ErrorCode.AUTH_ERROR;
            }
            if (i2 == 4) {
                return ErrorCode.SERVER_QUOTA_ERROR;
            }
            if (i2 != 5) {
                return (i2 == 8 || i2 == 9) ? i != 9000 ? i != 9001 ? ErrorCode.SERVER_ERROR : ErrorCode.SERVER_UNVAILABLE : ErrorCode.SERVER_INTERNAL_ERROR : ErrorCode.DEVICE_UNKNOWN_ERROR;
            }
            if (i != 5120) {
                if (i != 5152) {
                    if (i == 5210) {
                        return ErrorCode.SAFETY_FILTER_RECITATION_ERROR;
                    }
                    if (i != 5220) {
                        if (i != 5252) {
                            return ErrorCode.SAFETY_FILTER_ERROR;
                        }
                    }
                }
                return ErrorCode.SAFETY_FILTER_TOXIC_ERROR;
            }
            return ErrorCode.SAFETY_FILTER_UNSUPPORTED_LANGUAGE_ERROR;
        }
        if (i == 1010) {
            return ErrorCode.CLIENT_ERROR_INVALID_REQUEST_TYPE;
        }
        if (i == 1024) {
            return ErrorCode.CLIENT_ERROR_MANDATORY_FIELD_MISSING;
        }
        if (i == 1026) {
            return ErrorCode.CLIENT_ERROR_INPUT_TOO_LONG;
        }
        if (i == 1900) {
            return ErrorCode.CLIENT_ERROR_UNSUPPORTED_LANGUAGE;
        }
        if (i == 1107) {
            return ErrorCode.CLIENT_ERROR_KERNEL_UPDATE_REQUIRED;
        }
        if (i == 1108) {
            return ErrorCode.CLIENT_ERROR_MODEL_UPDATE_REQUIRED;
        }
        switch (i) {
            case 1097:
                return ErrorCode.CLIENT_ERROR_UNSUPPORTED_DEVICE;
            case 1098:
                return ErrorCode.CLIENT_ERROR_BUSY;
            case 1099:
                return ErrorCode.CLIENT_ERROR_CANCEL;
            default:
                return ErrorCode.CLIENT_ERROR;
        }
    }
}
