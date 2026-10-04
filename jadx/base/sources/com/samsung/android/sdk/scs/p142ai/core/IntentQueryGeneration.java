package com.samsung.android.sdk.scs.p142ai.core;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class IntentQueryGeneration {
    private static final String TAG = "IntentQueryGenerator";
    private final ExtensionServiceExecutor mServiceExecutor;

    public IntentQueryGeneration(@NonNull Context context) {
        this.mServiceExecutor = new ExtensionServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$0(Task task) {
        this.mServiceExecutor.deInit();
    }

    public Task<IntentQueryResult> inference(String str, Bundle bundle) {
        Log.m6485d(TAG, "inference()");
        IntentQueryInferenceRunnable intentQueryInferenceRunnable = new IntentQueryInferenceRunnable(this.mServiceExecutor);
        intentQueryInferenceRunnable.setFeature("FEATURE_INTENT_QUERY");
        intentQueryInferenceRunnable.setInputArg(str);
        intentQueryInferenceRunnable.setInputData(bundle);
        this.mServiceExecutor.execute(intentQueryInferenceRunnable);
        return intentQueryInferenceRunnable.getTask();
    }

    public Task<Boolean> prepare() {
        Log.m6485d(TAG, "prepare()");
        IntentQueryPrepareRunnable intentQueryPrepareRunnable = new IntentQueryPrepareRunnable(this.mServiceExecutor);
        this.mServiceExecutor.execute(intentQueryPrepareRunnable);
        return intentQueryPrepareRunnable.getTask();
    }

    public Task<Boolean> release() {
        Log.m6485d(TAG, "release()");
        IntentQueryReleaseRunnable intentQueryReleaseRunnable = new IntentQueryReleaseRunnable(this.mServiceExecutor);
        this.mServiceExecutor.execute(intentQueryReleaseRunnable);
        intentQueryReleaseRunnable.getTask().addOnCompleteListener(new C0061b(this, 26));
        return intentQueryReleaseRunnable.getTask();
    }
}
