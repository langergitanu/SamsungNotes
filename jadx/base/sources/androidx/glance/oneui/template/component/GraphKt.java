package androidx.glance.oneui.template.component;

import androidx.compose.p109ui.Modifier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.GlanceModifier;
import androidx.glance.oneui.template.CircularProgressData;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.StackedGraphData;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.layout.glance.LinearGraphLayoutKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001f\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\r\u001a\u0015\u0010\n\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001a\u001f\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"TemplateCircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "data", "Landroidx/glance/oneui/template/CircularProgressData;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/CircularProgressData;Landroidx/compose/runtime/Composer;I)V", "Landroidx/glance/GlanceModifier;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/CircularProgressData;Landroidx/compose/runtime/Composer;I)V", "(Landroidx/glance/oneui/template/CircularProgressData;Landroidx/compose/runtime/Composer;I)V", "TemplateLinearProgressIndicator", "Landroidx/glance/oneui/template/LinearProgressData;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/LinearProgressData;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/LinearProgressData;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/glance/oneui/template/LinearProgressData;Landroidx/compose/runtime/Composer;I)V", "TemplateStackedProgressIndicator", "Landroidx/glance/oneui/template/StackedGraphData;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/StackedGraphData;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/StackedGraphData;Landroidx/compose/runtime/Composer;II)V", "graphSizeResId", "", "(Landroidx/glance/oneui/template/StackedGraphData;ILandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Graph.kt\nandroidx/glance/oneui/template/component/GraphKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,83:1\n74#2:84\n74#2:85\n74#2:86\n*S KotlinDebug\n*F\n+ 1 Graph.kt\nandroidx/glance/oneui/template/component/GraphKt\n*L\n34#1:84\n57#1:85\n77#1:86\n*E\n"})
public final class GraphKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateCircularProgressIndicator(@NotNull final GlanceModifier modifier, @NotNull final CircularProgressData data, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1310879670);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1310879670, i, -1, "androidx.glance.oneui.template.component.TemplateCircularProgressIndicator (Graph.kt:64)");
        }
        ProgressIndicatorKt.GlanceCircularProgressIndicator(modifier, data, 0, null, composerStartRestartGroup, (i & 14) | 64, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateCircularProgressIndicator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    GraphKt.TemplateCircularProgressIndicator(modifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateLinearProgressIndicator(@Nullable final GlanceModifier glanceModifier, @NotNull final LinearProgressData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-315948918);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-315948918, i, -1, "androidx.glance.oneui.template.component.TemplateLinearProgressIndicator (Graph.kt:21)");
        }
        ProgressIndicatorKt.GlanceLinearProgressIndicator(glanceModifier, data, composerStartRestartGroup, (i & 14) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateLinearProgressIndicator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    GraphKt.TemplateLinearProgressIndicator(glanceModifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateStackedProgressIndicator(@Nullable final GlanceModifier glanceModifier, @NotNull final StackedGraphData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1716311885);
        if ((i2 & 1) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1716311885, i, -1, "androidx.glance.oneui.template.component.TemplateStackedProgressIndicator (Graph.kt:44)");
        }
        LinearGraphLayoutKt.GlanceStackedGraph(glanceModifier, data, composerStartRestartGroup, (i & 14) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateStackedProgressIndicator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    GraphKt.TemplateStackedProgressIndicator(glanceModifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateCircularProgressIndicator(@NotNull final Modifier modifier, @NotNull final CircularProgressData data, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1861966302);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1861966302, i, -1, "androidx.glance.oneui.template.component.TemplateCircularProgressIndicator (Graph.kt:69)");
        }
        androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeCircularProgressIndicator(modifier, data, 0, null, composerStartRestartGroup, (i & 14) | 64, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateCircularProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    GraphKt.TemplateCircularProgressIndicator(modifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "Use TemplateCircularProgressIndicator(GlanceModifier, CircularProgressData) instead")
    @Composable
    public static final void TemplateCircularProgressIndicator(@NotNull CircularProgressData data, @Nullable Composer composer, final int i) {
        final CircularProgressData circularProgressData;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1279351619);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1279351619, i, -1, "androidx.glance.oneui.template.component.TemplateCircularProgressIndicator (Graph.kt:75)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(2015998830);
            ProgressIndicatorKt.GlanceCircularProgressIndicator(data, composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
            circularProgressData = data;
        } else {
            composerStartRestartGroup.startReplaceableGroup(2015998889);
            circularProgressData = data;
            androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeCircularProgressIndicator(null, circularProgressData, 0, null, composerStartRestartGroup, 64, 13);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateCircularProgressIndicator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    GraphKt.TemplateCircularProgressIndicator(circularProgressData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TemplateLinearProgressIndicator(@Nullable final Modifier modifier, @NotNull final LinearProgressData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1774842526);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1774842526, i, -1, "androidx.glance.oneui.template.component.TemplateLinearProgressIndicator (Graph.kt:26)");
        }
        androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeLinearProgressIndicator(modifier, data, composerStartRestartGroup, (i & 14) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateLinearProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    GraphKt.TemplateLinearProgressIndicator(modifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TemplateStackedProgressIndicator(@Nullable final Modifier modifier, @NotNull final StackedGraphData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1708117791);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1708117791, i, -1, "androidx.glance.oneui.template.component.TemplateStackedProgressIndicator (Graph.kt:49)");
        }
        androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeStackedGraph(modifier, data, composerStartRestartGroup, (i & 14) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateStackedProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    GraphKt.TemplateStackedProgressIndicator(modifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(message = "Use TemplateLinearProgressIndicator(GlanceModifier, LinearProgressData) instead")
    @Composable
    public static final void TemplateLinearProgressIndicator(@NotNull final LinearProgressData data, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(968782223);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(968782223, i, -1, "androidx.glance.oneui.template.component.TemplateLinearProgressIndicator (Graph.kt:32)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(-1132775782);
            ProgressIndicatorKt.GlanceLinearProgressIndicator(data, 0, composerStartRestartGroup, 8, 2);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1132775725);
            androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeLinearProgressIndicator(data, 0, composerStartRestartGroup, 8, 2);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateLinearProgressIndicator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    GraphKt.TemplateLinearProgressIndicator(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Deprecated(message = "Use TemplateStackedProgressIndicator(GlanceModifier, StackedGraphData) instead")
    @Composable
    public static final void TemplateStackedProgressIndicator(@NotNull final StackedGraphData data, final int i, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-978871079);
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-978871079, i2, -1, "androidx.glance.oneui.template.component.TemplateStackedProgressIndicator (Graph.kt:55)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(-728030175);
            LinearGraphLayoutKt.GlanceStackedGraph(data, i, composerStartRestartGroup, (i2 & 112) | 8, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-728030113);
            androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeStackedGraph(data, i, composerStartRestartGroup, (i2 & 112) | 8, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.GraphKt.TemplateStackedProgressIndicator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    GraphKt.TemplateStackedProgressIndicator(data, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
