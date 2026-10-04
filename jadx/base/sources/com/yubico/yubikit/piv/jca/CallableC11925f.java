package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.jca.PivPrivateKey;
import java.io.Serializable;
import java.security.KeyStore;
import java.security.interfaces.ECPublicKey;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.yubico.yubikit.piv.jca.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class CallableC11925f implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8474a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Result f8475b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Serializable f8476c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f8477d;

    public /* synthetic */ CallableC11925f(Result result, Slot slot, Object obj, int i) {
        this.f8474a = i;
        this.f8475b = result;
        this.f8476c = slot;
        this.f8477d = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f8474a) {
            case 0:
                return ((PivPrivateKey.EcKey) this.f8476c).lambda$keyAgreement$0(this.f8475b, (ECPublicKey) this.f8477d);
            case 1:
                return PivKeyStoreSpi.lambda$engineGetKey$2(this.f8475b, (Slot) this.f8476c, (char[]) this.f8477d);
            case 2:
                return PivKeyStoreSpi.lambda$engineGetEntry$6(this.f8475b, (Slot) this.f8476c, (KeyStore.ProtectionParameter) this.f8477d);
            default:
                return ((PivPrivateKey) this.f8476c).lambda$rawSignOrDecrypt$0(this.f8475b, (byte[]) this.f8477d);
        }
    }

    public /* synthetic */ CallableC11925f(PivPrivateKey pivPrivateKey, Result result, Serializable serializable, int i) {
        this.f8474a = i;
        this.f8476c = pivPrivateKey;
        this.f8475b = result;
        this.f8477d = serializable;
    }
}
