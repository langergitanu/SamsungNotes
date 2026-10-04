package com.samsung.scsp.common;

import android.content.Context;
import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.scsp.common.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11625d implements FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8133a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f8134b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f8135c;

    public /* synthetic */ C11625d(Context context, String str, int i) {
        this.f8133a = i;
        this.f8134b = context;
        this.f8135c = str;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public final Object get() {
        switch (this.f8133a) {
            case 0:
                return FeatureConfigurator.lambda$get$0(this.f8134b, this.f8135c);
            default:
                return FeatureConfigurator.lambda$getJson$2(this.f8134b, this.f8135c);
        }
    }
}
