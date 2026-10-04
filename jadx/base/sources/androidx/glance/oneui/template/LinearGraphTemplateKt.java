package androidx.glance.oneui.template;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, m13886d2 = {"LinearGraphTemplate", "", "data", "Landroidx/glance/oneui/template/LinearGraphData;", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "descriptionContent", "detailGraphContent", "titleBar", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "(Landroidx/glance/oneui/template/LinearGraphData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLinearGraphTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinearGraphTemplate.kt\nandroidx/glance/oneui/template/LinearGraphTemplateKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,46:1\n74#2:47\n*S KotlinDebug\n*F\n+ 1 LinearGraphTemplate.kt\nandroidx/glance/oneui/template/LinearGraphTemplateKt\n*L\n16#1:47\n*E\n"})
public final class LinearGraphTemplateKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void LinearGraphTemplate(@NotNull final LinearGraphData data, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable TitleBarData titleBarData, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-805331563);
        Function2<? super Composer, ? super Integer, Unit> function25 = (i2 & 2) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = (i2 & 4) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = (i2 & 8) != 0 ? null : function23;
        TitleBarData titleBarData2 = (i2 & 16) != 0 ? null : titleBarData;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i2 & 32) != 0 ? null : function24;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-805331563, i, -1, "androidx.glance.oneui.template.LinearGraphTemplate (LinearGraphTemplate.kt:14)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(2114316702);
            LinearGraphLayoutKt.GlanceLinearGraphLayout(data, function25, function26, function27, titleBarData2, function28, composerStartRestartGroup, (i & 112) | 32776 | (i & 896) | (i & 7168) | (458752 & i));
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(2114316920);
            androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeLinearGraphLayout(data, function25, function26, function27, titleBarData2, function28, composerStartRestartGroup, (i & 112) | 32776 | (i & 896) | (i & 7168) | (458752 & i));
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function29 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function211 = function27;
            final TitleBarData titleBarData3 = titleBarData2;
            final Function2<? super Composer, ? super Integer, Unit> function212 = function28;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.LinearGraphTemplateKt.LinearGraphTemplate.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LinearGraphTemplateKt.LinearGraphTemplate(data, function29, function210, function211, titleBarData3, function212, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
