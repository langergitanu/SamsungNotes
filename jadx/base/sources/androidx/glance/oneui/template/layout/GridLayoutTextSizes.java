package androidx.glance.oneui.template.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
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
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/GridLayoutTextSizes;", "", "()V", ExternalDataConstants.Column.BODY_TEXT, "Landroidx/glance/oneui/template/layout/TextSize;", "getBodyText", "(Landroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", "labelText", "getLabelText", "()Landroidx/glance/oneui/template/layout/TextSize;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutTextSizes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/GridLayoutTextSizes\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,465:1\n74#2:466\n*S KotlinDebug\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/GridLayoutTextSizes\n*L\n154#1:466\n*E\n"})
public final class GridLayoutTextSizes {
    public static final int $stable = 0;

    @NotNull
    public static final GridLayoutTextSizes INSTANCE = new GridLayoutTextSizes();

    private GridLayoutTextSizes() {
    }

    @Composable
    @JvmName(name = "getBodyText")
    @NotNull
    public final TextSize getBodyText(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1685380000);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1685380000, i, -1, "androidx.glance.oneui.template.layout.GridLayoutTextSizes.<get-bodyText> (LayoutTextSizes.kt:152)");
        }
        TextSize textSize = new TextSize(AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4()) ? 12.0f : 10.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSize;
    }

    @NotNull
    public final TextSize getLabelText() {
        return new TextSize(10.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
    }
}
