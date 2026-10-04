package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.RecycleBinEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecycleBinEditMode extends RecycleBinSelectMode implements AbsEditModeView.Contract {
    private static final String TAG = "RecycleBinEditMode";
    private final AbsEditModeView mEditModeView;

    public RecycleBinEditMode(ModeParams modeParams) {
        super(modeParams);
        this.mEditModeView = new RecycleBinEditModeView(modeParams, this);
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

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 6;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        WorkerTaskManager.getInstance().cancelRunningTask(RestoreTask.TAG, this.mFragment.getActivity().hashCode());
        releaseEditMode();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(CommonHolderInfo commonHolderInfo) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.noteslist_edit_action_menu, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return this.mEditModeView.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        onDataChangedBase(i);
        this.mEditModeView.onDataChanged(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        return onItemLongPressedBase(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        onLayoutBase();
        this.mEditModeView.onLayout();
        this.mPresenter.checkRunningTask(RestoreTask.TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        this.mEditModeView.onModeEnd();
        showRecycleBinMessage(this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]) > 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        onItemChecked(mainEntryParam.getUuid(), !this.mPresenter.isUuidInCheckedNotes(mainEntryParam.getUuid()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mEditModeView.onOptionsItemSelected(menuItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        this.mEditModeView.onPrepareOptionsMenu();
        showRecycleBinMessage(this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]) > 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void onRestoreDataChanged(int i) {
        onDataChangedBase(i);
        this.mEditModeView.updateActionMenu(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSelectAll(boolean z) {
        this.mEditModeView.onSelectAll(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSubFolderSelected(String str) {
        onItemChecked(str, !this.mPresenter.isUuidInCheckedFolder(str));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSubHeaderSelected(boolean z, int i) {
        this.mEditModeView.onSubHeaderSelected(z, i);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onWindowFocusChanged(boolean z) {
        this.mEditModeView.onWindowFocusChanged(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void releaseEditMode() {
        super.releaseEditMode();
        if (this.mNotesView.setMode(5)) {
            CommonSamsungAnalytics.insertLog("531");
            this.mRecyclerView.stopScroll();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
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
        checkBox.setVisibility(0);
        this.mEditModeView.updateCheckBoxState(commonHolderInfo, checkBox);
    }
}
