package p209n4;

import com.samsung.android.support.senl.p148nt.stt.controller.STTFloatingController;

/* JADX INFO: renamed from: n4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class RunnableC13543a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9594a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ STTFloatingController f9595b;

    public /* synthetic */ RunnableC13543a(STTFloatingController sTTFloatingController, int i) {
        this.f9594a = i;
        this.f9595b = sTTFloatingController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9594a) {
            case 0:
                STTFloatingController.hideContainer$lambda$1(this.f9595b);
                break;
            default:
                STTFloatingController.showContainer$lambda$0(this.f9595b);
                break;
        }
    }
}
