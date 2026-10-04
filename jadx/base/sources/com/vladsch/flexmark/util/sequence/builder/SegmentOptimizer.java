package com.vladsch.flexmark.util.sequence.builder;

import java.util.Arrays;
import java.util.function.BiFunction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface SegmentOptimizer extends BiFunction<CharSequence, Object[], Object[]> {
    @NotNull
    static Object[] insert(@NotNull Object[] objArr, int i) {
        if (i >= objArr.length) {
            return Arrays.copyOf(objArr, objArr.length + 1);
        }
        Object[] objArr2 = new Object[objArr.length + 1];
        if (i == 0) {
            System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
            return objArr2;
        }
        System.arraycopy(objArr, 0, objArr2, 0, i);
        System.arraycopy(objArr, i, objArr2, i + 1, objArr.length - i);
        return objArr2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.BiFunction
    Object[] apply(@NotNull CharSequence charSequence, Object[] objArr);
}
