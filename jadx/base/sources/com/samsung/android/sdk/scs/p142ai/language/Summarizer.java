package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.SummarizationServiceExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Summarizer {
    private static final String TAG = "Summarizer";
    protected String featureName = "FEATURE_AI_GEN_SUMMARY";
    protected SummarizationServiceExecutor mServiceExecutor;
    private final OnDeviceServiceExecutor onDeviceServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Summarizer(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.onDeviceServiceExecutor = new OnDeviceServiceExecutor(context);
        createExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTokenCount$2(AppInfo appInfo, String str, SummarizeLevel summarizeLevel, SummarizeSubTask summarizeSubTask, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().getTokenCount(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, summarizeLevel.name(), summarizeSubTask.name(), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
        this.onDeviceServiceExecutor.deInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$summarize$0(AppInfo appInfo, String str, SummarizeLevel summarizeLevel, SummarizeSubTask summarizeSubTask, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().summarizeWithHeader3(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, "", "", summarizeLevel.name(), summarizeSubTask.name(), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$summarizeOnDevice$1(AppInfo appInfo, String str, SummaryOnDeviceType summaryOnDeviceType, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            if (Feature.checkFeature(this.mServiceExecutor.context, "FEATURE_AI_ONDEVICE_SUMMARY_EXTRA_PROMPT") == 0) {
                this.mServiceExecutor.getService().summarizeOnDeviceWithExtraPrompt(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, summaryOnDeviceType.getName(), llmServiceObserver2, map);
            } else {
                this.mServiceExecutor.getService().summarizeOnDevice(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, summaryOnDeviceType.getName(), llmServiceObserver2);
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void createExecutor(Context context) {
        this.mServiceExecutor = new SummarizationServiceExecutor(context);
        this.featureName = "FEATURE_AI_GEN_SUMMARY";
    }

    public Task<Result> getTokenCount(AppInfo appInfo, @NonNull String str, SummarizeLevel summarizeLevel, SummarizeSubTask summarizeSubTask) {
        return getTokenCount(appInfo, str, summarizeLevel, summarizeSubTask, new HashMap());
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, false, new C4191n(this, 12), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C7737b(this, 4));
    }

    public Task<Result> summarize(AppInfo appInfo, @NonNull String str, SummarizeLevel summarizeLevel, SummarizeSubTask summarizeSubTask) {
        return summarize(appInfo, str, summarizeLevel, summarizeSubTask, new HashMap());
    }

    @NonNull
    public Task<Result> summarizeOnDevice(@NonNull AppInfo appInfo, @NonNull String str, @NonNull SummaryOnDeviceType summaryOnDeviceType, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C7736a(this, appInfo, str, summaryOnDeviceType, map, 9), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    @Deprecated
    public void unLoadOndeviceModel(AppInfo appInfo) {
        OnDeviceRunnable onDeviceRunnable = new OnDeviceRunnable(this.onDeviceServiceExecutor);
        onDeviceRunnable.setAppInfo(appInfo);
        this.onDeviceServiceExecutor.execute(onDeviceRunnable);
    }

    public Task<Result> getTokenCount(AppInfo appInfo, @NonNull String str, SummarizeLevel summarizeLevel, SummarizeSubTask summarizeSubTask, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C7739d(this, appInfo, str, summarizeLevel, summarizeSubTask, map, 0), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> summarize(AppInfo appInfo, @NonNull String str, SummarizeLevel summarizeLevel, SummarizeSubTask summarizeSubTask, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C7739d(this, appInfo, str, summarizeLevel, summarizeSubTask, map, 1), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    @NonNull
    public Task<Result> summarizeOnDevice(@NonNull AppInfo appInfo, @NonNull String str, @NonNull SummaryOnDeviceType summaryOnDeviceType) {
        return summarizeOnDevice(appInfo, str, summaryOnDeviceType, new HashMap());
    }
}
