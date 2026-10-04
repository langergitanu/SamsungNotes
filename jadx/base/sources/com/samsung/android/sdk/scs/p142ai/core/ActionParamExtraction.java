package com.samsung.android.sdk.scs.p142ai.core;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ActionParamExtraction {
    private static final String TAG = "ActionParamExtraction";
    private final ExtensionServiceExecutor mServiceExecutor;

    public ActionParamExtraction(@NonNull Context context) {
        this.mServiceExecutor = new ExtensionServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$0(Task task) {
        this.mServiceExecutor.deInit();
    }

    public Task<ActionParamExtractionResult> inference(String str, Bundle bundle) {
        Log.m6485d(TAG, "generate()");
        ActionParamExtractionInferenceRunnable actionParamExtractionInferenceRunnable = new ActionParamExtractionInferenceRunnable(this.mServiceExecutor);
        actionParamExtractionInferenceRunnable.setFeature("FEATURE_ACTION_PARAM_EXTRACTION");
        actionParamExtractionInferenceRunnable.setInputArg(str);
        actionParamExtractionInferenceRunnable.setInputData(bundle);
        this.mServiceExecutor.execute(actionParamExtractionInferenceRunnable);
        return actionParamExtractionInferenceRunnable.getTask();
    }

    public Task<Boolean> prepare() {
        Log.m6485d(TAG, "prepare()");
        ActionParamExtractionPrepareRunnable actionParamExtractionPrepareRunnable = new ActionParamExtractionPrepareRunnable(this.mServiceExecutor);
        this.mServiceExecutor.execute(actionParamExtractionPrepareRunnable);
        return actionParamExtractionPrepareRunnable.getTask();
    }

    public Task<Boolean> release() {
        Log.m6485d(TAG, "release()");
        ActionParamExtractionReleaseRunnable actionParamExtractionReleaseRunnable = new ActionParamExtractionReleaseRunnable(this.mServiceExecutor);
        this.mServiceExecutor.execute(actionParamExtractionReleaseRunnable);
        actionParamExtractionReleaseRunnable.getTask().addOnCompleteListener(new C0061b(this, 24));
        return actionParamExtractionReleaseRunnable.getTask();
    }
}
