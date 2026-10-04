package androidx.glance.oneui.template.size;

import android.content.res.Configuration;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.DeviceConfigUtilsKt;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.utils.ContextUtilsKt;
import androidx.glance.oneui.template.utils.SizeUtilsKt;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\b"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GraphTemplatePercent;", "", "()V", "Graph", "Icon", "LinearGraph", "LinearGraphText", Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class GraphTemplatePercent {
    public static final int $stable = 0;

    @NotNull
    public static final GraphTemplatePercent INSTANCE = new GraphTemplatePercent();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GraphTemplatePercent$Graph;", "", "()V", "getGraphSize", "Lkotlin/Pair;", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getGraphSize-R2GYfMI", "(ILandroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Graph {
        public static final int $stable = 0;

        @NotNull
        public static final Graph INSTANCE = new Graph();

        private Graph() {
        }

        @Composable
        @NotNull
        /* JADX INFO: renamed from: getGraphSize-R2GYfMI, reason: not valid java name */
        public final Pair<Float, Float> m21943getGraphSizeR2GYfMI(int i, @Nullable Composer composer, int i2) {
            Float fValueOf = Float.valueOf(0.22f);
            Float fValueOf2 = Float.valueOf(0.935f);
            Float fValueOf3 = Float.valueOf(0.44f);
            Float fValueOf4 = Float.valueOf(1.0f);
            composer.startReplaceableGroup(1470826357);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1470826357, i2, -1, "androidx.glance.oneui.template.size.GraphTemplatePercent.Graph.getGraphSize (GraphLayoutSize.kt:23)");
            }
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            Pair<Float, Float> pairM13893to = AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4()) ? TuplesKt.m13893to(fValueOf4, fValueOf4) : AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? TuplesKt.m13893to(fValueOf3, fValueOf2) : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4()) ? TuplesKt.m13893to(fValueOf, fValueOf2) : AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4()) ? TuplesKt.m13893to(fValueOf3, Float.valueOf(0.45f)) : TuplesKt.m13893to(fValueOf, fValueOf4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return pairM13893to;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GraphTemplatePercent$Icon;", "", "()V", "getIconSize", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getIconSize-R2GYfMI", "(ILandroidx/compose/runtime/Composer;I)F", "getTopPadding", "getTopPadding-R2GYfMI", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nGraphLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphLayoutSize.kt\nandroidx/glance/oneui/template/size/GraphTemplatePercent$Icon\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,186:1\n74#2:187\n*S KotlinDebug\n*F\n+ 1 GraphLayoutSize.kt\nandroidx/glance/oneui/template/size/GraphTemplatePercent$Icon\n*L\n74#1:187\n*E\n"})
    public static final class Icon {
        public static final int $stable = 0;

        @NotNull
        public static final Icon INSTANCE = new Icon();

        private Icon() {
        }

        @Composable
        /* JADX INFO: renamed from: getIconSize-R2GYfMI, reason: not valid java name */
        public final float m21944getIconSizeR2GYfMI(int i, @Nullable Composer composer, int i2) {
            float f;
            composer.startReplaceableGroup(487387667);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(487387667, i2, -1, "androidx.glance.oneui.template.size.GraphTemplatePercent.Icon.getIconSize (GraphLayoutSize.kt:90)");
            }
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
                f = 0.37f;
            } else {
                f = AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4()) ? 0.33f : (!AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4()) || SizeUtilsKt.getWidgetContainerRatio(composer, 0) > 0.75f) ? 0.15f : 0.11f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return f;
        }

        @Composable
        /* JADX INFO: renamed from: getTopPadding-R2GYfMI, reason: not valid java name */
        public final float m21945getTopPaddingR2GYfMI(int i, @Nullable Composer composer, int i2) {
            float f;
            composer.startReplaceableGroup(487614069);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(487614069, i2, -1, "androidx.glance.oneui.template.size.GraphTemplatePercent.Icon.getTopPadding (GraphLayoutSize.kt:71)");
            }
            Configuration configuration = ContextUtilsKt.getCurrentEnvironmentContext(composer, 0).getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
            boolean zIsPortrait = DeviceConfigUtilsKt.isPortrait(configuration);
            boolean z = composer.consume(CompositionLocalsKt.getLocalDeviceType()) == DeviceType.Flip;
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
                f = 0.29f;
            } else {
                f = AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4()) ? (!z || zIsPortrait) ? 0.33f : 0.3f : AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4()) ? SizeUtilsKt.getWidgetContainerRatio(composer, 0) > 0.75f ? (!z || zIsPortrait) ? 0.14f : 0.125f : 0.17f : 0.295f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GraphTemplatePercent$LinearGraph;", "", "()V", "getGraphSize", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getGraphSize-L2j3NV4", "(I)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class LinearGraph {
        public static final int $stable = 0;

        @NotNull
        public static final LinearGraph INSTANCE = new LinearGraph();

        private LinearGraph() {
        }

        /* JADX INFO: renamed from: getGraphSize-L2j3NV4, reason: not valid java name */
        public final float m21946getGraphSizeL2j3NV4(int widgetSize) {
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21573getWideSmallrx25Pp4())) {
                return 0.225f;
            }
            return AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21568getLargerx25Pp4()) ? 0.15f : 0.42f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GraphTemplatePercent$LinearGraphText;", "", "()V", "getMinMaxTextSize", "Lkotlin/Pair;", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "textType", "Landroidx/glance/oneui/template/TextType;", "getMinMaxTextSize-tEsvO4U", "(II)Lkotlin/Pair;", "getTextViewSize", "maxLine", "", "getTextViewSize-tZlUyYw", "(III)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class LinearGraphText {
        public static final int $stable = 0;

        @NotNull
        public static final LinearGraphText INSTANCE = new LinearGraphText();

        private LinearGraphText() {
        }

        @NotNull
        /* JADX INFO: renamed from: getMinMaxTextSize-tEsvO4U, reason: not valid java name */
        public final Pair<Float, Float> m21947getMinMaxTextSizetEsvO4U(int widgetSize, int textType) {
            TextType.Companion companion = TextType.INSTANCE;
            return TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow()) ? new Pair<>(Float.valueOf(12.0f), Float.valueOf(33.0f)) : TextType.m21684equalsimpl0(textType, companion.m21690getDescriptiongxbDmow()) ? new Pair<>(Float.valueOf(18.0f), Float.valueOf(24.0f)) : new Pair<>(Float.valueOf(10.0f), Float.valueOf(16.0f));
        }

        /* JADX INFO: renamed from: getTextViewSize-tZlUyYw, reason: not valid java name */
        public final float m21948getTextViewSizetZlUyYw(int widgetSize, int textType, int maxLine) {
            TextType.Companion companion = TextType.INSTANCE;
            if (!TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow())) {
                if (TextType.m21684equalsimpl0(textType, companion.m21690getDescriptiongxbDmow())) {
                    AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
                    return AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21573getWideSmallrx25Pp4()) ? 0.26f : 0.165f;
                }
                AppWidgetSize.Companion companion3 = AppWidgetSize.INSTANCE;
                return AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21573getWideSmallrx25Pp4()) ? 0.26f : 0.1f;
            }
            AppWidgetSize.Companion companion4 = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion4.m21571getTinyrx25Pp4())) {
                return maxLine == 1 ? 0.3f : 0.6f;
            }
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion4.m21570getSmallrx25Pp4())) {
                return 0.45f;
            }
            return AppWidgetSize.m21550equalsimpl0(widgetSize, companion4.m21573getWideSmallrx25Pp4()) ? 0.47f : 0.2f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/oneui/template/size/GraphTemplatePercent$Text;", "", "()V", "getTextViewSize", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "textType", "Landroidx/glance/oneui/template/TextType;", "maxLine", "", "getTextViewSize-K3AT5sc", "(IIILandroidx/compose/runtime/Composer;I)F", "getTopPadding", "getTopPadding-R2GYfMI", "(ILandroidx/compose/runtime/Composer;I)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Text {
        public static final int $stable = 0;

        @NotNull
        public static final Text INSTANCE = new Text();

        private Text() {
        }

        @Composable
        /* JADX INFO: renamed from: getTextViewSize-K3AT5sc, reason: not valid java name */
        public final float m21949getTextViewSizeK3AT5sc(int i, int i2, int i4, @Nullable Composer composer, int i5) {
            composer.startReplaceableGroup(106182780);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(106182780, i5, -1, "androidx.glance.oneui.template.size.GraphTemplatePercent.Text.getTextViewSize (GraphLayoutSize.kt:38)");
            }
            float f = 0.26f;
            if (TextType.m21684equalsimpl0(i2, TextType.INSTANCE.m21694getTitlegxbDmow())) {
                AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
                    f = 0.28f;
                } else {
                    if (!(AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4()))) {
                        f = 0.135f;
                    }
                }
            } else if (i4 == 1) {
                f = 0.1f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return f;
        }

        @Composable
        /* JADX INFO: renamed from: getTopPadding-R2GYfMI, reason: not valid java name */
        public final float m21950getTopPaddingR2GYfMI(int i, @Nullable Composer composer, int i2) {
            float f;
            composer.startReplaceableGroup(-2055000767);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2055000767, i2, -1, "androidx.glance.oneui.template.size.GraphTemplatePercent.Text.getTopPadding (GraphLayoutSize.kt:57)");
            }
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(i, companion.m21571getTinyrx25Pp4())) {
                f = 0.67f;
            } else {
                f = AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4()) ? 0.69f : AppWidgetSize.m21550equalsimpl0(i, companion.m21569getMediumrx25Pp4()) ? 0.33f : 0.445f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return f;
        }
    }

    private GraphTemplatePercent() {
    }
}
