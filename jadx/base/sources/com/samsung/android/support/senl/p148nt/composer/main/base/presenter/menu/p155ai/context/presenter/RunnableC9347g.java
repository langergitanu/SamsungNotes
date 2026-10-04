package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiDrawingManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.STTPresenterImpl;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9347g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6818a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6819b;

    public /* synthetic */ RunnableC9347g(Object obj, int i) {
        this.f6818a = i;
        this.f6819b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6818a) {
            case 0:
                ((AiDrawingManager.C93292) this.f6819b).lambda$onPositionUpdated$0();
                break;
            default:
                ((STTPresenterImpl) this.f6819b).executeTranscribeDialog();
                break;
        }
    }
}
