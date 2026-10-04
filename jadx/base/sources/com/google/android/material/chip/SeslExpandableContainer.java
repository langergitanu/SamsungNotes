package com.google.android.material.chip;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.core.text.TextUtilsCompat;
import com.google.android.material.C4548R;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import p035H2.RunnableC0117b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 23)
public class SeslExpandableContainer extends FrameLayout {
    private static final String TAG = "SeslExpandableContainer";
    private boolean mChipGroupInitialized;
    private boolean mExpanded;

    @NonNull
    private final SeslExpansionButton mExpansionButton;
    private final int mExpansionButtonContainerId;
    private boolean mFadeAnimation;
    private boolean mFloatChangeAllowed;
    private final boolean mIsRtl;
    private OnExpansionButtonClickedListener mOnExpansionButtonClickedListener;
    private boolean mPaddingAllowed;

    @NonNull
    private final View mPaddingView;

    @NonNull
    private final HorizontalScrollView mScrollView;
    private int mScrollViewPos;

    @NonNull
    private final LinearLayout mScrollingChipsContainer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnExpansionButtonClickedListener {
        void onClick();
    }

    public SeslExpandableContainer(Context context) {
        this(context, null);
    }

    private void addExpansionButtonContainer(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        relativeLayout.setId(this.mExpansionButtonContainerId);
        if (this.mIsRtl) {
            relativeLayout.setGravity(3);
        } else {
            relativeLayout.setGravity(5);
        }
        addView(relativeLayout);
        relativeLayout.addView(this.mExpansionButton);
    }

