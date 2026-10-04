package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut70;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class FastScrollBar {
    private static final int DURATION = 333;
    private static final long SHOW_TIME = 2500;
    private static final String TAG = Logger.createTag("FastScrollBar");
    private ViewPropertyAnimator mAnimator;
    private ComposerViewState mComposerViewState;
    private boolean mDisabled;
    private boolean mEnabledFadeScrollBar = true;
    private boolean mEnabledPageIndex;
    private Runnable mHideRunnable;
    private Interpolator mInterpolator;
    private boolean mIsHiding;
    private final int mMinScrollbarSize;
    private OnScrollListener mOnScrollListener;
    private PageIndexView mPageIndexView;
    private final View mParentView;
    private Scroller mScroller;
    private final boolean mSubMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HorizontalScroller extends Scroller {
        public HorizontalScroller(View view, PageIndexView pageIndexView) {
            super(pageIndexView);
            this.mScrollBar = (ImageView) view.findViewById(C9086R.id.comp_scroll_bar_horizontal);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void calculateMaxValue(View view) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mScrollBar.getLayoutParams();
            this.mRangeStart = marginLayoutParams.getMarginStart();
            int width = view.getWidth() - marginLayoutParams.getMarginEnd();
            this.mRangeEnd = width;
            this.mMaxPosValue = (width - marginLayoutParams.width) - this.mRangeStart;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public boolean canShow() {
            return this.mScrollBar.getVisibility() == 0;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public boolean isVertical() {
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void onDown(View view, MotionEvent motionEvent) {
            super.onDown(view, motionEvent);
            calculateMaxValue(view);
            initPageIndexView();
            this.mStartPos = this.mScrollBar.getTranslationX();
            this.mTouchStartPoint = motionEvent.getRawX();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void onMove(View view, OnScrollListener onScrollListener, MotionEvent motionEvent) {
            float fMin = Math.min(Math.max((motionEvent.getRawX() - this.mTouchStartPoint) + this.mStartPos, 0.0f), this.mMaxPosValue);
            view.setTranslationX(fMin);
            onScrollListener.onChangedScrollBarX(fMin / this.mMaxPosValue, motionEvent);
            FastScrollBar.this.mPageIndexView.getPositionUpdater().updateVariablePosition(view);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void onUp(OnScrollListener onScrollListener) {
            super.onUp(onScrollListener);
            onScrollListener.onTouchUpScrollBar(false);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void setUpdatePosition(View view, float f) {
            super.setUpdatePosition(view, f);
            calculateMaxValue(view);
            this.mScrollBar.setTranslationX(this.mMaxPosValue * f);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void updateScrollbarSize(float f) {
            int iMax = Math.max((int) (Math.max(Math.min(1.0f, f), 0.1f) * FastScrollBar.this.mParentView.getWidth()), FastScrollBar.this.mMinScrollbarSize);
            ViewGroup.LayoutParams layoutParams = FastScrollBar.this.mScroller.getView().getLayoutParams();
            if (iMax == layoutParams.width) {
                return;
            }
            layoutParams.width = iMax;
            FastScrollBar.this.mScroller.getView().setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnScrollListener {
        void onChangedScrollBarX(float f, MotionEvent motionEvent);

        void onChangedScrollBarY(float f, MotionEvent motionEvent);

        void onReady(boolean z);

        void onTouchUpScrollBar(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class Scroller {
        boolean mIsScrollingByBar;
        int mMaxPosValue;
        int mRangeEnd;
        int mRangeStart;
        ImageView mScrollBar;
        float mStartPos;
        float mTouchStartPoint;

        public Scroller(PageIndexView pageIndexView) {
            FastScrollBar.this.mPageIndexView = pageIndexView;
        }

        public abstract void calculateMaxValue(View view);

        public boolean canShow() {
            return true;
        }

        public View getView() {
            return this.mScrollBar;
        }

        public void initPageIndexView() {
            if (FastScrollBar.this.mEnabledPageIndex) {
                FastScrollBar.this.mPageIndexView.show();
                FastScrollBar.this.mPageIndexView.getPositionUpdater().setUpdatePosition(this.mScrollBar, this.mRangeStart, this.mRangeEnd);
            }
        }

        public boolean isScrolling() {
            return this.mIsScrollingByBar;
        }

        public abstract boolean isVertical();

        public void onDown(View view, MotionEvent motionEvent) {
            this.mIsScrollingByBar = true;
            FastScrollBar.this.mScroller.getView().setActivated(true);
        }

        public abstract void onMove(View view, OnScrollListener onScrollListener, MotionEvent motionEvent);

        public void onUp(OnScrollListener onScrollListener) {
            this.mIsScrollingByBar = false;
            FastScrollBar.this.mScroller.getView().setActivated(false);
            FastScrollBar.this.mPageIndexView.hide();
        }

        public void setUpdatePosition(View view, float f) {
            FastScrollBar.this.mPageIndexView.invisible();
        }

        public void setVisibility(int i) {
            this.mScrollBar.setVisibility(i);
            if (FastScrollBar.this.mEnabledPageIndex && i == 8) {
                FastScrollBar.this.mPageIndexView.hide();
            }
        }

        public abstract void updateScrollbarSize(float f);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SubHorizontalScroller extends HorizontalScroller {
        public SubHorizontalScroller(View view, PageIndexView pageIndexView) {
            super(view, pageIndexView);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.HorizontalScroller, com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public boolean canShow() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class VerticalScroller extends Scroller {
        public VerticalScroller(View view, PageIndexView pageIndexView) {
            super(pageIndexView);
            this.mScrollBar = (ImageView) view.findViewById(C9086R.id.comp_scroll_bar_vertical);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void calculateMaxValue(View view) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mScrollBar.getLayoutParams();
            this.mRangeStart = 0;
            int height = view.getHeight() - marginLayoutParams.bottomMargin;
            this.mRangeEnd = height;
            int i = height - marginLayoutParams.height;
            this.mMaxPosValue = i;
            if (i < 0) {
                this.mMaxPosValue = 0;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public boolean canShow() {
            return this.mMaxPosValue > 0;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public boolean isVertical() {
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void onDown(View view, MotionEvent motionEvent) {
            super.onDown(view, motionEvent);
            calculateMaxValue(view);
            initPageIndexView();
            this.mStartPos = this.mScrollBar.getTranslationY();
            this.mTouchStartPoint = motionEvent.getRawY();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void onMove(View view, OnScrollListener onScrollListener, MotionEvent motionEvent) {
            float fMin = Math.min(Math.max((motionEvent.getRawY() - this.mTouchStartPoint) + this.mStartPos, 0.0f), this.mMaxPosValue);
            view.setTranslationY(fMin);
            onScrollListener.onChangedScrollBarY(fMin / this.mMaxPosValue, motionEvent);
            FastScrollBar.this.mPageIndexView.getPositionUpdater().updateVariablePosition(view);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void onUp(OnScrollListener onScrollListener) {
            super.onUp(onScrollListener);
            onScrollListener.onTouchUpScrollBar(true);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void setUpdatePosition(View view, float f) {
            super.setUpdatePosition(view, f);
            calculateMaxValue(view);
            this.mScrollBar.setTranslationY(this.mMaxPosValue * f);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.Scroller
        public void updateScrollbarSize(float f) {
            int iMax = Math.max((int) (Math.max(Math.min(1.0f, f), 0.1f) * FastScrollBar.this.mParentView.getHeight()), FastScrollBar.this.mMinScrollbarSize);
            ViewGroup.LayoutParams layoutParams = FastScrollBar.this.mScroller.getView().getLayoutParams();
            if (iMax == layoutParams.height) {
                return;
            }
            layoutParams.height = iMax;
            FastScrollBar.this.mScroller.getView().setLayoutParams(layoutParams);
        }
    }

    public FastScrollBar(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.mPageIndexView = new PageIndexView(viewGroup);
        this.mSubMode = z;
        this.mMinScrollbarSize = viewGroup.getResources().getDimensionPixelSize(C9086R.dimen.comp_fast_scroll_vertical_thumb_height);
    }

    private void initListener() {
        final GestureDetector gestureDetector = new GestureDetector(this.mScroller.getView().getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                FastScrollBar.this.mScroller.onDown(FastScrollBar.this.mParentView, motionEvent);
                FastScrollBar.this.mOnScrollListener.onReady(FastScrollBar.this.mScroller.isVertical());
                FastScrollBar.this.mScroller.getView().removeCallbacks(FastScrollBar.this.mHideRunnable);
                return true;
            }
        });
        this.mScroller.getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean zOnTouchEvent = gestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    Logger.m11003i(FastScrollBar.TAG, "onTouch event #" + motionEvent);
                    FastScrollBar.this.mScroller.onUp(FastScrollBar.this.mOnScrollListener);
                    if (FastScrollBar.this.mEnabledFadeScrollBar) {
                        FastScrollBar.this.mScroller.getView().postDelayed(FastScrollBar.this.mHideRunnable, FastScrollBar.SHOW_TIME);
                    }
                } else if (motionEvent.getAction() == 2) {
                    FastScrollBar.this.mScroller.onMove(FastScrollBar.this.mScroller.getView(), FastScrollBar.this.mOnScrollListener, motionEvent);
                    return zOnTouchEvent;
                }
                return zOnTouchEvent;
            }
        });
    }

    private boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runHideAnimation() {
        this.mAnimator.alpha(0.0f).setDuration(333L).setInterpolator(this.mInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FastScrollBar.this.mScroller.setVisibility(8);
                FastScrollBar.this.mIsHiding = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                FastScrollBar.this.mIsHiding = true;
            }
        }).start();
    }

    private void runShowAnimation() {
        this.mAnimator.alpha(1.0f).setDuration(333L).setInterpolator(this.mInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FastScrollBar.this.mScroller.getView().postDelayed(FastScrollBar.this.mHideRunnable, FastScrollBar.SHOW_TIME);
            }
        }).start();
    }

    private void setEnabledPageIndex(boolean z) {
        this.mEnabledPageIndex = !this.mSubMode && z;
    }

    public void hide() {
        Runnable runnable;
        if (!this.mEnabledFadeScrollBar) {
            this.mScroller.setVisibility(8);
        } else {
            if (this.mDisabled || (runnable = this.mHideRunnable) == null) {
                return;
            }
            runnable.run();
        }
    }

    public void init(OnScrollListener onScrollListener, boolean z, ComposerViewState composerViewState) {
        this.mOnScrollListener = onScrollListener;
        this.mComposerViewState = composerViewState;
        setEnabledPageIndex(z);
        this.mInterpolator = new SineInOut70();
        this.mHideRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FastScrollBar.1
            @Override // java.lang.Runnable
            public void run() {
                FastScrollBar.this.runHideAnimation();
            }
        };
    }

    public boolean isFadingEnabled() {
        return this.mEnabledFadeScrollBar;
    }

    public boolean isScrolling() {
        return this.mScroller.isScrolling();
    }

    public boolean isVertical() {
        return this.mScroller.isVertical();
    }

    public void onChangedNoteType(boolean z) {
        setEnabledPageIndex(!z);
    }

    public void setDirection(boolean z) {
        Scroller scroller = this.mScroller;
        if (scroller != null) {
            if (scroller.isVertical() == z) {
                return;
            }
            this.mScroller.getView().setAlpha(0.0f);
            this.mScroller.setVisibility(8);
        }
        if (z) {
            this.mScroller = new VerticalScroller(this.mParentView, this.mPageIndexView);
        } else if (this.mSubMode) {
            this.mScroller = new SubHorizontalScroller(this.mParentView, this.mPageIndexView);
        } else {
            this.mScroller = new HorizontalScroller(this.mParentView, this.mPageIndexView);
        }
        this.mAnimator = this.mScroller.getView().animate();
        this.mPageIndexView.setDirection(z);
        initListener();
    }

    public void setEnable(boolean z) {
        this.mDisabled = !z;
    }

    public void setFadingEnabled(boolean z) {
        this.mEnabledFadeScrollBar = z;
    }

    public void setPageCount(int i) {
        if (this.mPageIndexView.setPageCount(i) && isMainThread() && this.mPageIndexView.isShowing()) {
            this.mPageIndexView.updateText();
        }
    }

    public void setPageIndex(int i) {
        if (this.mPageIndexView.setPageIndex(i) && isMainThread() && this.mPageIndexView.isShowing()) {
            this.mPageIndexView.updateText();
        }
    }

    public void show(boolean z) {
        if (this.mDisabled) {
            return;
        }
        ComposerViewState composerViewState = this.mComposerViewState;
        if (composerViewState != null && composerViewState.getComposerMode() == 1 && SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, false)) {
            return;
        }
        if (this.mScroller.canShow() || z) {
            if (!this.mEnabledFadeScrollBar) {
                this.mScroller.getView().bringToFront();
                this.mScroller.setVisibility(0);
                return;
            }
            if (this.mScroller.getView().getVisibility() != 0) {
                this.mScroller.setVisibility(0);
                this.mScroller.getView().bringToFront();
                runShowAnimation();
            } else {
                this.mScroller.getView().removeCallbacks(this.mHideRunnable);
                if (this.mIsHiding) {
                    this.mScroller.getView().animate().cancel();
                    this.mScroller.setVisibility(0);
                    runShowAnimation();
                }
                this.mScroller.getView().postDelayed(this.mHideRunnable, SHOW_TIME);
            }
        }
    }

    public void updatePosition(float f) {
        if (this.mDisabled) {
            return;
        }
        this.mScroller.setUpdatePosition(this.mParentView, f);
    }

    public void updateScrollbarSize(float f) {
        if (this.mDisabled) {
            return;
        }
        this.mScroller.updateScrollbarSize(f);
    }
}
