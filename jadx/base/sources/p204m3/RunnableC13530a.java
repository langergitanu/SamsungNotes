package p204m3;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCopyTask;

/* JADX INFO: renamed from: m3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC13530a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9539a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiResultCopyTask f9540b;

    public /* synthetic */ RunnableC13530a(AiResultCopyTask aiResultCopyTask, int i) {
        this.f9539a = i;
        this.f9540b = aiResultCopyTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9539a) {
            case 0:
                AiResultCopyTask.runOnThread$lambda$1(this.f9540b);
                break;
            default:
                this.f9540b.runOnThread();
                break;
        }
    }
}
