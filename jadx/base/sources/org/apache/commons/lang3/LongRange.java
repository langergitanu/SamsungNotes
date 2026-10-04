package org.apache.commons.lang3;

import java.util.stream.LongStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class LongRange extends NumberRange<Long> {
    private static final long serialVersionUID = 1;

    private LongRange(Long l, Long l2) {
        super(l, l2, null);
    }

    /* JADX INFO: renamed from: of */
    public static LongRange m14655of(long j, long j2) {
        return m14656of(Long.valueOf(j), Long.valueOf(j2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LongStream toLongStream() {
        return LongStream.rangeClosed(((Long) getMinimum()).longValue(), ((Long) getMaximum()).longValue());
    }

    /* JADX INFO: renamed from: of */
    public static LongRange m14656of(Long l, Long l2) {
        return new LongRange(l, l2);
    }
}
