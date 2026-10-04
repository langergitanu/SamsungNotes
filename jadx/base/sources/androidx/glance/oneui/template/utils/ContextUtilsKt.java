package androidx.glance.oneui.template.utils;

import android.content.Context;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TemplateCompositor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"getCurrentEnvironmentContext", "Landroid/content/Context;", "(Landroidx/compose/runtime/Composer;I)Landroid/content/Context;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContextUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextUtils.kt\nandroidx/glance/oneui/template/utils/ContextUtilsKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,17:1\n74#2:18\n74#2:19\n74#2:20\n*S KotlinDebug\n*F\n+ 1 ContextUtils.kt\nandroidx/glance/oneui/template/utils/ContextUtilsKt\n*L\n11#1:18\n12#1:19\n14#1:20\n*E\n"})
public final class ContextUtilsKt {
    @Composable
    @NotNull
    public static final Context getCurrentEnvironmentContext(@Nullable Composer composer, int i) {
        Context context;
        composer.startReplaceableGroup(1865269086);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1865269086, i, -1, "androidx.glance.oneui.template.utils.getCurrentEnvironmentContext (ContextUtils.kt:9)");
        }
        if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composer.startReplaceableGroup(-1346186396);
            context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1346186354);
            context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return context;
    }
}
