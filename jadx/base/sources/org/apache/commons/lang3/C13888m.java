package org.apache.commons.lang3;

import java.util.function.IntFunction;

/* JADX INFO: renamed from: org.apache.commons.lang3.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13888m implements IntFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9910a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Class[] f9911b;

    public /* synthetic */ C13888m(Class[] clsArr, int i) {
        this.f9910a = i;
        this.f9911b = clsArr;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.f9910a) {
            case 0:
                return ClassUtils.lambda$wrappersToPrimitives$8(this.f9911b, i);
            default:
                return ClassUtils.lambda$primitivesToWrappers$6(this.f9911b, i);
        }
    }
}
