package androidx.glance.oneui.template.layout.glance;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.GridItem;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/glance/GridMapManager;", "", "()V", "getGridMap", "Lkotlin/Pair;", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "gridCount", "firstItem", "Landroidx/glance/oneui/template/GridItem;", "getGridMap-nXd0AQQ", "(IILandroidx/glance/oneui/template/GridItem;Landroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class GridMapManager {
    public static final int $stable = 0;

    @NotNull
    public static final GridMapManager INSTANCE = new GridMapManager();

    private GridMapManager() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: getGridMap-nXd0AQQ, reason: not valid java name */
    public final Pair<Integer, Integer> m21839getGridMapnXd0AQQ(int i, int i2, @NotNull GridItem firstItem, @Nullable Composer composer, int i4) {
        Pair<Integer, Integer> pairM13893to;
        Intrinsics.checkNotNullParameter(firstItem, "firstItem");
        composer.startReplaceableGroup(-1171335914);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1171335914, i4, -1, "androidx.glance.oneui.template.layout.glance.GridMapManager.getGridMap (GridLayout.kt:76)");
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
            pairM13893to = TuplesKt.m13893to(1, 1);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4())) {
            pairM13893to = TuplesKt.m13893to(2, 1);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4())) {
            pairM13893to = TuplesKt.m13893to(Integer.valueOf(i2 >= 6 ? 6 : 4), 1);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4())) {
            pairM13893to = TuplesKt.m13893to(2, Integer.valueOf(i2 >= 6 ? 3 : 2));
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4())) {
            pairM13893to = i2 <= 4 ? TuplesKt.m13893to(4, 1) : i2 <= 6 ? TuplesKt.m13893to(6, 1) : TuplesKt.m13893to(4, 2);
        } else {
            pairM13893to = TuplesKt.m13893to(4, Integer.valueOf(firstItem.getText() != null ? 3 : 4));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pairM13893to;
    }
}
