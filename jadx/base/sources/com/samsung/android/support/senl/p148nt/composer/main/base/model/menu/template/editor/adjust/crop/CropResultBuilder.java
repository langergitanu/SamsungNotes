package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CropResultBuilder {
    private float mCenterX;
    private float mCenterY;
    private RectF mCropRect;
    private int mDrawableH;
    private int mDrawableW;
    private RectF mImageRect;
    private Matrix mMatrix;

    private Bitmap createBitmap(Drawable drawable) {
        Size resultBitmapSize = getResultBitmapSize();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(resultBitmapSize.getWidth(), resultBitmapSize.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.concat(this.mMatrix);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private float getDeltaScale() {
        float[] fArr = new float[9];
        this.mMatrix.getValues(fArr);
        return Math.abs(1.0f / fArr[0]);
    }

    private Size getResultBitmapSize() {
        return new Size(Math.min(this.mDrawableW, Math.round(this.mCropRect.width())), Math.min(this.mDrawableH, Math.round(this.mCropRect.height())));
    }

    private void postScale() {
        float deltaScale = getDeltaScale();
        this.mMatrix.postScale(deltaScale, deltaScale, this.mCenterX, this.mCenterY);
        Matrix matrix = new Matrix();
        matrix.postScale(deltaScale, deltaScale, this.mCenterX, this.mCenterY);
        matrix.mapRect(this.mImageRect);
        matrix.mapRect(this.mCropRect);
    }

    private void postTranslate() {
        Matrix matrix = this.mMatrix;
        RectF rectF = this.mImageRect;
        matrix.postTranslate(-rectF.left, -rectF.top);
        Matrix matrix2 = new Matrix();
        RectF rectF2 = this.mImageRect;
        matrix2.setTranslate(-rectF2.left, -rectF2.top);
        matrix2.mapRect(this.mImageRect);
        matrix2.mapRect(this.mCropRect);
        Matrix matrix3 = this.mMatrix;
        RectF rectF3 = this.mCropRect;
        matrix3.postTranslate(-rectF3.left, -rectF3.top);
    }

    public Bitmap build(Drawable drawable) {
        this.mDrawableW = drawable.getIntrinsicWidth();
        this.mDrawableH = drawable.getIntrinsicHeight();
        postScale();
        postTranslate();
        return createBitmap(drawable);
    }

    public CropResultBuilder setCenter(float f, float f4) {
        this.mCenterX = f;
        this.mCenterY = f4;
        return this;
    }

    public CropResultBuilder setCropRect(RectF rectF) {
        this.mCropRect = new RectF(rectF);
        return this;
    }

    public CropResultBuilder setImageRect(RectF rectF) {
        this.mImageRect = new RectF(rectF);
        return this;
    }

    public CropResultBuilder setMatrix(Matrix matrix) {
        this.mMatrix = new Matrix(matrix);
        return this;
    }
}
