package com.samsung.android.sdk.scs.p142ai.core;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IntentQueryReleaseRunnable extends TaskRunnable<Boolean> {
    private static final String TAG = "IntentQueryReleaseRunnable";
    private final ExtensionServiceExecutor mServiceExecutor;

    public IntentQueryReleaseRunnable(@NonNull ExtensionServiceExecutor extensionServiceExecutor) {
        this.mServiceExecutor = extensionServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6489i(TAG, "release runnable execute");
        try {
            this.mServiceExecutor.getExtensionService().release(1000);
            this.mSource.setResult((TResult) Boolean.TRUE);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "Exception : " + e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_INTENT_QUERY";
    }
}
