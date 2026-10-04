package com.vladsch.flexmark.util.collection;

import java.util.function.BiFunction;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BoundedMaxAggregator implements BiFunction<Integer, Integer, Integer> {
    public final int maxBound;

    public BoundedMaxAggregator(int i) {
        this.maxBound = i;
    }

    @Override // java.util.function.BiFunction
    public Integer apply(@Nullable Integer num, @Nullable Integer num2) {
        return (num2 == null || num2.intValue() >= this.maxBound) ? num : MaxAggregator.INSTANCE.apply(num, num2);
    }
}
