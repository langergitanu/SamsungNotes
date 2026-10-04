package androidx.compose.foundation.layout;

import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\n\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000e\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0010\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0011\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/layout/IntrinsicMeasureBlocks;", "", "()V", "HorizontalMaxHeight", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableWidth", "mainAxisSpacing", "HorizontalMaxWidth", "availableHeight", "HorizontalMinHeight", "HorizontalMinWidth", "VerticalMaxHeight", "VerticalMaxWidth", "VerticalMinHeight", "VerticalMinWidth", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRowColumnImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RowColumnImpl.kt\nandroidx/compose/foundation/layout/IntrinsicMeasureBlocks\n+ 2 RowColumnImpl.kt\nandroidx/compose/foundation/layout/RowColumnImplKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 4 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,723:1\n428#2,5:724\n433#2,7:733\n441#2:741\n442#2,2:743\n453#2,5:745\n458#2,17:754\n477#2,6:772\n485#2,17:779\n453#2,5:796\n458#2,17:805\n477#2,6:823\n485#2,17:830\n428#2,5:847\n433#2,7:856\n441#2:864\n442#2,2:866\n428#2,5:868\n433#2,7:877\n441#2:885\n442#2,2:887\n453#2,5:889\n458#2,17:898\n477#2,6:916\n485#2,17:923\n453#2,5:940\n458#2,17:949\n477#2,6:967\n485#2,17:974\n428#2,5:991\n433#2,7:1000\n441#2:1008\n442#2,2:1010\n33#3,4:729\n38#3:742\n33#3,4:750\n38#3:771\n33#3,4:801\n38#3:822\n33#3,4:852\n38#3:865\n33#3,4:873\n38#3:886\n33#3,4:894\n38#3:915\n33#3,4:945\n38#3:966\n33#3,4:996\n38#3:1009\n26#4:740\n26#4:778\n26#4:829\n26#4:863\n26#4:884\n26#4:922\n26#4:973\n26#4:1007\n*S KotlinDebug\n*F\n+ 1 RowColumnImpl.kt\nandroidx/compose/foundation/layout/IntrinsicMeasureBlocks\n*L\n325#1:724,5\n325#1:733,7\n325#1:741\n325#1:743,2\n337#1:745,5\n337#1:754,17\n337#1:772,6\n337#1:779,17\n350#1:796,5\n350#1:805,17\n350#1:823,6\n350#1:830,17\n363#1:847,5\n363#1:856,7\n363#1:864\n363#1:866,2\n375#1:868,5\n375#1:877,7\n375#1:885\n375#1:887,2\n387#1:889,5\n387#1:898,17\n387#1:916,6\n387#1:923,17\n400#1:940,5\n400#1:949,17\n400#1:967,6\n400#1:974,17\n413#1:991,5\n413#1:1000,7\n413#1:1008\n413#1:1010,2\n325#1:729,4\n325#1:742\n337#1:750,4\n337#1:771\n350#1:801,4\n350#1:822\n363#1:852,4\n363#1:865\n375#1:873,4\n375#1:886\n387#1:894,4\n387#1:915\n400#1:945,4\n400#1:966\n413#1:996,4\n413#1:1009\n325#1:740\n337#1:778\n350#1:829\n363#1:863\n375#1:884\n387#1:922\n400#1:973\n413#1:1007\n*E\n"})
public final class IntrinsicMeasureBlocks {
    public static final int $stable = 0;

    @NotNull
    public static final IntrinsicMeasureBlocks INSTANCE = new IntrinsicMeasureBlocks();

    private IntrinsicMeasureBlocks() {
    }

    public final int HorizontalMaxHeight(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((measurables.size() - 1) * mainAxisSpacing, availableWidth);
        int size = measurables.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE), availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableWidth - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.maxIntrinsicHeight(iMin2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int iRound = f == 0.0f ? 0 : availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableWidth - iMin, 0) / f);
        int size2 = measurables.size();
        for (int i2 = 0; i2 < size2; i2++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i2);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.maxIntrinsicHeight(iRound != Integer.MAX_VALUE ? Math.round(iRound * weight2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int HorizontalMaxWidth(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int iMax = 0;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i2);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(availableHeight);
            if (weight == 0.0f) {
                i += iMaxIntrinsicWidth;
            } else if (weight > 0.0f) {
                f += weight;
                iMax = Math.max(iMax, Math.round(iMaxIntrinsicWidth / weight));
            }
        }
        return ((measurables.size() - 1) * mainAxisSpacing) + Math.round(iMax * f) + i;
    }

    public final int HorizontalMinHeight(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((measurables.size() - 1) * mainAxisSpacing, availableWidth);
        int size = measurables.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE), availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableWidth - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.minIntrinsicHeight(iMin2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int iRound = f == 0.0f ? 0 : availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableWidth - iMin, 0) / f);
        int size2 = measurables.size();
        for (int i2 = 0; i2 < size2; i2++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i2);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.minIntrinsicHeight(iRound != Integer.MAX_VALUE ? Math.round(iRound * weight2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int HorizontalMinWidth(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int iMax = 0;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i2);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(availableHeight);
            if (weight == 0.0f) {
                i += iMinIntrinsicWidth;
            } else if (weight > 0.0f) {
                f += weight;
                iMax = Math.max(iMax, Math.round(iMinIntrinsicWidth / weight));
            }
        }
        return ((measurables.size() - 1) * mainAxisSpacing) + Math.round(iMax * f) + i;
    }

    public final int VerticalMaxHeight(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int iMax = 0;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i2);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(availableWidth);
            if (weight == 0.0f) {
                i += iMaxIntrinsicHeight;
            } else if (weight > 0.0f) {
                f += weight;
                iMax = Math.max(iMax, Math.round(iMaxIntrinsicHeight / weight));
            }
        }
        return ((measurables.size() - 1) * mainAxisSpacing) + Math.round(iMax * f) + i;
    }

    public final int VerticalMaxWidth(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((measurables.size() - 1) * mainAxisSpacing, availableHeight);
        int size = measurables.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE), availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableHeight - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.maxIntrinsicWidth(iMin2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int iRound = f == 0.0f ? 0 : availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableHeight - iMin, 0) / f);
        int size2 = measurables.size();
        for (int i2 = 0; i2 < size2; i2++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i2);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.maxIntrinsicWidth(iRound != Integer.MAX_VALUE ? Math.round(iRound * weight2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int VerticalMinHeight(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int iMax = 0;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i2);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(availableWidth);
            if (weight == 0.0f) {
                i += iMinIntrinsicHeight;
            } else if (weight > 0.0f) {
                f += weight;
                iMax = Math.max(iMax, Math.round(iMinIntrinsicHeight / weight));
            }
        }
        return ((measurables.size() - 1) * mainAxisSpacing) + Math.round(iMax * f) + i;
    }

    public final int VerticalMinWidth(@NotNull List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((measurables.size() - 1) * mainAxisSpacing, availableHeight);
        int size = measurables.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE), availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableHeight - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.minIntrinsicWidth(iMin2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int iRound = f == 0.0f ? 0 : availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableHeight - iMin, 0) / f);
        int size2 = measurables.size();
        for (int i2 = 0; i2 < size2; i2++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i2);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.minIntrinsicWidth(iRound != Integer.MAX_VALUE ? Math.round(iRound * weight2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }
}
