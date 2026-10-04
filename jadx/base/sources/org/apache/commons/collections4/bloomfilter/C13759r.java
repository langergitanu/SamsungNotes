package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongBinaryOperator;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13759r implements LongBinaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9743a;

    public /* synthetic */ C13759r(int i) {
        this.f9743a = i;
    }

    @Override // java.util.function.LongBinaryOperator
    public final long applyAsLong(long j, long j2) {
        switch (this.f9743a) {
            case 0:
                return SetOperations.lambda$xorCardinality$5(j, j2);
            case 1:
                return SetOperations.lambda$orCardinality$4(j, j2);
            default:
                return SetOperations.lambda$andCardinality$0(j, j2);
        }
    }
}
