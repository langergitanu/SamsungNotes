package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;
import com.samsung.android.app.notes.receiver.KnoxRestrictionsReceiver;
import com.samsung.android.app.notes.receiver.OneDriveAccountLinkReceiver;
import com.samsung.android.app.notes.sync.C6751f;
import com.samsung.android.app.notes.sync.RunnableC6663b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.migration.C6798g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6902e;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.model.contractimpl.RequestSyncContractImpl;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostResumeManager;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.EdpManager;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.livesharing.LiveSharingHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.BixbyNoteListInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.ChildDeletableData;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.checkbox.CheckBoxAnimatorController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.UnlockConfirmDialogHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreNoteTask;
import com.samsung.android.support.senl.p148nt.app.settings.common.dialog.GDPRDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;
import com.samsung.android.support.senl.p148nt.app.updater.connector.MarketConnectorFactory;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncErrorCode;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AIFeatureInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import com.samsung.android.support.senl.p148nt.model.securefolder.domain.ImportNoteFromSecureSpaceUseCase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import p001A.AbstractC0000a;
import p026F1.AbstractC0100d;
import p026F1.C0098b;
import p030G1.InterfaceC0107a;
import p042J1.C0145c;
import p044K.C0158a;
import p066P2.RunnableC0201c;
import p079T.AbstractC0299q;
import p079T.C0287e;
import p084U0.AbstractC0311c;
import p084U0.C0312d;
import p192j1.C12936a;
import p207n1.C13540g;
import p207n1.C13541h;
import p244u1.C14477a;
import p249v1.C14499b;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesPresenter extends ObjectMapper {
    private static final String TAG = "NotesPresenter";
    private final SharedPreferences.OnSharedPreferenceChangeListener mSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (NotesConstants.KEY_SORT_BY.equals(str) || NotesConstants.KEY_ORDER_BY.equals(str) || NotesConstants.KEY_PIN_FAVORITES.equals(str)) {
                NotesPresenter.this.mRecyclerViewHelper.getInstance().updateRecyclerViewLayoutMode(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NotesPresenter.this.mAdapterManager.updateDataObserverToCurrentMode();
                    }
                });
                return;
            }
            if ("view_mode".equals(str)) {
                NotesPresenter.this.viewModeChanged(true);
            } else if (NotesConstants.KEY_MDE_FEATURE_ENABLED.equals(str) && NotesUtils.isCoeditFeatureEnabled(NotesPresenter.this.mViewParams.getContext())) {
                NotesPresenter.this.mViewParams.getNotesView().changedGcsDisable();
            }
        }
    };
    private InterfaceC0107a mUiSyncProgressListener = new InterfaceC0107a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter.2
        @Override // p030G1.InterfaceC0107a
        public void onEnded(int i) {
            AbstractC8014b.m7201c(i, "Sync ProgressListener# onEnded errorCode : ", NotesPresenter.TAG);
            if (i == 108) {
                if (NotesPresenter.this.mViewParams.getAbsFragment().isResumed()) {
                    GDPRDialogFragment.newInstance().showAllowingStateLoss(NotesPresenter.this.mViewParams.getAbsFragment().getChildFragmentManager(), GDPRDialogFragment.TAG);
                }
            } else if (i == 126) {
                NotesPresenter.this.mTipCardHelper.getInstance().addSyncFailPSMTipCard();
            }
            EdpManager.getInstance().setUnsupportedEdpDevice(i == 124);
            EdpManager.getInstance().setKeyErrorEdpDevice(i == 125);
            NotesPresenter.this.mTipCardHelper.getInstance().addEdpNotifyTipCard();
        }

        @Override // p030G1.InterfaceC0107a
        public void onProgress(C0098b c0098b) {
            c0098b.getClass();
        }

        @Override // p030G1.InterfaceC0107a
        public void onStarted() {
        }
    };
    private final IConvertTaskCallback openNotesCallback = new IConvertTaskCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter.5
        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
            if (iConvertResult.getDstType() == 9) {
                NotesPresenter notesPresenter = NotesPresenter.this;
                Intent startComposerIntent = notesPresenter.getStartComposerIntent(notesPresenter.mViewParams.getContext(), new Intent(), iConvertResult.getUuid());
                startComposerIntent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
                startComposerIntent.putExtra(ComposerConstants.ARG_USE_VIEW_MODE, false);
                NotesPresenter.this.mViewParams.getContext().startActivity(startComposerIntent);
            }
        }
    };

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C83843 extends AbstractC0311c {
        final /* synthetic */ Context val$context;

        public C83843(Context context) {
            this.val$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFinish$0(int i, Context context) {
            NotesPresenter.this.mDialogHelper.getInstance().dismissSaveToDeviceDialog();
            if (i > 0 && FeatureUtils.isMDEMode(NotesPresenter.this.mViewParams.getModeIndex())) {
                String quantityString = context.getResources().getQuantityString(C8003R.plurals.plural_base_toast_download_shared_notes_success, i, Integer.valueOf(i));
                AbstractC8014b.m7209k("duplicateToDevice# onFinish, isSpaceMode, message : ", quantityString, NotesPresenter.TAG);
                ToastHandler.show(context, quantityString, 1, false);
            }
            NotesPresenter.this.mImportDocumentManager = null;
        }

        @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
        public void onFail(@NonNull String str, @NonNull String str2, int i, @Nullable String str3) {
            MainLogger.m7255e(NotesPresenter.TAG, "duplicateToDevice# onFail, errCode : " + i + SQLKeyword.COMMA + str3);
            NotesPresenter.this.duplicateToDeviceFailed(str3);
        }

        @Override // p084U0.InterfaceC0313e
        public void onFinish(int i, int i2, @NonNull Map<String, Integer> map, final int i4) {
            AbstractC8014b.m7212n(AbstractC0622a.m1173s(i, i2, "duplicateToDevice# onFinish, total : ", ", errorCount : ", ", successCount : "), NotesPresenter.TAG, i4);
            TaskState.INSTANCE.getInstance().setIsRunning("DUPLICATE_NOTES", false);
            FragmentActivity activity = NotesPresenter.this.mViewParams.getAbsFragment().getActivity();
            final Context context = this.val$context;
            ViewModeUtils.runOnUiThread(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6215a.lambda$onFinish$0(i4, context);
                }
            });
        }

        @Override // p084U0.AbstractC0311c, p084U0.InterfaceC0313e
        public void onProgress(int i, int i2) {
            AbstractC8014b.m7200b(i, i2, "duplicateToDevice# onProgress, ", " / ", NotesPresenter.TAG);
        }

        @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
        public void onStart(@NonNull String str, @NonNull String str2) {
            AbstractC8014b.m7209k("duplicateToDevice# onStart, import document uuid : ", str, NotesPresenter.TAG);
        }

        @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
        public void onSuccess(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Pair<String, String> pair) {
            AbstractC8014b.m7209k("duplicateToDevice# onSuccess, import document uuid : ", str2, NotesPresenter.TAG);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C83876 implements WorkerTask.Callback {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ AbsAppCompatActivity val$activityContract;
        final /* synthetic */ MainEntryParam val$mainEntryParam;
        final /* synthetic */ RestoreNoteTask val$restoreNoteTask;

        public C83876(RestoreNoteTask restoreNoteTask, Activity activity, AbsAppCompatActivity absAppCompatActivity, MainEntryParam mainEntryParam) {
            this.val$restoreNoteTask = restoreNoteTask;
            this.val$activity = activity;
            this.val$activityContract = absAppCompatActivity;
            this.val$mainEntryParam = mainEntryParam;
        }

        private static boolean isInvalidate(Activity activity) {
            boolean zIsSyncAvailable = isSyncAvailable();
            boolean z = !zIsSyncAvailable;
            if (!zIsSyncAvailable) {
                RequestToSCloudManager.INSTANCE.getInstance().printDataNetworkLog();
            }
            return z;
        }

        private static boolean isSyncAvailable() {
            if (!RequestToSCloudManager.INSTANCE.getInstance().isDataNetworkAvailable() || !C0158a.m407a().m417k()) {
                return false;
            }
            C14477a.m15065b().f10283a.getClass();
            return C14499b.m15085e() && ((C13540g) C13541h.m14287e().f9588a).m14285a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onEnd$0(Activity activity) {
            ToastHandler.show(activity, C8003R.string.unable_to_open_note, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnd$1(Activity activity, RestoreNoteTask restoreNoteTask, AbsAppCompatActivity absAppCompatActivity, MainEntryParam mainEntryParam) {
            if (CommonUtil.isNotAvailableActivity(activity)) {
                MainLogger.m7258i(NotesPresenter.TAG, "restoreCorruptedNote# activity is destroyed");
                return;
            }
            if (restoreNoteTask.getResult().getMSuccess()) {
                absAppCompatActivity.onNoteSelected(mainEntryParam);
                NotesPresenter.this.mDialogHelper.getInstance().removeCircleProgressDialog();
            } else if (isInvalidate(activity)) {
                activity.runOnUiThread(new RunnableC8505k(activity, 0));
                NotesPresenter.this.mDialogHelper.getInstance().removeCircleProgressDialog();
            } else {
                CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_NOTESLIST_RESTORE_CORRUPT_NOTE);
                NotesPresenter.this.startRestoreOnCloud(mainEntryParam.getUuid());
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onEnd(@NonNull WorkerTask.Result result) {
            Handler handler = new Handler();
            final Activity activity = this.val$activity;
            final RestoreNoteTask restoreNoteTask = this.val$restoreNoteTask;
            final AbsAppCompatActivity absAppCompatActivity = this.val$activityContract;
            final MainEntryParam mainEntryParam = this.val$mainEntryParam;
            handler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6218a.lambda$onEnd$1(activity, restoreNoteTask, absAppCompatActivity, mainEntryParam);
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onStart(@NonNull WorkerTask<?> workerTask) {
            this.val$restoreNoteTask.getResult().setSuccess(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getStartComposerIntent(Context context, Intent intent, String str) {
        IntentUtil.ComposerIntentBuilder docUuid = new IntentUtil.ComposerIntentBuilder(intent, ComposerConstants.ACTIVITY_FLAG_CALLEE).setDocUuid(str);
        String action = intent.getAction();
        String str2 = ComposerConstants.ACTION_SIMPLE_MODE;
        if (!ComposerConstants.ACTION_SIMPLE_MODE.equals(action)) {
            str2 = "android.intent.action.VIEW";
        }
        return docUuid.setAction(str2).setDefaultFlags().addFlags(1).setComposerComponent(context).build();
    }

    private boolean isDexMode(@NonNull Activity activity) {
        return DesktopModeCompat.INSTANCE.getInstance().isDexMode(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkLiveSharingStatus$1(int i) {
        this.mTipCardHelper.getInstance().setMeetTipCard(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$duplicateToDevice$4(List list) {
        if (list.isEmpty()) {
            duplicateToDeviceFailed("duplicateToDeviceFailed empty");
        } else {
            duplicateToDevice(true, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$duplicateToDeviceFailed$5(Context context, String str) {
        this.mDialogHelper.getInstance().dismissSaveToDeviceDialog();
        if (context != null) {
            ToastHandler.show(context, FeatureUtils.isMDEMode(this.mViewParams.getModeIndex()) ? context.getResources().getString(C11397R.string.base_toast_download_shared_notes_fail) : context.getResources().getString(C8003R.string.duplicate_note_fail_toast), 0, false);
        }
        AbstractC0000a.m25v("duplicateToDevice# onError, message : ", str, TAG);
        this.mImportDocumentManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onResume$0() {
        MainLogger.m7254d(TAG, "onPostResume# run");
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mViewParams.getNotesView().getMode().onPostResume();
        if (ModelFeature.getFeature().isFoldableModel()) {
            setLastDisplay(DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(applicationContext));
        }
        new ImportNoteFromSecureSpaceUseCase(applicationContext).executeOnExecutor(DataMapper.SINGLE_THREAD_EXECUTOR, new Void[0]);
        Context context = C6751f.m4890a(applicationContext).f4139a;
        if (context == null) {
            Debugger.m8615i("GeneralManager", "onResumeAction() : mContext == null");
        } else {
            StringBuilder sb = new StringBuilder("printGeneralInfo() : isSyncing = ");
            sb.append(!C14477a.m15065b().f10283a.m5099h());
            if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                sb.append(", Not logged in");
            }
            if (!C0145c.m334s(context)) {
                sb.append(", Not connected");
            }
            if (C0145c.m299G(context) && !C0145c.m298F(context)) {
                sb.append(", Not WiFi connected");
            }
            C14477a.m15065b().getClass();
            if (C14477a.m15066c() == 126) {
                sb.append(", Fail to download notes in PSM");
            }
            Map<String, ?> all = SharedPreferencesCompat.getInstance("SyncNotDownSyncedNotes").getAll();
            if (all != null && !all.isEmpty()) {
                sb.append(", Not down-synced notes = ");
                sb.append(all.size());
            }
            if (DeviceUtils.isSyncEnabledInDoMode(context)) {
                sb.append(", isSyncEnabledInDoMode is true");
            }
            if (AbstractC0100d.m240b(context) == 0 && AbstractC0100d.m239a(context) == 0) {
                sb.append(", last syncTimeStamp = ");
                sb.append(AbstractC14517a.m15161u());
                Debugger.m8615i("GeneralManager", sb.toString());
            } else {
                if (AbstractC0100d.m240b(context) != 0) {
                    sb.append(", internalLastSyncError = ");
                    sb.append(SyncErrorCode.getErrorCodesString(AbstractC0100d.m240b(context)));
                }
                if (AbstractC0100d.m239a(context) != 0) {
                    sb.append(", externalLastSyncError = ");
                    sb.append(SyncErrorCode.getErrorCodesString(AbstractC0100d.m239a(context)));
                }
                Debugger.m8609e("GeneralManager", sb.toString());
            }
            if (C0145c.m338w(context)) {
                PostLaunchManager.getInstance().executeBaseLogic(301);
                C14477a.m15065b().m15077m(context);
            } else {
                C6902e c6902eM5116a = C6902e.m5116a();
                c6902eM5116a.getClass();
                C12936a.m13839c().getClass();
                boolean zM13842g = C12936a.m13842g();
                if (c6902eM5116a.f4471a) {
                    if (!zM13842g) {
                        c6902eM5116a.f4471a = false;
                    }
                } else if (zM13842g) {
                    ((C13540g) C13541h.m14287e().f9588a).m14285a();
                    if (C0158a.m407a().m413c()) {
                        Debugger.m8615i("SyncPermissionManager", "request sync now after all permissions are granted!");
                        C14477a.m15065b().m15071g(null);
                    }
                    c6902eM5116a.f4471a = true;
                }
            }
            if (System.currentTimeMillis() - C0145c.m328m(-1L, "pref_sync_logging", "pref_sync_weekly_logging_time") > 604800000) {
                C0145c.m308P(System.currentTimeMillis(), "pref_sync_logging", "pref_sync_weekly_logging_time");
                new SenlThreadFactory("reportSyncSALoggingEveryWeek").newThread(new RunnableC6663b()).start();
            }
        }
        if (PostLaunchManager.getInstance().hasBaseLogic(2)) {
            PostLaunchManager.getInstance().executeBaseLogic(2);
        }
        MarketConnectorFactory.createMarketConnector().initLastCheckedMarketVersionCode();
        if (SyncState.isAppUpdateNeeded(applicationContext)) {
            this.mDialogHelper.getInstance().showAppUpdateDialog(AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_SYNC);
        }
        this.mMicrosoftHelper.getInstance().checkMeridianDialog(applicationContext);
        this.mSOMRecognizeHelper.getInstance().onPostResume();
        C6798g.m4962h().m4969n(null);
        AIFeatureInfoManager.checkAIFeatureInfo();
        if (EdpManager.getInstance().hasFtuNotification()) {
            EdpManager.getInstance().notifyEdpFtu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$playConvertFinishedToast$6(Activity activity) {
        ToastHandler.show(activity, activity.getResources().getString(C8003R.string.base_string_convert_finish), 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestInAppReview$7(Task task) {
        if (task.isSuccessful()) {
            MainLogger.m7258i(TAG, "requestInAppReview# onComplete success");
        } else {
            MainLogger.m7258i(TAG, "requestInAppReview# onComplete fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestInAppReview$8(WeakReference weakReference, ReviewManager reviewManager, Task task) {
        if (!task.isSuccessful()) {
            MainLogger.m7258i(TAG, "requestInAppReview# There was some error while accessing review info, isComplete : " + task.isComplete());
            return;
        }
        ReviewInfo reviewInfo = (ReviewInfo) task.getResult();
        Activity activity = (Activity) weakReference.get();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7258i(TAG, "requestInAppReview# requestReviewFlow successful, isNotAvailableActivity return");
        } else {
            MainLogger.m7258i(TAG, "requestInAppReview# requestReviewFlow successful, launchReviewFlow");
            reviewManager.launchReviewFlow(activity, reviewInfo).addOnCompleteListener(new C8416h(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showExportOptionPopup$2(boolean z, Map map) {
        int i;
        Intent intent = new Intent();
        if (z) {
            intent.putParcelableArrayListExtra(NotesConstants.KEY_SAVE_LIST, new ArrayList<>(map.values()));
            i = 103;
        } else {
            intent.putParcelableArrayListExtra(NotesConstants.KEY_SHARE_LIST, new ArrayList<>(map.values()));
            i = 102;
        }
        this.mLockHelper.getInstance().verifyLockedNote(i, intent, (String[]) map.keySet().toArray(new String[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showExportOptionPopup$3(Map map, boolean z) {
        this.mExportHelper.getInstance().showExportShareTypeMenu(new ArrayList<>(map.values()), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playConvertFinishedToast() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.runOnUiThread(new RunnableC8505k(activity, 1));
    }

    private void registerWindowInsetManager() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity) || isDexMode(activity)) {
            return;
        }
        View container = this.mViewParams.getNotesView().getContainer();
        WindowInsetsManager.getInstance().registerAnimationCallback(container, this.mAnimationCallback);
        WindowInsetsManager.getInstance().registerApplyListener(container, this.mApplyInsetListener);
        this.mViewParams.getNotesView().applyWindowInsets();
    }

    private void showDeleteItemsDialog() {
        int i;
        int i2;
        int i4;
        int i5;
        boolean z;
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mViewParams.getContext(), this.mViewParams.getAbsFragment().getActivity().getSupportFragmentManager());
            return;
        }
        int checkedNotesCount = this.mNotesModel.getCheckedNotesCount();
        int checkedFoldersCount = this.mNotesModel.getCheckedFoldersCount();
        int lockedNotesCount = this.mNotesModel.getCheckNotesCountInfo().getLockedNotesCount();
        ChildDeletableData childDeletableData = new ChildDeletableData();
        Iterator<String> it = this.mNotesModel.getCheckedFoldersUUID().iterator();
        while (it.hasNext()) {
            childDeletableData.addAll(this.mDocumentMap.getChildDeletableList(it.next()));
        }
        int deletableWithVerifyCount = childDeletableData.getDeletableWithVerifyCount() + lockedNotesCount;
        boolean z2 = checkedFoldersCount + checkedNotesCount != childDeletableData.getTotalItems();
        if (deletableWithVerifyCount <= 0) {
            if (checkedFoldersCount == 0) {
                i2 = C8003R.plurals.plurals_move_to_trash_n_note_dialog_msg;
            } else if (checkedNotesCount == 0) {
                i2 = z2 ? C8003R.plurals.plurals_move_to_trash_n_folder_has_child_dialog_msg : C8003R.plurals.plurals_move_to_trash_n_folder_dialog_msg;
            } else {
                i = (checkedFoldersCount == 1 && checkedNotesCount == 1) ? z2 ? C8003R.string.move_to_trash_one_folder_has_child_and_one_note_q : C8003R.string.move_to_trash_one_folder_and_one_note_q : checkedFoldersCount == 1 ? z2 ? C8003R.string.move_to_trash_one_folder_has_child_and_n_note_q : C8003R.string.move_to_trash_one_folder_and_n_note_q : checkedNotesCount == 1 ? z2 ? C8003R.string.move_to_trash_n_folder_has_child_and_one_note_q : C8003R.string.move_to_trash_n_folder_and_one_note_q : z2 ? C8003R.string.move_to_trash_n_folder_has_child_and_n_note_q : C8003R.string.move_to_trash_n_folder_and_n_note_q;
            }
            i4 = checkedNotesCount;
            i5 = i2;
            z = true;
            AbstractC8014b.m7200b(i4, checkedFoldersCount, "showDeleteItemsDialog# deleteNotesCount : ", "# deleteFolderCount : ", TAG);
            this.mDialogHelper.getInstance().showDeleteDialog(0, i5, C8003R.string.move_to_trash_btn, i4, checkedFoldersCount, deletableWithVerifyCount, z, this.mViewParams.getModeIndex(), false);
        }
        checkedNotesCount += childDeletableData.getTotalNotes();
        i = deletableWithVerifyCount == 1 ? C8003R.plurals.plurals_move_to_trash_n_note_including_1_locked_note_dialog_msg : C8003R.string.notes_deleted_include_locked_notes;
        i4 = checkedNotesCount;
        z = false;
        i5 = i;
        AbstractC8014b.m7200b(i4, checkedFoldersCount, "showDeleteItemsDialog# deleteNotesCount : ", "# deleteFolderCount : ", TAG);
        this.mDialogHelper.getInstance().showDeleteDialog(0, i5, C8003R.string.move_to_trash_btn, i4, checkedFoldersCount, deletableWithVerifyCount, z, this.mViewParams.getModeIndex(), false);
    }

    private void showPermanentlyDeleteItemsDialog(boolean z) {
        if (this.mDocumentMap.getCommonDisplayListSize(new String[0]) <= 0) {
            return;
        }
        int checkedNotesCount = this.mNotesModel.getCheckedNotesCount();
        int checkedFoldersCount = this.mNotesModel.getCheckedFoldersCount();
        int i = C8003R.plurals.plurals_permanently_delete_dialog_msg;
        if (!DeviceUtils.isSupportedSync(C0158a.m407a().f492a) && !DeviceUtils.isPowerManageMode(this.mViewParams.getContext())) {
            i = C8003R.plurals.plurals_permanently_delete_no_cloud_dialog_msg;
        }
        int i2 = i;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(checkedNotesCount, checkedFoldersCount, "showPermanentlyDeleteItemsDialog# deleteNotesCount : ", ", deleteFolderCount : ", ", isEmptyAction: ");
        sbM1173s.append(z);
        MainLogger.m7257f(TAG, sbM1173s.toString());
        int lockedNotesCount = this.mNotesModel.getCheckNotesCountInfo().getLockedNotesCount();
        ChildDeletableData childDeletableData = new ChildDeletableData();
        Iterator<String> it = this.mNotesModel.getCheckedFoldersUUID().iterator();
        while (it.hasNext()) {
            childDeletableData.addAll(this.mDocumentMap.getChildDeletableList(it.next()));
        }
        this.mDialogHelper.getInstance().showDeleteDialog(0, i2, C8003R.string.action_delete, checkedNotesCount, checkedFoldersCount, childDeletableData.getDeletableWithVerifyCount() + lockedNotesCount, true, this.mViewParams.getModeIndex(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRestoreOnCloud(String str) {
        Context context = this.mViewParams.getContext();
        if (!C0145c.m299G(context) || C0145c.m298F(context)) {
            this.mDialogHelper.getInstance().showRestoreConfirmDialog(str);
        } else {
            this.mDialogHelper.getInstance().showRestoreCheckMobileDataDialog(str);
        }
    }

    private void unRegisterNoteListListener() {
        AdapterManager adapterManager = this.mAdapterManager;
        if (adapterManager != null) {
            adapterManager.release();
        }
        LiveSharingHelper liveSharingHelper = this.mLiveSharingHelper;
        if (liveSharingHelper != null) {
            liveSharingHelper.unregisterLiveSharing();
        }
        if (this.mTaskStatusListener != null) {
            ApplicationManager.getInstance().getAsyncTaskManager().unregisterTaskStatusListener(this.mViewParams.getAbsFragment().getActivity().hashCode(), this.mTaskStatusListener);
            this.mTaskStatusListener = null;
        }
        if (this.mWorkerTaskManagerListener != null) {
            WorkerTaskManager.getInstance().unregisterListener(this.mViewParams.getAbsFragment().getActivity().hashCode());
            this.mWorkerTaskManagerListener = null;
        }
        C6798g c6798gM4962h = C6798g.m4962h();
        c6798gM4962h.getClass();
        AbstractC0299q.m643n(C6798g.f4220k, "setProgressListener listener null");
        c6798gM4962h.f4223b = null;
        this.mMigrationListener = null;
        if (this.mUiSyncProgressListener != null) {
            C14477a c14477aM15065b = C14477a.m15065b();
            InterfaceC0107a interfaceC0107a = this.mUiSyncProgressListener;
            c14477aM15065b.f10283a.getClass();
            ArrayList arrayList = C14499b.f10312f;
            synchronized (arrayList) {
                arrayList.remove(interfaceC0107a);
                Debugger.m8607d("SyncLogic", "Removed Ui Sync progress listener - size : " + arrayList.size());
            }
            this.mUiSyncProgressListener = null;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            if (this.mSystemTimeFormatObserver != null) {
                applicationContext.getContentResolver().unregisterContentObserver(this.mSystemTimeFormatObserver);
                this.mSystemTimeFormatObserver = null;
            }
            try {
                BroadcastReceiver broadcastReceiver = this.mUpdateBroadcastReceiver;
                if (broadcastReceiver != null) {
                    applicationContext.unregisterReceiver(broadcastReceiver);
                    LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(this.mUpdateBroadcastReceiver);
                    this.mUpdateBroadcastReceiver = null;
                }
                KnoxRestrictionsReceiver knoxRestrictionsReceiver = this.mKnoxRestrictionsReceiver;
                if (knoxRestrictionsReceiver != null) {
                    applicationContext.unregisterReceiver(knoxRestrictionsReceiver);
                    this.mKnoxRestrictionsReceiver = null;
                }
            } catch (IllegalArgumentException e) {
                MainLogger.m7255e(TAG, e.getMessage());
            }
            try {
                BroadcastReceiver broadcastReceiver2 = this.mOneDriveLinkReceiver;
                if (broadcastReceiver2 != null) {
                    OneDriveAccountLinkReceiver.unregisterReceiver(applicationContext, broadcastReceiver2);
                    this.mOneDriveLinkReceiver = null;
                }
            } catch (Exception e2) {
                MainLogger.m7255e(TAG, "unRegisterNoteListListener# OneDriveAccountLinkReceiver error " + e2);
            }
        }
        this.mRecyclerViewHelper.getInstance().unregisterListener();
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).unregisterOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
        SharedPreferencesCompat.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mSettingSharedPreferenceListener);
        BadgeHelper.unregisterSOMBadgeChangeListener(this.mSOMSharedPreferenceChangeListener);
        if (ModelFeature.getFeature().isFoldableModel()) {
            SettingsSearchIndexingManager.unregisterSPenSettingStateChangeListener(this.mSPenSettingStateChangeListener);
            this.mSPenSettingStateChangeListener = null;
        }
        unregisterWindowInsetManager();
    }

    private void unregisterWindowInsetManager() {
        View container = this.mViewParams.getNotesView().getContainer();
        WindowInsetsManager.getInstance().unregisterAnimationCallback(container);
        WindowInsetsManager.getInstance().unregisterApplyListener(container);
    }

    private void verifyOldNote(List<String> list, boolean z) {
        MainLogger.m7258i(TAG, "verifyOldNote# locked sdoc");
        Intent intent = new Intent();
        intent.putExtra(NotesConstants.KEY_IS_SKIP_CONVERTED, z);
        this.mLockHelper.getInstance().verifyLockedNoteForConvert(111, intent, (String[]) list.toArray(new String[0]));
    }

    public void checkLiveSharingStatus() {
        if (FeatureUtils.isPickMode(this.mViewParams.getModeIndex())) {
            return;
        }
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (companion.getInstance().getRequestSyncContract() == null) {
            MainLogger.m7254d(TAG, "checkLiveSharingStatus#setRequestSyncContract");
            companion.getInstance().setRequestSyncContract(new RequestSyncContractImpl());
        }
        if (this.mLiveSharingHelper == null) {
            this.mLiveSharingHelper = new LiveSharingHelper(this.mViewParams.getAbsFragment().getActivity(), new C8413e(this));
        }
        this.mLiveSharingHelper.registerLiveSharing();
    }

    public void duplicateToDevice() {
        if (FeatureUtils.isCoeditMode(this.mViewParams.getModeIndex()) || FeatureUtils.isCoeditSpaceMode(this.mViewParams.getModeIndex())) {
            CoeditNoteUpDownloader.getInstance().requestExternalAccessibleNotes(this.mViewParams.getContext(), getCheckedNotesUUID(), new C8413e(this));
        } else {
            duplicateToDevice(FeatureUtils.isGcsSpaceMode(this.mViewParams.getModeIndex()), getCheckedNotesUUID());
        }
    }

    public void duplicateToDeviceFailed(String str) {
        ViewModeUtils.runOnUiThread(this.mViewParams.getAbsFragment().getActivity(), new RunnableC0201c(this, 27, this.mViewParams.getContext(), str));
    }

    @Nullable
    public BixbyNoteListInfo getNoteListInfo() {
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        NotesPenRecyclerView notesPenRecyclerView = this.mRecyclerView;
        if (notesPenRecyclerView == null || notesPenRecyclerView.getLayoutManager() == null) {
            return null;
        }
        int layoutMode = this.mRecyclerView.getLayoutMode();
        if (NotesUtils.isGridLayout(layoutMode)) {
            iFindFirstVisibleItemPosition = ((GridLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            iFindLastVisibleItemPosition = ((GridLayoutManager) this.mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        } else if (NotesUtils.isStaggeredGridLayout(layoutMode)) {
            NotesPenRecyclerView notesPenRecyclerView2 = this.mRecyclerView;
            iFindFirstVisibleItemPosition = notesPenRecyclerView2.getFirstVisibleItem(((StaggeredGridLayoutManager) notesPenRecyclerView2.getLayoutManager()).findFirstVisibleItemPositions(null));
            NotesPenRecyclerView notesPenRecyclerView3 = this.mRecyclerView;
            iFindLastVisibleItemPosition = notesPenRecyclerView3.getLastVisibleItem(((StaggeredGridLayoutManager) notesPenRecyclerView3.getLayoutManager()).findLastVisibleItemPositions(null));
        } else {
            iFindFirstVisibleItemPosition = ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            iFindLastVisibleItemPosition = ((GridLayoutManager) this.mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        }
        BixbyNoteListInfo bixbyNoteListInfo = new BixbyNoteListInfo();
        NotesFolder folderData = this.mDocumentMap.getFolderData(this.mStateInfo.getFolderUuid());
        bixbyNoteListInfo.setFolderUuid(this.mStateInfo.getFolderUuid());
        if (folderData == null) {
            return null;
        }
        String displayName = folderData.getDisplayName();
        Resources resources = this.mRecyclerView.getResources();
        int viewType = folderData.getViewType();
        if (viewType == 1) {
            displayName = resources.getString(C8003R.string.string_screen_off_memo);
        } else if (viewType == 2) {
            displayName = resources.getString(C8003R.string.string_math_notes);
        } else if (viewType == 3) {
            displayName = resources.getString(C8003R.string.settings_my_folders);
        } else if (viewType != 5) {
            switch (viewType) {
                case 1001:
                    displayName = resources.getString(C8003R.string.action_settings);
                    break;
                case 1002:
                    displayName = resources.getString(C8003R.string.all_notes);
                    break;
                case 1003:
                    displayName = resources.getString(C8003R.string.upgradable_notes);
                    break;
                case 1004:
                    displayName = resources.getString(C8003R.string.favorite_notes);
                    break;
                case 1005:
                    displayName = resources.getString(C8003R.string.locked_notes);
                    break;
                case 1006:
                    displayName = resources.getString(C8003R.string.folder_recently_imported);
                    break;
                case 1007:
                    displayName = resources.getString(C8003R.string.shared_notebooks);
                    break;
                case 1008:
                    displayName = resources.getString(C8003R.string.co_edit_title);
                    break;
                case 1009:
                    displayName = resources.getString(C8003R.string.recycle_bin_title);
                    break;
            }
        } else {
            displayName = resources.getString(C8003R.string.manage_folder);
        }
        bixbyNoteListInfo.setFolderDisplayName(displayName);
        if (iFindFirstVisibleItemPosition >= 0 && iFindLastVisibleItemPosition >= 0) {
            while (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                if (commonHolder != null && commonHolder.getMHolderType() == 2048) {
                    bixbyNoteListInfo.addEntry(this.mDocumentMap.getNoteData(((NotesHolder) commonHolder).getNotesHolderInfo().getUuid()));
                }
                iFindFirstVisibleItemPosition++;
            }
        }
        return bixbyNoteListInfo;
    }

    public void hideSearchFilter(Runnable runnable) {
        this.mAdapterManager.hideSearchFilter(runnable);
    }

    public boolean importNoteToSpace() {
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            MainLogger.m7258i(TAG, "importNoteToSpace# fail - network is not connected");
            ToastHandler.show(this.mViewParams.getAbsFragment().getActivity(), this.mViewParams.getContext().getString(C8003R.string.co_edit_connect_to_wifi_or_allow_mobile_data), 0, false);
            return true;
        }
        boolean z = this.mStateInfo.getCaller() == 6;
        AbstractC6670b.m4739D("importNoteToSpace# isOldSharedNotebook: ", TAG, z);
        if (z) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK_EDIT, NotesSAConstants.EVENT_PICK_EDIT_DONE);
        }
        return this.mCoeditHelper.getInstance().importNoteToSpace(this.mViewParams.getContext(), this.mStateInfo.getSpaceId(), z);
    }

    public void initPresenter(@NonNull ViewParams viewParams) {
        MainLogger.m7258i(TAG, "initPresenter");
        this.mRecyclerView = viewParams.getNotesRecyclerView();
        this.mDialogCreator = viewParams.getDialogCreator();
        this.mViewParams = viewParams;
        this.mCheckBoxAnimatorController = new CheckBoxAnimatorController(this.mRecyclerViewHelper, viewParams, this.mNotesModel, this.mDocumentMap);
        this.mAdapterManager = new AdapterManager(this.mViewParams, this.mDocumentMap, this.mNotesModel, this.mStateInfo, this.mTipCardHelper, this.mDialogHelper, this.mDragAndDropHelper, this.mRecyclerViewHelper, this.mSearchHelper, this.mSOMRecognizeHelper, this.mLockHelper);
        C14477a c14477aM15065b = C14477a.m15065b();
        InterfaceC0107a interfaceC0107a = this.mUiSyncProgressListener;
        c14477aM15065b.f10283a.getClass();
        ArrayList arrayList = C14499b.f10312f;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        ArrayList arrayList2 = C14499b.f10312f;
                        arrayList2.add(interfaceC0107a);
                        Debugger.m8607d("SyncLogic", "Added Ui Sync progress listener - size : " + arrayList2.size());
                        break;
                    }
                    if (((InterfaceC0107a) it.next()).equals(interfaceC0107a)) {
                    }
                }
            } finally {
            }
        }
        int iHashCode = this.mViewParams.getAbsFragment().getActivity().hashCode();
        ApplicationManager.getInstance().getAsyncTaskManager().registerTaskStatusListener(iHashCode, this.mTaskStatusListener);
        WorkerTaskManager.getInstance().registerListener(iHashCode, this.mWorkerTaskManagerListener);
        this.mCoeditHelper.getInstance().registerInviteReceiver();
    }

    public void insertRecentSearchKeyword(String str) {
        this.mSearchHelper.getInstance().insertRecentSearchKeyword(str);
    }

    public void onDataChangedByFolder(boolean z, boolean z2) {
        int modeIndex = this.mViewParams.getModeIndex();
        if (FeatureUtils.isSearchMode(modeIndex)) {
            this.mViewParams.getNotesView().getMode().onDataChangedByMode(new ArrayList());
            return;
        }
        boolean zInitCommonDisplayList = this.mDocumentMap.initCommonDisplayList();
        StringBuilder sbM2230u = AbstractC2821a.m2230u("onDataChangedByFolder# updateScreen : ", ", updateList : ", ", isDataChanged : ", z, z2);
        sbM2230u.append(zInitCommonDisplayList);
        MainLogger.m7258i(TAG, sbM2230u.toString());
        if (z || z2 || zInitCommonDisplayList) {
            if (modeIndex == 25 || modeIndex == 28) {
                this.mNotesModel.setCheckedDimmedNotes(this.mViewParams.getAbsFragment().getArguments(), this.mStateInfo.getCaller());
            }
            boolean zCanShowSOMRecognizedCard = FeatureUtils.canShowSOMRecognizedCard(modeIndex, this.mStateInfo.getFolderUuid());
            if (FeatureUtils.isPickEditMode(modeIndex) || FeatureUtils.isCoeditMode(modeIndex)) {
                this.mAdapterManager.notifyDataSetChangedWithViewPageChange("onDataChangedByFolder");
            } else if (z2 || zInitCommonDisplayList || zCanShowSOMRecognizedCard) {
                this.mAdapterManager.notifyDataSetChangedWithViewPageChange("onDataChangedByFolder");
                this.mSOMRecognizeHelper.getInstance().onFolderChanged(this.mStateInfo.getFolderBackHistory().empty() ? "" : this.mStateInfo.getFolderBackHistory().peek(), this.mStateInfo.getFolderUuid());
            }
            if (!zCanShowSOMRecognizedCard) {
                this.mSOMRecognizeHelper.getInstance().removeSOMRecognizedCard("onDataChangedByFolder");
            }
            if (FeatureUtils.isEditMode(modeIndex)) {
                this.mViewParams.getNotesView().onDataChanged(this.mDocumentMap.getCommonDisplayListSize(FolderUtils.sStaticFolders), "onDataChangedByFolder");
            } else {
                this.mViewParams.getNotesView().onDataChanged(this.mDocumentMap.getCommonDisplayListSize(new String[0]), "onDataChangedByFolder");
            }
        }
    }

    public void onDestroy(int i) {
        AbstractC8014b.m7201c(i, "onDestroy# hashCode : ", TAG);
        unRegisterNoteListListener();
        if (this.mTipCardHelper.isValid()) {
            this.mTipCardHelper.getInstance().release();
            this.mTipCardHelper.release();
        }
        if (this.mLockHelper.isValid()) {
            this.mLockHelper.release();
        }
        if (this.mDialogHelper.isValid()) {
            this.mDialogHelper.release();
        }
        if (this.mMicrosoftHelper.isValid()) {
            this.mMicrosoftHelper.release();
        }
        if (this.mRecyclerViewHelper.isValid()) {
            this.mRecyclerViewHelper.release();
        }
        if (this.mPdfImportHelper.isValid()) {
            this.mPdfImportHelper.release();
        }
        if (this.mSearchHelper.isValid()) {
            this.mSearchHelper.release();
        }
        if (this.mCoeditHelper.isValid()) {
            this.mCoeditHelper.getInstance().release();
            this.mCoeditHelper.release();
        }
        if (this.mDragAndDropHelper.isValid()) {
            this.mDragAndDropHelper.getInstance().onDestroy();
            this.mDragAndDropHelper.release();
        }
        if (this.mCoverHelper.isValid()) {
            this.mCoverHelper.release();
        }
        if (this.mDetailsMenuHelper.isValid()) {
            this.mDetailsMenuHelper.release();
        }
        if (this.mSwipeRefreshHelper.isValid()) {
            this.mSwipeRefreshHelper.release();
        }
        if (this.mBackPressedHelper.isValid()) {
            this.mBackPressedHelper.getInstance().onDestroy();
            this.mBackPressedHelper.release();
        }
    }

    public void onFolderSelected(String str, boolean z) {
        MainLogger.m7258i(TAG, "onFolderSelected# folderUuid : " + str + ", needDataChange : " + z);
        this.mDocumentMap.setFolderUuid(str);
        this.mStateInfo.setShowSubFolderWithAnimation(true);
        NotesUtils.setLastSelectedFolder(str);
        if (FeatureUtils.canDeleteFolderPathLayout(this.mViewParams.getModeIndex(), str) || FolderConstants.MyFolders.UUID.equals(str)) {
            this.mViewParams.getNotesView().setIsScrollToTop(true, 0);
        } else {
            this.mViewParams.getNotesView().scrollToTopOnFolderSelected();
        }
        if (z) {
            setLastOpenedSDocXUuid(null);
            onDataChangedByFolder(true, false);
        }
    }

    public void onHashTagSelected(Set<String> set) {
        if (set == null) {
            MainLogger.m7255e(TAG, "onHashTagSelected# selectedTags is null");
            return;
        }
        MainLogger.m7254d(TAG, "onHashTagSelected# selectedTags : " + set);
        this.mSearchHelper.getInstance().onHashTagSelected(set);
    }

    public void onPostLaunch() {
        releaseInflatedView();
        registerNoteListListener();
        checkLiveSharingStatus();
        getSOMRecognizeHelper().onDataChanged("onPostLaunch");
    }

    public void onResume() {
        Log.i(Constants.VERIFICATION_TAG, "Executed");
        PostResumeManager.getInstance().addLogic(this.mViewParams.getAbsFragment().getPostResumeToken(), 2, new RunnableC8412d(this, 3));
    }

    public void onScrolled(int i) {
    }

    public void registerNoteListListener() {
        MainLogger.m7258i(TAG, "registerNoteListListener#");
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            if (this.mSystemTimeFormatObserver != null) {
                applicationContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("time_12_24"), false, this.mSystemTimeFormatObserver);
            }
            BroadcastReceiver broadcastReceiver = this.mUpdateBroadcastReceiver;
            if (broadcastReceiver != null) {
                applicationContext.registerReceiver(broadcastReceiver, new IntentFilter(BaseWidgetConstant.TIME_SET_CHANGED));
                LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this.mUpdateBroadcastReceiver, new IntentFilter("com.samsung.android.app.notes.memolist.ACTION_FORCE_UPDATE"));
            }
            KnoxRestrictionsReceiver knoxRestrictionsReceiver = this.mKnoxRestrictionsReceiver;
            if (knoxRestrictionsReceiver != null) {
                applicationContext.registerReceiver(knoxRestrictionsReceiver, new IntentFilter());
            }
        }
        this.mRecyclerViewHelper.getInstance().registerListener();
        try {
            this.mOneDriveLinkReceiver = OneDriveAccountLinkReceiver.registerReceiver(applicationContext);
        } catch (Exception e) {
            MainLogger.m7255e(TAG, "registerNoteListListener# OneDriveAccountLinkReceiver error " + e);
        }
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).registerOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
        SharedPreferencesCompat.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mSettingSharedPreferenceListener);
        BadgeHelper.registerSOMBadgeChangeListener(this.mSOMSharedPreferenceChangeListener);
        if (ModelFeature.getFeature().isFoldableModel()) {
            SettingsSearchIndexingManager.requestIndexing();
            C8415g c8415g = new C8415g();
            this.mSPenSettingStateChangeListener = c8415g;
            SettingsSearchIndexingManager.registerSPenSettingStateChangeListener(c8415g);
        }
        registerWindowInsetManager();
    }

    public void requestInAppReview() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
        int i = sharedPreferencesCompat.getInt(NotesConstants.KEY_REVIEW_REQUEST_COUNT, 0);
        long j = sharedPreferencesCompat.getLong("review_request_time_stamp", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        MainLogger.m7258i(TAG, "requestInAppReview# count : " + i + ", timeStamp : " + j);
        if (j + 1209600000 > jCurrentTimeMillis || 15 > i) {
            MainLogger.m7258i(TAG, "requestInAppReview# not enough conditions");
            return;
        }
        sharedPreferencesCompat.putInt(NotesConstants.KEY_REVIEW_REQUEST_COUNT, 0);
        sharedPreferencesCompat.putLong("review_request_time_stamp", jCurrentTimeMillis);
        WeakReference weakReference = new WeakReference(this.mViewParams.getAbsFragment().getActivity());
        ReviewManager reviewManagerCreate = ReviewManagerFactory.create((Context) weakReference.get());
        reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new C0287e(weakReference, reviewManagerCreate, 10));
    }

    public void restoreCorruptedNote(Activity activity, AbsAppCompatActivity absAppCompatActivity, final MainEntryParam mainEntryParam) {
        boolean z = true;
        this.mStateInfo.setCanRestoreNote(true);
        final RestoreNoteTask restoreNoteTask = new RestoreNoteTask(mainEntryParam.getFilePath());
        restoreNoteTask.setCallback(new C83876(restoreNoteTask, activity, absAppCompatActivity, mainEntryParam));
        if (CommonUtil.isAvailableActivity(activity)) {
            this.mDialogHelper.getInstance().showCircleProgressDialogWithText(new OnBackPressedCallback(z) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter.7
                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    MainLogger.m7254d(NotesPresenter.TAG, "restoreCorruptedNote# CircleProgress Back Key pressed");
                    NotesPresenter.this.mDialogHelper.getInstance().removeCircleProgressDialog();
                    restoreNoteTask.cancel();
                    C14477a c14477aM15065b = C14477a.m15065b();
                    String uuid = mainEntryParam.getUuid();
                    c14477aM15065b.getClass();
                    Debugger.m8615i("SyncManager", "removeSyncDownImmediately() : " + uuid);
                    ((HashMap) C6903f.m5119c().f4476d).remove(uuid);
                    NotesPresenter.this.mStateInfo.setCanRestoreNote(false);
                }
            }, activity.getString(C8003R.string.restore_corrupt_server_restoring_note));
        }
        restoreNoteTask.run(Boolean.TRUE);
    }

    public void setCheck(String str, boolean z, boolean z2) {
        MainLogger.m7258i(TAG, "setCheck# uuid: " + str + " isChecked: " + z);
        CommonHolderInfo commonHolderInfoFindCommonHolderInfo = this.mRecyclerViewHelper.getInstance().findCommonHolderInfo(this.mRecyclerViewHelper.getInstance().findCommonHolder(str), str);
        updateCheckedData(commonHolderInfoFindCommonHolderInfo, z);
        this.mCheckBoxAnimatorController.setCheck(commonHolderInfoFindCommonHolderInfo, z, z2);
        this.mRecyclerView.setLastClickedUuid(str);
        this.mDragAndDropHelper.getInstance().updateDragShadow(this.mNotesModel.getCheckedDataCount());
    }

    public void shareOldNotes() {
        if (!StorageUtils.isAvailableMinimumMemory()) {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mViewParams.getAbsFragment().getActivity(), this.mViewParams.getAbsFragment().getChildFragmentManager());
            return;
        }
        ArrayList<CheckedNoteInfo> sharableCheckedOldNotes = this.mNotesModel.getSharableCheckedOldNotes();
        if (sharableCheckedOldNotes.isEmpty()) {
            return;
        }
        executeShareTask(sharableCheckedOldNotes, 6);
    }

    public void showDeleteDialog() {
        showDeleteDialog(false);
    }

    public void showExportOptionPopup(boolean z) {
        if (!StorageUtils.isAvailableMinimumMemory()) {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mViewParams.getAbsFragment().getActivity(), this.mViewParams.getAbsFragment().getChildFragmentManager());
            return;
        }
        Context context = this.mViewParams.getContext();
        if (z && !ContentPickerUtils.canAddPdfFileMenu(context)) {
            MainLogger.m7255e(TAG, "showExportOptionPopup# isSaveAs, canAddPdfFileMenu fail");
            return;
        }
        if (this.mNotesModel.getCheckedNotesCount() == 0) {
            MainLogger.m7254d(TAG, "showExportOptionPopup# checkCount 0");
            return;
        }
        Map<String, CheckedNoteInfo> sharableCheckedNoteMap = this.mNotesModel.getSharableCheckedNoteMap();
        StringBuilder sbM3200j = AbstractC4539a.m3200j("showExportOptionPopup# isSaveAs : ", ", selectedSize: ", z);
        sbM3200j.append(sharableCheckedNoteMap.size());
        MainLogger.m7258i(TAG, sbM3200j.toString());
        int deletableCheckedLockNotesCount = this.mNotesModel.getCheckNotesCountInfo().getDeletableCheckedLockNotesCount();
        boolean zIsSupportedFileProvider = DeviceUtils.isSupportedFileProvider();
        if (deletableCheckedLockNotesCount != 0 && zIsSupportedFileProvider) {
            this.mDialogCreator.createUnlockConfirmDialog(context, new UnlockConfirmDialogHelper(context, UnlockConfirmDialogHelper.Caller.SHARE, deletableCheckedLockNotesCount, z), new C8414f(this, z, sharableCheckedNoteMap)).show();
        } else if (deletableCheckedLockNotesCount != 0) {
            this.mDialogCreator.createUnlockConfirmDialog(context, new UnlockConfirmDialogHelper(context, UnlockConfirmDialogHelper.Caller.SHARE_NO_PROVIDER, deletableCheckedLockNotesCount, z), new C8414f(this, sharableCheckedNoteMap, z)).show();
        } else {
            this.mExportHelper.getInstance().showExportShareTypeMenu(new ArrayList<>(sharableCheckedNoteMap.values()), z);
        }
    }

    public void showSearchFilter() {
        this.mAdapterManager.showSearchFilter();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.DataMapper
    public void startConvertNotes(List<String> list, boolean z, boolean z2) {
        ArrayList<MainListDocumentData> arrayList;
        List<String> list2 = list;
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<MainListDocumentData> arrayList3 = (ArrayList) DataManager.getInstance().getAll_OldNotes();
            if (arrayList3 != null) {
                MainLogger.m7258i(TAG, "startConvertNotes# oldNotes size: " + arrayList3.size());
                for (MainListDocumentData mainListDocumentData : arrayList3) {
                    if (mainListDocumentData != null) {
                        arrayList2.add(mainListDocumentData.getUuid());
                    }
                }
            }
            if (z && (arrayList = (ArrayList) DataManager.getInstance().getAll_Converted()) != null) {
                MainLogger.m7258i(TAG, "startConvertNotes# convertedNotes size: " + arrayList.size());
                for (MainListDocumentData mainListDocumentData2 : arrayList) {
                    if (mainListDocumentData2 != null) {
                        arrayList2.add(mainListDocumentData2.getUuid());
                    }
                }
            }
            TipCardUtil.setConvertAll(true);
            list2 = arrayList2;
        }
        MainLogger.m7258i(TAG, "startConvertNotes# uuid size : " + list2.size());
        ArrayList<MainListDocumentData> arrayList4 = new ArrayList<>();
        if (!z2 && hasLockedSdoc(list2)) {
            MainLogger.m7258i(TAG, "startConvertNotes# hasLockedSdoc");
            verifyOldNote(list2, z);
            return;
        }
        for (String str : list2) {
            MainListDocumentData noteData = this.mDocumentMap.getNoteData(str);
            if (DataManager.getInstance().isOldConvertedNote(str)) {
                if (!z) {
                    if (noteData == null) {
                        noteData = DataManager.getInstance().getDocumentData(str);
                    }
                }
            }
            arrayList4.add(noteData);
        }
        if (arrayList4.isEmpty()) {
            MainLogger.m7258i(TAG, "startConvertNotes# ignore, notesList is empty");
            return;
        }
        if (list2.size() != 1 || hasLockedSdoc(list2)) {
            this.mTipCardHelper.getInstance().addConvertNoteTipCard(arrayList4, new IConvertTaskCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.NotesPresenter.4
                @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
                public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                }

                @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
                public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                    NotesPresenter.this.playConvertFinishedToast();
                }
            });
        } else {
            this.mTipCardHelper.getInstance().addConvertNoteTipCard(arrayList4, this.openNotesCallback);
        }
        this.mViewParams.getNotesView().onFolderSelected(FolderConstants.AllNotes.UUID);
    }

    public void updateCheckedData(CommonHolderInfo commonHolderInfo, boolean z) {
        if (commonHolderInfo == null || commonHolderInfo.getHolderType() >= 4096 || FolderUtils.isStaticFolder(commonHolderInfo.getUuid())) {
            return;
        }
        MainLogger.m7258i(TAG, "updateCheckedData# uuid: " + commonHolderInfo.getUuid() + " isChecked: " + z);
        if (commonHolderInfo.getHolderType() != 2048) {
            if (z) {
                this.mNotesModel.addCheckedFolder(commonHolderInfo.getUuid());
            } else {
                this.mNotesModel.removeCheckedFolder(commonHolderInfo.getUuid());
            }
            updateFolderExpandBarHolder();
            return;
        }
        MainListDocumentData noteData = this.mDocumentMap.getNoteData(commonHolderInfo.getUuid());
        if (noteData == null) {
            return;
        }
        if (z) {
            this.mNotesModel.addCheckedNote(noteData);
        } else {
            this.mNotesModel.removeCheckedNote(noteData.getUuid());
        }
    }

    public void updateDataObserverToCurrentMode(int i, int i2) {
        if (FeatureUtils.getUpdateDataIndex(i) == FeatureUtils.getUpdateDataIndex(i2)) {
            return;
        }
        this.mDocumentMap.clearCommonDisplayList();
        notifyDataSetChangedWithViewPageChange("updateDataObserverToCurrentMode");
        this.mAdapterManager.updateDataObserverToCurrentMode();
    }

    public void updateSearchFilterInfo() {
        this.mSearchHelper.getInstance().updateSearchFilterInfo();
    }

    public void updateSubHeaderCheckBox(long j) {
        CommonHolderInfo commonHolderInfoFindCommonHolderInfo;
        boolean zIsSubHeaderChecked;
        CommonHolder commonHolderFindCommonHolder = this.mRecyclerViewHelper.getInstance().findCommonHolder(j);
        if (commonHolderFindCommonHolder == null || (commonHolderInfoFindCommonHolderInfo = this.mRecyclerViewHelper.getInstance().findCommonHolderInfo(commonHolderFindCommonHolder, null)) == null || commonHolderInfoFindCommonHolderInfo.getCheckBox() == null) {
            return;
        }
        if (j == -15 || j == -14 || j == -16) {
            zIsSubHeaderChecked = this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(j == -15));
        } else {
            zIsSubHeaderChecked = this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(commonHolderFindCommonHolder.getAbsoluteAdapterPosition()));
        }
        commonHolderInfoFindCommonHolderInfo.getCheckBox().setChecked(isSubHeaderChecked(zIsSubHeaderChecked));
    }

    public void updateTimeSubHeaderCheckBox(String str) {
        int iFindTimeSubHeaderPosition = this.mDocumentMap.findTimeSubHeaderPosition(str);
        CommonHolderInfo commonHolderInfoFindCommonHolderInfo = this.mRecyclerViewHelper.getInstance().findCommonHolderInfo((CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(iFindTimeSubHeaderPosition), null);
        if (commonHolderInfoFindCommonHolderInfo == null || commonHolderInfoFindCommonHolderInfo.getCheckBox() == null) {
            return;
        }
        commonHolderInfoFindCommonHolderInfo.getCheckBox().setChecked(this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(iFindTimeSubHeaderPosition)));
    }

    public void showDeleteDialog(boolean z) {
        if (NotesUtils.isNeedToDeletePermanently(this.mViewParams.getModeIndex()) || FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel()) {
            showPermanentlyDeleteItemsDialog(z);
        } else {
            showDeleteItemsDialog();
        }
    }

    private void duplicateToDevice(boolean z, List<String> list) {
        ArrayList<ImportDocument> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            MainListDocumentData noteData = this.mDocumentMap.getNoteData(it.next());
            if (noteData != null) {
                String filePath = noteData.getFilePath();
                String categoryUuid = noteData.getCategoryUuid();
                if (z || FeatureUtils.isPreDefinedFolderUuid(categoryUuid)) {
                    categoryUuid = null;
                }
                if (!TextUtils.isEmpty(filePath)) {
                    arrayList.add(new ImportDocument(filePath, categoryUuid, UUIDUtils.isCoeditUuid(noteData.getUuid())));
                }
            }
        }
        duplicateToDevice(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.DataMapper
    public void duplicateToDevice(ArrayList<ImportDocument> arrayList) {
        MainLogger.m7258i(TAG, "duplicateToDevice# documentList size : " + arrayList.size());
        if (arrayList.isEmpty()) {
            return;
        }
        TaskState.INSTANCE.getInstance().setIsRunning("DUPLICATE_NOTES", true);
        this.mDialogHelper.getInstance().showSaveToDeviceDialog();
        Context context = this.mViewParams.getContext();
        if (context == null) {
            MainLogger.m7259w(TAG, "duplicateToDevice# context is null");
            return;
        }
        C0312d c0312d = new C0312d(context, arrayList, com.samsung.android.support.senl.p148nt.model.importer.common.Constants.CALLER_DUPLICATE_NOTE);
        this.mImportDocumentManager = c0312d;
        c0312d.f804i = Executors.newFixedThreadPool(2, new SenlThreadFactory(TAG));
        c0312d.f808m = new C83843(context);
        c0312d.m664c(false);
        onTaskFinished();
    }
}
