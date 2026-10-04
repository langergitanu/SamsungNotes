package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class GetSpeechLlmSupportedTargetLanguageRunnable extends TaskRunnable<List<String>> {
    private static final String CLASS_NAME = "GetSpeechLLMSupportedTargetLanguageRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    private String sourceLanguageCode;

    public GetSpeechLlmSupportedTargetLanguageRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, @NonNull String str) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.sourceLanguageCode = str;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            this.mSource.setResult((TResult) this.neuralTranslationServiceExecutor.getTranslationService().getSpeechLlmSupportedTargetLanguage(this.sourceLanguageCode));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "GetSpeechLLMSupportedTargetLanguageRunnable -- Exception: " + e);
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_NEURAL_TRANSLATION_SPEECH_LLM";
    }
}
