package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: com.google.common.collect.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5720e implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3350a;

    public /* synthetic */ C5720e(int i) {
        this.f3350a = i;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3350a) {
            case 0:
                return Multimaps.access$100((Collection) obj);
            case 1:
                return ((Iterable) obj).iterator();
            default:
                return TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
        }
    }
}
