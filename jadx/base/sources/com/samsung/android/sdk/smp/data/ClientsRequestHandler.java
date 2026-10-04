package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.JSONUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.ClientsRequest;
import com.samsung.android.sdk.smp.marketing.FeedbackManager;
import com.samsung.android.sdk.smp.spsclient.SpsUtil;
import com.samsung.android.sdk.smp.testmode.TestModeChecker;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
abstract class ClientsRequestHandler {
    private static final String RESPONSE_ACK_PERIOD = "ackperiod";
    private static final String RESPONSE_ACTIVE_PERIOD = "activeperiod";
    private static final String RESPONSE_BASE_URL = "baseUrl";
    private static final String RESPONSE_CONFIG = "config";
    private static final String RESPONSE_CONFIG_VERSION = "version";
    private static final String RESPONSE_CONTENTS_TYPE = "contentsType";
    private static final String RESPONSE_DEBUG = "debug";
    private static final String RESPONSE_DEBUG_ALARM = "alarm";
    private static final String RESPONSE_DEBUG_JOB = "job";
    protected static final String RESPONSE_INIT_STS = "initsts";
    private static final String RESPONSE_SESSION = "session";
    private static final String RESPONSE_SPS_POLICY = "spspolicy";
    private static final String RESPONSE_UPLOAD_PERIOD = "uploadperiod";
    protected static final String RESPONSE_WEBID = "webid";
    static final String TAG = "ClientsRequestHandler";
    private final String mAppid;
    private final Context mContext;
    private final PrefManager mPrefManager;
    private String mSmpid;

    public ClientsRequestHandler(Context context) {
        this.mContext = context;
        PrefManager prefManager = PrefManager.getInstance(context);
        this.mPrefManager = prefManager;
        this.mAppid = InitOptionsHolder.getInstance().getAppId(context);
        this.mSmpid = prefManager.getSmpID();
    }

    private JSONObject buildAppFilterData(DBHandler dBHandler) throws InternalException.BuildClientsException {
        Map<String, String> appFilter = dBHandler.getAppFilter();
        if (!DeviceInfoUtil.isSamsungPushService(getContext()) || SpsUtil.isDeviceIdAppFilterIncluded(appFilter)) {
            return JSONUtil.getJSONObjectFromMap(appFilter);
        }
        SmpLog.m6496he(TAG, "buildAppFilter error. deviceid null");
        throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
    }

