package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScan;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServerManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback;
import com.samsung.android.support.senl.p148nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.C9123b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.ComposerSaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.mde.OptionMenuLeaveCoeditPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.mde.OptionMenuStartCoeditPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationLanguageModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.SolveMathPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDeleteMdeNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakeDataToHashTag;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.translation.TaskAddToNoteWithPDFTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuPresenter {
    private static final String TAG = Logger.createTag("OptionMenuPresenter");
    private static final String VEX_SCANNER_PACKAGE_NAME = "com.samsung.android.app.vex.scanner";
    private ActionManager mActionManager;
    protected Activity mActivity;
    protected AiMenuManager mAiMenuManager;
    private final ComponentFactory mComponentFactory;
    protected ComposerModel mComposerModel;
    protected ComposerViewPresenter mComposerViewPresenter;
    protected ControllerManager mControllerManager;
    private DialogPresenterManager mDialogPresenterManager;
    private VexDocumentScan mDocumentScan;
    private DynamicTemplateLoader mDynamicTemplateLoader;
    private Fragment mFragment;
    private HwToolbarPresenter mHwToolbarPresenter;
    private KeyguardPresenter mKeyguardPresenter;
    private MdeInfoObserverImpl mMdeInfoObserver;
    protected MenuPresenterContract.IMenuManager mMenuManager;
    private OptionMenuContract.IOptionMenu mOptionMenu;
    private OptionMenuAddPresenter mOptionMenuAddPresenter;
    private OptionMenuBackPresenter mOptionMenuBackPresenter;
    private OptionMenuChangeNoteStyle mOptionMenuChangeNoteStyle;
    private IOptionMenuFingerDrawingPresenter mOptionMenuFingerDrawingPresenter;
    private OptionMenuLeaveCoeditPresenter mOptionMenuLeaveCoeditPresenter;
    private OptionMenuLock mOptionMenuLock;
    private OptionMenuNotesAssistPresenter mOptionMenuNotesAssistPresenter;
    private OptionMenuPageSettingPresenter mOptionMenuPageSettingPresenter;
    private OptionMenuPinToHome mOptionMenuPinToHome;
    private OptionMenuReminder mOptionMenuReminder;
    protected OptionMenuSharePresenter mOptionMenuSharePresenter;
    private OptionMenuStartCoeditPresenter mOptionMenuStartCoeditPresenter;
    private OptionMenuTextOnlyMode mOptionMenuTextOnlyMode;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C98231 implements ExecuteCallback {
        final /* synthetic */ int val$successMessage;

        public C98231(int i) {
            this.val$successMessage = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFail$1() {
            ToastHandler.show(OptionMenuPresenter.this.mActivity, C9086R.string.composer_save_to_device_fail, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(int i) {
            ToastHandler.showContinuous(OptionMenuPresenter.this.mActivity, i, 0);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback
        public void onFail() {
            OptionMenuPresenter.this.mComposerViewPresenter.getHandler().post(new RunnableC9845d(this, 0));
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback
        public void onSuccess() {
            OptionMenuPresenter.this.mComposerViewPresenter.getHandler().post(new RunnableC9846e(this, this.val$successMessage, 0));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C98264 implements Task.Callback<TaskAddToNoteWithPDFTranslation.ResultValues> {
        final /* synthetic */ Runnable val$postRunnable;

        public C98264(Runnable runnable) {
            this.val$postRunnable = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openNoteAfterAddToNoteWithTranslation$0() {
            MenuPresenterContract.IMenuManager iMenuManager = OptionMenuPresenter.this.mMenuManager;
            if (iMenuManager != null) {
                iMenuManager.finish("openNoteAfterAddToNoteWithTranslation");
            }
        }

        private void openNoteAfterAddToNoteWithTranslation(String str) {
            Logger.m10999d(OptionMenuPresenter.TAG, "openNoteAfterAddToNoteWithTranslation, uuid: " + str);
            OptionMenuPresenter.this.mActivity.startActivity(new IntentUtil.ComposerIntentBuilder(new Intent()).setDocUuid(str).setComposerComponent(OptionMenuPresenter.this.mActivity).setAction(ComposerConstants.ACTION_OPEN_MEMO).removeFlags(16777216).putExtra(ComposerConstants.ARG_GUIDE_TRANSLATED_PDF_NEED_TO_SHOW, true).build());
            OptionMenuPresenter.this.mComposerViewPresenter.getHandler().post(new RunnableC9845d(this, 1));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onError(TaskAddToNoteWithPDFTranslation.ResultValues resultValues) {
            if (resultValues.getErrorType() == 2 || CommonUtil.isNotAvailableActivity(OptionMenuPresenter.this.mActivity)) {
                return;
            }
            if (resultValues.getErrorType() == 3) {
                OptionMenuPresenter.this.mComposerViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(3);
            } else {
                ToastHandler.show(OptionMenuPresenter.this.mActivity, C9086R.string.composer_failed_to_copy, 0);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onSuccess(TaskAddToNoteWithPDFTranslation.ResultValues resultValues) {
            Runnable runnable = this.val$postRunnable;
            if (runnable != null) {
                runnable.run();
            }
            openNoteAfterAddToNoteWithTranslation(resultValues.getUuid());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends OptionMenuAddPresenter.ComponentFactory {
        @NonNull
        OptionMenuBackPresenter createOptionMenuBackPresenter(@NonNull ControllerManager controllerManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull MenuPresenterContract.IMenuManager iMenuManager);

        @NonNull
        OptionMenuSharePresenter createSharePresenter(@NonNull ControllerManager controllerManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull DialogPresenterManager dialogPresenterManager);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MdeInfoObserverImpl extends MdeInfo.ObserverAdapter {
        public /* synthetic */ MdeInfoObserverImpl(OptionMenuPresenter optionMenuPresenter, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.ObserverAdapter, com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
        public void onCoeditMemberListChanged(List<CoeditResolverContract.MemberInfo> list) {
            if (!OptionMenuPresenter.this.mComposerModel.getMdeManager().getMdeInfo().isBanished(list)) {
                if (OptionMenuPresenter.this.mOptionMenuLeaveCoeditPresenter.isNeededToUpdate(list)) {
                    OptionMenuPresenter.this.invalidateOptionsMenu();
                }
            } else {
                OptionMenuPresenter.this.mComposerModel.setUpToFinishWithoutSave();
                if (OptionMenuPresenter.this.mControllerManager.getExecuteOtherActivityController().finishBrush(false, null)) {
                    return;
                }
                OptionMenuPresenter.this.mMenuManager.finish("onCoeditMemberListChanged# banished");
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.ObserverAdapter, com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
        public void onLeaderChanged() {
            OptionMenuPresenter.this.invalidateOptionsMenu();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.ObserverAdapter, com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
        public void onPermissionChanged(MdeInfo mdeInfo) {
            ModeManager modeManager = OptionMenuPresenter.this.mComposerModel.getModeManager();
            if (modeManager.isMode(Mode.Init)) {
                return;
            }
            if (!modeManager.isEditModeWithReadOnly()) {
                OptionMenuPresenter.this.invalidateOptionsMenu();
            } else {
                if (mdeInfo.hasWritePermission()) {
                    return;
                }
                OptionMenuPresenter.this.mOptionMenuBackPresenter.goBackComposer(OptionMenuPresenter.this.mActivity, OptionMenuBackPresenter.Caller.BACK_KEY);
            }
        }

        private MdeInfoObserverImpl() {
        }
    }

    public OptionMenuPresenter(@NonNull ComponentFactory componentFactory) {
        this.mComponentFactory = componentFactory;
    }

    private boolean canStartCoeditShareWithCollaborators() {
        if (this.mComposerModel.getComposerSpenDocModel().hasStickyMemo()) {
            ToastHandler.show(this.mActivity, C9086R.string.sticky_memo_cant_share_notes, 0);
            return false;
        }
        if (this.mComposerModel.getComposerSpenDocModel().hasTableObject()) {
            ToastHandler.show(this.mActivity, C9086R.string.table_cant_share_notes, 0);
            return false;
        }
        if (this.mComposerModel.getComposerSpenDocModel().hasCodeBlockObject()) {
            ToastHandler.show(this.mActivity, C9086R.string.codeblock_cant_share_notes, 0);
            return false;
        }
        if (this.mComposerModel.getComposerSpenDocModel().hasTextFormat()) {
            ToastHandler.show(this.mActivity, C9086R.string.text_format_cant_share_notes, 0);
            return false;
        }
        if (!this.mComposerModel.getDocState().getCoverDataSource().isEnabled()) {
            return true;
        }
        ToastHandler.show(this.mActivity, C9086R.string.composer_failed_to_copy, 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithoutSave(@NonNull String str) {
        this.mComposerModel.setUpToFinishWithoutSave();
        this.mMenuManager.finish(str);
    }

    private String getEventSaveScreenOnMemoDetail() {
        try {
            SpenWNote doc = this.mComposerModel.getDoc();
            boolean z = doc.hasObject(2) || !TextUtils.isEmpty(doc.getBodyText().getText());
            boolean zHasObject = doc.hasObject(1);
            return (z && zHasObject) ? "3" : z ? "1" : zHasObject ? "2" : "4";
        } catch (Exception e) {
            Logger.m10999d(TAG, "getEventSaveScreenOnMemoDetail e : " + e.getMessage());
            return "4";
        }
    }

    private OptionMenuChangeNoteStyle getOptionMenuChangeTemplate() {
        if (this.mOptionMenuChangeNoteStyle == null) {
            this.mOptionMenuChangeNoteStyle = new OptionMenuChangeNoteStyle(this.mComposerViewPresenter, this.mComposerModel, this.mOptionMenuAddPresenter, this.mControllerManager.getTaskController(), this.mDynamicTemplateLoader);
        }
        return this.mOptionMenuChangeNoteStyle;
    }

    private void initScan(Context context) {
        if (this.mComponentFactory.getConfig().isDocumentScanEnabled() && FeatureInfo.isVexScanSupported(context) && SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500) {
            if (this.mDocumentScan != null || this.mOptionMenuAddPresenter == null) {
                this.mDocumentScan = VexDocumentScan.create(context);
                return;
            }
            VexDocumentScan vexDocumentScanCreate = VexDocumentScan.create(context);
            this.mDocumentScan = vexDocumentScanCreate;
            this.mOptionMenuAddPresenter.setDocumentScan(vexDocumentScanCreate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClickDone$0() {
        String eventSaveScreenOnMemoDetail = getEventSaveScreenOnMemoDetail();
        if (!"4".equals(eventSaveScreenOnMemoDetail)) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_LOCK_SCREEN_ON_MEMO, ComposerSAConstants.EVENT_SAVE_SCREEN_ON_MEMO, eventSaveScreenOnMemoDetail);
        }
        ToastHandler.show(this.mActivity, C9086R.string.composer_note_saved, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveAndExecute$1(Runnable runnable) {
        this.mComposerModel.saveAndExecute(runnable);
    }

    private void talkbackForPageList() {
        if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mActivity)) {
            String strM12i = AbstractC0000a.m12i(this.mActivity.getResources(), C9086R.string.composer_sort_pages, AbstractC0541b.m781w(isClickedPageList() ? this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) : this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected), SQLKeyword.COMMA));
            View viewFindViewById = this.mActivity.findViewById(C9086R.id.action_tablet_sort_pages);
            if (viewFindViewById != null) {
                viewFindViewById.announceForAccessibility(strM12i);
            }
        }
    }

    public void attachBottomView() {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.attachBottomMenu();
        }
    }

    public boolean canDelete() {
        if (this.mComposerModel == null) {
            return false;
        }
        if (!isCoeditNote() && this.mComposerModel.isEmpty()) {
            return this.mComposerModel.isExistInDB(this.mActivity) && this.mComposerModel.getDocInfo().getOpenType() != DocInfo.OpenType.New;
        }
        return true;
    }

    public void clearSelection() {
        this.mComposerViewPresenter.setContextMenu(false);
        if (this.mComposerViewPresenter.getObjectManager().isFocusedTextBox()) {
            this.mComposerViewPresenter.getTextManager().clearSelection();
        } else if (this.mComposerModel.getModeManager().isEditMode()) {
            this.mComposerViewPresenter.getObjectManager().clearSelectObject(false);
        }
    }

    public void clearSelectionForEachMode() {
        this.mComposerViewPresenter.setContextMenu(false);
        if (this.mComposerModel.getModeManager().isMode(Mode.View)) {
            this.mComposerViewPresenter.getObjectManager().clearSelectObject(true);
        } else if (this.mComposerModel.getModeManager().isEditMode()) {
            this.mComposerViewPresenter.getObjectManager().clearSelectObject(false);
        }
    }

    public void completeComposing() {
        if (this.mComposerViewPresenter.getObjectManager().isFocusedTextBox() || this.mComposerModel.getModeManager().isMode(Mode.Text)) {
            return;
        }
        this.mComposerViewPresenter.clearWritingToolControl();
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
    }

    public AppWidgetThumbnailTask getAppWidgetThumbnailTask() {
        OptionMenuBackPresenter optionMenuBackPresenter = this.mOptionMenuBackPresenter;
        if (optionMenuBackPresenter == null) {
            return null;
        }
        return optionMenuBackPresenter.getAppWidgetThumbnailTask();
    }

    public int getBackgroundColor() {
        return this.mComposerViewPresenter.getBackgroundColor();
    }

    @NonNull
    public ComponentFactory getComponentFactory() {
        return this.mComponentFactory;
    }

    public ComposerViewPresenter getComposerViewPresenter() {
        return this.mComposerViewPresenter;
    }

    public DynamicTemplateLoader getDynamicTemplateLoader() {
        return this.mDynamicTemplateLoader;
    }

    @Nullable
    public KeyguardPresenter getKeyguardPresenter() {
        return this.mKeyguardPresenter;
    }

    public Pair<Integer, Integer> getLaserPenData() {
        return this.mMenuManager.getLaserPenData();
    }

    public OptionMenuAddPresenter getOptionMenuAddPresenter() {
        return this.mOptionMenuAddPresenter;
    }

    public IOptionMenuFingerDrawingPresenter getOptionMenuFingerDrawingPresenter() {
        return this.mOptionMenuFingerDrawingPresenter;
    }

    public OptionMenuNotesAssistPresenter getOptionMenuNotesAssistPresenter() {
        return this.mOptionMenuNotesAssistPresenter;
    }

    public OptionMenuPageSettingPresenter getOptionMenuPageSettingPresenter() {
        if (this.mOptionMenuPageSettingPresenter == null) {
            this.mOptionMenuPageSettingPresenter = new OptionMenuPageSettingPresenter(this.mComposerViewPresenter, this.mComposerModel, this.mControllerManager);
        }
        return this.mOptionMenuPageSettingPresenter;
    }

    public OptionMenuSharePresenter getOptionMenuSharePresenter() {
        return this.mOptionMenuSharePresenter;
    }

    public SolveMathPresenter getSolveMathPresenter() {
        return this.mAiMenuManager.getSolveMathPresenter();
    }

    public int getTwoPageLeftIndex() {
        return getOptionMenuChangeTemplate().getTwoPageLeftIndex();
    }

    public int getTwoPageRightIndex() {
        return getOptionMenuChangeTemplate().getTwoPageRightIndex();
    }

    public boolean hasDeletePermission() {
        return !this.mComposerModel.getMdeInfo().isMde() || this.mComposerModel.getMdeInfo().isCreator() || this.mComposerModel.getMdeInfo().isLeader();
    }

    public boolean hasHashTag() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null || composerModel.getDocState() == null) {
            return false;
        }
        return !this.mControllerManager.getHashTagController().getTagList().isEmpty();
    }

    public boolean hasWritePermission() {
        return this.mComposerModel.getMdeInfo().hasWritePermission();
    }

    public void hideAiContextMenu() {
        AiMenuManager aiMenuManager = this.mAiMenuManager;
        if (aiMenuManager != null) {
            aiMenuManager.hideContextMenu(true);
        }
    }

    public void hideBottomMenu() {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.hideBottomMenu();
        }
    }

    public void hideInAppDeviceListDialog() {
        this.mDialogPresenterManager.hideInAppDeviceListDialog();
    }

    public void hideOptionMenu() {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.hideOptionMenu();
        }
    }

    public void init(MenuPresenterContract.IMenuManager iMenuManager, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, ComposerModel composerModel, DialogPresenterManager dialogPresenterManager, VoiceRecordMenuPresenter voiceRecordMenuPresenter, ActionManager actionManager, AiMenuManager aiMenuManager, HwToolbarPresenter hwToolbarPresenter, StickyMemoManager stickyMemoManager, @NonNull KeyguardPresenter keyguardPresenter, DynamicTemplateLoader dynamicTemplateLoader) {
        this.mMenuManager = iMenuManager;
        this.mComposerModel = composerModel;
        this.mControllerManager = controllerManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mDialogPresenterManager = dialogPresenterManager;
        this.mActionManager = actionManager;
        this.mOptionMenuReminder = new OptionMenuReminder();
        this.mOptionMenuPinToHome = new OptionMenuPinToHome();
        this.mOptionMenuLock = new OptionMenuLock(iMenuManager, this.mComposerModel, this.mControllerManager.getTaskController());
        this.mOptionMenuNotesAssistPresenter = new OptionMenuNotesAssistPresenter(composerViewPresenter, iMenuManager, aiMenuManager);
        this.mOptionMenuAddPresenter = new OptionMenuAddPresenter(iMenuManager, composerViewPresenter, controllerManager, composerModel, voiceRecordMenuPresenter, this.mDocumentScan, stickyMemoManager, dialogPresenterManager, this.mComponentFactory);
        this.mOptionMenuSharePresenter = this.mComponentFactory.createSharePresenter(controllerManager, composerViewPresenter, composerModel, this.mDialogPresenterManager);
        if (ComposerSpenUtils.isSpenSupportChangeable()) {
            this.mOptionMenuFingerDrawingPresenter = new OptionMenuFingerDrawingSpenChangeablePresenter(composerViewPresenter, composerModel);
        } else {
            this.mOptionMenuFingerDrawingPresenter = new OptionMenuFingerDrawingPresenter(composerViewPresenter, composerModel);
        }
        this.mOptionMenuBackPresenter = this.mComponentFactory.createOptionMenuBackPresenter(controllerManager, composerViewPresenter, composerModel, this.mDialogPresenterManager, iMenuManager);
        this.mOptionMenuStartCoeditPresenter = new OptionMenuStartCoeditPresenter(iMenuManager, controllerManager, composerViewPresenter, composerModel, dialogPresenterManager);
        this.mOptionMenuLeaveCoeditPresenter = new OptionMenuLeaveCoeditPresenter(iMenuManager, composerModel);
        if (this.mMdeInfoObserver == null) {
            this.mMdeInfoObserver = new MdeInfoObserverImpl(this, 0);
        }
        this.mComposerModel.getMdeInfo().addObserver(this.mMdeInfoObserver);
        this.mOptionMenuTextOnlyMode = new OptionMenuTextOnlyMode(composerModel, composerViewPresenter);
        this.mAiMenuManager = aiMenuManager;
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mKeyguardPresenter = keyguardPresenter;
        this.mDynamicTemplateLoader = dynamicTemplateLoader;
        if (isPDFReader()) {
            AiLanguageHelper.initTranslateConfig();
            SCSOperator.initTranslator();
        }
        onPostInitialized();
    }

    public void insertSALogClickPageListBtn(boolean z, boolean z2) {
        if (isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EVENT_PAGE_SORTER);
            return;
        }
        if (isCoeditNote()) {
            if (z2) {
                ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_SORT_PAGES);
                return;
            } else {
                ComposerSA.insertLog("682", ComposerSAConstants.EVENT_VIEW_SORT_PAGES);
                return;
            }
        }
        if (this.mComposerModel.isPDFReader()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_SORT_PAGES);
            return;
        }
        if (z) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_TABLET_PAGE);
        } else if (z2) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_SORT_PAGES);
        } else {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_SORT_PAGES);
        }
    }

    public void invalidateOptionsMenu() {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.invalidateOptionsMenu();
        } else {
            Logger.m11003i(TAG, "invalidateOptionsMenu# ");
        }
    }

    public boolean isAiDrawingActivated() {
        AiMenuManager aiMenuManager = this.mAiMenuManager;
        if (aiMenuManager != null) {
            return aiMenuManager.getAiContextMenuPresenter().isAiDrawingActivated();
        }
        return false;
    }

    public boolean isAutoSaveOptionEnabled() {
        return this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled();
    }

    public boolean isAvailableReminder(Activity activity) {
        OptionMenuReminder optionMenuReminder;
        return (this.mComposerModel.getCoeditAdapter().isCoeditNote() || (optionMenuReminder = this.mOptionMenuReminder) == null || !optionMenuReminder.isReminderPackageExistAndUsable(activity)) ? false : true;
    }

    public boolean isClickedPageList() {
        return this.mMenuManager.isClickedPageList();
    }

    public boolean isCoeditNote() {
        return this.mComposerModel.getCoeditAdapter().isCoeditNote();
    }

    public boolean isDeleteOnly() {
        return this.mComposerModel.getModeManager().isDeleteOnlyMode();
    }

    public boolean isEditMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getModeManager().isEditModeWithReadOnly();
    }

    public boolean isEditable() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.isEditable();
    }

    public boolean isEmptyOnNewNote() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return true;
        }
        return composerModel.isEmptyOnNewNote();
    }

    public boolean isEnableTextOnlyMode() {
        return this.mComposerModel.getTextOnlyModeState().isEnableTextOnlyMode();
    }

    public boolean isEnabledToStartCoedit() {
        if (!DeviceInfo.isVSTModel() && this.mComposerModel.getCoeditAdapter().isEnabled() && !this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            if (this.mComposerModel.getComposerSpenDocModel().getDoc() == null) {
                Logger.m11000e(TAG, "isEnabledToStartCoedit# doc is null");
                return false;
            }
            if (!this.mComposerModel.isSingleMode() && this.mComposerModel.getComposerSpenDocModel().getDoc().getOrientation() != SpenWNote.Orientation.LANDSCAPE_NEW && !this.mComposerModel.getComposerSpenDocModel().hasUnknownObject() && !ContinuityServerManager.getInstance().isPeerConnected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isFavorite() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getNotesDocEntityManager().isFavoriteNote();
    }

    public boolean isInAppCollaborationMode() {
        return this.mComposerModel.getComposerState().isInAppCollaborationMode();
    }

    public boolean isInitMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getModeManager().isMode(Mode.Init);
    }

    public boolean isInputFormMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getModeManager().isInputFormMode();
    }

    public boolean isLaserPenEnabled() {
        return this.mComposerModel.getComposerState().isLaserPenMode();
    }

    public boolean isLeader() {
        return this.mComposerModel.getMdeInfo().isLeader();
    }

    public boolean isLeaveEnabled() {
        return this.mOptionMenuLeaveCoeditPresenter.isLeaveEnabled();
    }

    public boolean isLockNote() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getNotesDocEntityManager().isLocked();
    }

    public boolean isLockVerified() {
        OptionMenuLock optionMenuLock = this.mOptionMenuLock;
        if (optionMenuLock != null) {
            return optionMenuLock.isLockVerified();
        }
        return false;
    }

    public boolean isMde() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getMdeInfo().isMde();
    }

    public boolean isMdeMode() {
        ComposerModel composerModel = this.mComposerModel;
        return composerModel != null && composerModel.getModeManager().isMode(Mode.View) && this.mComposerModel.getMdeInfo().isMde();
    }

    public boolean isNeedToShowBottomView() {
        return this.mComposerModel.getModeManager().isMode(Mode.ReadOnly) && !this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated();
    }

    public boolean isPDFReader() {
        return this.mComposerModel.isPDFReader();
    }

    public boolean isReadOnlyMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getModeManager().isMode(Mode.ReadOnly);
    }

    public boolean isRunningProgress() {
        return this.mControllerManager.getProgressController().isNotFinished();
    }

    public boolean isSameLanguageForTranslationOverlay() {
        TranslationLanguageModel translationLanguageModel = new TranslationLanguageModel();
        translationLanguageModel.updateFromLanguageTagFromRepository();
        translationLanguageModel.updateToLanguageTagFromRepository();
        Logger.m10999d(TAG, "isSameLanguageForTranslationOverlay# from : " + translationLanguageModel.getFromLanguageTag() + ", to : " + translationLanguageModel.getToLanguageTag());
        return translationLanguageModel.isSame();
    }

    public boolean isSecured() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getComposerState().isSecured();
    }

    public boolean isSettingPopupTouchOutside() {
        return this.mComposerViewPresenter.onTouchOutside();
    }

    public boolean isSimpleMode() {
        return this.mComposerModel.isSimpleMode();
    }

    public boolean isSingleMode() {
        return this.mComposerModel.isSingleMode();
    }

    public boolean isSpenOnlyMode() {
        return this.mComposerViewPresenter.getWritingToolManager().isSpenOnlyMode();
    }

    public boolean isStandAlone() {
        return this.mComposerModel.getMdeInfo().isStandAlone();
    }

    public boolean isStartWithTextOnly() {
        return this.mOptionMenuTextOnlyMode.isStartWithTextOnly();
    }

    public boolean isSupportedLockMenu() {
        return this.mOptionMenuLock.isSupportedLockMenu();
    }

    public boolean isSupportedPinToHome(Activity activity) {
        return !this.mComposerModel.getCoeditAdapter().isCoeditNote() && this.mOptionMenuPinToHome.isSupportedPinToHome(activity);
    }

    public boolean isSupportedViewMode() {
        return this.mComposerModel.isSupportedViewMode();
    }

    public boolean isToolbarShowing() {
        return this.mMenuManager.isToolbarShowing();
    }

    public boolean isTranslationOverlayActivated() {
        if (this.mAiMenuManager.getAiContextMenuPresenter() == null) {
            return false;
        }
        return this.mAiMenuManager.getAiContextMenuPresenter().isTranslationOverlayActivated();
    }

    public boolean isTwoPage() {
        return getOptionMenuChangeTemplate().isTwoPage();
    }

    public boolean isViewMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getModeManager().isMode(Mode.View);
    }

    public boolean needToRemoveInAppCollaborationMenu() {
        return this.mMenuManager.isRestrictedInAppCollaboration();
    }

    public boolean needToShowInAppCollaborationMenu() {
        return this.mMenuManager.isEnabledInAppCollaboration();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == ComposerRequestCode.ChangeNoteStyle.getId()) {
            getOptionMenuChangeTemplate().onActivityResult(i2, intent);
            getComposerViewPresenter().getAiMenuManager().getAiCoverMenuViewPresenter().onActivityResult(i, i2, intent);
            return true;
        }
        if (i == ComposerRequestCode.Export.getId()) {
            this.mOptionMenuSharePresenter.onActivityResultForExport(i2, intent);
            return true;
        }
        if (i == ComposerRequestCode.InAppCollaborationFTU.getId()) {
            if (i2 == -1) {
                onClickInAppCollaboration();
            }
            return true;
        }
        if (this.mOptionMenuStartCoeditPresenter.onActivityResult(i, i2, intent, this.mFragment)) {
            return true;
        }
        if (i == ComposerRequestCode.LeaveCoedit.getId()) {
            this.mOptionMenuLeaveCoeditPresenter.onActivityResult(i2);
            return true;
        }
        if (i2 == -1 || i != ComposerRequestCode.BrushDrawing.getId() || !this.mComposerModel.isRunningDrawing() || !this.mComposerModel.getMdeManager().getMdeInfo().isBanished(null)) {
            return this.mOptionMenuAddPresenter.onActivityResult(i, i2, intent);
        }
        this.mControllerManager.getExecuteOtherActivityController().releaseExecutedBrush();
        this.mMenuManager.finish("onActivityResult# banished after drawing");
        return true;
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
        this.mOptionMenuAddPresenter.onAttachView(activity, fragment);
        this.mOptionMenuSharePresenter.onAttachView(activity, fragment);
        this.mOptionMenuLock.onAttachView(activity, fragment);
        this.mOptionMenuFingerDrawingPresenter.onAttachView(activity);
    }

    public boolean onBackPressed() {
        OptionMenuBackPresenter optionMenuBackPresenter = this.mOptionMenuBackPresenter;
        if (optionMenuBackPresenter == null) {
            return false;
        }
        return optionMenuBackPresenter.goBackComposer(this.mActivity, OptionMenuBackPresenter.Caller.BACK_KEY);
    }

    public void onClickCalculatedMode() {
        boolean zIsEnabled = this.mAiMenuManager.getSolveMathPresenter().isEnabled();
        if (!zIsEnabled && FeatureInfo.isHandwritingHelpEnabled(this.mActivity) && this.mHwToolbarPresenter.isAssistanceSelected()) {
            Activity activity = this.mActivity;
            ToastHandler.show(activity, activity.getResources().getString(C9086R.string.composer_turn_on_calculate_mode_guide), 1, true);
        }
        this.mAiMenuManager.getSolveMathPresenter().setEnabled(!zIsEnabled);
        this.mHwToolbarPresenter.setSolveMathEnabled(!zIsEnabled);
    }

    public void onClickChangeTemplate() {
        if (this.mControllerManager.getSoftInputManager().isInputMethodShown()) {
            this.mControllerManager.getSoftInputManager().hide(true);
        }
        this.mControllerManager.getClipboardController().closeClipboard();
        try {
            getOptionMenuChangeTemplate().startChangeTemplateActivity(this.mActivity);
        } catch (Exception e) {
            AbstractC8014b.m7207i("Exception : ", e, TAG);
        }
    }

    public void onClickCoeditAddToSharedNotebook() {
        if (canStartCoeditShareWithCollaborators()) {
            this.mOptionMenuStartCoeditPresenter.addToSharedNotebook(this.mActivity, this.mFragment);
        }
    }

    public void onClickCoeditInternalSnapRefresh() {
        this.mComposerModel.getCoeditAdapter().internalSnapRefresh();
    }

    public void onClickCoeditShareWithCollaborators() {
        if (canStartCoeditShareWithCollaborators()) {
            this.mOptionMenuStartCoeditPresenter.shareWithCollaborators(this.mActivity, this.mFragment);
        }
    }

    public void onClickConvertToNoteBtn() {
    }

    public void onClickDeleteBtn(boolean z) {
        if (ComposerManager.getInstance().isOpen(this.mComposerModel.getDocState().getUuid(), this.mFragment)) {
            Logger.m10999d(TAG, "onClickDeleteBtn# " + this.mActivity.hashCode());
            ToastHandler.show(this.mActivity, C9086R.string.unable_to_delete_file_in_use, 0);
            return;
        }
        Logger.m11002f(TAG, "onClickDeleteBtn# " + z);
        if (this.mComposerModel.getMdeInfo().isMde()) {
            this.mControllerManager.getTaskController().execute(new TaskDeleteMdeNote(), new TaskDeleteMdeNote.InputValues(this.mActivity, this.mComposerModel), new Task.Callback<TaskDeleteMdeNote.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskDeleteMdeNote.ResultValues resultValues) {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskDeleteMdeNote.ResultValues resultValues) {
                    OptionMenuPresenter.this.finishWithoutSave("onClickDeleteBtn");
                }
            }, false);
            return;
        }
        if (z) {
            this.mComposerModel.getComposerSpenDocModel().clearCanvasCacheData();
            this.mComposerModel.getNotesDocEntityManager().updateDeleteState(this.mActivity, 2);
        } else {
            this.mComposerModel.getNotesDocEntityManager().updateDeleteState(this.mActivity, 1);
        }
        finishWithoutSave("onClickDeleteBtn");
    }

    public void onClickDone() {
        String str = TAG;
        Logger.addFileLog(str, "ClickDone-" + this.mComposerModel.isEditable(), 0);
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getObjectManager().clearSelectObject(true);
        if (this.mComposerModel.isEmptyOnNewNote()) {
            finishWithoutSave("onClickDone, a new empty note");
            return;
        }
        OptionMenuBackPresenter optionMenuBackPresenter = this.mOptionMenuBackPresenter;
        if (optionMenuBackPresenter == null) {
            Logger.m10999d(str, "onClickDone, presenter is null");
        } else if (optionMenuBackPresenter.goBackComposer(this.mActivity, OptionMenuBackPresenter.Caller.DONE_BUTTON)) {
            this.mComposerModel.getComposerSaveModel().setRunnableAfterCompletedSave(new RunnableC9845d(this, 3));
        }
    }

    public void onClickEditBtn(int i) {
        this.mActionManager.doAction(ActionManager.ActionType.EditMode, "onClickEditBtn", Boolean.valueOf(i != 2));
        ComposerSA.insertLog(isCoeditNote() ? "682" : "301", ComposerSAConstants.EVENT_VIEW_EDIT, i == 1 ? "1" : "2");
    }

    public void onClickFavoriteBtn() {
        setFavorite(!isFavorite());
    }

    public void onClickFingerDrawing() {
        this.mOptionMenuFingerDrawingPresenter.onClickFingerDrawing();
    }

    public void onClickHashTagBtn() {
        if (!FeatureInfo.isHashTagFeatureEnabled() || isMdeMode()) {
            Logger.m11000e(TAG, "onClickHashTagBtn# the tag feature is not enabled");
            return;
        }
        clearSelection();
        this.mControllerManager.getClipboardController().closeClipboard();
        this.mControllerManager.getSoftInputManager().hide(true);
        this.mControllerManager.getSoftInputManager().setClearSkip(true);
        if (this.mControllerManager.getHashTagController().isNeedToExecuteAsyncForRecognition()) {
            this.mControllerManager.getTaskController().execute(new TaskMakeDataToHashTag(), new TaskMakeDataToHashTag.InputValues(this.mActivity, this.mComposerModel), new Task.Callback<TaskMakeDataToHashTag.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskMakeDataToHashTag.ResultValues resultValues) {
                    Logger.m11004w(OptionMenuPresenter.TAG, "TaskMakeDataToHashTag#onError# ");
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskMakeDataToHashTag.ResultValues resultValues) {
                    Logger.m10999d(OptionMenuPresenter.TAG, "TaskMakeDataToHashTag#onSuccess# ");
                    ControllerManager controllerManager = OptionMenuPresenter.this.mControllerManager;
                    if (controllerManager != null) {
                        controllerManager.getHashTagController().executeHashTagEditor(resultValues.getStringBufferTextRecognition().toString());
                    }
                }
            }, false);
        } else {
            this.mControllerManager.getHashTagController().executeHashTagEditor(null);
        }
        ComposerSA.insertLog(this.mComposerModel.getModeManager().isEditMode() ? "401" : "301", hasHashTag() ? ComposerSAConstants.EVENT_VIEW_EDIT_TAG : ComposerSAConstants.EVENT_VIEW_ADD_TAG);
    }

    public void onClickInAppCollaboration() {
        if (!FTUConstants.isInAppFTUNeeds()) {
            this.mDialogPresenterManager.showInAppDeviceListDialog(ContinuityServerManager.getInstance().getNearbyMyDevices());
        } else {
            InAppLogger.m8595d(TAG, "onClickInAppCollaboration# show FTU");
            this.mActivity.startActivityForResult(new Intent(this.mActivity, (Class<?>) InAppCollaborationFTUActivity.class), ComposerRequestCode.InAppCollaborationFTU.getId());
        }
    }

    public boolean onClickInputFormBtn() {
        return this.mActionManager.doAction(ActionManager.ActionType.InputForm, "onClickInputFormBtn");
    }

    public void onClickLaserPen() {
        this.mMenuManager.onEvent(13);
        this.mMenuManager.invalidateOptionsMenu();
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mComposerModel.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_LASER_PEN_IN_APPBAR, isLaserPenEnabled() ? "1" : "0");
    }

    public void onClickLeave() {
        this.mOptionMenuLeaveCoeditPresenter.leaveNote(this.mActivity);
    }

    public void onClickLockUnlock() {
        this.mOptionMenuLock.onClickLockUnlock(this.mMenuManager);
    }

    public void onClickNaviUpBtn() {
        OptionMenuBackPresenter optionMenuBackPresenter = this.mOptionMenuBackPresenter;
        if (optionMenuBackPresenter == null) {
            return;
        }
        optionMenuBackPresenter.goBackComposer(this.mActivity, OptionMenuBackPresenter.Caller.NAVI_UP_BUTTON);
    }

    public void onClickNoteInformation() {
        this.mActionManager.doAction(ActionManager.ActionType.Information);
    }

    public void onClickPageListBtn() {
        this.mActionManager.doAction(ActionManager.ActionType.PageList, "onClickPageListBtn");
        talkbackForPageList();
    }

    public void onClickPageSetting() {
        clearSelection();
    }

    public void onClickPinToHome() {
        clearSelectionForEachMode();
        this.mOptionMenuPinToHome.onClickPinToHome(this.mActivity, this.mMenuManager, this.mDialogPresenterManager, this.mComposerModel, this.mOptionMenuLock);
    }

    public void onClickPrintBtn() {
        this.mActionManager.doAction(ActionManager.ActionType.Print);
    }

    public void onClickReadModeBtn() {
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, ResourceUtils.isTabletLayout(this.mActivity)), ComposerSAConstants.EVENT_EDIT_READING_MODE, this.mComposerModel.getModeManager().isMode(Mode.ReadOnly) ? "0" : "1");
        this.mActionManager.doAction(ActionManager.ActionType.ReadOnlyMode, "onClickReadModeBtn");
        talkbackSelectedButton(isReadOnlyMode(), C9086R.string.composer_reading_mode);
        if (this.mComposerModel.isPDFReader()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT, ComposerSAConstants.EVENT_PDF_VIEWER_EDIT_READING_MODE);
        }
    }

    public void onClickSave() {
        Logger.addFileLog(TAG, "ClickSave-" + this.mComposerModel.isEditable(), 0);
        this.mComposerModel.getVoiceModel().stopRecording();
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getObjectManager().clearSelectObject(true);
        this.mMenuManager.hideStickyMemo("8");
        if (this.mComposerModel.isEmptyOnNewNote()) {
            finishWithoutSave("onClickSave, a new empty note");
            return;
        }
        if (this.mComposerModel.isSupportedViewMode()) {
            this.mComposerModel.getModeManager().setMode(Mode.View, "onClickSave", true);
        }
        if (!this.mComposerModel.isChangedDocStateWithSnapSavedData()) {
            if (this.mComposerModel.isSupportedViewMode()) {
                return;
            }
            ToastHandler.show(this.mActivity, C9086R.string.composer_nothing_to_save, 0);
        } else {
            boolean zSave = this.mComposerModel.save(true, true);
            if (!this.mComposerModel.isSupportedViewMode() && zSave) {
                ToastHandler.show(this.mActivity, C9086R.string.composer_note_saved, 0);
            }
            this.mComposerModel.updateActionLinkData();
        }
    }

    public void onClickSaveToDeviceBtn(@StringRes int i) {
        if (!AbstractC2322a.m1607A(this.mComposerModel.getDocState().getPath())) {
            Logger.m11000e(TAG, "onClickSaveToDeviceBtn# not found file : ");
            ToastHandler.show(this.mActivity, C9086R.string.composer_save_to_device_fail, 0);
        } else {
            if (StorageUtils.getAvailableInternalMemorySize() < 10485760) {
                ToastHandler.show(this.mActivity, DeviceUtils.isTabletModel() ? C9086R.string.clear_some_space_for_tablet : C9086R.string.clear_some_space_for_phone, 0);
                return;
            }
            Logger.m11002f(TAG, "onClickSaveToDeviceBtn");
            this.mComposerModel.saveCache(true);
            this.mComposerModel.getComposerSaveModel().saveToDevice(new C98231(i), null);
        }
    }

    public void onClickSearchBtn() {
        if (isTranslationOverlayActivated()) {
            this.mComposerViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return;
        }
        clearSelectionForEachMode();
        this.mComposerViewPresenter.getComposerModel().saveCacheAndRequestCollect();
        this.mComposerModel.getModeManager().setMode(Mode.Search, "onClickSearchBtn", true);
    }

    public void onClickSendToReminder() {
        clearSelectionForEachMode();
        this.mOptionMenuReminder.sendReminderIntent(this.mActivity, this.mComposerViewPresenter.getDoc(), this.mComposerModel.getDocState().getUuid(), this.mComposerModel.getMdeInfo(), this.mComposerModel.getNotesDocEntityManager().isLocked());
    }

    public void onClickTextOnlyModeBtn() {
        this.mOptionMenuTextOnlyMode.toggleForTextOnlyMode(this.mActivity);
    }

    public void onDetachView() {
        this.mActivity = null;
        this.mFragment = null;
        OptionMenuAddPresenter optionMenuAddPresenter = this.mOptionMenuAddPresenter;
        if (optionMenuAddPresenter != null) {
            optionMenuAddPresenter.onDetachView();
        }
        OptionMenuSharePresenter optionMenuSharePresenter = this.mOptionMenuSharePresenter;
        if (optionMenuSharePresenter != null) {
            optionMenuSharePresenter.onDetachView();
        }
        OptionMenuLock optionMenuLock = this.mOptionMenuLock;
        if (optionMenuLock != null) {
            optionMenuLock.onDetachView();
        }
        IOptionMenuFingerDrawingPresenter iOptionMenuFingerDrawingPresenter = this.mOptionMenuFingerDrawingPresenter;
        if (iOptionMenuFingerDrawingPresenter != null) {
            iOptionMenuFingerDrawingPresenter.onDetachView();
        }
        VexDocumentScan vexDocumentScan = this.mDocumentScan;
        if (vexDocumentScan != null) {
            vexDocumentScan.release();
            this.mDocumentScan = null;
        }
    }

    public void onFullScreenModeOn() {
        this.mActionManager.doAction(ActionManager.ActionType.FullScreen, TAG);
    }

    public boolean onLockActivityResult(int i, int i2, Intent intent) {
        OptionMenuLock optionMenuLock = this.mOptionMenuLock;
        if (optionMenuLock == null || !optionMenuLock.onActivityResult(this.mActivity, i, i2, intent)) {
            return false;
        }
        AbstractC0000a.m3D(i, "mOptionMenuLock#onActivityResult ", TAG);
        return true;
    }

    public void onOptionsItemSelected(OptionMenuParam optionMenuParam, int i) {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.onOptionsItemSelected(optionMenuParam, i);
        }
    }

    public void onPostInitialized() {
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mOptionMenuAddPresenter.onRequestPermissionsResult(i) || this.mOptionMenuLock.onRequestPermissionsResult(i, strArr, iArr) || this.mOptionMenuStartCoeditPresenter.onRequestPermissionsResult(this.mActivity, i) || this.mOptionMenuSharePresenter.onRequestPermissionsResult(i)) {
            return true;
        }
        if (i != 202) {
            return false;
        }
        this.mActivity.getIntent().putExtra(CoHandoffConstant.ARG_HANDOFF_WAITING, false);
        return true;
    }

    public void onStart(Activity activity) {
        initScan(activity);
    }

    public void onToggleToolbarVisibility() {
        Logger.m10999d(TAG, "onToggleToolbarVisibility# " + this.mMenuManager.isToolbarShowing());
        this.mMenuManager.onEvent(6);
    }

    public void onTranslationStateUpdated(int i) {
        AbstractC0000a.m3D(i, "onTranslationStateUpdated : ", TAG);
        if (this.mComposerModel.getModeManager().isMode(Mode.Search) && i != 0) {
            this.mComposerModel.getModeManager().setMode(this.mComposerModel.getModeManager().getPrevMode(), "translationState", true);
        }
        this.mMenuManager.invalidateOptionsMenu();
    }

    public void releaseAiDrawingPopup(String str) {
        this.mAiMenuManager.releaseAiDrawingPopup(str);
    }

    public boolean replaceInAppMenuToProgress(boolean z) {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu == null) {
            return false;
        }
        return iOptionMenu.replaceInAppOptionMenu(z);
    }

    public void resetLockVerified() {
        OptionMenuLock optionMenuLock = this.mOptionMenuLock;
        if (optionMenuLock != null) {
            optionMenuLock.resetLockVerified();
        }
    }

    public void saveAndExecute(Runnable runnable, int i) {
        if (this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled()) {
            if (this.mComposerModel.saveCache(false)) {
                ComposerSaveModel composerSaveModel = this.mComposerModel.getComposerSaveModel();
                Objects.requireNonNull(runnable);
                composerSaveModel.addSaveListener(new C9123b(runnable));
                return;
            }
        } else if (this.mComposerModel.isChangedDocStateWithSnapSavedData()) {
            this.mDialogPresenterManager.showSaveNoteConfirmDialogToNextAction(new RunnableC9844c(this, runnable, 0), i);
            return;
        }
        runnable.run();
    }

    public void saveAsNewNoteWithTranslation(@Nullable Runnable runnable) {
        int pageCountExcludedDummy = this.mComposerViewPresenter.getPageManager().getPageCountExcludedDummy();
        if (pageCountExcludedDummy > 500) {
            AbstractC8014b.m7217s(pageCountExcludedDummy, "onClickConvertToNoteBtn# too many pages : ", TAG);
            Activity activity = this.mActivity;
            ToastHandler.show(activity, activity.getResources().getQuantityString(C9086R.plurals.composer_failed_to_add_translated_pdfs, 500, 500), 0);
            return;
        }
        C98264 c98264 = new C98264(runnable);
        String text = this.mComposerModel.getDoc().getTitle().getText();
        if (TextUtils.isEmpty(text)) {
            text = "pdf_" + System.currentTimeMillis();
        }
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        this.mControllerManager.getTaskController().execute(new TaskAddToNoteWithPDFTranslation(), new TaskAddToNoteWithPDFTranslation.InputValues(composerViewPresenter, composerViewPresenter.getComposerModel(), text), c98264, false);
    }

    public void setCanUseTextOnlyMode(boolean z) {
        this.mOptionMenuTextOnlyMode.setCanUseTextOnlyMode(this.mActivity, z, (this.mMenuManager.isPageListShowing() || this.mComposerModel.getModeManager().isMode(Mode.Writing)) ? false : true);
    }

    public void setDisableTextOnlyModeToHandwriting() {
        this.mOptionMenuTextOnlyMode.setDisableTextOnlyModeToHandwriting(this.mActivity);
    }

    public void setFavorite(boolean z) {
        this.mComposerModel.getNotesDocEntityManager().setNoteFavorite(z);
    }

    public void setMenuDirty() {
        this.mComposerModel.setMenuDirty("OptionMenu");
    }

    public void setOptionMenu(OptionMenuContract.IOptionMenu iOptionMenu) {
        this.mOptionMenu = iOptionMenu;
    }

    public void showBottomMenu() {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.showBottomMenu();
        }
    }

    public void showGuideDialogForTextOnlyMode() {
        OptionMenuTextOnlyMode optionMenuTextOnlyMode = this.mOptionMenuTextOnlyMode;
        if (optionMenuTextOnlyMode != null) {
            optionMenuTextOnlyMode.showGuideDialogForTextOnlyMode(this.mActivity);
        }
    }

    public void showNoteStyle() {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.showNoteStyle();
        }
    }

    public void showOverlayTranslation() {
        this.mMenuManager.showOverlayTranslation();
    }

    public void showSaveAsPopup() {
        OptionMenuContract.IOptionMenu iOptionMenu = this.mOptionMenu;
        if (iOptionMenu != null) {
            iOptionMenu.showSaveAsPopup();
        }
    }

    public void showTitle() {
        this.mMenuManager.onEvent(14);
    }

    public void talkbackSelectedButton(boolean z, @StringRes int i) {
        if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mActivity)) {
            StringBuilder sbM781w = AbstractC0541b.m781w(z ? this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) : this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected), SQLKeyword.COMMA);
            sbM781w.append(this.mActivity.getResources().getString(i));
            VoiceAssistantTTS.getInstance().sendTalkBackMessage(sbM781w.toString());
        }
    }

    public void updateTemplateResult(Intent intent) {
        getOptionMenuChangeTemplate().updateTemplateResult(intent);
    }

    public boolean verifyScreenLock() {
        OptionMenuLock optionMenuLock = this.mOptionMenuLock;
        if (optionMenuLock != null) {
            return optionMenuLock.verifyScreenLock();
        }
        return false;
    }
}
