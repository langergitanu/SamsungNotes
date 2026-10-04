package com.samsung.android.support.senl.p148nt.app.main.folder.presenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.microsoft.graph.RunnableC6781c;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderDeleteTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderWorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderAdapter;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.DialogManager;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.LockHelper;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.RecyclerViewHelper;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.controller.ReorderItemController;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderPresenter extends DataMapper implements AdapterContract {
    private static final String TAG = "FolderPresenter";
    private final DialogContract mDialogCreator;
    private final ObjectBuilder<DialogManager> mDialogManager;
    private LiveData<DocumentCategoryTree> mDisplayFolderTree;
    private final AbsFragment mFragment;
    private final ViewContract.IFragment mFragmentContract;
    private final FolderPenRecyclerView mRecyclerView;
    private final ObjectBuilder<ReorderItemController> mReorderItemController;
    private int mDataUpdateType = -1;
    private final Observer<DocumentCategoryTree> mFoldersObserver = new Observer<DocumentCategoryTree>() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.1
        @Override // androidx.lifecycle.Observer
        @SuppressLint({"NotifyDataSetChanged"})
        public void onChanged(DocumentCategoryTree documentCategoryTree) {
            if (FolderPresenter.this.mDataUpdateType == 9) {
                FolderPresenter.this.mFolderModel.setNeedDataChange(true);
                return;
            }
            FolderPresenter.this.mFolderModel.setNeedDataChange(false);
            if (FolderPresenter.this.mRecyclerView.getAdapter() == null) {
                FolderPresenter.this.mRecyclerView.setAdapter(FolderPresenter.this.mFolderAdapter);
            }
            MainLogger.m7258i(FolderPresenter.TAG, "Folder LiveData onChanged# " + documentCategoryTree.getFolderCount() + ", DataUpdateType : " + FolderPresenter.this.mDataUpdateType);
            FolderPresenter.this.mFolderModel.updateFolderDataMap(documentCategoryTree.getFolderMap());
            FolderPresenter.this.removeDeletedCheckedItem();
            FolderPresenter folderPresenter = FolderPresenter.this;
            folderPresenter.attachAddFolderItem(FeatureUtils.isNeedAddFolder(folderPresenter.mFragmentContract.getModeIndex()), FolderPresenter.this.mFragmentContract.getModeIndex() == 3);
            FolderModel folderModel = FolderPresenter.this.mFolderModel;
            NotesFolder folderData = folderModel.getFolderData(folderModel.getSelectedUuid());
            FolderPresenter.this.mFolderModel.setSelectedUuid(null);
            if (folderData == null) {
                FolderPresenter.this.clearAnimateItems();
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange");
                FolderPresenter.this.mFragmentContract.onDataChanged(documentCategoryTree.getFolderCount());
                return;
            }
            int iIndexOf = FolderPresenter.this.mFolderModel.getFolderDisplayDataList().indexOf(folderData);
            int i = FolderPresenter.this.mDataUpdateType;
            if (i == 1) {
                if (!folderData.isExpanded()) {
                    FolderPresenter.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf);
                }
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange - ADD");
                FolderPresenter.this.mRecyclerView.smoothScrollToPosition(FolderPresenter.this.mFolderModel.getPositionExpandedFolderCount(folderData.getChildren(), FolderPresenter.this.mFolderModel.getNewUuid()) + iIndexOf);
                AbstractC8014b.m7201c(iIndexOf, "Folder LiveData onChange# add position : ", FolderPresenter.TAG);
            } else if (i == 2) {
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange - RENAME");
                MainLogger.m7258i(FolderPresenter.TAG, "Folder LiveData onChange# rename position : " + iIndexOf);
            } else if (i == 3) {
                if (!folderData.isExpanded()) {
                    FolderPresenter.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf);
                }
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange - ADD MYFOLDER");
                FolderPresenter.this.mRecyclerView.scrollToBottom();
            } else if (i == 4) {
                FolderPresenter.this.mFragmentContract.getMode().onBackKeyDown();
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange - MOVE");
            } else if (i == 5) {
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange - DELETE");
            } else if (i != 10) {
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange - default");
            } else {
                if (!folderData.isExpanded()) {
                    FolderPresenter.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf);
                }
                FolderPresenter.this.mFolderAdapter.notifyDataSetChanged("Folder LiveData onChange - REORDER");
            }
            if (FolderPresenter.this.mDataUpdateType != 10) {
                FolderPresenter.this.clearAnimateItems();
            }
            FolderPresenter.this.mFragmentContract.onDataChanged(documentCategoryTree.getFolderCount());
            FolderPresenter.this.mDataUpdateType = -1;
            FolderPresenter.this.mFolderModel.setNewUuid(null);
        }
    };
    private final ObjectBuilder<LockHelper> mLockHelper = new ObjectBuilder<LockHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public LockHelper build() {
            return new LockHelper(new LockHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.2.1
                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.LockHelper.IPresenter
                public void onFolderDeleteVerifySuccess() {
                    FolderPresenter.this.mDataUpdateType = 5;
                    FolderPresenter folderPresenter = FolderPresenter.this;
                    folderPresenter.deleteFolderData(folderPresenter.getDeleteFolderList());
                }
            });
        }
    };
    private final ObjectBuilder<RecyclerViewHelper> mRecyclerViewHelper = new ObjectBuilder<RecyclerViewHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public RecyclerViewHelper build() {
            return new RecyclerViewHelper(FolderPresenter.this.mFragment.getActivity(), FolderPresenter.this.mRecyclerView, FolderPresenter.this.mFolderModel, new RecyclerViewHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.3.1
                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public int getModeIndex() {
                    return FolderPresenter.this.mFragmentContract.getModeIndex();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public void initializeDragAndDrop(boolean z) {
                    FolderPresenter.this.mFolderMoveMap.clearDimStatusItems();
                    if (3 == getModeIndex()) {
                        FolderPresenter folderPresenter = FolderPresenter.this;
                        folderPresenter.addDimStatusItem(folderPresenter.mFolderModel.getFolderData("addFolder:///"));
                    }
                    if (z) {
                        return;
                    }
                    FolderPresenter.this.onReplaceCheckedItems();
                    for (String str : FolderPresenter.this.getCheckedRootItemUuidList()) {
                        FolderPresenter folderPresenter2 = FolderPresenter.this;
                        folderPresenter2.addDimStatusItem(folderPresenter2.mFolderModel.getFolderData(str));
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public boolean isCheckedItem(String str) {
                    return FolderPresenter.this.isCheckedItem(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public boolean isDimItem(String str) {
                    return FolderPresenter.this.isDimItem(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public void setExpandedStatus(boolean z, String str, int i) {
                    FolderPresenter.this.setExpandedStatus(z, str, i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public boolean setMode(int i) {
                    return FolderPresenter.this.mFragmentContract.setMode(i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public void showBottomNavigation() {
                    FolderPresenter.this.mFragmentContract.getMode().showBottomNavigation();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public void showMoveFolderConfirmDialog(String str, int i) {
                    ((DialogManager) FolderPresenter.this.mDialogManager.getInstance()).showMoveFolderConfirmDialog(str, FolderPresenter.this.getSelectedItemCount(), i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.RecyclerViewHelper.IPresenter
                public void toggleCheckBox(String str, boolean z) {
                    FolderPresenter.this.toggleCheckBox(str, z);
                }
            });
        }
    };

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C82725 extends ObjectBuilder<DialogManager> {
        public C82725() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public DialogManager build() {
            AbsFragment absFragment = FolderPresenter.this.mFragment;
            FolderPresenter folderPresenter = FolderPresenter.this;
            return new DialogManager(absFragment, folderPresenter.mFolderModel, folderPresenter.mDialogCreator, new DialogManager.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.5.1
                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.IPresenter
                public void onBackKeyDown() {
                    FolderPresenter.this.mFragmentContract.getMode().onBackKeyDown();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.IPresenter
                public void onColorConfirm(final ArrayList<String> arrayList, final int i) {
                    if (CommonUtil.isNotAvailableActivity(FolderPresenter.this.mFragment.getActivity())) {
                        MainLogger.m7258i(FolderPresenter.TAG, "onColorConfirm isNotAvailableActivity");
                    } else {
                        new FolderWorkerTask("ColorChange").run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.5.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                FolderPresenter.this.mDataUpdateType = 11;
                                FolderPresenter.this.mFolderModel.changeColorData(arrayList, i);
                            }
                        }));
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.IPresenter
                public void onDeleteCancel() {
                    if (FolderPresenter.this.getDeleteFolderList().size() > 1) {
                        NotesSamsungAnalytics.insertLog("707", "7081");
                    } else {
                        NotesSamsungAnalytics.insertLog("707", "7071");
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.IPresenter
                public void onDeleteConfirm(String str) {
                    FolderPresenter.this.mDataUpdateType = 5;
                    FolderPresenter.this.mFolderModel.setToBeDeletedUuid(str);
                    ArrayList deleteFolderList = FolderPresenter.this.getDeleteFolderList();
                    if (deleteFolderList.size() > 1) {
                        NotesSamsungAnalytics.insertLog("707", "7082");
                    } else {
                        NotesSamsungAnalytics.insertLog("707", "7072");
                    }
                    Iterator it = deleteFolderList.iterator();
                    while (it.hasNext()) {
                        if (FolderPresenter.this.mFolderModel.hasLockedNoteInsideFolder((String) it.next(), true)) {
                            ((LockHelper) FolderPresenter.this.mLockHelper.getInstance()).verifyForDelete(FolderPresenter.this.mFragment.getActivity());
                            return;
                        }
                    }
                    FolderPresenter.this.deleteFolderData(deleteFolderList);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.IPresenter
                public void onEditDialogResult(final int i, final String str, final String str2, final int i2) {
                    MainLogger.m7258i(FolderPresenter.TAG, "onEditDialogResult# folderName : " + MainLogger.getEncode(str2) + ", selectedUuid : " + str + ", dialogType : " + i + ", markColor : " + i2);
                    if (CommonUtil.isNotAvailableActivity(FolderPresenter.this.mFragment.getActivity())) {
                        MainLogger.m7258i(FolderPresenter.TAG, "onEditDialogResult isNotAvailableActivity");
                        return;
                    }
                    final FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderEdit");
                    folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.5.1.4
                        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                        public void onEnd(@NonNull WorkerTask.Result result) {
                            if (!folderWorkerTask.getTaskResult().getMSuccess()) {
                                ToastHandler.show(FolderPresenter.this.mFragment.getContext(), C8003R.string.folder_already_in_use, 0);
                            }
                            FolderPresenter.this.mFragmentContract.getMode().onBackKeyDown();
                        }

                        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                        public void onStart(@NonNull WorkerTask<?> workerTask) {
                            folderWorkerTask.getTaskResult().setSuccess(true);
                        }
                    });
                    folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.5.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            int i4 = i;
                            String parentUuid = (i4 == 1 || i4 == 3) ? str : FolderPresenter.this.mFolderModel.getParentUuid(str);
                            if (FolderModel.isExistFolderName(FolderPresenter.this.mFragment.getContext(), str2, parentUuid, DataManager.getInstance().getFoldersDisplayName(parentUuid, FolderPresenter.this.mFolderModel.getFolderDataMap()), true)) {
                                folderWorkerTask.getTaskResult().setSuccess(false);
                                return;
                            }
                            FolderPresenter.this.mDataUpdateType = i;
                            FolderPresenter.this.mFolderModel.setSelectedUuid(str);
                            int i5 = i;
                            if (i5 != 1 && i5 != 3) {
                                FolderPresenter.this.mFolderModel.renameFolderData(str, str2, i2);
                            } else {
                                FolderModel folderModel = FolderPresenter.this.mFolderModel;
                                folderModel.setNewUuid(folderModel.addFolderData(str, str2, i2));
                            }
                        }
                    }));
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.IPresenter
                public void onMoveConfirm(final String str) {
                    if (CommonUtil.isNotAvailableActivity(FolderPresenter.this.mFragment.getActivity())) {
                        MainLogger.m7258i(FolderPresenter.TAG, "onMoveConfirm isNotAvailableActivity");
                        return;
                    }
                    final int[] iArr = new int[1];
                    FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderMove");
                    folderWorkerTask.setPostCallback(new FolderWorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.5.1.1
                        @Override // com.samsung.android.support.senl.nt.app.main.common.task.FolderWorkerTask.Callback
                        public void onPostExecute(@NonNull FolderWorkerTask.Result result) {
                            if (iArr[0] == 2) {
                                ToastHandler.show(FolderPresenter.this.mFragment.getContext(), FolderPresenter.this.mFragment.getContext().getResources().getString(C8003R.string.add_subfolder_max_toast), 0);
                            }
                        }
                    });
                    folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.5.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FolderPresenter.this.mFolderModel.setSelectedUuid(str);
                            FolderPresenter.this.mDataUpdateType = 4;
                            int[] iArr2 = iArr;
                            FolderPresenter folderPresenter2 = FolderPresenter.this;
                            iArr2[0] = folderPresenter2.mFolderModel.moveFolderData(folderPresenter2.getCheckedRootItemUuidList(), str);
                        }
                    }));
                }

                @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.IPresenter
                public void onPickConfirm(String str) {
                    FolderPresenter.this.mFolderModel.setSelectedUuid(str);
                    FolderPresenter.this.mDataUpdateType = 4;
                }
            });
        }
    }

    public FolderPresenter(AbsFragment absFragment, FolderPenRecyclerView folderPenRecyclerView, ViewContract.IFragment iFragment, DialogContract dialogContract, int i) {
        ObjectBuilder<ReorderItemController> objectBuilder = new ObjectBuilder<ReorderItemController>() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
            public ReorderItemController build() {
                FolderPenRecyclerView folderPenRecyclerView2 = FolderPresenter.this.mRecyclerView;
                FolderPresenter folderPresenter = FolderPresenter.this;
                return new ReorderItemController(folderPenRecyclerView2, folderPresenter.mFolderModel, folderPresenter.mFragment.getContext(), new ReorderItemController.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.4.1
                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public void attachAddFolderItem() {
                        FolderPresenter folderPresenter2 = FolderPresenter.this;
                        folderPresenter2.attachAddFolderItem(FeatureUtils.isNeedAddFolder(folderPresenter2.mFragmentContract.getModeIndex()), FolderPresenter.this.mFragmentContract.getModeIndex() == 3);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public int getDataUpdateType() {
                        return FolderPresenter.this.mDataUpdateType;
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public boolean isCheckedItem(String str) {
                        return FolderPresenter.this.isCheckedItem(str);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public boolean isSkippedDataSetChanged() {
                        if (FolderPresenter.this.mFolderModel.isNeedDataChange()) {
                            MainLogger.m7255e(FolderPresenter.TAG, "isSkippedDataSetChanged");
                            FolderPresenter.this.mDisplayFolderTree.removeObserver(FolderPresenter.this.mFoldersObserver);
                            try {
                                FolderPresenter.this.mDisplayFolderTree.observe(FolderPresenter.this.mFragment.getViewLifecycleOwner(), FolderPresenter.this.mFoldersObserver);
                            } catch (IllegalStateException e) {
                                MainLogger.m7255e(FolderPresenter.TAG, "reattach Observe : " + e.getMessage());
                            }
                        }
                        return FolderPresenter.this.mFolderModel.isNeedDataChange();
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public void setDataUpdateType(int i2) {
                        FolderPresenter.this.mDataUpdateType = i2;
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public void setExpandedStatus(boolean z, String str, int i2) {
                        FolderPresenter.this.setExpandedStatus(z, str, i2);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public void setSelectedUuid(String str) {
                        FolderPresenter.this.mFolderModel.setSelectedUuid(str);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.Contract
                    public void setToScrollUuid(String str) {
                        FolderPresenter.this.addAnimateItem(str);
                    }
                }, FolderPresenter.this.mFolderAdapter);
            }
        };
        this.mReorderItemController = objectBuilder;
        this.mDialogManager = new C82725();
        this.mFragment = absFragment;
        this.mFragmentContract = iFragment;
        this.mRecyclerView = folderPenRecyclerView;
        this.mDialogCreator = dialogContract;
        this.mFolderAdapter = new FolderAdapter(absFragment.getContext(), this, this.mFolderModel);
        if (i == 4) {
            this.mFolderModel.restoreFolderMsSyncExpandState();
        } else {
            DataManager.getInstance().restoreFolderExpandState(this.mFolderModel.getFolderDataMap());
        }
        if (objectBuilder.getInstance() == null) {
            return;
        }
        objectBuilder.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteFolderData(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            MainLogger.m7258i(TAG, "deleteFolderData# fail, folder Uuids is invalid");
            return;
        }
        MainLogger.m7258i(TAG, "deleteFolderData# " + arrayList.size());
        FolderDeleteTask folderDeleteTask = new FolderDeleteTask(this.mFragment.getActivity());
        folderDeleteTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.7
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(@NonNull WorkerTask.Result result) {
                FragmentActivity activity = FolderPresenter.this.mFragment.getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    MainLogger.m7258i(FolderPresenter.TAG, "folderDeleteTask end# ignore, activity is invalid");
                    return;
                }
                if ((result instanceof FolderDeleteTask.Result) && ((FolderDeleteTask.Result) result).getHasOpenedNote()) {
                    ToastHandler.show(BaseUtils.getContext(), C8003R.string.toast_not_delete_opened_note, 0);
                }
                FolderPresenter.this.mFragmentContract.getMode().onBackKeyDown();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(@NonNull WorkerTask<?> workerTask) {
            }
        });
        folderDeleteTask.run(arrayList);
    }

    @Nullable
    private List<NotesFolder> getChildFolders(String str) {
        NotesFolder folderData = getFolderData(str);
        if (folderData == null) {
            return null;
        }
        return folderData.getChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> getDeleteFolderList() {
        if (TextUtils.isEmpty(this.mFolderModel.getToBeDeletedUuid())) {
            return getCheckedItemUuidList();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.mFolderModel.getToBeDeletedUuid());
        return arrayList;
    }

    private FolderHolder getFolderHolder(String str) {
        return this.mRecyclerViewHelper.getInstance().getFolderHolder(str);
    }

    private void removeCheckedChild(String str) {
        List<NotesFolder> childFolders = getChildFolders(str);
        if (childFolders == null) {
            return;
        }
        for (NotesFolder notesFolder : childFolders) {
            removeCheckedItem(notesFolder.getUuid());
            removeCheckedChild(notesFolder.getUuid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDeletedCheckedItem() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.mFolderCheckMap.getCheckedItemUuidList()) {
            if (this.mFolderModel.isDeletedFolder(str)) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeCheckedItem((String) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleCheckBox(String str, boolean z) {
        if (z) {
            addCheckedItem(str);
        } else {
            removeCheckedItem(str);
        }
        this.mFragmentContract.getMode().updateSelectedFolderCount(getSelectedItemCount() == getFolderCount() - getDimFolderCount(), getSelectedItemCount());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public String getFolderUuid() {
        return FolderConstants.AllNotes.UUID;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public int getLayoutMode() {
        return this.mRecyclerView.getLayoutMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public int getModeIndex() {
        return this.mFragmentContract.getModeIndex();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean isDimItem(String str) {
        return this.mFragmentContract.getMode().isDimItem(str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mLockHelper.getInstance().onActivityResultFromLockManager((AppCompatActivity) this.mFragment.getActivity(), i, i2, intent);
    }

    public void onDestroy() {
        saveFolderExpandState();
        if (this.mRecyclerViewHelper.isValid()) {
            this.mRecyclerViewHelper.getInstance().release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void onFolderSelected(FolderHolderInfo folderHolderInfo, int i, boolean z) {
        Resources resources;
        int i2;
        if (folderHolderInfo == null) {
            return;
        }
        this.mFolderModel.setSelectedUuid(folderHolderInfo.getUuid());
        if (!folderHolderInfo.hasChild() || z) {
            if (folderHolderInfo.getFolderItemContainer().isEnabled()) {
                if (this.mFragmentContract.getMode().onFolderSelected(folderHolderInfo, folderHolderInfo.getViewType())) {
                    if (this.mFragmentContract.getModeIndex() == 3) {
                        this.mRecyclerViewHelper.getInstance().toggleCheckBox(folderHolderInfo, !folderHolderInfo.getCheckBox().isChecked());
                    } else if (this.mFragmentContract.getModeIndex() == 4) {
                        toggleFolderSyncSwitch(folderHolderInfo);
                    }
                }
                this.mRecyclerView.smoothScrollToPositionForDrawer(i);
                return;
            }
            return;
        }
        NotesFolder folderDisplayData = this.mFolderModel.getFolderDisplayData(i);
        if (this.mFragmentContract.getModeIndex() == 3 && FolderConstants.MyFolders.UUID.equals(folderDisplayData.getUuid())) {
            return;
        }
        View iconLayout = folderHolderInfo.getIconLayout();
        if (folderDisplayData.isExpanded()) {
            resources = this.mFragment.getContext().getResources();
            i2 = C8003R.string.collapse;
        } else {
            resources = this.mFragment.getContext().getResources();
            i2 = C8003R.string.expand;
        }
        iconLayout.announceForAccessibility(resources.getString(i2));
        setExpandedStatus(folderDisplayData.isExpanded(), folderHolderInfo.getUuid(), i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean onItemLongPressed(FolderHolderInfo folderHolderInfo) {
        this.mDataUpdateType = -1;
        if (folderHolderInfo == null) {
            return false;
        }
        int modeIndex = this.mFragmentContract.getModeIndex();
        if (!this.mFragmentContract.getMode().onItemLongPressed(folderHolderInfo.getViewType())) {
            return false;
        }
        int modeIndex2 = this.mFragmentContract.getModeIndex();
        String uuid = folderHolderInfo.getUuid();
        if (!isCheckedItem(uuid)) {
            this.mRecyclerViewHelper.getInstance().toggleCheckBox(folderHolderInfo, true);
            this.mFolderModel.setSelectedUuid(uuid);
        }
        this.mRecyclerViewHelper.getInstance().postStartDragAndDrop(folderHolderInfo, this.mFolderModel.getFolderDisplayDataList().indexOf(this.mFolderModel.getFolderData(uuid)), getSelectedItemCount(), modeIndex2 != modeIndex ? 1000L : 500L);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void onItemPressReleased() {
        this.mFragmentContract.getMode().onItemPressReleased();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean onTouch(FolderHolder folderHolder, int i) {
        int i2 = this.mDataUpdateType;
        if (i2 == 9 || i2 == 10) {
            MainLogger.m7258i(TAG, "onTouch block");
        } else {
            if (!StorageUtils.isAvailableMemoryForNewMemo()) {
                DialogUtils.showNotEnoughStorageDialogFragment(this.mFragment.getActivity(), this.mFragment.getActivity().getSupportFragmentManager());
                return false;
            }
            MainLogger.m7258i(TAG, "onItemTouched: reorder");
            if (this.mFolderModel.getFolderDisplayData(i).isExpanded()) {
                setExpandedStatus(true, folderHolder.getFolderHolderInfo().getUuid(), i);
            }
            this.mDataUpdateType = 9;
            this.mReorderItemController.getInstance().reorderStart(folderHolder);
        }
        return false;
    }

    public void registerListener() {
        this.mRecyclerViewHelper.getInstance().registerListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.presenter.DataMapper
    public void restoreInstanceState(Bundle bundle) {
        super.restoreInstanceState(bundle);
        this.mDialogManager.getInstance().restoreInstanceState();
    }

    public void saveFolderExpandState() {
        if (this.mFragmentContract.getModeIndex() == 4) {
            this.mFolderModel.saveFolderMsSyncExpandState();
        } else {
            DataManager.getInstance().saveFolderExpandState(this.mFolderModel.getFolderDataMap());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void setDragListener(FolderHolderInfo folderHolderInfo) {
        this.mRecyclerViewHelper.getInstance().setDragListener(folderHolderInfo);
    }

    public void setExpandedStatus(boolean z, String str, int i) {
        FolderHolderInfo folderHolderInfo;
        if (i == -1 || this.mFolderModel.getFolderDisplayDataList().size() <= i) {
            return;
        }
        NotesFolder folderDisplayData = this.mFolderModel.getFolderDisplayData(i);
        if (folderDisplayData.isExpanded() != z) {
            return;
        }
        FolderHolder folderHolder = getFolderHolder(str);
        if (folderHolder != null && (folderHolderInfo = folderHolder.getFolderHolderInfo()) != null) {
            folderHolderInfo.setArrowExpanded(z, str);
        }
        if (z) {
            int iCollapseFolderDisplayData = this.mFolderModel.collapseFolderDisplayData(folderDisplayData);
            AbstractC8014b.m7200b(i, iCollapseFolderDisplayData, "setExpandedStatus# collapse position : ", ", itemCount : ", TAG);
            this.mFolderAdapter.notifyItemRangeRemoved(i + 1, iCollapseFolderDisplayData);
            removeCheckedChild(str);
        } else {
            int i2 = i + 1;
            int iExpandedFolderDisplayData = this.mFolderModel.expandedFolderDisplayData(str, i2);
            AbstractC8014b.m7200b(i, iExpandedFolderDisplayData, "setExpandedStatus# expand position : ", ", itemCount : ", TAG);
            this.mFolderAdapter.notifyItemRangeInserted(i2, iExpandedFolderDisplayData);
            if (10 != this.mDataUpdateType && ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findLastVisibleItemPosition() < i2) {
                if (iExpandedFolderDisplayData <= 30) {
                    this.mRecyclerView.smoothScrollToPositionForDrawer(i2);
                } else {
                    this.mRecyclerView.smoothScrollToPosition(i2);
                }
            }
            if (isCheckedItem(str)) {
                List<NotesFolder> childFolders = getChildFolders(str);
                if (childFolders == null) {
                    return;
                }
                Iterator<NotesFolder> it = childFolders.iterator();
                while (it.hasNext()) {
                    addCheckedItem(it.next().getUuid());
                }
            }
        }
        folderDisplayData.setExpanded(!z);
        this.mFolderModel.updateFolderData(folderDisplayData);
        setFastScrollerEnabled(getFolderCount());
        this.mFragmentContract.getMode().updateSelectedFolderCount(getSelectedItemCount() == getFolderCount() - 1, getSelectedItemCount());
    }

    public void setFastScrollerEnabled(int i) {
        FolderPenRecyclerView folderPenRecyclerView = this.mRecyclerView;
        if (folderPenRecyclerView == null) {
            return;
        }
        folderPenRecyclerView.seslSetFastScrollerEnabled(i >= 70);
    }

    public void setObserveDataChanged() {
        LiveData<DocumentCategoryTree> observer = this.mFolderModel.getObserver(this.mFragmentContract.getModeIndex() == 4 ? new LinkedList(Arrays.asList(FolderConstants.RecycleBin.UUID, FolderConstants.SharedNotes.UUID)) : new LinkedList(Arrays.asList(FolderConstants.RecycleBin.UUID, FolderConstants.ScreenOffMemo.UUID, FolderConstants.SharedNotes.UUID, FolderConstants.MathNotes.UUID)));
        this.mDisplayFolderTree = observer;
        observer.observe(this.mFragment.getViewLifecycleOwner(), this.mFoldersObserver);
    }

    public void showAddFolderDialog(String str, int i, int i2) {
        this.mDialogManager.getInstance().showAddFolderDialog(str, i, i2);
    }

    public void showChangeColorDialog(ArrayList<String> arrayList, int i) {
        this.mDialogManager.getInstance().showChangeColorDialog(arrayList, i);
    }

    public void showDeleteFolderDialog(String str, int i) {
        this.mDialogManager.getInstance().showDeleteFolderDialog(str, i);
    }

    public void showFolderMoveDialog() {
        onReplaceCheckedItems();
        this.mDialogManager.getInstance().showFolderMoveDialog(getCheckedRootItemUuidList(), getSelectedItemCount());
    }

    public void showRenameFolderDialog(String str, int i) {
        this.mDialogManager.getInstance().showRenameFolderDialog(str, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void toggleFolderSyncSwitch(FolderHolderInfo folderHolderInfo) {
        if (folderHolderInfo == null) {
            return;
        }
        this.mDataUpdateType = 12;
        final String uuid = folderHolderInfo.getUuid();
        if (CommonUtil.isNotAvailableActivity(this.mFragment.getActivity())) {
            MainLogger.m7258i(TAG, "onEditDialogResult isNotAvailableActivity");
            return;
        }
        final NotesFolder folderData = this.mFolderModel.getFolderData(uuid);
        if (folderData == null) {
            return;
        }
        new FolderWorkerTask("FolderMSSync").run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.FolderPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                int i = folderData.isSyncWithMS() == 0 ? 1 : 0;
                folderData.setIsSyncWithMS(i);
                FolderPresenter.this.mFolderModel.update(folderData);
                C6785g c6785g = AbstractC6784f.f4180a;
                String str = uuid;
                c6785g.getClass();
                if (i == 0) {
                    MSLogger.m8632d("GraphManager", "remove ConnectedFolder. folderUuid :" + str);
                } else {
                    MSLogger.m8632d("GraphManager", "add ConnectedFolder. folderUuid :" + str);
                    new SenlThreadFactory("GraphManager-updateConnectedFolder").newThread(new RunnableC6781c(c6785g, str, 2)).start();
                }
            }
        }));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void updateContentDescription(FolderHolderInfo folderHolderInfo) {
        this.mRecyclerViewHelper.getInstance().updateContentDescription(folderHolderInfo);
    }

    public void showDeleteFolderDialog(int i) {
        this.mDialogManager.getInstance().showDeleteFolderDialog(getSelectedItemCount(), i);
    }
}
