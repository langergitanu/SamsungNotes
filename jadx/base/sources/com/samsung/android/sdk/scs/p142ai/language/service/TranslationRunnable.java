package com.samsung.android.sdk.scs.p142ai.language.service;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.ResultErrorException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TranslationRunnable extends TaskRunnable<String> {
    private static final String TAG = "TranslationRunnable";
    Map<String, String> authHeader;
    String fromLanguage;
    String inputText;
    TranslationServiceExecutor mServiceExecutor;
    String toLanguage;

    public TranslationRunnable(@NonNull TranslationServiceExecutor translationServiceExecutor) {
        this.mServiceExecutor = translationServiceExecutor;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            this.mServiceExecutor.getService().translateWithHeader(this.authHeader, this.inputText, this.fromLanguage, this.toLanguage, new LlmServiceObserver() { // from class: com.samsung.android.sdk.scs.ai.language.service.TranslationRunnable.1
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onError(Bundle bundle) {
                    if (bundle == null) {
                        Log.m6487e(TranslationRunnable.TAG, "onError= error is null");
                        AbstractC6670b.m4749j(5, "error is null", ((TaskRunnable) TranslationRunnable.this).mSource);
                        return;
                    }
                    Log.m6487e(TranslationRunnable.TAG, "onError= " + bundle.getInt("error_code") + bundle.getString("error_message"));
                    ((TaskRunnable) TranslationRunnable.this).mSource.setException(new ResultErrorException(500, bundle.getInt("error_code"), bundle.getString("error_message")));
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onNext(String str) {
                    ((TaskRunnable) TranslationRunnable.this).mSource.setResult(str);
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onComplete() {
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_AI_GEN_TRANSLATION";
    }

    public void setAppInfo(AppInfo appInfo) {
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context);
    }

    public void setFromLanguage(String str) {
        this.fromLanguage = str;
    }

    public void setInputText(String str) {
        this.inputText = str;
    }

    public void setToLanguage(String str) {
        this.toLanguage = str;
    }
}
