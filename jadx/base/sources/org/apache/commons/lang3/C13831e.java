package org.apache.commons.lang3;

import java.util.function.IntFunction;
import org.apache.commons.lang3.Functions;
import org.apache.commons.text.AlphabetConverter;

/* JADX INFO: renamed from: org.apache.commons.lang3.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13831e implements IntFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9820a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9821b;

    public /* synthetic */ C13831e(Object obj, int i) {
        this.f9820a = i;
        this.f9821b = obj;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.f9820a) {
            case 0:
                return ArrayUtils.lambda$toObject$19((float[]) this.f9821b, i);
            case 1:
                return ArrayUtils.lambda$toObject$17((char[]) this.f9821b, i);
            case 2:
                return ArrayUtils.lambda$toObject$20((int[]) this.f9821b, i);
            case 3:
                return ArrayUtils.lambda$toObject$15((boolean[]) this.f9821b, i);
            case 4:
                return ArrayUtils.lambda$toObject$18((double[]) this.f9821b, i);
            case 5:
                return ArrayUtils.lambda$toObject$21((long[]) this.f9821b, i);
            case 6:
                return ArrayUtils.lambda$toObject$22((short[]) this.f9821b, i);
            case 7:
                return ArrayUtils.lambda$toObject$16((byte[]) this.f9821b, i);
            case 8:
                return ClassUtils.lambda$toClass$7((Object[]) this.f9821b, i);
            case 9:
                return Functions.lambda$tryWithResources$16((Functions.FailableRunnable[]) this.f9821b, i);
            default:
                return AlphabetConverter.lambda$convertCharsToIntegers$0((Character[]) this.f9821b, i);
        }
    }
}
