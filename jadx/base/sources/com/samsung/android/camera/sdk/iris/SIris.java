package com.samsung.android.camera.sdk.iris;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class SIris implements SsdkInterface {
    public static final int DEVICE_SIRIS = 0;
    private static final String TAG = "SIris";
    private Context mContext;

    public SIris() {
        Log.d(TAG, "Create SIris object, SDK version = " + getVersionName());
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() {
        return 16777229;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public String getVersionName() {
        return String.format("%d.%d.%d", 1, 0, 13);
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public void initialize(Context context) throws SsdkUnsupportedException {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context may not be null!!");
        }
        if (!SsdkVendorCheck.isSamsungDevice()) {
            throw new SsdkUnsupportedException("This is not Samsung device!!!", 0);
        }
        SIrisManager sIrisManager = SIrisManager.getSIrisManager(this.mContext);
        if (sIrisManager == null || !sIrisManager.isHardwareDetected()) {
            throw new SsdkUnsupportedException("This device is not supported Siris!!!", 1);
        }
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int i) {
        SIrisManager sIrisManager = SIrisManager.getSIrisManager(this.mContext);
        if (sIrisManager != null) {
            return sIrisManager.isHardwareDetected();
        }
        return false;
    }
}
