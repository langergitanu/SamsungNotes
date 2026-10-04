package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionBottomMenu {
    private static final String TAG = Logger.createTag("OptionBottomMenu");
    private ViewGroup mBottomMenuContainer;
    private ValueAnimator mFadeInOutAnimator;
    private OptionMenuPresenter mOptionMenuPresenter;
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private Animation mSlideDownAnimation;
    private Animation mSlideUpAnimation;

    public OptionBottomMenu(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        this.mOptionMenuPresenter = optionMenuPresenter;
        this.mBottomMenuContainer = (ViewGroup) activity.findViewById(C9086R.id.comp_bottom_cover_container);
        activity.getLayoutInflater().inflate(C9086R.layout.pdf_reader_bottom_menu, this.mBottomMenuContainer, true).findViewById(C9086R.id.pdf_reader_add_to_button).setVisibility(8);
        this.mBottomMenuContainer.findViewById(C9086R.id.pdf_reader_edit_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionBottomMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OptionBottomMenu.this.hide(true);
                OptionBottomMenu.this.mOptionMenuPresenter.onClickReadModeBtn();
            }
        });
        this.mBottomMenuContainer.findViewById(C9086R.id.pdf_reader_assist_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionBottomMenu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OptionBottomMenu.this.hide(true);
                OptionBottomMenu.this.mOptionMenuPresenter.showOverlayTranslation();
            }
        });
        initAnimation();
        if (this.mPreTouchListener == null) {
            final GestureDetector gestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionBottomMenu.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                    if (!OptionBottomMenu.this.isShowing()) {
                        return false;
                    }
                    OptionBottomMenu.this.hide(true);
                    return false;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                    if (!OptionBottomMenu.this.isShowing()) {
                        return false;
                    }
                    OptionBottomMenu.this.hide(true);
                    return false;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    if (OptionBottomMenu.this.isAnimationRunning()) {
                        return false;
                    }
                    OptionBottomMenu.this.mOptionMenuPresenter.getComposerViewPresenter().getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionBottomMenu.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (OptionBottomMenu.this.isShowing()) {
                                OptionBottomMenu.this.hide(true);
                            } else if (OptionBottomMenu.this.mOptionMenuPresenter.isNeedToShowBottomView()) {
                                OptionBottomMenu.this.show();
                            }
                        }
                    }, (OptionBottomMenu.this.mOptionMenuPresenter.getComposerViewPresenter().getPdfManager().hasSelectedText() || OptionBottomMenu.this.mOptionMenuPresenter.getComposerViewPresenter().getTextManager().isSelected()) ? 100L : 0L);
                    return false;
                }
            });
            this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionBottomMenu.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    gestureDetector.onTouchEvent(motionEvent);
                    return false;
                }
            };
        }
        this.mOptionMenuPresenter.getComposerViewPresenter().getListenerManager().addPreTouchListener(this.mPreTouchListener);
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
        this.mSlideDownAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionBottomMenu.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                OptionBottomMenu.this.mBottomMenuContainer.setVisibility(8);
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
                this.mBottomMenuContainer.startAnimation(this.mSlideDownAnimation);
            } else {
                this.mBottomMenuContainer.setVisibility(8);
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
        ViewGroup viewGroup = this.mBottomMenuContainer;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public void show() {
        Logger.m11003i(TAG, "show#");
        if (isShowing()) {
            return;
        }
        this.mSlideUpAnimation.cancel();
        this.mSlideDownAnimation.cancel();
        this.mBottomMenuContainer.setVisibility(0);
        this.mBottomMenuContainer.startAnimation(this.mSlideUpAnimation);
        if (this.mFadeInOutAnimator.isRunning()) {
            this.mFadeInOutAnimator.cancel();
        }
        this.mFadeInOutAnimator.setFloatValues(0.0f, 1.0f);
        this.mFadeInOutAnimator.setDuration(200L);
        this.mFadeInOutAnimator.start();
    }
}
