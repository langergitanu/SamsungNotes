package com.samsung.android.sdk.scs.p142ai.translation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.DetectionCandidate;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class NeuralTranslationRunnableExecutor {
    NeuralTranslationServiceExecutor serviceExecutor;

    public NeuralTranslationRunnableExecutor(NeuralTranslationServiceExecutor neuralTranslationServiceExecutor) {
        this.serviceExecutor = neuralTranslationServiceExecutor;
    }

    private <T> Task<T> executeAndGetTask(TaskRunnable<T> taskRunnable) {
        this.serviceExecutor.execute(taskRunnable);
        return taskRunnable.getTask();
    }

    public static NeuralTranslationRunnableExecutor from(NeuralTranslationServiceExecutor neuralTranslationServiceExecutor) {
        return new NeuralTranslationRunnableExecutor(neuralTranslationServiceExecutor);
    }

    public void deInit() {
        this.serviceExecutor.deInit();
    }

    public Task<Map<LanguageDirection, LanguageDirectionState>> executeClearAndRefresh() {
        return executeAndGetTask(new ClearAndRefreshNeuralTranslatorRunnable(this.serviceExecutor));
    }

    public Task<Map<LanguageDirection, LanguageDirectionState>> executeClearWithSourceId(String str) {
        return executeAndGetTask(new ClearWithSourceIdRunnable(this.serviceExecutor, str));
    }

    public Task<String> executeGetResourcePackPackageName(String str, String str2) {
        return executeAndGetTask(new GetResourcePackPackageNameRunnable(this.serviceExecutor, str, str2));
    }

    public Task<List<String>> executeGetSpeechLlmSupportedSourceLanguage() {
        return executeAndGetTask(new GetSpeechLlmSupportedSourceLanguageRunnable(this.serviceExecutor));
    }

    public Task<List<String>> executeGetSpeechLlmSupportedTargetLanguage(String str) {
        return executeAndGetTask(new GetSpeechLlmSupportedTargetLanguageRunnable(this.serviceExecutor, str));
    }

    public Task<Boolean> executeIsTaggedTranslationSupported(String str, String str2) {
        return executeAndGetTask(new IsTaggedTranslationSupportedRunnable(this.serviceExecutor, str, str2));
    }

    public Task<String> executeLanguageIdentification(String str, String str2) {
        return executeAndGetTask(new LanguageIdentificationRunnable(this.serviceExecutor, str, str2));
    }

    public Task<List<DetectionCandidate>> executeLanguageIdentificationAndGetCandidate(String str, Integer num, Boolean bool, Boolean bool2) {
        return executeAndGetTask(new LanguageIdentificationAndGetCandidateRunnable(this.serviceExecutor, str, num, bool.booleanValue(), bool2.booleanValue()));
    }

    public Task<List<String>> executeLanguageIdentificationWithList(ArrayList<String> arrayList, String str) {
        return executeAndGetTask(new LanguageIdentificationWithListRunnable(this.serviceExecutor, arrayList, str));
    }

    public Task<String> executeLanguagePackCodeIdentification(String str, String str2) {
        return executeAndGetTask(new LanguagePackCodeIdentificationRunnable(this.serviceExecutor, str, str2));
    }

    public Task<Boolean> executePrepareSpeechLlmTranslationRunnable(SpeechLlmPrePareInfo speechLlmPrePareInfo) {
        return executeAndGetTask(new PrepareSpeechLlmTranslationRunnable(this.serviceExecutor, speechLlmPrePareInfo));
    }

    public Task<Map<LanguageDirection, LanguageDirectionState>> executeRefresh() {
        return executeAndGetTask(new RefreshNeuralTranslatorRunnable(this.serviceExecutor));
    }

    public Task<Void> executeTranslationByChunkRunnable(NeuralTranslationRequest neuralTranslationRequest, @Nullable AppInfo appInfo) {
        return executeAndGetTask(new NeuralTranslationByChunkRunnable(this.serviceExecutor, neuralTranslationRequest, appInfo));
    }

    public Task<Void> executeTranslationRunnable(NeuralTranslationRequest neuralTranslationRequest, @Nullable AppInfo appInfo) {
        return executeAndGetTask(new NeuralTranslationRunnable(this.serviceExecutor, neuralTranslationRequest, appInfo));
    }

    public Task<Void> executeTranslationByChunkRunnable(NeuralTranslationRequest neuralTranslationRequest, @Nullable AppInfo appInfo, int i) {
        return executeAndGetTask(new NeuralTranslationByChunkRunnable(this.serviceExecutor, neuralTranslationRequest, appInfo, i));
    }

    public Task<Void> executeTranslationRunnable(NeuralTranslationRequest neuralTranslationRequest, Bundle bundle, @Nullable AppInfo appInfo) {
        return executeAndGetTask(new NeuralTranslationRunnable(this.serviceExecutor, neuralTranslationRequest, bundle, appInfo));
    }
}
