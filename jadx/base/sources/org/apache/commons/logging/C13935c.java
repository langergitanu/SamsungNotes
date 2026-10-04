package org.apache.commons.logging;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.logging.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13935c implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9980a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SecurityException f9981b;

    public /* synthetic */ C13935c(SecurityException securityException, int i) {
        this.f9980a = i;
        this.f9981b = securityException;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9980a) {
            case 0:
                return LogFactory.lambda$getFactory$6(this.f9981b);
            default:
                return LogFactory.lambda$implementsLogFactory$21(this.f9981b);
        }
    }
}
