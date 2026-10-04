package com.samsung.android.sdk.scs.p142ai.visual;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.gateway.imageeditor.ImageEditorGateway;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ImageEditorPrepareRunnable extends TaskRunnable<Boolean> {
    private static final String TAG = "ImageEditorPrepareRunnable";
    private final int mMode;
    final AiServiceExecutor<? extends IInterface> mServiceExecutor;

    public ImageEditorPrepareRunnable(@NonNull AiServiceExecutor<? extends IInterface> aiServiceExecutor, int i) {
        this.mServiceExecutor = aiServiceExecutor;
        this.mMode = i;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6489i(TAG, "execute");
        try {
            new ImageEditorGateway(this.mServiceExecutor).prepare(getMode());
            this.mSource.setResult((TResult) Boolean.TRUE);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "Exception : " + e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return ImageEditorParamUtils.getFeatureName(getMode(), this.mServiceExecutor.getServiceType());
    }

    public int getMode() {
        return this.mMode;
    }
}
