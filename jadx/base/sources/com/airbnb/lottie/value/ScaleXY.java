package com.airbnb.lottie.value;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f, float f4) {
        this.scaleX = f;
        this.scaleY = f4;
    }

    public boolean equals(float f, float f4) {
        return this.scaleX == f && this.scaleY == f4;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f, float f4) {
        this.scaleX = f;
        this.scaleY = f4;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
