package androidx.glance.oneui.template.size;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TemplateState;
import androidx.glance.oneui.template.TextType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ0\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GridTemplatePercent;", "", "()V", "getIconSizePercent", "Lkotlin/Pair;", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "gridCount", "", "showLabel", "", "getIconSizePercent-nXd0AQQ", "(IIZLandroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "getTextViewSizePercent", "maxLine", "textType", "Landroidx/glance/oneui/template/TextType;", "getTextViewSizePercent-uzAuy7E", "(IIII)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGridLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GridLayoutSize.kt\nandroidx/glance/oneui/template/size/GridTemplatePercent\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,138:1\n74#2:139\n*S KotlinDebug\n*F\n+ 1 GridLayoutSize.kt\nandroidx/glance/oneui/template/size/GridTemplatePercent\n*L\n47#1:139\n*E\n"})
public final class GridTemplatePercent {
    public static final int $stable = 0;

    @NotNull
    public static final GridTemplatePercent INSTANCE = new GridTemplatePercent();

    private GridTemplatePercent() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: getIconSizePercent-nXd0AQQ, reason: not valid java name */
    public final Pair<Float, Float> m21952getIconSizePercentnXd0AQQ(int i, int i2, boolean z, @Nullable Composer composer, int i4) {
        Pair<Float, Float> pairM13893to;
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(0.115f);
        Float fValueOf3 = Float.valueOf(0.385f);
        Float fValueOf4 = Float.valueOf(0.21f);
        Float fValueOf5 = Float.valueOf(0.33f);
        Float fValueOf6 = Float.valueOf(0.75f);
        Float fValueOf7 = Float.valueOf(0.175f);
        composer.startReplaceableGroup(1938668740);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1938668740, i4, -1, "androidx.glance.oneui.template.size.GridTemplatePercent.getIconSizePercent (GridLayoutSize.kt:27)");
        }
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
            pairM13893to = TuplesKt.m13893to(fValueOf6, fValueOf6);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4())) {
            pairM13893to = TuplesKt.m13893to(fValueOf3, fValueOf6);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4())) {
            pairM13893to = i2 < 6 ? TuplesKt.m13893to(fValueOf7, fValueOf6) : TuplesKt.m13893to(fValueOf2, Float.valueOf(0.53f));
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4())) {
            pairM13893to = z ? TuplesKt.m13893to(Float.valueOf(0.34f), Float.valueOf(0.28f)) : i2 < 6 ? TuplesKt.m13893to(fValueOf3, fValueOf5) : TuplesKt.m13893to(Float.valueOf(0.26f), fValueOf4);
        } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21568getLargerx25Pp4())) {
            pairM13893to = z ? i2 < 6 ? TuplesKt.m13893to(fValueOf7, fValueOf5) : i2 < 8 ? TuplesKt.m13893to(fValueOf2, fValueOf4) : TuplesKt.m13893to(Float.valueOf(0.35f), Float.valueOf(0.29f)) : (i2 >= 6 && ((TemplateState) composer.consume(CompositionLocalsKt.getLocalTemplateState())).getHasTitleBar()) ? TuplesKt.m13893to(fValueOf7, fValueOf4) : TuplesKt.m13893to(fValueOf7, fValueOf5);
        } else {
            pairM13893to = AppWidgetSize.m21550equalsimpl0(i, companion.m21566getExtraLargerx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21567getExtraLargeLongrx25Pp4()) ? TuplesKt.m13893to(fValueOf7, Float.valueOf(0.15f)) : TuplesKt.m13893to(fValueOf, fValueOf);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pairM13893to;
    }

    /* JADX INFO: renamed from: getTextViewSizePercent-uzAuy7E, reason: not valid java name */
    public final float m21953getTextViewSizePercentuzAuy7E(int widgetSize, int maxLine, int textType, int gridCount) {
        if (!TextType.m21684equalsimpl0(textType, TextType.INSTANCE.m21693getLabelgxbDmow())) {
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21546compareToL2j3NV4(widgetSize, companion.m21570getSmallrx25Pp4()) >= 0) {
                return maxLine == 1 ? 0.26f : 0.52f;
            }
            if (AppWidgetSize.m21546compareToL2j3NV4(widgetSize, companion.m21569getMediumrx25Pp4()) >= 0) {
                return maxLine == 1 ? 0.11f : 0.21f;
            }
            return 0.0f;
        }
        AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21546compareToL2j3NV4(widgetSize, companion2.m21569getMediumrx25Pp4()) < 0) {
            if (AppWidgetSize.m21546compareToL2j3NV4(widgetSize, companion2.m21566getExtraLargerx25Pp4()) >= 0) {
                return maxLine == 1 ? 0.041f : 0.081f;
            }
            return 0.0f;
        }
        if (maxLine == 1) {
            return 0.13f;
        }
        if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21568getLargerx25Pp4()) && gridCount == 4) {
            return 0.28f;
        }
        GlanceLog.INSTANCE.m2301i("GridLayoutSize", "This case is not supported");
        return 0.28f;
    }
}
