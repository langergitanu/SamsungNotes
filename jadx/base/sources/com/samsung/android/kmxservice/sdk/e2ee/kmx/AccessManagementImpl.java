package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.glance.AbstractC2821a;
import com.google.gson.Gson;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;
import com.samsung.android.kmxservice.sdk.e2ee.data.PackageVO;
import com.samsung.android.kmxservice.sdk.e2ee.manager.AccessManagement;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.sdk.mobileservice.social.buddy.request.TargetAppListRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class AccessManagementImpl implements AccessManagement {
    private static final String TAG = "AccessManagementImpl";

    private String parsingAllowListJson(String str) {
        HashMap map = new HashMap();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(TargetAppListRequest.BundleKey.APPS);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("packageName");
                String string2 = jSONObject.getString("id");
                JSONArray jSONArray2 = jSONObject.getJSONArray("signatures");
                String[] strArr = new String[jSONArray2.length()];
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    strArr[i2] = jSONArray2.getString(i2);
                }
                JSONArray jSONArray3 = jSONObject.getJSONArray("serviceIds");
                String[] strArr2 = new String[jSONArray3.length()];
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    strArr2[i4] = jSONArray3.getString(i4);
                }
                map.put(string, new Gson().toJson(new PackageVO(string2, string, strArr, strArr2)));
            }
            return String.valueOf(new JSONObject(map));
        } catch (JSONException e) {
            KmxLogger.m5528e(TAG, "parsingAllowListJson error : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.AccessManagement
    public boolean isAllowPackage(String str) {
        Context context = KmxSdk.getContext();
        Bundle bundle = new Bundle();
        String packageName = context.getPackageName();
        bundle.putString(KMX_CONSTANT.KMX_SERVICE_ID, str);
        bundle.putString(KMX_CONSTANT.KMX_PACKAGE_NAME, packageName);
        Bundle bundleCall = context.getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_IS_VALID_PACKAGE, (String) null, bundle);
        if (bundleCall == null) {
            return false;
        }
        int i = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE);
        KmxLogger.m5529i(TAG, "[isAllowPackage] : " + str + " | " + i);
        return i == 0;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.AccessManagement
    public void updateAllowList(List<PackageVO> list) {
        KmxLogger.m5529i(TAG, "[updateAllowList] - PackageVO");
        HashMap map = new HashMap();
        for (PackageVO packageVO : list) {
            KmxLogger.m5529i(TAG, "AppId :" + packageVO.getAppId() + "|PackageName :" + packageVO.getPackageName());
            if (packageVO.getServiceId() != null && packageVO.getServiceId().length > 0) {
                KmxLogger.m5529i(TAG, "ServiceId :" + Arrays.toString(packageVO.getServiceId()));
            }
            if (packageVO.getSignature() != null && packageVO.getSignature().length > 0) {
                KmxLogger.m5529i(TAG, "Signature :" + Arrays.toString(packageVO.getSignature()));
            }
            map.put(packageVO.getPackageName(), packageVO);
        }
        HashMap map2 = new HashMap();
        Gson gson = new Gson();
        for (Map.Entry entry : map.entrySet()) {
            map2.put((String) entry.getKey(), gson.toJson(entry.getValue()));
        }
        KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_UPDATE_ALLOW_LIST, (String) null, AbstractC2821a.m2215f(KMX_CONSTANT.KMX_ALLOW_PACKAGE_LIST, String.valueOf(new JSONObject(map2))));
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.AccessManagement
    public void updateAllowList(String str, String str2) throws KmxException {
        KmxLogger.m5529i(TAG, "[updateAllowList] - Signed");
        if (str == null) {
            KmxLogger.m5528e(TAG, "allowListJson is null");
            KmxErrorHandler.throwIfNotSuccess("allowListJson is null", 4);
            return;
        }
        KmxLogger.m5529i(TAG, "allowListJson : ".concat(str));
        if (str2 == null) {
            KmxLogger.m5528e(TAG, "base64Signature is null");
            KmxErrorHandler.throwIfNotSuccess("base64Signature is null", 4);
            return;
        }
        KmxLogger.m5529i(TAG, "base64Signature : ".concat(str2));
        String strParsingAllowListJson = parsingAllowListJson(str);
        if (strParsingAllowListJson == null) {
            KmxLogger.m5528e(TAG, "Fail to parsing allowListJson");
            KmxErrorHandler.throwIfNotSuccess("Fail to parsing allowListJson", 1);
            return;
        }
        KmxLogger.m5529i(TAG, "allowLists : ".concat(strParsingAllowListJson));
        Bundle bundle = new Bundle();
        bundle.putString(KMX_CONSTANT.KMX_ALLOW_PACKAGE_LIST, strParsingAllowListJson);
        bundle.putString(KMX_CONSTANT.KMX_SIGNED_ALLOW_PACKAGE_LIST, str);
        bundle.putString(KMX_CONSTANT.KMX_SIGNATURE, str2);
        KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_UPDATE_ALLOW_LIST, (String) null, bundle);
    }
}
