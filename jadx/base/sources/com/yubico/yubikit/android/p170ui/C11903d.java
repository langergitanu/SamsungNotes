package com.yubico.yubikit.android.p170ui;

import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.core.util.Callback;

/* JADX INFO: renamed from: com.yubico.yubikit.android.ui.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11903d implements Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8437a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ YubiKeyPromptActivity f8438b;

    public /* synthetic */ C11903d(YubiKeyPromptActivity yubiKeyPromptActivity, int i) {
        this.f8437a = i;
        this.f8438b = yubiKeyPromptActivity;
    }

    @Override // com.yubico.yubikit.core.util.Callback
    public final void invoke(Object obj) {
        switch (this.f8437a) {
            case 0:
                this.f8438b.lambda$onCreate$6((UsbYubiKeyDevice) obj);
                break;
            case 1:
                this.f8438b.lambda$onResume$10((NfcYubiKeyDevice) obj);
                break;
            default:
                ((OtpActivity) this.f8438b).lambda$onCreate$3((UsbYubiKeyDevice) obj);
                break;
        }
    }
}
