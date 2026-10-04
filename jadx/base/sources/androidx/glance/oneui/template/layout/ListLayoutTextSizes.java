package androidx.glance.oneui.template.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
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
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/ListLayoutTextSizes;", "", "()V", Constant.DRAWING_TOOLKIT_KEY_REQUEST_TYPE_TEXT_DESCRIPTION_TEXT, "Landroidx/glance/oneui/template/layout/TextSize;", "getDescriptionText", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", "displayText", "getDisplayText", "labelText", "getLabelText", "titleText", "getTitleText", ExternalDataConstants.Column.BODY_TEXT, "itemCount", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/glance/oneui/template/layout/TextSize;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutTextSizes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/ListLayoutTextSizes\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,465:1\n74#2:466\n74#2:467\n74#2:468\n*S KotlinDebug\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/ListLayoutTextSizes\n*L\n85#1:466\n113#1:467\n144#1:468\n*E\n"})
public final class ListLayoutTextSizes {
    public static final int $stable = 0;

    @NotNull
    public static final ListLayoutTextSizes INSTANCE = new ListLayoutTextSizes();

    private ListLayoutTextSizes() {
    }

    @Composable
    @NotNull
    public final TextSize bodyText(int i, @Nullable Composer composer, int i2, int i4) {
        TextSize textSize;
        composer.startReplaceableGroup(-1350833937);
        if ((i4 & 1) != 0) {
            i = 2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1350833937, i2, -1, "androidx.glance.oneui.template.layout.ListLayoutTextSizes.bodyText (LayoutTextSizes.kt:111)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
            composer.startReplaceableGroup(-703892888);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_body_text_size_over_medium_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 1.15f, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-703892661);
            TextSize textSize2 = new TextSize(LayoutTextSizesKt.getContext(composer, 0), i <= 2 ? C3094R.dimen.sesl_glance_list_body_text_size : C3094R.dimen.sesl_glance_list_body_text_size_with_3_line, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
            textSize = textSize2;
        }
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
        composer.startReplaceableGroup(-1898245976);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1898245976, i, -1, "androidx.glance.oneui.template.layout.ListLayoutTextSizes.<get-descriptionText> (LayoutTextSizes.kt:134)");
        }
        TextSize textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_description_text_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
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
        composer.startReplaceableGroup(1869479912);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1869479912, i, -1, "androidx.glance.oneui.template.layout.ListLayoutTextSizes.<get-displayText> (LayoutTextSizes.kt:84)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21573getWideSmallrx25Pp4()) <= 0) {
            composer.startReplaceableGroup(1392760906);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_display_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1392761179);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_display_text_over_medium_size, AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? ComplexUnit.f1613DP : ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
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
        composer.startReplaceableGroup(1665142696);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1665142696, i, -1, "androidx.glance.oneui.template.layout.ListLayoutTextSizes.<get-labelText> (LayoutTextSizes.kt:140)");
        }
        TextSize textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_label_text_size, AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) <= 0 ? ComplexUnit.f1613DP : ComplexUnit.f1614SP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
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
        composer.startReplaceableGroup(1100741160);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1100741160, i, -1, "androidx.glance.oneui.template.layout.ListLayoutTextSizes.<get-titleText> (LayoutTextSizes.kt:107)");
        }
        TextSize textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_list_title_text_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }
}
