package androidx.compose.material;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class MaterialThemeKt {
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0194  */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(@Nullable Colors colors, @Nullable Typography typography, @Nullable Shapes shapes, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final Colors colors2;
        final int i4;
        final Typography typography2;
        Shapes shapes2;
        Object objRememberedValue;
        final Typography typography3;
        final Shapes shapes3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-891417079);
        if ((i & 14) == 0) {
            if ((i2 & 1) == 0) {
                colors2 = colors;
                int i5 = composerStartRestartGroup.changed(colors2) ? 4 : 2;
                i4 = i5 | i;
            } else {
                colors2 = colors;
            }
            i4 = i5 | i;
        } else {
            colors2 = colors;
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                typography2 = typography;
                int i6 = composerStartRestartGroup.changed(typography2) ? 32 : 16;
                i4 |= i6;
            } else {
                typography2 = typography;
            }
            i4 |= i6;
        } else {
            typography2 = typography;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                shapes2 = shapes;
                int i7 = composerStartRestartGroup.changed(shapes2) ? 256 : 128;
                i4 |= i7;
            } else {
                shapes2 = shapes;
            }
            i4 |= i7;
        } else {
            shapes2 = shapes;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
        }
        if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            typography3 = typography2;
            shapes3 = shapes2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colors2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6);
                    i4 &= -15;
                }
                if ((i2 & 2) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                Colors colors3 = colors2;
                Shapes shapes4 = shapes2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891417079, i4, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:58)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = colors3.m16668copypvPzIIM((8191 & 1) != 0 ? colors3.m16676getPrimary0d7_KjU() : 0L, (8191 & 2) != 0 ? colors3.m16677getPrimaryVariant0d7_KjU() : 0L, (8191 & 4) != 0 ? colors3.m16678getSecondary0d7_KjU() : 0L, (8191 & 8) != 0 ? colors3.m16679getSecondaryVariant0d7_KjU() : 0L, (8191 & 16) != 0 ? colors3.m16669getBackground0d7_KjU() : 0L, (8191 & 32) != 0 ? colors3.m16680getSurface0d7_KjU() : 0L, (8191 & 64) != 0 ? colors3.m16670getError0d7_KjU() : 0L, (8191 & 128) != 0 ? colors3.m16673getOnPrimary0d7_KjU() : 0L, (8191 & 256) != 0 ? colors3.m16674getOnSecondary0d7_KjU() : 0L, (8191 & 512) != 0 ? colors3.m16671getOnBackground0d7_KjU() : 0L, (8191 & 1024) != 0 ? colors3.m16675getOnSurface0d7_KjU() : 0L, (8191 & 2048) != 0 ? colors3.m16672getOnError0d7_KjU() : 0L, (8191 & 4096) != 0 ? colors3.isLight() : false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Colors colors4 = (Colors) objRememberedValue;
                ColorsKt.updateColorsFrom(colors4, colors3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorsKt.getLocalColors().provides(colors4), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes4), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(colors4, composerStartRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1740102967, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt.MaterialTheme.1
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
                    public final void invoke(@Nullable Composer composer2, int i8) {
                        if ((i8 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1740102967, i8, -1, "androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
                        }
                        TextStyle body1 = typography2.getBody1();
                        final Function2<Composer, Integer, Unit> function2 = content;
                        final int i9 = i4;
                        TextKt.ProvideTextStyle(body1, ComposableLambdaKt.composableLambda(composer2, 181426554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt.MaterialTheme.1.1
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
                            public final void invoke(@Nullable Composer composer3, int i10) {
                                if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(181426554, i10, -1, "androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:80)");
                                }
                                MaterialTheme_androidKt.PlatformMaterialTheme(function2, composer3, (i9 >> 9) & 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                typography3 = typography2;
                shapes3 = shapes4;
                colors2 = colors3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i4 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if ((i2 & 4) != 0) {
                    i4 &= -897;
                }
                Colors colors32 = colors2;
                Shapes shapes42 = shapes2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Colors colors42 = (Colors) objRememberedValue;
                ColorsKt.updateColorsFrom(colors42, colors32);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorsKt.getLocalColors().provides(colors42), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes42), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(colors42, composerStartRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1740102967, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt.MaterialTheme.1
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
                    public final void invoke(@Nullable Composer composer2, int i8) {
                        if ((i8 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1740102967, i8, -1, "androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
                        }
                        TextStyle body1 = typography2.getBody1();
                        final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                        final int i9 = i4;
                        TextKt.ProvideTextStyle(body1, ComposableLambdaKt.composableLambda(composer2, 181426554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt.MaterialTheme.1.1
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
                            public final void invoke(@Nullable Composer composer3, int i10) {
                                if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(181426554, i10, -1, "androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:80)");
                                }
                                MaterialTheme_androidKt.PlatformMaterialTheme(function2, composer3, (i9 >> 9) & 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                }
                typography3 = typography2;
                shapes3 = shapes42;
                colors2 = colors32;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt.MaterialTheme.2
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

            public final void invoke(@Nullable Composer composer2, int i8) {
                MaterialThemeKt.MaterialTheme(colors2, typography3, shapes3, content, composer2, i | 1, i2);
            }
        });
    }
}
