package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu;

import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckNotesCountInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class OldEditModeView extends AbsEditModeView {
    private static final String TAG = "OldEditModeView";

    public OldEditModeView(ModeParams modeParams, AbsEditModeView.Contract contract) {
        super(modeParams, contract);
    }

    private long appendConvert() {
        return ConvertTaskManager.getInstance().findConvertTaskGroup(2, 4, null) ? 512L : 0L;
    }

    private long appendDeleteAll(int i, int i2) {
        return i == i2 ? 2048L : 0L;
    }

    private long appendFavorite(CheckNotesCountInfo checkNotesCountInfo, int i) {
        if (i == 0 || i > 100) {
            return 12288L;
        }
        return i == checkNotesCountInfo.getFavoriteNotesCount() ? 8192L : 4096L;
    }

    private long appendLockNoteMenu(CheckNotesCountInfo checkNotesCountInfo, int i) {
        if (i == 0 || i > 100 || !LockUtils.isLockMenuEnabled(this.mFragment.getContext())) {
            return 6L;
        }
        int lockedNotesCount = checkNotesCountInfo.getLockedNotesCount();
        long j = 4;
        if (i != lockedNotesCount) {
            return 4L;
        }
        int importLockedNotesCount = checkNotesCountInfo.getImportLockedNotesCount();
        if (lockedNotesCount != importLockedNotesCount && importLockedNotesCount < 2 && DeviceUtils.isSupportedFileProvider()) {
            j = 0;
        }
        return 2 | j;
    }

    private long appendShare(CheckNotesCountInfo checkNotesCountInfo) {
        return checkNotesCountInfo.getLockedNotesCount() > 0 ? 16L : 0L;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public long getCurrentOptionsMenuStatus() {
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]);
        int checkedNotesCount = this.mPresenter.getCheckedNotesCount();
        CheckNotesCountInfo checkNotesCountInfo = this.mPresenter.getCheckNotesCountInfo();
        return appendLockNoteMenu(checkNotesCountInfo, checkedNotesCount) | appendDeleteAll(commonDisplayListSize, checkedNotesCount) | appendShare(checkNotesCountInfo) | appendConvert() | appendFavorite(checkNotesCountInfo, checkedNotesCount);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public int getOptionMenuRes() {
        return C8003R.menu.old_noteslist_edit_bottom;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onFilteredOptionsMenu(Menu menu) {
        if (menu == null) {
            return;
        }
        if ((this.mMenuStatus & 2048) > 0) {
            menu.findItem(C8003R.id.action_delete).setTitle(C8003R.string.action_delete_all);
        } else {
            menu.findItem(C8003R.id.action_delete).setTitle(C8003R.string.action_delete);
        }
        menu.findItem(C8003R.id.action_delete).setEnabled((this.mMenuStatus & 512) == 0);
        if ((this.mMenuStatus & 16) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_share);
        }
        if (menu.findItem(C8003R.id.action_convert) != null) {
            menu.findItem(C8003R.id.action_convert).setEnabled((512 & this.mMenuStatus) == 0);
        }
        if ((this.mMenuStatus & 4096) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_remove_from_favorites);
        }
        if ((this.mMenuStatus & 8192) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_add_to_favorites);
        }
        long j = this.mMenuStatus;
        if ((2 & j) <= 0 || (j & 4) <= 0) {
            setLockIcon(menu.findItem(C8003R.id.action_lock), (this.mMenuStatus & 4) > 0);
        } else {
            AbsEditModeView.removeItem(menu, C8003R.id.action_lock);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        if (this.mPresenter.checkRunningTask(LockTask.TAG)) {
            MainLogger.m7254d(TAG, "onOptionsItemSelected# return - lock task is running");
            return false;
        }
        MainCoeditLogger.m7250d(TAG, "onOptionsItemSelected# onClick : " + ((Object) menuItem.getTitle()));
        int itemId = menuItem.getItemId();
        if (itemId == C8003R.id.action_share) {
            this.mPresenter.shareOldNotes();
        } else if (itemId == C8003R.id.action_convert) {
            CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, NotesSAConstants.EVENT_OLDNOTES_EDIT_CONVERT, this.mPresenter.getCheckedDataCount());
            this.mPresenter.showConvertConfirmDialog();
        } else if (itemId == C8003R.id.action_delete) {
            CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, NotesSAConstants.EVENT_OLDNOTES_EDIT_DELETE, this.mPresenter.getCheckedDataCount());
            this.mPresenter.showDeleteDialog();
        } else if (itemId == C8003R.id.action_lock) {
            if (isUnlock()) {
                this.mPresenter.setUnlockNotes();
            } else {
                this.mPresenter.setLockNotes();
            }
        } else if (itemId == C8003R.id.action_remove_from_favorites) {
            this.mPresenter.updateFavorite(false);
        } else if (itemId == C8003R.id.action_add_to_favorites) {
            this.mPresenter.updateFavorite(true);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onPrepareContextMenu(Menu menu) {
        super.onPrepareContextMenu(menu);
        onFilteredOptionsMenu(menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onPrepareOptionsMenu() {
        super.onPrepareOptionsMenu();
        if (this.mPresenter.getCheckedDataCount() == 0) {
            this.mBottomMenuController.showBottomNavigation(false);
            updateBasicEffect(false);
            return;
        }
        this.mBottomMenuController.inflateBottomNavigationMenu(getOptionMenuRes(), new C7737b(this, 16));
        if (!this.mModeParams.getNotesRecyclerView().isLongPressed()) {
            this.mBottomMenuController.showBottomNavigation(true);
            updateBasicEffect(true);
            this.mBottomMenuController.checkProgressCircle();
        }
        onFilteredOptionsMenu(this.mBottomMenuController.getBottomNavigationMenu());
    }
}
