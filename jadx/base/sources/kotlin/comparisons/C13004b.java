package kotlin.comparisons;

import java.util.Comparator;

/* JADX INFO: renamed from: kotlin.comparisons.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13004b implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9321a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Comparator f9322b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Comparator f9323c;

    public /* synthetic */ C13004b(Comparator comparator, Comparator comparator2, int i) {
        this.f9321a = i;
        this.f9322b = comparator;
        this.f9323c = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9321a) {
            case 0:
                return ComparisonsKt__ComparisonsKt.thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(this.f9322b, this.f9323c, obj, obj2);
            default:
                return ComparisonsKt__ComparisonsKt.then$lambda$1$ComparisonsKt__ComparisonsKt(this.f9322b, this.f9323c, obj, obj2);
        }
    }
}
