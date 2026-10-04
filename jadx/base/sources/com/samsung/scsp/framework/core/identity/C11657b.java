package com.samsung.scsp.framework.core.identity;

import com.google.gson.JsonObject;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11657b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8200a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ JsonObject f8201b;

    public /* synthetic */ C11657b(JsonObject jsonObject, int i) {
        this.f8200a = i;
        this.f8201b = jsonObject;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8200a) {
            case 0:
                return AbstractRegisterApi.lambda$register$0(this.f8201b);
            default:
                return AbstractTokenApi.lambda$renew$0(this.f8201b);
        }
    }
}
