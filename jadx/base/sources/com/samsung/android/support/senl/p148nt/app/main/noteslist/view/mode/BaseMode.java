package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.ftu.signin.SignInFTUActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomProgressCircleManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.IntentFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa.NotesListSALogModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteExpiredNotesTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.ModeContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.popupmenu.PopupMenuFactory;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.model.MainHandoffData;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.DocumentThreadPoolManager;
import com.samsung.android.support.senl.p148nt.model.service.RestoreCacheManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMode implements ViewContract.IMode {
    protected final ActionMenuController mActionMenuController;
    protected final Context mAppContext;
    protected final BottomMenuController mBottomMenuController;
    protected final Context mContext;
    protected final AbsFragment mFragment;
    protected final ModeContract.IFragment mFragmentContract;
    protected ViewGroup mNoHolderLayout;
    protected final ModeContract.IView mNotesView;
    protected final NotesPresenter mPresenter;
    protected final NotesPenRecyclerView mRecyclerView;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseMode(ModeParams modeParams) {
        ModeContract.IFragment fragmentContract = modeParams.getFragmentContract();
        this.mFragmentContract = fragmentContract;
        AbsFragment absFragment = (AbsFragment) fragmentContract;
        this.mFragment = absFragment;
        this.mRecyclerView = modeParams.getNotesRecyclerView();
        this.mActionMenuController = modeParams.getActionMenuController();
        this.mBottomMenuController = modeParams.getBottomMenuController();
        this.mPresenter = modeParams.getPresenter();
        this.mNotesView = modeParams.getNotesView();
        this.mContext = absFragment.getContext();
        this.mAppContext = BaseUtils.getApplicationContext();
        if (PermissionHelper.noticeAppPermissionIfNeededs(absFragment.getActivity())) {
            return;
        }
        checkSignInFTUNeeds();
    }

    private boolean alreadyChecked(String str, boolean z) {
        return this.mPresenter.isUuidInCheckedData(str) ? z : !z;
    }

    private void checkFocusedItem() {
        View focusedChild;
        View viewFindViewById;
        SubFolderHolderInfo subFolderHolderInfo;
        NotesPenRecyclerView notesPenRecyclerView = this.mRecyclerView;
        if (notesPenRecyclerView == null || (focusedChild = notesPenRecyclerView.getFocusedChild()) == null) {
            return;
        }
        CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.getChildViewHolder(focusedChild);
        if (commonHolder.getMHolderType() == 2048) {
            this.mPresenter.setCheck(((NotesHolder) commonHolder).getNotesHolderInfo().getUuid(), true, false);
        } else {
            if (commonHolder.getMHolderType() > 1024 || (viewFindViewById = focusedChild.findViewById(C8003R.id.sub_folder_icon)) == null || (subFolderHolderInfo = ((SubFolderHolder) commonHolder).getSubFolderHolderInfo(((Integer) viewFindViewById.getTag()).intValue())) == null) {
                return;
            }
            this.mPresenter.setCheck(subFolderHolderInfo.getUuid(), true, false);
        }
    }

    private boolean closeDrawer() {
        return this.mFragmentContract.closeDrawer(true, 0);
    }

    private boolean isEditModeExceptPickEdit() {
        return (!FeatureUtils.isEditMode(getModeIndex()) || getModeIndex() == 8 || getModeIndex() == 25 || getModeIndex() == 28) ? false : true;
    }

    private boolean setDataWithoutFolder(List<MainListDocumentData> list) {
        if (this.mPresenter.getDocumentMap().nonNullDocumentCountMap() && this.mPresenter.getDocumentMap().getDocumentCount(this.mPresenter.getStateInfo().getFolderUuid()) <= 0) {
            this.mNotesView.releaseEmptyFolder();
        }
        return this.mPresenter.getDocumentMap().initNoteMapWithoutFolder(list);
    }

    private void updateSubFolder(CommonHolderInfo commonHolderInfo) {
        if (commonHolderInfo.isExpandable() && this.mPresenter.isCollapseSubFolderActionRunning()) {
            commonHolderInfo.getRootCardView().setVisibility(8);
        }
    }

    public boolean backStackHistory() {
        String backFolderHistory = this.mPresenter.getDocumentMap().getBackFolderHistory();
        if (backFolderHistory == null) {
            return NotesUtils.isTabletLayout(this.mContext) && closeDrawer();
        }
        this.mNotesView.onFolderSelected(backFolderHistory);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void checkSignInFTUNeeds() {
        if (FTUConstants.isSignInFTUNeeds() == 0 && !FeatureUtils.isDrawerInvisibleMode(getModeIndex()) && DeviceUtils.isSupportedSync(C0158a.m407a().f492a)) {
            FragmentActivity activity = this.mFragment.getActivity();
            if (activity == null || activity.isFinishing()) {
                MainLogger.m7255e(getTag(), "checkSignInFTUNeeds# show FTU, ignored, activity is invalid");
                return;
            }
            MainLogger.m7254d(getTag(), "checkSignInFTUNeeds# show FTU");
            FTUConstants.setSignInFTUUsed();
            Intent intent = new Intent(this.mAppContext, (Class<?>) SignInFTUActivity.class);
            intent.setFlags(603979776);
            if (DeviceInfo.isVSTModel()) {
                PopOverActivityWrapper.startActivityForResult(activity, intent, 15, 9);
            } else {
                activity.startActivityForResult(intent, 15);
            }
        }
    }

    public PopupMenu createContextPopupMenu(CommonHolderInfo commonHolderInfo) {
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return null;
        }
        return PopupMenuFactory.create(this.mFragment.getView(), activity.getMenuInflater(), this.mPresenter, commonHolderInfo);
    }

    public void executeDeleteExpiredNotes() {
        if (FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel()) {
            return;
        }
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        WorkerTask<?> runningTask = WorkerTaskManager.getInstance().getRunningTask(DeleteExpiredNotesTask.TAG);
        if (runningTask == null || runningTask.isCompleted()) {
            new DeleteExpiredNotesTask(activity).run(null);
        }
    }

    public void executePostAction() {
        updateBadge();
        handleHandoffAction();
        setNoNotesLayoutVisibility();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getCurrentOptionsMenuStatus() {
        return 0L;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public Intent getIntentForNoteSelected(MainEntryParam mainEntryParam) {
        return IntentFactory.makeIntent(1, this.mFragment.getActivity(), mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public long getLastOptionsMenuStatus() {
        return -1L;
    }

    public abstract int getModeIndex();

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public int getOptionMenuRes() {
        return 0;
    }

    public abstract String getTag();

    public Toolbar getToolbar() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity) || !activity.hasWindowFocus()) {
            return null;
        }
        return (Toolbar) activity.findViewById(C8003R.id.toolbar);
    }

    public void handleHandoffAction() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity) || !activity.hasWindowFocus()) {
            return;
        }
        Intent intent = activity.getIntent();
        MainHandoffManager.Companion companion = MainHandoffManager.INSTANCE;
        if (companion.getInstance().isHandoffAction(intent)) {
            return;
        }
        int modeIndex = getModeIndex();
        MainHandoffData.HandoffDataBuilder spaceId = new MainHandoffData.HandoffDataBuilder().setActivityType(HandoffUtils.getInstance().getActivityTypeFromClass(activity.getClass())).setFolderUuid(this.mPresenter.getStateInfo().getFolderUuid()).setSelectedTags(this.mPresenter.getStateInfo().getSelectedTags()).setCategoryUuid(this.mPresenter.getStateInfo().getCategoryUuid()).setSearchText(this.mNotesView.getSearchImpl().getSearchSavedText()).setSpaceId(this.mPresenter.getStateInfo().getSpaceId());
        if (FeatureUtils.isCoeditMode(modeIndex) || FeatureUtils.isCoeditSpaceMode(modeIndex)) {
            spaceId.setGroupId(this.mPresenter.getStateInfo().getGroupId());
        } else {
            spaceId.setGroupId(SesShareReadResolver.getInstance().getGroupId(this.mPresenter.getStateInfo().getSpaceId()));
        }
        companion.getInstance().sendHandoffAction(activity.getTaskId(), modeIndex, spaceId.getMMainHandoffData());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean hasCreatePostLogic() {
        return PostLaunchManager.getInstance().hasLogic(this.mFragment.getPostLaunchToken(), 105);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        MainLogger.m7258i(getTag(), "onBackKeyDown");
        return closeDrawer();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        updateCheckBoxState(commonHolderInfo, checkBox);
        updateCountTextView(textView, isEditModeExceptPickEdit() ? 8 : 0);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        this.mNotesView.onConfigurationChanged();
        if (ModelFeature.getFeature().isFoldableModel()) {
            this.mPresenter.setLastDisplay(DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(configuration));
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(final CommonHolderInfo commonHolderInfo) {
        PopupMenu popupMenuCreateContextPopupMenu = createContextPopupMenu(commonHolderInfo);
        if (popupMenuCreateContextPopupMenu == null) {
            return false;
        }
        final String uuid = commonHolderInfo.getUuid();
        final MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(uuid);
        popupMenuCreateContextPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.BaseMode.1
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                BaseMode.this.mPresenter.updateCheckedData(commonHolderInfo, true);
                int itemId = menuItem.getItemId();
                if (itemId == C8003R.id.move) {
                    BaseMode.this.mPresenter.showFolderPickerDialog();
                } else if (itemId == C8003R.id.convert) {
                    BaseMode.this.mPresenter.showConvertConfirmDialog();
                } else if (itemId == C8003R.id.lock) {
                    BaseMode.this.mPresenter.setLockNotes();
                } else if (itemId == C8003R.id.unlock) {
                    BaseMode.this.mPresenter.setUnlockNotes();
                } else if (itemId == C8003R.id.share) {
                    if (noteData.isSDoc()) {
                        BaseMode.this.mPresenter.shareOldNotes();
                    } else {
                        BaseMode.this.mPresenter.showExportOptionPopup(false);
                    }
                } else if (itemId == C8003R.id.delete) {
                    BaseMode.this.mPresenter.showDeleteDialog();
                } else if (itemId == C8003R.id.save) {
                    BaseMode.this.mPresenter.showExportOptionPopup(true);
                } else if (itemId == C8003R.id.duplicate) {
                    BaseMode.this.mPresenter.duplicateToDevice();
                } else if (itemId == C8003R.id.secure_folder) {
                    if (NotesUtils.isWarning(noteData.getCorrupted())) {
                        ToastHandler.show(BaseMode.this.mContext, C8003R.string.base_string_failed_to_load_image, 0);
                    } else {
                        NotesPresenter notesPresenter = BaseMode.this.mPresenter;
                        notesPresenter.moveToSecureFolder(notesPresenter.getCheckNotesCountInfo().getLockedNotesCount());
                    }
                } else if (itemId == C8003R.id.color) {
                    NotesPresenter notesPresenter2 = BaseMode.this.mPresenter;
                    Object[] objArr = {uuid};
                    ArrayList arrayList = new ArrayList(1);
                    Object obj = objArr[0];
                    notesPresenter2.showChangeColorDialog(new ArrayList<>(AbstractC2322a.m1630t(obj, arrayList, obj, arrayList)));
                } else if (itemId == C8003R.id.rename) {
                    BaseMode.this.mPresenter.showFolderRenameDialog();
                } else if (itemId == C8003R.id.action_remove_from_favorites) {
                    BaseMode.this.mPresenter.updateFavorite(false);
                } else if (itemId == C8003R.id.action_add_to_favorites) {
                    BaseMode.this.mPresenter.updateFavorite(true);
                } else if (itemId == C8003R.id.action_edit_cover) {
                    BaseMode.this.mPresenter.getCoverHelper().showCoverEditDialog(uuid);
                    BaseMode.this.mPresenter.clearCheckedData();
                } else {
                    if (itemId != C8003R.id.action_details) {
                        BaseMode.this.mPresenter.updateCheckedData(commonHolderInfo, false);
                        return false;
                    }
                    BaseMode.this.mPresenter.getDetailsMenuHelper().showDetailsDialog(BaseMode.this.mPresenter.getCheckedNotesUUID().get(0));
                    BaseMode.this.mPresenter.clearCheckedData();
                }
                return true;
            }
        });
        popupMenuCreateContextPopupMenu.show();
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return onCustomKeyEventBase(i, keyEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onCustomKeyEventBase(int i, KeyEvent keyEvent) {
        if (i == 59 || i == 60) {
            if (this.mRecyclerView == null) {
                return false;
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                this.mRecyclerView.setShiftKeyPressed(true);
                return true;
            }
            if (keyEvent.getAction() == 1) {
                this.mRecyclerView.setShiftKeyPressed(false);
                return true;
            }
        } else if (i != 67) {
            switch (i) {
                case 112:
                    if (keyEvent.getAction() == 1) {
                        if (!FeatureUtils.isEditMode(getModeIndex())) {
                            checkFocusedItem();
                        }
                        if (this.mPresenter.getCheckedDataCount() > 0) {
                            this.mPresenter.showDeleteDialog();
                        }
                    }
                    break;
                case 113:
                case 114:
                    if (this.mRecyclerView == null) {
                        return false;
                    }
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        this.mRecyclerView.startDragMouseMultiSelection();
                        return true;
                    }
                    if (keyEvent.getAction() == 1) {
                        this.mRecyclerView.cancelDragMouseMultiSelection();
                        return true;
                    }
                    break;
            }
        } else if (keyEvent.getAction() == 1 && !this.mNotesView.getMode().onBackKeyDown()) {
            this.mFragment.getActivity().finish();
        }
        return false;
    }

    public void onDataChangedBase(int i) {
        if (hasCreatePostLogic()) {
            return;
        }
        executePostAction();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        boolean dataWithoutFolder = FeatureUtils.isFilterFolderType(this.mPresenter.getStateInfo().getFolderUuid()) ? setDataWithoutFolder(list) : this.mPresenter.getDocumentMap().initNoteMap(list);
        int prevModeIndex = this.mPresenter.getStateInfo().getPrevModeIndex();
        if (FeatureUtils.isSearchMode(prevModeIndex)) {
            this.mPresenter.notifyDataSetChangedWithViewPageChange("Notes LiveData onChanged");
        } else if (prevModeIndex == 23) {
            dataWithoutFolder = true;
        }
        AbstractC8014b.m7210l("onDataChangedByMode# isDataChanged : ", getTag(), dataWithoutFolder);
        return dataWithoutFolder ? AdapterManager.DataState.CHANGED : AdapterManager.DataState.UNCHANGED;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        onDataChangedBase(i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDestroy() {
        BottomProgressCircleManager.getInstance().dismiss();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onItemChecked(String str, boolean z) {
        if (alreadyChecked(str, z)) {
            return;
        }
        this.mPresenter.setCheck(str, z, true);
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        this.mActionMenuController.updateSelectedNoteCount(checkedDataCount == this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders), checkedDataCount);
        updateSubHeaderCheckBox(str);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        MainLogger.m7258i(getTag(), "onItemLongPressed - uuid: " + str);
        return onItemLongPressedBase(str);
    }

    public boolean onItemLongPressedBase(String str) {
        this.mRecyclerView.requestDisallowInterceptTouchEvent(true);
        this.mNotesView.getMode().onItemChecked(str, true);
        this.mRecyclerView.startLongPressMultiSelection();
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        onLayoutBase();
        this.mNotesView.getSearchImpl().changeViewMode();
    }

    public void onLayoutBase() {
        if (this.mFragment.getActivity() == null) {
            return;
        }
        MainLogger.m7258i(getTag(), "onLayoutBase");
        this.mNotesView.setNoteFabVisibleWithAnimation();
        this.mActionMenuController.setHideSelectAllCheckbox();
        this.mActionMenuController.resetCheckItems();
        ViewModeUtils.updateRecyclerViewPaddingBottom(this.mRecyclerView, FeatureUtils.isNeedFooter(getModeIndex(), this.mPresenter.getStateInfo().getFolderUuid()) || FeatureUtils.isEditMode(getModeIndex()));
        ViewModeUtils.initGoToTopButtonPosition(this.mRecyclerView, this.mActionMenuController.getFloatingToolbarLayout(), this.mBottomMenuController.getMFloatingBottomLayout());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        MainLogger.m7254d(getTag(), "onModeEnd");
        this.mNotesView.getSearchImpl().changeViewMode();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        String uuid = mainEntryParam.getUuid();
        boolean zExists = new File(mainEntryParam.getFilePath()).exists();
        if (mainEntryParam.getFileExtension().equals(".sdoc") && ConvertTaskManager.getInstance().isConverting(uuid)) {
            AbstractC8014b.m7209k("onNoteSelected isConverting - uuid: ", uuid, getTag());
            ToastHandler.show(this.mContext, this.mFragment.getString(C8003R.string.select_converting_note), 1, false);
            return;
        }
        if (zExists) {
            if (!RestoreCacheManager.isRestoring(uuid)) {
                this.mFragmentContract.onNoteSelected(mainEntryParam);
                return;
            } else {
                AbstractC8014b.m7209k("onNoteSelected isRestoring - uuid: ", uuid, getTag());
                ToastHandler.show(this.mContext, C8003R.string.updating_note_try_again_later, 0);
                return;
            }
        }
        if (DocumentThreadPoolManager.getInstance().isSaving(uuid)) {
            AbstractC8014b.m7209k("onNoteSelected, document is saving - uuid: ", uuid, getTag());
            ToastHandler.show(this.mContext, C8003R.string.document_service_notification_name_saving, 0);
        } else {
            AbstractC8014b.m7209k("onNoteSelected, file error - uuid: ", uuid, getTag());
            ToastHandler.show(this.mContext, C8003R.string.unable_to_open_note, 0);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPaused() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPostResume() {
        executeDeleteExpiredNotes();
        executePostAction();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareContextMenu(Menu menu) {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRestoreDataChanged(int i) {
        onDataChangedViewUpdate(i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        if (this.mPresenter.onRestoreProgressCircle() || !bundle.getBoolean(NotesConstants.KEY_TASKING, false)) {
            return;
        }
        this.mPresenter.onTaskFinished();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (activity != null && EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(this.mAppContext)) {
            MainLogger.m7258i(getTag(), "isEmergencyMode is true");
            activity.findViewById(C8003R.id.notes_fragment_container).requestLayout();
        }
        NotesListSALogModel.addSAlogOnResume(getModeIndex(), this.mPresenter.getStateInfo().getFolderUuid());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSaveInstanceState(Bundle bundle) {
        onSaveInstanceStateBase(bundle);
    }

    public void onSaveInstanceStateBase(Bundle bundle) {
        bundle.putBoolean(NotesConstants.KEY_TASKING, this.mPresenter.onRestoreProgressCircle());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSelectAll(boolean z) {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSubFolderSelected(String str) {
        this.mNotesView.onFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSubHeaderSelected(long j, boolean z) {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSwipeRefresh() {
        MainLogger.m7254d(getTag(), "onSwipeRefresh#");
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewAttachedToWindow(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView) {
        updateCheckBoxState(commonHolderInfo, checkBox);
        updateCountTextView(textView, isEditModeExceptPickEdit() ? 8 : 0);
        updateSubFolder(commonHolderInfo);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewChangeRestoreInstanceState() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewChangeSaveInstanceState() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void releaseEditMode() {
        this.mRecyclerView.setLastClickedUuid(null);
    }

    public void removeCircleProgressDialog() {
        NotesPresenter notesPresenter = this.mPresenter;
        if (notesPresenter == null) {
            return;
        }
        notesPresenter.removeCircleProgressDialog();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        if (!z || this.mPresenter.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders) != 1) {
            return false;
        }
        String uuid = null;
        for (Common common : this.mPresenter.getDocumentMap().getCommonDisplayList()) {
            int i = common.type;
            if (i < 16384) {
                if (i == 2048) {
                    uuid = common.notes.getUuid();
                } else if (i <= 1024) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.mPresenter.getStateInfo().getSubFoldersSpan() || common.folders.get(i2) == null) {
                            break;
                        }
                        if (!FolderUtils.isStaticFolder(common.folders.get(i2).getUuid())) {
                            uuid = common.folders.get(i2).getUuid();
                            break;
                        }
                        i2++;
                    }
                }
                if (uuid != null) {
                    this.mPresenter.setCheck(uuid, true, false);
                    return true;
                }
            }
        }
        return false;
    }

    public void setNoHolderLayout() {
        TextView textView = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note);
        TextView textView2 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_note_sub);
        TextView textView3 = (TextView) this.mNoHolderLayout.findViewById(C8003R.id.no_result);
        textView.setVisibility(0);
        textView.setText(C8003R.string.no_notes);
        textView2.setVisibility(0);
        textView2.setText(C8003R.string.sub_no_notes);
        textView3.setVisibility(8);
    }

    public boolean setNoNoteLayoutVisibility(int i, String str) {
        if (hasCreatePostLogic()) {
            MainLogger.m7255e(str, "setNoNoteLayoutVisibility# do not inflate no note layout if post logic exists");
            return false;
        }
        AbstractC6670b.m4736A(i, "setNoNoteLayoutVisibility# visibility: ", str);
        if (this.mNoHolderLayout == null) {
            this.mNoHolderLayout = (ViewGroup) ViewModeUtils.getInflatedView(this.mFragment.getView(), C8003R.id.no_note_layout, C8003R.id.inflate_no_note_layout);
        }
        ViewGroup viewGroup = this.mNoHolderLayout;
        if (viewGroup == null) {
            return false;
        }
        this.mActionMenuController.setVerticalView(viewGroup);
        this.mNoHolderLayout.setVisibility(i);
        this.mRecyclerView.setImportantForAccessibility(i == 0 ? 2 : 1);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void setNoNotesLayoutVisibility() {
        int modeIndex = getModeIndex();
        int noteDataCount = this.mPresenter.getDocumentMap().getNoteDataCount();
        int folderCount = this.mPresenter.getDocumentMap().getFolderCount();
        int tipCardHolderCount = this.mPresenter.getTipCardHolderCount();
        String tag = getTag();
        StringBuilder sbM778t = AbstractC0541b.m778t(modeIndex, "setNoNoteLayoutVisibility# mode: ", ", folderUuid: ");
        sbM778t.append(this.mPresenter.getStateInfo().getFolderUuid());
        sbM778t.append(", noteCount: ");
        sbM778t.append(noteDataCount);
        sbM778t.append(", folderCount: ");
        sbM778t.append(folderCount);
        sbM778t.append(", tipCardHolderCount: ");
        sbM778t.append(tipCardHolderCount);
        MainLogger.m7258i(tag, sbM778t.toString());
        if (noteDataCount + folderCount + tipCardHolderCount > 0) {
            setNoNoteLayoutVisibility(8, getTag());
        } else if (setNoNoteLayoutVisibility(0, getTag())) {
            setNoHolderLayout();
        }
    }

    public void setSearchNoHolderLayout() {
    }

    public void setSearchNoRecentHolderLayout(int i) {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void showBottomNavigation(boolean z) {
    }

    public void showCircleProgressDialog() {
        NotesPresenter notesPresenter = this.mPresenter;
        if (notesPresenter == null) {
            return;
        }
        notesPresenter.showCircleProgressDialog();
    }

    public void updateBadge() {
        int modeIndex = getModeIndex();
        if (FeatureUtils.isOldMode(modeIndex) || FeatureUtils.isHashTagMode(modeIndex) || this.mFragment.getActivity() == null) {
            return;
        }
        BadgeHelper.updateGcsUnReadCount();
        BadgeHelper.updateCoeditUnReadCount();
        this.mActionMenuController.updateDrawerIconWithBadge();
        this.mPresenter.checkSOMUnRecognizedCount();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void updateBasicEffect(boolean z) {
        ViewModeUtils.updateRecyclerViewFadingEdge(this.mRecyclerView, this.mActionMenuController.getHasPaddingForFolderpathLayout(), z);
        ViewModeUtils.updateGoToTopButtonPosition(this.mBottomMenuController.getMFloatingBottomLayout(), z);
        ViewModeUtils.updateFloatingLayoutShadow(this.mRecyclerView, this.mBottomMenuController.getMFloatingBottomLayout(), this.mActionMenuController.getMultiFloatingView(), this.mActionMenuController.getFloatingToolbarLayout());
    }

    public void updateCheckBoxState(CommonHolderInfo commonHolderInfo, CheckBox checkBox) {
        if (checkBox != null && checkBox.getVisibility() != 8) {
            this.mPresenter.setCheckBoxState(commonHolderInfo);
            checkBox.setVisibility(8);
        }
        this.mPresenter.updateContentDescription(commonHolderInfo, false);
    }

    public void updateCountTextView(TextView textView, int i) {
        if (textView == null || textView.getVisibility() == i) {
            return;
        }
        textView.setVisibility(i);
    }

    public void updateFocusView(int i) {
        if (FeatureUtils.isNotUsingNotesListFragment(i)) {
            AbstractC8014b.m7201c(i, "updateFocusView# applyWindowInsets, last : ", getTag());
            this.mNotesView.applyWindowInsets();
        }
    }

    public void updateSubHeaderCheckBox(String str) {
        this.mPresenter.updateTimeSubHeaderCheckBox(str);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void updateTitle() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onSubHeaderSelected(boolean z, int i) {
        return true;
    }
}
