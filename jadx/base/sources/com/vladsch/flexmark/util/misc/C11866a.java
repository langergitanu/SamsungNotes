package com.vladsch.flexmark.util.misc;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.misc.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11866a implements CharPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8393a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CharPredicate f8394b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ CharPredicate f8395c;

    public /* synthetic */ C11866a(CharPredicate charPredicate, CharPredicate charPredicate2, int i) {
        this.f8393a = i;
        this.f8394b = charPredicate;
        this.f8395c = charPredicate2;
    }

    @Override // com.vladsch.flexmark.util.misc.CharPredicate, java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f8393a) {
            case 0:
                return this.f8394b.lambda$and$29(this.f8395c, i);
            default:
                return this.f8394b.lambda$or$31(this.f8395c, i);
        }
    }
}
