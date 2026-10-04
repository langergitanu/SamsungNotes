package androidx.glance.oneui.template.layout.glance.combine;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.percent.PaddingModifiersKt;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.ImageButtonData;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.PrimaryContentData;
import androidx.glance.oneui.template.SecondaryContentData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.component.glance.ImageButtonKt;
import androidx.glance.oneui.template.component.glance.ImageKt;
import androidx.glance.oneui.template.component.glance.ProgressIndicatorKt;
import androidx.glance.oneui.template.utils.Debug;
import androidx.glance.text.TextAlign;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m13886d2 = {"TinyLayout", "", "modifier", "Landroidx/glance/GlanceModifier;", "primaryData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryData", "Landroidx/glance/oneui/template/SecondaryContentData;", "primaryContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TinyPrimaryButtonContent", "(Landroidx/glance/GlanceModifier;Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TinyLayoutKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.glance.GlanceComposable]]")
    public static final void TinyLayout(@NotNull final GlanceModifier modifier, @Nullable final PrimaryContentData primaryContentData, @Nullable final SecondaryContentData secondaryContentData, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-186789131);
        final Function2<? super Composer, ? super Integer, Unit> function22 = (i2 & 8) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-186789131, i, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyLayout (TinyLayout.kt:34)");
        }
        Debug.INSTANCE.debugBox(modifier, Alignment.INSTANCE.getCenter(), "Tiny1", false, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1854830892, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt.TinyLayout.1
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

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1854830892, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyLayout.<anonymous> (TinyLayout.kt:36)");
                }
                if (function22 != null) {
                    composer2.startReplaceableGroup(476953283);
                    AbstractC1038a.m1198C(composer2, 0, function22);
                } else if (primaryContentData != null) {
                    composer2.startReplaceableGroup(476953354);
                    TinyLayoutKt.TinyPrimaryButtonContent(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), primaryContentData, secondaryContentData, composer2, Units.MASTER_DPI, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(476953564);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i & 14) | 221568 | (Alignment.$stable << 3), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt.TinyLayout.2
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
                    TinyLayoutKt.TinyLayout(modifier, primaryContentData, secondaryContentData, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void TinyPrimaryButtonContent(final GlanceModifier glanceModifier, final PrimaryContentData primaryContentData, SecondaryContentData secondaryContentData, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2124866076);
        if ((i2 & 4) != 0) {
            secondaryContentData = null;
        }
        final SecondaryContentData secondaryContentData2 = secondaryContentData;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2124866076, i, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent (TinyLayout.kt:53)");
        }
        if (secondaryContentData2 != null) {
            composerStartRestartGroup.startReplaceableGroup(-1380872216);
            TinyPrimaryButtonContent$TinyButtonContent(glanceModifier, primaryContentData, secondaryContentData2, composerStartRestartGroup, (i & 14) | Units.MASTER_DPI);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (primaryContentData.getImage() != null) {
            composerStartRestartGroup.startReplaceableGroup(-1380872020);
            if (primaryContentData.getImage() instanceof ImageButtonData) {
                composerStartRestartGroup.startReplaceableGroup(-1380871968);
                GlanceModifier glanceModifierM21357paddingLwRUR8o = PaddingModifiersKt.m21357paddingLwRUR8o(glanceModifier, 0.15f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composerStartRestartGroup, (i & 14) | 48, 0);
                composerStartRestartGroup.startReplaceableGroup(-1380871787);
                ImageButtonData imageButtonData = (ImageButtonData) primaryContentData.getImage();
                if (imageButtonData.getBackgroundColor() == null) {
                    imageButtonData.setBackgroundColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface());
                }
                composerStartRestartGroup.endReplaceableGroup();
                ImageButtonKt.GlanceImageButton(imageButtonData, glanceModifierM21357paddingLwRUR8o, composerStartRestartGroup, 8, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1380871568);
                ImageKt.m21746GlanceImagecuCYCYk(primaryContentData.getImage(), PaddingModifiersKt.m21357paddingLwRUR8o(glanceModifier, 0.15f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), composerStartRestartGroup, (i & 14) | 48, 0), 0, composerStartRestartGroup, 8, 4);
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else if (primaryContentData.getProgressIndicator() != null) {
            composerStartRestartGroup.startReplaceableGroup(-1380871334);
            ProgressIndicatorKt.GlanceCircularProgressIndicator(glanceModifier, primaryContentData.getProgressIndicator(), 0, null, composerStartRestartGroup, (i & 14) | 64, 12);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1380871228);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt.TinyPrimaryButtonContent.2
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
                    TinyLayoutKt.TinyPrimaryButtonContent(glanceModifier, primaryContentData, secondaryContentData2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void TinyPrimaryButtonContent$TinyButtonContent(GlanceModifier glanceModifier, final PrimaryContentData primaryContentData, SecondaryContentData secondaryContentData, Composer composer, int i) {
        List<TypedTextData> listEmptyList;
        composer.startReplaceableGroup(-1969805050);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1969805050, i, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent.TinyButtonContent (TinyLayout.kt:60)");
        }
        TypedTextListData textList = secondaryContentData.getTextList();
        if (textList == null || (listEmptyList = textList.getItems()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        int size = listEmptyList.size();
        final float f = size != 0 ? size != 1 ? 0.25f : 0.42f : 0.75f;
        if (size == 0) {
            composer.startReplaceableGroup(1001704801);
            if (primaryContentData.getImage() != null) {
                Debug.INSTANCE.debugBox(glanceModifier, Alignment.INSTANCE.getCenter(), "Tiny2", false, ComposableLambdaKt.composableLambda(composer, 1921611650, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt$TinyPrimaryButtonContent$TinyButtonContent$1$1
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
                    public final void invoke(@Nullable Composer composer2, int i2) {
                        if ((i2 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1921611650, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent.TinyButtonContent.<anonymous>.<anonymous> (TinyLayout.kt:82)");
                        }
                        ImageKt.m21746GlanceImagecuCYCYk(primaryContentData.getImage(), PaddingModifiersKt.m21357paddingLwRUR8o(androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, f, 0, 0.0f, composer2, 6, 6), f / 5, 0, composer2, 0, 2), 0, composer2, 8, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, 221568 | (i & 14) | (Alignment.$stable << 3), 8);
            }
            composer.endReplaceableGroup();
        } else if (size == 1) {
            composer.startReplaceableGroup(1001705201);
            final TypedTextData typedTextData = listEmptyList.get(0);
            Alignment.Companion companion = Alignment.INSTANCE;
            ColumnKt.m21455ColumnK4GKKTE(glanceModifier, companion.m21431getCenterVerticallymnfRV0w(), companion.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, 529994572, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt$TinyPrimaryButtonContent$TinyButtonContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i2) {
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(529994572, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent.TinyButtonContent.<anonymous> (TinyLayout.kt:95)");
                    }
                    ImageData image = primaryContentData.getImage();
                    composer2.startReplaceableGroup(-116119764);
                    if (image != null) {
                        float f4 = f;
                        PrimaryContentData primaryContentData2 = primaryContentData;
                        ImageKt.m21746GlanceImagecuCYCYk(primaryContentData2.getImage(), androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, f4, 0, 0.0f, composer2, 6, 6), 0, composer2, 8, 4);
                        Unit unit = Unit.INSTANCE;
                    }
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(-116119624);
                    if (!TextType.m21684equalsimpl0(typedTextData.getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow())) {
                        SpacerKt.Spacer(androidx.glance.appwidget.percent.SizeModifiersKt.height(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE), 0.06f, composer2, 48), composer2, 0, 0);
                    }
                    composer2.endReplaceableGroup();
                    GlanceModifier glanceModifierM21356padding6PoWaU8 = PaddingModifiersKt.m21356padding6PoWaU8(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE)), 0.1f, 0.0f, 0.0f, 0.0f, composer2, 432, 12);
                    int iM21430getCenterHorizontallyPGIyAqw = Alignment.INSTANCE.m21430getCenterHorizontallyPGIyAqw();
                    final TypedTextData typedTextData2 = typedTextData;
                    RowKt.m21502RowlMAjyxE(glanceModifierM21356padding6PoWaU8, iM21430getCenterHorizontallyPGIyAqw, 0, ComposableLambdaKt.composableLambda(composer2, 602961256, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt$TinyPrimaryButtonContent$TinyButtonContent$2.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i4) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(602961256, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent.TinyButtonContent.<anonymous>.<anonymous> (TinyLayout.kt:108)");
                            }
                            GlanceModifier glanceModifierWrapContentHeight = SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(GlanceModifier.INSTANCE));
                            int iM21571getTinyrx25Pp4 = AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4();
                            TypedTextData typedTextData3 = typedTextData2;
                            typedTextData3.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22007getCenterROrN78o());
                            Unit unit2 = Unit.INSTANCE;
                            CombineLayoutKt.m21861CombineText57gRyVA(glanceModifierWrapContentHeight, iM21571getTinyrx25Pp4, typedTextData3, typedTextData2.getTextType(), 0, null, 0.0f, 0.0f, composer3, 0, 240);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, (i & 14) | 3072, 0);
            composer.endReplaceableGroup();
        } else if (size != 2) {
            composer.startReplaceableGroup(1001708264);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1001706481);
            final TypedTextData typedTextData2 = listEmptyList.get(0);
            final TypedTextData typedTextData3 = listEmptyList.get(1);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            ColumnKt.m21455ColumnK4GKKTE(glanceModifier, companion2.m21431getCenterVerticallymnfRV0w(), companion2.m21430getCenterHorizontallyPGIyAqw(), ComposableLambdaKt.composableLambda(composer, -1275508723, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt$TinyPrimaryButtonContent$TinyButtonContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                @Composable
                public final void invoke(@NotNull ColumnScope Column, @Nullable Composer composer2, int i2) {
                    Intrinsics.checkNotNullParameter(Column, "$this$Column");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1275508723, i2, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent.TinyButtonContent.<anonymous> (TinyLayout.kt:124)");
                    }
                    ImageData image = primaryContentData.getImage();
                    composer2.startReplaceableGroup(-116118443);
                    if (image != null) {
                        float f4 = f;
                        ImageKt.m21746GlanceImagecuCYCYk(primaryContentData.getImage(), androidx.glance.appwidget.percent.SizeModifiersKt.m21387size9UTdIk(GlanceModifier.INSTANCE, f4, 0, 0.0f, composer2, 6, 6), 0, composer2, 8, 4);
                        Unit unit = Unit.INSTANCE;
                    }
                    composer2.endReplaceableGroup();
                    GlanceModifier.Companion companion3 = GlanceModifier.INSTANCE;
                    GlanceModifier glanceModifierM21356padding6PoWaU8 = PaddingModifiersKt.m21356padding6PoWaU8(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion3)), 0.08f, 0.0f, 0.0f, 0.0f, composer2, 432, 12);
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    int iM21430getCenterHorizontallyPGIyAqw = companion4.m21430getCenterHorizontallyPGIyAqw();
                    final TypedTextData typedTextData4 = typedTextData2;
                    RowKt.m21502RowlMAjyxE(glanceModifierM21356padding6PoWaU8, iM21430getCenterHorizontallyPGIyAqw, 0, ComposableLambdaKt.composableLambda(composer2, -1202542039, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt$TinyPrimaryButtonContent$TinyButtonContent$3.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i4) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1202542039, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent.TinyButtonContent.<anonymous>.<anonymous> (TinyLayout.kt:134)");
                            }
                            int iM21571getTinyrx25Pp4 = AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4();
                            TypedTextData typedTextData5 = typedTextData4;
                            typedTextData5.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22007getCenterROrN78o());
                            Unit unit2 = Unit.INSTANCE;
                            CombineLayoutKt.m21861CombineText57gRyVA(null, iM21571getTinyrx25Pp4, typedTextData5, typedTextData4.getTextType(), 0, null, 0.0f, 0.0f, composer3, 0, 241);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 4);
                    GlanceModifier glanceModifierM21356padding6PoWaU82 = PaddingModifiersKt.m21356padding6PoWaU8(SizeModifiersKt.wrapContentHeight(SizeModifiersKt.fillMaxWidth(companion3)), TextType.m21684equalsimpl0(typedTextData3.getTextType(), TextType.INSTANCE.m21693getLabelgxbDmow()) ? 0.2f : 0.08f, 0.0f, 0.0f, 0.0f, composer2, 384, 12);
                    int iM21430getCenterHorizontallyPGIyAqw2 = companion4.m21430getCenterHorizontallyPGIyAqw();
                    final TypedTextData typedTextData5 = typedTextData3;
                    RowKt.m21502RowlMAjyxE(glanceModifierM21356padding6PoWaU82, iM21430getCenterHorizontallyPGIyAqw2, 0, ComposableLambdaKt.composableLambda(composer2, 1763269074, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.TinyLayoutKt$TinyPrimaryButtonContent$TinyButtonContent$3.3
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                        @Composable
                        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer3, int i4) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1763269074, i4, -1, "androidx.glance.oneui.template.layout.glance.combine.TinyPrimaryButtonContent.TinyButtonContent.<anonymous>.<anonymous> (TinyLayout.kt:150)");
                            }
                            int iM21571getTinyrx25Pp4 = AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4();
                            TypedTextData typedTextData6 = typedTextData5;
                            typedTextData6.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22007getCenterROrN78o());
                            Unit unit2 = Unit.INSTANCE;
                            CombineLayoutKt.m21861CombineText57gRyVA(null, iM21571getTinyrx25Pp4, typedTextData6, typedTextData5.getTextType(), 0, null, 0.0f, 0.0f, composer3, 0, 241);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer, (i & 14) | 3072, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
