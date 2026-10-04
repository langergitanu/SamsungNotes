package com.samsung.android.sdk.scs.p142ai.language.service;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.tasks.TaskCompletionSource;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.sdk.scs.p142ai.language.ResultErrorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class SuggestionRunnableForExternal extends TaskRunnable<Result> {
    private static final String TAG = "SuggestionRunnableForExternal";
    Map<String, String> authHeader;
    private final Map<String, String> extraPrompt;
    String inputText;
    SuggestionServiceExecutorForExternal mServiceExecutor;

    public SuggestionRunnableForExternal(@NonNull SuggestionServiceExecutorForExternal suggestionServiceExecutorForExternal, TaskCompletionSource<Result> taskCompletionSource) {
        super(taskCompletionSource);
        this.extraPrompt = new HashMap();
        this.mServiceExecutor = suggestionServiceExecutorForExternal;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            this.mServiceExecutor.getService().suggestionWithHeaderForExternal(this.authHeader, this.inputText, new LlmServiceObserver2() { // from class: com.samsung.android.sdk.scs.ai.language.service.SuggestionRunnableForExternal.1
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onError(Bundle bundle) {
                    if (bundle == null) {
                        Log.m6487e(SuggestionRunnableForExternal.TAG, "onError= error is null");
                        AbstractC6670b.m4749j(5, "error is null", ((TaskRunnable) SuggestionRunnableForExternal.this).mSource);
                        return;
                    }
                    Log.m6487e(SuggestionRunnableForExternal.TAG, "onError= " + bundle.getInt("error_code") + bundle.getString("error_message"));
                    ((TaskRunnable) SuggestionRunnableForExternal.this).mSource.setException(new ResultErrorException(500, bundle.getInt("error_code"), bundle.getString("error_message")));
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onNext(List<Bundle> list) {
                    ((TaskRunnable) SuggestionRunnableForExternal.this).mSource.setResult(new Result(list.get(0)));
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onComplete() {
                }
            }, this.extraPrompt);
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_AI_GEN_SUGGESTION";
    }

    public void setAppInfo(AppInfo appInfo) {
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context);
    }

    public void setExtraPrompt(Map<String, String> map) {
        this.extraPrompt.putAll(map);
    }

    public void setInputText(String str) {
        this.inputText = str;
    }
}
