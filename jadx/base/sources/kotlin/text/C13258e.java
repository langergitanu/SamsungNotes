package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: renamed from: kotlin.text.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13258e implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9398a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CharSequence f9399b;

    public /* synthetic */ C13258e(CharSequence charSequence, int i) {
        this.f9398a = i;
        this.f9399b = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9398a) {
            case 0:
                return StringsKt__StringsKt.splitToSequence$lambda$20$StringsKt__StringsKt(this.f9399b, (IntRange) obj);
            default:
                return StringsKt__StringsKt.splitToSequence$lambda$18$StringsKt__StringsKt(this.f9399b, (IntRange) obj);
        }
    }
}
