package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.G */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13842G implements FailableIntUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9835a;

    public /* synthetic */ C13842G(int i) {
        this.f9835a = i;
    }

    @Override // org.apache.commons.lang3.function.FailableIntUnaryOperator
    public final int applyAsInt(int i) {
        switch (this.f9835a) {
            case 0:
                return FailableIntUnaryOperator.lambda$static$0(i);
            default:
                return FailableIntUnaryOperator.lambda$identity$1(i);
        }
    }
}
