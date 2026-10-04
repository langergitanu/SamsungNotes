package com.samsung.android.sdk.scs.p142ai.translation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationByChunkRunnable;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.ChunkPair;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationCallback;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.TranslationConst;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"LogNotTimber"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
class NeuralTranslationByChunkRunnable extends TaskRunnable<Void> {
    private static final String CLASS_NAME = "NeuralTranslationByChunkRunnable";
    private static final String TAG = "ScsApi@NeuralTranslator";
    Map<String, String> authHeader;
    int chunkBaseLen;
    Bundle mBundle;
    List<ChunkPair> mTextChunks;
    NeuralTranslationServiceExecutor neuralTranslationServiceExecutor;
    NeuralTranslationRequest request;

    /* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.translation.NeuralTranslationByChunkRunnable$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BinderC77751 extends INeuralTranslationCallback.Stub {
        final /* synthetic */ String val$translationId;
        final /* synthetic */ Handler val$translationResultHandler;

        public BinderC77751(String str, Handler handler) {
            this.val$translationId = str;
            this.val$translationResultHandler = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$2(NeuralTranslationErrorCode neuralTranslationErrorCode) {
            NeuralTranslationByChunkRunnable.this.request.getOnFailure().accept(neuralTranslationErrorCode);
            NeuralTranslationByChunkRunnable.this.request.deRegisterCallback();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$3(NeuralTranslationErrorCode neuralTranslationErrorCode) {
            NeuralTranslationByChunkRunnable.this.request.getOnFailure().accept(neuralTranslationErrorCode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(NeuralTranslationResult neuralTranslationResult) {
            NeuralTranslationByChunkRunnable.this.request.getOnSuccess().accept(neuralTranslationResult);
            NeuralTranslationByChunkRunnable.this.request.deRegisterCallback();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$1(NeuralTranslationResult neuralTranslationResult) {
            NeuralTranslationByChunkRunnable.this.request.getOnSuccess().accept(neuralTranslationResult);
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationCallback
        public void onFailure(int i) {
            final NeuralTranslationErrorCode neuralTranslationErrorCodeFrom = NeuralTranslationErrorCode.from(i);
            Log.m6487e(NeuralTranslationByChunkRunnable.TAG, "NeuralTranslationByChunkRunnable -- [" + this.val$translationId + "] Translation fails with error code " + neuralTranslationErrorCodeFrom);
            if (NeuralTranslationByChunkRunnable.this.mTextChunks.size() == 1) {
                final int i2 = 0;
                this.val$translationResultHandler.post(new Runnable(this) { // from class: com.samsung.android.sdk.scs.ai.translation.e

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ NeuralTranslationByChunkRunnable.BinderC77751 f5240b;

                    {
                        this.f5240b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                this.f5240b.lambda$onFailure$2(neuralTranslationErrorCodeFrom);
                                break;
                            default:
                                this.f5240b.lambda$onFailure$3(neuralTranslationErrorCodeFrom);
                                break;
                        }
                    }
                });
            } else {
                final int i4 = 1;
                this.val$translationResultHandler.post(new Runnable(this) { // from class: com.samsung.android.sdk.scs.ai.translation.e

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ NeuralTranslationByChunkRunnable.BinderC77751 f5240b;

                    {
                        this.f5240b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                this.f5240b.lambda$onFailure$2(neuralTranslationErrorCodeFrom);
                                break;
                            default:
                                this.f5240b.lambda$onFailure$3(neuralTranslationErrorCodeFrom);
                                break;
                        }
                    }
                });
            }
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationCallback
        public void onSuccess(Bundle bundle) {
            String string = bundle.getString("sourceLanguage");
            String string2 = bundle.getString("targetLanguage");
            Boolean boolValueOf = Boolean.valueOf(bundle.getBoolean("formality"));
            Log.m6489i(NeuralTranslationByChunkRunnable.TAG, "NeuralTranslationByChunkRunnable -- [" + this.val$translationId + "] Translate success");
            String string3 = bundle.getString("targetText");
            String delimiter = NeuralTranslationByChunkRunnable.this.mTextChunks.get(0).getDelimiter();
            final NeuralTranslationResult neuralTranslationResultBuild = NeuralTranslationResult.builder().sourceLanguage(string).targetLanguage(string2).sourceText(bundle.getString("sourceText") + delimiter).targetText(AbstractC0541b.m756B(string3, delimiter)).m6423id(bundle.getString("id")).verbose(Boolean.valueOf(bundle.getBoolean("verbose"))).appendMeta(Boolean.valueOf(bundle.getBoolean("appendMeta"))).formality(boolValueOf).forcePivot(Boolean.valueOf(bundle.getBoolean("forcePivot"))).interimResult(bundle.getString(TranslationConst.KEY_TEXT_TRANSLATION_RESULT.INTERIM_RESULT)).isComplete(Boolean.valueOf(NeuralTranslationByChunkRunnable.this.mTextChunks.size() == 1)).build();
            if (NeuralTranslationByChunkRunnable.this.mTextChunks.size() == 1) {
                final int i = 0;
                this.val$translationResultHandler.post(new Runnable(this) { // from class: com.samsung.android.sdk.scs.ai.translation.d

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ NeuralTranslationByChunkRunnable.BinderC77751 f5237b;

                    {
                        this.f5237b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                this.f5237b.lambda$onSuccess$0(neuralTranslationResultBuild);
                                break;
                            default:
                                this.f5237b.lambda$onSuccess$1(neuralTranslationResultBuild);
                                break;
                        }
                    }
                });
            } else {
                final int i2 = 1;
                this.val$translationResultHandler.post(new Runnable(this) { // from class: com.samsung.android.sdk.scs.ai.translation.d

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ NeuralTranslationByChunkRunnable.BinderC77751 f5237b;

                    {
                        this.f5237b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                this.f5237b.lambda$onSuccess$0(neuralTranslationResultBuild);
                                break;
                            default:
                                this.f5237b.lambda$onSuccess$1(neuralTranslationResultBuild);
                                break;
                        }
                    }
                });
            }
            if (NeuralTranslationByChunkRunnable.this.mTextChunks.size() > 1) {
                NeuralTranslationByChunkRunnable.this.mTextChunks.remove(0);
                NeuralTranslationByChunkRunnable neuralTranslationByChunkRunnable = NeuralTranslationByChunkRunnable.this;
                neuralTranslationByChunkRunnable.mBundle.putString("sourceText", neuralTranslationByChunkRunnable.mTextChunks.get(0).getSentence());
                try {
                    NeuralTranslationByChunkRunnable.this.neuralTranslationServiceExecutor.getTranslationService().translate(NeuralTranslationByChunkRunnable.this.mBundle, this);
                } catch (RemoteException e) {
                    Log.m6487e(NeuralTranslationByChunkRunnable.TAG, "NeuralTranslationByChunkRunnable onSuccess recursive -- Exception : " + e);
                    e.printStackTrace();
                    ((TaskRunnable) NeuralTranslationByChunkRunnable.this).mSource.setException(e);
                }
            }
        }
    }

    public NeuralTranslationByChunkRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, @NonNull NeuralTranslationRequest neuralTranslationRequest, @Nullable AppInfo appInfo) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.request = neuralTranslationRequest;
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.neuralTranslationServiceExecutor.context);
        this.chunkBaseLen = 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(NeuralTranslationResult neuralTranslationResult) {
        this.request.getOnSuccess().accept(neuralTranslationResult);
        this.request.deRegisterCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$1() {
        this.request.getOnFailure().accept(NeuralTranslationErrorCode.UNKNOWN);
        this.request.deRegisterCallback();
    }

    private Bundle makeTranslateBundle(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, boolean z4, String str7, boolean z5, String str8, boolean z6, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("sourceText", str);
        bundle.putString("sourceLanguage", str2);
        bundle.putString("targetLanguage", str3);
        bundle.putString("id", str4);
        bundle.putString("tid", str5);
        bundle.putBoolean("verbose", z);
        bundle.putBoolean("appendMeta", z2);
        bundle.putBoolean("formality", z3);
        bundle.putString("mode", str6);
        bundle.putBoolean("forcePivot", z4);
        bundle.putString(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.REQUESTING_PACKAGE_NAME, str7);
        bundle.putBoolean(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.NEED_SENTENCE_SPLIT, z5);
        bundle.putString(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.REQUESTING_SOURCE_ID, str8);
        bundle.putBoolean(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.END_OF_CONTEXT, z6);
        bundle.putInt(TranslationConst.KEY_TEXT_TRANSLATION_REQUEST.CONTEXT_CANDIDATE, i);
        for (Map.Entry<String, String> entry : this.authHeader.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Handler handler;
        String str;
        Handler handler2 = new Handler(Looper.getMainLooper());
        try {
            NeuralTranslationSource source = this.request.getSource();
            String sourceText = source.getSourceText();
            String sourceLanguage = source.getSourceLanguage();
            String targetLanguage = source.getTargetLanguage();
            String id = source.getId();
            String string = UUID.randomUUID().toString();
            Boolean verbose = source.getVerbose();
            boolean zBooleanValue = verbose.booleanValue();
            Boolean appendMeta = source.getAppendMeta();
            boolean zBooleanValue2 = appendMeta.booleanValue();
            Boolean formality = source.getFormality();
            boolean zBooleanValue3 = formality.booleanValue();
            String mode = source.getMode();
            int contextCandidate = source.getContextCandidate();
            boolean endOfContext = source.getEndOfContext();
            if (mode.equalsIgnoreCase("plain") || mode.equalsIgnoreCase("contextual")) {
                str = mode;
            } else {
                Log.m6490w(TAG, "splitTranslate is only for plain or contextual mode not ".concat(mode));
                Log.m6490w(TAG, "mode changed to plain");
                str = "plain";
            }
            Boolean forcePivot = source.getForcePivot();
            boolean zBooleanValue4 = forcePivot.booleanValue();
            String requestingPackageName = source.getRequestingPackageName();
            boolean sentenceSplit = source.getSentenceSplit();
            String requestingSourceId = source.getRequestingSourceId();
            String str2 = str;
            Log.m6489i(TAG, "NeuralTranslationByChunkRunnable -- [" + string + "] Translate requested");
            BinderC77751 binderC77751 = new BinderC77751(string, handler2);
            this.mTextChunks = this.neuralTranslationServiceExecutor.getTranslationService().chunkText(sourceText, sourceLanguage, this.chunkBaseLen);
            Log.m6489i(TAG, "init chunk size: " + this.mTextChunks.size());
            if (this.mTextChunks.isEmpty()) {
                handler2.post(new RunnableC7779b(this, NeuralTranslationResult.builder().sourceLanguage(sourceLanguage).targetLanguage(targetLanguage).sourceText(sourceText).targetText(sourceText).m6423id(id).verbose(verbose).appendMeta(appendMeta).formality(formality).forcePivot(forcePivot).interimResult("").isComplete(Boolean.TRUE).build(), 0));
                return;
            }
            handler = handler2;
            try {
                this.mBundle = makeTranslateBundle(this.mTextChunks.get(0).getSentence(), sourceLanguage, targetLanguage, id, string, zBooleanValue, zBooleanValue2, zBooleanValue3, str2, zBooleanValue4, requestingPackageName, sentenceSplit, requestingSourceId, endOfContext, contextCandidate);
                this.neuralTranslationServiceExecutor.getTranslationService().translate(this.mBundle, binderC77751);
            } catch (RemoteException e) {
                e = e;
                Log.m6487e(TAG, "NeuralTranslationByChunkRunnable -- Exception : " + e);
                e.printStackTrace();
                handler.post(new RunnableC7780c(this, 0));
                this.mSource.setException(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            handler = handler2;
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_NEURAL_TRANSLATION_BY_CHUNK";
    }

    public NeuralTranslationByChunkRunnable(@NonNull NeuralTranslationServiceExecutor neuralTranslationServiceExecutor, @NonNull NeuralTranslationRequest neuralTranslationRequest, @Nullable AppInfo appInfo, int i) {
        this.neuralTranslationServiceExecutor = neuralTranslationServiceExecutor;
        this.request = neuralTranslationRequest;
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.neuralTranslationServiceExecutor.context);
        this.chunkBaseLen = i;
    }
}
