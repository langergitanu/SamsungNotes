package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarizationStreaming;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9467l implements STTUpdateDataTask.Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6888a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ STTSummarizationStreaming.SummarizeStreamingCallback f6889b;

    public /* synthetic */ C9467l(STTSummarizationStreaming.SummarizeStreamingCallback summarizeStreamingCallback, int i) {
        this.f6888a = i;
        this.f6889b = summarizeStreamingCallback;
    }

    @Override // com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask.Callback
    public final void onFinished(boolean z) {
        switch (this.f6888a) {
            case 0:
                this.f6889b.lambda$new$1(z);
                break;
            default:
                this.f6889b.lambda$onFailed$5(z);
                break;
        }
    }
}
