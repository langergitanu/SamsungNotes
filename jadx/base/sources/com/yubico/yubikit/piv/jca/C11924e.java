package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.jca.PivPrivateKey;
import java.io.Serializable;
import java.security.KeyStore;
import java.security.interfaces.ECPublicKey;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: renamed from: com.yubico.yubikit.piv.jca.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11924e implements Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8470a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayBlockingQueue f8471b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Serializable f8472c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f8473d;

    public /* synthetic */ C11924e(PivPrivateKey pivPrivateKey, ArrayBlockingQueue arrayBlockingQueue, Serializable serializable, int i) {
        this.f8470a = i;
        this.f8472c = pivPrivateKey;
        this.f8471b = arrayBlockingQueue;
        this.f8473d = serializable;
    }

    @Override // com.yubico.yubikit.core.util.Callback
    public final void invoke(Object obj) {
        switch (this.f8470a) {
            case 0:
                ((PivPrivateKey.EcKey) this.f8472c).lambda$keyAgreement$1(this.f8471b, (ECPublicKey) this.f8473d, (Result) obj);
                break;
            case 1:
                PivKeyStoreSpi.lambda$engineGetEntry$7(this.f8471b, (Slot) this.f8472c, (KeyStore.ProtectionParameter) this.f8473d, (Result) obj);
                break;
            case 2:
                PivKeyStoreSpi.lambda$engineGetKey$3(this.f8471b, (Slot) this.f8472c, (char[]) this.f8473d, (Result) obj);
                break;
            default:
                ((PivPrivateKey) this.f8472c).lambda$rawSignOrDecrypt$1(this.f8471b, (byte[]) this.f8473d, (Result) obj);
                break;
        }
    }

    public /* synthetic */ C11924e(ArrayBlockingQueue arrayBlockingQueue, Slot slot, Object obj, int i) {
        this.f8470a = i;
        this.f8471b = arrayBlockingQueue;
        this.f8472c = slot;
        this.f8473d = obj;
    }
}
