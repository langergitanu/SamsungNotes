package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.handwriting;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LaserPenInfo {
    private float blurSize;
    private int color;
    private int colorOption = 0;
    private boolean fillInside;
    private int insideRatio;
    private int strokeSize;
    private int type;

    public LaserPenInfo(int i, float f, boolean z, int i2, int i4) {
        this.type = i;
        this.blurSize = f;
        this.fillInside = z;
        this.strokeSize = i2;
        this.insideRatio = i4;
    }

    public float getBlurSize() {
        return this.blurSize;
    }

    public int getColor() {
        return this.color;
    }

    public int getColorOption() {
        return this.colorOption;
    }

    public int getInsideRatio() {
        return this.insideRatio;
    }

    public int getStrokeSize() {
        return this.strokeSize;
    }

    public int getType() {
        return this.type;
    }

    public boolean isFillInside() {
        return this.fillInside;
    }

    public void setBlurSize(float f) {
        this.blurSize = f;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setColorOption(int i) {
        this.colorOption = i;
    }

    public void setFillInside(boolean z) {
        this.fillInside = z;
    }

    public void setStrokeSize(int i) {
        this.strokeSize = i;
    }
}
