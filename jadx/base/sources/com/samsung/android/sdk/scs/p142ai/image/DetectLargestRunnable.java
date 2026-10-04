package com.samsung.android.sdk.scs.p142ai.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DetectLargestRunnable extends TaskRunnable<Boundary> {
    private static final String TAG = "ScsApi@DetectLargestRunnable";
    Bitmap mBitmap;
    Boundary mLargestBoundary;
    ImageServiceExecutor mServiceExecutor;
    Uri mUri;

    public DetectLargestRunnable(@NonNull ImageServiceExecutor imageServiceExecutor) {
        this.mServiceExecutor = imageServiceExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        if (this.mUri == null && this.mBitmap == null) {
            Log.m6487e(TAG, "RESULT_MISSING_MANDATORY_FIELD!!!");
            this.mSource.setException(new IllegalArgumentException("input is null"));
            return;
        }
        try {
            Bundle bundle = new Bundle();
            Uri uri = this.mUri;
            if (uri != null) {
                bundle.putParcelable("uri", uri);
            } else {
                bundle.putParcelable("bmp", this.mBitmap);
            }
            Bundle bundleDetectLargestBoundary = this.mServiceExecutor.getImageService().detectLargestBoundary(bundle);
            if (bundleDetectLargestBoundary == null) {
                Log.m6487e(TAG, "detectLargestBoundary(). retBundle is null!!");
                this.mSource.setException(new ResultException(5, "retBundle is null"));
                return;
            }
            int i = bundleDetectLargestBoundary.getInt("resultCode");
            if (i == 1) {
                Boundary rect = Boundary.create().setRect((Rect) bundleDetectLargestBoundary.getParcelable("rect"));
                this.mLargestBoundary = rect;
                this.mSource.setResult((TResult) rect);
                return;
            }
            Log.m6487e(TAG, "detectLargestBoundary(). Abnormal resultCode!!! resultCode: " + i);
            if (i == 500) {
                this.mSource.setException(new ResultException(500));
            } else {
                this.mSource.setException(new ResultException(2000, Integer.toString(i)));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_IMAGE_GET_LARGEST_BOUNDARY";
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }
}
