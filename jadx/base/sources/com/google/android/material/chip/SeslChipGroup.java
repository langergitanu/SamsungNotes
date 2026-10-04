package com.google.android.material.chip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.math.MathUtils;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.C4548R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 23)
public class SeslChipGroup extends ChipGroup {
    private static final String TAG = "SeslChipGroup";
    private static final int sChipAlphaDelay = 100;
    private static final int sChipAppearAlphaDuration = 200;
    private static final int sChipDissChipAppearAlphaDuration = 200;
    private static int sChipInitialWidth;
    private OnChipAddListener mChipAddListener;
    private int mChipMaxWidth;
    private OnChipRemovedListener mChipRemoveListener;
    private boolean mDynamicChipTextTruncation;
    int mEmptyContainerHeight;
    private final LayoutTransition mLayoutTransition;
    private int mRowCount;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnChipAddListener {
        void onAdd();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnChipRemovedListener {
        void onRemove();
    }

    public SeslChipGroup(Context context) {
        this(context, null);
    }

    private void addRemoveAnim() {
        if (isLineAddedOrRemoved()) {
            startSeslLayoutHeightAnim();
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = -2;
        this.mEmptyContainerHeight = 0;
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void animateChipAppear(ValueAnimator valueAnimator) {
        View targetView = ((SeslValueAnimator) valueAnimator).getTargetView();
        if (targetView == null) {
            return;
        }
        if (!(targetView instanceof SeslChip)) {
            targetView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            return;
        }
        SeslChip seslChip = (SeslChip) targetView;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        seslChip.setRight(seslChip.getLeft() + sChipInitialWidth + ((int) ((seslChip.getChipDrawable().getIntrinsicWidth() - sChipInitialWidth) * fFloatValue)));
        seslChip.setBottom(seslChip.getChipDrawable().getIntrinsicHeight() + seslChip.getTop());
        seslChip.setInternalsAlpha((int) (MathUtils.clamp((((int) valueAnimator.getCurrentPlayTime()) - 100) / 200.0f, 0.0f, 1.0f) * 255.0f));
        seslChip.setBackgroundAlpha((int) (fFloatValue * 255.0f));
        seslChip.setTextEndPadding(0.0f);
        seslChip.setEllipsize(null);
        seslChip.setSeslFullText(true);
        seslChip.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void animateChipDisappear(ValueAnimator valueAnimator) {
        View targetView = ((SeslValueAnimator) valueAnimator).getTargetView();
        if (targetView == null) {
            return;
        }
        if (!(targetView instanceof SeslChip)) {
            targetView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            return;
        }
        SeslChip seslChip = (SeslChip) targetView;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        seslChip.setRight(seslChip.getLeft() + ((int) (((seslChip.getChipDrawable().getIntrinsicWidth() - sChipInitialWidth) * fFloatValue) + sChipInitialWidth)));
        seslChip.setBottom(seslChip.getChipDrawable().getIntrinsicHeight() + seslChip.getTop());
        seslChip.setInternalsAlpha((int) (MathUtils.clamp(1.0f - (((int) valueAnimator.getCurrentPlayTime()) / 200.0f), 0.0f, 1.0f) * 255.0f));
        seslChip.setBackgroundAlpha((int) (fFloatValue * 255.0f));
        seslChip.setTextEndPadding(0.0f);
        seslChip.setEllipsize(null);
        seslChip.setSeslFullText(true);
        seslChip.invalidate();
    }

    private AnimatorListenerAdapter getAddRemAnimListener() {
        return new AnimatorListenerAdapter() { // from class: com.google.android.material.chip.SeslChipGroup.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View targetView = ((SeslValueAnimator) animator).getTargetView();
                if (targetView == null) {
                    return;
                }
                if (!(targetView instanceof SeslChip)) {
                    targetView.setAlpha(1.0f);
                    return;
                }
                SeslChip seslChip = (SeslChip) targetView;
                seslChip.setInternalsAlpha(255);
                seslChip.setBackgroundAlpha(255);
                seslChip.setSeslFullText(false);
                seslChip.invalidate();
            }
        };
    }

    private int getChipGroupExpandedEndPadding() {
        return getContext().getResources().getDimensionPixelSize(C4548R.dimen.padding_view_width);
    }

    private LayoutTransition.TransitionListener getChipTransitionListener() {
        return new LayoutTransition.TransitionListener() { // from class: com.google.android.material.chip.SeslChipGroup.2
            @Override // android.animation.LayoutTransition.TransitionListener
            public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
                if (view instanceof SeslChip) {
                    SeslChip seslChip = (SeslChip) view;
                    if (i == 2 || i == 3) {
                        seslChip.setSeslFullText(false);
                        seslChip.setEllipsize(TextUtils.TruncateAt.END);
                    }
                }
            }

            @Override // android.animation.LayoutTransition.TransitionListener
            public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
                if (view instanceof SeslChip) {
                    SeslChip seslChip = (SeslChip) view;
                    if (i == 2 || i == 3) {
                        seslChip.setTextEndPadding(0.0f);
                        seslChip.setEllipsize(null);
                        ((ChipDrawable) seslChip.getChipDrawable()).setSeslFinalWidth(r1.getIntrinsicWidth());
                        seslChip.setSeslFullText(true);
                    }
                }
            }
        };
    }

    private boolean isLineAddedOrRemoved() {
        return getHeight() != getInternalHeight((float) getWidth()) && shouldAnimateHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postRemoveView$0() {
        this.mChipRemoveListener.onRemove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSeslLayoutHeightAnim$1(int i, int i2, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int iFloatValue = i + ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * i2));
        layoutParams.height = iFloatValue;
        this.mEmptyContainerHeight = iFloatValue;
        setLayoutParams(layoutParams);
    }

    private void postAddView(Chip chip) {
        if (this.mDynamicChipTextTruncation) {
            int i = this.mChipMaxWidth;
            if (i > 0) {
                chip.setMaxWidth(i);
            }
            chip.setEllipsize(TextUtils.TruncateAt.END);
        }
        OnChipAddListener onChipAddListener = this.mChipAddListener;
        if (onChipAddListener != null) {
            onChipAddListener.onAdd();
        }
    }

    private void postRemoveView() {
        if (this.mChipRemoveListener != null) {
            post(new RunnableC4644l(this, 3));
        }
    }

    private void setChipLayoutTransition() {
        this.mLayoutTransition.enableTransitionType(2);
        this.mLayoutTransition.enableTransitionType(3);
        this.mLayoutTransition.enableTransitionType(4);
        final int i = 0;
        this.mLayoutTransition.enableTransitionType(0);
        final int i2 = 1;
        this.mLayoutTransition.enableTransitionType(1);
        this.mLayoutTransition.setStartDelay(2, 0L);
        this.mLayoutTransition.setStartDelay(3, 0L);
        this.mLayoutTransition.setStartDelay(4, 0L);
        this.mLayoutTransition.setStartDelay(0, 0L);
        this.mLayoutTransition.setStartDelay(1, 0L);
        int integer = getContext().getResources().getInteger(C4548R.integer.sesl_chip_default_anim_duration);
        SeslValueAnimator seslValueAnimatorOfFloat = SeslValueAnimator.ofFloat(0.0f, 1.0f);
        long j = integer;
        seslValueAnimatorOfFloat.setDuration(j);
        seslValueAnimatorOfFloat.setStartDelay(0L);
        seslValueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.chip.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        SeslChipGroup.animateChipAppear(valueAnimator);
                        break;
                    default:
                        SeslChipGroup.animateChipDisappear(valueAnimator);
                        break;
                }
            }
        });
        seslValueAnimatorOfFloat.addListener(getAddRemAnimListener());
        this.mLayoutTransition.setAnimator(2, seslValueAnimatorOfFloat);
        SeslValueAnimator seslValueAnimatorOfFloat2 = SeslValueAnimator.ofFloat(1.0f, 0.0f);
        seslValueAnimatorOfFloat2.setDuration(j);
        seslValueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.chip.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        SeslChipGroup.animateChipAppear(valueAnimator);
                        break;
                    default:
                        SeslChipGroup.animateChipDisappear(valueAnimator);
                        break;
                }
            }
        });
        seslValueAnimatorOfFloat2.addListener(getAddRemAnimListener());
        this.mLayoutTransition.setAnimator(3, seslValueAnimatorOfFloat2);
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(getContext(), C0419R.interpolator.sesl_chip_default_interpolator);
        this.mLayoutTransition.setInterpolator(3, interpolatorLoadInterpolator);
        this.mLayoutTransition.setInterpolator(2, interpolatorLoadInterpolator);
        this.mLayoutTransition.setInterpolator(4, interpolatorLoadInterpolator);
        this.mLayoutTransition.setInterpolator(0, interpolatorLoadInterpolator);
        this.mLayoutTransition.setInterpolator(1, interpolatorLoadInterpolator);
        this.mLayoutTransition.addTransitionListener(getChipTransitionListener());
    }

    private void setStaticHeight() {
        this.mEmptyContainerHeight = getHeight();
    }

    private boolean shouldAnimateHeight() {
        if (isSingleLine()) {
            return isSingleLine() && getChildCount() == 0;
        }
        return true;
    }

    private void startSeslLayoutHeightAnim() {
        int height = getHeight();
        int internalHeight = getInternalHeight(getWidth()) - height;
        if (Math.abs(internalHeight) < getContext().getResources().getDimension(C4548R.dimen.chip_height)) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(getContext().getResources().getInteger(C4548R.integer.sesl_chip_default_anim_duration));
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(getContext(), C0419R.interpolator.sesl_chip_default_interpolator));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.chip.SeslChipGroup.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = SeslChipGroup.this.getLayoutParams();
                layoutParams.height = -2;
                SeslChipGroup seslChipGroup = SeslChipGroup.this;
                seslChipGroup.mEmptyContainerHeight = 0;
                seslChipGroup.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new C4635c(this, height, internalHeight, 0));
        valueAnimatorOfFloat.start();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        enableSeslLayoutTransitions(getChildCount() > 0);
        super.addView(view instanceof SeslChip ? (SeslChip) view : view, i, layoutParams);
        if (isLineAddedOrRemoved()) {
            enableSeslLayoutTransitions(false);
        }
        addRemoveAnim();
        if (view instanceof Chip) {
            postAddView((Chip) view);
        }
    }

    public void enableSeslLayoutTransitions(boolean z) {
        if (z) {
            setLayoutTransition(this.mLayoutTransition);
        } else {
            setLayoutTransition(null);
        }
    }

    public int getInternalHeight(float f) {
        int i;
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        int paddingStart = getPaddingStart();
        int chipGroupExpandedEndPadding = getChipGroupExpandedEndPadding();
        int chipSpacingHorizontal = getChipSpacingHorizontal();
        int width = getChildAt(0).getWidth() + paddingStart + chipGroupExpandedEndPadding + chipSpacingHorizontal;
        int i2 = 1;
        for (int i4 = 1; i4 < childCount; i4++) {
            int intrinsicWidth = ((Chip) getChildAt(i4)).getChipDrawable().getIntrinsicWidth();
            if (width + intrinsicWidth < f) {
                i = intrinsicWidth + chipSpacingHorizontal + width;
            } else {
                i = intrinsicWidth + chipSpacingHorizontal + paddingStart + chipGroupExpandedEndPadding;
                i2++;
            }
            width = i;
        }
        int chipSpacingVertical = getChipSpacingVertical();
        return (getPaddingTop() + (getPaddingBottom() + ((getChildAt(0).getHeight() + chipSpacingVertical) * i2))) - chipSpacingVertical;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public int getRowCount() {
        return this.mRowCount;
    }

    public int getRowInternalIndex(View view) {
        int childCount = getChildCount();
        int[] iArr = new int[getRowCount()];
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return iArr[getRowIndex(getChildAt(i))];
            }
            int rowIndex = getRowIndex(getChildAt(i));
            iArr[rowIndex] = iArr[rowIndex] + 1;
        }
        return 0;
    }

    public int getTotalWidth() {
        int paddingEnd = getPaddingEnd() + getPaddingStart();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                paddingEnd = (childAt instanceof SeslChip ? ((SeslChip) childAt).getChipDrawable().getIntrinsicWidth() : childAt.getWidth()) + paddingEnd;
            }
            if (childCount > 1) {
                return AbstractC1974b.m1304A(childCount, 2, getChipSpacingHorizontal(), paddingEnd);
            }
        }
        return paddingEnd;
    }

    @Override // com.google.android.material.internal.FlowLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        int marginEnd;
        int marginStart;
        boolean z2;
        int i6 = 0;
        if (getChildCount() == 0) {
            this.mRowCount = 0;
            return;
        }
        boolean z3 = true;
        this.mRowCount = 1;
        boolean z4 = ViewCompat.getLayoutDirection(this) == 1;
        int paddingRight = z4 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z4 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int lineSpacing = getLineSpacing();
        int itemSpacing = getItemSpacing();
        int i7 = i4 - i;
        int i8 = i7 - paddingLeft;
        if (!z4) {
            i7 = i8;
        }
        int i9 = 0;
        int measuredWidth = paddingRight;
        int i10 = paddingTop;
        while (i9 < getChildCount()) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(C4548R.id.row_index_key, -1);
                z2 = z3;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    marginEnd = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    marginEnd = i6;
                    marginStart = marginEnd;
                }
                z2 = z3;
                int measuredWidth2 = childAt.getMeasuredWidth() + measuredWidth + marginStart;
                if (!isSingleLine() && measuredWidth2 > i8) {
                    i10 = paddingTop + lineSpacing;
                    this.mRowCount++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(C4548R.id.row_index_key, Integer.valueOf(this.mRowCount - 1));
                int i11 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i11;
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                if (z4) {
                    childAt.layout(i7 - measuredWidth3, i10, (i7 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i11, i10, measuredWidth3, measuredHeight);
                }
                measuredWidth += childAt.getMeasuredWidth() + marginStart + marginEnd + itemSpacing;
                paddingTop = measuredHeight;
            }
            i9++;
            z3 = z2;
            i6 = 0;
        }
    }

    @Override // com.google.android.material.internal.FlowLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() <= 0) {
            setMeasuredDimension(getWidth(), this.mEmptyContainerHeight);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        setStaticHeight();
        super.removeAllViews();
        addRemoveAnim();
        postRemoveView();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        setStaticHeight();
        super.removeAllViewsInLayout();
        addRemoveAnim();
        postRemoveView();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        enableSeslLayoutTransitions(getChildCount() > 1);
        setStaticHeight();
        super.removeView(view);
        addRemoveAnim();
        postRemoveView();
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        setStaticHeight();
        super.removeViewAt(i);
        addRemoveAnim();
        postRemoveView();
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        setStaticHeight();
        super.removeViewInLayout(view);
        addRemoveAnim();
        postRemoveView();
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        setStaticHeight();
        super.removeViews(i, i2);
        addRemoveAnim();
        postRemoveView();
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        setStaticHeight();
        super.removeViewsInLayout(i, i2);
        addRemoveAnim();
        postRemoveView();
    }

    public void setDynamicTruncation(boolean z) {
        this.mDynamicChipTextTruncation = z;
        AbstractC4539a.m3208r("dynamic truncation state: ", TAG, z);
    }

    public void setMaxChipWidth(int i) {
        this.mChipMaxWidth = i - ((getPaddingEnd() + getPaddingStart()) + getResources().getDimensionPixelSize(C4548R.dimen.expansion_button_size));
    }

    public void setOnChipAddListener(OnChipAddListener onChipAddListener) {
        this.mChipAddListener = onChipAddListener;
    }

    public void setOnChipRemovedListener(OnChipRemovedListener onChipRemovedListener) {
        this.mChipRemoveListener = onChipRemovedListener;
    }

    public SeslChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C4548R.attr.chipGroupStyle);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SeslValueAnimator extends ValueAnimator {
        private ArrayList<Animator.AnimatorListener> mSeslListeners;
        private ArrayList<ValueAnimator.AnimatorUpdateListener> mSeslUpdateListeners;
        private WeakReference<View> mTargetView;
        private float[] mValues;

        private SeslValueAnimator() {
        }

        public static SeslValueAnimator ofFloat(float... fArr) {
            SeslValueAnimator seslValueAnimator = new SeslValueAnimator();
            seslValueAnimator.setFloatValues(fArr);
            seslValueAnimator.mValues = fArr;
            seslValueAnimator.mSeslUpdateListeners = new ArrayList<>();
            seslValueAnimator.mSeslListeners = new ArrayList<>();
            return seslValueAnimator;
        }

        @Override // android.animation.Animator
        public void addListener(Animator.AnimatorListener animatorListener) {
            super.addListener(animatorListener);
            this.mSeslListeners.add(animatorListener);
        }

        @Override // android.animation.ValueAnimator
        public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            super.addUpdateListener(animatorUpdateListener);
            this.mSeslUpdateListeners.add(animatorUpdateListener);
        }

        public View getTargetView() {
            return this.mTargetView.get();
        }

        @Override // android.animation.Animator
        public void setTarget(@Nullable Object obj) {
            this.mTargetView = new WeakReference<>((View) obj);
            super.setTarget(obj);
        }

        @Override // android.animation.ValueAnimator, android.animation.Animator
        @NonNull
        public SeslValueAnimator clone() {
            SeslValueAnimator seslValueAnimatorOfFloat = ofFloat(this.mValues);
            ArrayList<ValueAnimator.AnimatorUpdateListener> arrayList = this.mSeslUpdateListeners;
            if (arrayList != null) {
                Iterator<ValueAnimator.AnimatorUpdateListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    seslValueAnimatorOfFloat.addUpdateListener(it.next());
                }
            }
            ArrayList<Animator.AnimatorListener> arrayList2 = this.mSeslListeners;
            if (arrayList2 != null) {
                Iterator<Animator.AnimatorListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    seslValueAnimatorOfFloat.addListener(it2.next());
                }
            }
            return seslValueAnimatorOfFloat;
        }
    }

    public SeslChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDynamicChipTextTruncation = true;
        this.mLayoutTransition = new LayoutTransition();
        this.mEmptyContainerHeight = 0;
        sChipInitialWidth = (int) getResources().getDimension(C4548R.dimen.chip_start_width);
        setLayoutDirection(TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()));
        setChipLayoutTransition();
        enableSeslLayoutTransitions(false);
    }

    public int getRowInternalIndex(int i) {
        int childCount = getChildCount();
        int[] iArr = new int[getRowCount()];
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i2 == i) {
                return iArr[getRowIndex(getChildAt(i2))];
            }
            int rowIndex = getRowIndex(getChildAt(i2));
            iArr[rowIndex] = iArr[rowIndex] + 1;
        }
        return 0;
    }
}
