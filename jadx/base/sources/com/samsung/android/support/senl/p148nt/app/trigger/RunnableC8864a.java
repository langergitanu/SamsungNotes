package com.samsung.android.support.senl.p148nt.app.trigger;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.trigger.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8864a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6334a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DocOpenTriggerActivity f6335b;

    public /* synthetic */ RunnableC8864a(DocOpenTriggerActivity docOpenTriggerActivity, int i) {
        this.f6334a = i;
        this.f6335b = docOpenTriggerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6334a) {
            case 0:
                this.f6335b.lambda$initialize$0();
                break;
            default:
                this.f6335b.lambda$showConvertProgressDialog$3();
                break;
        }
    }
}
