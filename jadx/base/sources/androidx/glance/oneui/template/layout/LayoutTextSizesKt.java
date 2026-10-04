package androidx.glance.oneui.template.layout;

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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"getContext", "Landroid/content/Context;", "(Landroidx/compose/runtime/Composer;I)Landroid/content/Context;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutTextSizes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/LayoutTextSizesKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,465:1\n74#2:466\n74#2:467\n*S KotlinDebug\n*F\n+ 1 LayoutTextSizes.kt\nandroidx/glance/oneui/template/layout/LayoutTextSizesKt\n*L\n462#1:466\n463#1:467\n*E\n"})
public final class LayoutTextSizesKt {
    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Context getContext(Composer composer, int i) {
        Context context;
        composer.startReplaceableGroup(1198500138);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1198500138, i, -1, "androidx.glance.oneui.template.layout.getContext (LayoutTextSizes.kt:460)");
        }
        if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composer.startReplaceableGroup(-1589076638);
            context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1589076579);
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
