package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;
import org.apache.commons.collections4.bloomfilter.BitMapExtractor;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13745d implements LongPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9725a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9726b;

    public /* synthetic */ C13745d(Object obj, int i) {
        this.f9725a = i;
        this.f9726b = obj;
    }

    @Override // java.util.function.LongPredicate
    public final boolean test(long j) {
        switch (this.f9725a) {
            case 0:
                return ((BitMapExtractor.C1Bits) this.f9726b).add(j);
            case 1:
                return ((LongPredicate) this.f9726b).test(j);
            default:
                return SetOperations.lambda$cardinality$1((int[]) this.f9726b, j);
        }
    }
}
