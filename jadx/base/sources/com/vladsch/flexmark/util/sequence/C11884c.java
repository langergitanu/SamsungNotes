package com.vladsch.flexmark.util.sequence;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11884c implements BiPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8418a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Predicate f8419b;

    public /* synthetic */ C11884c(Predicate predicate, int i) {
        this.f8418a = i;
        this.f8419b = predicate;
    }

    @Override // java.util.function.BiPredicate
    public final boolean test(Object obj, Object obj2) {
        IRichSequence iRichSequence = (IRichSequence) obj;
        CharSequence charSequence = (CharSequence) obj2;
        switch (this.f8418a) {
            case 0:
                return IRichSequenceBase.lambda$nullIf$0(this.f8419b, iRichSequence, charSequence);
            default:
                return IRichSequenceBase.lambda$nullIfNot$1(this.f8419b, iRichSequence, charSequence);
        }
    }
}
