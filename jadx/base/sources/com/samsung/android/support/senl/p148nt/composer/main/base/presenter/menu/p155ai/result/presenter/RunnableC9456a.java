package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarizationStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SummarizationStreaming;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9456a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6863a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f6864b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6865c;

    public /* synthetic */ RunnableC9456a(int i, Object obj, String str) {
        this.f6863a = i;
        this.f6865c = obj;
        this.f6864b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6863a) {
            case 0:
                ((AutoFormat.AbsFormat) this.f6865c).lambda$onFailed$1(this.f6864b);
                break;
            case 1:
                ((STTSummarization.SummarizeCallback) this.f6865c).lambda$onFailed$1(this.f6864b);
                break;
            case 2:
                ((STTSummarizationStreaming.SummarizeStreamingCallback) this.f6865c).lambda$onFailed$4(this.f6864b);
                break;
            case 3:
                ((Summarization.SummarizeCallback) this.f6865c).lambda$onFailed$1(this.f6864b);
                break;
            case 4:
                ((SummarizationStreaming.CallbackStreamingImpl) this.f6865c).lambda$onFailed$0(this.f6864b);
                break;
            case 5:
                ((AutoFormatStreaming) this.f6865c).lambda$initStreamingCharManager$0(this.f6864b);
                break;
            default:
                ((SummarizationStreaming) this.f6865c).lambda$initStreamingChar$0(this.f6864b);
                break;
        }
    }
}
