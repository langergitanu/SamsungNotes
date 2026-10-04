package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationBarView;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckNotesCountInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.CoeditEditModeView;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.GcsSpaceDeleteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.Iterator;
import p079T.C0283a;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SpaceEditMode extends SpaceSelectMode implements AbsEditModeView.Contract {
    private static final String TAG = "SpaceEditMode";
    private int mCheckedOwnershipCount;
    private final AbsEditModeView mEditModeView;

    public SpaceEditMode(ModeParams modeParams) {
        super(modeParams);
        this.mEditModeView = new CoeditEditModeView(modeParams, this, false);
        this.mIsEditMode = true;
    }

    private void appendStartCoedit(Menu menu, CheckNotesCountInfo checkNotesCountInfo, int i) {
        if (!CommonUtil.isInitializedSpenSdk(BaseUtils.getApplicationContext())) {
            new DataTask(this.mFragment.getActivity()).run(new RunnableC0284b(12));
            menu.removeItem(C8003R.id.action_save_to_new_coedit);
        } else if (i != 1 || checkNotesCountInfo.getOldNotesCount() > 0 || this.mPresenter.hasCoeditUnsupportedFormatVersion()) {
            menu.removeItem(C8003R.id.action_save_to_new_coedit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$appendStartCoedit$0() {
        CommonUtil.initSpenSdk(BaseUtils.getApplicationContext());
    }

    private void setOwnershipCount(int i) {
        this.mCheckedOwnershipCount = i;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public boolean callCustomKeyEventBase(int i, KeyEvent keyEvent) {
        return onCustomKeyEventBase(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getCurrentOptionsMenuStatus() {
        return 0L;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getLastOptionsMenuStatus() {
        return -1L;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 11;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        releaseEditMode();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(CommonHolderInfo commonHolderInfo) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return this.mEditModeView.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        onDataChangedBase(i);
        this.mEditModeView.onDataChanged(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onItemChecked(String str, boolean z) {
        this.mPresenter.setCheck(str, z, true);
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.updateSelectedNoteCount(checkedDataCount == this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]), checkedDataCount);
        updateSubHeaderCheckBox();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        return onItemLongPressedBase(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        onLayoutBase();
        this.mEditModeView.onLayout();
        GcsSpaceDeleteReceivedReceiver.registerReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        this.mEditModeView.onModeEnd();
        GcsSpaceDeleteReceivedReceiver.unregisterReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        onItemChecked(mainEntryParam.getUuid(), !this.mPresenter.isUuidInCheckedNotes(mainEntryParam.getUuid()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        if (menuItem.getItemId() == C8003R.id.action_delete) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_EDIT, NotesSAConstants.EVENT_GCS_SPACE_DELETE);
            this.mPresenter.showDeleteGcsSpaceNotesDialog(this.mCheckedOwnershipCount);
            return true;
        }
        if (menuItem.getItemId() == C8003R.id.action_save_to_device) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_EDIT, NotesSAConstants.EVENT_GCS_SPACE_SAVE_TO_DEVICE);
            this.mPresenter.duplicateToDevice();
            return true;
        }
        if (menuItem.getItemId() != C8003R.id.action_save_to_new_coedit) {
            return false;
        }
        showCoeditSpacePicker();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        if (checkedDataCount == 0) {
            this.mBottomMenuController.showBottomNavigation(false);
            updateBasicEffect(false);
            return;
        }
        this.mBottomMenuController.inflateBottomNavigationMenu(C8003R.menu.gcs_spacelist_edit, new NavigationBarView.OnItemSelectedListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SpaceEditMode.1
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return SpaceEditMode.this.mNotesView.getMode().onOptionsItemSelected(menuItem);
            }
        });
        if (!this.mRecyclerView.isLongPressed()) {
            this.mBottomMenuController.showBottomNavigation(true);
            updateBasicEffect(true);
        }
        ArrayList<String> checkedNotesUUID = this.mPresenter.getCheckedNotesUUID();
        C0283a.m562d().getClass();
        String strM561c = C0283a.m561c();
        Iterator<String> it = checkedNotesUUID.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(it.next());
            if (noteData != null) {
                if (strM561c == null || strM561c.equals(noteData.getMdeOwnerId())) {
                    i++;
                } else {
                    i2++;
                }
            }
        }
        setOwnershipCount(i);
        Menu bottomNavigationMenu = this.mBottomMenuController.getBottomNavigationMenu();
        if (bottomNavigationMenu == null) {
            return;
        }
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]);
        if (i2 > 0) {
            bottomNavigationMenu.removeItem(C8003R.id.action_delete);
        } else {
            if (checkedDataCount > 100) {
                bottomNavigationMenu.removeItem(C8003R.id.action_save_to_device);
            }
            if (commonDisplayListSize == checkedNotesUUID.size()) {
                bottomNavigationMenu.findItem(C8003R.id.action_delete).setTitle(C8003R.string.action_delete_all);
            } else {
                bottomNavigationMenu.findItem(C8003R.id.action_delete).setTitle(C8003R.string.action_delete);
            }
        }
        appendStartCoedit(bottomNavigationMenu, this.mPresenter.getCheckNotesCountInfo(), checkedNotesUUID.size());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSelectAll(boolean z) {
        this.mEditModeView.onSelectAll(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSubFolderSelected(String str) {
        onItemChecked(str, !this.mPresenter.isUuidInCheckedFolder(str));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSubHeaderSelected(long j, boolean z) {
        this.mPresenter.selectAllWithSubHeader(z, j == -15);
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.updateSelectedNoteCount(checkedDataCount == this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders), checkedDataCount);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onWindowFocusChanged(boolean z) {
        this.mEditModeView.onWindowFocusChanged(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void releaseEditMode() {
        super.releaseEditMode();
        if (this.mNotesView.setMode(10)) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT);
            this.mRecyclerView.stopScroll();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void showBottomNavigation(boolean z) {
        this.mBottomMenuController.showBottomNavigation(z);
        updateBasicEffect(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void updateCheckBoxState(CommonHolderInfo commonHolderInfo, CheckBox checkBox) {
        this.mEditModeView.updateCheckBoxState(commonHolderInfo, checkBox);
    }

    public void updateSubHeaderCheckBox() {
        if (this.mPresenter.getDocumentMap().hasHolderInfo(4)) {
            this.mPresenter.updateSubHeaderCheckBox(-15L);
            this.mPresenter.updateSubHeaderCheckBox(-14L);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSubHeaderSelected(boolean z, int i) {
        this.mEditModeView.onSubHeaderSelected(z, i);
        return true;
    }
}
