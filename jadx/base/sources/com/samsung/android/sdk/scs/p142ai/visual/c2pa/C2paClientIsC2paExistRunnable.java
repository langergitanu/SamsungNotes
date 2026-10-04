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
public class C2paClientIsC2paExistRunnable extends TaskRunnable<Boolean> {
    private static final String TAG = "C2paClientIsC2paExistRunnable";
    String mFilePath;
    private final C2paServiceExecutor mServiceExecutor;

    public C2paClientIsC2paExistRunnable(@NonNull C2paServiceExecutor c2paServiceExecutor) {
        this.mServiceExecutor = c2paServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6485d(TAG, "execute isC2paExist()");
        try {
            String fileExtension = C2paUtils.getFileExtension(this.mFilePath);
            ParcelFileDescriptor parcelFileDescriptor = C2paUtils.getParcelFileDescriptor(this.mFilePath);
            if (parcelFileDescriptor != null && fileExtension != null) {
                this.mSource.setResult((TResult) Boolean.valueOf(this.mServiceExecutor.getC2PAService().isC2paInfoExistWithPfd(new C2paParam.C2paExistParamBuilder().setPfd(parcelFileDescriptor).setExtensionType(fileExtension).build())));
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

    public void setParentPath(@NonNull String str) {
        this.mFilePath = str;
    }
}
