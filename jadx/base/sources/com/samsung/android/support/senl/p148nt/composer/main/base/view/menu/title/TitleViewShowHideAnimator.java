package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ViewOnHoverListenerC7469a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleViewShowHideAnimator {
    private static final String TAG = Logger.createTag("TitleViewShowHideAnimator");
    private static final float TITLE_END_SCALE = 1.0f;
    private static final float TITLE_START_SCALE = 0.6f;
    public static final float TOOLBAR_END_SCALE = 1.575f;
    private static final float TOOLBAR_START_SCALE = 1.0f;
    private final Contract mContract;
    private final View mTitleFolderContainer;
    private int mTitleLeftEnd;
    private int mTitleLeftStart;
    private final View mTitleTextContainer;
    private int mTitleTopEnd;
    private int mTitleTopStart;
    private final EditText mTitleView;
    private float mToolbarLeftEnd;
    private float mToolbarLeftStart;
    private final TextView mToolbarTitleCopyView;
    private float mToolbarTopEnd;
    private float mToolbarTopStart;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getPresenter();

        void onHide();

        void onShow();
    }

    public TitleViewShowHideAnimator(ViewGroup viewGroup, EditText editText, TextView textView, ViewGroup viewGroup2, Contract contract) {
        this.mTitleTextContainer = viewGroup;
        this.mTitleView = editText;
        this.mToolbarTitleCopyView = textView;
        textView.setOnHoverListener(new ViewOnHoverListenerC7469a(7));
        this.mTitleFolderContainer = viewGroup2;
        this.mContract = contract;
    }

    private void animateTitleViewByFraction(float f) {
        View view = this.mTitleTextContainer;
        float animatedValue = getAnimatedValue(0.6f, 1.0f, f);
        float measuredWidth = view.getMeasuredWidth();
        float measuredHeight = view.getMeasuredHeight();
        view.setX((((measuredWidth * animatedValue) - measuredWidth) / 2.0f) + getAnimatedValue(this.mTitleLeftStart, this.mTitleLeftEnd, f));
        view.setY((((measuredHeight * animatedValue) - measuredHeight) / 2.0f) + getAnimatedValue(this.mTitleTopStart, this.mTitleTopEnd, f));
        view.setScaleX(animatedValue);
        view.setScaleY(animatedValue);
    }

    private void animateToolbarTitleCopyViewByFraction(float f) {
        float animatedValue = getAnimatedValue(1.0f, 1.575f, f);
        float measuredWidth = this.mToolbarTitleCopyView.getMeasuredWidth();
        float measuredHeight = this.mToolbarTitleCopyView.getMeasuredHeight();
        this.mToolbarTitleCopyView.setX((((measuredWidth * animatedValue) - measuredWidth) / 2.0f) + getAnimatedValue(this.mToolbarLeftStart, this.mToolbarLeftEnd, f));
        this.mToolbarTitleCopyView.setY((((measuredHeight * animatedValue) - measuredHeight) / 2.0f) + getAnimatedValue(this.mToolbarTopStart, this.mToolbarTopEnd, f));
        this.mToolbarTitleCopyView.setScaleX(animatedValue);
        this.mToolbarTitleCopyView.setScaleY(animatedValue);
    }

    private float getAnimatedValue(float f, float f4, float f5) {
        return AbstractC0000a.m29z(f4, f, f5, f);
    }

    private void initAnimationValue(boolean z) {
        if (z) {
            this.mToolbarTitleCopyView.setAlpha(0.0f);
        } else {
            this.mTitleView.setAlpha(0.0f);
        }
    }

    private void initToolbarTitleCopyView(AppCompatTextView appCompatTextView, int i) {
        this.mToolbarTitleCopyView.setText(appCompatTextView.getText());
        ViewGroup.LayoutParams layoutParams = this.mToolbarTitleCopyView.getLayoutParams();
        layoutParams.width = Math.max(i, appCompatTextView.getWidth());
        layoutParams.height = appCompatTextView.getHeight();
        this.mToolbarTitleCopyView.setLayoutParams(layoutParams);
        this.mToolbarTitleCopyView.setTextSize(0, appCompatTextView.getTextSize());
        this.mToolbarTitleCopyView.setX(appCompatTextView.getLeft());
        this.mToolbarTitleCopyView.setY(appCompatTextView.getTop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getHideAlphaAnimator$3(ValueAnimator valueAnimator) {
        this.mTitleView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getHideAlphaAnimator$4(ValueAnimator valueAnimator) {
        this.mToolbarTitleCopyView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getShowAlphaAnimator$1(ValueAnimator valueAnimator) {
        this.mTitleView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getShowAlphaAnimator$2(ValueAnimator valueAnimator) {
        this.mToolbarTitleCopyView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    private void setLayoutHeight(int i, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    private void setLayoutWidth(int i, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    private void updateHeight(int i) {
        View view = this.mTitleTextContainer;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    private void updateTitleLeftTop(int i, int i2, int i4, int i5, float f) {
        View view = this.mTitleTextContainer;
        view.setX(getAnimatedValue(i, i4, f));
        view.setY(getAnimatedValue(i2, i5, f));
    }

    private void updateWidth(float f, float f4, float f5) {
        View view = this.mTitleTextContainer;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) getAnimatedValue(f, f4, f5);
        view.setLayoutParams(layoutParams);
    }

    public int getBottom() {
        return this.mTitleTopEnd + this.mTitleView.getLayoutParams().height;
    }

    public AnimatorSet getHideAlphaAnimator() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new C10506e(this, 2));
        valueAnimatorOfFloat.setDuration(200L);
        this.mToolbarTitleCopyView.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.addUpdateListener(new C10506e(this, 3));
        valueAnimatorOfFloat2.setStartDelay(80L);
        valueAnimatorOfFloat2.setDuration(253L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        return animatorSet;
    }

    public AnimatorSet getShowAlphaAnimator() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C10506e(this, 0));
        valueAnimatorOfFloat.setStartDelay(80L);
        valueAnimatorOfFloat.setDuration(253L);
        this.mToolbarTitleCopyView.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(new C10506e(this, 1));
        valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewShowHideAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                TitleViewShowHideAnimator.this.mToolbarTitleCopyView.setVisibility(8);
            }
        });
        valueAnimatorOfFloat2.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        return animatorSet;
    }

    public void initAnimationValueTitleView(int i, int i2, int i4, int i5) {
        this.mTitleLeftStart = i;
        this.mTitleLeftEnd = i2;
        this.mTitleTopStart = i4;
        this.mTitleTopEnd = i5;
    }

    public void initAnimationValueToolbar(AppCompatTextView appCompatTextView, int i, int i2, int i4, int i5) {
        initToolbarTitleCopyView(appCompatTextView, i5);
        this.mToolbarLeftStart = i;
        this.mToolbarLeftEnd = i2;
        this.mToolbarTopStart = this.mToolbarTitleCopyView.getY();
        this.mToolbarTopEnd = i4;
    }

    public void initHideState(int i) {
        Logger.m10999d(TAG, "initHideState#");
        this.mContract.onHide();
        updateWidth(0.0f, i, 1.0f);
        initAnimationValue(true);
        this.mTitleView.setSelection(0);
        this.mTitleView.setEnabled(false);
    }

    public void initShowState(int i, int i2) {
        Logger.m10999d(TAG, "initShowState#");
        this.mContract.onShow();
        updateHeight(i2);
        updateWidth(0.0f, i, 1.0f);
        updateTitleLeftTop(this.mTitleLeftStart, this.mTitleTopStart, this.mTitleLeftEnd, this.mTitleTopEnd, 1.0f);
        initAnimationValue(false);
        updateFolderContainerWidth(i);
        this.mTitleView.setEnabled(false);
    }

    public void updateFolderContainerWidth(int i) {
        int dimensionPixelSize = i - this.mTitleFolderContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_folder_container_margin);
        if (dimensionPixelSize < this.mTitleFolderContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_folder_icon_size)) {
            dimensionPixelSize = 1;
        }
        AbstractC0000a.m3D(dimensionPixelSize, "updateFolderContainerWidth# folderWidth = ", TAG);
        setLayoutWidth(dimensionPixelSize, this.mTitleFolderContainer);
    }

    public void updateViewByFraction(float f, boolean z) {
        if (z) {
            f = 1.0f - f;
        }
        animateTitleViewByFraction(f);
        animateToolbarTitleCopyViewByFraction(f);
    }

    public void updateWidth(int i, int i2) {
        setLayoutHeight(i2, this.mTitleTextContainer);
        setLayoutWidth(i, this.mTitleTextContainer);
        updateFolderContainerWidth(i);
    }
}
