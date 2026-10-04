package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.TranslationConst;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class LanguageIdentificationRunnable extends TaskRunnable<String> {
    private static final String CLASS_NAME = "LanguageIdentificationRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    private final String fallbackLanguage;
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    private final String text;

    public LanguageIdentificationRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, String str, String str2) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.text = str;
        this.fallbackLanguage = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("text", this.text);
            bundle.putString(TranslationConst.KEY_LANGUAGE_IDENTIFICATION.FALLBACK_LANGUAGE, this.fallbackLanguage);
            String strIdentifyLanguage = this.neuralTranslationServiceExecutor.getTranslationService().identifyLanguage(bundle);
            Log.m6489i(TAG, "LanguageIdentificationRunnable -- identified language: " + strIdentifyLanguage);
            this.mSource.setResult((TResult) strIdentifyLanguage);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "LanguageIdentificationRunnable -- Exception: " + e);
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return this.neuralTranslationServiceExecutor.isPublic() ? "FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL" : "FEATURE_NEURAL_TRANSLATION";
    }
}