    private void fadeAnimation() {
        (this.mExpanded ? getChildAt(1) : this.mScrollingChipsContainer).animate().setDuration(100L).alpha(0.0f).setListener(new Animator.AnimatorListener() { // from class: com.google.android.material.chip.SeslExpandableContainer.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                if (SeslExpandableContainer.this.mExpanded) {
                    SeslExpandableContainer.this.getChildAt(1).setAlpha(1.0f);
                } else {
                    SeslExpandableContainer.this.mScrollingChipsContainer.setAlpha(1.0f);
                }
                SeslExpandableContainer.this.postFadeAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
            }
        });
    }

    private static void getAddedChildrens(ViewGroup viewGroup, View[] viewArr, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            viewArr[i] = viewGroup.getChildAt(i);
        }
        if (z) {
            Collections.reverse(Arrays.asList(viewArr));
        }
    }

    private void initExpansionButtonLayout(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, context.getResources().getDimensionPixelSize(C4548R.dimen.expansion_button_margin_top), 0, 0);
        this.mExpansionButton.setLayoutParams(layoutParams);
        this.mExpansionButton.setBackground(context.getDrawable(C4548R.drawable.sesl_expansion_button_background));
        this.mExpansionButton.setImageDrawable(context.getDrawable(C4548R.drawable.sesl_expansion_button_foreground));
        this.mExpansionButton.setAutomaticDisappear(true);
        this.mExpansionButton.setExpanded(false);
        this.mExpansionButton.setFloated(true);
        this.mExpansionButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fullScrollToRight$1(int i, int i2) {
        scrollTo(getScrollContentsWidth(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollTo$0(int i, int i2, int i4) {
        if (i > 0) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.mScrollView, "scrollX", i2);
            ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.mScrollView, "scrollY", 0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(AnimationUtils.loadInterpolator(getContext(), C0419R.interpolator.sesl_chip_default_interpolator));
            animatorSet.setDuration(i);
            animatorSet.setStartDelay(i4);
            animatorSet.playTogether(objectAnimatorOfInt, objectAnimatorOfInt2);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setExpanded$2() {
        this.mExpansionButton.setExpanded(this.mExpanded);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setExpansionButton$3() {
        this.mExpansionButton.setExpanded(this.mExpanded);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setExpansionButton$4(View view) {
        if (this.mFadeAnimation) {
            fadeAnimation();
            return;
        }
        this.mExpanded = !this.mExpanded;
        refreshLayout();
        post(new RunnableC4636d(this, 0));
        OnExpansionButtonClickedListener onExpansionButtonClickedListener = this.mOnExpansionButtonClickedListener;
        if (onExpansionButtonClickedListener != null) {
            onExpansionButtonClickedListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnScrollChangeListener$5(View view, int i, int i2, int i4, int i5) {
        updateScrollExpansionButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postFadeAnimation() {
        this.mExpanded = !this.mExpanded;
        refreshLayout();
        this.mExpansionButton.setExpanded(this.mExpanded);
        OnExpansionButtonClickedListener onExpansionButtonClickedListener = this.mOnExpansionButtonClickedListener;
        if (onExpansionButtonClickedListener != null) {
            onExpansionButtonClickedListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLayout() {
        setLayoutTransition(null);
        int i = 1;
        if (this.mExpanded) {
            if (this.mScrollingChipsContainer.getChildCount() > 0) {
                this.mExpansionButton.setAutomaticDisappear(false);
                this.mScrollViewPos = this.mScrollView.getScrollX();
                int childCount = this.mScrollingChipsContainer.getChildCount();
                View[] viewArr = new View[childCount];
                getAddedChildrens(this.mScrollingChipsContainer, viewArr, this.mIsRtl);
                int height = 0;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View view = viewArr[i2];
                    if (!this.mPaddingAllowed || view.getId() != this.mPaddingView.getId()) {
                        this.mScrollingChipsContainer.removeView(view);
                        addView(view, i);
                        height += view.getHeight();
                        i++;
                    }
                }
                this.mScrollView.setVisibility(8);
                if (this.mExpansionButton.getVisibility() == 0 || height <= 0) {
                    return;
                }
                this.mExpansionButton.setVisibility(0);
                return;
            }
            return;
        }
        if (getChildCount() > 2) {
            this.mExpansionButton.setAutomaticDisappear(true);
            this.mScrollView.setVisibility(0);
            int childCount2 = getChildCount();
            View[] viewArr2 = new View[childCount2];
            getAddedChildrens(this, viewArr2, this.mIsRtl);
            int i4 = 0;
            for (int i5 = 0; i5 < childCount2; i5++) {
                View view2 = viewArr2[i5];
                if (!this.mChipGroupInitialized && (view2 instanceof SeslChipGroup)) {
                    ((SeslChipGroup) view2).setMaxChipWidth(getWidth());
                    this.mChipGroupInitialized = true;
                }
                int id = view2.getId();
                if (id != this.mScrollView.getId() && id != this.mExpansionButtonContainerId && id != this.mPaddingView.getId()) {
                    removeView(view2);
                    this.mScrollingChipsContainer.addView(view2, i4);
                    i4++;
                }
            }
            this.mScrollView.scrollTo(this.mScrollViewPos, 0);
            updateScrollExpansionButton();
        }
    }

    private void setExpansionButton() {
        this.mExpansionButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.chip.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2256a.lambda$setExpansionButton$4(view);
            }
        });
    }

    private void setOnScrollChangeListener() {
        this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.google.android.material.chip.f
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i4, int i5) {
                this.f2255a.lambda$setOnScrollChangeListener$5(view, i, i2, i4, i5);
            }
        });
    }

    private boolean shouldFloat() {
        if (!this.mIsRtl || this.mScrollView.getScrollX() <= getPaddingView().getWidth() / 2) {
            return !this.mIsRtl && this.mScrollView.getScrollX() < getScrollContentsWidth() - getWidth();
        }
        return true;
    }

    private void updateScrollExpansionButton() {
        int scrollContentsWidth = getScrollContentsWidth();
        int width = getWidth() + 10;
        int width2 = this.mPaddingView.getWidth();
        if (this.mPaddingAllowed) {
            if ((this.mPaddingView.getVisibility() == 0 && scrollContentsWidth - width2 > width) || (this.mPaddingView.getVisibility() == 8 && scrollContentsWidth > width)) {
                if (this.mExpansionButton.getVisibility() != 0) {
                    this.mExpansionButton.setVisibility(0);
                }
                setExpansionButton();
            } else if (this.mExpansionButton.getVisibility() == 0) {
                this.mExpansionButton.setVisibility(4);
            }
        } else if (scrollContentsWidth > width) {
            if (this.mExpansionButton.getVisibility() != 0) {
                this.mExpansionButton.setVisibility(0);
            }
            setExpansionButton();
        } else if (this.mExpansionButton.getVisibility() == 0) {
            this.mExpansionButton.setVisibility(4);
        }
        updateScrollExpansionButtonFloat();
    }

    private void updateScrollExpansionButtonFloat() {
        if (this.mFloatChangeAllowed && this.mScrollView.getVisibility() == 0) {
            if (!this.mPaddingAllowed || shouldFloat()) {
                this.mExpansionButton.setFloated(true);
            } else {
                this.mExpansionButton.setFloated(false);
            }
        }
    }

    public void enableFadingAnimation(boolean z) {
        this.mFadeAnimation = z;
    }

    public void enableFloatChange(boolean z) {
        this.mFloatChangeAllowed = z;
    }

    public void enablePadding(boolean z) {
        this.mPaddingAllowed = z;
        post(new RunnableC4636d(this, 1));
        Log.i(TAG, "padding view updated visibility: " + z);
    }

    public void fullScrollToLeft(int i, int i2) {
        if (this.mExpanded) {
            Log.w(TAG, "cannot scroll if container is expanded");
        } else {
            scrollTo(0, i, i2);
        }
    }

    public void fullScrollToRight(int i, int i2) {
        if (this.mExpanded) {
            Log.w(TAG, "cannot scroll if container is expanded");
        } else {
            post(new RunnableC0117b(this, i, i2, 2));
        }
    }

    @NonNull
    public SeslExpansionButton getExpansionButton() {
        return this.mExpansionButton;
    }

    public View getPaddingView() {
        return this.mPaddingView;
    }

    public int getScrollContentsWidth() {
        if (this.mExpanded) {
            return 0;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C4548R.dimen.padding_view_width);
        for (int i = 0; i < this.mScrollingChipsContainer.getChildCount(); i++) {
            View childAt = this.mScrollingChipsContainer.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                dimensionPixelSize = (childAt instanceof SeslChipGroup ? ((SeslChipGroup) childAt).getTotalWidth() : childAt.getWidth()) + dimensionPixelSize;
            }
        }
        return dimensionPixelSize;
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public boolean isPaddingEnabled() {
        return this.mPaddingAllowed;
    }

    public boolean isPaddingViewVisible() {
        return this.mPaddingView.getVisibility() == 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        refreshLayout();
    }

    public void scrollTo(final int i, final int i2, final int i4) {
        if (this.mExpanded) {
            Log.w(TAG, "cannot scroll if container is expanded");
        } else {
            this.mScrollView.post(new Runnable() { // from class: com.google.android.material.chip.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2251a.lambda$scrollTo$0(i2, i, i4);
                }
            });
        }
    }

    public void setExpanded(boolean z) {
        this.mExpanded = z;
        refreshLayout();
        post(new RunnableC4636d(this, 2));
        Log.i(TAG, "expansion state: " + z);
    }

    public void setExpansionBackGroundImage(Drawable drawable) {
        this.mExpansionButton.setBackground(drawable);
        Log.i(TAG, "expansion button background changed");
    }

    public void setExpansionImageDrawable(Drawable drawable) {
        this.mExpansionButton.setImageDrawable(drawable);
        Log.i(TAG, "expansion button image changed");
    }

    public void setOnExpansionButtonClickedListener(OnExpansionButtonClickedListener onExpansionButtonClickedListener) {
        this.mOnExpansionButtonClickedListener = onExpansionButtonClickedListener;
    }

    public void tempHideExpansionButton() {
        this.mExpansionButton.setVisibility(8);
    }

    public void updateExpansionButton() {
        if (this.mExpanded) {
            return;
        }
        updateScrollExpansionButton();
    }

    public SeslExpandableContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SeslExpandableContainer(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public SeslExpandableContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mExpanded = false;
        this.mPaddingAllowed = true;
        this.mScrollViewPos = 0;
        this.mFloatChangeAllowed = true;
        this.mIsRtl = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        View viewInflate = LayoutInflater.from(context).inflate(C4548R.layout.sesl_expandable_container, (ViewGroup) null);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) viewInflate.findViewById(C4548R.id.sesl_scroll_view);
        this.mScrollView = horizontalScrollView;
        View viewFindViewById = viewInflate.findViewById(C4548R.id.sesl_padding_view);
        this.mPaddingView = viewFindViewById;
        horizontalScrollView.setPaddingRelative(0, 0, context.getResources().getDimensionPixelSize(C4548R.dimen.padding_view_width), 0);
        viewFindViewById.setVisibility(8);
        setOnScrollChangeListener();
        this.mScrollingChipsContainer = (LinearLayout) viewInflate.findViewById(C4548R.id.sesl_scrolling_chips_container);
        addView(viewInflate);
        this.mExpansionButtonContainerId = View.generateViewId();
        this.mExpansionButton = new SeslExpansionButton(context);
        initExpansionButtonLayout(context);
        addExpansionButtonContainer(context);
    }
}
