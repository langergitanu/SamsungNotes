package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.data.LlmCloudUsage;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmCloudUsageRequestExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmCloudUsageRequestRunnable;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/language/LlmCloudUsageRequest;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "serviceExecutor", "Lcom/samsung/android/sdk/scs/ai/language/service/LlmCloudUsageRequestExecutor;", "requestUsage", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "Lcom/samsung/android/sdk/scs/ai/language/data/LlmCloudUsage;", "appInfo", "Lcom/samsung/android/sdk/scs/ai/language/AppInfo;", ClientCookie.DOMAIN_ATTR, "", "packageName", "yyyymmddStart", "", "yyyymmddEnd", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LlmCloudUsageRequest {

    @NotNull
    public static final String TAG = "Usage";

    @NotNull
    private final Context context;

    @NotNull
    private LlmCloudUsageRequestExecutor serviceExecutor;

    public LlmCloudUsageRequest(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.serviceExecutor = new LlmCloudUsageRequestExecutor(context);
        Log.d(TAG, TAG);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Task<LlmCloudUsage> requestUsage(@NotNull AppInfo appInfo, @NotNull String domain, @NotNull String packageName, int yyyymmddStart, int yyyymmddEnd) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        LlmCloudUsageRequestRunnable llmCloudUsageRequestRunnable = new LlmCloudUsageRequestRunnable(this.serviceExecutor);
        llmCloudUsageRequestRunnable.setAppInfo(appInfo);
        llmCloudUsageRequestRunnable.setDomain(domain);
        llmCloudUsageRequestRunnable.setPackageName(packageName);
        llmCloudUsageRequestRunnable.setYyyymmddStart(yyyymmddStart);
        llmCloudUsageRequestRunnable.setYyyymmddEnd(yyyymmddEnd);
        this.serviceExecutor.execute(llmCloudUsageRequestRunnable);
        Task<LlmCloudUsage> task = llmCloudUsageRequestRunnable.getTask();
        Intrinsics.checkNotNullExpressionValue(task, "getTask(...)");
        return task;
    }
}
