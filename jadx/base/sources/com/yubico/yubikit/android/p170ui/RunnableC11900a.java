package com.yubico.yubikit.android.p170ui;

import com.yubico.yubikit.android.p170ui.YubiKeyPromptActivity;

/* JADX INFO: renamed from: com.yubico.yubikit.android.ui.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC11900a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8431a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8432b;

    public /* synthetic */ RunnableC11900a(Object obj, int i) {
        this.f8431a = i;
        this.f8432b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8431a) {
            case 0:
                ((OtpActivity) this.f8432b).lambda$onCreate$1();
                break;
            case 1:
                ((OtpActivity) this.f8432b).lambda$onCreate$2();
                break;
            case 2:
                ((OtpActivity) this.f8432b).lambda$onCreate$0();
                break;
            default:
                ((YubiKeyPromptActivity.MyCommandState) this.f8432b).lambda$onKeepAliveStatus$0();
                break;
        }
    }
}
