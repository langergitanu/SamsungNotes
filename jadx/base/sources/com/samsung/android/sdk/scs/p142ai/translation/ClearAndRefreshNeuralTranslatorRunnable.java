package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class ClearAndRefreshNeuralTranslatorRunnable extends TaskRunnable<Map<LanguageDirection, LanguageDirectionState>> {
    private static final String CLASS_NAME = "ClearAndRefreshNeuralTranslatorRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;

    public ClearAndRefreshNeuralTranslatorRunnable(NeuralTranslationServiceExecutor neuralTranslationServiceExecutor) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            INeuralTranslationService translationService = this.neuralTranslationServiceExecutor.getTranslationService();
            translationService.clear();
            translationService.refresh();
            this.mSource.setResult((TResult) LanguageDirectionStateMapper.from(translationService.getLanguageDirectionStateMap()));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "ClearAndRefreshNeuralTranslatorRunnable -- Exception: " + e);
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return this.neuralTranslationServiceExecutor.isPublic() ? "FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL" : "FEATURE_NEURAL_TRANSLATION";
    }
}
