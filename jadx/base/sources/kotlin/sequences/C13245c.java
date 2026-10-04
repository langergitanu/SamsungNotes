package kotlin.sequences;

import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlin.sequences.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13245c implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9387a;

    public /* synthetic */ C13245c(int i) {
        this.f9387a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9387a) {
            case 0:
                return SequencesKt__SequencesKt.flatten$lambda$1$SequencesKt__SequencesKt((Sequence) obj);
            case 1:
                return SequencesKt__SequencesKt.flatten$lambda$2$SequencesKt__SequencesKt((Iterable) obj);
            case 2:
                return SequencesKt__SequencesKt.flatten$lambda$3$SequencesKt__SequencesKt(obj);
            case 3:
                return SequencesKt___SequencesKt.filterIndexed$lambda$3$SequencesKt___SequencesKt((IndexedValue) obj);
            case 4:
                return Boolean.valueOf(SequencesKt___SequencesKt.filterNotNull$lambda$5$SequencesKt___SequencesKt(obj));
            default:
                return SequencesKt___SequencesKt.distinct$lambda$13$SequencesKt___SequencesKt(obj);
        }
    }
}
