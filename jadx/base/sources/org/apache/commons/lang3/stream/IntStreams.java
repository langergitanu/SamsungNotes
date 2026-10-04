package org.apache.commons.lang3.stream;

import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IntStreams {
    @Deprecated
    public IntStreams() {
    }

    @SafeVarargs
    /* JADX INFO: renamed from: of */
    public static IntStream m14866of(int... iArr) {
        return iArr == null ? IntStream.empty() : IntStream.of(iArr);
    }

    public static IntStream range(int i) {
        return IntStream.range(0, i);
    }

    public static IntStream rangeClosed(int i) {
        return IntStream.rangeClosed(0, i);
    }
}
