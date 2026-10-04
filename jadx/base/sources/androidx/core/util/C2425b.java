package androidx.core.util;

/* JADX INFO: renamed from: androidx.core.util.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2425b implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1320a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1321b;

    public /* synthetic */ C2425b(Object obj, int i) {
        this.f1320a = i;
        this.f1321b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1320a) {
            case 0:
                return this.f1321b.equals(obj);
            default:
                return ((Predicate) this.f1321b).lambda$negate$1(obj);
        }
    }
}
