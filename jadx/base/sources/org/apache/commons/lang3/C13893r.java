package org.apache.commons.lang3;

import java.util.function.BiPredicate;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiPredicate;

/* JADX INFO: renamed from: org.apache.commons.lang3.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13893r implements BiPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9919a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9920b;

    public /* synthetic */ C13893r(Object obj, int i) {
        this.f9919a = i;
        this.f9920b = obj;
    }

    @Override // java.util.function.BiPredicate
    public final boolean test(Object obj, Object obj2) {
        switch (this.f9919a) {
            case 0:
                return Functions.test((Functions.FailableBiPredicate) this.f9920b, obj, obj2);
            default:
                return Failable.test((FailableBiPredicate) this.f9920b, obj, obj2);
        }
    }
}
