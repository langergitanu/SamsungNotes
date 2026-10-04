package com.samsung.android.imagetranslation.data;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MaskRequest {
    private Bitmap inputBitmap;
    private LttOcrResult lttOcrResult;

    public MaskRequest(Bitmap bitmap, LttOcrResult lttOcrResult) {
        this.inputBitmap = bitmap;
        this.lttOcrResult = lttOcrResult;
    }

    public Bitmap getInputBitmap() {
        return this.inputBitmap;
    }

    public LttOcrResult getLttOcrResult() {
        return this.lttOcrResult;
    }

    public void setInputBitmap(Bitmap bitmap) {
        this.inputBitmap = bitmap;
    }

    public void setLttOcrResult(LttOcrResult lttOcrResult) {
        this.lttOcrResult = lttOcrResult;
    }
}
