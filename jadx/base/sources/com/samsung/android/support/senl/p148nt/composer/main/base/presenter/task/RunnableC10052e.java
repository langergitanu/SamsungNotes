package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10052e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7098a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SingleThreadTask f7099b;

    public /* synthetic */ RunnableC10052e(SingleThreadTask singleThreadTask, int i) {
        this.f7098a = i;
        this.f7099b = singleThreadTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7098a) {
            case 0:
                ((TaskWebClip) this.f7099b).lambda$pauseMediaPlayer$3();
                break;
            case 1:
                ((TaskWebClip) this.f7099b).lambda$loadFinish$4();
                break;
            default:
                TaskLoadDynamicTemplate.executeTask$lambda$1$lambda$0((TaskLoadDynamicTemplate) this.f7099b);
                break;
        }
    }
}
