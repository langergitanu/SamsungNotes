package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.TranslationConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class LanguageIdentificationWithListRunnable extends TaskRunnable<List<String>> {
    private static final String CLASS_NAME = "LanguageIdentificationWithListRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    private final String fallbackLanguage;
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    private final ArrayList<String> textList;

    public LanguageIdentificationWithListRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, ArrayList<String> arrayList, String str) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.textList = arrayList;
        this.fallbackLanguage = str;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("textList", this.textList);
            bundle.putString(TranslationConst.KEY_LANGUAGE_IDENTIFICATION.FALLBACK_LANGUAGE, this.fallbackLanguage);
            List<String> listIdentifyLanguageWithList = this.neuralTranslationServiceExecutor.getTranslationService().identifyLanguageWithList(bundle);
            Log.m6489i(TAG, "LanguageIdentificationWithListRunnable -- identified language: " + listIdentifyLanguageWithList.toString());
            this.mSource.setResult((TResult) listIdentifyLanguageWithList);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "LanguageIdentificationWithListRunnable -- Exception: " + e);
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return this.neuralTranslationServiceExecutor.isPublic() ? "FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL" : "FEATURE_LANGUAGE_LIST_IDENTIFICATION";
    }
}
