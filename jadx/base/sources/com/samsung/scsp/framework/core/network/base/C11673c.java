package com.samsung.scsp.framework.core.network.base;

import java.net.HttpURLConnection;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.base.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11673c implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8234a;

    public /* synthetic */ C11673c(int i) {
        this.f8234a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f8234a) {
            case 0:
                return NetworkImpl.lambda$execute$8((Map.Entry) obj);
            case 1:
                return NetworkImpl.lambda$new$0((String) obj);
            default:
                return NetworkImpl.lambda$close$4((HttpURLConnection) obj);
        }
    }
}
