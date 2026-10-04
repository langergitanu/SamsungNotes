package com.samsung.android.support.senl.p148nt.app.main.folder.presenter;

import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ChangeColorDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.FolderNameDialog;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.IColorConfirmDialogResult;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.MoveConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DialogManager {
    private static final String TAG = "DialogManager";
    private final DialogContract mDialogCreator;
    private final FolderModel mFolderModel;
    private final AbsFragment mFragment;
    private final IPresenter mPresenter;
    private final IEditDialogResult mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.1
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogDismiss() {
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogResult(int i, String str, String str2, int i2) {
            DialogManager.this.mPresenter.onEditDialogResult(i, str, str2, i2);
        }
    };
    private final IFolderPickerDialogResult mPickerDialogListener = new IFolderPickerDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.2
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult
        public void onCancel() {
            DialogManager.this.mPresenter.onBackKeyDown();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult
        public void onConfirm(String str) {
            DialogManager.this.mPresenter.onPickConfirm(str);
        }
    };
    private final IConfirmDialogResultListener mConfirmResultListener = new IConfirmDialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.3
        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
        public void onCancel() {
            DialogManager.this.mPresenter.onDeleteCancel();
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
        public void onConfirm(String str) {
            DialogManager.this.mPresenter.onDeleteConfirm(str);
        }
    };
    private final IConfirmDialogResultListener mMoveConfirmResultListener = new IConfirmDialogResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.4
        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
        public void onCancel() {
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IConfirmDialogResultListener
        public void onConfirm(String str) {
            DialogManager.this.mPresenter.onMoveConfirm(str);
        }
    };
    private final IColorConfirmDialogResult mColorConfirmResultListener = new IColorConfirmDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.DialogManager.5
        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IColorConfirmDialogResult
        public void onConfirm(ArrayList<String> arrayList, int i) {
            DialogManager.this.mPresenter.onColorConfirm(arrayList, i);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void onBackKeyDown();

        void onColorConfirm(ArrayList<String> arrayList, int i);

        void onDeleteCancel();

        void onDeleteConfirm(String str);

        void onEditDialogResult(int i, String str, String str2, int i2);

        void onMoveConfirm(String str);

        void onPickConfirm(String str);
    }

    public DialogManager(AbsFragment absFragment, FolderModel folderModel, DialogContract dialogContract, IPresenter iPresenter) {
        this.mFragment = absFragment;
        this.mFolderModel = folderModel;
        this.mDialogCreator = dialogContract;
        this.mPresenter = iPresenter;
    }

    public void restoreInstanceState() {
        FragmentManager childFragmentManager = this.mFragment.getChildFragmentManager();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.FOLDER_NAME);
        if (fragmentFindFragmentByTag != null) {
            ((NameDialogFragment) fragmentFindFragmentByTag).setEditDialogResultListener(this.mEditDialogResultListener);
        }
        Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.DELETE_FOLDER);
        if (fragmentFindFragmentByTag2 != null) {
            ((ConfirmDialogFragment) fragmentFindFragmentByTag2).setConfirmDialogResultListener(this.mConfirmResultListener);
        }
        ActivityResultCaller activityResultCallerFindFragmentByTag = childFragmentManager.findFragmentByTag("FolderPickerDialog");
        if (activityResultCallerFindFragmentByTag != null) {
            ((IFolderPickerDialog) activityResultCallerFindFragmentByTag).setPickerDialogListener(this.mPickerDialogListener);
        }
        Fragment fragmentFindFragmentByTag3 = childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.MOVE_CONFIRM_FOLDER);
        if (fragmentFindFragmentByTag3 != null) {
            ((MoveConfirmDialogFragment) fragmentFindFragmentByTag3).setConfirmDialogResultListener(this.mMoveConfirmResultListener);
        }
        Fragment fragmentFindFragmentByTag4 = childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.CHANGE_COLOR);
        if (fragmentFindFragmentByTag4 != null) {
            ((ChangeColorDialogFragment) fragmentFindFragmentByTag4).setColorConfirmDialogResultListener(this.mColorConfirmResultListener);
        }
    }

    public void showAddFolderDialog(String str, int i, int i2) {
        int i4;
        AbstractC8014b.m7209k("showAddFolderDialog #parentUuid ", str, TAG);
        NotesFolder folderData = this.mFolderModel.getFolderData(str);
        if (folderData != null && folderData.getDepth() >= 50) {
            ToastHandler.show(this.mFragment.getContext(), this.mFragment.getResources().getString(C8003R.string.add_subfolder_max_toast), 0);
            return;
        }
        if ("addFolder:///".equals(str)) {
            str = FolderConstants.MyFolders.UUID;
            i4 = 3;
        } else {
            i4 = 1;
        }
        FolderNameDialog folderNameDialog = new FolderNameDialog(str, i4, DataManager.getInstance().getFoldersDisplayName(str, this.mFolderModel.getFolderDataMap()), i2);
        folderNameDialog.setAnchorViewId(i);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
    }

    public void showChangeColorDialog(ArrayList<String> arrayList, int i) {
        ChangeColorDialogFragment changeColorDialogFragment;
        MainLogger.m7258i(TAG, "showChangeColorDialog");
        if (arrayList.size() == 1) {
            NotesFolder folderData = this.mFolderModel.getFolderData(arrayList.get(0));
            if (folderData == null) {
                return;
            } else {
                changeColorDialogFragment = new ChangeColorDialogFragment(arrayList, folderData.getDisplayNameColor());
            }
        } else {
            changeColorDialogFragment = new ChangeColorDialogFragment(arrayList, -1);
        }
        changeColorDialogFragment.setAnchorViewId(i);
        changeColorDialogFragment.setColorConfirmDialogResultListener(this.mColorConfirmResultListener);
        changeColorDialogFragment.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.CHANGE_COLOR);
    }

    public void showDeleteFolderDialog(int i, int i2) {
        MainLogger.m7258i(TAG, "showDeleteFolderDialog");
        FloatingFeature.Companion companion = FloatingFeature.INSTANCE;
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment(0, companion.getInstance().isDisableRecycleBinModel() ? C8003R.plurals.plurals_permanently_delete_no_cloud_dialog_msg : C8003R.plurals.plurals_move_to_trash_n_folder_dialog_msg, companion.getInstance().isDisableRecycleBinModel() ? C8003R.string.action_delete : C8003R.string.move_to_trash_btn, C8003R.string.cancel_btn, i, true);
        confirmDialogFragment.setAnchorViewId(i2);
        confirmDialogFragment.setConfirmDialogResultListener(this.mConfirmResultListener);
        confirmDialogFragment.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.DELETE_FOLDER);
    }

    public void showFolderMoveDialog(ArrayList<String> arrayList, int i) {
        MainLogger.m7258i(TAG, "showFolderMoveDialog");
        IFolderPickerDialog iFolderPickerDialogCreateFolderPickerDialog = this.mDialogCreator.createFolderPickerDialog(this.mFolderModel.getFolderDataMap(), true, this.mPickerDialogListener);
        iFolderPickerDialogCreateFolderPickerDialog.setAnchorViewId(C8003R.id.action_move);
        iFolderPickerDialogCreateFolderPickerDialog.setPickerDialogData(arrayList, 0, i);
        iFolderPickerDialogCreateFolderPickerDialog.show(this.mFragment.getChildFragmentManager(), "FolderPickerDialog");
    }

    public void showMoveFolderConfirmDialog(String str, int i, int i2) {
        NotesFolder folderData;
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mFragment.getActivity(), this.mFragment.getActivity().getSupportFragmentManager());
            return;
        }
        AbstractC8014b.m7209k("showMoveFolderConfirmDialog #folderUuid ", str, TAG);
        MoveConfirmDialogFragment moveConfirmDialogFragment = (MoveConfirmDialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(FolderConstants.DialogTag.MOVE_CONFIRM_FOLDER);
        if ((moveConfirmDialogFragment != null && moveConfirmDialogFragment.isAdded() && moveConfirmDialogFragment.isResumed()) || (folderData = this.mFolderModel.getFolderData(str)) == null) {
            return;
        }
        MoveConfirmDialogFragment moveConfirmDialogFragment2 = new MoveConfirmDialogFragment(this.mFragment.getResources().getQuantityString(C8003R.plurals.plurals_folders_moved, i, Integer.valueOf(i), FolderConstants.MyFolders.UUID.equals(str) ? this.mFragment.getString(C8003R.string.settings_my_folders) : folderData.getDisplayName()), C8003R.string.action_move);
        moveConfirmDialogFragment2.setAnchorViewId(i2);
        moveConfirmDialogFragment2.setSelectedUuid(str);
        moveConfirmDialogFragment2.setConfirmDialogResultListener(this.mMoveConfirmResultListener);
        moveConfirmDialogFragment2.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.MOVE_CONFIRM_FOLDER);
    }

    public void showRenameFolderDialog(String str, int i) {
        AbstractC8014b.m7209k("showRenameFolderDialog #folderUuid ", str, TAG);
        NotesFolder folderData = this.mFolderModel.getFolderData(str);
        if (folderData == null) {
            return;
        }
        NotesFolder parent = folderData.getParent();
        FolderNameDialog folderNameDialog = new FolderNameDialog(parent.getUuid(), str, folderData.getDisplayName(), 2, DataManager.getInstance().getFoldersDisplayName(parent.getUuid(), this.mFolderModel.getFolderDataMap()), folderData.getDisplayNameColor());
        folderNameDialog.setAnchorViewId(i);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
    }

    public void showDeleteFolderDialog(String str, int i) {
        MainLogger.m7258i(TAG, "showDeleteFolderDialog #folderUuid " + str);
        FloatingFeature.Companion companion = FloatingFeature.INSTANCE;
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment(0, companion.getInstance().isDisableRecycleBinModel() ? C8003R.plurals.plurals_permanently_delete_no_cloud_dialog_msg : C8003R.plurals.plurals_move_to_trash_n_folder_dialog_msg, companion.getInstance().isDisableRecycleBinModel() ? C8003R.string.default_folder : C8003R.string.move_to_trash_btn, C8003R.string.cancel_btn, 1, true);
        confirmDialogFragment.setAnchorViewId(i);
        confirmDialogFragment.setSelectedUuid(str);
        confirmDialogFragment.setConfirmDialogResultListener(this.mConfirmResultListener);
        confirmDialogFragment.show(this.mFragment.getChildFragmentManager(), FolderConstants.DialogTag.DELETE_FOLDER);
    }
}
