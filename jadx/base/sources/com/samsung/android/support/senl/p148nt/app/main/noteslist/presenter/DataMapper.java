package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.receiver.KnoxRestrictionsReceiver;
import com.samsung.android.app.notes.sync.migration.C6798g;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderWorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.livesharing.LiveSharingHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckNotesCountInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.checkbox.CheckBoxAnimatorController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareDialogTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.ProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.task.AsyncTaskWithActivity;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import p079T.AbstractC0299q;
import p084U0.C0312d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DataMapper {
    protected static final String KEY_REVIEW_REQUEST_TIME_STAMP = "review_request_time_stamp";
    protected static final int MAX_DUPLICATE_THREAD_POOL_COUNT = 2;
    protected static final long REVIEW_REQUEST_PERIOD = 1209600000;
    protected AdapterManager mAdapterManager;
    protected CheckBoxAnimatorController mCheckBoxAnimatorController;
    protected DialogViewContract.IDialogCreator mDialogCreator;
    protected final DocumentMap mDocumentMap;
    protected C0312d mImportDocumentManager;
    protected LiveSharingHelper mLiveSharingHelper;
    protected NotesPenRecyclerView mRecyclerView;
    protected final SharedPreferences.OnSharedPreferenceChangeListener mSOMSharedPreferenceChangeListener;
    protected SettingsSearchIndexingManager.SPenSettingStateChangeListener mSPenSettingStateChangeListener;
    protected final SharedPreferences.OnSharedPreferenceChangeListener mSettingSharedPreferenceListener;
    protected StateInfo mStateInfo;
    protected ViewParams mViewParams;
    private static final String TAG = "DataMapper";
    protected static final Executor SINGLE_THREAD_EXECUTOR = AbstractC4539a.m3201k(TAG);
    protected ProgressListener mMigrationListener = new C83761();
    protected BroadcastReceiver mUpdateBroadcastReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.DataMapper.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            int iIndexOfDisplayData;
            String action = intent.getAction();
            MainLogger.m7258i(DataMapper.TAG, "onReceive, action : " + action);
            if (!"com.samsung.android.app.notes.memolist.ACTION_FORCE_UPDATE".equals(action)) {
                if (BaseWidgetConstant.TIME_SET_CHANGED.equals(action)) {
                    DataMapper.this.updateNoteListTimeView();
                }
            } else {
                if (DataMapper.this.mAdapterManager == null || (iIndexOfDisplayData = DataMapper.this.mDocumentMap.indexOfDisplayData((stringExtra = intent.getStringExtra("sdoc_uuid")))) < 0) {
                    return;
                }
                DataMapper.this.mStateInfo.setForceUpdateThumbnail(stringExtra);
                DataMapper.this.mAdapterManager.notifyItemChanged(iIndexOfDisplayData, "com.samsung.android.app.notes.memolist.ACTION_FORCE_UPDATE", "UpdateBroadcastReceiver");
            }
        }
    };
    protected KnoxRestrictionsReceiver mKnoxRestrictionsReceiver = new KnoxRestrictionsReceiver();
    protected BroadcastReceiver mOneDriveLinkReceiver = null;
    protected ContentObserver mSystemTimeFormatObserver = new ContentObserver(new Handler()) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.DataMapper.3
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (Settings.System.getUriFor("time_12_24").equals(uri)) {
                DataMapper.this.updateNoteListTimeView();
            }
        }
    };
    protected AsyncTaskManager.TaskStatusListener mTaskStatusListener = new C83794();
    protected final WindowInsetsManager.ApplyInsetListener mApplyInsetListener = new WindowInsetsManager.ApplyInsetListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.DataMapper.5
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.ApplyInsetListener
        public void onApplyInsets(@NotNull View view, @NotNull WindowInsetsCompat windowInsetsCompat) {
            MainLogger.m7259w(DataMapper.TAG, "onApplyInsets# " + DataMapper.this.mViewParams.getAbsFragment().isResumed());
            DataMapper.this.mViewParams.getNotesView().applyWindowInsets();
            if (DataMapper.this.mStateInfo.getSearchCallerMode() != 27) {
                DataMapper.this.mViewParams.getNotesView().getSearchImpl().onWindowInsetUpdated(windowInsetsCompat);
            }
        }
    };
    protected final WindowInsetsManager.AnimationCallback mAnimationCallback = new WindowInsetsManager.AnimationCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.DataMapper.6
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onEnd(@NotNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            MainLogger.m7259w(DataMapper.TAG, "onEnd#");
            DataMapper.this.mViewParams.getNotesView().getSearchImpl().onWindowInsetUpdated(WindowInsetsManager.getInstance().getWindowInsets());
            DataMapper.this.mViewParams.getNotesView().getSearchImpl().onWindowInsetAnimationUpdated(WindowInsetsManager.getInstance().getWindowInsets());
            DataMapper.this.mViewParams.getNotesView().applyWindowInsets();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onProgress(@NotNull WindowInsetsCompat windowInsetsCompat, @NotNull List<WindowInsetsAnimationCompat> list) {
            MainLogger.m7259w(DataMapper.TAG, "onProgress#");
            DataMapper.this.mViewParams.getNotesView().getSearchImpl().onWindowInsetUpdated(windowInsetsCompat);
            DataMapper.this.mViewParams.getNotesView().getSearchImpl().onWindowInsetAnimationUpdated(windowInsetsCompat);
        }
    };
    protected final NotesModel mNotesModel = new NotesModel();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.DataMapper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C83761 implements ProgressListener {
        public C83761() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnd$2() {
            MainLogger.m7258i(DataMapper.TAG, "onEnd, run");
            DataMapper.this.mDocumentMap.removeHolderInfoMap(0);
            DataMapper.this.mDocumentMap.sortTopHolderDisplayList(0);
            DataMapper.this.notifyDataSetChanged("Migration end");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onProgress$1() {
            MainLogger.m7258i(DataMapper.TAG, "onProgress, run");
            DataMapper.this.mDocumentMap.putHolderInfoMap(0, true);
            DataMapper.this.mDocumentMap.sortTopHolderDisplayList(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStart$0() {
            MainLogger.m7258i(DataMapper.TAG, "onStart, run");
            DataMapper.this.mDocumentMap.putHolderInfoMap(0, true);
            DataMapper.this.mDocumentMap.sortTopHolderDisplayList(0);
            DataMapper.this.notifyDataSetChanged("Migration start");
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.ProgressListener
        public void onEnd() {
            MainLogger.m7258i(DataMapper.TAG, "onEnd");
            ViewModeUtils.runOnUiThread(DataMapper.this.mViewParams.getAbsFragment().getActivity(), new RunnableC8407c(this, 2));
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.ProgressListener
        public void onProgress() {
            MainLogger.m7258i(DataMapper.TAG, "onProgress");
            ViewModeUtils.runOnUiThread(DataMapper.this.mViewParams.getAbsFragment().getActivity(), new RunnableC8407c(this, 0));
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.ProgressListener
        public void onStart() {
            MainLogger.m7258i(DataMapper.TAG, "onStart");
            ViewModeUtils.runOnUiThread(DataMapper.this.mViewParams.getAbsFragment().getActivity(), new RunnableC8407c(this, 1));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.DataMapper$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C83794 implements AsyncTaskManager.TaskStatusListener {
        public C83794() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnd$0() {
            DataMapper.this.onTaskFinished();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.task.AsyncTaskManager.TaskStatusListener
        public void onEnd(AsyncTaskWithActivity asyncTaskWithActivity, AsyncTaskManager.TaskResult taskResult) {
            if (taskResult == null) {
                DataMapper.this.onTaskFinished();
                return;
            }
            taskResult.getType();
            MainLogger.m7254d(DataMapper.TAG, "onEnd# ");
            new Handler().postDelayed(new RunnableC8412d(this, 0), 0L);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.task.AsyncTaskManager.TaskStatusListener
        public void onStart(AsyncTaskWithActivity asyncTaskWithActivity) {
            if (asyncTaskWithActivity instanceof LockTask) {
                DataMapper.this.checkRunningTask(LockTask.TAG);
                MainLogger.m7254d(DataMapper.TAG, "onStart# LockTask");
            }
        }
    }

    public DataMapper() {
        final int i = 0;
        this.mSettingSharedPreferenceListener = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ DataMapper f6185b;

            {
                this.f6185b = this;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                switch (i) {
                    case 0:
                        this.f6185b.lambda$new$0(sharedPreferences, str);
                        break;
                    default:
                        this.f6185b.lambda$new$1(sharedPreferences, str);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mSOMSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ DataMapper f6185b;

            {
                this.f6185b = this;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                switch (i2) {
                    case 0:
                        this.f6185b.lambda$new$0(sharedPreferences, str);
                        break;
                    default:
                        this.f6185b.lambda$new$1(sharedPreferences, str);
                        break;
                }
            }
        };
        StateInfo stateInfo = new StateInfo();
        this.mStateInfo = stateInfo;
        this.mDocumentMap = new DocumentMap(stateInfo);
        initFolderWorkerTask();
    }

    private void initFolderWorkerTask() {
        new FolderWorkerTask("InitFolderMap").run(new FolderWorkerTask.TaskParams(new RunnableC8412d(this, 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFolderWorkerTask$2() {
        DataManager.getInstance().initFolderMap();
        this.mDocumentMap.initFolderDataMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(SharedPreferences sharedPreferences, String str) {
        if (SettingsConstants.SETTINGS_MICROSOFT_SYNC.equals(str)) {
            msSyncChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(SharedPreferences sharedPreferences, String str) {
        if (FolderConstants.KEY_SOM_FOLDER_HAS_BADGE.equals(str)) {
            if (FolderConstants.MyFolders.UUID.equals(this.mStateInfo.getFolderUuid())) {
                this.mAdapterManager.onSOMSubFolderNewBadgeChanged();
            } else if (FolderConstants.ScreenOffMemo.UUID.equals(this.mStateInfo.getFolderUuid())) {
                this.mAdapterManager.onSOMRecognizedCardNewBadgeChanged();
            }
        }
    }

    private void msSyncChanged() {
        List<Common> commonDisplayList = this.mDocumentMap.getCommonDisplayList();
        int i = -1;
        int i2 = 0;
        int i4 = -1;
        while (true) {
            if (i2 >= commonDisplayList.size()) {
                break;
            }
            if (commonDisplayList.get(i2).type <= 1024) {
                if (i4 == -1) {
                    i4 = i2;
                }
            } else if (i4 != -1) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i4 < i) {
            this.mAdapterManager.notifyDataSetChanged("msSyncChanged");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNoteListTimeView() {
        NotesPenRecyclerView notesPenRecyclerView;
        MainLogger.m7258i(TAG, "updateNoteListTimeView");
        AdapterManager adapterManager = this.mAdapterManager;
        if (adapterManager == null || (notesPenRecyclerView = this.mRecyclerView) == null) {
            return;
        }
        adapterManager.notifyItemRangeChanged(0, notesPenRecyclerView.getChildCount(), NotesConstants.PAYLOAD_CHANGE_TIME);
    }

    public void addCheckedNote(MainListDocumentData mainListDocumentData) {
        this.mNotesModel.addCheckedNote(mainListDocumentData);
        if (this.mStateInfo.getModeIndex() == 25 || this.mStateInfo.getModeIndex() == 28) {
            this.mDocumentMap.getNoteMap().put(mainListDocumentData.getUuid(), mainListDocumentData);
        }
    }

    public void addInflatedView(View view) {
        this.mAdapterManager.addInflatedView(view);
    }

    public void addSubFolderBitmap(int i, int i2, @NotNull Drawable drawable) {
        this.mAdapterManager.addSubFolderBitmap(i, i2, drawable);
    }

    public void addSubHeaderInflatedView(View view) {
        this.mAdapterManager.addSubHeaderInflatedView(view);
    }

    public boolean checkRunningTask(String str) {
        AsyncTaskWithActivity runningTask = getRunningTask(str);
        WorkerTask<?> runningTask2 = WorkerTaskManager.getInstance().getRunningTask(str);
        if ((runningTask != null && !runningTask.isCancelled()) || (runningTask2 != null && !runningTask2.isCancelled())) {
            MainLogger.m7258i(TAG, "checkRunningTask# " + str);
            if (LockTask.TAG.equals(str)) {
                showProgressCircle(C8003R.id.action_lock);
                return true;
            }
            if (RestoreTask.TAG.equals(str)) {
                showProgressCircle(C8003R.id.action_restore);
                return true;
            }
            if (ShareDialogTask.TAG.equals(str)) {
                showProgressCircle(100);
                return true;
            }
        }
        return false;
    }

    public void clearCheckedData() {
        this.mNotesModel.clearCheckedNotes();
        this.mNotesModel.clearCheckedFolders();
        this.mNotesModel.clearCheckedDimmedNotes();
    }

    public void clearHighlightText() {
        this.mAdapterManager.setHighlightText(new HighlightText());
    }

    public void clickPinToFavorites() {
        boolean zIsPinFavorites = NotesUtils.isPinFavorites();
        if (zIsPinFavorites) {
            CommonSamsungAnalytics.insertLog("706", "7094", "0");
        } else {
            CommonSamsungAnalytics.insertLog("706", "7094", "1");
        }
        NotesUtils.setPinFavorites(!zIsPinFavorites);
    }

    public void deleteCheckedNoteDataFile(Context context) {
        this.mNotesModel.deleteCheckedNoteDataFile(context);
    }

    public abstract void duplicateToDevice(ArrayList<ImportDocument> arrayList);

    public CheckNotesCountInfo getCheckNotesCountInfo() {
        return this.mNotesModel.getCheckNotesCountInfo();
    }

    public int getCheckedDataCount() {
        return this.mNotesModel.getCheckedDataCount();
    }

    public int getCheckedDimmedNotesCount() {
        return this.mNotesModel.getCheckedDimmedNotesCount();
    }

    public int getCheckedDimmedNotesInFolderCount() {
        return this.mNotesModel.getCheckedDimmedNotesInFolderCount();
    }

    public ArrayList<String> getCheckedFolderUUID() {
        return this.mNotesModel.getCheckedFoldersUUID();
    }

    public int getCheckedFoldersCount() {
        return this.mNotesModel.getCheckedFoldersCount();
    }

    public ArrayList<CheckedNoteInfo> getCheckedNotes() {
        return this.mNotesModel.getCheckedNotes();
    }

    public int getCheckedNotesCount() {
        return this.mNotesModel.getCheckedNotesCount();
    }

    public ArrayList<String> getCheckedNotesUUID() {
        return this.mNotesModel.getCheckedNotesUUID();
    }

    public ArrayList<String> getCheckedNotesUUIDForWidgetList() {
        return this.mNotesModel.getCheckedNotesUUIDForWidgetList();
    }

    public Pair<List<String>, Integer> getConvertTargetUuids(boolean z) {
        ArrayList<String> checkedNotesUUID;
        int lockedNotesCount;
        if (z) {
            checkedNotesUUID = new ArrayList<>();
            ArrayList<MainListDocumentData> arrayList = (ArrayList) DataManager.getInstance().getAll_OldNotes();
            lockedNotesCount = 0;
            if (arrayList != null) {
                MainLogger.m7258i(TAG, "startConvertNotes# oldNotes size : " + arrayList.size());
                for (MainListDocumentData mainListDocumentData : arrayList) {
                    if (mainListDocumentData != null) {
                        checkedNotesUUID.add(mainListDocumentData.getUuid());
                        if (mainListDocumentData.getIsLock() == 1) {
                            lockedNotesCount++;
                        }
                    }
                }
            }
            ArrayList<MainListDocumentData> arrayList2 = (ArrayList) DataManager.getInstance().getAll_Converted();
            if (arrayList2 != null) {
                MainLogger.m7258i(TAG, "startConvertNotes# convertedNotes size : " + arrayList2.size());
                for (MainListDocumentData mainListDocumentData2 : arrayList2) {
                    if (mainListDocumentData2 != null) {
                        checkedNotesUUID.add(mainListDocumentData2.getUuid());
                        if (mainListDocumentData2.getIsLock() == 1) {
                            lockedNotesCount++;
                        }
                    }
                }
            }
        } else {
            checkedNotesUUID = this.mNotesModel.getCheckedNotesUUID();
            lockedNotesCount = this.mNotesModel.getCheckNotesCountInfo().getLockedNotesCount();
        }
        return new Pair<>(checkedNotesUUID, Integer.valueOf(lockedNotesCount));
    }

    public DocumentMap getDocumentMap() {
        return this.mDocumentMap;
    }

    public FilterInfo getFilterInfo() {
        return this.mStateInfo.getFilterInfo();
    }

    public boolean getIsInAppSearch() {
        return this.mStateInfo.getIsInAppSearch();
    }

    public String getLastOpenedSDocXUuid() {
        return this.mNotesModel.getLastOpenedSDocXUuid();
    }

    public boolean getLongPressFlag() {
        return this.mNotesModel.getLongPressFlag();
    }

    public ArrayList<String> getNonCorruptedNotesUuid() {
        return this.mNotesModel.getNonCorruptedNotesUuid();
    }

    public int getRequestCodeForOtherApp() {
        return this.mNotesModel.getRequestCodeForOtherApp();
    }

    public AsyncTaskWithActivity getRunningTask(String str) {
        if (!LockTask.TAG.equals(str)) {
            return null;
        }
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return null;
        }
        return ApplicationManager.getInstance().getAsyncTaskManager().getRunningTask(activity.hashCode(), LockTask.class);
    }

    public ArrayList<CheckedNoteInfo> getSaveExportNoteList() {
        return this.mNotesModel.getSaveExportNoteList();
    }

    public int getSaveExportType() {
        return this.mNotesModel.getSaveExportType();
    }

    @NonNull
    public String getSavedSearchText() {
        return this.mStateInfo.getSavedSearchText();
    }

    @NonNull
    public Map<String, CheckedNoteInfo> getSharableCheckedNoteMap() {
        return this.mNotesModel.getSharableCheckedNoteMap();
    }

    public StateInfo getStateInfo() {
        return this.mStateInfo;
    }

    public int getToolType() {
        return this.mNotesModel.getToolType();
    }

    public boolean hasCoeditUnsupportedFormatVersion() {
        return this.mNotesModel.hasCoeditUnsupportedFormatVersion();
    }

    public boolean hasGenUuidNote(List<String> list) {
        return this.mNotesModel.hasGenUuidNote(list);
    }

    public boolean hasLockedSdoc(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            MainListDocumentData noteData = this.mDocumentMap.getNoteData(it.next());
            if (noteData != null && LockUtils.isLockedSdocType(noteData.getIsLock())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTemplateUuid(List<String> list) {
        return this.mNotesModel.hasTemplateUuid(list);
    }

    public void initDataObserver() {
        this.mAdapterManager.initDataObserver();
    }

    public boolean isScrolling() {
        return this.mNotesModel.isScrolling();
    }

    public boolean isSearchInsideFolder() {
        return this.mStateInfo.isSearchInsideFolder();
    }

    public boolean isSubHeaderAllDimmed(List<String> list) {
        return this.mNotesModel.isSubHeaderAllDimmed(list);
    }

    public boolean isSubHeaderChecked(boolean z) {
        return this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(z));
    }

    public boolean isUuidInCheckedData(String str) {
        return this.mNotesModel.isUuidInCheckedFolder(str) || this.mNotesModel.isUuidInCheckedNotes(str);
    }

    public boolean isUuidInCheckedDimmedNotes(String str) {
        return this.mNotesModel.isUuidInCheckedDimmedNotes(str);
    }

    public boolean isUuidInCheckedFolder(String str) {
        return this.mNotesModel.isUuidInCheckedFolder(str);
    }

    public boolean isUuidInCheckedNotes(String str) {
        return this.mNotesModel.isUuidInCheckedNotes(str);
    }

    public void modeChangeAnimation(boolean z) {
        this.mCheckBoxAnimatorController.modeChangeAnimation(z);
    }

    public boolean needInflatedView() {
        return this.mAdapterManager.needInflatedView();
    }

    public void notifyDataSetChanged(String str) {
        AdapterManager adapterManager = this.mAdapterManager;
        if (adapterManager == null) {
            return;
        }
        adapterManager.notifyDataSetChanged(str);
    }

    public void notifyDataSetChangedWithViewPageChange(String str) {
        AdapterManager adapterManager = this.mAdapterManager;
        if (adapterManager == null) {
            return;
        }
        adapterManager.notifyDataSetChangedWithViewPageChange(str);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.mStateInfo.onRestoreInstanceState(bundle);
        this.mNotesModel.onRestoreInstanceState(bundle, this.mViewParams.getContext());
        this.mDocumentMap.onRestoreInstanceState(this.mViewParams.getAbsFragment().getActivity(), bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mDocumentMap.onSaveInstanceState(bundle);
        this.mStateInfo.onSaveInstanceState(bundle);
        this.mNotesModel.onSaveInstanceState(bundle, this.mViewParams.getContext());
    }

    public void onScrollStateChanged(int i) {
        this.mAdapterManager.onScrollStateChanged(i);
    }

    public boolean onTaskCancel() {
        if (FeatureUtils.isEditMode(this.mViewParams.getModeIndex())) {
            return false;
        }
        clearCheckedData();
        return true;
    }

    public void onTaskFinished() {
        ViewParams viewParams = this.mViewParams;
        if (viewParams == null || viewParams.getNotesView() == null) {
            MainLogger.m7258i(TAG, "onTaskFinished# notesView is null");
            return;
        }
        ViewContract.IMode mode = this.mViewParams.getNotesView().getMode();
        if (mode == null) {
            MainLogger.m7258i(TAG, "onTaskFinished# mode is null");
            return;
        }
        MainLogger.m7258i(TAG, "onTaskFinished");
        if (!onTaskCancel()) {
            mode.onBackKeyDown();
        }
        showProgressCircle(0);
    }

    public void postNotifyDataSetChanged() {
        this.mAdapterManager.reattachDataObserver();
    }

    public void releaseInflatedView() {
        this.mAdapterManager.releaseInflatedView();
    }

    public void releaseNoteAnimation() {
        this.mNotesModel.releaseNoteAnimation();
    }

    public void saveArguments(Bundle bundle) {
        this.mStateInfo.initFolderBackHistory();
        this.mStateInfo.saveArguments(bundle);
        setCheckedDimmedNotes(bundle);
    }

    public void selectAllForListWidget(boolean z, int i) {
        this.mNotesModel.selectAllForListWidget(z, this.mDocumentMap.getCommonDisplayList(), i);
        this.mCheckBoxAnimatorController.updateCheckBox(0, false);
    }

    public void selectAllNotes(boolean z) {
        this.mNotesModel.selectAllNotes(z, this.mDocumentMap.getCommonDisplayList());
        this.mCheckBoxAnimatorController.updateCheckBox(0, false);
    }

    public void selectAllWithSubHeader(boolean z, boolean z2) {
        this.mNotesModel.selectAllWithSubHeader(z, this.mDocumentMap.getCommonDisplayList(), z2);
        this.mCheckBoxAnimatorController.updateCheckBoxWithSubHeader(0, false, z2);
    }

    public void selectAllWithTimeSubHeader(boolean z, int i) {
        this.mNotesModel.selectAllWithSubHeader(z, this.mDocumentMap.getCommonDisplayList(), i);
        this.mCheckBoxAnimatorController.updateCheckBoxWithSubHeader(0, false, i);
    }

    public void setCheckBoxState(CommonHolderInfo commonHolderInfo) {
        this.mCheckBoxAnimatorController.setCheckBoxState(commonHolderInfo);
    }

    public void setCheckedDimmedNotes(Bundle bundle) {
        this.mNotesModel.setCheckedDimmedNotes(bundle, this.mStateInfo.getCaller());
    }

    public boolean setEditMode(boolean z) {
        return this.mViewParams.getNotesView().getMode().setEditMode(z);
    }

    public void setIsInAppSearch(boolean z) {
        this.mStateInfo.setIsInAppSearch(z);
    }

    public boolean setIsScrolling(boolean z) {
        return this.mNotesModel.setIsScrolling(z);
    }

    public void setLastDisplay(int i) {
        this.mNotesModel.setLastDisplay(i);
    }

    public void setLastOpenedSDocXUuid(String str) {
        this.mNotesModel.setLastOpenedSDocXUuid(str);
    }

    public void setLongPressFlag(boolean z) {
        this.mNotesModel.setLongPressFlag(z);
    }

    public void setMigrationListener(String str) {
        MainLogger.m7254d(TAG, "setMigrationListener# caller : " + str);
        C6798g c6798gM4962h = C6798g.m4962h();
        ProgressListener progressListener = this.mMigrationListener;
        c6798gM4962h.getClass();
        AbstractC0299q.m643n(C6798g.f4220k, "setProgressListener listener " + progressListener);
        c6798gM4962h.f4223b = progressListener;
    }

    public void setPostNotifyDataSetChanged() {
        this.mNotesModel.postNotifyDataSetChanged();
    }

    public void setRequestCodeForOtherApp(int i) {
        this.mNotesModel.setRequestCodeForOtherApp(i);
    }

    public void setSaveExportType(int i) {
        this.mNotesModel.setSaveExportType(i);
    }

    public void setSavedSearchText(@NonNull String str, @NonNull String str2) {
        this.mStateInfo.setSavedSearchText(str);
        this.mStateInfo.setSearchCoverData(str2);
    }

    public void setSearchInsideFolder(boolean z) {
        this.mStateInfo.setSearchInsideFolder(z);
    }

    public void setSearchMode() {
        this.mViewParams.getNotesView().setMode(3);
    }

    public void setToolType(int i) {
        this.mNotesModel.setToolType(i);
    }

    public void showDeleteErrorToast(DeleteTask.Result result) {
        if (result.getMHasOpenedNote()) {
            Context context = BaseUtils.getContext();
            ToastHandler.show(context, context.getResources().getString(C8003R.string.toast_not_delete_opened_note), 0, true);
        }
    }

    public void showProgressCircle(int i) {
        this.mViewParams.getNotesView().showProgressCircle(i);
    }

    public ArrayList<String> showToastForMove(String str) {
        NotesModel.MovingFolder movingFolderMoveFolder = this.mNotesModel.moveFolder(str);
        Context context = this.mViewParams.getContext();
        if (movingFolderMoveFolder.duplCount > 0) {
            Resources resources = context.getResources();
            int i = C8003R.plurals.plurals_note_not_moved;
            int i2 = movingFolderMoveFolder.duplCount;
            ToastHandler.show(context, resources.getQuantityString(i, i2, Integer.valueOf(i2)), 1);
        }
        return movingFolderMoveFolder.sdocUuidList;
    }

    public abstract void startConvertNotes(List<String> list, boolean z, boolean z2);

    public void updateContentDescription(CommonHolderInfo commonHolderInfo, boolean z) {
        this.mCheckBoxAnimatorController.updateContentDescription(commonHolderInfo, z);
    }

    public void updateDataObserverToCurrentMode() {
        this.mAdapterManager.updateDataObserverToCurrentMode();
    }

    public boolean isSubHeaderChecked(List<String> list) {
        return this.mNotesModel.isSubHeaderChecked(list);
    }

    public boolean selectAllWithTimeSubHeader(boolean z, int i, int i2) {
        boolean zSelectAllWithSubHeader = this.mNotesModel.selectAllWithSubHeader(z, this.mDocumentMap.getCommonDisplayList(), i, i2);
        this.mCheckBoxAnimatorController.updateCheckBoxWithSubHeader(0, false, i);
        return zSelectAllWithSubHeader;
    }
}
