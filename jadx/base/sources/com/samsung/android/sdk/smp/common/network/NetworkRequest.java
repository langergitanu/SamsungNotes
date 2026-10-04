package com.samsung.android.sdk.smp.common.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.BuildConfig;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class NetworkRequest {
    private static final String TAG = "NetworkRequest";
    private static Boolean mIsServerStg;

    public static Uri getBaseUrl(Context context) {
        String domainByFlavor = getDomainByFlavor(context);
        if (TextUtils.isEmpty(domainByFlavor)) {
            return null;
        }
        return Uri.parse(domainByFlavor + NetworkConfig.COMMON_POST_URI);
    }

    public static Uri getBaseUrlWithoutCommonPostUri(Context context) {
        String domainByFlavor = getDomainByFlavor(context);
        if (TextUtils.isEmpty(domainByFlavor)) {
            return null;
        }
        return Uri.parse(domainByFlavor);
    }

    public static String getDomainByFlavor(Context context) {
        if (!getIsServerStg(context)) {
            char flavorType = DeviceInfoUtil.getFlavorType();
            return flavorType != 'c' ? flavorType != 'g' ? PrefManager.getInstance(context).getBaseUrl() : BuildConfig.SMP_G_SERVER : BuildConfig.SMP_C_SERVER;
        }
        SmpLog.m6492d(TAG, "request to stg server");
        char flavorType2 = DeviceInfoUtil.getFlavorType();
        return flavorType2 != 'c' ? flavorType2 != 'g' ? PrefManager.getInstance(context).getBaseUrl() : BuildConfig.SMP_G_SERVER_STG : BuildConfig.SMP_C_SERVER_STG;
    }

    private static boolean getIsServerStg(Context context) {
        Boolean bool = mIsServerStg;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(DeviceInfoUtil.getSmpServerStg(context));
        mIsServerStg = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public Uri getBDomain(Context context) {
        if (!getIsServerStg(context)) {
            return Uri.parse("https://sdk.pushmessage.samsung.com/baseUrl");
        }
        SmpLog.m6492d(TAG, "request to stg server");
        return Uri.parse("https://sdk.stg.pushmessage.samsung.com/baseUrl");
    }

    public abstract String getRequestBody();

    public abstract int getRequestMethod();

    public abstract String getServerUrl(Context context);
}
