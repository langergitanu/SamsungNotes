package com.samsung.android.app.notes;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.samsung.android.app.notes.control.NotificationChannelManager;
import com.samsung.android.app.notes.memolist.MemoListActivity;
import com.samsung.android.app.notes.memolist.MemoListBaseActivity;
import com.samsung.android.app.notes.memolist.MemoPickerActivity;
import com.samsung.android.app.notes.memolist.MultiInstanceMemoListActivity;
import com.samsung.android.app.notes.nativecomposer.NativeComposerActionNewActivity;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.app.notes.receiver.CoeditPushReceiver;
import com.samsung.android.app.notes.receiver.EdpPushReceiver;
import com.samsung.android.app.notes.receiver.KnoxRestrictionsReceiver;
import com.samsung.android.app.notes.receiver.MdePushReceiver;
import com.samsung.android.app.notes.receiver.SpenEventBroadcastReceiverSwitcher;
import com.samsung.android.app.notes.sync.p135db.C6733b;
import com.samsung.android.app.notes.tools.CreateNoteActivity;
import com.samsung.android.app.notes.widget.AppWidgetConfiguration;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import com.samsung.android.app.notes.widget.WidgetToolBarProvider;
import com.samsung.android.model.contractimpl.DocumentAccessContractImpl;
import com.samsung.android.model.contractimpl.FolderAccessContractImpl;
import com.samsung.android.model.contractimpl.ParseHyperTextContractImpl;
import com.samsung.android.model.contractimpl.RequestCmsContractImpl;
import com.samsung.android.model.contractimpl.RequestCollectContractImpl;
import com.samsung.android.model.contractimpl.RequestSCloudContractImpl;
import com.samsung.android.model.contractimpl.RequestSamsungAccountContractImpl;
import com.samsung.android.model.contractimpl.RequestSyncContractImpl;
import com.samsung.android.sdk.smp.SmpActivityLifecycleCallbacks;
import com.samsung.android.support.notes.bixby.BixbyManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AddonInitializer;
import com.samsung.android.support.senl.p148nt.app.jobscheduler.NotesJobService;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.LockManagerFactory;
import com.samsung.android.support.senl.p148nt.app.lock.ScreenLockManager;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockBackupUtil;
import com.samsung.android.support.senl.p148nt.app.main.coedit.CoeditLaunchSocialPickerActivity;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.CoeditSpacePickerActivity;
import com.samsung.android.support.senl.p148nt.app.main.folder.FolderListActivity;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.dialog.FolderPickerDialog;
import com.samsung.android.support.senl.p148nt.app.main.hashtag.HashTagNotesActivity;
import com.samsung.android.support.senl.p148nt.app.main.invitation.GcsInvitationActivity;
import com.samsung.android.support.senl.p148nt.app.main.livesharing.LiveSharingActivity;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.app.settings.SettingsActivity;
import com.samsung.android.support.senl.p148nt.app.settings.about.SetupWizardWelcomeActivity;
import com.samsung.android.support.senl.p148nt.app.sync.SyncInitializer;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocTagResolverContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.SyncNotificationHelper;
import com.samsung.android.support.senl.p148nt.app.sync.providers.DataUpdateObserverImpl;
import com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.app.updater.restore.RestoreDatabaseManager;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.MemoryLogger;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.coedit.CoeditAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.hashtag.HashTagAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.LockAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.ReceiverAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityClientManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToCmsManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareComponents;
import com.samsung.android.support.senl.p148nt.base.framework.support.DeveloperMode;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.coedit.service.CoeditService;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.RunnableC9675B;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.PdfWriterActivity;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.contract.DataToComposerManager;
import com.samsung.android.support.senl.p148nt.data.contract.DataToModelManager;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.model.executor.ModelThreadPoolExecutor;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentServiceIntent;
import com.samsung.android.support.senl.p148nt.word.DocConverterConfiguration;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.function.C13849N;
import p044K.C0158a;
import p073R.C0226e;
import p073R.C0228g;
import p188i3.RunnableC12034a;
import p258y.AbstractC14516b;
import p258y.RunnableC14515a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MemoApplication extends Application {
    public static final String TAG = "MemoApplication";
    private Context mApplicationContext;
    private Locale mCurrentLocale = null;
    private Runnable mRunnableToUpdateDisplay;
    private Handler mUIHandler;

    private void changeConfigurationToDisplayUtils(@NonNull Configuration configuration) {
        if (DisplayUtils.onConfigurationChanged(this.mApplicationContext, configuration)) {
            return;
        }
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler(Looper.getMainLooper());
            this.mRunnableToUpdateDisplay = new RunnableC14515a(this, 4);
        }
        this.mUIHandler.removeCallbacks(this.mRunnableToUpdateDisplay);
        this.mUIHandler.postDelayed(this.mRunnableToUpdateDisplay, 50L);
    }

    public static void initAccessHandler() {
        NoteListAccessHandler.setNoteListClass(MemoListActivity.class);
        NoteListAccessHandler.setNoteListBaseActivityClass(MemoListBaseActivity.class);
        NoteListAccessHandler.setNotePickerClass(MemoPickerActivity.class);
        NoteListAccessHandler.setSettingsActivity(SettingsActivity.class);
        NoteListAccessHandler.setSharedInvitationListClass(GcsInvitationActivity.class);
        NoteListAccessHandler.setSocialPickerClass(CoeditLaunchSocialPickerActivity.class);
        NoteListAccessHandler.setCoeditSpacePickerClass(CoeditSpacePickerActivity.class);
        NoteListAccessHandler.setLiveSharingActivityClass(LiveSharingActivity.class);
        NoteListAccessHandler.setNoteListMultiInstanceClass(MultiInstanceMemoListActivity.class);
        PermissionHelper.setNoticePermissionActivity(SetupWizardWelcomeActivity.class);
        DocumentAccessHandler.setContract(new DocumentAccessContractImpl());
        CoeditAccessHandler.setCoeditServiceClass(CoeditService.class);
        LockAccessHandler.setLockActivityClass(LockActivity.class);
        LockAccessHandler.setLockManagerFactory(new LockManagerFactory());
        HashTagAccessHandler.setHashTagNotesActivityClass(HashTagNotesActivity.class);
        HashTagAccessHandler.setContract(new SDocTagResolverContractImpl());
        FolderAccessHandler.setFolderListClass(FolderListActivity.class);
        FolderAccessHandler.setFolderPickerDialogClass(FolderPickerDialog.class);
        FolderAccessHandler.setContract(new FolderAccessContractImpl());
        ComposerAccessHandler.setComposerActivityClass(ComposerActivity.class);
        ComposerAccessHandler.setNativeComposerActionNewActivityClass(NativeComposerActionNewActivity.class);
        ComposerAccessHandler.setPdfReaderActivityClass(PdfWriterActivity.class);
        ComposerAccessHandler.setCreateNoteActivityClass(CreateNoteActivity.class);
        ComposerAccessHandler.setPopupNoteServiceClass(PopupNoteService.class);
        WidgetAccessHandler.setWidgetToolbarProviderClass(WidgetToolBarProvider.class);
        WidgetAccessHandler.setNoteListWidgetProviderClass(WidgetListProvider.class);
        AddonInitializer.initialize();
        ReceiverAccessHandler.setMdePushReceiverClass(MdePushReceiver.class);
        ReceiverAccessHandler.setCoeditPushReceiverClass(CoeditPushReceiver.class);
        ReceiverAccessHandler.setEdpPushReceiverClass(EdpPushReceiver.class);
        ReceiverAccessHandler.setKnoxRestrictionsReceiverClass(KnoxRestrictionsReceiver.class);
    }

    private void initBixby(boolean z) {
        BixbyManager.getInstance().setup(z, this);
        BixbyManager.getInstance().registerBixby2Action(new C13849N(20));
    }

    private void initDatabase() {
        DataUtils.setContext(this.mApplicationContext);
        NotesDatabaseManager.init();
        DataToSyncManager.getInstance().init(new C6733b());
        FolderManager.getInstance().initializePredefined(31);
        RestoreDatabaseManager.restoreAfterInit();
    }

    private void initSamsungAnalytics(boolean z) {
        NotesSamsungAnalytics.init(z);
    }

    private void initShareDropComponents() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(MemoListActivity.class);
        arrayList.add(MemoPickerActivity.class);
        arrayList.add(NativeComposerActionNewActivity.class);
        arrayList.add(DocOpenTriggerActivity.class);
        ShareComponents.initAppDropList(arrayList);
    }

    private boolean isSamsungFuncEnabled() {
        return (PackageManagerCompat.INSTANCE.getInstance().isKMemoPackage(this.mApplicationContext) || UserHandleCompat.getInstance().isKnoxMode() || DeviceInfo.isOtherCorpDevice()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeConfigurationToDisplayUtils$10() {
        DisplayUtils.updateMainScreenSize(this.mApplicationContext, "DisplayListener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$0() {
        Logger.m8697d(TAG, "DocConverterConfiguration setup");
        DocConverterConfiguration.setup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onCreate$1() {
        Logger.m8697d(TAG, "init TAG_COMPOSER_SETUP");
        DeveloperMode.initFilesDirForDeveloperMode(this.mApplicationContext.getFilesDir().getPath());
        initShareDropComponents();
        new ShareCacheHelper().removeCache(this);
        ComposerCacheFileUtil.trimCache(this);
        ClipboardCacheManager.trimCache(this);
        File file = new File(AbstractC14517a.m15149i(this));
        if (!file.exists()) {
            Logger.m8698e("ImportCacheRepository", "trimCache, No cache dir");
            return;
        }
        File[] fileArrListFiles = new File(file.getPath()).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        new SenlThreadFactory("ImportCacheRepository").newThread(new RunnableC12034a(fileArrListFiles, 13)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onCreate$2() {
        Logger.m8697d(TAG, "init TAG_SYNC_SETUP");
        DocumentAccessHandler.setContract(new DocumentAccessContractImpl());
        SyncInitializer.lazyInitialize(this.mApplicationContext);
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        companion.getInstance().setRequestSyncContract(new RequestSyncContractImpl());
        companion.getInstance().setGcsResolver(new C0228g());
        companion.getInstance().setCoeditResolver(new C0226e());
        RequestToSamsungAccountManager.INSTANCE.getInstance().setRequestSamsungAccountContract(new RequestSamsungAccountContractImpl());
        RequestToSCloudManager.INSTANCE.getInstance().setRequestSCloudContract(new RequestSCloudContractImpl());
        RequestToCmsManager.INSTANCE.getInstance().setRequestCmsContract(new RequestCmsContractImpl());
        DataToModelManager.getInstance().setRequestCollectContract(new RequestCollectContractImpl());
        registerActivityLifecycleCallbacks(new SmpActivityLifecycleCallbacks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$3() {
        Logger.m8697d(TAG, "init TAG_RECOGNIZER_SETUP");
        DataToComposerManager.getInstance().setParseHyperTextContract(new ParseHyperTextContractImpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$4() {
        Logger.m8697d(TAG, "init access handler");
        initAccessHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5() {
        Logger.m8702i(TAG, "init TAG_MEMO_APPLICATION_BASE_SETUP");
        if (SharedPreferencesCompat.getInstance("Settings").getLong(SettingsConstants.SETTINGS_COMPOSER_BG_INVERT_BASE_TIME_FOR_PDF, -1L) <= 0) {
            SharedPreferencesCompat.getInstance("Settings").putLong(SettingsConstants.SETTINGS_COMPOSER_BG_INVERT_BASE_TIME_FOR_PDF, new Date().getTime());
            Logger.m8702i(TAG, "init TAG_MEMO_APPLICATION_BASE_SETUP# set ComposerBgInvertBaseTimeForPDF");
        }
        UpdateManager.getInstance().handleAppUpdate();
        Logger.setupFileLogger(this.mApplicationContext);
        MemoryLogger.monitor();
        if (!SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
            NotesSamsungAnalytics.setup(this);
        }
        NotesJobService.getInstance().registerJobs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6() {
        Logger.m8697d(TAG, "init TAG_MEMO_APPLICATION_SIDE_SETUP");
        ClipboardManagerCompat.INSTANCE.getInstance().init(this);
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.APP_LAUNCH_PREFERENCE, 0);
        if (sharedPreferences.getBoolean(Constants.FIRST_TIME_USE, true)) {
            sharedPreferences.edit().putBoolean(Constants.FIRST_TIME_USE, false).apply();
        }
        NotificationChannelManager.cleanNotificationChannels(this.mApplicationContext);
        DataUpdateManager.getInstance().addObserver(0, new DataUpdateObserverImpl(this.mApplicationContext));
        if (!PackageManagerCompat.INSTANCE.getInstance().getMetaData(getApplicationContext(), getApplicationContext().getPackageName(), "com.samsung.android.app.notes.disable.BR.com.samsung.pen.INSERT", false) && 1 != SpenEventBroadcastReceiverSwitcher.getComponentEnabledSetting(getApplicationContext())) {
            SpenEventBroadcastReceiverSwitcher.enableSpenEventBroadcastReceiver(getApplicationContext());
        }
        LockBackupUtil.backupLockInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7() {
        if (ContinuityServiceManager.isSupportedInAppCollaborationAsClient()) {
            ContinuityClientManager.getInstance().initContinuityService(getApplicationContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRestoreDocumentAction$8() {
        new PwFileManager().getValidCacheFiles(this.mApplicationContext, false);
        if (SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE").getBoolean(DocumentServiceConstants.Task.CACHE_RESAVE_TASK_IN_PROGRESS, false) || UpdateManager.getInstance().isStartFirstTimeAfterVersionUpdate()) {
            NotesWordDocumentServiceIntent.removeCacheAndResave(getApplicationContext());
        } else {
            NotesWordDocumentServiceIntent.restoreCaches(getApplicationContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRestoreDocumentAction$9() {
        Logger.m8697d(TAG, "init TAG_RESTORE_CACHE");
        try {
            ModelThreadPoolExecutor.getSingleThreadExecutor().execute(new RunnableC14515a(this, 2));
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("Cannot start sdoc service. "), TAG);
        }
    }

    private void sendRestoreDocumentAction() {
        Logger.m8697d(TAG, "sendRestoreDocumentAction, send restore action - start");
        PostLaunchManager.getInstance().addBaseLogic(202, new RunnableC14515a(this, 3));
        Logger.m8697d(TAG, "sendRestoreDocumentAction, send restore action - end");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        changeConfigurationToDisplayUtils(configuration);
        SyncNotificationHelper.changeConfiguration(this.mApplicationContext, configuration);
        int i = configuration.uiMode;
        Debugger.m8607d("ConditionalFeature", "onConfigurationChanged# oldUiMode : " + C0158a.f488h + ", newUiMode : " + i);
        if (C0158a.f488h != i) {
            C0158a.f486f = false;
            C0158a.f489i = false;
            C0158a.f488h = i;
            RequestToSyncManager.INSTANCE.initPreferenceMDESupported();
        }
        Locale locale = LocaleUtils.getLocale(configuration);
        Locale locale2 = this.mCurrentLocale;
        if (locale2 == null || !locale2.equals(locale)) {
            Logger.m8697d(TAG, "onConfigurationChanged Locale is changed : " + this.mCurrentLocale + " to " + locale);
            NotificationChannelManager.updateNotificationChannels(getBaseContext());
            this.mCurrentLocale = locale;
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.mApplicationContext = getApplicationContext();
        ApplicationManager.getInstance().setAppContext(this.mApplicationContext);
        BaseUtils.setApplicationContext(this.mApplicationContext);
        registerActivityLifecycleCallbacks(ApplicationManager.getInstance().getActivityTracker());
        registerActivityLifecycleCallbacks(ApplicationManager.getInstance().getAsyncTaskManager());
        registerActivityLifecycleCallbacks(new ScreenLockManager());
        initDatabase();
        SharedPreferencesCompat.setApplicationContext(this.mApplicationContext);
        TypedArrayCompat.INSTANCE.setApplicationContext(this.mApplicationContext);
        SettingsContentObserver.INSTANCE.setApplicationContext(this.mApplicationContext);
        AppWidgetConfiguration.setup();
        boolean zIsSamsungFuncEnabled = isSamsungFuncEnabled();
        initSamsungAnalytics(zIsSamsungFuncEnabled);
        initBixby(zIsSamsungFuncEnabled);
        SyncInitializer.quickInitialize(this.mApplicationContext);
        PostLaunchManager postLaunchManager = PostLaunchManager.getInstance();
        postLaunchManager.addBaseLogic(204, new RunnableC9675B(3));
        postLaunchManager.addBaseLogic(201, new RunnableC14515a(this, 5));
        postLaunchManager.addBaseLogic(301, new RunnableC14515a(this, 6));
        postLaunchManager.addBaseLogic(302, new RunnableC9675B(4));
        postLaunchManager.addBaseLogic(1, new RunnableC9675B(5));
        postLaunchManager.addBaseLogic(2, new RunnableC14515a(this, 7));
        postLaunchManager.addBaseLogic(3, new RunnableC14515a(this, 0));
        postLaunchManager.addBaseLogic(6, new RunnableC14515a(this, 1));
        MultiTaskManager.getInstance().initialize(MemoListActivity.class);
        sendRestoreDocumentAction();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        ApplicationManager.getInstance().getActivityTracker().onTrimMemory(i);
        Logger.m8697d(TAG, "onTrimMemory: " + i);
    }
}
