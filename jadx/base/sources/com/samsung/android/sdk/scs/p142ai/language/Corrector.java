package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.CorrectionServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceServiceExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p017D1.C0061b;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Corrector {
    private static final String TAG = "Corrector";
    protected String featureName = "FEATURE_AI_GEN_CORRECTION";
    protected CorrectionServiceExecutor mServiceExecutor;
    private final OnDeviceServiceExecutor onDeviceServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Corrector(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.onDeviceServiceExecutor = new OnDeviceServiceExecutor(context);
        createExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$correct$0(AppInfo appInfo, String str, CorrectionSubTask correctionSubTask, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().correctWithHeader3(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, correctionSubTask.name(), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
        this.onDeviceServiceExecutor.deInit();
    }

    public Task<Result> correct(AppInfo appInfo, @NonNull String str, CorrectionSubTask correctionSubTask) {
        return correct(appInfo, str, correctionSubTask, new HashMap());
    }

    public void createExecutor(Context context) {
        this.mServiceExecutor = new CorrectionServiceExecutor(context);
        this.featureName = "FEATURE_AI_GEN_CORRECTION";
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, false, new C4191n(this, 5), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C0061b(this, 27));
    }

    @Deprecated
    public void unLoadOndeviceModel(AppInfo appInfo) {
        OnDeviceRunnable onDeviceRunnable = new OnDeviceRunnable(this.onDeviceServiceExecutor);
        onDeviceRunnable.setAppInfo(appInfo);
        this.onDeviceServiceExecutor.execute(onDeviceRunnable);
    }

    public Task<Result> correct(AppInfo appInfo, @NonNull String str, CorrectionSubTask correctionSubTask, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C7736a(this, appInfo, str, correctionSubTask, map, 0), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}
