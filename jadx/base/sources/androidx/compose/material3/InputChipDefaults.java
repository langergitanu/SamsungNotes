package androidx.compose.material3;

import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
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
@ExperimentalMaterial3Api
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0097\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00132\b\b\u0002\u0010)\u001a\u00020\u0013H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+JQ\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, m13886d2 = {"Landroidx/compose/material3/InputChipDefaults;", "", "()V", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "Height", "getHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "inputChipBorder", "Landroidx/compose/material3/SelectableChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-gHcDVlo", "(JJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipBorder;", "inputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "containerColor", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class InputChipDefaults {
    public static final int $stable = 0;
    private static final float AvatarSize;
    private static final float Height;

    @NotNull
    public static final InputChipDefaults INSTANCE = new InputChipDefaults();
    private static final float IconSize;

    static {
        InputChipTokens inputChipTokens = InputChipTokens.INSTANCE;
        Height = inputChipTokens.m17715getContainerHeightD9Ej5fM();
        IconSize = inputChipTokens.m17717getLeadingIconSizeD9Ej5fM();
        AvatarSize = inputChipTokens.m17713getAvatarSizeD9Ej5fM();
    }

    private InputChipDefaults() {
    }

    /* JADX INFO: renamed from: getAvatarSize-D9Ej5fM, reason: not valid java name */
    public final float m17200getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m17201getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17202getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @Composable
    @JvmName(name = "getShape")
    @NotNull
    public final Shape getShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1052444143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052444143, i, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1138)");
        }
        Shape shape = ShapesKt.toShape(InputChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: inputChipBorder-gHcDVlo, reason: not valid java name */
    public final SelectableChipBorder m17203inputChipBordergHcDVlo(long j, long j2, long j3, long j5, float f, float f4, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-324924235);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), composer, 6) : j;
        long jM18560getTransparent0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18560getTransparent0d7_KjU2 = (i2 & 8) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j5;
        float fM17720getUnselectedOutlineWidthD9Ej5fM = (i2 & 16) != 0 ? InputChipTokens.INSTANCE.m17720getUnselectedOutlineWidthD9Ej5fM() : f;
        float fM17718getSelectedOutlineWidthD9Ej5fM = (i2 & 32) != 0 ? InputChipTokens.INSTANCE.m17718getSelectedOutlineWidthD9Ej5fM() : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-324924235, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1120)");
        }
        SelectableChipBorder selectableChipBorder = new SelectableChipBorder(color, jM18560getTransparent0d7_KjU, jM18524copywmQWz5c$default, jM18560getTransparent0d7_KjU2, fM17720getUnselectedOutlineWidthD9Ej5fM, fM17718getSelectedOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipBorder;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: inputChipColors-kwJvTHA, reason: not valid java name */
    public final SelectableChipColors m17204inputChipColorskwJvTHA(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, @Nullable Composer composer, int i, int i2, int i4) {
        composer.startReplaceableGroup(1312840646);
        long jM18560getTransparent0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long color = (i4 & 2) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer, 6) : j2;
        long color2 = (i4 & 4) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedLeadingIconColor(), composer, 6) : j3;
        long color3 = (i4 & 8) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getUnselectedTrailingIconColor(), composer, 6) : j5;
        long jM18560getTransparent0d7_KjU2 = (i4 & 16) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j6;
        long jM18524copywmQWz5c$default = (i4 & 32) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default2 = (i4 & 64) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long jM18524copywmQWz5c$default3 = (i4 & 128) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long color4 = (i4 & 256) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedContainerColor(), composer, 6) : j10;
        long jM18524copywmQWz5c$default4 = (i4 & 512) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getDisabledSelectedContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long color5 = (i4 & 1024) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedLabelTextColor(), composer, 6) : j12;
        long color6 = (i4 & 2048) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedLeadingIconColor(), composer, 6) : j13;
        long color7 = (i4 & 4096) != 0 ? ColorSchemeKt.toColor(InputChipTokens.INSTANCE.getSelectedTrailingIconColor(), composer, 6) : j14;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1312840646, i, i2, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1043)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(jM18560getTransparent0d7_KjU, color, color2, color3, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18524copywmQWz5c$default3, color4, jM18524copywmQWz5c$default4, color5, color6, color7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: inputChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m17205inputChipElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1745270109);
        if ((i2 & 1) != 0) {
            f = InputChipTokens.INSTANCE.m17714getContainerElevationD9Ej5fM();
        }
        float f9 = f;
        float f10 = (i2 & 2) != 0 ? f9 : f4;
        float f11 = (i2 & 4) != 0 ? f9 : f5;
        float f12 = (i2 & 8) != 0 ? f9 : f6;
        float fM17716getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? InputChipTokens.INSTANCE.m17716getDraggedContainerElevationD9Ej5fM() : f7;
        float f13 = (i2 & 32) != 0 ? f9 : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1745270109, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1091)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f9, f10, f11, f12, fM17716getDraggedContainerElevationD9Ej5fM, f13, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }
}
