package com.samsung.android.sdk.pen.ocr;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenTypeClassifier implements SpenITypeClassifier {
    private static final String TAG = "SpenTypeClassifier";
    private long mNativeHandle;

    public SpenTypeClassifier(long j) {
        this.mNativeHandle = j;
        Log.i(TAG, "SpenTypeClassifier is created! [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "]");
    }

    private native void Native_finalize(long j);

    private native boolean Native_isHandwrittenImage(long j, Bitmap bitmap);

    private native boolean Native_isPrintedImage(long j, Bitmap bitmap);

    private boolean isDebugMode() {
        try {
            return new File("/data/local/tmp/isHandwritten.test").exists();
        } catch (Exception e) {
            Log.e(TAG, "Fail to check debug file! : " + e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenITypeClassifier
    public void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenITypeClassifier
    public boolean isHandwrittenImage(Bitmap bitmap) {
        if (this.mNativeHandle == 0) {
            return false;
        }
        if (isDebugMode()) {
            return true;
        }
        return Native_isHandwrittenImage(this.mNativeHandle, bitmap);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenITypeClassifier
    public boolean isPrintedImage(Bitmap bitmap) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return Native_isPrintedImage(j, bitmap);
        }
        return false;
    }
}
