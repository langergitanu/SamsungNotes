package com.samsung.android.sdk.scs.p142ai.language.service;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.ResultErrorException;
import com.samsung.android.sdk.scs.p142ai.language.data.LlmCloudUsage;
import com.samsung.android.sdk.scs.p142ai.language.data.LlmCloudUsageItem;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IUsageService;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J.\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/language/service/LlmCloudUsageRequestRunnable;", "Lcom/samsung/android/sdk/scs/base/tasks/TaskRunnable;", "Lcom/samsung/android/sdk/scs/ai/language/data/LlmCloudUsage;", "serviceExecutor", "Lcom/samsung/android/sdk/scs/ai/language/service/LlmCloudUsageRequestExecutor;", "<init>", "(Lcom/samsung/android/sdk/scs/ai/language/service/LlmCloudUsageRequestExecutor;)V", "getServiceExecutor", "()Lcom/samsung/android/sdk/scs/ai/language/service/LlmCloudUsageRequestExecutor;", "authHeader", "", "", "getAuthHeader", "()Ljava/util/Map;", "setAuthHeader", "(Ljava/util/Map;)V", ClientCookie.DOMAIN_ATTR, "packageName", "yyyymmddStart", "", "yyyymmddEnd", "getFeatureName", "execute", "", "parseUsageData", "result", "setParams", "appInfo", "Lcom/samsung/android/sdk/scs/ai/language/AppInfo;", "setAppInfo", "setDomain", "setPackageName", "setYyyymmddStart", "setYyyymmddEnd", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LlmCloudUsageRequestRunnable extends TaskRunnable<LlmCloudUsage> {

    @NotNull
    public static final String TAG = "UsageRunnable";

    @NotNull
    private Map<String, String> authHeader;

    @NotNull
    private String domain;

    @NotNull
    private String packageName;

    @NotNull
    private final LlmCloudUsageRequestExecutor serviceExecutor;
    private int yyyymmddEnd;
    private int yyyymmddStart;

    public LlmCloudUsageRequestRunnable(@NotNull LlmCloudUsageRequestExecutor serviceExecutor) {
        Intrinsics.checkNotNullParameter(serviceExecutor, "serviceExecutor");
        this.serviceExecutor = serviceExecutor;
        this.authHeader = MapsKt.emptyMap();
        this.domain = "";
        this.packageName = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LlmCloudUsage parseUsageData(String result) throws JSONException {
        JSONObject jSONObject = new JSONObject(result);
        long j = jSONObject.getLong("remainingUsage");
        JSONArray jSONArray = jSONObject.getJSONArray("usage");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getJSONObject(i).getString("packageName");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = jSONArray.getJSONObject(i).getString(ClientCookie.DOMAIN_ATTR);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            arrayList.add(new LlmCloudUsageItem(string, string2, jSONArray.getJSONObject(i).getLong("usedUsage")));
        }
        return new LlmCloudUsage(j, arrayList);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            LlmServiceObserver llmServiceObserver = new LlmServiceObserver() { // from class: com.samsung.android.sdk.scs.ai.language.service.LlmCloudUsageRequestRunnable$execute$observer$1
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onError(Bundle error) {
                    if (error != null) {
                        AbstractC2322a.m1632v(error.getInt("error_code"), "onError= ", error.getString("error_message"), LlmCloudUsageRequestRunnable.TAG);
                        ((TaskRunnable) this.this$0).mSource.setException(new ResultErrorException(500, error.getInt("error_code"), error.getString("error_message")));
                    } else {
                        Log.e(LlmCloudUsageRequestRunnable.TAG, "onError= error is null");
                        AbstractC6670b.m4749j(5, "error is null", ((TaskRunnable) this.this$0).mSource);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onNext(String result) throws JSONException {
                    if (result != null) {
                        LlmCloudUsageRequestRunnable llmCloudUsageRequestRunnable = this.this$0;
                        ((TaskRunnable) llmCloudUsageRequestRunnable).mSource.setResult(llmCloudUsageRequestRunnable.parseUsageData(result));
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver
                public void onComplete() {
                }
            };
            IUsageService service = this.serviceExecutor.getService();
            if (service != null) {
                service.usageWithHeader(this.authHeader, this.domain, this.packageName, this.yyyymmddStart, this.yyyymmddEnd, llmServiceObserver);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @NotNull
    public final Map<String, String> getAuthHeader() {
        return this.authHeader;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    @NotNull
    public String getFeatureName() {
        return "FEATURE_AI_GEN_USAGE";
    }

    @NotNull
    public final LlmCloudUsageRequestExecutor getServiceExecutor() {
        return this.serviceExecutor;
    }

    public final void setAppInfo(@NotNull AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.serviceExecutor.getContext());
    }

    public final void setAuthHeader(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.authHeader = map;
    }

    public final void setDomain(@NotNull String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.domain = domain;
    }

    public final void setPackageName(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
    }

    public final void setParams(@NotNull AppInfo appInfo, @NotNull String domain, @NotNull String packageName, int yyyymmddStart, int yyyymmddEnd) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.serviceExecutor.getContext());
        this.domain = domain;
        this.packageName = packageName;
        this.yyyymmddStart = yyyymmddStart;
        this.yyyymmddEnd = yyyymmddEnd;
    }

    public final void setYyyymmddEnd(int yyyymmddEnd) {
        this.yyyymmddEnd = yyyymmddEnd;
    }

    public final void setYyyymmddStart(int yyyymmddStart) {
        this.yyyymmddStart = yyyymmddStart;
    }
}
