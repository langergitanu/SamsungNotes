package com.samsung.scsp.common;

import android.content.Context;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.scsp.common.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11622a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8129a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f8130b;

    public /* synthetic */ C11622a(Context context, int i) {
        this.f8129a = i;
        this.f8130b = context;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8129a) {
            case 0:
                return ContextFactory.lambda$attachBaseContext$0(this.f8130b);
            case 1:
                return ContextFactory.lambda$attachApplicationContext$1(this.f8130b);
            default:
                return ContextFactory.lambda$attachApplicationContext$2(this.f8130b);
        }
    }
}
