package kotlin.text;

import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: kotlin.text.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13259f implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9400a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f9401b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9402c;

    public /* synthetic */ C13259f(int i, Object obj, boolean z) {
        this.f9400a = i;
        this.f9402c = obj;
        this.f9401b = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f9400a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$14$StringsKt__StringsKt((char[]) this.f9402c, this.f9401b, (CharSequence) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return StringsKt__StringsKt.rangesDelimitedBy$lambda$16$StringsKt__StringsKt((List) this.f9402c, this.f9401b, (CharSequence) obj, iIntValue2);
        }
    }
}
