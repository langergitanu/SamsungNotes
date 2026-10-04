package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubHeaderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa.NotesListSALogModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsEditModeView {
    private static final String TAG = "AbsEditModeView";
    protected final ActionMenuController mActionMenuController;
    protected final BottomMenuController mBottomMenuController;
    protected final Contract mContract;
    protected final AbsFragment mFragment;
    protected final ModeParams mModeParams;
    protected final NotesPresenter mPresenter;
    protected boolean mUnlock = false;
    protected long mMenuStatus = 0;
    private final ActionMenuController.OnClickSelectAllListener mOnClickSelectAllListener = new ActionMenuController.OnClickSelectAllListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.1
        @Override // com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.OnClickSelectAllListener
        public void onClick(boolean z) {
            NotesListSALogModel.addSAlogOnSelectAll(AbsEditModeView.this.mContract.getModeIndex(), z, AbsEditModeView.this.mModeParams.getPresenter().getStateInfo().getFolderUuid());
            AbsEditModeView.this.mModeParams.getNotesView().getMode().onSelectAll(z);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean callCustomKeyEventBase(int i, KeyEvent keyEvent);

        long getCurrentOptionsMenuStatus();

        long getLastOptionsMenuStatus();

        int getModeIndex();

        void releaseEditMode();
    }

    public AbsEditModeView(ModeParams modeParams, Contract contract) {
        this.mModeParams = modeParams;
        this.mFragment = (AbsFragment) modeParams.getFragmentContract();
        this.mActionMenuController = modeParams.getActionMenuController();
        this.mBottomMenuController = modeParams.getBottomMenuController();
        this.mPresenter = modeParams.getPresenter();
        this.mContract = contract;
    }

    public static void disableItem(Menu menu, int i) {
        if (menu == null || menu.findItem(i) == null) {
            return;
        }
        menu.findItem(i).setEnabled(false);
    }

    public static void removeItem(Menu menu, int i) {
        if (menu == null) {
            return;
        }
        menu.removeItem(i);
    }

    public boolean checkIsNotCoeditSupportedPageMode() {
        ArrayList<String> checkedNotesUUID = this.mPresenter.getCheckedNotesUUID();
        if (checkedNotesUUID == null) {
            return false;
        }
        Iterator<String> it = checkedNotesUUID.iterator();
        while (it.hasNext()) {
            MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(it.next());
            if (noteData != null && noteData.getPageMode() != 2) {
                return true;
            }
        }
        return false;
    }

    public abstract long getCurrentOptionsMenuStatus();

    public long getMenuStatus() {
        return this.mMenuStatus;
    }

    public abstract int getOptionMenuRes();

    public boolean isUnlock() {
        return this.mUnlock;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.noteslist_edit_action_menu, menu);
    }

    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 29) {
            if (keyEvent.getAction() != 0 || (keyEvent.getMetaState() & 4096) != 4096) {
                return false;
            }
            onSelectAll(true);
            return true;
        }
        if (i != 32) {
            if (i != 62 && i != 66) {
                return this.mContract.callCustomKeyEventBase(i, keyEvent);
            }
            if (keyEvent.getAction() == 1 && this.mModeParams.getNotesRecyclerView().isLongPressed()) {
                this.mModeParams.getNotesRecyclerView().setLongPressed(false);
                this.mBottomMenuController.showBottomNavigation(true);
                updateBasicEffect(true);
            }
            return true;
        }
        if (keyEvent.getAction() != 0 || (keyEvent.getMetaState() & 4096) != 4096 || this.mPresenter.getCheckedDataCount() <= 0) {
            return false;
        }
        if (FeatureUtils.isCoeditMode(this.mContract.getModeIndex()) || FeatureUtils.isCoeditSpaceMode(this.mContract.getModeIndex())) {
            this.mPresenter.showDeleteCoeditNotesDialog();
        } else {
            this.mPresenter.showDeleteDialog();
        }
        return true;
    }

    public void onDataChanged(int i) {
        if (i == 0) {
            this.mContract.releaseEditMode();
        } else {
            this.mPresenter.recalculateCheckedData();
            updateActionMenu(i);
        }
    }

    public abstract void onFilteredOptionsMenu(Menu menu);

    public void onLayout() {
        this.mMenuStatus = -1L;
        this.mActionMenuController.enableScrollTransitionOfFloating(false);
        this.mBottomMenuController.enableScrollTransitionOfFloating(false);
        this.mActionMenuController.startActionMode(this.mOnClickSelectAllListener);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(false);
        this.mActionMenuController.setToolbarTitle((String) null);
        this.mActionMenuController.setToolbarSubTitle((String) null);
        this.mPresenter.modeChangeAnimation(true);
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders);
        if (commonDisplayListSize <= 0 || commonDisplayListSize > this.mPresenter.getCheckedDataCount()) {
            this.mActionMenuController.updateSelectedNoteCount(false, this.mPresenter.getCheckedDataCount());
        } else {
            onSelectAll(true);
        }
    }

    public void onModeEnd() {
        MainLogger.m7254d(TAG, "onModeEnd");
        this.mActionMenuController.enableScrollTransitionOfFloating(true);
        this.mBottomMenuController.enableScrollTransitionOfFloating(true);
        this.mActionMenuController.finishActionMode();
        this.mPresenter.clearCheckedData();
        this.mPresenter.modeChangeAnimation(false);
        this.mPresenter.updateFolderExpandBarHolder();
        if (!FeatureUtils.isSearchEditMode(this.mContract.getModeIndex())) {
            this.mBottomMenuController.showBottomNavigation(false);
        }
        updateBasicEffect(false);
        this.mPresenter.setLastOpenedSDocXUuid(null);
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.invalidateOptionsMenu();
    }

    public abstract boolean onOptionsItemSelected(MenuItem menuItem);

    public void onPrepareContextMenu(Menu menu) {
        this.mMenuStatus = getCurrentOptionsMenuStatus();
    }

    public void onPrepareOptionsMenu() {
        this.mMenuStatus = getCurrentOptionsMenuStatus();
    }

    public void onSelectAll(boolean z) {
        AbstractC6670b.m4739D("onSelectAll# ", TAG, z);
        if (this.mPresenter.getLongPressFlag()) {
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_MULTI_SELECTION, "1");
        }
        this.mPresenter.selectAll(z);
        this.mActionMenuController.updateSelectedNoteCount(z, this.mPresenter.getCheckedDataCount());
    }

    public void onSubHeaderSelected(boolean z, int i) {
        this.mPresenter.selectAllWithTimeSubHeader(z, i);
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.updateSelectedNoteCount(checkedDataCount == this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders), checkedDataCount);
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.mModeParams.getNotesView().filteredInvalidateOptionsMenu();
        }
    }

    public void setLockIcon(MenuItem menuItem, boolean z) {
        if (menuItem == null) {
            return;
        }
        if (z) {
            menuItem.setIcon(C8003R.drawable.ic_lock_line);
            menuItem.setTitle(C8003R.string.action_more_lock);
        } else {
            menuItem.setIcon(C8003R.drawable.ic_unlock);
            menuItem.setTitle(C8003R.string.action_unlock);
        }
        this.mUnlock = !z;
    }

    public void updateActionMenu(int i) {
        if (i <= this.mPresenter.getCheckedDataCount()) {
            onSelectAll(true);
        } else {
            this.mActionMenuController.updateSelectedNoteCount(false, this.mPresenter.getCheckedDataCount());
        }
    }

    public void updateBasicEffect(boolean z) {
        this.mModeParams.getNotesView().getMode().updateBasicEffect(z);
    }

    public void updateCheckBoxState(CommonHolderInfo commonHolderInfo, CheckBox checkBox) {
        boolean zIsUuidInCheckedData;
        if (commonHolderInfo.getHolderType() == 4096) {
            SubHeaderHolderInfo subHeaderHolderInfo = (SubHeaderHolderInfo) commonHolderInfo;
            long id = subHeaderHolderInfo.getId();
            if (id == -15 || id == -14 || id == -16) {
                zIsUuidInCheckedData = this.mPresenter.isSubHeaderChecked(subHeaderHolderInfo.getId() == -15);
            } else {
                List<String> subHeaderUuidList = this.mPresenter.getDocumentMap().getSubHeaderUuidList(commonHolderInfo.getPosition());
                zIsUuidInCheckedData = this.mPresenter.isSubHeaderChecked(subHeaderUuidList);
                if (zIsUuidInCheckedData && this.mPresenter.isSubHeaderAllDimmed(subHeaderUuidList)) {
                    MainLogger.m7254d(TAG, "#updateCheckBoxState header#" + commonHolderInfo.getPosition() + " all item are dimmed");
                    commonHolderInfo.setEnable(false);
                } else {
                    commonHolderInfo.setEnable(true);
                }
            }
        } else {
            zIsUuidInCheckedData = this.mPresenter.isUuidInCheckedData(commonHolderInfo.getUuid());
        }
        this.mPresenter.setCheckBoxState(commonHolderInfo);
        checkBox.setChecked(zIsUuidInCheckedData);
        checkBox.jumpDrawablesToCurrentState();
        this.mPresenter.updateContentDescription(commonHolderInfo, true);
    }

    public boolean onSubHeaderSelected(boolean z, int i, int i2) {
        boolean zSelectAllWithTimeSubHeader = this.mPresenter.selectAllWithTimeSubHeader(z, i, i2);
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.updateSelectedNoteCount(checkedDataCount == this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders), checkedDataCount);
        return zSelectAllWithTimeSubHeader;
    }
}
