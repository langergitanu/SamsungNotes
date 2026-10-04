package com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks;

import android.util.Log;
import androidx.annotation.RestrictTo;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ISpeechRecognizerService;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class RecognitionTask<T> extends TaskRunnable<T> {
    private static final String TAG = "RecognitionTask";
    private boolean mIsCancelled = false;
    protected ISpeechRecognizerService mService;

    public void active(ISpeechRecognizerService iSpeechRecognizerService) {
        this.mService = iSpeechRecognizerService;
    }

    public void cancel() {
        if (isComplete() || isCancelled()) {
            return;
        }
        this.mIsCancelled = true;
        try {
            this.mSource.setException(new InterruptedException(TelemetryEventStrings.Value.CANCELLED));
        } catch (IllegalStateException unused) {
            Log.e(TAG, "cannot cancel, already completed");
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void complete(T t) {
        if (isComplete()) {
            Log.i(TAG, "already completed");
        } else {
            this.mSource.setResult((TResult) t);
            this.mService = null;
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_SPEECH_RECOGNITION";
    }

    public boolean isCancelled() {
        return this.mIsCancelled;
    }

    public boolean isComplete() {
        return this.mSource.getTask().isComplete();
    }

    public void setError(Exception exc) {
        if (isComplete()) {
            Log.i(TAG, "already completed");
        } else {
            this.mSource.setException(exc);
            this.mService = null;
        }
    }
}
