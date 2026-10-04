package com.samsung.android.support.senl.p148nt.app.common.updater;

import android.content.Context;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditUpdater extends BaseUpdater {
    private static final int COEDIT_SUPPORT_SES_AGENT_VERSION_CODE;
    private static final String GALAXY_APPS_CHECK_EVERY_HOUR = "galaxy_apps_check_ses_agent_version_every_hour";
    private static final String TAG = "CoeditUpdater";
    private static CoeditUpdater sInstance;

    static {
        COEDIT_SUPPORT_SES_AGENT_VERSION_CODE = Build.VERSION.SDK_INT < 29 ? 1080900003 : 1311000025;
    }

    public static synchronized CoeditUpdater getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new CoeditUpdater();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private long getUpdatePeriod() {
        return SharedPreferencesCompat.getInstance("Settings").getLong(GALAXY_APPS_CHECK_EVERY_HOUR, 0L);
    }

    private boolean isBlockedToCheckVersion() {
        long updatePeriod = getUpdatePeriod();
        if (updatePeriod == 0) {
            MainCoeditLogger.m7253i(TAG, "isBlockedToCheckVersion(). false / first time");
            setUpdatePeriod(System.currentTimeMillis());
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - updatePeriod;
        if (jCurrentTimeMillis >= 3600000) {
            MainCoeditLogger.m7253i(TAG, "isBlockedToCheckVersion(). false");
            setUpdatePeriod(System.currentTimeMillis());
            return false;
        }
        MainCoeditLogger.m7253i(TAG, "isBlockedToCheckVersion(). true " + jCurrentTimeMillis);
        return true;
    }

    private void setUpdatePeriod(long j) {
        SharedPreferencesCompat.getInstance("Settings").putLong(GALAXY_APPS_CHECK_EVERY_HOUR, j);
    }

    public boolean checkForceUpdateSESAgentVersion(Context context) {
        if (context == null) {
            MainCoeditLogger.m7253i(TAG, "checkForceUpdateSESAgentVersion() false - context is null");
            return false;
        }
        int versionCode = PackageManagerCompat.INSTANCE.getInstance().getVersionCode(context, "com.samsung.android.mobileservice");
        if (versionCode >= COEDIT_SUPPORT_SES_AGENT_VERSION_CODE) {
            MainCoeditLogger.m7253i(TAG, "checkForceUpdateSESAgentVersion() false - this is coedit supported SES version. " + versionCode);
            return false;
        }
        if (isBlockedToCheckVersion()) {
            MainCoeditLogger.m7253i(TAG, "checkForceUpdateSESAgentVersion() false - blocked to check server");
            return false;
        }
        MainCoeditLogger.m7253i(TAG, "checkForceUpdateSESAgentVersion() true");
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.updater.BaseUpdater
    public String getTag() {
        return TAG;
    }

    public void releaseUpdatePeriod() {
        MainCoeditLogger.m7253i(TAG, "releaseUpdatePeriod()");
        SharedPreferencesCompat.getInstance("Settings").putLong(GALAXY_APPS_CHECK_EVERY_HOUR, 0L);
    }
}
