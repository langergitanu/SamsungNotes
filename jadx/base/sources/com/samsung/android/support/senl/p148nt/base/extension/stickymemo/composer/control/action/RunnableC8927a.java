package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8927a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6460a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SmCopyTask f6461b;

    public /* synthetic */ RunnableC8927a(SmCopyTask smCopyTask, int i) {
        this.f6460a = i;
        this.f6461b = smCopyTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6460a) {
            case 0:
                SmCopyTask.runOnThread$lambda$1(this.f6461b);
                break;
            case 1:
                SmCopyTask.runOnThread$lambda$2(this.f6461b);
                break;
            default:
                this.f6461b.runOnThread();
                break;
        }
    }
}
