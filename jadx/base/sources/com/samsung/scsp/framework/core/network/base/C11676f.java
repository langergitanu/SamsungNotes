package com.samsung.scsp.framework.core.network.base;

import com.samsung.scsp.framework.core.network.HttpRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.base.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11676f implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8236a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ HttpRequest f8237b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Serializable f8238c;

    public /* synthetic */ C11676f(HttpRequest httpRequest, String str) {
        this.f8237b = httpRequest;
        this.f8238c = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8236a) {
            case 0:
                return NetworkImpl.lambda$execute$12(this.f8237b, (String) this.f8238c);
            default:
                return NetworkImpl.lambda$getConnection$7((HashMap) this.f8238c, this.f8237b);
        }
    }

    public /* synthetic */ C11676f(HashMap map, HttpRequest httpRequest) {
        this.f8238c = map;
        this.f8237b = httpRequest;
    }
}
