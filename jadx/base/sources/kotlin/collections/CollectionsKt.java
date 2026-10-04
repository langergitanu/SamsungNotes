package kotlin.collections;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"kotlin/collections/CollectionsKt__CollectionsJVMKt", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/CollectionsKt__IterablesKt", "kotlin/collections/CollectionsKt__IteratorsJVMKt", "kotlin/collections/CollectionsKt__IteratorsKt", "kotlin/collections/CollectionsKt__MutableCollectionsJVMKt", "kotlin/collections/CollectionsKt__MutableCollectionsKt", "kotlin/collections/CollectionsKt__ReversedViewsKt", "kotlin/collections/CollectionsKt___CollectionsJvmKt", "kotlin/collections/CollectionsKt___CollectionsKt"}, m13887k = 4, m13888mv = {2, 1, 0}, m13890xi = 49)
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    private CollectionsKt() {
    }

    /* JADX INFO: renamed from: k */
    public static /* bridge */ /* synthetic */ int m13952k(Iterable iterable) {
        return CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
    }

    /* JADX INFO: renamed from: n */
    public static /* bridge */ /* synthetic */ String m13955n(Iterable iterable, String str, String str2, String str3, Function1 function1, int i) throws IOException {
        return CollectionsKt___CollectionsKt.joinToString$default(iterable, str, str2, str3, 0, null, function1, i, null);
    }
}
