package com.samsung.android.sdk.scs.p142ai.translation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationCallback;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.TranslationConst;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"LogNotTimber"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
class NeuralTranslationRunnable extends TaskRunnable<Void> {
    private static final String CLASS_NAME = "NeuralTranslationRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    Map<String, String> authHeader;
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    NeuralTranslationRequest request;
    Bundle speechLlmRequest;

    /* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.translation.NeuralTranslationRunnable$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BinderC77761 extends INeuralTranslationCallback.Stub {
        final /* synthetic */ String val$translationId;
        final /* synthetic */ Handler val$translationResultHandler;

        public BinderC77761(String str, Handler handler) {
            this.val$translationId = str;
            this.val$translationResultHandler = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$1(NeuralTranslationErrorCode neuralTranslationErrorCode) {
            NeuralTranslationRunnable.this.request.getOnFailure().accept(neuralTranslationErrorCode);
            NeuralTranslationRunnable.this.request.deRegisterCallback();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(NeuralTranslationResult neuralTranslationResult) {
            NeuralTranslationRunnable.this.request.getOnSuccess().accept(neuralTranslationResult);
            NeuralTranslationRunnable.this.request.deRegisterCallback();
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationCallback
        public void onFailure(int i) {
            NeuralTranslationErrorCode neuralTranslationErrorCodeFrom = NeuralTranslationErrorCode.from(i);
            Log.m6487e(NeuralTranslationRunnable.TAG, "NeuralTranslationRunnable -- [" + this.val$translationId + "] Translation fails with error code " + neuralTranslationErrorCodeFrom);
            this.val$translationResultHandler.post(new RunnableC7779b(this, neuralTranslationErrorCodeFrom, 2));
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationCallback
        public void onSuccess(Bundle bundle) {
            String string = bundle.getString("sourceLanguage");
            String string2 = bundle.getString("targetLanguage");
            Boolean boolValueOf = Boolean.valueOf(bundle.getBoolean("formality"));
            Log.m6489i(NeuralTranslationRunnable.TAG, "NeuralTranslationRunnable -- [" + this.val$translationId + "] Translate success");
            this.val$translationResultHandler.post(new RunnableC7779b(this, NeuralTranslationResult.builder().sourceLanguage(string).targetLanguage(string2).sourceText(bundle.getString("sourceText")).targetText(bundle.getString("targetText")).m6423id(bundle.getString("id")).verbose(Boolean.valueOf(bundle.getBoolean("verbose"))).appendMeta(Boolean.valueOf(bundle.getBoolean("appendMeta"))).formality(boolValueOf).forcePivot(Boolean.valueOf(bundle.getBoolean("forcePivot"))).interimResult(bundle.getString(TranslationConst.KEY_TEXT_TRANSLATION_RESULT.INTERIM_RESULT)).isComplete(Boolean.TRUE).build(), 1));
        }
    }

    public NeuralTranslationRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, @NonNull NeuralTranslationRequest neuralTranslationRequest, @Nullable AppInfo appInfo) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.request = neuralTranslationRequest;
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.neuralTranslationServiceExecutor.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0() {
        this.request.getOnFailure().accept(NeuralTranslationErrorCode.UNKNOWN);
        this.request.deRegisterCallback();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Handler handler = new Handler(Looper.getMainLooper());
        try {
            NeuralTranslationSource source = this.request.getSource();
            Bundle bundle = new Bundle();
            String string = UUID.randomUUID().toString();
            String sourceLanguage = source.getSourceLanguage();
            String targetLanguage = source.getTargetLanguage();
            Boolean formality = source.getFormality();
            String mode = source.getMode();
            boolean sentenceSplit = source.getSentenceSplit();
            Log.m6489i(TAG, "NeuralTranslationRunnable -- [" + string + "] Translate requested");
            bundle.putString("sourceLanguage", sourceLanguage);
            bundle.putString("targetLanguage", targetLanguage);
            bundle.putString("sourceText", source.getSourceText());
            bundle.putString("id", source.getId());
            bundle.putString("tid", string);
            bundle.putBoolean("verbose", source.getVerbose().booleanValue());
            bundle.putBoolean("appendMeta", source.getAppendMeta().booleanValue());
            bundle.putBoolean("formality", formality.booleanValue());
            bundle.putString("mode", mode);
            bundle.putBoolean("forcePivot", source.getForcePivot().booleanValue());
            bundle.putString(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.REQUESTING_PACKAGE_NAME, source.getRequestingPackageName());
            bundle.putBoolean(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.NEED_SENTENCE_SPLIT, sentenceSplit);
            bundle.putString(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.REQUESTING_SOURCE_ID, source.getRequestingSourceId());
            bundle.putBoolean(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.END_OF_CONTEXT, source.getEndOfContext());
            bundle.putInt(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.CONTEXT_CANDIDATE, source.getContextCandidate());
            bundle.putBundle(TranslationConst.KEY_SPEECH_LLM.KEY_SPEECH_LLM_BUNDLE, this.speechLlmRequest);
            for (Map.Entry<String, String> entry : this.authHeader.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            this.neuralTranslationServiceExecutor.getTranslationService().translate(bundle, new BinderC77761(string, handler));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "NeuralTranslationRunnable -- Exception : " + e);
            e.printStackTrace();
            this.mSource.setException(e);
            handler.post(new RunnableC7780c(this, 1));
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return this.neuralTranslationServiceExecutor.isPublic() ? "FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL" : "FEATURE_NEURAL_TRANSLATION";
    }

    public NeuralTranslationRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, @NonNull NeuralTranslationRequest neuralTranslationRequest, @NonNull Bundle bundle, @Nullable AppInfo appInfo) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.request = neuralTranslationRequest;
        this.speechLlmRequest = bundle;
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.neuralTranslationServiceExecutor.context);
    }
}
