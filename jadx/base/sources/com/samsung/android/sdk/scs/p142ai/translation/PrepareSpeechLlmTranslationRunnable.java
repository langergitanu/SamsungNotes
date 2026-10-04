package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class PrepareSpeechLlmTranslationRunnable extends TaskRunnable<Boolean> {
    private static final String CLASS_NAME = "PrepareSpeechLLMTranslationRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    SpeechLlmPrePareInfo prepareInfo;

    public PrepareSpeechLlmTranslationRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, @NonNull SpeechLlmPrePareInfo speechLlmPrePareInfo) {
        this.prepareInfo = speechLlmPrePareInfo;
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sourceLanguage", this.prepareInfo.getSourceLanguage());
            bundle.putString("targetLanguage", this.prepareInfo.getTargetLanguage());
            this.mSource.setResult((TResult) Boolean.valueOf(this.neuralTranslationServiceExecutor.getTranslationService().prepareSpeechLlmTranslation(bundle)));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "PrepareSpeechLLMTranslationRunnable -- Exception: " + e);
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_NEURAL_TRANSLATION_SPEECH_LLM";
    }
}
