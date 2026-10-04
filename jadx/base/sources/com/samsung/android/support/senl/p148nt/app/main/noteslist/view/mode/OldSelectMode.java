package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.IntentFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard.TipCardHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class OldSelectMode extends BaseMode {
    private static final String TAG = "OldSelectMode";
    private DataTask mConvertNotesCheckTask;
    private boolean mIsConvertedNotesExist;

    public OldSelectMode(ModeParams modeParams) {
        super(modeParams);
        this.mIsConvertedNotesExist = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateOptionsMenu$0() {
        this.mIsConvertedNotesExist = DataManager.getInstance().getAll_ConvertedCount() > 0;
    }

    private void setConvertedNotesMode() {
        this.mPresenter.getStateInfo().setCategoryUuid("old_converted_notes");
        onLayout();
        this.mPresenter.getDocumentMap().clearCommonDisplayList();
        this.mPresenter.notifyDataSetChangedWithViewPageChange("setConvertedNotesMode");
        this.mPresenter.updateDataObserverToCurrentMode();
    }

    private void setTipCard(int i) {
        AbstractC8014b.m7201c(i, "setTipCard# caller : ", getTag());
        TipCardHelper tipCardHelper = this.mPresenter.getTipCardHelper();
        if (i == 1) {
            tipCardHelper.loadConvertProgressingTipCard();
        }
        tipCardHelper.clearTipCard(true);
    }

    private void showDeleteConvertedNotesMessage(boolean z) {
        int iIndexOfSortTopHolder = this.mPresenter.getDocumentMap().indexOfSortTopHolder(14);
        if (z || iIndexOfSortTopHolder != -1) {
            if (!z || iIndexOfSortTopHolder == -1) {
                this.mPresenter.getDocumentMap().putHolderInfoMap(14, z);
                if (this.mPresenter.getDocumentMap().sortTopHolderDisplayList(14) == -1) {
                    return;
                }
                this.mPresenter.notifyDataSetChangedWithViewPageChange("showDeleteConvertedNotesMessage");
                if (this.mPresenter.getStateInfo().getPrevModeIndex() == 22 || this.mPresenter.getStateInfo().getModeIndex() != 21) {
                    return;
                }
                this.mRecyclerView.scrollToTop();
            }
        }
    }

    private void updateOptionsMenu() {
        if ("old_converted_notes".equals(this.mPresenter.getStateInfo().getCategoryUuid())) {
            return;
        }
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        DataTask dataTask = this.mConvertNotesCheckTask;
        if (dataTask == null) {
            this.mConvertNotesCheckTask = new DataTask(activity);
        } else {
            dataTask.cancel();
        }
        final boolean z = this.mIsConvertedNotesExist;
        this.mConvertNotesCheckTask.run(new RunnableC8669a(this, 0));
        this.mConvertNotesCheckTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.OldSelectMode.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(WorkerTask.Result result) {
                if (z != OldSelectMode.this.mIsConvertedNotesExist) {
                    MainLogger.m7254d(OldSelectMode.TAG, "updateOptionsMenu# call invalidateOptionsMenu");
                    OldSelectMode.this.mFragment.filteredInvalidateOptionsMenu();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(@NotNull WorkerTask<?> workerTask) {
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public Intent getIntentForNoteSelected(MainEntryParam mainEntryParam) {
        return IntentFactory.makeIntent(5, this.mFragment.getActivity(), mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 21;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        this.mNotesView.setIsScrollToTop(true, 0);
        this.mNotesView.setMode(23);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(final CommonHolderInfo commonHolderInfo) {
        PopupMenu popupMenuCreateContextPopupMenu = createContextPopupMenu(commonHolderInfo);
        if (popupMenuCreateContextPopupMenu == null) {
            return false;
        }
        String uuid = commonHolderInfo.getUuid();
        MainLogger.m7254d(getTag(), "onContextClick " + uuid);
        popupMenuCreateContextPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.OldSelectMode.2
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                OldSelectMode.this.mPresenter.updateCheckedData(commonHolderInfo, true);
                int itemId = menuItem.getItemId();
                if (itemId == C8003R.id.convert) {
                    OldSelectMode.this.mPresenter.showConvertConfirmDialog();
                } else if (itemId == C8003R.id.share) {
                    OldSelectMode.this.mPresenter.shareOldNotes();
                } else if (itemId == C8003R.id.delete) {
                    OldSelectMode.this.mPresenter.showDeleteDialog();
                } else if (itemId == C8003R.id.action_remove_from_favorites) {
                    OldSelectMode.this.mPresenter.updateFavorite(false);
                } else {
                    if (itemId != C8003R.id.action_add_to_favorites) {
                        OldSelectMode.this.mPresenter.updateCheckedData(commonHolderInfo, false);
                        return false;
                    }
                    OldSelectMode.this.mPresenter.updateFavorite(true);
                }
                return true;
            }
        });
        popupMenuCreateContextPopupMenu.show();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.old_noteslist_select, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 34) {
            if (i == 84) {
                return this.mNotesView.setMode(3);
            }
        } else if ((keyEvent.getMetaState() & 4096) == 4096) {
            return this.mNotesView.setMode(3);
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void onDataChangedBase(int i) {
        super.onDataChangedBase(i);
        updateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        boolean zInitConvertedNoteMap = "old_converted_notes".equals(this.mPresenter.getStateInfo().getCategoryUuid()) ? this.mPresenter.getDocumentMap().initConvertedNoteMap(list) : this.mPresenter.getDocumentMap().initOldNoteMap(list);
        if (FeatureUtils.isSearchMode(this.mPresenter.getStateInfo().getPrevModeIndex())) {
            this.mPresenter.notifyDataSetChangedWithViewPageChange("Notes LiveData onChanged");
        }
        return zInitConvertedNoteMap ? AdapterManager.DataState.CHANGED : AdapterManager.DataState.UNCHANGED;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        if (i != 0 || this.mFragmentContract.getAddonsHandler().isProgressDialogShowing()) {
            super.onDataChangedViewUpdate(i);
        } else {
            MainLogger.m7254d(getTag(), "onDataChanged# count 0, back to all note");
            this.mNotesView.onFolderSelected(FolderConstants.OldNotes.UUID);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        setEditMode(true);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        this.mActionMenuController.setHideSelectAllCheckbox();
        this.mActionMenuController.resetCheckItems();
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
        this.mActionMenuController.setToolbarSubTitle((String) null);
        updateTitle();
        ViewModeUtils.updateRecyclerViewPaddingBottom(this.mRecyclerView, false);
        setTipCard(1);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        showDeleteConvertedNotesMessage(this.mPresenter.getStateInfo().getModeIndex() == 22 && "old_converted_notes".equals(this.mPresenter.getStateInfo().getCategoryUuid()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        int itemId = menuItem.getItemId();
        if (itemId == C8003R.id.action_search) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_SELECT, NotesUtils.isTabletLayout(this.mContext) ? NotesSAConstants.EVENT_TABLET_SEARCH : "0001");
            CommonSamsungAnalytics.insertLog("221");
            this.mNotesView.setMode(3);
        } else if (itemId == C8003R.id.action_edit) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_SELECT, NotesUtils.isTabletLayout(this.mContext) ? NotesSAConstants.EVENT_TABLET_NOTESLIST_EDIT : NotesSAConstants.EVENT_NOTESLIST_EDIT);
            setEditMode(true);
        } else if (itemId == C8003R.id.action_pin_to_favorites) {
            this.mPresenter.clickPinToFavorites();
        } else if (itemId == C8003R.id.action_viewby) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_SELECT, NotesUtils.isTabletLayout(this.mContext) ? NotesSAConstants.EVENT_TABLET_NOTESLIST_VIEW_BY : NotesSAConstants.EVENT_NOTESLIST_VIEW_BY);
            this.mPresenter.showViewByPopupMenu();
        } else {
            if (itemId != C8003R.id.action_converted_notes) {
                return false;
            }
            CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, NotesSAConstants.EVENT_OLDNOTES_CONVERTED_NOTES);
            setConvertedNotesMode();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]);
        if (commonDisplayListSize <= 0) {
            menu.removeItem(C8003R.id.action_search);
            menu.removeItem(C8003R.id.action_edit);
            menu.removeItem(C8003R.id.action_pin_to_favorites);
            menu.removeItem(C8003R.id.action_viewby);
        }
        if (NotesUtils.isPinFavorites() && menu.findItem(C8003R.id.action_pin_to_favorites) != null) {
            menu.findItem(C8003R.id.action_pin_to_favorites).setTitle(C8003R.string.dialog_sort_by_unpin_favorite_to_top);
        }
        if ("old_converted_notes".equals(this.mPresenter.getStateInfo().getCategoryUuid())) {
            menu.removeItem(C8003R.id.action_converted_notes);
            showDeleteConvertedNotesMessage(commonDisplayListSize > 0);
        } else {
            if (this.mIsConvertedNotesExist) {
                return;
            }
            menu.removeItem(C8003R.id.action_converted_notes);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        super.onResume();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        super.setEditMode(z);
        return this.mNotesView.setMode(22);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        TextView textView = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note);
        TextView textView2 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note_sub);
        TextView textView3 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_result);
        textView.setVisibility(0);
        textView.setText(C8003R.string.no_notes);
        textView2.setVisibility(8);
        textView3.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void updateTitle() {
        String displayName;
        String categoryUuid = this.mPresenter.getStateInfo().getCategoryUuid();
        if ("1".equals(categoryUuid)) {
            displayName = this.mAppContext.getResources().getString(C8003R.string.uncategorised);
        } else if ("2".equals(categoryUuid)) {
            displayName = this.mAppContext.getResources().getString(C8003R.string.string_screen_off_memo);
        } else {
            NotesFolder folderData = DataManager.getInstance().getFolderData(categoryUuid);
            displayName = folderData != null ? folderData.getDisplayName() : this.mAppContext.getResources().getString(C8003R.string.converted_notes);
        }
        this.mActionMenuController.setToolbarTitle(displayName);
    }
}
