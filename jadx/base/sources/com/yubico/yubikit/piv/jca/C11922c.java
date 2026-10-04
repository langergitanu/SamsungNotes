package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.Slot;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: renamed from: com.yubico.yubikit.piv.jca.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11922c implements Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8461a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayBlockingQueue f8462b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8463c;

    public /* synthetic */ C11922c(PivKeyPairGeneratorSpi pivKeyPairGeneratorSpi, ArrayBlockingQueue arrayBlockingQueue) {
        this.f8461a = 2;
        this.f8463c = pivKeyPairGeneratorSpi;
        this.f8462b = arrayBlockingQueue;
    }

    @Override // com.yubico.yubikit.core.util.Callback
    public final void invoke(Object obj) {
        switch (this.f8461a) {
            case 0:
                PivKeyStoreSpi.lambda$engineDeleteEntry$9(this.f8462b, (Slot) this.f8463c, (Result) obj);
                break;
            case 1:
                PivKeyStoreSpi.lambda$engineGetCertificate$5(this.f8462b, (Slot) this.f8463c, (Result) obj);
                break;
            default:
                ((PivKeyPairGeneratorSpi) this.f8463c).lambda$generateKeyPair$1(this.f8462b, (Result) obj);
                break;
        }
    }

    public /* synthetic */ C11922c(ArrayBlockingQueue arrayBlockingQueue, Slot slot, int i) {
        this.f8461a = i;
        this.f8462b = arrayBlockingQueue;
        this.f8463c = slot;
    }
}
