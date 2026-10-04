package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.p145cm.base.framework.app.AiActionStatusCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.common.cms.SamsungAccountConsentHelper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.SamsungAccountUtil;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.AiProgressActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AIFeatureInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiActionStatus {
    private static final int AI_DEFAULT_ENABLED = 2;
    private static final int AI_DRAWING_ENABLED = 4;
    private static final int AI_MATH_ENABLED = 8;
    private static final int CONFIRM = 1;
    private static final String CREATE_IMAGE_CONFIG_GETTER = "drawing_assist_config_get";
    private static final String CREATE_IMAGE_CONFIG_IS_ENABLED = "is_enabled";
    private static final String CREATE_IMAGE_CONFIG_SETTER = "drawing_assist_config_set";
    private static final String CREATE_IMAGE_SCRIBBLE_WEIGHT = "scribble_weight";
    private static final String CREATE_IMAGE_SCRIBBLE_WEIGHT_GETTER = "drawing_assist_scribble_weight_get";
    private static final String CREATE_IMAGE_SKETCH_BOOK_AUTHORITY = "com.samsung.android.app.sketchbook.ConfigProvider";
    private static final String CREATE_IMAGE_SMART_CAPTURE_AUTHORITY = "com.samsung.android.aidrawing.ConfigProvider";
    private static final int NOT_CONFIRM = 0;
    public static final int REQUEST_DRAWING_ASSIST_NOTICE = 817;
    public static final int REQUEST_INTENT_ACCOUNT_AI_PERMISSION = 810;
    public static final int REQUEST_INTENT_ACCOUNT_AI_PERMISSION_WITH_SETTINGS = 811;
    public static final int REQUEST_INTENT_ACCOUNT_SIGN_UP = 808;
    public static final int REQUEST_INTENT_ACCOUNT_SIGN_UP_WITH_SETTINGS = 809;
    public static final int REQUEST_INTENT_PREVENT_AI_SETTINGS = 812;
    public static final int REQUEST_INTENT_TOKEN = 815;
    public static final int REQUEST_INTENT_TOKEN_RETRY = 816;
    public static final int REQUEST_PIN_REQUEST = 813;
    public static final int REQUEST_PROGRESS = 814;
    private static final String SETTINGS_AI_CONFIRM = "ai_info_confirmed";
    public static final String SETTINGS_PREVENT_ONLINE_PROCESSING = "prevent_online_processing";
    private static final String SETTINGS_USER_ID_HASH = "user_id_hash";
    private static final String START_DRAWING_FTU_DIALOG = "com.samsung.android.drawing.START_FTU_DIALOG";
    private static final String START_DRAWING_FTU_STATUS = "ftu_status";
    private static final String UNCONSENT_PIN_CASE_RELATED_ACTION = "com.samsung.android.samsungaccount.action.REQUEST_CONSENT_AGREEMENT";
    private static final String UNCONSENT_PIN_CASE_RELATED_ERROR_CODE = "error_code";
    private static final String UNCONSENT_PIN_CASE_RELATED_ERROR_MESSAGE = "error_message";
    private static final String UNCONSENT_PIN_CASE_RELATED_INTENT_ACCESS_TOKEN = "access_token";
    private static final String UNCONSENT_PIN_CASE_RELATED_INTENT_APPLICATION_REGION = "application_region";
    private static final String UNCONSENT_PIN_CASE_RELATED_INTENT_APP_VERSION = "app_version";
    private static final String UNCONSENT_PIN_CASE_RELATED_INTENT_CLIENT_ID = "client_id";
    private static final String UNCONSENT_PIN_CASE_RELATED_INTENT_LANGUAGE = "language";
    private static final String UNCONSENT_PIN_CASE_RELATED_INTENT_REGION = "region";
    private static final String UNCONSENT_PIN_CASE_RELATED_IS_AGREE = "isAgreed";
    private static final int UNKNOWN = -1;
    private Runnable mCancelAction;
    private final DIALOG_TYPE mDialogType;
    private boolean mIsServerChecked;
    private final LOGIN_PAGE mLoginPage;
    private Runnable mOkAction;
    private boolean mValidationCheck;
    private static final String TAG = Logger.createTag("AiActionStatus", AiConstants.PREFIX_TAG);
    private static int FTU_VERSION = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DIALOG_TYPE {
        ON_DEVICE,
        SERVER,
        AI_DRAWING_NOTICE,
        SUMMARY_SETTING,
        AUDIO_ERASER,
        NONE
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LOGIN_PAGE {
        SETTINGS,
        POPUP
    }

    public AiActionStatus(Runnable runnable) {
        this.mIsServerChecked = AIFeatureInfoManager.isServerChecked();
        this.mValidationCheck = false;
        this.mLoginPage = LOGIN_PAGE.POPUP;
        this.mOkAction = runnable;
        this.mDialogType = DIALOG_TYPE.NONE;
    }

    private static void checkFtuVersion() {
        int i = FTU_VERSION;
        if (FeatureInfo.isAiFeatureEnabled()) {
            FTU_VERSION |= 2;
        }
        if (FeatureInfo.isAiDrawingS2IEnabled()) {
            FTU_VERSION |= 4;
        }
        if (FeatureInfo.isNeedNoticeSolveMath()) {
            FTU_VERSION |= 8;
        }
        if (i != FTU_VERSION) {
            AbstractC8014b.m7195A(AbstractC0541b.m778t(i, "ftuVersion change from # ", " to # "), TAG, FTU_VERSION);
        }
    }

    public static void enableDrawingAssist(boolean z) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(CREATE_IMAGE_CONFIG_IS_ENABLED, z);
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                Logger.m11000e(TAG, "enableDrawingAssist, context is null");
                return;
            }
            if (applicationContext.getContentResolver() == null) {
                Logger.m11000e(TAG, "enableDrawingAssist, contentResolver is null");
                return;
            }
            if (Features.isDrawingSupportSketchBookInstalled()) {
                applicationContext.getContentResolver().call("com.samsung.android.app.sketchbook.ConfigProvider", "drawing_assist_config_set", (String) null, bundle);
            } else if (Features.isDrawingSupportSmartCaptureInstalled()) {
                applicationContext.getContentResolver().call("com.samsung.android.aidrawing.ConfigProvider", "drawing_assist_config_set", (String) null, bundle);
            } else {
                Logger.m11000e(TAG, "enableDrawingAssist, supported app is not installed");
            }
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("enableDrawingAssist, Exception : "), TAG);
        }
    }

    private int getAccountAge() {
        return AIFeatureInfoManager.getChildAge();
    }

    public static float getDrawingAssistScribbleWeight() {
        Context applicationContext;
        if (Build.VERSION.SDK_INT >= 29) {
            Bundle bundleCall = null;
            try {
                applicationContext = BaseUtils.getApplicationContext();
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("isDrawingAssistEnabled, Exception : "), TAG);
            }
            if (applicationContext == null) {
                Logger.m11000e(TAG, "isDrawingAssistEnabled, context is null");
                return 0.8f;
            }
            if (applicationContext.getContentResolver() == null) {
                Logger.m11000e(TAG, "isDrawingAssistEnabled, contentResolver is null");
                return 0.8f;
            }
            if (Features.isDrawingSupportSketchBookInstalled()) {
                bundleCall = applicationContext.getContentResolver().call("com.samsung.android.app.sketchbook.ConfigProvider", "drawing_assist_scribble_weight_get", (String) null, (Bundle) null);
            }
            if (bundleCall != null) {
                return bundleCall.getFloat("scribble_weight", 0.8f);
            }
        }
        return 0.8f;
    }

    @NonNull
    private static Intent getIntent(SamsungAccountConsentHelper samsungAccountConsentHelper) {
        Intent intentM2214e = AbstractC2821a.m2214e(UNCONSENT_PIN_CASE_RELATED_ACTION, "com.osp.app.signin");
        intentM2214e.putExtra("client_id", samsungAccountConsentHelper.getAppKey());
        intentM2214e.putExtra("language", samsungAccountConsentHelper.getLanguage());
        intentM2214e.putExtra("region", samsungAccountConsentHelper.getRegion());
        intentM2214e.putExtra(UNCONSENT_PIN_CASE_RELATED_INTENT_APPLICATION_REGION, SamsungAccountUtil.getApplicationRegion());
        intentM2214e.putExtra("access_token", RequestToSamsungAccountManager.INSTANCE.getAccessToken());
        intentM2214e.putExtra("app_version", samsungAccountConsentHelper.getAppVersion());
        return intentM2214e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getInvalidLoggedIn() {
        return (!RequestToSamsungAccountManager.INSTANCE.getInvalidLoggedIn() || this.mDialogType == DIALOG_TYPE.ON_DEVICE || DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) ? false : true;
    }

    public static String getUserIdHash() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SETTINGS_USER_ID_HASH, null);
    }

    public static boolean isAiFeatureEnable() {
        boolean zIsAiShopDemoDevice = DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext());
        boolean z = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST, zIsAiShopDemoDevice);
        Logger.m11003i(TAG, "isAiFeatureEnable#isDemoDevice: " + zIsAiShopDemoDevice + " isAiFeatureEnabled: " + z);
        return z;
    }

    private boolean isAudioEraserFeature() {
        return this.mDialogType == DIALOG_TYPE.AUDIO_ERASER;
    }

    public static boolean isAutoTranscribeEnable() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE, false) && Features.isSupportAutoTranscribeFunction();
    }

    public static boolean isDrawingAssistEnabled() {
        Bundle bundleCall;
        Context applicationContext;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                applicationContext = BaseUtils.getApplicationContext();
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("isDrawingAssistEnabled, Exception : "), TAG);
                bundleCall = null;
            }
            if (applicationContext == null) {
                Logger.m11000e(TAG, "isDrawingAssistEnabled, context is null");
                return false;
            }
            if (applicationContext.getContentResolver() == null) {
                Logger.m11000e(TAG, "isDrawingAssistEnabled, contentResolver is null");
                return false;
            }
            if (Features.isDrawingSupportSketchBookInstalled()) {
                bundleCall = applicationContext.getContentResolver().call("com.samsung.android.app.sketchbook.ConfigProvider", "drawing_assist_config_get", (String) null, (Bundle) null);
            } else {
                if (!Features.isDrawingSupportSmartCaptureInstalled()) {
                    Logger.m11000e(TAG, "isDrawingAssistEnabled, supported app is not installed");
                    return false;
                }
                bundleCall = applicationContext.getContentResolver().call("com.samsung.android.aidrawing.ConfigProvider", "drawing_assist_config_get", (String) null, (Bundle) null);
            }
            if (bundleCall != null) {
                return bundleCall.getBoolean(CREATE_IMAGE_CONFIG_IS_ENABLED);
            }
        }
        return false;
    }

    private static boolean isInvalidate(Activity activity) {
        boolean zIsNetworkAvailable = isNetworkAvailable();
        boolean z = !zIsNetworkAvailable;
        if (!zIsNetworkAvailable) {
            ToastHandler.show(activity, C9086R.string.ai_network_connection_error_msg, 0);
            RequestToSCloudManager.INSTANCE.getInstance().printDataNetworkLog();
        }
        return z;
    }

    public static boolean isKidsAccountBlocked() {
        return RequestToSamsungAccountManager.INSTANCE.isChildAccount() && !SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel();
    }

    private boolean isLoginedNotRequired() {
        return RequestToSamsungAccountManager.INSTANCE.isLogined() || DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext());
    }

    private boolean isNeedAiFeatureEnableDialog() {
        if (isSettingsPage() || this.mDialogType == DIALOG_TYPE.SUMMARY_SETTING) {
            return false;
        }
        return isChangedUserAccount() || !isAiFeatureEnable();
    }

    private boolean isNeedShowDrawingAssistNotice() {
        if (DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()) || this.mDialogType != DIALOG_TYPE.AI_DRAWING_NOTICE) {
            return false;
        }
        return !isDrawingAssistEnabled();
    }

    private boolean isNeedShowServerAiFeature() {
        return !isNoticedServerAiFeature() || isNeedAiFeatureEnableDialog() || isServerAiFeatureChanged();
    }

    public static boolean isNetworkAvailable() {
        RequestToSCloudManager.Companion companion = RequestToSCloudManager.INSTANCE;
        return companion.getInstance().isWiFiAvailable() || companion.getInstance().isDataNetworkAvailable();
    }

    public static boolean isPreventOnlineProcessing() {
        return Settings.System.getInt(BaseUtils.getApplicationContext().getContentResolver(), SETTINGS_PREVENT_ONLINE_PROCESSING, -1) == 1;
    }

    private boolean isServerAiFeatureChanged() {
        if (isSettingsPage() || DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
            return false;
        }
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_SERVER_CHANGED, false);
    }

    private boolean isServerCheckRequested() {
        if (DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
            return true;
        }
        if (isKidsAccountBlocked() && !AIFeatureInfoManager.hasChildAge() && isNetworkAvailable()) {
            return false;
        }
        DIALOG_TYPE dialog_type = this.mDialogType;
        if (dialog_type == DIALOG_TYPE.AUDIO_ERASER) {
            return true;
        }
        if (dialog_type == DIALOG_TYPE.ON_DEVICE && !isNetworkAvailable()) {
            return true;
        }
        if (this.mValidationCheck || !(TokenManager.checkServerDataInvalidate() || AIFeatureInfoManager.getIsUnconsentPinCaseRelated())) {
            return this.mIsServerChecked;
        }
        return false;
    }

    private boolean isSettingsNotConfirmed() {
        return !DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()) && Features.supportSystemAiPermission(BaseUtils.getApplicationContext()) && !isKidsAccountBlocked() && Settings.System.getInt(BaseUtils.getApplicationContext().getContentResolver(), SETTINGS_AI_CONFIRM, 0) == 0;
    }

    private boolean isSettingsPreventOnlineProcessing() {
        if (isSettingsPage() || this.mDialogType == DIALOG_TYPE.ON_DEVICE) {
            return false;
        }
        return isPreventOnlineProcessing();
    }

    public static boolean isSummaryOnDeviceFeatureEnable() {
        return (SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY, false) || isPreventOnlineProcessing()) && Features.isSupportOnDeviceSummaryFunction() && !SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel();
    }

    private boolean isUnconsentPinCaseRelated() {
        if (this.mDialogType != DIALOG_TYPE.ON_DEVICE || isNetworkAvailable()) {
            return AIFeatureInfoManager.getIsUnconsentPinCaseRelated();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeAiNoticeDialog$0(Activity activity) {
        setAiFeatureEnable(true, !isSettingsPage());
        noticedServerAiFeature();
        if (SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_SERVER_CHANGED, false)) {
            SharedPreferencesCompat.getInstance("Settings").remove(SettingsConstants.SETTINGS_NOTES_ASSIST_SERVER_CHANGED);
            if (isNetworkAvailable() && RequestToSamsungAccountManager.INSTANCE.isLogined() && !DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
                AIFeatureInfoManager.requestAIFeatureInfo();
            }
        }
        if (isAiActionStatusEnabled()) {
            execute(activity);
        } else {
            requestAiActionStatusEnabled(activity);
        }
    }

    public static void noticedServerAiFeature() {
        checkFtuVersion();
        Logger.m11003i(TAG, "noticedServerAiFeature# " + FTU_VERSION);
        SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.SETTINGS_NOTES_ASSIST_NOTICE_SERVER_AI_FEATURE, FTU_VERSION);
    }

    private void onActivityAiGrantedResult(Activity activity, int i) {
        if (i != -1) {
            release();
        } else if (isLoginedNotRequired()) {
            onActivityResultSettingsConfirmed(activity);
        } else {
            RequestToSamsungAccountManager.INSTANCE.loginPopupSamsungAccount(activity, REQUEST_INTENT_ACCOUNT_SIGN_UP);
        }
    }

    private void onActivityAiGrantedResultWithSettings(Activity activity, int i) {
        if (i != -1) {
            release();
        } else if (isLoginedNotRequired()) {
            onActivityResultSettingsConfirmed(activity);
        } else {
            RequestToSamsungAccountManager.INSTANCE.loginPopupSamsungAccount(activity, REQUEST_INTENT_ACCOUNT_SIGN_UP_WITH_SETTINGS);
        }
    }

    private void onActivityDrawingAssistNoticeResult(Activity activity, int i) {
        boolean zIsDrawingAssistEnabled = isDrawingAssistEnabled();
        Logger.m10999d(TAG, "onActivityDrawingAssistNoticeResult# resultCode: " + i + ", isDrawingAssistEnabled: " + zIsDrawingAssistEnabled);
        if (!zIsDrawingAssistEnabled) {
            release();
        } else if (isAiActionStatusEnabled()) {
            execute(activity);
        } else {
            requestAiActionStatusEnabled(activity);
        }
    }

    private void onActivityIsUnconsentPinCaseRelatedResult(Activity activity, int i, @Nullable Intent intent) {
        boolean booleanExtra = true;
        if (i == -1) {
            if (intent != null) {
                booleanExtra = intent.getBooleanExtra(UNCONSENT_PIN_CASE_RELATED_IS_AGREE, false);
            } else if (!RequestToSamsungAccountManager.INSTANCE.isChildAccount()) {
                booleanExtra = false;
            }
            if (booleanExtra) {
                AIFeatureInfoManager.setIsUnconsentPinCaseRelated(false);
                if (isAiActionStatusEnabled()) {
                    execute(activity);
                    return;
                } else {
                    requestAiActionStatusEnabled(activity);
                    return;
                }
            }
        } else if (i == 1) {
            String stringExtra = intent.getStringExtra("error_code");
            String stringExtra2 = intent.getStringExtra("error_message");
            Logger.m11000e(TAG, "onActivityIsUnconsentPinCaseRelatedResult# " + stringExtra + " " + stringExtra2);
        }
        release();
    }

    private void onActivityLoginResult(Activity activity, int i) {
        if (i == -1 || isLoginedNotRequired()) {
            onActivityResultSettingsConfirmed(activity);
        } else {
            release();
        }
    }

    private void onActivityLoginResultWithPreventOnlineProcessing(Activity activity) {
        if (isSettingsPreventOnlineProcessing()) {
            release();
        } else {
            execute(activity);
        }
    }

    private void onActivityLoginResultWithSettings(Activity activity, int i) {
        if (i == -1 || isLoginedNotRequired()) {
            onActivityResultSettingsConfirmed(activity);
        } else {
            release();
        }
    }

    private void onActivityResultSettingsConfirmed(Activity activity) {
        setSettingsConfirmed();
        if (isAiActionStatusEnabled()) {
            execute(activity);
        } else {
            requestAiActionStatusEnabled(activity);
        }
    }

    private void onActivityServerResult(Activity activity, int i, @Nullable Intent intent) {
        this.mIsServerChecked = true;
        AbstractC0000a.m3D(i, "onActivityServerResult# ", TAG);
        if (i == -1 || getInvalidLoggedIn()) {
            AIFeatureInfoManager.setAIFeatureInfo();
            if (isAiActionStatusEnabled()) {
                execute(activity);
                return;
            } else {
                requestAiActionStatusEnabled(activity);
                return;
            }
        }
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        if (companion.getInvalidLoggedIn() || ErrorCodeConvertor.NOT_REGISTER_COMPLETED.equals(intent.getAction())) {
            companion.loginRequestAccessToken(activity, REQUEST_INTENT_TOKEN);
        } else {
            release();
        }
    }

    private void onActivityTokenResult(Activity activity, int i) {
        if (i != -1) {
            release();
            return;
        }
        RequestToSamsungAccountManager.INSTANCE.clearInvalidLoggedIn();
        this.mIsServerChecked = AIFeatureInfoManager.resetAIFeatureInfo();
        if (isAiActionStatusEnabled()) {
            execute(activity);
        } else {
            requestAiActionStatusEnabled(activity);
        }
    }

    private void onActivityTokenRetryResult(int i) {
        if (i == -1) {
            RequestToSamsungAccountManager.INSTANCE.clearInvalidLoggedIn();
            this.mIsServerChecked = AIFeatureInfoManager.resetAIFeatureInfo();
            if (AIFeatureInfoManager.checkServerInvalidate()) {
                AIFeatureInfoManager.requestAIFeatureInfo(new AIFeatureInfoManager.Listener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatus.3
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
                    public void checkedProgress() {
                        if (AiActionStatus.this.mOkAction != null) {
                            Logger.m11003i(AiActionStatus.TAG, "onActivityTokenRetryResult success");
                            AiActionStatus.this.mOkAction.run();
                            AiActionStatus.this.mOkAction = null;
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
                    public void stopProgress(String str) {
                        if (AiActionStatus.this.mOkAction != null) {
                            Logger.m11003i(AiActionStatus.TAG, "onActivityTokenRetryResult success");
                            AiActionStatus.this.mOkAction.run();
                            AiActionStatus.this.mOkAction = null;
                        }
                    }
                }, true, false);
                return;
            }
        }
        if (this.mOkAction != null) {
            Logger.m11003i(TAG, "onActivityTokenRetryResult");
            this.mOkAction.run();
            this.mOkAction = null;
        }
    }

    public static void resetAIFeatureInfo() {
        AIFeatureInfoManager.resetAIFeatureInfo();
        setAiFeatureEnable(false, false);
        SharedPreferencesCompat.getInstance("Settings").remove(SettingsConstants.SETTINGS_NOTES_ASSIST_NOTICE_SERVER_AI_FEATURE);
    }

    public static void setAiFeatureEnable(boolean z, boolean z2) {
        String userIdHash = getUserIdHash();
        setUserIdHash(RequestToSamsungAccountManager.INSTANCE.getUserIdHash());
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST, z);
        if (!TextUtils.isEmpty(userIdHash) && !userIdHash.equals(getUserIdHash())) {
            AIFeatureInfoManager.resetAIFeatureInfo();
            SharedPreferencesCompat.getInstance("Settings").remove(SettingsConstants.SETTINGS_NOTES_ASSIST_NOTICE_SERVER_AI_FEATURE);
        }
        if (z2 && z && !PolicyManager.isEdmPolicyAiDrawingGrayout() && !isDrawingAssistEnabled()) {
            enableDrawingAssist(true);
        }
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_LOCAL_CHANGED, true);
    }

    public static void setAutoTranscribeEnable(boolean z) {
        Logger.m10999d(TAG, "setAutoTranscribeEnable: " + z);
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE, z);
    }

    private void setSettingsConfirmed() {
        if (DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()) || DeviceInfo.isVSTModel()) {
            return;
        }
        try {
            Settings.System.putInt(BaseUtils.getApplicationContext().getContentResolver(), SETTINGS_AI_CONFIRM, 1);
            Logger.m11003i(TAG, "setSettingsConfirmed# success");
        } catch (Exception e) {
            Logger.m11003i(TAG, "setSettingsConfirmed# failed " + e.getMessage());
        }
    }

    public static void setSummaryOnDeviceFeatureEnable(boolean z) {
        AbstractC8014b.m7224z("setSummaryOnDeviceFeatureEnable ", TAG, z);
        if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() && z) {
            return;
        }
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY, z);
    }

    public static void setUserIdHash(String str) {
        SharedPreferencesCompat.getInstance("Settings").putString(SETTINGS_USER_ID_HASH, str);
    }

    private void showAiDrawingNoticeDialog(Activity activity) {
        Logger.m11003i(TAG, "showAiDrawingNoticeDialog");
        if (CommonUtil.isNotAvailableActivity(activity)) {
            release();
            return;
        }
        Intent intent = new Intent();
        if (Features.isDrawingSupportSketchBookInstalled()) {
            intent.setPackage(Features.PACKAGE_NAME_SKETCH_BOOK);
        } else if (Features.isDrawingSupportSmartCaptureInstalled()) {
            intent.setPackage(Features.PACKAGE_NAME_SMART_CAPTURE);
        }
        intent.setAction(START_DRAWING_FTU_DIALOG);
        intent.putExtra(START_DRAWING_FTU_STATUS, activity.getPackageName());
        try {
            activity.startActivityForResult(intent, REQUEST_DRAWING_ASSIST_NOTICE);
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, "showAiDrawingNoticeDialog, Exception : " + e.getMessage());
        }
    }

    private void showAiNoticeDialog(Activity activity, Runnable runnable, Runnable runnable2) {
        Logger.m11003i(TAG, "showAiNoticeDialog");
        if (CommonUtil.isNotAvailableActivity(activity)) {
            release();
        } else {
            new AiNoticeDialog().show(activity, runnable, runnable2, isSettingsPage());
        }
    }

    private void showKidsAccountBlockDialog(Activity activity) {
        showKidsNoticeDialog(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatus.4
            @Override // java.lang.Runnable
            public void run() {
                AiActionStatus.this.release();
            }
        });
    }

    private void showKidsNoticeDialog(Activity activity, Runnable runnable) {
        Logger.m11003i(TAG, "showKidNoticeDialog");
        if (CommonUtil.isNotAvailableActivity(activity)) {
            release();
        } else {
            new KidsNoticeDialog().show(activity, runnable, getAccountAge());
        }
    }

    private void showPreventAiNoticeDialog(Activity activity, Runnable runnable, Runnable runnable2) {
        Logger.m11003i(TAG, "showPreventAiNoticeDialog");
        if (CommonUtil.isNotAvailableActivity(activity)) {
            release();
        } else {
            new PreventAiNoticeDialog().show(activity, runnable, runnable2);
        }
    }

    private void showPreventOnlineProcessingDialog(final Activity activity) {
        if (showToastIfOnlineProcessingDisallowed(activity.getApplicationContext())) {
            release();
        } else {
            showPreventAiNoticeDialog(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatus.5
                @Override // java.lang.Runnable
                public void run() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatus.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestToSamsungAccountManager.INSTANCE.requestPreventOnlineProcessingSettings(activity, AiActionStatus.REQUEST_INTENT_PREVENT_AI_SETTINGS);
                        }
                    });
                }
            }, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatus.6
                @Override // java.lang.Runnable
                public void run() {
                    AiActionStatus.this.release();
                }
            });
        }
    }

    private void showProgressDialogActivity(Activity activity) {
        Logger.m11003i(TAG, "showProgressDialogActivity");
        if (CommonUtil.isNotAvailableActivity(activity)) {
            release();
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) AiProgressActivity.class);
        intent.setFlags(603979776);
        activity.startActivityForResult(intent, REQUEST_PROGRESS);
    }

    private static boolean showToastIfOnlineProcessingDisallowed(Context context) {
        return AiActionStatusCompat.INSTANCE.getInstance().showToastIfOnlineProcessingDisallowed(context);
    }

    private void showUnconsentPinCaseRelatedRequest(Activity activity) {
        if (activity == null) {
            return;
        }
        Intent intent = getIntent(new SamsungAccountConsentHelper());
        if (activity.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            Logger.m11000e(TAG, "showUnconsentPinCaseRelatedRequest# queryIntentActivities return");
            return;
        }
        try {
            activity.startActivityForResult(intent, REQUEST_PIN_REQUEST);
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, "showUnconsentPinCaseRelatedRequest# " + e.getMessage());
        }
    }

    public void execute(Activity activity) {
        DIALOG_TYPE dialog_type;
        if (!isSettingsPage() && (dialog_type = this.mDialogType) != DIALOG_TYPE.AUDIO_ERASER && dialog_type != DIALOG_TYPE.SUMMARY_SETTING && dialog_type != DIALOG_TYPE.ON_DEVICE && isInvalidate(activity)) {
            Logger.m11003i(TAG, "executeAction failed");
            release();
            return;
        }
        Logger.m11003i(TAG, "executeAction success");
        Runnable runnable = this.mOkAction;
        if (runnable != null) {
            runnable.run();
            this.mOkAction = null;
        }
        if (this.mCancelAction != null) {
            this.mCancelAction = null;
        }
        TokenManager.setCheckPeriod();
    }

    public void executeAiNoticeDialog(Activity activity) {
        showAiNoticeDialog(activity, new RunnableC8515c(this, activity, 24), new RunnableC8669a(this, 26));
    }

    public void executeRetryAction(final Activity activity) {
        Logger.m11003i(TAG, "executeRetryAction");
        AIFeatureInfoManager.requestAIFeatureInfo(new AIFeatureInfoManager.Listener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatus.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
            public void checkedProgress() {
                Logger.m11003i(AiActionStatus.TAG, "executeRetryAction#checkedProgress");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
            public void stopProgress(String str) {
                if (activity != null && AiActionStatus.this.getInvalidLoggedIn()) {
                    Logger.m11003i(AiActionStatus.TAG, "executeRetryAction#loginRequestAccessToken");
                    RequestToSamsungAccountManager.INSTANCE.loginRequestAccessToken(activity, AiActionStatus.REQUEST_INTENT_TOKEN_RETRY);
                    return;
                }
                AbstractC8014b.m7222x(new StringBuilder("executeRetryAction#activity# "), activity != null, AiActionStatus.TAG);
                if (AiActionStatus.this.mOkAction != null) {
                    AiActionStatus.this.mOkAction.run();
                    AiActionStatus.this.mOkAction = null;
                }
            }
        }, true, true);
    }

    public boolean isAiActionStatusEnabled() {
        return (!isLoginedNotRequired() || isSettingsNotConfirmed() || getInvalidLoggedIn() || !isServerCheckRequested() || isKidsAccountBlocked() || isUnconsentPinCaseRelated() || isNeedShowServerAiFeature() || isNeedShowDrawingAssistNotice() || isSettingsPreventOnlineProcessing()) ? false : true;
    }

    public boolean isAiSettingsButtonEnabled() {
        return (!isLoginedNotRequired() || isKidsAccountBlocked() || isSettingsNotConfirmed()) ? false : true;
    }

    public boolean isChangedUserAccount() {
        if (TextUtils.isEmpty(RequestToSamsungAccountManager.INSTANCE.getUserIdHash()) || TextUtils.isEmpty(getUserIdHash())) {
            return false;
        }
        return !getUserIdHash().equals(r0.getUserIdHash());
    }

    public boolean isNoticedServerAiFeature() {
        if (DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
            Logger.m11003i(TAG, "isNoticedServerAiFeature#isDemoDevice");
            return true;
        }
        checkFtuVersion();
        int i = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_NOTES_ASSIST_NOTICE_SERVER_AI_FEATURE, 0);
        if (i == 0) {
            return false;
        }
        int i2 = i | 2;
        AbstractC8014b.m7195A(AbstractC0541b.m778t(i2, "isNoticedServerAiFeature#result: ", " AI default enabled: 2 FTU version: "), TAG, FTU_VERSION);
        return i2 == FTU_VERSION;
    }

    public boolean isSettingsPage() {
        return this.mLoginPage == LOGIN_PAGE.SETTINGS;
    }

    public void onActivityResult(Activity activity, int i, int i2, @Nullable Intent intent) {
        if (i == 810) {
            onActivityAiGrantedResult(activity, i2);
            return;
        }
        if (i == 808) {
            onActivityLoginResult(activity, i2);
            return;
        }
        if (i == 811) {
            onActivityAiGrantedResultWithSettings(activity, i2);
            return;
        }
        if (i == 809) {
            onActivityLoginResultWithSettings(activity, i2);
            return;
        }
        if (i == 812) {
            onActivityLoginResultWithPreventOnlineProcessing(activity);
            return;
        }
        if (i == 814) {
            onActivityServerResult(activity, i2, intent);
            return;
        }
        if (i == 813) {
            onActivityIsUnconsentPinCaseRelatedResult(activity, i2, intent);
            return;
        }
        if (i == 815) {
            onActivityTokenResult(activity, i2);
        } else if (i == 816) {
            onActivityTokenRetryResult(i2);
        } else if (i == 817) {
            onActivityDrawingAssistNoticeResult(activity, i2);
        }
    }

    public void release() {
        Logger.m11003i(TAG, "release");
        if (this.mOkAction != null) {
            this.mOkAction = null;
        }
        Runnable runnable = this.mCancelAction;
        if (runnable != null) {
            runnable.run();
            this.mCancelAction = null;
        }
    }

    public void releaseActivity() {
        if (this.mOkAction != null) {
            this.mOkAction = null;
        }
        if (this.mCancelAction != null) {
            this.mCancelAction = null;
        }
    }

    public void requestAiActionStatusEnabled(Activity activity) {
        String str = TAG;
        Logger.m11003i(str, "requestAiActionStatusEnabled");
        if (!isLoginedNotRequired() || isSettingsNotConfirmed()) {
            this.mIsServerChecked = AIFeatureInfoManager.resetAIFeatureInfo();
            RequestToSamsungAccountManager.INSTANCE.requestSystemAiPermission(activity, REQUEST_INTENT_ACCOUNT_AI_PERMISSION);
            return;
        }
        if (getInvalidLoggedIn()) {
            RequestToSamsungAccountManager.INSTANCE.loginRequestAccessToken(activity, REQUEST_INTENT_TOKEN);
            return;
        }
        if (!isServerCheckRequested()) {
            this.mValidationCheck = true;
            if (isInvalidate(activity)) {
                release();
                return;
            } else {
                showProgressDialogActivity(activity);
                return;
            }
        }
        if (isKidsAccountBlocked()) {
            showKidsAccountBlockDialog(activity);
            return;
        }
        if (isUnconsentPinCaseRelated()) {
            showUnconsentPinCaseRelatedRequest(activity);
            return;
        }
        if (isAudioEraserFeature()) {
            execute(activity);
            return;
        }
        if (isNeedShowServerAiFeature()) {
            executeAiNoticeDialog(activity);
            return;
        }
        if (isNeedShowDrawingAssistNotice()) {
            showAiDrawingNoticeDialog(activity);
        } else if (isSettingsPreventOnlineProcessing()) {
            showPreventOnlineProcessingDialog(activity);
        } else {
            Logger.m11000e(str, "requestAiActionStatusEnabled# failed");
            release();
        }
    }

    public AiActionStatus(Runnable runnable, Runnable runnable2) {
        this.mIsServerChecked = AIFeatureInfoManager.isServerChecked();
        this.mValidationCheck = false;
        this.mLoginPage = LOGIN_PAGE.POPUP;
        this.mOkAction = runnable;
        this.mCancelAction = runnable2;
        this.mDialogType = DIALOG_TYPE.NONE;
    }

    public AiActionStatus(Runnable runnable, Runnable runnable2, LOGIN_PAGE login_page) {
        this.mIsServerChecked = AIFeatureInfoManager.isServerChecked();
        this.mValidationCheck = false;
        this.mLoginPage = login_page;
        this.mOkAction = runnable;
        this.mCancelAction = runnable2;
        this.mDialogType = DIALOG_TYPE.NONE;
    }

    public AiActionStatus(Runnable runnable, Runnable runnable2, DIALOG_TYPE dialog_type) {
        this.mIsServerChecked = AIFeatureInfoManager.isServerChecked();
        this.mValidationCheck = false;
        this.mLoginPage = LOGIN_PAGE.POPUP;
        this.mOkAction = runnable;
        this.mCancelAction = runnable2;
        this.mDialogType = dialog_type;
    }

    public AiActionStatus(Runnable runnable, DIALOG_TYPE dialog_type) {
        this.mIsServerChecked = AIFeatureInfoManager.isServerChecked();
        this.mValidationCheck = false;
        this.mLoginPage = LOGIN_PAGE.POPUP;
        this.mOkAction = runnable;
        this.mDialogType = dialog_type;
    }

    public AiActionStatus(DIALOG_TYPE dialog_type) {
        this.mIsServerChecked = AIFeatureInfoManager.isServerChecked();
        this.mValidationCheck = false;
        this.mLoginPage = LOGIN_PAGE.POPUP;
        this.mDialogType = dialog_type;
    }

    public AiActionStatus() {
        this.mIsServerChecked = AIFeatureInfoManager.isServerChecked();
        this.mValidationCheck = false;
        this.mLoginPage = LOGIN_PAGE.POPUP;
        this.mDialogType = DIALOG_TYPE.NONE;
        this.mOkAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatus.1
            @Override // java.lang.Runnable
            public void run() {
            }
        };
    }
}
