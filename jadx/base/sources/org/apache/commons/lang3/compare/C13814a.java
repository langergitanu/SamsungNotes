package org.apache.commons.lang3.compare;

import java.util.function.Predicate;

/* JADX INFO: renamed from: org.apache.commons.lang3.compare.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13814a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9806a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Comparable f9807b;

    public /* synthetic */ C13814a(Comparable comparable, int i) {
        this.f9806a = i;
        this.f9807b = comparable;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9806a) {
            case 0:
                return ComparableUtils.lambda$ge$2(this.f9807b, (Comparable) obj);
            case 1:
                return ComparableUtils.lambda$gt$3(this.f9807b, (Comparable) obj);
            case 2:
                return ComparableUtils.lambda$lt$5(this.f9807b, (Comparable) obj);
            default:
                return ComparableUtils.lambda$le$4(this.f9807b, (Comparable) obj);
        }
    }
}
