package kotlin.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlin.text.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13256c implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9395a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9396b;

    public /* synthetic */ C13256c(Object obj, int i) {
        this.f9395a = i;
        this.f9396b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9395a) {
            case 0:
                return StringsKt__IndentKt.prependIndent$lambda$5$StringsKt__IndentKt((String) this.f9396b, (String) obj);
            case 1:
                return StringsKt__IndentKt.getIndentFunction$lambda$9$StringsKt__IndentKt((String) this.f9396b, (String) obj);
            default:
                return ((MatcherMatchResult$groups$1) this.f9396b).get(((Integer) obj).intValue());
        }
    }
}
