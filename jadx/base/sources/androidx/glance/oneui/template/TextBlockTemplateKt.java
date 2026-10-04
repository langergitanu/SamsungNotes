package androidx.glance.oneui.template;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.oneui.template.layout.glance.TextBlockLayoutKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"TextBlockTemplate", "", "data", "Landroidx/glance/oneui/template/TextBlockData;", "mainContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "subContent", "(Landroidx/glance/oneui/template/TextBlockData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextBlockTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextBlockTemplate.kt\nandroidx/glance/oneui/template/TextBlockTemplateKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,122:1\n74#2:123\n74#2:124\n74#2:125\n*S KotlinDebug\n*F\n+ 1 TextBlockTemplate.kt\nandroidx/glance/oneui/template/TextBlockTemplateKt\n*L\n48#1:123\n22#1:124\n40#1:125\n*E\n"})
public final class TextBlockTemplateKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_]]")
    public static final void TextBlockTemplate(@NotNull final TextBlockData data, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, int i, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(37139499);
        Function2<? super Composer, ? super Integer, Unit> function2ComposableLambda = null;
        Function2<? super Composer, ? super Integer, Unit> function23 = (i2 & 2) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = (i2 & 4) != 0 ? null : function22;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(37139499, i4, -1, "androidx.glance.oneui.template.TextBlockTemplate (TextBlockTemplate.kt:18)");
        } else {
            i4 = i;
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(427298931);
            TextBlockItem mainTextBlock = data.getMainTextBlock();
            Function2<? super Composer, ? super Integer, Unit> function2ComposableLambda2 = function23 != null ? function23 : ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1806465388, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.TextBlockTemplateKt.TextBlockTemplate.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i5) {
                    if ((i5 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1806465388, i5, -1, "androidx.glance.oneui.template.TextBlockTemplate.<anonymous> (TextBlockTemplate.kt:53)");
                    }
                    TextBlockTemplateKt.TextBlockTemplate$MainContent(data, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            TextBlockItem subTextBlock = data.getSubTextBlock();
            if (function24 != null) {
                function2ComposableLambda = function24;
            } else if (data.getSubTextBlock() != null) {
                function2ComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1309532197, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.TextBlockTemplateKt.TextBlockTemplate.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i5) {
                        if ((i5 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1309532197, i5, -1, "androidx.glance.oneui.template.TextBlockTemplate.<anonymous> (TextBlockTemplate.kt:58)");
                        }
                        TextBlockTemplateKt.TextBlockTemplate$SubContent(data, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
            }
            TextBlockLayoutKt.GlanceTextBlockLayout(mainTextBlock, function2ComposableLambda2, subTextBlock, function2ComposableLambda, data.getDividerColor(), composerStartRestartGroup, 33288);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(427299357);
            TextBlockItem mainTextBlock2 = data.getMainTextBlock();
            Function2<? super Composer, ? super Integer, Unit> function2ComposableLambda3 = function23 != null ? function23 : ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1065094727, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.TextBlockTemplateKt.TextBlockTemplate.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i5) {
                    if ((i5 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1065094727, i5, -1, "androidx.glance.oneui.template.TextBlockTemplate.<anonymous> (TextBlockTemplate.kt:68)");
                    }
                    TextBlockTemplateKt.TextBlockTemplate$MainContent(data, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            TextBlockItem subTextBlock2 = data.getSubTextBlock();
            if (function24 != null) {
                function2ComposableLambda = function24;
            } else if (data.getSubTextBlock() != null) {
                function2ComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1027063446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.TextBlockTemplateKt.TextBlockTemplate.4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i5) {
                        if ((i5 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1027063446, i5, -1, "androidx.glance.oneui.template.TextBlockTemplate.<anonymous> (TextBlockTemplate.kt:73)");
                        }
                        TextBlockTemplateKt.TextBlockTemplate$SubContent(data, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
            }
            androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockLayout(mainTextBlock2, function2ComposableLambda3, subTextBlock2, function2ComposableLambda, data.getDividerColor(), composerStartRestartGroup, 33288);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
            final int i5 = i4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.TextBlockTemplateKt.TextBlockTemplate.5
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    TextBlockTemplateKt.TextBlockTemplate(data, function25, function26, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TextBlockTemplate$MainContent(TextBlockData textBlockData, Composer composer, int i) {
        composer.startReplaceableGroup(1393932755);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1393932755, i, -1, "androidx.glance.oneui.template.TextBlockTemplate.MainContent (TextBlockTemplate.kt:20)");
        }
        if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composer.startReplaceableGroup(-1189366197);
            TextBlockLayoutKt.GlanceTextBlockTextList(textBlockData.getMainTextBlock().getTextList(), textBlockData.getMainTextBlock().getFromSingleBlock$glance_oneui_template_release(), textBlockData.getMainTextBlock().getDefaultTextColor(composer, 8), composer, 520);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1189365979);
            androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockTextList(textBlockData.getMainTextBlock().getTextList(), textBlockData.getMainTextBlock().getFromSingleBlock$glance_oneui_template_release(), textBlockData.getMainTextBlock().getDefaultTextColor(composer, 8), composer, 520);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TextBlockTemplate$SubContent(TextBlockData textBlockData, Composer composer, int i) {
        composer.startReplaceableGroup(-695271416);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-695271416, i, -1, "androidx.glance.oneui.template.TextBlockTemplate.SubContent (TextBlockTemplate.kt:37)");
        }
        TextBlockItem subTextBlock = textBlockData.getSubTextBlock();
        if (subTextBlock != null) {
            if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                composer.startReplaceableGroup(-1431946854);
                TextBlockLayoutKt.GlanceTextBlockTextList(subTextBlock.getTextList(), subTextBlock.getFromSingleBlock$glance_oneui_template_release(), subTextBlock.getDefaultTextColor(composer, 8), composer, 520);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1431946739);
                androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockTextList(subTextBlock.getTextList(), subTextBlock.getFromSingleBlock$glance_oneui_template_release(), subTextBlock.getDefaultTextColor(composer, 8), composer, 520);
                composer.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
