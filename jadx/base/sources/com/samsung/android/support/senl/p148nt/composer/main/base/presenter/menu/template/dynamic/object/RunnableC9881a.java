package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.object;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.object.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9881a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7051a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Task.Callback f7052b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ TaskAddPdf.ResultValues f7053c;

    public /* synthetic */ RunnableC9881a(Task.Callback callback, TaskAddPdf.ResultValues resultValues, int i) {
        this.f7051a = i;
        this.f7052b = callback;
        this.f7053c = resultValues;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7051a) {
            case 0:
                this.f7052b.onSuccess(this.f7053c);
                break;
            default:
                this.f7052b.onError(this.f7053c);
                break;
        }
    }
}
