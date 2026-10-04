package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.dialog.GroupEditMenuDialog;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.dialog.GroupNameDialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupDialogPresenter {
    public static final String TAG = "GcsGroupDialogPresenter";
    private final IGroupDialogContract mIGroupDialogContract;
    private final IEditDialogResult mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.1
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogDismiss() {
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogResult(int i, String str, String str2, int i2) {
            if (str == null) {
                GcsGroupDialogPresenter.this.mIGroupDialogContract.launchSocialPicker(str2);
            } else {
                GcsGroupDialogPresenter.this.mIGroupDialogContract.updateSharedNotebooks(str, str2);
            }
        }
    };
    private final DialogViewContract.IDeleteDialog mDeleteSpaceResultListener = new DialogViewContract.IDeleteDialog() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.2
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onBackPressed() {
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onCancel() {
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onConfirm(boolean z) {
            GcsGroupDialogPresenter.this.mIGroupDialogContract.deleteConfirm();
            DeleteDialogFragment deleteDialogFragment = (DeleteDialogFragment) GcsGroupDialogPresenter.this.mIGroupDialogContract.getChildFragmentManager().findFragmentByTag(FolderConstants.DialogTag.DELETE_FOLDER);
            if (deleteDialogFragment != null) {
                deleteDialogFragment.dismissAllowingStateLoss();
            }
        }
    };
    private final GroupEditMenuDialog.IGroupEditMenuDialog mEditMenuDialogContract = new GroupEditMenuDialog.IGroupEditMenuDialog() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupDialogPresenter.3
        @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.dialog.GroupEditMenuDialog.IGroupEditMenuDialog
        public void delete(boolean z) {
            GcsGroupDialogPresenter.this.deleteSharedNotebooks(z);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.dialog.GroupEditMenuDialog.IGroupEditMenuDialog
        public void rename() {
            GcsGroupDialogPresenter.this.renameSharedNotebooks();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IGroupDialogContract {
        boolean checkInvalidSpace();

        void deleteConfirm();

        FragmentManager getChildFragmentManager();

        Context getContext();

        String getSelectedSpaceId();

        String getSelectedSpaceName();

        boolean isAdded();

        void launchSocialPicker(String str);

        void updateSharedNotebooks(String str, String str2);
    }

    public GcsGroupDialogPresenter(IGroupDialogContract iGroupDialogContract) {
        this.mIGroupDialogContract = iGroupDialogContract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteSharedNotebooks(boolean z) {
        int i;
        int i2;
        int i4;
        if (this.mIGroupDialogContract.isAdded()) {
            if (this.mIGroupDialogContract.checkInvalidSpace()) {
                MainLogger.m7255e(TAG, "deleteSharedNotebooks(). error : no item selected.");
                return;
            }
            if (z) {
                i = C8003R.string.gcs_group_dialog_delete_title;
                i2 = C8003R.string.gcs_group_dialog_delete_message;
                i4 = C8003R.string.dialog_delete;
            } else {
                i = C8003R.string.co_edit_leave_space_dialog_title;
                i2 = C8003R.string.gcs_group_dialog_leave_message;
                i4 = C8003R.string.gcs_group_edit_menu_dialog_action_leave;
            }
            DeleteDialogFragment deleteDialogFragment = new DeleteDialogFragment(i, i2, i4, 1, 0, 0, false, 10, false);
            deleteDialogFragment.setContract(this.mDeleteSpaceResultListener);
            deleteDialogFragment.show(this.mIGroupDialogContract.getChildFragmentManager(), FolderConstants.DialogTag.DELETE_FOLDER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renameSharedNotebooks() {
        if (this.mIGroupDialogContract.isAdded()) {
            if (this.mIGroupDialogContract.checkInvalidSpace()) {
                MainLogger.m7255e(TAG, "renameSharedNotebooks(). error : no item selected.");
                return;
            }
            GroupNameDialogFragment groupNameDialogFragment = new GroupNameDialogFragment(this.mIGroupDialogContract.getSelectedSpaceId(), this.mIGroupDialogContract.getSelectedSpaceName());
            groupNameDialogFragment.setEditDialogResultListener(this.mEditDialogResultListener);
            groupNameDialogFragment.show(this.mIGroupDialogContract.getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
        }
    }

    public void addSharedNotebooks() {
        if (!this.mIGroupDialogContract.isAdded()) {
            MainLogger.m7254d(TAG, "addSharedNotebooks# fragment has not been attached yet.");
            return;
        }
        GroupNameDialogFragment groupNameDialogFragment = new GroupNameDialogFragment();
        groupNameDialogFragment.setAnchorViewId(C8003R.id.action_add_shared_notebook);
        groupNameDialogFragment.setEditDialogResultListener(this.mEditDialogResultListener);
        groupNameDialogFragment.show(this.mIGroupDialogContract.getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
    }

    public void restoreInstance() {
        GroupNameDialogFragment groupNameDialogFragment = (GroupNameDialogFragment) this.mIGroupDialogContract.getChildFragmentManager().findFragmentByTag(FolderConstants.DialogTag.FOLDER_NAME);
        if (groupNameDialogFragment != null) {
            groupNameDialogFragment.setEditDialogResultListener(this.mEditDialogResultListener);
        }
        DeleteDialogFragment deleteDialogFragment = (DeleteDialogFragment) this.mIGroupDialogContract.getChildFragmentManager().findFragmentByTag(FolderConstants.DialogTag.DELETE_FOLDER);
        if (deleteDialogFragment != null) {
            deleteDialogFragment.setContract(this.mDeleteSpaceResultListener);
        }
    }

    public void showGroupEditMenuDialog(boolean z) {
        new GroupEditMenuDialog(this.mIGroupDialogContract.getContext(), this.mIGroupDialogContract.getSelectedSpaceName(), z, this.mEditMenuDialogContract).show();
    }
}
