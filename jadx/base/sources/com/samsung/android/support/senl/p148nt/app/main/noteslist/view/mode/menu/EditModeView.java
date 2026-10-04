package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu;

import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckNotesCountInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa.NotesListSALogModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderUtils;
import java.util.ArrayList;
import java.util.Iterator;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EditModeView extends AbsEditModeView {
    private static final String TAG = "EditModeView";

    public EditModeView(ModeParams modeParams, AbsEditModeView.Contract contract) {
        super(modeParams, contract);
    }

    private long appendConvert(long j) {
        return ((32 & j) == 0 && ConvertTaskManager.getInstance().findConvertTaskGroup(2, 4, null)) ? j | 512 : j;
    }

    private long appendCover(CheckNotesCountInfo checkNotesCountInfo, int i, int i2) {
        if (i2 > 0 || checkNotesCountInfo.getLockedNotesCount() > 0 || checkNotesCountInfo.getOldNotesCount() > 0 || i != 1) {
            return 0L;
        }
        return this.mPresenter.getCoverHelper().isActiveCover(this.mPresenter.getDocumentMap().getNoteData(this.mPresenter.getCheckedNotesUUID().get(0))) ? 131072L : 0L;
    }

    private long appendDeleteAll(int i, int i2) {
        return this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders) == i + i2 ? 2048L : 0L;
    }

    private long appendDetails(CheckNotesCountInfo checkNotesCountInfo, int i, int i2) {
        return (i2 > 0 || checkNotesCountInfo.getLockedNotesCount() > 0 || checkNotesCountInfo.getOldNotesCount() > 0 || i != 1) ? 0L : 262144L;
    }

    private long appendDuplicate(CheckNotesCountInfo checkNotesCountInfo, boolean z) {
        return (z || checkNotesCountInfo.getLockedNotesCount() > 0) ? 16384L : 0L;
    }

    private long appendFavorite(CheckNotesCountInfo checkNotesCountInfo, int i, int i2) {
        if (i + i2 == 0) {
            return 12288L;
        }
        return i2 == checkNotesCountInfo.getFavoriteNotesCount() ? 8192L : 4096L;
    }

    private long appendFolderMenu(int i, int i2) {
        if (i <= 0) {
            return 0L;
        }
        if (i2 == 0) {
            return i == 1 ? 29110L : 28982L;
        }
        return 28726L;
    }

    private long appendLockNoteMenu(CheckNotesCountInfo checkNotesCountInfo, int i) {
        int lockedNotesCount = checkNotesCountInfo.getLockedNotesCount();
        if (i != lockedNotesCount) {
            return 4L;
        }
        int importLockedNotesCount = checkNotesCountInfo.getImportLockedNotesCount();
        return ((lockedNotesCount == importLockedNotesCount || importLockedNotesCount >= 2 || !DeviceUtils.isSupportedFileProvider()) ? 20L : 0L) | 2;
    }

    private long appendMaxNoteMenu(int i) {
        return i <= 100 ? 0L : 28720L;
    }

    private long appendNoticeOverNotes(int i, int i2) {
        if (i != 0 || i2 <= 100) {
            return 0L;
        }
        long j = this.mMenuStatus;
        return ((j & 524288) > 0 || (j & 1048576) > 0) ? 1048576L : 524288L;
    }

    private long appendOldNoteMenu(CheckNotesCountInfo checkNotesCountInfo, int i, int i2) {
        int oldNotesCount = checkNotesCountInfo.getOldNotesCount();
        if (oldNotesCount <= 0) {
            return i2 + i > 1000 ? 40L : 32L;
        }
        ArrayList<String> checkedNotesUUID = this.mPresenter.getCheckedNotesUUID();
        long j = (i2 != oldNotesCount || checkNotesCountInfo.getLockedNotesCount() > 0) ? 16440L : 16392L;
        Iterator<String> it = checkedNotesUUID.iterator();
        while (it.hasNext()) {
            if (ConvertTaskManager.getInstance().isConverting(it.next())) {
                return 1024 | j;
            }
        }
        return j;
    }

    private long appendSaveAsFile(CheckNotesCountInfo checkNotesCountInfo, int i, int i2, boolean z) {
        return (z || i2 == checkNotesCountInfo.getImportLockedNotesCount() || i2 > 100 || i > 0 || checkNotesCountInfo.getOldNotesCount() > 0 || !DeviceUtils.isSupportedFileProvider() || EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(this.mFragment.getContext())) ? 0L : 64L;
    }

    private long appendSecureFolderMove(CheckNotesCountInfo checkNotesCountInfo, int i, int i2, boolean z) {
        if (!z && SecureFolderUtils.isEnabled(this.mFragment.getContext())) {
            int importLockedNotesCount = checkNotesCountInfo.getImportLockedNotesCount();
            if (checkNotesCountInfo.getOldNotesCount() <= 0 && importLockedNotesCount <= 0 && i <= 0 && i2 > 0 && i2 <= 100) {
                ArrayList<CheckedNoteInfo> checkedNotes = this.mPresenter.getCheckedNotes();
                if (checkedNotes.isEmpty()) {
                    return 0L;
                }
                Iterator<CheckedNoteInfo> it = checkedNotes.iterator();
                while (it.hasNext()) {
                    if (it.next().getUnknownMinVersion() != 0) {
                        return 1L;
                    }
                }
                return 0L;
            }
        }
        return 1L;
    }

    private long appendShare(boolean z) {
        return z ? 16L : 0L;
    }

    private long appendStartCoedit(CheckNotesCountInfo checkNotesCountInfo, int i, int i2) {
        if (CommonUtil.isInitializedSpenSdk(BaseUtils.getApplicationContext())) {
            return (i2 != 1 || i > 0 || checkNotesCountInfo.getOldNotesCount() > 0 || this.mPresenter.hasCoeditUnsupportedFormatVersion()) ? 98304L : 0L;
        }
        new DataTask(this.mFragment.getActivity()).run(new RunnableC0284b(13));
        return 98304L;
    }

    private long appendUnsupportedLock(int i) {
        return (!LockUtils.isLockMenuEnabled(this.mFragment.getContext()) || i > 1000) ? 6L : 0L;
    }

    private int getBottomActionMenuItemCount() {
        long j = this.mMenuStatus;
        int i = (8 & j) <= 0 ? 2 : 1;
        if ((2 & j) <= 0 || (4 & j) <= 0) {
            i++;
        }
        if ((16 & j) <= 0) {
            i++;
        }
        if ((256 & j) > 0) {
            i++;
        }
        if ((128 & j) > 0) {
            i++;
        }
        return (j & 32) <= 0 ? i + 1 : i;
    }

    private void invalidateMenu() {
        this.mBottomMenuController.inflateBottomNavigationMenu(getOptionMenuRes(), new C8677a(this));
        if (!this.mModeParams.getNotesRecyclerView().isLongPressed()) {
            this.mBottomMenuController.showBottomNavigation(true);
            updateBasicEffect(true);
            this.mBottomMenuController.checkProgressCircle();
        }
        onFilteredOptionsMenu(this.mBottomMenuController.getBottomNavigationMenu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$appendStartCoedit$2() {
        CommonUtil.initSpenSdk(BaseUtils.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$invalidateMenu$1(MenuItem menuItem) {
        return this.mModeParams.getNotesView().getMode().onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPrepareOptionsMenu$0(boolean z) {
        invalidateMenu();
        if (z) {
            return;
        }
        this.mBottomMenuController.playItemChangeAnimation(true, null);
    }

    private void onOptionsItemSelectedSALogging(int i) {
        NotesListSALogModel.addSAlogOnOptionsItemSelected(this.mContract.getModeIndex(), i, this.mUnlock, this.mPresenter.getCheckedDataCount(), this.mPresenter.getStateInfo().getFolderUuid());
        if (this.mPresenter.getLongPressFlag()) {
            if (i == C8003R.id.action_delete) {
                CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_MULTI_SELECTION, "2");
            } else if (i == C8003R.id.action_share) {
                CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_MULTI_SELECTION, "3");
            } else if (i == C8003R.id.action_move) {
                CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_MULTI_SELECTION, "4");
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public long getCurrentOptionsMenuStatus() {
        int checkedFoldersCount = this.mPresenter.getCheckedFoldersCount();
        int checkedNotesCount = this.mPresenter.getCheckedNotesCount();
        CheckNotesCountInfo checkNotesCountInfo = this.mPresenter.getCheckNotesCountInfo();
        NotesPresenter notesPresenter = this.mPresenter;
        boolean zHasGenUuidNote = notesPresenter.hasGenUuidNote(notesPresenter.getCheckedNotesUUID());
        long jAppendDeleteAll = appendDeleteAll(checkedFoldersCount, checkedNotesCount) | appendSecureFolderMove(checkNotesCountInfo, checkedFoldersCount, checkedNotesCount, zHasGenUuidNote) | appendNoticeOverNotes(checkedFoldersCount, checkedNotesCount) | appendFolderMenu(checkedFoldersCount, checkedNotesCount) | appendMaxNoteMenu(checkedNotesCount) | appendLockNoteMenu(checkNotesCountInfo, checkedNotesCount) | appendFavorite(checkNotesCountInfo, checkedFoldersCount, checkedNotesCount) | appendUnsupportedLock(checkedNotesCount) | appendOldNoteMenu(checkNotesCountInfo, checkedFoldersCount, checkedNotesCount) | appendShare(zHasGenUuidNote) | appendSaveAsFile(checkNotesCountInfo, checkedFoldersCount, checkedNotesCount, zHasGenUuidNote);
        return appendDetails(checkNotesCountInfo, checkedNotesCount, checkedFoldersCount) | jAppendDeleteAll | appendConvert(jAppendDeleteAll) | appendDuplicate(checkNotesCountInfo, zHasGenUuidNote) | appendStartCoedit(checkNotesCountInfo, checkedFoldersCount, checkedNotesCount) | appendCover(checkNotesCountInfo, checkedNotesCount, checkedFoldersCount);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public int getOptionMenuRes() {
        return C8003R.menu.noteslist_edit_bottom_menu;
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
        long j = this.mMenuStatus;
        if ((2 & j) <= 0 || (j & 4) <= 0) {
            setLockIcon(menu.findItem(C8003R.id.action_lock), (4 & this.mMenuStatus) > 0);
        } else {
            AbsEditModeView.removeItem(menu, C8003R.id.action_lock);
        }
        if ((this.mMenuStatus & 8) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_move);
        }
        if ((this.mMenuStatus & 16) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_share);
        }
        if ((this.mMenuStatus & 32) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_convert);
        }
        if ((this.mMenuStatus & 512) > 0) {
            AbsEditModeView.disableItem(menu, C8003R.id.action_convert);
        }
        if ((this.mMenuStatus & 1024) > 0) {
            AbsEditModeView.disableItem(menu, C8003R.id.action_delete);
        }
        if ((this.mMenuStatus & 128) <= 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_rename);
        }
        if ((this.mMenuStatus & 256) <= 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_change_color);
        }
        if ((this.mMenuStatus & 64) <= 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_save_as_file);
        }
        if ((this.mMenuStatus & 1) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_secure_folder_move);
        } else {
            String menuName = SecureFolderUtils.getMenuName(this.mFragment.getContext());
            if (menuName.isEmpty()) {
                AbsEditModeView.removeItem(menu, C8003R.id.action_secure_folder_move);
            } else {
                menu.findItem(C8003R.id.action_secure_folder_move).setTitle(menuName);
            }
        }
        if ((this.mMenuStatus & 4096) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_remove_from_favorites);
        }
        if ((this.mMenuStatus & 8192) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_add_to_favorites);
        }
        if ((this.mMenuStatus & 16384) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_duplicate);
        }
        long j2 = this.mMenuStatus;
        if ((32768 & j2) > 0 || (j2 & 65536) > 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_start_coedit);
        }
        if ((this.mMenuStatus & 131072) <= 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_edit_cover);
        }
        if ((this.mMenuStatus & 262144) <= 0) {
            AbsEditModeView.removeItem(menu, C8003R.id.action_details);
        }
        if ((this.mMenuStatus & 524288) > 0) {
            ToastHandler.show(this.mFragment.getContext(), C8003R.string.f6012x8bfba965, 0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(500L, tag);
        MainLogger.m7258i(TAG, "onOptionsItemSelectedEdit# " + ((Object) menuItem.getTitle()));
        if (this.mPresenter.checkRunningTask(LockTask.TAG)) {
            MainLogger.m7254d(TAG, "onOptionsItemSelected# return - lock task is running");
            return false;
        }
        int itemId = menuItem.getItemId();
        onOptionsItemSelectedSALogging(itemId);
        if (itemId == C8003R.id.action_delete) {
            if (this.mPresenter.getLongPressFlag()) {
                this.mPresenter.setLongPressFlag(false);
            }
            this.mPresenter.showDeleteDialog();
        } else if (itemId == C8003R.id.action_save_as_file) {
            this.mPresenter.showExportOptionPopup(true);
        } else if (itemId == C8003R.id.action_share) {
            if (this.mPresenter.getLongPressFlag()) {
                this.mPresenter.setLongPressFlag(false);
            }
            if (this.mPresenter.getCheckedNotesCount() == this.mPresenter.getCheckNotesCountInfo().getOldNotesCount()) {
                this.mPresenter.shareOldNotes();
            } else {
                this.mPresenter.showExportOptionPopup(false);
            }
        } else if (itemId == C8003R.id.action_rename) {
            this.mPresenter.showFolderRenameDialog();
        } else if (itemId == C8003R.id.action_move) {
            if (this.mPresenter.getLongPressFlag()) {
                this.mPresenter.setLongPressFlag(false);
            }
            this.mPresenter.showFolderPickerDialog();
        } else if (itemId == C8003R.id.action_lock) {
            if (this.mUnlock) {
                this.mPresenter.setUnlockNotes();
            } else {
                this.mPresenter.setLockNotes();
            }
        } else if (itemId == C8003R.id.action_secure_folder_move) {
            if (this.mPresenter.getNonCorruptedNotesUuid().isEmpty()) {
                ToastHandler.show(this.mFragment.getContext(), C8003R.string.base_string_failed_to_load_image, 0);
            } else {
                NotesPresenter notesPresenter = this.mPresenter;
                notesPresenter.moveToSecureFolder(notesPresenter.getCheckNotesCountInfo().getLockedNotesCount());
            }
        } else if (itemId == C8003R.id.action_remove_from_favorites) {
            this.mPresenter.updateFavorite(false);
        } else if (itemId == C8003R.id.action_add_to_favorites) {
            this.mPresenter.updateFavorite(true);
        } else if (itemId == C8003R.id.action_convert) {
            this.mPresenter.showConvertConfirmDialog();
        } else if (itemId == C8003R.id.action_change_color) {
            NotesPresenter notesPresenter2 = this.mPresenter;
            notesPresenter2.showChangeColorDialog(notesPresenter2.getCheckedFolderUUID());
        } else if (itemId == C8003R.id.action_duplicate) {
            this.mPresenter.duplicateToDevice();
        } else if (itemId == C8003R.id.action_start_coedit) {
            this.mPresenter.getCoeditHelper().showStartCoeditNote();
        } else if (itemId == C8003R.id.action_edit_cover) {
            this.mPresenter.getCoverHelper().showCoverEditDialog(this.mPresenter.getCheckedNotesUUID().get(0));
        } else if (itemId == C8003R.id.action_details) {
            this.mPresenter.getDetailsMenuHelper().showDetailsDialog(this.mPresenter.getCheckedNotesUUID().get(0));
        } else {
            if (itemId != C8003R.id.action_done) {
                return false;
            }
            this.mModeParams.getNotesView().getMode().releaseEditMode();
            if (DeviceInfo.isVSTModel()) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MAIN_EDIT, ComposerSAConstants.EVENT_VST_EDITING_LIST_DONE);
            }
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
        int iconMenuCount = this.mBottomMenuController.getIconMenuCount();
        if (this.mPresenter.getCheckedDataCount() == 0) {
            this.mBottomMenuController.showBottomNavigation(false);
            updateBasicEffect(false);
            this.mBottomMenuController.setIconMenuCount(0);
            return;
        }
        int bottomActionMenuItemCount = getBottomActionMenuItemCount();
        this.mBottomMenuController.setIconMenuCount(bottomActionMenuItemCount);
        MainLogger.m7254d(TAG, "onPrepareOptionsMenu# prev : " + iconMenuCount + ", cur : " + bottomActionMenuItemCount);
        if (iconMenuCount == 0 || bottomActionMenuItemCount == iconMenuCount) {
            invalidateMenu();
        } else {
            this.mBottomMenuController.playItemChangeAnimation(false, new C8677a(this));
        }
    }
}
