package androidx.glance.oneui.template.size;

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
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/template/size/TitleBarPercent;", "", "()V", "titleBarHeight", "", "getTitleBarHeight", "(Landroidx/compose/runtime/Composer;I)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTitleBarLayoutSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TitleBarLayoutSize.kt\nandroidx/glance/oneui/template/size/TitleBarPercent\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,24:1\n74#2:25\n*S KotlinDebug\n*F\n+ 1 TitleBarLayoutSize.kt\nandroidx/glance/oneui/template/size/TitleBarPercent\n*L\n15#1:25\n*E\n"})
public final class TitleBarPercent {
    public static final int $stable = 0;

    @NotNull
    public static final TitleBarPercent INSTANCE = new TitleBarPercent();

    private TitleBarPercent() {
    }

    @Composable
    @JvmName(name = "getTitleBarHeight")
    public final float getTitleBarHeight(@Nullable Composer composer, int i) {
        float f;
        composer.startReplaceableGroup(1558161533);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1558161533, i, -1, "androidx.glance.oneui.template.size.TitleBarPercent.<get-titleBarHeight> (TitleBarLayoutSize.kt:13)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4())) {
            f = 0.3f;
        } else {
            f = AppWidgetSize.m21550equalsimpl0(mask, companion.m21566getExtraLargerx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21567getExtraLargeLongrx25Pp4()) ? 0.14f : 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return f;
    }
}
