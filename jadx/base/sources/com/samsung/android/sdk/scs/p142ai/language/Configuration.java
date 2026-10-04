package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.opencsv.bean.C6631n;
import com.samsung.android.app.notes.sync.importing.core.types.C6776b;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.ConfigurationRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.ConfigurationServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Configuration {
    private static final String TAG = "Configuration";
    public static final String TASK_STRUCTURED_DATA_EXTRACTION = "structured_data_extraction";
    private final Context mContext;
    private final ConfigurationServiceExecutor mServiceExecutor;
    private final String PACKAGE_LANGUAGE_PACK = Features.OFFLINE_LANGUAGE_MODEL_APP_INFO;
    private final String METADATA_FUNCTION_INFO = Features.OFFLINE_LANGUAGE_MODEL_FUNC_INFO;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface OnDeviceLlmTaskName {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Configuration(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.mContext = context;
        this.mServiceExecutor = new ConfigurationServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getModelInfo$0(AppInfo appInfo, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().getModelInfo(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prewarmLlm$1(AppInfo appInfo, String str, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().prewarmLlm(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Task<String> getConfig(AppInfo appInfo) {
        ConfigurationRunnable configurationRunnable = new ConfigurationRunnable(this.mServiceExecutor);
        configurationRunnable.setAppInfo(appInfo);
        configurationRunnable.setType(ConfigurationRunnable.ConfigType.APP);
        this.mServiceExecutor.execute(configurationRunnable);
        return configurationRunnable.getTask();
    }

    public Task<String> getLlmSupportLanguage(AppInfo appInfo) {
        ConfigurationRunnable configurationRunnable = new ConfigurationRunnable(this.mServiceExecutor);
        configurationRunnable.setAppInfo(appInfo);
        configurationRunnable.setType(ConfigurationRunnable.ConfigType.LLM);
        this.mServiceExecutor.execute(configurationRunnable);
        return configurationRunnable.getTask();
    }

    public Task<Result> getModelInfo(@NonNull AppInfo appInfo) {
        return getModelInfo(appInfo, new HashMap());
    }

    public String getOndeviceCapability() {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(Features.OFFLINE_LANGUAGE_MODEL_APP_INFO, 128);
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(Features.OFFLINE_LANGUAGE_MODEL_FUNC_INFO);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.m6487e(TAG, "language pack is not installed");
            return "";
        }
    }

    @NonNull
    public Task<String> getOndeviceSafetyCheck(@NonNull String str) {
        ConfigurationRunnable configurationRunnable = new ConfigurationRunnable(this.mServiceExecutor);
        configurationRunnable.setAppInfo(new AppInfo.Builder().setRequestType(AppInfo.RequestType.ONDEVICE).build());
        configurationRunnable.setType(ConfigurationRunnable.ConfigType.SAFE);
        configurationRunnable.setInputText(str);
        this.mServiceExecutor.execute(configurationRunnable);
        return configurationRunnable.getTask();
    }

    public Task<String> getTranslateSupportLanguage() {
        ConfigurationRunnable configurationRunnable = new ConfigurationRunnable(this.mServiceExecutor);
        configurationRunnable.setType(ConfigurationRunnable.ConfigType.LPD);
        this.mServiceExecutor.execute(configurationRunnable);
        return configurationRunnable.getTask();
    }

    @NonNull
    public Task<Result> prewarmLlm(@NonNull AppInfo appInfo, @NonNull @OnDeviceLlmTaskName String str) {
        return prewarmLlm(appInfo, str, new HashMap());
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
    }

    public Task<Result> getModelInfo(@NonNull AppInfo appInfo, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_ONDEVICE_LLM_PREWARM", false, new C6631n(this, 3, appInfo, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    @NonNull
    public Task<Result> prewarmLlm(@NonNull AppInfo appInfo, @NonNull @OnDeviceLlmTaskName String str, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_ONDEVICE_LLM_PREWARM", false, new C6776b(3, this, appInfo, str, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}
