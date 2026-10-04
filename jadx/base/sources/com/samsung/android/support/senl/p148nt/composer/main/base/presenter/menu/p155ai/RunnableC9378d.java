package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9378d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6834a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6835b;

    public /* synthetic */ RunnableC9378d(Object obj, int i) {
        this.f6834a = i;
        this.f6835b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6834a) {
            case 0:
                ((AiMenuManager.C92661) this.f6835b).lambda$onFinished$0();
                break;
            default:
                ((AiMenuManager) this.f6835b).lambda$runAiAssistByBixby$2();
                break;
        }
    }
}
