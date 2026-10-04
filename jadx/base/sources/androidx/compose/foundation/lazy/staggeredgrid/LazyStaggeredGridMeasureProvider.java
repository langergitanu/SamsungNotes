package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016JR\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\u0011H&ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J \u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020$ø\u0001\u0001¢\u0006\u0004\b%\u0010&J2\u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0011H\u0016ø\u0001\u0001¢\u0006\u0004\b'\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006)"}, m13886d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "(ZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "", "span", "childConstraints-JhjzzOo", "(II)J", "createItem", "index", "lane", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "constraints", "createItem-pitSLOA", "(IIILjava/lang/Object;Ljava/lang/Object;Ljava/util/List;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getAndMeasure", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "getAndMeasure-jy6DScQ", "(IJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyStaggeredGridMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider\n+ 2 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/SpanRange\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,1354:1\n1027#2:1355\n1029#2:1357\n1028#2:1358\n1027#2:1360\n107#3:1356\n114#3:1359\n107#3:1361\n*S KotlinDebug\n*F\n+ 1 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider\n*L\n1150#1:1355\n1151#1:1357\n1151#1:1358\n1151#1:1360\n1150#1:1356\n1151#1:1359\n1151#1:1361\n*E\n"})
public abstract class LazyStaggeredGridMeasureProvider implements LazyLayoutMeasuredItemProvider<LazyStaggeredGridMeasuredItem> {
    public static final int $stable = 8;
    private final boolean isVertical;

    @NotNull
    private final LazyStaggeredGridItemProvider itemProvider;

    @NotNull
    private final LazyLayoutMeasureScope measureScope;

    @NotNull
    private final LazyStaggeredGridSlots resolvedSlots;

    public LazyStaggeredGridMeasureProvider(boolean z, @NotNull LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, @NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, @NotNull LazyStaggeredGridSlots lazyStaggeredGridSlots) {
        this.isVertical = z;
        this.itemProvider = lazyStaggeredGridItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.resolvedSlots = lazyStaggeredGridSlots;
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo, reason: not valid java name */
    private final long m16068childConstraintsJhjzzOo(int slot, int span) {
        int i;
        if (span == 1) {
            i = this.resolvedSlots.getSizes()[slot];
        } else {
            int i2 = this.resolvedSlots.getPositions()[slot];
            int i4 = (slot + span) - 1;
            i = (this.resolvedSlots.getPositions()[i4] + this.resolvedSlots.getSizes()[i4]) - i2;
        }
        return this.isVertical ? Constraints.INSTANCE.m20933fixedWidthOenEA2s(i) : Constraints.INSTANCE.m20932fixedHeightOenEA2s(i);
    }

    @NotNull
    /* JADX INFO: renamed from: createItem-pitSLOA */
    public abstract LazyStaggeredGridMeasuredItem mo16062createItempitSLOA(int index, int lane, int span, @NotNull Object key, @Nullable Object contentType, @NotNull List<? extends Placeable> placeables, long constraints);

    @NotNull
    /* JADX INFO: renamed from: getAndMeasure-jy6DScQ, reason: not valid java name */
    public final LazyStaggeredGridMeasuredItem m16069getAndMeasurejy6DScQ(int index, long span) {
        Object key = this.itemProvider.getKey(index);
        Object contentType = this.itemProvider.getContentType(index);
        int length = this.resolvedSlots.getSizes().length;
        int i = (int) (span >> 32);
        int iCoerceAtMost = RangesKt.coerceAtMost(i, length - 1);
        int iCoerceAtMost2 = RangesKt.coerceAtMost(((int) (span & 4294967295L)) - i, length - iCoerceAtMost);
        long jM16068childConstraintsJhjzzOo = m16068childConstraintsJhjzzOo(iCoerceAtMost, iCoerceAtMost2);
        return mo16062createItempitSLOA(index, iCoerceAtMost, iCoerceAtMost2, key, contentType, this.measureScope.mo16025measure0kLqBqw(index, jM16068childConstraintsJhjzzOo), jM16068childConstraintsJhjzzOo);
    }

    @NotNull
    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    @NotNull
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public LazyStaggeredGridMeasuredItem mo15968getAndMeasurehBUhpc(int index, int lane, int span, long constraints) {
        return mo16062createItempitSLOA(index, lane, span, this.itemProvider.getKey(index), this.itemProvider.getContentType(index), this.measureScope.mo16025measure0kLqBqw(index, constraints), constraints);
    }
}
