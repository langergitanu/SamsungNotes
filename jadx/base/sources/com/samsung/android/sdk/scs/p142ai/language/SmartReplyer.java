package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.opencsv.bean.C6631n;
import com.samsung.android.app.notes.sync.importing.core.types.C6776b;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.SmartReplyServiceExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SmartReplyer {
    private static final String TAG = "SmartReplyer";
    protected String featureName = "FEATURE_AI_GEN_SMART_REPLY";
    protected SmartReplyServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SmartReplyer(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        createExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$identifyLanguage$2(AppInfo appInfo, String str, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().identifyLanguage(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, llmServiceObserver2);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smartReply$0(AppInfo appInfo, String str, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().replyWithHeader3(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smartReply$1(AppInfo appInfo, String str, SmartReplyCategory smartReplyCategory, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().replyWithCategory(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, smartReplyCategory.getName(), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void createExecutor(Context context) {
        this.mServiceExecutor = new SmartReplyServiceExecutor(context);
        this.featureName = "FEATURE_AI_GEN_SMART_REPLY";
    }

    public Task<Result> identifyLanguage(@NonNull AppInfo appInfo, @NonNull String str) {
        Log.m6489i(TAG, "identifyLanguage: " + str);
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C6631n(this, 4, appInfo, str), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, false, new C4191n(this, 9), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C7737b(this, 1));
    }

    public Task<List<Result>> smartReply(@NonNull AppInfo appInfo, @NonNull String str) {
        return smartReply(appInfo, str, new HashMap());
    }

    public Task<List<Result>> smartReply(@NonNull AppInfo appInfo, @NonNull String str, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C6776b(6, this, appInfo, str, map), new C4662f(16));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<List<Result>> smartReply(@NonNull AppInfo appInfo, @NonNull String str, @NonNull SmartReplyCategory smartReplyCategory) {
        return smartReply(appInfo, str, smartReplyCategory, new HashMap());
    }

    public Task<List<Result>> smartReply(@NonNull AppInfo appInfo, @NonNull String str, @NonNull SmartReplyCategory smartReplyCategory, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(this.featureName, appInfo.isStreamingMode(), new C7736a(this, appInfo, str, smartReplyCategory, map, 7), new C4662f(16));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}
