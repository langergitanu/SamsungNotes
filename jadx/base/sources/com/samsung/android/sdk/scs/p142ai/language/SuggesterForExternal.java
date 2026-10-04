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
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.SuggestionRunnableForExternal;
import com.samsung.android.sdk.scs.p142ai.language.service.SuggestionServiceExecutorForExternal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SuggesterForExternal {
    private static final String TAG = "SuggesterForExternal";
    private final String featureName = "FEATURE_AI_GEN_SUGGESTION";
    private final SuggestionServiceExecutorForExternal mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SuggesterForExternal(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.mServiceExecutor = new SuggestionServiceExecutorForExternal(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$0(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_GEN_SUGGESTION", false, new C4191n(this, 11), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C7737b(this, 3));
    }

    public Task<Result> suggestion(AppInfo appInfo, @NonNull String str) {
        return suggestion(appInfo, str, new HashMap());
    }

    public Task<Result> suggestion(AppInfo appInfo, @NonNull String str, @NonNull Map<String, String> map) {
        SuggestionRunnableForExternal suggestionRunnableForExternal = new SuggestionRunnableForExternal(this.mServiceExecutor, appInfo.isStreamingMode() ? new TaskStreamingCompletionSource() : new TaskCompletionSource());
        Log.m6489i(TAG, "created: " + suggestionRunnableForExternal.hashCode());
        suggestionRunnableForExternal.setAppInfo(appInfo);
        suggestionRunnableForExternal.setInputText(str);
        suggestionRunnableForExternal.setExtraPrompt(map);
        this.mServiceExecutor.execute(suggestionRunnableForExternal);
        Log.m6489i(TAG, "executed: " + suggestionRunnableForExternal.hashCode());
        return suggestionRunnableForExternal.getTask();
    }
}
