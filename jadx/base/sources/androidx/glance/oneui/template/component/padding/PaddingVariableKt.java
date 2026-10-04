package androidx.glance.oneui.template.component.padding;

import android.util.SizeF;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.oneui.common.appwidgetsize.AppWidgetSizeInfo;
import androidx.glance.oneui.common.appwidgetsize.SpanSize;
import androidx.glance.oneui.template.CompositionLocalsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"getCell1Height", "", "(Landroidx/compose/runtime/Composer;I)F", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPaddingVariable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PaddingVariable.kt\nandroidx/glance/oneui/template/component/padding/PaddingVariableKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,71:1\n74#2:72\n*S KotlinDebug\n*F\n+ 1 PaddingVariable.kt\nandroidx/glance/oneui/template/component/padding/PaddingVariableKt\n*L\n15#1:72\n*E\n"})
public final class PaddingVariableKt {
    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final float getCell1Height(Composer composer, int i) {
        SizeF dpSize;
        composer.startReplaceableGroup(-1180433564);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1180433564, i, -1, "androidx.glance.oneui.template.component.padding.getCell1Height (PaddingVariable.kt:14)");
        }
        AppWidgetSizeInfo appWidgetSizeInfo = (AppWidgetSizeInfo) ((Map) composer.consume(CompositionLocalsKt.getLocalWidgetSizeInfos())).get(new SpanSize(2, 1));
        float height = (appWidgetSizeInfo == null || (dpSize = appWidgetSizeInfo.getDpSize()) == null) ? 0.0f : dpSize.getHeight();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return height;
    }
}
