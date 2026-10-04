package com.samsung.android.support.senl.p148nt.app.main.folder.view.mode;

import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationBarView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.FolderPresenter;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ManageEditMode extends BaseMode {
    private static final int ANIMATE_DURATION = 300;
    private static final String TAG = "ManageEditMode";
    private final ActionMenuController.OnClickSelectAllListener mOnClickSelectAllListener;

    public ManageEditMode(AbsFragment absFragment, FolderPenRecyclerView folderPenRecyclerView, ActionMenuController actionMenuController, BottomMenuController bottomMenuController, FolderPresenter folderPresenter) {
        super(absFragment, folderPenRecyclerView, actionMenuController, bottomMenuController, folderPresenter);
        this.mOnClickSelectAllListener = new ActionMenuController.OnClickSelectAllListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.mode.ManageEditMode.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.OnClickSelectAllListener
            public void onClick(boolean z) {
                ManageEditMode.this.onSelectAll(z);
            }
        };
    }

    private int getBottomActionMenuItemCount(int i) {
        if (i == 0) {
            return 0;
        }
        return i == 1 ? 5 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPrepareOptionsMenu$0(boolean z) {
        showBottomNavigation(this.mPresenter.getSelectedItemCount());
        if (z) {
            return;
        }
        this.mBottomMenuController.playItemChangeAnimation(true, null);
    }

    private void modeChangeAnimation(boolean z) {
        FolderHolder folderHolder;
        AbstractC6670b.m4739D("modeChangeAnimation# isCurrentEditMode : ", TAG, z);
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        List<NotesFolder> folderDisplayDataList = this.mPresenter.getFolderDisplayDataList();
        for (int i = 0; i < layoutManager.getChildCount(); i++) {
            View childAt = layoutManager.getChildAt(i);
            if (childAt != null && (folderHolder = (FolderHolder) this.mRecyclerView.findContainingViewHolder(childAt)) != null) {
                FolderHolderInfo folderHolderInfo = folderHolder.getFolderHolderInfo();
                String uuid = folderHolderInfo.getUuid();
                folderHolder.setFolderItemDim(this.mPresenter.isDimItem(uuid));
                if (folderHolderInfo.getViewType() != 4) {
                    this.mPresenter.addAnimateItem(uuid);
                    if (folderHolderInfo.getViewType() == 3) {
                        folderHolderInfo.getIconLayout().setBackground(z ? null : ResourcesCompat.getDrawable(this.mFragment.getResources(), C8003R.drawable.folder_list_ripple, null));
                    }
                    folderHolderInfo.setBackground(folderDisplayDataList.indexOf(this.mPresenter.getFolderData(uuid)), folderDisplayDataList.size());
                    folderHolder.setCheckBoxStatus(z ? 0 : 8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSelectAll(boolean z) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        for (int i = 0; i < layoutManager.getChildCount(); i++) {
            FolderHolder folderHolder = (FolderHolder) this.mRecyclerView.getChildViewHolder(layoutManager.getChildAt(i));
            if (folderHolder != null) {
                FolderHolderInfo folderHolderInfo = folderHolder.getFolderHolderInfo();
                if (!FolderConstants.MyFolders.UUID.equals(folderHolderInfo.getUuid()) && !"addFolder:///".equals(folderHolderInfo.getUuid()) && !FolderUtils.isStaticFolder(folderHolderInfo.getUuid())) {
                    setFolderSelectedDescription(folderHolderInfo, z);
                    folderHolderInfo.getCheckBox().setChecked(z);
                }
            }
        }
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_SELECT_ALL, z ? "1" : "0");
        this.mPresenter.onSelectAll(z);
        this.mActionMenuController.updateSelectedFolderCount(z, this.mPresenter.getSelectedItemCount());
    }

    private void scrollToBottomHolder() {
        final String selectedUuid = this.mPresenter.getSelectedUuid();
        if (TextUtils.isEmpty(selectedUuid)) {
            return;
        }
        this.mPresenter.setSelectedUuid(null);
        new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.mode.ManageEditMode.3
            @Override // java.lang.Runnable
            public void run() {
                int iIndexOf = ManageEditMode.this.mPresenter.getFolderDisplayDataList().indexOf(ManageEditMode.this.mPresenter.getFolderData(selectedUuid));
                int iFindLastVisibleItemPosition = ((LinearLayoutManager) ManageEditMode.this.mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                AbstractC8014b.m7200b(iIndexOf, iFindLastVisibleItemPosition, "onItemLongPressReleased# lastSelectedItemPosition : ", " lastVisibleItemPosition : ", ManageEditMode.TAG);
                if (iFindLastVisibleItemPosition < iIndexOf) {
                    ManageEditMode.this.mRecyclerView.smoothScrollToPositionForDrawer(iIndexOf);
                }
            }
        }, 300L);
    }

    private void setExpandFolderList(ArrayList<String> arrayList) {
        for (String str : arrayList) {
            int iIndexOf = this.mPresenter.getFolderDisplayDataList().indexOf(this.mPresenter.getFolderData(str));
            if (iIndexOf >= 0) {
                this.mPresenter.setExpandedStatus(true, str, iIndexOf);
            }
        }
    }

    private void setFolderSelectedDescription(FolderHolderInfo folderHolderInfo, boolean z) {
        String string = this.mFragment.getContext().getString(C8003R.string.selectall_voice_ass_not_selected);
        String string2 = this.mFragment.getContext().getString(C8003R.string.selectall_voice_ass_tick_box);
        if (z) {
            folderHolderInfo.getFolderItemLayout().setContentDescription(folderHolderInfo.getTitle() + folderHolderInfo.getCount() + SQLKeyword.COMMA + string2);
            return;
        }
        View folderItemLayout = folderHolderInfo.getFolderItemLayout();
        StringBuilder sbM781w = AbstractC0541b.m781w(string, SQLKeyword.COMMA);
        sbM781w.append(folderHolderInfo.getTitle());
        sbM781w.append(folderHolderInfo.getCount());
        sbM781w.append(SQLKeyword.COMMA);
        sbM781w.append(string2);
        folderItemLayout.setContentDescription(sbM781w.toString());
    }

    private void showBottomNavigation(int i) {
        if (i == 0 || (this.mRecyclerView.isLongPressed() && !this.mRecyclerView.isPenMultiSelectionOn())) {
            this.mBottomMenuController.showBottomNavigation(false);
            updateBasicEffect(false);
            return;
        }
        this.mBottomMenuController.inflateBottomNavigationMenu(C8003R.menu.folderlist_manage_edit_bottom, new NavigationBarView.OnItemSelectedListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.mode.ManageEditMode.2
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return ManageEditMode.this.mFragmentContract.getMode().onOptionsItemSelected(menuItem);
            }
        });
        this.mBottomMenuController.showBottomNavigation(true);
        updateBasicEffect(true);
        Menu bottomNavigationMenu = this.mBottomMenuController.getBottomNavigationMenu();
        if (bottomNavigationMenu == null) {
            return;
        }
        int folderCount = this.mPresenter.getFolderCount() - 1;
        MenuItem menuItemFindItem = bottomNavigationMenu.findItem(C8003R.id.action_delete);
        if (menuItemFindItem != null) {
            menuItemFindItem.setTitle(folderCount == this.mPresenter.getSelectedItemCount() ? C8003R.string.action_delete_all : C8003R.string.action_delete);
        }
        bottomNavigationMenu.removeItem(C8003R.id.action_MSNotes);
        if (i > 1) {
            bottomNavigationMenu.removeItem(C8003R.id.action_add_folder);
            bottomNavigationMenu.removeItem(C8003R.id.action_rename);
        }
    }

    private void updateBasicEffect(boolean z) {
        ViewModeUtils.updateRecyclerViewFadingEdge(this.mRecyclerView, z);
        ViewModeUtils.updateGoToTopButtonPosition(this.mBottomMenuController.getMFloatingBottomLayout(), z);
        ViewModeUtils.updateFloatingLayoutShadow(this.mRecyclerView, this.mBottomMenuController.getMFloatingBottomLayout(), this.mActionMenuController.getMultiFloatingView(), this.mActionMenuController.getFloatingToolbarLayout());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public int getModeIndex() {
        return 3;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean isDimItem(String str) {
        return this.mPresenter.getFolderMoveMap().isDimStatusItem(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (!this.mFragmentContract.setMode(2)) {
            return true;
        }
        this.mRecyclerView.stopScroll();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 29) {
            if (keyEvent.getAction() != 0 || (keyEvent.getMetaState() & 4096) != 4096) {
                return false;
            }
            onSelectAll(true);
            return true;
        }
        if (i == 32) {
            if (keyEvent.getAction() != 0 || (keyEvent.getMetaState() & 4096) != 4096) {
                return false;
            }
            this.mPresenter.showDeleteFolderDialog(0);
            return true;
        }
        if (i != 62 && i != 66) {
            return super.onCustomKeyEvent(i, keyEvent);
        }
        if (keyEvent.getAction() == 1 && this.mRecyclerView.isLongPressed()) {
            this.mRecyclerView.setLongPressed(false);
            this.mBottomMenuController.showBottomNavigation(true);
            updateBasicEffect(true);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onDataChanged(int i) {
        super.onDataChanged(i);
        if (this.mPresenter.getSelectedItemCount() != this.mPresenter.getFolderCount() - this.mPresenter.getDimFolderCount() || this.mPresenter.getSelectedItemCount() <= 0) {
            this.mActionMenuController.updateSelectedFolderCount(false, this.mPresenter.getSelectedItemCount());
        } else {
            onSelectAll(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onFolderSelected(FolderHolderInfo folderHolderInfo, int i) {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onItemLongPressed(int i) {
        this.mRecyclerView.requestDisallowInterceptTouchEvent(true);
        this.mRecyclerView.startLongPressMultiSelection();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onItemPressReleased() {
        scrollToBottomHolder();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onLayout() {
        this.mActionMenuController.startActionMode(this.mOnClickSelectAllListener, true);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(false, true);
        this.mActionMenuController.setToolbarTitle((String) null);
        this.mActionMenuController.setAppbarCollapsedState();
        this.mActionMenuController.enableScrollTransitionOfFloating(false);
        this.mBottomMenuController.enableScrollTransitionOfFloating(false);
        boolean zIsLongPressed = this.mRecyclerView.isLongPressed();
        if (this.mRecyclerView.getAdapter() != null) {
            this.mRecyclerView.setLongPressed(false);
            if (this.mPresenter.getSelectedItemCount() == this.mPresenter.getFolderCount() - this.mPresenter.getDimFolderCount()) {
                onSelectAll(true);
            } else {
                this.mActionMenuController.updateSelectedFolderCount(false, this.mPresenter.getSelectedItemCount());
            }
            this.mRecyclerView.setLongPressed(zIsLongPressed);
        }
        this.mPresenter.attachAddFolderItem(true, true);
        modeChangeAnimation(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onModeEnd() {
        this.mActionMenuController.finishActionMode();
        this.mPresenter.clearCheckedItems();
        this.mBottomMenuController.showBottomNavigation(false);
        updateBasicEffect(false);
        this.mActionMenuController.setHideSelectAllCheckbox();
        this.mActionMenuController.setDisplayHomeAsUpEnabled(false, true);
        this.mActionMenuController.enableScrollTransitionOfFloating(true);
        this.mBottomMenuController.enableScrollTransitionOfFloating(true);
        this.mPresenter.attachAddFolderItem(true, false);
        modeChangeAnimation(false);
        this.mFragment.getActivity().invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        ArrayList<String> checkedItemUuidList = this.mPresenter.getCheckedItemUuidList();
        if (checkedItemUuidList != null && !checkedItemUuidList.isEmpty()) {
            int itemId = menuItem.getItemId();
            if (itemId == C8003R.id.action_delete) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_EDIT_DELETE);
                setExpandFolderList(checkedItemUuidList);
                this.mPresenter.showDeleteFolderDialog(C8003R.id.action_delete);
                return true;
            }
            if (itemId == C8003R.id.action_move) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_EDIT_MOVE);
                setExpandFolderList(checkedItemUuidList);
                this.mPresenter.showFolderMoveDialog();
                return true;
            }
            if (itemId == C8003R.id.action_add_folder) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_EDIT_ADD_SUBFOLDER);
                this.mPresenter.showAddFolderDialog(checkedItemUuidList.get(0), C8003R.id.action_add_folder, getModeIndex());
                return true;
            }
            if (itemId == C8003R.id.action_rename) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, NotesSAConstants.EVENT_FOLDER_EDIT_RENAME);
                this.mPresenter.showRenameFolderDialog(checkedItemUuidList.get(0), C8003R.id.action_rename);
                return true;
            }
            int i = C8003R.id.action_change_color;
            if (itemId == i) {
                this.mPresenter.showChangeColorDialog(checkedItemUuidList, i);
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onPrepareOptionsMenu() {
        int iconMenuCount = this.mBottomMenuController.getIconMenuCount();
        int bottomActionMenuItemCount = getBottomActionMenuItemCount(this.mPresenter.getSelectedItemCount());
        MainLogger.m7254d(TAG, "onPrepareOptionsMenu# prev : " + iconMenuCount + ", cur : " + bottomActionMenuItemCount);
        this.mBottomMenuController.setIconMenuCount(bottomActionMenuItemCount);
        if (iconMenuCount == 0 || bottomActionMenuItemCount == 0 || iconMenuCount == bottomActionMenuItemCount) {
            showBottomNavigation(this.mPresenter.getSelectedItemCount());
        } else {
            this.mBottomMenuController.playItemChangeAnimation(false, new C7737b(this, 12));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void updateSelectedFolderCount(boolean z, int i) {
        this.mActionMenuController.updateSelectedFolderCount(z, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void showBottomNavigation() {
        showBottomNavigation(this.mPresenter.getSelectedItemCount());
    }
}
