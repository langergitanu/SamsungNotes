package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization;
import com.samsung.android.support.senl.p148nt.model.assist.lvm.ImageMaker;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9465j implements STTUpdateDataTask.Callback, ImageMaker.Contract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6884a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6885b;

    public /* synthetic */ C9465j(Object obj, int i) {
        this.f6884a = i;
        this.f6885b = obj;
    }

    @Override // com.samsung.android.support.senl.nt.model.assist.lvm.ImageMaker.Contract
    public int getDocumentWidth() {
        return ((CreateImage) this.f6885b).lambda$initImageMaker$0();
    }

    @Override // com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask.Callback
    public void onFinished(boolean z) {
        switch (this.f6884a) {
            case 0:
                ((STTSummarization.SummarizeCallback) this.f6885b).lambda$onFailed$2(z);
                break;
            default:
                ((STTSummarization.SummarizeCallback) this.f6885b).lambda$onSuccess$0(z);
                break;
        }
    }
}
