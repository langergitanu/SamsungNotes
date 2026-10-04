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
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/SingleTextBlockLayoutTextSizes;", "", "()V", ExternalDataConstants.Column.BODY_TEXT, "Landroidx/glance/oneui/template/layout/TextSize;", "getBodyText", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", Constant.DRAWING_TOOLKIT_KEY_REQUEST_TYPE_TEXT_DESCRIPTION_TEXT, "getDescriptionText", "labelText", "getLabelText", "titleText", "getTitleText", "displayText", "length", "", "visibleTextCountInSmall", "(IILandroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutTextSizes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/SingleTextBlockLayoutTextSizes\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,465:1\n74#2:466\n74#2:467\n74#2:468\n74#2:469\n*S KotlinDebug\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/SingleTextBlockLayoutTextSizes\n*L\n240#1:466\n278#1:467\n304#1:468\n311#1:469\n*E\n"})
public final class SingleTextBlockLayoutTextSizes {
    public static final int $stable = 0;

    @NotNull
    public static final SingleTextBlockLayoutTextSizes INSTANCE = new SingleTextBlockLayoutTextSizes();

    private SingleTextBlockLayoutTextSizes() {
    }

    @Composable
    @NotNull
    public final TextSize displayText(int i, int i2, @Nullable Composer composer, int i4) {
        TextSize textSize;
        composer.startReplaceableGroup(-655735170);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-655735170, i4, -1, "androidx.glance.oneui.template.layout.SingleTextBlockLayoutTextSizes.displayText (LayoutTextSizes.kt:238)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composer.startReplaceableGroup(-995281833);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), i < 3 ? C3094R.dimen.sesl_glance_single_textblock_tiny_display_2_size : i == 3 ? C3094R.dimen.sesl_glance_single_textblock_tiny_display_3_size : C3094R.dimen.sesl_glance_single_textblock_tiny_display_4_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                composer.startReplaceableGroup(-995281249);
                textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), i2 == 1 ? C3094R.dimen.sesl_glance_single_textblock_small_display_solo_size : C3094R.dimen.sesl_glance_single_textblock_small_display_couple_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-995280884);
                composer.endReplaceableGroup();
                textSize = new TextSize(40.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }

    @Composable
    @JvmName(name = "getBodyText")
    @NotNull
    public final TextSize getBodyText(@Nullable Composer composer, int i) {
        TextSize textSize;
        composer.startReplaceableGroup(-1755594658);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1755594658, i, -1, "androidx.glance.oneui.template.layout.SingleTextBlockLayoutTextSizes.<get-bodyText> (LayoutTextSizes.kt:277)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
            composer.startReplaceableGroup(-1759958805);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_single_textblock_body_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 1.5f, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1759958553);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_single_textblock_body_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
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
        composer.startReplaceableGroup(1255040446);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1255040446, i, -1, "androidx.glance.oneui.template.layout.SingleTextBlockLayoutTextSizes.<get-descriptionText> (LayoutTextSizes.kt:292)");
        }
        TextSize textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_single_textblock_description_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 1.3f, (DefaultConstructorMarker) null);
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
        composer.startReplaceableGroup(-2086402370);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2086402370, i, -1, "androidx.glance.oneui.template.layout.SingleTextBlockLayoutTextSizes.<get-labelText> (LayoutTextSizes.kt:303)");
        }
        composer.startReplaceableGroup(1381780528);
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        boolean zM21550equalsimpl0 = AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4());
        composer.endReplaceableGroup();
        if (zM21550equalsimpl0) {
            composer.startReplaceableGroup(1381780575);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_single_textblock_tiny_label_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1381780806);
            boolean z = AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), companion.m21573getWideSmallrx25Pp4()) <= 0;
            composer.endReplaceableGroup();
            if (z) {
                composer.startReplaceableGroup(1381780858);
                textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_single_textblock_small_label_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1381781086);
                textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_single_textblock_small_label_size, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 1.5f, (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
            }
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
        composer.startReplaceableGroup(-396063682);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-396063682, i, -1, "androidx.glance.oneui.template.layout.SingleTextBlockLayoutTextSizes.<get-titleText> (LayoutTextSizes.kt:272)");
        }
        TextSize textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_single_textblock_title_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }
}
