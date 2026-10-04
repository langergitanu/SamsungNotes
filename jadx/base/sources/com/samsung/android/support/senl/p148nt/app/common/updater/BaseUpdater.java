package com.samsung.android.support.senl.p148nt.app.common.updater;

import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener;
import com.samsung.android.support.senl.p148nt.app.updater.connector.MarketConnectorFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseUpdater {
    private static final String GALAXY_APPS_CHECK_NOTES_EVERY_DAY = "galaxy_apps_check_notes_every_day";
    private static final String LATEST_CHECKED_NOTES_VERSION_CODE = "latest_checked_notes_version_code";
    protected static final long UPDATE_CHECK_PERIOD = 3600000;
    private static final long UPDATE_CHECK_PERIOD_EVERY_DAY = 86400000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum AppStoreResult {
        ERROR,
        NEED_UPDATE,
        LATEST
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AppStoreResultListener {
        void onResult(AppStoreResult appStoreResult);
    }

    private long getPrefNotesCheckedPeriod() {
        return SharedPreferencesCompat.getInstance("Settings").getLong(GALAXY_APPS_CHECK_NOTES_EVERY_DAY, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrefLatestNotesVersion(int i) {
        SharedPreferencesCompat.getInstance("Settings").putInt(LATEST_CHECKED_NOTES_VERSION_CODE, i);
    }

    private void setPrefNotesCheckedPeriod(long j) {
        SharedPreferencesCompat.getInstance("Settings").putLong(GALAXY_APPS_CHECK_NOTES_EVERY_DAY, j);
    }

    public AppStoreResult checkForceUpdateNotesVersion(final AppStoreResultListener appStoreResultListener) {
        if (!UpdateManager.getInstance().isGalaxyAppStorePackageExist()) {
            MainCoeditLogger.m7251e(getTag(), "checkForceUpdateNotesVersion# GalaxyAppStorePackage not exist");
            return AppStoreResult.ERROR;
        }
        final int currentVersionCode = UpdateManager.getInstance().getCurrentVersionCode();
        int prefLatestNotesVersion = getPrefLatestNotesVersion();
        MainCoeditLogger.m7253i(getTag(), "checkForceUpdateNotesVersion# currentVersion : " + currentVersionCode + ", checkedLatestVersion : " + prefLatestNotesVersion);
        if (currentVersionCode < prefLatestNotesVersion) {
            PackageManagerCompat.Version version = new PackageManagerCompat.Version(currentVersionCode);
            PackageManagerCompat.Version version2 = new PackageManagerCompat.Version(prefLatestNotesVersion);
            if (version.getMajor() < version2.getMajor() || version.getMinor() < version2.getMinor()) {
                MainCoeditLogger.m7253i(getTag(), "checkForceUpdateNotesVersion# currentVersion < checkedLatestVersion");
                return AppStoreResult.NEED_UPDATE;
            }
        }
        if (currentVersionCode > prefLatestNotesVersion) {
            MainCoeditLogger.m7253i(getTag(), "checkForceUpdateNotesVersion# currentVersion > checkedLatestVersion");
            setPrefLatestNotesVersion(currentVersionCode);
            return AppStoreResult.LATEST;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - getPrefNotesCheckedPeriod();
        MainCoeditLogger.m7253i(getTag(), "checkForceUpdateNotesVersion# currentVersion == checkedLatestVersion, latestCheckedPeriod : " + jCurrentTimeMillis);
        if (jCurrentTimeMillis > 86400000) {
            MainCoeditLogger.m7253i(getTag(), "checkForceUpdateNotesVersion# App Store check");
            MarketConnectorFactory.createMarketConnector().checkNewVersionOnMarket(new INewVersionCheckResetListener() { // from class: com.samsung.android.support.senl.nt.app.common.updater.BaseUpdater.1
                @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener
                public void getResult(int i) {
                    MainCoeditLogger.m7253i(BaseUpdater.this.getTag(), "checkForceUpdateNotesVersion#getResult, marketVersionCode : " + i);
                    if (i == 3) {
                        MainCoeditLogger.m7251e(BaseUpdater.this.getTag(), "checkForceUpdateNotesVersion#getResult, RESULT_CODE_NO_NETWORK");
                        AppStoreResultListener appStoreResultListener2 = appStoreResultListener;
                        if (appStoreResultListener2 != null) {
                            appStoreResultListener2.onResult(AppStoreResult.ERROR);
                            return;
                        }
                        return;
                    }
                    int i2 = currentVersionCode;
                    if (i2 >= i) {
                        if (i2 == i) {
                            MainCoeditLogger.m7253i(BaseUpdater.this.getTag(), "checkForceUpdateNotesVersion#getResult, currentVersion is latest");
                            BaseUpdater.this.setPrefLatestNotesVersion(i);
                            return;
                        }
                        return;
                    }
                    PackageManagerCompat.Version version3 = new PackageManagerCompat.Version(i2);
                    PackageManagerCompat.Version version4 = new PackageManagerCompat.Version(i);
                    if (version3.getMajor() == version4.getMajor() && version3.getMinor() == version4.getMinor()) {
                        MainCoeditLogger.m7253i(BaseUpdater.this.getTag(), "checkForceUpdateNotesVersion# skip");
                        BaseUpdater.this.setPrefLatestNotesVersion(i);
                        return;
                    }
                    MainCoeditLogger.m7253i(BaseUpdater.this.getTag(), "checkForceUpdateNotesVersion#getResult, currentVersion < marketVersionCode");
                    BaseUpdater.this.setPrefLatestNotesVersion(i);
                    AppStoreResultListener appStoreResultListener3 = appStoreResultListener;
                    if (appStoreResultListener3 != null) {
                        appStoreResultListener3.onResult(AppStoreResult.NEED_UPDATE);
                    }
                }
            });
            setPrefNotesCheckedPeriod(System.currentTimeMillis());
        }
        return AppStoreResult.LATEST;
    }

    public int getPrefLatestNotesVersion() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(LATEST_CHECKED_NOTES_VERSION_CODE, UpdateManager.getInstance().getCurrentVersionCode());
    }

    public abstract String getTag();
}
