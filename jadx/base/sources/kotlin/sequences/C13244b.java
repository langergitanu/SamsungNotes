package kotlin.sequences;

import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: kotlin.sequences.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13244b implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9385a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9386b;

    public /* synthetic */ C13244b(Object obj, int i) {
        this.f9385a = i;
        this.f9386b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f9385a) {
            case 0:
                return SequencesKt__SequencesKt.generateSequence$lambda$4$SequencesKt__SequencesKt((Function0) this.f9386b, obj);
            case 1:
                return Boolean.valueOf(((Class) this.f9386b).isInstance(obj));
            case 2:
                return SequencesKt___SequencesKt.requireNoNulls$lambda$16$SequencesKt___SequencesKt((Sequence) this.f9386b, obj);
            case 3:
                return Boolean.valueOf(SequencesKt___SequencesKt.filterIndexed$lambda$2$SequencesKt___SequencesKt((Function2) this.f9386b, (IndexedValue) obj));
            case 4:
                return SequencesKt___SequencesKt.onEach$lambda$14$SequencesKt___SequencesKt((Function1) this.f9386b, obj);
            case 5:
                return Boolean.valueOf(ArraysKt.contains((Object[]) this.f9386b, obj));
            case 6:
                return Boolean.valueOf(((Collection) this.f9386b).contains(obj));
            default:
                return Boolean.valueOf(((List) this.f9386b).contains(obj));
        }
    }
}
