package com.samsung.android.sdk.scs.p142ai.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BoundaryDetector {
    private static final String TAG = "ScsApi@BoundaryDetector";
    private ImageServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public BoundaryDetector(@NonNull Context context) {
        Log.m6485d(TAG, "BoundaryDetector");
        this.mServiceExecutor = new ImageServiceExecutor(context);
    }

    public void close() {
        ImageServiceExecutor imageServiceExecutor = this.mServiceExecutor;
        if (imageServiceExecutor != null) {
            imageServiceExecutor.deInit();
        }
    }

    public Task<List<Boundary>> detect(@NonNull Uri uri) {
        Log.m6485d(TAG, "detect - Uri : " + uri.toString());
        DetectRunnable detectRunnable = new DetectRunnable(this.mServiceExecutor);
        detectRunnable.setUri(uri);
        this.mServiceExecutor.execute(detectRunnable);
        return detectRunnable.getTask();
    }

    public Task<Boundary> detectLargest(@NonNull Uri uri) {
        Log.m6485d(TAG, "detectLargest - Uri : " + uri.toString());
        DetectLargestRunnable detectLargestRunnable = new DetectLargestRunnable(this.mServiceExecutor);
        detectLargestRunnable.setUri(uri);
        this.mServiceExecutor.execute(detectLargestRunnable);
        return detectLargestRunnable.getTask();
    }

    public Task<List<Boundary>> detect(@NonNull Bitmap bitmap) {
        Log.m6485d(TAG, "detect(bitmap)");
        DetectRunnable detectRunnable = new DetectRunnable(this.mServiceExecutor);
        detectRunnable.setBitmap(bitmap);
        this.mServiceExecutor.execute(detectRunnable);
        return detectRunnable.getTask();
    }

    public Task<Boundary> detectLargest(@NonNull Bitmap bitmap) {
        Log.m6485d(TAG, "detectLargest(bitmap)");
        DetectLargestRunnable detectLargestRunnable = new DetectLargestRunnable(this.mServiceExecutor);
        detectLargestRunnable.setBitmap(bitmap);
        this.mServiceExecutor.execute(detectLargestRunnable);
        return detectLargestRunnable.getTask();
    }
}
