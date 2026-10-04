package com.vladsch.flexmark.util.misc;

import java.util.BitSet;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.misc.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11868c implements CharPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8398a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8399b;

    public /* synthetic */ C11868c(Object obj, int i) {
        this.f8398a = i;
        this.f8399b = obj;
    }

    @Override // com.vladsch.flexmark.util.misc.CharPredicate, java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f8398a) {
            case 0:
                return CharPredicate.lambda$anyOf$36((String) this.f8399b, i);
            case 1:
                return ((BitSet) this.f8399b).get(i);
            default:
                return ((CharPredicate) this.f8399b).lambda$negate$30(i);
        }
    }
}