    private JSONObject buildBasicData() throws InternalException.BuildClientsException {
        Context context = getContext();
        BasicData basicData = new BasicData();
        basicData.setInitsts(getPrefManager().getSmpFirstUploadTime());
        basicData.setLc(DeviceInfoUtil.getLocale());
        basicData.setOs(DeviceInfoUtil.getPlatform());
        basicData.setOsv(DeviceInfoUtil.getPlatformVersionCode());
        basicData.setOneUIV(DeviceInfoUtil.getOneUIVersion());
        String pushType = getPrefManager().getPushType();
        if (TextUtils.isEmpty(pushType)) {
            SmpLog.m6496he(TAG, "buildBasicData error. push type null");
            throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
        }
        basicData.setPtype(pushType);
        String pushToken = getPrefManager().getPushToken();
        if (TextUtils.isEmpty(pushToken)) {
            SmpLog.m6496he(TAG, "buildBasicData error. push token null");
            throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
        }
        basicData.setPid(pushToken);
        String strConvertNullToEmpty = convertNullToEmpty(DeviceInfoUtil.getCountryIsoCode());
        String strConvertNullToEmpty2 = convertNullToEmpty(DeviceInfoUtil.getSimMcc(context));
        if (TextUtils.isEmpty(strConvertNullToEmpty) && TextUtils.isEmpty(strConvertNullToEmpty2)) {
            SmpLog.m6497hi(TAG, "buildBasicData error. country code and sim mcc null");
            throw new InternalException.BuildClientsException(IErrors.ERROR_CODE_SMP_0103, IErrors.ERROR_MESSAGE_SMP_0103);
        }
        basicData.setDcc(strConvertNullToEmpty);
        basicData.setSmcc(strConvertNullToEmpty2);
        basicData.setNmcc(convertNullToEmpty(DeviceInfoUtil.getNetMcc(context)));
        basicData.setSmnc(convertNullToEmpty(DeviceInfoUtil.getSimMnc(context)));
        basicData.setNmnc(convertNullToEmpty(DeviceInfoUtil.getNetMnc(context)));
        basicData.setIsProductShip(DeviceInfoUtil.isProductShip());
        basicData.setModel(DeviceInfoUtil.getModelName());
        basicData.setCsc(DeviceInfoUtil.getCscCode());
        basicData.setSdkv(DeviceInfoUtil.getSmpSdkVersion(context));
        basicData.setAppv(DeviceInfoUtil.getAppVersion(context));
        basicData.setTargetSdkLevel(DeviceInfoUtil.getTargetSdkVersion(context));
        basicData.setChannel(getChannel());
        if (DeviceInfoUtil.isSamsungPushService(context)) {
            basicData.setSpspolicy(SpsUtil.getSpsPolicy(context));
        }
        basicData.setConfv(getPrefManager().getConfigVersion());
        basicData.setUid(getPrefManager().getUID());
        basicData.setIntegratedOptin(SmpConstants.OptInPolicy.INTEGRATED_BASED.equals(getPrefManager().getOptinPolicy()));
        basicData.setOptin(getPrefManager().getOptIn());
        basicData.setOptintime(getPrefManager().getOptInTime());
        basicData.setDatasaver(DeviceInfoUtil.isDataSaverMode(context));
        basicData.setPowersaver(DeviceInfoUtil.isPowerSaveMode(context));
        basicData.setTimezone(TimeZone.getDefault().getID());
        basicData.setBackgroundRestricted(DeviceInfoUtil.isBackgroundRestricted(context));
        if (Build.VERSION.SDK_INT >= 28) {
            basicData.setStandByBucket(DeviceInfoUtil.getStandByBucket(context));
        }
        basicData.setSmallestScreenWidth(DeviceInfoUtil.getSmallestScreenWidth(context));
        basicData.setFold(DeviceInfoUtil.isFoldDevice());
        return basicData.toJSONObject();
    }

