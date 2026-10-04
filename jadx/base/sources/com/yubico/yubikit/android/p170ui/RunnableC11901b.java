package com.yubico.yubikit.android.p170ui;

/* JADX INFO: renamed from: com.yubico.yubikit.android.ui.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC11901b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8433a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ YubiKeyPromptActivity f8434b;

    public /* synthetic */ RunnableC11901b(YubiKeyPromptActivity yubiKeyPromptActivity, int i) {
        this.f8433a = i;
        this.f8434b = yubiKeyPromptActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8433a) {
            case 0:
                this.f8434b.lambda$onCreate$3();
                break;
            case 1:
                this.f8434b.lambda$onCreate$4();
                break;
            case 2:
                this.f8434b.lambda$onCreate$5();
                break;
            case 3:
                this.f8434b.lambda$onYubiKeyDevice$0();
                break;
            case 4:
                this.f8434b.lambda$onResume$8();
                break;
            default:
                this.f8434b.finishIfDone();
                break;
        }
    }
}
