package com.samsung.android.sdk.scs.p142ai.core;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.core.p139ai.sdkcommon.AdapterInfo;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.core.p139ai.sdkcommon.ModelInfo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class GenericInference {
    private static final String TAG = "GenericInference";
    private AdapterInfo mAdapterInfo;
    private ModelInfo mModelInfo;
    private final ExtensionServiceExecutor mServiceExecutor;

    public GenericInference(@NonNull Context context) {
        this.mServiceExecutor = new ExtensionServiceExecutor(context);
    }

    private AdapterInfo getAdapterInfo() {
        return this.mAdapterInfo;
    }

    private ModelInfo getModelInfo() {
        return this.mModelInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$0(Task task) {
        this.mServiceExecutor.deInit();
    }

    private boolean setDefaultInputData(Bundle bundle) {
        if (getModelInfo() == null || getAdapterInfo() == null) {
            return false;
        }
        bundle.putParcelable(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_MODEL_INFO, getModelInfo());
        bundle.putParcelable(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_ADAPTER_INFO, getAdapterInfo());
        return true;
    }

    public Task<GenericInferenceResult> inference(Bundle bundle) {
        Log.m6485d(TAG, "inference()");
        GenericInferenceInferenceRunnable genericInferenceInferenceRunnable = new GenericInferenceInferenceRunnable(this.mServiceExecutor);
        if (!setDefaultInputData(bundle)) {
            Log.m6490w(TAG, "The required info was not provided");
            return null;
        }
        genericInferenceInferenceRunnable.setFeature("FEATURE_GENERIC_INFERENCE");
        genericInferenceInferenceRunnable.setInputData(bundle);
        this.mServiceExecutor.execute(genericInferenceInferenceRunnable);
        return genericInferenceInferenceRunnable.getTask();
    }

    public Task<Boolean> prepare() {
        Log.m6485d(TAG, "prepare()");
        GenericInferencePrepareRunnable genericInferencePrepareRunnable = new GenericInferencePrepareRunnable(this.mServiceExecutor);
        this.mServiceExecutor.execute(genericInferencePrepareRunnable);
        return genericInferencePrepareRunnable.getTask();
    }

    public Task<Boolean> release() {
        Log.m6485d(TAG, "release()");
        GenericInferenceReleaseRunnable genericInferenceReleaseRunnable = new GenericInferenceReleaseRunnable(this.mServiceExecutor);
        this.mServiceExecutor.execute(genericInferenceReleaseRunnable);
        genericInferenceReleaseRunnable.getTask().addOnCompleteListener(new C0061b(this, 25));
        return genericInferenceReleaseRunnable.getTask();
    }

    public void setAdapterInfo(AdapterInfo adapterInfo) {
        this.mAdapterInfo = adapterInfo;
    }

    public void setModelInfo(ModelInfo modelInfo) {
        this.mModelInfo = modelInfo;
    }
}
