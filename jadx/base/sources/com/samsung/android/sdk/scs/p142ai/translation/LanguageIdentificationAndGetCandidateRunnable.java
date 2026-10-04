package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.DetectionCandidate;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.TranslationConst;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LanguageIdentificationAndGetCandidateRunnable extends TaskRunnable<List<DetectionCandidate>> {
    private static final String CLASS_NAME = "LanguageIdentificationAndGetCandidateRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    private final boolean differentiate;
    private final Integer maxCandidate;
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    private final String text;
    private final boolean verbose;

    public LanguageIdentificationAndGetCandidateRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, String str, Integer num, boolean z, boolean z2) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.text = str;
        this.maxCandidate = num;
        this.differentiate = z;
        this.verbose = z2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("text", this.text);
            bundle.putInt(TranslationConst.KEY_LANGUAGE_IDENTIFICATION.MAX_CANDIDATES, this.maxCandidate.intValue());
            bundle.putBoolean(TranslationConst.KEY_LANGUAGE_IDENTIFICATION.DIFFERENTIATE, this.differentiate);
            bundle.putBoolean("verbose", this.verbose);
            List<DetectionCandidate> listIdentifyLanguageAndGetCandidate = this.neuralTranslationServiceExecutor.getTranslationService().identifyLanguageAndGetCandidate(bundle);
            Log.m6489i(TAG, "LanguageIdentificationAndGetCandidateRunnable -- identified language: " + listIdentifyLanguageAndGetCandidate.toString());
            this.mSource.setResult((TResult) listIdentifyLanguageAndGetCandidate);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "LanguageIdentificationAndGetCandidateRunnable -- Exception: " + e);
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return this.neuralTranslationServiceExecutor.isPublic() ? "FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL" : "FEATURE_LANGUAGE_IDENTIFICATION_AND_GET_CANDIDATE";
    }
}
