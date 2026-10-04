package org.apache.commons.lang3;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DoubleRange extends NumberRange<Double> {
    private static final long serialVersionUID = 1;

    private DoubleRange(Double d, Double d2) {
        super(d, d2, null);
    }

    /* JADX INFO: renamed from: of */
    public static DoubleRange m14626of(double d, double d2) {
        return m14627of(Double.valueOf(d), Double.valueOf(d2));
    }

    /* JADX INFO: renamed from: of */
    public static DoubleRange m14627of(Double d, Double d2) {
        return new DoubleRange(d, d2);
    }
}
