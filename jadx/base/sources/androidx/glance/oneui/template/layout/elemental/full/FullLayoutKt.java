package androidx.glance.oneui.template.layout.elemental.full;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.FuturePublicApi;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.template.component.padding.Padding;
import androidx.glance.oneui.template.component.padding.PaddingKt;
import androidx.glance.oneui.template.utils.SizeUtilsKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"FullLayout", "", "padding", "Landroidx/glance/oneui/template/component/padding/Padding;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "contentAlignment", "Landroidx/glance/layout/Alignment;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/glance/oneui/template/component/padding/Padding;Landroidx/glance/unit/ColorProvider;Landroidx/glance/layout/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class FullLayoutKt {
    /* JADX WARN: Removed duplicated region for block: B:66:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f9  */
    @Composable
    @FuturePublicApi
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullLayout(@Nullable final Padding padding, @Nullable ColorProvider colorProvider, @Nullable Alignment alignment, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final Alignment alignment2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-203853937);
        if ((i & 14) == 0) {
            i4 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(padding)) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 16;
        }
        if ((i & 896) == 0) {
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(alignment)) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if (i5 == 2 && (i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            alignment2 = alignment;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    padding = Padding.INSTANCE.getNone();
                    i4 &= -15;
                }
                if (i5 != 0) {
                    colorProvider = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if ((i2 & 4) != 0) {
                    alignment = Alignment.INSTANCE.getCenter();
                    i4 &= -897;
                }
                Alignment alignment3 = alignment;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-203853937, i4, -1, "androidx.glance.oneui.template.layout.elemental.full.FullLayout (FullLayout.kt:32)");
                }
                androidx.glance.oneui.template.layout.internal.FullLayoutKt.FullLayout(BackgroundKt.background(PaddingKt.padding(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), padding, composerStartRestartGroup, (i4 << 3) & 112), colorProvider), alignment3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 920748215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.elemental.full.FullLayoutKt.FullLayout.1
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
                            ComposerKt.traceEventStart(920748215, i6, -1, "androidx.glance.oneui.template.layout.elemental.full.FullLayout.<anonymous> (FullLayout.kt:37)");
                        }
                        ProvidedValue<DpSize> providedValueProvides = CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(SizeUtilsKt.m21968getLocalSizeWithoutPaddingeVKgIn8(padding, 0L, composer2, 0, 2)));
                        final Function2<Composer, Integer, Unit> function2 = content;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda(composer2, -515582601, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.elemental.full.FullLayoutKt.FullLayout.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(@Nullable Composer composer3, int i7) {
                                if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-515582601, i7, -1, "androidx.glance.oneui.template.layout.elemental.full.FullLayout.<anonymous>.<anonymous> (FullLayout.kt:38)");
                                }
                                if (AbstractC1038a.m1196A(composer3, 0, function2)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (Alignment.$stable << 3) | 384 | ((i4 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment2 = alignment3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i4 &= -15;
                }
                if (i5 != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if ((i2 & 4) != 0) {
                    i4 &= -897;
                }
                Alignment alignment32 = alignment;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                androidx.glance.oneui.template.layout.internal.FullLayoutKt.FullLayout(BackgroundKt.background(PaddingKt.padding(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), padding, composerStartRestartGroup, (i4 << 3) & 112), colorProvider), alignment32, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 920748215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.elemental.full.FullLayoutKt.FullLayout.1
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
                            ComposerKt.traceEventStart(920748215, i6, -1, "androidx.glance.oneui.template.layout.elemental.full.FullLayout.<anonymous> (FullLayout.kt:37)");
                        }
                        ProvidedValue<DpSize> providedValueProvides = CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(SizeUtilsKt.m21968getLocalSizeWithoutPaddingeVKgIn8(padding, 0L, composer2, 0, 2)));
                        final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda(composer2, -515582601, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.elemental.full.FullLayoutKt.FullLayout.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(@Nullable Composer composer3, int i7) {
                                if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-515582601, i7, -1, "androidx.glance.oneui.template.layout.elemental.full.FullLayout.<anonymous>.<anonymous> (FullLayout.kt:38)");
                                }
                                if (AbstractC1038a.m1196A(composer3, 0, function2)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (Alignment.$stable << 3) | 384 | ((i4 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                alignment2 = alignment32;
            }
        }
        final Padding padding2 = padding;
        final ColorProvider colorProvider2 = colorProvider;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.elemental.full.FullLayoutKt.FullLayout.2
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
                    FullLayoutKt.FullLayout(padding2, colorProvider2, alignment2, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
