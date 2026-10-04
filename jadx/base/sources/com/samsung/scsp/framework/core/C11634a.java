package com.samsung.scsp.framework.core;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.pam.kps.lite.KpsGetPolicyJobImpl;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11634a implements FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8152a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Map f8153b;

    public /* synthetic */ C11634a(Map map, int i) {
        this.f8152a = i;
        this.f8153b = map;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public final Object get() {
        switch (this.f8152a) {
            case 0:
                return DefaultErrorListener.lambda$onError$0(this.f8153b);
            default:
                return KpsGetPolicyJobImpl.lambda$onStream$1(this.f8153b);
        }
    }
}
