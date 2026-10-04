package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormatStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarizationStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9463h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6882a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6883b;

    public /* synthetic */ RunnableC9463h(Object obj, int i) {
        this.f6882a = i;
        this.f6883b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6882a) {
            case 0:
                ((AutoFormatStreaming.MeetingFormatStreaming) this.f6883b).lambda$formatting$0();
                break;
            case 1:
                ((AutoFormatStreaming.NormalFormatStreaming) this.f6883b).lambda$formatting$0();
                break;
            case 2:
                ((STTSummarizationStreaming.SummarizeStreamingCallback) this.f6883b).lambda$new$2();
                break;
            case 3:
                ((Summarization.OnDeviceSummarizeCallbackNext) this.f6883b).lambda$onFailed$0();
                break;
            case 4:
                ((AutoFormatStreaming) this.f6883b).lambda$initStreamingCharManager$2();
                break;
            default:
                ((SummarizationStreaming) this.f6883b).lambda$initStreamingChar$2();
                break;
        }
    }
}
