package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchModeView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PickEditSearchWidgetMode extends PickEditSearchMode {
    private static final String TAG = "PickEditSearchWidgetMode";

    public PickEditSearchWidgetMode(ModeParams modeParams) {
        super(modeParams);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 26;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchMode
    public int getSearchCallerModeIndex() {
        return 28;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.menu.PickEditModeView.Contract
    public void handleActionDone() {
        sendNoteListToWidget();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onBindViewHolder(commonHolderInfo, checkBox, textView);
        onBindViewHolder(commonHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        setNoNotesLayoutVisibility();
        this.mPresenter.recalculateCheckedData();
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.toggleActionModeToolbar(checkedDataCount > 0);
        this.mActionMenuController.updateSelectedNoteCount(false, checkedDataCount);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onItemChecked(String str, boolean z) {
        onItemCheckedForWidget(str, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode
    public void onItemCheckedForWidget(String str, boolean z) {
        if (maxListWidget(z)) {
            return;
        }
        this.mPresenter.setCheck(str, z, true);
        updateSubHeaderCheckBox(str);
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.toggleActionModeToolbar(checkedDataCount > 0);
        if (checkedDataCount == 0) {
            this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
            this.mActionMenuController.setStartMarginToToolbarTitle(false);
        }
        this.mActionMenuController.updateSelectedNoteCount(false, checkedDataCount);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        this.mPresenter.getStateInfo().setSearchCallerMode(this.mPresenter.getStateInfo().getPrevModeIndex());
        this.mActionMenuController.enableEditCustomToolbarTitle();
        this.mActionMenuController.setAppbarCollapsedState();
        this.mActionMenuController.toggleActionModeToolbar(this.mPresenter.getCheckedDataCount() > 0);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
        this.mActionMenuController.setStartMarginToToolbarTitle(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        if (this.mPresenter.isUuidInCheckedDimmedNotes(mainEntryParam.getUuid())) {
            return;
        }
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void onRestoreDataChanged(int i) {
        setNoNotesLayoutVisibility();
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.toggleActionModeToolbar(checkedDataCount > 0);
        this.mActionMenuController.updateSelectedNoteCount(false, checkedDataCount);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mPresenter.getStateInfo().setSearchCallerMode(bundle.getInt(SearchModeView.KEY_SEARCH_CALLER_MODE));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(SearchModeView.KEY_SEARCH_CALLER_MODE, this.mPresenter.getStateInfo().getSearchCallerMode());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode
    public void onSelectAll() {
        onSelectAllForListWidget();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSubHeaderSelected(boolean z, int i) {
        return onSubHeaderSelectedForListWidget(z, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewAttachedToWindow(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onViewAttachedToWindow(commonHolderInfo, checkBox, textView);
        onViewAttachedToWindow(commonHolderInfo);
    }
}
