package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102JG\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J=\u0010<\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u00102JG\u0010>\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010;J=\u0010@\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u00102JG\u0010B\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010;J=\u0010D\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u00102J=\u0010F\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u00102R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0019\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0011\u0010&\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0011\u0010(\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b)\u0010\u001d\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, m13886d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ButtonVerticalPadding", "ButtonWithIconContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getButtonWithIconContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconHorizontalStartPadding", "ContentPadding", "getContentPadding", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledTonalShape", "getFilledTonalShape", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedShape", "getOutlinedShape", VMetaDataKey.META_KEY_SHAPE, "getShape", "textShape", "getTextShape", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "textButtonColors", "textButtonColors-ro_MJ88", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;

    @NotNull
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconHorizontalStartPadding;

    @NotNull
    private static final PaddingValues ContentPadding;

    @NotNull
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;

    @NotNull
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(24);
        ButtonHorizontalPadding = fM20968constructorimpl;
        float f = 8;
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(f);
        ButtonVerticalPadding = fM20968constructorimpl2;
        PaddingValues paddingValuesM15850PaddingValuesa9UjIt4 = PaddingKt.m15850PaddingValuesa9UjIt4(fM20968constructorimpl, fM20968constructorimpl2, fM20968constructorimpl, fM20968constructorimpl2);
        ContentPadding = paddingValuesM15850PaddingValuesa9UjIt4;
        float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(16);
        ButtonWithIconHorizontalStartPadding = fM20968constructorimpl3;
        ButtonWithIconContentPadding = PaddingKt.m15850PaddingValuesa9UjIt4(fM20968constructorimpl3, fM20968constructorimpl2, fM20968constructorimpl, fM20968constructorimpl2);
        float fM20968constructorimpl4 = C2256Dp.m20968constructorimpl(12);
        TextButtonHorizontalPadding = fM20968constructorimpl4;
        TextButtonContentPadding = PaddingKt.m15850PaddingValuesa9UjIt4(fM20968constructorimpl4, paddingValuesM15850PaddingValuesa9UjIt4.getTop(), fM20968constructorimpl4, paddingValuesM15850PaddingValuesa9UjIt4.getBottom());
        MinWidth = C2256Dp.m20968constructorimpl(58);
        MinHeight = C2256Dp.m20968constructorimpl(40);
        IconSize = FilledButtonTokens.INSTANCE.m17667getIconSizeD9Ej5fM();
        IconSpacing = C2256Dp.m20968constructorimpl(f);
    }

    private ButtonDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m17006buttonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-339300779);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, i, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:547)");
        }
        ButtonColors buttonColors = new ButtonColors(color, color2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: buttonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m17007buttonElevationR_JCAzs(float f, float f4, float f5, float f6, float f7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1827791191);
        if ((i2 & 1) != 0) {
            f = FilledButtonTokens.INSTANCE.m17662getContainerElevationD9Ej5fM();
        }
        float f8 = f;
        if ((i2 & 2) != 0) {
            f4 = FilledButtonTokens.INSTANCE.m17668getPressedContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 4) != 0) {
            f5 = FilledButtonTokens.INSTANCE.m17665getFocusContainerElevationD9Ej5fM();
        }
        float f10 = f5;
        if ((i2 & 8) != 0) {
            f6 = FilledButtonTokens.INSTANCE.m17666getHoverContainerElevationD9Ej5fM();
        }
        float f11 = f6;
        if ((i2 & 16) != 0) {
            f7 = FilledButtonTokens.INSTANCE.m17664getDisabledContainerElevationD9Ej5fM();
        }
        float f12 = f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, i, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:674)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f8, f9, f10, f11, f12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m17008elevatedButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1507908383);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507908383, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:572)");
        }
        ButtonColors buttonColors = new ButtonColors(color, color2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m17009elevatedButtonElevationR_JCAzs(float f, float f4, float f5, float f6, float f7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1065482445);
        if ((i2 & 1) != 0) {
            f = ElevatedButtonTokens.INSTANCE.m17578getContainerElevationD9Ej5fM();
        }
        float f8 = f;
        if ((i2 & 2) != 0) {
            f4 = ElevatedButtonTokens.INSTANCE.m17584getPressedContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 4) != 0) {
            f5 = ElevatedButtonTokens.INSTANCE.m17581getFocusContainerElevationD9Ej5fM();
        }
        float f10 = f5;
        if ((i2 & 8) != 0) {
            f6 = ElevatedButtonTokens.INSTANCE.m17582getHoverContainerElevationD9Ej5fM();
        }
        float f11 = f6;
        if ((i2 & 16) != 0) {
            f7 = ElevatedButtonTokens.INSTANCE.m17580getDisabledContainerElevationD9Ej5fM();
        }
        float f12 = f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1065482445, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:700)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f8, f9, f10, f11, f12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filledTonalButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m17010filledTonalButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1670757653);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670757653, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:598)");
        }
        ButtonColors buttonColors = new ButtonColors(color, color2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filledTonalButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m17011filledTonalButtonElevationR_JCAzs(float f, float f4, float f5, float f6, float f7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(5982871);
        if ((i2 & 1) != 0) {
            f = FilledTonalButtonTokens.INSTANCE.m17685getContainerElevationD9Ej5fM();
        }
        float f8 = f;
        if ((i2 & 2) != 0) {
            f4 = FilledTonalButtonTokens.INSTANCE.m17691getPressedContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 4) != 0) {
            f5 = FilledTonalButtonTokens.INSTANCE.m17688getFocusContainerElevationD9Ej5fM();
        }
        float f10 = f5;
        if ((i2 & 8) != 0) {
            f6 = FilledTonalButtonTokens.INSTANCE.m17689getHoverContainerElevationD9Ej5fM();
        }
        float f11 = f6;
        if ((i2 & 16) != 0) {
            f7 = C2256Dp.m20968constructorimpl(0);
        }
        float f12 = f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5982871, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:727)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f8, f9, f10, f11, f12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    @NotNull
    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    @Composable
    @JvmName(name = "getElevatedShape")
    @NotNull
    public final Shape getElevatedShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(2143958791);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143958791, i, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:526)");
        }
        Shape shape = ShapesKt.toShape(ElevatedButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @JvmName(name = "getFilledTonalShape")
    @NotNull
    public final Shape getFilledTonalShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-886584987);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-886584987, i, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:529)");
        }
        Shape shape = ShapesKt.toShape(FilledTonalButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17012getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m17013getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m17014getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m17015getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    @JvmName(name = "getOutlinedButtonBorder")
    @NotNull
    public final BorderStroke getOutlinedButtonBorder(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-563957672);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563957672, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:744)");
        }
        OutlinedButtonTokens outlinedButtonTokens = OutlinedButtonTokens.INSTANCE;
        BorderStroke borderStrokeM15436BorderStrokecXLIe8U = BorderStrokeKt.m15436BorderStrokecXLIe8U(outlinedButtonTokens.m17768getOutlineWidthD9Ej5fM(), ColorSchemeKt.toColor(outlinedButtonTokens.getOutlineColor(), composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStrokeM15436BorderStrokecXLIe8U;
    }

    @Composable
    @JvmName(name = "getOutlinedShape")
    @NotNull
    public final Shape getOutlinedShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-2045213065);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045213065, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:532)");
        }
        Shape shape = ShapesKt.toShape(OutlinedButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @JvmName(name = "getShape")
    @NotNull
    public final Shape getShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1234923021);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, i, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:523)");
        }
        Shape shape = ShapesKt.toShape(FilledButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @Composable
    @JvmName(name = "getTextShape")
    @NotNull
    public final Shape getTextShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-349121587);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, i, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:535)");
        }
        Shape shape = ShapesKt.toShape(TextButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m17016outlinedButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1778526249);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long color = (i2 & 2) != 0 ? ColorSchemeKt.toColor(OutlinedButtonTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long jM18560getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778526249, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:624)");
        }
        ButtonColors buttonColors = new ButtonColors(jM18560getTransparent0d7_KjU, color, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m17017textButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1402274782);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long color = (i2 & 2) != 0 ? ColorSchemeKt.toColor(TextButtonTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long jM18560getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(TextButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, i, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:648)");
        }
        ButtonColors buttonColors = new ButtonColors(jM18560getTransparent0d7_KjU, color, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }
}
