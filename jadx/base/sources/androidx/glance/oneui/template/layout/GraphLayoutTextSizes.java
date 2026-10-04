package androidx.glance.oneui.template.layout;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
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
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/GraphLayoutTextSizes;", "", "()V", ExternalDataConstants.Column.BODY_TEXT, "Landroidx/glance/oneui/template/layout/TextSize;", "getBodyText", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", Constant.DRAWING_TOOLKIT_KEY_REQUEST_TYPE_TEXT_DESCRIPTION_TEXT, "getDescriptionText", "displayText", "getDisplayText", "labelText", "getLabelText", "titleText", "getTitleText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutTextSizes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/GraphLayoutTextSizes\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,465:1\n74#2:466\n74#2:467\n74#2:468\n74#2:469\n74#2:470\n*S KotlinDebug\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/GraphLayoutTextSizes\n*L\n386#1:466\n413#1:467\n429#1:468\n437#1:469\n450#1:470\n*E\n"})
public final class GraphLayoutTextSizes {
    public static final int $stable = 0;

    @NotNull
    public static final GraphLayoutTextSizes INSTANCE = new GraphLayoutTextSizes();

    private GraphLayoutTextSizes() {
    }

    @Composable
    @JvmName(name = "getBodyText")
    @NotNull
    public final TextSize getBodyText(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1688501192);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1688501192, i, -1, "androidx.glance.oneui.template.layout.GraphLayoutTextSizes.<get-bodyText> (LayoutTextSizes.kt:428)");
        }
        TextSize textSize = AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composer.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8()) ? new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_progress_item_body_text, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null) : new TextSize(14.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }

    @Composable
    @JvmName(name = "getDescriptionText")
    @NotNull
    public final TextSize getDescriptionText(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1362863832);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1362863832, i, -1, "androidx.glance.oneui.template.layout.GraphLayoutTextSizes.<get-descriptionText> (LayoutTextSizes.kt:435)");
        }
        TextSize textSize = new TextSize(AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0 ? 12.0f : 20.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
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
        TextSize textSize;
        TextSize textSize2;
        composer.startReplaceableGroup(-527478296);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-527478296, i, -1, "androidx.glance.oneui.template.layout.GraphLayoutTextSizes.<get-displayText> (LayoutTextSizes.kt:385)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composer.startReplaceableGroup(-685208923);
            composer.endReplaceableGroup();
            textSize2 = new TextSize(14.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
        } else {
            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                composer.startReplaceableGroup(-685208795);
                textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_graph_small_display_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
            } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                composer.startReplaceableGroup(-685208547);
                composer.endReplaceableGroup();
                textSize2 = new TextSize(24.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
            } else {
                composer.startReplaceableGroup(-685208475);
                textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_graph_large_display_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
            }
            textSize2 = textSize;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize2;
    }

    @Composable
    @JvmName(name = "getLabelText")
    @NotNull
    public final TextSize getLabelText(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1728002600);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1728002600, i, -1, "androidx.glance.oneui.template.layout.GraphLayoutTextSizes.<get-labelText> (LayoutTextSizes.kt:449)");
        }
        TextSize textSize = AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composer.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8()) ? new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_progress_item_label_text, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null) : new TextSize(12.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
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
        composer.startReplaceableGroup(1411424168);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1411424168, i, -1, "androidx.glance.oneui.template.layout.GraphLayoutTextSizes.<get-titleText> (LayoutTextSizes.kt:410)");
        }
        Context context = LayoutTextSizesKt.getContext(composer, 0);
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        TextSize textSize = new TextSize(context, AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4()) ? C3094R.dimen.sesl_glance_graph_small_title_text_size : AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? C3094R.dimen.sesl_glance_graph_medium_title_text_size : C3094R.dimen.sesl_glance_graph_large_title_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }
}
