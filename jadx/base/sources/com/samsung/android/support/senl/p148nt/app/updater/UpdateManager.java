package com.samsung.android.support.senl.p148nt.app.updater;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.quota.C6871d;
import com.samsung.android.support.senl.p145cm.base.common.constants.AppUpdateConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.app.trash.EmptyTrashNotifier;
import com.samsung.android.support.senl.p148nt.app.updater.restore.RestoreDatabaseManager;
import com.samsung.android.support.senl.p148nt.app.updater.version.VersionChecker;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.diagmon.DiagMonLogger;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ImageTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.PdfTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import p042J1.C0145c;
import p079T.RunnableC0286d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class UpdateManager {
    private static final String GALAXY_APPS_CHECK_TWICE_A_DAY = "galaxy_apps_check_once_a_day";
    private static final String GALAXY_APPS_CHECK_WHEN_SEP_CHANGED = "galaxy_apps_check_when_sep_changed";
    public static final int SHOW_TIPCARD_VERSION = -1;
    private static final String TAG = "UpdateManager";
    private static UpdateManager mInstance;
    private final String GALAXY_APPS_PACKAGE_NAME = "com.sec.android.app.samsungapps";
    private final long UPDATE_CHECK_PERIOD = 172800000;
    private final long UPDATE_CHECK_ONE_HOUR = 3600000;
    private final VersionChecker mVersionChecker = new VersionChecker();
    private VersionChecker.StartType mStartType = VersionChecker.StartType.Normal;

    private void clearGlideDiskCache(final Context context) {
        AbstractC4539a.m3201k(TAG).execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.updater.UpdateManager.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.m8697d(UpdateManager.TAG, "clearGlideDiskCache# start");
                Glide.get(context).clearDiskCache();
                Logger.m8697d(UpdateManager.TAG, "clearGlideDiskCache# end");
            }
        });
    }

    public static UpdateManager getInstance() {
        synchronized (UpdateManager.class) {
            try {
                if (mInstance == null) {
                    mInstance = new UpdateManager();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mInstance;
    }

    private int getPrefLatestSepVersion() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(GALAXY_APPS_CHECK_WHEN_SEP_CHANGED, 0);
    }

    private long getUpdatePeriod() {
        return SharedPreferencesCompat.getInstance("Settings").getLong(GALAXY_APPS_CHECK_TWICE_A_DAY, 0L);
    }

    private void handleFirstTimeAfterVersionUpdate(Context context) {
        RestoreDatabaseManager.restore(this.mVersionChecker.getMLastVersionCode());
        revisionOperation(this.mVersionChecker.getMCurrentVersionCode(), this.mVersionChecker.getMLastVersionCode());
        if (SyncState.isAppUpdateNeeded(context)) {
            SyncState.setAppUpdateNeeded(context, false);
        }
        updateViewModeIfNeeded();
        DiagMonLogger.clearPreferencesForLogger();
        C6871d.m5056b().getClass();
        Debugger.m8615i("QT/QuotaHelper", "clear()");
        if (C0145c.m323h("QUOTA_PREFERENCE", "quota_ui_checked", false)) {
            C0145c.m304L("QUOTA_PREFERENCE", "quota_ui_checked", false);
        }
        if (!TextUtils.isEmpty(C0145c.m331p("QUOTA_PREFERENCE", "quota_od_link_status", ""))) {
            C0145c.m310R("QUOTA_PREFERENCE", "quota_od_link_status", "");
        }
        if (!TextUtils.isEmpty(C0145c.m331p("QUOTA_PREFERENCE", "quota_eof_status", ""))) {
            C0145c.m310R("QUOTA_PREFERENCE", "quota_eof_status", "");
        }
        new EmptyTrashNotifier().execute(true);
        updateCoverData(context);
        updateSpenSdk();
        updateFabData();
    }

    private void handleFirstTimeAfterVersionUpdateGuaranteed(Context context) {
        if (this.mVersionChecker.isVersionUpdated()) {
            RestoreDatabaseManager.prepareRestoreGuaranteed();
            SyncState.setStoreConnected(false);
            this.mVersionChecker.resetVersionUpdated();
            clearGlideDiskCache(context);
            SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE").putInt("KEY_UPDATE_SEARCH_ENGINE_DATA", 1);
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(TipCardUtil.KEY_CONVERT_TRY_COUNT, 0);
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putLong(TipCardUtil.KEY_LAST_CONVERT_CHECKED_TIME, 0L);
        }
        RestoreDatabaseManager.restoreGuaranteed(context);
    }

    public static boolean isValid() {
        return mInstance != null;
    }

    private void migrateCoverData(Context context, ExecutorService executorService) {
        SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE").putInt("KEY_COVER_DATA_MIGRATION", 1);
        executorService.execute(new RunnableC0286d(context, 7));
    }

    private void revisionOperation(int i, int i2) {
        setPreviousVersionCode(i2);
        setHasTipCard(i);
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Settings");
        if (i2 < 400220000 && DeviceUtils.isTabletModel()) {
            sharedPreferencesCompat.remove(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING);
        }
        if (i2 < 420206000) {
            sharedPreferencesCompat.putBoolean(SettingsConstants.SETTINGS_ANCHOR_TO_TEXT_ENABLED, false);
        }
        if (i2 >= 443600000 || !sharedPreferencesCompat.contains(SettingsConstants.SETTINGS_TEMPLATE_TYPE)) {
            return;
        }
        int templateViewType = DocumentBackgroundUtils.getTemplateViewType();
        String templatePath = DocumentBackgroundUtils.getTemplatePath();
        if (TemplateViewType.isLegacyPdfType(templateViewType)) {
            sharedPreferencesCompat.putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, PdfTemplatePresenterUtil.getTemplateTypeFromTemplateName(templatePath, DocumentPageRatio.getPageRatioTypeFromSettings().getPageRatio()));
        } else if (TemplateViewType.isLegacyImageType(templateViewType)) {
            sharedPreferencesCompat.putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, ImageTemplatePresenterUtil.getTemplateTypeFromTemplateName(templatePath));
        }
    }

    private void saveCoverPreviewJpg(final Context context, ExecutorService executorService) {
        if (this.mVersionChecker.getMLastVersionCode() <= 441400000) {
            executorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.updater.UpdateManager.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m8697d(UpdateManager.TAG, "saveCoverPreviewJpg# start");
                    NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
                    List<Pair<String, Integer>> listCreateCategoryList = CoverData.createCategoryList();
                    ArrayList<String> arrayList = new ArrayList();
                    for (Pair<String, Integer> pair : listCreateCategoryList) {
                        ArrayList arrayList2 = new ArrayList(notesDocumentCoverRepositoryCreateDocumentCoverRepository.getUuidList((String) pair.first, 0));
                        arrayList.addAll(arrayList2);
                        Logger.m8697d(UpdateManager.TAG, "saveCoverPreviewJpg# category : " + pair + ", size : " + arrayList2.size());
                    }
                    for (String str : arrayList) {
                        DocumentCoverStateTuple coverStateTuple = notesDocumentCoverRepositoryCreateDocumentCoverRepository.getCoverStateTuple(str);
                        if (coverStateTuple != null && coverStateTuple.isEnabled()) {
                            CoverEditorUtils.savePreviewJpg(context, coverStateTuple.getSummary(), coverStateTuple.getCategoryUuid(), coverStateTuple.getTemplateUuid(), coverStateTuple.getBackgroundColor(), str, coverStateTuple.getState());
                        }
                    }
                }
            });
            return;
        }
        Logger.m8697d(TAG, "saveCoverPreviewJpg# last version code : " + this.mVersionChecker.getMLastVersionCode());
    }

    private void setPrefCloseTipCardVersion(int i) {
        SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.CLOSE_TIPCARD_VERSION, i);
    }

    private void setPrefLatestSepVersion(int i) {
        SharedPreferencesCompat.getInstance("Settings").putInt(GALAXY_APPS_CHECK_WHEN_SEP_CHANGED, i);
    }

    private void setUpdatePeriod(long j) {
        SharedPreferencesCompat.getInstance("Settings").putLong(GALAXY_APPS_CHECK_TWICE_A_DAY, j);
    }

    private void updateCoverData(Context context) {
        ExecutorService executorServiceM3201k = AbstractC4539a.m3201k(TAG);
        saveCoverPreviewJpg(context, executorServiceM3201k);
        migrateCoverData(context, executorServiceM3201k);
    }

    private void updateFabData() {
        SharedPreferencesCompat.getInstance(Constants.PREF_NAME_SMART_POPUP).putInt(Constants.KEY_FAB_REMAINING_NOTIFICATION_COUNT, 3);
    }

    private void updateViewModeIfNeeded() {
        int viewMode = ContentUtils.getViewMode();
        AbstractC4539a.m3203m(viewMode, "updateViewModeIfNeeded# viewMode : ", TAG);
        if (viewMode != 2) {
            if (viewMode != 3) {
                return;
            }
            if (ModelFeature.getFeature().needNoThumbnailSimpleList()) {
                ContentUtils.setViewMode(6);
                return;
            } else {
                Logger.m8698e(TAG, "updateViewModeIfNeeded# no MODEL_FEATURE_NO_THUMBNAIL_SIMPLE_LIST");
                return;
            }
        }
        if (!ModelFeature.getFeature().getIsDefaultViewModeGridSmall()) {
            Logger.m8698e(TAG, "updateViewModeIfNeeded# no MODEL_FEATURE_DEFAULT_VIEW_MODE_GRID_MEDIUM");
            return;
        }
        if (-1 == SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("view_mode", -1)) {
            Logger.m8698e(TAG, "updateViewModeIfNeeded# preference value is VIEW_MODE_NONE");
            return;
        }
        int lastVersionCode = this.mVersionChecker.getMLastVersionCode() / 100000;
        if (lastVersionCode < 4302) {
            ContentUtils.setViewMode(4);
            return;
        }
        Logger.m8698e(TAG, "updateViewModeIfNeeded# lastVersion : " + lastVersionCode);
    }

    public int getCurrentVersionCode() {
        Context applicationContext = BaseUtils.getApplicationContext();
        int versionCode = PackageManagerCompat.INSTANCE.getInstance().getVersionCode(applicationContext, applicationContext.getPackageName());
        if (versionCode > 0) {
            return versionCode;
        }
        return 0;
    }

    public int getLastCheckedMarketVersionCode() {
        return this.mVersionChecker.getMLastCheckedMarketVersionCode();
    }

    public int getPrefCloseTipCardVersion() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.CLOSE_TIPCARD_VERSION, 0);
    }

    public int getPrefUserCheckedVersion() {
        return SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.USER_CHECKED_VERSION, 0);
    }

    public void goToGalaxyAppStore() {
        goToGalaxyAppStore(BaseUtils.getApplicationContext().getPackageName());
    }

    public void handleAppUpdate() {
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mStartType = this.mVersionChecker.checkVersionStart();
        Logger.m8697d(TAG, "handleAppUpdate, startType: " + this.mStartType);
        handleFirstTimeAfterVersionUpdateGuaranteed(applicationContext);
        VersionChecker.StartType startType = this.mStartType;
        if (startType == VersionChecker.StartType.FirstTimeAfterVersionUpdate) {
            Logger.m8700f(TAG, "App version changed! - last: " + this.mVersionChecker.getMLastVersionCode() + " current: " + this.mVersionChecker.getMCurrentVersionCode());
            handleFirstTimeAfterVersionUpdate(applicationContext);
        } else if (startType == VersionChecker.StartType.FirstTime) {
            updateFabData();
        }
        new RevisionOperationExecutor(this.mVersionChecker).execute(applicationContext);
    }

    public boolean hasBadge() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.HAS_NEW_VERSION_BADGE, false) && getCurrentVersionCode() < getPrefUserCheckedVersion();
    }

    public boolean hasTipCard() {
        return getPrefCloseTipCardVersion() == -1;
    }

    public void initLastCheckedMarketVersionCode() {
        this.mVersionChecker.initLastCheckedMarketVersionCode();
    }

    public boolean isGalaxyAppStorePackageExist() {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(BaseUtils.getApplicationContext(), "com.sec.android.app.samsungapps");
    }

    public boolean isStartFirstTimeAfterVersionUpdate() {
        return VersionChecker.StartType.FirstTimeAfterVersionUpdate.equals(this.mStartType);
    }

    public boolean needToCheck() {
        int prefLatestSepVersion = getPrefLatestSepVersion();
        int semPlatformVersionInt = DeviceInfo.getSemPlatformVersionInt(0);
        if (semPlatformVersionInt != prefLatestSepVersion) {
            if (prefLatestSepVersion != 0) {
                MainLogger.m7258i(TAG, "needToCheck(). true - SEP version is changed.");
                return true;
            }
            setPrefLatestSepVersion(semPlatformVersionInt);
        }
        long updatePeriod = getUpdatePeriod();
        if (updatePeriod == 0) {
            MainLogger.m7258i(TAG, "needToCheck(). false - do not check server app version at the first app launch.");
            setUpdatePeriod(System.currentTimeMillis());
            return false;
        }
        if (System.currentTimeMillis() - updatePeriod >= 172800000) {
            MainLogger.m7258i(TAG, "needToCheck(). true");
            return true;
        }
        MainLogger.m7258i(TAG, "needToCheck(). false - operate only once every two days.. So skip. " + updatePeriod);
        return false;
    }

    public void resetNeedToCheck() {
        setUpdatePeriod(System.currentTimeMillis());
        int prefLatestSepVersion = getPrefLatestSepVersion();
        int semPlatformVersionInt = DeviceInfo.getSemPlatformVersionInt(0);
        if (semPlatformVersionInt != prefLatestSepVersion) {
            setPrefLatestSepVersion(semPlatformVersionInt);
        }
        AbstractC8014b.m7200b(prefLatestSepVersion, semPlatformVersionInt, "resetNeedToCheck# latestSepVersion : ", ", currentSepVersion : ", TAG);
    }

    public void setHasBadge(boolean z) {
        MainLogger.m7258i(TAG, "updateBadge : " + z);
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.HAS_NEW_VERSION_BADGE, z);
    }

    public void setHasTipCard(int i) {
        AbstractC8014b.m7201c(i, "setHasTipCard : ", TAG);
        setPrefCloseTipCardVersion(i);
    }

    public void setLastCheckedMarketVersionCode(int i) {
        this.mVersionChecker.setLastCheckedMarketVersionCode(i);
    }

    public void setNeedToCheckOneHourLater() {
        setUpdatePeriod(System.currentTimeMillis() - 169200000);
    }

    public void setPrefUserCheckedVersion(int i) {
        SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.USER_CHECKED_VERSION, i);
    }

    public void setPreviousVersionCode(int i) {
        MainLogger.m7258i(TAG, "setPreviousVersionCode : " + i);
        SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.SETTINGS_PREVIOUS_VERSION, i);
    }

    public void updateSpenSdk() {
        AbstractC4539a.m3201k(TAG).execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.updater.UpdateManager.2
            @Override // java.lang.Runnable
            public void run() {
                Context applicationContext = BaseUtils.getApplicationContext();
                SpenSdkInitializer.initialize(applicationContext);
                SpenSdkInitializer.updateSDK(applicationContext);
            }
        });
    }

    public void goToGalaxyAppStore(String str) {
        MainLogger.m7258i(TAG, "goToGalaxyAppStore# ");
        Context applicationContext = BaseUtils.getApplicationContext();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(AppUpdateConstants.PRODUCT_DETAIL + str + "/?source=SamsungNotes&fsOrigin=stubUpdateCheck&fsUpdateType=self"));
        intent.addFlags(335544352);
        if (intent.resolveActivity(applicationContext.getPackageManager()) != null) {
            try {
                applicationContext.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                MainLogger.m7255e(TAG, "goToGalaxyAppStore# " + e.getMessage());
            }
        }
    }
}
