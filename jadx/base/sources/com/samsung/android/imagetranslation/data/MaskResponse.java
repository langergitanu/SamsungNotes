package com.samsung.android.imagetranslation.data;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MaskResponse {
    private int[] maskData;
    private Size maskSize;
    private int requestId;

    public int[] getMaskData() {
        return this.maskData;
    }

    public Size getMaskSize() {
        return this.maskSize;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setMaskData(int[] iArr) {
        this.maskData = iArr;
    }

    public void setMaskSize(Size size) {
        this.maskSize = size;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }
}
