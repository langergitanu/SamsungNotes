package com.samsung.android.sdk.bixby2.state;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.bixby2.Constants;
import com.samsung.android.sdk.bixby2.LogUtil;
import com.samsung.android.sdk.bixby2.Sbixby;
import com.samsung.android.sdk.bixby2.data.AppMetaInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class StateHandler {
    public static final String ACTION_GET_APP_STATE = "getAppContext";
    public static final String APP_ID = "appId";
    public static final String APP_VERSION_CODE = "appVersionCode";
    public static final String CAPSULE_ID = "capsuleId";
    public static final String CONCEPTS = "concepts";
    public static final String DENIED_PERMISSIONS = "deniedPermissions";
    public static final String KEY_APP_STATE = "appContext";
    public static final String KEY_CAPSULE_ID = "com.samsung.android.bixby.capsuleId";
    public static final String LLM_CONTEXT = "llmContext";
    private static final String SUPPORTED_PERMISSIONS = "SUPPORTED_PERMISSIONS";
    private static final String TAG = "StateHandler";
    public static final String TYPE = "type";
    public static final String VALUE = "value";
    public static final String VALUES = "values";
    private static StateHandler mInstance;
    private Callback mCallback = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Callback {
        public List<String> getUsedPermissionsWhenAppStateRequested() {
            return null;
        }

        public abstract String onAppStateRequested();

        public String onCapsuleIdRequested() {
            return null;
        }
    }

    private StateHandler() {
    }

    @Nullable
    private List<String> getClientDeniedPermissions(@NonNull List<String> list, @NonNull Context context, @Nullable Bundle bundle) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = bundle != null ? new HashSet(bundle.getStringArrayList(SUPPORTED_PERMISSIONS)) : null;
            LogUtil.m5747i(TAG, "supportedPermissionsInClient = " + hashSet);
            for (String str : list) {
                if (hashSet == null || hashSet.contains(str)) {
                    if (packageManager.checkPermission(str, Constants.BIXBY_AGENT_PKG_NAME) != 0) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            LogUtil.m5746e(TAG, "exception : " + e.getMessage());
            return null;
        }
    }

    private AppMetaInfo getDefaultAppMetaInfo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            String packageName = context.getPackageName();
            Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
            if (bundle != null && bundle.containsKey(KEY_CAPSULE_ID)) {
                return new AppMetaInfo(bundle.getString(KEY_CAPSULE_ID), packageManager.getPackageInfo(packageName, 0).versionCode);
            }
            LogUtil.m5746e(TAG, "Can't get Capsule ID from Meta data:" + packageName);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            LogUtil.m5746e(TAG, "Failed to get Meta data info: " + e.getMessage());
            return null;
        } catch (NullPointerException e2) {
            e = e2;
            LogUtil.m5746e(TAG, "Failed to get Meta data info: " + e.getMessage());
            return null;
        }
    }

    public static synchronized StateHandler getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new StateHandler();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private void replaceAppContextLegacyWithDeniedPermissions(@Nullable List<String> list, @NonNull JSONObject jSONObject) {
        if (list != null) {
            try {
                if (list.isEmpty() || !jSONObject.has(CONCEPTS)) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray(CONCEPTS);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.has("values")) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(DENIED_PERMISSIONS, new JSONArray((Collection) list));
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(jSONObject3);
                        jSONObject2.put("values", jSONArray2);
                        return;
                    }
                }
            } catch (Exception e) {
                LogUtil.m5746e(TAG, "[2.0][AppContext] replace context with denied permission exception : " + e.getMessage());
            }
        }
    }

    private void replaceLlmAppContextWithDeniedPermissions(@Nullable List<String> list, @NonNull JSONObject jSONObject) {
        int i;
        if (list != null) {
            try {
                if (list.isEmpty() || !jSONObject.has(LLM_CONTEXT)) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray(LLM_CONTEXT);
                while (i < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    i = (jSONObject2.has("value") || jSONObject2.has("values")) ? 0 : i + 1;
                    jSONObject2.remove("value");
                    jSONObject2.remove("values");
                    jSONObject2.put(DENIED_PERMISSIONS, new JSONArray((Collection) list));
                    return;
                }
            } catch (Exception e) {
                LogUtil.m5746e(TAG, "[LLM][AppContext] replace context with denied permission exception : " + e.getMessage());
            }
        }
    }

    public String getAppState(Context context) {
        return getAppState(context, null);
    }

    public void updateStateChange(Callback callback) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("state handler updated. callback: ");
        sb.append(callback != null ? callback.toString() : null);
        LogUtil.m5745d(str, sb.toString());
        this.mCallback = callback;
    }

    public String getAppState(Context context, @Nullable Bundle bundle) {
        AppMetaInfo defaultAppMetaInfo;
        Callback callback = this.mCallback;
        if (callback == null) {
            LogUtil.m5746e(TAG, "StateHandler.Callback instance is null");
            return null;
        }
        String strOnAppStateRequested = callback.onAppStateRequested();
        if (TextUtils.isEmpty(strOnAppStateRequested)) {
            LogUtil.m5746e(TAG, "state info is empty.");
            return null;
        }
        String strOnCapsuleIdRequested = this.mCallback.onCapsuleIdRequested();
        Map<String, AppMetaInfo> appMetaInfoMap = Sbixby.getInstance().getAppMetaInfoMap();
        if (TextUtils.isEmpty(strOnCapsuleIdRequested)) {
            String str = TAG;
            LogUtil.m5746e(str, "capsuleId is empty");
            if (appMetaInfoMap == null || appMetaInfoMap.size() == 0) {
                defaultAppMetaInfo = getDefaultAppMetaInfo(context);
            } else {
                if (appMetaInfoMap.size() != 1) {
                    LogUtil.m5746e(str, "No Capsule Id and multiple App Meta Info. Can't pick one");
                    return null;
                }
                LogUtil.m5747i(str, "Map for App Meta Info. has only one");
                defaultAppMetaInfo = appMetaInfoMap.entrySet().iterator().next().getValue();
            }
        } else if (appMetaInfoMap == null || !appMetaInfoMap.containsKey(strOnCapsuleIdRequested)) {
            LogUtil.m5746e(TAG, "Map for App Meta Info. is empty");
            AppMetaInfo defaultAppMetaInfo2 = getDefaultAppMetaInfo(context);
            if (defaultAppMetaInfo2 != null) {
                defaultAppMetaInfo2.setCapsuleId(strOnCapsuleIdRequested);
            }
            defaultAppMetaInfo = defaultAppMetaInfo2;
        } else {
            defaultAppMetaInfo = appMetaInfoMap.get(strOnCapsuleIdRequested);
        }
        if (defaultAppMetaInfo == null) {
            LogUtil.m5746e(TAG, "App Meta Info. is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strOnAppStateRequested);
            jSONObject.put(CAPSULE_ID, defaultAppMetaInfo.getCapsuleId());
            jSONObject.put("appId", context.getPackageName());
            jSONObject.put(APP_VERSION_CODE, defaultAppMetaInfo.getAppVersionCode());
            List<String> usedPermissionsWhenAppStateRequested = this.mCallback.getUsedPermissionsWhenAppStateRequested();
            String str2 = TAG;
            LogUtil.m5747i(str2, "getUsedPermissionsWhenAppStateRequested() = " + usedPermissionsWhenAppStateRequested);
            if (Build.VERSION.SDK_INT >= 31 && usedPermissionsWhenAppStateRequested != null && !usedPermissionsWhenAppStateRequested.isEmpty()) {
                List<String> clientDeniedPermissions = getClientDeniedPermissions(usedPermissionsWhenAppStateRequested, context, bundle);
                LogUtil.m5747i(str2, "deniedPermissionsInClient = " + clientDeniedPermissions);
                if (clientDeniedPermissions != null) {
                    replaceAppContextLegacyWithDeniedPermissions(clientDeniedPermissions, jSONObject);
                    replaceLlmAppContextWithDeniedPermissions(clientDeniedPermissions, jSONObject);
                }
            }
            LogUtil.m5745d(str2, "state info: " + jSONObject);
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtil.m5746e(TAG, "getAppState exception " + e.getMessage());
            return null;
        }
    }
}
