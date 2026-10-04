package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.res.Configuration;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PickEditWidgetMode extends PickEditMode {
    private static final String TAG = "PickEditWidgetMode";

    public PickEditWidgetMode(ModeParams modeParams) {
        super(modeParams);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return this.mPresenter.getStateInfo().getCaller() == 14 ? 28 : 25;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.menu.PickEditModeView.Contract
    public int getModeSearchIndex() {
        return 26;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
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
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mRecyclerView.seslSetFadingEdgeEnabled(true, this.mEditModeView.isExtendBottomFadingEdge());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        this.mPresenter.setCheckedDimmedNotes(this.mFragment.getArguments());
        return super.onDataChangedByMode(list);
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

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        onLayoutBase();
        this.mEditModeView.onLayout();
        this.mActionMenuController.toggleActionModeToolbar(this.mPresenter.getCheckedDataCount() > 0);
        this.mActionMenuController.setStartMarginToToolbarTitle(true);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(false);
        this.mActionMenuController.setAppbarCollapsedState();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        final String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
        if (PermissionHelper.isPermissionGranted(this.mFragment.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.PickEditWidgetMode.1
            @Override // java.lang.Runnable
            public void run() {
                PermissionHelper.requestPermissions((Fragment) PickEditWidgetMode.this.mFragment, 102, true, storagePermissions);
            }
        }, storagePermissions) && !this.mPresenter.isUuidInCheckedDimmedNotes(mainEntryParam.getUuid())) {
            super.onNoteSelected(mainEntryParam);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void onRestoreDataChanged(int i) {
        setNoNotesLayoutVisibility();
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.toggleActionModeToolbar(checkedDataCount > 0);
        this.mActionMenuController.updateSelectedNoteCount(false, checkedDataCount);
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
