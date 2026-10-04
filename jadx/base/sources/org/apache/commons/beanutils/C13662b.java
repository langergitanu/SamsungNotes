package org.apache.commons.beanutils;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.beanutils.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13662b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9705a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f9706b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f9707c;

    public /* synthetic */ C13662b(String str, String str2, int i) {
        this.f9705a = i;
        this.f9706b = str;
        this.f9707c = str2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9705a) {
            case 0:
                return BasicDynaBean.lambda$contains$0(this.f9706b, this.f9707c);
            case 1:
                return BasicDynaBean.lambda$get$2(this.f9706b, this.f9707c);
            case 2:
                return BasicDynaBean.lambda$set$5(this.f9706b, this.f9707c);
            default:
                return BasicDynaBean.lambda$remove$3(this.f9706b, this.f9707c);
        }
    }
}
