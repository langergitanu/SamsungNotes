package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.view.MenuCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa.NotesListSALogModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.util.SearchSALoggingUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard.TipCardHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.FocusView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SelectMode extends BaseMode implements FocusView.Contract {
    private static final String TAG = "SelectMode";
    protected final FocusView mFocusView;
    protected boolean mIsEditMode;
    protected long mMenuStatus;

    public SelectMode(ModeParams modeParams) {
        super(modeParams);
        this.mIsEditMode = false;
        this.mMenuStatus = 0L;
        this.mFocusView = new FocusView(this);
    }

    private void initRefreshLayout() {
        if (DeviceUtils.getDeviceSyncError(this.mContext) != 0) {
            this.mNotesView.setSwipeRefreshLayoutEnabled(false);
        } else {
            this.mNotesView.setSwipeRefreshLayoutEnabled(true);
            this.mNotesView.setSwipeRefreshLayoutDuration(0);
        }
    }

    private void isAlwaysCheckNeededTipCard(TipCardHelper tipCardHelper) {
        tipCardHelper.loadSyncTipCard(getModeIndex());
        tipCardHelper.addExternalStoragePermissionGranted();
        tipCardHelper.addImportNoteFromAccountTipCardIfNeeds();
        tipCardHelper.addMicrosoftAccountLoginTipCard();
        tipCardHelper.addEdpNotifyTipCard();
    }

    private void onFilteredOptionsMenu(Menu menu) {
        if (menu == null) {
            return;
        }
        if ((this.mMenuStatus & 1) > 0) {
            menu.removeItem(C8003R.id.action_search);
        }
        if ((this.mMenuStatus & 2) > 0) {
            menu.removeItem(C8003R.id.action_edit);
        }
        if ((this.mMenuStatus & 4) > 0) {
            menu.removeItem(C8003R.id.action_pin_to_favorites);
        }
        if ((this.mMenuStatus & 8) > 0) {
            menu.removeItem(C8003R.id.action_viewby);
        }
        if ((this.mMenuStatus & 16) > 0) {
            menu.removeItem(C8003R.id.action_sortby);
        }
        if ((this.mMenuStatus & 32) > 0) {
            menu.removeItem(C8003R.id.action_add_folder);
        }
        if ((this.mMenuStatus & 64) <= 0 || menu.findItem(C8003R.id.action_pin_to_favorites) == null) {
            return;
        }
        menu.findItem(C8003R.id.action_pin_to_favorites).setTitle(C8003R.string.dialog_sort_by_unpin_favorite_to_top);
    }

    private void onItemLongPressedSALogging() {
        String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
        CommonSamsungAnalytics.insertLog(NotesListSALogModel.getSAScreenIDInSelectModeForFilterFolder(folderUuid), NotesUtils.isTabletLayout(this.mContext) ? NotesSAConstants.EVENT_TABLET_NOTESLIST_SELECTION_MODE : NotesSAConstants.EVENT_NOTESLIST_SELECTION_MODE);
        NotesListSALogModel.addSAlogOnItemLongPressedForFilterFolder(folderUuid);
    }

    private void onNoteSelectedSALogging(int i) {
        String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
        boolean zEquals = FolderConstants.ScreenOffMemo.UUID.equals(folderUuid);
        String str = NotesSAConstants.EVENT_NOTESLIST_VIEW_NOTE;
        if (zEquals) {
            String sAScreenIDInSelectModeForFilterFolder = NotesListSALogModel.getSAScreenIDInSelectModeForFilterFolder(folderUuid);
            if (NotesUtils.isTabletLayout(this.mContext)) {
                str = NotesSAConstants.EVENT_TABLET_NOTESLIST_VIEW_NOTE;
            }
            CommonSamsungAnalytics.insertLog(sAScreenIDInSelectModeForFilterFolder, str, i == 1 ? "c" : "d");
            return;
        }
        String sAScreenIDInSelectModeForFilterFolder2 = NotesListSALogModel.getSAScreenIDInSelectModeForFilterFolder(folderUuid);
        if (NotesUtils.isTabletLayout(this.mContext)) {
            str = NotesSAConstants.EVENT_TABLET_NOTESLIST_VIEW_NOTE;
        }
        CommonSamsungAnalytics.insertLog(sAScreenIDInSelectModeForFilterFolder2, str, i == 1 ? "a" : "b");
    }

    private void onSubFolderSelectedSALogging() {
        CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_NOTESLIST_VIEW_SUB_FOLDER);
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
        AbstractC8014b.m7209k("setSubTitle : ", strM757C, TAG);
        this.mActionMenuController.setToolbarSubTitle(strM757C);
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.NOTES_COUNT_FOR_SUBTITLE, strM757C);
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(NotesConstants.NOTES_COUNT_FOR_TOOLBAR, noteDataCount);
    }

    private void setTipCard(int i) {
        AbstractC8014b.m7201c(i, "setTipCard# caller : ", getTag());
        this.mPresenter.setMigrationListener(getTag() + ", setTipCard");
        TipCardHelper tipCardHelper = this.mPresenter.getTipCardHelper();
        if (i == 3) {
            tipCardHelper.setImportStorageTipCard();
            tipCardHelper.setSyncTipCardProgressListener();
            tipCardHelper.addSyncFailPSMTipCard();
            tipCardHelper.loadConvertProgressingTipCard();
            tipCardHelper.loadImportSamsungNoteProgressingTipCard();
            tipCardHelper.loadImportPDFProgressingTipCard();
            tipCardHelper.addCheckConvertedNotesTipCard();
            isAlwaysCheckNeededTipCard(tipCardHelper);
            return;
        }
        if (i != 1) {
            if (i != 2 || hasCreatePostLogic()) {
                return;
            }
            isAlwaysCheckNeededTipCard(tipCardHelper);
            return;
        }
        int mTipCardType = LiveSharingManager.getInstance().getMTipCardType();
        if (mTipCardType != LiveSharingManager.NONE) {
            tipCardHelper.setMeetTipCard(mTipCardType);
        }
        tipCardHelper.loadConvertProgressingTipCard();
        tipCardHelper.loadImportSamsungNoteProgressingTipCard();
        tipCardHelper.loadImportPDFProgressingTipCard();
        if (hasCreatePostLogic()) {
            return;
        }
        isAlwaysCheckNeededTipCard(tipCardHelper);
    }

    private void updateSubTitleUsingCache() {
        this.mActionMenuController.setToolbarSubTitle(SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getString(NotesConstants.NOTES_COUNT_FOR_SUBTITLE, null));
    }

    private void updateTitleUsingCache() {
        this.mActionMenuController.setToolbarTitle(SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getString(NotesConstants.SELECT_MODE_TITLE, this.mContext.getResources().getString(C8003R.string.all_notes)));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getCurrentOptionsMenuStatus() {
        long j;
        String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
        String str = FolderConstants.AllNotes.UUID;
        if (folderUuid.equals(str)) {
            j = (hasCreatePostLogic() ? SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(NotesConstants.NOTES_COUNT_FOR_TOOLBAR, 0) : this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0])) == 0 ? 31L : 0L;
        } else {
            long j2 = this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders) == 0 ? 30L : "recentlyImported:///".equals(folderUuid) ? 20L : 0L;
            j = SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt(str, 0) == 0 ? 1 | j2 : j2;
        }
        if (FeatureUtils.isPreDefinedFolderUuid(folderUuid) || FolderUtils.isStaticFolder(folderUuid)) {
            j |= 32;
        }
        return ((this.mMenuStatus & 4) == 0 && NotesUtils.isPinFavorites()) ? j | 64 : j;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getLastOptionsMenuStatus() {
        return this.mMenuStatus;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (NotesUtils.isTabletLayout(this.mContext) || !super.onBackKeyDown()) {
            return backStackHistory();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.noteslist_select, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 34) {
            if (i != 42) {
                if (i == 84) {
                    return this.mNotesView.setMode(3);
                }
            } else {
                if (keyEvent.getAction() == 0 || (keyEvent.getMetaState() & 4096) != 4096) {
                    return false;
                }
                String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
                if (FeatureUtils.isCreateNewNoteEnabled(getModeIndex(), folderUuid)) {
                    this.mNotesView.onNewNote(folderUuid, 1);
                }
            }
        } else if ((keyEvent.getMetaState() & 4096) == 4096 && SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt(FolderConstants.AllNotes.UUID, 0) != 0) {
            return this.mNotesView.setMode(3);
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        setSubTitle();
        if (hasCreatePostLogic()) {
            return;
        }
        updateTitle();
        setTipCard(2);
        executePostAction();
        this.mPresenter.getSOMRecognizeHelper().onDataChanged("onDataChangedViewUpdate");
        this.mFocusView.updateFocus(this.mPresenter.getStateInfo().getFolderUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        if (this.mPresenter.getDocumentMap().getNoteData(str) != null) {
            this.mPresenter.setLongPressFlag(true);
        }
        onItemLongPressedSALogging();
        setEditMode(true);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        this.mMenuStatus = -1L;
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
        if (hasCreatePostLogic()) {
            updateTitleUsingCache();
            updateSubTitleUsingCache();
            return;
        }
        super.onLayout();
        setTipCard(1);
        if (!FeatureUtils.isRecyclebinMode(this.mPresenter.getStateInfo().getPrevModeIndex())) {
            updateTitle();
            setSubTitle();
        }
        this.mActionMenuController.updateDrawerIconWithBadge();
        initRefreshLayout();
        removeCircleProgressDialog();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        this.mPresenter.getSwipeRefreshHelper().releaseSwipeRefresh();
        this.mNotesView.setSwipeRefreshLayoutEnabled(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        onNoteSelectedSALogging(mainEntryParam.getToolType());
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        MainLogger.m7258i(TAG, "onOptionsItemSelected# item : " + ((Object) menuItem.getTitle()));
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        int itemId = menuItem.getItemId();
        SearchSALoggingUtil.INSTANCE.onOptionsItemSelectedSALogging(NotesListSALogModel.getSAScreenIDInSelectModeForFilterFolder(this.mPresenter.getStateInfo().getFolderUuid()), itemId, NotesUtils.isTabletLayout(this.mContext));
        if (itemId == C8003R.id.action_edit) {
            setEditMode(true);
        } else if (itemId == C8003R.id.action_search) {
            this.mNotesView.setMode(3);
        } else if (itemId == C8003R.id.action_pin_to_favorites) {
            this.mPresenter.clickPinToFavorites();
        } else if (itemId == C8003R.id.action_viewby) {
            this.mPresenter.showViewByPopupMenu();
        } else if (itemId == C8003R.id.action_sortby) {
            this.mPresenter.showSortByDialog();
        } else {
            if (itemId != C8003R.id.action_add_folder) {
                return false;
            }
            NotesPresenter notesPresenter = this.mPresenter;
            notesPresenter.showAddFolderDialog(notesPresenter.getStateInfo().getFolderUuid());
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPostResume() {
        super.onPostResume();
        if (!this.mIsEditMode) {
            setTipCard(3);
        }
        initRefreshLayout();
        removeCircleProgressDialog();
        updateTitle();
        setSubTitle();
        this.mFocusView.updateFocus(this.mPresenter.getStateInfo().getFolderUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        this.mMenuStatus = getCurrentOptionsMenuStatus();
        onFilteredOptionsMenu(menu);
        this.mFocusView.checkFocus(this.mPresenter.getStateInfo().getFolderUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSubFolderSelected(String str) {
        onSubFolderSelectedSALogging();
        super.onSubFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSwipeRefresh() {
        return this.mPresenter.getSwipeRefreshHelper().requestSyncBySelectMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        super.setEditMode(z);
        return this.mNotesView.setMode(2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void updateFocusView(int i) {
        super.updateFocusView(i);
        this.mFocusView.setSearchFocus(i, this.mPresenter.getStateInfo().getFolderUuid());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void updateTitle() {
        String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
        NotesFolder folderData = DataManager.getInstance().getFolderData(folderUuid);
        long id = folderData == null ? -1L : folderData.getId();
        MainLogger.m7258i(TAG, "updateTitle# folderUuid : " + folderUuid + ", id : " + id);
        String string = id == -1 ? this.mAppContext.getResources().getString(C8003R.string.all_notes) : (id == -4 || folderUuid.equals(FolderConstants.MyFolders.UUID)) ? this.mAppContext.getResources().getString(C8003R.string.settings_my_folders) : id == -3 ? this.mAppContext.getResources().getString(C8003R.string.favorite_notes) : id == -5 ? this.mAppContext.getResources().getString(C8003R.string.locked_notes) : id == -13 ? this.mAppContext.getResources().getString(C8003R.string.string_screen_off_memo) : id == -19 ? this.mAppContext.getResources().getString(C8003R.string.string_math_notes) : id == -6 ? this.mAppContext.getResources().getString(C8003R.string.folder_recently_imported) : id == -2 ? this.mAppContext.getResources().getString(C8003R.string.upgradable_notes) : id == -8 ? this.mAppContext.getResources().getString(C8003R.string.co_edit_title) : folderData.getDisplayName();
        this.mActionMenuController.setToolbarTitle(string);
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.SELECT_MODE_TITLE, string);
    }
}
