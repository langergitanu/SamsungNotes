package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditNameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.CoeditEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSearchEditMode extends CoeditSearchMode implements AbsEditModeView.Contract {
    private static final String TAG = "CoeditSearchEditMode";
    private final AbsEditModeView mEditModeView;

    public CoeditSearchEditMode(ModeParams modeParams) {
        super(modeParams);
        this.mEditModeView = new CoeditEditModeView(modeParams, this, true);
    }

    private ArrayList<String> getCheckedNotesSpaceId() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = this.mPresenter.getCheckedNotesUUID().iterator();
        while (it.hasNext()) {
            MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(it.next());
            if (noteData != null) {
                arrayList.add(noteData.getMdeSpaceId());
            }
        }
        MainCoeditLogger.m7250d(TAG, "getCheckedNotesSpaceId# size : " + arrayList.size());
        return arrayList;
    }

    private void switchToNewNotebook() {
        final String str = getCheckedNotesSpaceId().get(0);
        MainCoeditLogger.m7250d(TAG, "switchToNewNotebook# spaceId : " + str);
        CoeditNameDialogFragment coeditNameDialogFragment = new CoeditNameDialogFragment();
        coeditNameDialogFragment.setAnchorViewId(C8003R.id.action_switch_to_notebook);
        coeditNameDialogFragment.setEditDialogResultListener(new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditSearchEditMode.1
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogDismiss() {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogResult(int i, String str2, String str3, int i2) {
                CoeditSearchEditMode.this.mSessionConnector.requestSpaceMove(str, str3, false);
                CoeditSearchEditMode.this.onBackKeyDown();
            }
        });
        coeditNameDialogFragment.show(this.mFragment.getChildFragmentManager(), GcsConstants.DialogTag.ADD_NOTEBOOK);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public boolean callCustomKeyEventBase(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void changeViewMode() {
        if (this.mPresenter.getStateInfo().getModeIndex() == 16 || this.mPresenter.getStateInfo().getPrevModeIndex() == 16) {
            return;
        }
        this.mPresenter.viewModeChanged(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 17;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public int getOptionMenuRes() {
        return this.mEditModeView.getOptionMenuRes();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void leaveSharedNote() {
        MainListDocumentData noteData;
        ArrayList<String> checkedNotesUUID = this.mPresenter.getCheckedNotesUUID();
        if (checkedNotesUUID.size() == 1 && (noteData = this.mPresenter.getDocumentMap().getNoteData(checkedNotesUUID.get(0))) != null) {
            this.mSelectedGroupId = noteData.getMdeGroupId();
            this.mSelectedSpaceId = noteData.getMdeSpaceId();
            MainCoeditLogger.m7250d(TAG, "leaveSharedNote# groupId: " + this.mSelectedGroupId + ", spaceId: " + this.mSelectedSpaceId);
            leaveSpace(this.mSelectedGroupId, this.mSelectedSpaceId, false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN);
        return this.mNotesView.setMode(16);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(CommonHolderInfo commonHolderInfo) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.mEditModeView.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        onDataChangedBase(i);
        this.mEditModeView.onDataChanged(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        return onItemLongPressedBase(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        this.mSessionConnector.connect();
        this.mEditModeView.onLayout();
        this.mSearchModeView.disableSearchView();
        updateBasicEffect(false);
        this.mSearchModeView.onFiltersSearchViewModeChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        changeViewMode();
        if (this.mPresenter.getStateInfo().getModeIndex() != 16) {
            this.mSearchModeView.onModeEnd();
        }
        this.mSessionConnector.disconnect();
        this.mEditModeView.onModeEnd();
        this.mSearchModeView.setSkipQuery(true);
        this.mSearchModeView.showSearchView(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        onItemChecked(mainEntryParam.getUuid(), !this.mPresenter.isUuidInCheckedNotes(mainEntryParam.getUuid()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!UserInputSkipper.isValidEvent(UserInputSkipper.Tag.Menu)) {
            return false;
        }
        if (this.mEditModeView.onOptionsItemSelected(menuItem)) {
            return true;
        }
        if (menuItem.getItemId() == C8003R.id.action_switch_to_notebook) {
            switchToNewNotebook();
        } else if (menuItem.getItemId() == C8003R.id.action_leave_shared_note) {
            leaveSharedNote();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareContextMenu(Menu menu) {
        this.mEditModeView.onPrepareContextMenu(menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        this.mEditModeView.onPrepareOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void onRestoreDataChanged(int i) {
        super.onDataChangedViewUpdate(i);
        this.mEditModeView.updateActionMenu(i);
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
    public boolean onSubHeaderSelected(boolean z, int i) {
        this.mEditModeView.onSubHeaderSelected(z, i);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void releaseEditMode() {
        super.releaseEditMode();
        this.mPresenter.getSearchHelper().onEditModeChanged();
        onBackKeyDown();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void setNoNotesLayoutVisibility() {
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
