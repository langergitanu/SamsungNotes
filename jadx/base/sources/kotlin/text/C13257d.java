package kotlin.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlin.text.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13257d implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9397a;

    public /* synthetic */ C13257d(int i) {
        this.f9397a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9397a) {
            case 0:
                return StringsKt__IndentKt.getIndentFunction$lambda$8$StringsKt__IndentKt((String) obj);
            case 1:
                return StringsKt___StringsKt.windowed$lambda$23$StringsKt___StringsKt((CharSequence) obj);
            case 2:
                return StringsKt___StringsKt.windowedSequence$lambda$24$StringsKt___StringsKt((CharSequence) obj);
            default:
                return StringsKt___StringsKt.chunkedSequence$lambda$22$StringsKt___StringsKt((CharSequence) obj);
        }
    }
}
