package p079T;

import android.content.Context;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.samsung.android.livetranslation.text.LiveTranslation;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.importer.ImportProcessor;
import com.samsung.android.support.senl.p148nt.app.main.AppLaunchManager;
import com.samsung.android.support.senl.p148nt.app.main.drawer.view.DrawerFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.EditModeView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistOnDeviceFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncWithSamsungAccountPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;
import com.samsung.android.support.senl.p148nt.app.sync.providers.DataUpdateObserverImpl;
import com.samsung.android.support.senl.p148nt.app.updater.RevisionOperationExecutor;
import com.samsung.android.support.senl.p148nt.app.updater.restore.RestoreDatabaseManager;
import com.samsung.android.support.senl.p148nt.base.common.MemoryLogger;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.TokenManager$sAuthInfoReqListener$1;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTT;

/* JADX INFO: renamed from: T.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0284b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f740a;

    public /* synthetic */ RunnableC0284b(int i) {
        this.f740a = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f740a) {
            case 0:
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null) {
                    ToastHandler.show(applicationContext, applicationContext.getResources().getString(C7943R.string.base_toast_not_delete_opened_note), 0, true);
                    break;
                }
                break;
            case 1:
                TokenManager.requestAuthInfo$lambda$1();
                break;
            case 2:
                TokenManager.setTokenExpiredRequestAuthInfo$lambda$0();
                break;
            case 3:
                TokenManager$sAuthInfoReqListener$1.onReceived$lambda$0();
                break;
            case 4:
                AlarmManagerSchedulerBroadcastReceiver.lambda$onReceive$0();
                break;
            case 5:
                LiveTranslation.lambda$_captureRequestCallback$1();
                break;
            case 6:
                Log.i(ProcessingLightEffect.TAG, "Stop Animation - onStart");
                break;
            case 7:
                Log.i(ProcessingLightEffect.TAG, "Stop Animation - onCancel");
                break;
            case 8:
                ImportProcessor.lambda$initialize$0();
                break;
            case 9:
                AppLaunchManager.lambda$deleteScanCache$4();
                break;
            case 10:
                DrawerFragment.lambda$updateDrawerLayout$0();
                break;
            case 11:
                HolderAnimation.mIsVibrating = false;
                break;
            case 12:
                SpaceEditMode.lambda$appendStartCoedit$0();
                break;
            case 13:
                EditModeView.lambda$appendStartCoedit$2();
                break;
            case 14:
                SettingsNotesAssistOnDeviceFragment.mPrivacyNoticeLinkActions$lambda$0();
                break;
            case 15:
                SettingsNotesAssistOnDeviceFragment.mPrivacyNoticeLinkActions$lambda$1();
                break;
            case 16:
                SettingsNotesAssistPrefFragment.mPrivacyNoticeLinkActions$lambda$0();
                break;
            case 17:
                SettingsNotesAssistPrefFragment.mPrivacyNoticeLinkActions$lambda$1();
                break;
            case 18:
                SettingsSyncWithSamsungAccountPrefFragment.onActivityResult$lambda$13();
                break;
            case 19:
                SettingsSearchIndexingManager.requestIndexing();
                break;
            case 20:
                DataUpdateObserverImpl.lambda$onDataUpdated$0();
                break;
            case 21:
                RevisionOperationExecutor.lambda$recognizeSDocs$1();
                break;
            case 22:
                RevisionOperationExecutor.lambda$restoreCorruptData$0();
                break;
            case 23:
                RestoreDatabaseManager.lambda$repairScreenOffMemoFolder$3();
                break;
            case 24:
                RestoreDatabaseManager.lambda$restoreAfterInit$0();
                break;
            case 25:
                MemoryLogger.dump$lambda$0();
                break;
            case 26:
                RecentSearchDatabaseHelper.AsyncExecutor.deleteAllSearchKeywords$lambda$2();
                break;
            case 27:
                ToastHelper.rPostShow$lambda$0();
                break;
            case 28:
                ToastHelper.mRunnableShowCompleted$lambda$1();
                break;
            default:
                AiMenuResultViewSTT.lambda$initTranslateConfig$21();
                break;
        }
    }
}
