package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.glance.AbstractC2821a;
import androidx.viewpager2.widget.ViewPager2;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AiResultLayout;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcherToAiResultLayout;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.animation.AiResultViewFlickAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultLayoutManager extends AiResultLayout.FloatingPaneCallback implements DragEventDispatcherToAiResultLayout.IAiMenuResultLayoutManager {
    private static final boolean DEBUG = false;
    private static final String TAG = Logger.createTag("LayoutManager", AiConstants.PREFIX_TAG);
    public static final int TOUCHSLOP_DEFAULT = 42;
    private int MAX_HEIGHT;
    private int MAX_TOP_MARGIN;
    private int MIN_HEIGHT;
    private int MIN_WIDTH;
    private boolean isFocusEditResult;
    private View.OnLayoutChangeListener mAppBarOnLayoutChangeListener;
    private final View mAppbar;
    private final View mBelowViewPager;
    private final View mBottomDocker;
    private AiMenuResultCommonViews mCommonViews;
    private final View mComposerToolbar;
    private int mContainerHeight;
    private int mContainerWidth;
    private final Contract mContract;
    private final View mFixedBottom;
    private final View mFragmentView;
    private View.OnLayoutChangeListener mFragmentViewOnLayoutChangeListener;
    private HeightHandle mHeightHandle;
    private ValueAnimator mHideAnimator;
    boolean mIsMultiWindow;
    boolean mIsRTL;
    private Boolean mIsRotate;
    private final ViewGroup mLandscapeContainer;
    private final ViewGroup mLayoutContainer;
    private View.OnLayoutChangeListener mLayoutContainerOnLayoutChangeListener;
    private View mLayoutContent;
    private final int mMinimizeHeight;
    private View mNavigationBarBGView;
    int mOrientation;
    private final ViewGroup mPortraitContainer;
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private View mResultContainer;
    private View.OnLayoutChangeListener mResultContainerOnLayoutChangeListener;
    private AiResultViewFlickAnimation mRippleBGContentAnimation;
    private int mScrollState;
    private ValueAnimator mShowAnimator;
    Runnable mSnapToPageAction;
    private final View mTopDocker;
    private final View mTranslateContainer;
    private Runnable mUpdatePageRunnable;
    protected ConstraintLayout mViewAutoTranscribe;
    private final ViewPager2 mViewPager;
    protected CustomConstraintLayout mViewPagerContainer;
    private View.OnLayoutChangeListener mViewPagerContainerOnLayoutChangeListener;
    protected GestureDetector mViewPagerGestureDetector;
    private View.OnLayoutChangeListener mViewPagerOnLayoutChangeListener;
    private final View mVoiceControllerView;
    private View.OnLayoutChangeListener mVoiceControllerViewOnLayoutChangeListener;
    private WidthHandle mWidthHandle;
    private int mElevationTopMargin = 0;
    private int mCurrentMode = -1;
    private int mPageIndexToUpdate = -1;
    private int mStateResize = -1;
    private Integer mOldHeight = null;
    private Integer mTagetSizeForSideMode = null;
    private boolean isEditResult = false;
    private boolean mIsShowingSIP = false;
    private boolean mIsPreTouchHiding = false;
    private boolean mIsMinimizeView = false;
    private boolean mOnResize = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class AbsHandle {
        static final float BLUR_VALUE = 25.0f;
        int OVERLAP_COLOR;
        Bitmap mComposerThumbnail;
        View mComposerViewCover;
        View mComposerWindowView;
        View mHandle;
        View mHandleTouchArea;
        int mLocalElevationTopMargin = 0;
        int mMaxSize;
        int mMinSize;
        View mResizeContainer;
        ResizeShowHideAnimation mResizeShowHideAnimation;
        View mResizeView;
        Bitmap mResultThumbnail;
        View mResultWindowView;
        float mStartPoint;
        int mStartSize;
        int mTitleHeight;

        public AbsHandle(ViewGroup viewGroup) {
            this.OVERLAP_COLOR = viewGroup.getResources().getColor(C9086R.color.ai_menu_result_resize_overlap_color, null);
            this.mTitleHeight = AiMenuResultLayoutManager.this.mFragmentView.findViewById(C9086R.id.appbar_layout).getHeight();
            this.mComposerViewCover = (View) AiMenuResultLayoutManager.this.mFragmentView.findViewById(C9086R.id.comp_capture_view).getParent();
        }

        public void clearResizeWindow() {
            Logger.m10999d(AiMenuResultLayoutManager.TAG, "clearResizeWindow#");
            this.mResizeView.setVisibility(8);
            this.mResizeContainer.setVisibility(8);
            this.mComposerWindowView.setBackground(null);
            this.mResultWindowView.setBackground(null);
            Bitmap bitmap = this.mComposerThumbnail;
            if (bitmap != null) {
                bitmap.recycle();
                this.mComposerThumbnail = null;
            }
            Bitmap bitmap2 = this.mResultThumbnail;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.mResultThumbnail = null;
            }
        }

        public void createResizeShowHideAnimation() {
            this.mResizeShowHideAnimation = new ResizeShowHideAnimation(this.mComposerWindowView, this.mResultWindowView, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.AbsHandle.1
                @Override // java.lang.Runnable
                public void run() {
                    AbsHandle.this.clearResizeWindow();
                }
            });
        }

        public void drawColorForBlur(Canvas canvas, Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setColor(AiMenuResultLayoutManager.this.mFragmentView.getContext().getColor(C9086R.color.ai_menu_result_large_layout_bg_color));
            if (AiViewUtils.isSupportFloatingLayout()) {
                AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                GradientDrawable backgroundGradient = aiMenuResultLayoutManager.getBackgroundGradient(aiMenuResultLayoutManager.mCommonViews.mActivity);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AiMenuResultLayoutManager.this.mViewPagerContainer.getLayoutParams();
                if (marginLayoutParams != null) {
                    backgroundGradient.setBounds(!AiViewUtils.isAtLeastOneUI85() ? new Rect(marginLayoutParams.leftMargin, AiMenuResultLayoutManager.this.mCommonViews.getTopContainer().getBottom(), bitmap.getWidth() - marginLayoutParams.rightMargin, bitmap.getHeight() - marginLayoutParams.bottomMargin) : new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
                    backgroundGradient.draw(canvas);
                }
            } else {
                canvas.drawRect(new Rect(0, AiMenuResultLayoutManager.this.mCommonViews.getTopContainer().getBottom(), bitmap.getWidth(), bitmap.getHeight()), paint);
            }
            if (AiViewUtils.isAtLeastOneUI85()) {
                return;
            }
            canvas.drawRect(new Rect(0, 0, bitmap.getWidth(), this.mLocalElevationTopMargin), paint);
            paint.setColor(this.OVERLAP_COLOR);
            canvas.drawRect(new Rect(0, 0, bitmap.getWidth(), AiMenuResultLayoutManager.this.mCommonViews.getTopContainer().getBottom()), paint);
        }

        public void setVisible(boolean z) {
            if (AiViewUtils.isSupportFloatingLayout()) {
                this.mHandle.setVisibility(4);
                this.mHandleTouchArea.setVisibility(4);
            } else if (z) {
                this.mHandle.setVisibility(0);
                this.mHandleTouchArea.setVisibility(0);
            } else {
                this.mHandle.setVisibility(8);
                this.mHandleTouchArea.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        List<AiMenuContract.IAiActionResultView> getPageTypeList();

        AiMenuResultViewPresenter getPresenter();

        void hide();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResizeShowHideAnimation {
        private static final int HIDE_DURATION = 500;
        private static final int SHOW_DURATION = 200;
        private final ValueAnimator mHideAnimator;
        private final Runnable mHideEndAction;
        private final ValueAnimator mShowAnimator;

        public ResizeShowHideAnimation(final View view, final View view2, Runnable runnable) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mShowAnimator = valueAnimatorOfFloat;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.mHideAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat.setDuration(200L);
            PathInterpolator pathInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(pathInterpolator);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.ResizeShowHideAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    view.setAlpha(fFloatValue);
                    view2.setAlpha(fFloatValue);
                }
            });
            valueAnimatorOfFloat2.setDuration(500L);
            valueAnimatorOfFloat2.setInterpolator(pathInterpolator);
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.ResizeShowHideAnimation.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    view.setAlpha(fFloatValue);
                    view2.setAlpha(fFloatValue);
                }
            });
            this.mHideEndAction = runnable;
            valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.ResizeShowHideAnimation.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ResizeShowHideAnimation.this.mHideEndAction.run();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearState() {
            if (this.mShowAnimator.isRunning()) {
                this.mShowAnimator.cancel();
                this.mShowAnimator.end();
            } else if (this.mHideAnimator.isRunning()) {
                this.mHideAnimator.cancel();
                this.mHideAnimator.end();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hide() {
            if (this.mShowAnimator.isRunning()) {
                this.mShowAnimator.cancel();
                this.mShowAnimator.end();
            }
            this.mHideAnimator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void readyShow() {
            if (this.mHideAnimator.isRunning()) {
                this.mHideAnimator.cancel();
                this.mHideAnimator.end();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void show() {
            this.mShowAnimator.start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class WidthHandle extends AbsHandle implements View.OnTouchListener {
        float MAX_WIDTH_RATIO;
        View mEndWindowHandle;

        public WidthHandle(ViewGroup viewGroup) {
            super(viewGroup);
            if (AiViewUtils.isSupportFloatingLayout()) {
                this.MAX_WIDTH_RATIO = 1.0f;
            } else if (AiMenuResultLayoutManager.this.mIsMultiWindow || AiMenuResultLayoutManager.this.mContract.getPresenter().isTabletLayout()) {
                this.MAX_WIDTH_RATIO = 0.5f;
            } else {
                this.MAX_WIDTH_RATIO = 0.82f;
            }
            this.mHandle = viewGroup.findViewById(C9086R.id.ai_menu_result_width_handle_container);
            this.mHandleTouchArea = viewGroup.findViewById(C9086R.id.ai_menu_result_width_handle_touch_area);
            if (!AiViewUtils.isSupportFloatingLayout()) {
                this.mHandle.setOnTouchListener(this);
                this.mHandleTouchArea.setOnTouchListener(this);
            }
            View viewFindViewById = AiMenuResultLayoutManager.this.mFragmentView.findViewById(C9086R.id.window_resize_view);
            this.mResizeContainer = viewFindViewById;
            this.mComposerWindowView = viewFindViewById.findViewById(C9086R.id.start_window);
            View viewFindViewById2 = this.mResizeContainer.findViewById(C9086R.id.end_window);
            this.mResultWindowView = viewFindViewById2;
            this.mEndWindowHandle = viewFindViewById2.findViewById(C9086R.id.end_window_handle);
            if (AiViewUtils.isSupportFloatingLayout()) {
                this.mEndWindowHandle.setVisibility(4);
            }
            this.mResizeView = this.mResizeContainer.findViewById(C9086R.id.window_resize_view_width);
            createResizeShowHideAnimation();
        }

        public void applyResizeWindow(int i) {
            int i2;
            int iCalculateSize = calculateSize(i);
            if (iCalculateSize < AiMenuResultLayoutManager.this.MIN_WIDTH) {
                i2 = AiMenuResultLayoutManager.this.MIN_WIDTH - iCalculateSize;
                iCalculateSize = AiMenuResultLayoutManager.this.MIN_WIDTH;
            } else {
                i2 = 0;
            }
            if (AiMenuResultLayoutManager.this.mContainerWidth < iCalculateSize) {
                AiMenuResultLayoutManager.this.insertSALog("d");
            } else if (AiMenuResultLayoutManager.this.mContainerWidth > iCalculateSize) {
                AiMenuResultLayoutManager.this.insertSALog("e");
            }
            if (i2 == 0) {
                AiMenuResultLayoutManager.this.mLandscapeContainer.getLayoutParams().width = -2;
                AiMenuResultLayoutManager.this.mLandscapeContainer.requestLayout();
            } else {
                AiMenuResultLayoutManager.this.mLandscapeContainer.getLayoutParams().width = AiMenuResultLayoutManager.this.MIN_WIDTH - i2;
            }
            AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutParams().width = iCalculateSize;
            AbstractC8014b.m7221w(AbstractC0541b.m778t(iCalculateSize, "applyResizeWindow# ", " / "), AiMenuResultLayoutManager.TAG, AiMenuResultLayoutManager.this.mViewPager.getLayoutParams().width);
            AiMenuResultLayoutManager.this.mLayoutContainer.requestLayout();
            AiMenuResultLayoutManager.this.mViewPager.requestLayout();
            AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
            if (aiMenuResultLayoutManager.mIsRTL) {
                aiMenuResultLayoutManager.callSnapToPage();
            }
        }

        public int calculateSize(int i) {
            int iMax = Math.max(Math.min(this.mStartSize - i, this.mMaxSize), this.mMinSize);
            int i2 = this.mMaxSize;
            return iMax > i2 ? i2 : iMax;
        }

        public void clearState() {
            AiMenuResultLayoutManager.this.mLandscapeContainer.getLayoutParams().width = -2;
            AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutParams().width = AiMenuResultLayoutManager.this.mContainerWidth;
            this.mResizeShowHideAnimation.clearState();
            clearResizeWindow();
        }

        public int getDelta(MotionEvent motionEvent) {
            return AiMenuResultLayoutManager.this.mIsRTL ? (int) (this.mStartPoint - motionEvent.getRawX()) : (int) (motionEvent.getRawX() - this.mStartPoint);
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.mStartPoint = motionEvent.getRawX();
                readyResizeWindow();
                return true;
            }
            if (motionEvent.getAction() == 2) {
                resizeResultWindow(getDelta(motionEvent), true);
                return true;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return false;
            }
            applyResizeWindow(getDelta(motionEvent));
            this.mResizeShowHideAnimation.hide();
            return true;
        }

        public void readyResizeWindow() {
            Logger.m10999d(AiMenuResultLayoutManager.TAG, "readyResizeWindow#start");
            AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
            this.mEndWindowHandle.setTranslationY(aiMenuResultLayoutManager.getViewHeight(aiMenuResultLayoutManager.mVoiceControllerView) / 2.0f);
            this.mResizeShowHideAnimation.readyShow();
            this.mResizeView.getLayoutParams().height = AiMenuResultLayoutManager.this.mLayoutContainer.getHeight();
            this.mStartSize = (AiMenuResultLayoutManager.this.mLandscapeContainer.getWidth() != -2 ? AiMenuResultLayoutManager.this.mLandscapeContainer : AiMenuResultLayoutManager.this.mLayoutContainer).getWidth();
            this.mMaxSize = (int) (AiMenuResultLayoutManager.this.mFragmentView.getWidth() * this.MAX_WIDTH_RATIO);
            this.mMinSize = AiViewUtils.isSupportFloatingLayout() ? 0 : AiMenuResultLayoutManager.this.MIN_WIDTH;
            Bitmap bitmapCreateBitmap = AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutDirection() == 1 ? Bitmap.createBitmap(AiMenuResultLayoutManager.this.mFragmentView.getWidth(), AiMenuResultLayoutManager.this.mFragmentView.getHeight(), Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(AiMenuResultLayoutManager.this.mFragmentView.getWidth() - this.mStartSize, AiMenuResultLayoutManager.this.mFragmentView.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            this.mComposerViewCover.setBackgroundColor(AiMenuResultLayoutManager.this.mContract.getPresenter().getBackgroundThemeColor());
            AiMenuResultLayoutManager.this.mFragmentView.draw(canvas);
            this.mComposerViewCover.setBackgroundColor(0);
            canvas.drawColor(this.OVERLAP_COLOR);
            int height = (AiViewUtils.isAtLeastOneUI85() && AiMenuResultLayoutManager.this.isPhoneLayout()) ? 0 : AiMenuResultLayoutManager.this.mTranslateContainer.getHeight() + AiMenuResultLayoutManager.this.mVoiceControllerView.getHeight() + AiMenuResultLayoutManager.this.mAppbar.getHeight();
            Bitmap bitmapCreateBitmap2 = AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutDirection() == 1 ? Bitmap.createBitmap(bitmapCreateBitmap, this.mStartSize, height, bitmapCreateBitmap.getWidth() - this.mStartSize, bitmapCreateBitmap.getHeight() - height) : Bitmap.createBitmap(bitmapCreateBitmap, 0, height, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight() - height);
            bitmapCreateBitmap.recycle();
            this.mComposerThumbnail = AiViewUtils.blur(AiMenuResultLayoutManager.this.mFragmentView.getContext(), bitmapCreateBitmap2, 25.0f);
            bitmapCreateBitmap2.recycle();
            View view = AiViewUtils.isSupportFloatingLayout() ? AiMenuResultLayoutManager.this.mResultContainer : AiMenuResultLayoutManager.this.mLayoutContainer;
            Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap3);
            view.draw(canvas2);
            drawColorForBlur(canvas2, bitmapCreateBitmap3);
            this.mResultThumbnail = AiViewUtils.blur(AiMenuResultLayoutManager.this.mFragmentView.getContext(), bitmapCreateBitmap3, 25.0f);
            bitmapCreateBitmap3.recycle();
            Logger.m10999d(AiMenuResultLayoutManager.TAG, "readyResizeWindow#end");
            this.mComposerWindowView.setBackground(new BitmapDrawable(AiMenuResultLayoutManager.this.mFragmentView.getResources(), this.mComposerThumbnail));
            this.mResultWindowView.setBackground(new BitmapDrawable(AiMenuResultLayoutManager.this.mFragmentView.getResources(), this.mResultThumbnail));
            resizeResultWindow(0, false);
            this.mResizeView.setVisibility(0);
            this.mResizeContainer.setVisibility(0);
            this.mResizeShowHideAnimation.show();
        }

        public void resizeResultWindow(int i, boolean z) {
            this.mResultWindowView.getLayoutParams().width = calculateSize(i);
            if (z) {
                this.mResultWindowView.requestLayout();
                this.mResizeContainer.requestLayout();
            }
        }
    }

    public AiMenuResultLayoutManager(Activity activity, Contract contract) {
        readyView(activity);
        this.mContract = contract;
        this.mOrientation = activity.getResources().getConfiguration().orientation;
        this.mIsRTL = LocaleUtils.isRTLMode();
        this.mIsMultiWindow = WindowManagerCompat.getInstance().isMultiWindowMode(activity);
        View viewFindViewById = activity.findViewById(C9086R.id.main_container);
        this.mFragmentView = viewFindViewById;
        this.mPortraitContainer = (ViewGroup) activity.findViewById(C9086R.id.ai_menu_result_bottom_root_container);
        this.mViewPagerContainer = (CustomConstraintLayout) activity.findViewById(C9086R.id.ai_menu_result_viewpager_container);
        this.mViewAutoTranscribe = (ConstraintLayout) activity.findViewById(C9086R.id.ai_menu_result_stt_auto_transcribe);
        this.mLandscapeContainer = (ViewGroup) activity.findViewById(C9086R.id.comp_end_container);
        if (AiViewUtils.isSupportFloatingLayout()) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(C9086R.id.ai_menu_result_layout_container);
            this.mLayoutContainer = viewGroup;
            if (AiViewUtils.isAtLeastOneUI85()) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                if (viewGroup2 != null && isPhoneLayout()) {
                    viewGroup2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    viewGroup2.requestLayout();
                }
                this.mRippleBGContentAnimation = new AiResultViewFlickAnimation(this.mViewPagerContainer);
            }
            this.mLayoutContent = activity.findViewById(C9086R.id.result_layout_content);
            setBackgroundForResultView(activity);
            ((AiResultLayout) viewGroup).addCallback(this);
            this.mLayoutContent.setOnGenericMotionListener(new View.OnGenericMotionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.6
                @Override // android.view.View.OnGenericMotionListener
                public boolean onGenericMotion(View view, MotionEvent motionEvent) {
                    return motionEvent.getAction() == 8;
                }
            });
            initSizeForResultView(null);
        } else {
            this.mLayoutContainer = (ViewGroup) activity.findViewById(C9086R.id.old_ai_menu_result_layout_container);
        }
        initSize(activity, viewFindViewById.getWidth(), viewFindViewById.getHeight());
        this.mAppbar = viewFindViewById.findViewById(C9086R.id.appbar_layout);
        this.mTopDocker = viewFindViewById.findViewById(C9086R.id.top_docker);
        this.mBottomDocker = viewFindViewById.findViewById(C9086R.id.bottom_docker);
        this.mComposerToolbar = viewFindViewById.findViewById(C9086R.id.floating_layout);
        this.mFixedBottom = viewFindViewById.findViewById(C9086R.id.bottom_fixed_docker);
        this.mVoiceControllerView = viewFindViewById.findViewById(C9086R.id.voice_record_menu_container_parent);
        this.mTranslateContainer = viewFindViewById.findViewById(C9086R.id.translate_overlay_language_selector_container);
        this.mViewPager = (ViewPager2) this.mLayoutContainer.findViewById(C9086R.id.ai_menu_result_viewpager);
        this.mBelowViewPager = this.mLayoutContainer.findViewById(C9086R.id.ai_menu_result_viewpager_below_container);
        this.mScrollState = 0;
        this.mMinimizeHeight = (int) ResourceUtils.convertDpToPixel(viewFindViewById.getContext(), 56.0f);
    }

    private void createResultContainerListener() {
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                int paneMode = ((AiResultLayout) AiMenuResultLayoutManager.this.mLayoutContainer).getPaneMode();
                AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
                if (paneMode == companion.MODE_BOTTOM()) {
                    if (AiMenuResultLayoutManager.this.mStateResize != companion.STATE_RESIZE()) {
                        if (AiMenuResultLayoutManager.this.mStateResize == companion.STATE_MOVE()) {
                            AiMenuResultLayoutManager.this.mHeightHandle.resizeResultWindow((int) (i2 - AiMenuResultLayoutManager.this.mHeightHandle.mStartPoint), true);
                            return;
                        }
                        return;
                    } else {
                        if (i7 != i2) {
                            AiMenuResultLayoutManager.this.mHeightHandle.mStartPoint = AiMenuResultLayoutManager.this.mResultContainer.getTop();
                            AiMenuResultLayoutManager.this.mHeightHandle.readyResizeWindow();
                            AiMenuResultLayoutManager.this.mStateResize = companion.STATE_MOVE();
                            AiMenuResultLayoutManager.this.mBelowViewPager.setVisibility(8);
                            return;
                        }
                        return;
                    }
                }
                if (paneMode == companion.MODE_SIDE()) {
                    if (AiMenuResultLayoutManager.this.mStateResize == companion.STATE_RESIZE()) {
                        if (i6 == i && i8 == i4) {
                            return;
                        }
                        AiMenuResultLayoutManager.this.mWidthHandle.mStartPoint = AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutDirection() == 1 ? AiMenuResultLayoutManager.this.mResultContainer.getRight() : AiMenuResultLayoutManager.this.mResultContainer.getLeft();
                        AiMenuResultLayoutManager.this.mWidthHandle.readyResizeWindow();
                        AiMenuResultLayoutManager.this.mStateResize = companion.STATE_MOVE();
                        return;
                    }
                    if (AiMenuResultLayoutManager.this.mStateResize == companion.STATE_MOVE()) {
                        int i10 = (int) (i - AiMenuResultLayoutManager.this.mWidthHandle.mStartPoint);
                        if (AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutDirection() == 1) {
                            i10 = (int) (AiMenuResultLayoutManager.this.mWidthHandle.mStartPoint - i4);
                        }
                        AiMenuResultLayoutManager.this.mWidthHandle.resizeResultWindow(i10, true);
                    }
                }
            }
        };
        this.mResultContainerOnLayoutChangeListener = onLayoutChangeListener;
        this.mResultContainer.addOnLayoutChangeListener(onLayoutChangeListener);
        this.mResultContainer.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.3
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        makePreTouchListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GradientDrawable getBackgroundGradient(Activity activity) {
        boolean zIsNightMode = ContextUtils.isNightMode(activity);
        int[] iArr = !zIsNightMode ? new int[]{-1, -327694, -983041, -1510401, -1118209, -461057} : new int[]{-14275793, -14602965, -14471120, -14275016, -14145228, -13948366};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TL_BR;
        if (AiViewUtils.isAtLeastOneUI85()) {
            iArr = !zIsNightMode ? new int[]{-132097, -986881, -1904641, -1048833, -65553, -1} : new int[]{-12961219, -12763828, -12827572, -13088953, -12697803, -12961219};
            orientation = GradientDrawable.Orientation.BL_TR;
        }
        return new GradientDrawable(orientation, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFloatingToolbarHeight() {
        if (getViewHeight(this.mTopDocker) > 0 || getViewHeight(this.mBottomDocker) > 0) {
            return getViewHeight(this.mComposerToolbar);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFragmentHeight() {
        return this.mFragmentView.getHeight() - this.mFragmentView.getPaddingBottom();
    }

    private int getHorizontalMarginViewPagerContainer(Resources resources) {
        return AiViewUtils.isSupportFloatingLayout() ? resources.getDimensionPixelSize(C9086R.dimen.ai_result_page_viewpager_container_horizontal_margin_landscape) : isPortrait() ? resources.getDimensionPixelSize(C9086R.dimen.ai_result_page_viewpager_container_horizontal_margin_portrait) : resources.getDimensionPixelSize(C9086R.dimen.f6694xa4de54d9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMaxHeight(int i) {
        int height = (((i - this.mAppbar.getHeight()) - getFloatingToolbarHeight()) - getViewHeight(this.mFixedBottom)) - getViewHeight(this.mVoiceControllerView);
        int i2 = this.MAX_HEIGHT;
        return (i2 <= 0 || height <= i2) ? height : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewHeight(View view) {
        if (view == null || view.getVisibility() != 0) {
            return 0;
        }
        return Math.max(view.getHeight(), 0);
    }

    private boolean hasDragDropPosition(View view, DragEvent dragEvent) {
        int[] iArr = new int[2];
        this.mResultContainer.getLocationOnScreen(iArr);
        Rect rect = new Rect(0, 0, this.mResultContainer.getWidth(), this.mResultContainer.getHeight());
        rect.offset(iArr[0], iArr[1]);
        view.getLocationOnScreen(iArr);
        return rect.contains(((int) dragEvent.getX()) + iArr[0], ((int) dragEvent.getY()) + iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasTouchPosition(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.mResultContainer.getLocationOnScreen(iArr);
        Rect rect = new Rect(0, 0, this.mResultContainer.getWidth(), this.mResultContainer.getHeight());
        rect.offset(iArr[0], iArr[1]);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSize(Context context, int i, int i2) {
        this.MIN_WIDTH = (int) ResourceUtils.convertDpToPixel(context, 250.0f);
        this.MIN_HEIGHT = (int) ResourceUtils.convertDpToPixel(context, 150.0f);
        boolean zIsFoldableModel = ModelFeature.getFeature().isFoldableModel();
        boolean zIsTabletLayout = this.mContract.getPresenter().isTabletLayout();
        if (isCreateImageRunning()) {
            if (zIsTabletLayout) {
                this.MAX_TOP_MARGIN = 0;
                this.MIN_WIDTH = (int) ResourceUtils.convertDpToPixel(context, 300.0f);
                if (zIsFoldableModel) {
                    initSize(i, i2, 0.42f, 0.765f);
                } else {
                    initSize(i, i2, 0.42f, 0.55f);
                }
            } else {
                this.MAX_TOP_MARGIN = context.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_max_top_margin);
                if (zIsFoldableModel) {
                    initSize(i, i2, 0.42f, 0.585f);
                } else {
                    initSize(i, i2, 0.42f, 0.7f);
                }
                int i4 = this.mContainerWidth;
                if (i4 < this.MIN_WIDTH) {
                    this.MIN_WIDTH = i4;
                }
            }
        } else if (zIsTabletLayout) {
            this.MAX_TOP_MARGIN = 0;
            if (zIsFoldableModel) {
                initSize(i, i2, 0.42f, 0.5f);
            } else {
                initSize(i, i2, 0.3f, 0.42f);
            }
        } else {
            this.MAX_TOP_MARGIN = context.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_max_top_margin);
            initSize(i, i2, 0.42f, 0.5f);
            int i5 = this.mContainerWidth;
            if (i5 < this.MIN_WIDTH) {
                this.MIN_WIDTH = i5;
            }
        }
        updateMaxHeightSize(this.mFragmentView.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSizeForResultView(Configuration configuration) {
        Logger.m11003i(TAG, "initSizeForResultView#");
        final AiResultLayout aiResultLayout = (AiResultLayout) this.mLayoutContainer;
        if (configuration == null) {
            configuration = aiResultLayout.getResources().getConfiguration();
        }
        boolean zIsPhoneLayout = isPhoneLayout();
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(this.mFragmentView.getContext(), configuration.screenHeightDp);
        int iConvertDpToPixel2 = (int) ResourceUtils.convertDpToPixel(this.mFragmentView.getContext(), configuration.screenWidthDp);
        final int paneMode = aiResultLayout.getPaneMode();
        AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
        float f = 0.45f;
        if (paneMode == companion.MODE_BOTTOM()) {
            if (this.mOldHeight != null) {
                this.mResultContainer.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.30
                    @Override // java.lang.Runnable
                    public void run() {
                        aiResultLayout.setResultHeight(paneMode, AiMenuResultLayoutManager.this.mOldHeight);
                        if (AiMenuResultLayoutManager.this.mOldHeight.intValue() > AiMenuResultLayoutManager.this.mMinimizeHeight) {
                            aiResultLayout.enterMinimizeView(false);
                        }
                        AiMenuResultLayoutManager.this.mOldHeight = null;
                    }
                });
                return;
            }
            float f4 = iConvertDpToPixel;
            if (isCreateImageRunning()) {
                f = 0.6f;
            } else if (zIsPhoneLayout || this.mIsMultiWindow) {
                f = 0.5f;
            }
            aiResultLayout.setResultHeight(paneMode, Integer.valueOf((int) (f4 * f)));
            return;
        }
        if (paneMode != companion.MODE_SIDE()) {
            if (paneMode == companion.MODE_FLOATING()) {
                aiResultLayout.setResultHeight(paneMode, Integer.valueOf((int) (iConvertDpToPixel * (isPortrait() ? 0.48f : 0.58f))));
            }
        } else {
            float f5 = iConvertDpToPixel2;
            int i = (int) (0.45f * f5);
            aiResultLayout.setResultWidth(paneMode, Integer.valueOf(i));
            aiResultLayout.setMinWidth(paneMode, Integer.valueOf((int) (f5 * 0.32f)));
            this.mTagetSizeForSideMode = Integer.valueOf(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBottomMenuSupported() {
        if (getCurrentPageView() != null) {
            return getCurrentPageView().isBottomMenuSupported();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCreateImageRunning() {
        return this.mContract.getPresenter().isCreateImageRunning();
    }

    private boolean isMarginUpdateRequired() {
        boolean zIsPortrait = isPortrait();
        boolean zIsTabletLayout = this.mContract.getPresenter().isTabletLayout();
        boolean z = ModelFeature.getFeature().isFoldableModel() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(this.mCommonViews.mActivity.getResources().getConfiguration());
        boolean zIsFreeFormWindow = WindowManagerCompat.getInstance().isFreeFormWindow(this.mCommonViews.mActivity);
        boolean zIsMultiWindowMode = WindowManagerCompat.getInstance().isMultiWindowMode(this.mCommonViews.mActivity);
        String str = TAG;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("isPortrait: ", " isTabletLayout: ", " isMainDisplayOfFoldModel: ", zIsPortrait, zIsTabletLayout);
        AbstractC2821a.m2208C(sbM2230u, z, " isFreeFormWindow: ", zIsFreeFormWindow, " isMultiWindowMode: ");
        AbstractC8014b.m7215q(sbM2230u, zIsMultiWindowMode, str);
        return zIsPortrait || zIsTabletLayout || zIsFreeFormWindow || zIsMultiWindowMode || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPhoneLayout() {
        return (this.mContract.getPresenter().isTabletLayout() || (ModelFeature.getFeature().isFoldableModel() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(this.mFragmentView.getResources().getConfiguration()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait() {
        return this.mOrientation == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStreaming() {
        if (getCurrentPageView() != null) {
            return getCurrentPageView().isStreaming();
        }
        return false;
    }

    private boolean isWidthHandleSupported() {
        if (this.mOrientation == 2) {
            return !isCreateImageRunning() || com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils.isLargeHandsetLayout(this.mCommonViews.mActivity);
        }
        return false;
    }

    private void makeAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mHideAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.mHideAnimator.setDuration(200L);
        this.mHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                AiMenuResultLayoutManager.this.mResultContainer.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mHideAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AiMenuResultLayoutManager.this.mResultContainer.setAlpha(1.0f);
                AiMenuResultLayoutManager.this.mResultContainer.setVisibility(8);
                Logger.m11003i(AiMenuResultLayoutManager.TAG, "hide Animation end");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AiMenuResultLayoutManager.this.mResultContainer.setVisibility(0);
                Logger.m11003i(AiMenuResultLayoutManager.TAG, "hide Animation start");
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mShowAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.mShowAnimator.setDuration(200L);
        this.mShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                AiMenuResultLayoutManager.this.mResultContainer.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mShowAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AiMenuResultLayoutManager.this.mResultContainer.setAlpha(1.0f);
                AiMenuResultLayoutManager.this.mResultContainer.setVisibility(0);
                AiMenuResultLayoutManager.this.mIsPreTouchHiding = false;
                Logger.m11003i(AiMenuResultLayoutManager.TAG, "show Animation end");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AiMenuResultLayoutManager.this.mResultContainer.setVisibility(0);
                Logger.m11003i(AiMenuResultLayoutManager.TAG, "show Animation start");
            }
        });
    }

    private void makePreTouchListener() {
        ComposerViewPresenter composerViewPresenter = this.mContract.getPresenter().getComposerViewPresenter();
        final ComposerModel composerModel = composerViewPresenter.getComposerModel();
        this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.7
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ModeManager modeManager = composerModel.getModeManager();
                if ((!modeManager.isMode(Mode.Writing) && !modeManager.isMode(Mode.ReadOnly)) || AiMenuResultLayoutManager.this.mCurrentMode != AiResultLayout.INSTANCE.MODE_FLOATING()) {
                    return false;
                }
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2 || actionMasked == 213) {
                    if (!AiMenuResultLayoutManager.this.hasTouchPosition(motionEvent) || AiMenuResultLayoutManager.this.mIsPreTouchHiding) {
                        return false;
                    }
                    AiMenuResultLayoutManager.this.mIsPreTouchHiding = true;
                    AiMenuResultLayoutManager.this.startHideAnimation();
                    return false;
                }
                if ((actionMasked != 1 && actionMasked != 212 && actionMasked != 3 && actionMasked != 214) || !AiMenuResultLayoutManager.this.mIsPreTouchHiding) {
                    return false;
                }
                AiMenuResultLayoutManager.this.startShowAnimation();
                return false;
            }
        };
        composerViewPresenter.getListenerManager().addPreTouchListener(this.mPreTouchListener);
        composerViewPresenter.getListenerManager().getOnDragListener().setDragEventAIResultViewDispatcher(new DragEventDispatcherToAiResultLayout(this));
        makeAnimation();
    }

    private void matchLandscapeLayout() {
        this.mCommonViews.getTopView().setOrientation(this.mOrientation);
        this.mHeightHandle.setVisible(false);
        this.mHeightHandle.clearState();
        this.mWidthHandle.setVisible(isWidthHandleSupported());
        this.mWidthHandle.clearState();
        updateLayoutContainerParams();
        updateTopContainerParams();
        updateViewPagerContainerParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void matchOrientationLayout() {
        if (this.mOrientation != 2) {
            updatePaddingLandscapeContainer(false);
            if (this.mLayoutContainer.getParent() == this.mPortraitContainer) {
                matchPortraitLayout();
                return;
            }
            this.mLandscapeContainer.removeView(this.mLayoutContainer);
            matchPortraitLayout();
            this.mPortraitContainer.addView(this.mLayoutContainer);
            return;
        }
        updatePaddingLandscapeContainer(true);
        if (this.mLayoutContainer.getParent() == this.mLandscapeContainer) {
            matchLandscapeLayout();
            return;
        }
        this.mPortraitContainer.removeView(this.mLayoutContainer);
        matchLandscapeLayout();
        this.mLandscapeContainer.addView(this.mLayoutContainer);
        this.mLandscapeContainer.requestLayout();
    }

    private void matchPortraitLayout() {
        this.mCommonViews.getTopView().setOrientation(this.mOrientation);
        this.mWidthHandle.setVisible(isWidthHandleSupported());
        this.mWidthHandle.clearState();
        this.mHeightHandle.setVisible(true);
        this.mHeightHandle.clearState();
        updateLayoutContainerParams();
        updateTopContainerParams();
        updateViewPagerContainerParams();
        if (this.mContract.getPresenter().isShowingSip()) {
            this.mHeightHandle.minimize();
        }
    }

    private void onLayoutContainerChangeMode(int i) {
        AbstractC8014b.m7217s(i, "onLayoutContainerChangeMode# ", TAG);
        int i2 = this.mCurrentMode;
        AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
        if (i2 == companion.MODE_SIDE()) {
            this.mLandscapeContainer.getLayoutParams().width = 0;
        } else if (this.mCurrentMode == companion.MODE_BOTTOM()) {
            this.mPortraitContainer.getLayoutParams().height = 0;
            this.mPortraitContainer.requestLayout();
        }
        this.mCurrentMode = i;
        if (this.mResultContainer == null) {
            return;
        }
        if (i != companion.MODE_FLOATING()) {
            this.mCommonViews.getTopView().setOrientation(i == companion.MODE_BOTTOM() ? 1 : 2);
        }
        this.mOldHeight = null;
        updateViewPagerContainerParamsOnNormal();
        if (!this.mIsShowingSIP) {
            this.mLayoutContainer.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.32
                @Override // java.lang.Runnable
                public void run() {
                    AiMenuResultLayoutManager.this.initSizeForResultView(null);
                }
            });
            return;
        }
        this.mIsShowingSIP = false;
        boolean zIsPhoneLayout = isPhoneLayout();
        boolean z = i == companion.MODE_BOTTOM() && !this.isEditResult;
        if (zIsPhoneLayout && this.isEditResult) {
            this.mContract.getPresenter().getSoftInputManager().hide(false);
            expandView();
        }
        this.mBelowViewPager.setVisibility(z ? 8 : 0);
        ((AiResultLayout) this.mLayoutContainer).enterMinimizeView(z);
        if (zIsPhoneLayout || i != companion.MODE_BOTTOM() || z) {
            return;
        }
        final int height = this.mAppbar.getHeight() + getFloatingToolbarHeight() + getViewHeight(this.mFixedBottom) + getViewHeight(this.mVoiceControllerView) + getViewHeight(this.mTranslateContainer);
        this.mResultContainer.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.31
            @Override // java.lang.Runnable
            public void run() {
                ((AiResultLayout) AiMenuResultLayoutManager.this.mLayoutContainer).setResultHeight(AiResultLayout.INSTANCE.MODE_BOTTOM(), Integer.valueOf(AiMenuResultLayoutManager.this.getFragmentHeight() - height));
            }
        });
    }

    private void preShow() {
        if (this.mViewPagerOnLayoutChangeListener == null) {
            this.mViewPagerOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.16
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    AiMenuContract.IAiActionResultView currentPageView;
                    int i10 = i4 - i;
                    int i11 = i5 - i2;
                    Logger.m10999d(AiMenuResultLayoutManager.TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(i8 - i6, i10, "viewpager onLayoutChange#: (", "/", ") ("), i9 - i7, i11, "/", ")"));
                    if ((i == i6 && i4 == i8 && i2 == i7 && i5 == i9) || (currentPageView = AiMenuResultLayoutManager.this.getCurrentPageView()) == null) {
                        return;
                    }
                    currentPageView.updateLayout(AiMenuResultLayoutManager.this.mOrientation == 2, i10, i11);
                }
            };
        }
        this.mViewPager.addOnLayoutChangeListener(this.mViewPagerOnLayoutChangeListener);
        initViewPagerGestureDetector();
        if (AiViewUtils.isSupportFloatingLayout()) {
            if (this.mFragmentViewOnLayoutChangeListener == null) {
                this.mFragmentViewOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.20
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                        if (i5 - i2 != i9 - i7 && ((AiResultLayout) AiMenuResultLayoutManager.this.mLayoutContainer).isMinimizeView()) {
                            AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                            if (aiMenuResultLayoutManager.mIsMultiWindow) {
                                ((AiResultLayout) aiMenuResultLayoutManager.mLayoutContainer).enterMinimizeView(false);
                                AiMenuResultLayoutManager.this.initSizeForResultView(null);
                            }
                        }
                        AiMenuResultLayoutManager.this.mIsMultiWindow = WindowManagerCompat.getInstance().isMultiWindowMode(AiMenuResultLayoutManager.this.mCommonViews.mActivity);
                    }
                };
            }
            this.mFragmentView.addOnLayoutChangeListener(this.mFragmentViewOnLayoutChangeListener);
            if (this.mLayoutContainerOnLayoutChangeListener == null) {
                this.mLayoutContainerOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.21
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                        if (i2 > i7) {
                            int i10 = AiMenuResultLayoutManager.this.mCurrentMode;
                            AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
                            if (i10 == companion.MODE_BOTTOM()) {
                                int floatingToolbarHeight = AiMenuResultLayoutManager.this.getFloatingToolbarHeight() + AiMenuResultLayoutManager.this.mAppbar.getHeight();
                                AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                                int viewHeight = aiMenuResultLayoutManager.getViewHeight(aiMenuResultLayoutManager.mFixedBottom) + floatingToolbarHeight;
                                AiMenuResultLayoutManager aiMenuResultLayoutManager2 = AiMenuResultLayoutManager.this;
                                int viewHeight2 = aiMenuResultLayoutManager2.getViewHeight(aiMenuResultLayoutManager2.mVoiceControllerView) + viewHeight;
                                AiMenuResultLayoutManager aiMenuResultLayoutManager3 = AiMenuResultLayoutManager.this;
                                int fragmentHeight = AiMenuResultLayoutManager.this.getFragmentHeight() - (aiMenuResultLayoutManager3.getViewHeight(aiMenuResultLayoutManager3.mTranslateContainer) + viewHeight2);
                                if (AiMenuResultLayoutManager.this.mResultContainer == null || AiMenuResultLayoutManager.this.mResultContainer.getHeight() <= fragmentHeight) {
                                    return;
                                }
                                ((AiResultLayout) AiMenuResultLayoutManager.this.mLayoutContainer).setResultHeight(companion.MODE_BOTTOM(), Integer.valueOf(fragmentHeight));
                            }
                        }
                    }
                };
            }
            this.mLayoutContainer.addOnLayoutChangeListener(this.mLayoutContainerOnLayoutChangeListener);
            return;
        }
        this.mViewPagerContainer.addOnLayoutChangeListener(this.mViewPagerContainerOnLayoutChangeListener);
        if (this.mFragmentViewOnLayoutChangeListener == null) {
            this.mFragmentViewOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.17
                int mLastBottomPadding = 0;

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    boolean z = this.mLastBottomPadding != view.getPaddingBottom();
                    this.mLastBottomPadding = view.getPaddingBottom();
                    int i10 = i8 - i6;
                    int i11 = i4 - i;
                    int i12 = i9 - i7;
                    int i13 = i5 - i2;
                    if (i10 != i11 || i12 != i13) {
                        AiMenuResultLayoutManager.this.updateMaxHeightSize(i13);
                    }
                    if (i10 != i11 && !AiMenuResultLayoutManager.this.isPortrait()) {
                        ViewGroup.LayoutParams layoutParams = AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutParams();
                        int i14 = layoutParams.width;
                        if (i14 > i11 / 2 || i14 < AiMenuResultLayoutManager.this.MIN_WIDTH) {
                            Logger.m10999d(AiConstants.LAYOUT_DEBUG_TAG, "layout width because layout is changed");
                            AiMenuResultLayoutManager.this.initSize(view.getContext(), i11, i13);
                            layoutParams.width = AiMenuResultLayoutManager.this.MIN_WIDTH;
                            AiMenuResultLayoutManager.this.mLayoutContainer.requestLayout();
                            AiMenuResultLayoutManager.this.mViewPager.requestLayout();
                            return;
                        }
                        return;
                    }
                    if (AiMenuResultLayoutManager.this.isPortrait() && ((i12 != i13 || z) && AiMenuResultLayoutManager.this.mLandscapeContainer.getTranslationY() == 0.0f && AiMenuResultLayoutManager.this.updateHeightOnTopContainerHeightChanged(i13))) {
                        return;
                    }
                    AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                    if (aiMenuResultLayoutManager.mIsRTL && i10 != i11 && aiMenuResultLayoutManager.mScrollState == 0) {
                        AiMenuResultLayoutManager.this.callSnapToPage();
                    }
                }
            };
        }
        this.mFragmentView.addOnLayoutChangeListener(this.mFragmentViewOnLayoutChangeListener);
        if (this.mAppBarOnLayoutChangeListener == null) {
            this.mAppBarOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.18
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    int i10 = i9 - i7;
                    if (i5 - i2 != i10 && i10 == 0 && AiMenuResultLayoutManager.this.isPortrait()) {
                        AiMenuResultLayoutManager.this.mContract.getPresenter().getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Logger.m10999d(AiMenuResultLayoutManager.TAG, "mAppBarOnLayoutChangeListener#");
                                AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                                aiMenuResultLayoutManager.updateHeightOnTopContainerHeightChanged(aiMenuResultLayoutManager.mFragmentView.getHeight());
                            }
                        }, 100L);
                    }
                }
            };
        }
        this.mAppbar.addOnLayoutChangeListener(this.mAppBarOnLayoutChangeListener);
        if (this.mVoiceControllerViewOnLayoutChangeListener == null) {
            this.mVoiceControllerViewOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.19
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (!AiMenuResultLayoutManager.this.isPortrait() || i5 == i9) {
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutParams();
                    int floatingToolbarHeight = AiMenuResultLayoutManager.this.getFloatingToolbarHeight() + AiMenuResultLayoutManager.this.mAppbar.getHeight();
                    AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                    int viewHeight = aiMenuResultLayoutManager.getViewHeight(aiMenuResultLayoutManager.mFixedBottom) + floatingToolbarHeight;
                    AiMenuResultLayoutManager aiMenuResultLayoutManager2 = AiMenuResultLayoutManager.this;
                    int viewHeight2 = aiMenuResultLayoutManager2.getViewHeight(aiMenuResultLayoutManager2.mVoiceControllerView) + viewHeight;
                    AiMenuResultLayoutManager aiMenuResultLayoutManager3 = AiMenuResultLayoutManager.this;
                    int fragmentHeight = AiMenuResultLayoutManager.this.getFragmentHeight() - (aiMenuResultLayoutManager3.getViewHeight(aiMenuResultLayoutManager3.mTranslateContainer) + viewHeight2);
                    if (layoutParams.height > fragmentHeight) {
                        layoutParams.height = fragmentHeight;
                        AiMenuResultLayoutManager.this.mLayoutContainer.requestLayout();
                        AiMenuResultLayoutManager.this.mPortraitContainer.requestLayout();
                    }
                }
            };
        }
        this.mVoiceControllerView.addOnLayoutChangeListener(this.mVoiceControllerViewOnLayoutChangeListener);
    }

    private void readyView(Activity activity) {
        ViewGroup viewGroup;
        activity.findViewById(C9086R.id.comp_end_container).setBackgroundResource(C9086R.drawable.ai_result_bg);
        ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(C9086R.id.comp_over_bottom_container).findViewById(C9086R.id.ai_menu_result_bottom_root_container);
        viewGroup2.setBackgroundResource(C9086R.drawable.ai_result_bg);
        if (activity.findViewById(C9086R.id.result_layout_content) != null) {
            return;
        }
        if (AiViewUtils.isSupportFloatingLayout()) {
            viewGroup = (ViewGroup) activity.findViewById(C9086R.id.ai_menu_result_layout_container);
        } else {
            viewGroup = (ViewGroup) activity.findViewById(C9086R.id.old_ai_menu_result_layout_container);
            if (viewGroup.getParent() != null) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            viewGroup2.addView(viewGroup);
        }
        viewGroup.setVisibility(0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(activity);
        this.mElevationTopMargin = 0;
        layoutInflaterFrom.inflate(C9086R.layout.ai_result_layout, viewGroup, true);
    }

    private void setBackgroundForResultView(Activity activity) {
        View viewFindViewById = this.mLayoutContainer.findViewById(C9086R.id.ai_menu_result_stt_help_container);
        if (AiViewUtils.isAtLeastOneUI85()) {
            this.mViewPagerContainer.setBackgroundResource(C9086R.drawable.ai_result_content_bg85);
            if (viewFindViewById != null) {
                viewFindViewById.setBackground(null);
            }
            this.mLayoutContent.setBackgroundResource(C9086R.drawable.ai_result_bg85);
            return;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{ContextCompat.getDrawable(activity, C9086R.drawable.ai_result_content_bg), getBackgroundGradient(activity)});
        this.mViewPagerContainer.setBackground(layerDrawable);
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(layerDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationBarColor(boolean z) {
        ViewGroup viewGroup;
        if (AiViewUtils.isAtLeastOneUI85()) {
            int paneMode = ((AiResultLayout) this.mLayoutContainer).getPaneMode();
            if (this.mIsMultiWindow || paneMode == AiResultLayout.INSTANCE.MODE_FLOATING() || !z) {
                View view = this.mNavigationBarBGView;
                if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
                    return;
                }
                viewGroup.removeView(this.mNavigationBarBGView);
                return;
            }
            Activity activity = this.mContract.getPresenter().getActivity();
            if (SettingsCompat.getInstance().hasGestureNavigationBar(activity)) {
                return;
            }
            int color = activity.getColor(C9086R.color.ai_menu_result_bg_color85);
            if (this.mNavigationBarBGView == null) {
                this.mNavigationBarBGView = new View(activity);
            }
            this.mNavigationBarBGView.setBackgroundColor(color);
            ViewGroup viewGroup2 = (ViewGroup) activity.getWindow().getDecorView();
            View childAt = viewGroup2.getChildAt(1);
            if (childAt != null) {
                this.mNavigationBarBGView.setLayoutParams(childAt.getLayoutParams());
                if (this.mNavigationBarBGView.getParent() == null) {
                    viewGroup2.addView(this.mNavigationBarBGView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewSize(View view, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateHeightOnTopContainerHeightChanged(int i) {
        int maxHeight = getMaxHeight(i) - this.mFragmentView.getPaddingBottom();
        int currentHeight = this.mHeightHandle.getCurrentHeight();
        if (maxHeight >= currentHeight || this.mHeightHandle.isMinimized()) {
            return false;
        }
        if (isFocusSTTWindow()) {
            this.mHeightHandle.setLastSize(this.mLayoutContainer.getLayoutParams().height);
            this.mHeightHandle.setLastSizeSTT(this.mLayoutContainer.getLayoutParams().height);
        }
        this.mLayoutContainer.getLayoutParams().height = maxHeight;
        this.mLayoutContainer.requestLayout();
        updateViewPagerHeight(this.mViewPager.getLayoutParams().height - (currentHeight - maxHeight));
        this.mViewPager.requestLayout();
        return true;
    }

    private void updateLayoutContainerParams() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mLayoutContainer.getLayoutParams();
        if (isPortrait()) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.mContainerHeight;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = this.mContainerWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMaxHeightSize(int i) {
        this.MAX_HEIGHT = -1;
        if (!isCreateImageRunning()) {
            int i2 = this.MAX_TOP_MARGIN;
            if (i2 == 0 || this.mIsMultiWindow) {
                return;
            }
            this.MAX_HEIGHT = i - i2;
            return;
        }
        boolean zIsFoldableModel = ModelFeature.getFeature().isFoldableModel();
        if (this.mContract.getPresenter().isTabletLayout()) {
            if (zIsFoldableModel) {
                this.MAX_HEIGHT = (int) (((double) i) * 0.765d);
                return;
            } else {
                this.MAX_HEIGHT = (int) (((double) i) * 0.55d);
                return;
            }
        }
        if (zIsFoldableModel) {
            this.MAX_HEIGHT = (int) (((double) i) * 0.585d);
        } else {
            this.MAX_HEIGHT = (int) (((double) i) * 0.7d);
        }
    }

    private void updateOrientationLayout(final Runnable runnable) {
        this.mFragmentView.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.25
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable2;
                if (!AiViewUtils.isSupportFloatingLayout()) {
                    AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                    aiMenuResultLayoutManager.initSize(aiMenuResultLayoutManager.mFragmentView.getContext(), AiMenuResultLayoutManager.this.mFragmentView.getMeasuredWidth(), AiMenuResultLayoutManager.this.mFragmentView.getMeasuredHeight());
                    AiMenuResultLayoutManager.this.matchOrientationLayout();
                }
                Iterator<AiMenuContract.IAiActionResultView> it = AiMenuResultLayoutManager.this.mContract.getPageTypeList().iterator();
                while (it.hasNext()) {
                    it.next().onOrientationChanged(AiMenuResultLayoutManager.this.mOrientation);
                }
                AiMenuResultLayoutManager.this.mContract.getPresenter().setAlwaysFitPageToScreen();
                if (AiViewUtils.isSupportFloatingLayout() || (runnable2 = runnable) == null) {
                    return;
                }
                runnable2.run();
            }
        }, 50L);
    }

    private void updatePaddingLandscapeContainer(boolean z) {
        ViewGroup viewGroup = this.mLandscapeContainer;
        if (viewGroup == null) {
            return;
        }
        int dimensionPixelSize = z ? viewGroup.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_bg_border) : 0;
        this.mLandscapeContainer.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    private void updateTopContainerParams() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCommonViews.getTopContainer().getLayoutParams();
        if (isPortrait()) {
            marginLayoutParams.setMargins(0, 0, 0, 0);
        } else {
            marginLayoutParams.setMargins(0, (int) ResourceUtils.convertDpToPixel(this.mLayoutContainer.getContext(), 15.0f), 0, 0);
        }
        this.mCommonViews.getTopView().updateVisibilityByWidth();
    }

    private void updateViewAutoTranscribeMargin(int i) {
        Context context;
        if (this.mViewAutoTranscribe.getVisibility() != 0 || (context = this.mViewAutoTranscribe.getContext()) == null) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_page_view_auto_transcribe_horizontal_margin_bottom);
        AbstractC8014b.m7216r(i, dimensionPixelSize, "updateViewAutoTranscribeMargin# marginH: ", ", marginV: ", TAG);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mViewAutoTranscribe.getLayoutParams();
        marginLayoutParams.setMargins(i, 0, i, dimensionPixelSize);
        this.mViewAutoTranscribe.setLayoutParams(marginLayoutParams);
    }

    private boolean updateViewPagerContainerMargin(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mViewPagerContainer.getLayoutParams();
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.rightMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.bottomMargin == i2) {
            return false;
        }
        AbstractC8014b.m7216r(i, i2, "updateViewPagerContainerMargin# marginH: ", ", marginV: ", TAG);
        marginLayoutParams.setMargins(i, i2, i, i2);
        this.mViewPagerContainer.setLayoutParams(marginLayoutParams);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewPagerContainerParamsOnCreateImage() {
        int measuredWidth;
        int measuredHeight;
        int measuredHeight2;
        int horizontalMarginViewPagerContainer = getHorizontalMarginViewPagerContainer(this.mViewPagerContainer.getContext().getResources());
        if (AiViewUtils.isSupportFloatingLayout()) {
            measuredWidth = this.mResultContainer.getMeasuredWidth();
            measuredHeight = (this.mResultContainer.getMeasuredHeight() - this.mLayoutContainer.findViewById(C9086R.id.ai_menu_result_handle_touch_area).getMeasuredHeight()) - this.mCommonViews.getBottomView().getView().getMeasuredHeight();
            measuredHeight2 = this.mBelowViewPager.getMeasuredHeight();
        } else {
            measuredWidth = this.mLayoutContainer.getMeasuredWidth();
            measuredHeight = (this.mLayoutContainer.getMeasuredHeight() - this.mLayoutContainer.findViewById(C9086R.id.ai_menu_result_handle_touch_area).getMeasuredHeight()) - this.mCommonViews.getBottomView().getView().getMeasuredHeight();
            measuredHeight2 = this.mBelowViewPager.getMeasuredHeight();
        }
        int i = measuredHeight - measuredHeight2;
        int iM7d = 0;
        if (isMarginUpdateRequired()) {
            if (measuredWidth < i) {
                if (!AiViewUtils.isSupportFloatingLayout() && !this.mContract.getPresenter().isTabletLayout()) {
                    horizontalMarginViewPagerContainer = 0;
                }
                iM7d = AbstractC0000a.m7d(i, measuredWidth, 2, horizontalMarginViewPagerContainer);
            } else {
                int iMax = Math.max(this.MIN_WIDTH, i);
                horizontalMarginViewPagerContainer = !AiViewUtils.isSupportFloatingLayout() ? (measuredWidth - iMax) / 2 : Math.max(horizontalMarginViewPagerContainer, (measuredWidth - iMax) / 2);
            }
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(measuredWidth, i, "updateViewPagerContainerParamsOnCreateImage, layoutContainerWidth: ", ", layoutContainerHeight: ", ", marginHorizontal: ");
        sbM1173s.append(horizontalMarginViewPagerContainer);
        sbM1173s.append(", marginVertical: ");
        sbM1173s.append(iM7d);
        Logger.m10999d(str, sbM1173s.toString());
        if (updateViewPagerContainerMargin(horizontalMarginViewPagerContainer, iM7d)) {
            updateViewAutoTranscribeMargin(horizontalMarginViewPagerContainer);
            if (this.mIsRTL) {
                callSnapToPage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewPagerContainerParamsOnNormal() {
        Context context = this.mViewPagerContainer.getContext();
        int horizontalMarginViewPagerContainer = getHorizontalMarginViewPagerContainer(context.getResources());
        if (AiViewUtils.isSupportFloatingLayout()) {
            Configuration configuration = this.mCommonViews.mActivity.getResources().getConfiguration();
            int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(this.mFragmentView.getContext(), configuration.screenWidthDp);
            boolean zIsTabletLayout = this.mContract.getPresenter().isTabletLayout();
            boolean z = ModelFeature.getFeature().isFoldableModel() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(configuration);
            int paneMode = ((AiResultLayout) this.mLayoutContainer).getPaneMode();
            AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
            if (paneMode == companion.MODE_BOTTOM()) {
                if (z) {
                    float f = iConvertDpToPixel;
                    horizontalMarginViewPagerContainer = (isPortrait() || configuration.screenWidthDp < 960) ? (int) (0.05f * f) : (int) ((f - ResourceUtils.convertDpToPixel(context, 840.0f)) / 2.0f);
                } else if (zIsTabletLayout) {
                    horizontalMarginViewPagerContainer = (int) ((isPortrait() ? iConvertDpToPixel * 0.1f : iConvertDpToPixel - ResourceUtils.convertDpToPixel(context, 840.0f)) / 2.0f);
                } else {
                    horizontalMarginViewPagerContainer = context.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_page_viewpager_container_horizontal_margin_portrait);
                }
            } else if (paneMode == companion.MODE_FLOATING()) {
                horizontalMarginViewPagerContainer = context.getResources().getDimensionPixelSize(C9086R.dimen.f6688x99076360);
            }
            this.mCommonViews.getTopView().setMarginTabLayout(horizontalMarginViewPagerContainer);
        }
        if (updateViewPagerContainerMargin(horizontalMarginViewPagerContainer, 0)) {
            updateViewAutoTranscribeMargin(horizontalMarginViewPagerContainer);
            if (this.mIsRTL) {
                callSnapToPage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateViewPagerHeight(int i) {
        if (this.mViewPager.getLayoutParams().height == i) {
            return false;
        }
        this.mViewPager.getLayoutParams().height = i;
        return true;
    }

    public void callSnapToPage() {
        if (this.mSnapToPageAction != null) {
            this.mContract.getPresenter().getHandler().removeCallbacks(this.mSnapToPageAction);
        }
        this.mSnapToPageAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.26
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultLayoutManager.this.snapToPage();
                AiMenuResultLayoutManager.this.mSnapToPageAction = null;
            }
        };
        this.mContract.getPresenter().getHandler().post(this.mSnapToPageAction);
    }

    public boolean canMinimize() {
        for (AiMenuContract.IAiActionResultView iAiActionResultView : this.mContract.getPageTypeList()) {
            if ((iAiActionResultView instanceof AiMenuResultViewRecognizedHw) && ((AiMenuResultViewRecognizedHw) iAiActionResultView).canShowingSip()) {
                return false;
            }
        }
        return this.mContract.getPresenter().isCanMinimizeMode();
    }

    @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragEventDispatcherToAiResultLayout.IAiMenuResultLayoutManager
    public boolean dispatchDragEvent(@NonNull View view, @NonNull DragEvent dragEvent) {
        if (this.mCurrentMode == AiResultLayout.INSTANCE.MODE_FLOATING()) {
            return hasDragDropPosition(view, dragEvent);
        }
        return false;
    }

    public void expandView() {
        Logger.m11003i(TAG, "expandView#");
        if (!AiViewUtils.isSupportFloatingLayout()) {
            if (isPortrait()) {
                this.mHeightHandle.expand();
            }
        } else {
            AiResultLayout aiResultLayout = (AiResultLayout) this.mLayoutContainer;
            if (aiResultLayout.getPaneMode() != AiResultLayout.INSTANCE.MODE_SIDE()) {
                aiResultLayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.29
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultLayoutManager.this.initSizeForResultView(null);
                    }
                });
            }
        }
    }

    public int getCurrentMode() {
        return this.mCurrentMode;
    }

    @Nullable
    public AiMenuContract.IAiActionResultView getCurrentPageView() {
        try {
            return this.mContract.getPageTypeList().get(this.mViewPager.getCurrentItem());
        } catch (IndexOutOfBoundsException e) {
            Logger.m11000e(TAG, "getCurrentPageView# " + e.getMessage());
            return null;
        }
    }

    public View getLayoutContainer() {
        return this.mLayoutContainer;
    }

    public void hide() {
        View.OnLayoutChangeListener onLayoutChangeListener;
        Logger.m11003i(TAG, "hide#");
        setNavigationBarColor(false);
        this.mAppbar.removeOnLayoutChangeListener(this.mAppBarOnLayoutChangeListener);
        this.mViewPager.removeOnLayoutChangeListener(this.mViewPagerOnLayoutChangeListener);
        this.mViewPagerContainer.removeOnLayoutChangeListener(this.mViewPagerContainerOnLayoutChangeListener);
        this.mFragmentView.removeOnLayoutChangeListener(this.mFragmentViewOnLayoutChangeListener);
        this.mCommonViews.getTopView().hideDialogs();
        if (AiViewUtils.isSupportFloatingLayout()) {
            AiResultLayout aiResultLayout = (AiResultLayout) this.mLayoutContainer;
            aiResultLayout.hide();
            aiResultLayout.removeCallback();
            this.mPortraitContainer.getLayoutParams().height = 0;
            this.mLandscapeContainer.getLayoutParams().width = 0;
            this.mPortraitContainer.requestLayout();
            View view = this.mResultContainer;
            if (view != null && (onLayoutChangeListener = this.mResultContainerOnLayoutChangeListener) != null) {
                view.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
            AiResultViewFlickAnimation aiResultViewFlickAnimation = this.mRippleBGContentAnimation;
            if (aiResultViewFlickAnimation != null) {
                aiResultViewFlickAnimation.close();
                this.mRippleBGContentAnimation = null;
            }
            this.mLayoutContainer.removeOnLayoutChangeListener(this.mLayoutContainerOnLayoutChangeListener);
            this.mContract.getPresenter().getComposerViewPresenter().getListenerManager().removePreTouchListener(this.mPreTouchListener);
            this.mContract.getPresenter().getComposerViewPresenter().getListenerManager().getOnDragListener().setDragEventAIResultViewDispatcher(null);
            this.mHeightHandle.mResizeShowHideAnimation.hide();
            setViewSize(this.mLayoutContent, -1, -1);
        } else {
            if (this.mOrientation == 1) {
                this.mHeightHandle.clearState();
            } else {
                this.mWidthHandle.clearState();
            }
            this.mLayoutContainer.setVisibility(8);
            this.mVoiceControllerView.removeOnLayoutChangeListener(this.mVoiceControllerViewOnLayoutChangeListener);
        }
        updatePaddingLandscapeContainer(false);
    }

    public void init(AiMenuResultCommonViews aiMenuResultCommonViews) {
        this.mCommonViews = aiMenuResultCommonViews;
        if (this.mViewPagerContainerOnLayoutChangeListener == null) {
            this.mViewPagerContainerOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.13
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    int i10 = i9 - i7;
                    int i11 = i5 - i2;
                    int i12 = i8 - i6;
                    int i13 = i2 - i;
                    if (AiMenuResultLayoutManager.this.isCreateImageRunning() && (i10 != i11 || i12 != i13)) {
                        AiMenuResultLayoutManager.this.updateViewPagerContainerParams();
                    }
                    if (i10 != i11) {
                        if (AiMenuResultLayoutManager.this.updateViewPagerHeight(i11)) {
                            AiMenuResultLayoutManager.this.mViewPager.requestLayout();
                        }
                        AbstractC0000a.m3D(i11, "ViewPagerContainer#onLayoutChange# height is changed: ", AiConstants.LAYOUT_DEBUG_TAG);
                    } else if (AiMenuResultLayoutManager.this.updateViewPagerHeight(i11)) {
                        AiMenuResultLayoutManager.this.mViewPager.requestLayout();
                        Logger.m10999d(AiConstants.LAYOUT_DEBUG_TAG, "ViewPagerContainer#onLayoutChange# mismatch: " + i11);
                    }
                }
            };
        }
        this.mViewPagerContainer.addOnLayoutChangeListener(this.mViewPagerContainerOnLayoutChangeListener);
        this.mHeightHandle = new HeightHandle(this.mLayoutContainer);
        this.mWidthHandle = new WidthHandle(this.mLayoutContainer);
        if (AiViewUtils.isSupportFloatingLayout()) {
            return;
        }
        matchOrientationLayout();
    }

    public void initViewPagerGestureDetector() {
        if (this.mViewPagerGestureDetector == null) {
            this.mViewPagerGestureDetector = new GestureDetector(this.mViewPager.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.14
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(@Nullable MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f4) {
                    if (motionEvent != null && AiMenuResultLayoutManager.this.mScrollState == 0 && AiMenuResultLayoutManager.this.isBottomMenuSupported() && Math.abs(motionEvent2.getRawY() - motionEvent.getRawY()) >= 42.0f && !AiMenuResultLayoutManager.this.mCommonViews.getBottomView().isShowing() && !AiMenuResultLayoutManager.this.mCommonViews.getBottomView().isEditMode() && AiMenuResultLayoutManager.this.canMinimize() && !AiMenuResultLayoutManager.this.isStreaming()) {
                        AiMenuResultLayoutManager.this.mCommonViews.getBottomView().show(true);
                    }
                    return false;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                    if (!AiMenuResultLayoutManager.this.isBottomMenuSupported()) {
                        return false;
                    }
                    if (AiMenuResultLayoutManager.this.mCommonViews.getBottomView().mContract.getPresenter().getSTTTabletLayoutAction() != null && DeviceInfo.isVSTModel()) {
                        return false;
                    }
                    if (AiMenuResultLayoutManager.this.mCommonViews.getBottomView().isShowing() && !AiMenuResultLayoutManager.this.mCommonViews.getBottomView().isEditMode() && !AiMenuResultLayoutManager.this.mCommonViews.mContract.getPresenter().isSTTSelectionMode() && !AiMenuResultLayoutManager.this.mCommonViews.mContract.getPresenter().isSTTSelectionSummaryMode()) {
                        AiMenuResultLayoutManager.this.mCommonViews.getBottomView().isPositionInRect((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        return false;
                    }
                    if (AiMenuResultLayoutManager.this.canMinimize() && !AiMenuResultLayoutManager.this.isStreaming()) {
                        AiMenuResultLayoutManager.this.mCommonViews.getBottomView().showDelay();
                    }
                    return false;
                }
            });
        }
        this.mViewPagerContainer.setPreTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.15
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AiMenuResultLayoutManager.this.mViewPagerGestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.mCommonViews.getBottomView().show(false);
    }

    public void insertSALog(String str) {
        ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_SPLIT_OVER_HANDLER, str);
    }

    public void insertSALogAiResultViewSplitHandler(Rect rect) {
        int paneMode = ((AiResultLayout) this.mLayoutContainer).getPaneMode();
        AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
        if (paneMode == companion.MODE_BOTTOM()) {
            int height = this.mLayoutContent.getHeight();
            int iHeight = rect.height();
            if (iHeight > height) {
                insertSALog("a");
                return;
            } else {
                if (iHeight < height) {
                    insertSALog("b");
                    return;
                }
                return;
            }
        }
        if (paneMode != companion.MODE_SIDE()) {
            if (paneMode == companion.MODE_FLOATING()) {
                insertSALog("f");
                return;
            }
            return;
        }
        int width = this.mLayoutContent.getWidth();
        int iWidth = rect.width();
        if (iWidth > width) {
            insertSALog("d");
        } else if (iWidth < width) {
            insertSALog("e");
        }
    }

    public boolean isFocusSTTWindow() {
        if (isPortrait()) {
            return this.mContract.getPresenter().isFocusingSTTSearchMode() || this.mContract.getPresenter().isFocusingSTTEditMode();
        }
        return false;
    }

    public boolean isMinimizeView() {
        if (AiViewUtils.isSupportFloatingLayout()) {
            return ((AiResultLayout) this.mLayoutContainer).isMinimizeView();
        }
        return false;
    }

    public void minimize() {
        View view;
        if (!AiViewUtils.isSupportFloatingLayout()) {
            if (isPortrait()) {
                if (canMinimize()) {
                    this.mHeightHandle.minimize();
                    return;
                } else {
                    if (isFocusSTTWindow()) {
                        this.mHeightHandle.setLastSizeSTT();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        AiResultLayout aiResultLayout = (AiResultLayout) this.mLayoutContainer;
        int paneMode = aiResultLayout.getPaneMode();
        AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
        if (paneMode == companion.MODE_BOTTOM()) {
            if (this.mOldHeight == null && (view = this.mResultContainer) != null) {
                this.mOldHeight = Integer.valueOf(view.getHeight());
            }
            if (this.isFocusEditResult || this.mContract.getPresenter().isFocusingSTTSearchMode() || this.mContract.getPresenter().isFocusingSTTEditMode() || this.mContract.getPresenter().isEditingRecognizedHw()) {
                Logger.m11003i(TAG, "startEditResultView#");
                this.isEditResult = true;
                if (this.mFragmentView.getPaddingBottom() == 0) {
                    aiResultLayout.setResultHeight(companion.MODE_BOTTOM(), Integer.valueOf(aiResultLayout.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_min_height_phone_layout) + 1));
                    this.mPortraitContainer.getLayoutParams().height = 0;
                }
            } else {
                Logger.m11003i(TAG, "stopEditResultView#");
                this.isEditResult = false;
                this.mPortraitContainer.getLayoutParams().height = this.mMinimizeHeight;
            }
            this.mPortraitContainer.requestLayout();
            this.mBelowViewPager.setVisibility(this.isEditResult ? 0 : 8);
            aiResultLayout.enterMinimizeView(!this.isEditResult);
        }
    }

    public void onConfigurationChanged(Configuration configuration, boolean z, int i) {
        String str = TAG;
        AbstractC8014b.m7224z("onConfigurationChanged# isOrientationChanged: ", str, z);
        int i2 = this.mOrientation;
        int i4 = configuration.orientation;
        boolean z2 = i2 != i4;
        this.mOrientation = i4;
        this.mIsShowingSIP = this.mContract.getPresenter().getSoftInputManager().isInputMethodShown();
        if (this.mCurrentMode != AiResultLayout.INSTANCE.MODE_FLOATING()) {
            if ((AiViewUtils.isSupportFloatingLayout() ? ((AiResultLayout) this.mLayoutContainer).getIsKeepSelectedPaneMode() : false) || !z) {
                if (AiViewUtils.isSupportFloatingLayout()) {
                    initSizeForResultView(configuration);
                }
            } else if (configuration.screenHeightDp >= configuration.screenWidthDp) {
                this.mLandscapeContainer.getLayoutParams().width = 0;
            } else {
                this.mPortraitContainer.getLayoutParams().height = 0;
                this.mPortraitContainer.requestLayout();
                this.mLandscapeContainer.getLayoutParams().width = (int) ResourceUtils.convertDpToPixel(this.mFragmentView.getContext(), configuration.screenWidthDp * 0.45f);
                this.mTagetSizeForSideMode = Integer.valueOf(this.mLandscapeContainer.getLayoutParams().width);
            }
        }
        if (z2 && !z) {
            Logger.m11000e(str, "onConfigurationChanged# mismatch orientation");
        }
        if (!z && !z2) {
            this.mIsRotate = Boolean.FALSE;
            return;
        }
        this.mIsRotate = Boolean.TRUE;
        onOrientationChanged(i);
        this.mCommonViews.getTopView().hideDialogs();
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout.FloatingPaneCallback
    public void onFloatingMoved(int i, int i2) {
        AbstractC14516b.m15114b(i, i2, "onFloatingMoved# left: ", " - top: ", TAG);
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout.FloatingPaneCallback
    public void onInsert(Rect rect) {
        if (rect == null) {
            Logger.m10999d(TAG, "onInsert# rect is null");
            return;
        }
        if (this.mResultContainer == null) {
            Logger.m10999d(TAG, "onInsert# mResultContainer is null");
            return;
        }
        Logger.m10999d(TAG, "onInsert# height: " + rect.height() + " - width: " + rect.width());
        this.mIsRotate = Boolean.FALSE;
        AiResultLayout aiResultLayout = (AiResultLayout) this.mLayoutContainer;
        int paneMode = aiResultLayout.getPaneMode();
        AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
        if (paneMode == companion.MODE_BOTTOM() && rect.height() < this.mMinimizeHeight && this.mStateResize != -1) {
            insertSALog("c");
            this.mContract.hide();
            return;
        }
        this.mCommonViews.mResultProgress.updateBGEffect();
        insertSALogAiResultViewSplitHandler(rect);
        setViewSize(this.mLayoutContent, -1, -1);
        boolean zIsMinimizeView = aiResultLayout.isMinimizeView();
        if (paneMode == companion.MODE_SIDE()) {
            Integer num = this.mTagetSizeForSideMode;
            if ((num != null && num.intValue() == rect.width()) || this.mOnResize) {
                this.mLandscapeContainer.getLayoutParams().width = Math.max(rect.width(), (int) ResourceUtils.convertDpToPixel(this.mFragmentView.getContext(), aiResultLayout.getResources().getConfiguration().screenWidthDp * 0.32f));
                this.mPortraitContainer.getLayoutParams().height = 0;
                this.mPortraitContainer.requestLayout();
                this.mOnResize = false;
            }
        } else if (paneMode == companion.MODE_BOTTOM()) {
            this.mLandscapeContainer.getLayoutParams().width = 0;
            this.mPortraitContainer.getLayoutParams().height = !zIsMinimizeView ? rect.height() : this.mLayoutContainer.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_top_margin);
            this.mPortraitContainer.requestLayout();
        }
        if (!zIsMinimizeView && this.mIsMinimizeView) {
            this.mCommonViews.mResultProgress.stopEffect();
        }
        this.mIsMinimizeView = zIsMinimizeView;
        this.mBelowViewPager.setVisibility(zIsMinimizeView ? 8 : 0);
        this.mCommonViews.getTopView().minimizeView(this.mCurrentMode, zIsMinimizeView);
        this.mContract.getPresenter().onMinimize(zIsMinimizeView);
        if (this.mPageIndexToUpdate > -1 && this.mUpdatePageRunnable == null) {
            this.mUpdatePageRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AiMenuResultLayoutManager.this.mViewPager != null) {
                        if (!AiMenuResultLayoutManager.this.mViewPager.isFakeDragging() || AiMenuResultLayoutManager.this.mViewPager.endFakeDrag()) {
                            AiMenuResultLayoutManager.this.mViewPager.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AiMenuResultLayoutManager.this.mViewPager.setCurrentItem(AiMenuResultLayoutManager.this.mPageIndexToUpdate);
                                    AiMenuResultLayoutManager.this.mPageIndexToUpdate = -1;
                                    AiMenuResultLayoutManager.this.mUpdatePageRunnable = null;
                                }
                            });
                        }
                    }
                }
            };
            this.mContract.getPresenter().getHandler().postDelayed(this.mUpdatePageRunnable, 100L);
        }
        updateViewPagerContainerParams();
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout.FloatingPaneCallback
    public void onModeChanged(int i) {
        AbstractC8014b.m7217s(i, "onModeChanged# ", TAG);
        Boolean bool = this.mIsRotate;
        if (bool != null && !bool.booleanValue()) {
            ((AiResultLayout) this.mLayoutContainer).setKeepSelectedPaneMode(true);
        }
        if (this.mIsRotate == null) {
            this.mIsRotate = Boolean.FALSE;
        }
        onLayoutContainerChangeMode(i);
        this.mPageIndexToUpdate = this.mViewPager.isFakeDragging() ? 1 : this.mViewPager.getCurrentItem();
        this.mHeightHandle.mResizeShowHideAnimation.hide();
        this.mWidthHandle.mResizeShowHideAnimation.hide();
        int currentScreenIdByAiActions = this.mContract.getPresenter().getCurrentScreenIdByAiActions();
        if (currentScreenIdByAiActions == 9005) {
            ComposerSA.insertLog("816", ComposerSAConstants.EVENT_AI_RESULT_VIEW_TYPE_AFTER_CHANGING_TYPE, ComposerSA.getAiResultViewMode(i));
        } else if (currentScreenIdByAiActions != 9000) {
            ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_RESULT_VIEW_TYPE_AFTER_CHANGING_TYPE, ComposerSA.getAiResultViewMode(i));
        }
    }

    public void onOrientationChanged(final int i) {
        AbstractC0000a.m3D(i, "onOrientationChanged previousPageIndex# ", TAG);
        this.mPageIndexToUpdate = i;
        updateOrientationLayout(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.27
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultLayoutManager.this.callSnapToPage();
                AiMenuResultLayoutManager.this.mContract.getPresenter().getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.27.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AiMenuResultLayoutManager.this.mViewPager != null) {
                            AbstractC8014b.m7221w(new StringBuilder("onOrientationChanged# setCurrentItem: "), AiMenuResultLayoutManager.TAG, i);
                            AiMenuResultLayoutManager.this.mViewPager.setCurrentItem(i);
                        }
                    }
                }, 50L);
            }
        });
        this.mCommonViews.getBottomView().hideAddToListPopup();
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout.FloatingPaneCallback
    public void onPreInsert(Rect rect) {
        if (rect == null) {
            Logger.m10999d(TAG, "onPreInsert# rect is null");
            return;
        }
        Logger.m10999d(TAG, "onPreInsert# height: " + rect.height() + " - width: " + rect.width());
        if (this.mResultContainer != null) {
            setViewSize(this.mLayoutContent, rect.width(), rect.height());
            return;
        }
        this.mResultContainer = this.mLayoutContainer.getChildAt(1);
        createResultContainerListener();
        this.mResultContainer.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.1
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultLayoutManager.this.initSizeForResultView(null);
                AiMenuResultLayoutManager.this.mCommonViews.inLayoutFinished();
            }
        });
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout.FloatingPaneCallback
    public void onResizeAnimate(@NonNull Rect rect, @NonNull Rect rect2, long j) {
        Logger.m11003i(TAG, "onResizeAnimate# from: " + rect + " - to: " + rect2 + " - duration: " + j);
        setViewSize(this.mLayoutContent, rect2.width(), rect2.height());
    }

    public void onShowSip() {
        AbstractC8014b.m7222x(new StringBuilder("onShowSip# isEditResult: "), this.isEditResult, TAG);
        View view = this.mResultContainer;
        if (view != null) {
            view.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.28
                @Override // java.lang.Runnable
                public void run() {
                    AiResultLayout aiResultLayout = (AiResultLayout) AiMenuResultLayoutManager.this.mLayoutContainer;
                    int paneMode = aiResultLayout.getPaneMode();
                    AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
                    if (paneMode == companion.MODE_BOTTOM()) {
                        if (!AiMenuResultLayoutManager.this.isEditResult || AiMenuResultLayoutManager.this.mFragmentView.getPaddingBottom() <= 0) {
                            if (AiMenuResultLayoutManager.this.isEditResult || aiResultLayout.isMinimizeView()) {
                                return;
                            }
                            AiMenuResultLayoutManager.this.mBelowViewPager.setVisibility(8);
                            aiResultLayout.enterMinimizeView(true);
                            return;
                        }
                        int floatingToolbarHeight = AiMenuResultLayoutManager.this.getFloatingToolbarHeight() + AiMenuResultLayoutManager.this.mAppbar.getHeight();
                        AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                        int viewHeight = aiMenuResultLayoutManager.getViewHeight(aiMenuResultLayoutManager.mFixedBottom) + floatingToolbarHeight;
                        AiMenuResultLayoutManager aiMenuResultLayoutManager2 = AiMenuResultLayoutManager.this;
                        int viewHeight2 = aiMenuResultLayoutManager2.getViewHeight(aiMenuResultLayoutManager2.mVoiceControllerView) + viewHeight;
                        AiMenuResultLayoutManager aiMenuResultLayoutManager3 = AiMenuResultLayoutManager.this;
                        int fragmentHeight = AiMenuResultLayoutManager.this.getFragmentHeight() - (aiMenuResultLayoutManager3.getViewHeight(aiMenuResultLayoutManager3.mTranslateContainer) + viewHeight2);
                        if (fragmentHeight <= aiResultLayout.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_min_height_phone_layout) || AiMenuResultLayoutManager.this.mResultContainer.getHeight() == fragmentHeight) {
                            return;
                        }
                        aiResultLayout.setResultHeight(companion.MODE_BOTTOM(), Integer.valueOf(fragmentHeight));
                        AbstractC8014b.m7217s(fragmentHeight, "new Height = ", AiMenuResultLayoutManager.TAG);
                    }
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout.FloatingPaneCallback
    public void onStateChanged(int i) {
        AbstractC8014b.m7217s(i, "onStateChanged#", TAG);
        final int paneMode = ((AiResultLayout) this.mLayoutContainer).getPaneMode();
        AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
        if (paneMode != companion.MODE_FLOATING()) {
            if (i == companion.STATE_IDLE()) {
                if (this.mStateResize == companion.STATE_MOVE()) {
                    this.mResultContainer.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (paneMode != AiResultLayout.INSTANCE.MODE_BOTTOM()) {
                                AiMenuResultLayoutManager.this.mWidthHandle.mResizeShowHideAnimation.hide();
                                AiMenuResultLayoutManager.this.mLandscapeContainer.getLayoutParams().width = AiMenuResultLayoutManager.this.mResultContainer.getWidth();
                            } else {
                                AiMenuResultLayoutManager.this.mHeightHandle.mResizeShowHideAnimation.hide();
                                AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                                aiMenuResultLayoutManager.setViewSize(aiMenuResultLayoutManager.mLayoutContent, -1, -1);
                                AiMenuResultLayoutManager.this.mPortraitContainer.getLayoutParams().height = AiMenuResultLayoutManager.this.mResultContainer.getHeight();
                                AiMenuResultLayoutManager.this.mPortraitContainer.requestLayout();
                            }
                        }
                    });
                    this.mStateResize = -1;
                    return;
                }
            } else if (i == companion.STATE_RESIZE()) {
                View view = this.mLayoutContent;
                setViewSize(view, view.getWidth(), this.mLayoutContent.getHeight());
                this.mOnResize = paneMode == companion.MODE_SIDE();
            }
            this.mStateResize = i;
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout.FloatingPaneCallback
    public void onVisibilityChanged(int i) {
        AbstractC8014b.m7217s(i, "onVisibilityChanged#", TAG);
        if (i != 8 || this.mIsPreTouchHiding || this.mHideAnimator.isRunning() || this.mShowAnimator.isRunning()) {
            return;
        }
        this.mContract.hide();
    }

    public void setEnabledFlickAnimation(boolean z) {
        AiResultViewFlickAnimation aiResultViewFlickAnimation = this.mRippleBGContentAnimation;
        if (aiResultViewFlickAnimation != null) {
            aiResultViewFlickAnimation.setEnabledAnimation(z);
        }
    }

    public void setFocusEditResult(boolean z) {
        this.isFocusEditResult = z;
    }

    public void setPageIndexToUpdate(int i) {
        this.mPageIndexToUpdate = i;
    }

    public void setScrollState(int i) {
        AiResultViewFlickAnimation aiResultViewFlickAnimation;
        this.mScrollState = i;
        if (!AiViewUtils.isAtLeastOneUI85() || (aiResultViewFlickAnimation = this.mRippleBGContentAnimation) == null) {
            return;
        }
        if (i == 1) {
            aiResultViewFlickAnimation.startShowAnimation();
        } else if (i == 0) {
            aiResultViewFlickAnimation.startHideAnimation();
            setEnabledFlickAnimation(true);
        }
    }

    public void show(boolean z) {
        Logger.m11003i(TAG, "show#");
        preShow();
        if (!AiViewUtils.isSupportFloatingLayout()) {
            matchOrientationLayout();
            this.mLayoutContainer.setVisibility(0);
            return;
        }
        this.mStateResize = -1;
        ViewGroup viewGroup = this.mLayoutContainer;
        final AiResultLayout aiResultLayout = (AiResultLayout) viewGroup;
        viewGroup.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.22
            @Override // java.lang.Runnable
            public void run() {
                aiResultLayout.show();
                AiMenuResultLayoutManager.this.setNavigationBarColor(true);
            }
        }, z ? 400L : 150L);
        onLayoutContainerChangeMode(aiResultLayout.getPaneMode());
        updateViewPagerContainerParams();
    }

    public void snapToPage() {
        Logger.m10999d(TAG, "snapToPage#");
        try {
            Method declaredMethod = ViewPager2.class.getDeclaredMethod("snapToPage", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.mViewPager, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Logger.m11001e(TAG, "snapToPage# " + e.getMessage(), e);
        }
    }

    public void startHideAnimation() {
        if (this.mShowAnimator.isRunning()) {
            this.mHideAnimator.setCurrentFraction(1.0f - this.mShowAnimator.getAnimatedFraction());
            this.mShowAnimator.cancel();
        }
        this.mHideAnimator.start();
    }

    public void startShowAnimation() {
        if (this.mHideAnimator.isRunning()) {
            this.mShowAnimator.setCurrentFraction(1.0f - this.mHideAnimator.getAnimatedFraction());
            this.mHideAnimator.cancel();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.12
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultLayoutManager.this.mShowAnimator.start();
            }
        }, 200L);
    }

    public void updateViewPagerContainerParams() {
        Runnable runnable = isCreateImageRunning() ? new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.23
            @Override // java.lang.Runnable
            public void run() {
                if (AiViewUtils.isSupportFloatingLayout() && AiMenuResultLayoutManager.this.mResultContainer == null) {
                    return;
                }
                AiMenuResultLayoutManager.this.updateViewPagerContainerParamsOnCreateImage();
            }
        } : new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.24
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultLayoutManager.this.updateViewPagerContainerParamsOnNormal();
            }
        };
        if (this.mViewPagerContainer.isInLayout()) {
            this.mLayoutContainer.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HeightHandle extends AbsHandle implements View.OnTouchListener {
        static final int NO_SIZE = -1;
        private boolean mIsLastMinimized;
        private int mLastSize;
        private int mLastSizeSTT;

        public HeightHandle(ViewGroup viewGroup) {
            super(viewGroup);
            this.OVERLAP_COLOR = viewGroup.getResources().getColor(C9086R.color.ai_menu_result_resize_overlap_color, null);
            this.mHandle = viewGroup.findViewById(C9086R.id.ai_menu_result_height_handle_container);
            if (AiViewUtils.isSupportFloatingLayout()) {
                this.mHandle.setVisibility(4);
            }
            this.mHandleTouchArea = viewGroup.findViewById(C9086R.id.ai_menu_result_handle_touch_area);
            if (!AiViewUtils.isSupportFloatingLayout()) {
                this.mHandle.setOnTouchListener(this);
                this.mHandleTouchArea.setOnTouchListener(this);
            }
            this.mResizeContainer = AiMenuResultLayoutManager.this.mFragmentView.findViewById(C9086R.id.window_resize_view);
            if (AiViewUtils.isAtLeastOneUI85() && AiMenuResultLayoutManager.this.isPhoneLayout()) {
                this.mResizeContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.mResizeContainer.requestLayout();
            }
            this.mComposerWindowView = this.mResizeContainer.findViewById(C9086R.id.top_window);
            this.mResultWindowView = this.mResizeContainer.findViewById(C9086R.id.bottom_window);
            this.mResizeView = this.mResizeContainer.findViewById(C9086R.id.window_resize_view_height);
            createResizeShowHideAnimation();
            this.mLocalElevationTopMargin = AiMenuResultLayoutManager.this.mElevationTopMargin;
        }

        public void applyResizeWindow(int i, boolean z) {
            int i2;
            int i4;
            int iCalculateSize = calculateSize(i);
            if (iCalculateSize > AiMenuResultLayoutManager.this.MIN_HEIGHT) {
                if (AiMenuResultLayoutManager.this.MAX_HEIGHT <= 0 || AiMenuResultLayoutManager.this.MAX_HEIGHT >= iCalculateSize) {
                    this.mIsLastMinimized = false;
                    this.mLastSize = -1;
                    this.mLastSizeSTT = -1;
                } else {
                    AbstractC0000a.m3D(iCalculateSize, "applyResizeWindow# result size is bigger: ", AiMenuResultLayoutManager.TAG);
                    iCalculateSize = AiMenuResultLayoutManager.this.MAX_HEIGHT;
                    this.mIsLastMinimized = false;
                    this.mLastSize = -1;
                    this.mLastSizeSTT = -1;
                }
                i2 = iCalculateSize;
                i4 = 0;
            } else if (this.mIsLastMinimized && z) {
                Logger.m10999d(AiMenuResultLayoutManager.TAG, "applyResizeWindow#hide");
                AiMenuResultLayoutManager.this.mContract.hide();
                AiMenuResultLayoutManager.this.insertSALog("c");
                return;
            } else {
                i4 = AiMenuResultLayoutManager.this.MIN_HEIGHT - this.mMinSize;
                i2 = AiMenuResultLayoutManager.this.MIN_HEIGHT;
                this.mIsLastMinimized = true;
            }
            if (i4 == 0) {
                AiMenuResultLayoutManager.this.mPortraitContainer.getLayoutParams().height = -2;
                AiMenuResultLayoutManager.this.mPortraitContainer.requestLayout();
            } else {
                AiMenuResultLayoutManager.this.mPortraitContainer.getLayoutParams().height = this.mMinSize;
            }
            if (z) {
                if (AiMenuResultLayoutManager.this.mContainerHeight < i2) {
                    AiMenuResultLayoutManager.this.insertSALog("a");
                } else if (AiMenuResultLayoutManager.this.mContainerHeight > i2) {
                    AiMenuResultLayoutManager.this.insertSALog("b");
                }
            }
            AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutParams().height = i2;
            if (AiMenuResultLayoutManager.this.mViewPager != null) {
                AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                aiMenuResultLayoutManager.updateViewPagerHeight(aiMenuResultLayoutManager.mViewPager.getLayoutParams().height - (this.mStartSize - i2));
                AbstractC8014b.m7221w(AbstractC0541b.m778t(i2, "applyResizeWindow# ", " / "), AiMenuResultLayoutManager.TAG, AiMenuResultLayoutManager.this.mViewPager.getLayoutParams().height);
            }
            AiMenuResultLayoutManager.this.mLayoutContainer.requestLayout();
            if (AiMenuResultLayoutManager.this.mViewPager != null) {
                AiMenuResultLayoutManager.this.mViewPager.requestLayout();
            }
        }

        public int calculateSize(int i) {
            int iMin = Math.min(this.mStartSize - i, this.mMaxSize);
            int iMax = this.mIsLastMinimized ? Math.max(iMin, 0) : Math.max(iMin, this.mMinSize);
            int i2 = this.mMaxSize;
            return iMax > i2 ? i2 : iMax;
        }

        public void clearState() {
            AiMenuResultLayoutManager.this.mLayoutContainer.setTranslationY(0.0f);
            AiMenuResultLayoutManager.this.mPortraitContainer.getLayoutParams().height = -2;
            AiMenuResultLayoutManager.this.mLayoutContainer.getLayoutParams().height = AiMenuResultLayoutManager.this.mContainerHeight;
            if (AiMenuResultLayoutManager.this.mViewPager != null && AiMenuResultLayoutManager.this.mViewPager.getLayoutParams().height != -1) {
                AiMenuResultLayoutManager.this.mViewPager.getLayoutParams().height = AiMenuResultLayoutManager.this.mContainerHeight;
            }
            this.mResizeShowHideAnimation.clearState();
            clearResizeWindow();
            this.mLastSize = -1;
            this.mLastSizeSTT = -1;
            this.mIsLastMinimized = false;
        }

        public void expand() {
            Logger.m10999d(AiMenuResultLayoutManager.TAG, "expand#");
            if (AiViewUtils.isSupportFloatingLayout()) {
                init();
                resizeFloatingWindow((this.mStartSize - ((int) AiMenuResultLayoutManager.this.mLayoutContainer.getTranslationY())) - this.mLastSize, false);
                return;
            }
            int i = this.mLastSizeSTT;
            if (i != -1) {
                this.mLastSize = i;
                this.mLastSizeSTT = -1;
            }
            if (this.mLastSize == -1) {
                return;
            }
            init();
            applyResizeWindow((this.mStartSize - ((int) AiMenuResultLayoutManager.this.mLayoutContainer.getTranslationY())) - this.mLastSize, false);
        }

        public int getCurrentHeight() {
            if (AiViewUtils.isSupportFloatingLayout()) {
                if (AiMenuResultLayoutManager.this.mResultContainer != null) {
                    return AiMenuResultLayoutManager.this.mResultContainer.getHeight();
                }
                return 0;
            }
            if (AiMenuResultLayoutManager.this.mPortraitContainer != null) {
                if (AiMenuResultLayoutManager.this.mPortraitContainer.getHeight() == -2 && AiMenuResultLayoutManager.this.mPortraitContainer.getHeight() != 0) {
                    return AiMenuResultLayoutManager.this.mPortraitContainer.getHeight();
                }
                if (AiMenuResultLayoutManager.this.mLayoutContainer != null) {
                    return AiMenuResultLayoutManager.this.mLayoutContainer.getHeight();
                }
            }
            return 0;
        }

        public int getDelta(MotionEvent motionEvent) {
            return (int) (motionEvent.getRawY() - this.mStartPoint);
        }

        public void init() {
            int height;
            ViewGroup.LayoutParams layoutParams = this.mResizeView.getLayoutParams();
            if (AiViewUtils.isSupportFloatingLayout()) {
                height = AiMenuResultLayoutManager.this.mLayoutContainer.getHeight();
            } else {
                height = AiMenuResultLayoutManager.this.getFragmentHeight() - (AiMenuResultLayoutManager.this.mAppbar.getHeight() != 0 ? this.mTitleHeight : 0);
            }
            layoutParams.height = height;
            this.mStartSize = getCurrentHeight();
            if (AiViewUtils.isSupportFloatingLayout()) {
                this.mMaxSize = AiMenuResultLayoutManager.this.mLayoutContainer.getHeight();
                this.mMinSize = 0;
                return;
            }
            if (AiMenuResultLayoutManager.this.isFocusSTTWindow()) {
                AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                this.mMaxSize = aiMenuResultLayoutManager.getMaxHeight(aiMenuResultLayoutManager.mFragmentView.getHeight()) - this.mLocalElevationTopMargin;
            } else {
                AiMenuResultLayoutManager aiMenuResultLayoutManager2 = AiMenuResultLayoutManager.this;
                this.mMaxSize = aiMenuResultLayoutManager2.getMaxHeight(aiMenuResultLayoutManager2.getFragmentHeight()) - this.mLocalElevationTopMargin;
            }
            this.mMinSize = AiMenuResultLayoutManager.this.mCommonViews.getTopContainer().getBottom();
        }

        public boolean isMinimized() {
            return this.mIsLastMinimized;
        }

        public void minimize() {
            if (AiViewUtils.isSupportFloatingLayout()) {
                Logger.m10999d(AiMenuResultLayoutManager.TAG, "minimize#");
                init();
                resizeFloatingWindow(this.mLastSize, true);
            } else {
                if (this.mLastSize != -1 || this.mIsLastMinimized) {
                    return;
                }
                Logger.m10999d(AiMenuResultLayoutManager.TAG, "minimize#");
                init();
                this.mLastSize = this.mStartSize;
                applyResizeWindow(AiMenuResultLayoutManager.this.mLayoutContainer.getHeight(), false);
            }
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.mStartPoint = motionEvent.getRawY();
                readyResizeWindow();
                return true;
            }
            if (motionEvent.getAction() == 2) {
                resizeResultWindow(getDelta(motionEvent), true);
                return true;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return false;
            }
            applyResizeWindow(getDelta(motionEvent), true);
            this.mResizeShowHideAnimation.hide();
            return true;
        }

        public void readyResizeWindow() {
            Logger.m10999d(AiMenuResultLayoutManager.TAG, "readyResizeWindow#start");
            this.mResizeShowHideAnimation.readyShow();
            init();
            int fragmentHeight = (AiMenuResultLayoutManager.this.getFragmentHeight() - this.mStartSize) - this.mLocalElevationTopMargin;
            if (fragmentHeight <= 0 || fragmentHeight - this.mTitleHeight <= 0) {
                String str = AiMenuResultLayoutManager.TAG;
                StringBuilder sb = new StringBuilder("readyResizeWindow# height is 0 (FH: ");
                sb.append(AiMenuResultLayoutManager.this.getFragmentHeight());
                sb.append(" StartS: ");
                AbstractC2821a.m2235z(sb, this.mStartSize, fragmentHeight, " CpH + TH: ", " CpH: ");
                sb.append(fragmentHeight - this.mTitleHeight);
                Logger.m11000e(str, sb.toString());
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(AiMenuResultLayoutManager.this.mFragmentView.getWidth(), 1, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(AiMenuResultLayoutManager.this.mFragmentView.getContext().getColor(C9086R.color.ai_menu_result_resize_overlap_bg_color));
                canvas.drawColor(this.OVERLAP_COLOR);
                this.mComposerThumbnail = AiViewUtils.blur(AiMenuResultLayoutManager.this.mFragmentView.getContext(), bitmapCreateBitmap, 25.0f);
                bitmapCreateBitmap.recycle();
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(AiMenuResultLayoutManager.this.mFragmentView.getWidth(), fragmentHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                this.mComposerViewCover.setBackgroundColor(AiMenuResultLayoutManager.this.mContract.getPresenter().getBackgroundThemeColor());
                AiMenuResultLayoutManager.this.mFragmentView.draw(canvas2);
                this.mComposerViewCover.setBackgroundColor(0);
                canvas2.drawColor(this.OVERLAP_COLOR);
                int height = this.mTitleHeight;
                if (AiViewUtils.isSupportFloatingLayout()) {
                    height = (AiViewUtils.isAtLeastOneUI85() && AiMenuResultLayoutManager.this.isPhoneLayout()) ? 0 : AiMenuResultLayoutManager.this.mTranslateContainer.getHeight() + AiMenuResultLayoutManager.this.mVoiceControllerView.getHeight() + AiMenuResultLayoutManager.this.mAppbar.getHeight();
                }
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCreateBitmap2, 0, height, bitmapCreateBitmap2.getWidth(), Math.max(bitmapCreateBitmap2.getHeight() - height, 1));
                bitmapCreateBitmap2.recycle();
                this.mComposerThumbnail = AiViewUtils.blur(AiMenuResultLayoutManager.this.mFragmentView.getContext(), bitmapCreateBitmap3, 25.0f);
                bitmapCreateBitmap3.recycle();
            }
            View view = AiViewUtils.isSupportFloatingLayout() ? AiMenuResultLayoutManager.this.mResultContainer : AiMenuResultLayoutManager.this.mLayoutContainer;
            Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(view.getWidth(), this.mStartSize, Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(bitmapCreateBitmap4);
            view.draw(canvas3);
            drawColorForBlur(canvas3, bitmapCreateBitmap4);
            this.mResultThumbnail = AiViewUtils.blur(AiMenuResultLayoutManager.this.mFragmentView.getContext(), bitmapCreateBitmap4, 25.0f);
            bitmapCreateBitmap4.recycle();
            Logger.m10999d(AiMenuResultLayoutManager.TAG, "readyResizeWindow#end");
            this.mComposerWindowView.setBackground(new BitmapDrawable(AiMenuResultLayoutManager.this.mFragmentView.getResources(), this.mComposerThumbnail));
            this.mResultWindowView.setBackground(new BitmapDrawable(AiMenuResultLayoutManager.this.mFragmentView.getResources(), this.mResultThumbnail));
            resizeResultWindow(0, false);
            this.mResizeView.setVisibility(0);
            this.mResizeContainer.setVisibility(0);
            this.mLastSize = -1;
            this.mResizeShowHideAnimation.show();
        }

        public void resizeFloatingWindow(int i, boolean z) {
            if (z) {
                int inputMethodWindowVisibleHeight = InputMethodCompat.getInstance().getInputMethodWindowVisibleHeight(AiMenuResultLayoutManager.this.mFragmentView.getContext());
                if (inputMethodWindowVisibleHeight == 0) {
                    return;
                }
                if (inputMethodWindowVisibleHeight <= 0 || i <= inputMethodWindowVisibleHeight) {
                    AiMenuResultLayoutManager.this.mPortraitContainer.getLayoutParams().height = 0;
                } else {
                    AiMenuResultLayoutManager.this.mPortraitContainer.getLayoutParams().height = i - inputMethodWindowVisibleHeight;
                }
            } else {
                AiMenuResultLayoutManager.this.mPortraitContainer.getLayoutParams().height = this.mLastSize;
            }
            AiMenuResultLayoutManager.this.mPortraitContainer.requestLayout();
            if (AiMenuResultLayoutManager.this.mViewPager != null) {
                AiMenuResultLayoutManager aiMenuResultLayoutManager = AiMenuResultLayoutManager.this;
                aiMenuResultLayoutManager.updateViewPagerHeight(aiMenuResultLayoutManager.mViewPager.getLayoutParams().height - (this.mStartSize - i));
                AbstractC8014b.m7221w(AbstractC0541b.m778t(i, "applyResizeWindow# ", " / "), AiMenuResultLayoutManager.TAG, AiMenuResultLayoutManager.this.mViewPager.getLayoutParams().height);
            }
            if (AiMenuResultLayoutManager.this.mViewPager != null) {
                AiMenuResultLayoutManager.this.mViewPager.requestLayout();
            }
        }

        public void resizeResultWindow(int i, boolean z) {
            int iCalculateSize = (int) (calculateSize(i) - AiMenuResultLayoutManager.this.mLayoutContainer.getTranslationY());
            ViewGroup.LayoutParams layoutParams = this.mResultWindowView.getLayoutParams();
            if (iCalculateSize <= 0) {
                iCalculateSize = 1;
            }
            layoutParams.height = iCalculateSize;
            if (z) {
                this.mResultWindowView.requestLayout();
                this.mResizeContainer.requestLayout();
            }
        }

        public void setLastSize(int i) {
            this.mLastSize = i;
        }

        public void setLastSizeSTT(int i) {
            if (this.mLastSizeSTT != -1 || this.mIsLastMinimized) {
                return;
            }
            this.mLastSizeSTT = i;
        }

        public void setLastSizeSTT() {
            if (this.mLastSizeSTT != -1 || this.mIsLastMinimized) {
                return;
            }
            this.mLastSizeSTT = getCurrentHeight();
        }
    }

    private void initSize(int i, int i2, float f, float f4) {
        if (isPortrait()) {
            i = i2;
        }
        float f5 = i;
        this.mContainerWidth = (int) (f * f5);
        this.mContainerHeight = (int) (f5 * f4);
    }
}
