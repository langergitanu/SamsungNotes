package com.samsung.android.sdk.scs.p142ai.language;

import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.language.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7739d implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5203a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Summarizer f5204b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ AppInfo f5205c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f5206d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ SummarizeLevel f5207e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ SummarizeSubTask f5208f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Map f5209g;

    public /* synthetic */ C7739d(Summarizer summarizer, AppInfo appInfo, String str, SummarizeLevel summarizeLevel, SummarizeSubTask summarizeSubTask, Map map, int i) {
        this.f5203a = i;
        this.f5204b = summarizer;
        this.f5205c = appInfo;
        this.f5206d = str;
        this.f5207e = summarizeLevel;
        this.f5208f = summarizeSubTask;
        this.f5209g = map;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5203a) {
            case 0:
                this.f5204b.lambda$getTokenCount$2(this.f5205c, this.f5206d, this.f5207e, this.f5208f, this.f5209g, (LlmServiceObserver2) obj);
                break;
            default:
                this.f5204b.lambda$summarize$0(this.f5205c, this.f5206d, this.f5207e, this.f5208f, this.f5209g, (LlmServiceObserver2) obj);
                break;
        }
    }
}
