package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlin.comparisons.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13003a implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9319a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9320b;

    public /* synthetic */ C13003a(Object obj, int i) {
        this.f9319a = i;
        this.f9320b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9319a) {
            case 0:
                return ComparisonsKt__ComparisonsKt.nullsLast$lambda$4$ComparisonsKt__ComparisonsKt((Comparator) this.f9320b, obj, obj2);
            case 1:
                return ComparisonsKt__ComparisonsKt.nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt((Comparator) this.f9320b, obj, obj2);
            default:
                return ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt((Function1[]) this.f9320b, obj, obj2);
        }
    }
}
