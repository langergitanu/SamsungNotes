package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.JG\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J3\u00103\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J3\u00106\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00105R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001a\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, m13886d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedBorderOpacity", "", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "buttonColors", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "elevation", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "pressedElevation", "disabledElevation", "elevation-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "outlinedButtonColors", "outlinedButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "textButtonColors-RGew2ao", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;

    @NotNull
    private static final PaddingValues ContentPadding;

    @NotNull
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize;

    @NotNull
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(16);
        ButtonHorizontalPadding = fM20968constructorimpl;
        float f = 8;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(f);
        ButtonVerticalPadding = fM20968constructorimpl2;
        PaddingValues paddingValuesM15850PaddingValuesa9UjIt4 = PaddingKt.m15850PaddingValuesa9UjIt4(fM20968constructorimpl, fM20968constructorimpl2, fM20968constructorimpl, fM20968constructorimpl2);
        ContentPadding = paddingValuesM15850PaddingValuesa9UjIt4;
        MinWidth = C2256Dp.m20968constructorimpl(64);
        MinHeight = C2256Dp.m20968constructorimpl(36);
        IconSize = C2256Dp.m20968constructorimpl(18);
        IconSpacing = C2256Dp.m20968constructorimpl(f);
        OutlinedBorderSize = C2256Dp.m20968constructorimpl(1);
        float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(f);
        TextButtonHorizontalPadding = fM20968constructorimpl3;
        TextButtonContentPadding = PaddingKt.m15850PaddingValuesa9UjIt4(fM20968constructorimpl3, paddingValuesM15850PaddingValuesa9UjIt4.getTop(), fM20968constructorimpl3, paddingValuesM15850PaddingValuesa9UjIt4.getBottom());
    }

    private ButtonDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m16626buttonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        long jM18570compositeOverOWjLjI;
        composer.startReplaceableGroup(1870371134);
        long jM16676getPrimary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j;
        long jM16694contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m16694contentColorForek8zF_U(jM16676getPrimary0d7_KjU, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(materialTheme.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            jM18570compositeOverOWjLjI = j3;
        }
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:402)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM16676getPrimary0d7_KjU, jM16694contentColorForek8zF_U, jM18570compositeOverOWjLjI, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m16627elevationR_JCAzs(float f, float f4, float f5, float f6, float f7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-737170518);
        if ((i2 & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(2);
        }
        float f8 = f;
        if ((i2 & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(8);
        }
        float f9 = f4;
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(0);
        }
        float f10 = f5;
        float fM20968constructorimpl = (i2 & 8) != 0 ? C2256Dp.m20968constructorimpl(4) : f6;
        float fM20968constructorimpl2 = (i2 & 16) != 0 ? C2256Dp.m20968constructorimpl(4) : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:368)");
        }
        Object[] objArr = {C2256Dp.m20966boximpl(f8), C2256Dp.m20966boximpl(f9), C2256Dp.m20966boximpl(f10), C2256Dp.m20966boximpl(fM20968constructorimpl), C2256Dp.m20966boximpl(fM20968constructorimpl2)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i4 = 0; i4 < 5; i4++) {
            zChanged |= composer.changed(objArr[i4]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            DefaultButtonElevation defaultButtonElevation = new DefaultButtonElevation(f8, f9, f10, fM20968constructorimpl, fM20968constructorimpl2, null);
            composer.updateRememberedValue(defaultButtonElevation);
            objRememberedValue = defaultButtonElevation;
        }
        composer.endReplaceableGroup();
        DefaultButtonElevation defaultButtonElevation2 = (DefaultButtonElevation) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonElevation2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    @Composable
    /* JADX INFO: renamed from: elevation-yajeYGU, reason: not valid java name */
    public final /* synthetic */ ButtonElevation m16628elevationyajeYGU(float f, float f4, float f5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1428576874);
        if ((i2 & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(2);
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(8);
        }
        float f7 = f4;
        if ((i2 & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(0);
        }
        float f8 = f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428576874, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:342)");
        }
        float f9 = 4;
        ButtonElevation buttonElevationM16627elevationR_JCAzs = m16627elevationR_JCAzs(f6, f7, f8, C2256Dp.m20968constructorimpl(f9), C2256Dp.m20968constructorimpl(f9), composer, (i & 14) | 27648 | (i & 112) | (i & 896) | ((i << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevationM16627elevationR_JCAzs;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m16629getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m16630getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m16631getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m16632getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    @JvmName(name = "getOutlinedBorder")
    @NotNull
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-2091313033);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2091313033, i, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:473)");
        }
        BorderStroke borderStrokeM15436BorderStrokecXLIe8U = BorderStrokeKt.m15436BorderStrokecXLIe8U(OutlinedBorderSize, Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStrokeM15436BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m16633getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    @NotNull
    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m16634outlinedButtonColorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2124406093);
        long jM16680getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j;
        long jM16676getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124406093, i, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:425)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM16680getSurface0d7_KjU, jM16676getPrimary0d7_KjU, jM16680getSurface0d7_KjU, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m16635textButtonColorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(182742216);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long jM16676getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:446)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM18560getTransparent0d7_KjU, jM16676getPrimary0d7_KjU, jM18560getTransparent0d7_KjU, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }
}
