package org.apache.commons.lang3.compare;

import java.util.function.Predicate;

/* JADX INFO: renamed from: org.apache.commons.lang3.compare.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13815b implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9808a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Comparable f9809b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Comparable f9810c;

    public /* synthetic */ C13815b(Comparable comparable, Comparable comparable2, int i) {
        this.f9808a = i;
        this.f9809b = comparable;
        this.f9810c = comparable2;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9808a) {
            case 0:
                return ComparableUtils.lambda$between$0(this.f9809b, this.f9810c, (Comparable) obj);
            default:
                return ComparableUtils.lambda$betweenExclusive$1(this.f9809b, this.f9810c, (Comparable) obj);
        }
    }
}
