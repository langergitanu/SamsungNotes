package androidx.glance.oneui.template.size;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TextType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J,\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, m13886d2 = {"Landroidx/glance/oneui/template/size/CombineTemplatePercent;", "", "()V", "MEDIUM_BOTTOM_PADDING", "", "MEDIUM_TOP_PADDING", "MULTIPLE_PROGRESS_HEIGHT", "getMULTIPLE_PROGRESS_HEIGHT", "(Landroidx/compose/runtime/Composer;I)F", "PRIMARY_CONTENT_SIZE_PERCENT", "getPRIMARY_CONTENT_SIZE_PERCENT", "TINY_ICON_SIZE_WITH_MULTIPLE_TEXT", "getTINY_ICON_SIZE_WITH_MULTIPLE_TEXT", "()F", "TINY_ICON_SIZE_WITH_TEXT", "getTINY_ICON_SIZE_WITH_TEXT", "getButtonSize", "Lkotlin/Pair;", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getButtonSize-L2j3NV4", "(I)Lkotlin/Pair;", "getTextSizeRange", "textType", "Landroidx/glance/oneui/template/TextType;", "getTextSizeRange-tEsvO4U", "(II)Lkotlin/Pair;", "getTextViewHeightPercent", "maxLine", "", "getTextViewHeightPercent-tZlUyYw", "(III)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCombineLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombineLayoutSize.kt\nandroidx/glance/oneui/template/size/CombineTemplatePercent\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,259:1\n74#2:260\n74#2:261\n74#2:262\n74#2:263\n74#2:264\n*S KotlinDebug\n*F\n+ 1 CombineLayoutSize.kt\nandroidx/glance/oneui/template/size/CombineTemplatePercent\n*L\n102#1:260\n114#1:261\n115#1:262\n125#1:263\n147#1:264\n*E\n"})
public final class CombineTemplatePercent {
    public static final int $stable = 0;
    public static final float MEDIUM_BOTTOM_PADDING = 0.09f;
    public static final float MEDIUM_TOP_PADDING = 0.07f;

    @NotNull
    public static final CombineTemplatePercent INSTANCE = new CombineTemplatePercent();
    private static final float TINY_ICON_SIZE_WITH_MULTIPLE_TEXT = 0.25f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.Tablet.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CombineTemplatePercent() {
    }

    @NotNull
    /* JADX INFO: renamed from: getButtonSize-L2j3NV4, reason: not valid java name */
    public final Pair<Float, Float> m21937getButtonSizeL2j3NV4(int widgetSize) {
        Float fValueOf = Float.valueOf(0.385f);
        Float fValueOf2 = Float.valueOf(0.75f);
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        return AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21571getTinyrx25Pp4()) ? TuplesKt.m13893to(fValueOf2, fValueOf2) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21570getSmallrx25Pp4()) ? TuplesKt.m13893to(fValueOf, fValueOf2) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21573getWideSmallrx25Pp4()) ? TuplesKt.m13893to(Float.valueOf(0.175f), fValueOf2) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21569getMediumrx25Pp4()) ? TuplesKt.m13893to(Float.valueOf(0.55f), Float.valueOf(0.33f)) : TuplesKt.m13893to(Float.valueOf(0.285f), fValueOf);
    }

    @Composable
    @JvmName(name = "getMULTIPLE_PROGRESS_HEIGHT")
    public final float getMULTIPLE_PROGRESS_HEIGHT(@Nullable Composer composer, int i) {
        float f;
        composer.startReplaceableGroup(1819943979);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1819943979, i, -1, "androidx.glance.oneui.template.size.CombineTemplatePercent.<get-MULTIPLE_PROGRESS_HEIGHT> (CombineLayoutSize.kt:146)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
            f = 0.322f;
        } else {
            f = AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4()) ? 0.166f : 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }

    @Composable
    @JvmName(name = "getPRIMARY_CONTENT_SIZE_PERCENT")
    public final float getPRIMARY_CONTENT_SIZE_PERCENT(@Nullable Composer composer, int i) {
        float f;
        composer.startReplaceableGroup(2089744555);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2089744555, i, -1, "androidx.glance.oneui.template.size.CombineTemplatePercent.<get-PRIMARY_CONTENT_SIZE_PERCENT> (CombineLayoutSize.kt:112)");
        }
        DeviceType deviceType = (DeviceType) composer.consume(CompositionLocalsKt.getLocalDeviceType());
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            f = 1.0f;
        } else {
            f = AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4()) ? deviceType == DeviceType.Tablet ? AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composer.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21536getLockAndAODmn_SBp8()) ? 0.6f : 0.765f : 0.75f : AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()] == 1 ? 0.31f : 0.33f : AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4()) ? 0.385f : 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }

    public final float getTINY_ICON_SIZE_WITH_MULTIPLE_TEXT() {
        return TINY_ICON_SIZE_WITH_MULTIPLE_TEXT;
    }

    @Composable
    @JvmName(name = "getTINY_ICON_SIZE_WITH_TEXT")
    public final float getTINY_ICON_SIZE_WITH_TEXT(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1897386357);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1897386357, i, -1, "androidx.glance.oneui.template.size.CombineTemplatePercent.<get-TINY_ICON_SIZE_WITH_TEXT> (CombineLayoutSize.kt:100)");
        }
        float f = WhenMappings.$EnumSwitchMapping$0[((DeviceType) composer.consume(CompositionLocalsKt.getLocalDeviceType())).ordinal()] == 1 ? 0.47f : 0.42f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }

    @NotNull
    /* JADX INFO: renamed from: getTextSizeRange-tEsvO4U, reason: not valid java name */
    public final Pair<Float, Float> m21938getTextSizeRangetEsvO4U(int widgetSize, int textType) {
        Float fValueOf = Float.valueOf(14.0f);
        Float fValueOf2 = Float.valueOf(20.0f);
        Float fValueOf3 = Float.valueOf(12.0f);
        if (AppWidgetSize.m21550equalsimpl0(widgetSize, AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4())) {
            return TextType.m21684equalsimpl0(textType, TextType.INSTANCE.m21691getDisplaygxbDmow()) ? new Pair<>(fValueOf3, fValueOf2) : new Pair<>(Float.valueOf(8.0f), fValueOf3);
        }
        TextType.Companion companion = TextType.INSTANCE;
        return TextType.m21684equalsimpl0(textType, companion.m21694getTitlegxbDmow()) ? new Pair<>(fValueOf, fValueOf2) : TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow()) ? new Pair<>(Float.valueOf(15.0f), Float.valueOf(32.0f)) : new Pair<>(Float.valueOf(10.0f), fValueOf);
    }

    /* JADX INFO: renamed from: getTextViewHeightPercent-tZlUyYw, reason: not valid java name */
    public final float m21939getTextViewHeightPercenttZlUyYw(int widgetSize, int textType, int maxLine) {
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(textType, companion.m21694getTitlegxbDmow())) {
            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21573getWideSmallrx25Pp4())) {
                return maxLine == 1 ? 0.31f : 0.61f;
            }
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21568getLargerx25Pp4())) {
                return maxLine == 1 ? 0.135f : 0.27f;
            }
            return 0.0f;
        }
        if (TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow())) {
            AppWidgetSize.Companion companion3 = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21571getTinyrx25Pp4())) {
                return 0.33f;
            }
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21573getWideSmallrx25Pp4())) {
                return 0.38f;
            }
            return AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21568getLargerx25Pp4()) ? 0.255f : 0.0f;
        }
        if (TextType.m21684equalsimpl0(textType, companion.m21689getBodygxbDmow())) {
            AppWidgetSize.Companion companion4 = AppWidgetSize.INSTANCE;
            return AppWidgetSize.m21550equalsimpl0(widgetSize, companion4.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion4.m21568getLargerx25Pp4()) ? 0.1f : 0.0f;
        }
        AppWidgetSize.Companion companion5 = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion5.m21571getTinyrx25Pp4())) {
            return 0.21f;
        }
        if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion5.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion5.m21573getWideSmallrx25Pp4())) {
            return 0.26f;
        }
        return AppWidgetSize.m21550equalsimpl0(widgetSize, companion5.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion5.m21568getLargerx25Pp4()) ? 0.1f : 0.0f;
    }
}
