package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u008c\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001añ\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2/\u0010I\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\bL\u0012\u0004\u0012\u00020M0JH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, m13886d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", DBSchema.DocumentThumbnail.LAYOUT, "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPagerMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerMeasure.kt\nandroidx/compose/foundation/pager/PagerMeasureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,681:1\n677#1,4:683\n677#1,4:687\n677#1,4:691\n677#1,4:695\n677#1,4:699\n677#1,4:703\n677#1,4:752\n1#2:682\n33#3,6:707\n33#3,6:713\n235#3,3:719\n33#3,4:722\n238#3,2:726\n38#3:728\n240#3:729\n235#3,3:730\n33#3,4:733\n238#3,2:737\n38#3:739\n240#3:740\n235#3,3:741\n33#3,4:744\n238#3,2:748\n38#3:750\n240#3:751\n33#3,6:756\n33#3,6:762\n171#3,13:768\n33#3,6:781\n33#3,6:787\n33#3,6:793\n*S KotlinDebug\n*F\n+ 1 PagerMeasure.kt\nandroidx/compose/foundation/pager/PagerMeasureKt\n*L\n69#1:683,4\n134#1:687,4\n155#1:691,4\n175#1:695,4\n214#1:699,4\n236#1:703,4\n445#1:752,4\n335#1:707,6\n361#1:713,6\n401#1:719,3\n401#1:722,4\n401#1:726,2\n401#1:728\n401#1:729\n406#1:730,3\n406#1:733,4\n406#1:737,2\n406#1:739\n406#1:740\n411#1:741,3\n411#1:744,4\n411#1:748,2\n411#1:750\n411#1:751\n499#1:756,6\n524#1:762,6\n543#1:768,13\n651#1:781,6\n658#1:787,6\n664#1:793,6\n*E\n"})
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i4, int i5, SnapPosition snapPosition, int i6) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i4, i5, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i6));
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i7 = 1;
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i7);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f4 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i4, i5, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i6));
                    if (Float.compare(f, f4) < 0) {
                        f = f4;
                        measuredPage2 = measuredPage4;
                    }
                    if (i7 == lastIndex) {
                        break;
                    }
                    i7++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i4, int i5, int i6, Orientation orientation, boolean z, Density density, int i7, int i8) {
        int i9 = i6;
        int i10 = i8 + i7;
        int i11 = orientation == Orientation.Vertical ? i2 : i;
        boolean z2 = i4 < Math.min(i11, i5);
        if (z2 && i9 != 0) {
            throw new IllegalStateException(AbstractC0000a.m11h(i9, "non-zero pagesScrollOffset=").toString());
        }
        ArrayList arrayList = new ArrayList(list3.size() + list2.size() + list.size());
        if (!z2) {
            int size = list2.size();
            int i12 = i9;
            for (int i13 = 0; i13 < size; i13++) {
                MeasuredPage measuredPage = list2.get(i13);
                i12 -= i10;
                measuredPage.position(i12, i, i2);
                arrayList.add(measuredPage);
            }
            int size2 = list.size();
            for (int i14 = 0; i14 < size2; i14++) {
                MeasuredPage measuredPage2 = list.get(i14);
                measuredPage2.position(i9, i, i2);
                arrayList.add(measuredPage2);
                i9 += i10;
            }
            int size3 = list3.size();
            for (int i15 = 0; i15 < size3; i15++) {
                MeasuredPage measuredPage3 = list3.get(i15);
                measuredPage3.position(i9, i, i2);
                arrayList.add(measuredPage3);
                i9 += i10;
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i16 = 0; i16 < size4; i16++) {
                iArr[i16] = i8;
            }
            int[] iArr2 = new int[size4];
            for (int i17 = 0; i17 < size4; i17++) {
                iArr2[i17] = 0;
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM15737spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m15737spacedBy0680j_4(lazyLayoutMeasureScope.mo15543toDpu2uoSUM(i7));
            if (orientation == Orientation.Vertical) {
                horizontalOrVerticalM15737spacedBy0680j_4.arrange(density, i11, iArr, iArr2);
            } else {
                horizontalOrVerticalM15737spacedBy0680j_4.arrange(density, i11, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            IntProgression intProgressionReversed = indices;
            if (z) {
                intProgressionReversed = RangesKt___RangesKt.reversed(indices);
            }
            int first = intProgressionReversed.getFirst();
            int last = intProgressionReversed.getLast();
            int step = intProgressionReversed.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size5 = iArr2[first];
                    MeasuredPage measuredPage4 = list.get(calculatePagesOffsets$reverseAware(first, z, size4));
                    if (z) {
                        size5 = (i11 - size5) - measuredPage4.getSize();
                    }
                    measuredPage4.position(size5, i, i2);
                    arrayList.add(measuredPage4);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        return arrayList;
    }

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i4, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int iMin = Math.min(i4 + i, i2 - 1);
        int i5 = i + 1;
        ArrayList arrayList = null;
        if (i5 <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i5)));
                if (i5 == iMin) {
                    break;
                }
                i5++;
            }
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            int iIntValue = list.get(i6).intValue();
            if (iMin + 1 <= iIntValue && iIntValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int iMax = Math.max(0, i - i2);
        int i4 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i4) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == iMax) {
                    break;
                }
                i4--;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iIntValue = list.get(i5).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m16095getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo16025measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
    }

    @NotNull
    /* JADX INFO: renamed from: measurePager-bmk8ZPk, reason: not valid java name */
    public static final PagerMeasureResult m16096measurePagerbmk8ZPk(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, @NotNull final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i4, int i5, int i6, int i7, int i8, long j, @NotNull final Orientation orientation, @Nullable final Alignment.Vertical vertical, @Nullable final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i9, int i10, @NotNull List<Integer> list, @NotNull SnapPosition snapPosition, @NotNull final MutableState<Unit> mutableState, @NotNull CoroutineScope coroutineScope, @NotNull Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i11;
        int iMax;
        int i12;
        int i13;
        int i14;
        List<MeasuredPage> arrayList;
        List arrayList2;
        List arrayList3;
        int index;
        int i15;
        int i16;
        int i17;
        int i18;
        SnapPosition snapPosition2;
        int i19;
        int i20;
        int i21;
        if (i4 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding");
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i9 + i6, 0);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i9, i6, i5, orientation, -i4, i2 + i5, false, i10, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m20923getMinWidthimpl(j)), Integer.valueOf(Constraints.m20922getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        Orientation orientation2 = orientation;
        Orientation orientation3 = Orientation.Vertical;
        final long jConstraints$default = ConstraintsKt.Constraints$default(0, orientation2 == orientation3 ? Constraints.m20921getMaxWidthimpl(j) : i9, 0, orientation2 != orientation3 ? Constraints.m20920getMaxHeightimpl(j) : i9, 5, null);
        int i22 = i7;
        int i23 = i8;
        while (i22 > 0 && i23 > 0) {
            i22--;
            i23 -= iCoerceAtLeast;
        }
        int i24 = i23 * (-1);
        if (i22 >= i) {
            i22 = i - 1;
            i24 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i25 = -i4;
        int i26 = (i6 < 0 ? i6 : 0) + i25;
        int i27 = i24 + i26;
        int iMax2 = 0;
        while (i27 < 0 && i22 > 0) {
            int i28 = i22 - 1;
            MeasuredPage measuredPageM16095getAndMeasureSGf7dI0 = m16095getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i28, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation2, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i9);
            arrayDeque.add(0, measuredPageM16095getAndMeasureSGf7dI0);
            iMax2 = Math.max(iMax2, measuredPageM16095getAndMeasureSGf7dI0.getCrossAxisSize());
            i27 += iCoerceAtLeast;
            i26 = i26;
            i22 = i28;
            orientation2 = orientation;
        }
        int i29 = i26;
        int i30 = iMax2;
        if (i27 < i29) {
            i27 = i29;
        }
        int i31 = i27 - i29;
        int i32 = i2 + i5;
        int i33 = i22;
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(i32, 0);
        int i34 = -i31;
        int i35 = i33;
        int i36 = 0;
        boolean z2 = false;
        while (i36 < arrayDeque.size()) {
            if (i34 >= iCoerceAtLeast2) {
                arrayDeque.remove(i36);
                z2 = true;
            } else {
                i35++;
                i34 += iCoerceAtLeast;
                i36++;
            }
        }
        int iMax3 = i30;
        int i37 = i35;
        boolean z3 = z2;
        int i38 = i31;
        while (i37 < i && (i34 < iCoerceAtLeast2 || i34 <= 0 || arrayDeque.isEmpty())) {
            int i39 = iCoerceAtLeast2;
            int i40 = i37;
            MeasuredPage measuredPageM16095getAndMeasureSGf7dI02 = m16095getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i40, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i9);
            int i41 = i38;
            int i42 = i - 1;
            i34 += i40 == i42 ? i9 : iCoerceAtLeast;
            if (i34 > i29 || i40 == i42) {
                iMax3 = Math.max(iMax3, measuredPageM16095getAndMeasureSGf7dI02.getCrossAxisSize());
                arrayDeque.add(measuredPageM16095getAndMeasureSGf7dI02);
                i21 = i33;
                i38 = i41;
            } else {
                i21 = i40 + 1;
                i38 = i41 - iCoerceAtLeast;
                z3 = true;
            }
            i37 = i40 + 1;
            i33 = i21;
            iCoerceAtLeast2 = i39;
        }
        int i43 = i38;
        if (i34 < i2) {
            int i44 = i2 - i34;
            i12 = i43 - i44;
            i34 += i44;
            iMax = iMax3;
            i13 = i33;
            while (i12 < i4 && i13 > 0) {
                int i45 = i13 - 1;
                MeasuredPage measuredPageM16095getAndMeasureSGf7dI03 = m16095getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i45, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i9);
                arrayDeque.add(0, measuredPageM16095getAndMeasureSGf7dI03);
                iMax = Math.max(iMax, measuredPageM16095getAndMeasureSGf7dI03.getCrossAxisSize());
                i12 += iCoerceAtLeast;
                i37 = i37;
                i13 = i45;
            }
            i11 = i37;
            if (i12 < 0) {
                i34 += i12;
                i12 = 0;
            }
        } else {
            i11 = i37;
            iMax = iMax3;
            i12 = i43;
            i13 = i33;
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset");
        }
        int i46 = iMax;
        int i47 = -i12;
        MeasuredPage measuredPage = (MeasuredPage) arrayDeque.first();
        if (i4 > 0 || i6 < 0) {
            int size = arrayDeque.size();
            i14 = i47;
            int i48 = 0;
            while (i48 < size && i12 != 0 && iCoerceAtLeast <= i12 && i48 != CollectionsKt.getLastIndex(arrayDeque)) {
                i12 -= iCoerceAtLeast;
                i48++;
                measuredPage = (MeasuredPage) arrayDeque.get(i48);
            }
        } else {
            i14 = i47;
        }
        int i49 = i12;
        MeasuredPage measuredPage2 = measuredPage;
        List<MeasuredPage> listCreatePagesBeforeList = createPagesBeforeList(i13, i10, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final MeasuredPage invoke(int i50) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m16095getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i50, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i9);
            }
        });
        int size2 = listCreatePagesBeforeList.size();
        int iMax4 = i46;
        int i50 = 0;
        while (i50 < size2) {
            iMax4 = Math.max(iMax4, listCreatePagesBeforeList.get(i50).getCrossAxisSize());
            i50++;
            listCreatePagesBeforeList = listCreatePagesBeforeList;
        }
        List<MeasuredPage> list2 = listCreatePagesBeforeList;
        List<MeasuredPage> listCreatePagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque.last()).getIndex(), i, i10, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final MeasuredPage invoke(int i51) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m16095getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i51, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i9);
            }
        });
        int size3 = listCreatePagesAfterList.size();
        for (int i51 = 0; i51 < size3; i51++) {
            iMax4 = Math.max(iMax4, listCreatePagesAfterList.get(i51).getCrossAxisSize());
        }
        boolean z4 = Intrinsics.areEqual(measuredPage2, arrayDeque.first()) && list2.isEmpty() && listCreatePagesAfterList.isEmpty();
        Orientation orientation4 = Orientation.Vertical;
        int iM20938constrainWidthK40F9xA = ConstraintsKt.m20938constrainWidthK40F9xA(j, orientation == orientation4 ? iMax4 : i34);
        if (orientation == orientation4) {
            iMax4 = i34;
        }
        int iM20937constrainHeightK40F9xA = ConstraintsKt.m20937constrainHeightK40F9xA(j, iMax4);
        int i52 = i11;
        int i53 = i34;
        final List<MeasuredPage> listCalculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque, list2, listCreatePagesAfterList, iM20938constrainWidthK40F9xA, iM20937constrainHeightK40F9xA, i53, i2, i14, orientation, z, lazyLayoutMeasureScope, i6, i9);
        if (z4) {
            arrayList = listCalculatePagesOffsets;
        } else {
            arrayList = new ArrayList<>(listCalculatePagesOffsets.size());
            int size4 = listCalculatePagesOffsets.size();
            int i54 = 0;
            while (i54 < size4) {
                MeasuredPage measuredPage3 = listCalculatePagesOffsets.get(i54);
                MeasuredPage measuredPage4 = measuredPage3;
                MeasuredPage measuredPage5 = measuredPage2;
                int i55 = i52;
                if (measuredPage4.getIndex() >= ((MeasuredPage) arrayDeque.first()).getIndex() && measuredPage4.getIndex() <= ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList.add(measuredPage3);
                }
                i54++;
                i52 = i55;
                measuredPage2 = measuredPage5;
            }
        }
        MeasuredPage measuredPage6 = measuredPage2;
        int i56 = i52;
        if (list2.isEmpty()) {
            arrayList2 = CollectionsKt.emptyList();
        } else {
            arrayList2 = new ArrayList(listCalculatePagesOffsets.size());
            int size5 = listCalculatePagesOffsets.size();
            for (int i57 = 0; i57 < size5; i57++) {
                MeasuredPage measuredPage7 = listCalculatePagesOffsets.get(i57);
                if (measuredPage7.getIndex() < ((MeasuredPage) arrayDeque.first()).getIndex()) {
                    arrayList2.add(measuredPage7);
                }
            }
        }
        List list3 = arrayList2;
        if (listCreatePagesAfterList.isEmpty()) {
            arrayList3 = CollectionsKt.emptyList();
        } else {
            arrayList3 = new ArrayList(listCalculatePagesOffsets.size());
            int size6 = listCalculatePagesOffsets.size();
            for (int i58 = 0; i58 < size6; i58++) {
                MeasuredPage measuredPage8 = listCalculatePagesOffsets.get(i58);
                if (measuredPage8.getIndex() > ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList3.add(measuredPage8);
                }
            }
        }
        List list4 = arrayList3;
        MeasuredPage measuredPageCalculateNewCurrentPage = calculateNewCurrentPage(orientation == Orientation.Vertical ? iM20937constrainHeightK40F9xA : iM20938constrainWidthK40F9xA, arrayList, i4, i5, iCoerceAtLeast, snapPosition, i);
        List<MeasuredPage> list5 = arrayList;
        if (measuredPageCalculateNewCurrentPage != null) {
            index = measuredPageCalculateNewCurrentPage.getIndex();
            i15 = i;
            i16 = i2;
            i17 = i4;
            i18 = i9;
            i19 = iCoerceAtLeast;
            i20 = i5;
            snapPosition2 = snapPosition;
        } else {
            index = 0;
            i15 = i;
            i16 = i2;
            i17 = i4;
            i18 = i9;
            snapPosition2 = snapPosition;
            i19 = iCoerceAtLeast;
            i20 = i5;
        }
        return new PagerMeasureResult(list5, i9, i6, i5, orientation, i25, i32, z, i10, measuredPage6, measuredPageCalculateNewCurrentPage, i19 == 0 ? 0.0f : RangesKt.coerceIn((snapPosition2.position(i16, i18, i17, i20, index, i15) - (measuredPageCalculateNewCurrentPage != null ? measuredPageCalculateNewCurrentPage.getOffset() : 0)) / i19, -0.5f, 0.5f), i49, i56 < i15 || i53 > i16, snapPosition, function3.invoke(Integer.valueOf(iM20938constrainWidthK40F9xA), Integer.valueOf(iM20937constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
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
                List<MeasuredPage> list6 = listCalculatePagesOffsets;
                int size7 = list6.size();
                for (int i59 = 0; i59 < size7; i59++) {
                    list6.get(i59).place(placementScope);
                }
                ObservableScopeInvalidator.m16028attachToScopeimpl(mutableState);
            }
        }), z3, list3, list4, coroutineScope);
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
