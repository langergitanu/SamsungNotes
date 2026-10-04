package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, m13886d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyListHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyListHeaders.kt\nandroidx/compose/foundation/lazy/LazyListHeadersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,95:1\n1#2:96\n69#3,6:97\n*S KotlinDebug\n*F\n+ 1 LazyListHeaders.kt\nandroidx/compose/foundation/lazy/LazyListHeadersKt\n*L\n57#1:97,6\n*E\n"})
public final class LazyListHeadersKt {
    @Nullable
    public static final LazyListMeasuredItem findOrComposeLazyListHeader(@NotNull List<LazyListMeasuredItem> list, @NotNull LazyListMeasuredItemProvider lazyListMeasuredItemProvider, @NotNull List<Integer> list2, int i, int i2, int i4) {
        int index = ((LazyListMeasuredItem) CollectionsKt.first((List) list)).getIndex();
        int size = list2.size();
        int iIntValue = -1;
        int iIntValue2 = -1;
        int i5 = 0;
        while (i5 < size && list2.get(i5).intValue() <= index) {
            iIntValue2 = list2.get(i5).intValue();
            i5++;
            iIntValue = ((i5 < 0 || i5 > CollectionsKt.getLastIndex(list2)) ? -1 : list2.get(i5)).intValue();
        }
        int size2 = list.size();
        int offset = Integer.MIN_VALUE;
        int offset2 = Integer.MIN_VALUE;
        int i6 = -1;
        for (int i7 = 0; i7 < size2; i7++) {
            LazyListMeasuredItem lazyListMeasuredItem = list.get(i7);
            if (lazyListMeasuredItem.getIndex() == iIntValue2) {
                offset = lazyListMeasuredItem.getOffset();
                i6 = i7;
            } else if (lazyListMeasuredItem.getIndex() == iIntValue) {
                offset2 = lazyListMeasuredItem.getOffset();
            }
        }
        if (iIntValue2 == -1) {
            return null;
        }
        LazyListMeasuredItem lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, iIntValue2, 0L, 2, null);
        lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default.setNonScrollableItem(true);
        int iMax = offset != Integer.MIN_VALUE ? Math.max(-i, offset) : -i;
        if (offset2 != Integer.MIN_VALUE) {
            iMax = Math.min(iMax, offset2 - lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default.getSize());
        }
        lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default.position(iMax, i2, i4);
        if (i6 != -1) {
            list.set(i6, lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default);
            return lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default;
        }
        list.add(0, lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default);
        return lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default;
    }
}
