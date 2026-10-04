package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.K */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13846K implements FailableLongPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9841a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableLongPredicate f9842b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableLongPredicate f9843c;

    public /* synthetic */ C13846K(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2, int i) {
        this.f9841a = i;
        this.f9842b = failableLongPredicate;
        this.f9843c = failableLongPredicate2;
    }

    @Override // org.apache.commons.lang3.function.FailableLongPredicate
    public final boolean test(long j) {
        switch (this.f9841a) {
            case 0:
                return this.f9842b.lambda$and$2(this.f9843c, j);
            default:
                return this.f9842b.lambda$or$4(this.f9843c, j);
        }
    }
}
