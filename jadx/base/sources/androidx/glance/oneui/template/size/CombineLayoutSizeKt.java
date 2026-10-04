package androidx.glance.oneui.template.size;

import android.content.Context;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TemplateCompositor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"getSmallestWidth", "", "(Landroidx/compose/runtime/Composer;I)I", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCombineLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombineLayoutSize.kt\nandroidx/glance/oneui/template/size/CombineLayoutSizeKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,259:1\n74#2:260\n74#2:261\n74#2:262\n*S KotlinDebug\n*F\n+ 1 CombineLayoutSize.kt\nandroidx/glance/oneui/template/size/CombineLayoutSizeKt\n*L\n252#1:260\n253#1:261\n254#1:262\n*E\n"})
public final class CombineLayoutSizeKt {
    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final int getSmallestWidth(Composer composer, int i) {
        Object objM22215constructorimpl;
        Context context;
        composer.startReplaceableGroup(391440730);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(391440730, i, -1, "androidx.glance.oneui.template.size.getSmallestWidth (CombineLayoutSize.kt:248)");
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getCompose())) {
                composer.startReplaceableGroup(-1878978032);
                context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1878977990);
                context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
                composer.endReplaceableGroup();
            }
            objM22215constructorimpl = Result.m22215constructorimpl(Integer.valueOf(context.getResources().getConfiguration().smallestScreenWidthDp));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        Integer num = (Integer) objM22215constructorimpl;
        int iIntValue = num != null ? num.intValue() : 0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iIntValue;
    }
}
