package com.samsung.android.sdk.pen.ocr;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrRecognitionListener {
    private static final String TAG = "SpenOcrRecognitionListener";
    private long mNativeHandle;

    public SpenOcrRecognitionListener() {
        this.mNativeHandle = 0L;
        this.mNativeHandle = Native_init(this);
        Log.i(TAG, "SpenOcrRecognitionListener is created! mNativeHandle : " + Long.toHexString(this.mNativeHandle));
    }

    private native void Native_finalize(long j);

    private native long Native_init(SpenOcrRecognitionListener spenOcrRecognitionListener);

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

    public void onPageRecognitionCompleted(SpenOcrPageData spenOcrPageData) {
        Log.i(TAG, "SpenOcrRecognitionListener onPageRecognitionCompleted");
    }

    public void onPageRecognitionStarted() {
        Log.i(TAG, "SpenOcrRecognitionListener onPageRecognitionStarted");
    }

    public void onTextBlockDetected(SpenOcrBlockData spenOcrBlockData) {
        Log.i(TAG, "SpenOcrRecognitionListener onTextBlockDetected");
    }

    public void onTextLineDetected(SpenOcrLineData spenOcrLineData) {
        Log.i(TAG, "SpenOcrRecognitionListener onTextLineDetected");
    }

    public void onTextLineRecognized(SpenOcrLineData spenOcrLineData) {
        Log.i(TAG, "SpenOcrRecognitionListener onTextLineRecognized");
    }
}
