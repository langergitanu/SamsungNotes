package com.samsung.android.sdk.scs.p142ai.language.service;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
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
public class ConfigurationRunnable extends TaskRunnable<String> {
    private static final String TAG = "ConfigurationRunnable";
    Map<String, String> authHeader = new HashMap();
    private ConfigType configType;
    private String inputText;
    ConfigurationServiceExecutor mServiceExecutor;

    /* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.language.service.ConfigurationRunnable$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C77433 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$scs$ai$language$service$ConfigurationRunnable$ConfigType */
        static final /* synthetic */ int[] f5210xc0ceff9;

        static {
            int[] iArr = new int[ConfigType.values().length];
            f5210xc0ceff9 = iArr;
            try {
                iArr[ConfigType.LLM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5210xc0ceff9[ConfigType.LPD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5210xc0ceff9[ConfigType.SAFE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5210xc0ceff9[ConfigType.APP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ConfigType {
        APP,
        LPD,
        LLM,
        SAFE
    }

    public ConfigurationRunnable(@NonNull ConfigurationServiceExecutor configurationServiceExecutor) {
        this.mServiceExecutor = configurationServiceExecutor;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            LlmServiceObserver llmServiceObserver = new LlmServiceObserver() { // from class: com.samsung.android.sdk.scs.ai.language.service.ConfigurationRunnable.1
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onError(Bundle bundle) {
                    if (bundle == null) {
                        Log.m6487e(ConfigurationRunnable.TAG, "onError= error is null");
                        AbstractC6670b.m4749j(5, "error is null", ((TaskRunnable) ConfigurationRunnable.this).mSource);
                        return;
                    }
                    Log.m6487e(ConfigurationRunnable.TAG, "onError= " + bundle.getInt("error_code") + bundle.getString("error_message"));
                    ((TaskRunnable) ConfigurationRunnable.this).mSource.setException(new ResultErrorException(500, bundle.getInt("error_code"), bundle.getString("error_message")));
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onNext(String str) {
                    ((TaskRunnable) ConfigurationRunnable.this).mSource.setResult(str);
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onComplete() {
                }
            };
            LlmServiceObserver2 llmServiceObserver2 = new LlmServiceObserver2() { // from class: com.samsung.android.sdk.scs.ai.language.service.ConfigurationRunnable.2
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onError(Bundle bundle) {
                    if (bundle == null) {
                        Log.m6487e(ConfigurationRunnable.TAG, "onError= error is null");
                        AbstractC6670b.m4749j(5, "error is null", ((TaskRunnable) ConfigurationRunnable.this).mSource);
                        return;
                    }
                    Log.m6487e(ConfigurationRunnable.TAG, "onError= " + bundle.getInt("error_code") + bundle.getString("error_message"));
                    ((TaskRunnable) ConfigurationRunnable.this).mSource.setException(new ResultErrorException(500, bundle.getInt("error_code"), bundle.getString("error_message")));
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onNext(List<Bundle> list) {
                    ((TaskRunnable) ConfigurationRunnable.this).mSource.setResult(new Result(list.get(0)).getSafetyAttribute());
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
                public void onComplete() {
                }
            };
            int i = C77433.f5210xc0ceff9[this.configType.ordinal()];
            if (i == 1) {
                this.mServiceExecutor.getService().getLlmSupportLanguage(this.authHeader, llmServiceObserver);
                return;
            }
            if (i == 2) {
                this.mServiceExecutor.getService().getTranslateSupportLanguage(this.authHeader, llmServiceObserver);
            } else if (i != 3) {
                this.mServiceExecutor.getService().getConfig(this.authHeader, llmServiceObserver);
            } else {
                this.mServiceExecutor.getService().getOndeviceSafetyCheck(this.authHeader, this.inputText, llmServiceObserver2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_SIVS_CONFIGURATION";
    }

    public void setAppInfo(AppInfo appInfo) {
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context);
    }

    public void setInputText(String str) {
        this.inputText = str;
    }

    public void setType(ConfigType configType) {
        this.configType = configType;
    }
}
