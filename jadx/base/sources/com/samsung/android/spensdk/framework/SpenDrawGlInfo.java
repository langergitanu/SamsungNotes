package com.samsung.android.spensdk.framework;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SpenDrawGlInfo {
    public Rect mClipRect;
    public int mScreenHeight;
    public int mScreenWidth;
    public float[] mTransformMatrix = new float[16];

    public SpenDrawGlInfo(Rect rect, int i, int i2, float[] fArr) {
        this.mClipRect = rect;
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        setMatrix(fArr);
    }

    private void setClipRect(Rect rect) {
        this.mClipRect = rect;
    }

    private void setMatrix(float[] fArr) {
        if (fArr.length != this.mTransformMatrix.length) {
            return;
        }
        int i = 0;
        while (true) {
            float[] fArr2 = this.mTransformMatrix;
            if (i >= fArr2.length) {
                return;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }

    private void setSize(int i, int i2) {
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
    }
}
