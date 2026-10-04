package com.samsung.android.support.senl.p148nt.coedit.control;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.control.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9049e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6626a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ICoeditHandler f6627b;

    public /* synthetic */ RunnableC9049e(ICoeditHandler iCoeditHandler, int i) {
        this.f6626a = i;
        this.f6627b = iCoeditHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6626a) {
            case 0:
                this.f6627b.checkDeleteOnlyMode();
                break;
            case 1:
                this.f6627b.saveCoeditCache();
                break;
            case 2:
                this.f6627b.internalSnapRefresh();
                break;
            default:
                this.f6627b.requestReadPermission();
                break;
        }
    }
}
