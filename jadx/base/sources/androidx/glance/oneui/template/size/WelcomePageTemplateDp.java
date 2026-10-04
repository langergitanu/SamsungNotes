package androidx.glance.oneui.template.size;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/template/size/WelcomePageTemplateDp;", "", "()V", "HORIZONTAL_PADDING_OVER_MEDIUM", "Landroidx/compose/ui/unit/Dp;", "getHORIZONTAL_PADDING_OVER_MEDIUM", "(Landroidx/compose/runtime/Composer;I)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWelcomePageLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WelcomePageLayoutSize.kt\nandroidx/glance/oneui/template/size/WelcomePageTemplateDp\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,64:1\n74#2:65\n154#3:66\n154#3:67\n*S KotlinDebug\n*F\n+ 1 WelcomePageLayoutSize.kt\nandroidx/glance/oneui/template/size/WelcomePageTemplateDp\n*L\n59#1:65\n60#1:66\n61#1:67\n*E\n"})
public final class WelcomePageTemplateDp {
    public static final int $stable = 0;

    @NotNull
    public static final WelcomePageTemplateDp INSTANCE = new WelcomePageTemplateDp();

    private WelcomePageTemplateDp() {
    }

    @Composable
    @JvmName(name = "getHORIZONTAL_PADDING_OVER_MEDIUM")
    public final float getHORIZONTAL_PADDING_OVER_MEDIUM(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1011423210);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1011423210, i, -1, "androidx.glance.oneui.template.size.WelcomePageTemplateDp.<get-HORIZONTAL_PADDING_OVER_MEDIUM> (WelcomePageLayoutSize.kt:58)");
        }
        float fM20968constructorimpl = AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) ? C2256Dp.m20968constructorimpl(14) : C2256Dp.m20968constructorimpl(16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }
}
