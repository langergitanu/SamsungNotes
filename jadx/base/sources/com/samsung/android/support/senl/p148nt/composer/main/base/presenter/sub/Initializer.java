package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.hashtag.HashTagDataHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.IntroVI;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import com.samsung.android.support.senl.p148nt.model.repository.data.tag.DocumentTagFactory;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Initializer {
    private static final String TAG = Logger.createTag("Initializer");
    private final Activity mActivity;
    private final ComposerViewPresenter mCompViewPresenter;
    private final ComposerModel mComposerModel;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogPresenterManager;
    private final Fragment mFragment;
    private final boolean mHashTagEnabled;
    private final MenuPresenterManager mMenuPresenterManager;
    private final PageManager mPageManager;

    public Initializer(BaseSubManager baseSubManager) {
        this.mActivity = baseSubManager.getComposerLifeState().getActivity();
        this.mFragment = baseSubManager.getComposerLifeState().getFragment();
        this.mMenuPresenterManager = baseSubManager.getMenuPresenterManager();
        this.mControllerManager = baseSubManager.getControllerManager();
        ComposerViewPresenter compViewPresenter = baseSubManager.getCompViewPresenter();
        this.mCompViewPresenter = compViewPresenter;
        this.mDialogPresenterManager = baseSubManager.getDialogPresenterManager();
        this.mComposerModel = baseSubManager.getComposerModel();
        this.mPageManager = compViewPresenter.getPageManager();
        this.mHashTagEnabled = baseSubManager.getConfig().isHashTagEnabled();
    }

    private void blockSipToShow(boolean z, String str) {
        if (z) {
            this.mControllerManager.getSoftInputManager().blockToShow(true, str);
        } else {
            this.mCompViewPresenter.getView().postDelayed(new RunnableC9957a(this, str, 1), 10L);
        }
    }

    private boolean handleActionSend(Intent intent, boolean z) {
        int iIsSendAction = EntryAction.isSendAction(intent);
        if (iIsSendAction == 0) {
            return false;
        }
        if (iIsSendAction == 2) {
            ToastHandler.show(this.mActivity, C9086R.string.unsupported_format_note, 0);
            setEntryDefaultState(intent, z);
            return true;
        }
        blockSipToShow(true, "handleActionSend ");
        this.mComposerModel.getModeManager().setMode(Mode.Text, "insert item from share", true);
        EntryAction entryAction = new EntryAction();
        if (!entryAction.isDefaultTemplatePdf(intent) || entryAction.isSendActionWithPdf(this.mActivity, intent)) {
            entryAction.executeTaskActionSend(intent, this.mActivity, this.mFragment, this.mCompViewPresenter, this.mControllerManager, this.mDialogPresenterManager, false);
        } else {
            entryAction.executeNewAddActionWithPdfTemplate(intent, this.mMenuPresenterManager.getOptionMenuPresenter().getOptionMenuAddPresenter());
            setPendingJobToTaskController(new RunnableC9960d(this, 1, entryAction, intent));
        }
        blockSipToShow(false, "handleActionSend ");
        return true;
    }

    private void handleEntryAction(Intent intent, boolean z) {
        if (handleActionSend(intent, z)) {
            Logger.m10999d(TAG, "handleEntryAction# action send");
            return;
        }
        if (handleWidgetAction(intent)) {
            Logger.m10999d(TAG, "handleEntryAction# widget action");
            return;
        }
        EntryAction entryAction = new EntryAction();
        setEntryDefaultState(intent, z);
        if (!z) {
            entryAction.executeSearchTextAction(intent, this.mComposerModel.getModeManager(), this.mPageManager);
        } else if (entryAction.isDynamicTemplate(intent)) {
            entryAction.executeNewDynamicTemplateAction(this.mActivity, intent, this.mControllerManager.getTaskController(), this.mMenuPresenterManager.getDynamicTemplatePresenter().getMDynamicTemplateLoader());
        } else {
            entryAction.executeNewAction(this.mActivity, intent, this.mMenuPresenterManager.getOptionMenuPresenter().getOptionMenuAddPresenter());
        }
    }

    private boolean handleWidgetAction(Intent intent) {
        String stringExtra = intent.getStringExtra(ComposerConstants.MEMO_WIDGET_ACTION);
        if (stringExtra == null) {
            return false;
        }
        EntryAction entryAction = new EntryAction();
        boolean zIsDefaultTemplatePdf = entryAction.isDefaultTemplatePdf(intent);
        entryAction.executeWidgetSendAction(this.mActivity.getIntent(), this.mMenuPresenterManager.getOptionMenuPresenter().getOptionMenuAddPresenter(), this.mControllerManager.getSoftInputManager(), this.mComposerModel.getModeManager(), !zIsDefaultTemplatePdf, isToolbarSmartTip());
        if (zIsDefaultTemplatePdf) {
            entryAction.executeNewAddActionWithPdfTemplate(this.mActivity.getIntent(), this.mMenuPresenterManager.getOptionMenuPresenter().getOptionMenuAddPresenter());
            setPendingJobToTaskController(new RunnableC9957a(this, stringExtra, 0));
        }
        return true;
    }

    private void initHashTag() {
        if (this.mHashTagEnabled && FeatureInfo.isHashTagFeatureEnabled() && !this.mComposerModel.getMdeInfo().isMde()) {
            Logger.m10999d(TAG, "initHashTag#, Initialized the tag list from [DB] ");
            List<TagData> listCreateTagDataFromEntities = DocumentTagFactory.createTagDataFromEntities(NotesDataRepositoryFactory.newInstance(this.mActivity).createDocumentTagRepository().getTagListByDocUuid(this.mComposerModel.getDocState().getUuid()));
            this.mComposerModel.getDocState().getTagDataSource().setOriginalSortedList(listCreateTagDataFromEntities);
            initTagList(listCreateTagDataFromEntities);
        }
    }

    private void initStickyModel() {
        this.mComposerModel.getDocState().getStickyDataSource().insert(NotesDataRepositoryFactory.newInstance(this.mActivity).createStickyNoteRepository().getEntities(this.mComposerModel.getDocState().getUuid()), true);
    }

    private void initTagList(List<TagData> list) {
        this.mCompViewPresenter.setTagList(HashTagDataHelper.convertToTagStringList(list));
        this.mMenuPresenterManager.getTitleEditorPresenter().getHashTagPresenter().saveTagList(list);
    }

    private boolean isToolbarSmartTip() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        boolean z = sharedPreferencesCompat.getBoolean(SharedPreferencesConstants.COMPOSER_KEY_GUIDE_SMART_TIP_SHOWN, true);
        boolean z2 = sharedPreferencesCompat.getBoolean(SharedPreferencesConstants.COMPOSER_KEY_LASER_PEN_GUIDE_SHOWN, false);
        if (!this.mComposerModel.isTabletLayout()) {
            return z || IntroVI.isSupport() || !z2;
        }
        return ((sharedPreferencesCompat.getInt(SharedPreferencesConstants.FLOATING_GUIDE_COUNT_ID, 1) == 5) && z) || ((sharedPreferencesCompat.getInt(SharedPreferencesConstants.CUSTOM_GUIDE_COUNT_ID, 1) == 3) && sharedPreferencesCompat.getBoolean(SharedPreferencesConstants.COMPOSER_KEY_CUSTOMIZE_TOOLBAR_SHOWN, true)) || ((sharedPreferencesCompat.getInt(SharedPreferencesConstants.CUSTOM_GUIDE_COUNT_ID, 1) == 2) && !z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$blockSipToShow$2(String str) {
        if (this.mCompViewPresenter.getView() == null) {
            return;
        }
        this.mControllerManager.getSoftInputManager().blockToShow(false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleActionSend$0(EntryAction entryAction, Intent intent) {
        entryAction.executeTaskActionSend(intent, this.mActivity, this.mFragment, this.mCompViewPresenter, this.mControllerManager, this.mDialogPresenterManager, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleWidgetAction$1(String str) {
        if (str.equals(ComposerConstants.NEW_MEMO_VOICE_OPEN)) {
            this.mMenuPresenterManager.getOptionMenuPresenter().getOptionMenuAddPresenter().addVoice();
        } else if (str.equals(ComposerConstants.NEW_MEMO_INSERT_OPEN)) {
            this.mMenuPresenterManager.getOptionMenuPresenter().getOptionMenuAddPresenter().addImage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restore$3(boolean z) {
        if (this.mControllerManager.getSoftInputManager() != null) {
            this.mControllerManager.getSoftInputManager().blockToShow(z, "composerModel_restore");
        }
    }

    private void setDataFromDB(boolean z) {
        this.mComposerModel.setOpenedTime();
        if (z) {
            return;
        }
        Logger.startTime(String.valueOf(hashCode()));
        setStrokeRecognitionData();
        initHashTag();
        initStickyModel();
        Logger.endTime(String.valueOf(hashCode()), TAG, "setDataFromDB#");
    }

    private void setEntryDefaultState(Intent intent, boolean z) {
        boolean zIsLaunchedPen = CommonUtil.isLaunchedPen(intent);
        if (DeviceInfo.isVSTModel()) {
            zIsLaunchedPen = false;
        }
        if (intent.getBooleanExtra(ComposerConstants.ARG_POPUP_NOTE, false)) {
            zIsLaunchedPen = ComposerSpenUtils.canUseSpen(this.mActivity);
        }
        boolean zIsToolbarSmartTip = isToolbarSmartTip();
        if (!z || zIsToolbarSmartTip) {
            if (!zIsToolbarSmartTip) {
                this.mCompViewPresenter.getComposerControllerManager().getComposerModeController().setBlockingSelectBodyText(true);
            }
            blockSipToShow(true, "setEntryDefaultState# tooltip: " + zIsToolbarSmartTip);
        }
        boolean z2 = !this.mComposerModel.isSupportedViewMode() ? true : z;
        if (!zIsLaunchedPen && DeviceUtils.isSpenModel() && CommonUtil.isAutoTypeForDefaultEditingMode()) {
            zIsLaunchedPen = this.mComposerModel.getComposerSpenDocModel().isHandwritingOnlyNote();
            Logger.m11003i(TAG, "isHandwritingOnlyNote# isLaunchedPen");
        }
        this.mComposerModel.getModeManager().init(z2, zIsLaunchedPen, EntryAction.isPdfViewAction(intent), EntryAction.isSimpleModeAction(intent), this.mComposerModel.isPDFReader() && EntryAction.isEditModeAction(intent));
        this.mCompViewPresenter.getComposerControllerManager().getComposerModeController().setBlockingSelectBodyText(false);
        blockSipToShow(false, "setEntryDefaultState");
    }

    private void setPendingJobToTaskController(Runnable runnable) {
        this.mControllerManager.getTaskController().addPendingJob(runnable, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initChangeNoteCase() {
        boolean z;
        setDataFromDB(false);
        this.mMenuPresenterManager.initFirstCase();
        Mode prevMode = this.mComposerModel.getModeManager().getPrevMode();
        Mode mode = this.mComposerModel.getModeManager().getMode();
        this.mComposerModel.getModeManager().setMode(Mode.Init, "changing doc", false);
        if (mode != Mode.Writing) {
            if (mode == Mode.Text) {
                this.mControllerManager.getSoftInputManager().blockToShow(true, "initChangeNoteCase");
                z = true;
            }
            this.mComposerModel.getModeManager().setMode(mode, "changing doc", true);
            this.mComposerModel.getModeManager().setPrevMode(prevMode);
            if (z) {
                this.mCompViewPresenter.getObjectManager().clearSelectObject();
                this.mControllerManager.getSoftInputManager().blockToShow(false, "initChangeNoteCase");
            }
            this.mMenuPresenterManager.invalidateOptionsMenu();
        }
        this.mMenuPresenterManager.getToolbarPresenter().clearSelectedButtonsOfHandWritingToolbarItem();
        z = false;
        this.mComposerModel.getModeManager().setMode(mode, "changing doc", true);
        this.mComposerModel.getModeManager().setPrevMode(prevMode);
        if (z) {
        }
        this.mMenuPresenterManager.invalidateOptionsMenu();
    }

    public void initFirstCase(boolean z) {
        setDataFromDB(z);
        Logger.startTime(String.valueOf(hashCode()));
        Intent intent = this.mActivity.getIntent();
        handleEntryAction(intent, z);
        this.mComposerModel.getComposerState().setFinishAfterSave(intent.getBooleanExtra(ComposerConstants.EXTRA_KEY_PICK_NOTE, false));
        this.mMenuPresenterManager.initFirstCase();
        Logger.endTime(String.valueOf(hashCode()), TAG, "initFirstCase#");
    }

    public void restore(LifecycleOwner lifecycleOwner, Bundle bundle, boolean z) {
        if (z) {
            setStrokeRecognitionData();
            if (this.mHashTagEnabled && FeatureInfo.isHashTagFeatureEnabled() && !this.mComposerModel.getMdeInfo().isMde()) {
                Logger.m10999d(TAG, "initComposer#, Initialized the tag list from [SDocState] ");
                initTagList(this.mComposerModel.getDocState().getTagDataSource().cloneChangedSortedList());
            }
        } else {
            initHashTag();
        }
        initStickyModel();
        this.mMenuPresenterManager.getHwToolbarPresenter().restoreSettingState(bundle);
        this.mComposerModel.restoreState(bundle, z, new C8886c(this, 9));
        this.mCompViewPresenter.restoreState(bundle);
        this.mComposerModel.getEntityManager().updateDataRepository(lifecycleOwner);
        if (this.mControllerManager.getTaskController().isRunning() || !this.mControllerManager.getProgressController().isShowingProgressCircleByType(0)) {
            return;
        }
        this.mControllerManager.getProgressController().hideProgress(0, true);
    }

    public void restoreMenu(Bundle bundle, boolean z) {
        this.mMenuPresenterManager.restoreState(bundle, z);
    }

    public void setStrokeRecognitionData() {
        String uuid = this.mComposerModel.getDocState().getUuid();
        this.mComposerModel.getComposerSpenDocModel().setStrokeRecognitionData(CollectResolver.createStrokeRecognitionData(CollectResolver.getSearchDataListFromDB(uuid), CollectResolver.getActionLinkDataListFromDB(uuid)), Collections.EMPTY_LIST, true);
    }
}
