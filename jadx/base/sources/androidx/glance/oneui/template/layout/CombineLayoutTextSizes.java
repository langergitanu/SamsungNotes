package androidx.glance.oneui.template.layout;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/CombineLayoutTextSizes;", "", "()V", ExternalDataConstants.Column.BODY_TEXT, "Landroidx/glance/oneui/template/layout/TextSize;", "getBodyText", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", "displayText", "getDisplayText", "labelText", "getLabelText", "titleText", "getTitleText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutTextSizes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/CombineLayoutTextSizes\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,465:1\n74#2:466\n74#2:467\n74#2:468\n74#2:469\n74#2:470\n*S KotlinDebug\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/CombineLayoutTextSizes\n*L\n173#1:466\n187#1:467\n202#1:468\n217#1:469\n220#1:470\n*E\n"})
public final class CombineLayoutTextSizes {
    public static final int $stable = 0;

    @NotNull
    public static final CombineLayoutTextSizes INSTANCE = new CombineLayoutTextSizes();

    private CombineLayoutTextSizes() {
    }

    @Composable
    @JvmName(name = "getBodyText")
    @NotNull
    public final TextSize getBodyText(@Nullable Composer composer, int i) {
        TextSize textSize;
        composer.startReplaceableGroup(1960884727);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1960884727, i, -1, "androidx.glance.oneui.template.layout.CombineLayoutTextSizes.<get-bodyText> (LayoutTextSizes.kt:201)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0) {
            composer.startReplaceableGroup(-1968877210);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_combine_body_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1968877094);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_combine_body_text_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 1.15f, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }

    @Composable
    @JvmName(name = "getDisplayText")
    @NotNull
    public final TextSize getDisplayText(@Nullable Composer composer, int i) {
        int i2;
        composer.startReplaceableGroup(-1586591721);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1586591721, i, -1, "androidx.glance.oneui.template.layout.CombineLayoutTextSizes.<get-displayText> (LayoutTextSizes.kt:170)");
        }
        Context context = LayoutTextSizesKt.getContext(composer, 0);
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            i2 = C3094R.dimen.sesl_glance_combine_display_text_tiny_size;
        } else {
            i2 = AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4()) ? C3094R.dimen.sesl_glance_combine_display_text_small_size : C3094R.dimen.sesl_glance_combine_display_text_medium_over_size;
        }
        TextSize textSize = new TextSize(context, i2, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }

    @Composable
    @JvmName(name = "getLabelText")
    @NotNull
    public final TextSize getLabelText(@Nullable Composer composer, int i) {
        TextSize textSize;
        composer.startReplaceableGroup(1267032151);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1267032151, i, -1, "androidx.glance.oneui.template.layout.CombineLayoutTextSizes.<get-labelText> (LayoutTextSizes.kt:216)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4()) >= 0) {
            composer.startReplaceableGroup(-799643353);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) ? C3094R.dimen.sesl_glance_combine_label_text_small_over_size : C3094R.dimen.sesl_glance_combine_label_monotone_text_small_over_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 1.15f, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-799642926);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_combine_label_text_tiny_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }

    @Composable
    @JvmName(name = "getTitleText")
    @NotNull
    public final TextSize getTitleText(@Nullable Composer composer, int i) {
        TextSize textSize;
        composer.startReplaceableGroup(1977837015);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1977837015, i, -1, "androidx.glance.oneui.template.layout.CombineLayoutTextSizes.<get-titleText> (LayoutTextSizes.kt:186)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0) {
            composer.startReplaceableGroup(-344724032);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_combine_title_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-344723913);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_combine_title_text_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 1.15f, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }
}
