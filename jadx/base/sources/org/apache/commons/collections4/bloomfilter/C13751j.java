package org.apache.commons.collections4.bloomfilter;

import java.util.function.ToIntFunction;
import org.apache.commons.collections4.bloomfilter.CellExtractor;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13751j implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((CellExtractor.C137351.CounterCell) obj).idx;
    }
}
