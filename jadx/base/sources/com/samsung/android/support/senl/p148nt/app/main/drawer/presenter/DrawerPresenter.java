package com.samsung.android.support.senl.p148nt.app.main.drawer.presenter;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6696j;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ChangeColorDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.FolderNameDialog;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.IColorConfirmDialogResult;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderDeleteTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderWorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.DrawerAdapter;
import com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.DrawerHolder;
import com.samsung.android.support.senl.p148nt.app.main.drawer.model.DrawerModel;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.AnchorViewUtils;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DrawerPresenter implements AdapterContract {
    private static final int REATTACH_DURATION = 500;
    private static final String TAG = "DrawerPresenter";
    private final DrawerAdapter mAdapter;
    private LiveData<List<CoeditMainListEntry>> mCoeditLiveData;
    private LiveData<Map<String, NotesDocumentCountEntry>> mCountLiveData;
    private int mDataUpdateType;
    private LiveData<DocumentCategoryTree> mFolderLiveData;
    protected final AbsFragment mFragment;
    private FolderWorkerTask mInitFolderWorkerTask;
    protected DrawerModel mModel;
    protected final FolderPenRecyclerView mRecyclerView;
    private String mSelectedUuid;
    private String mToBeDeletedUuid;
    protected final ViewContract mView;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final Runnable mReattachObserverRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            DrawerPresenter drawerPresenter = DrawerPresenter.this;
            if (drawerPresenter.mModel == null || drawerPresenter.mAdapter == null) {
                MainLogger.m7258i(DrawerPresenter.TAG, "mReattachObserverRunnable: null");
                return;
            }
            if (DrawerPresenter.this.mModel.isInitFolderMapNeed() || DrawerPresenter.this.mInitFolderWorkerTask != null) {
                return;
            }
            if (DrawerPresenter.this.needPostNotifyDataSetChanged()) {
                DrawerPresenter.this.setPostNotifyDataSetChanged();
            } else {
                DrawerPresenter.this.updateWaitedObservedMap();
            }
        }
    };
    private final IEditDialogResult mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.2
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogDismiss() {
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogResult(final int i, final String str, final String str2, final int i2) {
            String tag = DrawerPresenter.this.getTag();
            StringBuilder sb = new StringBuilder("onEditDialogResult# folderName : ");
            sb.append(MainLogger.getEncode(str2));
            sb.append(", selectedUuid : ");
            sb.append(str);
            sb.append(", dialogType : ");
            AbstractC8014b.m7212n(sb, tag, i);
            final NotesFolder folderData = DrawerPresenter.this.mModel.getFolderData(str);
            if (folderData == null || CommonUtil.isNotAvailableActivity(DrawerPresenter.this.mFragment.getActivity())) {
                return;
            }
            final FolderWorkerTask folderWorkerTask = new FolderWorkerTask(i == 1 ? "FolderAdd" : "FolderRename");
            folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.2.1
                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onEnd(@NonNull WorkerTask.Result result) {
                    if (folderWorkerTask.getTaskResult().getMSuccess()) {
                        return;
                    }
                    ToastHandler.show(DrawerPresenter.this.mFragment.getContext(), C8003R.string.folder_already_in_use, 0);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onStart(@NonNull WorkerTask<?> workerTask) {
                    folderWorkerTask.getTaskResult().setSuccess(true);
                }
            });
            folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.2.2
                @Override // java.lang.Runnable
                public void run() {
                    String parentUuid = i == 1 ? str : folderData.getParentUuid();
                    if (DataManager.getInstance().isExistFolderName(DrawerPresenter.this.mFragment.getContext(), str2, parentUuid, DataManager.getInstance().getFoldersDisplayName(parentUuid, DrawerPresenter.this.mModel.getFolderDataMap()), true)) {
                        folderWorkerTask.getTaskResult().setSuccess(false);
                        return;
                    }
                    try {
                        if (i == 1) {
                            DrawerPresenter.this.mModel.addFolderData(parentUuid, str2, i2);
                        } else {
                            folderData.setDisplayName(str2);
                            FolderManager.getInstance().update(folderData);
                        }
                        DrawerPresenter.this.mDataUpdateType = i;
                        DrawerPresenter.this.mSelectedUuid = str;
                    } catch (InvalidParentFolderException e) {
                        MainLogger.m7255e(DrawerPresenter.this.getTag(), "mEditDialogResultListener# : " + e.getMessage());
                    }
                }
            }));
        }
    };
    private final IConfirmDialogResultListener mConfirmResultListener = new IConfirmDialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.3
        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
        public void onCancel() {
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
        public void onConfirm(String str) {
            boolean zHasLockedNoteInsideFolder = DrawerPresenter.this.mModel.hasLockedNoteInsideFolder(str, true);
            DrawerPresenter.this.mToBeDeletedUuid = str;
            if (zHasLockedNoteInsideFolder) {
                DrawerPresenter.this.mView.verifyForDelete();
            } else {
                DrawerPresenter.this.deleteItems();
            }
        }
    };
    private final IColorConfirmDialogResult mColorConfirmDialogResult = new IColorConfirmDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.4
        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IColorConfirmDialogResult
        public void onConfirm(final ArrayList<String> arrayList, final int i) {
            if (CommonUtil.isNotAvailableActivity(DrawerPresenter.this.mFragment.getActivity())) {
                return;
            }
            final FolderWorkerTask folderWorkerTask = new FolderWorkerTask("ColorChange");
            folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.4.1
                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onEnd(@NonNull WorkerTask.Result result) {
                    MainLogger.m7255e(DrawerPresenter.TAG, "mColorConfirmDialogResult# : onEnd");
                    if (folderWorkerTask.getTaskResult().getMSuccess()) {
                        DrawerPresenter.this.mView.updateNoteViewByDrawerObserver(true);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onStart(@NonNull WorkerTask<?> workerTask) {
                    folderWorkerTask.getTaskResult().setSuccess(false);
                }
            });
            folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.4.2
                @Override // java.lang.Runnable
                public void run() {
                    DrawerPresenter.this.mDataUpdateType = 11;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        NotesFolder folderData = DrawerPresenter.this.mModel.getFolderData((String) it.next());
                        if (folderData != null) {
                            int displayNameColor = folderData.getDisplayNameColor();
                            int i2 = i;
                            if (displayNameColor != i2) {
                                folderData.setDisplayNameColor(i2);
                                arrayList2.add(folderData);
                            }
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        return;
                    }
                    try {
                        FolderManager.getInstance().update(arrayList2);
                        folderWorkerTask.getTaskResult().setSuccess(true);
                    } catch (InvalidParentFolderException e) {
                        MainLogger.m7255e(DrawerPresenter.TAG, "mColorConfirmResultListener# : " + e.getMessage());
                    }
                }
            }));
        }
    };
    private final Observer<Map<String, NotesDocumentCountEntry>> mCountObserver = new Observer<Map<String, NotesDocumentCountEntry>>() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.5
        @Override // androidx.lifecycle.Observer
        public void onChanged(Map<String, NotesDocumentCountEntry> map) {
            if (DrawerPresenter.this.mModel.isInitFolderMapNeed() || DrawerPresenter.this.mInitFolderWorkerTask != null) {
                DrawerPresenter.this.mModel.enqueueWaitedObservedMap(map);
            } else if (!DrawerPresenter.this.needPostNotifyDataSetChanged()) {
                DrawerPresenter.this.updateCountObserver(map);
            } else {
                DrawerPresenter.this.mModel.enqueueWaitedObservedMap(map);
                DrawerPresenter.this.setPostNotifyDataSetChanged();
            }
        }
    };
    private final Observer<DocumentCategoryTree> mFolderObserver = new Observer<DocumentCategoryTree>() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.6
        @Override // androidx.lifecycle.Observer
        public void onChanged(DocumentCategoryTree documentCategoryTree) {
            if (DrawerPresenter.this.mModel.isInitFolderMapNeed() || DrawerPresenter.this.mInitFolderWorkerTask != null) {
                DrawerPresenter.this.mModel.enqueueWaitedObservedMap(documentCategoryTree);
            } else if (!DrawerPresenter.this.needPostNotifyDataSetChanged()) {
                DrawerPresenter.this.updateFolderObserver(documentCategoryTree);
            } else {
                DrawerPresenter.this.mModel.enqueueWaitedObservedMap(documentCategoryTree);
                DrawerPresenter.this.setPostNotifyDataSetChanged();
            }
        }
    };
    private final Observer<List<CoeditMainListEntry>> mCoeditObserver = new Observer<List<CoeditMainListEntry>>() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.7
        @Override // androidx.lifecycle.Observer
        public void onChanged(List<CoeditMainListEntry> list) {
            if (DrawerPresenter.this.mModel.isInitFolderMapNeed() || DrawerPresenter.this.mInitFolderWorkerTask != null) {
                DrawerPresenter.this.mModel.enqueueWaitedObservedMap(list);
            } else if (!DrawerPresenter.this.needPostNotifyDataSetChanged()) {
                DrawerPresenter.this.updateCoeditObserver(list);
            } else {
                DrawerPresenter.this.mModel.enqueueWaitedObservedMap(list);
                DrawerPresenter.this.setPostNotifyDataSetChanged();
            }
        }
    };
    private final Runnable mUpdateDrawerDisplayDataRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.8
        @Override // java.lang.Runnable
        public void run() {
            DrawerPresenter drawerPresenter = DrawerPresenter.this;
            if (drawerPresenter.mModel == null || drawerPresenter.mAdapter == null) {
                return;
            }
            MainLogger.m7254d(DrawerPresenter.this.getTag(), "run UpdateDrawerDisplayDataRunnable");
            DataManager.getInstance().restoreFolderExpandState(DrawerPresenter.this.mModel.getFolderDataMap());
            DrawerPresenter.this.mModel.initDrawerDisplayDataList();
            DrawerPresenter.this.mAdapter.notifyDataSetChanged("UpdateDrawerDisplayDataRunnable");
        }
    };
    private SharedPreferences.OnSharedPreferenceChangeListener mBadgeSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.9
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            String str2;
            if (GcsConstants.KEY_COEIDT_HAS_BADGE.equals(str)) {
                str2 = FolderConstants.Coedit.UUID;
            } else if (GcsConstants.KEY_GCS_HAS_DRAWER_BADGE.equals(str)) {
                str2 = NotesUtils.isCoeditFeatureEnabled(BaseUtils.getApplicationContext()) ? FolderConstants.Coedit.UUID : FolderConstants.SharedNotes.UUID;
            } else if (FolderConstants.KEY_SOM_FOLDER_HAS_BADGE.equals(str)) {
                DrawerModel drawerModel = DrawerPresenter.this.mModel;
                String str3 = FolderConstants.MyFolders.UUID;
                NotesFolder folderData = drawerModel.getFolderData(str3);
                str2 = (folderData == null || !folderData.isExpanded()) ? str3 : FolderConstants.ScreenOffMemo.UUID;
            } else {
                str2 = SettingsConstants.HAS_NEW_VERSION_BADGE.equals(str) ? "settings:///" : null;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            DrawerPresenter.this.updateBadge(str2);
            DrawerPresenter.this.updateNewBadge();
        }
    };
    private SharedPreferences.OnSharedPreferenceChangeListener mSettingSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.10
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (SettingsConstants.SETTINGS_MICROSOFT_SYNC.equals(str)) {
                DrawerPresenter.this.msSyncChanged();
            }
        }
    };

    public DrawerPresenter(AbsFragment absFragment, FolderPenRecyclerView folderPenRecyclerView, ViewContract viewContract) {
        this.mFragment = absFragment;
        this.mRecyclerView = folderPenRecyclerView;
        this.mView = viewContract;
        setModel();
        initMap();
        DrawerAdapter drawerAdapter = new DrawerAdapter(absFragment.getContext(), this, this.mModel);
        this.mAdapter = drawerAdapter;
        folderPenRecyclerView.setAdapter(drawerAdapter);
        viewContract.initFolderDataMap();
        setObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteItems() {
        NotesFolder folderData;
        MainLogger.m7254d(getTag(), "deleteItems# " + this.mToBeDeletedUuid);
        if (TextUtils.isEmpty(this.mToBeDeletedUuid) || (folderData = this.mModel.getFolderData(this.mToBeDeletedUuid)) == null) {
            return;
        }
        this.mSelectedUuid = folderData.getParentUuid();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mToBeDeletedUuid);
        FolderDeleteTask folderDeleteTask = new FolderDeleteTask(this.mFragment.getActivity());
        folderDeleteTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.13
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(@NonNull WorkerTask.Result result) {
                FragmentActivity activity = DrawerPresenter.this.mFragment.getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    MainLogger.m7258i(DrawerPresenter.TAG, "folderDeleteTask end# ignore, activity is invalid");
                    return;
                }
                if ((result instanceof FolderDeleteTask.Result) && ((FolderDeleteTask.Result) result).getHasOpenedNote()) {
                    ToastHandler.show(BaseUtils.getContext(), C8003R.string.toast_not_delete_opened_note, 0);
                }
                DrawerModel drawerModel = DrawerPresenter.this.mModel;
                NotesFolder folderData2 = drawerModel.getFolderData(drawerModel.getFolderUuid());
                if (folderData2 == null || FolderConstants.RecycleBin.UUID.equals(folderData2.getParentUuid())) {
                    ((AbsAppCompatActivity) activity).onFolderSelected(FolderConstants.AllNotes.UUID);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(@NotNull WorkerTask<?> workerTask) {
            }
        });
        folderDeleteTask.run(arrayList);
    }

    private DrawerHolder getDrawerHolder(String str) {
        if (this.mRecyclerView != null && !TextUtils.isEmpty(str)) {
            int childCount = this.mRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                FolderPenRecyclerView folderPenRecyclerView = this.mRecyclerView;
                DrawerHolder drawerHolder = (DrawerHolder) folderPenRecyclerView.getChildViewHolder(folderPenRecyclerView.getChildAt(i));
                if (drawerHolder != null && str.equals(drawerHolder.getDrawerHolderInfo().getUuid())) {
                    return drawerHolder;
                }
            }
        }
        return null;
    }

    private void initMap() {
        if (this.mFragment.getActivity() == null) {
            MainLogger.m7255e(getTag(), "initMap failed");
            return;
        }
        FolderWorkerTask folderWorkerTask = new FolderWorkerTask("DrawerInitMap");
        this.mInitFolderWorkerTask = folderWorkerTask;
        folderWorkerTask.setPostCallback(new FolderWorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.11
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.FolderWorkerTask.Callback
            public void onPostExecute(@NonNull FolderWorkerTask.Result result) {
                DataManager.getInstance().restoreFolderExpandState(DrawerPresenter.this.mModel.getFolderDataMap());
                DrawerPresenter.this.updateWaitedObservedMap();
                DrawerPresenter.this.mInitFolderWorkerTask = null;
            }
        });
        this.mInitFolderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.12
            @Override // java.lang.Runnable
            public void run() {
                DrawerPresenter.this.mModel.initFolderMap();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needPostNotifyDataSetChanged() {
        return this.mView.isRunningAnimator() || this.mView.isNoteListScrolling();
    }

    private void openCurrentFolder(String str) {
        NotesFolder folderData = this.mModel.getFolderData(str);
        NotesFolder parent = folderData == null ? null : folderData.getParent();
        List<NotesFolder> drawerDisplayDataList = this.mModel.getDrawerDisplayDataList();
        if (parent != null) {
            openCurrentFolder(parent.getUuid());
            if (parent.hasChild() && !parent.isExpanded() && drawerDisplayDataList != null && !drawerDisplayDataList.isEmpty()) {
                setExpandedStatus(parent.getUuid(), drawerDisplayDataList.indexOf(parent));
            }
        }
        if (folderData != null) {
            if ((folderData.getViewType() != 0 && folderData.getViewType() != 3) || !folderData.hasChild() || folderData.isExpanded() || drawerDisplayDataList == null || drawerDisplayDataList.isEmpty()) {
                return;
            }
            setExpandedStatus(folderData.getUuid(), drawerDisplayDataList.indexOf(folderData));
        }
    }

    private void removeObserver() {
        MainLogger.m7258i(getTag(), "removeObserver");
        LiveData<Map<String, NotesDocumentCountEntry>> liveData = this.mCountLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.mCountObserver);
            this.mCountLiveData = null;
        }
        LiveData<DocumentCategoryTree> liveData2 = this.mFolderLiveData;
        if (liveData2 != null) {
            liveData2.removeObserver(this.mFolderObserver);
            this.mFolderLiveData = null;
        }
        LiveData<List<CoeditMainListEntry>> liveData3 = this.mCoeditLiveData;
        if (liveData3 != null) {
            liveData3.removeObserver(this.mCoeditObserver);
            this.mCoeditLiveData = null;
        }
    }

    private void setObserver() {
        LiveData<Map<String, NotesDocumentCountEntry>> allDocumentCountEntryMap_LiveData;
        MainLogger.m7258i(getTag(), "setObserver");
        try {
            if (this.mCountLiveData == null && (allDocumentCountEntryMap_LiveData = this.mModel.getAllDocumentCountEntryMap_LiveData()) != null) {
                this.mCountLiveData = allDocumentCountEntryMap_LiveData;
            }
            if (this.mFolderLiveData == null) {
                this.mFolderLiveData = FolderManager.getInstance().getAllDocumentCategoryTree_LiveData(true);
            }
            if (this.mCoeditLiveData == null && NotesUtils.isCoeditFeatureEnabled(this.mFragment.getContext())) {
                this.mCoeditLiveData = new C6696j(this.mFragment.getContext(), NotesUtils.getSortParam());
            }
            LiveData<Map<String, NotesDocumentCountEntry>> liveData = this.mCountLiveData;
            if (liveData != null) {
                liveData.observe(this.mFragment.getViewLifecycleOwner(), this.mCountObserver);
            }
            this.mFolderLiveData.observe(this.mFragment.getViewLifecycleOwner(), this.mFolderObserver);
            LiveData<List<CoeditMainListEntry>> liveData2 = this.mCoeditLiveData;
            if (liveData2 != null) {
                liveData2.observe(this.mFragment.getViewLifecycleOwner(), this.mCoeditObserver);
            }
        } catch (IllegalStateException e) {
            MainLogger.m7255e(getTag(), "setObserver# : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAddSubFolderDialog(String str, int i) {
        NotesFolder folderData = this.mModel.getFolderData(str);
        if (folderData == null) {
            return;
        }
        if (folderData.getDepth() >= 50) {
            ToastHandler.show(this.mFragment.getContext(), this.mFragment.getResources().getString(C8003R.string.add_subfolder_max_toast), 0);
            return;
        }
        this.mDataUpdateType = 1;
        FolderNameDialog folderNameDialog = new FolderNameDialog(str, 1, DataManager.getInstance().getFoldersDisplayName(str, this.mModel.getFolderDataMap()));
        folderNameDialog.setAnchorViewId(i);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
        CommonSamsungAnalytics.insertLog("751", "7801");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showChangeColorDialog(String str, int i) {
        NotesFolder folderData = this.mModel.getFolderData(str);
        if (folderData == null) {
            return;
        }
        ChangeColorDialogFragment changeColorDialogFragment = new ChangeColorDialogFragment(new ArrayList(Arrays.asList(str)), folderData.getDisplayNameColor());
        changeColorDialogFragment.setAnchorViewId(i);
        changeColorDialogFragment.setColorConfirmDialogResultListener(this.mColorConfirmDialogResult);
        changeColorDialogFragment.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.CHANGE_COLOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteFolderDialog(String str, int i) {
        this.mDataUpdateType = 5;
        FloatingFeature.Companion companion = FloatingFeature.INSTANCE;
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment(0, companion.getInstance().isDisableRecycleBinModel() ? C8003R.plurals.plurals_permanently_delete_no_cloud_dialog_msg : C8003R.plurals.plurals_move_to_trash_n_folder_dialog_msg, companion.getInstance().isDisableRecycleBinModel() ? C8003R.string.action_delete : C8003R.string.move_to_trash_btn, C8003R.string.cancel_btn, 1, true);
        confirmDialogFragment.setSelectedUuid(str);
        confirmDialogFragment.setAnchorViewId(i);
        confirmDialogFragment.setConfirmDialogResultListener(this.mConfirmResultListener);
        confirmDialogFragment.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.DELETE_FOLDER);
        CommonSamsungAnalytics.insertLog("751", "7807");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRenameFolderDialog(String str, int i) {
        NotesFolder parent;
        this.mDataUpdateType = 2;
        NotesFolder folderData = this.mModel.getFolderData(str);
        if (folderData == null || (parent = this.mModel.getFolderData(str).getParent()) == null) {
            return;
        }
        FolderNameDialog folderNameDialog = new FolderNameDialog(parent.getUuid(), str, folderData.getDisplayName(), 2, DataManager.getInstance().getFoldersDisplayName(parent.getUuid(), this.mModel.getFolderDataMap()), folderData.getDisplayNameColor());
        folderNameDialog.setAnchorViewId(i);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
        CommonSamsungAnalytics.insertLog("751", "7806");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCoeditObserver(List<CoeditMainListEntry> list) {
        int iIndexOfDrawerDisplayData = this.mModel.indexOfDrawerDisplayData(FolderConstants.Coedit.UUID);
        MainLogger.m7258i(getTag(), "[CS9] Coedit LiveData onChanged# coeditCount: " + list.size() + ", coeditIndex: " + iIndexOfDrawerDisplayData);
        if (this.mModel.updateCoeditCountMap(list.size())) {
            this.mAdapter.notifyItemChanged(iIndexOfDrawerDisplayData, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountObserver(Map<String, NotesDocumentCountEntry> map) {
        MainLogger.m7258i(getTag(), "DocumentCount LiveData onChanged# countEntryMap : " + map.size());
        this.mModel.updateAllDocumentCountMap(map);
        this.mView.updateDocumentCountMap(map);
        this.mView.updateNoteViewByDrawerObserver(false);
        this.mView.updateDrawerBar();
        this.mAdapter.notifyDataSetChanged("DocumentCount LiveData onChanged");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFolderObserver(DocumentCategoryTree documentCategoryTree) {
        String tag = getTag();
        StringBuilder sb = new StringBuilder("Drawer LiveData onChanged# childCount : ");
        sb.append(documentCategoryTree.getFolderCount());
        sb.append(", DataUpdateType : ");
        AbstractC8014b.m7212n(sb, tag, this.mDataUpdateType);
        this.mModel.updateDrawerData(documentCategoryTree);
        NotesFolder folderData = this.mModel.getFolderData(this.mSelectedUuid);
        this.mSelectedUuid = null;
        List<NotesFolder> drawerDisplayDataList = this.mModel.getDrawerDisplayDataList();
        if (folderData == null || drawerDisplayDataList == null) {
            this.mAdapter.notifyDataSetChanged("Drawer LiveData onChanged");
            this.mView.updateNoteViewByDrawerObserver(false);
            this.mView.updateDrawerBar();
            return;
        }
        int iIndexOf = drawerDisplayDataList.indexOf(folderData);
        int i = this.mDataUpdateType;
        if (i == 1) {
            if (folderData.isExpanded()) {
                iIndexOf += folderData.getChildren().size() + 1;
                this.mAdapter.notifyItemInserted(iIndexOf);
            } else {
                setExpandedStatus(folderData.getUuid(), iIndexOf);
            }
            AbstractC8014b.m7201c(iIndexOf, "Drawer LiveData onChanged# add position : ", getTag());
        } else if (i == 2) {
            this.mAdapter.notifyItemChanged(iIndexOf);
            AbstractC8014b.m7201c(iIndexOf, "Drawer LiveData onChanged# rename position : ", getTag());
        } else if (i != 5) {
            this.mAdapter.notifyDataSetChanged("Drawer LiveData onChanged");
        } else {
            int size = folderData.getChildren().size();
            this.mAdapter.notifyItemChanged(iIndexOf, 0);
            this.mAdapter.notifyItemRangeChanged(iIndexOf + 1, size);
            this.mAdapter.notifyItemChanged(this.mModel.indexOfDrawerDisplayData(FolderConstants.RecycleBin.UUID));
            this.mToBeDeletedUuid = null;
            AbstractC8014b.m7200b(iIndexOf, size, "Drawer LiveData onChanged# delete position : ", ", itemCount : ", getTag());
        }
        this.mView.updateNoteViewByDrawerObserver(false);
        this.mView.updateDrawerBar();
    }

    public void addSALog(int i) {
        if (i == 1) {
            CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_SCREEN_OFF_MEMO);
            CommonSamsungAnalytics.insertLog("202");
            return;
        }
        if (i == 3) {
            CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_FOLDER_EXPAND_COLLAPSE);
            CommonSamsungAnalytics.insertLog("201");
            return;
        }
        if (i == 5) {
            CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_MANAGE_FOLDERS);
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS);
            return;
        }
        switch (i) {
            case 1001:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_NOTESLIST_SETTINGS);
                CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_SETTINGS);
                break;
            case 1002:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_ALL_NOTES);
                CommonSamsungAnalytics.insertLog("101");
                break;
            case 1003:
                CommonSamsungAnalytics.insertLog("103", "1311");
                break;
            case 1004:
                CommonSamsungAnalytics.insertLog("103", "1101");
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_FAVORITES);
                break;
            case 1005:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_LOCKED_NOTE);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_LOCKED_NOTES);
                break;
            case 1006:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_RECENTLY_IMPORTED);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_RECENTLY_IMPORTED);
                break;
            case 1007:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_SHARED_NOTEBOOKS);
                break;
            case 1008:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_SHARED_NOTEBOOKS);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN);
                break;
            case 1009:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_RECYCLEBIN);
                CommonSamsungAnalytics.insertLog("531");
                break;
            default:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_SELECT_FOLDER);
                CommonSamsungAnalytics.insertLog("201");
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public String getFolderUuid() {
        return this.mModel.getFolderUuid();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public DrawerModel getModel() {
        return this.mModel;
    }

    public String getPrevFolderUuid() {
        return this.mModel.getPrevFolderUuid();
    }

    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public boolean isFreeFormWindow() {
        return this.mView.isFreeFormWindow();
    }

    public void msSyncChanged() {
        this.mAdapter.notifyDataSetChanged("msSyncChanged");
    }

    public void onDestroyView() {
        removeObserver();
    }

    public void onFolderDeleteVerifySuccess() {
        deleteItems();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public void onFolderSelected(FolderHolderInfo folderHolderInfo, int i, boolean z) {
        Resources resources;
        int i2;
        NotesFolder drawerDisplayData = this.mModel.getDrawerDisplayData(i);
        if (drawerDisplayData == null) {
            return;
        }
        if (z || !folderHolderInfo.hasChild()) {
            MainLogger.m7258i(getTag(), "onFolderSelected# uuid : " + folderHolderInfo.getUuid());
            addSALog(folderHolderInfo.getViewType());
            this.mView.onFolderSelected(folderHolderInfo.getUuid(), folderHolderInfo.getViewType());
            return;
        }
        View iconLayout = folderHolderInfo.getIconLayout();
        if (drawerDisplayData.isExpanded()) {
            resources = this.mFragment.getContext().getResources();
            i2 = C8003R.string.collapse;
        } else {
            resources = this.mFragment.getContext().getResources();
            i2 = C8003R.string.expand;
        }
        iconLayout.announceForAccessibility(resources.getString(i2));
        setExpandedStatus(folderHolderInfo.getUuid(), i);
    }

    public void onFoldersDataMove(final ArrayList<String> arrayList, final String str) {
        MainLogger.m7258i(getTag(), "onFoldersDataMove# checkedFolderUuidList count : " + arrayList.size() + " toParentUuid : " + str);
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        if (FolderConstants.RecycleBin.UUID.equals(str)) {
            new FolderDeleteTask(activity).run(arrayList);
            return;
        }
        final int[] iArr = {0};
        final int[] iArr2 = {0};
        FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderMove");
        folderWorkerTask.setPostCallback(new FolderWorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.15
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.FolderWorkerTask.Callback
            public void onPostExecute(@NonNull FolderWorkerTask.Result result) {
                String tag = DrawerPresenter.this.getTag();
                StringBuilder sb = new StringBuilder("onFoldersDataMove# moveCount : ");
                sb.append(iArr[0]);
                sb.append(" failCount : ");
                AbstractC8014b.m7212n(sb, tag, iArr2[0]);
                if (iArr2[0] > 0) {
                    ToastHandler.show(DrawerPresenter.this.mFragment.getContext(), DrawerPresenter.this.mFragment.getContext().getResources().getString(C8003R.string.add_subfolder_max_toast), 0);
                }
            }
        });
        folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.16
            @Override // java.lang.Runnable
            public void run() {
                NotesFolder folderData = DrawerPresenter.this.mModel.getFolderData(str);
                for (String str2 : arrayList) {
                    NotesFolder folderData2 = DrawerPresenter.this.mModel.getFolderData(str2);
                    if (!str2.equals(str) && folderData2 != null && !folderData2.getParent().getUuid().equals(str)) {
                        if ((folderData.getDepth() + DataManager.getMaximumFolderDepth(folderData2)) - folderData2.getDepth() >= 50) {
                            int[] iArr3 = iArr2;
                            iArr3[0] = iArr3[0] + 1;
                        } else {
                            try {
                                if (FolderManager.getInstance().move(str2, str)) {
                                    int[] iArr4 = iArr;
                                    iArr4[0] = iArr4[0] + 1;
                                }
                            } catch (InvalidParentFolderException e) {
                                MainLogger.m7255e(DrawerPresenter.this.getTag(), "onFoldersDataMove# : " + e.getMessage());
                            }
                        }
                    }
                }
            }
        }));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public void onItemLongPressed(FolderHolderInfo folderHolderInfo) {
        final String uuid = folderHolderInfo.getUuid();
        MainLogger.m7258i(getTag(), "onItemLongPressed " + uuid);
        if (FolderUtils.isStaticFolder(uuid)) {
            return;
        }
        final View anchorView = AnchorViewUtils.getAnchorView(this.mRecyclerView, (ViewGroup) folderHolderInfo.getTouchedView(), folderHolderInfo.getTouchPos()[0], folderHolderInfo.getTouchPos()[1]);
        PopupMenu popupMenu = new PopupMenu(anchorView.getContext(), anchorView, 8388611);
        this.mFragment.getActivity().getMenuInflater().inflate(C8003R.menu.drawer_popup_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        if (FolderConstants.MyFolders.UUID.equals(uuid)) {
            menu.removeItem(C8003R.id.rename);
            menu.removeItem(C8003R.id.delete);
            menu.removeItem(C8003R.id.change_color);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.presenter.DrawerPresenter.14
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == C8003R.id.create) {
                    DrawerPresenter.this.showAddSubFolderDialog(uuid, anchorView.getId());
                    return false;
                }
                if (itemId == C8003R.id.rename) {
                    DrawerPresenter.this.showRenameFolderDialog(uuid, anchorView.getId());
                    return false;
                }
                if (itemId == C8003R.id.delete) {
                    DrawerPresenter.this.showDeleteFolderDialog(uuid, anchorView.getId());
                    return false;
                }
                if (itemId != C8003R.id.change_color) {
                    return false;
                }
                DrawerPresenter.this.showChangeColorDialog(uuid, anchorView.getId());
                return false;
            }
        });
        popupMenu.show();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        FragmentManager childFragmentManager = this.mFragment.getChildFragmentManager();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.FOLDER_NAME);
        if (fragmentFindFragmentByTag != null) {
            ((NameDialogFragment) fragmentFindFragmentByTag).setEditDialogResultListener(this.mEditDialogResultListener);
        }
        Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.DELETE_FOLDER);
        if (fragmentFindFragmentByTag2 != null) {
            ((ConfirmDialogFragment) fragmentFindFragmentByTag2).setConfirmDialogResultListener(this.mConfirmResultListener);
        }
        Fragment fragmentFindFragmentByTag3 = childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.CHANGE_COLOR);
        if (fragmentFindFragmentByTag3 != null) {
            ((ChangeColorDialogFragment) fragmentFindFragmentByTag3).setColorConfirmDialogResultListener(this.mColorConfirmDialogResult);
        }
        setFolderUuid(bundle.getString(NotesConstants.KEY_FOLDER_UUID, NotesUtils.getLastSelectedFolder()));
        this.mDataUpdateType = bundle.getInt(NotesConstants.KEY_DATA_UPDATE_TYPE);
        this.mToBeDeletedUuid = bundle.getString(NotesConstants.KEY_FOLDER_UUID);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(NotesConstants.KEY_DATA_UPDATE_TYPE, this.mDataUpdateType);
        bundle.putString(NotesConstants.KEY_FOLDER_UUID, this.mToBeDeletedUuid);
        bundle.putString(NotesConstants.KEY_FOLDER_UUID, getFolderUuid());
    }

    public void registerSharedPreferenceListener() {
        SharedPreferencesCompat.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mSettingSharedPreferenceChangeListener);
        BadgeHelper.registerSettingBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
        BadgeHelper.registerCoeditBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
        BadgeHelper.registerGCSDrawerBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
        BadgeHelper.registerSOMBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
    }

    public void saveArguments(Bundle bundle) {
        if (bundle == null) {
            MainLogger.m7255e(getTag(), "saveArguments# arguments is null");
        } else {
            setFolderUuid(bundle.getString(NotesConstants.KEY_FOLDER_UUID, NotesUtils.getLastSelectedFolder()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public void setDragListener(DrawerHolder drawerHolder) {
    }

    public void setDrawerTitleBold(String str) {
        if (this.mRecyclerView == null) {
            return;
        }
        setFolderUuid(str);
        int i = 0;
        while (true) {
            if (i > 1) {
                return;
            }
            DrawerHolder drawerHolder = (DrawerHolder) this.mRecyclerView.findViewHolderForAdapterPosition(getModel().indexOfDrawerDisplayData(i == 0 ? getPrevFolderUuid() : getFolderUuid()));
            if (drawerHolder != null) {
                drawerHolder.applyHighlightSelectedHolder(i != 0);
            }
            i++;
        }
    }

    public void setExpandedStatus(String str, int i) {
        NotesFolder drawerDisplayData = this.mModel.getDrawerDisplayData(i);
        if (drawerDisplayData == null) {
            return;
        }
        boolean zIsExpanded = drawerDisplayData.isExpanded();
        DrawerHolder drawerHolder = getDrawerHolder(str);
        if (drawerHolder != null) {
            FolderHolderInfo drawerHolderInfo = drawerHolder.getDrawerHolderInfo();
            if (drawerHolderInfo != null) {
                drawerHolderInfo.setArrowExpanded(zIsExpanded, str);
            }
            if (FolderConstants.MyFolders.UUID.equals(str)) {
                this.mAdapter.notifyItemChanged(i, 3);
            }
        }
        if (zIsExpanded) {
            int iCollapseDrawerDisplayData = this.mModel.collapseDrawerDisplayData(drawerDisplayData);
            int i2 = i + 1;
            this.mAdapter.notifyItemRangeRemoved(i2, iCollapseDrawerDisplayData);
            MainLogger.m7254d(getTag(), "setExpandedStatus# collapse position : " + i2 + ", itemCount : " + iCollapseDrawerDisplayData);
        } else {
            int i4 = i + 1;
            int iExpandedDrawerDisplayData = this.mModel.expandedDrawerDisplayData(str, i4);
            this.mAdapter.notifyItemRangeInserted(i4, iExpandedDrawerDisplayData);
            this.mRecyclerView.smoothScrollToPositionForDrawer(i4);
            MainLogger.m7254d(getTag(), "setExpandedStatus# expand position : " + i4 + ", itemCount : " + iExpandedDrawerDisplayData);
        }
        drawerDisplayData.setExpanded(!zIsExpanded);
        this.mModel.updateFolderData(drawerDisplayData);
    }

    public void setFolderUuid(String str) {
        this.mModel.setFolderUuid(str);
        openCurrentFolder(str);
    }

    public void setModel() {
        this.mModel = new DrawerModel();
    }

    public void setPostNotifyDataSetChanged() {
        MainLogger.m7258i(TAG, "setPostNotifyDataSetChanged");
        this.mHandler.removeCallbacks(this.mReattachObserverRunnable);
        this.mHandler.postDelayed(this.mReattachObserverRunnable, 500L);
    }

    public void unregisterSharedPreferenceListener() {
        SharedPreferencesCompat.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mSettingSharedPreferenceChangeListener);
        this.mSettingSharedPreferenceChangeListener = null;
        BadgeHelper.unregisterSettingBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
        BadgeHelper.unregisterCoeditBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
        BadgeHelper.unregisterGCSDrawerBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
        BadgeHelper.unregisterSOMBadgeChangeListener(this.mBadgeSharedPreferenceChangeListener);
        this.mBadgeSharedPreferenceChangeListener = null;
    }

    public void updateBadge(String str) {
        int iIndexOfDrawerDisplayData = this.mModel.indexOfDrawerDisplayData(str);
        if (iIndexOfDrawerDisplayData < 0 || iIndexOfDrawerDisplayData >= this.mAdapter.getItemCount()) {
            return;
        }
        this.mAdapter.notifyItemChanged(iIndexOfDrawerDisplayData, 3);
    }

    public void updateDrawerDisplayData() {
        MainLogger.m7258i(getTag(), "updateDrawerDisplayData");
        if (this.mRecyclerView.isComputingLayout()) {
            this.mRecyclerView.post(this.mUpdateDrawerDisplayDataRunnable);
        } else {
            this.mUpdateDrawerDisplayDataRunnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public void updateNewBadge() {
        this.mView.updateNewBadge();
    }

    public void updateWaitedObservedMap() {
        DocumentCategoryTree documentCategoryTreeDequeueWaitedCategoryObservedMap = this.mModel.dequeueWaitedCategoryObservedMap();
        if (documentCategoryTreeDequeueWaitedCategoryObservedMap != null) {
            updateFolderObserver(documentCategoryTreeDequeueWaitedCategoryObservedMap);
        }
        Map<String, NotesDocumentCountEntry> mapDequeueWaitedCountObservedMap = this.mModel.dequeueWaitedCountObservedMap();
        if (mapDequeueWaitedCountObservedMap != null) {
            updateCountObserver(mapDequeueWaitedCountObservedMap);
        }
        List<CoeditMainListEntry> listDequeueWaitedCoeditObservedMap = this.mModel.dequeueWaitedCoeditObservedMap();
        if (listDequeueWaitedCoeditObservedMap != null) {
            updateCoeditObserver(listDequeueWaitedCoeditObservedMap);
        }
        this.mModel.clearWaitedObservedMap();
    }
}
