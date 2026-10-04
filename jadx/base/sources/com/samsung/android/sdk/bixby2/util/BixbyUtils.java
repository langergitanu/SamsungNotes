package com.samsung.android.sdk.bixby2.util;

import android.os.Bundle;
import com.samsung.android.sdk.bixby2.LogUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BixbyUtils {
    private static final String TAG = "BixbyUtils";

    public static BixbyContextInfo getBixbyContextInfo(Bundle bundle) {
        LogUtil.m5745d(TAG, "getBixbyContextInfo()");
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle("contextInfo");
        return (bundle2 == null || bundle2.isEmpty()) ? new BixbyContextInfo() : new BixbyContextInfo(bundle2);
    }
}
