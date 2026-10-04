package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongBinaryOperator;
import org.apache.commons.collections4.bloomfilter.CellExtractor;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13742a implements CellExtractor.CellPredicate, LongBiPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9718a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int[] f9719b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9720c;

    public /* synthetic */ C13742a(Object obj, int[] iArr, int i) {
        this.f9718a = i;
        this.f9720c = obj;
        this.f9719b = iArr;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public boolean test(int i, int i2) {
        switch (this.f9718a) {
            case 0:
                return ((ArrayCountingBloomFilter) this.f9720c).lambda$getMaxInsert$3(this.f9719b, i, i2);
            default:
                return CountingBloomFilter.lambda$getMaxInsert$0((long[]) this.f9720c, this.f9719b, i, i2);
        }
    }

    public /* synthetic */ C13742a(int[] iArr, LongBinaryOperator longBinaryOperator) {
        this.f9718a = 2;
        this.f9719b = iArr;
        this.f9720c = longBinaryOperator;
    }

    @Override // org.apache.commons.collections4.bloomfilter.LongBiPredicate
    public boolean test(long j, long j2) {
        return SetOperations.lambda$cardinality$2(this.f9719b, (LongBinaryOperator) this.f9720c, j, j2);
    }
}
