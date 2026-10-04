package com.samsung.android.support.senl.p148nt.composer.main.base.model;

import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task.PwTaskConvertToNote;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.model.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9121a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6768a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ComposerModel f6769b;

    public /* synthetic */ RunnableC9121a(ComposerModel composerModel, int i) {
        this.f6768a = i;
        this.f6769b = composerModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6768a) {
            case 0:
                this.f6769b.requestCollect();
                break;
            default:
                PwTaskConvertToNote.lambda$executeTask$0(this.f6769b);
                break;
        }
    }
}
