package com.samsung.android.sdk.scs.p142ai.core;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.visual.VisualErrorCode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ActionParamExtractionInferenceRunnable extends TaskRunnable<ActionParamExtractionResult> {
    private static final String TAG = "ActionParamExtractionInferenceRunnable";
    private String mFeature;
    private String mInputArg;
    private final ExtensionServiceExecutor mServiceExecutor;
    private final Bundle mRequestBundle = new Bundle();
    private int mMode = 1000;

    public ActionParamExtractionInferenceRunnable(@NonNull ExtensionServiceExecutor extensionServiceExecutor) {
        this.mServiceExecutor = extensionServiceExecutor;
    }

    private int getMode() {
        return this.mMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void setResult(@Nullable Bundle bundle) {
        if (bundle == null) {
            Log.m6487e(TAG, "generate(). retBundle is null!!");
            AbstractC6670b.m4749j(5, "retBundle is null", this.mSource);
            return;
        }
        ActionParamExtractionResult actionParamExtractionResult = new ActionParamExtractionResult();
        int i = bundle.getInt("resultCode");
        actionParamExtractionResult.setResult(i);
        if (i == 1) {
            actionParamExtractionResult.setBundle(bundle);
            this.mSource.setResult((TResult) actionParamExtractionResult);
            return;
        }
        AbstractC6670b.m4750k(i, "generate(). Abnormal resultCode!!! resultCode: ", TAG);
        if (i == 500) {
            AbstractC6670b.m4748i(500, this.mSource);
        } else {
            AbstractC6670b.m4749j(bundle.getInt("errorCode", VisualErrorCode.NOT_SPECIFIED.getCode()), bundle.getString("errorMessage", ""), this.mSource);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6485d(TAG, "ActionParamExtractionInferenceRunnable execute()");
        if (getFeatureName() == null || getBundle() == null) {
            AbstractC6670b.m4748i(700, this.mSource);
            return;
        }
        try {
            ExtensionParamUtils.transformBitmapsInBundle(getBundle());
            ExtensionParamUtils.setBundleFeature(getBundle(), getFeature());
            ExtensionParamUtils.setBundleInputArg(getBundle(), getInputArg());
            ExtensionParamUtils.setBundleTaskId(getBundle(), getTask().getTaskId());
            setResult(this.mServiceExecutor.getExtensionService().generate(getMode(), new Bundle(getBundle())));
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    public Bundle getBundle() {
        return this.mRequestBundle;
    }

    public String getFeature() {
        return this.mFeature;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_ACTION_PARAM_EXTRACTION";
    }

    public String getInputArg() {
        return this.mInputArg;
    }

    public void setBundle(@NonNull Bundle bundle) {
        this.mRequestBundle.putAll(bundle);
    }

    public void setFeature(String str) {
        this.mFeature = str;
    }

    public void setInputArg(String str) {
        this.mInputArg = str;
    }

    public void setInputData(Bundle bundle) {
        setBundle(bundle);
    }
}
