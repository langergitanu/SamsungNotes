package org.apache.commons.lang3;

import java.lang.Number;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NumberRange<N extends Number> extends Range<N> {
    private static final long serialVersionUID = 1;

    public NumberRange(N n, N n2, Comparator<N> comparator) {
        super(n, n2, comparator);
    }
}
