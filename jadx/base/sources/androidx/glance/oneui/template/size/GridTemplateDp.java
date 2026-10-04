package androidx.glance.oneui.template.size;

import android.content.Context;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GridTemplateDp;", "", "()V", "getMaxIconSize", "Landroidx/compose/ui/unit/Dp;", "context", "Landroid/content/Context;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "showLabel", "", "gridCount", "", "getMaxIconSize-xeG5q6M", "(Landroid/content/Context;IZI)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGridLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GridLayoutSize.kt\nandroidx/glance/oneui/template/size/GridTemplateDp\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,138:1\n174#2:139\n174#2:140\n174#2:141\n174#2:142\n174#2:143\n154#2:144\n154#2:145\n*S KotlinDebug\n*F\n+ 1 GridLayoutSize.kt\nandroidx/glance/oneui/template/size/GridTemplateDp\n*L\n111#1:139\n112#1:140\n119#1:141\n120#1:142\n127#1:143\n128#1:144\n133#1:145\n*E\n"})
public final class GridTemplateDp {
    public static final int $stable = 0;

    @NotNull
    public static final GridTemplateDp INSTANCE = new GridTemplateDp();

    private GridTemplateDp() {
    }

    /* JADX INFO: renamed from: getMaxIconSize-xeG5q6M, reason: not valid java name */
    public final float m21951getMaxIconSizexeG5q6M(@NotNull Context context, int widgetSize, boolean showLabel, int gridCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        return AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21573getWideSmallrx25Pp4()) ? showLabel ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_small_icon_max_size_with_label)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_small_icon_max_size)) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21569getMediumrx25Pp4()) ? showLabel ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_medium_icon_max_size_with_label)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_medium_icon_max_size)) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21568getLargerx25Pp4()) ? ((showLabel && gridCount == 8) || gridCount == 4) ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_medium_icon_max_size_with_label)) : C2256Dp.m20968constructorimpl(100) : C2256Dp.m20968constructorimpl(100);
    }
}
