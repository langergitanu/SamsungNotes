package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13871p implements FailableBiPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9882a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableBiPredicate f9883b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableBiPredicate f9884c;

    public /* synthetic */ C13871p(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2, int i) {
        this.f9882a = i;
        this.f9883b = failableBiPredicate;
        this.f9884c = failableBiPredicate2;
    }

    @Override // org.apache.commons.lang3.function.FailableBiPredicate
    public final boolean test(Object obj, Object obj2) {
        switch (this.f9882a) {
            case 0:
                return this.f9883b.lambda$and$2(this.f9884c, obj, obj2);
            default:
                return this.f9883b.lambda$or$4(this.f9884c, obj, obj2);
        }
    }
}
