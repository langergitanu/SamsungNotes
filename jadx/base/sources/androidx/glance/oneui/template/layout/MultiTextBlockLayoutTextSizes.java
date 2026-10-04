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
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/MultiTextBlockLayoutTextSizes;", "", "()V", ExternalDataConstants.Column.BODY_TEXT, "Landroidx/glance/oneui/template/layout/TextSize;", "getBodyText", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", "displayText", "getDisplayText", "labelText", "getLabelText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutTextSizes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/MultiTextBlockLayoutTextSizes\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,465:1\n74#2:466\n74#2:467\n*S KotlinDebug\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/MultiTextBlockLayoutTextSizes\n*L\n333#1:466\n368#1:467\n*E\n"})
public final class MultiTextBlockLayoutTextSizes {
    public static final int $stable = 0;

    @NotNull
    public static final MultiTextBlockLayoutTextSizes INSTANCE = new MultiTextBlockLayoutTextSizes();

    private MultiTextBlockLayoutTextSizes() {
    }

    @Composable
    @JvmName(name = "getBodyText")
    @NotNull
    public final TextSize getBodyText(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-287171169);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-287171169, i, -1, "androidx.glance.oneui.template.layout.MultiTextBlockLayoutTextSizes.<get-bodyText> (LayoutTextSizes.kt:361)");
        }
        TextSize textSize = new TextSize(12.0f, ComplexUnit.f1614SP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
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
        composer.startReplaceableGroup(670444415);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(670444415, i, -1, "androidx.glance.oneui.template.layout.MultiTextBlockLayoutTextSizes.<get-displayText> (LayoutTextSizes.kt:332)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4())) {
            composer.startReplaceableGroup(332284234);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_multi_textblock_small_display_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
            composer.startReplaceableGroup(332284515);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_multi_textblock_widesmall_display_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
            composer.startReplaceableGroup(332284797);
            textSize = new TextSize(LayoutTextSizesKt.getContext(composer, 0), C3094R.dimen.sesl_glance_multi_textblock_medium_display_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(332285040);
            composer.endReplaceableGroup();
            textSize = new TextSize(40.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
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
        composer.startReplaceableGroup(256346943);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(256346943, i, -1, "androidx.glance.oneui.template.layout.MultiTextBlockLayoutTextSizes.<get-labelText> (LayoutTextSizes.kt:366)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        TextSize textSize = new TextSize(AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4()) ? 10.0f : AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? 12.0f : 16.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }
}
