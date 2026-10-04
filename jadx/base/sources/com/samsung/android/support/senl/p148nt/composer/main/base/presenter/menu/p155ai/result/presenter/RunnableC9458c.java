package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9458c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6870a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f6871b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6872c;

    public /* synthetic */ RunnableC9458c(int i, Object obj, boolean z) {
        this.f6870a = i;
        this.f6872c = obj;
        this.f6871b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6870a) {
            case 0:
                ((AutoFormat.AbsFormat) this.f6872c).lambda$onCompleted$0(this.f6871b);
                break;
            default:
                ((Summarization.SummarizeCallback) this.f6872c).lambda$onSuccess$0(this.f6871b);
                break;
        }
    }
}
