package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.Q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13852Q implements FailablePredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9851a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailablePredicate f9852b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailablePredicate f9853c;

    public /* synthetic */ C13852Q(FailablePredicate failablePredicate, FailablePredicate failablePredicate2, int i) {
        this.f9851a = i;
        this.f9852b = failablePredicate;
        this.f9853c = failablePredicate2;
    }

    @Override // org.apache.commons.lang3.function.FailablePredicate
    public final boolean test(Object obj) {
        switch (this.f9851a) {
            case 0:
                return this.f9852b.lambda$or$4(this.f9853c, obj);
            default:
                return this.f9852b.lambda$and$2(this.f9853c, obj);
        }
    }
}
