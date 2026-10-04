package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskActionSend;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10049b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7087a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7088b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f7089c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f7090d;

    public /* synthetic */ RunnableC10049b(TaskAddPdf.ResultValues resultValues, int i, TaskActionSend.InputValues inputValues) {
        this.f7088b = resultValues;
        this.f7089c = i;
        this.f7090d = inputValues;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7087a) {
            case 0:
                TaskActionSend.C99631.lambda$notifyViewUpdate$0((TaskAddPdf.ResultValues) this.f7088b, this.f7089c, (TaskActionSend.InputValues) this.f7090d);
                break;
            case 1:
                ((TaskWebClip.C100456) this.f7090d).lambda$notifyViewUpdate$0((TaskAddPdf.ResultValues) this.f7088b, this.f7089c);
                break;
            default:
                ((TaskWebClip) this.f7088b).lambda$tryToConvertWebToPDF$5((Context) this.f7090d, this.f7089c);
                break;
        }
    }

    public /* synthetic */ RunnableC10049b(TaskWebClip.C100456 c100456, TaskAddPdf.ResultValues resultValues, int i) {
        this.f7090d = c100456;
        this.f7088b = resultValues;
        this.f7089c = i;
    }

    public /* synthetic */ RunnableC10049b(TaskWebClip taskWebClip, Context context, int i) {
        this.f7088b = taskWebClip;
        this.f7090d = context;
        this.f7089c = i;
    }
}
