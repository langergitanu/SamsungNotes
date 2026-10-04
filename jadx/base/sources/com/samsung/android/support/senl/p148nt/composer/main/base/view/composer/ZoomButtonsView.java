package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import com.samsung.android.support.senl.addons.base.utils.DrawableUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ZoomButtonsView {
    public static final int BLOCK_CANVAS_LOCK = 1;
    public static final int BLOCK_EASY_WRITING_PAD = 4;
    private static final int DELAY_SHOW = 300;
    private static final float DISABLE_ALPHA = 0.4f;
    private static final int DURATION = 200;
    private static final int DURATION_SHOWN = 3000;
    private static final float ENABLE_ALPHA = 1.0f;
    private static final String TAG = Logger.createTag("ZoomButtonsView");
    private int mBlockScenario;
    protected Context mContext;
    private AnimationSet mHideAnimation;
    private boolean mIsBlockShow;
    private boolean mIsFadingEnabled = true;
    private boolean mIsOnHideAnimation;
    private AnimationSet mShowAnimation;
    private Runnable mStartHideAnimationRunnable;
    private Runnable mStartShowAnimationRunnable;
    private View mZoomContainerView;
    private final ImageView mZoomInButtonView;
    private final ImageView mZoomOutButtonView;

    public ZoomButtonsView(ViewGroup viewGroup, View view, Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mContext = context;
        this.mZoomContainerView = view;
        ImageView imageView = (ImageView) viewGroup.findViewById(C9086R.id.comp_zoom_in_btn);
        this.mZoomInButtonView = imageView;
        initButtonView(imageView, onClickListener);
        ImageView imageView2 = (ImageView) viewGroup.findViewById(C9086R.id.comp_zoom_out_btn);
        this.mZoomOutButtonView = imageView2;
        initButtonView(imageView2, onClickListener2);
        makeShowAnimation();
        makeHideAnimation();
    }

    private void initButtonView(ImageView imageView, View.OnClickListener onClickListener) {
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setBackground(DrawableUtils.setRippleSelected(this.mContext, DrawableUtils.TYPE_RECTANGLE));
        ViewCompat.getInstance().setTooltipText(imageView);
    }

    private void makeHideAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setStartOffset(0L);
        alphaAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        this.mHideAnimation = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.mHideAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomButtonsView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ZoomButtonsView.this.mIsOnHideAnimation) {
                    ZoomButtonsView.this.mZoomContainerView.setVisibility(8);
                }
                ZoomButtonsView.this.mZoomContainerView.setAlpha(1.0f);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void makeShowAnimation() {
        this.mStartHideAnimationRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomButtonsView.1
            @Override // java.lang.Runnable
            public void run() {
                ZoomButtonsView.this.mIsOnHideAnimation = true;
                ZoomButtonsView.this.mZoomContainerView.startAnimation(ZoomButtonsView.this.mHideAnimation);
                ZoomButtonsView.this.mStartShowAnimationRunnable = null;
            }
        };
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(0L);
        alphaAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        this.mShowAnimation = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.mShowAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomButtonsView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ZoomButtonsView.this.release();
                ZoomButtonsView.this.mZoomContainerView.postDelayed(ZoomButtonsView.this.mStartHideAnimationRunnable, AiSTTListView.USER_SCROLL_INTERVAL);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                ZoomButtonsView.this.mZoomContainerView.setVisibility(0);
            }
        });
    }

    private void setButtonEnable(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setAlpha(z ? 1.0f : 0.4f);
        view.setEnabled(z);
    }

    public boolean isShowing() {
        return this.mZoomContainerView.getVisibility() == 0;
    }

    public void release() {
        this.mZoomContainerView.removeCallbacks(this.mStartShowAnimationRunnable);
        this.mStartShowAnimationRunnable = null;
        this.mZoomContainerView.removeCallbacks(this.mStartHideAnimationRunnable);
        this.mContext = null;
    }

    public void setBlockShow(int i, boolean z) {
        if (z) {
            this.mBlockScenario = i | this.mBlockScenario;
        } else {
            this.mBlockScenario = (~i) & this.mBlockScenario;
        }
        boolean z2 = this.mBlockScenario != 0;
        this.mIsBlockShow = z2;
        setVisible(!z2);
    }

    public void setFadingEnabled(boolean z) {
        this.mIsFadingEnabled = z;
    }

    public void setRippleSelectedType(int i) {
        ImageView imageView = this.mZoomInButtonView;
        if (imageView == null || this.mZoomOutButtonView == null) {
            return;
        }
        imageView.setBackground(DrawableUtils.setRippleSelected(this.mContext, i));
        this.mZoomOutButtonView.setBackground(DrawableUtils.setRippleSelected(this.mContext, i));
    }

    public void setVisible(boolean z) {
        if (this.mZoomInButtonView == null || this.mZoomOutButtonView == null) {
            return;
        }
        if (this.mIsBlockShow && z) {
            Logger.m11003i(TAG, "setVisible# block to show");
            return;
        }
        if (!z) {
            release();
            this.mZoomContainerView.setVisibility(8);
            return;
        }
        if (!this.mIsFadingEnabled) {
            this.mZoomContainerView.setVisibility(0);
            return;
        }
        if (isShowing()) {
            release();
            this.mZoomContainerView.postDelayed(this.mStartHideAnimationRunnable, AiSTTListView.USER_SCROLL_INTERVAL);
        } else if (this.mStartShowAnimationRunnable == null) {
            Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ZoomButtonsView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ZoomButtonsView.this.mIsBlockShow) {
                        Logger.m11003i(ZoomButtonsView.TAG, "setVisible# block to show");
                    } else {
                        ZoomButtonsView.this.mZoomContainerView.startAnimation(ZoomButtonsView.this.mShowAnimation);
                    }
                }
            };
            this.mStartShowAnimationRunnable = runnable;
            this.mZoomContainerView.postDelayed(runnable, 300L);
        }
    }

    public void updateButtonEnable(float f, float f4, float f5) {
        boolean z = f < f5;
        boolean z2 = f > f4;
        setButtonEnable(this.mZoomInButtonView, z);
        setButtonEnable(this.mZoomOutButtonView, z2);
    }
}
