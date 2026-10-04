package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C2paClientSaveManifestsToCacheRunnable extends TaskRunnable<String> {
    private static final String TAG = "C2paClientSaveManifestsToCacheRunnable";
    private final C2paServiceExecutor mServiceExecutor;
    String mfilePath;

    public C2paClientSaveManifestsToCacheRunnable(@NonNull C2paServiceExecutor c2paServiceExecutor) {
        this.mServiceExecutor = c2paServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6485d(TAG, "execute saveManifestsToCache()");
        try {
            String fileExtension = C2paUtils.getFileExtension(this.mfilePath);
            ParcelFileDescriptor parcelFileDescriptor = C2paUtils.getParcelFileDescriptor(this.mfilePath);
            if (parcelFileDescriptor != null && fileExtension != null && this.mfilePath != null) {
                this.mSource.setResult((TResult) this.mServiceExecutor.getC2PAService().saveManifestsToCacheWithPfd(new C2paParam.SaveToCacheParamBuilder().setPfd(parcelFileDescriptor).setExtensionType(fileExtension).setFilePath(this.mfilePath).build()));
                return;
            }
            if (parcelFileDescriptor != null) {
                try {
                    if (parcelFileDescriptor.getFileDescriptor().valid()) {
                        parcelFileDescriptor.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            throw new NullPointerException("Target PFD/Extension is NULL");
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mSource.setException(e2);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_C2PA";
    }

    public void setFilePath(@NonNull String str) {
        this.mfilePath = str;
    }
}
