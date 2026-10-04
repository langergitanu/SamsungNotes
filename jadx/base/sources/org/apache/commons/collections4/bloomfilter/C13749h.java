package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;
import org.apache.commons.collections4.bloomfilter.CellExtractor;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13749h implements CellExtractor.CellPredicate, IndexExtractor, LongBiPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f9730a;

    public /* synthetic */ C13749h(Object obj) {
        this.f9730a = obj;
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        return IndexExtractor.lambda$fromBitMapExtractor$0((BitMapExtractor) this.f9730a, intPredicate);
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public boolean test(int i, int i2) {
        return CellExtractor.lambda$processIndices$0((IntPredicate) this.f9730a, i, i2);
    }

    @Override // org.apache.commons.collections4.bloomfilter.LongBiPredicate
    public boolean test(long j, long j2) {
        return SetOperations.lambda$jaccardSimilarity$3((int[]) this.f9730a, j, j2);
    }
}
