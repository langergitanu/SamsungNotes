package com.samsung.android.spr.drawable.animation;

import android.graphics.drawable.Drawable;
import com.samsung.android.spr.drawable.document.SprDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class SprDrawableAnimation implements Runnable {
    private static final int DEFAULT_FRAME_DURATION = 16;
    public static final byte TYPE_FRAMEANIMATION = 2;
    public static final byte TYPE_NONE = 0;
    public static final byte TYPE_VALUEANIMATION = 1;
    protected final SprDocument mDocument;
    protected final Drawable mDrawable;
    protected final int mInterval;
    protected boolean mIsRunning = false;
    public final byte mType;

    public SprDrawableAnimation(byte b, Drawable drawable, SprDocument sprDocument) {
        if (drawable == null) {
            throw new RuntimeException("A drawable is not allocated.");
        }
        if (sprDocument == null) {
            throw new RuntimeException("A document is not allocated.");
        }
        this.mType = b;
        this.mDrawable = drawable;
        this.mDocument = sprDocument;
        int i = sprDocument.mAnimationInterval;
        this.mInterval = i < 16 ? 16 : i;
    }

    public int getAnimationIndex() {
        return 0;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void start() {
        if (this.mIsRunning) {
            stop();
        }
        this.mIsRunning = true;
    }

    public void stop() {
        this.mDrawable.unscheduleSelf(this);
        this.mIsRunning = false;
    }

    public void update() {
    }
}
