package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevicesModel;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.QuickNoteModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AiDrawingDeleteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SummaryOptionDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceDataDeleteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceDataRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.List;
import java.util.Map;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DialogPresenterManager implements DialogContract.IFragmentPresenterContainer, ComposerViewContract.IDialogManager {
    private static final String TAG = Logger.createTag("DialogPresenterManager");
    private Activity mActivity;
    private AiDrawingDeleteConfirmDialogPresenter mAiDrawingDeleteConfirmDialogPresenter;
    private AutoRestoredNoteNotiDialogPresenter mAutoRestoredNoteNotiDialogPresenter;
    private CanNotAddToNoteDialogPresenter mCanNotAddToNoteDialogPresenter;
    private CanNotUseSpenDialogPresenter mCanNotUseSpenDialogPresenter;
    private ComposerViewPresenter mCompViewPresenter;
    private final ComponentFactory mComponentFactory;
    private ComposerModel mComposerModel;
    private ConvertSettingDialogPresenter mConvertSettingDialogPresenter;
    private DialogContract.IDialogCreator mCreator;
    private DirectWriteSettingDialogPresenter mDirectWriteSettingDialogPresenter;
    private GoToSettingsDialogPresenter mGoToSettingsDialogPresenter;
    private HashTagRenameDialogPresenter mHashTagRenameDialogPresenter;
    private HwBeautifierLanguageDialogPresenter mHwBeautifierLanguageDialogPresenter;
    private InAppDialogPresenter mInAppDialogPresenter;
    private LinkEditDialogPresenter mLinkEditDialogPresenter;
    private ManualSaveConfirmDialogPresenter mManualSaveConfirmDialogPresenter;
    private PopupWindow mOpenLinkPopupWindow;
    private ProgressController mProgressController;
    private QuickNoteDialogPresenter mQuickNoteDialogPresenter;
    private final Runnable mResetHwToolbarRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogPresenterManager.1
        @Override // java.lang.Runnable
        public void run() {
            DialogPresenterManager.this.mCompViewPresenter.getHWToolbarPresenter().updateToolbarItemList();
        }
    };
    private SaveAsRenameDialogPresenter mSaveAsRenameDialogPresenter;
    protected SaveNoteConfirmDialogPresenter mSaveNoteConfirmDialogPresenter;
    private ShareSaveNoteConfirmDialogPresenter mShareSaveNoteConfirmDialogPresenter;
    private SoftInputManager mSoftInputManager;
    private SummaryOptionDialogPresenter mSummaryOptionDialogPresenter;
    private SyncConflictConfirmDialogPresenter mSyncConflictConfirmDialogPresenter;
    private SyncWaitingProgressDialogPresenter mSyncWaitingProgressDialogPresenter;
    private TableDialogPresenter mTableDialogPresenter;
    private TextBoxMoreDialogPresenter mTextBoxMoreDialogPresenter;
    private TranslatedPDFBlockingDialogPresenter mTranslatedPDFBlockingDialogPresenter;
    private TranslatedPDFGuideDialogPresenter mTranslatedPDFGuideDialogPresenter;
    private TurnOffTranslationDialogPresenter mTurnOffTranslationDialogPresenter;
    private UnavailableContentDialogPresenter mUnavailableContentDialogPresenter;
    private UnlockConfirmDialogPresenter mUnlockConfirmDialogPresenter;
    private VersionUpdateDialogPresenter mVersionUpdateDialogPresenter;
    private VoiceDataDeleteConfirmDialogPresenter mVoiceDataDeleteConfirmDialogPresenter;
    private VoiceDataRenameDialogPresenter mVoiceDataRenameDialogPresenter;
    private VoiceDialogPresenter mVoiceDialogPresenter;
    private VoiceRenameDialogPresenter mVoiceRenameDialogPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory {
        SaveNoteConfirmDialogPresenter createSaveNoteConfirmDialogPresenter(@NonNull DialogContract.IParent iParent, @NonNull DialogContract.IDialogCreator iDialogCreator, @NonNull ComposerModel composerModel, @NonNull PageManager pageManager);
    }

    public DialogPresenterManager(@NonNull ComponentFactory componentFactory) {
        this.mComponentFactory = componentFactory;
    }

    private void hideSoftInput() {
        if (WindowManagerCompat.getInstance().isMultiWindowMode(this.mActivity)) {
            this.mSoftInputManager.hide(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showOpenLinkPopup$0(Runnable runnable, View view) {
        runnable.run();
        this.mOpenLinkPopupWindow.dismiss();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void dismissConfirmVoiceDialog() {
        VoiceDialogPresenter voiceDialogPresenter = this.mVoiceDialogPresenter;
        if (voiceDialogPresenter == null || !voiceDialogPresenter.isShowing()) {
            return;
        }
        this.mVoiceDialogPresenter.hide();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void dismissConvertSettingDialog() {
        this.mConvertSettingDialogPresenter.dismissConvertSettingDialog();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void dismissDirectWriteSettingDialog() {
        this.mDirectWriteSettingDialogPresenter.hide();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IFragmentPresenterContainer
    @Nullable
    public DialogContract.IFragmentPresenter getDialogFragmentPresenter(int i) {
        if (i == 1) {
            return this.mVoiceRenameDialogPresenter;
        }
        if (i == 2) {
            return this.mConvertSettingDialogPresenter;
        }
        if (i == 3) {
            return this.mHashTagRenameDialogPresenter;
        }
        switch (i) {
            case 7:
                return this.mSaveAsRenameDialogPresenter;
            case 8:
                return this.mSaveNoteConfirmDialogPresenter;
            case 9:
                return this.mVoiceDataRenameDialogPresenter;
            case 10:
                return this.mSyncWaitingProgressDialogPresenter;
            case 11:
                return this.mSyncConflictConfirmDialogPresenter;
            case 12:
                return this.mDirectWriteSettingDialogPresenter;
            case 13:
                return this.mVoiceDataDeleteConfirmDialogPresenter;
            case 14:
                return this.mShareSaveNoteConfirmDialogPresenter;
            case 15:
                return this.mHwBeautifierLanguageDialogPresenter;
            case 16:
                return this.mTurnOffTranslationDialogPresenter;
            case 17:
                return this.mUnavailableContentDialogPresenter;
            case 18:
                return this.mVersionUpdateDialogPresenter;
            case 19:
                return this.mTableDialogPresenter;
            case 20:
                return this.mLinkEditDialogPresenter;
            default:
                return null;
        }
    }

    public QuickNoteDialogPresenter getQuickNoteDialogPresenter() {
        return this.mQuickNoteDialogPresenter;
    }

    public void hideInAppDeviceListDialog() {
        this.mInAppDialogPresenter.dismiss();
    }

    public void hideQuickNoteDialog(String str, @Nullable List<String> list, boolean z) {
        this.mQuickNoteDialogPresenter.hide(str, list, z);
    }

    public void hideSummaryOptionDialog() {
        SummaryOptionDialogPresenter summaryOptionDialogPresenter = this.mSummaryOptionDialogPresenter;
        if (summaryOptionDialogPresenter != null) {
            summaryOptionDialogPresenter.hide();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.IDialogManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffHandler.DialogManager
    public void hideSyncWaitingProgressDialog() {
        this.mSyncWaitingProgressDialogPresenter.hide();
    }

    public void hideVoiceDialog() {
        this.mVoiceDataRenameDialogPresenter.hide();
        this.mVoiceDataDeleteConfirmDialogPresenter.hide();
    }

    public void init(DialogContract.IParent iParent, DialogContract.IDialogCreator iDialogCreator, ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, MenuPresenterManager menuPresenterManager, ComposerModel composerModel) {
        this.mCreator = iDialogCreator;
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mCompViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mProgressController = controllerManager.getProgressController();
        if (this.mHashTagRenameDialogPresenter != null) {
            Logger.m10999d(TAG, "init# objects are already created");
            return;
        }
        this.mHashTagRenameDialogPresenter = new HashTagRenameDialogPresenter(iDialogCreator, controllerManager.getHashTagController());
        this.mConvertSettingDialogPresenter = new ConvertSettingDialogPresenter(iDialogCreator, this.mCompViewPresenter.getWritingToolManager());
        this.mDirectWriteSettingDialogPresenter = new DirectWriteSettingDialogPresenter(iDialogCreator, this.mCompViewPresenter.getWritingToolManager(), this.mComposerModel);
        this.mVoiceDialogPresenter = new VoiceDialogPresenter(iDialogCreator, this.mCompViewPresenter.getObjectManager());
        this.mVoiceRenameDialogPresenter = new VoiceRenameDialogPresenter(iDialogCreator, this.mCompViewPresenter, controllerManager);
        this.mUnlockConfirmDialogPresenter = new UnlockConfirmDialogPresenter(iDialogCreator);
        this.mSaveAsRenameDialogPresenter = new SaveAsRenameDialogPresenter(iDialogCreator);
        this.mSaveNoteConfirmDialogPresenter = this.mComponentFactory.createSaveNoteConfirmDialogPresenter(iParent, iDialogCreator, this.mComposerModel, this.mCompViewPresenter.getPageManager());
        this.mShareSaveNoteConfirmDialogPresenter = new ShareSaveNoteConfirmDialogPresenter(iDialogCreator);
        this.mVoiceDataRenameDialogPresenter = new VoiceDataRenameDialogPresenter(iDialogCreator, this.mComposerModel, controllerManager, this.mCompViewPresenter);
        this.mSyncWaitingProgressDialogPresenter = new SyncWaitingProgressDialogPresenter(iDialogCreator, composerViewPresenter);
        this.mSyncConflictConfirmDialogPresenter = new SyncConflictConfirmDialogPresenter(iParent, iDialogCreator, this.mComposerModel, new SyncConflictConfirmDialogPresenter.DialogPresenterManagerContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogPresenterManager.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter.DialogPresenterManagerContract
            public void hideProgress(int i) {
                DialogPresenterManager.this.mProgressController.hideProgress(i, true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter.DialogPresenterManagerContract
            public void showProgress(int i) {
                if (DialogPresenterManager.this.mSyncWaitingProgressDialogPresenter.isShowing()) {
                    return;
                }
                DialogPresenterManager.this.mProgressController.showProgress(0, i);
            }
        });
        this.mAutoRestoredNoteNotiDialogPresenter = new AutoRestoredNoteNotiDialogPresenter(this.mComposerModel);
        this.mCanNotUseSpenDialogPresenter = new CanNotUseSpenDialogPresenter(iDialogCreator, this.mCompViewPresenter.getWritingToolManager(), this.mComposerModel);
        this.mVoiceDataDeleteConfirmDialogPresenter = new VoiceDataDeleteConfirmDialogPresenter(iDialogCreator, this.mComposerModel.getVoiceModel());
        this.mQuickNoteDialogPresenter = new QuickNoteDialogPresenter(iDialogCreator, controllerManager, this.mCompViewPresenter.getComponentFactory());
        this.mInAppDialogPresenter = new InAppDialogPresenter(iParent);
        this.mManualSaveConfirmDialogPresenter = new ManualSaveConfirmDialogPresenter();
        this.mHwBeautifierLanguageDialogPresenter = new HwBeautifierLanguageDialogPresenter(iDialogCreator, this.mCompViewPresenter.getWritingToolManager());
        this.mTurnOffTranslationDialogPresenter = new TurnOffTranslationDialogPresenter(iDialogCreator, menuPresenterManager);
        this.mTranslatedPDFGuideDialogPresenter = new TranslatedPDFGuideDialogPresenter(iDialogCreator, this.mComposerModel);
        this.mTranslatedPDFBlockingDialogPresenter = new TranslatedPDFBlockingDialogPresenter(iDialogCreator);
        this.mCanNotAddToNoteDialogPresenter = new CanNotAddToNoteDialogPresenter(iDialogCreator);
        this.mUnavailableContentDialogPresenter = new UnavailableContentDialogPresenter(iDialogCreator);
        this.mVersionUpdateDialogPresenter = new VersionUpdateDialogPresenter(iDialogCreator);
        this.mTableDialogPresenter = new TableDialogPresenter(iDialogCreator, menuPresenterManager);
        this.mLinkEditDialogPresenter = new LinkEditDialogPresenter(iDialogCreator, this.mCompViewPresenter, controllerManager);
        this.mGoToSettingsDialogPresenter = new GoToSettingsDialogPresenter();
    }

    public boolean isShowingQuickNoteDialog() {
        return this.mQuickNoteDialogPresenter.isShowing();
    }

    public boolean isShowingSyncWaitingProgressDialog() {
        return this.mSyncWaitingProgressDialogPresenter.isShowing();
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
        this.mHashTagRenameDialogPresenter.onAttachView(activity);
        this.mConvertSettingDialogPresenter.onAttachView(activity);
        this.mDirectWriteSettingDialogPresenter.onAttachView(activity);
        this.mVoiceDialogPresenter.onAttachView(activity);
        this.mVoiceRenameDialogPresenter.onAttachView(activity);
        this.mUnlockConfirmDialogPresenter.onAttachView(activity);
        this.mSaveAsRenameDialogPresenter.onAttachView(activity);
        this.mVoiceDataRenameDialogPresenter.onAttachView(activity);
        this.mSyncWaitingProgressDialogPresenter.onAttachView(activity);
        this.mSyncConflictConfirmDialogPresenter.onAttachView(activity);
        this.mCanNotUseSpenDialogPresenter.onAttachView(activity);
        this.mSaveNoteConfirmDialogPresenter.onAttachView(activity);
        this.mShareSaveNoteConfirmDialogPresenter.onAttachView(activity);
        this.mVoiceDataDeleteConfirmDialogPresenter.onAttachView(activity);
        this.mQuickNoteDialogPresenter.onAttachView(activity);
        this.mHwBeautifierLanguageDialogPresenter.onAttachView(activity);
        this.mTurnOffTranslationDialogPresenter.onAttachView(activity);
        this.mTranslatedPDFGuideDialogPresenter.onAttachView(activity);
        this.mTranslatedPDFBlockingDialogPresenter.onAttachView(activity);
        this.mCanNotAddToNoteDialogPresenter.onAttachView(activity);
        this.mUnavailableContentDialogPresenter.onAttachView(activity);
        this.mVersionUpdateDialogPresenter.onAttachView(activity);
        this.mTableDialogPresenter.onAttachView(activity);
        this.mLinkEditDialogPresenter.onAttachView(activity);
    }

    public boolean onBackPressed() {
        VoiceDialogPresenter voiceDialogPresenter = this.mVoiceDialogPresenter;
        if (voiceDialogPresenter != null && voiceDialogPresenter.isShowing()) {
            this.mVoiceDialogPresenter.hide();
            return true;
        }
        TextBoxMoreDialogPresenter textBoxMoreDialogPresenter = this.mTextBoxMoreDialogPresenter;
        if (textBoxMoreDialogPresenter != null && textBoxMoreDialogPresenter.isShowing()) {
            this.mTextBoxMoreDialogPresenter.hide();
            return true;
        }
        UnlockConfirmDialogPresenter unlockConfirmDialogPresenter = this.mUnlockConfirmDialogPresenter;
        if (unlockConfirmDialogPresenter != null && unlockConfirmDialogPresenter.isShowing()) {
            this.mUnlockConfirmDialogPresenter.hide();
            return true;
        }
        QuickNoteDialogPresenter quickNoteDialogPresenter = this.mQuickNoteDialogPresenter;
        if (quickNoteDialogPresenter != null && quickNoteDialogPresenter.isShowing()) {
            this.mQuickNoteDialogPresenter.hide("onBackPressed", null, false);
            return true;
        }
        ManualSaveConfirmDialogPresenter manualSaveConfirmDialogPresenter = this.mManualSaveConfirmDialogPresenter;
        if (manualSaveConfirmDialogPresenter != null && manualSaveConfirmDialogPresenter.isShowing()) {
            this.mManualSaveConfirmDialogPresenter.hide();
            return true;
        }
        SummaryOptionDialogPresenter summaryOptionDialogPresenter = this.mSummaryOptionDialogPresenter;
        if (summaryOptionDialogPresenter != null && summaryOptionDialogPresenter.isShowing()) {
            this.mSummaryOptionDialogPresenter.hide();
            return true;
        }
        AiDrawingDeleteConfirmDialogPresenter aiDrawingDeleteConfirmDialogPresenter = this.mAiDrawingDeleteConfirmDialogPresenter;
        if (aiDrawingDeleteConfirmDialogPresenter == null || !aiDrawingDeleteConfirmDialogPresenter.isShowing()) {
            return false;
        }
        this.mAiDrawingDeleteConfirmDialogPresenter.hide();
        return true;
    }

    public void onDetachView() {
        this.mActivity = null;
        if (this.mCreator == null) {
            return;
        }
        this.mHashTagRenameDialogPresenter.onDetachView();
        this.mConvertSettingDialogPresenter.onDetachView();
        this.mDirectWriteSettingDialogPresenter.onDetachView();
        this.mVoiceDialogPresenter.onDetachView();
        this.mVoiceRenameDialogPresenter.onDetachView();
        this.mUnlockConfirmDialogPresenter.onDetachView();
        this.mSaveAsRenameDialogPresenter.onDetachView();
        this.mVoiceDataRenameDialogPresenter.onDetachView();
        this.mSyncWaitingProgressDialogPresenter.onDetachView();
        this.mSyncConflictConfirmDialogPresenter.onDetachView();
        this.mAutoRestoredNoteNotiDialogPresenter.onDetachView();
        this.mCanNotUseSpenDialogPresenter.onDetachView();
        this.mSaveNoteConfirmDialogPresenter.onDetachView();
        this.mShareSaveNoteConfirmDialogPresenter.onDetachView();
        this.mVoiceDataDeleteConfirmDialogPresenter.onDetachView();
        TextBoxMoreDialogPresenter textBoxMoreDialogPresenter = this.mTextBoxMoreDialogPresenter;
        if (textBoxMoreDialogPresenter != null) {
            textBoxMoreDialogPresenter.onDetachView();
        }
        this.mQuickNoteDialogPresenter.onDetachView();
        this.mManualSaveConfirmDialogPresenter.onDetachView();
        this.mHwBeautifierLanguageDialogPresenter.onDetachView();
        SummaryOptionDialogPresenter summaryOptionDialogPresenter = this.mSummaryOptionDialogPresenter;
        if (summaryOptionDialogPresenter != null) {
            summaryOptionDialogPresenter.onDetachView();
        }
        AiDrawingDeleteConfirmDialogPresenter aiDrawingDeleteConfirmDialogPresenter = this.mAiDrawingDeleteConfirmDialogPresenter;
        if (aiDrawingDeleteConfirmDialogPresenter != null) {
            aiDrawingDeleteConfirmDialogPresenter.onDetachView();
        }
        this.mTurnOffTranslationDialogPresenter.onDetachView();
        this.mTranslatedPDFGuideDialogPresenter.onDetachView();
        this.mTranslatedPDFBlockingDialogPresenter.onDetachView();
        this.mCanNotAddToNoteDialogPresenter.onDetachView();
        this.mUnavailableContentDialogPresenter.onDetachView();
        this.mVersionUpdateDialogPresenter.onDetachView();
        this.mTableDialogPresenter.onDetachView();
        this.mLinkEditDialogPresenter.onDetachView();
    }

    public void showAiDrawingDeleteConfirmDialog(AiDrawingDeleteConfirmDialogPresenter.Contract contract) {
        if (this.mAiDrawingDeleteConfirmDialogPresenter == null) {
            this.mAiDrawingDeleteConfirmDialogPresenter = new AiDrawingDeleteConfirmDialogPresenter(this.mCreator);
        }
        this.mAiDrawingDeleteConfirmDialogPresenter.showDialog(this.mActivity, contract);
    }

    public void showAutoRestoredNoteNotiDialog() {
        this.mAutoRestoredNoteNotiDialogPresenter.show(this.mCreator, this.mActivity);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showCanNotAddToNoteDialog() {
        this.mCanNotAddToNoteDialogPresenter.show();
    }

    public void showCanNotUseSpenDialog() {
        this.mCanNotUseSpenDialogPresenter.showDialog();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showConfirmCancelVoiceDialog() {
        this.mVoiceDialogPresenter.showConfirmCancelVoiceDialog();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showConfirmRemoveItemDialog(SpenWPage spenWPage, SpenObjectBase spenObjectBase) {
        this.mVoiceDialogPresenter.showConfirmRemoveItemDialog(spenWPage, spenObjectBase);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showConfirmRemoveRecordingDialog() {
        this.mVoiceDialogPresenter.showConfirmRemoveRecordingDialog();
    }

    public void showConfirmSyncConflictDialog() {
        Logger.m10999d(TAG, "showConfirmSyncConflictDialog#");
        this.mSyncConflictConfirmDialogPresenter.show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showConvertSettingDialog(boolean z, boolean z2) {
        if (CommonUtil.isSos()) {
            hideSoftInput();
        }
        this.mConvertSettingDialogPresenter.showConvertSettingDialog(z, z2);
        ComposerSA.insertLog("411", ComposerSAConstants.EVENT_WRITING_CONVERT_TO_TEXT_SETTING);
    }

    public void showDirectWriteSettingDialog() {
        this.mDirectWriteSettingDialogPresenter.showDirectWriteSettingDialog();
    }

    public void showGoToSettingsDialog(int i) {
        final View view = this.mCompViewPresenter.getView();
        if (view != null) {
            view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogPresenterManager.3
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z) {
                    if (z) {
                        view.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                        view.postDelayed(DialogPresenterManager.this.mResetHwToolbarRunnable, 500L);
                    }
                }
            });
        }
        this.mGoToSettingsDialogPresenter.show(this.mActivity, i);
    }

    public void showHashTagRenameDialog(String str) {
        this.mSoftInputManager.hide(false);
        this.mHashTagRenameDialogPresenter.showHashTagRenameDialog(str);
    }

    public void showHwBeautifierLanguageDialog() {
        this.mHwBeautifierLanguageDialogPresenter.show();
    }

    public void showInAppDeviceListDialog(Map<String, NearbyMyDevicesModel.NearbyDevice> map) {
        this.mInAppDialogPresenter.show(this.mActivity, map);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showLinkEditDialog(String str, SpenHyperTextSpan spenHyperTextSpan, boolean z, boolean z2) {
        if (str == null || spenHyperTextSpan == null) {
            Logger.m11000e(TAG, "showLinkEditDialog# displayText or span is null.");
        } else {
            this.mLinkEditDialogPresenter.showEditDialog(str, spenHyperTextSpan, z, z2);
        }
    }

    public void showManualSaveConfirmDialog(Runnable runnable, boolean z) {
        this.mManualSaveConfirmDialogPresenter.show(this.mCreator, this.mActivity, runnable, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showNotEnoughStorageDialog() {
        Logger.m11003i(TAG, "showNotEnoughMemoryDialog");
        DialogUtils.showNotEnoughStorageDialog(this.mActivity, null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showOpenLinkPopup(Runnable runnable) {
        View viewInflate = ((LayoutInflater) this.mActivity.getSystemService("layout_inflater")).inflate(C9086R.layout.comp_simple_menu_popup, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(C9086R.id.txtTitle)).setText(C9086R.string.open_link);
        viewInflate.setOnClickListener(new ViewOnClickListenerC0219a(this, runnable, 11));
        MotionEvent lastTouchedMotionEvent = this.mCompViewPresenter.getListenerManager().getLastTouchedMotionEvent();
        this.mOpenLinkPopupWindow = new PopupWindow(viewInflate, -2, -2, true);
        View viewShowPopup = this.mCompViewPresenter.getViewShowPopup();
        this.mOpenLinkPopupWindow.showAsDropDown(viewShowPopup, lastTouchedMotionEvent == null ? 0 : (int) lastTouchedMotionEvent.getX(), lastTouchedMotionEvent != null ? ((int) lastTouchedMotionEvent.getY()) - viewShowPopup.getHeight() : 0);
    }

    public void showQuickNoteDialog(QuickNoteModel.SuggestedData suggestedData, QuickNoteDialogPresenter.ActionListener actionListener) {
        this.mQuickNoteDialogPresenter.show(suggestedData, actionListener);
    }

    public void showRenameDialog() {
        this.mVoiceRenameDialogPresenter.showRenameDialog();
    }

    public void showSaveAsRenameDialog(ShareData shareData, String str, String str2, SaveAsRenameDialogPresenter.OnClickListener onClickListener) {
        this.mSaveAsRenameDialogPresenter.showRenameDialog(shareData, str, str2, onClickListener);
    }

    public void showSaveNoteConfirmDialog(Runnable runnable) {
        Logger.m10999d(TAG, "showSaveNoteConfirmDialog#");
        this.mSaveNoteConfirmDialogPresenter.show(runnable);
    }

    public void showSaveNoteConfirmDialogToNextAction(Runnable runnable, int i) {
        Logger.m10999d(TAG, "showSaveNoteConfirmDialogToNextAction#");
        this.mShareSaveNoteConfirmDialogPresenter.show(i, runnable);
    }

    public void showShareSaveNoteConfirmDialog(boolean z, Runnable runnable) {
        Logger.m10999d(TAG, "showShareSaveNoteConfirmDialog#");
        this.mShareSaveNoteConfirmDialogPresenter.show(z, runnable);
    }

    public void showSummaryOptionDialog(int i, SummaryOptionDialogPresenter.Contract contract, boolean z, View view) {
        if (this.mSummaryOptionDialogPresenter == null) {
            this.mSummaryOptionDialogPresenter = new SummaryOptionDialogPresenter(this.mCreator);
        }
        this.mSummaryOptionDialogPresenter.setAnchorView(view);
        this.mSummaryOptionDialogPresenter.showDialog(this.mActivity, i, contract, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.handoff.HandoffManager.IDialogManager
    public void showSyncWaitingProgressDialog() {
        this.mSyncWaitingProgressDialogPresenter.show();
    }

    public void showTableDialog() {
        this.mTableDialogPresenter.show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showTextBoxMoreDialog(SpenObjectShape spenObjectShape) {
        if (this.mTextBoxMoreDialogPresenter == null) {
            this.mTextBoxMoreDialogPresenter = new TextBoxMoreDialogPresenter(this.mCompViewPresenter.getComposerModel(), this.mCompViewPresenter.getTextManager(), this.mCompViewPresenter.getListenerManager());
        }
        this.mTextBoxMoreDialogPresenter.show(this.mCreator, this.mActivity, spenObjectShape, this.mComposerModel.getSearchKeyword());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showTranslatedPDFBlockingDialog() {
        this.mTranslatedPDFBlockingDialogPresenter.show();
    }

    public void showTranslatedPDFGuideDialog() {
        this.mTranslatedPDFGuideDialogPresenter.show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showTurnOffTranslationDialog(int i) {
        this.mTurnOffTranslationDialogPresenter.show(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showUnavailableContentDialog() {
        this.mUnavailableContentDialogPresenter.show();
    }

    public void showUnlockConfirmDialog(Runnable runnable) {
        this.mUnlockConfirmDialogPresenter.show(runnable);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IDialogPresenter
    public void showVersionUpdateDialog(Runnable runnable, Runnable runnable2) {
        this.mVersionUpdateDialogPresenter.show(runnable, runnable2);
    }

    public void showVideoErrDialog() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mActivity, C9086R.style.NoteAlertDialogThemeForAppCompat).setMessage(this.mActivity.getResources().getString(C9086R.string.video_play_error_msg)).setPositiveButton(this.mActivity.getResources().getString(C9086R.string.video_play_error_msg_ok), new DialogInterfaceOnClickListenerC0140a(14)).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setGravity(80);
        }
        alertDialogCreate.show();
    }

    public void showVoiceDataDeleteConfirmDialog(VoiceDataDeleteConfirmDialogPresenter.OnClickListener onClickListener, View view) {
        this.mVoiceDataRenameDialogPresenter.hide();
        this.mVoiceDataDeleteConfirmDialogPresenter.showDialog(onClickListener, view);
    }

    public void showVoiceDataRenameDialog(VoiceDataRenameDialogPresenter.OnClickListener onClickListener, View view) {
        this.mVoiceDataDeleteConfirmDialogPresenter.hide();
        this.mVoiceDataRenameDialogPresenter.showRenameDialog(onClickListener, view);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.util.WebCardUtil.IDialogManager
    public void showWebCardPreviewDialog(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        this.mCreator.createConfirmWebCardPreviewDialog(this.mActivity, onClickListener, onClickListener2, onDismissListener);
    }
}
