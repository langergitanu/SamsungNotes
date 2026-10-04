package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\\\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002\u001a4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a£\u0002\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0002012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092/\u0010:\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<¢\u0006\u0002\b?\u0012\u0004\u0012\u00020@0;H\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, m13886d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "consumedScroll", "", "isLookingAhead", "lastPostLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "hasLookaheadPassOccurred", "postLookaheadLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", DBSchema.DocumentThumbnail.LAYOUT, "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-x0Ok8Vo", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyListMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyListMeasure.kt\nandroidx/compose/foundation/lazy/LazyListMeasureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,650:1\n1#2:651\n26#3:652\n26#3:653\n26#3:654\n33#4,6:655\n33#4,6:661\n33#4,6:667\n235#4,3:673\n33#4,4:676\n238#4,2:680\n38#4:682\n240#4:683\n116#4,2:684\n33#4,6:686\n118#4:692\n116#4,2:693\n33#4,6:695\n118#4:701\n116#4,2:702\n33#4,6:704\n118#4:710\n33#4,6:711\n51#4,6:717\n33#4,6:723\n33#4,6:729\n33#4,6:735\n*S KotlinDebug\n*F\n+ 1 LazyListMeasure.kt\nandroidx/compose/foundation/lazy/LazyListMeasureKt\n*L\n134#1:652\n259#1:653\n260#1:654\n307#1:655,6\n324#1:661,6\n380#1:667,6\n417#1:673,3\n417#1:676,4\n417#1:680,2\n417#1:682\n417#1:683\n478#1:684,2\n478#1:686,6\n478#1:692\n495#1:693,2\n495#1:695,6\n495#1:701\n497#1:702,2\n497#1:704,6\n497#1:710\n518#1:711,6\n545#1:717,6\n629#1:723,6\n636#1:729,6\n642#1:735,6\n*E\n"})
public final class LazyListMeasureKt {
    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i4, int i5, int i6, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i7 = z ? i2 : i;
        boolean z3 = i4 < Math.min(i7, i5);
        if (z3 && i6 != 0) {
            throw new IllegalStateException("non-zero itemsScrollOffset");
        }
        ArrayList arrayList = new ArrayList(list3.size() + list2.size() + list.size());
        if (!z3) {
            int size = list2.size();
            int mainAxisSizeWithSpacings = i6;
            for (int i8 = 0; i8 < size; i8++) {
                LazyListMeasuredItem lazyListMeasuredItem = list2.get(i8);
                mainAxisSizeWithSpacings -= lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem.position(mainAxisSizeWithSpacings, i, i2);
                arrayList.add(lazyListMeasuredItem);
            }
            int size2 = list.size();
            int mainAxisSizeWithSpacings2 = i6;
            for (int i9 = 0; i9 < size2; i9++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i9);
                lazyListMeasuredItem2.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem2);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
            }
            int size3 = list3.size();
            for (int i10 = 0; i10 < size3; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list3.get(i10);
                lazyListMeasuredItem3.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i11 = 0; i11 < size4; i11++) {
                iArr[i11] = list.get(calculateItemsOffsets$reverseAware(i11, z2, size4)).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i12 = 0; i12 < size4; i12++) {
                iArr2[i12] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                }
                vertical.arrange(density, i7, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                }
                horizontal.arrange(density, i7, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            IntProgression intProgressionReversed = indices;
            if (z2) {
                intProgressionReversed = RangesKt___RangesKt.reversed(indices);
            }
            int first = intProgressionReversed.getFirst();
            int last = intProgressionReversed.getLast();
            int step = intProgressionReversed.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size5 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem4 = list.get(calculateItemsOffsets$reverseAware(first, z2, size4));
                    if (z2) {
                        size5 = (i7 - size5) - lazyListMeasuredItem4.getSize();
                    }
                    lazyListMeasuredItem4.position(size5, i, i2);
                    arrayList.add(lazyListMeasuredItem4);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2, float f, boolean z, LazyListLayoutInfo lazyListLayoutInfo) {
        ArrayList arrayList;
        LazyListItemInfo lazyListItemInfo;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int mainAxisSizeWithSpacings;
        LazyListMeasuredItem lazyListMeasuredItem3;
        int index;
        int iMin;
        LazyListMeasuredItem lazyListMeasuredItem4;
        LazyListMeasuredItem lazyListMeasuredItem5;
        int i4 = i - 1;
        int iMin2 = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + i2, i4);
        int index2 = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        if (index2 <= iMin2) {
            int i5 = index2;
            arrayList = null;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i5, 0L, 2, null));
                if (i5 == iMin2) {
                    break;
                }
                i5++;
            }
        } else {
            arrayList = null;
        }
        if (z && lazyListLayoutInfo != null && !lazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            List<LazyListItemInfo> visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyListItemInfo = null;
                    break;
                }
                if (visibleItemsInfo.get(size).getIndex() > iMin2 && (size == 0 || visibleItemsInfo.get(size - 1).getIndex() <= iMin2)) {
                    break;
                }
            }
            lazyListItemInfo = visibleItemsInfo.get(size);
            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) CollectionsKt.last((List) lazyListLayoutInfo.getVisibleItemsInfo());
            if (lazyListItemInfo != null && (index = lazyListItemInfo.getIndex()) <= (iMin = Math.min(lazyListItemInfo2.getIndex(), i4))) {
                int i6 = index;
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size2) {
                                lazyListMeasuredItem5 = null;
                                break;
                            }
                            lazyListMeasuredItem5 = arrayList.get(i7);
                            if (lazyListMeasuredItem5.getIndex() == i6) {
                                break;
                            }
                            i7++;
                        }
                        lazyListMeasuredItem4 = lazyListMeasuredItem5;
                    } else {
                        lazyListMeasuredItem4 = null;
                    }
                    if (lazyListMeasuredItem4 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i6, 0L, 2, null));
                    }
                    if (i6 == iMin) {
                        break;
                    }
                    i6++;
                }
            }
            float viewportEndOffset = ((lazyListLayoutInfo.getViewportEndOffset() - lazyListItemInfo2.getOffset()) - lazyListItemInfo2.getSize()) - f;
            if (viewportEndOffset > 0.0f) {
                int index3 = lazyListItemInfo2.getIndex() + 1;
                int i8 = 0;
                while (index3 < i && i8 < viewportEndOffset) {
                    if (index3 <= iMin2) {
                        int size3 = list.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 >= size3) {
                                lazyListMeasuredItem3 = null;
                                break;
                            }
                            lazyListMeasuredItem3 = list.get(i9);
                            if (lazyListMeasuredItem3.getIndex() == index3) {
                                break;
                            }
                            i9++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem3;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size4) {
                                lazyListMeasuredItem2 = null;
                                break;
                            }
                            lazyListMeasuredItem2 = arrayList.get(i10);
                            if (lazyListMeasuredItem2.getIndex() == index3) {
                                break;
                            }
                            i10++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem2;
                    } else {
                        lazyListMeasuredItem = null;
                    }
                    if (lazyListMeasuredItem != null) {
                        index3++;
                        mainAxisSizeWithSpacings = lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index3, 0L, 2, null));
                        index3++;
                        mainAxisSizeWithSpacings = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getMainAxisSizeWithSpacings();
                    }
                    i8 += mainAxisSizeWithSpacings;
                }
            }
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex() > iMin2) {
            iMin2 = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i11 = 0; i11 < size5; i11++) {
            int iIntValue = list2.get(i11).intValue();
            if (iIntValue > iMin2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, iIntValue, 0L, 2, null));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int iMax = Math.max(0, i - i2);
        int i4 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i4) {
            int i5 = i4;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i5, 0L, 2, null));
                if (i5 == iMax) {
                    break;
                }
                i5--;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i6 = size - 1;
                int iIntValue = list.get(size).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, iIntValue, 0L, 2, null));
                }
                if (i6 < 0) {
                    break;
                }
                size = i6;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0375  */
    @NotNull
    /* JADX INFO: renamed from: measureLazyList-x0Ok8Vo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyListMeasureResult m15961measureLazyListx0Ok8Vo(int i, @NotNull LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i4, int i5, int i6, int i7, int i8, float f, long j, boolean z, @NotNull List<Integer> list, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, boolean z2, @NotNull Density density, @NotNull LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, int i9, @NotNull List<Integer> list2, boolean z3, final boolean z4, @Nullable LazyListLayoutInfo lazyListLayoutInfo, @NotNull CoroutineScope coroutineScope, @NotNull final MutableState<Unit> mutableState, @NotNull GraphicsContext graphicsContext, @NotNull Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        List<LazyListMeasuredItem> list3;
        int i20;
        int i21 = i4;
        if (i21 < 0) {
            throw new IllegalArgumentException("invalid beforeContentPadding");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("invalid afterContentPadding");
        }
        if (i <= 0) {
            int iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(j);
            int iM20922getMinHeightimpl = Constraints.m20922getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, iM20923getMinWidthimpl, iM20922getMinHeightimpl, new ArrayList(), lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long jM16019getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m16019getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m21136equalsimpl0(jM16019getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
                    iM20923getMinWidthimpl = ConstraintsKt.m20938constrainWidthK40F9xA(j, IntSize.m21138getWidthimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g));
                    iM20922getMinHeightimpl = ConstraintsKt.m20937constrainHeightK40F9xA(j, IntSize.m21137getHeightimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g));
                }
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(iM20923getMinWidthimpl), Integer.valueOf(iM20922getMinHeightimpl), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), 0.0f, false, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), CollectionsKt.emptyList(), -i21, i2 + i5, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5, i6, null);
        }
        int i22 = i7;
        if (i22 >= i) {
            i22 = i - 1;
            i10 = 0;
        } else {
            i10 = i8;
        }
        int iRound = Math.round(f);
        int i23 = i10 - iRound;
        if (i22 == 0 && i23 < 0) {
            iRound += i23;
            i23 = 0;
        }
        int i24 = iRound;
        ArrayDeque arrayDeque = new ArrayDeque();
        int i25 = -i21;
        int i26 = (i6 < 0 ? i6 : 0) + i25;
        int mainAxisSizeWithSpacings = i23 + i26;
        int iMax = 0;
        while (mainAxisSizeWithSpacings < 0 && i22 > 0) {
            int i27 = i22 - 1;
            int i28 = i26;
            LazyListMeasuredItem lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i27, 0L, 2, null);
            arrayDeque.add(0, lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default);
            iMax = Math.max(iMax, lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default.getCrossAxisSize());
            mainAxisSizeWithSpacings = lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings;
            i22 = i27;
            i26 = i28;
            i25 = i25;
            i24 = i24;
        }
        int i29 = iMax;
        int i30 = i24;
        int i31 = i25;
        int i32 = mainAxisSizeWithSpacings;
        int i33 = i26;
        if (i32 < i33) {
            i12 = i30 + i32;
            i11 = i33;
        } else {
            i11 = i32;
            i12 = i30;
        }
        int i34 = i11 - i33;
        int i35 = i2 + i5;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i35, 0);
        int mainAxisSizeWithSpacings2 = -i34;
        int i36 = i22;
        int i37 = 0;
        boolean z5 = false;
        while (i37 < arrayDeque.size()) {
            if (mainAxisSizeWithSpacings2 >= iCoerceAtLeast) {
                arrayDeque.remove(i37);
                z5 = true;
            } else {
                i36++;
                mainAxisSizeWithSpacings2 += ((LazyListMeasuredItem) arrayDeque.get(i37)).getMainAxisSizeWithSpacings();
                i37++;
            }
        }
        int i38 = i22;
        int i39 = i29;
        int mainAxisSizeWithSpacings3 = i34;
        int i40 = mainAxisSizeWithSpacings2;
        boolean z6 = z5;
        int i41 = i35;
        int i42 = i36;
        while (i42 < i && (i40 < iCoerceAtLeast || i40 <= 0 || arrayDeque.isEmpty())) {
            int i43 = i41;
            int i44 = i40;
            int i45 = iCoerceAtLeast;
            int i46 = i38;
            int i47 = mainAxisSizeWithSpacings3;
            int i48 = i39;
            LazyListMeasuredItem lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default2 = LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i42, 0L, 2, null);
            int i49 = i42;
            int mainAxisSizeWithSpacings4 = lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings() + i44;
            if (mainAxisSizeWithSpacings4 > i33 || i49 == i - 1) {
                int iMax2 = Math.max(i48, lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default2.getCrossAxisSize());
                arrayDeque.add(lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default2);
                mainAxisSizeWithSpacings3 = i47;
                i48 = iMax2;
                i20 = i46;
            } else {
                i20 = i49 + 1;
                mainAxisSizeWithSpacings3 = i47 - lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
                z6 = true;
            }
            i40 = mainAxisSizeWithSpacings4;
            i41 = i43;
            i42 = i49 + 1;
            i39 = i48;
            i38 = i20;
            iCoerceAtLeast = i45;
        }
        int i50 = i41;
        int i51 = i38;
        int i52 = mainAxisSizeWithSpacings3;
        int iMax3 = i39;
        int i53 = i42;
        int i54 = i40;
        if (i54 < i2) {
            int i55 = i2 - i54;
            int i56 = i54 + i55;
            int mainAxisSizeWithSpacings5 = i52 - i55;
            i15 = i51;
            while (mainAxisSizeWithSpacings5 < i21 && i15 > 0) {
                i15--;
                int i57 = mainAxisSizeWithSpacings5;
                LazyListMeasuredItem lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default3 = LazyListMeasuredItemProvider.m15967getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i15, 0L, 2, null);
                arrayDeque.add(0, lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default3);
                iMax3 = Math.max(iMax3, lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default3.getCrossAxisSize());
                mainAxisSizeWithSpacings5 = lazyListMeasuredItemM15967getAndMeasure0kLqBqw$default3.getMainAxisSizeWithSpacings() + i57;
                i53 = i53;
                i21 = i4;
            }
            i13 = i53;
            int i58 = mainAxisSizeWithSpacings5;
            i14 = 0;
            i16 = i55 + i12;
            if (i58 < 0) {
                i16 += i58;
                int i59 = i56 + i58;
                i18 = 0;
                i17 = i59;
            } else {
                i17 = i56;
                i18 = i58;
            }
        } else {
            i13 = i53;
            i14 = 0;
            i15 = i51;
            i16 = i12;
            i17 = i54;
            i18 = i52;
        }
        float f4 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(i16) || Math.abs(Math.round(f)) < Math.abs(i16)) ? f : i16;
        float f5 = f - f4;
        float f6 = 0.0f;
        if (z4 && i16 > i12 && f5 <= 0.0f) {
            f6 = (i16 - i12) + f5;
        }
        float f7 = f6;
        if (i18 < 0) {
            throw new IllegalArgumentException("negative currentFirstItemScrollOffset");
        }
        int i60 = -i18;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque.first();
        if (i4 > 0 || i6 < 0) {
            int size = arrayDeque.size();
            int i61 = i14;
            while (i61 < size) {
                int mainAxisSizeWithSpacings6 = ((LazyListMeasuredItem) arrayDeque.get(i61)).getMainAxisSizeWithSpacings();
                if (i18 == 0 || mainAxisSizeWithSpacings6 > i18 || i61 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i18 -= mainAxisSizeWithSpacings6;
                i61++;
                lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque.get(i61);
            }
        }
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        int i62 = i18;
        LazyListMeasuredItem lazyListMeasuredItem2 = lazyListMeasuredItem;
        List<LazyListMeasuredItem> listCreateItemsBeforeList = createItemsBeforeList(i15, lazyListMeasuredItemProvider2, i9, list2);
        int size2 = listCreateItemsBeforeList.size();
        int i63 = 0;
        while (i63 < size2) {
            iMax3 = Math.max(iMax3, listCreateItemsBeforeList.get(i63).getCrossAxisSize());
            i63++;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        List<LazyListMeasuredItem> listCreateItemsAfterList = createItemsAfterList(arrayDeque, lazyListMeasuredItemProvider2, i, i9, list2, f4, z4, lazyListLayoutInfo);
        int size3 = listCreateItemsAfterList.size();
        for (int i64 = 0; i64 < size3; i64++) {
            iMax3 = Math.max(iMax3, listCreateItemsAfterList.get(i64).getCrossAxisSize());
        }
        boolean z7 = Intrinsics.areEqual(lazyListMeasuredItem2, arrayDeque.first()) && listCreateItemsBeforeList.isEmpty() && listCreateItemsAfterList.isEmpty();
        int iM20938constrainWidthK40F9xA = ConstraintsKt.m20938constrainWidthK40F9xA(j, z ? iMax3 : i17);
        if (z) {
            iMax3 = i17;
        }
        int iM20937constrainHeightK40F9xA = ConstraintsKt.m20937constrainHeightK40F9xA(j, iMax3);
        int iM20938constrainWidthK40F9xA2 = iM20938constrainWidthK40F9xA;
        float f8 = f4;
        final List<LazyListMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayDeque, listCreateItemsBeforeList, listCreateItemsAfterList, iM20938constrainWidthK40F9xA2, iM20937constrainHeightK40F9xA, i17, i2, i60, z, vertical, horizontal, z2, density);
        lazyLayoutItemAnimator.onMeasured((int) f8, iM20938constrainWidthK40F9xA2, iM20937constrainHeightK40F9xA, listCalculateItemsOffsets, lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, i62, i17, coroutineScope, graphicsContext);
        int i65 = i17;
        if (!z4) {
            long jM16019getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m16019getMinSizeToFitDisappearingItemsYbymL2g();
            if (IntSize.m21136equalsimpl0(jM16019getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
                i19 = iM20937constrainHeightK40F9xA;
            } else {
                int i66 = z ? iM20937constrainHeightK40F9xA : iM20938constrainWidthK40F9xA2;
                iM20938constrainWidthK40F9xA2 = ConstraintsKt.m20938constrainWidthK40F9xA(j, Math.max(iM20938constrainWidthK40F9xA2, IntSize.m21138getWidthimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g2)));
                int iM20937constrainHeightK40F9xA2 = ConstraintsKt.m20937constrainHeightK40F9xA(j, Math.max(iM20937constrainHeightK40F9xA, IntSize.m21137getHeightimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g2)));
                int i67 = z ? iM20937constrainHeightK40F9xA2 : iM20938constrainWidthK40F9xA2;
                if (i67 != i66) {
                    int size4 = listCalculateItemsOffsets.size();
                    for (int i68 = 0; i68 < size4; i68++) {
                        listCalculateItemsOffsets.get(i68).updateMainAxisLayoutSize(i67);
                    }
                }
                i19 = iM20937constrainHeightK40F9xA2;
            }
        }
        int i69 = iM20938constrainWidthK40F9xA2;
        final LazyListMeasuredItem lazyListMeasuredItemFindOrComposeLazyListHeader = !list.isEmpty() ? LazyListHeadersKt.findOrComposeLazyListHeader(listCalculateItemsOffsets, lazyListMeasuredItemProvider, list, i4, i69, i19) : null;
        boolean z8 = i13 < i || i65 > i2;
        MeasureResult measureResultInvoke = function3.invoke(Integer.valueOf(i69), Integer.valueOf(i19), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                List<LazyListMeasuredItem> list4 = listCalculateItemsOffsets;
                LazyListMeasuredItem lazyListMeasuredItem3 = lazyListMeasuredItemFindOrComposeLazyListHeader;
                boolean z9 = z4;
                int size5 = list4.size();
                for (int i70 = 0; i70 < size5; i70++) {
                    LazyListMeasuredItem lazyListMeasuredItem4 = list4.get(i70);
                    if (lazyListMeasuredItem4 != lazyListMeasuredItem3) {
                        lazyListMeasuredItem4.place(placementScope, z9);
                    }
                }
                LazyListMeasuredItem lazyListMeasuredItem5 = lazyListMeasuredItemFindOrComposeLazyListHeader;
                if (lazyListMeasuredItem5 != null) {
                    lazyListMeasuredItem5.place(placementScope, z4);
                }
                ObservableScopeInvalidator.m16028attachToScopeimpl(mutableState);
            }
        });
        if (z7) {
            list3 = listCalculateItemsOffsets;
        } else {
            ArrayList arrayList = new ArrayList(listCalculateItemsOffsets.size());
            int size5 = listCalculateItemsOffsets.size();
            for (int i70 = 0; i70 < size5; i70++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = listCalculateItemsOffsets.get(i70);
                LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem3;
                if ((lazyListMeasuredItem4.getIndex() >= ((LazyListMeasuredItem) arrayDeque.first()).getIndex() && lazyListMeasuredItem4.getIndex() <= ((LazyListMeasuredItem) arrayDeque.last()).getIndex()) || lazyListMeasuredItem4 == lazyListMeasuredItemFindOrComposeLazyListHeader) {
                    arrayList.add(lazyListMeasuredItem3);
                }
            }
            list3 = arrayList;
        }
        return new LazyListMeasureResult(lazyListMeasuredItem2, i62, z8, f8, measureResultInvoke, f7, z6, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), list3, i31, i50, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5, i6, null);
    }
}
