package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C2paGetServiceRunnable extends TaskRunnable<IDpsC2pa> {
    private static final String TAG = "C2paGetServiceRunnable";
    private final C2paServiceExecutor mServiceExecutor;

    public C2paGetServiceRunnable(@NonNull C2paServiceExecutor c2paServiceExecutor) {
        this.mServiceExecutor = c2paServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        this.mSource.setResult((TResult) this.mServiceExecutor.getC2PAService());
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_C2PA";
    }
}
