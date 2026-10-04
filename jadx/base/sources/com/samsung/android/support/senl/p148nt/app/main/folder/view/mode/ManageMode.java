package com.samsung.android.support.senl.p148nt.app.main.folder.view.mode;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.PopupMenu;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.FolderPresenter;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.util.AnchorViewUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ManageMode extends BaseMode {
    private static final String TAG = "ManageMode";

    public ManageMode(AbsFragment absFragment, FolderPenRecyclerView folderPenRecyclerView, ActionMenuController actionMenuController, BottomMenuController bottomMenuController, FolderPresenter folderPresenter) {
        super(absFragment, folderPenRecyclerView, actionMenuController, bottomMenuController, folderPresenter);
    }

    private void showPopupMenu(FolderHolderInfo folderHolderInfo, int i, final View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, 8388611);
        this.mFragment.getActivity().getMenuInflater().inflate(C8003R.menu.drawer_popup_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        final String uuid = folderHolderInfo.getUuid();
        if (i == 3) {
            menu.removeItem(C8003R.id.rename);
            menu.removeItem(C8003R.id.delete);
            menu.removeItem(C8003R.id.change_color);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.mode.ManageMode.1
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == C8003R.id.create) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_ADD_SUBFOLDER);
                    ManageMode.this.mPresenter.showAddFolderDialog(uuid, view.getId(), ManageMode.this.getModeIndex());
                    return false;
                }
                if (itemId == C8003R.id.rename) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_RENAME);
                    ManageMode.this.mPresenter.showRenameFolderDialog(uuid, view.getId());
                    return false;
                }
                if (itemId == C8003R.id.delete) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_DELETE);
                    ManageMode.this.mPresenter.showDeleteFolderDialog(uuid, view.getId());
                    return false;
                }
                if (itemId != C8003R.id.change_color) {
                    return false;
                }
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_CHANGE_COLOR);
                ManageMode.this.mPresenter.showChangeColorDialog(new ArrayList<>(Arrays.asList(uuid)), view.getId());
                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.mode.ManageMode.2
            @Override // androidx.appcompat.widget.PopupMenu.OnDismissListener
            public void onDismiss(PopupMenu popupMenu2) {
            }
        });
        popupMenu.show();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public int getModeIndex() {
        return 2;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onBackKeyDown() {
        this.mPresenter.saveFolderExpandState();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        NotesFolder folderData = this.mPresenter.getFolderData(FolderConstants.MyFolders.UUID);
        if (folderData == null || folderData.getChildren().isEmpty()) {
            return;
        }
        menuInflater.inflate(C8003R.menu.folderlist_manage, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onFolderSelected(FolderHolderInfo folderHolderInfo, int i) {
        FolderPenRecyclerView folderPenRecyclerView;
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ManageCategory;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        String uuid = folderHolderInfo.getUuid();
        if (i == 4) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_ADD_FOLDERS);
            this.mPresenter.showAddFolderDialog(uuid, C8003R.id.anchor_view, getModeIndex());
        } else if (i <= 3) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_EDIT_FOLDERS);
            ViewGroup viewGroup = (ViewGroup) folderHolderInfo.getTouchedView();
            if (viewGroup != null && (folderPenRecyclerView = this.mRecyclerView) != null) {
                showPopupMenu(folderHolderInfo, i, AnchorViewUtils.getAnchorView(folderPenRecyclerView, viewGroup, folderHolderInfo.getTouchPos()[0], folderHolderInfo.getTouchPos()[1]));
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onItemLongPressed(int i) {
        this.mRecyclerView.requestDisallowInterceptTouchEvent(true);
        if (i == 3) {
            FolderPresenter folderPresenter = this.mPresenter;
            String str = FolderConstants.MyFolders.UUID;
            NotesFolder folderData = folderPresenter.getFolderData(str);
            if (folderData == null) {
                return false;
            }
            if (this.mPresenter.getFolderDisplayDataList().size() - this.mPresenter.getDimFolderCount() == 1 && folderData.hasChild()) {
                this.mPresenter.setExpandedStatus(false, str, 0);
            } else if (!folderData.hasChild()) {
                return false;
            }
            this.mFragmentContract.setMode(3);
        } else {
            this.mRecyclerView.setLongPressed(true);
            this.mFragmentContract.setMode(3);
            this.mRecyclerView.startLongPressMultiSelection();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onLayout() {
        MainLogger.m7258i(TAG, "onLayout");
        this.mActionMenuController.setToolbarTitle(C8003R.string.manage_folder);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
        this.mActionMenuController.setAppbarCollapsedState();
        this.mPresenter.attachAddFolderItem(true, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        if (menuItem.getItemId() != C8003R.id.action_edit) {
            return false;
        }
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_EDIT_MODE);
        List<NotesFolder> folderDisplayDataList = this.mPresenter.getFolderDisplayDataList();
        if (folderDisplayDataList != null) {
            if (folderDisplayDataList.size() - this.mPresenter.getDimFolderCount() == 1) {
                this.mPresenter.setExpandedStatus(false, FolderConstants.MyFolders.UUID, 0);
            }
            if (folderDisplayDataList.size() - this.mPresenter.getDimFolderCount() == 2) {
                this.mPresenter.addCheckedItem(folderDisplayDataList.get(1).getUuid());
            }
        }
        this.mFragmentContract.setMode(3);
        return true;
    }
}
