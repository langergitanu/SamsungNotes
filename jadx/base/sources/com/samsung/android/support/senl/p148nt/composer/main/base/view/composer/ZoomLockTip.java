package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class ZoomLockTip {
    private static final String SETTING_SHOW_COUNT_KEY = "zoom_lock_tip";
    private AnimatorSet mHideAnimatorSet;
    private AnimatorSet mShowAnimatorSet;
    private View mZoomTipView;

    public ZoomLockTip(View view) {
        this.mZoomTipView = view;
    }

    private AnimatorSet getHideAnimatorSet() {
        if (this.mHideAnimatorSet == null) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mZoomTipView, "scaleX", 1.0f, 0.95f);
            objectAnimatorOfFloat.setDuration(200L).setInterpolator(pathInterpolator);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mZoomTipView, "scaleY", 1.0f, 0.95f);
            objectAnimatorOfFloat2.setDuration(200L).setInterpolator(pathInterpolator);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.mZoomTipView, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat3.setDuration(200L).setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.mHideAnimatorSet = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
            this.mHideAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomLockTip.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ZoomLockTip.this.mZoomTipView.setVisibility(8);
                }
            });
        }
        return this.mHideAnimatorSet;
    }

    private AnimatorSet getShowAnimatorSet() {
        if (this.mShowAnimatorSet == null) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.6f, 0.0f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mZoomTipView, "scaleX", 0.95f, 1.0f);
            objectAnimatorOfFloat.setDuration(350L).setInterpolator(pathInterpolator);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mZoomTipView, "scaleY", 0.95f, 1.0f);
            objectAnimatorOfFloat2.setDuration(350L).setInterpolator(pathInterpolator);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.mZoomTipView, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat3.setDuration(100L).setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.mShowAnimatorSet = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        }
        return this.mShowAnimatorSet;
    }

    private boolean isNotAvailableToShow() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        int i = sharedPreferencesCompat.getInt(SETTING_SHOW_COUNT_KEY, 0);
        if (i >= 3) {
            return true;
        }
        sharedPreferencesCompat.putInt(SETTING_SHOW_COUNT_KEY, i + 1);
        return false;
    }

    public void hide() {
        if (this.mZoomTipView.getVisibility() != 0) {
            return;
        }
        this.mZoomTipView.removeCallbacks(null);
        if (getShowAnimatorSet().isRunning()) {
            getShowAnimatorSet().cancel();
        }
        getHideAnimatorSet().start();
    }

    public void show() {
        if (getShowAnimatorSet().isRunning()) {
            return;
        }
        if (getHideAnimatorSet().isRunning()) {
            getHideAnimatorSet().cancel();
        }
        this.mZoomTipView.setVisibility(0);
        getShowAnimatorSet().start();
        this.mZoomTipView.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomLockTip.1
            @Override // java.lang.Runnable
            public void run() {
                ZoomLockTip.this.hide();
            }
        }, AiSTTListView.USER_SCROLL_INTERVAL);
    }
}
