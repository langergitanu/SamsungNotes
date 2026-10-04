package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwAddToNoteBottomView {
    private static final String TAG = Logger.createTag("PwAddToNoteBottomView");
    private ViewGroup mAddToNoteBottomView;
    private ValueAnimator mFadeInOutAnimator;
    private View.OnClickListener mOnClickListener;
    private Animation mSlideDownAnimation;
    private Animation mSlideUpAnimation;

    public PwAddToNoteBottomView(Activity activity, View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.mAddToNoteBottomView = (ViewGroup) activity.findViewById(C9086R.id.comp_bottom_cover_container);
        int i = C9086R.layout.pdf_add_to_note_bottom;
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500) {
            ViewGroup.LayoutParams layoutParams = this.mAddToNoteBottomView.getLayoutParams();
            layoutParams.width = -2;
            this.mAddToNoteBottomView.setLayoutParams(layoutParams);
            i = C9086R.layout.pdf_add_to_note_bottom_floating;
        }
        View viewInflate = activity.getLayoutInflater().inflate(i, this.mAddToNoteBottomView, true);
        ((TextView) viewInflate.findViewById(C9086R.id.toast_text)).setText(activity.getResources().getString(C9086R.string.add_to_note_message));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.dialog.PwAddToNoteBottomView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PwAddToNoteBottomView.this.mOnClickListener != null) {
                    PwAddToNoteBottomView.this.mOnClickListener.onClick(null);
                }
            }
        });
        initAnimation();
    }

    private void initAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.mSlideUpAnimation = translateAnimation;
        translateAnimation.setDuration(500L);
        this.mSlideUpAnimation.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.mSlideDownAnimation = translateAnimation2;
        translateAnimation2.setDuration(330L);
        this.mSlideDownAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f));
        this.mSlideDownAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.dialog.PwAddToNoteBottomView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PwAddToNoteBottomView.this.mAddToNoteBottomView.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mFadeInOutAnimator = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
    }

    public void hide(boolean z) {
        if (isShowing()) {
            if (this.mFadeInOutAnimator.isRunning()) {
                this.mFadeInOutAnimator.cancel();
            }
            if (z) {
                this.mFadeInOutAnimator.setFloatValues(1.0f, 0.0f);
                this.mFadeInOutAnimator.setDuration(100L);
                this.mFadeInOutAnimator.start();
            }
            this.mSlideUpAnimation.cancel();
            this.mSlideDownAnimation.cancel();
            if (z) {
                this.mAddToNoteBottomView.startAnimation(this.mSlideDownAnimation);
            } else {
                this.mAddToNoteBottomView.setVisibility(8);
            }
        }
    }

    public boolean isAnimationRunning() {
        Animation animation = this.mSlideUpAnimation;
        if (animation != null && animation.hasStarted() && !this.mSlideUpAnimation.hasEnded()) {
            return true;
        }
        Animation animation2 = this.mSlideDownAnimation;
        if (animation2 == null || !animation2.hasStarted() || this.mSlideDownAnimation.hasEnded()) {
            return this.mFadeInOutAnimator.isRunning();
        }
        return true;
    }

    public boolean isShowing() {
        ViewGroup viewGroup = this.mAddToNoteBottomView;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public void show() {
        Logger.m11003i(TAG, "show#");
        if (isShowing()) {
            return;
        }
        this.mSlideUpAnimation.cancel();
        this.mSlideDownAnimation.cancel();
        this.mAddToNoteBottomView.setVisibility(0);
        this.mAddToNoteBottomView.startAnimation(this.mSlideUpAnimation);
        if (this.mFadeInOutAnimator.isRunning()) {
            this.mFadeInOutAnimator.cancel();
        }
        this.mFadeInOutAnimator.setFloatValues(0.0f, 1.0f);
        this.mFadeInOutAnimator.setDuration(200L);
        this.mFadeInOutAnimator.start();
    }
}
