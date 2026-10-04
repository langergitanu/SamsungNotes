package com.samsung.android.sdk.smp.push;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PushHelperFeature implements PushHelperFeatureInterface {
    private static final String ISO_CODE_HK = "HK";
    private static final String ISO_CODE_HKG = "HKG";
    private static final String ISO_CODE_MAC = "MAC";
    private static final String ISO_CODE_MO = "MO";
    private static final String TAG = "PushHelperFeature";

    private boolean checkPushTypeAndSwitchPush(Context context) {
        if (DeviceInfoUtil.isCN()) {
            return SppInterface.switchToSPPIfNot(context);
        }
        if (!isHKMO()) {
            return FcmInterface.switchToFCMIfNot(context);
        }
        SmpConstants.PushModeForHkAndMo pushModeForHkAndMo = InitOptionsHolder.getInstance().getPushModeForHkAndMo(context);
        if (SmpConstants.PushModeForHkAndMo.FCM_ONLY_MODE.equals(pushModeForHkAndMo)) {
            return FcmInterface.switchToFCMIfNot(context);
        }
        if (SmpConstants.PushModeForHkAndMo.SPP_ONLY_MODE.equals(pushModeForHkAndMo)) {
            return SppInterface.switchToSPPIfNot(context);
        }
        return false;
    }

    private String getRegisterPushType(Context context) {
        return (DeviceInfoUtil.isCN() || DeviceInfoUtil.hasSppForceActivationFeature()) ? "spp" : isHKMO() ? getRegisterPushTypeforHKMO(context) : "fcm";
    }

    private String getRegisterPushTypeforHKMO(Context context) {
        SmpConstants.PushModeForHkAndMo pushModeForHkAndMo = InitOptionsHolder.getInstance().getPushModeForHkAndMo(context);
        return SmpConstants.PushModeForHkAndMo.SPP_ONLY_MODE.equals(pushModeForHkAndMo) ? "spp" : (!SmpConstants.PushModeForHkAndMo.FCM_ONLY_MODE.equals(pushModeForHkAndMo) && "spp".equals(PrefManager.getInstance(context).getNextPushTypeForFCMPrimaryMode())) ? "spp" : "fcm";
    }

    private boolean isHKMO() {
        String countryIsoCode = DeviceInfoUtil.getCountryIsoCode();
        if (TextUtils.isEmpty(countryIsoCode)) {
            SmpLog.m6501w(TAG, "country iso code is empty");
            return false;
        }
        countryIsoCode.getClass();
        switch (countryIsoCode) {
        }
        return false;
    }

    private boolean isHKMOAndFcmPrimaryMode(Context context) {
        return isHKMO() && SmpConstants.PushModeForHkAndMo.FCM_PRIMARY_MODE.equals(InitOptionsHolder.getInstance().getPushModeForHkAndMo(context));
    }

    private boolean needToEnableFcm(Context context) {
        if (DeviceInfoUtil.hasSppForceActivationFeature()) {
            return false;
        }
        SmpConstants.PushModeForHkAndMo pushModeForHkAndMo = InitOptionsHolder.getInstance().getPushModeForHkAndMo(context);
        if (isHKMO() && pushModeForHkAndMo == SmpConstants.PushModeForHkAndMo.SPP_ONLY_MODE) {
            return false;
        }
        return !DeviceInfoUtil.isCN();
    }

    private void togglePushTypeForFcmPrimaryMode(Context context, String str) {
        String str2 = "fcm".equals(str) ? "spp" : "fcm";
        SmpLog.m6498i(TAG, "toggle next push type : ".concat(str2));
        PrefManager.getInstance(context).setNextPushTypeForFcmPrimaryMode(str2);
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized void handleBootOrUpdateEvent(Context context) {
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized void handlePushRegistrationFail(Context context, String str, String str2, String str3) {
        if (isHKMOAndFcmPrimaryMode(context)) {
            togglePushTypeForFcmPrimaryMode(context, str);
        }
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized void initializePushPlatform(Context context) {
        if (needToEnableFcm(context)) {
            FcmInterface.enableFcmAutoInit();
        }
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized boolean isValidPushRegistration(Context context, String str, String str2) {
        if (!isHKMOAndFcmPrimaryMode(context)) {
            return true;
        }
        if (PushHelper.isPushRegComplete(context)) {
            String pushType = PrefManager.getInstance(context).getPushType();
            if (!str.equals(pushType)) {
                SmpLog.m6497hi(TAG, "push registration success but not valid request : already registered to " + pushType + ". keep the current");
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized void register(Context context) {
        if ("spp".equals(getRegisterPushType(context))) {
            SppInterface.register(context);
        } else {
            FcmInterface.register(context);
        }
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized void switchPushWhenSppDeactivated(Context context) {
        FcmInterface.switchToFCMIfNot(context);
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized boolean validateAndSwitchPushPlatform(Context context) {
        if (checkPushTypeAndSwitchPush(context)) {
            return true;
        }
        FcmInterface.updatePushTokenIfChanged(context);
        return false;
    }
}
