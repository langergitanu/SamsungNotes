package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.y */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13880y implements FailableDoubleUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9896a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableDoubleUnaryOperator f9897b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableDoubleUnaryOperator f9898c;

    public /* synthetic */ C13880y(FailableDoubleUnaryOperator failableDoubleUnaryOperator, FailableDoubleUnaryOperator failableDoubleUnaryOperator2, int i) {
        this.f9896a = i;
        this.f9897b = failableDoubleUnaryOperator;
        this.f9898c = failableDoubleUnaryOperator2;
    }

    @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
    public final double applyAsDouble(double d) {
        switch (this.f9896a) {
            case 0:
                return this.f9897b.lambda$compose$3(this.f9898c, d);
            default:
                return this.f9897b.lambda$andThen$2(this.f9898c, d);
        }
    }
}
