package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.ViewOnLayoutChangeListenerC7473a;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightEffect;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.GuidingLightEffectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiResultProgress {
    private static final long EFFECT_DURATION = 2000;
    private static final String TAG = Logger.createTag("AiResultProgress", AiConstants.PREFIX_TAG);
    View mBlockingScrollView;
    private View.OnLayoutChangeListener mBlockingScrollViewOnLayoutChangeListener;
    View mBlockingView;
    Contract mContract;
    BaseProgress mProgressImpl;
    AiMenuResultProgress mTextProgress;
    View.OnClickListener mTranscribeCancelListener;
    View mTranscribeProgressCancelBtn;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BaseProgress {
        Animator mBGAnimator;
        View mBGEffectTargetView;
        GuidingLightEffect mBGLightEffect;
        ProcessingLightEffect mContentAreaEffect;
        View mContentAreaEffectView;
        Animator mGenerateEndAnimator;
        View mIndicatorContainer;
        TransitionLightEffect mTransitionEffect;
        View mTranstionTargetView;
        boolean mIsReady = false;
        boolean mFirstAnimationFlag = true;

        public BaseProgress(View view) {
            AiResultProgress.this.mBlockingView.setBackground(null);
            this.mContentAreaEffectView = view.findViewById(C9086R.id.ai_menu_result_viewpager_animation_cover);
            this.mBGEffectTargetView = view.findViewById(C9086R.id.ai_result_bg_lighting_effect);
            this.mIndicatorContainer = view.findViewById(C9086R.id.ai_menu_result_viewpage_indicator_container);
            this.mTranstionTargetView = view.findViewById(C9086R.id.transition_light_effect_view);
        }

        private void clearProgressState() {
            AiResultProgress.this.mBlockingView.setVisibility(8);
            AiResultProgress.this.mBlockingScrollView.setVisibility(8);
            AiResultProgress.this.mTextProgress.stopProgress();
            ProcessingLightEffect processingLightEffect = this.mContentAreaEffect;
            if (processingLightEffect != null && Build.VERSION.SDK_INT >= 33) {
                processingLightEffect.stop();
                this.mContentAreaEffect.remove(this.mContentAreaEffectView);
                this.mContentAreaEffect.release();
                this.mContentAreaEffect = null;
            }
            Animator animator = this.mGenerateEndAnimator;
            if (animator != null) {
                animator.cancel();
            }
            GuidingLightEffect guidingLightEffect = this.mBGLightEffect;
            if (guidingLightEffect != null && Build.VERSION.SDK_INT >= 33) {
                guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
                this.mBGLightEffect.remove(this.mBGEffectTargetView);
                this.mBGLightEffect.release();
                this.mBGLightEffect = null;
            }
            this.mBGEffectTargetView.setVisibility(8);
            Animator animator2 = this.mBGAnimator;
            if (animator2 != null) {
                animator2.cancel();
                this.mBGAnimator = null;
            }
            View view = this.mContentAreaEffectView;
            if (view != null) {
                view.setVisibility(8);
            }
            DeviceUtils.updatePreferredDisplayMode(AiResultProgress.this.mContract.getActivity(), 0.0f);
        }

        private void initCoverEffect() {
            this.mIsReady = true;
            this.mContentAreaEffectView.setAlpha(1.0f);
            this.mContentAreaEffectView.setVisibility(0);
            if (AiViewUtils.isAtLeastOneUI85()) {
                this.mContentAreaEffectView.setBackground(null);
            }
            if (this.mContentAreaEffect == null) {
                initProcessingLightEffect();
            }
        }

        private void initGenerateEndAnimation(final boolean z) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            final List<View> topButtons = AiResultProgress.this.mContract.getTopButtons();
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (z) {
                        for (View view : topButtons) {
                            if (view.getId() != C9086R.id.ai_menu_result_setting_btn || view.isEnabled()) {
                                view.setAlpha(fFloatValue);
                            } else {
                                view.setAlpha(0.4f);
                            }
                        }
                        BaseProgress.this.mIndicatorContainer.setAlpha(fFloatValue);
                    }
                }
            });
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            this.mGenerateEndAnimator = valueAnimatorOfFloat;
        }

        public void clear() {
            clearProgressState();
            TransitionLightEffect transitionLightEffect = this.mTransitionEffect;
            if (transitionLightEffect != null && Build.VERSION.SDK_INT >= 33) {
                transitionLightEffect.stop();
                this.mTransitionEffect.remove(this.mTranstionTargetView);
                this.mTransitionEffect.release();
                this.mTransitionEffect = null;
            }
            AiResultProgress.this.mTextProgress.clear();
        }

        public void hideProgress() {
            boolean z = AiResultProgress.this.mBlockingView.getVisibility() == 0 && this.mIsReady;
            clearProgressState();
            if (z) {
                runGenerateEndAnimation();
            }
        }

        public void initProcessingLightEffect() {
        }

        public void readyGenerateEndAnimation() {
            this.mIndicatorContainer.setAlpha(0.0f);
            Iterator<View> it = AiResultProgress.this.mContract.getTopButtons().iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.0f);
            }
            startBgEffect();
            this.mFirstAnimationFlag = false;
        }

        public void runGenerateEndAnimation() {
            DeviceUtils.updatePreferredDisplayMode(AiResultProgress.this.mContract.getActivity(), 60.0f);
            initGenerateEndAnimation(this.mIndicatorContainer.getAlpha() == 0.0f);
            this.mGenerateEndAnimator.start();
            startTransitionEffect();
            ViewCompat.getInstance().performHapticFeedback(this.mTranstionTargetView, 6);
            AiResultProgress.this.mBlockingView.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress.1
                @Override // java.lang.Runnable
                public void run() {
                    DeviceUtils.updatePreferredDisplayMode(AiResultProgress.this.mContract.getActivity(), 0.0f);
                }
            }, 2000L);
        }

        public void showProgress(int i) {
            ProcessingLightEffect processingLightEffect;
            DeviceUtils.updatePreferredDisplayMode(AiResultProgress.this.mContract.getActivity(), 60.0f);
            if (AiResultProgress.this.isShowingProgress()) {
                Logger.m11003i(AiResultProgress.TAG, "showProgress# show duplicated");
                Integer lastType = AiResultProgress.this.mTextProgress.getLastType();
                if (lastType == null || lastType.intValue() == i) {
                    return;
                }
                AiResultProgress.this.mTextProgress.updateProgress(i);
                return;
            }
            boolean z = this.mFirstAnimationFlag;
            initCoverEffect();
            if (this.mFirstAnimationFlag) {
                readyGenerateEndAnimation();
            }
            AiResultProgress.this.mBlockingView.setVisibility(0);
            AiResultProgress.this.mBlockingScrollView.setVisibility(0);
            AiResultProgress.this.mTextProgress.stopProgress();
            AiResultProgress.this.mTextProgress.startProgress(i);
            if (z || (processingLightEffect = this.mContentAreaEffect) == null || Build.VERSION.SDK_INT < 33) {
                return;
            }
            processingLightEffect.start();
        }

        public void startBgEffect() {
        }

        public void startProcessingEffect85() {
        }

        public void startTransitionEffect() {
        }

        public void updateBGEffect() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        Activity getActivity();

        List<View> getTopButtons();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ProgressOneUI7 extends BaseProgress {
        public ProgressOneUI7(View view) {
            super(view);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void initProcessingLightEffect() {
            if (Build.VERSION.SDK_INT < 33) {
                return;
            }
            ProcessingLightConfig vi_config_default = ProcessingLightConfig.INSTANCE.getVI_CONFIG_DEFAULT();
            vi_config_default.setAngle(84.0f);
            vi_config_default.setBlendMode(ProcessingLightConfig.BlendMode.ADD);
            vi_config_default.setFrameRate(60.0f);
            vi_config_default.setDurationInMillis(2000L);
            this.mContentAreaEffect = new ProcessingLightEffect(this.mContentAreaEffectView, vi_config_default);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void startBgEffect() {
            if (Build.VERSION.SDK_INT < 33) {
                return;
            }
            this.mBGEffectTargetView.setAlpha(1.0f);
            this.mBGEffectTargetView.setVisibility(0);
            GuidingLightEffect guidingLightEffect = new GuidingLightEffect(this.mBGEffectTargetView.getContext(), this.mBGEffectTargetView, !AiViewUtils.isAtLeastOneUI85() ? ContextUtils.isNightMode(this.mBGEffectTargetView.getContext()) ? GuidingLightConfig.DEFAULT_DARK : GuidingLightConfig.DEFAULT_LIGHT : ContextUtils.isNightMode(this.mBGEffectTargetView.getContext()) ? GuidingLightConfig.RESULT_DARK : GuidingLightConfig.DEFAULT_LIGHT);
            this.mBGLightEffect = guidingLightEffect;
            guidingLightEffect.setCornerRadiusPixel(1.0f, GuidingLightEffect.CornerRadiusSide.ALL);
            if (!AiViewUtils.isAtLeastOneUI85()) {
                this.mBGLightEffect.setColorState(PresetEffectColor.State.Common);
            }
            this.mBGLightEffect.setLightMovement(GuidingLightEffect.Movement.NONE);
            this.mBGLightEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.ProgressOneUI7.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    ProgressOneUI7.this.mBGEffectTargetView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            valueAnimatorOfFloat.setStartDelay(300L);
            valueAnimatorOfFloat.setDuration(500L);
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 1);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.ProgressOneUI7.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ProcessingLightEffect processingLightEffect;
                    if (Build.VERSION.SDK_INT < 33 || ProgressOneUI7.this.mContentAreaEffectView.getVisibility() != 0 || (processingLightEffect = ProgressOneUI7.this.mContentAreaEffect) == null) {
                        return;
                    }
                    processingLightEffect.start();
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfInt);
            this.mBGAnimator = animatorSet;
            animatorSet.start();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void startTransitionEffect() {
            if (Build.VERSION.SDK_INT < 33) {
                return;
            }
            if (this.mTransitionEffect == null) {
                TransitionLightConfig vi_config_default = TransitionLightConfig.INSTANCE.getVI_CONFIG_DEFAULT();
                vi_config_default.setAngle(84.0f);
                vi_config_default.setDurationInMillis(2000L);
                vi_config_default.setRevealMode(TransitionLightConfig.RevealMode.VIEW);
                vi_config_default.setFrameRate(60.0f);
                this.mTransitionEffect = new TransitionLightEffect(this.mTranstionTargetView, vi_config_default);
            }
            this.mTransitionEffect.start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ProgressOneUI85 extends ProgressOneUI7 {
        private GuidingLightEffect mBackgroundEffect;
        private final View mBackgroundEffectTargetView;
        private final View mContentContainer;
        private Runnable mStartProcessingEffect;

        public ProgressOneUI85(View view) {
            super(view);
            ((ViewGroup) this.mContentAreaEffectView.getParent()).removeView(this.mContentAreaEffectView);
            ((ViewGroup) view.findViewById(C9086R.id.ai_menu_result_viewpager_animation_cover_container85)).addView(this.mContentAreaEffectView);
            this.mContentAreaEffectView.requestLayout();
            this.mBackgroundEffectTargetView = view.findViewById(C9086R.id.ai_result_bg_effect85);
            this.mContentContainer = this.mTranstionTargetView;
            this.mTranstionTargetView = view.findViewById(C9086R.id.ai_menu_result_main_container);
            initBackgroundEffect();
        }

        private void initBackgroundEffect() {
            if (Build.VERSION.SDK_INT >= 33) {
                GuidingLightEffect guidingLightEffect = this.mBackgroundEffect;
                if (guidingLightEffect != null) {
                    guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
                    this.mBackgroundEffect.remove(this.mBackgroundEffectTargetView);
                    this.mBackgroundEffect.release();
                }
                GuidingLightEffect guidingLightEffectCreateGuidingLightEffectResultBG = GuidingLightEffectUtil.createGuidingLightEffectResultBG(this.mBackgroundEffectTargetView);
                this.mBackgroundEffect = guidingLightEffectCreateGuidingLightEffectResultBG;
                guidingLightEffectCreateGuidingLightEffectResultBG.show(GuidingLightEffect.ShowAnimationType.NONE);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void clear() {
            super.clear();
            this.mStartProcessingEffect = null;
            GuidingLightEffect guidingLightEffect = this.mBackgroundEffect;
            if (guidingLightEffect == null || Build.VERSION.SDK_INT < 33) {
                return;
            }
            guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
            this.mBackgroundEffect.remove(this.mBackgroundEffectTargetView);
            this.mBackgroundEffect.release();
            this.mBackgroundEffect = null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void hideProgress() {
            super.hideProgress();
            this.mContentContainer.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 33) {
                this.mBackgroundEffectTargetView.setVisibility(0);
                this.mBackgroundEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void readyGenerateEndAnimation() {
            this.mIndicatorContainer.setAlpha(0.0f);
            Iterator<View> it = AiResultProgress.this.mContract.getTopButtons().iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.0f);
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.mStartProcessingEffect = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.ProgressOneUI85.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ProcessingLightEffect processingLightEffect = ProgressOneUI85.this.mContentAreaEffect;
                        if (processingLightEffect != null) {
                            processingLightEffect.start();
                        }
                    }
                };
            }
            this.mFirstAnimationFlag = false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void showProgress(int i) {
            this.mContentContainer.setVisibility(4);
            super.showProgress(i);
            if (Build.VERSION.SDK_INT >= 33) {
                this.mBackgroundEffectTargetView.setVisibility(4);
                this.mBackgroundEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void startProcessingEffect85() {
            Runnable runnable;
            if (Build.VERSION.SDK_INT >= 33 && this.mContentAreaEffectView.getVisibility() == 0 && (runnable = this.mStartProcessingEffect) != null) {
                this.mContentAreaEffectView.post(runnable);
            }
            this.mFirstAnimationFlag = false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.BaseProgress
        public void updateBGEffect() {
            if (Build.VERSION.SDK_INT < 33 || this.mBackgroundEffect == null || this.mBackgroundEffectTargetView.getVisibility() != 0) {
                return;
            }
            this.mBackgroundEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
        }
    }

    public AiResultProgress(View.OnClickListener onClickListener, Contract contract) {
        this.mTranscribeCancelListener = onClickListener;
        this.mContract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initProgress$0(View view, View view2, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (view.getTop() < 0) {
            ((ViewGroup) this.mBlockingScrollView).getChildAt(0).setTranslationY(view.getTop() * (-1));
        } else {
            ((ViewGroup) this.mBlockingScrollView).getChildAt(0).setTranslationY(0.0f);
        }
    }

    public void clear() {
        this.mProgressImpl.clear();
        if (this.mBlockingScrollViewOnLayoutChangeListener != null) {
            ((View) this.mBlockingScrollView.getParent()).removeOnLayoutChangeListener(this.mBlockingScrollViewOnLayoutChangeListener);
        }
    }

    public AiMenuResultProgress getTextProgress() {
        return this.mTextProgress;
    }

    public View getTranscribeProgressCancelBtn() {
        return this.mTranscribeProgressCancelBtn;
    }

    public void hideProgress() {
        if (this.mBlockingView.getVisibility() == 8) {
            return;
        }
        Logger.m11003i(TAG, "hideProgress#");
        this.mProgressImpl.hideProgress();
    }

    public void inLayoutFinished() {
        BaseProgress baseProgress = this.mProgressImpl;
        if (baseProgress != null) {
            baseProgress.startProcessingEffect85();
        }
    }

    public void initProgress(View view) {
        this.mTextProgress = new AiMenuResultProgress(view);
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_blocking_scroll_view);
        this.mBlockingScrollView = viewFindViewById;
        View childAt = ((ViewGroup) viewFindViewById).getChildAt(0);
        if (this.mBlockingScrollViewOnLayoutChangeListener == null) {
            this.mBlockingScrollViewOnLayoutChangeListener = new ViewOnLayoutChangeListenerC7473a(this, childAt, 3);
        }
        ((View) this.mBlockingScrollView.getParent()).addOnLayoutChangeListener(this.mBlockingScrollViewOnLayoutChangeListener);
        View viewFindViewById2 = view.findViewById(C9086R.id.ai_menu_result_blocking_view);
        this.mBlockingView = viewFindViewById2;
        viewFindViewById2.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return !AiResultProgress.this.mTranscribeProgressCancelBtn.isShown();
            }
        });
        View viewFindViewById3 = view.findViewById(C9086R.id.ai_transcribe_cancel_button);
        this.mTranscribeProgressCancelBtn = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this.mTranscribeCancelListener);
        if (!AiViewUtils.isAtLeastOneUI7()) {
            this.mProgressImpl = new BaseProgress(view);
        } else if (AiViewUtils.isAtLeastOneUI85()) {
            this.mProgressImpl = new ProgressOneUI85(view);
        } else {
            this.mProgressImpl = new ProgressOneUI7(view);
        }
    }

    public boolean isShowingProgress() {
        return this.mBlockingView.getVisibility() == 0;
    }

    public void showProgress(int i) {
        AbstractC8014b.m7217s(i, "showProgress# ", TAG);
        this.mProgressImpl.showProgress(i);
    }

    public void stopEffect() {
        Logger.m11003i(TAG, "stopEffect#");
        TransitionLightEffect transitionLightEffect = this.mProgressImpl.mTransitionEffect;
        if (transitionLightEffect == null || Build.VERSION.SDK_INT < 33) {
            return;
        }
        transitionLightEffect.stop();
    }

    public void updateBGEffect() {
        BaseProgress baseProgress = this.mProgressImpl;
        if (baseProgress != null) {
            baseProgress.updateBGEffect();
        }
    }

    public void updatePercentProgress(int i) {
        AiMenuResultProgress aiMenuResultProgress = this.mTextProgress;
        if (aiMenuResultProgress != null) {
            aiMenuResultProgress.updatePercentProgress(i);
        }
    }
}
