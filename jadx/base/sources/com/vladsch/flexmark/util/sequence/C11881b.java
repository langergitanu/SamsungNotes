package com.vladsch.flexmark.util.sequence;

import java.util.function.Predicate;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11881b implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8413a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ IRichSequenceBase f8414b;

    public /* synthetic */ C11881b(IRichSequenceBase iRichSequenceBase, int i) {
        this.f8413a = i;
        this.f8414b = iRichSequenceBase;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f8413a) {
            case 0:
                return this.f8414b.matches((CharSequence) obj);
            case 1:
                return this.f8414b.startsWithIgnoreCase((CharSequence) obj);
            case 2:
                return this.f8414b.endsWithIgnoreCase((CharSequence) obj);
            case 3:
                return this.f8414b.endsWith((CharSequence) obj);
            default:
                return this.f8414b.startsWith((CharSequence) obj);
        }
    }
}
