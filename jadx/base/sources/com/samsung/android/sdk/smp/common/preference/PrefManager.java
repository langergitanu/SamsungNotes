package com.samsung.android.sdk.smp.common.preference;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.interfaces.SharedDataManager;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PrefManager extends SharedDataManager {
    private static final String ACK_PERIOD = "ackPeriod";
    private static final String ACTIVE_PERIOD = "activePeriod";
    private static final String BASE_URL = "baseUrl";
    private static final String CONFIG_VERSION = "confVersion";
    private static final String CONTENTS_TYPE = "contentsType";
    private static final String DEACTIVATE_SMP = "deactivate_smp";
    private static final String DEBUG_ALARM = "debugAlarm";
    private static final String DEBUG_JOB = "debugJob";
    private static final String ENABLE_ACTIVITY_TRACKING = "tracking";
    private static final String ENABLE_DEBUG_MODE = "debug";
    private static final String FCM_SERVICE_RETRY_COUNT = "fcm_service_retry_count";
    private static final String IDS_AID = "aid";
    private static final String IDS_OPTIN = "optin";
    private static final String IDS_OPTIN_TIME = "optintime";
    private static final String IDS_PID = "pid";
    private static final String IDS_PTYPE = "ptype";
    private static final String IDS_PTYPE_CACHE = "ptype_cache";
    private static final String IDS_SMPID = "smpid";
    private static final String IDS_UID = "uid";
    private static final String IDS_WEBID = "webid";
    private static final String INIT_COMPLETE_TIME_FOR_SPP_FORCE_ACTIVATION_FEATURE = "init_complete_time_for_spp_force_activation_feature";
    private static final String KEY_PREFIX_CHANNEL = "chan_";
    private static final String LAST_ACK_COMPLETE_TIME = "last_ack_complete_time";
    private static final String LAST_UPLOAD_COMPLETE_TIME = "last_upload_complete_time";
    private static final String LAST_UPLOAD_TRY_TIME = "last_upload_try_time";
    private static final String NEXT_PUSH_TYPE_FOR_FCM_PRIMARY_MODE = "next_push_type";
    private static final String NOTI_COLOR = "noti_color";
    private static final String NOTI_GROUP = "noti_group";
    private static final String NOTI_SOUND_ENABLED = "noti_sound_enabled";
    private static final String NOTI_SOUND_URI = "noti_sound_uri";
    private static final String NOTI_VIBRATE_ENABLED = "noti_vibrate_enabled";
    private static final String NOTI_VIBRATE_PATTERN = "noti_vibrate_pattern";
    private static final String OPT_IN_POLICY = "opt_in_policy";
    private static final int PREFERENCE_VERSION = 2;
    private static final String PREV_APP_FILTER = "prev_appfilters";
    private static final String PREV_APP_REFERRER_KEY = "prev_app_referrer_keys";
    private static final String PREV_BASIC = "prev_basic";
    private static final String PUSH_MODE_FOR_HK_AND_MO = "push_mode";
    private static final String RANDOM_SMPID_GENERATED = "random_smpid_generated";
    private static final String SMP_FIRST_UPLOAD_TIME = "smp_first_upload_time";
    private static final String SMP_PREFERENCE_VERSION = "smp_preference_version";
    private static final String SPP_APP_ID = "spp_app_id";
    private static final String TAG = "PrefManager";
    private static final int UNKNOWN_VERSION = -1;
    private static final String UPLOAD_FAIL_COUNT = "upload_fail_count";
    private static final String UPLOAD_PERIOD = "uploadDelay";
    private static PrefManager sPrefManager;

    private PrefManager(Context context) {
        super(context);
        int preferenceVersion = getPreferenceVersion();
        try {
            if (preferenceVersion == -1) {
                setPreferenceVersion(2);
            } else if (preferenceVersion < 2) {
                migratePreference(preferenceVersion);
            }
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "Exception setPreferenceVersion " + e.getErrorMessage());
        }
    }

    public static synchronized PrefManager getInstance(Context context) {
        try {
            if (sPrefManager == null) {
                sPrefManager = new PrefManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sPrefManager;
    }

    private void migratePreference(int i) {
        String str = TAG;
        SmpLog.m6497hi(str, "upgrade preference. oldVersion: " + i + ", newVersion: 2");
        if (i < 1) {
            setOptinPolicy(SmpConstants.OptInPolicy.DEVICE_BASED);
        } else if (i < 2) {
            SmpConstants.OptInPolicy optInPolicy = SmpConstants.OptInPolicy.DEVICE_BASED;
            if ("USER_BASED".equals(getString(OPT_IN_POLICY, optInPolicy.name()))) {
                setOptinPolicy(optInPolicy);
                SmpLog.m6497hi(str, "migrate opt in policy from USER_BASED to DEVICE_BASED");
            }
        }
        setPreferenceVersion(2);
    }

    private synchronized void setPushTypeCache(String str) {
        putString(IDS_PTYPE_CACHE, str);
    }

    public synchronized void deactivateSmp(boolean z) {
        putBoolean(DEACTIVATE_SMP, z);
    }

    public synchronized String getAID() {
        return getString("aid", null);
    }

    public synchronized long getAckPeriod() {
        return getLong(ACK_PERIOD, 360L).longValue();
    }

    public synchronized long getActivePeriod() {
        return getLong(ACTIVE_PERIOD, Constants.DEFAULT_ACTIVE_PERIOD).longValue();
    }

    public synchronized boolean getActivityTrackingEnabled() {
        return getBoolean(ENABLE_ACTIVITY_TRACKING, false);
    }

    public synchronized String getBaseUrl() {
        return getString("baseUrl", null);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public boolean getBooleanForSingleProcess(Context context, String str, boolean z) {
        return PrefInteractor.getInstance(context).getBoolean(str, z).booleanValue();
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getBooleanUri() {
        return getSmpPrefProviderBaseUri() + "pref_boolean/";
    }

    public synchronized int getConfigVersion() {
        return getInteger(CONFIG_VERSION, -1);
    }

    public synchronized String getContentsTypePolicy() {
        return getString(CONTENTS_TYPE, null);
    }

    public synchronized int getFcmServiceRetryCount() {
        return getInteger(FCM_SERVICE_RETRY_COUNT, 0);
    }

    public synchronized long getInitCompleteTimeForSppForceActivationFeature() {
        return getLong(INIT_COMPLETE_TIME_FOR_SPP_FORCE_ACTIVATION_FEATURE, 0L).longValue();
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public int getIntegerForSingleProcess(Context context, String str, int i) {
        return PrefInteractor.getInstance(context).getInteger(str, i).intValue();
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getIntegerUri() {
        return getSmpPrefProviderBaseUri() + "pref_integer/";
    }

    public synchronized long getLastAckCompleteTime() {
        return getLong(LAST_ACK_COMPLETE_TIME, 0L).longValue();
    }

    public synchronized long getLastUploadCompleteTime() {
        return getLong(LAST_UPLOAD_COMPLETE_TIME, 0L).longValue();
    }

    public synchronized long getLastUploadTryTime() {
        return getLong(LAST_UPLOAD_TRY_TIME, 0L).longValue();
    }

    public synchronized boolean getLogEnabled() {
        return getBoolean(ENABLE_DEBUG_MODE, false);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public long getLongForSingleProcess(Context context, String str, long j) {
        return PrefInteractor.getInstance(context).getLong(str, j).longValue();
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getLongUri() {
        return getSmpPrefProviderBaseUri() + "pref_long/";
    }

    public synchronized String getNextPushTypeForFCMPrimaryMode() {
        return getString(NEXT_PUSH_TYPE_FOR_FCM_PRIMARY_MODE, "fcm");
    }

    public synchronized String getNotiChannelId(int i) {
        return getString(KEY_PREFIX_CHANNEL + i, null);
    }

    public synchronized int getNotiColor() {
        return getInteger(NOTI_COLOR, 0);
    }

    public synchronized String getNotiGroup() {
        return getString(NOTI_GROUP, null);
    }

    public synchronized boolean getOptIn() {
        return getBoolean("optin", false);
    }

    public synchronized long getOptInTime() {
        return getLong("optintime", 0L).longValue();
    }

    public synchronized SmpConstants.OptInPolicy getOptinPolicy() {
        return SmpConstants.OptInPolicy.fromString(getString(OPT_IN_POLICY, SmpConstants.OptInPolicy.DEVICE_BASED.name()));
    }

    public synchronized int getPreferenceVersion() {
        return getInteger(SMP_PREFERENCE_VERSION, -1);
    }

    public synchronized String getPrevAppFilterData() {
        return getString(PREV_APP_FILTER, "");
    }

    public synchronized String getPrevAppReferrerKeyData() {
        return getString(PREV_APP_REFERRER_KEY, "");
    }

    public synchronized String getPrevBasicData() {
        return getString(PREV_BASIC, "");
    }

    public synchronized SmpConstants.PushModeForHkAndMo getPushModeForHkAndMo() {
        return SmpConstants.PushModeForHkAndMo.fromString(getString(PUSH_MODE_FOR_HK_AND_MO, SmpConstants.PushModeForHkAndMo.FCM_PRIMARY_MODE.name()));
    }

    public synchronized String getPushToken() {
        return getString("pid", null);
    }

    public synchronized String getPushType() {
        return getString("ptype", null);
    }

    public synchronized String getPushTypeCache() {
        return getString(IDS_PTYPE_CACHE, null);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getRemoveStringSetUri() {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getRemoveUri() {
        return getSmpPrefProviderBaseUri() + "pref_delete/";
    }

    public synchronized long getSmpFirstUploadTime() {
        return getLong(SMP_FIRST_UPLOAD_TIME, 0L).longValue();
    }

    public synchronized String getSmpID() {
        return getString("smpid", null);
    }

    public synchronized boolean getSoundEnabled() {
        return getBoolean(NOTI_SOUND_ENABLED, false);
    }

    public synchronized String getSoundUriString() {
        return getString(NOTI_SOUND_URI, "");
    }

    public synchronized String getSppAppId() {
        return getString(SPP_APP_ID, null);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getStringForSingleProcess(Context context, String str, String str2) {
        return PrefInteractor.getInstance(context).getString(str, str2);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public Set<String> getStringSetForSingleProcess(Context context, String str) {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getStringSetUri() {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getStringUri() {
        return getSmpPrefProviderBaseUri() + "pref_string/";
    }

    public synchronized String getUID() {
        return getString("uid", "");
    }

    public synchronized int getUploadFailCount() {
        return getInteger(UPLOAD_FAIL_COUNT, 0);
    }

    public synchronized long getUploadPeriod() {
        return getLong(UPLOAD_PERIOD, 60L).longValue();
    }

    public synchronized boolean getVibrateEnabled() {
        return getBoolean(NOTI_VIBRATE_ENABLED, false);
    }

    public synchronized long[] getVibratePattern() {
        long[] jArr;
        jArr = null;
        try {
            JSONArray jSONArray = new JSONArray(getString(NOTI_VIBRATE_PATTERN, ""));
            jArr = new long[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                jArr[i] = jSONArray.getLong(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jArr;
    }

    public synchronized String getWebId() {
        return getString("webid", null);
    }

    public synchronized boolean isDebugAlarmOn() {
        return getBoolean(DEBUG_ALARM, false);
    }

    public synchronized boolean isDebugJobOn() {
        return getBoolean(DEBUG_JOB, false);
    }

    public synchronized boolean isRandomSmpIdGenerated() {
        return getBoolean(RANDOM_SMPID_GENERATED, false);
    }

    public synchronized boolean isSmpDeactivated() {
        return getBoolean(DEACTIVATE_SMP, false);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putBooleanForSingleProcess(Context context, String str, boolean z) {
        PrefInteractor.getInstance(context).putBoolean(str, z);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putIntegerForSingleProcess(Context context, String str, int i) {
        PrefInteractor.getInstance(context).putInteger(str, i);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putLongForSingleProcess(Context context, String str, long j) {
        PrefInteractor.getInstance(context).putLong(str, j);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putStringForSingleProcess(Context context, String str, String str2) {
        PrefInteractor.getInstance(context).putString(str, str2);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putStringSetForSingleProcess(Context context, String str, String str2) {
    }

    public synchronized void removeData() {
        remove("smpid");
        remove("webid");
        remove("aid");
        remove("pid");
        remove("ptype");
        remove(IDS_PTYPE_CACHE);
        remove("uid");
        remove("optin");
        remove("optintime");
        remove(SMP_FIRST_UPLOAD_TIME);
        remove(LAST_UPLOAD_TRY_TIME);
        remove(LAST_UPLOAD_COMPLETE_TIME);
        remove(INIT_COMPLETE_TIME_FOR_SPP_FORCE_ACTIVATION_FEATURE);
        remove(LAST_ACK_COMPLETE_TIME);
        remove(CONFIG_VERSION);
        remove(UPLOAD_PERIOD);
        remove(ACTIVE_PERIOD);
        remove(ENABLE_ACTIVITY_TRACKING);
        remove(ACK_PERIOD);
        remove(SPP_APP_ID);
        remove(OPT_IN_POLICY);
        remove(ENABLE_DEBUG_MODE);
        remove(PUSH_MODE_FOR_HK_AND_MO);
        remove(NOTI_SOUND_URI);
        remove(NOTI_SOUND_ENABLED);
        remove(NOTI_VIBRATE_PATTERN);
        remove(NOTI_VIBRATE_ENABLED);
        remove(NOTI_COLOR);
        remove(KEY_PREFIX_CHANNEL);
        remove(NOTI_GROUP);
        remove(UPLOAD_FAIL_COUNT);
        remove(PREV_BASIC);
        remove(PREV_APP_FILTER);
        remove(RANDOM_SMPID_GENERATED);
        remove(NEXT_PUSH_TYPE_FOR_FCM_PRIMARY_MODE);
        remove(PREV_APP_REFERRER_KEY);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void removeForSingleProcess(Context context, String str) {
        PrefInteractor.getInstance(context).remove(str);
    }

    public synchronized void removeNotiChannel(int i) {
        remove(KEY_PREFIX_CHANNEL + i);
    }

    public synchronized void removePushInfoAndSaveToCache() {
        try {
            String pushType = getPushType();
            SmpLog.m6498i(TAG, "remove push info. type : " + pushType);
            if (!TextUtils.isEmpty(pushType)) {
                setPushTypeCache(getPushType());
            }
            remove("pid");
            remove("ptype");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void removeStringSetForSingleProcess(Context context, String str, String str2) {
    }

    public synchronized void setAID(String str) {
        putString("aid", str);
    }

    public synchronized void setAckPeriod(long j) {
        putLong(ACK_PERIOD, j);
    }

    public synchronized void setActivePeriod(long j) {
        putLong(ACTIVE_PERIOD, j);
    }

    public synchronized void setActivityTrackingEnabled(boolean z) {
        putBoolean(ENABLE_ACTIVITY_TRACKING, z);
    }

    public synchronized void setBaseUrl(String str) {
        putString("baseUrl", str);
    }

    public synchronized void setConfigVersion(int i) {
        putInteger(CONFIG_VERSION, i);
    }

    public synchronized void setContentsTypePolicy(String str) {
        putString(CONTENTS_TYPE, str);
    }

    public synchronized void setDebugAlarmOn(boolean z) {
        putBoolean(DEBUG_ALARM, z);
    }

    public synchronized void setDebugJobOn(boolean z) {
        putBoolean(DEBUG_JOB, z);
    }

    public synchronized void setFcmServiceRetryCount(int i) {
        putInteger(FCM_SERVICE_RETRY_COUNT, i);
    }

    public synchronized void setInitCompleteTimeForSppForceActivationFeature(long j) {
        putLong(INIT_COMPLETE_TIME_FOR_SPP_FORCE_ACTIVATION_FEATURE, j);
    }

    public synchronized void setLastAckCompleteTime(long j) {
        putLong(LAST_ACK_COMPLETE_TIME, j);
    }

    public synchronized void setLastUploadCompleteTime(long j) {
        putLong(LAST_UPLOAD_COMPLETE_TIME, j);
    }

    public synchronized void setLastUploadTryTime(long j) {
        putLong(LAST_UPLOAD_TRY_TIME, j);
    }

    public synchronized void setLogEnabled(boolean z) {
        putBoolean(ENABLE_DEBUG_MODE, z);
    }

    public synchronized void setNextPushTypeForFcmPrimaryMode(String str) {
        putString(NEXT_PUSH_TYPE_FOR_FCM_PRIMARY_MODE, str);
    }

    public synchronized void setNotiChannelId(int i, String str) {
        putString(KEY_PREFIX_CHANNEL + i, str);
    }

    public synchronized void setNotiColor(int i) {
        putInteger(NOTI_COLOR, i);
    }

    public synchronized void setNotiGroup(String str) {
        putString(NOTI_GROUP, str);
    }

    public synchronized void setOptIn(boolean z) {
        putBoolean("optin", z);
    }

    public synchronized void setOptInTime(long j) {
        putLong("optintime", j);
    }

    public synchronized void setOptinPolicy(SmpConstants.OptInPolicy optInPolicy) {
        if (optInPolicy == null) {
            try {
                optInPolicy = SmpConstants.OptInPolicy.DEVICE_BASED;
            } catch (Throwable th) {
                throw th;
            }
        }
        putString(OPT_IN_POLICY, optInPolicy.name());
    }

    public synchronized void setPreferenceVersion(int i) {
        putInteger(SMP_PREFERENCE_VERSION, i);
    }

    public synchronized void setPrevAppFilterData(String str) {
        putString(PREV_APP_FILTER, str);
    }

    public synchronized void setPrevAppReferrerKeyData(String str) {
        putString(PREV_APP_REFERRER_KEY, str);
    }

    public synchronized void setPrevBasicData(String str) {
        putString(PREV_BASIC, str);
    }

    public synchronized void setPushModeForHkAndMo(SmpConstants.PushModeForHkAndMo pushModeForHkAndMo) {
        putString(PUSH_MODE_FOR_HK_AND_MO, pushModeForHkAndMo.name());
    }

    public synchronized void setPushToken(String str) {
        putString("pid", str);
    }

    public synchronized void setPushType(String str) {
        putString("ptype", str);
    }

    public synchronized void setRandomSmpIdGenerated(boolean z) {
        putBoolean(RANDOM_SMPID_GENERATED, z);
    }

    public synchronized void setSmpFristUploadTime(long j) {
        putLong(SMP_FIRST_UPLOAD_TIME, j);
    }

    public synchronized void setSmpID(String str) {
        putString("smpid", str);
    }

    public synchronized void setSoundEnabled(boolean z) {
        putBoolean(NOTI_SOUND_ENABLED, z);
    }

    public synchronized void setSoundUriString(String str) {
        putString(NOTI_SOUND_URI, str);
    }

    public synchronized void setSppAppId(String str) {
        putString(SPP_APP_ID, str);
    }

    public synchronized void setUID(String str) {
        putString("uid", str);
    }

    public synchronized void setUploadFailCount(int i) {
        putInteger(UPLOAD_FAIL_COUNT, i);
    }

    public synchronized void setUploadPeriod(long j) {
        putLong(UPLOAD_PERIOD, j);
    }

    public synchronized void setVibrateEnabled(boolean z) {
        putBoolean(NOTI_VIBRATE_ENABLED, z);
    }

    public synchronized void setVibratePattern(long[] jArr) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (long j : jArr) {
                jSONArray.put(j);
            }
            putString(NOTI_VIBRATE_PATTERN, jSONArray.toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setWebId(String str) {
        putString("webid", str);
    }
}
