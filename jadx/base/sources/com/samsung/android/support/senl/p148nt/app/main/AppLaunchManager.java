package com.samsung.android.support.senl.p148nt.app.main;

import android.content.Context;
import android.os.SystemClock;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6780b;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.quota.C6871d;
import com.samsung.android.support.senl.docscan.common.util.DocScanUtils;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.dialog.BtnProgressDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.settings.common.dialog.AllowAppPermissionDialogFragment;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.app.updater.connector.IMarketConnector;
import com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener;
import com.samsung.android.support.senl.p148nt.app.updater.connector.MarketConnectorFactory;
import com.samsung.android.support.senl.p148nt.app.updater.migration.CoverDataMigrationManager;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.EncryptUtil;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.model.restore.document.DuplicatedDatabaseDetector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Set;
import p001A.AbstractC0000a;
import p016D0.C0059d;
import p033H0.C0112b;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.C0283a;
import p079T.RunnableC0284b;
import p186h1.C12028i;
import p195k1.C12969a;
import p202m1.C13527b;
import p212o1.C13573a;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AppLaunchManager {
    private static final String TAG = "AppLaunchManager";
    private DummyDocumentDetector mDummyDocumentDetector;
    private final IMainView mIMainView;
    private final AbsAppCompatActivity mMainActivity;
    private IMarketConnector mMarketConnector;
    private BtnProgressDialogFragment.IAddonsInstallDialog mRestoreDatabaseListener;
    private DummyDocumentDetector.OnRestoreListener mRestoreListener;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.AppLaunchManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C81441 implements DummyDocumentDetector.OnRestoreListener {
        public C81441() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFinish$0() {
            AppLaunchManager.this.dismissRestoreDatabaseDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.updater.restore.DummyDocumentDetector.OnRestoreListener
        public void onFinish() {
            MainLogger.m7258i(AppLaunchManager.TAG, "restoreDatabase# onFinish");
            AppLaunchManager.this.mMainActivity.runOnUiThread(new RunnableC8158b(this, 4));
            AppLaunchManager.this.savePendingRestorePath(null);
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(DummyDocumentDetector.NEED_TO_BE_RESTORED, false);
        }

        @Override // com.samsung.android.support.senl.nt.app.updater.restore.DummyDocumentDetector.OnRestoreListener
        public void onStart() {
            MainLogger.m7258i(AppLaunchManager.TAG, "restoreDatabase# onStart");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IMainView {
        void updateDrawerDisplayData();

        void updateDrawerIconWithBadge();
    }

    public AppLaunchManager(AbsAppCompatActivity absAppCompatActivity, IMainView iMainView) {
        this.mMainActivity = absAppCompatActivity;
        this.mIMainView = iMainView;
        execute();
    }

    private void checkNetworkOperation() {
        PostLaunchManager.getInstance().addLogic(this.mMainActivity.getPostLaunchToken(), 104, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.AppLaunchManager.4
            /* JADX INFO: Access modifiers changed from: private */
            public void setupSamsungAnalyticsForChina() {
                if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
                    NotesSamsungAnalytics.setup(AppLaunchManager.this.mMainActivity.getApplication());
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                MainLogger.m7254d(AppLaunchManager.TAG, "checkNetworkOperation#");
                AppLaunchManager.this.countReviewRequest();
                if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() && !C0145c.m332q(AppLaunchManager.this.mMainActivity.getApplicationContext())) {
                    AllowAppPermissionDialogFragment allowAppPermissionDialogFragmentNewInstance = (AllowAppPermissionDialogFragment) AppLaunchManager.this.mMainActivity.getSupportFragmentManager().findFragmentByTag(AllowAppPermissionDialogFragment.TAG);
                    if (allowAppPermissionDialogFragmentNewInstance == null) {
                        allowAppPermissionDialogFragmentNewInstance = AllowAppPermissionDialogFragment.newInstance();
                    }
                    allowAppPermissionDialogFragmentNewInstance.setAllowAppPermissionDialogCallback(new AllowAppPermissionDialogFragment.AllowAppPermissionDialogCallback() { // from class: com.samsung.android.support.senl.nt.app.main.AppLaunchManager.4.1
                        @Override // com.samsung.android.support.senl.nt.app.settings.common.dialog.AllowAppPermissionDialogFragment.AllowAppPermissionDialogCallback
                        public void onAppPermissionCancel() {
                            MainLogger.m7258i(AppLaunchManager.TAG, "onAppPermissionCancel.");
                            AppLaunchManager.this.mMainActivity.finish();
                        }

                        @Override // com.samsung.android.support.senl.nt.app.settings.common.dialog.AllowAppPermissionDialogFragment.AllowAppPermissionDialogCallback
                        public void onAppPermissionConfirm() {
                            MainLogger.m7258i(AppLaunchManager.TAG, "onAppPermissionConfirm.");
                            C0145c.m303K(AppLaunchManager.this.mMainActivity.getApplicationContext());
                            setupSamsungAnalyticsForChina();
                            AppLaunchManager.this.onCheckNewVersion();
                            AppLaunchManager.this.performSyncInitialization();
                        }
                    });
                    if (allowAppPermissionDialogFragmentNewInstance.isAdded() && allowAppPermissionDialogFragmentNewInstance.isResumed()) {
                        MainLogger.m7254d(AppLaunchManager.TAG, "checkNetworkOperation# already show");
                        return;
                    }
                    try {
                        allowAppPermissionDialogFragmentNewInstance.showAllowingStateLoss(AppLaunchManager.this.mMainActivity.getSupportFragmentManager(), AllowAppPermissionDialogFragment.TAG);
                        return;
                    } catch (IllegalStateException e) {
                        MainLogger.m7255e(AppLaunchManager.TAG, "checkNetworkOperation, showPermissionDialog error: " + e.getMessage());
                        return;
                    }
                }
                setupSamsungAnalyticsForChina();
                AppLaunchManager.this.onCheckNewVersion();
                AppLaunchManager.this.performSyncInitialization();
                if (C0158a.m407a().m416i()) {
                    C6785g c6785g = AbstractC6784f.f4180a;
                    AbsAppCompatActivity absAppCompatActivity = AppLaunchManager.this.mMainActivity;
                    c6785g.getClass();
                    c6785g.f4187g = new WeakReference(absAppCompatActivity);
                    c6785g.m4946f();
                    if (c6785g.f4185e && c6785g.f4186f && !C6785g.m4937g()) {
                        C0059d.m139g(BaseUtils.getApplicationContext());
                        C0145c.m308P(SystemClock.elapsedRealtime(), "GRAPH_PREFERENCE", "key_retry_after_time");
                        C0112b c0112bM261h = C0112b.m261h();
                        String strM331p = C0145c.m331p("GRAPH_PREFERENCE", "access_token", "");
                        c0112bM261h.m269m(("".equals(strM331p) || (strM331p = new EncryptUtil().decrypt(strM331p)) != null) ? strM331p : "", null);
                        C0112b c0112bM261h2 = C0112b.m261h();
                        C6780b c6780b = new C6780b(c6785g);
                        c0112bM261h2.getClass();
                        C0112b.m262i(c6780b);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countReviewRequest() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
        sharedPreferencesCompat.putInt(NotesConstants.KEY_REVIEW_REQUEST_COUNT, sharedPreferencesCompat.getInt(NotesConstants.KEY_REVIEW_REQUEST_COUNT, 0) + 1);
    }

    private void deleteDuplicatedDB() {
        PostLaunchManager.getInstance().addBaseLogic(5, new RunnableC8158b(this, 2));
    }

    private void deleteScanCache() {
        PostLaunchManager.getInstance().addBaseLogic(203, new RunnableC0284b(9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissRestoreDatabaseDialog() {
        BtnProgressDialogFragment btnProgressDialogFragment = (BtnProgressDialogFragment) this.mMainActivity.getSupportFragmentManager().findFragmentByTag(BtnProgressDialogFragment.DB_RESTORE_DIALOG);
        if (btnProgressDialogFragment != null) {
            btnProgressDialogFragment.dismissAllowingStateLoss();
        }
    }

    private void execute() {
        checkNetworkOperation();
        restoreDatabase();
        deleteDuplicatedDB();
        deleteScanCache();
        migrateCoverData();
        updateSearchEngineData();
    }

    private void initSMP() {
        Context applicationContext = this.mMainActivity.getApplicationContext();
        if (C12969a.m13872b(applicationContext).m13874c()) {
            C12969a c12969aM13872b = C12969a.m13872b(applicationContext);
            C13573a c13573a = (C13573a) c12969aM13872b.f9308b;
            ((C13527b) c13573a.f9635b).m14277a((Context) c12969aM13872b.f9307a);
        }
    }

    private void initSamsungAccount() {
        new C0283a().m563e();
    }

    private void initServerTime() {
        new C12028i().m13709d(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDuplicatedDB$1() {
        new DuplicatedDatabaseDetector().setOnArrangeListener(new DuplicatedDatabaseDetector.OnArrangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.AppLaunchManager.3
            static final String DUPLICATED_DB_DELETE_PROGRESS_DIALOG = "DuplicatedDBDeleteProgress";

            @Override // com.samsung.android.support.senl.nt.model.restore.document.DuplicatedDatabaseDetector.OnArrangeListener
            public void onFinish() {
                MainLogger.m7254d(AppLaunchManager.TAG, "deleteDuplicatedDB# finish()");
                DialogUtils.ProgressDialogFragment progressDialogFragment = (DialogUtils.ProgressDialogFragment) AppLaunchManager.this.mMainActivity.getSupportFragmentManager().findFragmentByTag(DUPLICATED_DB_DELETE_PROGRESS_DIALOG);
                if (progressDialogFragment != null) {
                    progressDialogFragment.dismissAllowingStateLoss();
                }
            }

            @Override // com.samsung.android.support.senl.nt.model.restore.document.DuplicatedDatabaseDetector.OnArrangeListener
            public void onStart() {
                MainLogger.m7254d(AppLaunchManager.TAG, "deleteDuplicatedDB# start()");
                DialogUtils.ProgressDialogFragment progressDialogFragment = (DialogUtils.ProgressDialogFragment) DialogUtils.createProgressDialogFragment();
                progressDialogFragment.setCancelable(false);
                progressDialogFragment.showAllowingStateLoss(AppLaunchManager.this.mMainActivity.getSupportFragmentManager(), DUPLICATED_DB_DELETE_PROGRESS_DIALOG);
            }
        }).execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteScanCache$4() {
        try {
            File[] fileArrListFiles = new File(DocScanUtils.getScanCacheDir()).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (!ComposerManager.getInstance().isOpen(file.getName(), null)) {
                        FileUtils.deleteFile(file);
                    }
                }
            }
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("deleteScanCache# "), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$migrateCoverData$5() {
        CoverDataMigrationManager.execute(this.mMainActivity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckNewVersion$2() {
        if (CommonUtil.isNotAvailableActivity(this.mMainActivity)) {
            return;
        }
        MainLogger.m7254d(TAG, "onCheckNewVersion# getResult, badge update");
        this.mIMainView.updateDrawerIconWithBadge();
        this.mIMainView.updateDrawerDisplayData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCheckNewVersion$3(int i) {
        MainLogger.m7258i(TAG, "onCheckNewVersion# getResult, marketVersionCode : " + i);
        if (!UpdateManager.getInstance().needToCheck()) {
            MainLogger.m7255e(TAG, "onCheckNewVersion# getResult, needToCheck() : false");
            return;
        }
        if (i == 3) {
            MainLogger.m7255e(TAG, "onCheckNewVersion# getResult, setNeedToCheckOneHourLater");
            UpdateManager.getInstance().setNeedToCheckOneHourLater();
            return;
        }
        UpdateManager.getInstance().resetNeedToCheck();
        if (10 > i) {
            MainLogger.m7255e(TAG, "onCheckNewVersion# getResult, smaller than MINIMUM_EXPECTED_NOTES_VERSION");
            return;
        }
        if (UpdateManager.getInstance().getCurrentVersionCode() >= i) {
            MainLogger.m7255e(TAG, "onCheckNewVersion# getResult, It is latest version");
            UpdateManager.getInstance().setHasTipCard(i);
            UpdateManager.getInstance().setHasBadge(false);
            if (SyncState.isAppUpdateNeeded(this.mMainActivity.getApplicationContext())) {
                SyncState.setAppUpdateNeeded(this.mMainActivity.getApplicationContext(), false);
                return;
            }
            return;
        }
        if (UpdateManager.getInstance().hasBadge()) {
            MainLogger.m7255e(TAG, "onCheckNewVersion# getResult, already hasBadge");
            return;
        }
        int prefUserCheckedVersion = UpdateManager.getInstance().getPrefUserCheckedVersion();
        int prefCloseTipCardVersion = UpdateManager.getInstance().getPrefCloseTipCardVersion();
        AbstractC8014b.m7200b(prefUserCheckedVersion, prefCloseTipCardVersion, "onCheckNewVersion# getResult savedVersionCode : ", ", closeTipCardVersionCode : ", TAG);
        if (i > prefCloseTipCardVersion) {
            UpdateManager.getInstance().setHasTipCard(-1);
        }
        if (i <= prefUserCheckedVersion) {
            AbstractC8014b.m7212n(AbstractC0622a.m1173s(i, prefCloseTipCardVersion, "onCheckNewVersion# getResult, Detected marketVersionCode : ", ", closeTipCardVersionCode : ", ", savedVersionCode : "), TAG, prefUserCheckedVersion);
            return;
        }
        UpdateManager.getInstance().setHasBadge(true);
        UpdateManager.getInstance().setPrefUserCheckedVersion(i);
        this.mMainActivity.runOnUiThread(new RunnableC8158b(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreDatabase$0() {
        if (SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(DummyDocumentDetector.NEED_TO_BE_RESTORED, false)) {
            MainLogger.m7254d(TAG, "restoreDatabase");
            if (this.mDummyDocumentDetector == null) {
                this.mDummyDocumentDetector = new DummyDocumentDetector(this.mMainActivity.getApplicationContext());
            }
            if (this.mRestoreListener == null) {
                this.mRestoreListener = new C81441();
            }
            if (this.mRestoreDatabaseListener == null) {
                this.mRestoreDatabaseListener = new BtnProgressDialogFragment.IAddonsInstallDialog() { // from class: com.samsung.android.support.senl.nt.app.main.AppLaunchManager.2
                    @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
                    public void onBackPressed() {
                        AppLaunchManager.this.dismissRestoreDatabaseDialog();
                        AppLaunchManager appLaunchManager = AppLaunchManager.this;
                        appLaunchManager.savePendingRestorePath(appLaunchManager.mDummyDocumentDetector.cancel());
                    }

                    @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
                    public void onCancel(String str) {
                        AppLaunchManager.this.dismissRestoreDatabaseDialog();
                        AppLaunchManager appLaunchManager = AppLaunchManager.this;
                        appLaunchManager.savePendingRestorePath(appLaunchManager.mDummyDocumentDetector.cancel());
                    }

                    @Override // com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.IAddonsInstallDialog
                    public void onConfirm(String str) {
                        AbstractC0000a.m25v("restoreDatabase# onConfirm, dialogType : ", str, AppLaunchManager.TAG);
                        AppLaunchManager.this.mDummyDocumentDetector.setOnRestoreListener(AppLaunchManager.this.mRestoreListener);
                        Set<String> stringSet = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getStringSet(DummyDocumentDetector.PREF_KEY_PENDING_PATH_SET, null);
                        if (stringSet != null && !stringSet.isEmpty()) {
                            AppLaunchManager.this.mDummyDocumentDetector.execute(stringSet);
                        } else {
                            if (AppLaunchManager.this.mDummyDocumentDetector.execute()) {
                                return;
                            }
                            MainLogger.m7254d(AppLaunchManager.TAG, "restoreDatabase#, restore list is empty");
                            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(DummyDocumentDetector.NEED_TO_BE_RESTORED, false);
                            onBackPressed();
                        }
                    }
                };
            }
            showRestoreDatabaseDialog(this.mRestoreDatabaseListener);
            Set<String> stringSet = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getStringSet(DummyDocumentDetector.PREF_KEY_PENDING_PATH_SET, null);
            if (stringSet != null && !stringSet.isEmpty()) {
                MainLogger.m7258i(TAG, "restoreDatabase# restart pendingPath");
                this.mDummyDocumentDetector.setOnRestoreListener(this.mRestoreListener).execute(stringSet);
            }
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_DB_CRASH);
        }
    }

    private void migrateCoverData() {
        DataRepositoryScheduler.runnable(new RunnableC8158b(this, 1)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckNewVersion() {
        if (!UpdateManager.getInstance().isGalaxyAppStorePackageExist()) {
            MainLogger.m7258i(TAG, "onCheckNewVersion# skip - isGalaxyAppStorePackageExist() false.");
        } else if (UpdateManager.getInstance().needToCheck()) {
            this.mMarketConnector = MarketConnectorFactory.createMarketConnector();
            MainLogger.m7258i(TAG, "onCheckNewVersion# Start to check update");
            this.mMarketConnector.checkNewVersionOnMarket(new INewVersionCheckResetListener() { // from class: com.samsung.android.support.senl.nt.app.main.a
                @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener
                public final void getResult(int i) {
                    this.f6147a.lambda$onCheckNewVersion$3(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performSyncInitialization() {
        Context applicationContext = this.mMainActivity.getApplicationContext();
        initServerTime();
        initSMP();
        initSamsungAccount();
        C6871d.m5056b().m5059d(applicationContext);
    }

    private void restoreDatabase() {
        PostLaunchManager.getInstance().addBaseLogic(4, new RunnableC8158b(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePendingRestorePath(Set<String> set) {
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putStringSet(DummyDocumentDetector.PREF_KEY_PENDING_PATH_SET, set);
    }

    private void showRestoreDatabaseDialog(BtnProgressDialogFragment.IAddonsInstallDialog iAddonsInstallDialog) {
        BtnProgressDialogFragment btnProgressDialogFragment = (BtnProgressDialogFragment) this.mMainActivity.getSupportFragmentManager().findFragmentByTag(BtnProgressDialogFragment.DB_RESTORE_DIALOG);
        if (btnProgressDialogFragment == null) {
            btnProgressDialogFragment = new BtnProgressDialogFragment(BtnProgressDialogFragment.DB_RESTORE_DIALOG, false);
        }
        btnProgressDialogFragment.setContract(iAddonsInstallDialog);
        if (btnProgressDialogFragment.isResumed() && btnProgressDialogFragment.isAdded()) {
            MainLogger.m7258i(TAG, "showRestoreDatabaseDialog# already showing");
        } else {
            btnProgressDialogFragment.showAllowingStateLoss(this.mMainActivity.getSupportFragmentManager(), BtnProgressDialogFragment.DB_RESTORE_DIALOG);
        }
    }

    private void updateSearchEngineData() {
        int i = SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE").getInt("KEY_UPDATE_SEARCH_ENGINE_DATA", 0);
        if (!Features.isSearchEngineConnected() || i <= 0) {
            return;
        }
        MainLogger.m7254d(TAG, "updateSearchEngineData, request update");
        DataUpdateManager.getInstance().onDataUpdated(2);
        SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE").putInt("KEY_UPDATE_SEARCH_ENGINE_DATA", 0);
    }

    public void release() {
        IMarketConnector iMarketConnector = this.mMarketConnector;
        if (iMarketConnector != null) {
            iMarketConnector.setListener(null);
            this.mMarketConnector = null;
        }
        DummyDocumentDetector dummyDocumentDetector = this.mDummyDocumentDetector;
        if (dummyDocumentDetector != null) {
            savePendingRestorePath(dummyDocumentDetector.cancel());
            this.mDummyDocumentDetector = null;
        }
    }
}
