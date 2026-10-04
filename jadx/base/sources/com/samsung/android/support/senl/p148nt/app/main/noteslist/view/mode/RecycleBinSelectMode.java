package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.IntentFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecycleBinSelectMode extends BaseMode {
    private static final String TAG = "RecycleBinSelectMode";

    public RecycleBinSelectMode(ModeParams modeParams) {
        super(modeParams);
    }

    private void setSubTitle() {
        Resources resources = this.mAppContext.getResources();
        int noteDataCount = this.mPresenter.getDocumentMap().getNoteDataCount();
        String str = "";
        String quantityString = noteDataCount <= 0 ? "" : resources.getQuantityString(C8003R.plurals.plurals_count_notes, noteDataCount, Integer.valueOf(noteDataCount));
        int folderCount = this.mPresenter.getDocumentMap().getFolderCount();
        String quantityString2 = folderCount <= 0 ? "" : resources.getQuantityString(C8003R.plurals.plurals_count_folders, folderCount, Integer.valueOf(folderCount));
        if (noteDataCount > 0 && folderCount > 0) {
            str = resources.getString(C8003R.string.string_comma) + " ";
        }
        String strM757C = AbstractC0541b.m757C(quantityString2, str, quantityString);
        AbstractC8014b.m7209k("setSubTitle# ", strM757C, TAG);
        this.mActionMenuController.setToolbarSubTitle(strM757C);
    }

    private void setTipCard(int i) {
        if (hasCreatePostLogic()) {
            return;
        }
        AbstractC8014b.m7201c(i, "setTipCard# caller : ", getTag());
        this.mPresenter.getTipCardHelper().clearTipCard(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public Intent getIntentForNoteSelected(MainEntryParam mainEntryParam) {
        return IntentFactory.makeIntent(2, this.mFragment.getActivity(), mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 5;
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
        WorkerTaskManager.getInstance().cancelRunningTask(RestoreTask.TAG, this.mFragment.getActivity().hashCode());
        return backStackHistory();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onBindViewHolder(commonHolderInfo, checkBox, textView);
        MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(commonHolderInfo.getUuid());
        if (noteData != null) {
            commonHolderInfo.setDueDateViewVisible(noteData.getRecycleBinTimeMoved());
            return;
        }
        NotesFolder folderData = this.mPresenter.getDocumentMap().getFolderData(commonHolderInfo.getUuid());
        if (folderData != null) {
            commonHolderInfo.setDueDateViewVisible(folderData.getRecycleBinTimeMoved());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(final CommonHolderInfo commonHolderInfo) {
        PopupMenu popupMenuCreateContextPopupMenu = createContextPopupMenu(commonHolderInfo);
        if (popupMenuCreateContextPopupMenu == null) {
            return false;
        }
        MainLogger.m7254d(TAG, "onContextClick " + commonHolderInfo.getUuid());
        popupMenuCreateContextPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.RecycleBinSelectMode.1
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                RecycleBinSelectMode.this.mPresenter.updateCheckedData(commonHolderInfo, true);
                int itemId = menuItem.getItemId();
                if (itemId == C8003R.id.action_delete) {
                    RecycleBinSelectMode.this.mPresenter.showDeleteDialog();
                } else {
                    if (itemId != C8003R.id.action_restore) {
                        RecycleBinSelectMode.this.mPresenter.updateCheckedData(commonHolderInfo, false);
                        return false;
                    }
                    RestoreTask restoreTask = new RestoreTask(RecycleBinSelectMode.this.mFragment.getActivity());
                    WorkerTaskManager.getInstance().addTask(restoreTask);
                    restoreTask.run(Pair.create(RecycleBinSelectMode.this.mPresenter.getCheckedNotesUUID(), RecycleBinSelectMode.this.mPresenter.getCheckedFolderUUID()));
                }
                return true;
            }
        });
        popupMenuCreateContextPopupMenu.show();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.notelist_recyclebin_select, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        setSubTitle();
        WorkerTask<?> runningTask = WorkerTaskManager.getInstance().getRunningTask(RestoreTask.TAG, this.mFragment.getActivity().hashCode());
        if (runningTask == null || runningTask.isCancelled()) {
            executeDeleteExpiredNotes();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        CommonSamsungAnalytics.insertLog("531", NotesSAConstants.EVENT_RECYCLEBIN_EDIT_MODE);
        setEditMode(true);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_RECYCLEBIN_EDIT);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        setTipCard(1);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
        this.mActionMenuController.setToolbarTitle(C8003R.string.recycle_bin_title);
        setSubTitle();
        executeDeleteExpiredNotes();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        showRecycleBinMessage(this.mPresenter.getStateInfo().getModeIndex() == 6);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        CommonSamsungAnalytics.insertLog("531", NotesSAConstants.EVENT_RECYCLEBIN_VIEW_NOTE);
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        int itemId = menuItem.getItemId();
        if (itemId == C8003R.id.action_recyclebin_edit) {
            CommonSamsungAnalytics.insertLog("531", NotesSAConstants.EVENT_RECYCLEBIN_EDIT_BUTTON);
            setEditMode(true);
        } else {
            if (itemId != C8003R.id.action_recyclebin_empty_bin) {
                return false;
            }
            CommonSamsungAnalytics.insertLog("531", NotesSAConstants.EVENT_RECYCLEBIN_EMPTY_BUTTON);
            this.mPresenter.selectAllWithoutCheckBox(true);
            this.mPresenter.showDeleteDialog(true);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]);
        if (commonDisplayListSize == 0) {
            menu.removeItem(C8003R.id.action_recyclebin_edit);
            menu.removeItem(C8003R.id.action_recyclebin_empty_bin);
        }
        showRecycleBinMessage(commonDisplayListSize > 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSubFolderSelected(String str) {
        ToastHandler.show(this.mContext, C8003R.string.recycle_bin_sub_folder_select_toast, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        super.setEditMode(z);
        return this.mNotesView.setMode(6);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        TextView textView = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note);
        TextView textView2 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note_sub);
        TextView textView3 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_result);
        textView.setVisibility(0);
        textView.setText(C8003R.string.no_items);
        textView2.setVisibility(0);
        textView2.setText(this.mFragment.getResources().getString(C8003R.string.recyclebin_notification_msg, "4.2.2"));
        textView3.setVisibility(8);
    }

    public void showRecycleBinMessage(boolean z) {
        int iIndexOfSortTopHolder = this.mPresenter.getDocumentMap().indexOfSortTopHolder(13);
        if (z || iIndexOfSortTopHolder != -1) {
            if (!z || iIndexOfSortTopHolder == -1) {
                this.mPresenter.getDocumentMap().putHolderInfoMap(13, z);
                if (this.mPresenter.getDocumentMap().sortTopHolderDisplayList(13) == -1) {
                    return;
                }
                this.mPresenter.notifyDataSetChangedWithViewPageChange("showRecycleBinMessage");
                if (this.mPresenter.getStateInfo().getPrevModeIndex() == 6 || this.mPresenter.getStateInfo().getModeIndex() != 5) {
                    return;
                }
                this.mRecyclerView.scrollToTop();
            }
        }
    }
}
