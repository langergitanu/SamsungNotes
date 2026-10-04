package org.apache.commons.collections4.bloomfilter;

import java.util.function.Predicate;
import org.apache.commons.collections4.bloomfilter.LayerManager;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13756o implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9738a;

    public /* synthetic */ C13756o(int i) {
        this.f9738a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9738a) {
            case 0:
                return LayerManager.ExtendCheck.lambda$neverAdvance$2((LayerManager) obj);
            case 1:
                return LayerManager.ExtendCheck.lambda$advanceOnPopulated$0((LayerManager) obj);
            default:
                return ((BloomFilter) obj).isEmpty();
        }
    }
}
