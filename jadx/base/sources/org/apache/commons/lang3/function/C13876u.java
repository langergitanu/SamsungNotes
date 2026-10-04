package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.u */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13876u implements FailableDoublePredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9890a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableDoublePredicate f9891b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableDoublePredicate f9892c;

    public /* synthetic */ C13876u(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2, int i) {
        this.f9890a = i;
        this.f9891b = failableDoublePredicate;
        this.f9892c = failableDoublePredicate2;
    }

    @Override // org.apache.commons.lang3.function.FailableDoublePredicate
    public final boolean test(double d) {
        switch (this.f9890a) {
            case 0:
                return this.f9891b.lambda$or$4(this.f9892c, d);
            default:
                return this.f9891b.lambda$and$2(this.f9892c, d);
        }
    }
}
