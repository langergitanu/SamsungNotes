package com.samsung.context.sdk.samsunganalytics.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.os.UserManager;
import android.text.TextUtils;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.DBOpenHelper;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import com.samsung.context.sdk.samsunganalytics.UserAgreement;
import com.samsung.context.sdk.samsunganalytics.internal.connection.Directory;
import com.samsung.context.sdk.samsunganalytics.internal.connection.Domain;
import com.samsung.context.sdk.samsunganalytics.internal.device.DeviceInfo;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Constants;
import com.samsung.context.sdk.samsunganalytics.internal.policy.PolicyUtils;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Validation;
import com.samsung.context.sdk.samsunganalytics.internal.sender.DMA.DMALogSender;
import com.samsung.context.sdk.samsunganalytics.internal.sender.Sender;
import com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.Manager;
import com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.database.DbManager;
import com.samsung.context.sdk.samsunganalytics.internal.terms.RegisterType;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.DeleteApiCallChecker;
import com.samsung.context.sdk.samsunganalytics.internal.util.IdGenerator;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import com.sec.android.diagmonagent.common.util.executor.SingleThreadExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Tracker {
    public static final int AUID_TYPE_DMA = 4;
    public static final int AUID_TYPE_INAPP = 2;
    public static final int AUID_TYPE_MAKE_SDK = 1;
    public static final int AUID_TYPE_UNKNOWN = -1;
    public static final int DEVICE_ID_BIT_NUM = 128;
    private static final int FAIL = -1;
    private static final int NOT_INIT = 0;
    public static final String PERMISSION_TOKEN = "com.sec.spp.permission.TOKEN";
    private static final int SUCCESS = 1;
    private static final String TAG_ASYNC_SECTION_CONSTRUCTOR = "Tracker Constructor SingleThreadExecutor";
    private static final String TAG_ASYNC_SECTION_REGISTER_SETTING = "Tracker registerSettingPref SingleThreadExecutor";
    private static final String TAG_ASYNC_SECTION_SENDLOG = "Tracker SendLog SingleThreadExecutor";
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
    private final Application application;
    private final Configuration configuration;
    private final DeleteApiCallChecker deleteApiCallChecker;
    private final Context mContext;
    private int mStatus = 0;

    public Tracker(final Application application, final Configuration configuration) {
        Trace.beginSection("Tracker Constructor");
        this.application = application;
        this.configuration = configuration;
        Context applicationContext = application.getApplicationContext();
        this.mContext = applicationContext;
        this.deleteApiCallChecker = new DeleteApiCallChecker(applicationContext);
        if (!configuration.isEnableUseInAppLogging()) {
            configuration.setUserAgreement(new UserAgreement() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.1
                @Override // com.samsung.context.sdk.samsunganalytics.UserAgreement
                public boolean isAgreement() {
                    return Utils.isDiagnosticAgree(Tracker.this.mContext);
                }
            });
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Trace.beginAsyncSection("Tracker Constructor SingleThreadExecutor", -757204973);
        }
        SingleThreadExecutor.getInstance().execute(new AsyncTaskClient() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.2
            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public int onFinish() {
                return 0;
            }

            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public void run() {
                if (Tracker.this.isActivated()) {
                    if (!Utils.isAppVersionChanged(Tracker.this.mContext, Preferences.PREFS_KEY_APP_VERSION_FOR_INIT)) {
                        Utils.sendSettings(Tracker.this.mContext, configuration);
                        Utils.sendProperties(Tracker.this.mContext, configuration);
                    }
                    Utils.sendRegistration(application, configuration, RegisterType.SEND_PREVIOUS_REGISTRATION_INFO);
                }
            }
        });
        if (i >= 29) {
            Trace.endAsyncSection("Tracker Constructor SingleThreadExecutor", -757204973);
        }
        Debug.LogI("Tracker start:6.05.079");
        Trace.endSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDeviceId() {
        if (PolicyUtils.getSenderType() >= 2 || !TextUtils.isEmpty(this.configuration.getDeviceId())) {
            return true;
        }
        Debug.LogD("did is empty");
        return false;
    }

    private boolean hasPermission(Context context) {
        String[] strArr;
        PackageInfo servicePkgInfo = CommonUtils.getServicePkgInfo(context);
        if (servicePkgInfo != null && (strArr = servicePkgInfo.requestedPermissions) != null) {
            for (String str : strArr) {
                if (str.startsWith(PERMISSION_TOKEN)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int init() {
        if (this.mStatus == 0) {
            UserManager userManager = (UserManager) this.mContext.getSystemService(IdentityApiContract.Token.USER);
            if (userManager != null && !userManager.isUserUnlocked()) {
                Debug.LogD("current user is locked");
                this.mStatus = 0;
                return 0;
            }
            if (this.configuration.isEnableUseInAppLogging()) {
                if (TextUtils.isEmpty(this.configuration.getDeviceId())) {
                    if (!loadDeviceId() && this.configuration.isEnableAutoDeviceId()) {
                        String strCreateDeviceId = new IdGenerator().createDeviceId(this.mContext);
                        if (TextUtils.isEmpty(strCreateDeviceId)) {
                            this.mStatus = -1;
                            return -1;
                        }
                        setDeviceId(strCreateDeviceId);
                    }
                } else if (this.configuration.getAuidType() == -1 || this.configuration.getAuidType() == 2) {
                    Preferences.getPreferences(this.mContext).edit().putString("deviceId", this.configuration.getDeviceId()).putInt(Preferences.PREFS_KEY_DID_TYPE, 2).apply();
                    this.configuration.setAuidType(2);
                }
            }
            PolicyUtils.setSenderType(this.mContext, this.configuration);
            if (PolicyUtils.getSenderType() == 0) {
                setPolicy();
            }
            if (!this.configuration.isEnableUseInAppLogging() && !Validation.isLoggingEnableDevice(this.mContext)) {
                Debug.LogD("Device is not enabled for logging");
                this.mStatus = -1;
                return -1;
            }
            if (-1 == PolicyUtils.getSenderType()) {
                Debug.LogD("SenderType is None");
                this.mStatus = -1;
                return -1;
            }
            if (PolicyUtils.getSenderType() == 2 && !hasPermission(this.mContext)) {
                Utils.throwException("SamsungAnalytics2 need to define 'com.sec.spp.permission.TOKEN_XXXX' permission in AndroidManifest");
                this.mStatus = -1;
                return -1;
            }
            if (Utils.isSendingAppCommonSupported(this.mContext)) {
                sendAppCommon();
            }
            if (this.configuration.isAlwaysRunningApp()) {
                Utils.registerReceiver(this.mContext, this.configuration);
            }
        }
        this.mStatus = 1;
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isActivated() {
        boolean z = false;
        if (-1 == this.mStatus) {
            Debug.LogD("Tracker is not initialized, status : " + this.mStatus);
            return false;
        }
        if (1 == init() && this.deleteApiCallChecker.isNotOverLimit()) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUserAgreement() {
        return this.configuration.getUserAgreement().isAgreement();
    }

    private boolean loadDeviceId() {
        SharedPreferences preferences = Preferences.getPreferences(this.application);
        String string = preferences.getString("deviceId", "");
        int i = preferences.getInt(Preferences.PREFS_KEY_DID_TYPE, -1);
        if (TextUtils.isEmpty(string) || string.length() != 32 || i == -1) {
            return false;
        }
        this.configuration.setAuidType(i);
        this.configuration.setDeviceId(string);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Application.ActivityLifecycleCallbacks makeActivityLifecycleCallbacks() {
        if (this.activityLifecycleCallbacks == null) {
            this.activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.8
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Tracker.this.sendLog(new LogBuilders.ScreenViewBuilder().setScreenView(activity.getComponentName().getShortClassName()).build());
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }
            };
        }
        return this.activityLifecycleCallbacks;
    }

    private void requestDeleteLogData(final RegisterType registerType) {
        SingleThreadExecutor.getInstance().execute(new AsyncTaskClient() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.6
            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public int onFinish() {
                return 0;
            }

            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public void run() {
                if (Tracker.this.configuration.isEnableUseInAppLogging() && Tracker.this.isActivated()) {
                    Utils.sendRegistration(Tracker.this.application, Tracker.this.configuration, registerType);
                    if (Tracker.this.configuration.getAuidType() == 1 && registerType == RegisterType.DELETE_APP_DATA) {
                        Debug.LogD("Reset deviceid");
                        String strRecreateDeviceId = new IdGenerator().recreateDeviceId(Tracker.this.mContext, Tracker.this.configuration.getDeviceId());
                        if (TextUtils.isEmpty(strRecreateDeviceId)) {
                            Tracker.this.mStatus = -1;
                        } else {
                            Tracker.this.setDeviceId(strRecreateDeviceId);
                        }
                    }
                    Tracker.this.deleteApiCallChecker.increaseCount();
                }
            }
        });
    }

    private void sendAppCommon() {
        if ((Utils.isProvidingDataSupported(this.mContext) || isUserAgreement()) && PolicyUtils.getSenderType() == 3) {
            SharedPreferences preferences = Preferences.getPreferences(this.mContext);
            String packageVersion = CommonUtils.getPackageVersion(this.mContext);
            if (TextUtils.isEmpty(packageVersion)) {
                packageVersion = "None";
            }
            boolean z = preferences.getBoolean(Preferences.PREFS_KEY_SEND_COMMON_SUCCESS, false);
            String string = preferences.getString("appVersion", "None");
            Long lValueOf = Long.valueOf(preferences.getLong(Preferences.PREFS_KEY_SEND_COMMON_TIME, 0L));
            StringBuilder sbM16m = AbstractC0000a.m16m("AppVersion = ", packageVersion, ", prefAppVersion = ", string, ", beforeSendCommonTime = ");
            sbM16m.append(lValueOf);
            sbM16m.append(", success = ");
            sbM16m.append(z);
            Debug.LogD(sbM16m.toString());
            if (!packageVersion.equals(string) || ((z && Utils.compareDays(7, lValueOf)) || (!z && Utils.compareHours(6, lValueOf)))) {
                Debug.LogD("send app common");
                preferences.edit().putString("appVersion", packageVersion).putLong(Preferences.PREFS_KEY_SEND_COMMON_TIME, System.currentTimeMillis()).apply();
                ((DMALogSender) Sender.get(this.application, 3, this.configuration)).sendCommon();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceId(String str) {
        Preferences.getPreferences(this.mContext).edit().putString("deviceId", str).putInt(Preferences.PREFS_KEY_DID_TYPE, 1).apply();
        this.configuration.setAuidType(1);
        this.configuration.setDeviceId(str);
    }

    private void setPolicy() {
        SharedPreferences preferences = Preferences.getPreferences(this.application);
        Domain.DLS.setDomain(preferences.getString(Constants.KEY_DLS_DOMAIN, ""));
        Directory.DLS_DIR.setDirectory(preferences.getString("uri", ""));
        Directory.DLS_DIR_BAT.setDirectory(preferences.getString(Constants.KEY_DLS_URI_BAT, ""));
        if (PolicyUtils.isPolicyExpired(this.mContext)) {
            PolicyUtils.updatePolicy(this.application, this.configuration, SingleThreadExecutor.getInstance(), DeviceInfo.getDeviceInfo(this.mContext), new Callback<Void, Boolean>() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.7
                @Override // com.samsung.context.sdk.samsunganalytics.internal.Callback
                public Void onResult(Boolean bool) {
                    if (!bool.booleanValue()) {
                        return null;
                    }
                    DBOpenHelper dbOpenHelper = Tracker.this.configuration.getDbOpenHelper();
                    if (dbOpenHelper == null) {
                        Manager.getInstance(Tracker.this.mContext, Tracker.this.configuration).enableDatabaseBuffering(Tracker.this.mContext);
                        return null;
                    }
                    Manager.getInstance(Tracker.this.mContext, Tracker.this.configuration).enableDatabaseBuffering(new DbManager(dbOpenHelper));
                    return null;
                }
            });
        }
    }

    public void deleteLogData() {
        requestDeleteLogData(RegisterType.DELETE_APP_DATA);
    }

    public void deleteSensitiveLogData() {
        if (Utils.isDeletionOfSensitiveDataSupported(this.mContext)) {
            requestDeleteLogData(RegisterType.DELETE_SENSITIVE_APP_DATA);
        } else {
            deleteLogData();
        }
    }

    public void disable() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        Application application = this.application;
        if (application != null && (activityLifecycleCallbacks = this.activityLifecycleCallbacks) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        Utils.unregisterReceiver(this.mContext);
        PolicyUtils.initSenderType();
        Sender.init();
    }

    public void enableAutoActivityTracking() {
        SingleThreadExecutor.getInstance().execute(new AsyncTaskClient() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.4
            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public int onFinish() {
                return 0;
            }

            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public void run() {
                if (Tracker.this.activityLifecycleCallbacks == null) {
                    Tracker.this.application.registerActivityLifecycleCallbacks(Tracker.this.makeActivityLifecycleCallbacks());
                }
            }
        });
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public void registerSettingPref(final Map<String, Set<String>> map) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Trace.beginAsyncSection("Tracker registerSettingPref SingleThreadExecutor", 499562429);
        }
        SingleThreadExecutor.getInstance().execute(new AsyncTaskClient() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.5
            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public int onFinish() {
                return 0;
            }

            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public void run() {
                Utils.registerSettings(Tracker.this.mContext, map);
                if (Tracker.this.isActivated()) {
                    Utils.sendSettings(Tracker.this.mContext, Tracker.this.configuration);
                }
            }
        });
        if (i >= 29) {
            Trace.endAsyncSection("Tracker registerSettingPref SingleThreadExecutor", 499562429);
        }
    }

    public int sendLog(final Map<String, String> map) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Trace.beginAsyncSection("Tracker SendLog SingleThreadExecutor", 1468411569);
        }
        SingleThreadExecutor.getInstance().execute(new AsyncTaskClient() { // from class: com.samsung.context.sdk.samsunganalytics.internal.Tracker.3
            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public int onFinish() {
                return 0;
            }

            @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
            public void run() {
                String str;
                if (Tracker.this.isActivated()) {
                    if (!Utils.isProvidingDataSupported(Tracker.this.mContext)) {
                        if (!Tracker.this.isUserAgreement()) {
                            Debug.LogD("user do not agree");
                            return;
                        } else {
                            map.remove("pd");
                            map.remove("ps");
                        }
                    }
                    Map map2 = map;
                    if (map2 == null || map2.isEmpty()) {
                        Debug.LogD("Failure to send Logs : No data");
                        return;
                    }
                    if (Tracker.this.checkDeviceId()) {
                        if ("pp".equals(map.get("t"))) {
                            Utils.registerProperties(Tracker.this.mContext, map);
                            Utils.sendProperties(Tracker.this.mContext, Tracker.this.configuration);
                            return;
                        }
                        if ("ev".equals(map.get("t")) && (str = (String) map.get("et")) != null && (str.equals(String.valueOf(10)) || str.equals(String.valueOf(11)))) {
                            String string = Preferences.getPropertyPreferences(Tracker.this.mContext).getString("guid", "");
                            if (!TextUtils.isEmpty(string)) {
                                String str2 = (String) map.get("cd");
                                Map map3 = TextUtils.isEmpty(str2) ? new HashMap() : Utils.parseDelimiterString(str2, Utils.Depth.TWO_DEPTH);
                                map3.put("guid", string);
                                map.put("cd", Utils.makeDelimiterString(Validation.checkSizeLimit(map3), Utils.Depth.TWO_DEPTH));
                            }
                        }
                        Sender.get(Tracker.this.application, PolicyUtils.getSenderType(), Tracker.this.configuration).send(map);
                    }
                }
            }
        });
        if (i < 29) {
            return 0;
        }
        Trace.endAsyncSection("Tracker SendLog SingleThreadExecutor", 1468411569);
        return 0;
    }
}
