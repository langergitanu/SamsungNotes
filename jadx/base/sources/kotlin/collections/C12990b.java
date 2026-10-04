package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ArrayIteratorsKt;

/* JADX INFO: renamed from: kotlin.collections.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C12990b implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9314a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9315b;

    public /* synthetic */ C12990b(Object obj, int i) {
        this.f9314a = i;
        this.f9315b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f9314a) {
            case 0:
                return ArrayIteratorsKt.iterator((int[]) this.f9315b);
            case 1:
                return ArrayIteratorsKt.iterator((double[]) this.f9315b);
            case 2:
                return ArrayIteratorsKt.iterator((char[]) this.f9315b);
            case 3:
                return ArrayIteratorsKt.iterator((short[]) this.f9315b);
            case 4:
                return ArrayIteratorsKt.iterator((float[]) this.f9315b);
            case 5:
                return ArrayIteratorsKt.iterator((boolean[]) this.f9315b);
            case 6:
                return ArrayIteratorsKt.iterator((long[]) this.f9315b);
            case 7:
                return ArrayIteratorsKt.iterator((byte[]) this.f9315b);
            case 8:
                return ArrayIteratorKt.iterator((Object[]) this.f9315b);
            default:
                return ((Iterable) this.f9315b).iterator();
        }
    }
}
