package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ZoomView extends LinearLayout {
    private static final float DISABLE_ALPHA = 0.4f;
    private static final int DURATION = 333;
    private static final float ENABLE_ALPHA = 1.0f;
    private static final long SHOW_TIME = 2000;
    private static final String TAG = Logger.createTag("ZoomView");
    private boolean mBlock;
    private Runnable mHideRunnable;
    private boolean mIsFadingEnabled;
    private boolean mIsZoomFitToScreenEnabled;
    private IListenerZoomView mListenerZoomView;
    private ViewPropertyAnimator mShowAnimator;
    private ImageButton mZoomFitToScreenButton;
    private float mZoomStartingValue;
    private View mZoomTextScaleImage;
    private float mZoomValue;
    private TextView mZoomValueView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IListenerZoomView {
        boolean isFitToScreen();

        void onClickZoomFitToScreen();
    }

    public ZoomView(Context context) {
        super(context);
        this.mIsFadingEnabled = true;
        this.mIsZoomFitToScreenEnabled = true;
    }

    private boolean isAvailableZoomFitToScreen() {
        if (this.mListenerZoomView == null) {
            return false;
        }
        return !r0.isFitToScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runHideAnimation() {
        animate().alpha(0.0f).setDuration(333L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ZoomView.this.setVisibility(8);
            }
        }).start();
        float f = this.mZoomStartingValue;
        float f4 = this.mZoomValue;
        if (f < f4) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_ZOOM_IN);
        } else if (f > f4) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_ZOOM_OUT);
        }
    }

    private void runShowAnimation() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate = animate();
        this.mShowAnimator = viewPropertyAnimatorAnimate;
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(333L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ZoomView.this.setAlpha(0.0f);
                ZoomView.this.setVisibility(8);
                ZoomView zoomView = ZoomView.this;
                zoomView.removeCallbacks(zoomView.mHideRunnable);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ZoomView zoomView = ZoomView.this;
                zoomView.removeCallbacks(zoomView.mHideRunnable);
                ZoomView zoomView2 = ZoomView.this;
                zoomView2.postDelayed(zoomView2.mHideRunnable, 2000L);
            }
        }).start();
    }

    private void updateFitToScreenButton(boolean z) {
        if (this.mZoomFitToScreenButton == null) {
            return;
        }
        if (z) {
            if (this.mIsZoomFitToScreenEnabled) {
                return;
            }
            Logger.m10999d(TAG, "updateFitToScreenButton# activate");
            this.mZoomFitToScreenButton.setAlpha(1.0f);
            this.mIsZoomFitToScreenEnabled = true;
            return;
        }
        if (this.mIsZoomFitToScreenEnabled) {
            Logger.m10999d(TAG, "updateFitToScreenButton# deactivate");
            this.mZoomFitToScreenButton.setAlpha(0.4f);
            this.mIsZoomFitToScreenEnabled = false;
        }
    }

    private void updateTextScaleImage(boolean z) {
        View view = this.mZoomTextScaleImage;
        if (view == null) {
            return;
        }
        if (z) {
            if (view.getVisibility() != 0) {
                this.mZoomTextScaleImage.setVisibility(0);
            }
        } else if (view.getVisibility() == 0) {
            this.mZoomTextScaleImage.setVisibility(8);
        }
    }

    public void forceShow() {
        show(this.mZoomValue, true, false);
    }

    public float getZoomValue() {
        return this.mZoomValue;
    }

    public void hideTextScaleImage() {
        View view = this.mZoomTextScaleImage;
        if (view != null && view.getVisibility() == 0) {
            this.mZoomTextScaleImage.setVisibility(8);
        }
    }

    public void init(float f, IListenerZoomView iListenerZoomView) {
        this.mZoomValueView = (TextView) findViewById(C9086R.id.comp_zoom_value_view);
        this.mZoomValue = f;
        this.mZoomStartingValue = f;
        this.mListenerZoomView = iListenerZoomView;
        this.mHideRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomView.1
            @Override // java.lang.Runnable
            public void run() {
                ZoomView.this.runHideAnimation();
            }
        };
        this.mZoomTextScaleImage = findViewById(C9086R.id.comp_text_scale_image);
        ImageButton imageButton = (ImageButton) findViewById(C9086R.id.comp_zoom_fit_to_screen_button);
        this.mZoomFitToScreenButton = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ZoomView.this.mIsZoomFitToScreenEnabled) {
                        Logger.m10999d(ZoomView.TAG, "onClick# FitToScreen");
                        ZoomView.this.mListenerZoomView.onClickZoomFitToScreen();
                        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_FIT_PAPER_TO_SCREEN);
                    }
                }
            });
        }
    }

    public void setBlock(boolean z) {
        AbstractC8014b.m7220v("setBlock# ", TAG, z);
        if (z) {
            ViewPropertyAnimator viewPropertyAnimator = this.mShowAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                this.mShowAnimator = null;
            }
            setAlpha(0.0f);
            setVisibility(8);
        }
        this.mBlock = z;
    }

    public void setFadingEnabled(boolean z) {
        this.mIsFadingEnabled = z;
    }

    public void show(float f) {
        show(f, false, false);
    }

    public void showTextScale(float f) {
        show(f, false, true);
    }

    @SuppressLint({"SetTextI18n"})
    private void show(float f, boolean z, boolean z2) {
        if (this.mZoomValueView != null) {
            if (this.mZoomValue != f || z) {
                if (this.mBlock) {
                    Logger.m10999d(TAG, "show# blocked");
                }
                this.mZoomValue = f;
                updateTextScaleImage(z2);
                updateFitToScreenButton(isAvailableZoomFitToScreen());
                this.mZoomValueView.setText(this.mZoomValueView.getResources().getString(C9086R.string.composer_zoom_percent, Integer.valueOf(Math.round(f * 100.0f))));
                if (getVisibility() == 0) {
                    if (this.mIsFadingEnabled) {
                        removeCallbacks(this.mHideRunnable);
                        postDelayed(this.mHideRunnable, 2000L);
                        return;
                    }
                    return;
                }
                setVisibility(0);
                this.mZoomStartingValue = this.mZoomValue;
                if (this.mIsFadingEnabled) {
                    runShowAnimation();
                }
            }
        }
    }

    public ZoomView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFadingEnabled = true;
        this.mIsZoomFitToScreenEnabled = true;
    }

    public ZoomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsFadingEnabled = true;
        this.mIsZoomFitToScreenEnabled = true;
    }

    public ZoomView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsFadingEnabled = true;
        this.mIsZoomFitToScreenEnabled = true;
    }
}
