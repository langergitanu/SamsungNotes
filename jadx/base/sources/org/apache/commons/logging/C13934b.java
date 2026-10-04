package org.apache.commons.logging;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.logging.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13934b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9978a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ClassLoader f9979b;

    public /* synthetic */ C13934b(ClassLoader classLoader, int i) {
        this.f9978a = i;
        this.f9979b = classLoader;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9978a) {
            case 0:
                return LogFactory.lambda$getFactory$1(this.f9979b);
            case 1:
                return LogFactory.lambda$getFactory$2(this.f9979b);
            default:
                return LogFactory.lambda$release$33(this.f9979b);
        }
    }
}
