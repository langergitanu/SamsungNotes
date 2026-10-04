package org.apache.commons.lang3.function;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.z */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13881z implements FailableFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9899a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FailableFunction f9900b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FailableFunction f9901c;

    public /* synthetic */ C13881z(FailableFunction failableFunction, FailableFunction failableFunction2, int i) {
        this.f9899a = i;
        this.f9900b = failableFunction;
        this.f9901c = failableFunction2;
    }

    @Override // org.apache.commons.lang3.function.FailableFunction
    public final Object apply(Object obj) {
        switch (this.f9899a) {
            case 0:
                return this.f9900b.lambda$compose$3(this.f9901c, obj);
            default:
                return this.f9900b.lambda$andThen$2(this.f9901c, obj);
        }
    }
}
