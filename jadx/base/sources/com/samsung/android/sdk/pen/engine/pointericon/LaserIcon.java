package com.samsung.android.sdk.pen.engine.pointericon;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010$\u001a\u00020 2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/pointericon/LaserIcon;", "", "<init>", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "type", "", "getType", "()I", "setType", "(I)V", "color", "getColor", "setColor", "blurSize", "", "getBlurSize", "()F", "setBlurSize", "(F)V", "strokeSize", "getStrokeSize", "setStrokeSize", "insideRatio", "getInsideRatio", "setInsideRatio", "isRainbowEnabled", "", "()Z", "setRainbowEnabled", "(Z)V", "equals", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LaserIcon {
    private float blurSize;
    private int color;

    @Nullable
    private Drawable drawable;
    private float insideRatio;
    private boolean isRainbowEnabled;
    private float strokeSize;
    private int type;

    public final boolean equals(int type, int color, float blurSize, float strokeSize, float insideRatio, boolean isRainbowEnabled) {
        return this.type == type && this.color == color && this.blurSize == blurSize && this.strokeSize == strokeSize && this.insideRatio == insideRatio && this.isRainbowEnabled == isRainbowEnabled;
    }

    public final float getBlurSize() {
        return this.blurSize;
    }

    public final int getColor() {
        return this.color;
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final float getInsideRatio() {
        return this.insideRatio;
    }

    public final float getStrokeSize() {
        return this.strokeSize;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: isRainbowEnabled, reason: from getter */
    public final boolean getIsRainbowEnabled() {
        return this.isRainbowEnabled;
    }

    public final void setBlurSize(float f) {
        this.blurSize = f;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setDrawable(@Nullable Drawable drawable) {
        this.drawable = drawable;
    }

    public final void setInsideRatio(float f) {
        this.insideRatio = f;
    }

    public final void setRainbowEnabled(boolean z) {
        this.isRainbowEnabled = z;
    }

    public final void setStrokeSize(float f) {
        this.strokeSize = f;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
