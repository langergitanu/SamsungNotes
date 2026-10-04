package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"DefaultRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "TextSelectionBackgroundOpacity", "", "MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class MaterialThemeKt {

    @NotNull
    private static final RippleAlpha DefaultRippleAlpha = new RippleAlpha(0.16f, 0.12f, 0.08f, 0.12f);
    public static final float TextSelectionBackgroundOpacity = 0.4f;

    /* JADX WARN: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a6  */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(@Nullable ColorScheme colorScheme, @Nullable Shapes shapes, @Nullable Typography typography, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final ColorScheme colorScheme2;
        final int i4;
        Shapes shapes2;
        Typography typography2;
        Object objRememberedValue;
        ColorScheme colorScheme3;
        final Shapes shapes3;
        final Typography typography3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2127166334);
        if ((i & 14) == 0) {
            if ((i2 & 1) == 0) {
                colorScheme2 = colorScheme;
                int i5 = composerStartRestartGroup.changed(colorScheme2) ? 4 : 2;
                i4 = i5 | i;
            } else {
                colorScheme2 = colorScheme;
            }
            i4 = i5 | i;
        } else {
            colorScheme2 = colorScheme;
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shapes2 = shapes;
                int i6 = composerStartRestartGroup.changed(shapes2) ? 32 : 16;
                i4 |= i6;
            } else {
                shapes2 = shapes;
            }
            i4 |= i6;
        } else {
            shapes2 = shapes;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                typography2 = typography;
                int i7 = composerStartRestartGroup.changed(typography2) ? 256 : 128;
                i4 |= i7;
            } else {
                typography2 = typography;
            }
            i4 |= i7;
        } else {
            typography2 = typography;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
        }
        if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            shapes3 = shapes2;
            typography3 = typography2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    i4 &= -15;
                }
                if ((i2 & 2) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if ((i2 & 4) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                ColorScheme colorScheme4 = colorScheme2;
                final Typography typography4 = typography2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2127166334, i4, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:57)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue != Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = colorScheme4.m17037copyG1PFcw((SegmentTree.MAX_VALUE & 1) != 0 ? colorScheme4.m17057getPrimary0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 2) != 0 ? colorScheme4.m17047getOnPrimary0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 4) != 0 ? colorScheme4.m17058getPrimaryContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 8) != 0 ? colorScheme4.m17048getOnPrimaryContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 16) != 0 ? colorScheme4.m17042getInversePrimary0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 32) != 0 ? colorScheme4.m17060getSecondary0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 64) != 0 ? colorScheme4.m17049getOnSecondary0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 128) != 0 ? colorScheme4.m17061getSecondaryContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 256) != 0 ? colorScheme4.m17050getOnSecondaryContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 512) != 0 ? colorScheme4.m17065getTertiary0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 1024) != 0 ? colorScheme4.m17053getOnTertiary0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 2048) != 0 ? colorScheme4.m17066getTertiaryContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 4096) != 0 ? colorScheme4.m17054getOnTertiaryContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 8192) != 0 ? colorScheme4.m17038getBackground0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 16384) != 0 ? colorScheme4.m17044getOnBackground0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 32768) != 0 ? colorScheme4.m17062getSurface0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 65536) != 0 ? colorScheme4.m17051getOnSurface0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 131072) != 0 ? colorScheme4.m17064getSurfaceVariant0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 262144) != 0 ? colorScheme4.m17052getOnSurfaceVariant0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 524288) != 0 ? colorScheme4.m17063getSurfaceTint0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 1048576) != 0 ? colorScheme4.m17043getInverseSurface0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 2097152) != 0 ? colorScheme4.m17041getInverseOnSurface0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 4194304) != 0 ? colorScheme4.m17039getError0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 8388608) != 0 ? colorScheme4.m17045getOnError0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 16777216) != 0 ? colorScheme4.m17040getErrorContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 33554432) != 0 ? colorScheme4.m17046getOnErrorContainer0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 67108864) != 0 ? colorScheme4.m17055getOutline0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 134217728) != 0 ? colorScheme4.m17056getOutlineVariant0d7_KjU() : 0L, (SegmentTree.MAX_VALUE & 268435456) != 0 ? colorScheme4.m17059getScrim0d7_KjU() : 0L);
                    colorScheme3 = colorScheme4;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    colorScheme3 = colorScheme4;
                }
                composerStartRestartGroup.endReplaceableGroup();
                ColorScheme colorScheme5 = (ColorScheme) objRememberedValue;
                ColorSchemeKt.updateColorSchemeFrom(colorScheme5, colorScheme3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme5), IndicationKt.getLocalIndication().provides(RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme5, composerStartRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography4)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1066563262, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.1
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
                            ComposerKt.traceEventStart(-1066563262, i8, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
                        }
                        TextKt.ProvideTextStyle(typography4.getBodyLarge(), content, composer2, (i4 >> 6) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shapes3 = shapes2;
                typography3 = typography4;
                colorScheme2 = colorScheme3;
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
                ColorScheme colorScheme42 = colorScheme2;
                final Typography typography42 = typography2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue != Composer.INSTANCE.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                ColorScheme colorScheme52 = (ColorScheme) objRememberedValue;
                ColorSchemeKt.updateColorSchemeFrom(colorScheme52, colorScheme3);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme52), IndicationKt.getLocalIndication().provides(RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme52, composerStartRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography42)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1066563262, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.1
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
                            ComposerKt.traceEventStart(-1066563262, i8, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
                        }
                        TextKt.ProvideTextStyle(typography42.getBodyLarge(), content, composer2, (i4 >> 6) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                }
                shapes3 = shapes2;
                typography3 = typography42;
                colorScheme2 = colorScheme3;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.2
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
                MaterialThemeKt.MaterialTheme(colorScheme2, shapes3, typography3, content, composer2, i | 1, i2);
            }
        });
    }

    @Composable
    @NotNull
    public static final TextSelectionColors rememberTextSelectionColors(@NotNull ColorScheme colorScheme, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        composer.startReplaceableGroup(1866455512);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:132)");
        }
        long jM17057getPrimary0d7_KjU = colorScheme.m17057getPrimary0d7_KjU();
        Color colorM18515boximpl = Color.m18515boximpl(jM17057getPrimary0d7_KjU);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(colorM18515boximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(jM17057getPrimary0d7_KjU, Color.m18524copywmQWz5c$default(jM17057getPrimary0d7_KjU, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors2;
    }
}
