package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import androidx.core.graphics.ColorUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface;
import com.samsung.android.sdk.pen.text.SpenTextScaleListener;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.DVFSHelperCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.CollectionHelper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenComposerSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.Callback;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TextOnlyModeState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.handwriting.LaserPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.PageMoveButton;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ScrollZoomManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.SpenComposerWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerView implements ComposerViewContract.IView, View.OnLayoutChangeListener {
    private static final boolean DEBUG_TO_DISABLE_SPEN_COMPOSER = false;
    private static final String TAG = Logger.createTag("ComposerView");
    protected Activity mActivity;
    private float mAppWidth;
    private ComposerViewMenuManager mComposerViewMenuManager;
    private DVFSHelperCompat mDVFSHelperForSpenFling;
    private SpenWNote mDoc;
    private FullScreenButtonView mFullScreenBtn;
    private InAppCollaborationButtonView mInAppCollaborationButtonView;
    protected boolean mIsToolbarChangeable;
    private ListenerManager mListenerManager;
    private PageMoveButton mPageMoveButton;
    private View mParent;
    private ComposerViewContract.IPresenter mPresenter;
    protected ScrollZoomManager mScrollZoomManager;
    private Runnable mSmoothScrollEndRunnable;
    protected SpenComposerWrapper mView;
    protected final FlashViewManager mFlashViewManager = new FlashViewManager();
    private final AnimationViewManager mAnimationViewManager = new AnimationViewManager();
    private final ComposerViewState mComposerViewState = new ComposerViewState();

    public ComposerView(Activity activity, @NonNull Config config) {
        this.mIsToolbarChangeable = config.isToolbarChangeable();
        composerViewConstruct(activity, config.isWritingOnlyType());
    }

    private void composerViewConstruct(Activity activity, boolean z) {
        initSdk(activity);
        Logger.m10999d(TAG, "ComposerView# isWritingOnly" + z);
        this.mView = new SpenComposerWrapper(activity, z ? 2 : 1);
        if (DeviceInfo.isVSTModel()) {
            this.mView.setVSTEnabled(true);
            this.mView.requestKeepPageFitToScreenWhenPageFit();
        }
        setSpenDvfsInterface(activity);
        this.mActivity = activity;
        this.mListenerManager = new ListenerManager(this.mView, this.mAnimationViewManager);
        this.mScrollZoomManager = new ScrollZoomManager(this.mComposerViewState);
        this.mComposerViewMenuManager = new ComposerViewMenuManager(this.mComposerViewState);
    }

    private void initActionLinkEnabled() {
        this.mView.setActionLinkEnabled(this.mPresenter.isActionLinkEnabled());
    }

    private void initFeatureEnable() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null || spenComposerWrapper.getTextManager() == null) {
            return;
        }
        ISpenNoteTextManager textManager = this.mView.getTextManager();
        boolean zIsHyperTextEnabled = this.mPresenter.isHyperTextEnabled();
        textManager.setHyperTextEnabled(zIsHyperTextEnabled);
        boolean z = !SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel();
        textManager.setDoubleTapSelectionEnabled(z);
        boolean z2 = FeatureInfo.isHashTagFeatureEnabled() && !this.mPresenter.getComposerModel().getMdeInfo().isMde();
        textManager.setHashTagEnabled(z2);
        AbstractC8014b.m7215q(AbstractC2821a.m2230u("initFeatureEnable: isHyperTextEnabled= ", " isDoubleTapSelectionEnabled= ", " isHashTagEnabled= ", zIsHyperTextEnabled, z), z2, TAG);
        initActionLinkEnabled();
    }

    private void initSdk(Context context) {
        try {
            SpenSdkInitializer.initialize(context);
            SpenComposerSdkInitializer.initialize(context);
        } catch (Exception e) {
            Logger.m11001e(TAG, "initSdk# " + e.getMessage(), e);
        }
    }

    private void makeFullScreenBtn() {
        FullScreenButtonView fullScreenButtonView = new FullScreenButtonView(this.mActivity.findViewById(C9086R.id.comp_full_screen_btn));
        this.mFullScreenBtn = fullScreenButtonView;
        fullScreenButtonView.init(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m11003i(ComposerView.TAG, "mFullScreenBtn onClick");
                ComposerView.this.mView.requestKeepPageFitToScreenWhenPageFit();
                FullScreenButtonView fullScreenButtonView2 = ComposerView.this.mFullScreenBtn;
                ComposerView composerView = ComposerView.this;
                fullScreenButtonView2.changeFullScreenMode(composerView.mActivity, composerView.mPresenter.getComposerModel().getComposerState(), ComposerView.this.mPresenter.getHWToolbarPresenter());
            }
        });
    }

    private void makeInAppCollaborationBtn() {
        InAppCollaborationButtonView inAppCollaborationButtonView = new InAppCollaborationButtonView((LinearLayout) this.mActivity.findViewById(C9086R.id.comp_in_app_collaboration_btn_container));
        this.mInAppCollaborationButtonView = inAppCollaborationButtonView;
        inAppCollaborationButtonView.init((AppCompatActivity) this.mActivity, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m11003i(ComposerView.TAG, "mFullScreenBtn onClick");
                ComposerView.this.mPresenter.onInAppCollaborationCloseButtonClicked();
            }
        });
    }

    private void makeMovePageBtn(ViewGroup viewGroup) {
        PageMoveButton pageMoveButton = new PageMoveButton();
        this.mPageMoveButton = pageMoveButton;
        pageMoveButton.init(viewGroup, this.mComposerViewState, new PageMoveButton.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.8
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageMoveButton.Contract
            public void goToPage(int i) {
                ComposerView.this.goToPage(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseComposerView(boolean z, boolean z2) {
        if (this.mView == null) {
            Logger.m11000e(TAG, "releaseComposerView# mView is null");
            return;
        }
        this.mComposerViewMenuManager.release();
        this.mView.getTextManager().setTextScaleListener(null);
        this.mScrollZoomManager.release();
        this.mComposerViewState.release();
        if (z) {
            requestReadyForSave();
        }
        this.mView.removeOnLayoutChangeListener(this);
        this.mListenerManager.release();
        this.mView.setDocument(null);
        this.mView.close();
        if (z2) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        releaseGuideTextView();
        DVFSHelperCompat dVFSHelperCompat = this.mDVFSHelperForSpenFling;
        if (dVFSHelperCompat != null) {
            dVFSHelperCompat.release();
            this.mDVFSHelperForSpenFling = null;
        }
        this.mView = null;
    }

    private void releaseGuideTextView() {
        View viewFindViewById = this.mParent.findViewById(C9086R.id.guide_text_view);
        if (viewFindViewById instanceof GuideTextView) {
            ((GuideTextView) viewFindViewById).release();
        }
    }

    private void setColorTheme(int i) {
        AbstractC0000a.m3D(i, "setColorTheme# ", TAG);
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setColorTheme(i);
        }
    }

    private void setDarkModeEnabled(boolean z) {
        AbstractC8014b.m7220v("setViewBackgroundColor# ", TAG, z);
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setDarkModeEnabled(z);
        }
    }

    private void setFadingEdgeColor(boolean z) {
        int backgroundColor = this.mDoc.getPage(0).getBackgroundColor();
        if (!z) {
            this.mView.setFadingEdgeColor(backgroundColor);
        } else {
            this.mView.setFadingEdgeColor(ColorUtils.blendARGB(BackgroundColorUtil.getBlackColor(this.mView.getContext()), -16777216, 0.1f));
        }
    }

    private void updateAppHeight() {
        if (Features.isSupportSimpleComposerForCoverDisplay()) {
            int heightPx = (int) DisplayUtils.getHeightPx(this.mParent.getContext());
            int iHeight = DisplayUtils.getScreenSize(this.mParent.getContext()).height();
            AbstractC8014b.m7216r(heightPx, iHeight, "updateAppHeight# appHeight : ", ", screenHeight : ", TAG);
            this.mScrollZoomManager.setGoToTopCovered(heightPx == iHeight);
        }
    }

    private void updateToolbarChangeableMode() {
        if (this.mIsToolbarChangeable) {
            boolean zIsFullScreenMode = this.mPresenter.getComposerModel().getComposerState().isFullScreenMode();
            boolean zIsInAppCollaborationMode = this.mPresenter.getComposerModel().getComposerState().isInAppCollaborationMode();
            if (zIsFullScreenMode) {
                this.mFullScreenBtn.updateFullScreen(this.mActivity, true);
            } else if (zIsInAppCollaborationMode) {
                this.mInAppCollaborationButtonView.updateInAppCollaborationMode(this.mActivity, true);
            } else {
                this.mFullScreenBtn.updateFullScreen(this.mActivity, false);
                this.mInAppCollaborationButtonView.updateInAppCollaborationMode(this.mActivity, false);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void alignmentContent(int i) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.requestAlignmentContent(i);
        }
    }

    public void attachView(ViewGroup viewGroup) {
        this.mParent = viewGroup;
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setClickable(true);
            this.mView.setFocusable(true);
            this.mView.setFocusableInTouchMode(true);
            this.mView.setNextFocusForwardId(C9086R.id.toolbar);
            this.mView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mFlashViewManager.init(viewGroup);
            initAttr();
            viewGroup.removeView(this.mView);
            this.mView.setTag(ComposerConstants.SPEN_COMPOSER_VIEW_TAG);
            viewGroup.addView(this.mView, 0);
            this.mView.getConvertToTextManager().setCanvasLayout(viewGroup);
            this.mAnimationViewManager.init(viewGroup);
            ViewCompat.getInstance().setAutoHandwritingEnabled(this.mView, false);
            if (DeviceInfo.isVSTModel()) {
                ViewCompat.getInstance().semClearUiDescriptors(this.mView);
            }
            this.mView.initFadingEdgeHelper();
            this.mView.setFadingEdgeScrollInfoProvider(this.mScrollZoomManager);
        }
        this.mScrollZoomManager.onAttachedView(viewGroup);
        this.mComposerViewMenuManager.onAttached(viewGroup);
        makeFullScreenBtn();
        makeInAppCollaborationBtn();
        makeMovePageBtn(viewGroup);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void cancelSearch() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.cancelSearch();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public Bitmap captureCurrentView() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return null;
        }
        return spenComposerWrapper.captureCurrentView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void clearSearch() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.clearSearch();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void clearSmoothScrollAndScaleToFitPage() {
        if (this.mView != null) {
            Logger.m11003i(TAG, "clearSmoothScrollAndScaleToFitPage : ");
            this.mSmoothScrollEndRunnable = null;
            this.mComposerViewState.clearSnapShotSmoothScrollData();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void clearZoomRunnableAfterZoom() {
        this.mScrollZoomManager.clearZoomRunnableAfterZoom();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void endContinuousChange() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.getNoteZoomScroller().endContinuousChange();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void executeWorkThreadFromCoedit(boolean z) {
        if (this.mView == null) {
            return;
        }
        AbstractC8014b.m7224z("executeWorkThreadFromCoedit# isExecute = ", TAG, z);
        if (z) {
            this.mView.startLazyViewUpdate();
        } else {
            this.mView.endLazyViewUpdate();
        }
    }

    public SpenComposer getComposerView() {
        return this.mView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    @NonNull
    public PointF getDelta() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return new PointF();
        }
        PointF delta = spenComposerWrapper.getNoteZoomScroller().getDelta();
        return delta == null ? new PointF() : delta;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IView
    public ListenerImplContract.IViewListenerManager getListenerManager() {
        return this.mListenerManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public int getPageIndex(RectF rectF) {
        return this.mScrollZoomManager.getPageIndex(rectF);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public PointF getPan() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return null;
        }
        return spenComposerWrapper.getNoteZoomScroller().getPan();
    }

    public ViewGroup getQTContainView() {
        return (ViewGroup) this.mActivity.findViewById(C9086R.id.qt_container);
    }

    public View getQTCoverView() {
        return this.mActivity.findViewById(C9086R.id.cover_qt_container);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public float getScale() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return 1.0f;
        }
        return this.mView.getNoteZoomScroller().getZoomScale() * spenComposerWrapper.getNoteZoomScroller().getContentScale();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public int getScrollingDirection() {
        return !this.mComposerViewState.isVertical() ? 1 : 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public View getView() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        return spenComposerWrapper != null ? spenComposerWrapper : this.mParent;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public View getViewShowPopup() {
        View viewFindViewById = this.mActivity.findViewById(C9086R.id.composer_fragment_content);
        return viewFindViewById != null ? viewFindViewById : getView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void goToPage(int i) {
        if (this.mView != null) {
            ComposerViewContract.IPresenter iPresenter = this.mPresenter;
            if (iPresenter != null) {
                iPresenter.clearWritingToolControl();
            }
            this.mView.goToPage(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IView
    public void hideCover() {
        this.mFlashViewManager.hideCover();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void init(SpenWNote spenWNote) {
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        Logger.startTime(strValueOf, str, "init# start");
        this.mDoc = spenWNote;
        initFeatureEnable();
        if (this.mView != null) {
            initBackgroundColor(BackgroundColorUtil.isComposerViewDarkTheme(this.mActivity, spenWNote.getPage(0).getBackgroundColor(), spenWNote.isBackgroundColorInverted(), BackgroundColorUtil.hasBackgroundImage(spenWNote.getPageList())));
            this.mView.setDocument(spenWNote);
            this.mView.requestFocus();
            this.mView.addOnLayoutChangeListener(this);
        }
        this.mComposerViewState.setComposerMode(1);
        updateToolbarChangeableMode();
        updateAppHeight();
        Logger.endTime(String.valueOf(hashCode()), str, "init# end");
    }

    public void initAttr() {
        if (this.mView != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            int color = this.mActivity.getColor(C9086R.color.composer_container_background);
            if (ContextUtils.isNightMode(this.mActivity)) {
                color = FloatingFeature.INSTANCE.getAntiGreenishColor();
            }
            if (DesktopModeCompat.INSTANCE.getInstance().isDexDualModeOnScreen(this.mActivity)) {
                color = ColorUtils.blendARGB(color, -16777216, 0.3f);
            }
            stateListDrawable.addState(new int[]{R.attr.background}, new ColorDrawable(color));
            stateListDrawable.addState(new int[]{R.attr.state_focused}, new ColorDrawable(color));
            stateListDrawable.addState(new int[]{-16842908}, new ColorDrawable(color));
            this.mView.setBackground(stateListDrawable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void initBackgroundColor(boolean z) {
        setDarkModeEnabled(ContextUtils.isNightMode(this.mActivity));
        setColorTheme(z ? 1 : 0);
        setFadingEdgeColor(z);
    }

    public void initGuideTextView() {
        View viewFindViewById = this.mParent.findViewById(C9086R.id.guide_text_view);
        if (viewFindViewById instanceof GuideTextView) {
            ((GuideTextView) viewFindViewById).init(this.mPresenter);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.IView
    public void initNoteManager(NoteManager noteManager) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        noteManager.setSpenNoteTextManager(spenComposerWrapper.getTextManager());
        noteManager.setSpenNotePageLayouter(this.mView.getNotePageLayouter());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.IView
    public void initObjectManager(ObjectManager objectManager) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        objectManager.setControlObject(spenComposerWrapper.getControlObjectManager());
        objectManager.setControlStyleInfoAsDefault();
        objectManager.setInserter(this.mView.getNoteObjectInserter());
        objectManager.setNoteZoomScroller(this.mView.getNoteZoomScroller());
        objectManager.setMathManager(this.mView.getMathManager());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.IView
    public void initPdfManager(PdfManager pdfManager) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        pdfManager.setSpenNotePdfManager(spenComposerWrapper.getNotePdfManager());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void initScrollManager() {
        Logger.m11003i(TAG, "initScrollManager#");
        this.mComposerViewMenuManager.init(this.mView, this.mDoc, this.mPresenter);
        this.mScrollZoomManager.init(this.mView, this.mDoc, new ScrollZoomManager.IComposerPresenter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public ComposerModel getComposerModel() {
                return ComposerView.this.mPresenter.getComposerModel();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public boolean isCtrlPressedLast() {
                return ComposerView.this.mPresenter.isCtrlPressedLast();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public boolean isScrollingEnabled() {
                return (ComposerView.this.isZoomLocked() || AiDrawingUtil.isPopupShowingState(ComposerView.this.mPresenter.getComposerModel().getComposerState().getAiDrawingState())) ? false : true;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public void onScroll(PagePanInfo pagePanInfo, float f, int i) {
                ComposerView.this.mPresenter.onScroll(pagePanInfo, f, i);
            }
        }, new ScrollZoomManager.IListenerManager() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IListenerManager
            public void addNoteZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
                ComposerView.this.mPresenter.getListenerManager().addNoteZoomScrollerListener(spenNoteZoomScrollerListener);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IListenerManager
            public void addZoomListener(SpenZoomListenerImpl.ZoomListener zoomListener) {
                ComposerView.this.mPresenter.getListenerManager().addZoomListener(zoomListener);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IListenerManager
            public void removeNoteZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
                ComposerView.this.mPresenter.getListenerManager().removeNoteZoomScrollerListener(spenNoteZoomScrollerListener);
            }
        }, new ScrollZoomManager.IGotoTopPresenter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.5
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IGotoTopPresenter
            public boolean canUpdate() {
                return !ComposerView.this.mPresenter.getComposerModel().getVoiceModel().isVoiceSyncPlaying();
            }
        });
        this.mScrollZoomManager.setOnGenericMotionListener(this.mActivity);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.IView
    public void initTextManager(TextManager textManager) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        textManager.setSpenTextManager(spenComposerWrapper.getTextManager());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.IView
    public void initWritingToolManager(WritingToolManager writingToolManager) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        writingToolManager.setManager(spenComposerWrapper.getNoteWritingViewManager()).setManager(this.mView.getConvertToTextManager()).setManager(this.mView.getAlignmentManager()).setManager(this.mView.getSTTManager()).setManager(this.mView.getHwrBeautifierManager()).initDone();
        writingToolManager.setSupportedSpenDisplay(SpenUtils.isSupportedSpenDisplay(this.mActivity));
        writingToolManager.setNotDexModeOrStandAloneMode(DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(this.mActivity));
    }

    public boolean isDisableComposerView() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public boolean isEasyWritingPadEnabled() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return false;
        }
        return spenComposerWrapper.isEasyWritingPadEnabled();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public boolean isEdgeState(boolean z) {
        Logger.m11003i(TAG, "isEdgeState y = " + this.mComposerViewState.getPanY());
        if (z && this.mComposerViewState.getPanY() <= 0.0f) {
            return true;
        }
        if (!z) {
            float panY = this.mComposerViewState.getPanY();
            RectF contentRectInView = this.mView.getNoteZoomScroller().getContentRectInView();
            if (contentRectInView != null) {
                panY = contentRectInView.bottom;
            }
            if (this.mComposerViewState.isVertical()) {
                return panY >= ((float) this.mPresenter.getComposerModel().getComposerSpenDocModel().getDocHeight(false));
            }
            if (panY >= this.mPresenter.getComposerModel().getComposerSpenDocModel().getPageHeight(this.mPresenter.getCurrentPageIndex())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public boolean isEnableTextOnlyMode() {
        if (this.mView == null) {
            return false;
        }
        return this.mComposerViewState.isOnTextOnlyMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public boolean isHyperTextEnabled() {
        ComposerViewContract.IPresenter iPresenter = this.mPresenter;
        if (iPresenter == null) {
            return false;
        }
        return iPresenter.isHyperTextEnabled();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public boolean isZoomLocked() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            return spenComposerWrapper.getGestureController().isOnFingerScrollAndScaleLocked();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void moveScroll(boolean z, boolean z2) {
        this.mScrollZoomManager.moveScroll(z, z2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void onChangedNoteType(boolean z) {
        this.mScrollZoomManager.onChangedNoteType(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void onChangedPageCount(int i) {
        this.mComposerViewState.updatePageCount(i);
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        boolean zIsSupportedSpenDisplay = SpenUtils.isSupportedSpenDisplay(configuration);
        Logger.m10999d(TAG, "onConfigurationChanged# isOrientationChanged:" + z + ", newSupportedSpenDisplay:" + zIsSupportedSpenDisplay);
        if (this.mPresenter.getComposerModel().checkSimpleModeStateAndReset() || this.mPresenter.getComposerModel().isSimpleMode()) {
            float widthPx = DisplayUtils.getWidthPx(this.mParent.getContext());
            if (widthPx != this.mAppWidth) {
                requestResetZoomScaleToDefault();
                this.mAppWidth = widthPx;
            }
        }
        this.mScrollZoomManager.onOrientationChanged(z);
        if (this.mPresenter.getWritingToolManager().isSupportedSpenDisplay() != zIsSupportedSpenDisplay) {
            this.mPresenter.getWritingToolManager().setSupportedSpenDisplay(zIsSupportedSpenDisplay);
            initActionLinkEnabled();
            this.mPresenter.getWritingToolManager().setToolTypeAction(2, this.mPresenter.getWritingToolManager().getToolTypeAction(2));
        }
        this.mPresenter.getWritingToolManager().setNotDexModeOrStandAloneMode(DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(this.mActivity));
        this.mPresenter.onConfigurationChanged(configuration, z);
        updateAppHeight();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void onInAppCollaborationModeChanged(boolean z) {
        this.mInAppCollaborationButtonView.onInAppCollaborationModeChanged(this.mActivity, z);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i8 - i6;
        int i11 = i4 - i;
        if (i10 != i11) {
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i10, i11, "onLayoutChange# beforeW: ", " newW: ", " contentScale#");
            sbM1173s.append(this.mView.getNoteZoomScroller().getContentScale());
            Logger.m10999d(str, sbM1173s.toString());
            this.mAppWidth = i11;
        }
    }

    public void onOptionsMenuPrepared() {
        if (this.mInAppCollaborationButtonView == null || !this.mPresenter.getComposerModel().getComposerState().isInAppCollaborationMode()) {
            return;
        }
        this.mInAppCollaborationButtonView.onOptionsMenuPrepared();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IView
    public void onSmoothScrollEnd() {
        Runnable runnable = this.mSmoothScrollEndRunnable;
        if (runnable != null) {
            this.mSmoothScrollEndRunnable = null;
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void onTextScaleChanged(float f) {
        this.mScrollZoomManager.onTextScaleChanged(f);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void pageScroll(boolean z) {
        this.mScrollZoomManager.pageScroll(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void pageZoom(boolean z) {
        this.mScrollZoomManager.pageZoom(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void release(boolean z) {
        release(z, false);
    }

    public void releaseAfterCapture(final Callback callback) {
        this.mDoc = null;
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        if (callback == null) {
            this.mFlashViewManager.showCaptureView(spenComposerWrapper, null);
            releaseComposerView(false, true);
        } else {
            this.mFlashViewManager.showCaptureView(this.mView, new Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.1
                @Override // com.samsung.android.support.senl.p148nt.composer.main.base.common.Callback
                public void onDone(@Nullable Object obj) {
                    ComposerView.this.releaseComposerView(false, true);
                    callback.onDone(obj);
                }
            });
        }
    }

    public void removeCaptureView() {
        this.mFlashViewManager.removeCaptureView(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.2
            @Override // java.lang.Runnable
            public void run() {
                ComposerView.this.mScrollZoomManager.setBlockToShowDecorView(false);
            }
        });
    }

    public void removeFromParent() {
        if (this.mView != null) {
            setEnableTextOnlyMode(false, 0.0f, null);
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void requestCancelTouch() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.requestCancelTouch();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void requestReadyForSave() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null || spenComposerWrapper.getNoteWritingViewManager() == null) {
            return;
        }
        this.mView.getTextManager().updateBodyTextPage();
        this.mView.getNoteWritingViewManager().requestReadyForSave();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void requestResetZoomScaleToDefault() {
        Logger.m10999d(TAG, "requestResetZoomScaleToDefault#");
        this.mView.requestResetZoomScaleToDefault();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void restoreBeforeSmoothScrollAndScaleToFitPage(Runnable runnable) {
        PointF pointF;
        if (this.mView == null) {
            return;
        }
        float zoomRatio = this.mComposerViewState.getSmoothScrollToLast().getZoomRatio();
        if (zoomRatio == 0.0f || Math.abs(zoomRatio - this.mComposerViewState.getZoomRatio()) < 0.01f) {
            Logger.m11003i(TAG, "restoreBeforeSmoothScrollAndScaleToFitPage skip : " + zoomRatio);
            this.mComposerViewState.clearSnapShotSmoothScrollData();
            runnable.run();
            return;
        }
        if (this.mPresenter.getCurrentPageIndex() == this.mComposerViewState.getSmoothScrollToLast().getPageIndex()) {
            pointF = new PointF(this.mComposerViewState.getSmoothScrollToLast().getPanX(), this.mComposerViewState.getSmoothScrollToLast().getPanY());
        } else {
            RectF contentRectInView = this.mView.getNoteZoomScroller().getContentRectInView();
            if (contentRectInView == null) {
                pointF = new PointF(this.mComposerViewState.getPanX(), this.mComposerViewState.getPanY());
            } else {
                pointF = new PointF(this.mComposerViewState.getPanX(), (contentRectInView.height() / 2.0f) + contentRectInView.top);
            }
        }
        boolean zSmoothScrollAndScaleTo = this.mView.smoothScrollAndScaleTo(pointF, this.mComposerViewState.getSmoothScrollToLast().getZoomRatio());
        AbstractC8014b.m7224z("restoreBeforeSmoothScrollAndScaleToFitPage : ", TAG, zSmoothScrollAndScaleTo);
        if (zSmoothScrollAndScaleTo) {
            this.mSmoothScrollEndRunnable = runnable;
        } else {
            this.mComposerViewState.clearSnapShotSmoothScrollData();
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public int search(String str, boolean z) {
        Logger.m10999d(TAG, "search# keyword length = " + Logger.getLength(str) + " / " + z);
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return 0;
        }
        return spenComposerWrapper.searchText(str, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public int searchBackward() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return 0;
        }
        return spenComposerWrapper.searchFocusPrev();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public int searchForward() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return 0;
        }
        return spenComposerWrapper.searchFocusNext();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setAllwaysFitPageToScreen(boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setAllwaysFitPageToScreen(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setAutoScrollEnabled(boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setAutoScrollEnabled(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setContentPan(float f, float f4, float f5, int i) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        if (f > 0.0f) {
            spenComposerWrapper.getNoteZoomScroller().setZoomScale(f, f4, f5);
        }
        this.mView.getNoteZoomScroller().setPan(new PointF(f4, f5));
        if (i != -1) {
            this.mView.requestAlignmentContent(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setContextMenuDelegate(boolean z) {
        if (this.mView == null) {
            return;
        }
        AbstractC8014b.m7224z("setContextMenuDelegate ", TAG, z);
        if (z) {
            this.mView.startContextMenuDelegate();
        } else {
            this.mView.stopContextMenuDelegate();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IView
    public void setDelayFlagToUpdateDecorView(boolean z) {
        this.mScrollZoomManager.setDelayFlagToUpdateDecorView(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setDocument(SpenWNote spenWNote) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setDocument(spenWNote);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setEasyWritingPadEnabled(boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setEasyWritingPadEnable(z);
            this.mScrollZoomManager.setBlockShowZoomButtonsView(4, z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setEditMode() {
        Logger.m10999d(TAG, "setEditMode#");
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setFocusableInTouchMode(true);
            this.mView.requestFocus();
            this.mView.setMode(1);
        }
        this.mComposerViewState.setComposerMode(1);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setEditModeType(int i) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setEditMode(i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setEnableTextOnlyMode(boolean z, float f, SpenTextScaleListener spenTextScaleListener) {
        if (this.mView == null || this.mComposerViewState.isOnTextOnlyMode() == z) {
            return;
        }
        this.mScrollZoomManager.hideScrollBar();
        this.mComposerViewState.setIsOnTextOnlyMode(z);
        Logger.m11003i(TAG, "setTextOnlyOnOff# isOn = " + z + " / lastScale = " + f);
        if (z) {
            this.mView.getTextManager().setTextScaleListener(spenTextScaleListener);
            this.mView.setTextOnlyEnabled(true);
            this.mView.getTextManager().setTextScale(f);
            this.mScrollZoomManager.showScrollBarForTextOnlyMode();
            return;
        }
        this.mView.getTextManager().setTextScaleListener(null);
        this.mScrollZoomManager.setTextOnlyEnabled(false);
        this.mView.setTextOnlyEnabled(false);
        TextOnlyModeState textOnlyModeState = this.mPresenter.getComposerModel().getTextOnlyModeState();
        this.mView.getNotePageLayouter().setPageLayoutAll(textOnlyModeState.getLastPageColumn(), textOnlyModeState.getLastPageRow(), textOnlyModeState.isLastFitScreen(), textOnlyModeState.isLastVertical());
        this.mView.getNoteZoomScroller().setZoomScale(f);
        this.mScrollZoomManager.onChangedPageLayout();
        this.mScrollZoomManager.showScrollBar();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setFullScreenModeOn() {
        Logger.m11003i(TAG, "setFullScreenModeOn");
        this.mFullScreenBtn.changeFullScreenMode(this.mActivity, this.mPresenter.getComposerModel().getComposerState(), this.mPresenter.getHWToolbarPresenter());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setHyperLinkAndActionLink(boolean z, boolean z2) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setActionLinkVisible(z2);
            this.mView.getTextManager().setHyperTextEnabled(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setInputFormEnabled(boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setInputFormEnabled(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setLaserPen(boolean z, LaserPenInfo laserPenInfo) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        spenComposerWrapper.setLaserViewEnabled(z);
        if (!z || laserPenInfo == null) {
            return;
        }
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = new SpenSettingUILaserPenInfo();
        spenSettingUILaserPenInfo.type = laserPenInfo.getType();
        spenSettingUILaserPenInfo.color = laserPenInfo.getColor();
        spenSettingUILaserPenInfo.blurSize = laserPenInfo.getBlurSize();
        spenSettingUILaserPenInfo.fillInside = laserPenInfo.isFillInside();
        spenSettingUILaserPenInfo.strokeSize = laserPenInfo.getStrokeSize();
        spenSettingUILaserPenInfo.insideRatio = laserPenInfo.getInsideRatio();
        spenSettingUILaserPenInfo.colorOption = laserPenInfo.getColorOption();
        String str = TAG;
        StringBuilder sb = new StringBuilder("setLaserPen#, type ");
        sb.append(spenSettingUILaserPenInfo.type);
        sb.append(", fillInside: ");
        sb.append(spenSettingUILaserPenInfo.fillInside);
        sb.append(", blurSize: ");
        sb.append(spenSettingUILaserPenInfo.blurSize);
        sb.append(", strokeSize: ");
        sb.append(spenSettingUILaserPenInfo.strokeSize);
        sb.append(", insideRatio: ");
        sb.append(spenSettingUILaserPenInfo.insideRatio);
        sb.append(", colorOption: ");
        AbstractC8014b.m7195A(sb, str, spenSettingUILaserPenInfo.colorOption);
        this.mView.getNoteLaserManager().setLaserPenInfo(spenSettingUILaserPenInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setLongPressEnabled(boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setLongPressEnabled(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setModeOfSpenComposerView(boolean z, int i) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            if (z) {
                spenComposerWrapper.setFocusableInTouchMode(true);
            }
            this.mView.setMode(i);
            setZoomLock(false);
        }
        this.mComposerViewState.setComposerMode(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setPageLayoutAll(int i, int i2, boolean z, boolean z2) {
        if (this.mView != null) {
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "setPageLayoutAll# ", SQLKeyword.COMMA, SQLKeyword.COMMA);
            sbM1173s.append(z);
            sbM1173s.append(SQLKeyword.COMMA);
            sbM1173s.append(z2);
            Logger.m10999d(str, sbM1173s.toString());
            if (this.mComposerViewState.isOnTextOnlyMode()) {
                this.mScrollZoomManager.showScrollBarForTextOnlyMode();
                return;
            }
            this.mComposerViewState.setVertical(z2);
            this.mComposerViewState.setTwoPageView(i == 2);
            this.mScrollZoomManager.onChangedPageLayout();
            this.mAnimationViewManager.setDirection(z2);
            this.mPresenter.getComposerModel().getTextOnlyModeState().setLastPageLayoutInfo(i, i2, z, z2);
            this.mView.getNotePageLayouter().setPageLayoutAll(i, i2, z, z2);
            this.mPageMoveButton.setEnabled(!z2);
            this.mComposerViewMenuManager.onPageLayoutChanged();
            if (DeviceInfo.isVSTModel()) {
                this.mView.getNoteZoomScroller().setZoomScale(this.mView.getNoteZoomScroller().getMinZoomScale());
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setPan(PointF pointF) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        spenComposerWrapper.getNoteZoomScroller().setPan(pointF);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setPresenter(ComposerViewContract.IPresenter iPresenter) {
        this.mPresenter = iPresenter;
        iPresenter.setView(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setScrollingEnabled(boolean z) {
        this.mScrollZoomManager.setScrollingEnabled(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public boolean setSearchFocus(int i) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return false;
        }
        return spenComposerWrapper.setSearchFocus(i);
    }

    public void setSpenDvfsInterface(Activity activity) {
        Logger.m10999d(TAG, "setDvfsInterface# ");
        if (this.mView == null) {
            return;
        }
        DVFSHelperCompat dVFSHelperCompat = this.mDVFSHelperForSpenFling;
        if (dVFSHelperCompat != null) {
            dVFSHelperCompat.release();
        }
        DVFSHelperCompat dVFSHelperCompat2 = new DVFSHelperCompat(activity);
        this.mDVFSHelperForSpenFling = dVFSHelperCompat2;
        dVFSHelperCompat2.initScenarioType(activity, 1500);
        this.mView.setDvfsFling(new SpenDvfsInterface() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.9
            @Override // com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface
            public void acquire() {
                ComposerView.this.mDVFSHelperForSpenFling.acquire();
            }

            @Override // com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface
            public void release() {
                ComposerView.this.mDVFSHelperForSpenFling.release();
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setSpenNotePdfActionListener(PdfManager pdfManager) {
        pdfManager.setSpenNotePdfActionListener(this.mPresenter.getListenerManager().getSpenNotePdfListener());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setTagList(List<String> list) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.getTextManager().setTagList(CollectionHelper.toArrayList(list));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setToolbarPosition(Rect rect, boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        spenComposerWrapper.getTextManager().setCursorObstacleRect(rect);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setVoiceSyncPlayAutoScroll(boolean z) {
        AbstractC8014b.m7220v("setVoiceSyncPlayAutoScroll# ", TAG, z);
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setVoiceSyncPlayAutoScroll(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void setVoiceSyncPlayEnabled(boolean z) {
        AbstractC8014b.m7220v("setVoiceSyncPlayEnabled# ", TAG, z);
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setVoiceSyncPlayEnabled(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setWritingGuideLineEnabled(boolean z) {
        if (this.mView == null) {
            return;
        }
        AbstractC8014b.m7224z("setWritingGuideLineEnabled ", TAG, z);
        this.mView.setWritingGuideLineEnabled(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setZoomLock(boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.getGestureController().setOneFingerScrollAndScaleLocked(z);
            this.mScrollZoomManager.setBlockShowZoomButtonsView(1, z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void setZoomRunnableAfterZoom(Runnable runnable) {
        this.mScrollZoomManager.setZoomRunnableAfterZoom(runnable);
    }

    public void showCover() {
        this.mFlashViewManager.showCover();
        this.mScrollZoomManager.hideScrollBar();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void showLockCanvasToolTip() {
        this.mScrollZoomManager.showLockCanvasToolTip();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void smoothScrollAndScaleToFitPage(int i, final Runnable runnable) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            Logger.m11000e(TAG, "smoothScrollAndScaleToFitPage : mView is null ");
            return;
        }
        spenComposerWrapper.getTextManager().setAutoFocusEnabled(false);
        boolean zSmoothScrollAndScaleToFitPage = this.mView.smoothScrollAndScaleToFitPage(i);
        AbstractC8014b.m7224z("smoothScrollAndScaleToFitPage : ", TAG, zSmoothScrollAndScaleToFitPage);
        if (zSmoothScrollAndScaleToFitPage) {
            this.mSmoothScrollEndRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerView.10
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                    ComposerView.this.mView.getTextManager().setAutoFocusEnabled(true);
                }
            };
            this.mComposerViewState.snapShotSmoothScrollData(this.mPresenter.getCurrentPageIndex());
        } else {
            this.mComposerViewState.clearSnapShotSmoothScrollData();
            runnable.run();
            this.mView.getTextManager().setAutoFocusEnabled(true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void smoothScrollAndScaleToFitRect(RectF rectF, Runnable runnable) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper == null) {
            return;
        }
        boolean zSmoothScrollAndScaleToFitRect = spenComposerWrapper.smoothScrollAndScaleToFitRect(rectF);
        Logger.m11003i(TAG, "smoothScrollAndScaleToFitRect: " + rectF + ", result: " + zSmoothScrollAndScaleToFitRect);
        if (zSmoothScrollAndScaleToFitRect) {
            this.mSmoothScrollEndRunnable = runnable;
        } else {
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void smoothScrollToFitPage() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.smoothScrollToFitPage();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void smoothScrollToPage(int i) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.smoothScrollToPage(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void startActionMode() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.startActionMode();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void startContinuousChange() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.getNoteZoomScroller().startContinuousChange();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void startStickyMemoIconAnimation(SpenStickyNote spenStickyNote, boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.startStickyMemoIconAnimation(spenStickyNote, z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void stopActionMode() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.stopActionMode();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void stopGestureAnimation() {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.stopGestureAnimation();
        }
    }

    public void updateByMultiWindowMode(int i) {
        if (this.mView == null) {
            return;
        }
        boolean z = !WindowManagerCompat.getInstance().isFreeFormWindow(this.mActivity);
        Logger.m10999d(TAG, "setFrontBufferRenderingEnabled# " + z + " / windowMode : " + i);
        this.mView.getNoteWritingViewManager().setFrontBufferRenderingEnabled(z, new boolean[0]);
        this.mView.setFrontBufferRenderingEnabledInEWP(z);
        this.mView.requestResetZoomScaleToDefault();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
    public void updateDisallowTouchDownArea(boolean z, int i) {
        if (this.mView != null) {
            Logger.m10999d(TAG, "updateDisallowTouchDownArea# " + z + " height = " + i);
            if (z) {
                this.mView.setTouchMargin(0, 0, 0, i / 4);
            } else {
                this.mView.setTouchMargin(0, 0, 0, 0);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IView
    public void updateNextFocusForward(boolean z) {
        SpenComposerWrapper spenComposerWrapper = this.mView;
        if (spenComposerWrapper != null) {
            spenComposerWrapper.setNextFocusForwardId(z ? C9086R.id.search_view_container : C9086R.id.toolbar);
        }
    }

    public void release(boolean z, boolean z2) {
        this.mDoc = null;
        if (this.mView != null) {
            try {
                releaseComposerView(z, z2);
            } catch (Exception e) {
                AbstractC8014b.m7207i("release# ", e, TAG);
            }
        }
        this.mView = null;
    }
}
