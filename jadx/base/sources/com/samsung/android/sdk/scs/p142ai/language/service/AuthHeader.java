package com.samsung.android.sdk.scs.p142ai.language.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.language.RequestHeaderConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AuthHeader {
    private static final String TAG = "AuthHeader";
    private final AppInfo appInfo;

    public AuthHeader(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    private String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    public Map<String, String> generateHeaderMap(Context context) {
        HashMap map = new HashMap();
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            map.put("api-key", appInfo.getApiKey());
            map.put("package-signing-key", this.appInfo.getSigningKey());
            map.put("ssp-app-id", this.appInfo.getAppId());
            map.put("ssp-access-token", this.appInfo.getAccessToken());
            map.put("ssp-user-id", this.appInfo.getUserId());
            map.put("ssp-server-url", this.appInfo.getServerUrl());
            map.put("ssp-account-type", this.appInfo.getAccountType());
            map.put("request-type", this.appInfo.getRequestType().name());
            map.put(RequestHeaderConst.KEY_STREAMING_MODE, Boolean.toString(this.appInfo.isStreamingMode()));
        }
        map.put("package-name", context.getPackageName());
        Log.m6489i(TAG, "SCS SDK VERSION: 4.0.55");
        return map;
    }
}
