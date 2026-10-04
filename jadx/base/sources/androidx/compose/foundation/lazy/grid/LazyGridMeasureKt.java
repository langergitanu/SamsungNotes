package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
@Metadata(m13885d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0083\b\u001a\u008c\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a¸\u0002\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-2\u0006\u0010.\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020423\u00105\u001a/\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+090\u00010\n2/\u0010:\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0\n¢\u0006\u0002\b>\u0012\u0004\u0012\u00020?0;H\u0000ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a+\u0010B\u001a\u00020=\"\u0004\b\u0000\u0010C*\b\u0012\u0004\u0012\u0002HC0\r2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002HC0EH\u0002¢\u0006\u0002\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, m13886d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "filter", "Lkotlin/Function1;", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "slotsPerLine", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", DBSchema.DocumentThumbnail.LAYOUT, "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-OZKpZRA", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "addAllFromArray", "T", "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyGridMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridMeasure.kt\nandroidx/compose/foundation/lazy/grid/LazyGridMeasureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,509:1\n393#1,3:514\n396#1,15:521\n412#1:537\n393#1,3:538\n396#1,15:545\n412#1:561\n1#2:510\n26#3:511\n26#3:512\n26#3:513\n33#4,4:517\n38#4:536\n33#4,4:541\n38#4:560\n33#4,6:562\n235#4,3:568\n33#4,4:571\n238#4,2:575\n38#4:577\n240#4:578\n33#4,6:579\n132#4,3:585\n33#4,4:588\n135#4,2:592\n38#4:594\n137#4:595\n51#4,6:596\n33#4,6:602\n33#4,6:608\n*S KotlinDebug\n*F\n+ 1 LazyGridMeasure.kt\nandroidx/compose/foundation/lazy/grid/LazyGridMeasureKt\n*L\n263#1:514,3\n263#1:521,15\n263#1:537\n270#1:538,3\n270#1:545,15\n270#1:561\n126#1:511\n248#1:512\n249#1:513\n263#1:517,4\n263#1:536\n270#1:541,4\n270#1:560\n346#1:562,6\n368#1:568,3\n368#1:571,4\n368#1:575,2\n368#1:577\n368#1:578\n395#1:579,6\n439#1:585,3\n439#1:588,4\n439#1:592,2\n439#1:594\n439#1:595\n482#1:596,6\n489#1:602,6\n494#1:608,6\n*E\n"})
public final class LazyGridMeasureKt {
    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t : tArr) {
            list.add(t);
        }
    }

    @ExperimentalFoundationApi
    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, Function1<? super Integer, Boolean> function1) {
        LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int size = list.size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            int iIntValue = list.get(i).intValue();
            if (function1.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                int iSpanOf = lazyGridMeasuredLineProvider.spanOf(iIntValue);
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                LazyGridMeasuredItem lazyGridMeasuredItemMo15968getAndMeasurehBUhpc = lazyGridMeasuredItemProvider2.mo15968getAndMeasurehBUhpc(iIntValue, 0, iSpanOf, lazyGridMeasuredLineProvider.m15999childConstraintsJhjzzOo$foundation_release(0, iSpanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyGridMeasuredItemMo15968getAndMeasurehBUhpc);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i4, int i5, int i6, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i7 = z ? i2 : i;
        boolean z3 = i4 < Math.min(i7, i5);
        if (z3 && i6 != 0) {
            throw new IllegalStateException("non-zero firstLineScrollOffset");
        }
        int size = list.size();
        int length = 0;
        for (int i8 = 0; i8 < size; i8++) {
            length += list.get(i8).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (!z3) {
            int size2 = list2.size() - 1;
            if (size2 >= 0) {
                int mainAxisSizeWithSpacings = i6;
                while (true) {
                    int i9 = size2 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size2);
                    mainAxisSizeWithSpacings -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(mainAxisSizeWithSpacings, 0, i, i2);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i9 < 0) {
                        break;
                    }
                    size2 = i9;
                }
            }
            int size3 = list.size();
            int mainAxisSizeWithSpacings2 = i6;
            for (int i10 = 0; i10 < size3; i10++) {
                LazyGridMeasuredLine lazyGridMeasuredLine = list.get(i10);
                addAllFromArray(arrayList, lazyGridMeasuredLine.position(mainAxisSizeWithSpacings2, i, i2));
                mainAxisSizeWithSpacings2 += lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int i11 = 0; i11 < size4; i11++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i11);
                lazyGridMeasuredItem2.position(mainAxisSizeWithSpacings2, 0, i, i2);
                arrayList.add(lazyGridMeasuredItem2);
                mainAxisSizeWithSpacings2 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no items");
            }
            int size5 = list.size();
            int[] iArr = new int[size5];
            for (int i12 = 0; i12 < size5; i12++) {
                iArr[i12] = list.get(calculateItemsOffsets$reverseAware(i12, z2, size5)).getMainAxisSize();
            }
            int[] iArr2 = new int[size5];
            for (int i13 = 0; i13 < size5; i13++) {
                iArr2[i13] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement");
                }
                vertical.arrange(density, i7, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement");
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
                    int mainAxisSize = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(calculateItemsOffsets$reverseAware(first, z2, size5));
                    if (z2) {
                        mainAxisSize = (i7 - mainAxisSize) - lazyGridMeasuredLine2.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine2.position(mainAxisSize, i, i2));
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

    /* JADX WARN: Removed duplicated region for block: B:171:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a9  */
    @NotNull
    /* JADX INFO: renamed from: measureLazyGrid-OZKpZRA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyGridMeasureResult m15995measureLazyGridOZKpZRA(int i, @NotNull LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, @NotNull LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i4, int i5, int i6, int i7, int i8, float f, long j, boolean z, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, boolean z2, @NotNull Density density, @NotNull LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, int i9, @NotNull List<Integer> list, @NotNull CoroutineScope coroutineScope, @NotNull final MutableState<Unit> mutableState, @NotNull GraphicsContext graphicsContext, @NotNull Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, @NotNull Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i10;
        int i11;
        int i12;
        ArrayDeque arrayDeque;
        int i13;
        int iM20937constrainHeightK40F9xA;
        List list2;
        int i14;
        int i15;
        int i16;
        ArrayDeque arrayDeque2;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int i22;
        int i23;
        if (i4 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding");
        }
        if (i <= 0) {
            int iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(j);
            int iM20922getMinHeightimpl = Constraints.m20922getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, iM20923getMinWidthimpl, iM20922getMinHeightimpl, new ArrayList(), lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, false, i9, false, 0, 0, coroutineScope, graphicsContext);
            long jM16019getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m16019getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m21136equalsimpl0(jM16019getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
                iM20923getMinWidthimpl = ConstraintsKt.m20938constrainWidthK40F9xA(j, IntSize.m21138getWidthimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g));
                iM20922getMinHeightimpl = ConstraintsKt.m20937constrainHeightK40F9xA(j, IntSize.m21137getHeightimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g));
            }
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(iM20923getMinWidthimpl), Integer.valueOf(iM20922getMinHeightimpl), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, coroutineScope, density, i9, function1, CollectionsKt.emptyList(), -i4, i2 + i5, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5, i6);
        }
        int iRound = Math.round(f);
        int i24 = i8 - iRound;
        if (i7 == 0 && i24 < 0) {
            iRound += i24;
            i24 = 0;
        }
        ArrayDeque arrayDeque3 = new ArrayDeque();
        int i25 = -i4;
        int i26 = (i6 < 0 ? i6 : 0) + i25;
        int mainAxisSizeWithSpacings = i24 + i26;
        int i27 = i7;
        while (mainAxisSizeWithSpacings < 0 && i27 > 0) {
            i27--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i27);
            arrayDeque3.add(0, andMeasure);
            mainAxisSizeWithSpacings += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (mainAxisSizeWithSpacings < i26) {
            iRound += mainAxisSizeWithSpacings;
            mainAxisSizeWithSpacings = i26;
        }
        int mainAxisSizeWithSpacings2 = mainAxisSizeWithSpacings - i26;
        int i28 = i2 + i5;
        int i29 = iRound;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i28, 0);
        int i30 = i27;
        int i31 = i30;
        int i32 = i25;
        int mainAxisSizeWithSpacings3 = -mainAxisSizeWithSpacings2;
        int i33 = 0;
        boolean z3 = false;
        while (i33 < arrayDeque3.size()) {
            if (mainAxisSizeWithSpacings3 >= iCoerceAtLeast) {
                arrayDeque3.remove(i33);
                z3 = true;
            } else {
                i31++;
                mainAxisSizeWithSpacings3 += ((LazyGridMeasuredLine) arrayDeque3.get(i33)).getMainAxisSizeWithSpacings();
                i33++;
            }
        }
        int i34 = i31;
        while (i34 < i && (mainAxisSizeWithSpacings3 < iCoerceAtLeast || mainAxisSizeWithSpacings3 <= 0 || arrayDeque3.isEmpty())) {
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i34);
            if (andMeasure2.isEmpty()) {
                break;
            }
            int mainAxisSizeWithSpacings4 = andMeasure2.getMainAxisSizeWithSpacings() + mainAxisSizeWithSpacings3;
            if (mainAxisSizeWithSpacings4 <= i26) {
                i22 = iCoerceAtLeast;
                i23 = mainAxisSizeWithSpacings4;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    mainAxisSizeWithSpacings2 -= andMeasure2.getMainAxisSizeWithSpacings();
                    i30 = i34 + 1;
                    z3 = true;
                }
                i34++;
                mainAxisSizeWithSpacings3 = i23;
                iCoerceAtLeast = i22;
            } else {
                i22 = iCoerceAtLeast;
                i23 = mainAxisSizeWithSpacings4;
            }
            arrayDeque3.add(andMeasure2);
            i34++;
            mainAxisSizeWithSpacings3 = i23;
            iCoerceAtLeast = i22;
        }
        if (mainAxisSizeWithSpacings3 < i2) {
            int i35 = i2 - mainAxisSizeWithSpacings3;
            mainAxisSizeWithSpacings2 -= i35;
            mainAxisSizeWithSpacings3 += i35;
            while (mainAxisSizeWithSpacings2 < i4 && i30 > 0) {
                int i36 = i30 - 1;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i36);
                arrayDeque3.add(0, andMeasure3);
                mainAxisSizeWithSpacings2 += andMeasure3.getMainAxisSizeWithSpacings();
                i30 = i36;
            }
            i10 = i29 + i35;
            if (mainAxisSizeWithSpacings2 < 0) {
                i10 += mainAxisSizeWithSpacings2;
                i11 = mainAxisSizeWithSpacings3 + mainAxisSizeWithSpacings2;
                i12 = 0;
            }
            float f4 = (MathKt.getSign(Math.round(f)) == MathKt.getSign(i10) || Math.abs(Math.round(f)) < Math.abs(i10)) ? f : i10;
            if (i12 >= 0) {
                throw new IllegalArgumentException("negative initial offset");
            }
            int i37 = -i12;
            LazyGridMeasuredLine lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque3.first();
            LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine.getItems());
            int index = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.getIndex() : 0;
            LazyGridMeasuredLine lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque3.lastOrNull();
            int index2 = (lazyGridMeasuredLine2 == null || (items = lazyGridMeasuredLine2.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) ? 0 : lazyGridMeasuredItem.getIndex();
            int size = list.size();
            List listEmptyList = null;
            List listEmptyList2 = null;
            int i38 = 0;
            while (i38 < size) {
                int i39 = i38;
                int iIntValue = list.get(i38).intValue();
                if (iIntValue < 0 || iIntValue >= index) {
                    i16 = i12;
                    arrayDeque2 = arrayDeque3;
                    i17 = index;
                    i18 = index2;
                    i19 = i28;
                    i20 = i32;
                    i21 = size;
                } else {
                    int i40 = index;
                    int iSpanOf = lazyGridMeasuredLineProvider.spanOf(iIntValue);
                    arrayDeque2 = arrayDeque3;
                    i20 = i32;
                    i17 = i40;
                    i19 = i28;
                    i18 = index2;
                    i21 = size;
                    i16 = i12;
                    LazyGridMeasuredItem lazyGridMeasuredItemMo15968getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo15968getAndMeasurehBUhpc(iIntValue, 0, iSpanOf, lazyGridMeasuredLineProvider.m15999childConstraintsJhjzzOo$foundation_release(0, iSpanOf));
                    if (listEmptyList2 == null) {
                        listEmptyList2 = new ArrayList();
                    }
                    List list3 = listEmptyList2;
                    list3.add(lazyGridMeasuredItemMo15968getAndMeasurehBUhpc);
                    listEmptyList2 = list3;
                }
                i12 = i16;
                i38 = i39 + 1;
                arrayDeque3 = arrayDeque2;
                index2 = i18;
                size = i21;
                i32 = i20;
                i28 = i19;
                index = i17;
            }
            int i41 = i12;
            ArrayDeque arrayDeque4 = arrayDeque3;
            int i42 = index;
            int i43 = index2;
            int i44 = i28;
            int i45 = i32;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            int size2 = list.size();
            int i46 = 0;
            while (i46 < size2) {
                int iIntValue2 = list.get(i46).intValue();
                if (i43 + 1 > iIntValue2 || iIntValue2 >= i) {
                    i14 = size2;
                    i15 = i46;
                } else {
                    int iSpanOf2 = lazyGridMeasuredLineProvider.spanOf(iIntValue2);
                    i14 = size2;
                    i15 = i46;
                    LazyGridMeasuredItem lazyGridMeasuredItemMo15968getAndMeasurehBUhpc2 = lazyGridMeasuredItemProvider.mo15968getAndMeasurehBUhpc(iIntValue2, 0, iSpanOf2, lazyGridMeasuredLineProvider.m15999childConstraintsJhjzzOo$foundation_release(0, iSpanOf2));
                    if (listEmptyList == null) {
                        listEmptyList = new ArrayList();
                    }
                    List list4 = listEmptyList;
                    list4.add(lazyGridMeasuredItemMo15968getAndMeasurehBUhpc2);
                    listEmptyList = list4;
                }
                i46 = i15 + 1;
                size2 = i14;
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (i4 > 0 || i6 < 0) {
                int size3 = arrayDeque4.size();
                int i47 = i41;
                int i48 = 0;
                while (true) {
                    arrayDeque = arrayDeque4;
                    if (i48 >= size3) {
                        break;
                    }
                    int mainAxisSizeWithSpacings5 = ((LazyGridMeasuredLine) arrayDeque.get(i48)).getMainAxisSizeWithSpacings();
                    if (i47 == 0 || mainAxisSizeWithSpacings5 > i47 || i48 == CollectionsKt.getLastIndex(arrayDeque)) {
                        break;
                    }
                    i47 -= mainAxisSizeWithSpacings5;
                    i48++;
                    lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque.get(i48);
                    arrayDeque4 = arrayDeque;
                }
                i13 = i47;
            } else {
                arrayDeque = arrayDeque4;
                i13 = i41;
            }
            float f5 = f4;
            int i49 = i11;
            List list5 = listEmptyList;
            int iM20921getMaxWidthimpl = z ? Constraints.m20921getMaxWidthimpl(j) : ConstraintsKt.m20938constrainWidthK40F9xA(j, i11);
            ArrayDeque arrayDeque5 = arrayDeque;
            int iM20937constrainHeightK40F9xA2 = z ? ConstraintsKt.m20937constrainHeightK40F9xA(j, i11) : Constraints.m20920getMaxHeightimpl(j);
            List list6 = listEmptyList2;
            final List<LazyGridMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayDeque5, list6, list5, iM20921getMaxWidthimpl, iM20937constrainHeightK40F9xA2, i49, i2, i37, z, vertical, horizontal, z2, density);
            lazyLayoutItemAnimator.onMeasured((int) f5, iM20921getMaxWidthimpl, iM20937constrainHeightK40F9xA2, listCalculateItemsOffsets, lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, false, i9, false, i13, i49, coroutineScope, graphicsContext);
            long jM16019getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m16019getMinSizeToFitDisappearingItemsYbymL2g();
            if (IntSize.m21136equalsimpl0(jM16019getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
                iM20937constrainHeightK40F9xA = iM20937constrainHeightK40F9xA2;
            } else {
                int i50 = z ? iM20937constrainHeightK40F9xA2 : iM20921getMaxWidthimpl;
                iM20921getMaxWidthimpl = ConstraintsKt.m20938constrainWidthK40F9xA(j, Math.max(iM20921getMaxWidthimpl, IntSize.m21138getWidthimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g2)));
                iM20937constrainHeightK40F9xA = ConstraintsKt.m20937constrainHeightK40F9xA(j, Math.max(iM20937constrainHeightK40F9xA2, IntSize.m21137getHeightimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g2)));
                int i51 = z ? iM20937constrainHeightK40F9xA : iM20921getMaxWidthimpl;
                if (i51 != i50) {
                    int size4 = listCalculateItemsOffsets.size();
                    for (int i52 = 0; i52 < size4; i52++) {
                        listCalculateItemsOffsets.get(i52).updateMainAxisLayoutSize(i51);
                    }
                }
            }
            int i53 = iM20921getMaxWidthimpl;
            boolean z4 = i43 != i + (-1) || i49 > i2;
            MeasureResult measureResultInvoke = function3.invoke(Integer.valueOf(i53), Integer.valueOf(iM20937constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6
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
                    List<LazyGridMeasuredItem> list7 = listCalculateItemsOffsets;
                    int size5 = list7.size();
                    for (int i54 = 0; i54 < size5; i54++) {
                        list7.get(i54).place(placementScope);
                    }
                    ObservableScopeInvalidator.m16028attachToScopeimpl(mutableState);
                }
            });
            if (list6.isEmpty() && list5.isEmpty()) {
                list2 = listCalculateItemsOffsets;
            } else {
                ArrayList arrayList = new ArrayList(listCalculateItemsOffsets.size());
                int size5 = listCalculateItemsOffsets.size();
                int i54 = 0;
                while (i54 < size5) {
                    LazyGridMeasuredItem lazyGridMeasuredItem3 = listCalculateItemsOffsets.get(i54);
                    int index3 = lazyGridMeasuredItem3.getIndex();
                    int i55 = i42;
                    if (i55 <= index3 && index3 <= i43) {
                        arrayList.add(lazyGridMeasuredItem3);
                    }
                    i54++;
                    i42 = i55;
                }
                list2 = arrayList;
            }
            return new LazyGridMeasureResult(lazyGridMeasuredLine, i13, z4, f5, measureResultInvoke, z3, coroutineScope, density, i9, function1, list2, i45, i44, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5, i6);
        }
        i10 = i29;
        i11 = mainAxisSizeWithSpacings3;
        i12 = mainAxisSizeWithSpacings2;
        if (MathKt.getSign(Math.round(f)) == MathKt.getSign(i10)) {
        }
        if (i12 >= 0) {
        }
    }
}
