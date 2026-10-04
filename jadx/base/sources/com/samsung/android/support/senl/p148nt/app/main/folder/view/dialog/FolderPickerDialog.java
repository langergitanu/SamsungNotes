package com.samsung.android.support.senl.p148nt.app.main.folder.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.FolderNameDialog;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.MoveConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderWorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.layoutmanager.FolderLayoutManager;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderAdapter;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderMoveMap;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.AnchorViewUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderPickerDialog extends AbsDialogFragment implements AdapterContract, IFolderPickerDialog {
    private static final int DATA_CONTAINS_FOLDERS = 0;
    private static final int DATA_CONTAINS_ONLY_NOTES = -1;
    private static final int DATA_UPDATE_FINISHED = 1;
    private static final int EXCLUDE_STATIC_FOLDER = 0;
    private static final int INCLUDE_STATIC_FOLDER = 1;
    private static final int NOT_DEFINE = -1;
    private static final String TAG = "FolderPickerDialog";
    private FolderAdapter mAdapter;
    private int mCheckedFolderCount;
    private ArrayList<String> mCheckedFolderRootItemUuidList;
    private int mCheckedNotesCount;
    private final IConfirmDialogResultListener mConfirmResultListener;
    private int mDataUpdateType;
    private final Observer<DocumentCategoryTree> mDocumentCategoryTreeObserver;
    private final IEditDialogResult mEditDialogResultListener;
    private int mFolderDataStatus;
    private final FolderMoveMap mFolderMoveMap;
    private IFolderPickerDialog.OnFolderSelectedListener mFolderSelectedListener;
    private String mHighlightFolderUuid;
    private boolean mIsMovableData;
    private final FolderModel mModel;
    private IFolderPickerDialogResult mPickerDialogListener;
    private FolderPenRecyclerView mRecyclerView;
    private String mSdocxUuid;
    private int mStaticFolderState;

    public FolderPickerDialog() {
        this.mFolderMoveMap = new FolderMoveMap();
        this.mHighlightFolderUuid = FolderConstants.AllNotes.UUID;
        this.mCheckedFolderCount = 0;
        this.mCheckedNotesCount = 0;
        this.mIsMovableData = true;
        this.mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogDismiss() {
                InputMethodCompat.getInstance().forceHideSoftInput(FolderPickerDialog.this.getContext());
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogResult(final int i, final String str, final String str2, final int i2) {
                StringBuilder sb = new StringBuilder("onEditDialogResult# folderName : ");
                sb.append(MainLogger.getEncode(str2));
                sb.append(", selectedUuid : ");
                sb.append(str);
                sb.append(", dialogType : ");
                AbstractC8014b.m7212n(sb, "FolderPickerDialog", i);
                if (CommonUtil.isNotAvailableActivity(FolderPickerDialog.this.getActivity())) {
                    MainLogger.m7258i("FolderPickerDialog", "onEditDialogResult isNotAvailableActivity");
                    return;
                }
                final FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderEdit");
                folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1.1
                    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                    public void onEnd(@NonNull WorkerTask.Result result) {
                        if (folderWorkerTask.getTaskResult().getMSuccess()) {
                            return;
                        }
                        ToastHandler.show(FolderPickerDialog.this.getContext(), C8003R.string.folder_already_in_use, 0);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                    public void onStart(@NonNull WorkerTask<?> workerTask) {
                        folderWorkerTask.getTaskResult().setSuccess(true);
                    }
                });
                folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FolderModel.isExistFolderName(FolderPickerDialog.this.getContext(), str2, str, DataManager.getInstance().getFoldersDisplayName(str, FolderPickerDialog.this.mModel.getFolderDataMap()), true)) {
                            folderWorkerTask.getTaskResult().setSuccess(false);
                            return;
                        }
                        FolderPickerDialog.this.mDataUpdateType = i;
                        FolderPickerDialog.this.mModel.addFolderData(str, str2, i2);
                        FolderPickerDialog.this.mModel.setSelectedUuid(str);
                        FolderPickerDialog.this.mFolderDataStatus = 0;
                    }
                }));
            }
        };
        this.mConfirmResultListener = new IConfirmDialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.2
            @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
            public void onConfirm(String str) {
                if (FolderPickerDialog.this.mPickerDialogListener == null) {
                    return;
                }
                if (FolderPickerDialog.this.mModel.isDeletedFolder(str)) {
                    MainLogger.m7259w("FolderPickerDialog", "Confirm result, ignore, already deleted folder confirmed");
                    return;
                }
                FolderPickerDialog.this.mFolderDataStatus = 1;
                FolderPickerDialog.this.mPickerDialogListener.onConfirm(str);
                FolderPickerDialog.this.onFoldersDataMove(str);
            }
        };
        this.mDocumentCategoryTreeObserver = new Observer<DocumentCategoryTree>() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.3
            @Override // androidx.lifecycle.Observer
            public void onChanged(DocumentCategoryTree documentCategoryTree) {
                if (FolderPickerDialog.this.isResumed()) {
                    if (FolderPickerDialog.this.mFolderDataStatus == 1) {
                        FolderPickerDialog.this.dismissAllowingStateLoss();
                    }
                    MainLogger.m7258i("FolderPickerDialog", "FolderDialog LiveData onChanged : " + documentCategoryTree.getFolderCount());
                    FolderPickerDialog.this.mModel.updateFolderDataMap(documentCategoryTree.getFolderMap());
                    FolderPickerDialog.this.mModel.attachAddFolderItem(FolderPickerDialog.this.mIsMovableData);
                    if (!FolderPickerDialog.this.mIsMovableData) {
                        FolderPickerDialog.this.mModel.attachAllNotesItem();
                    }
                    NotesFolder folderData = FolderPickerDialog.this.mModel.getFolderData(FolderPickerDialog.this.mModel.getSelectedUuid());
                    FolderPickerDialog.this.mModel.setSelectedUuid(null);
                    FolderPickerDialog.this.mAdapter.notifyDataSetChanged();
                    if (folderData == null) {
                        return;
                    }
                    int iIndexOf = FolderPickerDialog.this.mModel.getFolderDisplayDataList().indexOf(folderData);
                    int i = FolderPickerDialog.this.mDataUpdateType;
                    if (i == 1) {
                        if (!folderData.isExpanded()) {
                            FolderPickerDialog.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf, false);
                        }
                        FolderPickerDialog.this.mRecyclerView.smoothScrollToPosition(FolderPickerDialog.this.mModel.getExpandedFolderCount(folderData.getChildren()) + iIndexOf);
                        AbstractC8014b.m7212n(new StringBuilder("onChanged# add position : "), "FolderPickerDialog", iIndexOf);
                    } else if (i == 3) {
                        if (!folderData.isExpanded()) {
                            FolderPickerDialog.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf, false);
                        }
                        FolderPickerDialog.this.mRecyclerView.scrollToBottom();
                    }
                    FolderPickerDialog.this.mDataUpdateType = -1;
                }
            }
        };
        this.mModel = new FolderModel();
        this.mStaticFolderState = -1;
    }

    private void addDimStatusItem(NotesFolder notesFolder) {
        if (notesFolder == null) {
            return;
        }
        this.mFolderMoveMap.addDimStatusItem(notesFolder.getUuid());
        Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
        while (it.hasNext()) {
            addDimStatusItem(it.next());
        }
    }

    private List<String> getExcludedUuidList() {
        return this.mStaticFolderState == 0 ? Arrays.asList(FolderConstants.RecycleBin.UUID, FolderConstants.ScreenOffMemo.UUID, FolderConstants.MathNotes.UUID, FolderConstants.SharedNotes.UUID, FolderConstants.Coedit.UUID) : Arrays.asList(FolderConstants.RecycleBin.UUID, FolderConstants.SharedNotes.UUID, FolderConstants.Coedit.UUID);
    }

    private FolderHolder getFolderHolder(String str) {
        if (this.mRecyclerView != null && !TextUtils.isEmpty(str)) {
            int childCount = this.mRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                FolderPenRecyclerView folderPenRecyclerView = this.mRecyclerView;
                FolderHolder folderHolder = (FolderHolder) folderPenRecyclerView.getChildViewHolder(folderPenRecyclerView.getChildAt(i));
                if (folderHolder != null && str.equals(folderHolder.getFolderHolderInfo().getUuid())) {
                    return folderHolder;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFoldersDataMove(final String str) {
        if (CommonUtil.isNotAvailableActivity(getActivity())) {
            MainLogger.m7258i("FolderPickerDialog", "onFoldersDataMove isNotAvailableActivity");
            return;
        }
        final int[] iArr = new int[1];
        FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderMove");
        folderWorkerTask.setPostCallback(new FolderWorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.6
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.FolderWorkerTask.Callback
            public void onPostExecute(@NonNull FolderWorkerTask.Result result) {
                Context context = FolderPickerDialog.this.getContext();
                if (context == null) {
                    return;
                }
                if (iArr[0] == 2) {
                    ToastHandler.show(context, context.getResources().getString(C8003R.string.add_subfolder_max_toast), 0);
                }
                FolderPickerDialog.this.mPickerDialogListener.onCancel();
                FolderPickerDialog.this.dismissAllowingStateLoss();
            }
        });
        folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.7
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = FolderPickerDialog.this.mModel.moveFolderData(FolderPickerDialog.this.mCheckedFolderRootItemUuidList, str);
            }
        }));
    }

    private void onRestoreInstanceState(@NonNull Bundle bundle) {
        this.mFolderMoveMap.loadCheckedItem(bundle);
        this.mCheckedFolderRootItemUuidList = (ArrayList) bundle.getSerializable(NotesConstants.DialogTag.KEY_CHECKED_FOLDER_ROOT_ITEM_UUID_LIST);
        this.mCheckedFolderCount = bundle.getInt(NotesConstants.DialogTag.KEY_CHECKED_FOLDERS_COUNT);
        this.mCheckedNotesCount = bundle.getInt(NotesConstants.DialogTag.KEY_CHECKED_NOTES_COUNT);
        this.mFolderDataStatus = bundle.getInt(NotesConstants.DialogTag.KEY_FOLDER_DATA_STATUS);
        this.mStaticFolderState = bundle.getInt(NotesConstants.DialogTag.KEY_IS_EXCLUDED_STATIC_FOLDER);
        this.mSdocxUuid = bundle.getString("sdocx_uuid");
        this.mHighlightFolderUuid = bundle.getString(NotesConstants.DialogTag.KEY_HIGHLIGHT_UUID);
        this.mModel.restoreFolderPickerExpandState();
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(FolderConstants.DialogTag.MOVE_CONFIRM_FOLDER);
        if (fragmentFindFragmentByTag != null) {
            ((MoveConfirmDialogFragment) fragmentFindFragmentByTag).setConfirmDialogResultListener(this.mConfirmResultListener);
        }
        Fragment fragmentFindFragmentByTag2 = getChildFragmentManager().findFragmentByTag(FolderConstants.DialogTag.FOLDER_NAME);
        if (fragmentFindFragmentByTag2 != null) {
            ((NameDialogFragment) fragmentFindFragmentByTag2).setEditDialogResultListener(this.mEditDialogResultListener);
        }
    }

    private void openCurrentFolder(String str) {
        NotesFolder folderData = this.mModel.getFolderData(str);
        NotesFolder parent = folderData == null ? null : folderData.getParent();
        if (parent != null) {
            openCurrentFolder(parent.getUuid());
            if (!parent.isExpanded()) {
                setExpandedStatus(false, parent.getUuid(), this.mModel.getFolderDisplayDataList().indexOf(parent), true);
            }
        }
        if (folderData != null) {
            if ((folderData.getViewType() == 0 || folderData.getViewType() == 3) && !folderData.isExpanded()) {
                setExpandedStatus(false, folderData.getUuid(), this.mModel.getFolderDisplayDataList().indexOf(folderData), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpandedStatus(boolean z, String str, int i, boolean z2) {
        FolderHolderInfo folderHolderInfo;
        if (i == -1) {
            return;
        }
        NotesFolder folderDisplayData = this.mModel.getFolderDisplayData(i);
        this.mAdapter.notifyItemChanged(i, 0);
        FolderHolder folderHolder = getFolderHolder(str);
        if (folderHolder != null && (folderHolderInfo = folderHolder.getFolderHolderInfo()) != null) {
            folderHolderInfo.setArrowExpanded(z, str);
        }
        if (z) {
            int iCollapseFolderDisplayData = this.mModel.collapseFolderDisplayData(folderDisplayData);
            AbstractC8014b.m7200b(i, iCollapseFolderDisplayData, "setExpandedStatus# collapseFolderDisplayData collapse position : ", ", itemCount : ", "FolderPickerDialog");
            this.mAdapter.notifyItemRangeRemoved(i + 1, iCollapseFolderDisplayData);
        } else {
            int i2 = i + 1;
            int iExpandedFolderDisplayData = this.mModel.expandedFolderDisplayData(str, i2);
            AbstractC8014b.m7200b(i, iExpandedFolderDisplayData, "setExpandedStatus# expandedFolderDisplayData expand position : ", ", itemCount : ", "FolderPickerDialog");
            this.mAdapter.notifyItemRangeInserted(i2, iExpandedFolderDisplayData);
            if (!z2) {
                this.mRecyclerView.smoothScrollToPositionForDrawer(i2);
            }
        }
        folderDisplayData.setExpanded(!z);
        this.mModel.updateFolderData(folderDisplayData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAddFolderDialog(String str, int i) {
        int i2;
        if ("addFolder:///".equals(str)) {
            str = FolderConstants.MyFolders.UUID;
            i2 = 3;
        } else {
            i2 = 1;
        }
        MainLogger.m7258i("FolderPickerDialog", "showAddFolderDialog #parentUuid " + str);
        FolderNameDialog folderNameDialog = new FolderNameDialog(str, i2, DataManager.getInstance().getFoldersDisplayName(str, this.mModel.getFolderDataMap()));
        folderNameDialog.setAnchorViewId((AlertDialog) getDialog(), i);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.setDismissAfterHideSIP(true);
        folderNameDialog.show(getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public String getFolderUuid() {
        return this.mHighlightFolderUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public int getLayoutMode() {
        return this.mRecyclerView.getLayoutMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public int getModeIndex() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean isAnimateItem(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean isCheckedItem(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean isDimItem(String str) {
        return this.mFolderMoveMap.isDimStatusItem(str);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        MainLogger.m7258i("FolderPickerDialog", "onCreateDialog");
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        } else {
            this.mModel.initFolderDisplayDataList();
        }
        FolderModel folderModel = this.mModel;
        boolean z = bundle != null ? bundle.getBoolean(NotesConstants.DialogTag.KEY_IS_MOVABLE_DATA) : this.mIsMovableData;
        this.mIsMovableData = z;
        folderModel.attachAddFolderItem(z);
        if (!this.mIsMovableData) {
            this.mModel.attachAllNotesItem();
        }
        View viewInflate = View.inflate(getContext(), C8003R.layout.folder_picker_list_fragment, null);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).create();
        alertDialogCreate.setTitle(this.mIsMovableData ? C8003R.string.select_destination_folder : C8003R.string.select_folder);
        alertDialogCreate.getWindow().setGravity(17);
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                InputMethodCompat.getInstance().forceHideSoftInput(FolderPickerDialog.this.getContext());
            }
        });
        FolderPenRecyclerView folderPenRecyclerView = (FolderPenRecyclerView) viewInflate.findViewById(C8003R.id.folderlist_recyclerview);
        this.mRecyclerView = folderPenRecyclerView;
        folderPenRecyclerView.setLayoutManager(new FolderLayoutManager(getContext()), 9);
        this.mRecyclerView.setItemAnimator(null);
        FolderAdapter folderAdapter = new FolderAdapter(getContext(), this, this.mModel);
        this.mAdapter = folderAdapter;
        this.mRecyclerView.setAdapter(folderAdapter);
        this.mRecyclerView.seslSetFadingEdgeEnabled(true);
        this.mModel.getObserver(getExcludedUuidList()).observe(this, this.mDocumentCategoryTreeObserver);
        if (bundle == null) {
            if (FeatureUtils.isPreDefinedFolderUuid(this.mHighlightFolderUuid)) {
                openCurrentFolder(FolderConstants.MyFolders.UUID);
            } else {
                openCurrentFolder(this.mHighlightFolderUuid);
            }
            NotesFolder folderData = this.mModel.getFolderData(this.mHighlightFolderUuid);
            if (folderData != null) {
                this.mRecyclerView.scrollToPosition(this.mModel.getFolderDisplayDataList().indexOf(folderData));
            }
        }
        return alertDialogCreate;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void onFolderSelected(FolderHolderInfo folderHolderInfo, int i, boolean z) {
        MainLogger.m7258i("FolderPickerDialog", "onFolderSelected");
        if (folderHolderInfo.hasChild() && !z) {
            NotesFolder folderDisplayData = this.mModel.getFolderDisplayData(i);
            if (folderDisplayData == null) {
                return;
            }
            folderHolderInfo.getIconLayout().announceForAccessibility(getString(folderDisplayData.isExpanded() ? C8003R.string.collapse : C8003R.string.expand));
            setExpandedStatus(folderDisplayData.isExpanded(), folderHolderInfo.getUuid(), i, false);
            return;
        }
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ManageCategory;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(500L, tag);
            View anchorView = AnchorViewUtils.getAnchorView(this.mRecyclerView, (ViewGroup) folderHolderInfo.getFolderItemContainer(), folderHolderInfo.getTouchPos()[0], folderHolderInfo.getTouchPos()[1]);
            if (folderHolderInfo.getViewType() == 4) {
                showAddFolderDialog(folderHolderInfo.getUuid(), anchorView.getId());
                return;
            }
            if (isDimItem(folderHolderInfo.getUuid())) {
                return;
            }
            if (this.mSdocxUuid == null) {
                showMoveFolderConfirmDialog(folderHolderInfo.getUuid(), anchorView.getId());
                return;
            }
            MainLogger.m7258i("FolderPickerDialog", "onFolderSelected# noteData move");
            DataManager.getInstance().updateCategory(this.mSdocxUuid, folderHolderInfo.getUuid());
            IFolderPickerDialog.OnFolderSelectedListener onFolderSelectedListener = this.mFolderSelectedListener;
            if (onFolderSelectedListener != null) {
                onFolderSelectedListener.onFolderSelected(folderHolderInfo.getUuid());
            }
            dismissAllowingStateLoss();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean onItemLongPressed(FolderHolderInfo folderHolderInfo) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Folder;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return true;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        final String uuid = folderHolderInfo.getUuid();
        MainLogger.m7258i("FolderPickerDialog", "onItemLongPressed " + uuid);
        if (FolderUtils.isStaticFolder(uuid)) {
            return false;
        }
        final View anchorView = AnchorViewUtils.getAnchorView(this.mRecyclerView, (ViewGroup) folderHolderInfo.getFolderItemContainer(), folderHolderInfo.getTouchPos()[0], folderHolderInfo.getTouchPos()[1]);
        PopupMenu popupMenu = new PopupMenu(anchorView.getContext(), anchorView, 8388613);
        getActivity().getMenuInflater().inflate(C8003R.menu.folder_move_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.5
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() != C8003R.id.create) {
                    return false;
                }
                CommonSamsungAnalytics.insertLog("751", "7801");
                FolderPickerDialog.this.showAddFolderDialog(uuid, anchorView.getId());
                return false;
            }
        });
        popupMenu.show();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void onItemPressReleased() {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mFolderMoveMap.saveCheckedItem(bundle);
        this.mModel.saveFolderPickerExpandState();
        bundle.putSerializable(NotesConstants.DialogTag.KEY_CHECKED_FOLDER_ROOT_ITEM_UUID_LIST, this.mCheckedFolderRootItemUuidList);
        bundle.putInt(NotesConstants.DialogTag.KEY_CHECKED_FOLDERS_COUNT, this.mCheckedFolderCount);
        bundle.putInt(NotesConstants.DialogTag.KEY_CHECKED_NOTES_COUNT, this.mCheckedNotesCount);
        bundle.putInt(NotesConstants.DialogTag.KEY_FOLDER_DATA_STATUS, this.mFolderDataStatus);
        bundle.putInt(NotesConstants.DialogTag.KEY_IS_EXCLUDED_STATIC_FOLDER, this.mStaticFolderState);
        bundle.putBoolean(NotesConstants.DialogTag.KEY_IS_MOVABLE_DATA, this.mIsMovableData);
        bundle.putString("sdocx_uuid", this.mSdocxUuid);
        bundle.putString(NotesConstants.DialogTag.KEY_HIGHLIGHT_UUID, this.mHighlightFolderUuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public boolean onTouch(FolderHolder folderHolder, int i) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void setDragListener(FolderHolderInfo folderHolderInfo) {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog
    public void setFolderSelectedListener(IFolderPickerDialog.OnFolderSelectedListener onFolderSelectedListener) {
        this.mFolderSelectedListener = onFolderSelectedListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog
    public void setHighlightFolderUuid(String str) {
        this.mHighlightFolderUuid = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog
    public void setPickerDialogData(String str, String str2) {
        this.mFolderMoveMap.clearDimStatusItems();
        this.mFolderDataStatus = -1;
        ArrayList<String> arrayList = new ArrayList<>();
        this.mCheckedFolderRootItemUuidList = arrayList;
        arrayList.add(str2);
        this.mSdocxUuid = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog
    public void setPickerDialogListener(IFolderPickerDialogResult iFolderPickerDialogResult) {
        this.mPickerDialogListener = iFolderPickerDialogResult;
    }

    public void showMoveFolderConfirmDialog(String str, int i) {
        NotesFolder folderData;
        String string;
        AbstractC8014b.m7209k("showMoveFolderConfirmDialog #folderUuid ", str, "FolderPickerDialog");
        if (!this.mIsMovableData) {
            IFolderPickerDialogResult iFolderPickerDialogResult = this.mPickerDialogListener;
            if (iFolderPickerDialogResult == null) {
                return;
            }
            iFolderPickerDialogResult.onConfirm(str);
            dismissAllowingStateLoss();
            return;
        }
        MoveConfirmDialogFragment moveConfirmDialogFragment = (MoveConfirmDialogFragment) getChildFragmentManager().findFragmentByTag(FolderConstants.DialogTag.MOVE_CONFIRM_FOLDER);
        if ((moveConfirmDialogFragment != null && moveConfirmDialogFragment.isAdded() && moveConfirmDialogFragment.isResumed()) || (folderData = this.mModel.getFolderData(str)) == null) {
            return;
        }
        String prefixedFolderName = FolderUtils.getPrefixedFolderName(getContext(), str);
        if (TextUtils.isEmpty(prefixedFolderName)) {
            prefixedFolderName = folderData.getDisplayName();
        }
        int i2 = this.mCheckedFolderCount;
        if (i2 == 0) {
            Resources resources = getResources();
            int i4 = C8003R.plurals.plurals_notes_moved;
            int i5 = this.mCheckedNotesCount;
            string = resources.getQuantityString(i4, i5, Integer.valueOf(i5), prefixedFolderName);
        } else {
            int i6 = this.mCheckedNotesCount;
            if (i6 == 0) {
                Resources resources2 = getResources();
                int i7 = C8003R.plurals.plurals_folders_moved;
                int i8 = this.mCheckedFolderCount;
                string = resources2.getQuantityString(i7, i8, Integer.valueOf(i8), prefixedFolderName);
            } else {
                string = (i2 == 1 && i6 == 1) ? getResources().getString(C8003R.string.move_one_folder_and_one_note, prefixedFolderName) : i6 == 1 ? getResources().getString(C8003R.string.move_folders_and_one_note, Integer.valueOf(this.mCheckedFolderCount), prefixedFolderName) : i2 == 1 ? getResources().getString(C8003R.string.move_one_folder_and_notes, Integer.valueOf(this.mCheckedNotesCount), prefixedFolderName) : getResources().getString(C8003R.string.move_folders_and_notes, Integer.valueOf(this.mCheckedFolderCount), Integer.valueOf(this.mCheckedNotesCount), prefixedFolderName);
            }
        }
        MoveConfirmDialogFragment moveConfirmDialogFragment2 = new MoveConfirmDialogFragment(string, C8003R.string.action_move);
        moveConfirmDialogFragment2.setAnchorViewId((AlertDialog) getDialog(), i);
        moveConfirmDialogFragment2.setSelectedUuid(str);
        moveConfirmDialogFragment2.setConfirmDialogResultListener(this.mConfirmResultListener);
        moveConfirmDialogFragment2.show(getChildFragmentManager(), FolderConstants.DialogTag.MOVE_CONFIRM_FOLDER);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void toggleFolderSyncSwitch(FolderHolderInfo folderHolderInfo) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.adapter.AdapterContract
    public void updateContentDescription(FolderHolderInfo folderHolderInfo) {
        String string;
        if (folderHolderInfo == null) {
            return;
        }
        String title = folderHolderInfo.getTitle();
        if (FolderConstants.MyFolders.UUID.equals(folderHolderInfo.getUuid())) {
            title = getContext().getResources().getString(C8003R.string.settings_my_folders);
        }
        int count = folderHolderInfo.getCount();
        if (folderHolderInfo.getViewType() == 4) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(title)) {
                title = "";
            }
            sb.append(title);
            sb.append(SQLKeyword.COMMA);
            string = AbstractC0000a.m12i(getContext().getResources(), C8003R.string.button_string_button, sb);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getContext().getResources().getString(C8003R.string.folder_string));
            sb2.append(TextUtils.isEmpty(title) ? "" : AbstractC0541b.m772n(SQLKeyword.COMMA, title));
            sb2.append(SQLKeyword.COMMA);
            sb2.append(getContext().getResources().getQuantityString(C8003R.plurals.plurals_count_items, count, Integer.valueOf(count)));
            string = sb2.toString();
        }
        folderHolderInfo.getFolderItemLayout().setContentDescription(string);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog
    public void setPickerDialogData(ArrayList<String> arrayList, int i, int i2) {
        this.mFolderMoveMap.clearDimStatusItems();
        int i4 = i2 == 0 ? -1 : 0;
        this.mFolderDataStatus = i4;
        if (i4 == 0) {
            FolderModel folderModel = this.mModel;
            String str = FolderConstants.ScreenOffMemo.UUID;
            if (folderModel.getFolderData(str) != null) {
                addDimStatusItem(this.mModel.getFolderData(str));
            }
            FolderModel folderModel2 = this.mModel;
            String str2 = FolderConstants.MathNotes.UUID;
            if (folderModel2.getFolderData(str2) != null) {
                addDimStatusItem(this.mModel.getFolderData(str2));
            }
        }
        for (String str3 : arrayList) {
            if (this.mIsMovableData) {
                addDimStatusItem(this.mModel.getFolderData(str3));
            } else {
                this.mFolderMoveMap.addDimStatusItem(str3);
            }
        }
        this.mCheckedFolderRootItemUuidList = arrayList;
        this.mCheckedNotesCount = i;
        this.mCheckedFolderCount = i2;
        FolderModel folderModel3 = this.mModel;
        String str4 = FolderConstants.MyFolders.UUID;
        if (folderModel3.getFolderData(str4) == null) {
            return;
        }
        for (NotesFolder notesFolder : this.mModel.getFolderData(str4).getChildren()) {
            if (this.mFolderDataStatus == 0 || !this.mFolderMoveMap.isDimStatusItem(notesFolder.getUuid())) {
                this.mFolderDataStatus = 0;
                return;
            }
        }
    }

    public FolderPickerDialog(boolean z) {
        this.mFolderMoveMap = new FolderMoveMap();
        this.mHighlightFolderUuid = FolderConstants.AllNotes.UUID;
        this.mCheckedFolderCount = 0;
        this.mCheckedNotesCount = 0;
        this.mIsMovableData = true;
        this.mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogDismiss() {
                InputMethodCompat.getInstance().forceHideSoftInput(FolderPickerDialog.this.getContext());
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogResult(final int i, final String str, final String str2, final int i2) {
                StringBuilder sb = new StringBuilder("onEditDialogResult# folderName : ");
                sb.append(MainLogger.getEncode(str2));
                sb.append(", selectedUuid : ");
                sb.append(str);
                sb.append(", dialogType : ");
                AbstractC8014b.m7212n(sb, "FolderPickerDialog", i);
                if (CommonUtil.isNotAvailableActivity(FolderPickerDialog.this.getActivity())) {
                    MainLogger.m7258i("FolderPickerDialog", "onEditDialogResult isNotAvailableActivity");
                    return;
                }
                final FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderEdit");
                folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1.1
                    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                    public void onEnd(@NonNull WorkerTask.Result result) {
                        if (folderWorkerTask.getTaskResult().getMSuccess()) {
                            return;
                        }
                        ToastHandler.show(FolderPickerDialog.this.getContext(), C8003R.string.folder_already_in_use, 0);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                    public void onStart(@NonNull WorkerTask<?> workerTask) {
                        folderWorkerTask.getTaskResult().setSuccess(true);
                    }
                });
                folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FolderModel.isExistFolderName(FolderPickerDialog.this.getContext(), str2, str, DataManager.getInstance().getFoldersDisplayName(str, FolderPickerDialog.this.mModel.getFolderDataMap()), true)) {
                            folderWorkerTask.getTaskResult().setSuccess(false);
                            return;
                        }
                        FolderPickerDialog.this.mDataUpdateType = i;
                        FolderPickerDialog.this.mModel.addFolderData(str, str2, i2);
                        FolderPickerDialog.this.mModel.setSelectedUuid(str);
                        FolderPickerDialog.this.mFolderDataStatus = 0;
                    }
                }));
            }
        };
        this.mConfirmResultListener = new IConfirmDialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.2
            @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
            public void onConfirm(String str) {
                if (FolderPickerDialog.this.mPickerDialogListener == null) {
                    return;
                }
                if (FolderPickerDialog.this.mModel.isDeletedFolder(str)) {
                    MainLogger.m7259w("FolderPickerDialog", "Confirm result, ignore, already deleted folder confirmed");
                    return;
                }
                FolderPickerDialog.this.mFolderDataStatus = 1;
                FolderPickerDialog.this.mPickerDialogListener.onConfirm(str);
                FolderPickerDialog.this.onFoldersDataMove(str);
            }
        };
        this.mDocumentCategoryTreeObserver = new Observer<DocumentCategoryTree>() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.3
            @Override // androidx.lifecycle.Observer
            public void onChanged(DocumentCategoryTree documentCategoryTree) {
                if (FolderPickerDialog.this.isResumed()) {
                    if (FolderPickerDialog.this.mFolderDataStatus == 1) {
                        FolderPickerDialog.this.dismissAllowingStateLoss();
                    }
                    MainLogger.m7258i("FolderPickerDialog", "FolderDialog LiveData onChanged : " + documentCategoryTree.getFolderCount());
                    FolderPickerDialog.this.mModel.updateFolderDataMap(documentCategoryTree.getFolderMap());
                    FolderPickerDialog.this.mModel.attachAddFolderItem(FolderPickerDialog.this.mIsMovableData);
                    if (!FolderPickerDialog.this.mIsMovableData) {
                        FolderPickerDialog.this.mModel.attachAllNotesItem();
                    }
                    NotesFolder folderData = FolderPickerDialog.this.mModel.getFolderData(FolderPickerDialog.this.mModel.getSelectedUuid());
                    FolderPickerDialog.this.mModel.setSelectedUuid(null);
                    FolderPickerDialog.this.mAdapter.notifyDataSetChanged();
                    if (folderData == null) {
                        return;
                    }
                    int iIndexOf = FolderPickerDialog.this.mModel.getFolderDisplayDataList().indexOf(folderData);
                    int i = FolderPickerDialog.this.mDataUpdateType;
                    if (i == 1) {
                        if (!folderData.isExpanded()) {
                            FolderPickerDialog.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf, false);
                        }
                        FolderPickerDialog.this.mRecyclerView.smoothScrollToPosition(FolderPickerDialog.this.mModel.getExpandedFolderCount(folderData.getChildren()) + iIndexOf);
                        AbstractC8014b.m7212n(new StringBuilder("onChanged# add position : "), "FolderPickerDialog", iIndexOf);
                    } else if (i == 3) {
                        if (!folderData.isExpanded()) {
                            FolderPickerDialog.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf, false);
                        }
                        FolderPickerDialog.this.mRecyclerView.scrollToBottom();
                    }
                    FolderPickerDialog.this.mDataUpdateType = -1;
                }
            }
        };
        this.mModel = new FolderModel();
        this.mStaticFolderState = !z ? 1 : 0;
    }

    public FolderPickerDialog(Map<String, NotesFolder> map, boolean z) {
        this.mFolderMoveMap = new FolderMoveMap();
        this.mHighlightFolderUuid = FolderConstants.AllNotes.UUID;
        this.mCheckedFolderCount = 0;
        this.mCheckedNotesCount = 0;
        this.mIsMovableData = true;
        this.mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogDismiss() {
                InputMethodCompat.getInstance().forceHideSoftInput(FolderPickerDialog.this.getContext());
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogResult(final int i, final String str, final String str2, final int i2) {
                StringBuilder sb = new StringBuilder("onEditDialogResult# folderName : ");
                sb.append(MainLogger.getEncode(str2));
                sb.append(", selectedUuid : ");
                sb.append(str);
                sb.append(", dialogType : ");
                AbstractC8014b.m7212n(sb, "FolderPickerDialog", i);
                if (CommonUtil.isNotAvailableActivity(FolderPickerDialog.this.getActivity())) {
                    MainLogger.m7258i("FolderPickerDialog", "onEditDialogResult isNotAvailableActivity");
                    return;
                }
                final FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderEdit");
                folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1.1
                    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                    public void onEnd(@NonNull WorkerTask.Result result) {
                        if (folderWorkerTask.getTaskResult().getMSuccess()) {
                            return;
                        }
                        ToastHandler.show(FolderPickerDialog.this.getContext(), C8003R.string.folder_already_in_use, 0);
                    }

                    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                    public void onStart(@NonNull WorkerTask<?> workerTask) {
                        folderWorkerTask.getTaskResult().setSuccess(true);
                    }
                });
                folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FolderModel.isExistFolderName(FolderPickerDialog.this.getContext(), str2, str, DataManager.getInstance().getFoldersDisplayName(str, FolderPickerDialog.this.mModel.getFolderDataMap()), true)) {
                            folderWorkerTask.getTaskResult().setSuccess(false);
                            return;
                        }
                        FolderPickerDialog.this.mDataUpdateType = i;
                        FolderPickerDialog.this.mModel.addFolderData(str, str2, i2);
                        FolderPickerDialog.this.mModel.setSelectedUuid(str);
                        FolderPickerDialog.this.mFolderDataStatus = 0;
                    }
                }));
            }
        };
        this.mConfirmResultListener = new IConfirmDialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.2
            @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
            public void onConfirm(String str) {
                if (FolderPickerDialog.this.mPickerDialogListener == null) {
                    return;
                }
                if (FolderPickerDialog.this.mModel.isDeletedFolder(str)) {
                    MainLogger.m7259w("FolderPickerDialog", "Confirm result, ignore, already deleted folder confirmed");
                    return;
                }
                FolderPickerDialog.this.mFolderDataStatus = 1;
                FolderPickerDialog.this.mPickerDialogListener.onConfirm(str);
                FolderPickerDialog.this.onFoldersDataMove(str);
            }
        };
        this.mDocumentCategoryTreeObserver = new Observer<DocumentCategoryTree>() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.dialog.FolderPickerDialog.3
            @Override // androidx.lifecycle.Observer
            public void onChanged(DocumentCategoryTree documentCategoryTree) {
                if (FolderPickerDialog.this.isResumed()) {
                    if (FolderPickerDialog.this.mFolderDataStatus == 1) {
                        FolderPickerDialog.this.dismissAllowingStateLoss();
                    }
                    MainLogger.m7258i("FolderPickerDialog", "FolderDialog LiveData onChanged : " + documentCategoryTree.getFolderCount());
                    FolderPickerDialog.this.mModel.updateFolderDataMap(documentCategoryTree.getFolderMap());
                    FolderPickerDialog.this.mModel.attachAddFolderItem(FolderPickerDialog.this.mIsMovableData);
                    if (!FolderPickerDialog.this.mIsMovableData) {
                        FolderPickerDialog.this.mModel.attachAllNotesItem();
                    }
                    NotesFolder folderData = FolderPickerDialog.this.mModel.getFolderData(FolderPickerDialog.this.mModel.getSelectedUuid());
                    FolderPickerDialog.this.mModel.setSelectedUuid(null);
                    FolderPickerDialog.this.mAdapter.notifyDataSetChanged();
                    if (folderData == null) {
                        return;
                    }
                    int iIndexOf = FolderPickerDialog.this.mModel.getFolderDisplayDataList().indexOf(folderData);
                    int i = FolderPickerDialog.this.mDataUpdateType;
                    if (i == 1) {
                        if (!folderData.isExpanded()) {
                            FolderPickerDialog.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf, false);
                        }
                        FolderPickerDialog.this.mRecyclerView.smoothScrollToPosition(FolderPickerDialog.this.mModel.getExpandedFolderCount(folderData.getChildren()) + iIndexOf);
                        AbstractC8014b.m7212n(new StringBuilder("onChanged# add position : "), "FolderPickerDialog", iIndexOf);
                    } else if (i == 3) {
                        if (!folderData.isExpanded()) {
                            FolderPickerDialog.this.setExpandedStatus(folderData.isExpanded(), folderData.getUuid(), iIndexOf, false);
                        }
                        FolderPickerDialog.this.mRecyclerView.scrollToBottom();
                    }
                    FolderPickerDialog.this.mDataUpdateType = -1;
                }
            }
        };
        this.mModel = new FolderModel(map);
        this.mStaticFolderState = !z ? 1 : 0;
    }
}
