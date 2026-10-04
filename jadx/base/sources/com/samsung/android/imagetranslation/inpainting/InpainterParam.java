package com.samsung.android.imagetranslation.inpainting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;
import com.samsung.android.imagetranslation.data.LttOcrResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class InpainterParam {
    private Context context;
    private Bitmap inputImage;
    private int[] inputMask;
    private LttOcrResult lttOcrResult;
    private Size originalImageSize;
    private int requestId;
    private float resizeRatio = 1.0f;
    private Size resizedImageSize;

    public InpainterParam(int i, Bitmap bitmap, LttOcrResult lttOcrResult) {
        this.requestId = i;
        this.inputImage = bitmap;
        this.lttOcrResult = lttOcrResult;
    }

    public Context getContext() {
        return this.context;
    }

    public Bitmap getInputImage() {
        return this.inputImage;
    }

    public int[] getInputMask() {
        return this.inputMask;
    }

    public LttOcrResult getLttOcrResult() {
        return this.lttOcrResult;
    }

    public Size getOriginalImageSize() {
        return this.originalImageSize;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public float getResizeRatio() {
        return this.resizeRatio;
    }

    public Size getResizedImageSize() {
        return this.resizedImageSize;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setInputImage(Bitmap bitmap) {
        this.inputImage = bitmap;
    }

    public void setInputMask(int[] iArr) {
        this.inputMask = iArr;
    }

    public void setLttOcrResult(LttOcrResult lttOcrResult) {
        this.lttOcrResult = lttOcrResult;
    }

    public void setOriginalImageSize(Size size) {
        this.originalImageSize = size;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public void setResizeRatio(float f) {
        this.resizeRatio = f;
    }

    public void setResizedImageSize(Size size) {
        this.resizedImageSize = size;
    }
}
