package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.net.Uri;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10051d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7093a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TaskWebClip f7094b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Uri f7095c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ TaskWebClip.InputValues f7096d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ boolean[] f7097e;

    public /* synthetic */ RunnableC10051d(TaskWebClip taskWebClip, Uri uri, TaskWebClip.InputValues inputValues, boolean[] zArr) {
        this.f7094b = taskWebClip;
        this.f7095c = uri;
        this.f7096d = inputValues;
        this.f7097e = zArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7093a) {
            case 0:
                this.f7094b.lambda$downloadAudio$0(this.f7096d, this.f7095c, this.f7097e);
                break;
            default:
                this.f7094b.lambda$addImage$1(this.f7095c, this.f7096d, this.f7097e);
                break;
        }
    }

    public /* synthetic */ RunnableC10051d(TaskWebClip taskWebClip, TaskWebClip.InputValues inputValues, Uri uri, boolean[] zArr) {
        this.f7094b = taskWebClip;
        this.f7096d = inputValues;
        this.f7095c = uri;
        this.f7097e = zArr;
    }
}
