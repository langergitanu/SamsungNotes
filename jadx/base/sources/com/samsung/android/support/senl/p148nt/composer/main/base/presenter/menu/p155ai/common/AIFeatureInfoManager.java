package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.cms.SamsungAccountConsentHelper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyItem;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToCmsManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.ResultConsentData;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerConsentListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AIFeatureInfoManager {
    private static final String AI_CHECK_DURATION_WEEK = "AI_CHECK_DURATION_WEEK";
    public static final int SERVER_CHECK_LIST = 3;
    public static final String SETTINGS_TYPE_CHILD_ACCOUNT = "child_account_account";
    public static final String SETTINGS_TYPE_CHILD_AGE = "child_account_age";
    public static final String SETTINGS_TYPE_UNCONSENT_PIN_CASE = "unconsent_pin_case";
    private static final String TAG = "AIFeatureInfoManager";
    private static boolean mIsServerChecked;
    private static int mIsServerCheckedCount;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener {
        void checkedProgress();

        void stopProgress(String str);
    }

    static {
        mIsServerChecked = System.currentTimeMillis() - getCheckPeriod() < 604800000;
    }

    public static void checkAIFeatureInfo() {
        if (!checkValidate()) {
            TokenManager.checkTokenValidate();
        }
        if (!PolicyManager.isEdmPolicyAiEnabled() && AiActionStatus.isAiFeatureEnable()) {
            AiActionStatus.setAiFeatureEnable(false, false);
        }
        if (PolicyManager.isEdmPolicyAiDrawingEnabled() || !AiActionStatus.isDrawingAssistEnabled()) {
            return;
        }
        AiActionStatus.enableDrawingAssist(false);
    }

    private static void checkChildAccount(final Listener listener) {
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        boolean zIsChildAccount = companion.isChildAccount();
        setChildAccount(zIsChildAccount);
        if (zIsChildAccount) {
            companion.requestCountryPolicy(new CountryPolicyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.6
                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener
                public void onError(String str, String str2) {
                    Logger.m8702i(AIFeatureInfoManager.TAG, "requestCountryPolicy# onError");
                    Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.stopProgress(str);
                    }
                }

                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener
                public void onReceived(CountryPolicyItem countryPolicyItem) {
                    Logger.m8702i(AIFeatureInfoManager.TAG, "requestCountryPolicy# onReceived");
                    if (countryPolicyItem.getIsError()) {
                        Listener listener2 = listener;
                        if (listener2 != null) {
                            listener2.stopProgress("");
                            return;
                        }
                        return;
                    }
                    AIFeatureInfoManager.setChildAge(countryPolicyItem.getMinorAge());
                    Listener listener3 = listener;
                    if (listener3 != null) {
                        listener3.checkedProgress();
                    }
                }
            });
        } else if (listener != null) {
            listener.checkedProgress();
        }
    }

    private static void checkServerAgreement(final Listener listener) {
        if (DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
            Logger.m8702i(TAG, "checkServerAgreement isDemoDevice");
            checkedProgress(listener);
        } else {
            final boolean z = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST, false);
            final boolean z2 = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_LOCAL_CHANGED, false);
            final boolean z3 = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_SERVER_CHANGED, false);
            RequestToCmsManager.INSTANCE.request(new ServerConsentListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.7
                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerConsentListener
                public void onCanceled() {
                    Logger.m8702i(AIFeatureInfoManager.TAG, "RequestToCmsManager check request onCanceled# " + z2 + " isServerChanged# " + z3);
                    AIFeatureInfoManager.checkedProgress(listener);
                }

                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerConsentListener
                public void onError(@Nullable Integer num, @Nullable String str) {
                    Logger.m8698e(AIFeatureInfoManager.TAG, "RequestToCmsManager check request onError errCode# " + num + " errMsg# " + str + " isLocalChanged# " + z2 + " isServerChanged# " + z3);
                    AIFeatureInfoManager.checkedProgress(listener);
                }

                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerConsentListener
                public void onReceived(boolean z4) {
                    if (z4) {
                        if (z) {
                            Logger.m8702i(AIFeatureInfoManager.TAG, "server/local on");
                            AIFeatureInfoManager.onResultNoChanged(listener);
                            return;
                        }
                        Logger.m8702i(AIFeatureInfoManager.TAG, "server on / local off / isLocalChanged# " + z2);
                        if (z2) {
                            RequestToCmsManager.INSTANCE.request(false, new ServerResultListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.7.1
                                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener
                                public void onCanceled() {
                                    Logger.m8702i(AIFeatureInfoManager.TAG, "RequestToCmsManager request set false onCanceled");
                                    AIFeatureInfoManager.onResultFailed(listener);
                                }

                                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener
                                public void onError(@Nullable Integer num, @Nullable String str) {
                                    Logger.m8698e(AIFeatureInfoManager.TAG, "RequestToCmsManager request set false onError errCode# " + num + " errMsg# " + str);
                                    AIFeatureInfoManager.onResultFailed(listener);
                                }

                                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener
                                public void onSucceed() {
                                    Logger.m8702i(AIFeatureInfoManager.TAG, "RequestToCmsManager request set false onSucceed");
                                    AIFeatureInfoManager.onResultNoChanged(listener);
                                }
                            });
                            return;
                        } else {
                            AIFeatureInfoManager.onResultNoChanged(listener);
                            return;
                        }
                    }
                    if (!z) {
                        Logger.m8702i(AIFeatureInfoManager.TAG, "server/local off");
                        AIFeatureInfoManager.onResultNoChanged(listener);
                        return;
                    }
                    Logger.m8702i(AIFeatureInfoManager.TAG, "server off / local on / isLocalChanged# " + z2);
                    if (z2) {
                        RequestToCmsManager.INSTANCE.request(true, new ServerResultListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.7.2
                            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener
                            public void onCanceled() {
                                Logger.m8702i(AIFeatureInfoManager.TAG, "RequestToCmsManager request set true onCanceled");
                                AIFeatureInfoManager.onResultFailed(listener);
                            }

                            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener
                            public void onError(@Nullable Integer num, @Nullable String str) {
                                Logger.m8698e(AIFeatureInfoManager.TAG, "RequestToCmsManager request set true onError errCode# " + num + " errMsg# " + str);
                                AIFeatureInfoManager.onResultFailed(listener);
                            }

                            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ServerResultListener
                            public void onSucceed() {
                                Logger.m8702i(AIFeatureInfoManager.TAG, "RequestToCmsManager request set true onSucceed");
                                AIFeatureInfoManager.onResultNoChanged(listener);
                            }
                        });
                    } else {
                        AIFeatureInfoManager.onResultNotice(listener);
                    }
                }
            });
        }
    }

    public static boolean checkServerInvalidate() {
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        return TextUtils.isEmpty(companion.getAccessToken()) || TextUtils.isEmpty(companion.getApiServerUrl());
    }

    private static void checkUnconsentPinCaseRelated(final Listener listener) {
        if (new SamsungAccountConsentHelper().isConsentInterfaceAvailable()) {
            RequestToSamsungAccountManager.INSTANCE.requestConsentInfo(new ConsentDataListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.5
                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener
                public void onError(String str, String str2) {
                    Logger.m8702i(AIFeatureInfoManager.TAG, "requestConsentInfo# onError #" + str + " " + str2);
                    Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.checkedProgress();
                    }
                }

                @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener
                public void onReceived(ResultConsentData resultConsentData) {
                    Logger.m8702i(AIFeatureInfoManager.TAG, "requestConsentInfo# onReceived #");
                    if (resultConsentData.getIsError()) {
                        Logger.m8702i(AIFeatureInfoManager.TAG, "requestConsentInfo# onError");
                    } else {
                        if (!TextUtils.isEmpty(resultConsentData.getConsentInfo())) {
                            for (ResultConsentData.ConsentItem consentItem : resultConsentData.getConsentList()) {
                                if (consentItem.getMandatory() && consentItem.getPassed()) {
                                    AIFeatureInfoManager.setIsUnconsentPinCaseRelated(true);
                                    Listener listener2 = listener;
                                    if (listener2 != null) {
                                        listener2.checkedProgress();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        AIFeatureInfoManager.setIsUnconsentPinCaseRelated(false);
                    }
                    Listener listener3 = listener;
                    if (listener3 != null) {
                        listener3.checkedProgress();
                    }
                }
            });
        } else if (listener != null) {
            listener.checkedProgress();
        }
    }

    private static boolean checkValidate() {
        if (!Features.isSupportAiFunction()) {
            Logger.m8702i(TAG, "checkValidate() - not support ai function.");
            return false;
        }
        if (isNetworkAvailable()) {
            RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
            if (companion.isLogined() && !DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext())) {
                long checkPeriod = getCheckPeriod();
                if (checkPeriod == 0) {
                    Logger.m8702i(TAG, "checkValidate() - ai check at the first app launch.");
                    requestAIFeatureInfo(new Listener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
                        public void checkedProgress() {
                            AIFeatureInfoManager.mIsServerCheckedCount++;
                            if (AIFeatureInfoManager.mIsServerCheckedCount == 3) {
                                AIFeatureInfoManager.setCheckPeriod();
                            }
                        }

                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
                        public void stopProgress(String str) {
                        }
                    });
                    return true;
                }
                if (companion.isChildAccount() != getChildAccount() || System.currentTimeMillis() - checkPeriod >= 604800000) {
                    requestAIFeatureInfo(new Listener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.2
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
                        public void checkedProgress() {
                            AIFeatureInfoManager.mIsServerCheckedCount++;
                            if (AIFeatureInfoManager.mIsServerCheckedCount == 3) {
                                AIFeatureInfoManager.setCheckPeriod();
                            }
                        }

                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
                        public void stopProgress(String str) {
                        }
                    });
                    return true;
                }
                Logger.m8702i(TAG, "checkTokenValidate() - this is a user who has not used the ai function for a week... So skip. " + checkPeriod);
                mIsServerChecked = true;
                return false;
            }
        }
        Logger.m8702i(TAG, "checkValidate() - not avaliable state.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkedProgress(Listener listener) {
        if (listener == null) {
            return;
        }
        listener.checkedProgress();
    }

    private static long getCheckPeriod() {
        return SharedPreferencesCompat.getInstance("Settings").getLong(AI_CHECK_DURATION_WEEK, 0L);
    }

    public static boolean getChildAccount() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SETTINGS_TYPE_CHILD_ACCOUNT, false);
    }

    public static int getChildAge() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SETTINGS_TYPE_CHILD_AGE, 13);
    }

    public static boolean getIsUnconsentPinCaseRelated() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SETTINGS_TYPE_UNCONSENT_PIN_CASE, false);
    }

    public static boolean hasChildAge() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SETTINGS_TYPE_CHILD_AGE, -1) != -1;
    }

    private static boolean isNetworkAvailable() {
        RequestToSCloudManager.Companion companion = RequestToSCloudManager.INSTANCE;
        return companion.getInstance().isWiFiAvailable() || companion.getInstance().isDataNetworkAvailable();
    }

    public static boolean isServerChecked() {
        return mIsServerChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onResultFailed(Listener listener) {
        SharedPreferencesCompat.getInstance("Settings").remove(SettingsConstants.SETTINGS_NOTES_ASSIST_LOCAL_CHANGED);
        SharedPreferencesCompat.getInstance("Settings").remove(SettingsConstants.SETTINGS_NOTES_ASSIST_SERVER_CHANGED);
        checkedProgress(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onResultNoChanged(Listener listener) {
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_LOCAL_CHANGED, true);
        SharedPreferencesCompat.getInstance("Settings").remove(SettingsConstants.SETTINGS_NOTES_ASSIST_SERVER_CHANGED);
        checkedProgress(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onResultNotice(Listener listener) {
        SharedPreferencesCompat.getInstance("Settings").remove(SettingsConstants.SETTINGS_NOTES_ASSIST_LOCAL_CHANGED);
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_SERVER_CHANGED, true);
        checkedProgress(listener);
    }

    public static boolean requestAIFeatureInfo() {
        return requestAIFeatureInfo(new Listener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
            public void checkedProgress() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
            public void stopProgress(String str) {
            }
        });
    }

    public static boolean resetAIFeatureInfo() {
        mIsServerChecked = false;
        mIsServerCheckedCount = 0;
        SharedPreferencesCompat.getInstance("Settings").remove(AI_CHECK_DURATION_WEEK);
        SharedPreferencesCompat.getInstance("Settings").remove(SETTINGS_TYPE_UNCONSENT_PIN_CASE);
        SharedPreferencesCompat.getInstance("Settings").remove(SETTINGS_TYPE_CHILD_AGE);
        SharedPreferencesCompat.getInstance("Settings").remove(SETTINGS_TYPE_CHILD_ACCOUNT);
        return mIsServerChecked;
    }

    public static void setAIFeatureInfo() {
        mIsServerChecked = true;
        setCheckPeriod();
    }

    public static void setCheckPeriod() {
        mIsServerChecked = true;
        SharedPreferencesCompat.getInstance("Settings").putLong(AI_CHECK_DURATION_WEEK, System.currentTimeMillis());
    }

    public static void setChildAccount(boolean z) {
        Logger.m8702i(TAG, "setChildAccount# " + z);
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SETTINGS_TYPE_CHILD_ACCOUNT, z);
    }

    public static void setChildAge(int i) {
        Logger.m8702i(TAG, "setChildAge# " + i);
        SharedPreferencesCompat.getInstance("Settings").putInt(SETTINGS_TYPE_CHILD_AGE, i);
    }

    public static void setIsUnconsentPinCaseRelated(boolean z) {
        Logger.m8702i(TAG, "setIsUnconsentPinCaseRelated# " + z);
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SETTINGS_TYPE_UNCONSENT_PIN_CASE, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setProgress(Listener listener) {
        checkUnconsentPinCaseRelated(listener);
        checkChildAccount(listener);
        checkServerAgreement(listener);
    }

    public static boolean requestAIFeatureInfo(Listener listener) {
        return requestAIFeatureInfo(listener, checkServerInvalidate());
    }

    public static boolean requestAIFeatureInfo(Listener listener, boolean z) {
        return requestAIFeatureInfo(listener, z, false);
    }

    public static boolean requestAIFeatureInfo(final Listener listener, final boolean z, final boolean z2) {
        Logger.m8702i(TAG, "requestAIFeatureInfo()");
        new SenlThreadFactory(TAG).newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    AIFeatureInfoManager.setProgress(listener);
                    return;
                }
                TokenManager.setListener(new TokenManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.4.1
                    @Override // com.samsung.android.support.senl.nt.base.common.ai.common.TokenManager.Contract
                    public void onError(@NotNull String str) {
                        if (z2) {
                            Logger.m8702i(AIFeatureInfoManager.TAG, "requestAuthInfo# onError");
                            listener.stopProgress(str);
                        } else {
                            Logger.m8702i(AIFeatureInfoManager.TAG, "requestAuthInfo# onError retry Expired");
                            AIFeatureInfoManager.requestAIFeatureInfo(listener, true, true);
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.base.common.ai.common.TokenManager.Contract
                    public void onReceived() {
                        Logger.m8702i(AIFeatureInfoManager.TAG, "requestAuthInfo# onReceived");
                        RunnableC92764 runnableC92764 = RunnableC92764.this;
                        if (z2) {
                            listener.stopProgress("");
                        } else {
                            AIFeatureInfoManager.setProgress(listener);
                        }
                    }
                });
                if (z2) {
                    TokenManager.setTokenExpiredRequestAuthInfo();
                } else {
                    TokenManager.requestAuthInfo();
                }
            }
        }).start();
        return z;
    }
}
