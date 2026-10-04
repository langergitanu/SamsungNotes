package com.samsung.android.sdk.scs.p142ai.asr;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.asr.ExpiringData;
import com.samsung.android.sdk.scs.p142ai.asr.tasks.IdleTask;
import com.samsung.android.sdk.scs.p142ai.asr.tasks.SttRecognitionTask;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class SpeechRecognizerControl {
    private static final Duration DEFAULT_DURATION;
    private static final ExpiringData<RemoteServiceExecutor> sServiceExecutorPool;
    private final String TAG;
    private boolean isReleased;
    private final String mCallerPackage;
    private final Context mContext;
    private SpeechRecognitionListener mListener;
    private final RemoteServiceExecutor mServiceExecutor;
    private SttRecognitionTask mSttTask;

    static {
        Duration durationOfHours = ExpiringData.isDevelop ? Duration.ofHours(1L) : Duration.ofDays(1L);
        DEFAULT_DURATION = durationOfHours;
        sServiceExecutorPool = new ExpiringData.Builder("Executor", new C7692h(2)).setTimeout(durationOfHours).setCleanupCallback(new C7696l()).build();
    }

    public SpeechRecognizerControl(@NonNull Context context, @NonNull SpeechRecognitionListener speechRecognitionListener) {
        String str = "SpeechRecognizerControl@" + hashCode();
        this.TAG = str;
        this.isReleased = false;
        this.mContext = context;
        this.mCallerPackage = context.getPackageName();
        this.mListener = speechRecognitionListener;
        this.mServiceExecutor = sServiceExecutorPool.getOrCompute(new C7697m(context, 0));
        ASRLog.m6139i(str, "created", speechRecognitionListener);
    }

    private static Context getGlobalContext() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean initInternal() {
        if (Feature.checkFeature(this.mContext, "FEATURE_SPEECH_RECOGNITION") != 0) {
            this.mListener.onError(-1, "SpeechRecognizerService is UNAVAILABLE", new Bundle());
            return false;
        }
        if (isReleased()) {
            this.mListener.onError(15, "SpeechRecognizer is UNINITIALIZED", new Bundle());
            return false;
        }
        if (this.mServiceExecutor.isConnected()) {
            return true;
        }
        IdleTask idleTask = new IdleTask();
        RemoteServiceExecutor remoteServiceExecutor = this.mServiceExecutor;
        Objects.requireNonNull(remoteServiceExecutor);
        idleTask.setCompleteCallback(new C7695k(remoteServiceExecutor, 0));
        this.mServiceExecutor.execute(idleTask);
        return true;
    }

    private boolean isReleased() {
        return this.isReleased;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RemoteServiceExecutor lambda$new$2(Context context) {
        return new RemoteServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RemoteServiceExecutor lambda$static$0() {
        return new RemoteServiceExecutor(getGlobalContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(RemoteServiceExecutor remoteServiceExecutor) {
        if (remoteServiceExecutor != null) {
            remoteServiceExecutor.deInitWhenIdle();
        }
    }

    public void cancel() {
        Log.m6489i(this.TAG, "cancel");
        SttRecognitionTask sttRecognitionTask = this.mSttTask;
        if (sttRecognitionTask == null || sttRecognitionTask.isComplete()) {
            return;
        }
        this.mSttTask.cancel();
    }

    public void init() {
        ASRLog.m6139i(this.TAG, "init", this.mListener, Boolean.valueOf(initInternal()));
    }

    public void release() {
        this.isReleased = true;
        Log.m6489i(this.TAG, "release");
        cancel();
        SttRecognitionTask sttRecognitionTask = this.mSttTask;
        if (sttRecognitionTask != null) {
            sttRecognitionTask.release();
        }
        this.mSttTask = null;
    }

    public void start(@NonNull RecognitionConfig recognitionConfig, @NonNull InputStream inputStream) {
        if (!initInternal()) {
            Log.m6490w(this.TAG, "start failed");
            return;
        }
        Log.m6489i(this.TAG, "start");
        SttRecognitionTask sttRecognitionTask = new SttRecognitionTask(recognitionConfig, inputStream, this.mCallerPackage, this.mListener);
        this.mSttTask = sttRecognitionTask;
        RemoteServiceExecutor remoteServiceExecutor = this.mServiceExecutor;
        Objects.requireNonNull(remoteServiceExecutor);
        sttRecognitionTask.setCompleteCallback(new C7695k(remoteServiceExecutor, 0));
        this.mServiceExecutor.execute(this.mSttTask);
    }
}
