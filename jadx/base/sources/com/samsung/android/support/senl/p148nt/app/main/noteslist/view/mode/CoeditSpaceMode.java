package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.util.SeslKoreanGeneralizer;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.ViewInfoController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.CoeditHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditSpaceDeleteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Event;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventManager;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable;
import java.util.Collections;
import p028G.InterfaceC0102a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceMode extends CoeditBaseMode {
    private static final String TAG = "CoeditSpaceMode";
    private View mCustomSubTitleView;
    protected final Listenable mEventListener;
    private String mGroupId;
    private final InterfaceC0102a mImportProgressListener;
    protected boolean mIsLeader;
    private DialogFragment mProgressDialog;
    protected final CoeditSpaceDeleteReceivedReceiver mSpaceDeleteReceivedReceiver;
    private String mSpaceId;
    private final CoeditSessionConnector.ActionResult mSpaceRemoveResultListener;
    private final ViewInfoController mToolbarIconInfoController;

    public CoeditSpaceMode(ModeParams modeParams) {
        super(modeParams);
        this.mSpaceDeleteReceivedReceiver = new CoeditSpaceDeleteReceivedReceiver() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditSpaceMode.1
            @Override // com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditSpaceDeleteReceivedReceiver
            public void onSpaceDeleted(String str, String str2, String str3) {
                if (!CoeditSpaceMode.this.mGroupId.equals(str)) {
                    if (str.isEmpty() && CoeditSpaceMode.this.mSpaceId.equals(str3)) {
                        MainCoeditLogger.m7253i(CoeditSpaceMode.TAG, "onSpaceDeleted# " + str3);
                        CoeditSpaceMode.this.mNotesView.setMode(12);
                        return;
                    }
                    return;
                }
                MainCoeditLogger.m7253i(CoeditSpaceMode.TAG, "onSpaceDeleted# " + str + ", groupName: " + str2);
                CoeditSpaceMode.this.mNotesView.setMode(12);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                ToastHandler.show(CoeditSpaceMode.this.mContext, new SeslKoreanGeneralizer().naturalizeText(CoeditSpaceMode.this.mAppContext.getResources().getString(C8003R.string.gcs_space_deleted_body, str2)), 1, false);
            }
        };
        this.mImportProgressListener = new InterfaceC0102a() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditSpaceMode.2
            @Override // p028G.InterfaceC0102a
            public void onEnded(String str, int i) {
                MainCoeditLogger.m7253i(CoeditSpaceMode.TAG, "ImportProgressListener onEnded# " + str + " errorCode: " + i);
                CoeditSpaceMode.this.removeImportProgress();
            }

            @Override // p028G.InterfaceC0102a
            public void onProgress(int i, int i2) {
                MainCoeditLogger.m7253i(CoeditSpaceMode.TAG, "ImportProgressListener onProgress# currentCount: " + i + " totalCount: " + i2);
            }

            @Override // p028G.InterfaceC0102a
            public void onStarted(String str) {
                MainCoeditLogger.m7253i(CoeditSpaceMode.TAG, "ImportProgressListener onStarted# " + str);
                CoeditSpaceMode.this.showImportProgress();
            }
        };
        this.mEventListener = new Listenable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditSpaceMode.3
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public String requestName() {
                return "COEDIT_ITEM_EVENT";
            }

            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public void run(Event event) {
                if (CoeditSpaceMode.this.mSpaceId != null && (event.getEventData() instanceof String) && CoeditSpaceMode.this.mSpaceId.equals(event.getEventData())) {
                    CoeditSpaceMode coeditSpaceMode = CoeditSpaceMode.this;
                    coeditSpaceMode.requestDownload(coeditSpaceMode.mSpaceId);
                }
            }
        };
        this.mSpaceRemoveResultListener = new CoeditSessionConnector.ActionResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditSpaceMode.4
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
            public void onFail() {
                MainCoeditLogger.m7253i(CoeditSpaceMode.TAG, "SpaceRemoveResultListener# onFail");
                CoeditSpaceMode.this.dismissDeleteDialog();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActionResult
            public void onSuccess() {
                MainCoeditLogger.m7253i(CoeditSpaceMode.TAG, "SpaceRemoveResultListener# onSuccess");
                CoeditSpaceMode.this.dismissDeleteDialog();
                CoeditSpaceMode.this.onBackKeyDown();
            }
        };
        this.mCustomSubTitleView = null;
        this.mToolbarIconInfoController = new ViewInfoController();
    }

    private boolean checkIsInvalidGroup() {
        if (!TextUtils.isEmpty(SesCoeditShareReadResolver.getInstance().getGroupId(this.mSpaceId))) {
            return false;
        }
        MainCoeditLogger.m7251e(TAG, "checkIsInvalidGroup# true");
        onBackKeyDown();
        return true;
    }

    private void launchImportNotePickerActivity() {
        if (this.mSessionConnector.isStorageFull()) {
            ToastHandler.show(this.mContext, this.mAppContext.getResources().getString(C8003R.string.co_edit_cannot_import_storage_full), 1, false);
            return;
        }
        CoeditHelper.setImportProgressListener(this.mImportProgressListener);
        Intent intent = new Intent(this.mAppContext, NoteListAccessHandler.getNotePickerClass());
        intent.putExtra("spaceId", this.mSpaceId);
        intent.setAction(NotesConstants.ACTION_PICK_NOTES_FROM_COEDIT_SPACE);
        this.mFragment.startActivity(intent);
    }

    private void onLayoutSpaceMode() {
        if (FeatureUtils.isCoeditSpaceMode(this.mPresenter.getStateInfo().getModeIndex())) {
            this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
            setTitle();
            this.mBottomMenuController.showBottomNavigation(false);
            updateBasicEffect(false);
        }
    }

    private void onOptionsItemSelectedSALogging(int i) {
        if (i == C8003R.id.action_group_member_list) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_SHOW_MEMBER);
            return;
        }
        if (i == C8003R.id.action_edit) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_EDIT);
            return;
        }
        if (i == C8003R.id.action_viewby) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_VIEW_TYPE);
            return;
        }
        if (i == C8003R.id.action_import_notes) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_IMPORT_NOTES);
            return;
        }
        if (i == C8003R.id.action_switch_to_note) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_SWITCH_TO_NOTE);
            return;
        }
        if (i == C8003R.id.action_rename_shared_notebook) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_RENAME);
        } else if (i == C8003R.id.action_leave_shared_notebook) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_LEAVE, this.mIsLeader ? "a" : "b");
        } else if (i == C8003R.id.action_delete_shared_notebook) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_DELETE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImportProgress() {
        if (this.mProgressDialog != null) {
            MainCoeditLogger.m7253i(TAG, "removeImportProgress#");
            this.mProgressDialog.dismissAllowingStateLoss();
            this.mProgressDialog = null;
        }
    }

    private void setTitle() {
        if (FeatureUtils.isCoeditSpaceMode(this.mPresenter.getStateInfo().getModeIndex())) {
            this.mActionMenuController.setToolbarTitle(SesCoeditShareReadResolver.getInstance().getSpaceTitle(this.mSpaceId));
            updateTitle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImportProgress() {
        if (this.mFragment.isAdded()) {
            if (this.mProgressDialog != null) {
                MainCoeditLogger.m7253i(TAG, "showImportProgress# already showing");
                return;
            }
            MainCoeditLogger.m7253i(TAG, "showImportProgress#");
            DialogFragment dialogFragmentCreateProgressDialogFragment = DialogUtils.createProgressDialogFragment();
            this.mProgressDialog = dialogFragmentCreateProgressDialogFragment;
            dialogFragmentCreateProgressDialogFragment.setCancelable(false);
            ((DialogUtils.ProgressDialogFragment) this.mProgressDialog).showAllowingStateLoss(this.mFragment.getChildFragmentManager(), TAG);
        }
    }

    private void switchToNewNote() {
        MainCoeditLogger.m7250d(TAG, "switchToNewNote#");
        this.mSessionConnector.requestSpaceMove(this.mSpaceId, "", true);
        onBackKeyDown();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 14;
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
        this.mActionMenuController.setDisplayHomeAsUpEnabled(false);
        this.mNotesView.setIsScrollToTop(true, 0);
        if (this.mNotesView.setMode(12)) {
            this.mRecyclerView.stopScroll();
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onBindViewHolder(commonHolderInfo, checkBox, textView);
        CoeditMainListEntry coeditNoteData = this.mPresenter.getDocumentMap().getCoeditNoteData(commonHolderInfo.getUuid());
        if (coeditNoteData == null || decorateFakeNote(commonHolderInfo, coeditNoteData)) {
            return;
        }
        boolean zIsSnapShotUpdateRequired = coeditNoteData.isSnapShotUpdateRequired();
        commonHolderInfo.setCoeditExtraVisible(zIsSnapShotUpdateRequired, coeditNoteData.getMainListDocumentData().getFirstOpenedAt() == 0);
        if (zIsSnapShotUpdateRequired) {
            registerExternalSnap(commonHolderInfo.getUuid(), coeditNoteData.getMainListDocumentData().getMdeSpaceId());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.notelist_coedit_space_menu, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 42) {
            if (keyEvent.getAction() == 0 || (keyEvent.getMetaState() & 4096) != 4096) {
                return false;
            }
            this.mFragmentContract.onNewCoeditNote(this.mGroupId, this.mSpaceId, null, 1);
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        setNoNotesLayoutVisibility();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDestroy() {
        super.onDestroy();
        this.mSessionConnector.releaseSpaceDeleteActionResult();
        EventManager.getEventBus().unregister(this.mEventListener);
        CoeditSpaceDeleteReceivedReceiver.unregisterReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        setEditMode(true);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        this.mGroupId = this.mPresenter.getStateInfo().getGroupId();
        this.mSpaceId = this.mPresenter.getStateInfo().getSpaceId();
        this.mIsLeader = SesCoeditShareReadResolver.getInstance().isSpaceOwner(this.mSpaceId);
        if (checkIsInvalidGroup()) {
            return;
        }
        super.onLayout();
        onLayoutSpaceMode();
        CoeditSpaceDeleteReceivedReceiver.registerReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
        EventManager.getEventBus().register(this.mEventListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        this.mActionMenuController.setToolbarCustomSubTitle(null);
        CoeditHelper.removeImportProgressListener();
        removeImportProgress();
        CoeditSpaceDeleteReceivedReceiver.unregisterReceiver(this.mContext, this.mSpaceDeleteReceivedReceiver);
        EventManager.getEventBus().unregister(this.mEventListener);
        if (FeatureUtils.isCoeditSpaceMode(this.mPresenter.getStateInfo().getModeIndex())) {
            return;
        }
        this.mPresenter.getStateInfo().setGroupId(null);
        this.mPresenter.getStateInfo().setSpaceId(null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        super.onNoteSelected(mainEntryParam);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_SPACE_OPEN_NOTE);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        MainCoeditLogger.m7250d(TAG, "onOptionsItemSelected# onClick : " + ((Object) menuItem.getTitle()));
        int itemId = menuItem.getItemId();
        onOptionsItemSelectedSALogging(itemId);
        if (itemId == C8003R.id.action_group_member_list) {
            showCoeditMemberManage(this.mGroupId, this.mSpaceId, false);
        } else if (itemId == C8003R.id.action_edit) {
            setEditMode(true);
        } else if (itemId == C8003R.id.action_viewby) {
            this.mPresenter.showViewByPopupMenu();
        } else if (itemId == C8003R.id.action_sortby) {
            this.mPresenter.showSortByDialog();
        } else if (itemId == C8003R.id.action_import_notes) {
            launchImportNotePickerActivity();
        } else if (itemId == C8003R.id.action_switch_to_note) {
            switchToNewNote();
        } else if (itemId == C8003R.id.action_rename_shared_notebook) {
            renameSpace(this.mSpaceId);
        } else if (itemId == C8003R.id.action_leave_shared_notebook) {
            leaveSpace(this.mGroupId, this.mSpaceId, this.mIsLeader);
        } else if (itemId == C8003R.id.action_delete_shared_notebook) {
            deleteSpace();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]);
        if (commonDisplayListSize == 0) {
            menu.removeItem(C8003R.id.action_edit);
            menu.removeItem(C8003R.id.action_viewby);
            menu.removeItem(C8003R.id.action_sortby);
            menu.removeItem(C8003R.id.action_switch_to_note);
        } else if (commonDisplayListSize > 1) {
            menu.removeItem(C8003R.id.action_switch_to_note);
        }
        menu.removeItem(C8003R.id.action_switch_to_note);
        if (!this.mIsLeader) {
            menu.removeItem(C8003R.id.action_switch_to_note);
            menu.removeItem(C8003R.id.action_rename_shared_notebook);
            menu.removeItem(C8003R.id.action_delete_shared_notebook);
        }
        if (DataManager.getInstance().getAllUsedNoteCount() == 0) {
            menu.removeItem(C8003R.id.action_import_notes);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mGroupId = this.mPresenter.getStateInfo().getGroupId();
        this.mSpaceId = this.mPresenter.getStateInfo().getSpaceId();
        this.mIsLeader = bundle.getBoolean(GcsConstants.KEY_IS_LEADER);
        this.mProgressDialog = (DialogFragment) this.mFragment.getChildFragmentManager().findFragmentByTag(TAG);
        CoeditHelper.restoreImportProgressListener(this.mImportProgressListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        super.onResume();
        this.mIsLeader = SesCoeditShareReadResolver.getInstance().isSpaceOwner(this.mSpaceId);
        setTitle();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(GcsConstants.KEY_IS_LEADER, this.mIsLeader);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void onSpaceDelete() {
        if (this.mSessionConnector.requestSpaceDelete(this.mGroupId, this.mSpaceId, false, this.mSpaceRemoveResultListener, null, 0L)) {
            replaceDeleteBtnToProgress(GcsConstants.DialogTag.DELETE_NOTEBOOK);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void onSpaceLeave() {
        if (this.mIsLeader) {
            showCoeditMemberManage(this.mGroupId, this.mSpaceId, true);
        } else if (this.mSessionConnector.requestSpaceLeave(this.mGroupId, this.mSpaceId, this.mSpaceRemoveResultListener)) {
            replaceDeleteBtnToProgress(GcsConstants.DialogTag.LEAVE_NOTEBOOK);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void onSpaceRenameSuccess() {
        setTitle();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void requestDownload(String str) {
        requestDownload(this.mSpaceId, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void requestSync(boolean z, String str) {
        if (this.mPresenter.getStateInfo().getSpaceId() == null) {
            MainCoeditLogger.m7251e(TAG, "requestSync : getStateInfo().getSpaceId() null");
        } else {
            requestSync(Collections.singletonList(this.mPresenter.getStateInfo().getSpaceId()), z, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        super.setEditMode(z);
        return this.mNotesView.setMode(15);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode
    public void startTitleAndDatePolling(String str) {
        startTitleAndDatePolling(this.mSpaceId, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void updateTitle() {
        this.mIsLeader = SesCoeditShareReadResolver.getInstance().isSpaceOwner(this.mSpaceId);
        if (FeatureUtils.isCoeditSpaceMode(this.mPresenter.getStateInfo().getModeIndex())) {
            int size = SesCoeditGroupReadResolver.getInstance().getMemberInfoList(this.mGroupId).size();
            if (size == 0 && checkIsInvalidGroup()) {
                return;
            }
            AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
            if (CommonUtil.isNotAvailableActivity(appCompatActivity)) {
                return;
            }
            View toolbarCoeditSpaceExtraVisible = this.mToolbarIconInfoController.setToolbarCoeditSpaceExtraVisible(appCompatActivity, LocaleUtils.convertToArabicNumber(size), this.mIsLeader);
            this.mCustomSubTitleView = toolbarCoeditSpaceExtraVisible;
            this.mActionMenuController.setToolbarCustomSubTitle(toolbarCoeditSpaceExtraVisible);
            this.mActionMenuController.setCoeditInfoView(this.mCustomSubTitleView);
        }
    }
}
