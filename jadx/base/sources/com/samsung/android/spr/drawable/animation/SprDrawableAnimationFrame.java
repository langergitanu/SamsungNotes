package com.samsung.android.spr.drawable.animation;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.samsung.android.spr.drawable.document.SprDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprDrawableAnimationFrame extends SprDrawableAnimation {
    private int mCurrentFrameIndex;
    private final int mFrameCount;
    private final int mTotalFrameCount;

    public SprDrawableAnimationFrame(Drawable drawable, SprDocument sprDocument) {
        super((byte) 2, drawable, sprDocument);
        this.mCurrentFrameIndex = 0;
        int frameAnimationCount = this.mDocument.getFrameAnimationCount();
        this.mFrameCount = frameAnimationCount;
        this.mTotalFrameCount = frameAnimationCount * this.mDocument.mRepeatCount;
    }

    @Override // com.samsung.android.spr.drawable.animation.SprDrawableAnimation
    public int getAnimationIndex() {
        if (this.mDocument.mRepeatMode == 2) {
            return this.mCurrentFrameIndex % this.mFrameCount;
        }
        int i = this.mCurrentFrameIndex;
        int i2 = this.mFrameCount;
        int i4 = i % (i2 * 2);
        return i4 < i2 ? i4 : (i2 - (i4 % i2)) - 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.mCurrentFrameIndex + 1;
        this.mCurrentFrameIndex = i;
        if (this.mDocument.mRepeatCount == 0 || i < this.mTotalFrameCount) {
            this.mDrawable.scheduleSelf(this, SystemClock.uptimeMillis() + ((long) this.mInterval));
            if (this.mDocument.mRepeatCount == 0) {
                int i2 = this.mCurrentFrameIndex;
                int i4 = this.mFrameCount;
                if (i2 > i4 * 2) {
                    this.mCurrentFrameIndex = i2 - (i4 * 2);
                }
            }
        } else {
            this.mIsRunning = false;
        }
        this.mDrawable.invalidateSelf();
    }

    @Override // com.samsung.android.spr.drawable.animation.SprDrawableAnimation
    public void start() {
        super.start();
        this.mCurrentFrameIndex = 0;
        this.mDrawable.scheduleSelf(this, SystemClock.uptimeMillis());
    }
}
