package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.FastScrollBar;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class ScrollbarManager extends SpenNoteZoomScrollerListener {
    private SpenComposer mComposerView;
    private final ComposerViewState mComposerViewState;
    private final boolean mIsPageInfoSupport;
    private final FastScrollBar mMainScrollbar;
    private FastScrollBar mSubScrollbar;
    private boolean mFlagToShowScrollBar = false;
    private boolean mTwoPageView = false;
    private float mLastY = -1.0f;
    private float mLastHeight = -1.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnScrollListenerImpl implements FastScrollBar.OnScrollListener {
        private float mScrollableSizeInContent;

        public /* synthetic */ OnScrollListenerImpl(ScrollbarManager scrollbarManager, int i) {
            this();
        }

        private void dispatchCancelEvent(MotionEvent motionEvent) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            ScrollbarManager.this.mComposerView.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }

        private float getScrollableSizeInContent(boolean z, float f) {
            return (ScrollbarManager.this.getNoteSizeInView(z, f) - (z ? ScrollbarManager.this.mComposerView.getHeight() : ScrollbarManager.this.mComposerView.getWidth())) / f;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.OnScrollListener
        public void onChangedScrollBarX(float f, MotionEvent motionEvent) {
            if (ScrollbarManager.this.mComposerView != null) {
                dispatchCancelEvent(motionEvent);
                ScrollbarManager.this.mComposerView.setPan(f * this.mScrollableSizeInContent, ScrollbarManager.this.mComposerViewState.getPanY());
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.OnScrollListener
        public void onChangedScrollBarY(float f, MotionEvent motionEvent) {
            if (ScrollbarManager.this.mComposerView != null) {
                dispatchCancelEvent(motionEvent);
                ScrollbarManager.this.mComposerView.setPan(ScrollbarManager.this.mComposerViewState.getPanX(), f * this.mScrollableSizeInContent);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.OnScrollListener
        public void onReady(boolean z) {
            if (ScrollbarManager.this.mComposerView == null) {
                return;
            }
            ScrollbarManager.this.mComposerView.getNoteZoomScroller().startContinuousChange();
            ScrollbarManager scrollbarManager = ScrollbarManager.this;
            this.mScrollableSizeInContent = getScrollableSizeInContent(z, scrollbarManager.convertZoomFromNoteToView(scrollbarManager.mComposerView.getNoteZoomScroller().getZoomScale()));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.OnScrollListener
        public void onTouchUpScrollBar(boolean z) {
            if (ScrollbarManager.this.mComposerView == null) {
                return;
            }
            ScrollbarManager.this.mComposerView.getNoteZoomScroller().endContinuousChange();
            if (z) {
                return;
            }
            ScrollbarManager.this.mComposerView.smoothScrollToFitPage();
        }

        private OnScrollListenerImpl() {
        }
    }

    public ScrollbarManager(ViewGroup viewGroup, boolean z, ComposerViewState composerViewState) {
        this.mMainScrollbar = new FastScrollBar(viewGroup, false);
        this.mIsPageInfoSupport = z;
        if (z) {
            this.mSubScrollbar = new FastScrollBar(viewGroup, true);
        }
        this.mComposerViewState = composerViewState;
    }

    private void setLastState(float f, float f4) {
        this.mLastHeight = f;
        this.mLastY = f4;
    }

    public boolean canUpdateViewRelatedScroll(float f, float f4) {
        FastScrollBar fastScrollBar;
        boolean zCanUpdateViewRelatedScroll = canUpdateViewRelatedScroll(this.mMainScrollbar, f, f4);
        return (zCanUpdateViewRelatedScroll || (fastScrollBar = this.mSubScrollbar) == null) ? zCanUpdateViewRelatedScroll : canUpdateViewRelatedScroll(fastScrollBar, f, f4);
    }

    public void checkStateToShowScrollBar(int i, int i2) {
        boolean z = true;
        if (this.mIsPageInfoSupport) {
            this.mFlagToShowScrollBar = true;
            return;
        }
        if (i == i2 || i2 < 0 || i < 0) {
            return;
        }
        if (!this.mTwoPageView) {
            this.mFlagToShowScrollBar = true;
            return;
        }
        if (Math.abs(i2 - i) > 1) {
            this.mFlagToShowScrollBar = true;
            return;
        }
        if (i2 % 2 == 1 && i % 2 == 0) {
            z = false;
        }
        this.mFlagToShowScrollBar = z;
    }

    public float convertZoomFromNoteToView(float f) {
        float contentScale = this.mComposerView.getNoteZoomScroller().getContentScale() * f;
        if (contentScale == 0.0f) {
            return 1.0f;
        }
        return contentScale;
    }

    public float getLastHeight() {
        return this.mLastHeight;
    }

    public float getLastY() {
        return this.mLastY;
    }

    public FastScrollBar getMainScrollbar() {
        return this.mMainScrollbar;
    }

    public float getNoteSizeInView(boolean z, float f) {
        return (z ? this.mComposerView.getNoteZoomScroller().getContentHeight() : this.mComposerView.getNoteZoomScroller().getContentWidth()) * f;
    }

    public void hide() {
        this.mMainScrollbar.hide();
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            fastScrollBar.hide();
        }
    }

    public void init(SpenComposer spenComposer, SpenWNote spenWNote) {
        this.mComposerView = spenComposer;
        int i = 0;
        boolean z = spenWNote.getPageMode() == SpenWNote.PageMode.LIST;
        this.mMainScrollbar.init(new OnScrollListenerImpl(this, i), z, this.mComposerViewState);
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            fastScrollBar.init(new OnScrollListenerImpl(this, i), z, this.mComposerViewState);
        }
    }

    public boolean isNotInitialized() {
        return this.mComposerView == null;
    }

    public void onChangedNoteType(boolean z) {
        this.mMainScrollbar.onChangedNoteType(z);
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            fastScrollBar.onChangedNoteType(z);
        }
    }

    public void onChangedPageLayout(boolean z, boolean z2) {
        this.mMainScrollbar.setDirection(z);
        if (!this.mMainScrollbar.isFadingEnabled()) {
            this.mMainScrollbar.show(true);
        }
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            fastScrollBar.setDirection(!z);
        }
        this.mTwoPageView = z2;
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener
    public void onScrollLockChanged(boolean z) {
        setScrollingEnabled(!z);
    }

    @Override // com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener
    public void onZoomLockChanged(boolean z) {
        setScrollingEnabled(!z);
    }

    public void postShowAfterInit(float f) {
        float fConvertZoomFromNoteToView = convertZoomFromNoteToView(f);
        postShowAfterInit(this.mMainScrollbar, fConvertZoomFromNoteToView);
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            postShowAfterInit(fastScrollBar, fConvertZoomFromNoteToView);
        }
    }

    public void release() {
        this.mComposerView = null;
    }

    public void setFadingEnabled(boolean z) {
        this.mMainScrollbar.setFadingEnabled(z);
    }

    public void setScrollingEnabled(boolean z) {
        this.mMainScrollbar.setEnable(z);
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            fastScrollBar.setEnable(z);
        }
    }

    public void show() {
        this.mMainScrollbar.show(true);
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            fastScrollBar.show(true);
        }
    }

    public void updateScrollBar(float f, float f4, float f5) {
        float fConvertZoomFromNoteToView = convertZoomFromNoteToView(f5);
        updateScrollBar(this.mMainScrollbar, f, f4, fConvertZoomFromNoteToView);
        FastScrollBar fastScrollBar = this.mSubScrollbar;
        if (fastScrollBar != null) {
            updateScrollBar(fastScrollBar, f, f4, fConvertZoomFromNoteToView);
        }
    }

    private boolean canUpdateViewRelatedScroll(FastScrollBar fastScrollBar, float f, float f4) {
        return fastScrollBar.isVertical() ? this.mComposerViewState.getPanY() != f4 : this.mComposerViewState.getPanX() != f;
    }

    private void postShowAfterInit(FastScrollBar fastScrollBar, float f) {
        float noteSizeInView = getNoteSizeInView(fastScrollBar.isVertical(), f);
        if (fastScrollBar.isVertical()) {
            updateScrollBar(fastScrollBar, noteSizeInView, this.mComposerView.getHeight());
        } else {
            updateScrollBar(fastScrollBar, noteSizeInView, this.mComposerView.getWidth());
        }
    }

    public void updateScrollBar(FastScrollBar fastScrollBar, float f, float f4, float f5) {
        float noteSizeInView = getNoteSizeInView(fastScrollBar.isVertical(), f5);
        if (fastScrollBar.isVertical()) {
            updateScrollBar(fastScrollBar, noteSizeInView, this.mComposerView.getHeight(), f4, f5);
            setLastState(noteSizeInView, f4);
        } else {
            updateScrollBar(fastScrollBar, noteSizeInView, this.mComposerView.getWidth(), f, f5);
            setLastState(-1.0f, -1.0f);
        }
    }

    public void updateScrollBar(FastScrollBar fastScrollBar, float f, float f4, float f5, float f6) {
        if (f4 != 0.0f && f > 1.05f * f4 && f5 >= 0.0f) {
            fastScrollBar.setPageIndex(this.mComposerViewState.getLastPageIndex());
            float f7 = f - f4;
            fastScrollBar.updateScrollbarSize(1.0f - (f7 / f));
            fastScrollBar.updatePosition((f5 * f6) / f7);
            fastScrollBar.show(this.mFlagToShowScrollBar);
            this.mFlagToShowScrollBar = false;
            return;
        }
        fastScrollBar.hide();
    }

    public void updateScrollBar(FastScrollBar fastScrollBar, float f, float f4) {
        if (f > f4) {
            fastScrollBar.show(true);
        }
    }
}
