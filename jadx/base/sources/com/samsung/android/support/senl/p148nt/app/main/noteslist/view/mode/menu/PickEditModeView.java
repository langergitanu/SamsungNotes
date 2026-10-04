package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu;

import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.PickerTabView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PickEditModeView extends AbsEditModeView {
    protected final PickerTabView mPickerTabView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends AbsEditModeView.Contract {
        int getModeSearchIndex();

        void handleActionCreateNote();

        void handleActionDone();
    }

    public PickEditModeView(ModeParams modeParams, Contract contract) {
        super(modeParams, contract);
        PickerTabView pickerTabView = new PickerTabView(this.mFragment);
        this.mPickerTabView = pickerTabView;
        pickerTabView.setTabContract(new C7737b(this, 17));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long appendToggleButton() {
        long j;
        long j2;
        int modeIndex = this.mContract.getModeIndex();
        if (this.mPresenter.getCheckedNotesCount() == 0) {
            long j3 = this.mPresenter.getDocumentMap().getCommonDisplayList().isEmpty() ? 1L : 0L;
            j = 12 | j3;
            if (FeatureUtils.isSearchMode(modeIndex)) {
                j = 15 | j3;
            }
        } else {
            j = 3;
        }
        if (FeatureUtils.isPickEditMode(modeIndex) && !FeatureUtils.isSearchMode(modeIndex)) {
            if (this.mPresenter.getCheckedDataCount() <= (FeatureUtils.isPickEditWidgetMode(this.mContract.getModeIndex()) ? this.mPresenter.getCheckedDimmedNotesInFolderCount() : this.mPresenter.getCheckedDimmedNotesCount())) {
                j2 = 16;
            }
        } else {
            if (this.mModeParams.getNotesRecyclerView().isLongPressed()) {
                return j;
            }
            j2 = 32;
        }
        return j2 | j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str) {
        this.mPresenter.clearCheckedData();
        this.mModeParams.getNotesView().onFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public long getCurrentOptionsMenuStatus() {
        return appendToggleButton();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public int getOptionMenuRes() {
        return C8003R.menu.noteslist_pick;
    }

    public boolean isExtendBottomFadingEdge() {
        return this.mPickerTabView.getBottomTab() != null && this.mPickerTabView.getBottomTab().getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onFilteredOptionsMenu(Menu menu) {
        if ((this.mMenuStatus & 16) > 0) {
            this.mPickerTabView.setBottomTab(0, this.mPresenter.getStateInfo().getFolderUuid());
            updateBasicEffect(true);
        }
        if ((this.mMenuStatus & 32) > 0) {
            this.mPickerTabView.setBottomTab(8, this.mPresenter.getStateInfo().getFolderUuid());
            updateBasicEffect(false);
        }
        if (menu == null) {
            return;
        }
        if ((this.mMenuStatus & 8) > 0) {
            menu.removeItem(C8003R.id.action_cancel);
        }
        if ((this.mMenuStatus & 4) > 0) {
            menu.removeItem(C8003R.id.action_done);
        }
        if ((this.mMenuStatus & 1) > 0) {
            menu.removeItem(C8003R.id.action_search);
        }
        if ((this.mMenuStatus & 2) > 0) {
            menu.removeItem(C8003R.id.action_create_note);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onLayout() {
        super.onLayout();
        int modeIndex = this.mContract.getModeIndex();
        int i = (!FeatureUtils.isPickEditMode(modeIndex) || FeatureUtils.isSearchMode(modeIndex)) ? 8 : 0;
        this.mPickerTabView.setBottomTab(i, this.mPresenter.getStateInfo().getFolderUuid());
        this.mBottomMenuController.addBlurForTabLayout(this.mPickerTabView.getBottomTab());
        updateBasicEffect(i == 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onModeEnd() {
        super.onModeEnd();
        this.mPickerTabView.setBottomTab(8, this.mPresenter.getStateInfo().getFolderUuid());
        updateBasicEffect(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        int itemId = menuItem.getItemId();
        if (itemId == C8003R.id.action_cancel) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK_EDIT, NotesSAConstants.EVENT_PICK_EDIT_CANCEL);
            this.mFragment.getActivity().onBackPressed();
            return true;
        }
        if (itemId == C8003R.id.action_done) {
            ((Contract) this.mContract).handleActionDone();
            return true;
        }
        if (itemId == C8003R.id.action_create_note) {
            ((Contract) this.mContract).handleActionCreateNote();
        } else if (itemId == C8003R.id.action_search) {
            this.mModeParams.getNotesView().setMode(((Contract) this.mContract).getModeSearchIndex());
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK, NotesSAConstants.EVENT_PICK_SEARCH);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onPrepareOptionsMenu() {
        super.onPrepareOptionsMenu();
    }
}
