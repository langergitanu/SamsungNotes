package com.samsung.android.sdk.scs.base.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.scs.p140ai.sdkcommon.feature.FeatureConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FeatureHelper {
    private static final String TAG = "ScsApi@FeatureHelper";

    private static FeatureConfig getFeatureConfig(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("app_version", "");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("features");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, Integer.valueOf(jSONObjectOptJSONObject.optInt(next, 0)));
            }
        }
        return new FeatureConfig(strOptString, map);
    }

    public static int getFeatureVersionFromProvider(@NonNull Context context, @NonNull Uri uri, @NonNull String str) {
        Log.m6485d(TAG, "getFeatureVersionFromProvider()");
        Bundle bundleCall = null;
        try {
            bundleCall = context.getContentResolver().call(uri, "featureSupportRequest", str, (Bundle) null);
        } catch (Exception e) {
            Log.m6487e(TAG, "checkScsFeature(). " + e.getMessage());
        }
        if (bundleCall != null) {
            return bundleCall.getInt("constVersion");
        }
        Log.m6487e(TAG, "checkScsFeature(). retBundle == null!!!");
        return -2;
    }

    public static int getFeatureVersionFromSettings(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        StringBuilder sbM16m = AbstractC0000a.m16m("getFeatureVersionFromSettings(), serviceApp : ", str, ", feature : ", str2, ", settingKey : ");
        sbM16m.append(str3);
        Log.m6485d(TAG, sbM16m.toString());
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            try {
                String string = Settings.Global.getString(context.getContentResolver(), str3);
                if (TextUtils.isEmpty(string)) {
                    return -2;
                }
                try {
                    FeatureConfig featureConfig = getFeatureConfig(string);
                    if (packageInfo.versionName.compareTo(featureConfig.getAppVersion()) != 0) {
                        return -2;
                    }
                    Integer orDefault = featureConfig.getFeatures().getOrDefault(str2, -2);
                    int iIntValue = orDefault != null ? orDefault.intValue() : -2;
                    Log.m6485d(TAG, "Get feature version from global settings. feature : " + str2 + ", version : " + iIntValue);
                    return iIntValue;
                } catch (Exception e) {
                    Log.m6486d(TAG, "Unexpected behaviour when reading global settings", e);
                    return -2;
                }
            } catch (Exception e2) {
                Log.m6488e(TAG, "Failed to getString from global settings.", e2);
                return -2;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.m6488e(TAG, "Failed to get package info.", e3);
            return -2;
        }
    }
}
