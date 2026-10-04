package com.samsung.android.support.senl.p148nt.model.assist.lvm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Sketch2ImageMaker extends ImageMaker {
    private static final String TAG = "Sketch2ImageMaker";
    private Bitmap mContent;

    public Sketch2ImageMaker(Context context, String str) {
        super(context);
        this.mContent = BitmapFactory.decodeFile(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.SketchToImage;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.ImageMaker
    public String getTAG() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator
    public void operate() {
        if (isReleased()) {
            Logger.m8697d(TAG, "operate, ignore already released: " + hashCode());
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("style", this.mImageStyle);
            bundle.putFloat("scribble_weight", this.mScribbleWeightValue);
            this.mImpl.requestImage(getRequestType(), this.mContent, bundle);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator
    public void preProcessing() {
        if (isReleased()) {
            Logger.m8697d(TAG, "preProcessing ignore already released: " + hashCode());
            return;
        }
        if (this.mContent == null) {
            Logger.m8697d(TAG, "preProcessing, content is null: " + hashCode());
            return;
        }
        Logger.m8697d(TAG, "preProcessing start, " + hashCode());
        int width = this.mContent.getWidth();
        int height = this.mContent.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int i = width * height;
        int[] iArr = new int[i];
        this.mContent.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = iArr[i2] != 0 ? -16777216 : -1;
        }
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        this.mContent = bitmapCreateBitmap;
        Logger.m8697d(TAG, "preProcessing end");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator
    public void release() {
        super.release();
        Bitmap bitmap = this.mContent;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }
}
