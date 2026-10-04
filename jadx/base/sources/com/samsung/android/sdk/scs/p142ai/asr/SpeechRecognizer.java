package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SpeechRecognizer {
    private static final String TAG = "SpeechRecognizer";
    private final Context mContext;
    private final SpeechRecognitionListener mInnerListener;
    private final SpeechRecognizerControl mRecognizerController;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpeechRecognizer(@NonNull Context context, @NonNull SpeechRecognitionListener speechRecognitionListener) {
        this.mContext = context;
        this.mInnerListener = speechRecognitionListener;
        this.mRecognizerController = new SpeechRecognizerControl(context, speechRecognitionListener);
    }

    public void cancel() {
        this.mRecognizerController.cancel();
    }

    @NonNull
    public List<Locale> getSupportedLocales() {
        return Environment.getSupportedLocales(this.mContext);
    }

    public void init() {
        this.mRecognizerController.init();
    }

    public void release() {
        this.mRecognizerController.release();
    }

    public void start(@NonNull RecognitionConfig recognitionConfig, @NonNull InputStream inputStream) {
        this.mRecognizerController.start(recognitionConfig, inputStream);
        Log.m6487e(TAG, "started");
    }
}
