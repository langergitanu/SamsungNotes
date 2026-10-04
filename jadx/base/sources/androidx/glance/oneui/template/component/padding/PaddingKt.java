package androidx.glance.oneui.template.component.padding;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.FuturePublicApi;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"padding", "Landroidx/glance/GlanceModifier;", "Landroidx/glance/oneui/template/component/padding/Padding;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/component/padding/Padding;Landroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PaddingKt {
    @Composable
    @FuturePublicApi
    @NotNull
    public static final GlanceModifier padding(@NotNull GlanceModifier glanceModifier, @NotNull Padding padding, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(padding, "padding");
        composer.startReplaceableGroup(1742596126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1742596126, i, -1, "androidx.glance.oneui.template.component.padding.padding (Padding.kt:142)");
        }
        int i2 = (i >> 3) & 14;
        GlanceModifier glanceModifierM21499paddingqDBjuR0 = androidx.glance.layout.PaddingKt.m21499paddingqDBjuR0(glanceModifier, padding.m21767getStartchRvn1I(composer, i2), padding.m21769getTopchRvn1I(composer, i2), padding.m21765getEndchRvn1I(composer, i2), padding.m21763getBottomchRvn1I(composer, i2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21499paddingqDBjuR0;
    }
}
