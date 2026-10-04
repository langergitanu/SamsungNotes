package com.samsung.android.ocr;

import android.graphics.Bitmap;
import com.samsung.android.ocr.MOCRConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MOCRImage {
    private static final int MAX_AREA = 16777216;
    private static final int MAX_HEIGHT = 16384;
    private static final int MAX_WIDTH = 16384;
    private static final String TAG = "MOCRImage";
    private byte[] mByteArr;
    private int mHeight;
    private int mImageFormat;
    private float mScale = 1.0f;
    private int mWidth;

    private MOCRImage(Bitmap bitmap) throws Exception {
        if (bitmap == null || bitmap.isRecycled()) {
            MOCRLog.m5684e(TAG, "Error reading bitmap.");
            throw new Exception("Error reading bitmap. Null or recycled already.");
        }
        this.mHeight = bitmap.getHeight();
        this.mWidth = bitmap.getWidth();
        this.mImageFormat = MOCRConstants.MOCRPxlFmt.RGBA8888.getValue();
        Bitmap bitmapResizeBmp = resizeBmp(bitmap);
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmapResizeBmp.getRowBytes() * this.mHeight);
            if (!bitmap.isRecycled()) {
                bitmapResizeBmp.copyPixelsToBuffer(byteBufferAllocate);
            }
            this.mByteArr = byteBufferAllocate.array();
        } catch (Error e) {
            e = e;
            MOCRLog.m5684e(TAG, "Error reading bitmap. Could be recycled already.");
            throw new Exception("Error reading bitmap. Could be recycled already.", e);
        } catch (Exception e2) {
            e = e2;
            MOCRLog.m5684e(TAG, "Error reading bitmap. Could be recycled already.");
            throw new Exception("Error reading bitmap. Could be recycled already.", e);
        }
    }

    public static MOCRImage fromBitmap(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            MOCRLog.m5684e(TAG, "Skipping recycled bitmap");
            return null;
        }
        if (bitmap.getConfig() == Bitmap.Config.RGBA_F16 || bitmap.getConfig() == Bitmap.Config.RGB_565) {
            try {
                return new MOCRImage(bitmap.copy(Bitmap.Config.ARGB_8888, false));
            } catch (Exception unused) {
                return null;
            }
        }
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            try {
                return new MOCRImage(bitmap);
            } catch (Exception unused2) {
                return null;
            }
        }
        MOCRLog.m5684e(TAG, "Bitmap format not supported " + bitmap.getConfig().toString());
        return null;
    }

    public static MOCRImage fromByteArray(byte[] bArr, int i, int i2, int i4) {
        return new MOCRImage(bArr, i, i2, i4);
    }

    private Bitmap resizeBmp(Bitmap bitmap) {
        boolean z;
        if (this.mHeight * this.mWidth > 16777216) {
            this.mScale = (float) Math.sqrt((r1 * r0) / 1.6777216E7f);
            String str = TAG;
            MOCRLog.m5685i(str, "Area Scale : " + this.mScale);
            float f = (float) this.mHeight;
            float f4 = this.mScale;
            this.mHeight = (int) (f / f4);
            this.mWidth = (int) (this.mWidth / f4);
            MOCRLog.m5685i(str, "Updated ht / wd max area : " + this.mHeight + Constant.WHITE_SPACE_FOR_LINK_ICON + this.mWidth);
            z = true;
        } else {
            z = false;
        }
        int i = this.mWidth;
        if (i > 16384) {
            float f5 = i / 16384.0f;
            this.mHeight = (int) (this.mHeight / f5);
            this.mWidth = 16384;
            this.mScale *= f5;
            MOCRLog.m5685i(TAG, "Updated ht / wd max wd : " + this.mHeight + Constant.WHITE_SPACE_FOR_LINK_ICON + this.mWidth);
            z = true;
        }
        int i2 = this.mHeight;
        if (i2 > 16384) {
            float f6 = i2 / 16384.0f;
            this.mWidth = (int) (this.mWidth / f6);
            this.mHeight = 16384;
            this.mScale *= f6;
            MOCRLog.m5685i(TAG, "Updated ht / wd max ht : " + this.mHeight + Constant.WHITE_SPACE_FOR_LINK_ICON + this.mWidth);
            z = true;
        }
        return z ? Bitmap.createScaledBitmap(bitmap, this.mWidth, this.mHeight, true) : bitmap;
    }

    public byte[] getByte() {
        return this.mByteArr;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getImageFormat() {
        return this.mImageFormat;
    }

    public float getScale() {
        return this.mScale;
    }

    public int getWidth() {
        return this.mWidth;
    }

    private MOCRImage(byte[] bArr, int i, int i2, int i4) {
        this.mByteArr = bArr;
        this.mHeight = i;
        this.mWidth = i2;
        this.mImageFormat = i4;
    }
}
