package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.D */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13839D implements FailableIntPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9830a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableIntPredicate f9831b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableIntPredicate f9832c;

    public /* synthetic */ C13839D(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2, int i) {
        this.f9830a = i;
        this.f9831b = failableIntPredicate;
        this.f9832c = failableIntPredicate2;
    }

    @Override // org.apache.commons.lang3.function.FailableIntPredicate
    public final boolean test(int i) {
        switch (this.f9830a) {
            case 0:
                return this.f9831b.lambda$and$2(this.f9832c, i);
            default:
                return this.f9831b.lambda$or$4(this.f9832c, i);
        }
    }
}
