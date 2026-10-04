package androidx.compose.material;

import androidx.compose.foundation.ScrollState;
import androidx.compose.p109ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0007\u001a\u00020\bJ*\u0010\u0012\u001a\u00020\b*\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/material/ScrollableTabData;", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/ScrollState;Lkotlinx/coroutines/CoroutineScope;)V", "selectedTab", "", "Ljava/lang/Integer;", "onLaidOut", "", "density", "Landroidx/compose/ui/unit/Density;", "edgeOffset", "tabPositions", "", "Landroidx/compose/material/TabPosition;", "calculateTabOffset", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class ScrollableTabData {

    @NotNull
    private final CoroutineScope coroutineScope;

    @NotNull
    private final ScrollState scrollState;

    @Nullable
    private Integer selectedTab;

    public ScrollableTabData(@NotNull ScrollState scrollState, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.scrollState = scrollState;
        this.coroutineScope = coroutineScope;
    }

    private final int calculateTabOffset(TabPosition tabPosition, Density density, int i, List<TabPosition> list) {
        int iMo15540roundToPx0680j_4 = density.mo15540roundToPx0680j_4(((TabPosition) CollectionsKt.last((List) list)).m16899getRightD9Ej5fM()) + i;
        int maxValue = iMo15540roundToPx0680j_4 - this.scrollState.getMaxValue();
        return RangesKt.coerceIn(density.mo15540roundToPx0680j_4(tabPosition.getLeft()) - ((maxValue / 2) - (density.mo15540roundToPx0680j_4(tabPosition.getWidth()) / 2)), 0, RangesKt.coerceAtLeast(iMo15540roundToPx0680j_4 - maxValue, 0));
    }

    public final void onLaidOut(@NotNull Density density, int edgeOffset, @NotNull List<TabPosition> tabPositions, int selectedTab) {
        int iCalculateTabOffset;
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
        Integer num = this.selectedTab;
        if (num != null && num.intValue() == selectedTab) {
            return;
        }
        this.selectedTab = Integer.valueOf(selectedTab);
        TabPosition tabPosition = (TabPosition) CollectionsKt.getOrNull(tabPositions, selectedTab);
        if (tabPosition == null || this.scrollState.getValue() == (iCalculateTabOffset = calculateTabOffset(tabPosition, density, edgeOffset, tabPositions))) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new ScrollableTabData$onLaidOut$1$1(this, iCalculateTabOffset, null), 3, null);
    }
}
