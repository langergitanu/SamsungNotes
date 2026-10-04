package androidx.glance.oneui.template.layout.glance.combine.legacy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.layout.Alignment;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.CircularProgressData;
import androidx.glance.oneui.template.CombineData;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.oneui.template.TertiaryContentData;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001ac\u0010\u000f\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"Legacy70PreviewCombineTemplate", "", "data", "Landroidx/glance/oneui/template/CombineData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryContent", "secondaryContentAlign", "Landroidx/glance/layout/Alignment$Vertical;", "tertiaryContent", "tertiaryContentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "Legacy70PreviewCombineTemplate-hlbQeY0", "(Landroidx/glance/oneui/template/CombineData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;ILandroidx/compose/runtime/Composer;II)V", "LegacyCombineTemplate", "LegacyCombineTemplate-vBhK2Fw", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;ILandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLegacyCombineTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyCombineTemplate.kt\nandroidx/glance/oneui/template/layout/glance/combine/legacy/LegacyCombineTemplateKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n74#2:166\n74#2:167\n1#3:168\n*S KotlinDebug\n*F\n+ 1 LegacyCombineTemplate.kt\nandroidx/glance/oneui/template/layout/glance/combine/legacy/LegacyCombineTemplateKt\n*L\n25#1:166\n91#1:167\n*E\n"})
public final class LegacyCombineTemplateKt {
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba  */
    @Composable
    /* JADX INFO: renamed from: Legacy70PreviewCombineTemplate-hlbQeY0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21871Legacy70PreviewCombineTemplatehlbQeY0(@NotNull final CombineData data, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, int i, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, int i2, @Nullable Composer composer, int i4, final int i5) {
        int i6;
        int iM21429getBottommnfRV0w;
        int i7;
        final int iM21432getEndPGIyAqw;
        final boolean z;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int alignWithPrimaryContent;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(253792675);
        ComposableLambda composableLambda = null;
        Function2<? super Composer, ? super Integer, Unit> function25 = (i5 & 2) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = (i5 & 4) != 0 ? null : function22;
        if ((i5 & 8) != 0) {
            i6 = i4;
            i7 = i6 & (-7169);
            iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
        } else {
            i6 = i4;
            iM21429getBottommnfRV0w = i;
            i7 = i6;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = (i5 & 16) != 0 ? null : function23;
        if ((i5 & 32) != 0) {
            i7 &= -458753;
            iM21432getEndPGIyAqw = Alignment.INSTANCE.m21432getEndPGIyAqw();
        } else {
            iM21432getEndPGIyAqw = i2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(253792675, i7, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate (LegacyCombineTemplate.kt:23)");
        }
        Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance());
        Function2<? super Composer, ? super Integer, Unit> function2ComposableLambda = function25 == null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -264431856, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineTemplateKt$Legacy70PreviewCombineTemplate$finalPrimaryContent$1
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
            public final void invoke(@Nullable Composer composer2, int i8) {
                if ((i8 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-264431856, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate.<anonymous> (LegacyCombineTemplate.kt:82)");
                }
                if (data.getPrimaryContentData() != null) {
                    CombineData combineData = data;
                    LegacyCombineTemplateKt.Legacy70PreviewCombineTemplate_hlbQeY0$PrimaryContent(combineData, combineData.getPrimaryContentData(), composer2, 8);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }) : function25;
        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4()) && function26 == null && function27 == null) {
            SecondaryContentData secondaryContentData = data.getSecondaryContentData();
            if ((secondaryContentData != null ? secondaryContentData.getTextList() : null) != null) {
                TertiaryContentData tertiaryContentData = data.getTertiaryContentData();
                if ((tertiaryContentData != null ? tertiaryContentData.getTextList() : null) != null) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        Function2<? super Composer, ? super Integer, Unit> function2ComposableLambda2 = function26 == null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 369222430, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineTemplateKt$Legacy70PreviewCombineTemplate$finalSecondaryContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
            public final void invoke(@Nullable Composer composer2, int i8) {
                if ((i8 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(369222430, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate.<anonymous> (LegacyCombineTemplate.kt:99)");
                }
                if (data.getSecondaryContentData() != null) {
                    if (z) {
                        composer2.startReplaceableGroup(-1252922911);
                        SecondaryContentData secondaryContentData2 = data.getSecondaryContentData();
                        Intrinsics.checkNotNull(secondaryContentData2);
                        TertiaryContentData tertiaryContentData2 = data.getTertiaryContentData();
                        Intrinsics.checkNotNull(tertiaryContentData2);
                        LegacyCombineTemplateKt.m2326x130ca615(secondaryContentData2, tertiaryContentData2, composer2, 72);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-1252922682);
                        LegacyCombineTemplateKt.Legacy70PreviewCombineTemplate_hlbQeY0$SecondaryContent(data.getSecondaryContentData(), composer2, 8);
                        composer2.endReplaceableGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }) : function26;
        if (function27 == null) {
            if (!z && data.getTertiaryContentData() != null) {
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -459687909, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineTemplateKt$Legacy70PreviewCombineTemplate$finalTertiaryContent$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    public final void invoke(@Nullable Composer composer2, int i8) {
                        if ((i8 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-459687909, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate.<anonymous> (LegacyCombineTemplate.kt:116)");
                        }
                        LegacyCombineTemplateKt.Legacy70PreviewCombineTemplate_hlbQeY0$TertiaryContent(iM21432getEndPGIyAqw, data.getTertiaryContentData(), composer2, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
            }
            function24 = composableLambda;
        } else {
            function24 = function27;
        }
        if (function26 != null) {
            alignWithPrimaryContent = iM21429getBottommnfRV0w;
        } else {
            alignWithPrimaryContent = data.getSecondaryContentData() != null ? data.getSecondaryContentData().getAlignWithPrimaryContent() : Alignment.INSTANCE.m21429getBottommnfRV0w();
        }
        LegacyCombineLayoutKt.m21870Legacy70PreviewCombineLayoutKp2Snc(data, function2ComposableLambda, function2ComposableLambda2, alignWithPrimaryContent, function24, function27 != null ? iM21432getEndPGIyAqw : data.getTertiaryContentData() != null ? data.getTertiaryContentData().getAlignWithSecondaryContent() : Alignment.INSTANCE.m21432getEndPGIyAqw(), composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final int i8 = i6;
            final int i9 = iM21429getBottommnfRV0w;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final int i10 = iM21432getEndPGIyAqw;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineTemplateKt$Legacy70PreviewCombineTemplate$1
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

                public final void invoke(@Nullable Composer composer2, int i11) {
                    LegacyCombineTemplateKt.m21871Legacy70PreviewCombineTemplatehlbQeY0(data, function28, function29, i9, function210, i10, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), i5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void Legacy70PreviewCombineTemplate_hlbQeY0$PrimaryContent(CombineData combineData, PrimaryContentData primaryContentData, Composer composer, int i) {
        composer.startReplaceableGroup(1952678429);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1952678429, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate.PrimaryContent (LegacyCombineTemplate.kt:27)");
        }
        ImageData image = primaryContentData.getImage();
        composer.startReplaceableGroup(1168285153);
        if (image != null) {
            if (image instanceof ImageButtonData) {
                composer.startReplaceableGroup(-442211409);
                LegacyCombineLayoutKt.GlancePrimaryImageButton((ImageButtonData) image, composer, 8);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-442211343);
                SecondaryContentData secondaryContentData = combineData.getSecondaryContentData();
                LegacyCombineLayoutKt.GlancePrimaryIcon(image, secondaryContentData != null ? secondaryContentData.getTextList() : null, composer, 72);
                composer.endReplaceableGroup();
            }
            Unit unit = Unit.INSTANCE;
        }
        composer.endReplaceableGroup();
        CircularProgressData progressIndicator = primaryContentData.getProgressIndicator();
        if (progressIndicator != null) {
            ProgressIndicatorKt.GlanceCircularProgressIndicator(progressIndicator, composer, 8);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void Legacy70PreviewCombineTemplate_hlbQeY0$SecondaryContent(SecondaryContentData secondaryContentData, Composer composer, int i) {
        Composer composer2;
        composer.startReplaceableGroup(-1050651235);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1050651235, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate.SecondaryContent (LegacyCombineTemplate.kt:39)");
        }
        if (secondaryContentData.getTextList() != null) {
            composer.startReplaceableGroup(-2121444751);
            LegacyCombineLayoutKt.GlanceCombineTexts(secondaryContentData.getTextList(), null, composer, 8, 2);
            composer.endReplaceableGroup();
            composer2 = composer;
        } else if (secondaryContentData.getFirstProgressBar() == null || secondaryContentData.getSecondProgressBar() == null) {
            composer2 = composer;
            composer2.startReplaceableGroup(-2121444347);
            composer2.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2121444587);
            composer2 = composer;
            LegacyCombineLayoutKt.m21868GlanceCombineProgressBarsRJlTeC8(true, secondaryContentData.getFirstProgressBar(), secondaryContentData.getSecondProgressBar(), secondaryContentData.getAlignWithPrimaryContent(), composer2, 582, 0);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /* JADX INFO: renamed from: Legacy70PreviewCombineTemplate_hlbQeY0$SecondaryContentWithTertiaryContent */
    public static final void m2326x130ca615(SecondaryContentData secondaryContentData, TertiaryContentData tertiaryContentData, Composer composer, int i) {
        composer.startReplaceableGroup(1915399475);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1915399475, i, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate.SecondaryContentWithTertiaryContent (LegacyCombineTemplate.kt:73)");
        }
        if (secondaryContentData.getTextList() != null && tertiaryContentData.getTextList() != null) {
            LegacyCombineLayoutKt.GlanceCombineTexts(secondaryContentData.getTextList(), tertiaryContentData.getTextList(), composer, 72, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void Legacy70PreviewCombineTemplate_hlbQeY0$TertiaryContent(int i, TertiaryContentData tertiaryContentData, Composer composer, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(909996159);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(909996159, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.Legacy70PreviewCombineTemplate.TertiaryContent (LegacyCombineTemplate.kt:53)");
        }
        if (tertiaryContentData.getTextList() != null) {
            composer.startReplaceableGroup(516174567);
            LegacyCombineLayoutKt.GlanceCombineTexts(null, tertiaryContentData.getTextList(), composer, 64, 1);
            composer.endReplaceableGroup();
            composer2 = composer;
        } else if (tertiaryContentData.getFirstProgressBar() != null) {
            composer.startReplaceableGroup(516174689);
            composer2 = composer;
            LegacyCombineLayoutKt.m21868GlanceCombineProgressBarsRJlTeC8(false, tertiaryContentData.getFirstProgressBar(), tertiaryContentData.getSecondProgressBar(), 0, composer2, 582, 8);
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            if (tertiaryContentData.getStackedGraph() != null) {
                composer2.startReplaceableGroup(516174918);
                LegacyCombineLayoutKt.m21869GlanceCombineStackedGraphZURPRg8(tertiaryContentData.getStackedGraph(), i, composer2, 8);
                composer2.endReplaceableGroup();
            } else if (tertiaryContentData.getList() != null) {
                composer2.startReplaceableGroup(516175045);
                LegacyCombineLayoutKt.GlanceCombineList(false, tertiaryContentData.getList(), composer2, 70);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(516175122);
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0][0]]")
    /* JADX INFO: renamed from: LegacyCombineTemplate-vBhK2Fw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21872LegacyCombineTemplatevBhK2Fw(@NotNull final Function2<? super Composer, ? super Integer, Unit> primaryContent, @NotNull final Function2<? super Composer, ? super Integer, Unit> secondaryContent, int i, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, int i2, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        int iM21429getBottommnfRV0w;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i8;
        final int i9;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final int iM21432getEndPGIyAqw;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(primaryContent, "primaryContent");
        Intrinsics.checkNotNullParameter(secondaryContent, "secondaryContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-488636513);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(primaryContent) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i4 & 112) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(secondaryContent) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            if ((i5 & 4) == 0) {
                iM21429getBottommnfRV0w = i;
                int i10 = composerStartRestartGroup.changed(iM21429getBottommnfRV0w) ? 256 : 128;
                i6 |= i10;
            } else {
                iM21429getBottommnfRV0w = i;
            }
            i6 |= i10;
        } else {
            iM21429getBottommnfRV0w = i;
        }
        int i11 = i5 & 8;
        if (i11 == 0) {
            if ((i4 & 7168) == 0) {
                function22 = function2;
                i6 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
            }
            if ((i4 & 57344) != 0) {
                if ((i5 & 16) == 0) {
                    i7 = i2;
                    int i12 = composerStartRestartGroup.changed(i7) ? 16384 : 8192;
                    i6 |= i12;
                } else {
                    i7 = i2;
                }
                i6 |= i12;
            } else {
                i7 = i2;
            }
            if ((46811 & i6) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i4 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i5 & 4) != 0) {
                        iM21429getBottommnfRV0w = Alignment.INSTANCE.m21429getBottommnfRV0w();
                        i6 &= -897;
                    }
                    function23 = i11 == 0 ? null : function22;
                    if ((i5 & 16) == 0) {
                        i8 = i6 & (-57345);
                        i9 = iM21429getBottommnfRV0w;
                        function24 = function23;
                        iM21432getEndPGIyAqw = Alignment.INSTANCE.m21432getEndPGIyAqw();
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-488636513, i8, -1, "androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineTemplate (LegacyCombineTemplate.kt:154)");
                    }
                    int i13 = i8 << 3;
                    LegacyCombineLayoutKt.m21870Legacy70PreviewCombineLayoutKp2Snc(null, primaryContent, secondaryContent, i9, function24, iM21432getEndPGIyAqw, composerStartRestartGroup, (i13 & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (i13 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i5 & 4) != 0) {
                        i6 &= -897;
                    }
                    if ((i5 & 16) != 0) {
                        i6 &= -57345;
                    }
                    function23 = function22;
                }
                i8 = i6;
                i9 = iM21429getBottommnfRV0w;
                function24 = function23;
                iM21432getEndPGIyAqw = i7;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i132 = i8 << 3;
                LegacyCombineLayoutKt.m21870Legacy70PreviewCombineLayoutKp2Snc(null, primaryContent, secondaryContent, i9, function24, iM21432getEndPGIyAqw, composerStartRestartGroup, (i132 & 112) | 6 | (i132 & 896) | (i132 & 7168) | (57344 & i132) | (i132 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i9 = iM21429getBottommnfRV0w;
                function24 = function22;
                iM21432getEndPGIyAqw = i7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.legacy.LegacyCombineTemplateKt$LegacyCombineTemplate$1
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

                    public final void invoke(@Nullable Composer composer2, int i14) {
                        LegacyCombineTemplateKt.m21872LegacyCombineTemplatevBhK2Fw(primaryContent, secondaryContent, i9, function24, iM21432getEndPGIyAqw, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
                return;
            }
            return;
        }
        i6 |= 3072;
        function22 = function2;
        if ((i4 & 57344) != 0) {
        }
        if ((46811 & i6) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
                if ((i5 & 4) != 0) {
                }
                if (i11 == 0) {
                }
                if ((i5 & 16) == 0) {
                    i8 = i6;
                    i9 = iM21429getBottommnfRV0w;
                    function24 = function23;
                    iM21432getEndPGIyAqw = i7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1322 = i8 << 3;
                LegacyCombineLayoutKt.m21870Legacy70PreviewCombineLayoutKp2Snc(null, primaryContent, secondaryContent, i9, function24, iM21432getEndPGIyAqw, composerStartRestartGroup, (i1322 & 112) | 6 | (i1322 & 896) | (i1322 & 7168) | (57344 & i1322) | (i1322 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
