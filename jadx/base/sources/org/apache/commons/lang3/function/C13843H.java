package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.H */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13843H implements FailableIntUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9836a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableIntUnaryOperator f9837b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableIntUnaryOperator f9838c;

    public /* synthetic */ C13843H(FailableIntUnaryOperator failableIntUnaryOperator, FailableIntUnaryOperator failableIntUnaryOperator2, int i) {
        this.f9836a = i;
        this.f9837b = failableIntUnaryOperator;
        this.f9838c = failableIntUnaryOperator2;
    }

    @Override // org.apache.commons.lang3.function.FailableIntUnaryOperator
    public final int applyAsInt(int i) {
        switch (this.f9836a) {
            case 0:
                return this.f9837b.lambda$compose$3(this.f9838c, i);
            default:
                return this.f9837b.lambda$andThen$2(this.f9838c, i);
        }
    }
}
