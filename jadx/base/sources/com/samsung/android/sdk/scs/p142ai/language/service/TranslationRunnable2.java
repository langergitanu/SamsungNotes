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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TranslationRunnable2 extends TaskRunnable<List<Result>> {
    private static final String TAG = "TranslationRunnable2";
    Map<String, String> authHeader;
    private final Map<String, String> extraPrompt;
    String fromLanguage;
    List<String> inputTextList;
    TranslationServiceExecutor mServiceExecutor;
    String toLanguage;

    public TranslationRunnable2(@NonNull TranslationServiceExecutor translationServiceExecutor, TaskCompletionSource<List<Result>> taskCompletionSource) {
        super(taskCompletionSource);
        this.extraPrompt = new HashMap();
        this.mServiceExecutor = translationServiceExecutor;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            this.mServiceExecutor.getService().translateWithHeader2(this.authHeader, this.inputTextList, this.fromLanguage, this.toLanguage, new LlmServiceObserver2() { // from class: com.samsung.android.sdk.scs.ai.language.service.TranslationRunnable2.1
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onComplete() {
                    Log.m6485d(TranslationRunnable2.TAG, "onComplete()");
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onError(Bundle bundle) {
                    if (bundle == null) {
                        Log.m6487e(TranslationRunnable2.TAG, "onError= error is null");
                        AbstractC6670b.m4749j(5, "error is null", ((TaskRunnable) TranslationRunnable2.this).mSource);
                        return;
                    }
                    Log.m6487e(TranslationRunnable2.TAG, "onError= " + bundle.getInt("error_code") + bundle.getString("error_message"));
                    ((TaskRunnable) TranslationRunnable2.this).mSource.setException(new ResultErrorException(500, bundle.getInt("error_code"), bundle.getString("error_message")));
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onNext(List<Bundle> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Result(it.next()));
                    }
                    ((TaskRunnable) TranslationRunnable2.this).mSource.setResult(arrayList);
                }
            }, this.extraPrompt);
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return AppInfo.RequestType.ONDEVICE.name().equals(this.authHeader.get("request-type")) ? "FEATURE_AI_GEN_TRANSLATION_ONDEVICE" : "FEATURE_AI_GEN_TRANSLATION";
    }

    public void setAppInfo(AppInfo appInfo) {
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context);
    }

    public void setExtraPrompt(Map<String, String> map) {
        this.extraPrompt.putAll(map);
    }

    public void setFromLanguage(String str) {
        this.fromLanguage = str;
    }

    public void setInputText(List<String> list) {
        this.inputTextList = new ArrayList(list);
    }

    public void setToLanguage(String str) {
        this.toLanguage = str;
    }
}
