package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListMediumCoverProvider;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.PickEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PickEditMode extends BaseMode implements PickEditModeView.Contract {
    private static final String TAG = "PickEditMode";
    protected final PickEditModeView mEditModeView;

    public PickEditMode(ModeParams modeParams) {
        super(modeParams);
        this.mEditModeView = new PickEditModeView(modeParams, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendNoteListToWidget$0(Intent intent) {
        this.mFragment.getActivity().setResult(-1, intent);
        this.mFragment.getActivity().finish();
    }

    private void updateActionMenu() {
        int checkedNotesCount = this.mPresenter.getCheckedNotesCount();
        int noteDataCount = this.mPresenter.getDocumentMap().getNoteDataCount();
        if (noteDataCount <= 0 || noteDataCount != checkedNotesCount) {
            this.mActionMenuController.updateSelectedNoteCount(false, checkedNotesCount);
        } else {
            onSelectAll(true);
        }
        this.mActionMenuController.setEnabledSelectAll(noteDataCount > 0);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public boolean callCustomKeyEventBase(int i, KeyEvent keyEvent) {
        return onCustomKeyEventBase(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getCurrentOptionsMenuStatus() {
        return this.mEditModeView.getCurrentOptionsMenuStatus();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getLastOptionsMenuStatus() {
        return this.mEditModeView.getMenuStatus();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 8;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.menu.PickEditModeView.Contract
    public int getModeSearchIndex() {
        return 9;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public int getOptionMenuRes() {
        return this.mEditModeView.getOptionMenuRes();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.menu.PickEditModeView.Contract
    public void handleActionCreateNote() {
        if (StorageUtils.isAvailableMemoryForNewMemo()) {
            this.mFragmentContract.onNewNote(this.mPresenter.getStateInfo().getFolderUuid(), 1);
        } else {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mFragment.getContext(), this.mFragment.getChildFragmentManager());
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.menu.PickEditModeView.Contract
    public void handleActionDone() {
        this.mFragmentContract.importNoteToSpace();
    }

    public boolean maxListWidget(boolean z) {
        int size;
        if (!z || (size = this.mPresenter.getCheckedNotesUUIDForWidgetList().size()) < 10) {
            return false;
        }
        String stringExtra = this.mFragment.getActivity().getIntent().getStringExtra(WidgetConstant.WIDGET_PROVIDER_NAME);
        AbstractC6670b.m4736A(size, "maxListWidget# checkedNoteCount : ", getTag());
        String quantityString = this.mAppContext.getResources().getQuantityString(C8003R.plurals.plurals_max_select_note_for_widget, 10, 10);
        if (stringExtra == null || !(stringExtra.equals(WidgetListExtraLargeCoverProvider.TAG) || stringExtra.equals(WidgetListMediumCoverProvider.TAG) || stringExtra.equals(WidgetListLargeCoverProvider.TAG))) {
            ToastHandler.show(this.mContext, quantityString, 0);
            return true;
        }
        ToastHandler.showToastOnFlipCoverScreen(ProviderUtils.createWidgetCoverContext(this.mContext), quantityString, 0);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (CommonUtil.isNotAvailableActivity(this.mFragment.getActivity())) {
            return false;
        }
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT);
        String backFolderHistory = this.mPresenter.getDocumentMap().getBackFolderHistory();
        if (backFolderHistory == null && this.mPresenter.getStateInfo().getPrevModeIndex() != getModeIndex()) {
            this.mFragment.getActivity().finish();
        }
        this.mNotesView.onFolderSelected(backFolderHistory);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onBindViewHolder(commonHolderInfo, checkBox, textView);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mRecyclerView.seslSetFadingEdgeEnabled(true, this.mEditModeView.isExtendBottomFadingEdge());
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
        if (i != 29) {
            if (i != 34) {
                if (i != 84) {
                    return this.mEditModeView.onCustomKeyEvent(i, keyEvent);
                }
                this.mNotesView.setMode(getModeSearchIndex());
                return false;
            }
            if ((keyEvent.getMetaState() & 4096) == 4096) {
                this.mNotesView.setMode(getModeSearchIndex());
                return false;
            }
        } else {
            if (keyEvent.getAction() != 0 || (keyEvent.getMetaState() & 4096) != 4096 || this.mPresenter.getDocumentMap().getNoteDataCount() == 0) {
                return false;
            }
            onSelectAll();
        }
        return callCustomKeyEventBase(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        setNoNotesLayoutVisibility();
        this.mPresenter.recalculateCheckedData();
        updateActionMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onItemChecked(String str, boolean z) {
        this.mPresenter.setCheck(str, z, true);
        int checkedNotesCount = this.mPresenter.getCheckedNotesCount();
        this.mActionMenuController.updateSelectedNoteCount(checkedNotesCount == this.mPresenter.getDocumentMap().getNoteDataCount(), checkedNotesCount);
    }

    public void onItemCheckedForWidget(String str, boolean z) {
        if (maxListWidget(z)) {
            return;
        }
        this.mPresenter.setCheck(str, z, true);
        updateSubHeaderCheckBox(str);
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.toggleActionModeToolbar(checkedDataCount > 0);
        this.mActionMenuController.updateSelectedNoteCount(false, checkedDataCount);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK, NotesSAConstants.EVENT_PICK_SELECT_NOTE);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        if (this.mPresenter.getDocumentMap().getFolderData(str) != null) {
            return false;
        }
        return super.onItemLongPressed(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        this.mEditModeView.onLayout();
        this.mActionMenuController.setAppbarCollapsedState();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        this.mEditModeView.onModeEnd();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        onItemChecked(mainEntryParam.getUuid(), !this.mPresenter.isUuidInCheckedNotes(mainEntryParam.getUuid()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mEditModeView.onOptionsItemSelected(menuItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        this.mEditModeView.onPrepareOptionsMenu();
        this.mEditModeView.onFilteredOptionsMenu(menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void onRestoreDataChanged(int i) {
        setNoNotesLayoutVisibility();
        updateActionMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSelectAll(boolean z) {
        AbstractC8014b.m7210l("onSelectAll: ", getTag(), z);
        if (this.mPresenter.getLongPressFlag()) {
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_MULTI_SELECTION, "1");
        }
        this.mPresenter.selectAllNotes(z);
        this.mActionMenuController.updateSelectedNoteCount(z, this.mPresenter.getCheckedNotesCount());
    }

    public void onSelectAllForListWidget() {
        if (this.mPresenter.getLongPressFlag()) {
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_MULTI_SELECTION, "1");
        }
        int checkedNotesCount = this.mPresenter.getCheckedNotesCount();
        AbstractC6670b.m4736A(checkedNotesCount, "onSelectAllForListWidget# checkedNoteCount : ", TAG);
        this.mPresenter.selectAllForListWidget(true, 10 - checkedNotesCount);
        this.mActionMenuController.updateSelectedNoteCount(true, checkedNotesCount);
        if (checkedNotesCount >= 10) {
            ToastHandler.show(this.mContext, this.mFragment.getResources().getQuantityString(C8003R.plurals.plurals_max_select_note_for_widget, 10, 10), 0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSubFolderSelected(String str) {
        if (this.mPresenter.getStateInfo().getCaller() == 6) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK_EDIT, NotesSAConstants.EVENT_PICK_EDIT_FOLDER_CONTAINER);
        }
        this.mNotesView.onFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSubHeaderSelected(boolean z, int i) {
        this.mEditModeView.onSubHeaderSelected(z, i);
        return true;
    }

    public boolean onSubHeaderSelectedForListWidget(boolean z, int i) {
        if (!this.mEditModeView.onSubHeaderSelected(z, i, 10)) {
            return true;
        }
        MainLogger.m7254d(TAG, "onSubHeaderSelected# checkedNoteCount : " + this.mPresenter.getCheckedNotesCount());
        ToastHandler.show(this.mContext, this.mFragment.getResources().getQuantityString(C8003R.plurals.plurals_max_select_note_for_widget, 10, 10), 0);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewAttachedToWindow(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        super.onViewAttachedToWindow(commonHolderInfo, checkBox, textView);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onWindowFocusChanged(boolean z) {
        this.mEditModeView.onWindowFocusChanged(z);
    }

    public void sendNoteListToWidget() {
        if (this.mFragment.getActivity() == null) {
            return;
        }
        Intent intent = this.mFragment.getActivity().getIntent();
        Intent intent2 = new Intent();
        if (intent.getBooleanExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, false)) {
            intent2.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, this.mPresenter.getCheckedNotesUUIDForWidgetList());
        } else {
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (BaseWidgetUtils.isSupportedNewWidget()) {
                WidgetBroadcast.sendPickNoteListBroadcast(this.mFragment.getActivity(), intExtra, intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, 75), intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, -1), intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, -1), intent.getBooleanExtra(WidgetConstant.EXTRA_KEY_ACTION_ADD_FROM_WIDGET_LIST_GLANCE, false) ? this.mPresenter.getCheckedNotesUUIDForWidgetList() : this.mPresenter.getCheckedNotesUUID(), intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, true), intent.getIntExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, 0), intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, true), 1);
            } else {
                WidgetBroadcast.sendPickNoteListBroadcast(this.mFragment.getActivity(), intExtra, intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, 100), this.mPresenter.getCheckedNotesUUID());
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC8515c(this, intent2, 2), DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mFragment.getActivity()) ? 150L : 0L);
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

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void updateCheckBoxState(CommonHolderInfo commonHolderInfo, CheckBox checkBox) {
        this.mEditModeView.updateCheckBoxState(commonHolderInfo, checkBox);
    }

    public void onBindViewHolder(CommonHolderInfo commonHolderInfo) {
        boolean zIsUuidInCheckedDimmedNotes = this.mPresenter.isUuidInCheckedDimmedNotes(commonHolderInfo.getUuid());
        commonHolderInfo.getRootCardView().setEnabled(!zIsUuidInCheckedDimmedNotes);
        commonHolderInfo.getRootCardView().setAlpha(!zIsUuidInCheckedDimmedNotes ? 1.0f : 0.4f);
    }

    public void onViewAttachedToWindow(CommonHolderInfo commonHolderInfo) {
        boolean zIsUuidInCheckedDimmedNotes = this.mPresenter.isUuidInCheckedDimmedNotes(commonHolderInfo.getUuid());
        commonHolderInfo.getRootCardView().setEnabled(!zIsUuidInCheckedDimmedNotes);
        commonHolderInfo.getRootCardView().setAlpha(!zIsUuidInCheckedDimmedNotes ? 1.0f : 0.4f);
    }

    public void onSelectAll() {
        onSelectAll(true);
    }
}
