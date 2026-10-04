package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.document.SpenWNoteHelper;
import com.samsung.android.sdk.composer.util.SpenPagePan;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.addons.base.utils.DrawableUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ZoomView;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.SpenComposerWrapper;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ScrollZoomManager implements SpenZoomListenerImpl.ZoomListener, SpenComposerWrapper.IFadingEdgeScrollInfoProvider {
    public static final float SHORT_CUT_MOVE_SCROLL_UNIT = 20.0f;
    public static final float SHORT_CUT_ZOOM_RATE_FIT_DEFAULT = 1.0f;
    public static final float SHORT_CUT_ZOOM_RATE_STEP = 0.5f;
    private static final String TAG = Logger.createTag("cv$ScrollZoomManager");
    public static final float ZOOM_VALUE_CHANGE_RATE = 0.9f;
    private boolean mBlockToShowView;
    private final ComposerViewState mComposerViewState;
    private boolean mDisabledZoomLock = false;
    private GoToTop mGoToTop;
    private IGotoTopPresenter mGotoTopPresenter;
    private boolean mIsGoToTopCovered;
    private boolean mIsPendingUpdateScroll;
    private boolean mIsPendingUpdateZoom;
    private boolean mLayoutNotDone;
    private IListenerManager mListenerManager;
    private SpenWNote mNote;
    private ViewGroup mParent;
    private IComposerPresenter mPresenter;
    private float mPrevContentHeight;
    private float mPrevViewHeight;
    private Runnable mRunnableAfterZoom;
    private ScrollbarManager mScrollBarManager;
    private SpenWNoteHelper mSpenWNoteHelper;
    protected SpenComposer mView;
    private ViewGroup mZoomButtonContainer;
    private ZoomButtonsView mZoomButtonsView;
    private ZoomLockTip mZoomLockTip;
    private Runnable mZoomRunnable;
    private ZoomView mZoomView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IComposerPresenter {
        ComposerModel getComposerModel();

        boolean isCtrlPressedLast();

        boolean isScrollingEnabled();

        void onScroll(PagePanInfo pagePanInfo, float f, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IGotoTopPresenter {
        boolean canUpdate();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IListenerManager {
        void addNoteZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener);

        void addZoomListener(SpenZoomListenerImpl.ZoomListener zoomListener);

        void removeNoteZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener);
    }

    public ScrollZoomManager(ComposerViewState composerViewState) {
        this.mComposerViewState = composerViewState;
    }

    private boolean checkFirstLayoutDone() {
        SpenComposer spenComposer;
        if (!this.mLayoutNotDone || (spenComposer = this.mView) == null || spenComposer.getHeight() <= 0) {
            return false;
        }
        this.mLayoutNotDone = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRunnableAfterZoom() {
        SpenComposer spenComposer;
        Runnable runnable = this.mRunnableAfterZoom;
        if (runnable == null || (spenComposer = this.mView) == null) {
            return;
        }
        spenComposer.removeCallbacks(runnable);
        this.mView.postDelayed(this.mRunnableAfterZoom, 100L);
    }

    private void initPendingUpdate() {
        this.mIsPendingUpdateScroll = true;
        this.mIsPendingUpdateZoom = true;
    }

    private void initZoomButtonView() {
        View viewInflate;
        if (this.mDisabledZoomLock) {
            Logger.m11004w(TAG, "initZoomButtonView# mDisabledZoomLock true");
            return;
        }
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mParent.getContext())) {
            this.mZoomButtonContainer = (ViewGroup) this.mParent.findViewById(C9086R.id.zoom_button_container);
            viewInflate = LayoutInflater.from(this.mParent.getContext()).inflate(C9086R.layout.comp_zoom_buttons_layout, this.mZoomButtonContainer);
        } else {
            if (!FeatureInfo.isVSTModel()) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.mParent.findViewById(C9086R.id.vst_comp_page_controller_zoom_container);
            this.mZoomButtonContainer = viewGroup;
            viewInflate = viewGroup;
        }
        View view = viewInflate;
        ViewGroup viewGroup2 = this.mParent;
        this.mZoomButtonsView = new ZoomButtonsView(viewGroup2, view, viewGroup2.getContext(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ScrollZoomManager.this.onClickZoomButton(true);
                if (DeviceInfo.isVSTModel()) {
                    ComposerSA.insertLog(ComposerSA.getScreenID(ScrollZoomManager.this.mPresenter.getComposerModel().getModeManager().isEditMode(), ScrollZoomManager.this.mPresenter.getComposerModel().getModeManager().isMode(Mode.Writing), ScrollZoomManager.this.mPresenter.getComposerModel().isTabletLayout()), ComposerSAConstants.EVENT_VST_PAGE_CONTROLLER_ZOOM_IN);
                }
            }
        }, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ScrollZoomManager.this.onClickZoomButton(false);
                if (DeviceInfo.isVSTModel()) {
                    ComposerSA.insertLog(ComposerSA.getScreenID(ScrollZoomManager.this.mPresenter.getComposerModel().getModeManager().isEditMode(), ScrollZoomManager.this.mPresenter.getComposerModel().getModeManager().isMode(Mode.Writing), ScrollZoomManager.this.mPresenter.getComposerModel().isTabletLayout()), ComposerSAConstants.EVENT_VST_PAGE_CONTROLLER_ZOOM_OUT);
                }
            }
        });
        if (FeatureInfo.isVSTModel()) {
            this.mZoomButtonsView.setFadingEnabled(false);
            this.mZoomButtonsView.setRippleSelectedType(DrawableUtils.TYPE_CIRCLE);
        }
    }

    private void initZoomLockListener() {
        if (this.mDisabledZoomLock) {
            return;
        }
        this.mListenerManager.addNoteZoomScrollerListener(this.mScrollBarManager);
    }

    private void initZoomView() {
        if (!FeatureInfo.isVSTModel()) {
            ZoomView zoomView = (ZoomView) this.mParent.findViewById(C9086R.id.comp_zoom_view);
            this.mZoomView = zoomView;
            zoomView.setVisibility(8);
            this.mZoomView.init(this.mView.getNoteZoomScroller().getZoomScale(), new ZoomView.IListenerZoomView() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomView.IListenerZoomView
                public boolean isFitToScreen() {
                    ScrollZoomManager scrollZoomManager = ScrollZoomManager.this;
                    SpenComposer spenComposer = scrollZoomManager.mView;
                    if (spenComposer != null) {
                        return spenComposer.isFitToScreen(scrollZoomManager.mParent.getContext().getResources().getConfiguration().orientation == 1);
                    }
                    return false;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomView.IListenerZoomView
                public void onClickZoomFitToScreen() {
                    Logger.m10999d(ScrollZoomManager.TAG, "onClickZoomFitToScreen#");
                    ScrollZoomManager.this.requestFitToScreen();
                }
            });
            return;
        }
        ZoomView zoomView2 = (ZoomView) this.mParent.findViewById(C9086R.id.comp_zoom_widget_zoom_view);
        this.mZoomView = zoomView2;
        if (zoomView2 == null) {
            Logger.m11004w(TAG, "initZoomView# Cannot find VST zoom view");
            return;
        }
        zoomView2.init(this.mView.getNoteZoomScroller().getZoomScale(), null);
        this.mZoomView.setFadingEnabled(false);
        this.mZoomView.forceShow();
    }

    private boolean isNeedToApplyDisplayCutout() {
        IComposerPresenter iComposerPresenter = this.mPresenter;
        if (iComposerPresenter == null || iComposerPresenter.getComposerModel() == null || !this.mPresenter.getComposerModel().isSimpleMode()) {
            return false;
        }
        return this.mIsGoToTopCovered;
    }

    private boolean isNotAvailableState() {
        return this.mView == null || this.mBlockToShowView;
    }

    private void notifyScrollToPresenter() {
        if (this.mNote == null) {
            Logger.m11003i(TAG, "notifyScrollToPresenter # mNote is null");
            return;
        }
        RectF contentRectInView = this.mView.getNoteZoomScroller().getContentRectInView();
        if (contentRectInView == null) {
            return;
        }
        int pageIndex = getPageIndex(contentRectInView);
        ScrollbarManager scrollbarManager = this.mScrollBarManager;
        if (scrollbarManager != null) {
            scrollbarManager.checkStateToShowScrollBar(this.mComposerViewState.getLastPageIndex(), pageIndex);
        }
        PointF pointF = new PointF(contentRectInView.left, contentRectInView.top);
        SpenPagePan spenPagePanConvertContentPanToPagePan = SpenPagePan.convertContentPanToPagePan(this.mNote, this.mSpenWNoteHelper, contentRectInView);
        this.mPresenter.onScroll(spenPagePanConvertContentPanToPagePan == null ? new PagePanInfo(pointF, 0, pointF) : PagePanInfo.convertToPagePan(pointF, spenPagePanConvertContentPanToPagePan), this.mComposerViewState.getZoomRatio(), pageIndex);
        this.mComposerViewState.setLastPageIndex(pageIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFitToScreen() {
        if (this.mView == null) {
            return;
        }
        boolean z = this.mParent.getContext().getResources().getConfiguration().orientation == 1;
        AbstractC8014b.m7220v("requestFitToScreen# isPortrait : ", TAG, z);
        this.mView.smoothScrollFitPageToScreen(z);
    }

    private void updateGoToTop(float f) {
        if (this.mComposerViewState.getComposerMode() != 1 && this.mGotoTopPresenter.canUpdate() && this.mScrollBarManager.getMainScrollbar().isVertical()) {
            if (f <= 0.0f) {
                this.mGoToTop.hide();
            } else {
                this.mGoToTop.updateBottomMargin(isNeedToApplyDisplayCutout());
                this.mGoToTop.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGoToTopNScrollBar(float f, float f4, float f5, boolean z) {
        ScrollbarManager scrollbarManager;
        if (isNotAvailableState() || (scrollbarManager = this.mScrollBarManager) == null || scrollbarManager.isNotInitialized()) {
            return;
        }
        updateGoToTop(f4);
        if (!z && this.mScrollBarManager.getMainScrollbar().isScrolling()) {
            this.mScrollBarManager.getMainScrollbar().setPageIndex(this.mComposerViewState.getLastPageIndex());
        } else {
            this.mScrollBarManager.updateScrollBar(f, f4, f5);
            updateZoomButtonsView(true);
        }
    }

    private void updateViewRelatedScroll(final float f, final float f4, boolean z) {
        ScrollbarManager scrollbarManager;
        if (this.mView == null || (scrollbarManager = this.mScrollBarManager) == null || scrollbarManager.isNotInitialized()) {
            return;
        }
        if (z || this.mScrollBarManager.canUpdateViewRelatedScroll(f, f4)) {
            if (!this.mIsPendingUpdateScroll) {
                updateGoToTopNScrollBar(f, f4, this.mComposerViewState.getZoomRatio(), false);
            } else {
                this.mIsPendingUpdateScroll = false;
                this.mView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.10
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        SpenComposer spenComposer = ScrollZoomManager.this.mView;
                        if (spenComposer == null) {
                            return;
                        }
                        spenComposer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        ScrollZoomManager scrollZoomManager = ScrollZoomManager.this;
                        scrollZoomManager.updateGoToTopNScrollBar(f, f4, scrollZoomManager.mComposerViewState.getZoomRatio(), true);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZoomView(float f) {
        ZoomView zoomView;
        if (isNotAvailableState() || this.mComposerViewState.isOnTextOnlyMode() || (zoomView = this.mZoomView) == null || zoomView.getZoomValue() == f) {
            return;
        }
        this.mZoomView.show(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoomComposerView(float f, float f4, float f5) {
        if (this.mView == null) {
            return;
        }
        boolean z = this.mComposerViewState.getZoomRatio() != f5;
        this.mComposerViewState.setZoomRatio(f5);
        notifyScrollToPresenter();
        updateViewRelatedScroll(f, f4, z);
        if (z) {
            if (this.mIsPendingUpdateZoom) {
                this.mIsPendingUpdateZoom = false;
                this.mView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.9
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        SpenComposer spenComposer = ScrollZoomManager.this.mView;
                        if (spenComposer == null) {
                            return;
                        }
                        spenComposer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        ScrollZoomManager scrollZoomManager = ScrollZoomManager.this;
                        scrollZoomManager.updateZoomView(scrollZoomManager.mComposerViewState.getZoomRatio());
                    }
                });
            } else {
                updateZoomView(this.mComposerViewState.getZoomRatio());
            }
            ZoomButtonsView zoomButtonsView = this.mZoomButtonsView;
            if (zoomButtonsView != null) {
                zoomButtonsView.updateButtonEnable(this.mView.getNoteZoomScroller().getZoomScale(), this.mView.getNoteZoomScroller().getMinZoomScale(), this.mView.getNoteZoomScroller().getMaxZoomScale());
            }
        }
        this.mComposerViewState.setPanXY(f, f4);
        this.mPrevViewHeight = this.mView.getHeight();
    }

    private void zoomComposerViewOnUiThread(Runnable runnable) {
        if (this.mView == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        this.mView.removeCallbacks(this.mZoomRunnable);
        this.mZoomRunnable = runnable;
        this.mView.post(runnable);
    }

    public void clearZoomRunnableAfterZoom() {
        SpenComposer spenComposer;
        Runnable runnable = this.mRunnableAfterZoom;
        if (runnable == null || (spenComposer = this.mView) == null) {
            return;
        }
        spenComposer.removeCallbacks(runnable);
        this.mRunnableAfterZoom = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.view.SpenComposerWrapper.IFadingEdgeScrollInfoProvider
    public int computeVerticalScrollOffset() {
        ScrollbarManager scrollbarManager = this.mScrollBarManager;
        if (scrollbarManager != null) {
            return (int) scrollbarManager.getLastY();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.view.SpenComposerWrapper.IFadingEdgeScrollInfoProvider
    public int computeVerticalScrollRange() {
        ScrollbarManager scrollbarManager = this.mScrollBarManager;
        if (scrollbarManager != null) {
            return (int) scrollbarManager.getLastHeight();
        }
        return 0;
    }

    public void disableZoomLock() {
        this.mDisabledZoomLock = true;
    }

    public int getPageIndex(RectF rectF) {
        return this.mComposerViewState.isVertical() ? this.mSpenWNoteHelper.getPageIndexClosedByY(rectF.centerY()) : this.mSpenWNoteHelper.getPageIndexClosedByX(rectF.centerX());
    }

    public void hideScrollBar() {
        ScrollbarManager scrollbarManager = this.mScrollBarManager;
        if (scrollbarManager != null) {
            scrollbarManager.hide();
        }
    }

    public void init(SpenComposer spenComposer, SpenWNote spenWNote, IComposerPresenter iComposerPresenter, IListenerManager iListenerManager, IGotoTopPresenter iGotoTopPresenter) {
        if (spenComposer == null) {
            return;
        }
        this.mNote = spenWNote;
        this.mView = spenComposer;
        this.mPresenter = iComposerPresenter;
        this.mListenerManager = iListenerManager;
        this.mGotoTopPresenter = iGotoTopPresenter;
        SpenWNoteHelper spenWNoteHelper = new SpenWNoteHelper(true);
        this.mSpenWNoteHelper = spenWNoteHelper;
        spenWNoteHelper.setDocument(this.mNote);
        this.mListenerManager.addZoomListener(this);
        this.mScrollBarManager.init(this.mView, this.mNote);
        this.mScrollBarManager.setScrollingEnabled(this.mPresenter.isScrollingEnabled());
        this.mGoToTop.init(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PointF pan = ScrollZoomManager.this.mView.getNoteZoomScroller().getPan();
                if (pan != null) {
                    ScrollZoomManager.this.mView.setPan(pan.x, 0.0f);
                }
            }
        });
        initZoomLockListener();
        this.mView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.2
            @Override // java.lang.Runnable
            public void run() {
                ScrollZoomManager scrollZoomManager = ScrollZoomManager.this;
                if (scrollZoomManager.mView == null) {
                    Logger.m11000e(ScrollZoomManager.TAG, "init#post# view is null");
                } else {
                    scrollZoomManager.mScrollBarManager.postShowAfterInit(ScrollZoomManager.this.mComposerViewState.getZoomRatio());
                }
            }
        });
        initZoomButtonView();
        initZoomView();
        this.mComposerViewState.addStateChangeListener(new ComposerViewState.StateChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewState.StateChangeListener
            public void onComposerModeChanged(int i, int i2) {
                if (ScrollZoomManager.this.mComposerViewState.getComposerMode() == 1) {
                    ScrollZoomManager.this.mGoToTop.hideImmediately();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewState.StateChangeListener
            public void onPageCountChanged(int i) {
                ScrollZoomManager.this.mScrollBarManager.getMainScrollbar().setPageCount(i);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewState.StateChangeListener
            public void onPageIndexChanged(int i, int i2) {
            }
        });
        this.mLayoutNotDone = true;
    }

    public void moveScroll(boolean z, boolean z2) {
        RectF contentRectInView;
        PointF pan = this.mView.getNoteZoomScroller().getPan();
        if (pan == null || (contentRectInView = this.mView.getNoteZoomScroller().getContentRectInView()) == null) {
            return;
        }
        Logger.m11003i(TAG, "moveScroll# isVertical = " + z + " / isUpOrLeft = " + z2);
        if (z) {
            float fHeight = contentRectInView.height() / 20.0f;
            if (z2) {
                pan.y -= fHeight;
            } else {
                pan.y += fHeight;
            }
        } else {
            float fWidth = contentRectInView.width() / 20.0f;
            if (z2) {
                pan.x -= fWidth;
            } else {
                pan.x += fWidth;
            }
        }
        this.mView.setPan(pan.x, pan.y);
    }

    public void onAttachedView(ViewGroup viewGroup) {
        ScrollbarManager scrollbarManager = new ScrollbarManager(viewGroup, DesktopModeCompat.INSTANCE.getInstance().isDexMode(viewGroup.getContext()), this.mComposerViewState);
        this.mScrollBarManager = scrollbarManager;
        scrollbarManager.setFadingEnabled(!FeatureInfo.isVSTModel());
        this.mGoToTop = new GoToTop(viewGroup.findViewById(C9086R.id.comp_go_to_top_btn));
        this.mZoomLockTip = new ZoomLockTip(viewGroup.findViewById(C9086R.id.comp_zoom_lock_tip));
        this.mParent = viewGroup;
        this.mLayoutNotDone = false;
    }

    public void onChangedNoteType(boolean z) {
        this.mScrollBarManager.onChangedNoteType(z);
    }

    public void onChangedPageLayout() {
        this.mGoToTop.setEnable(this.mComposerViewState.isVertical());
        this.mScrollBarManager.onChangedPageLayout(this.mComposerViewState.isVertical(), this.mComposerViewState.isTwoPageView());
    }

    public void onClickZoomButton(boolean z) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer == null || spenComposer.getNoteZoomScroller().getContentRectInView() == null) {
            return;
        }
        float zoomScale = this.mView.getNoteZoomScroller().getZoomScale();
        this.mView.getNoteZoomScroller().setZoomScale(z ? zoomScale / 0.9f : zoomScale * 0.9f);
    }

    public void onOrientationChanged(boolean z) {
        if (z) {
            initPendingUpdate();
        }
    }

    public void onTextScaleChanged(float f) {
        Logger.m10999d(TAG, "onTextScaleChanged# " + f);
        ZoomView zoomView = this.mZoomView;
        if (zoomView != null) {
            zoomView.showTextScale(f);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl.ZoomListener
    public void onZoom(final float f, final float f4, float f5, float f6, final float f7) {
        if (this.mView == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("onZoom# ", f, Constant.WHITE_SPACE_FOR_LINK_ICON, f4, Constant.WHITE_SPACE_FOR_LINK_ICON);
        AbstractC11014a.m12337v(sbM1176v, f5, Constant.WHITE_SPACE_FOR_LINK_ICON, f6, Constant.WHITE_SPACE_FOR_LINK_ICON);
        sbM1176v.append(f7);
        sbM1176v.append(" : ");
        sbM1176v.append(this.mView.getHeight());
        Logger.m10999d(str, sbM1176v.toString());
        if (this.mComposerViewState.getPanX() == f && this.mComposerViewState.getPanY() == f4 && this.mComposerViewState.getZoomRatio() == f7 && this.mPrevViewHeight == this.mView.getHeight()) {
            float contentHeight = this.mView.getNoteZoomScroller().getContentHeight();
            if (!checkFirstLayoutDone() && this.mPrevContentHeight == contentHeight) {
                zoomComposerViewOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollZoomManager.this.executeRunnableAfterZoom();
                    }
                });
                return;
            }
            this.mPrevContentHeight = contentHeight;
        }
        zoomComposerViewOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.8
            @Override // java.lang.Runnable
            public void run() {
                ScrollZoomManager.this.zoomComposerView(f, f4, f7);
                ScrollZoomManager.this.executeRunnableAfterZoom();
            }
        });
    }

    public void pageScroll(boolean z) {
        RectF contentRectInView;
        if (!this.mComposerViewState.isVertical()) {
            int lastPageIndex = this.mComposerViewState.getLastPageIndex();
            this.mView.goToPage(z ? this.mComposerViewState.isTwoPageView() ? lastPageIndex - 2 : lastPageIndex - 1 : this.mComposerViewState.isTwoPageView() ? lastPageIndex + 2 : lastPageIndex + 1);
            return;
        }
        PointF pan = this.mView.getNoteZoomScroller().getPan();
        if (pan == null || (contentRectInView = this.mView.getNoteZoomScroller().getContentRectInView()) == null) {
            return;
        }
        float fHeight = contentRectInView.height();
        if (z) {
            pan.y -= fHeight;
        } else {
            pan.y += fHeight;
        }
        this.mView.setPan(pan.x, pan.y);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pageZoom(boolean z) {
        float f;
        SpenComposer spenComposer = this.mView;
        if (spenComposer == null) {
            return;
        }
        if (spenComposer.getGestureController().isOnFingerScrollAndScaleLocked()) {
            Logger.m11004w(TAG, "pageZoom# isOnFingerScrollAndScaleLocked true");
            return;
        }
        float zoomScale = this.mView.getNoteZoomScroller().getZoomScale();
        if (z) {
            f = (zoomScale >= 1.0f || zoomScale + 0.5f <= 1.0f) ? z ? zoomScale + 0.5f : zoomScale - 0.5f : 1.0f;
        }
        this.mView.getNoteZoomScroller().setZoomScale(f);
    }

    public void release() {
        clearZoomRunnableAfterZoom();
        ScrollbarManager scrollbarManager = this.mScrollBarManager;
        if (scrollbarManager != null) {
            this.mListenerManager.removeNoteZoomScrollerListener(scrollbarManager);
            this.mScrollBarManager.release();
            this.mScrollBarManager = null;
        }
        setBlockToShowDecorView(true);
        SpenWNoteHelper spenWNoteHelper = this.mSpenWNoteHelper;
        if (spenWNoteHelper != null) {
            spenWNoteHelper.setDocument(null);
            this.mSpenWNoteHelper.close();
            this.mSpenWNoteHelper = null;
        }
        ZoomButtonsView zoomButtonsView = this.mZoomButtonsView;
        if (zoomButtonsView != null) {
            zoomButtonsView.release();
            this.mZoomButtonsView = null;
        }
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.removeCallbacks(this.mZoomRunnable);
            this.mView = null;
        }
        ViewGroup viewGroup = this.mZoomButtonContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.mZoomButtonContainer = null;
        }
        this.mPresenter = null;
        this.mListenerManager = null;
        this.mGotoTopPresenter = null;
        this.mGoToTop = null;
        this.mZoomLockTip = null;
        this.mZoomView = null;
        this.mNote = null;
        this.mParent = null;
    }

    public void setBlockShowZoomButtonsView(int i, boolean z) {
        ZoomButtonsView zoomButtonsView = this.mZoomButtonsView;
        if (zoomButtonsView != null) {
            zoomButtonsView.setBlockShow(i, z);
        }
    }

    public void setBlockToShowDecorView(boolean z) {
        this.mBlockToShowView = z;
    }

    public void setDelayFlagToUpdateDecorView(boolean z) {
        AbstractC8014b.m7224z("setDelayFlagToUpdateDecorView ", TAG, z);
        if (z) {
            initPendingUpdate();
        }
    }

    public void setGoToTopCovered(boolean z) {
        AbstractC8014b.m7224z("setGoToTopCovered# ", TAG, z);
        this.mGoToTop.hideImmediately();
        this.mIsGoToTopCovered = z;
    }

    public void setOnGenericMotionListener(Context context) {
        if (this.mView != null && DesktopModeCompat.INSTANCE.getInstance().isDexMode(context)) {
            this.mView.setOnGenericMotionListener(new View.OnGenericMotionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.11
                @Override // android.view.View.OnGenericMotionListener
                public boolean onGenericMotion(View view, MotionEvent motionEvent) {
                    if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() != 8 || ScrollZoomManager.this.mPresenter == null || !ScrollZoomManager.this.mPresenter.isCtrlPressedLast()) {
                        return false;
                    }
                    ScrollZoomManager.this.mView.getNoteZoomScroller().setZoomScale((motionEvent.getAxisValue(9) > 0.0f ? 1.1111112f : 0.9f) * ScrollZoomManager.this.mView.getNoteZoomScroller().getZoomScale(), motionEvent.getX(), motionEvent.getY());
                    return true;
                }
            });
        }
    }

    public void setScrollingEnabled(boolean z) {
        this.mScrollBarManager.setScrollingEnabled(z);
    }

    public void setTextOnlyEnabled(boolean z) {
        ZoomView zoomView = this.mZoomView;
        if (zoomView == null || z) {
            return;
        }
        zoomView.hideTextScaleImage();
    }

    public void setZoomRunnableAfterZoom(Runnable runnable) {
        clearZoomRunnableAfterZoom();
        this.mRunnableAfterZoom = runnable;
    }

    public void showLockCanvasToolTip() {
        ZoomLockTip zoomLockTip = this.mZoomLockTip;
        if (zoomLockTip == null) {
            return;
        }
        zoomLockTip.show();
    }

    public void showScrollBar() {
        ScrollbarManager scrollbarManager = this.mScrollBarManager;
        if (scrollbarManager != null) {
            scrollbarManager.show();
        }
    }

    public void showScrollBarForTextOnlyMode() {
        if (this.mScrollBarManager != null) {
            this.mGoToTop.setEnable(true);
            this.mScrollBarManager.onChangedPageLayout(true, false);
            this.mScrollBarManager.show();
        }
    }

    public void updateZoomButtonsView(boolean z) {
        ZoomButtonsView zoomButtonsView = this.mZoomButtonsView;
        if (zoomButtonsView != null) {
            zoomButtonsView.setVisible(z);
        }
    }
}
