package org.apache.commons.lang3;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.lang3.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13830d implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9817a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Class f9818b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f9819c;

    public /* synthetic */ C13830d(Class cls, int i, int i2) {
        this.f9817a = i2;
        this.f9818b = cls;
        this.f9819c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9817a) {
            case 0:
                return ArrayUtils.newInstance(this.f9818b, this.f9819c);
            default:
                return ArrayUtils.lambda$add$0(this.f9818b, this.f9819c);
        }
    }
}
