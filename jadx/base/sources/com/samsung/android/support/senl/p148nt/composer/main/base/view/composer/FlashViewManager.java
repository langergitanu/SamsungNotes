package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.Callback;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FlashViewManager {
    private static final boolean DEBUG_CAPTURE_VIEW = true;
    private ImageView mCaptureView;
    private View mCoverView;
    private ViewTreeObserver.OnDrawListener mOnDrawListener;

    public View getCoverView() {
        return this.mCoverView;
    }

    public void hideCover() {
        View view = this.mCoverView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void init(ViewGroup viewGroup) {
        this.mCaptureView = (ImageView) viewGroup.findViewById(C9086R.id.comp_capture_view);
        View viewFindViewById = viewGroup.findViewById(C9086R.id.comp_view_cover);
        this.mCoverView = viewFindViewById;
        BackgroundColorUtil.updateAntiGreenishColor(viewFindViewById);
    }

    public boolean isVisibleCaptureView() {
        ImageView imageView = this.mCaptureView;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void removeCaptureView(@NonNull final Runnable runnable) {
        if (isVisibleCaptureView()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setStartOffset(0L);
            alphaAnimation.setDuration(300L);
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FlashViewManager.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (FlashViewManager.this.mCaptureView != null) {
                        FlashViewManager.this.mCaptureView.setForeground(null);
                        FlashViewManager.this.mCaptureView.setVisibility(8);
                    }
                    runnable.run();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.mCaptureView.startAnimation(animationSet);
        }
    }

    public void showCaptureView(SpenComposer spenComposer, final Callback callback) {
        if (this.mCaptureView == null) {
            return;
        }
        spenComposer.getLocationOnScreen(new int[2]);
        this.mCaptureView.getLocationOnScreen(new int[2]);
        this.mCaptureView.setTranslationY(r1[1] - r0[1]);
        Bitmap bitmapCaptureCurrentView = spenComposer.captureCurrentView();
        if (bitmapCaptureCurrentView == null) {
            ImageView imageView = this.mCaptureView;
            imageView.setBackgroundColor(imageView.getResources().getColor(C9086R.color.composer_container_background, null));
        } else {
            if (spenComposer.getBackground() instanceof StateListDrawable) {
                new Canvas(bitmapCaptureCurrentView).drawColor(((ColorDrawable) ((StateListDrawable) spenComposer.getBackground()).getCurrent()).getColor(), PorterDuff.Mode.DST_OVER);
            }
            this.mCaptureView.setBackground(new BitmapDrawable(this.mCaptureView.getResources(), bitmapCaptureCurrentView));
        }
        this.mCaptureView.setVisibility(0);
        if (callback == null) {
            return;
        }
        this.mOnDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FlashViewManager.1
            boolean isCalled = false;

            @Override // android.view.ViewTreeObserver.OnDrawListener
            public void onDraw() {
                if (this.isCalled) {
                    return;
                }
                this.isCalled = true;
                FlashViewManager.this.mCaptureView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FlashViewManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onDone(null);
                        FlashViewManager.this.mCaptureView.getViewTreeObserver().removeOnDrawListener(FlashViewManager.this.mOnDrawListener);
                        FlashViewManager.this.mOnDrawListener = null;
                    }
                });
            }
        };
        this.mCaptureView.getViewTreeObserver().addOnDrawListener(this.mOnDrawListener);
    }

    public void showCover() {
        View view = this.mCoverView;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
