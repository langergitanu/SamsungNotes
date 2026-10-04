package com.google.common.collect;

import com.google.common.collect.Iterators;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: renamed from: com.google.common.collect.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5717b implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3346a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Comparator f3347b;

    public /* synthetic */ C5717b(Comparator comparator, int i) {
        this.f3346a = i;
        this.f3347b = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f3346a) {
            case 0:
                return Iterators.MergingIterator.lambda$new$0(this.f3347b, (PeekingIterator) obj, (PeekingIterator) obj2);
            default:
                return ImmutableSortedMap.lambda$fromEntries$0(this.f3347b, (Map.Entry) obj, (Map.Entry) obj2);
        }
    }
}
