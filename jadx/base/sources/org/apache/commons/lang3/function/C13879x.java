package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.x */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13879x implements FailableDoubleUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9895a;

    public /* synthetic */ C13879x(int i) {
        this.f9895a = i;
    }

    @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
    public final double applyAsDouble(double d) {
        switch (this.f9895a) {
            case 0:
                return FailableDoubleUnaryOperator.lambda$identity$1(d);
            default:
                return FailableDoubleUnaryOperator.lambda$static$0(d);
        }
    }
}
