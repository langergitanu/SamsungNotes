package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.tasks.TaskCompletionSource;
import com.samsung.android.sdk.scs.base.tasks.TaskStreamingCompletionSource;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.TranslationRunnable2;
import com.samsung.android.sdk.scs.p142ai.language.service.TranslationServiceExecutor;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Translator {
    private static final String TAG = "Translator";
    private final TranslationServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Translator(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.mServiceExecutor = new TranslationServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$interpret$0(AppInfo appInfo, String str, String str2, String str3, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().interpret(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, str2, str3, llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Task<String> identifyLanguage(@NonNull String str) {
        Log.m6489i(TAG, "identifyLanguage: " + str);
        return AiServices.getNeuralTranslator(this.mServiceExecutor.context).identifyLanguage(str);
    }

    @NonNull
    public Task<Result> interpret(@NonNull AppInfo appInfo, @NonNull String str, @NonNull Locale locale, @NonNull Locale locale2) {
        return interpret(appInfo, str, locale.toLanguageTag(), locale2.toLanguageTag(), new HashMap());
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
    }

    public Task<List<Result>> translate(AppInfo appInfo, @NonNull List<String> list, Locale locale, Locale locale2) {
        return translate(appInfo, list, locale.toLanguageTag(), locale2.toLanguageTag());
    }

    @NonNull
    public Task<Result> interpret(@NonNull AppInfo appInfo, @NonNull String str, @NonNull Locale locale, @NonNull Locale locale2, @NonNull Map<String, String> map) {
        return interpret(appInfo, str, locale.toLanguageTag(), locale2.toLanguageTag(), map);
    }

    public Task<List<Result>> translate(AppInfo appInfo, @NonNull List<String> list, String str, String str2) {
        return translate(appInfo, list, str, str2, null);
    }

    @NonNull
    public Task<Result> interpret(@NonNull AppInfo appInfo, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        return interpret(appInfo, str, str2, str3, new HashMap());
    }

    public Task<List<Result>> translate(AppInfo appInfo, @NonNull List<String> list, String str, String str2, Map<String, String> map) {
        TranslationRunnable2 translationRunnable2 = new TranslationRunnable2(this.mServiceExecutor, appInfo.isStreamingMode() ? new TaskStreamingCompletionSource() : new TaskCompletionSource());
        Log.m6489i(TAG, "created: " + translationRunnable2.hashCode());
        translationRunnable2.setAppInfo(appInfo);
        translationRunnable2.setInputText(list);
        translationRunnable2.setFromLanguage(str);
        translationRunnable2.setToLanguage(str2);
        if (map != null) {
            translationRunnable2.setExtraPrompt(map);
        }
        this.mServiceExecutor.execute(translationRunnable2);
        Log.m6489i(TAG, "executed: " + translationRunnable2.hashCode());
        return translationRunnable2.getTask();
    }

    @NonNull
    public Task<Result> interpret(@NonNull AppInfo appInfo, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_CLOUD_LLM_INTERPRETATION", appInfo.isStreamingMode(), new C7738c(this, appInfo, str, str2, str3, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}
