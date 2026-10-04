package com.samsung.android.sdk.scs.p142ai.extension.lts;

import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.extension.lts.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7731b implements OnCompleteListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5183a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LongTextSummarizer f5184b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ CompletableFuture f5185c;

    public /* synthetic */ C7731b(LongTextSummarizer longTextSummarizer, CompletableFuture completableFuture, int i) {
        this.f5183a = i;
        this.f5184b = longTextSummarizer;
        this.f5185c = completableFuture;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f5183a) {
            case 0:
                this.f5184b.lambda$process$0(this.f5185c, task);
                break;
            case 1:
                this.f5184b.lambda$process$1(this.f5185c, task);
                break;
            default:
                this.f5184b.lambda$summarize$4(this.f5185c, task);
                break;
        }
    }
}
