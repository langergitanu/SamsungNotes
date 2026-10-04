package com.samsung.android.support.senl.p148nt.model.contextawareness.common;

import android.content.Intent;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.sdk.deepsky.DeepSky;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.app.sdk.deepsky.suggestion.Capability;
import com.samsung.android.app.sdk.deepsky.suggestion.CapabilityEnum;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessFeature {
    public static final String BROWSER_PACKAGE_NAME = "com.sec.android.app.sbrowser";
    public static final String GALLERY_PACKAGE_NAME = "com.sec.android.gallery3d";
    private static final int MAX_VERSION_CODE_NEED_DELAY_WHEN_REQUEST_SUBSCRIBE = 410000093;
    public static final String MESSAGE_PACKAGE_NAME = "com.samsung.android.messaging";
    private static final int MIN_VERSION_CODE_NEED_DELAY_WHEN_REQUEST_SUBSCRIBE = 410000090;
    private static final String SMART_SUGGESTION_PACKAGE_NAME = "com.samsung.android.smartsuggestions";
    public static final ArrayList<String> SUPPORTED_DONATED_APPS;
    private static final String TAG;
    private static final ExecutorService mExecutor;
    private static Boolean sSupportedPlatform;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContextAwarenessSupportedCallable implements Callable {
        public /* synthetic */ ContextAwarenessSupportedCallable(int i) {
            this();
        }

        private ContextAwarenessSupportedCallable() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(ContextAwarenessFeature.isSupportedPlatform() && !UserHandleCompat.getInstance().isSecureFolderMode());
        }
    }

    static {
        String strCreateTag = CALogger.createTag("ContextAwarenessFeature");
        TAG = strCreateTag;
        SUPPORTED_DONATED_APPS = new ArrayList<>(Arrays.asList(GALLERY_PACKAGE_NAME, BROWSER_PACKAGE_NAME, MESSAGE_PACKAGE_NAME));
        sSupportedPlatform = null;
        mExecutor = AbstractC4539a.m3201k(strCreateTag);
    }

    private static int getSmartSuggestionVersion() {
        return PackageManagerCompat.INSTANCE.getInstance().getVersionCode(BaseUtils.getApplicationContext(), SMART_SUGGESTION_PACKAGE_NAME);
    }

    private static boolean isContainUserContextBasedContentCapability() {
        Iterator<Capability> it = DeepSky.with(BaseUtils.getContext()).getSuggestionRequest().getCapabilities().iterator();
        while (it.hasNext()) {
            if (it.next().getCapability() == CapabilityEnum.USER_CONTEXT_BASED_CONTENT) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContextAwarenessEnabled() {
        return isContextAwarenessSupported() && isSupportedMode() && SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized boolean isContextAwarenessSupported() {
        boolean zBooleanValue;
        zBooleanValue = false;
        try {
            zBooleanValue = ((Boolean) ((FutureTask) mExecutor.submit(new ContextAwarenessSupportedCallable(0 == true ? 1 : 0))).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            DataLogger.m12303e(TAG, "isContextAwarenessSupported# " + e.getMessage());
        }
        return zBooleanValue;
    }

    private static boolean isDeepSkySupported() {
        return DeepSky.isSupported(BaseUtils.getContext());
    }

    public static boolean isSupportedDonationApp(SuggestionItem suggestionItem) {
        try {
            return SUPPORTED_DONATED_APPS.contains(suggestionItem.getItems().get(0).getExtras().getString("source"));
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("isSupportedDonationApp# "), TAG);
            return false;
        }
    }

    public static boolean isSupportedMode() {
        return (DeviceUtils.isPowerManageMode(BaseUtils.getApplicationContext()) || EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(BaseUtils.getApplicationContext())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSupportedPlatform() {
        if (sSupportedPlatform == null) {
            try {
                if (isDeepSkySupported() && isContainUserContextBasedContentCapability()) {
                    sSupportedPlatform = Boolean.TRUE;
                } else {
                    sSupportedPlatform = Boolean.FALSE;
                }
                DataLogger.m12305f(TAG, "isSupportedPlatform# " + sSupportedPlatform);
            } catch (Exception e) {
                sSupportedPlatform = Boolean.FALSE;
                AbstractC11014a.m12333r(e, new StringBuilder("isSupportedPlatform# "), TAG);
            }
        }
        return sSupportedPlatform.booleanValue();
    }

    public static boolean needDelayWhenRequestSubscribe() {
        int smartSuggestionVersion = getSmartSuggestionVersion();
        return smartSuggestionVersion >= MIN_VERSION_CODE_NEED_DELAY_WHEN_REQUEST_SUBSCRIBE && smartSuggestionVersion <= MAX_VERSION_CODE_NEED_DELAY_WHEN_REQUEST_SUBSCRIBE;
    }

    public static boolean isSupportedDonationApp(Intent intent) {
        try {
            return SUPPORTED_DONATED_APPS.contains(intent.getStringExtra("source"));
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("isSupportedDonationApp# "), TAG);
            return false;
        }
    }
}
