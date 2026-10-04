package androidx.glance.oneui.template;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.SizeF;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.oneui.common.AppWidgetConstants;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetUtilsKt;
import androidx.glance.oneui.common.GlanceLog;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u000f\u0010\u0013\u001a\u00020\u0014*\u00020\u0004¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0004H\u0000\u001a\f\u0010\u0017\u001a\u00020\u0012*\u00020\u0004H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\f\u0010\u001a\u001a\u00020\u0012*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "columnSpan", "", "Landroid/os/Bundle;", "getColumnSpan", "(Landroid/os/Bundle;)I", "rowSpan", "getRowSpan", "estimatePreviewSize", "Landroidx/compose/ui/unit/DpSize;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "estimatePreviewSize-qK15sPk", "(Landroid/os/Bundle;ILandroidx/compose/runtime/Composer;I)J", "getGrid", "Landroid/graphics/Point;", "isPortrait", "", "getHostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "getScale", "", "is2x2", "is5x6", "is6x3", "isEasyMode", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingPreviewUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingPreviewUtils.kt\nandroidx/glance/oneui/template/SettingPreviewUtilsKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,85:1\n154#2:86\n154#2:87\n154#2:88\n154#2:89\n174#2:90\n*S KotlinDebug\n*F\n+ 1 SettingPreviewUtils.kt\nandroidx/glance/oneui/template/SettingPreviewUtilsKt\n*L\n40#1:86\n41#1:87\n42#1:88\n43#1:89\n46#1:90\n*E\n"})
public final class SettingPreviewUtilsKt {

    @NotNull
    private static final String TAG = "GWT:SettingPreviewUtils";

    @Composable
    @SuppressLint({WarningType.NewApi})
    /* JADX INFO: renamed from: estimatePreviewSize-qK15sPk, reason: not valid java name */
    public static final long m21668estimatePreviewSizeqK15sPk(@NotNull Bundle estimatePreviewSize, int i, @Nullable Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(estimatePreviewSize, "$this$estimatePreviewSize");
        composer.startReplaceableGroup(-1654636162);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1654636162, i2, -1, "androidx.glance.oneui.template.estimatePreviewSize (SettingPreviewUtils.kt:30)");
        }
        long jEstimatePreviewSize_qK15sPk$getAppWidgetSizeFromOptions = estimatePreviewSize_qK15sPk$getAppWidgetSizeFromOptions(i, estimatePreviewSize);
        GlanceLog.INSTANCE.m2301i(TAG, "App widget size from option is " + DpSize.m21073toStringimpl(jEstimatePreviewSize_qK15sPk$getAppWidgetSizeFromOptions));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jEstimatePreviewSize_qK15sPk$getAppWidgetSizeFromOptions;
    }

    private static final long estimatePreviewSize_qK15sPk$getAppWidgetSizeFromOptions(int i, Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("appWidgetSizes");
        SizeF sizeF = parcelableArrayList != null ? (SizeF) CollectionsKt.first((List) parcelableArrayList) : null;
        if (sizeF != null) {
            return DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(sizeF.getWidth()), C2256Dp.m20968constructorimpl(sizeF.getHeight()));
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        return AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(260), C2256Dp.m20968constructorimpl(80)) : AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4()) ? DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(260), C2256Dp.m20968constructorimpl(180)) : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4()) ? DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(400), C2256Dp.m20968constructorimpl(80)) : DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(400), C2256Dp.m20968constructorimpl(180));
    }

    public static final int getColumnSpan(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return bundle.getInt("semAppWidgetColumnSpan", 0);
    }

    @NotNull
    public static final Point getGrid(@NotNull Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Point point = Build.VERSION.SDK_INT >= 33 ? (Point) bundle.getParcelable(AppWidgetConstants.OPTION_APPWIDGET_HOME_GRID, Point.class) : null;
        GlanceLog.INSTANCE.m2297d(TAG, "grid(" + (point != null ? Integer.valueOf(point.x) : null) + SQLKeyword.COMMA + (point != null ? Integer.valueOf(point.y) : null) + ") from options");
        return point == null ? z ? new Point(4, 6) : new Point(6, 4) : point;
    }

    public static final int getHostType(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return AppWidgetUtilsKt.extractWidgetHost(bundle);
    }

    public static final int getRowSpan(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return bundle.getInt("semAppWidgetRowSpan", 0);
    }

    public static final float getScale(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return bundle.getFloat(AppWidgetConstants.OPTION_APPWIDGET_SCALE_RATIO, 1.0f);
    }

    public static final boolean is2x2(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return getColumnSpan(bundle) == 2 && getRowSpan(bundle) == 2;
    }

    public static final boolean is5x6(@NotNull Point point, boolean z) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return z && point.x == 5 && point.y == 6;
    }

    public static final boolean is6x3(@NotNull Point point, boolean z) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return !z && point.x == 6 && point.y == 3;
    }

    public static final boolean isEasyMode(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return Intrinsics.areEqual(bundle.getString(AppWidgetConstants.OPTION_APPWIDGET_HOME_MODE, ""), "Easy");
    }
}
