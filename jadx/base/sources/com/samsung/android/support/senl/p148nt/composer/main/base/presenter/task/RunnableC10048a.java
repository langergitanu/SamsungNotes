package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskActionSend;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10048a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7084a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TaskActionSend f7085b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ TaskActionSend.InputValues f7086c;

    public /* synthetic */ RunnableC10048a(TaskActionSend taskActionSend, TaskActionSend.InputValues inputValues, int i) {
        this.f7084a = i;
        this.f7085b = taskActionSend;
        this.f7086c = inputValues;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7084a) {
            case 0:
                this.f7085b.lambda$executeTask$0(this.f7086c);
                break;
            default:
                this.f7085b.lambda$executeTask$2(this.f7086c);
                break;
        }
    }
}
