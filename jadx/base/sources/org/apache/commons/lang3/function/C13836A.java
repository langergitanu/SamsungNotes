package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.A */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13836A implements FailableFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9827a;

    public /* synthetic */ C13836A(int i) {
        this.f9827a = i;
    }

    @Override // org.apache.commons.lang3.function.FailableFunction
    public final Object apply(Object obj) {
        switch (this.f9827a) {
            case 0:
                return FailableFunction.lambda$static$0(obj);
            default:
                return FailableFunction.lambda$identity$1(obj);
        }
    }
}
