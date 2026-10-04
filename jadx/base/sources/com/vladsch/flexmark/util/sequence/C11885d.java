package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.misc.CharPredicate;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11885d implements CharPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8420a;

    public /* synthetic */ C11885d(int i) {
        this.f8420a = i;
    }

    @Override // com.vladsch.flexmark.util.misc.CharPredicate, java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f8420a) {
            case 0:
                return SequenceUtils.lambda$static$0(i);
            default:
                return CharPredicate.lambda$static$16(i);
        }
    }
}
