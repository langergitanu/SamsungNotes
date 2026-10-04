package com.samsung.android.sdk.scs.p142ai.asr.tasks;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ISpeechRecognizerService;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class RecognitionTask<T> extends TaskRunnable<T> {
    protected final String TAG;

    @Nullable
    private Consumer<Runnable> completeCallback;
    private boolean mIsCancelled;
    protected ISpeechRecognizerService mService;

    private RecognitionTask() {
        this("RecognitionTask");
    }

    private void callResultCallback() {
        Consumer<Runnable> consumer = this.completeCallback;
        if (consumer != null) {
            this.completeCallback = null;
            Log.m6489i(this.TAG, "callResultCallback");
            consumer.accept(this);
        }
    }

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
            callResultCallback();
        } catch (IllegalStateException unused) {
            Log.m6487e(this.TAG, "cannot cancel, already completed");
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void complete(T t) {
        if (isComplete()) {
            Log.m6489i(this.TAG, "already completed");
            return;
        }
        this.mSource.setResult((TResult) t);
        this.mService = null;
        callResultCallback();
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

    public void setCompleteCallback(Consumer<Runnable> consumer) {
        this.completeCallback = consumer;
    }

    public void setError(Exception exc) {
        if (isComplete()) {
            Log.m6489i(this.TAG, "already completed");
            return;
        }
        this.mSource.setException(exc);
        this.mService = null;
        callResultCallback();
    }

    public String toString() {
        return this.TAG + "{cancelled=" + isCancelled() + ", isComplete=" + isComplete() + '}';
    }

    public RecognitionTask(String str) {
        this.mIsCancelled = false;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, Log.TAG_SEPARATOR);
        sbM781w.append(hashCode());
        this.TAG = sbM781w.toString();
    }
}
