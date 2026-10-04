package com.samsung.android.sdk.smp.common.network;

import android.os.Bundle;
import com.samsung.android.sdk.smp.SmpResult;
import com.samsung.android.sdk.smp.common.exception.IErrors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NetworkErrorCodeParser {
    public static SmpResult parseErrorToSmpResult(int i, String str) {
        Bundle bundle = new Bundle();
        if (i < 1000) {
            bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0501);
            bundle.putString("error_message", "Internal server error - " + str);
            return new SmpResult(false, bundle);
        }
        if (i == 1002 || i == 1003 || i == 1010) {
            bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0301);
            bundle.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0301);
        } else if (i != 1015) {
            bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0401);
            bundle.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0401);
        } else {
            bundle.putString("error_code", IErrors.ERROR_CODE_SMP_0502);
            bundle.putString("error_message", IErrors.ERROR_MESSAGE_SMP_0502);
        }
        return new SmpResult(false, bundle);
    }
}
