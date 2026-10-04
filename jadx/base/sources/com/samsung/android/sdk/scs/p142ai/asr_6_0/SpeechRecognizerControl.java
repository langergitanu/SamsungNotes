package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.ExpiringData;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks.IdleTask;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks.SttRecognitionTask;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SpeechRecognizerControl {
    private static final Duration DEFAULT_DURATION;
    private static final String TAG = "SpeechRecognizerControl";
    private static final ExpiringData<RemoteServiceExecutor> sServiceExecutorPool;
    private final Context mContext;
    private final SpeechRecognitionListener mListener;
    private final RemoteServiceExecutor mServiceExecutor;
    private SttRecognitionTask mSttTask;

    static {
        Duration durationOfHours = ExpiringData.isDevelop ? Duration.ofHours(1L) : Duration.ofDays(1L);
        DEFAULT_DURATION = durationOfHours;
        sServiceExecutorPool = new ExpiringData.Builder("Executor", new C7718f(2)).setTimeout(durationOfHours).build();
    }

    public SpeechRecognizerControl(@NonNull Context context, @NonNull SpeechRecognitionListener speechRecognitionListener) {
        this.mContext = context;
        this.mListener = speechRecognitionListener;
        this.mServiceExecutor = sServiceExecutorPool.getOrCompute(new C7720h(context, 0));
    }

    private static Context getGlobalContext() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RemoteServiceExecutor lambda$new$1(Context context) {
        return new RemoteServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RemoteServiceExecutor lambda$static$0() {
        return new RemoteServiceExecutor(getGlobalContext());
    }

    public void cancel() {
        SttRecognitionTask sttRecognitionTask = this.mSttTask;
        if (sttRecognitionTask == null || sttRecognitionTask.isComplete()) {
            return;
        }
        this.mSttTask.cancel();
    }

    public void init() {
        if (Feature.checkFeature(this.mContext, "FEATURE_SPEECH_RECOGNITION") != 0) {
            this.mListener.onError(-1, "SpeechRecognizerService is UNAVAILABLE", new Bundle());
        } else {
            if (this.mServiceExecutor.isConnected()) {
                return;
            }
            this.mServiceExecutor.execute(new IdleTask());
        }
    }

    public void release() {
        cancel();
        SttRecognitionTask sttRecognitionTask = this.mSttTask;
        if (sttRecognitionTask != null) {
            sttRecognitionTask.release();
        }
        this.mSttTask = null;
    }

    public void start(@NonNull RecognitionConfig recognitionConfig, @NonNull InputStream inputStream) {
        init();
        SttRecognitionTask sttRecognitionTask = new SttRecognitionTask(recognitionConfig, inputStream, this.mListener);
        this.mSttTask = sttRecognitionTask;
        this.mServiceExecutor.execute(sttRecognitionTask);
    }
}
