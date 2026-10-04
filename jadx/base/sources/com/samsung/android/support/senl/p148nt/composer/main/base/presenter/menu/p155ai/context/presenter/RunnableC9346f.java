package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiDrawingManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9346f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6816a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiDrawingManager.C93281 f6817b;

    public /* synthetic */ RunnableC9346f(AiDrawingManager.C93281 c93281, int i) {
        this.f6816a = i;
        this.f6817b = c93281;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6816a) {
            case 0:
                this.f6817b.lambda$notifyComposerViewTouchEnd$1();
                break;
            default:
                this.f6817b.lambda$executeCreateImage$0();
                break;
        }
    }
}
