package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarizationStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.StreamingSummaryParser;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9466k implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6886a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6887b;

    public /* synthetic */ C9466k(Object obj, int i) {
        this.f6886a = i;
        this.f6887b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6886a) {
            case 0:
                ((STTSummarizationStreaming.SummarizeStreamingCallback) this.f6887b).lambda$new$0((StreamingSummaryParser) obj);
                break;
            case 1:
                ((STTSummarizationStreaming.SummarizeStreamingCallback) this.f6887b).lambda$new$3((Void) obj);
                break;
            default:
                ((SpellingCorrectionStreaming) this.f6887b).lambda$initStreamingChar$4((Void) obj);
                break;
        }
    }
}
