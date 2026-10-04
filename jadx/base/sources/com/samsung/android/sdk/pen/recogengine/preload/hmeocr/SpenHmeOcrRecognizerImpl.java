package com.samsung.android.sdk.pen.recogengine.preload.hmeocr;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0004J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0005H\u0084 J\u0011\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0084 J\u0019\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0084 J!\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrRecognizerImpl;", "", "<init>", "()V", "mNativeHandle", "", "mIsModelInitialized", "", "finalize", "", "close", "setModel", "model", "Lcom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrModel;", "recognize", "bitmap", "Landroid/graphics/Bitmap;", "result", "Lcom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrResult;", "Native_init", "Native_finalize", "nativeHandle", "Native_setMode", "nativeHandleModel", "Native_recognize", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeOcrRecognizerImpl {

    @NotNull
    private static final String TAG = "SpenHmeOcrRecognizer";
    private boolean mIsModelInitialized;
    private long mNativeHandle = Native_init();

    private final native boolean Native_recognize(long nativeHandle, Bitmap bitmap, SpenHmeOcrResult result);

    public final native void Native_finalize(long nativeHandle);

    public final native long Native_init();

    public final native boolean Native_setMode(long nativeHandle, long nativeHandleModel);

    public final void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    public final void finalize() {
        close();
    }

    public final boolean recognize(@NotNull Bitmap bitmap, @NotNull SpenHmeOcrResult result) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.mIsModelInitialized) {
            Log.e(TAG, "SpenHmeOcrRecognizerImpl::recognize model not initialized!");
            return false;
        }
        long j = this.mNativeHandle;
        if (j == 0) {
            Log.e(TAG, "SpenHmeOcrRecognizerImpl::recognize mNativeHandle == 0!");
            return false;
        }
        AbstractC4539a.m3207q("SpenHmeOcrRecognizerImpl::recognizer() START mNativeHandle[", Long.toHexString(j), "]", TAG);
        boolean zNative_recognize = Native_recognize(this.mNativeHandle, bitmap, result);
        Log.i(TAG, "SpenHmeOcrRecognizerImpl::recognizer() END mNativeHandle[" + Long.toHexString(this.mNativeHandle) + "], ret[" + zNative_recognize + "]");
        return zNative_recognize;
    }

    public final void setModel(@NotNull SpenHmeOcrModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.getMNativeHandle() == 0) {
            Log.e(TAG, "SpenHmeOcrRecognizerImpl::setModel model.getNativeHandle() == 0!");
            return;
        }
        boolean zNative_setMode = Native_setMode(this.mNativeHandle, model.getMNativeHandle());
        this.mIsModelInitialized = zNative_setMode;
        if (zNative_setMode) {
            return;
        }
        Log.e(TAG, "SpenHmeOcrRecognizerImpl::setModel failed!");
    }
}
