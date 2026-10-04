package androidx.compose.foundation.lazy.grid;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0003\b\t\nJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells;", "", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "Adaptive", "Fixed", "FixedSize", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface GridCells {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Adaptive;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", TokenizerME.NO_SPLIT, "equals", "", "other", "", "hashCode", "", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/GridCells$Adaptive\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,569:1\n149#2:570\n1#3:571\n*S KotlinDebug\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/GridCells$Adaptive\n*L\n304#1:570\n*E\n"})
    public static final class Adaptive implements GridCells {
        public static final int $stable = 0;
        private final float minSize;

        public /* synthetic */ Adaptive(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2) {
            return LazyGridDslKt.calculateCellsCrossAxisSizeImpl(i, Math.max((i + i2) / (density.mo15540roundToPx0680j_4(this.minSize) + i2), 1), i2);
        }

        public boolean equals(@Nullable Object other) {
            return (other instanceof Adaptive) && C2256Dp.m20973equalsimpl0(this.minSize, ((Adaptive) other).minSize);
        }

        public int hashCode() {
            return C2256Dp.m20974hashCodeimpl(this.minSize);
        }

        private Adaptive(float f) {
            this.minSize = f;
            if (C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl(0)) > 0) {
                return;
            }
            throw new IllegalArgumentException(("Provided min size " + ((Object) C2256Dp.m20979toStringimpl(f)) + " should be larger than zero.").toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\u0003H\u0016J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Fixed;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "count", "", "(I)V", "equals", "", "other", "", "hashCode", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/GridCells$Fixed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,569:1\n1#2:570\n*E\n"})
    public static final class Fixed implements GridCells {
        public static final int $stable = 0;
        private final int count;

        public Fixed(int i) {
            this.count = i;
            if (i <= 0) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Provided count ", " should be larger than zero").toString());
            }
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2) {
            return LazyGridDslKt.calculateCellsCrossAxisSizeImpl(i, this.count, i2);
        }

        public boolean equals(@Nullable Object other) {
            return (other instanceof Fixed) && this.count == ((Fixed) other).count;
        }

        public int hashCode() {
            return -this.count;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$FixedSize;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "size", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", TokenizerME.NO_SPLIT, "equals", "", "other", "", "hashCode", "", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/GridCells$FixedSize\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,569:1\n149#2:570\n1#3:571\n*S KotlinDebug\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/GridCells$FixedSize\n*L\n337#1:570\n*E\n"})
    public static final class FixedSize implements GridCells {
        public static final int $stable = 0;
        private final float size;

        public /* synthetic */ FixedSize(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2) {
            int iMo15540roundToPx0680j_4 = density.mo15540roundToPx0680j_4(this.size);
            int i4 = iMo15540roundToPx0680j_4 + i2;
            int i5 = i2 + i;
            if (i4 >= i5) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Integer.valueOf(i));
                return arrayList;
            }
            int i6 = i5 / i4;
            ArrayList arrayList2 = new ArrayList(i6);
            for (int iM1200a = 0; iM1200a < i6; iM1200a = AbstractC1038a.m1200a(iMo15540roundToPx0680j_4, iM1200a, 1, arrayList2)) {
            }
            return arrayList2;
        }

        public boolean equals(@Nullable Object other) {
            return (other instanceof FixedSize) && C2256Dp.m20973equalsimpl0(this.size, ((FixedSize) other).size);
        }

        public int hashCode() {
            return C2256Dp.m20974hashCodeimpl(this.size);
        }

        private FixedSize(float f) {
            this.size = f;
            if (C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl(0)) > 0) {
                return;
            }
            throw new IllegalArgumentException(("Provided size " + ((Object) C2256Dp.m20979toStringimpl(f)) + " should be larger than zero.").toString());
        }
    }

    @NotNull
    List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2);
}
