package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class AnimationViewManager {
    private static final int ADD_PAGE_STATE_END = 0;
    private static final int ADD_PAGE_STATE_FULL = 4;
    private static final int ADD_PAGE_STATE_HIDE = 3;
    private static final int ADD_PAGE_STATE_MOVE = 2;
    private static final int ADD_PAGE_STATE_START = 1;
    private static final int LOTTIE_ANIMATION_START_FRAME = 60;
    private static final String TAG = Logger.createTag("AnimationViewManager");
    private static final boolean TEMP_DEBUG = true;
    private ILayoutHelper mAdaptiveLayoutHelper;
    private LottieAnimationView mAnimationView;
    private AnimatorListenerAdapter mAnimationViewAnimatorListener;
    private ViewGroup mContainer;
    private ValueAnimator mHideAnimator;
    private TextView mInfoTextView;
    private View mParent;
    private ValueAnimator mShowAnimator;
    private Runnable mTextUpdateRunnable;
    private float mTopMargin;
    private int mState = 0;
    private boolean mIsRTL = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Horizontal implements ILayoutHelper {
        public Horizontal() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public float getX(float f) {
            return f;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public float getY(float f) {
            return f - (AnimationViewManager.this.mContainer.getHeight() / 2.0f);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public void updateLayout() {
            AnimationViewManager.this.mInfoTextView.getLayoutParams().width = AnimationViewManager.this.mContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_add_page_text_with);
            AnimationViewManager.this.mInfoTextView.requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HorizontalRTL extends Horizontal {
        public HorizontalRTL() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.Horizontal, com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public float getX(float f) {
            return -((AnimationViewManager.this.mParent.getWidth() - AnimationViewManager.this.mContainer.getWidth()) - f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ILayoutHelper {
        float getX(float f);

        float getY(float f);

        void updateLayout();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Vertical implements ILayoutHelper {
        public Vertical() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public float getX(float f) {
            return f - (AnimationViewManager.this.mContainer.getWidth() / 2.0f);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public float getY(float f) {
            return f + AnimationViewManager.this.mTopMargin;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public void updateLayout() {
            AnimationViewManager.this.mInfoTextView.getLayoutParams().width = AnimationViewManager.this.mParent.getWidth() - (AnimationViewManager.this.mParent.getResources().getDimensionPixelSize(C9086R.dimen.comp_add_page_text_side_padding) * 2);
            AnimationViewManager.this.mInfoTextView.requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class VerticalRTL extends Vertical {
        public VerticalRTL() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.Vertical, com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.ILayoutHelper
        public float getX(float f) {
            return -super.getX(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeText(boolean z) {
        this.mInfoTextView.setText(z ? C9086R.string.composer_opt_release_to_add_page : C9086R.string.composer_opt_drag_for_new_page);
        if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mInfoTextView.getContext())) {
            if (z) {
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(this.mInfoTextView.getResources().getString(C9086R.string.composer_opt_release_to_add_page_tts));
            } else {
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(this.mInfoTextView.getResources().getString(C9086R.string.composer_opt_drag_for_new_page_tts));
            }
        }
    }

    private ILayoutHelper createAdaptiveLayoutHelper(boolean z, boolean z2) {
        return z ? z2 ? new VerticalRTL() : new Vertical() : z2 ? new HorizontalRTL() : new Horizontal();
    }

    private ValueAnimator.AnimatorUpdateListener getContainerAlphaUpdateListener() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationViewManager.this.mContainer.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        };
    }

    private void log(String str) {
        Logger.m10999d(TAG, str);
    }

    private void onEnd() {
        log("onEnd#");
        if (this.mState == 0) {
            return;
        }
        setEndState();
        log("onEnd# end");
    }

    private void onStart() {
        setAddPageState(1);
        this.mContainer.setVisibility(0);
        setFrame(0);
        setMinFrame(0);
        changeText(false);
        startShowAnimation();
    }

    private void removeTextUpdateCallback() {
        Runnable runnable = this.mTextUpdateRunnable;
        if (runnable != null) {
            this.mAnimationView.removeCallbacks(runnable);
        }
    }

    private void setAddPageState(int i) {
        if (this.mState == i) {
            return;
        }
        AbstractC0000a.m3D(i, "setAddPageState# ", TAG);
        this.mState = i;
    }

    private void setEndState() {
        ValueAnimator valueAnimator = this.mHideAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mShowAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.mContainer.setAlpha(0.0f);
        if (this.mAnimationView.isAnimating()) {
            this.mAnimationView.cancelAnimation();
        }
        setFrame(0);
        setMinFrame(0);
        this.mContainer.setVisibility(8);
        setAddPageState(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrame(int i) {
        this.mAnimationView.setFrame(i);
    }

    private void setMinFrame(int i) {
        this.mAnimationView.setMinFrame(i);
    }

    private void startHideAnimation() {
        log("startHideAnimation#");
        if (this.mState == 3) {
            return;
        }
        ValueAnimator valueAnimator = this.mShowAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mShowAnimator.cancel();
        }
        if (this.mState != 0) {
            setAddPageState(3);
        }
        if (this.mAnimationView.getFrame() < 60) {
            setFrame(0);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mContainer.getAlpha(), 0.0f);
        this.mHideAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.mHideAnimator.addUpdateListener(getContainerAlphaUpdateListener());
        this.mHideAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AnimationViewManager.this.mAnimationView.getFrame() == AnimationViewManager.this.mAnimationView.getMaxFrame()) {
                    AnimationViewManager.this.setFrame(0);
                }
            }
        });
        this.mHideAnimator.start();
        log("startHideAnimation# end");
    }

    private void startShowAnimation() {
        log("startShowAnimation#");
        ValueAnimator valueAnimator = this.mHideAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        removeTextUpdateCallback();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mContainer.getAlpha(), 1.0f);
        this.mShowAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.mShowAnimator.addUpdateListener(getContainerAlphaUpdateListener());
        this.mShowAnimator.start();
        log("startShowAnimation# end");
    }

    private void updateMoveState(float f) {
        ValueAnimator valueAnimator;
        if (f <= 0.0f) {
            startHideAnimation();
            return;
        }
        if (f < 1.0f) {
            if (this.mState == 4) {
                return;
            }
            ValueAnimator valueAnimator2 = this.mHideAnimator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.mHideAnimator.cancel();
                startShowAnimation();
            } else if (this.mContainer.getAlpha() < 1.0f && (valueAnimator = this.mShowAnimator) != null && !valueAnimator.isRunning()) {
                startShowAnimation();
            }
            setAddPageState(2);
            setFrame((int) (f * 60.0f));
            return;
        }
        if (this.mState == 4) {
            return;
        }
        ViewCompat.getInstance().performHapticFeedback(this.mAnimationView, 108);
        setAddPageState(4);
        setFrame(60);
        setMinFrame(60);
        this.mAnimationView.playAnimation();
        if (this.mAnimationViewAnimatorListener == null) {
            AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    AnimationViewManager.this.mAnimationView.setMinFrame(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AnimationViewManager.this.mAnimationView.setMinFrame(0);
                }
            };
            this.mAnimationViewAnimatorListener = animatorListenerAdapter;
            this.mAnimationView.addAnimatorListener(animatorListenerAdapter);
        }
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.AnimationViewManager.2
            @Override // java.lang.Runnable
            public void run() {
                AnimationViewManager.this.changeText(true);
                AnimationViewManager.this.mTextUpdateRunnable = null;
            }
        };
        this.mTextUpdateRunnable = runnable;
        this.mAnimationView.postDelayed(runnable, 100L);
    }

    private void updatePosition(float f, float f4) {
        this.mContainer.setTranslationX(this.mAdaptiveLayoutHelper.getX(f));
        this.mContainer.setTranslationY(this.mAdaptiveLayoutHelper.getY(f4));
    }

    public void init(ViewGroup viewGroup) {
        this.mParent = viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(C9086R.id.comp_add_page_animation_container);
        this.mContainer = viewGroup2;
        this.mInfoTextView = (TextView) viewGroup2.findViewById(C9086R.id.comp_add_page_text);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mContainer.findViewById(C9086R.id.comp_add_page_animation_view);
        this.mAnimationView = lottieAnimationView;
        lottieAnimationView.setAnimation("add_page.json");
        this.mTopMargin = ResourceUtils.convertDpToPixel(viewGroup.getContext(), 70.0f);
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        this.mIsRTL = zIsRTLMode;
        this.mAdaptiveLayoutHelper = createAdaptiveLayoutHelper(true, zIsRTLMode);
    }

    public void onChanged(float f, float f4, float f5, boolean z) {
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("onChanged# ", f, "| ", f4, "/");
        sbM1176v.append(f5);
        sbM1176v.append(" curstate: ");
        AbstractC8014b.m7221w(sbM1176v, str, this.mState);
        updatePosition(f4, f5);
        if (z) {
            onEnd();
        } else if (this.mState == 0) {
            onStart();
        } else {
            updateMoveState(f);
        }
    }

    public void release() {
        ValueAnimator valueAnimator = this.mShowAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mHideAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.mContainer.setVisibility(8);
        this.mContainer.setAlpha(0.0f);
        removeTextUpdateCallback();
    }

    public void setDirection(boolean z) {
        ILayoutHelper iLayoutHelperCreateAdaptiveLayoutHelper = createAdaptiveLayoutHelper(z, this.mIsRTL);
        this.mAdaptiveLayoutHelper = iLayoutHelperCreateAdaptiveLayoutHelper;
        iLayoutHelperCreateAdaptiveLayoutHelper.updateLayout();
        this.mAnimationView.setRotation(z ? 90.0f : 0.0f);
    }
}
