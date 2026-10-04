package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.PickerTabView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PickMode extends BaseMode {
    private static final String TAG = "PickMode";
    private final PickerTabView mPickerTabView;

    public PickMode(ModeParams modeParams) {
        super(modeParams);
        PickerTabView pickerTabView = new PickerTabView(this.mFragment);
        this.mPickerTabView = pickerTabView;
        pickerTabView.setTabContract(new PickerTabView.TabViewContract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.PickMode.1
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.PickerTabView.TabViewContract
            public void onTabSelected(String str) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK, NotesSAConstants.EVENT_PICK_ALL_NOTES);
                PickMode.this.mPresenter.clearCheckedData();
                PickMode.this.mNotesView.onFolderSelected(str);
            }
        });
    }

    private boolean isDisplayHomeAsUpEnabled() {
        int caller = this.mPresenter.getStateInfo().getCaller();
        return (caller == 1 || caller == 8 || caller == 13 || caller == 14) ? false : true;
    }

    private void setDisplayHomeAsUp() {
        if (isDisplayHomeAsUpEnabled()) {
            this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
            this.mActionMenuController.setStartMarginToToolbarTitle(false);
        } else {
            this.mActionMenuController.setDisplayHomeAsUpEnabled(false);
            this.mActionMenuController.setStartMarginToToolbarTitle(true);
        }
    }

    private void setTipCard() {
        if (hasCreatePostLogic()) {
            return;
        }
        MainLogger.m7258i(getTag(), "setTipCard# caller : 1");
        this.mPresenter.getTipCardHelper().clearTipCard(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return this.mPresenter.getStateInfo().getCaller() == 13 ? 27 : 7;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (!NotesUtils.isTabletLayout(this.mContext) && super.onBackKeyDown()) {
            return true;
        }
        String backFolderHistory = this.mPresenter.getDocumentMap().getBackFolderHistory();
        if ((backFolderHistory == null || FolderConstants.RecycleBin.UUID.equals(backFolderHistory) || !(FeatureUtils.isSubFolderExist(getModeIndex(), backFolderHistory) || FolderConstants.AllNotes.UUID.equals(backFolderHistory))) && !super.onBackKeyDown()) {
            this.mFragment.getActivity().finish();
            return true;
        }
        this.mNotesView.onFolderSelected(backFolderHistory);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mRecyclerView.seslSetFadingEdgeEnabled(true, this.mPickerTabView.getBottomTab() != null && this.mPickerTabView.getBottomTab().getVisibility() == 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(CommonHolderInfo commonHolderInfo) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.noteslist_pick, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 34) {
            if (i == 42) {
                if (keyEvent.getAction() == 0 || (keyEvent.getMetaState() & 4096) != 4096) {
                    return false;
                }
                this.mNotesView.onNewNote(FolderConstants.MyFolders.UUID, 1);
                return true;
            }
            if (i == 84) {
                return this.mNotesView.setMode(3);
            }
        } else if ((keyEvent.getMetaState() & 4096) == 4096) {
            return this.mNotesView.setMode(3);
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        setDisplayHomeAsUp();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        setTipCard();
        setDisplayHomeAsUp();
        this.mActionMenuController.setToolbarTitle(C8003R.string.select_notes);
        this.mActionMenuController.setAppbarCollapsedState();
        this.mBottomMenuController.getMFloatingBottomLayout().setVisibility(0);
        this.mPickerTabView.setBottomTab(0, this.mPresenter.getStateInfo().getFolderUuid());
        this.mBottomMenuController.addBlurForTabLayout(this.mPickerTabView.getBottomTab());
        updateBasicEffect(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        this.mPickerTabView.setBottomTab(8, this.mPresenter.getStateInfo().getFolderUuid());
        updateBasicEffect(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK, NotesSAConstants.EVENT_PICK_SELECT_NOTE);
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (this.mFragment.getActivity() == null) {
                return false;
            }
            this.mFragment.getActivity().onBackPressed();
            return true;
        }
        if (itemId == C8003R.id.action_search) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK, NotesSAConstants.EVENT_PICK_SEARCH);
            CommonSamsungAnalytics.insertLog("221");
            this.mNotesView.setMode(3);
            return true;
        }
        if (itemId == C8003R.id.action_create_note) {
            if (StorageUtils.isAvailableMemoryForNewMemo()) {
                this.mFragmentContract.onNewNote(this.mPresenter.getStateInfo().getFolderUuid(), 1);
            } else {
                DialogUtils.showNotEnoughStorageDialogFragment(this.mFragment.getContext(), this.mFragment.getChildFragmentManager());
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        if (this.mPresenter.getCheckedDataCount() == 0) {
            if (this.mPresenter.getDocumentMap().getCommonDisplayList().isEmpty()) {
                menu.removeItem(C8003R.id.action_search);
            }
            menu.removeItem(C8003R.id.action_cancel);
            menu.removeItem(C8003R.id.action_done);
        } else {
            menu.removeItem(C8003R.id.action_search);
            menu.removeItem(C8003R.id.action_create_note);
        }
        if (this.mPresenter.getStateInfo().getCaller() == 13) {
            menu.removeItem(C8003R.id.action_create_note);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSubFolderSelected(String str) {
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK, NotesSAConstants.EVENT_PICK_FOLDER_CONTAINER);
        super.onSubFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        if (this.mPresenter.getStateInfo().getCaller() == 9) {
            this.mNoHolderLayout.findViewById(C8003R.id.no_note_sub).setVisibility(8);
        }
    }
}
