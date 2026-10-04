package com.samsung.android.sdk.pen.recogengine.preload.hmeocr;

import android.content.Context;
import android.util.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\t\u0010\u0012\u001a\u00020\u0005H\u0084 J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0084 J\u0019\u0010\u0014\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrModel;", "", "<init>", "()V", "mNativeHandle", "", "finalize", "", "close", "nativeHandle", "getNativeHandle", "()J", "loadDB", "", "context", "Landroid/content/Context;", "filePath", "", "Native_init", "Native_finalize", "Native_loadDB", "dbFilePath", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeOcrModel {

    @NotNull
    private static final String TAG = "SpenHmeOcrModel";
    private long mNativeHandle;

    public SpenHmeOcrModel() {
        long jNative_init = Native_init();
        this.mNativeHandle = jNative_init;
        Log.i(TAG, "SpenHmeOcrModel mNativeHandle[" + jNative_init + "]");
    }

    private final native boolean Native_loadDB(long nativeHandle, String dbFilePath);

    public final native void Native_finalize(long nativeHandle);

    public final native long Native_init();

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

    /* JADX INFO: renamed from: getNativeHandle, reason: from getter */
    public final long getMNativeHandle() {
        return this.mNativeHandle;
    }

    public final boolean loadDB(@Nullable Context context, @Nullable String filePath) {
        if (filePath == null) {
            Log.e(TAG, "SpenHmeOcrModel::LoadDB : filePath is null!");
            return false;
        }
        boolean zNative_loadDB = Native_loadDB(this.mNativeHandle, filePath);
        Log.i(TAG, "SpenHmeOcrModel::LoadDB : succeed! DB num[" + zNative_loadDB + "]");
        return zNative_loadDB;
    }
}
