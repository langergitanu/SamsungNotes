package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paParam;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C2paClientGetManifestRunnable extends TaskRunnable<C2paResult> {
    private static final String TAG = "C2paClientGetManifestRunnable";
    private C2paManifestsCallback mCallback = new C2paManifestsCallback() { // from class: com.samsung.android.sdk.scs.ai.visual.c2pa.C2paClientGetManifestRunnable.1
        @Override // com.samsung.android.visual.p167ai.sdkcommon.IC2paManifestsCallback
        public void onError(String str) {
            ((TaskRunnable) C2paClientGetManifestRunnable.this).mSource.setResult(new C2paResult.Builder().setSuccess(false).setError(str).build());
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IC2paManifestsCallback
        public void onResult(String str, boolean z, boolean z2) {
            ((TaskRunnable) C2paClientGetManifestRunnable.this).mSource.setResult(new C2paResult.Builder().setSuccess(true).setTrusted(z).setCompleted(z2).setManifestResult(str).build());
        }
    };
    private String mFilePath;
    private final C2paServiceExecutor mServiceExecutor;

    public C2paClientGetManifestRunnable(@NonNull C2paServiceExecutor c2paServiceExecutor) {
        this.mServiceExecutor = c2paServiceExecutor;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6485d(TAG, "execute getManifestsAsString()");
        try {
            String fileExtension = C2paUtils.getFileExtension(this.mFilePath);
            ParcelFileDescriptor parcelFileDescriptor = C2paUtils.getParcelFileDescriptor(this.mFilePath);
            if (parcelFileDescriptor != null && fileExtension != null && this.mFilePath != null) {
                this.mServiceExecutor.getC2PAService().getManifestsAsStringWithPfd(new C2paParam.ExtractParamBuilder().setPfd(parcelFileDescriptor).setExtensionType(fileExtension).setFilePath(this.mFilePath).build(), this.mCallback);
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
        this.mFilePath = str;
    }
}
