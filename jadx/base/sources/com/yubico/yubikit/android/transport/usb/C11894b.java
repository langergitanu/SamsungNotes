package com.yubico.yubikit.android.transport.usb;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.jca.PivProvider;

/* JADX INFO: renamed from: com.yubico.yubikit.android.transport.usb.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11894b implements Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8425a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8426b;

    public /* synthetic */ C11894b(Object obj, int i) {
        this.f8425a = i;
        this.f8426b = obj;
    }

    @Override // com.yubico.yubikit.core.util.Callback
    public final void invoke(Object obj) {
        switch (this.f8425a) {
            case 0:
                ((Callback) this.f8426b).invoke((Result) obj);
                break;
            default:
                PivProvider.lambda$new$0((PivSession) this.f8426b, (Callback) obj);
                break;
        }
    }
}
