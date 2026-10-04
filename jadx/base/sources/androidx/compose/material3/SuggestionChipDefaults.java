package androidx.compose.material3;

import androidx.compose.material3.tokens.SuggestionChipTokens;
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
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JQ\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J3\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020\u00112\b\b\u0002\u0010'\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0018JQ\u0010,\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010\"R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, m13886d2 = {"Landroidx/compose/material3/SuggestionChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "IconSize", "getIconSize-D9Ej5fM", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledIconContentColor", "elevatedSuggestionChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipElevation", "Landroidx/compose/material3/ChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedSuggestionChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "suggestionChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "disabledBorderColor", "borderWidth", "suggestionChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "suggestionChipColors", "suggestionChipColors-5tl4gsc", "suggestionChipElevation", "suggestionChipElevation-aqJV_2Y", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SuggestionChipDefaults {
    public static final int $stable = 0;
    private static final float Height;

    @NotNull
    public static final SuggestionChipDefaults INSTANCE = new SuggestionChipDefaults();
    private static final float IconSize;

    static {
        SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.INSTANCE;
        Height = suggestionChipTokens.m17891getContainerHeightD9Ej5fM();
        IconSize = suggestionChipTokens.m17900getLeadingIconSizeD9Ej5fM();
    }

    private SuggestionChipDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedSuggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m17318elevatedSuggestionChipColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1269423125);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getElevatedContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long jM17052getOnSurfaceVariant0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17052getOnSurfaceVariant0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM18524copywmQWz5c$default2 = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default3 = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17051getOnSurface0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1269423125, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1249)");
        }
        Color.Companion companion = Color.INSTANCE;
        ChipColors chipColors = new ChipColors(color, color2, jM17052getOnSurfaceVariant0d7_KjU, companion.m18561getUnspecified0d7_KjU(), jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18524copywmQWz5c$default3, companion.m18561getUnspecified0d7_KjU(), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedSuggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m17319elevatedSuggestionChipElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1118088467);
        if ((i2 & 1) != 0) {
            f = SuggestionChipTokens.INSTANCE.m17893getElevatedContainerElevationD9Ej5fM();
        }
        float f9 = f;
        if ((i2 & 2) != 0) {
            f4 = SuggestionChipTokens.INSTANCE.m17897getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 4) != 0) {
            f5 = SuggestionChipTokens.INSTANCE.m17895getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        if ((i2 & 8) != 0) {
            f6 = SuggestionChipTokens.INSTANCE.m17896getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f12 = f6;
        float fM17892getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m17892getDraggedContainerElevationD9Ej5fM() : f7;
        float fM17894getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? SuggestionChipTokens.INSTANCE.m17894getElevatedDisabledContainerElevationD9Ej5fM() : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1118088467, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1286)");
        }
        ChipElevation chipElevation = new ChipElevation(f9, f10, f11, f12, fM17892getDraggedContainerElevationD9Ej5fM, fM17894getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m17320getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17321getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @Composable
    @JvmName(name = "getShape")
    @NotNull
    public final Shape getShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(641188183);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(641188183, i, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1303)");
        }
        Shape shape = ShapesKt.toShape(SuggestionChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: suggestionChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m17322suggestionChipBorderd_3_b6Q(long j, long j2, float f, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(439283919);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM18524copywmQWz5c$default = (i2 & 2) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM17899getFlatOutlineWidthD9Ej5fM = (i2 & 4) != 0 ? SuggestionChipTokens.INSTANCE.m17899getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(439283919, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1226)");
        }
        ChipBorder chipBorder = new ChipBorder(color, jM18524copywmQWz5c$default, fM17899getFlatOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipBorder;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: suggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m17323suggestionChipColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1882647883);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long color = (i2 & 2) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j3;
        long jM18560getTransparent0d7_KjU2 = (i2 & 8) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j5;
        long jM18524copywmQWz5c$default = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default2 = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1882647883, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1169)");
        }
        Color.Companion companion = Color.INSTANCE;
        ChipColors chipColors = new ChipColors(jM18560getTransparent0d7_KjU, color, color2, companion.m18561getUnspecified0d7_KjU(), jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, companion.m18561getUnspecified0d7_KjU(), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: suggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m17324suggestionChipElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1929994057);
        if ((i2 & 1) != 0) {
            f = SuggestionChipTokens.INSTANCE.m17898getFlatContainerElevationD9Ej5fM();
        }
        float f9 = f;
        float f10 = (i2 & 2) != 0 ? f9 : f4;
        float f11 = (i2 & 4) != 0 ? f9 : f5;
        float f12 = (i2 & 8) != 0 ? f9 : f6;
        float fM17892getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m17892getDraggedContainerElevationD9Ej5fM() : f7;
        float f13 = (i2 & 32) != 0 ? f9 : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1929994057, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1202)");
        }
        ChipElevation chipElevation = new ChipElevation(f9, f10, f11, f12, fM17892getDraggedContainerElevationD9Ej5fM, f13, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }
}
