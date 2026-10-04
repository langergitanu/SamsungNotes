package com.samsung.android.sdk.pen.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SpenOcrRecognizer implements SpenIOcrRecognizer {
    private static final String TAG = "SpenOcrRecognizer";
    private long mNativeHandle;

    public SpenOcrRecognizer(long j) {
        this.mNativeHandle = j;
        Log.i(TAG, "SpenOcrRecognizer is created! [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        AbstractC11014a.m12338w(new StringBuilder("Native Version : "), getVersion(), TAG);
    }

    private native void Native_cancelRequest(long j);

    private native int Native_detect(long j, Bitmap bitmap);

    private native int Native_detect(long j, Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener);

    private native void Native_finalize(long j);

    private native String Native_getVersion(long j);

    private native int Native_recognize(long j, Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrLineData spenOcrLineData);

    private native int Native_recognize(long j, Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener);

    private native int Native_recognize_block_at(long j, Bitmap bitmap, int i, int i2, boolean z, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener);

    private native void Native_setConfiguration(long j, String[] strArr, String[] strArr2);

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public void cancelRequest() {
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_cancelRequest(j);
        }
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public SpenOcrError detect(Bitmap bitmap) {
        Log.i(TAG, "Start detect(Bitmap) of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        if (this.mNativeHandle == 0) {
            return SpenOcrError.OE_RecogError;
        }
        SpenOcrError spenOcrError = SpenOcrError.values()[Native_detect(this.mNativeHandle, bitmap)];
        Log.i(TAG, "End of detect(Bitmap) of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        return spenOcrError;
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public String getVersion() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return Native_getVersion(j);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public SpenOcrError recognize(Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener) {
        Log.i(TAG, "Start recognize() of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        if (this.mNativeHandle == 0) {
            return SpenOcrError.OE_RecogError;
        }
        SpenOcrError spenOcrError = SpenOcrError.values()[Native_recognize(this.mNativeHandle, bitmap, spenRecogConfig, spenOcrRecognitionListener)];
        Log.i(TAG, "End of SpenOcrRecognizer::recognize() of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        return spenOcrError;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public SpenOcrError recognizeBlockAt(Bitmap bitmap, Point point, boolean z, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener) {
        Log.i(TAG, "Start recognizeBlockAt(" + point.x + "," + point.y + ") of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        if (this.mNativeHandle == 0) {
            return SpenOcrError.OE_RecogError;
        }
        SpenOcrError spenOcrError = SpenOcrError.values()[Native_recognize_block_at(this.mNativeHandle, bitmap, point.x, point.y, z, spenRecogConfig, spenOcrRecognitionListener)];
        Log.i(TAG, "End of SpenOcrRecognizer::recognizeBlockAt() of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        return spenOcrError;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public SpenOcrError recognize_line(Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrLineData spenOcrLineData) {
        Log.i(TAG, "Start recognize_line() of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        if (this.mNativeHandle == 0) {
            return SpenOcrError.OE_RecogError;
        }
        SpenOcrError spenOcrError = SpenOcrError.values()[Native_recognize(this.mNativeHandle, bitmap, spenRecogConfig, spenOcrLineData)];
        Log.i(TAG, "End of recognize_line() of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        return spenOcrError;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public void setConfiguration(String str, String str2) {
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_setConfiguration(j, new String[]{str}, new String[]{str2});
        }
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public void setConfiguration(String[] strArr, String[] strArr2) {
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_setConfiguration(j, strArr, strArr2);
        }
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer
    public SpenOcrError detect(Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener) {
        Log.i(TAG, "Start detect() of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
        if (this.mNativeHandle != 0) {
            SpenOcrError spenOcrError = SpenOcrError.values()[Native_detect(this.mNativeHandle, bitmap, spenRecogConfig, spenOcrRecognitionListener)];
            Log.i(TAG, "End of detect() of SpenOcrRecognizer [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
            return spenOcrError;
        }
        return SpenOcrError.OE_RecogError;
    }
}
