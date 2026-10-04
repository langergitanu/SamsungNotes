package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.ToneConvertServiceExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ToneConverter {
    private static final String TAG = "ToneConverter";
    protected String featureName = "FEATURE_AI_GEN_TONE";
    protected ToneConvertServiceExecutor mServiceExecutor;
    private final OnDeviceServiceExecutor onDeviceServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ToneConverter(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.onDeviceServiceExecutor = new OnDeviceServiceExecutor(context);
        createExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
        this.onDeviceServiceExecutor.deInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toneConvert$0(AppInfo appInfo, String str, ToneType toneType, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().toneConverterWithHeader3(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, toneType.name(), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toneConvert$1(AppInfo appInfo, String str, String str2, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().toneConvertDynamicStyle(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, str2, llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void createExecutor(Context context) {
        this.mServiceExecutor = new ToneConvertServiceExecutor(context);
        this.featureName = "FEATURE_AI_GEN_TONE";
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, false, new C4191n(this, 13), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C7737b(this, 5));
    }

    public Task<Result> toneConvert(AppInfo appInfo, @NonNull String str, ToneType toneType) {
        return toneConvert(appInfo, str, toneType, new HashMap());
    }

    @Deprecated
    public void unLoadOndeviceModel(AppInfo appInfo) {
        OnDeviceRunnable onDeviceRunnable = new OnDeviceRunnable(this.onDeviceServiceExecutor);
        onDeviceRunnable.setAppInfo(appInfo);
        this.onDeviceServiceExecutor.execute(onDeviceRunnable);
    }

    public Task<Result> toneConvert(AppInfo appInfo, @NonNull String str, ToneType toneType, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C7736a(this, appInfo, str, toneType, map, 10), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> toneConvert(AppInfo appInfo, @NonNull String str, @NonNull String str2) {
        return toneConvert(appInfo, str, str2, new HashMap());
    }

    public Task<Result> toneConvert(AppInfo appInfo, @NonNull String str, @NonNull String str2, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C7736a(this, appInfo, str, str2, map, 11), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}
