package org.apache.commons.lang3;

import java.util.List;
import java.util.function.BinaryOperator;
import org.apache.commons.lang3.Streams;

/* JADX INFO: renamed from: org.apache.commons.lang3.y */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13931y implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return Streams.ArrayCollector.lambda$combiner$0((List) obj, (List) obj2);
    }
}
