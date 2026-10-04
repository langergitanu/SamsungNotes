package com.vladsch.flexmark.util.sequence;

import java.util.function.Predicate;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11880a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8410a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ IRichSequenceBase f8411b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f8412c;

    public /* synthetic */ C11880a(IRichSequenceBase iRichSequenceBase, boolean z, int i) {
        this.f8410a = i;
        this.f8411b = iRichSequenceBase;
        this.f8412c = z;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f8410a) {
            case 0:
                return this.f8411b.lambda$nullIfStartsWith$2(this.f8412c, (CharSequence) obj);
            case 1:
                return this.f8411b.lambda$nullIfNotStartsWith$3(this.f8412c, (CharSequence) obj);
            case 2:
                return this.f8411b.lambda$nullIfEndsWith$4(this.f8412c, (CharSequence) obj);
            default:
                return this.f8411b.lambda$nullIfNotEndsWith$5(this.f8412c, (CharSequence) obj);
        }
    }
}
