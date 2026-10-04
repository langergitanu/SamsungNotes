package com.airbnb.lottie.utils;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.utils.OffscreenLayer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DropShadow {
    private int color;

    /* JADX INFO: renamed from: dx */
    private float f1965dx;

    /* JADX INFO: renamed from: dy */
    private float f1966dy;
    private float radius;

    @Nullable
    private float[] vecs;

    public DropShadow() {
        this.radius = 0.0f;
        this.f1965dx = 0.0f;
        this.f1966dy = 0.0f;
        this.color = 0;
    }

    public void applyTo(Paint paint) {
        if (Color.alpha(this.color) > 0) {
            paint.setShadowLayer(Math.max(this.radius, Float.MIN_VALUE), this.f1965dx, this.f1966dy, this.color);
        } else {
            paint.clearShadowLayer();
        }
    }

    public void applyWithAlpha(int i, Paint paint) {
        int iMixOpacities = Utils.mixOpacities(Color.alpha(this.color), MiscUtils.clamp(i, 0, 255));
        if (iMixOpacities <= 0) {
            paint.clearShadowLayer();
        } else {
            paint.setShadowLayer(Math.max(this.radius, Float.MIN_VALUE), this.f1965dx, this.f1966dy, Color.argb(iMixOpacities, Color.red(this.color), Color.green(this.color), Color.blue(this.color)));
        }
    }

    public int getColor() {
        return this.color;
    }

    public float getDx() {
        return this.f1965dx;
    }

    public float getDy() {
        return this.f1966dy;
    }

    public float getRadius() {
        return this.radius;
    }

    public void multiplyOpacity(int i) {
        this.color = Color.argb(Math.round((MiscUtils.clamp(i, 0, 255) * Color.alpha(this.color)) / 255.0f), Color.red(this.color), Color.green(this.color), Color.blue(this.color));
    }

    public boolean sameAs(DropShadow dropShadow) {
        return this.radius == dropShadow.radius && this.f1965dx == dropShadow.f1965dx && this.f1966dy == dropShadow.f1966dy && this.color == dropShadow.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setDx(float f) {
        this.f1965dx = f;
    }

    public void setDy(float f) {
        this.f1966dy = f;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public void transformBy(Matrix matrix) {
        if (this.vecs == null) {
            this.vecs = new float[2];
        }
        float[] fArr = this.vecs;
        fArr[0] = this.f1965dx;
        fArr[1] = this.f1966dy;
        matrix.mapVectors(fArr);
        float[] fArr2 = this.vecs;
        this.f1965dx = fArr2[0];
        this.f1966dy = fArr2[1];
        this.radius = matrix.mapRadius(this.radius);
    }

    public void applyTo(OffscreenLayer.ComposeOp composeOp) {
        if (Color.alpha(this.color) > 0) {
            composeOp.shadow = this;
        } else {
            composeOp.shadow = null;
        }
    }

    public void applyWithAlpha(int i, OffscreenLayer.ComposeOp composeOp) {
        DropShadow dropShadow = new DropShadow(this);
        composeOp.shadow = dropShadow;
        dropShadow.multiplyOpacity(i);
    }

    public DropShadow(float f, float f4, float f5, int i) {
        this.radius = f;
        this.f1965dx = f4;
        this.f1966dy = f5;
        this.color = i;
        this.vecs = null;
    }

    public DropShadow(DropShadow dropShadow) {
        this.radius = 0.0f;
        this.f1965dx = 0.0f;
        this.f1966dy = 0.0f;
        this.color = 0;
        this.radius = dropShadow.radius;
        this.f1965dx = dropShadow.f1965dx;
        this.f1966dy = dropShadow.f1966dy;
        this.color = dropShadow.color;
        this.vecs = null;
    }
}
