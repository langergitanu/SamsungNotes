package com.google.android.material.chip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.core.text.TextUtilsCompat;
import com.google.android.material.C4548R;
import com.google.android.material.chip.SeslExpandableContainer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 23)
public class SeslPeoplePicker extends FrameLayout {

    @NonNull
    private final SeslChipGroup mChipGroup;

    @NonNull
    private final SeslExpandableContainer mContainer;
    private boolean mInitialized;
    private final boolean mIsRtl;

    @Nullable
    private OnChipAddListener mOnChipAddListener;

    @Nullable
    private OnChipRemovedListener mOnChipRemovedListener;

    @Nullable
    private OnExpansionButtonClickedListener mOnExpansionButtonClickedListener;

    /* JADX INFO: renamed from: com.google.android.material.chip.SeslPeoplePicker$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C46324 extends AnimatorListenerAdapter {
        public C46324() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
            ViewGroup.LayoutParams layoutParams = SeslPeoplePicker.this.mContainer.getLayoutParams();
            layoutParams.height = -2;
            SeslPeoplePicker.this.mContainer.setLayoutParams(layoutParams);
            SeslPeoplePicker.this.mContainer.getExpansionButton().startDisappearTimer();
            SeslPeoplePicker.this.mContainer.post(new RunnableC4644l(SeslPeoplePicker.this, 0));
            SeslPeoplePicker.this.mChipGroup.enableSeslLayoutTransitions(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator) {
            SeslPeoplePicker.this.mChipGroup.setAlpha(0.0f);
            SeslPeoplePicker.this.mChipGroup.setSingleLine(!SeslPeoplePicker.this.mContainer.isExpanded());
            SeslPeoplePicker.this.mChipGroup.enableSeslLayoutTransitions(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnChipAddListener {
        void onChipAdded();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnChipRemovedListener {
        void onChipRemoved();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnExpansionButtonClickedListener {
        void onExpansionButtonCLicked();
    }

    public SeslPeoplePicker(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ void access$200(SeslPeoplePicker seslPeoplePicker) {
        seslPeoplePicker.updateFloatWhenExpanded();
    }

    private int getChipGroupZRowWidth() {
        int paddingStart = this.mChipGroup.getPaddingStart();
        int paddingEnd = this.mChipGroup.getPaddingEnd();
        int chipSpacingHorizontal = this.mChipGroup.getChipSpacingHorizontal();
        int width = this.mChipGroup.getChildAt(0).getWidth() + paddingStart + paddingEnd + chipSpacingHorizontal;
        int width2 = getWidth();
        for (int i = 1; i < this.mChipGroup.getChildCount(); i++) {
            int width3 = ((Chip) this.mChipGroup.getChildAt(i)).getWidth();
            if (width + width3 >= width2) {
                break;
            }
            width += width3 + chipSpacingHorizontal;
        }
        return (width - chipSpacingHorizontal) - paddingEnd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$0() {
        startExpandingAnimation();
        setChipGroupEndPadding(this.mContainer.isExpanded());
        OnExpansionButtonClickedListener onExpansionButtonClickedListener = this.mOnExpansionButtonClickedListener;
        if (onExpansionButtonClickedListener != null) {
            onExpansionButtonClickedListener.onExpansionButtonCLicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$1() {
        if (this.mChipGroup.getTotalWidth() > getWidth() - getContext().getResources().getDimensionPixelSize(C4548R.dimen.padding_view_width)) {
            int integer = getContext().getResources().getInteger(C4548R.integer.sesl_chip_default_anim_duration);
            this.mContainer.enableFloatChange(false);
            getExpansionButton().setFloated(true);
            if (this.mIsRtl) {
                getExpansionButton().setVisibility(0);
                getExpansionButton().setFloated(true);
                this.mContainer.fullScrollToLeft(integer, 0);
            } else {
                this.mContainer.fullScrollToRight(integer, 0);
            }
            long j = integer;
            new CountDownTimer(j, j) { // from class: com.google.android.material.chip.SeslPeoplePicker.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    SeslPeoplePicker.this.mContainer.enableFloatChange(true);
                    SeslPeoplePicker.this.getExpansionButton().setFloated(false);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$2(Context context) {
        if (!this.mInitialized) {
            this.mInitialized = true;
            SeslExpansionButton expansionButton = this.mContainer.getExpansionButton();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) expansionButton.getLayoutParams();
            int dimension = (int) context.getResources().getDimension(C4548R.dimen.expansion_button_margin_top);
            int dimension2 = (int) context.getResources().getDimension(C4548R.dimen.expansion_button_margin_right);
            if (this.mIsRtl) {
                layoutParams.setMargins(dimension2, dimension, 0, 0);
            } else {
                layoutParams.setMargins(0, dimension, dimension2, 0);
            }
            expansionButton.setLayoutParams(layoutParams);
        }
        if (this.mChipGroup.getChildCount() == 1) {
            startShowingAnimation(context);
        }
        if (this.mContainer.isExpanded()) {
            this.mChipGroup.post(new RunnableC4644l(this, 1));
        } else {
            post(new RunnableC4644l(this, 2));
        }
        OnChipAddListener onChipAddListener = this.mOnChipAddListener;
        if (onChipAddListener != null) {
            onChipAddListener.onChipAdded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$3(Context context) {
        if (this.mContainer.isExpanded()) {
            this.mContainer.post(new RunnableC4644l(this, 1));
        }
        if (this.mChipGroup.getChildCount() == 0) {
            this.mContainer.tempHideExpansionButton();
            startHidingAnimation(context);
        }
        OnChipRemovedListener onChipRemovedListener = this.mOnChipRemovedListener;
        if (onChipRemovedListener != null) {
            onChipRemovedListener.onChipRemoved();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startExpandingAnimation$6(int i, float f, int i2, int i4, int i5, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        layoutParams.height = i + ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * f));
        this.mContainer.setLayoutParams(layoutParams);
        float fFloatValue = (((Float) valueAnimator.getAnimatedValue()).floatValue() * (i2 - i4)) / i5;
        if (fFloatValue > 0.0f) {
            this.mChipGroup.setAlpha(Math.min(fFloatValue, 1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startHidingAnimation$5(float f, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * f);
        this.mContainer.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startShowingAnimation$4(float f, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        layoutParams.height = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * f);
        this.mContainer.setLayoutParams(layoutParams);
    }

    private void setChipGroupEndPadding(boolean z) {
        this.mChipGroup.setPaddingRelative(this.mChipGroup.getPaddingStart(), this.mChipGroup.getPaddingTop(), z ? getContext().getResources().getDimensionPixelSize(C4548R.dimen.padding_view_width) : getContext().getResources().getDimensionPixelSize(C4548R.dimen.chip_group_end_padding), this.mChipGroup.getPaddingBottom());
    }

    private void setListeners(Context context) {
        this.mContainer.setOnExpansionButtonClickedListener(new SeslExpandableContainer.OnExpansionButtonClickedListener() { // from class: com.google.android.material.chip.h
            @Override // com.google.android.material.chip.SeslExpandableContainer.OnExpansionButtonClickedListener
            public final void onClick() {
                this.f2257a.lambda$setListeners$0();
            }
        });
        this.mChipGroup.setOnChipAddListener(new C4641i(this, context));
        this.mChipGroup.setOnChipRemovedListener(new C4641i(this, context));
    }

    private void startExpandingAnimation() {
        final int i;
        int internalHeight = this.mChipGroup.getInternalHeight(getWidth());
        int paddingBottom = this.mChipGroup.getPaddingBottom() + this.mChipGroup.getPaddingTop() + this.mChipGroup.getChildAt(0).getHeight();
        if (this.mContainer.isExpanded()) {
            i = paddingBottom;
        } else {
            i = internalHeight;
            internalHeight = paddingBottom;
        }
        final float f = internalHeight - i;
        Context context = getContext();
        final int integer = context.getResources().getInteger(C4548R.integer.sesl_chip_default_anim_duration);
        final int integer2 = context.getResources().getInteger(C4548R.integer.sesl_people_picker_alpha_duration);
        final int integer3 = context.getResources().getInteger(C4548R.integer.sesl_people_picker_alpha_delay);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(integer);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, C0419R.interpolator.sesl_chip_default_interpolator));
        valueAnimatorOfFloat.addListener(new C46324());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.chip.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f2260a.lambda$startExpandingAnimation$6(i, f, integer, integer3, integer2, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    private void startHidingAnimation(Context context) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(context.getResources().getInteger(C4548R.integer.sesl_chip_default_anim_duration));
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, C0419R.interpolator.sesl_chip_default_interpolator));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.chip.SeslPeoplePicker.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = SeslPeoplePicker.this.mContainer.getLayoutParams();
                layoutParams.height = -2;
                SeslPeoplePicker.this.mContainer.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new C4643k(this, this.mContainer.getHeight(), 0));
        valueAnimatorOfFloat.start();
    }

    private void startShowingAnimation(Context context) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(context.getResources().getInteger(C4548R.integer.sesl_chip_default_anim_duration));
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, C0419R.interpolator.sesl_chip_default_interpolator));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.chip.SeslPeoplePicker.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = SeslPeoplePicker.this.mContainer.getLayoutParams();
                layoutParams.height = -2;
                SeslPeoplePicker.this.mContainer.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new C4643k(this, context.getResources().getDimension(C4548R.dimen.chip_height) + this.mChipGroup.getPaddingTop() + this.mChipGroup.getPaddingBottom(), 1));
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFloatWhenExpanded() {
        if (!this.mContainer.isExpanded() || this.mChipGroup.getChildCount() <= 0) {
            return;
        }
        SeslExpansionButton expansionButton = getExpansionButton();
        if (expansionButton.getVisibility() != 0) {
            expansionButton.setVisibility(0);
        }
        if (getChipGroupZRowWidth() >= getWidth() - getExpansionButton().getWidth()) {
            expansionButton.setFloated(true);
        } else {
            expansionButton.setFloated(false);
        }
    }

    @NonNull
    public SeslChipGroup getChipGroup() {
        return this.mChipGroup;
    }

    @NonNull
    public SeslExpandableContainer getChipGroupContainer() {
        return this.mContainer;
    }

    @NonNull
    public SeslExpansionButton getExpansionButton() {
        return this.mContainer.getExpansionButton();
    }

    public void setExpansionBackgroundImage(Drawable drawable) {
        this.mContainer.setExpansionBackGroundImage(drawable);
    }

    public void setExpansionImageDrawable(Drawable drawable) {
        this.mContainer.setExpansionImageDrawable(drawable);
    }

    public void setOnChipAddListener(OnChipAddListener onChipAddListener) {
        this.mOnChipAddListener = onChipAddListener;
    }

    public void setOnChipRemovedListener(OnChipRemovedListener onChipRemovedListener) {
        this.mOnChipRemovedListener = onChipRemovedListener;
    }

    public void setOnExpansionButtonClickedListener(OnExpansionButtonClickedListener onExpansionButtonClickedListener) {
        this.mOnExpansionButtonClickedListener = onExpansionButtonClickedListener;
    }

    public SeslPeoplePicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SeslPeoplePicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public SeslPeoplePicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsRtl = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        View viewInflate = LayoutInflater.from(context).inflate(C4548R.layout.sesl_people_picker_layout, (ViewGroup) this, true);
        SeslChipGroup seslChipGroup = (SeslChipGroup) viewInflate.findViewById(C4548R.id.chip);
        this.mChipGroup = seslChipGroup;
        seslChipGroup.setSingleLine(true);
        SeslExpandableContainer seslExpandableContainer = (SeslExpandableContainer) viewInflate.findViewById(C4548R.id.container);
        this.mContainer = seslExpandableContainer;
        seslExpandableContainer.enableFadingAnimation(true);
        setChipGroupEndPadding(seslExpandableContainer.isExpanded());
        setListeners(context);
    }
}
