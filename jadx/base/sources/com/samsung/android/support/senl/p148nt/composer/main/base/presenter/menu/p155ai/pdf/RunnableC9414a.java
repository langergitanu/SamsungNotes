package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9414a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6849a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6850b;

    public /* synthetic */ RunnableC9414a(Object obj, int i) {
        this.f6849a = i;
        this.f6850b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6849a) {
            case 0:
                ((TextTranslator) this.f6850b).lambda$execute$0();
                break;
            default:
                ((TranslatedPDFSaveTask) this.f6850b).lambda$notifySuccess$0();
                break;
        }
    }
}
