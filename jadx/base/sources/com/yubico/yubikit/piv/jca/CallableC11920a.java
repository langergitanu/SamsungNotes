package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.Slot;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.yubico.yubikit.piv.jca.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class CallableC11920a implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8452a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Result f8453b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8454c;

    public /* synthetic */ CallableC11920a(Result result, Slot slot, int i) {
        this.f8452a = i;
        this.f8453b = result;
        this.f8454c = slot;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f8452a) {
            case 0:
                return PivKeyStoreSpi.lambda$engineDeleteEntry$8(this.f8453b, (Slot) this.f8454c);
            case 1:
                return PivKeyStoreSpi.lambda$engineGetCertificate$4(this.f8453b, (Slot) this.f8454c);
            default:
                return ((PivKeyPairGeneratorSpi) this.f8454c).lambda$generateKeyPair$0(this.f8453b);
        }
    }

    public /* synthetic */ CallableC11920a(PivKeyPairGeneratorSpi pivKeyPairGeneratorSpi, Result result) {
        this.f8452a = 2;
        this.f8454c = pivKeyPairGeneratorSpi;
        this.f8453b = result;
    }
}
