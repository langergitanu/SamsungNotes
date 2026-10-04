package org.apache.commons.lang3;

import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class IntegerRange extends NumberRange<Integer> {
    private static final long serialVersionUID = 1;

    private IntegerRange(Integer num, Integer num2) {
        super(num, num2, null);
    }

    /* JADX INFO: renamed from: of */
    public static IntegerRange m14649of(int i, int i2) {
        return m14650of(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntStream toIntStream() {
        return IntStream.rangeClosed(((Integer) getMinimum()).intValue(), ((Integer) getMaximum()).intValue());
    }

    /* JADX INFO: renamed from: of */
    public static IntegerRange m14650of(Integer num, Integer num2) {
        return new IntegerRange(num, num2);
    }
}
