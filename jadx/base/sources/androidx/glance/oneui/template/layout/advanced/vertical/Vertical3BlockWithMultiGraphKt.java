package androidx.glance.oneui.template.layout.advanced.vertical;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.FuturePublicApi;
import androidx.glance.oneui.template.component.padding.Padding;
import androidx.glance.oneui.template.component.padding.PaddingVariable;
import androidx.glance.oneui.template.layout.elemental.full.FullLayoutKt;
import androidx.glance.oneui.template.layout.elemental.vertical.Vertical2to1to1Kt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Vertical3BlockWithMultiGraph", "", "padding", "Landroidx/glance/oneui/template/component/padding/Padding;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "top", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "middle", "bottom", "(Landroidx/glance/oneui/template/component/padding/Padding;Landroidx/glance/unit/ColorProvider;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class Vertical3BlockWithMultiGraphKt {
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0119  */
    @Composable
    @FuturePublicApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Vertical3BlockWithMultiGraph(@Nullable Padding padding, @Nullable ColorProvider colorProvider, @NotNull final Function2<? super Composer, ? super Integer, Unit> top, @NotNull final Function2<? super Composer, ? super Integer, Unit> middle, @NotNull final Function2<? super Composer, ? super Integer, Unit> bottom, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Padding padding2;
        ColorProvider colorProvider2;
        final Padding padding3;
        final ColorProvider colorProvider3;
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(middle, "middle");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Composer composerStartRestartGroup = composer.startRestartGroup(1182309202);
        if ((i & 14) == 0) {
            i4 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(padding)) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(top) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(middle) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i4 |= 24576;
        } else if ((57344 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(bottom) ? 16384 : 8192;
        }
        if (i5 == 2 && (46811 & i4) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            padding3 = padding;
            colorProvider3 = colorProvider;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    padding = Padding.INSTANCE.getNone();
                    i4 &= -15;
                }
                if (i5 != 0) {
                    ColorProvider colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    padding2 = padding;
                    colorProvider2 = colorProviderM22055ColorProvider8_81llA;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1182309202, i4, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph (Vertical3BlockWithMultiGraph.kt:29)");
                }
                Vertical2to1to1Kt.Vertical2to1to1(padding2, colorProvider2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1050342691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph.1
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

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i6) {
                        if ((i6 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1050342691, i6, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.<anonymous> (Vertical3BlockWithMultiGraph.kt:68)");
                        }
                        Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph$TopContent(top, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1754055900, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph.2
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

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i6) {
                        if ((i6 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1754055900, i6, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.<anonymous> (Vertical3BlockWithMultiGraph.kt:69)");
                        }
                        Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph$MiddleContent(middle, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -263487195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph.3
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

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i6) {
                        if ((i6 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-263487195, i6, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.<anonymous> (Vertical3BlockWithMultiGraph.kt:70)");
                        }
                        Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph$BottomContent(bottom, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (i4 & 14) | 28096, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                padding3 = padding2;
                colorProvider3 = colorProvider2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i4 &= -15;
                }
                if (i5 != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
            }
            padding2 = padding;
            colorProvider2 = colorProvider;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Vertical2to1to1Kt.Vertical2to1to1(padding2, colorProvider2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1050342691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph.1
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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i6) {
                    if ((i6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1050342691, i6, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.<anonymous> (Vertical3BlockWithMultiGraph.kt:68)");
                    }
                    Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph$TopContent(top, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1754055900, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph.2
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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i6) {
                    if ((i6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1754055900, i6, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.<anonymous> (Vertical3BlockWithMultiGraph.kt:69)");
                    }
                    Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph$MiddleContent(middle, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -263487195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph.3
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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i6) {
                    if ((i6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-263487195, i6, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.<anonymous> (Vertical3BlockWithMultiGraph.kt:70)");
                    }
                    Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph$BottomContent(bottom, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (i4 & 14) | 28096, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            padding3 = padding2;
            colorProvider3 = colorProvider2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph.4
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
                    Vertical3BlockWithMultiGraphKt.Vertical3BlockWithMultiGraph(padding3, colorProvider3, top, middle, bottom, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void Vertical3BlockWithMultiGraph$BottomContent(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(-582735460);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582735460, i, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.BottomContent (Vertical3BlockWithMultiGraph.kt:55)");
        }
        PaddingVariable.Companion companion = PaddingVariable.INSTANCE;
        FullLayoutKt.FullLayout(new Padding(companion.getStandard1(), (PaddingVariable) null, companion.getStandard1(), companion.getStandard1(), 2, (DefaultConstructorMarker) null), null, null, ComposableLambdaKt.composableLambda(composer, 366343635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt$Vertical3BlockWithMultiGraph$BottomContent$1
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

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(366343635, i2, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.BottomContent.<anonymous> (Vertical3BlockWithMultiGraph.kt:62)");
                }
                if (AbstractC1038a.m1196A(composer2, 0, function2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void Vertical3BlockWithMultiGraph$MiddleContent(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(825454342);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(825454342, i, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.MiddleContent (Vertical3BlockWithMultiGraph.kt:43)");
        }
        PaddingVariable.Companion companion = PaddingVariable.INSTANCE;
        FullLayoutKt.FullLayout(new Padding(companion.getStandard1(), companion.getStandard2(), companion.getStandard1(), companion.getStandard2()), null, null, ComposableLambdaKt.composableLambda(composer, 1774533437, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt$Vertical3BlockWithMultiGraph$MiddleContent$1
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

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1774533437, i2, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.MiddleContent.<anonymous> (Vertical3BlockWithMultiGraph.kt:51)");
                }
                if (AbstractC1038a.m1196A(composer2, 0, function2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void Vertical3BlockWithMultiGraph$TopContent(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(369285418);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(369285418, i, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.TopContent (Vertical3BlockWithMultiGraph.kt:31)");
        }
        PaddingVariable.Companion companion = PaddingVariable.INSTANCE;
        FullLayoutKt.FullLayout(new Padding(companion.getStandard1(), companion.getStandard1(), companion.getStandard1(), companion.getStandard2()), null, null, ComposableLambdaKt.composableLambda(composer, -2063839149, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraphKt$Vertical3BlockWithMultiGraph$TopContent$1
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

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2063839149, i2, -1, "androidx.glance.oneui.template.layout.advanced.vertical.Vertical3BlockWithMultiGraph.TopContent.<anonymous> (Vertical3BlockWithMultiGraph.kt:39)");
                }
                if (AbstractC1038a.m1196A(composer2, 0, function2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
