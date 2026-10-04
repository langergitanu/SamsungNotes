package androidx.core.util;

import androidx.core.content.IntentSanitizer;

/* JADX INFO: renamed from: androidx.core.util.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2424a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1317a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Predicate f1318b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1319c;

    public /* synthetic */ C2424a(Predicate predicate, Predicate predicate2, int i) {
        this.f1317a = i;
        this.f1318b = predicate;
        this.f1319c = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1317a) {
            case 0:
                return this.f1318b.lambda$or$2((Predicate) this.f1319c, obj);
            case 1:
                return this.f1318b.lambda$and$0((Predicate) this.f1319c, obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.f1319c, this.f1318b, obj);
        }
    }

    public /* synthetic */ C2424a(Class cls, Predicate predicate) {
        this.f1317a = 2;
        this.f1319c = cls;
        this.f1318b = predicate;
    }
}
