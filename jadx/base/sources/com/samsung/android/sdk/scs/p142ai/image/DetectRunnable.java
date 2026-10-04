package com.samsung.android.sdk.scs.p142ai.image;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.scs.p140ai.sdkcommon.image.localization.BoundaryInternal;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DetectRunnable extends TaskRunnable<List<Boundary>> {
    private static final String TAG = "ScsApi@DetectLargestRunnable";
    Bitmap mBitmap;
    List<Boundary> mBoundaryList;
    ImageServiceExecutor mServiceExecutor;
    Uri mUri;

    public DetectRunnable(@NonNull ImageServiceExecutor imageServiceExecutor) {
        this.mServiceExecutor = imageServiceExecutor;
    }

    private void generateResult(@NonNull List<BoundaryInternal> list) {
        for (BoundaryInternal boundaryInternal : list) {
            if (boundaryInternal.getChildBlocks() != null) {
                generateResult(boundaryInternal.getChildBlocks());
            }
            this.mBoundaryList.add(Boundary.create().setRect(boundaryInternal.getBlockRect()).setType(BoundaryType.get(boundaryInternal.getBlockType())));
        }
    }

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
            Bundle bundleDetectBoundaries = this.mServiceExecutor.getImageService().detectBoundaries(bundle);
            if (bundleDetectBoundaries == null) {
                Log.m6487e(TAG, "detectBoundaries(). retBundle is null!!");
                this.mSource.setException(new ResultException(5, "retBundle is null"));
                return;
            }
            bundleDetectBoundaries.setClassLoader(BoundaryInternal.class.getClassLoader());
            int i = bundleDetectBoundaries.getInt("resultCode");
            if (i == 1) {
                ArrayList parcelableArrayList = bundleDetectBoundaries.getParcelableArrayList(ImageConst.KEY_BOUNDARY_LIST);
                this.mBoundaryList = new ArrayList();
                generateResult(parcelableArrayList);
                this.mSource.setResult((TResult) this.mBoundaryList);
                return;
            }
            Log.m6487e(TAG, "detectBoundaries(). Abnormal resultCode!!! resultCode: " + i);
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
        return "FEATURE_IMAGE_GET_BOUNDARIES";
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }
}
