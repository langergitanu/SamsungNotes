package com.samsung.scsp.framework.core.network;

import com.samsung.scsp.framework.core.network.NetworkPermissionFactoryLoader;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11683d implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return NetworkPermissionFactoryLoader.NetworkPermissionFactoryHolder.lambda$new$1();
    }
}
