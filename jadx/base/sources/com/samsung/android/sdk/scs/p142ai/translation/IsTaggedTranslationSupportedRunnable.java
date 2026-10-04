package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IsTaggedTranslationSupportedRunnable extends TaskRunnable<Boolean> {
    private static final String CLASS_NAME = "IsTaggedTranslationSupported";
    private static final String TAG = "ScsApi@NeuralTranslator";
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    private final String sourceLanguageCode;
    private final String targetLanguageCode;

    public IsTaggedTranslationSupportedRunnable(NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, String str, String str2) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.sourceLanguageCode = str;
        this.targetLanguageCode = str2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            INeuralTranslationService translationService = this.neuralTranslationServiceExecutor.getTranslationService();
            Log.m6485d(TAG, "isTaggedTranslationSupported is calling : " + this.sourceLanguageCode + " " + this.targetLanguageCode);
            this.mSource.setResult((TResult) Boolean.valueOf(translationService.isTaggedTranslationSupported(this.sourceLanguageCode, this.targetLanguageCode)));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "IsTaggedTranslationSupported -- Exception: " + e);
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_NEURAL_TRANSLATION_TAG_SUPPORTED";
    }
}
