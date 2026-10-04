package androidx.core.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroupOverlay;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.view.SemBlurCompat;
import p001A.AbstractC0000a;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslGoToTopController {
    private static final float ALPHA_OPAQUE = 1.0f;
    private static final float ALPHA_OPAQUE_WITHOUT_BLUR = 0.9f;
    private static final float ALPHA_TRANSPARENT = 0.0f;
    private static final int AUTO_HIDE_REASON_CLICK = 0;
    static final int AUTO_HIDE_REASON_SHOWN_OR_UPDATE = 1;
    private static final int DRAWABLE_ALPHA_OPAQUE = 255;
    private static final int FADE_IN_DURATION_MS = 333;
    private static final int FADE_OUT_DURATION_MS = 150;
    private static final int FADE_OUT_STATE_COMPLETED = 2;
    private static final int FADE_OUT_STATE_NONE = 0;
    private static final int FADE_OUT_STATE_RUNNING = 1;
    private static final int GO_TO_TOP_HIDE = 1500;
    public static final int GTT_STATE_NONE = 0;
    public static final int GTT_STATE_PRESSED = 2;
    private static final int GTT_STATE_REQUEST_LAYOUT = -1;
    public static final int GTT_STATE_SHOWN = 1;
    private static final int MOTION_EVENT_ACTION_PEN_DOWN = 211;
    private static final int MOTION_EVENT_ACTION_PEN_MOVE = 213;
    private static final int MOTION_EVENT_ACTION_PEN_UP = 212;
    private static final String TAG = "SeslGoToTopController";
    SeslGoToTopConfig mConfig;
    private ValueAnimator mFadeInAnimator;
    private ValueAnimator mFadeOutAnimator;
    Drawable mGoToTopImage;
    SeslGoToTopImageView mGoToTopView;
    Host mHost;
    OnGoToTopClickListener mOnClickListener;
    private static final SemBlurCompat.CurveParameter LIGHT_THICK = new SemBlurCompat.CurveParameter(300, 0.4f, 15.0f, 15.0f, 235.0f, 176.7f, 253.2f);
    private static final SemBlurCompat.CurveParameter DARK_THICK = new SemBlurCompat.CurveParameter(300, 0.5f, -15.0f, 0.0f, 255.0f, 33.8f, 153.7f);
    private boolean mEnableGoToTop = false;
    private boolean mIsBlurEnabled = false;
    private int mImmersiveBottomPadding = 0;
    Rect mGoToTopRect = new Rect();
    int mGoToTopState = 0;
    private int mGoToTopLastState = 0;
    private int mFadeOutState = 0;
    private boolean mIsScrollRunning = false;
    private final Runnable mFadeInRunnable = new Runnable() { // from class: androidx.core.widget.SeslGoToTopController.1
        @Override // java.lang.Runnable
        public void run() {
            SeslGoToTopController.this.playFadeIn();
        }
    };
    private final Runnable mFadeOutRunnable = new Runnable() { // from class: androidx.core.widget.SeslGoToTopController.2
        @Override // java.lang.Runnable
        public void run() {
            SeslGoToTopController.this.playFadeOut();
        }
    };
    private final Runnable mAutoHide = new Runnable() { // from class: androidx.core.widget.SeslGoToTopController.3
        @Override // java.lang.Runnable
        public void run() {
            SeslGoToTopController.this.applyState(0);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends SeslGoToTopControllerBuilder<SeslGoToTopController, Builder> {
        @Override // androidx.core.widget.SeslGoToTopControllerBuilder
        public SeslGoToTopController build() {
            validate();
            return new SeslGoToTopController(this.host, this.config);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Host {
        boolean canScrollDown();

        boolean canScrollUp();

        @NonNull
        Context getContext();

        int getHeight();

        void getLocationInWindow(@NonNull int[] iArr);

        @NonNull
        ViewGroupOverlay getOverlay();

        int getPaddingBottom();

        int getPaddingLeft();

        int getPaddingRight();

        int getScrollY();

        int getWidth();

        void invalidateHost();

        boolean isFastScrollerEnabled();

        void playSoundEffect(int i);

        void post(@NonNull Runnable runnable);

        void postDelayed(@NonNull Runnable runnable, long j);

        void removeCallbacks(@NonNull Runnable runnable);

        void showTopEdgeEffect();

        void smoothScrollToTop();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnGoToTopClickListener {
        boolean onGoToTopClick();
    }

    public SeslGoToTopController(@NonNull Host host, @NonNull SeslGoToTopConfig seslGoToTopConfig) {
        this.mHost = host;
        this.mConfig = seslGoToTopConfig;
    }

    private boolean applyBlur(boolean z) {
        return SemBlurCompat.setBlurEffectPreset((View) this.mGoToTopView, 2, z ? LIGHT_THICK : DARK_THICK, (Integer) null, (Float) null, (Integer) 1);
    }

    private void applyLayout() {
        SeslGoToTopImageView seslGoToTopImageView = this.mGoToTopView;
        Rect rect = this.mGoToTopRect;
        seslGoToTopImageView.layout(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void cleanupOnDisable() {
        this.mHost.removeCallbacks(this.mAutoHide);
        this.mHost.removeCallbacks(this.mFadeInRunnable);
        this.mHost.removeCallbacks(this.mFadeOutRunnable);
        ValueAnimator valueAnimator = this.mFadeInAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mFadeOutAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        if (this.mGoToTopView != null) {
            if (this.mIsBlurEnabled) {
                clearBlur();
            }
            try {
                this.mHost.getOverlay().remove(this.mGoToTopView);
            } catch (Exception unused) {
            }
            this.mGoToTopView.setImageDrawable(null);
        }
        this.mGoToTopImage = null;
        this.mFadeOutState = 0;
        this.mGoToTopLastState = 0;
        this.mGoToTopState = 0;
        this.mGoToTopRect.set(0, 0, 0, 0);
        this.mGoToTopView = null;
    }

    private void clearBlur() {
        SemBlurCompat.setBlurInfoClear(this.mGoToTopView);
        this.mIsBlurEnabled = false;
    }

    private void computeTargetRect() {
        int paddingLeft = this.mHost.getPaddingLeft();
        int width = this.mHost.getWidth() - this.mHost.getPaddingRight();
        int paddingLeft2 = this.mConfig.getPaddingLeft() + paddingLeft;
        int paddingRight = width - this.mConfig.getPaddingRight();
        int size = this.mConfig.getSize() / 2;
        int i = paddingLeft2 + size;
        int i2 = paddingRight - size;
        if (i > i2) {
            i = paddingLeft + size;
            i2 = width - size;
        } else {
            paddingLeft = paddingLeft2;
            width = paddingRight;
        }
        int iM7d = AbstractC0000a.m7d(width, paddingLeft, 2, paddingLeft);
        if (iM7d >= i) {
            i = iM7d;
        }
        if (i <= i2) {
            i2 = i;
        }
        int height = this.mHost.getHeight();
        this.mGoToTopRect.set(i2 - size, ((height - this.mConfig.getSize()) - this.mConfig.getPaddingBottom()) - this.mImmersiveBottomPadding, i2 + size, (height - this.mConfig.getPaddingBottom()) - this.mImmersiveBottomPadding);
    }

    private void disableBlurEffect(boolean z) {
        clearBlur();
        setSolidBackground(z);
    }

    private boolean enableBlurEffect(boolean z) {
        if (!applyBlur(z)) {
            return false;
        }
        setBlurBackground();
        return true;
    }

    private void ensureView(boolean z) {
        if (isEnabled()) {
            return;
        }
        this.mGoToTopImage = this.mConfig.getIcon(z);
        SeslGoToTopImageView seslGoToTopImageView = new SeslGoToTopImageView(this.mHost.getContext());
        this.mGoToTopView = seslGoToTopImageView;
        seslGoToTopImageView.setWindowLocationProvider(new C0061b(this, 7));
        this.mGoToTopView.setImageDrawable(this.mGoToTopImage);
    }

    @VisibleForTesting
    public static int getAutoHideDelay() {
        return 1500;
    }

    @VisibleForTesting
    public static int getFadeInDuration() {
        return FADE_IN_DURATION_MS;
    }

    private void initAnimators() {
        final int i = 1;
        final int i2 = 0;
        if (this.mFadeInAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.mIsBlurEnabled ? 1.0f : 0.9f);
            this.mFadeInAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(333L);
            this.mFadeInAnimator.setInterpolator(this.mConfig.getFadeInInterpolator());
            this.mFadeInAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: androidx.core.widget.e

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SeslGoToTopController f1379b;

                {
                    this.f1379b = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    switch (i2) {
                        case 0:
                            this.f1379b.lambda$initAnimators$1(valueAnimator);
                            break;
                        default:
                            this.f1379b.lambda$initAnimators$2(valueAnimator);
                            break;
                    }
                }
            });
        }
        if (this.mFadeOutAnimator == null) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.mIsBlurEnabled ? 1.0f : 0.9f, 0.0f);
            this.mFadeOutAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(150L);
            this.mFadeOutAnimator.setInterpolator(this.mConfig.getFadeOutInterpolator());
            this.mFadeOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: androidx.core.widget.e

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SeslGoToTopController f1379b;

                {
                    this.f1379b = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    switch (i) {
                        case 0:
                            this.f1379b.lambda$initAnimators$1(valueAnimator);
                            break;
                        default:
                            this.f1379b.lambda$initAnimators$2(valueAnimator);
                            break;
                    }
                }
            });
            this.mFadeOutAnimator.addListener(new Animator.AnimatorListener() { // from class: androidx.core.widget.SeslGoToTopController.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SeslGoToTopController.this.mFadeOutState = 2;
                    SeslGoToTopController.this.applyState(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    SeslGoToTopController.this.mFadeOutState = 1;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
        }
    }

    private boolean isBlurEnabled() {
        return this.mIsBlurEnabled;
    }

    private boolean isEnvironmentAvailable() {
        String string;
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.mHost.getContext().getSystemService("accessibility");
        return (accessibilityManager == null || !accessibilityManager.isEnabled() || (string = Settings.Secure.getString(this.mHost.getContext().getContentResolver(), "enabled_accessibility_services")) == null || !(string.matches("(?i).*com.samsung.accessibility/com.samsung.android.app.talkback.TalkBackService.*") || string.matches("(?i).*com.samsung.android.accessibility.talkback/com.samsung.android.marvin.talkback.TalkBackService.*") || string.matches("(?i).*com.google.android.marvin.talkback.TalkBackService.*") || string.matches("(?i).*com.samsung.accessibility/com.samsung.accessibility.universalswitch.UniversalSwitchService.*"))) && this.mHost.getHeight() > this.mConfig.getOverlayFeatureHiddenHeightPx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureView$0(int[] iArr) {
        int[] iArr2 = new int[2];
        this.mHost.getLocationInWindow(iArr2);
        iArr[0] = iArr[0] + iArr2[0];
        iArr[1] = (iArr2[1] - this.mHost.getScrollY()) + iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAnimators$1(ValueAnimator valueAnimator) {
        try {
            this.mGoToTopView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAnimators$2(ValueAnimator valueAnimator) {
        try {
            this.mGoToTopView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playFadeIn() {
        ValueAnimator valueAnimator = this.mFadeInAnimator;
        if (valueAnimator == null || this.mFadeOutAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        if (this.mFadeOutAnimator.isRunning()) {
            this.mFadeOutAnimator.cancel();
        }
        if (this.mGoToTopImage.getAlpha() < 255) {
            this.mGoToTopImage.setAlpha(255);
        }
        this.mFadeInAnimator.setFloatValues(this.mGoToTopView.getAlpha(), this.mIsBlurEnabled ? 1.0f : 0.9f);
        this.mFadeInAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playFadeOut() {
        ValueAnimator valueAnimator = this.mFadeOutAnimator;
        if (valueAnimator == null || this.mFadeInAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        if (this.mFadeInAnimator.isRunning()) {
            this.mFadeOutAnimator.cancel();
        }
        this.mFadeOutAnimator.setFloatValues(this.mGoToTopView.getAlpha(), 0.0f);
        this.mFadeOutAnimator.start();
    }

    private void setBlurBackground() {
        this.mGoToTopView.setBackground(this.mConfig.getBackgroundBlur());
        this.mGoToTopView.setElevation(this.mConfig.getElevation());
        this.mGoToTopView.setClipToOutline(true);
        this.mGoToTopView.setBackgroundTintList(ColorStateList.valueOf(0));
    }

    private void setBlurEnabledInternal(boolean z, boolean z2) {
        if (z && enableBlurEffect(z2)) {
            this.mIsBlurEnabled = true;
        } else {
            disableBlurEffect(z2);
            this.mIsBlurEnabled = false;
        }
    }

    private void setSolidBackground(boolean z) {
        this.mGoToTopView.setBackground(z ? this.mConfig.getBackgroundLight() : this.mConfig.getBackgroundDark());
        this.mGoToTopView.setElevation(this.mConfig.getElevation());
        this.mGoToTopView.setBackgroundTintList(null);
        this.mGoToTopView.setAlpha(0.9f);
    }

    public void applyState(int i) {
        if (isEnabled()) {
            if (!isEnvironmentAvailable()) {
                this.mFadeOutState = 2;
                i = 0;
            }
            this.mHost.removeCallbacks(this.mAutoHide);
            if (i == 1 && !this.mHost.canScrollUp()) {
                i = 0;
            }
            if (i == -1 && this.mConfig.isSizeChanged()) {
                i = (this.mHost.canScrollUp() || this.mHost.canScrollDown()) ? this.mGoToTopLastState : 0;
            } else if (i == -1 && (this.mHost.canScrollUp() || this.mHost.canScrollDown())) {
                i = 1;
            }
            if (i != 0) {
                this.mHost.removeCallbacks(this.mFadeOutRunnable);
            }
            if (i != 1) {
                this.mHost.removeCallbacks(this.mFadeInRunnable);
            }
            if (this.mFadeOutState == 0 && i == 0 && this.mGoToTopLastState != 0) {
                this.mHost.post(this.mFadeOutRunnable);
            }
            if (i != 2) {
                this.mGoToTopView.setPressed(false);
            }
            this.mGoToTopState = i;
            if (i != 0) {
                if (i == 1 || i == 2) {
                    this.mHost.removeCallbacks(this.mFadeOutRunnable);
                    computeTargetRect();
                }
            } else if (this.mFadeOutState == 2) {
                this.mGoToTopRect.set(0, 0, 0, 0);
            }
            if (this.mFadeOutState == 2) {
                this.mFadeOutState = 0;
            }
            applyLayout();
            if (i == 1 && (this.mGoToTopLastState == 0 || this.mGoToTopView.getAlpha() == 0.0f || this.mConfig.isSizeChanged())) {
                this.mHost.post(this.mFadeInRunnable);
            }
            this.mConfig.setSizeChanged(false);
            this.mGoToTopLastState = this.mGoToTopState;
        }
    }

    public void autoHide(int i) {
        if (isAvailable()) {
            if (i == 0) {
                if (this.mHost.isFastScrollerEnabled()) {
                    return;
                }
                this.mHost.removeCallbacks(this.mAutoHide);
                this.mHost.postDelayed(this.mAutoHide, getAutoHideDelayMs());
                return;
            }
            if (i == 1) {
                this.mHost.removeCallbacks(this.mAutoHide);
                this.mHost.postDelayed(this.mAutoHide, getAutoHideDelayMs());
            }
        }
    }

    public boolean contains(int i, int i2) {
        return this.mGoToTopRect.contains(i, i2);
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!isAvailable()) {
            return false;
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (action == 7) {
            if (this.mGoToTopRect.contains(x, y2)) {
                return true;
            }
            if (this.mGoToTopState == 2) {
                this.mGoToTopState = 1;
                this.mGoToTopView.setPressed(false);
                autoHide(1);
            }
        }
        return false;
    }

    public void draw() {
        if (isEnabled()) {
            this.mGoToTopView.setTranslationY(this.mHost.getScrollY());
            if (this.mGoToTopState != 0 && !this.mHost.canScrollUp()) {
                applyState(0);
            }
            if (isAvailable()) {
                return;
            }
            this.mGoToTopView.setAlpha(0.0f);
        }
    }

    public int getAutoHideDelayMs() {
        return 1500;
    }

    public int getBottomPadding() {
        return this.mConfig.getPaddingBottom();
    }

    public int getDefaultBottomPadding() {
        if (this.mConfig.hasDefaultBottomPadding()) {
            return this.mConfig.getDefaultPaddingBottom();
        }
        return 0;
    }

    public int getState() {
        return this.mGoToTopState;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public SeslGoToTopImageView getView() {
        return this.mGoToTopView;
    }

    public void invalidate() {
        if (isAvailable() && isBlurEnabled()) {
            this.mGoToTopView.invalidate();
        }
    }

    public boolean isAvailable() {
        return isEnvironmentAvailable() && isEnabled();
    }

    public boolean isEnabled() {
        return this.mEnableGoToTop && this.mGoToTopView != null;
    }

    public final boolean isScrollRunning() {
        return this.mIsScrollRunning;
    }

    public void onSizeChanged() {
        applyState(-1);
        autoHide(1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (isAvailable()) {
            int actionMasked = motionEvent.getActionMasked();
            int x = (int) (motionEvent.getX() + 0.5f);
            int y2 = (int) (motionEvent.getY() + 0.5f);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            switch (actionMasked) {
                            }
                            return true;
                        }
                        int i = this.mGoToTopState;
                        if (i != 0) {
                            if (i == 2) {
                                this.mGoToTopState = 1;
                            }
                            this.mGoToTopView.setPressed(false);
                        }
                    }
                    if (this.mGoToTopState == 2) {
                        if (!this.mGoToTopRect.contains(x, y2)) {
                            this.mGoToTopState = 1;
                            this.mGoToTopView.setPressed(false);
                            autoHide(1);
                            return true;
                        }
                        return true;
                    }
                }
                if (this.mGoToTopState == 2) {
                    if (this.mHost.canScrollUp()) {
                        OnGoToTopClickListener onGoToTopClickListener = this.mOnClickListener;
                        if (onGoToTopClickListener == null || !onGoToTopClickListener.onGoToTopClick()) {
                            setScrollRunning(true);
                            this.mHost.smoothScrollToTop();
                        }
                        return true;
                    }
                    autoHide(0);
                    this.mHost.playSoundEffect(0);
                    return true;
                }
            } else if (this.mGoToTopState != 2 && this.mGoToTopRect.contains(x, y2)) {
                applyState(2);
                this.mGoToTopView.setPressed(true);
                return true;
            }
        }
        return false;
    }

    public void release() {
        if (this.mEnableGoToTop) {
            cleanupOnDisable();
            this.mEnableGoToTop = false;
        }
    }

    public void setBlurEnabled(boolean z, boolean z2) {
        if (Build.VERSION.SDK_INT < 35) {
            this.mIsBlurEnabled = false;
        } else {
            if (!isEnabled() || z == isBlurEnabled()) {
                return;
            }
            setBlurEnabledInternal(z, z2);
        }
    }

    public void setBottomPadding(int i) {
        if (i >= 0 && isEnabled() && i != this.mConfig.getPaddingBottom()) {
            this.mConfig.setPaddingBottom(i);
            if (this.mGoToTopState != 0 || this.mFadeOutState == 1) {
                computeTargetRect();
                applyLayout();
            }
        }
    }

    public void setElevation(float f) {
        this.mConfig.setElevation(f);
    }

    public void setEnabled(boolean z, boolean z2) {
        ensureView(z2);
        SeslGoToTopImageView seslGoToTopImageView = this.mGoToTopView;
        if (seslGoToTopImageView == null || z == this.mEnableGoToTop) {
            return;
        }
        this.mEnableGoToTop = z;
        if (!z) {
            cleanupOnDisable();
            return;
        }
        seslGoToTopImageView.setAlpha(0.0f);
        this.mHost.getOverlay().add(this.mGoToTopView);
        setBlurEnabled(true, z2);
        initAnimators();
    }

    public void setImmersiveBottomPadding(int i) {
        if (i >= 0 && isEnabled()) {
            if (((this.mHost.getHeight() - this.mConfig.getSize()) - this.mConfig.getPaddingBottom()) - i < 0) {
                this.mImmersiveBottomPadding = 0;
                AbstractC2322a.m1632v(i, "The Immersive padding value (", ") was too large to draw GoToTop.", TAG);
                return;
            }
            this.mImmersiveBottomPadding = i;
            if (this.mGoToTopState != 0 || this.mFadeOutState == 1) {
                computeTargetRect();
                applyLayout();
            }
        }
    }

    public void setOnGoToTopClickListener(@Nullable OnGoToTopClickListener onGoToTopClickListener) {
        this.mOnClickListener = onGoToTopClickListener;
    }

    public void setOverlayFeatureHiddenHeightPx(int i) {
        this.mConfig.setOverlayFeatureHiddenHeightPx(i);
    }

    public void setPaddingHorizontal(int i, int i2) {
        if (i < 0 || i2 < 0 || !isEnabled()) {
            return;
        }
        if (this.mConfig.getPaddingLeft() != i) {
            this.mConfig.setPaddingLeft(i);
        }
        if (this.mConfig.getPaddingRight() != i2) {
            this.mConfig.setPaddingRight(i2);
        }
        if (this.mGoToTopState != 0 || this.mFadeOutState == 1) {
            computeTargetRect();
            applyLayout();
        }
    }

    public final void setScrollRunning(boolean z) {
        this.mIsScrollRunning = z;
    }

    public void setSizeChanged(boolean z) {
        this.mConfig.setSizeChanged(z);
    }

    public void setState(int i) {
        if (this.mGoToTopState != i) {
            this.mGoToTopState = i;
        }
    }

    public void showIfNeeded() {
        if (this.mEnableGoToTop && this.mHost.canScrollUp() && this.mGoToTopState != 2) {
            applyState(1);
            autoHide(1);
        }
    }

    public void updateConfig(SeslGoToTopConfig seslGoToTopConfig) {
        if (seslGoToTopConfig != null) {
            this.mConfig = seslGoToTopConfig;
        }
    }

    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return this.mGoToTopImage == drawable;
    }
}
