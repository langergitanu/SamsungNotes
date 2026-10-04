package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.network.NetworkJSonRequest;
import com.samsung.android.sdk.smp.common.network.NetworkRequest;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.JSONUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.testmode.TestModeChecker;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ClientsRequest extends NetworkJSonRequest {
    private static final String TAG = "ClientsRequest";
    private JSONObject mAppFilterData;
    private final String mAppId;
    private final JSONArray mAppReferrerKeyData;
    private final JSONArray mAppStartData;
    private final JSONObject mBasicData;
    private final Context mContext;
    private boolean mIsTrackingEnabled;
    private final JSONArray mMarketingData;
    private final JSONArray mSessionData;
    private final String mSmpId;
    private final JSONObject mTestData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private JSONObject mAppFilterData;
        private final String mAppId;
        private JSONArray mAppReferrerKeyData;
        private JSONArray mAppStartData;
        private final JSONObject mBasicData;
        private final Context mContext;
        private JSONArray mMarketingData;
        private JSONArray mSessionData;
        private final String mSmpId;
        private JSONObject mTestData;

        public Builder(Context context, String str, String str2, JSONObject jSONObject) throws InternalException.BuildClientsException {
            if (context == null) {
                SmpLog.m6496he(ClientsRequest.TAG, "create builder fail. context null");
                throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            }
            if (TextUtils.isEmpty(str)) {
                SmpLog.m6496he(ClientsRequest.TAG, "create builder fail. appId null");
                throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            }
            if (TextUtils.isEmpty(str2)) {
                SmpLog.m6496he(ClientsRequest.TAG, "create builder fail. smpId null");
                throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            }
            if (jSONObject == null) {
                SmpLog.m6496he(ClientsRequest.TAG, "create builder fail. basicData null");
                throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            }
            this.mContext = context;
            this.mAppId = str;
            this.mSmpId = str2;
            this.mBasicData = jSONObject;
        }

        public ClientsRequest build() {
            return new ClientsRequest(this.mContext, this.mAppId, this.mSmpId, this.mBasicData, this.mAppFilterData, this.mAppReferrerKeyData, this.mAppStartData, this.mSessionData, this.mMarketingData, this.mTestData);
        }

        public Builder setAppFilterData(JSONObject jSONObject) {
            this.mAppFilterData = jSONObject;
            return this;
        }

        public Builder setAppReferrerKeyData(JSONArray jSONArray) {
            this.mAppReferrerKeyData = jSONArray;
            return this;
        }

        public Builder setAppStartData(JSONArray jSONArray) {
            this.mAppStartData = jSONArray;
            return this;
        }

        public Builder setMarketingData(JSONArray jSONArray) {
            this.mMarketingData = jSONArray;
            return this;
        }

        public Builder setSessionData(JSONArray jSONArray) {
            this.mSessionData = jSONArray;
            return this;
        }

        public Builder setTestData(JSONObject jSONObject) {
            this.mTestData = jSONObject;
            return this;
        }
    }

    private String refineBasicData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove(NetworkConfig.CLIENTS_INIT_STS);
            jSONObject.remove(NetworkConfig.CLIENTS_CONFIG_VER);
            if (DeviceInfoUtil.isSamsungPushService(this.mContext)) {
                jSONObject.remove(NetworkConfig.CLIENTS_SDKV);
                jSONObject.remove(NetworkConfig.CLIENTS_APPV);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public JSONObject getAppFilterData() {
        return this.mAppFilterData;
    }

    public JSONArray getAppReferrerKeyData() {
        return this.mAppReferrerKeyData;
    }

    public JSONObject getBasicData() {
        return this.mBasicData;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public JSONObject getJsonRequestBody() throws InternalException.InvalidDataException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NetworkConfig.CLIENTS_CURRENT_DTS, System.currentTimeMillis());
            jSONObject.put(NetworkConfig.CLIENTS_BASIC, this.mBasicData);
            if (!JSONUtil.isEmpty(this.mAppFilterData)) {
                jSONObject.put("appfilter", this.mAppFilterData);
            }
            if (!JSONUtil.isEmpty(this.mAppReferrerKeyData)) {
                jSONObject.put(NetworkConfig.CLIENTS_APP_REFERRER_KEY, this.mAppReferrerKeyData);
            }
            if (!JSONUtil.isEmpty(this.mAppStartData)) {
                jSONObject.put(NetworkConfig.CLIENTS_APP_START, this.mAppStartData);
            }
            if (!JSONUtil.isEmpty(this.mSessionData)) {
                jSONObject.put("session", this.mSessionData);
            }
            if (!JSONUtil.isEmpty(this.mMarketingData)) {
                jSONObject.put("marketing", this.mMarketingData);
            }
            if (!JSONUtil.isEmpty(this.mTestData)) {
                SmpLog.m6497hi(TAG, "test device : " + TestModeChecker.getDeviceNickname());
                jSONObject.put("test", this.mTestData);
            }
            return jSONObject;
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, e.toString());
            throw new InternalException.InvalidDataException();
        }
    }

    public JSONArray getMarketingData() {
        return this.mMarketingData;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public int getRequestMethod() {
        return 1;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkRequest
    public String getServerUrl(Context context) {
        Uri baseUrl = NetworkRequest.getBaseUrl(context);
        if (baseUrl == null) {
            return null;
        }
        return baseUrl.buildUpon().appendPath(this.mAppId).appendPath(NetworkConfig.PATH_CLIENTS).appendPath(this.mSmpId).toString();
    }

    public boolean hasDataChanged() {
        PrefManager prefManager = PrefManager.getInstance(this.mContext);
        if (!refineBasicData(this.mBasicData.toString()).equals(refineBasicData(prefManager.getPrevBasicData()))) {
            return true;
        }
        String prevAppFilterData = prefManager.getPrevAppFilterData();
        String string = JSONUtil.isEmpty(this.mAppFilterData) ? "" : this.mAppFilterData.toString();
        if (JSONUtil.isEmpty(prevAppFilterData)) {
            prevAppFilterData = "";
        }
        if (!string.equals(prevAppFilterData)) {
            return true;
        }
        String prevAppReferrerKeyData = prefManager.getPrevAppReferrerKeyData();
        if ((JSONUtil.isEmpty(this.mAppReferrerKeyData) ? "" : this.mAppReferrerKeyData.toString()).equals(JSONUtil.isEmpty(prevAppReferrerKeyData) ? "" : prevAppReferrerKeyData) && JSONUtil.isEmpty(this.mAppStartData) && JSONUtil.isEmpty(this.mSessionData)) {
            return !JSONUtil.isEmpty(this.mMarketingData);
        }
        return true;
    }

    public boolean hasTestData() {
        return this.mTestData != null;
    }

    @Override // com.samsung.android.sdk.smp.common.network.NetworkJSonRequest
    public boolean isGzipEnabled() {
        return this.mIsTrackingEnabled;
    }

    public void setTrackingEnabled(boolean z) {
        this.mIsTrackingEnabled = z;
    }

    public void updateAppFilterData(JSONObject jSONObject) {
        this.mAppFilterData = jSONObject;
    }

    private ClientsRequest(Context context, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONObject jSONObject3) {
        this.mContext = context;
        this.mAppId = str;
        this.mSmpId = str2;
        this.mBasicData = jSONObject;
        this.mAppFilterData = jSONObject2;
        this.mAppReferrerKeyData = jSONArray;
        this.mAppStartData = jSONArray2;
        this.mSessionData = jSONArray3;
        this.mMarketingData = jSONArray4;
        this.mTestData = jSONObject3;
    }
}
