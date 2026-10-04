package com.samsung.android.sdk.scs.p142ai.translation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.transition.C3970a;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Configuration;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.sdk.scs.p142ai.language.Translator;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.DetectionCandidate;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NeuralTranslator {
    private static final String CLASS_NAME = "NeuralTranslator";
    private static final String TAG = "ScsApi@NeuralTranslator";
    Context context;
    Map<LanguageDirection, LanguageDirectionState> languageDirectionStateMap;
    Translator llmTranslator;
    NeuralTranslationRunnableExecutor neuralTranslationRunnableExecutor;

    public NeuralTranslator(@NonNull Context context) {
        this(context, false);
    }

    private AppInfo copyAppInfoWithOnDeviceType(AppInfo appInfo) {
        return new AppInfo.Builder().setAppId(appInfo != null ? appInfo.getAppId() : "").setSigningKey(appInfo != null ? appInfo.getSigningKey() : "").setAppId(appInfo != null ? appInfo.getAppId() : "").setAccessToken(appInfo != null ? appInfo.getAccessToken() : "").setUserId(appInfo != null ? appInfo.getUserId() : "").setServerUrl(appInfo != null ? appInfo.getServerUrl() : "").setAccountType(appInfo != null ? appInfo.getAccountType() : null).setRequestType(AppInfo.RequestType.ONDEVICE).setStreamingMode(appInfo != null ? appInfo.isStreamingMode() : false).build();
    }

    private List<String> getAvailableLanguageDirectionStringList(LanguageDirectionState languageDirectionState) {
        return (List) this.languageDirectionStateMap.entrySet().stream().filter(new C7784g(languageDirectionState, 1)).map(new C4662f(21)).map(new C4662f(19)).distinct().sorted().collect(Collectors.toList());
    }

    private boolean isLLMTranslationSupported(LlmTranslationRequest llmTranslationRequest, Configuration configuration) {
        Log.m6489i(TAG, "NeuralTranslator -- isLLMTranslationSupported() executed ");
        String ondeviceCapability = configuration.getOndeviceCapability();
        String languageTag = llmTranslationRequest.getFromLanguage().toLanguageTag();
        String languageTag2 = llmTranslationRequest.getToLanguage().toLanguageTag();
        try {
            JSONArray jSONArray = new JSONArray(ondeviceCapability);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getString("language").equals(languageTag)) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray(Features.META_FUNCTION);
                    String str = "Translation-" + languageTag + "2" + languageTag2;
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        if (jSONArray2.getString(i2).equals(str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            Log.m6487e(TAG, "Looks like Configuration is empty" + ondeviceCapability);
            e.printStackTrace();
        } catch (JSONException e2) {
            Log.m6487e(TAG, "Failed to parse Configuration");
            e2.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clear$3(Task task) {
        try {
            this.languageDirectionStateMap = (Map) task.getResult();
            Log.m6489i(TAG, "NeuralTranslator -- clear() - Available LanguageDirection list [(source, target)]: " + getAvailableLanguageDirectionStringList(LanguageDirectionState.AVAILABLE));
        } catch (RuntimeException e) {
            Log.m6487e(TAG, "NeuralTranslator -- Exception: " + e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clear$4(Task task) {
        try {
            this.languageDirectionStateMap = (Map) task.getResult();
            Log.m6489i(TAG, "NeuralTranslator -- clear() - Available LanguageDirection list [(source, target)]: " + getAvailableLanguageDirectionStringList(LanguageDirectionState.AVAILABLE));
        } catch (RuntimeException e) {
            Log.m6487e(TAG, "NeuralTranslator -- Exception: " + e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getAvailableLanguageDirectionStringList$10(LanguageDirection languageDirection) {
        return AbstractC0541b.m775q("(", languageDirection.getSourceLanguage(), SQLKeyword.COMMA, languageDirection.getTargetLanguage(), ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAvailableLanguageDirectionStringList$9(LanguageDirectionState languageDirectionState, Map.Entry entry) {
        return entry.getValue() == languageDirectionState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSourceLanguageList$6(Map.Entry entry) {
        return entry.getValue() == LanguageDirectionState.AVAILABLE || entry.getValue() == LanguageDirectionState.AVAILABLE_BY_PIVOT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTargetLanguageList$7(Map.Entry entry) {
        return entry.getValue() == LanguageDirectionState.AVAILABLE || entry.getValue() == LanguageDirectionState.AVAILABLE_BY_PIVOT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTargetLanguageList$8(String str, LanguageDirection languageDirection) {
        return languageDirection.getSourceLanguage().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$5(Task task) {
        try {
            this.languageDirectionStateMap = (Map) task.getResult();
            Log.m6489i(TAG, "NeuralTranslator -- refresh() - Available LanguageDirection list [(source, target)]: " + getAvailableLanguageDirectionStringList(LanguageDirectionState.AVAILABLE));
            Log.m6489i(TAG, "NeuralTranslator -- refresh() - Available by pivot LanguageDirection list [(source, target)]: " + getAvailableLanguageDirectionStringList(LanguageDirectionState.AVAILABLE_BY_PIVOT));
            Log.m6489i(TAG, "NeuralTranslator -- refresh() - Available downloadable LanguageDirection list [(source, target)]: " + getAvailableLanguageDirectionStringList(LanguageDirectionState.DOWNLOADABLE));
        } catch (RuntimeException e) {
            Log.m6487e(TAG, "NeuralTranslator -- Exception: " + e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$translate$0(LlmTranslationRequest llmTranslationRequest, Task task) {
        llmTranslationRequest.getOnSuccess().accept((Result) ((List) task.getResult()).get(0));
        llmTranslationRequest.deregistercallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$translate$1(LlmTranslationRequest llmTranslationRequest, Task task) {
        llmTranslationRequest.getOnFailure().accept(task.getException());
        llmTranslationRequest.deregistercallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$translate$2(Handler handler, final LlmTranslationRequest llmTranslationRequest, NeuralTranslationRequest neuralTranslationRequest, final Task task) {
        if (task.isSuccessful()) {
            Log.m6489i(TAG, "NeuralTranslator -- llm translation success");
            final int i = 0;
            handler.post(new Runnable() { // from class: com.samsung.android.sdk.scs.ai.translation.h
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            NeuralTranslator.lambda$translate$0(llmTranslationRequest, task);
                            break;
                        default:
                            NeuralTranslator.lambda$translate$1(llmTranslationRequest, task);
                            break;
                    }
                }
            });
            neuralTranslationRequest.deRegisterCallback();
            return;
        }
        Log.m6489i(TAG, "NeuralTranslator -- llm translation failed with Exception");
        final int i2 = 1;
        handler.post(new Runnable() { // from class: com.samsung.android.sdk.scs.ai.translation.h
            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        NeuralTranslator.lambda$translate$0(llmTranslationRequest, task);
                        break;
                    default:
                        NeuralTranslator.lambda$translate$1(llmTranslationRequest, task);
                        break;
                }
            }
        });
        neuralTranslationRequest.deRegisterCallback();
    }

    @NonNull
    public Task<Map<LanguageDirection, LanguageDirectionState>> clear() {
        Log.m6489i(TAG, "NeuralTranslator -- clear() executed");
        Task<Map<LanguageDirection, LanguageDirectionState>> taskExecuteClearAndRefresh = this.neuralTranslationRunnableExecutor.executeClearAndRefresh();
        taskExecuteClearAndRefresh.addOnCompleteListener(new C7783f(this, 0));
        return taskExecuteClearAndRefresh;
    }

    public void close() {
        Log.m6489i(TAG, "NeuralTranslator -- close() executed");
        NeuralTranslationRunnableExecutor neuralTranslationRunnableExecutor = this.neuralTranslationRunnableExecutor;
        if (neuralTranslationRunnableExecutor != null) {
            neuralTranslationRunnableExecutor.deInit();
        }
        Translator translator = this.llmTranslator;
        if (translator != null) {
            translator.release();
        }
    }

    @NonNull
    public Map<LanguageDirection, LanguageDirectionState> getLanguageDirectionStateMap() {
        Log.m6489i(TAG, "NeuralTranslator -- getLanguageDirectionStateMap() executed");
        return this.languageDirectionStateMap;
    }

    @Nullable
    public Task<String> getResourcePackPackageName(String str, String str2) {
        Log.m6489i(TAG, "NeuralTranslator -- getResourcePackPackageName() executed");
        return this.neuralTranslationRunnableExecutor.executeGetResourcePackPackageName(str, str2);
    }

    @NonNull
    public List<String> getSourceLanguageList() {
        Log.m6489i(TAG, "NeuralTranslator -- getSourceLanguageList() executed");
        return (List) this.languageDirectionStateMap.entrySet().stream().filter(new C0233e(6)).map(new C4662f(21)).map(new C4662f(20)).distinct().sorted().collect(Collectors.toList());
    }

    @NonNull
    public Task<List<String>> getSpeechLlmSupportedSourceLanguage() {
        Log.m6489i(TAG, "NeuralTranslator -- getSpeechLLMSupportedSourceLanguage() executed");
        return this.neuralTranslationRunnableExecutor.executeGetSpeechLlmSupportedSourceLanguage();
    }

    @NonNull
    public Task<List<String>> getSpeechLlmSupportedTargetLanguage(@NonNull String str) {
        Log.m6489i(TAG, "NeuralTranslator -- getSpeechLLMSupportedTargetLanguage() executed");
        return this.neuralTranslationRunnableExecutor.executeGetSpeechLlmSupportedTargetLanguage(str);
    }

    @NonNull
    public List<String> getTargetLanguageList(@NonNull String str) {
        Log.m6489i(TAG, "NeuralTranslator -- getTargetLanguageList() executed");
        return (List) this.languageDirectionStateMap.entrySet().stream().filter(new C0233e(7)).map(new C4662f(21)).filter(new C7784g(str, 0)).map(new C4662f(22)).distinct().sorted().collect(Collectors.toList());
    }

    @NonNull
    public Task<String> identifyLanguage(@NonNull String str) {
        Log.m6489i(TAG, "NeuralTranslator -- identifyLanguage() executed - default");
        return identifyLanguage(str, "en");
    }

    @NonNull
    public Task<List<DetectionCandidate>> identifyLanguageAndGetCandidate(@NonNull String str, @NonNull Integer num, boolean z, boolean z2) {
        Log.m6489i(TAG, "NeuralTranslator -- identifyLanguageAndGetCandidate() executed");
        return this.neuralTranslationRunnableExecutor.executeLanguageIdentificationAndGetCandidate(str, num, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    @NonNull
    public Task<String> identifyLanguagePackCode(@NonNull String str) {
        Log.m6489i(TAG, "NeuralTranslator -- identifyLanguagePackCode() executed - default");
        return identifyLanguagePackCode(str, "en");
    }

    @NonNull
    public Task<List<String>> identifyLanguageWithList(@NonNull ArrayList<String> arrayList) {
        Log.m6489i(TAG, "NeuralTranslator -- identifyLanguageWithList() executed - default");
        return identifyLanguageWithList(arrayList, "en");
    }

    public boolean isAvailableDirection(@NonNull LanguageDirection languageDirection) {
        Log.m6489i(TAG, "NeuralTranslator -- isAvailableDirection() executed");
        LanguageDirectionState languageDirectionState = this.languageDirectionStateMap.get(languageDirection);
        return languageDirectionState == LanguageDirectionState.AVAILABLE || languageDirectionState == LanguageDirectionState.AVAILABLE_BY_PIVOT;
    }

    @NonNull
    public Task<Boolean> isTaggedTranslationSupported(String str, String str2) {
        Log.m6489i(TAG, "NeuralTranslator -- isTaggedTranslationSupported() executed");
        return this.neuralTranslationRunnableExecutor.executeIsTaggedTranslationSupported(str, str2);
    }

    @NonNull
    public Task<Boolean> prepareSpeechLlmTranslation(@NonNull SpeechLlmPrePareInfo speechLlmPrePareInfo) {
        Log.m6489i(TAG, "NeuralTranslator -- prepareSpeechLlmTranslation() executed");
        return this.neuralTranslationRunnableExecutor.executePrepareSpeechLlmTranslationRunnable(speechLlmPrePareInfo);
    }

    @NonNull
    public Task<Map<LanguageDirection, LanguageDirectionState>> refresh() {
        Log.m6489i(TAG, "NeuralTranslator -- refresh() executed");
        Task<Map<LanguageDirection, LanguageDirectionState>> taskExecuteRefresh = this.neuralTranslationRunnableExecutor.executeRefresh();
        taskExecuteRefresh.addOnCompleteListener(new C7783f(this, 1));
        return taskExecuteRefresh;
    }

    @NonNull
    public Task<Void> translate(@NonNull NeuralTranslationRequest neuralTranslationRequest) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed (without app info)");
        return translate(null, neuralTranslationRequest);
    }

    @NonNull
    public Task<Void> translateByChunk(AppInfo appInfo, @NonNull NeuralTranslationRequest neuralTranslationRequest) {
        Log.m6489i(TAG, "NeuralTranslator -- translateByChunk() executed");
        if (Feature.checkFeature(this.context, "FEATURE_NEURAL_TRANSLATION_BY_CHUNK") == 0) {
            return this.neuralTranslationRunnableExecutor.executeTranslationByChunkRunnable(neuralTranslationRequest, appInfo);
        }
        Log.m6489i(TAG, "NeuralTranslator -- translate chunk not supported with service app");
        return this.neuralTranslationRunnableExecutor.executeTranslationRunnable(neuralTranslationRequest, appInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public NeuralTranslator(@NonNull Context context, boolean z) {
        this.languageDirectionStateMap = new HashMap();
        this.neuralTranslationRunnableExecutor = NeuralTranslationRunnableExecutor.from(new NeuralTranslationServiceExecutor(context, z));
        this.context = context.getApplicationContext();
        this.llmTranslator = new Translator(context);
    }

    @NonNull
    public Task<String> identifyLanguage(@NonNull String str, @NonNull String str2) {
        Log.m6489i(TAG, "NeuralTranslator -- identifyLanguage() executed - fallbackLanguage: " + str2);
        return this.neuralTranslationRunnableExecutor.executeLanguageIdentification(str, str2);
    }

    @NonNull
    public Task<String> identifyLanguagePackCode(@NonNull String str, @NonNull String str2) {
        Log.m6489i(TAG, "NeuralTranslator -- identifyLanguagePackCode() executed - fallbackLanguage: " + str2);
        return this.neuralTranslationRunnableExecutor.executeLanguagePackCodeIdentification(str, str2);
    }

    @NonNull
    public Task<List<String>> identifyLanguageWithList(@NonNull ArrayList<String> arrayList, @NonNull String str) {
        Log.m6489i(TAG, "NeuralTranslator -- identifyLanguageWithList() executed - fallbackLanguage: " + str);
        return this.neuralTranslationRunnableExecutor.executeLanguageIdentificationWithList(arrayList, str);
    }

    public void translate(@Nullable AppInfo appInfo, @NonNull NeuralTranslationRequest neuralTranslationRequest, @NonNull LlmTranslationRequest llmTranslationRequest) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed (with LLM request)");
        if (isLLMTranslationSupported(llmTranslationRequest, new Configuration(this.context))) {
            Log.m6489i(TAG, "NeuralTranslator -- llm translation supported, run llm translation");
            this.llmTranslator.translate(copyAppInfoWithOnDeviceType(appInfo), llmTranslationRequest.getInputTextList(), llmTranslationRequest.getFromLanguage(), llmTranslationRequest.getToLanguage()).addOnCompleteListener(new C3970a(new Handler(Looper.getMainLooper()), 1, llmTranslationRequest, neuralTranslationRequest));
        } else {
            Log.m6489i(TAG, "NeuralTranslator -- llm translation not supported, run neuralTranslation");
            llmTranslationRequest.deregistercallback();
            translate(appInfo, neuralTranslationRequest);
        }
    }

    @NonNull
    public Task<Map<LanguageDirection, LanguageDirectionState>> clear(String str) {
        Task<Map<LanguageDirection, LanguageDirectionState>> taskExecuteClearAndRefresh;
        Log.m6489i(TAG, "NeuralTranslator -- clear() executed - SourceId : " + str);
        if (Feature.checkFeature(this.context, "FEATURE_NEURAL_TRANSLATION_CLEAR_WITH_SOURCE_ID") == 0) {
            taskExecuteClearAndRefresh = this.neuralTranslationRunnableExecutor.executeClearWithSourceId(str);
        } else {
            taskExecuteClearAndRefresh = this.neuralTranslationRunnableExecutor.executeClearAndRefresh();
        }
        taskExecuteClearAndRefresh.addOnCompleteListener(new C7783f(this, 2));
        return taskExecuteClearAndRefresh;
    }

    @NonNull
    public Task<Void> translateByChunk(AppInfo appInfo, @NonNull NeuralTranslationRequest neuralTranslationRequest, int i) {
        Log.m6489i(TAG, "NeuralTranslator -- translateByChunk() executed - chunkBaseLen: " + i);
        if (Feature.checkFeature(this.context, "FEATURE_NEURAL_TRANSLATION_BY_CHUNK") == 0) {
            return this.neuralTranslationRunnableExecutor.executeTranslationByChunkRunnable(neuralTranslationRequest, appInfo, i);
        }
        Log.m6489i(TAG, "NeuralTranslator -- translate chunk not supported with service app");
        return this.neuralTranslationRunnableExecutor.executeTranslationRunnable(neuralTranslationRequest, appInfo);
    }

    @NonNull
    public Task<Result> translate(@NonNull AppInfo appInfo, @NonNull String str, @NonNull Locale locale, @NonNull Locale locale2) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed (server request)");
        return this.llmTranslator.interpret(appInfo, str, locale, locale2);
    }

    @NonNull
    public Task<Result> translate(@NonNull AppInfo appInfo, @NonNull String str, @NonNull Locale locale, @NonNull Locale locale2, @NonNull Map<String, String> map) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed (server request)");
        return this.llmTranslator.interpret(appInfo, str, locale, locale2, map);
    }

    @NonNull
    public Task<Result> translate(@NonNull AppInfo appInfo, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed (server request)");
        return this.llmTranslator.interpret(appInfo, str, str2, str3);
    }

    @NonNull
    public Task<Result> translate(@NonNull AppInfo appInfo, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Map<String, String> map) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed (server request)");
        return this.llmTranslator.interpret(appInfo, str, str2, str3, map);
    }

    @NonNull
    public Task<Void> translate(AppInfo appInfo, @NonNull NeuralTranslationRequest neuralTranslationRequest) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed");
        return this.neuralTranslationRunnableExecutor.executeTranslationRunnable(neuralTranslationRequest, appInfo);
    }

    @NonNull
    public Task<Void> translate(AppInfo appInfo, @NonNull NeuralTranslationRequest neuralTranslationRequest, @NonNull Bundle bundle) {
        Log.m6489i(TAG, "NeuralTranslator -- translate() executed");
        return this.neuralTranslationRunnableExecutor.executeTranslationRunnable(neuralTranslationRequest, bundle, appInfo);
    }
}
