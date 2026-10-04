package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import com.airbnb.lottie.C4306L;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    @Nullable
    private LottieComposition composition;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;
    private long lastFrameTimeNs = 0;
    private float frameRaw = 0.0f;
    private float frame = 0.0f;
    private int repeatCount = 0;
    private float minFrame = -2.1474836E9f;
    private float maxFrame = 2.1474836E9f;

    @VisibleForTesting
    protected boolean running = false;
    private boolean useCompositionFrameRate = false;

    private void checkNotifyUpdate(float f) {
        if (this.useCompositionFrameRate && this.frameRaw == f) {
            return;
        }
        notifyUpdate();
    }

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition == null) {
            return;
        }
        float f = this.frame;
        if (f < this.minFrame || f > this.maxFrame) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        postFrameCallback();
        if (this.composition == null || !isRunning()) {
            return;
        }
        if (C4306L.isTraceEnabled()) {
            C4306L.beginSection("LottieValueAnimator#doFrame");
        }
        float frameDurationNs = (this.lastFrameTimeNs != 0 ? j - r2 : 0L) / getFrameDurationNs();
        float f = this.frameRaw;
        if (isReversed()) {
            frameDurationNs = -frameDurationNs;
        }
        float f4 = f + frameDurationNs;
        boolean zContains = MiscUtils.contains(f4, getMinFrame(), getMaxFrame());
        float f5 = this.frameRaw;
        float fClamp = MiscUtils.clamp(f4, getMinFrame(), getMaxFrame());
        this.frameRaw = fClamp;
        if (this.useCompositionFrameRate) {
            fClamp = (float) Math.floor(fClamp);
        }
        this.frame = fClamp;
        this.lastFrameTimeNs = j;
        if (zContains) {
            checkNotifyUpdate(f5);
        } else if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
            if (getRepeatMode() == 2) {
                this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                reverseAnimationSpeed();
            } else {
                float maxFrame = isReversed() ? getMaxFrame() : getMinFrame();
                this.frameRaw = maxFrame;
                this.frame = maxFrame;
            }
            this.lastFrameTimeNs = j;
            checkNotifyUpdate(f5);
            notifyRepeat();
            this.repeatCount++;
        } else {
            float minFrame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
            this.frameRaw = minFrame;
            this.frame = minFrame;
            removeFrameCallback();
            checkNotifyUpdate(f5);
            notifyEnd(isReversed());
        }
        verifyFrame();
        if (C4306L.isTraceEnabled()) {
            C4306L.endSection("LottieValueAnimator#doFrame");
        }
    }

    @MainThread
    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, m705to = 1.0d)
    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame = getMaxFrame() - this.frame;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.frame - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = 0.0d, m705to = 1.0d)
    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        return f == 2.1474836E9f ? lottieComposition.getEndFrame() : f;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        return f == -2.1474836E9f ? lottieComposition.getStartFrame() : f;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    public void notifyCancel() {
        super.notifyCancel();
        notifyEnd(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        removeFrameCallback();
        notifyPause();
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.lastFrameTimeNs = 0L;
        this.repeatCount = 0;
        postFrameCallback();
    }

    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0L;
        if (isReversed() && getFrame() == getMinFrame()) {
            setFrame(getMaxFrame());
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            setFrame(getMinFrame());
        }
        notifyResume();
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean z = this.composition == null;
        this.composition = lottieComposition;
        if (z) {
            setMinAndMaxFrames(Math.max(this.minFrame, lottieComposition.getStartFrame()), Math.min(this.maxFrame, lottieComposition.getEndFrame()));
        } else {
            setMinAndMaxFrames((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
        }
        float f = this.frame;
        this.frame = 0.0f;
        this.frameRaw = 0.0f;
        setFrame((int) f);
        notifyUpdate();
    }

    public void setFrame(float f) {
        if (this.frameRaw == f) {
            return;
        }
        float fClamp = MiscUtils.clamp(f, getMinFrame(), getMaxFrame());
        this.frameRaw = fClamp;
        if (this.useCompositionFrameRate) {
            fClamp = (float) Math.floor(fClamp);
        }
        this.frame = fClamp;
        this.lastFrameTimeNs = 0L;
        notifyUpdate();
    }

    public void setMaxFrame(float f) {
        setMinAndMaxFrames(this.minFrame, f);
    }

    public void setMinAndMaxFrames(float f, float f4) {
        if (f > f4) {
            throw new IllegalArgumentException(AbstractC0541b.m770l("minFrame (", f, ") must be <= maxFrame (", f4, ")"));
        }
        LottieComposition lottieComposition = this.composition;
        float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
        LottieComposition lottieComposition2 = this.composition;
        float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
        float fClamp = MiscUtils.clamp(f, startFrame, endFrame);
        float fClamp2 = MiscUtils.clamp(f4, startFrame, endFrame);
        if (fClamp == this.minFrame && fClamp2 == this.maxFrame) {
            return;
        }
        this.minFrame = fClamp;
        this.maxFrame = fClamp2;
        setFrame((int) MiscUtils.clamp(this.frame, fClamp, fClamp2));
    }

    public void setMinFrame(int i) {
        setMinAndMaxFrames(i, (int) this.maxFrame);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.speedReversedForRepeatMode) {
            return;
        }
        this.speedReversedForRepeatMode = false;
        reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.useCompositionFrameRate = z;
    }

    @MainThread
    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }
}
