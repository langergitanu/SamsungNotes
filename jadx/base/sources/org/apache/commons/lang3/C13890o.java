package org.apache.commons.lang3;

import java.util.function.Function;
import org.apache.commons.lang3.concurrent.Memoizer;

/* JADX INFO: renamed from: org.apache.commons.lang3.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13890o implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9912a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function f9913b;

    public /* synthetic */ C13890o(Function function, int i) {
        this.f9912a = i;
        this.f9913b = function;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f9912a) {
            case 0:
                return this.f9913b.apply((Enum) obj);
            default:
                return Memoizer.lambda$new$3(this.f9913b, obj);
        }
    }
}
