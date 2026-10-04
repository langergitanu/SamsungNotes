package org.apache.commons.collections4;

import java.util.Set;

/* JADX INFO: renamed from: org.apache.commons.collections4.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13732b implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9715a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9716b;

    public /* synthetic */ C13732b(Object obj, int i) {
        this.f9715a = i;
        this.f9716b = obj;
    }

    @Override // org.apache.commons.collections4.Predicate
    public final boolean evaluate(Object obj) {
        switch (this.f9715a) {
            case 0:
                return SetUtils.lambda$difference$0((Set) this.f9716b, obj);
            case 1:
                return ((Set) this.f9716b).contains(obj);
            default:
                return ((java.util.function.Predicate) this.f9716b).test(obj);
        }
    }
}
