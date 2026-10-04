package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.P */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13851P implements FailableLongUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9848a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableLongUnaryOperator f9849b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableLongUnaryOperator f9850c;

    public /* synthetic */ C13851P(FailableLongUnaryOperator failableLongUnaryOperator, FailableLongUnaryOperator failableLongUnaryOperator2, int i) {
        this.f9848a = i;
        this.f9849b = failableLongUnaryOperator;
        this.f9850c = failableLongUnaryOperator2;
    }

    @Override // org.apache.commons.lang3.function.FailableLongUnaryOperator
    public final long applyAsLong(long j) {
        switch (this.f9848a) {
            case 0:
                return this.f9849b.lambda$andThen$2(this.f9850c, j);
            default:
                return this.f9849b.lambda$compose$3(this.f9850c, j);
        }
    }
}
