package com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks;

import android.util.Log;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IdleTask extends RecognitionTask<Boolean> {
    private static final String TAG = "IdleTask";

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.d(TAG, "connected");
        complete(Boolean.TRUE);
    }
}
