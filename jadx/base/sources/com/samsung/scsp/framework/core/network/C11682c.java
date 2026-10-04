package com.samsung.scsp.framework.core.network;

import com.samsung.scsp.framework.core.network.NetworkPermissionFactoryLoader;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11682c implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8246a;

    public /* synthetic */ C11682c(int i) {
        this.f8246a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f8246a) {
            case 0:
                return NetworkPermissionFactoryLoader.NetworkPermissionFactoryHolder.lambda$new$0((String) obj);
            case 1:
                return ResponseUtil.lambda$static$1((Integer) obj);
            default:
                return ResponseUtil.lambda$static$3((Integer) obj);
        }
    }
}