    private JSONArray buildMarketingData(DBHandler dBHandler) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Map<String, JSONArray> allFeedbacksToSend = dBHandler.getAllFeedbacksToSend();
        if (allFeedbacksToSend.size() > 0) {
            for (Map.Entry<String, JSONArray> entry : allFeedbacksToSend.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mid", entry.getKey());
                jSONObject.put("feedback", entry.getValue());
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    private ClientsRequest buildRequest() {
        DBHandler dBHandlerOpen = DBHandler.open(getContext());
        try {
            if (dBHandlerOpen == null) {
                SmpLog.m6496he(TAG, "build request fail. dbHandler null");
                afterBuildRequestError(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
                return null;
            }
            ClientsRequest clientsRequestBuild = new ClientsRequest.Builder(getContext(), getAppId(), getSmpId(), buildBasicData()).setAppFilterData(buildAppFilterData(dBHandlerOpen)).setAppReferrerKeyData(dBHandlerOpen.getAppReferrerKeyData()).setAppStartData(dBHandlerOpen.getAppStartData()).setSessionData(dBHandlerOpen.getSessionData()).setMarketingData(buildMarketingData(dBHandlerOpen)).setTestData(buildTestData()).build();
            clientsRequestBuild.setTrackingEnabled(getPrefManager().getActivityTrackingEnabled());
            return clientsRequestBuild;
        } catch (InternalException.BuildClientsException e) {
            SmpLog.m6496he(TAG, "build request fail. " + e.getErrorCode());
            afterBuildRequestError(e.getErrorCode(), e.getErrorMessage());
            return null;
        } catch (JSONException e2) {
            SmpLog.m6496he(TAG, "build request fail. JSONError : " + e2.toString());
            afterBuildRequestError(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            return null;
        } finally {
            dBHandlerOpen.close();
        }
    }

    private JSONObject buildTestData() throws JSONException {
        TestModeChecker.checkModeAndEnableLog(getContext());
        if (TextUtils.isEmpty(TestModeChecker.getDeviceNickname())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NetworkConfig.CLIENTS_DEVICENAME, TestModeChecker.getDeviceNickname());
        return jSONObject;
    }

    private void checkBaseUrlValidity(int i) {
        if (i < 400 || i >= 500) {
            return;
        }
        SmpLog.m6501w(TAG, "invalid base url - server client error");
        getPrefManager().setBaseUrl(null);
    }

    private void clearSentData(ClientsRequest clientsRequest) {
        if (clientsRequest != null) {
            FeedbackManager.deleteFeedbacks(getContext(), clientsRequest.getMarketingData());
            UsageManager.clearAppUsage(getContext());
        }
    }

    private String convertNullToEmpty(String str) {
        return str == null ? "" : str;
    }

    private JSONObject getChannel() throws JSONException {
        boolean zIsChannelEnabled = isChannelEnabled(getContext(), 1);
        boolean zIsChannelEnabled2 = isChannelEnabled(getContext(), 2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NetworkConfig.CLIENTS_CHANNEL_NOTICE, zIsChannelEnabled);
        jSONObject.put("marketing", zIsChannelEnabled2);
        return jSONObject;
    }

    private void handleDebugResponse(JSONObject jSONObject) {
        boolean zOptBoolean;
        boolean z = false;
        if (jSONObject != null) {
            boolean zOptBoolean2 = jSONObject.optBoolean("alarm", false);
            zOptBoolean = jSONObject.optBoolean(RESPONSE_DEBUG_JOB, false);
            z = zOptBoolean2;
        } else {
            zOptBoolean = false;
        }
        getPrefManager().setDebugAlarmOn(z);
        getPrefManager().setDebugJobOn(zOptBoolean);
    }

    private boolean isChannelEnabled(Context context, int i) {
        try {
            return !DeviceInfoUtil.isNotiSettingOptionDisabled(context, getPrefManager().getNotiChannelId(i));
        } catch (InternalException.IllegalPushChannelException unused) {
            return false;
        }
    }

    private boolean isRequestAvailableNow(ClientsRequest clientsRequest) {
        if (clientsRequest.hasDataChanged()) {
            SmpLog.m6498i(TAG, "UPLOAD_CLIENTS available : data changed");
            return true;
        }
        long lastUploadCompleteTime = getPrefManager().getLastUploadCompleteTime();
        long activePeriod = getPrefManager().getActivePeriod();
        long j = Constants.MINMILLIS;
        long j2 = lastUploadCompleteTime + (activePeriod * j);
        if (System.currentTimeMillis() > j2) {
            SmpLog.m6498i(TAG, "UPLOAD_CLIENTS available : active period");
            return true;
        }
        if (clientsRequest.hasTestData()) {
            SmpLog.m6498i(TAG, "UPLOAD_CLIENTS available : test device");
            return true;
        }
        long jCurrentTimeMillis = j2 - System.currentTimeMillis();
        SmpLog.m6498i(TAG, "data not changed. next active period will be after " + (jCurrentTimeMillis / j) + " minutes");
        return false;
    }

    private boolean notifyInitAndUpdateAppFilterForSps(ClientsRequest clientsRequest) {
        if (SpsUtil.notifyAppClientInit(getContext()) != 1) {
            SmpLog.m6496he(TAG, "notifyInitAndUpdateAppFilterForSps. notify fail");
            afterBuildRequestError(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            return false;
        }
        DBHandler dBHandlerOpen = DBHandler.open(getContext());
        try {
            if (dBHandlerOpen != null) {
                clientsRequest.updateAppFilterData(buildAppFilterData(dBHandlerOpen));
                return true;
            }
            SmpLog.m6496he(TAG, "notifyInitAndUpdateAppFilterForSps fail. db null");
            afterBuildRequestError(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            return false;
        } catch (JSONException e) {
            SmpLog.m6496he(TAG, "notifyInitAndUpdateAppFilterForSps JSON error. " + e.toString());
            afterBuildRequestError(IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_MESSAGE_SMP_0401);
            return false;
        } catch (InternalException.BuildClientsException e2) {
            SmpLog.m6496he(TAG, "notifyInitAndUpdateAppFilterForSps fail. update app filters error");
            afterBuildRequestError(e2.getErrorCode(), e2.getErrorMessage());
            return false;
        } finally {
            dBHandlerOpen.close();
        }
    }

    private void saveSentData(ClientsRequest clientsRequest) {
        if (clientsRequest.getBasicData() != null) {
            getPrefManager().setPrevBasicData(clientsRequest.getBasicData().toString());
        }
        if (clientsRequest.getAppFilterData() != null) {
            getPrefManager().setPrevAppFilterData(clientsRequest.getAppFilterData().toString());
        }
        if (clientsRequest.getAppReferrerKeyData() != null) {
            getPrefManager().setPrevAppReferrerKeyData(clientsRequest.getAppReferrerKeyData().toString());
        }
    }

    public void adjustDataAfterUploadDone(ClientsRequest clientsRequest) {
        getPrefManager().setUploadFailCount(0);
        getPrefManager().setLastUploadCompleteTime(System.currentTimeMillis());
        clearSentData(clientsRequest);
        saveSentData(clientsRequest);
    }

    public void afterBuildRequestError(String str, String str2) {
        UsageManager.handleUploadFail(getContext());
    }

    public void afterError(int i, String str) {
        if (i != 1002) {
            UsageManager.handleUploadFail(getContext());
        }
        checkBaseUrlValidity(i);
    }

    public abstract void afterSuccess(ClientsRequest clientsRequest, String str);

    public abstract boolean beforeRequest();

    public String getAppId() {
        return this.mAppid;
    }

    public Context getContext() {
        return this.mContext;
    }

    public PrefManager getPrefManager() {
        return this.mPrefManager;
    }

    public String getSmpId() {
        return this.mSmpid;
    }

    public void handleResponse(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("config")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("config");
                if (jSONObject2.has("session")) {
                    getPrefManager().setActivityTrackingEnabled(jSONObject2.getBoolean("session"));
                }
                if (jSONObject2.has(RESPONSE_UPLOAD_PERIOD)) {
                    getPrefManager().setUploadPeriod(jSONObject2.getLong(RESPONSE_UPLOAD_PERIOD));
                }
                if (jSONObject2.has(RESPONSE_ACTIVE_PERIOD)) {
                    getPrefManager().setActivePeriod(jSONObject2.getLong(RESPONSE_ACTIVE_PERIOD));
                }
                if (jSONObject2.has("version")) {
                    getPrefManager().setConfigVersion(jSONObject2.getInt("version"));
                }
                if (jSONObject2.has(RESPONSE_ACK_PERIOD)) {
                    getPrefManager().setAckPeriod(jSONObject2.getLong(RESPONSE_ACK_PERIOD));
                }
                if (jSONObject2.has("baseUrl")) {
                    String string = jSONObject2.getString("baseUrl");
                    if (!TextUtils.isEmpty(string)) {
                        getPrefManager().setBaseUrl(string);
                    }
                }
                getPrefManager().setContentsTypePolicy(jSONObject2.optString(RESPONSE_CONTENTS_TYPE));
                handleDebugResponse(jSONObject2.optJSONObject(RESPONSE_DEBUG));
            }
            if (jSONObject.has("spspolicy") && DeviceInfoUtil.isSamsungPushService(getContext())) {
                BroadcastUtil.broadcastSPSPolicy(getContext(), jSONObject.getJSONObject("spspolicy").toString());
            }
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, e.toString());
        }
    }

    public void request() {
        if (beforeRequest()) {
            ClientsRequest clientsRequestBuildRequest = buildRequest();
            if (clientsRequestBuildRequest == null) {
                SmpLog.m6494e(TAG, "request fail. fail to build request");
                return;
            }
            if (isRequestAvailableNow(clientsRequestBuildRequest)) {
                if (!DeviceInfoUtil.isSamsungPushService(getContext()) || notifyInitAndUpdateAppFilterForSps(clientsRequestBuildRequest)) {
                    NetworkResult networkResultRequest = NetworkManager.request(getContext(), clientsRequestBuildRequest, 30);
                    if (networkResultRequest.isSuccess()) {
                        afterSuccess(clientsRequestBuildRequest, networkResultRequest.getResponseMsg());
                    } else {
                        afterError(networkResultRequest.getResponseCode(), networkResultRequest.getResponseMsg());
                    }
                }
            }
        }
    }

    public void updateSmpId(String str) {
        this.mSmpid = str;
    }
}
