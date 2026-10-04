package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubHeaderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditNameDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.CoeditEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditEditMode extends CoeditMode implements AbsEditModeView.Contract {
    private static final String TAG = "CoeditEditMode";
    private final AbsEditModeView mEditModeView;

    public CoeditEditMode(ModeParams modeParams) {
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
        if (getCheckedNotesSpaceId() == null) {
            return;
        }
        final String str = getCheckedNotesSpaceId().get(0);
        MainCoeditLogger.m7250d(TAG, "switchToNewNotebook# spaceId : " + str);
        CoeditNameDialogFragment coeditNameDialogFragment = new CoeditNameDialogFragment();
        coeditNameDialogFragment.setAnchorViewId(C8003R.id.action_switch_to_notebook);
        coeditNameDialogFragment.setEditDialogResultListener(new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditEditMode.1
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogDismiss() {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
            public void onEditDialogResult(int i, String str2, String str3, int i2) {
                CoeditEditMode.this.mSessionConnector.requestSpaceMove(str, str3, false);
                CoeditEditMode.this.onBackKeyDown();
            }
        });
        coeditNameDialogFragment.show(this.mFragment.getChildFragmentManager(), GcsConstants.DialogTag.ADD_NOTEBOOK);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public boolean callCustomKeyEventBase(int i, KeyEvent keyEvent) {
        return onCustomKeyEventBase(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 13;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public int getOptionMenuRes() {
        return this.mEditModeView.getOptionMenuRes();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        releaseEditMode();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.mEditModeView.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return this.mEditModeView.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        this.mEditModeView.onDataChanged(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        onLayoutBase();
        this.mSessionConnector.connect();
        this.mEditModeView.onLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        this.mSessionConnector.disconnect();
        this.mEditModeView.onModeEnd();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
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
        if (this.mNotesView.setMode(12)) {
            this.mRecyclerView.stopScroll();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
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
        if (commonHolderInfo.getHolderType() == 4096 && FeatureUtils.isNotSupportCheckingSubHeader(((SubHeaderHolderInfo) commonHolderInfo).getId())) {
            return;
        }
        checkBox.setVisibility(0);
        this.mEditModeView.updateCheckBoxState(commonHolderInfo, checkBox);
    }
}
