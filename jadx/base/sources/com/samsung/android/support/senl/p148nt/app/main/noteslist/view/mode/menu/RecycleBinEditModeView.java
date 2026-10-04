package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu;

import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecycleBinEditModeView extends AbsEditModeView {
    public RecycleBinEditModeView(ModeParams modeParams, AbsEditModeView.Contract contract) {
        super(modeParams, contract);
    }

    private long appendRestoreAndDeleteAll(int i, int i2) {
        return this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders) == i + i2 ? 2048L : 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onPrepareOptionsMenu$0(MenuItem menuItem) {
        return this.mModeParams.getNotesView().getMode().onOptionsItemSelected(menuItem);
    }

    private void onOptionsItemSelectedSALogging(int i) {
        if (i == C8003R.id.action_delete) {
            CommonSamsungAnalytics.insertLog("531", "5323");
        } else if (i == C8003R.id.action_restore) {
            CommonSamsungAnalytics.insertLog("531", NotesSAConstants.EVENT_RECYCLEBIN_RESTORE_BUTTON);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public long getCurrentOptionsMenuStatus() {
        return appendRestoreAndDeleteAll(this.mPresenter.getCheckedFoldersCount(), this.mPresenter.getCheckedNotesCount());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public int getOptionMenuRes() {
        return C8003R.menu.notelist_recyclebin_edit;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onFilteredOptionsMenu(Menu menu) {
        if (menu == null || menu.findItem(C8003R.id.action_delete) == null || menu.findItem(C8003R.id.action_restore) == null) {
            return;
        }
        if ((this.mMenuStatus & 2048) > 0) {
            menu.findItem(C8003R.id.action_delete).setTitle(C8003R.string.action_delete_all);
            menu.findItem(C8003R.id.action_restore).setTitle(C8003R.string.action_restore_all);
        } else {
            menu.findItem(C8003R.id.action_delete).setTitle(C8003R.string.action_delete);
            menu.findItem(C8003R.id.action_restore).setTitle(C8003R.string.action_restore);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        int itemId = menuItem.getItemId();
        onOptionsItemSelectedSALogging(itemId);
        if (itemId == C8003R.id.action_delete) {
            this.mPresenter.showDeleteDialog();
            return true;
        }
        if (itemId != C8003R.id.action_restore) {
            if (itemId != C8003R.id.action_done) {
                return false;
            }
            this.mModeParams.getNotesView().getMode().releaseEditMode();
            return true;
        }
        RestoreTask restoreTask = new RestoreTask(this.mFragment.getActivity());
        WorkerTaskManager.getInstance().addTask(restoreTask);
        restoreTask.run(Pair.create(this.mPresenter.getCheckedNotesUUID(), this.mPresenter.getCheckedFolderUUID()));
        this.mPresenter.checkRunningTask(RestoreTask.TAG);
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
        this.mBottomMenuController.inflateBottomNavigationMenu(getOptionMenuRes(), new C7737b(this, 18));
        if (!this.mModeParams.getNotesRecyclerView().isLongPressed()) {
            this.mBottomMenuController.showBottomNavigation(true);
            updateBasicEffect(true);
            this.mBottomMenuController.checkProgressCircle();
        }
        onFilteredOptionsMenu(this.mBottomMenuController.getBottomNavigationMenu());
    }
}
