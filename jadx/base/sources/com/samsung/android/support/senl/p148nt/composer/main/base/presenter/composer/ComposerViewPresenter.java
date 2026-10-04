package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer;

import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.sdk.pen.setting.quicktool.RunnableC7661m;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.SavedState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.handwriting.LaserPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.search.RecentSearchKeywordManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.provideassist.ProvideAssist;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.BackgroundTaskManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerAiController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerSearchController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerVoiceController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.EmptyHandoffManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPageEventListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.HWToolbarPolicyManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.documents.data.CoverDataSource;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p027F3.RunnableC0101a;
import p035H2.RunnableC0116a;
import p035H2.RunnableC0117b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerViewPresenter implements ComposerViewContract.IPresenter, PageManager.OnPageUpdateListener, ListenerImplContract.IPresenter {
    private static final String TAG = Logger.createTag("ComposerViewPresenter");
    protected Activity mActivity;
    private ComposerViewContract.AiMenuManagerContract mAiMenuManager;
    protected final ComponentFactory mComponentFactory;
    protected final ComposerControllerManager mComposerControllerManager;
    private ComposerModel mComposerModel;
    private List<ObserverConfigurationChanged> mConfigurationObserverList;
    private ControllerManager mControllerManager;
    private ComposerViewContract.IDialogManager mDialogPresenterManager;
    private ComposerViewContract.HWToolbarContract mHwToolbarPresenter;
    private ComposerViewContract.InAppContract mInAppPresenter;
    private boolean mIsInitialized;
    private final KeyguardPresenter mKeyguardPresenter;
    private Boolean mLastIsAbleToUseSpen;
    private final ListenerManager mListenerManager;
    protected ModelManager mModelManager;
    private ComposerViewContract.IView mOldView;
    private OnInitFinishedListener mOnInitFinishedListener;
    private ComposerViewContract.RtTableAndCellStyleContract mRtTableAndCellStylePresenter;
    private Runnable mRunnableSmoothScrollAndScaleToFitPage;
    protected SpenWNote mSpenWNote;
    private ComposerViewContract.TableAndCellContract mTableAndCellPresenter;
    private ThumbnailUpdateHandler mThumbnailUpdateHandler;
    private ComposerViewContract.TlToolbarContract mTlToolbarPresenter;
    private UndoRedoPresenter mUndoRedoPresenter;

    @Nullable
    private ComposerViewContract.IView mView;
    private ViewState mViewState;
    private final BackgroundTaskManager mBackgroundTaskManager = new BackgroundTaskManager();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private int mWindowMode = 0;
    private final HandoffManager mHandoffManager = createHandoffManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends ModelManager.ComponentFactory, ComposerControllerManager.ComponentFactory, HwToolbarOrderManager.ComponentFactory, ListenerManager.ComponentFactory, SettingInfoManager.ComponentFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ObserverConfigurationChanged {
        void onConfigurationChanged(Configuration configuration, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnInitFinishedListener {
        void onInitFinished();

        void onInitLayoutFinished();
    }

    public ComposerViewPresenter(@NonNull ComponentFactory componentFactory, @NonNull KeyguardPresenter keyguardPresenter) {
        this.mComponentFactory = componentFactory;
        this.mKeyguardPresenter = keyguardPresenter;
        this.mModelManager = new ModelManager(componentFactory, keyguardPresenter);
        this.mComposerControllerManager = new ComposerControllerManager(componentFactory);
        this.mListenerManager = new ListenerManager(componentFactory, this, new C9176a(this));
        AiLanguageHelper.TranslateConfig.INSTANCE.getInstance().loadLanguagePackInformation();
    }

    private boolean canUndoRedo() {
        ComposerViewContract.AiMenuManagerContract aiMenuManagerContract = this.mAiMenuManager;
        if (aiMenuManagerContract == null) {
            return true;
        }
        aiMenuManagerContract.hideAiSuggestionView();
        if (!this.mAiMenuManager.isTranslating()) {
            return true;
        }
        Logger.m11000e(TAG, "canUndoRedo# AiMenuManager.isTranslating ");
        return false;
    }

    private boolean changeOrientation(SpenWNote spenWNote, SpenWNote.Orientation orientation) {
        if (spenWNote.getOrientation() == orientation) {
            return false;
        }
        int pageCount = spenWNote.getPageCount();
        if (pageCount > 0) {
            for (int i = pageCount - 1; i >= 0; i--) {
                spenWNote.removePage(i);
            }
        }
        SpenWNote.Orientation orientation2 = SpenWNote.Orientation.LANDSCAPE_NEW;
        int height = orientation == orientation2 ? DocumentPageRatio.PageRatioType.A4_PORTRAIT.getHeight(spenWNote.getPageDefaultWidth()) : spenWNote.getPageDefaultWidth();
        Activity activity = this.mActivity;
        if (activity != null && activity.getIntent() != null) {
            this.mActivity.getIntent().putExtra(SettingsConstants.SETTINGS_PAGE_SIZE, orientation == orientation2 ? 2 : 0);
        }
        spenWNote.changeOrientation(orientation, height);
        if (spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            spenWNote.setPageDefaultHeight(DocumentPageRatio.PageRatioType.A4_PORTRAIT.getHeight(spenWNote.getPageDefaultWidth()));
        } else {
            DocumentPageRatio.PageRatioType pageRatioType = DocumentPageRatio.PageRatioType.A4_PORTRAIT;
            if (orientation == orientation2) {
                pageRatioType = DocumentPageRatio.PageRatioType.A4_LANDSCAPE;
            }
            spenWNote.setPageDefaultHeight(pageRatioType.getHeight(spenWNote.getPageDefaultWidth()));
        }
        Logger.m11003i(TAG, "changeOrientation# toOrientation = " + orientation);
        return true;
    }

    private HandoffManager createHandoffManager() {
        return this.mComponentFactory.getConfig().isHandOffEnabled() ? new HandoffManager(this.mComposerControllerManager.getScrollController(), new C9176a(this)) : new EmptyHandoffManager(this.mComposerControllerManager.getScrollController());
    }

    private DocumentBackgroundUtils.InvertBackgroundColorType getInvertBackgroundColorType() {
        SpenWNote spenWNote = this.mSpenWNote;
        if (spenWNote == null || spenWNote.isClosed()) {
            return DocumentBackgroundUtils.InvertBackgroundColorType.None;
        }
        List pageList = this.mSpenWNote.getPageList();
        if (pageList == null) {
            pageList = Collections.EMPTY_LIST;
        }
        return BackgroundColorUtil.getInvertBackgroundColorType(pageList);
    }

    private void initCoverDataFromIntent() {
        boolean booleanExtra = this.mActivity.getIntent().getBooleanExtra(CoverData.KEY_IS_CHANGED, false);
        CoverData coverData = (CoverData) this.mActivity.getIntent().getParcelableExtra(CoverData.KEY_COVER_DATA);
        if (!booleanExtra || coverData == null) {
            return;
        }
        CoverDataSource coverDataSource = this.mComposerModel.getDocState().getCoverDataSource();
        String title = coverData.getTitle();
        String summary = coverData.getSummary();
        String templateUuid = coverData.getTemplateUuid();
        String categoryUuid = coverData.getCategoryUuid();
        String colorId = coverData.getColorId();
        boolean zIsEnabled = coverData.isEnabled();
        coverDataSource.setCoverData(title, summary, templateUuid, categoryUuid, colorId, zIsEnabled ? 1 : 0, coverData.getState(), 0, 0, true);
    }

    private void initListener() {
        this.mListenerManager.onDestroy();
        this.mListenerManager.init(this.mControllerManager);
        this.mListenerManager.initListenerForDoc();
        this.mListenerManager.addSpenObjectEventListener(this.mModelManager.getTextManager().getSpenObjectListener());
        if (!FeatureInfo.isSupportHyperTextInEditMode() || this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            return;
        }
        this.mListenerManager.addSpenObjectEventListener(this.mComposerControllerManager.getHyperTextUpdateController());
    }

    private void initManager() {
        if (this.mView == null) {
            return;
        }
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        Logger.startTime(strValueOf, str, "initManager# start");
        this.mView.init(this.mSpenWNote);
        this.mModelManager.init(this.mView, this.mSpenWNote, this.mActivity, this.mComposerModel);
        this.mComposerControllerManager.init(this.mComposerModel, this.mControllerManager, this.mModelManager);
        this.mComposerControllerManager.onAttachView(this.mView);
        this.mThumbnailUpdateHandler.init(this.mActivity, this.mSpenWNote, getPageManager());
        initListener();
        this.mView.initScrollManager();
        this.mView.setSpenNotePdfActionListener(this.mModelManager.getPdfManager());
        this.mIsInitialized = true;
        this.mOnInitFinishedListener.onInitFinished();
        getComposerControllerManager().getComposerAiController().setContract(new ComposerAiController.ComposerViewPresenterContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerAiController.ComposerViewPresenterContract
            public void clearContextMenuDelegate() {
                ComposerViewPresenter.this.setContextMenuDelegate(false, null);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerAiController.ComposerViewPresenterContract
            public void clearTextSelectionChangedListener() {
                ComposerViewPresenter.this.mListenerManager.setTextSelectionChangedListener(null);
            }
        });
        this.mModelManager.getTextManager().setContract(new TextManager.IContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.TextManager.IContract
            public boolean isKeyboardConnected() {
                return InputMethodCompat.getInstance().isKeyboardConnected(ComposerViewPresenter.this.mActivity);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.TextManager.IContract
            public boolean isSIPShown() {
                InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
                Activity activity = ComposerViewPresenter.this.mActivity;
                return inputMethodCompat.isInputMethodShown(activity, activity.getWindow().getDecorView(), false);
            }
        });
        Logger.endTime(String.valueOf(hashCode()), str, "initManager# end");
    }

    private void initNote(boolean z) {
        ComposerDocInitialization composerDocInitializationCreateDocInitialization = createDocInitialization();
        composerDocInitializationCreateDocInitialization.setPageDefaultHeight();
        composerDocInitializationCreateDocInitialization.init(z);
        initCoverDataFromIntent();
    }

    private void initNoteAfterChangeParameter(SpenWNote spenWNote, SpenWNote.PageMode pageMode, SpenWNote.Orientation orientation) {
        if (spenWNote.getPageMode() != pageMode) {
            spenWNote.changePageMode(pageMode);
            Activity activity = this.mActivity;
            if (activity != null && activity.getIntent() != null) {
                this.mActivity.getIntent().putExtra(ComposerConstants.ARG_PAGE_TYPE, pageMode == SpenWNote.PageMode.SINGLE ? 0 : 1);
            }
        }
        ComposerDocInitialization composerDocInitializationCreateDocInitialization = createDocInitialization();
        SpenPageEventListener spenPageEventListener = this.mListenerManager.getSpenPageEventListener();
        spenWNote.deregisterPageEventListener(spenPageEventListener);
        boolean zChangeOrientation = changeOrientation(spenWNote, orientation);
        createDocInitialization().init(true);
        if (zChangeOrientation) {
            composerDocInitializationCreateDocInitialization.initNoteManager(spenWNote);
        }
        spenWNote.registerPageEventListener(spenPageEventListener);
    }

    private void initView() {
        initManager();
        this.mModelManager.getNoteManager().addBackgroundColorObserver(new NoteManager.ObserverBackgroundColor() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.b
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
            public final void onChangedBackgroundColor(int i, boolean z, boolean z2) {
                this.f6778a.lambda$initView$2(i, z, z2);
            }
        });
        this.mModelManager.getNoteManager().setInvertBackgroundColorObserver(new C9176a(this));
        this.mModelManager.getNoteManager().notifyBackgroundColorChange();
        getPageManager().getDocPageInfo().setViewUpdater(this.mComposerControllerManager.getScrollController());
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.onChangedPageCount(this.mSpenWNote.getPageCount());
        }
        ComposerViewContract.IView iView2 = this.mView;
        if (iView2 != null && iView2.getView() != null && this.mView.getView().getResources() != null) {
            this.mWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(this.mView.getView().getResources().getConfiguration());
            Logger.m11004w(TAG, "initView# windowMode : " + this.mWindowMode);
        }
        setSoftInputMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createHandoffManager$1() {
        this.mHwToolbarPresenter.updatedLastPenInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideProgress$7(int i, boolean z) {
        this.mControllerManager.getProgressController().hideProgress(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(int i, boolean z, boolean z2) {
        boolean zIsComposerViewDarkTheme = BackgroundColorUtil.isComposerViewDarkTheme(this.mActivity, i, z, z2);
        setViewBackgroundColor(zIsComposerViewDarkTheme);
        setPageBackgroundColor(zIsComposerViewDarkTheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenerImplContract.IView lambda$new$0() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pauseCoEdit$3(Runnable runnable) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.getView().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseView$4(boolean z) {
        Logger.m10999d(TAG, "releaseView# pending release ");
        releaseOldView(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showProgress$6(int i, int i2) {
        this.mControllerManager.getProgressController().showProgress(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smoothScrollAndScaleToFitPage$5(int i, Runnable runnable) {
        this.mView.smoothScrollAndScaleToFitPage(i, runnable);
    }

    private boolean needToSkipSelectedBodyText() {
        if (this.mModelManager.getObjectManager().getSelectedObjectManager().isSelectedBodyText()) {
            int[] cursorFromFocusedTextBox = this.mModelManager.getTextManager().getCursorFromFocusedTextBox();
            if (cursorFromFocusedTextBox[0] == cursorFromFocusedTextBox[1]) {
                int pageIndexByCursorOfBodyText = this.mModelManager.getTextManager().getSpenNoteTextManager().getPageIndexByCursorOfBodyText(cursorFromFocusedTextBox[0]);
                int currentPageIndex = this.mModelManager.getPageManager().getDocPageInfo().getCurrentPageIndex();
                if (currentPageIndex - 1 > pageIndexByCursorOfBodyText || pageIndexByCursorOfBodyText > currentPageIndex + 1) {
                    Logger.m11003i(TAG, "needToSkipSelectedBodyText# is true");
                    return true;
                }
            }
        }
        return false;
    }

    private void releaseManager() {
        Logger.m10999d(TAG, "releaseManager#");
        this.mModelManager.getWritingToolManager().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toastDarkModeNotApplied(DocumentBackgroundUtils.InvertBackgroundColorType invertBackgroundColorType) {
        if (!ContextUtils.isNightMode(this.mActivity)) {
            Logger.m11003i(TAG, "toastDarkModeNotApplied# currentNightMode is true.");
            return;
        }
        if (isBackgroundColorInverted()) {
            Logger.m11003i(TAG, "toastDarkModeNotApplied# isBackgroundColorInverted is true.");
        } else if (invertBackgroundColorType == DocumentBackgroundUtils.InvertBackgroundColorType.Pdf) {
            ToastHandler.show(this.mActivity, C9086R.string.dark_mode_not_applied_has_pdf_toast_msg, 0);
        } else if (invertBackgroundColorType == DocumentBackgroundUtils.InvertBackgroundColorType.Image) {
            ToastHandler.show(this.mActivity, C9086R.string.dark_mode_not_applied_template_image_toast_msg, 0);
        }
    }

    private void updateLaserPenState() {
        if (!this.mComposerModel.getComposerState().isLaserPenMode()) {
            this.mModelManager.getWritingToolManager().setToolTypeAction(2, 1);
            this.mModelManager.getWritingToolManager().setToolTypeAction(6, 0);
        } else if (this.mModelManager.getWritingToolManager().getToolTypeAction(2) != 18) {
            getHWToolbarPresenter().getSettingInstance().setEnableLaserPen(true);
        }
    }

    public void addConfigurationObserverChanged(ObserverConfigurationChanged observerConfigurationChanged) {
        if (this.mConfigurationObserverList == null) {
            this.mConfigurationObserverList = new ArrayList(2);
        }
        this.mConfigurationObserverList.add(observerConfigurationChanged);
    }

    public boolean canUseLaserPenMode() {
        if (this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            return false;
        }
        return getHWToolbarPresenter().getSettingInstance().getSettingInfoManager().getToolbarItemData().isEnabledLaserPointer();
    }

    public Bitmap captureCurrentView() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            return iView.captureCurrentView();
        }
        Logger.m11000e(TAG, "captureCurrentView : mView is null");
        return null;
    }

    public void changeNoteType(SpenWNote spenWNote, SpenWNote.PageMode pageMode, SpenWNote.Orientation orientation) {
        ComposerViewContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.setDocument(null);
        initNoteAfterChangeParameter(spenWNote, pageMode, orientation);
        this.mView.setDocument(spenWNote);
        boolean z = pageMode == SpenWNote.PageMode.SINGLE;
        this.mComposerControllerManager.getCvPageSettingController().updatePageLayoutByPageType(z);
        this.mView.onChangedNoteType(z);
    }

    public void clearSmoothScrollAndScaleToFitPage() {
        getHandler().removeCallbacks(this.mRunnableSmoothScrollAndScaleToFitPage);
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.clearSmoothScrollAndScaleToFitPage();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void clearWritingToolControl() {
        this.mModelManager.getWritingToolManager().clearControl();
    }

    public void clearZoomRunnableAfterZoom() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.clearZoomRunnableAfterZoom();
        }
    }

    public ComposerDocInitialization createDocInitialization() {
        return new ComposerDocInitialization(this.mActivity, this.mSpenWNote, this.mModelManager, true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void disableTableUnsupportedMenu() {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.setUnselectedDirectWriteButton();
        }
    }

    public void endContinuousChange() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.endContinuousChange();
        }
    }

    public void executeWorkThreadFromCoedit(boolean z) {
        getComposerModel().setDoingCoeditWorkThread(z);
        getComposerModel().getComposerSaveModel().setBlockedSave(z);
        if (z) {
            getComposerControllerManager().getScrollController().stopGestureAnimation();
        }
        this.mListenerManager.setBlockDefaultPreTouch(z);
        getNoteManager().setTextInputBlock(z);
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.executeWorkThreadFromCoedit(z);
        }
        this.mThumbnailUpdateHandler.setBlockToUpdate(z, true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public Activity getActivity() {
        return this.mActivity;
    }

    public ComposerViewContract.AiMenuManagerContract getAiMenuManager() {
        return this.mAiMenuManager;
    }

    public int getBackgroundColor() {
        return BackgroundColorUtil.getColorAdjustment(this.mActivity, this.mModelManager.getNoteManager().getBackgroundColor());
    }

    public int getBackgroundThemeColor() {
        return BackgroundColorUtil.getBackgroundThemeColor(this.mActivity, getBackgroundColor(), isBackgroundColorInverted(), hasBackgroundImage());
    }

    public int[] getBackgroundThemeColorTable() {
        return BackgroundColorUtil.getBackgroundThemeColorTable(this.mActivity, getBackgroundColor(), isBackgroundColorInverted(), hasBackgroundImage());
    }

    public ClipboardController getClipboardController() {
        return this.mControllerManager.getClipboardController();
    }

    public ComponentFactory getComponentFactory() {
        return this.mComponentFactory;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public ComposerControllerManager getComposerControllerManager() {
        return this.mComposerControllerManager;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public ComposerModel getComposerModel() {
        return this.mComposerModel;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public int getCurrentPageIndex() {
        if (this.mModelManager.getPageManager() == null || this.mModelManager.getPageManager().getDocPageInfo() == null) {
            return 0;
        }
        return this.mModelManager.getPageManager().getDocPageInfo().getCurrentPageIndex();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public ListenerImplContract.IDialogPresenter getDialogPresenterManager() {
        return this.mDialogPresenterManager;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public SpenWNote getDoc() {
        return this.mSpenWNote;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    @NonNull
    public HWToolbarPolicyManager getHWToolbarPolicyManager() {
        return new HWToolbarPolicyManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public ComposerViewContract.HWToolbarContract getHWToolbarPresenter() {
        return this.mHwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public HandoffManager getHandoffManager() {
        return this.mHandoffManager;
    }

    @NonNull
    public KeyguardPresenter getKeyguardPresenter() {
        return this.mKeyguardPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public ListenerManager getListenerManager() {
        return this.mListenerManager;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public NoteManager getNoteManager() {
        return this.mModelManager.getNoteManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public ObjectManager getObjectManager() {
        return this.mModelManager.getObjectManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public PageManager getPageManager() {
        return this.mModelManager.getPageManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public PdfManager getPdfManager() {
        return this.mModelManager.getPdfManager();
    }

    public RecentSearchKeywordManager getRecentSearchKeywordManager() {
        return this.mModelManager.getRecentSearchKeywordManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public ComposerViewContract.RtTableAndCellStyleContract getRtTableAndCellStylePresenter() {
        return this.mRtTableAndCellStylePresenter;
    }

    public ComposerSearchController getSearchController() {
        return this.mComposerControllerManager.getCompSearchController();
    }

    public SoftInputManager getSoftInputManager() {
        return this.mControllerManager.getSoftInputManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public ComposerViewContract.TableAndCellContract getTableAndCellPresenter() {
        return this.mTableAndCellPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public TextManager getTextManager() {
        return this.mModelManager.getTextManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public ThumbnailUpdateHandler getThumbnailUpdateHandler() {
        return this.mThumbnailUpdateHandler;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public ComposerViewContract.TlToolbarContract getTlToolbarPresenter() {
        return this.mTlToolbarPresenter;
    }

    public int getTwoPageLeftIndex(int i) {
        if (i <= 0) {
            return 0;
        }
        return (i / 2) * 2;
    }

    public int getTwoPageRightIndex(int i) {
        if (i <= 0) {
            return 1;
        }
        return AbstractC2322a.m1610D(i, 2, 2, 1);
    }

    public UndoRedoPresenter getUndoRedoPresenter() {
        return this.mUndoRedoPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public View getView() {
        ComposerViewContract.IView iView = this.mView;
        if (iView == null) {
            return null;
        }
        return iView.getView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public View getViewShowPopup() {
        ComposerViewContract.IView iView = this.mView;
        if (iView == null) {
            return null;
        }
        return iView.getViewShowPopup();
    }

    public ComposerVoiceController getVoiceController() {
        return this.mComposerControllerManager.getCompVoiceController();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    @NonNull
    public WritingToolManager getWritingToolManager() {
        return this.mModelManager.getWritingToolManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void goToPage(int i) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.goToPage(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public boolean hasBackgroundImage() {
        SpenWNote spenWNote = this.mSpenWNote;
        if (spenWNote != null) {
            return BackgroundColorUtil.hasBackgroundImage(spenWNote.getPageList());
        }
        Logger.m11000e(TAG, "hasBackgroundImage mSpenWNote is null ");
        return false;
    }

    public void hideAiSuggestionView() {
        ComposerViewContract.AiMenuManagerContract aiMenuManagerContract = this.mAiMenuManager;
        if (aiMenuManagerContract != null) {
            aiMenuManagerContract.hideAiSuggestionView();
        }
    }

    public void hideProgress(int i, boolean z) {
        this.mHandler.post(new RunnableC7661m(i, 2, this, z));
    }

    public void hideSoftInputAndExecute(Runnable runnable) {
        if (!this.mControllerManager.getSoftInputManager().isInputMethodShown()) {
            runnable.run();
            return;
        }
        long j = this.mComposerModel.isSingleMode() ? 800L : 500L;
        this.mControllerManager.getSoftInputManager().hide((View) null);
        this.mHandler.postDelayed(runnable, j);
    }

    public void init(Activity activity, SpenWNote spenWNote, String str, Bundle bundle) {
        this.mActivity = activity;
        this.mSpenWNote = spenWNote;
        this.mModelManager.createPageManager(activity, str, spenWNote.getPageDefaultWidth(), spenWNote.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW);
        this.mThumbnailUpdateHandler = new ThumbnailUpdateHandler();
        getPageManager().addListener(this);
        this.mUndoRedoPresenter = new UndoRedoPresenter(this.mModelManager.getObjectManager(), this.mControllerManager.getTaskController(), this.mControllerManager.getQuickSaveTimer(), this.mThumbnailUpdateHandler, this.mModelManager.getWritingToolManager(), getComposerModel());
        initNote(bundle == null);
        this.mBackgroundTaskManager.startPageManagerInitTask(spenWNote, getPageManager());
        this.mHandoffManager.init(activity, this.mControllerManager, this.mComposerModel, this.mModelManager, this.mDialogPresenterManager, this.mComposerControllerManager.getCvPageSettingController());
        initView();
    }

    public void insertNewPageByCurrentPage(int i) {
        this.mModelManager.getNoteManager().insertNewPageByCurrentPage(i);
        this.mComposerControllerManager.getScrollController().goToPage(i + 1);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void insertPage(int i) {
        this.mModelManager.getNoteManager().insertPage(i);
        this.mComposerControllerManager.getScrollController().goToPage(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public boolean isActionLinkEnabled() {
        if (this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            return false;
        }
        boolean zIsActionLinkEnabled = FeatureInfo.isActionLinkEnabled(this.mActivity);
        boolean zCanUseSpen = ComposerSpenUtils.canUseSpen(this.mActivity);
        Logger.m10999d(TAG, "initActionLinkEnabled # isActionLinkEnabled:" + zIsActionLinkEnabled + ", canUseSpen:" + zCanUseSpen);
        return zIsActionLinkEnabled && zCanUseSpen;
    }

    public boolean isBackgroundColorInverted() {
        return this.mModelManager.getNoteManager().isBackgroundColorInverted();
    }

    public boolean isBackgroundDarkTheme() {
        return BackgroundColorUtil.isBackgroundDarkTheme(this.mActivity, getBackgroundColor(), isBackgroundColorInverted(), hasBackgroundImage());
    }

    public boolean isComposerViewDarkTheme() {
        return BackgroundColorUtil.isComposerViewDarkTheme(this.mActivity, getBackgroundColor(), isBackgroundColorInverted(), hasBackgroundImage());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public boolean isCtrlPressedLast() {
        return this.mListenerManager.isCtrlPressedLast();
    }

    public boolean isEasyWritingPadEnabled() {
        ComposerViewContract.IView iView = this.mView;
        return iView != null && iView.isEasyWritingPadEnabled();
    }

    public boolean isEdgeState(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            return iView.isEdgeState(z);
        }
        return false;
    }

    public boolean isFocusable() {
        ComposerViewContract.IView iView = this.mView;
        return iView != null && iView.getView().isFocusable();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public boolean isHyperTextEnabled() {
        if (this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            return false;
        }
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public boolean isLockedScreen() {
        if (this.mControllerManager.getProgressController() == null) {
            return false;
        }
        return this.mControllerManager.getProgressController().isLockedScreen();
    }

    public boolean isOverlappingWithFragment() {
        Activity activity = this.mActivity;
        return activity == null || !(activity instanceof FragmentActivity) || ((FragmentActivity) activity).getSupportFragmentManager().getFragments().size() > 1;
    }

    public boolean isZoomLocked() {
        ComposerViewContract.IView iView = this.mView;
        return iView != null && iView.isZoomLocked();
    }

    public void notifyConfigurationChanged(Configuration configuration, boolean z) {
        List<ObserverConfigurationChanged> list = this.mConfigurationObserverList;
        if (list == null) {
            return;
        }
        for (ObserverConfigurationChanged observerConfigurationChanged : list) {
            if (observerConfigurationChanged != null) {
                observerConfigurationChanged.onConfigurationChanged(configuration, z);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void onAlignmentProgress(boolean z) {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.onAlignmentProgress(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void onAlignmentRunning(boolean z) {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.onAlignmentRunning(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void onAlignmentUpdateResult(ArrayList<RectF> arrayList) {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.onAlignmentUpdateResult(arrayList);
        }
    }

    public boolean onBackPressed() {
        String str = TAG;
        Logger.m10999d(str, "onBackPressed");
        if (this.mModelManager.getWritingToolManager().cancelConvertToText()) {
            Logger.m11003i(str, "onBackPressed# cancel ConvertToText");
            return true;
        }
        if (this.mComposerModel.getModeManager().isMode(Mode.Writing) && this.mModelManager.getWritingToolManager().cancel()) {
            Logger.m11003i(str, "onBackPressed# cancel Alignment");
            return true;
        }
        if (isLockedScreen()) {
            Logger.m10999d(str, "onBackPressed : Progress is running. return");
            return true;
        }
        if (this.mComposerControllerManager.getComposerSelectionController().clearSelection()) {
            return true;
        }
        return this.mControllerManager.getClipboardController().onBackPressed();
    }

    public void onChangeMode(ModeManager modeManager) {
        this.mComposerControllerManager.getComposerModeController().onChangeMode(modeManager, this.mActivity, this.mHwToolbarPresenter);
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateNextFocusForward(modeManager.isMode(Mode.Search));
        }
        if (modeManager.isMode(Mode.ReadOnly)) {
            updateLaserPenState();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void onConfigurationChanged(Configuration configuration, boolean z) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mModelManager.onConfigurationChanged(activity);
        }
        if (this.mComposerControllerManager.getCvPageSettingController() != null) {
            this.mComposerControllerManager.getCvPageSettingController().onConfigurationChanged(configuration, z);
        }
        notifyConfigurationChanged(configuration, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void onConvertToTextRunning(boolean z) {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.onConvertToTextRunning(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onDeletedPages(List<Integer> list, PageManager.PageUpdateState pageUpdateState) {
        if (this.mView == null) {
            return;
        }
        Logger.m10999d(TAG, "onDeletedPages#");
        this.mThumbnailUpdateHandler.onDeletedPages(pageUpdateState.getPageIdList());
        this.mView.onChangedPageCount(this.mSpenWNote.getPageCount());
    }

    public void onDestroy() {
        getPageManager().setDestroyFlag();
        if (this.mSpenWNote != null) {
            this.mBackgroundTaskManager.stop();
            ComposerViewContract.IView iView = this.mView;
            if (iView != null) {
                this.mListenerManager.releaseSpenComposerViewListener(iView);
            }
            this.mComposerControllerManager.getComposerModeController().release();
            releaseView(true, false);
        }
        if (this.mIsInitialized) {
            this.mModelManager.getNoteManager().getNotePdfData().clearHavingPdf();
            this.mComposerControllerManager.getComposerModeController().stopParsingHyperText();
            getPageManager().saveCacheToFile(this.mSpenWNote);
            if (!getPageManager().isSkipToSaveCache()) {
                this.mModelManager.getRecentSearchKeywordManager().save();
            }
            this.mThumbnailUpdateHandler.removeCallbacksAndMessages(null);
            this.mThumbnailUpdateHandler.release();
            this.mListenerManager.removeSpenObjectEventListener(this.mModelManager.getTextManager().getSpenObjectListener());
            this.mListenerManager.onDestroy();
        }
        this.mHandoffManager.release();
        this.mModelManager.getNoteManager().release();
        this.mSpenWNote = null;
        List<ObserverConfigurationChanged> list = this.mConfigurationObserverList;
        if (list != null) {
            list.clear();
            this.mConfigurationObserverList = null;
        }
    }

    public void onDetachView() {
        String str = TAG;
        Logger.m10999d(str, "onDetachView");
        if (this.mControllerManager.getTaskController() != null) {
            this.mControllerManager.getTaskController().onDetachView();
        }
        this.mComposerControllerManager.getComposerModeController().release();
        if (this.mSpenWNote == null) {
            return;
        }
        clearWritingToolControl();
        releaseView(true, true);
        this.mModelManager.getObjectManager().release();
        ThumbnailUpdateHandler thumbnailUpdateHandler = this.mThumbnailUpdateHandler;
        if (thumbnailUpdateHandler != null) {
            thumbnailUpdateHandler.release();
        }
        Logger.m10999d(str, "onDetachView end");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void onInAppCollaborationCloseButtonClicked() {
        ComposerViewContract.InAppContract inAppContract = this.mInAppPresenter;
        if (inAppContract != null) {
            inAppContract.onInAppCollaborationCloseButtonClicked();
        }
    }

    public void onInAppCollaborationModeChanged(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.onInAppCollaborationModeChanged(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void onInitLayoutFinished() {
        OnInitFinishedListener onInitFinishedListener = this.mOnInitFinishedListener;
        if (onInitFinishedListener != null) {
            onInitFinishedListener.onInitLayoutFinished();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onInsertedPages(PageManager.PageUpdateState pageUpdateState) {
        Logger.m10999d(TAG, "onInsertedPages#");
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.onChangedPageCount(this.mSpenWNote.getPageCount());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void onPageCountChanged(int i) {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.onPageCountChanged();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void onPageIndexChanged(int i) {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.onPageIndexChanged();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void onPageLayoutChanged() {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            hWToolbarContract.onPageLayoutChanged();
        }
    }

    public void onPause() {
        this.mComposerControllerManager.getCompSipController().releaseKeyboardRunnable();
    }

    public void onProvideAssistContent(@NonNull Activity activity, AssistContent assistContent) {
        if (activity.getIntent() == null) {
            return;
        }
        String strBuild = new ProvideAssist().setPdfManager(this.mModelManager.getPdfManager()).setUri(activity.getIntent().getData()).build(activity);
        if (TextUtils.isEmpty(strBuild)) {
            return;
        }
        assistContent.setStructuredData(strBuild);
    }

    public void onResume() {
        if (this.mActivity == null) {
            return;
        }
        this.mHandoffManager.updatePendingStateFromHandoff();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        SavedState savedState = new SavedState();
        if (!needToSkipSelectedBodyText()) {
            this.mModelManager.getObjectManager().getSelectedObjectManager().saveState(savedState);
        }
        this.mModelManager.getObjectManager().getSelectedObjectManager().saveState(savedState);
        savedState.setPrevNightMode(ContextUtils.isNightMode(this.mActivity));
        bundle.putParcelable(SavedState.KEY, savedState);
        if (this.mSpenWNote != null) {
            getPageManager().saveCacheToFile(this.mSpenWNote);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void onScroll(PagePanInfo pagePanInfo, float f, int i) {
        this.mComposerControllerManager.getScrollController().onScroll(pagePanInfo, f, i);
    }

    public boolean onTouchOutside() {
        ComposerViewContract.HWToolbarContract hWToolbarContract = this.mHwToolbarPresenter;
        if (hWToolbarContract != null) {
            return hWToolbarContract.onTouchOutside();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onUpdatePage(int i, int i2, int i4, PageManager.PageUpdateState pageUpdateState) {
        AbstractC8014b.m7221w(AbstractC0622a.m1173s(i, i2, "onUpdatePage# action : ", " ", " - "), TAG, i4);
    }

    public void onWindowFocusChanged(boolean z) {
        if (!this.mIsInitialized || this.mView == null || this.mActivity == null) {
            return;
        }
        if (!z) {
            this.mComposerControllerManager.getCompSipController().updateClipboardFilter(true, "onWindowFocusChanged#!hasFocus");
            return;
        }
        this.mComposerControllerManager.getCompSipController().updateClipboardFilter(false, "onWindowFocusChanged#hasFocus");
        this.mComposerControllerManager.getCompSipController().onGetWindowFocus(this.mActivity);
        setSoftInputMode();
        Logger.m11004w(TAG, "onWindowFocusChanged# " + this.mActivity.hashCode() + " " + this.mActivity.getCurrentFocus());
    }

    public void onWindowModeChanged(int i) {
        Logger.m11004w(TAG, "onWindowModeChanged# " + i);
        this.mWindowMode = i;
        setSoftInputMode();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void pauseCoEdit(String str, Runnable runnable) {
        this.mComposerModel.getCoeditAdapter().pauseCoedit(str, new RunnableC8515c(this, runnable, 22));
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return this.mHandler.postDelayed(runnable, j);
    }

    public void redo() {
        if (canUndoRedo()) {
            this.mUndoRedoPresenter.redo();
        }
    }

    public void releaseOldView(boolean z) {
        ComposerViewContract.IView iView = this.mOldView;
        if (iView == null) {
            return;
        }
        iView.release(z);
        this.mOldView = null;
    }

    public void releaseView(boolean z, boolean z2) {
        if (this.mView == null) {
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mComposerControllerManager.getCompSipController().releaseKeyboardRunnable();
        this.mHandoffManager.getHandler().removeMessages(1);
        if (z2 && this.mControllerManager.getTaskController().isKeepTaskDuringActivityRecreation()) {
            Logger.m10999d(TAG, "releaseView# keep old composer view");
            this.mOldView = this.mView;
            this.mControllerManager.getTaskController().addPendingJob(new RunnableC0116a(13, this, z), 2);
        } else {
            releaseManager();
            this.mComposerControllerManager.onDetachView();
            this.mView.release(z);
            this.mView = null;
            releaseOldView(z);
        }
    }

    public void removeConfigurationObserverChanged(ObserverConfigurationChanged observerConfigurationChanged) {
        List<ObserverConfigurationChanged> list = this.mConfigurationObserverList;
        if (list != null) {
            list.remove(observerConfigurationChanged);
        }
    }

    public void requestCancelTouch() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.requestCancelTouch();
        }
    }

    public void requestFocus() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.getView().requestFocus();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void requestReadyForSave() {
        ComposerViewContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.requestReadyForSave();
    }

    public void requestResetZoomScaleToDefault() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.requestResetZoomScaleToDefault();
        }
    }

    public void restoreBeforeSmoothScrollAndScaleToFitPage(Runnable runnable) {
        ComposerViewContract.IView iView = this.mView;
        if (iView == null) {
            Logger.m11000e(TAG, "restoreBeforeSmoothScrollAndScaleToFitPage# mView is null");
        } else {
            iView.restoreBeforeSmoothScrollAndScaleToFitPage(runnable);
        }
    }

    public void restoreState(Bundle bundle) {
        SavedState savedState = (SavedState) bundle.getParcelable(SavedState.KEY);
        if (savedState == null) {
            Logger.m10999d(TAG, "restoreState# savedState  is null ");
            return;
        }
        if (this.mComposerModel.getModeManager().isEditMode() && ContextUtils.isNightMode(this.mActivity) && !savedState.getPrevNightMode()) {
            toastDarkModeNotApplied(getInvertBackgroundColorType());
        }
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager == null || controllerManager.getTaskController() == null || this.mControllerManager.getTaskController().isAvailableToSave()) {
            this.mModelManager.getObjectManager().getSelectedObjectManager().restoreState(savedState);
        } else {
            Logger.m11000e(TAG, "restoreState# TaskController is running and isAvailableToSave() is false.");
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void resumeCoEdit(String str) {
        this.mComposerModel.getCoeditAdapter().resumeCoedit(str);
    }

    public void setAiMenuManager(ComposerViewContract.AiMenuManagerContract aiMenuManagerContract) {
        this.mAiMenuManager = aiMenuManagerContract;
    }

    public void setAllwaysFitPageToScreen(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setAllwaysFitPageToScreen(z);
        }
    }

    public void setAutoScrollEnabled(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setAutoScrollEnabled(z);
        }
    }

    public void setContainerControllers(ControllerManager controllerManager, ComposerViewContract.IDialogManager iDialogManager, ComposerModel composerModel, OnInitFinishedListener onInitFinishedListener) {
        this.mControllerManager = controllerManager;
        this.mViewState = controllerManager.getViewState();
        this.mDialogPresenterManager = iDialogManager;
        this.mComposerModel = composerModel;
        this.mOnInitFinishedListener = onInitFinishedListener;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IPresenter
    public void setContextMenu(boolean z) {
        if (this.mView == null) {
            return;
        }
        AbstractC8014b.m7224z("setContextMenu# ", TAG, z);
        if (z) {
            this.mView.startActionMode();
        } else {
            this.mView.stopActionMode();
        }
    }

    public void setContextMenuDelegate(boolean z, SpenContextMenuDelegateListener spenContextMenuDelegateListener) {
        if (this.mView != null) {
            this.mListenerManager.setSpenContextMenuDelegateListener(spenContextMenuDelegateListener);
            this.mView.setContextMenuDelegate(z);
        }
    }

    public void setEasyWritingPadEnabled(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setEasyWritingPadEnabled(z);
        }
    }

    public void setFocusable(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.getView().setFocusable(z);
            this.mView.getView().setFocusableInTouchMode(z);
        }
    }

    public void setForceShowKeyboard() {
        Logger.m11003i(TAG, "showSoftInput with force show keyboard");
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() < 60000) {
            return;
        }
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).sendAppPrivateCommand(getView(), DirectWriteConstant.DIRECT_WRITE_FORCE_SHOW_KEYBOARD, null);
    }

    public void setFullScreenModeOn() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setFullScreenModeOn();
        }
    }

    public void setHwToolbarPresenter(ComposerViewContract.HWToolbarContract hWToolbarContract) {
        this.mHwToolbarPresenter = hWToolbarContract;
    }

    public void setInAppPresenter(ComposerViewContract.InAppContract inAppContract) {
        this.mInAppPresenter = inAppContract;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void setInputFormEnabled(boolean z) {
        if (z) {
            getWritingToolManager().setInputFormEnabled();
        }
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setInputFormEnabled(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void setLaserPen(boolean z, LaserPenInfo laserPenInfo) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setLaserPen(z, laserPenInfo);
            if (z) {
                getWritingToolManager().setToolTypeAction(2, 18);
                getWritingToolManager().setToolTypeAction(6, 0);
            }
        }
    }

    public void setPageBackgroundColor(boolean z) {
        if (z != getPageManager().getDocPageInfo().isEnabledDarkTheme()) {
            getPageManager().getDocPageInfo().setDarkTheme(z);
            if (this.mBackgroundTaskManager.isRunningPageInfoInitTask()) {
                return;
            }
            getThumbnailUpdateHandler().updateThumbnailAll();
        }
    }

    public void setRtTableAndCellStylePresenter(ComposerViewContract.RtTableAndCellStyleContract rtTableAndCellStyleContract) {
        this.mRtTableAndCellStylePresenter = rtTableAndCellStyleContract;
    }

    public void setScrollingEnabled(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setScrollingEnabled(z);
        }
    }

    public void setSoftInputMode() {
        int i = Build.VERSION.SDK_INT;
        if (i > 33) {
            if (!this.mComposerControllerManager.getCompSipController().isKeyboardShowing(getActivity())) {
                this.mComposerControllerManager.getCompSipController().setSIPInputModeHidden(getActivity(), false, this.mWindowMode);
                return;
            } else if (!this.mComposerModel.getComposerState().getIsExceptionalSIPStateHiddenOnUos()) {
                this.mComposerControllerManager.getCompSipController().setSIPInputModeHidden(getActivity(), true, this.mWindowMode);
                return;
            }
        }
        if (i > 30) {
            this.mComposerControllerManager.getCompSipController().setSIPInputModeHidden(getActivity(), false, this.mWindowMode);
            getComposerModel().getComposerState().setIsExceptionalSIPStateHiddenOnUos(false);
        }
    }

    public void setTableAndCellPresenter(ComposerViewContract.TableAndCellContract tableAndCellContract) {
        this.mTableAndCellPresenter = tableAndCellContract;
    }

    public void setTagList(List<String> list) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setTagList(list);
        }
    }

    public void setTlToolbarPresenter(TlToolbarPresenter tlToolbarPresenter) {
        this.mTlToolbarPresenter = tlToolbarPresenter;
    }

    public void setToolbarPosition(Rect rect, boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setToolbarPosition(rect, z);
        }
        hideAiSuggestionView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void setView(ComposerViewContract.IView iView) {
        Logger.m10999d(TAG, "setView# " + hashCode() + " " + iView);
        this.mView = iView;
    }

    public void setViewBackgroundColor(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView == null) {
            Logger.m11004w(TAG, "setViewBackgroundColor# mView is null");
        } else {
            iView.initBackgroundColor(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
    public void setWritingGuideLineEnabled(boolean z) {
        if (!FeatureInfo.isHandwritingHelpEnabled(this.mActivity)) {
            Logger.m11003i(TAG, "setWritingGuideLineEnabled# Assistance Not Supported");
            return;
        }
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setWritingGuideLineEnabled(z);
        }
    }

    public void setZoomLock(boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setZoomLock(z);
        }
    }

    public void setZoomRunnableAfterZoom(Runnable runnable) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.setZoomRunnableAfterZoom(runnable);
        }
    }

    public void showLockCanvasToolTip() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.showLockCanvasToolTip();
        }
    }

    public void showProgress(int i, int i2) {
        this.mHandler.post(new RunnableC0117b(this, i, i2, 5));
    }

    public void smoothScrollAndScaleToFitPage(int i, Runnable runnable, int i2) {
        if (this.mView == null) {
            Logger.m11000e(TAG, "smoothScrollAndScaleToFitPage# mView is null");
            return;
        }
        getHandler().removeCallbacks(this.mRunnableSmoothScrollAndScaleToFitPage);
        if (i2 <= 0) {
            this.mView.smoothScrollAndScaleToFitPage(i, runnable);
        } else {
            this.mRunnableSmoothScrollAndScaleToFitPage = new RunnableC0101a(this, i, runnable, 12);
            getHandler().postDelayed(this.mRunnableSmoothScrollAndScaleToFitPage, i2);
        }
    }

    public void smoothScrollAndScaleToFitRect(RectF rectF, Runnable runnable) {
        ComposerViewContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.smoothScrollAndScaleToFitRect(rectF, runnable);
    }

    public void smoothScrollToPage(int i) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.smoothScrollToPage(i);
        }
    }

    public void startContinuousChange() {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.startContinuousChange();
        }
    }

    public void startStickyMemoIconAnimation(SpenStickyNote spenStickyNote, boolean z) {
        ComposerViewContract.IView iView = this.mView;
        if (iView != null) {
            iView.startStickyMemoIconAnimation(spenStickyNote, z);
        }
    }

    public void undo() {
        if (canUndoRedo()) {
            this.mUndoRedoPresenter.undo();
        }
    }

    public void updateBodyTextPage() {
        if (this.mView == null) {
            return;
        }
        this.mModelManager.getNoteManager().updateBodyTextPage();
    }

    public void updateDisallowTouchDownArea(boolean z) {
        if (this.mView == null || this.mActivity == null) {
            return;
        }
        this.mComposerControllerManager.getComposerModeController().updateDisallowTouchDownArea(z, this.mActivity);
    }

    public boolean updateSpenOnlyModeWithPreference(boolean z) {
        boolean z2 = false;
        if (!this.mIsInitialized || this.mView == null || this.mActivity == null || !z || !this.mViewState.isResumed() || this.mComposerModel.getModeManager().isMode(Mode.View)) {
            return false;
        }
        boolean zCanUseSpen = ComposerSpenUtils.canUseSpen(this.mActivity);
        if (zCanUseSpen) {
            boolean zIsSpenOnlyMode = getWritingToolManager().isSpenOnlyMode();
            if (this.mComposerModel.isLastSpenOnlyMode() != zIsSpenOnlyMode) {
                AbstractC8014b.m7220v("onWindowFocusChanged update# currentSpenOnlyMode : ", TAG, zIsSpenOnlyMode);
                this.mComposerModel.setLastSpenOnlyMode(zIsSpenOnlyMode);
                getWritingToolManager().setSpenOnlyMode(zIsSpenOnlyMode);
                z2 = true;
            }
        } else if (ComposerSpenUtils.isSpenSupportChangeable() && !this.mComposerModel.getModeManager().isMoveOnlyMode()) {
            getWritingToolManager().setToolTypeAction(2, getWritingToolManager().getToolTypeAction(2));
        }
        Boolean bool = this.mLastIsAbleToUseSpen;
        boolean z3 = (bool == null || bool.booleanValue() == zCanUseSpen) ? z2 : true;
        this.mLastIsAbleToUseSpen = Boolean.valueOf(zCanUseSpen);
        return z3;
    }

    public void init(Activity activity, SpenWNote spenWNote, boolean z) {
        this.mActivity = activity;
        this.mSpenWNote = spenWNote;
        if (z) {
            this.mThumbnailUpdateHandler.release();
            this.mComposerControllerManager.getComposerModeController().stopParsingHyperText();
            this.mModelManager.getNoteManager().getNotePdfData().clearNoteKey();
            this.mBackgroundTaskManager.startPageManagerInitTask(spenWNote, getPageManager());
            if (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
                this.mModelManager.getPageManager().getDocPageInfo().fixInvalidInfo(spenWNote);
            }
            initNote(true);
        }
        this.mHandoffManager.init(activity, spenWNote);
        initView();
    }
}
