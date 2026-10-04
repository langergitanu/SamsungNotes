package com.samsung.scsp.framework.core.decorator;

import com.google.gson.JsonObject;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.decorator.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11649b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8178a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8179b;

    public /* synthetic */ C11649b(Object obj, int i) {
        this.f8178a = i;
        this.f8179b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8178a) {
            case 0:
                return PlatformConfigurationImpl.lambda$getPlatformConfiguration$5((String) this.f8179b);
            case 1:
                return PlatformConfigurationImpl.lambda$downloadPlatformConfiguration$3((String) this.f8179b);
            default:
                return PlatformConfigurationImpl.lambda$downloadPlatformConfiguration$2((JsonObject) this.f8179b);
        }
    }
}
