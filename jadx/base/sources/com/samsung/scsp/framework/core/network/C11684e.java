package com.samsung.scsp.framework.core.network;

import java.io.Serializable;
import java.util.function.IntPredicate;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.network.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11684e implements IntPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8247a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Serializable f8248b;

    public /* synthetic */ C11684e(Serializable serializable, int i) {
        this.f8247a = i;
        this.f8248b = serializable;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f8247a) {
            case 0:
                return ResponseUtil.lambda$static$0((Integer) this.f8248b, i);
            case 1:
                return ResponseUtil.lambda$static$2((Integer) this.f8248b, i);
            default:
                return ArrayUtils.contains((int[]) this.f8248b, i);
        }
    }
}
