package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 Jo\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 Jo\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, m13886d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@ExperimentalMaterialApi
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;

    @NotNull
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = C2256Dp.m20968constructorimpl(32);
    private static final float OutlinedBorderSize = C2256Dp.m20968constructorimpl(1);
    private static final float LeadingIconSize = C2256Dp.m20968constructorimpl(20);
    private static final float SelectedIconSize = C2256Dp.m20968constructorimpl(18);

    private ChipDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m16656chipColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        long jM18570compositeOverOWjLjI;
        long jM18570compositeOverOWjLjI2;
        composer.startReplaceableGroup(1838505436);
        if ((i2 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(materialTheme.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            jM18570compositeOverOWjLjI = j;
        }
        long jM18524copywmQWz5c$default = (i2 & 2) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18524copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if ((i2 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            jM18570compositeOverOWjLjI2 = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(materialTheme2.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            jM18570compositeOverOWjLjI2 = j5;
        }
        long jM18524copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, i, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:383)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(jM18570compositeOverOWjLjI, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18570compositeOverOWjLjI2, jM18524copywmQWz5c$default3, jM18524copywmQWz5c$default4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultChipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m16657filterChipColorsJ08w3E(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, @Nullable Composer composer, int i, int i2) {
        long jM18570compositeOverOWjLjI;
        long jM18570compositeOverOWjLjI2;
        composer.startReplaceableGroup(830140629);
        if ((i2 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(materialTheme.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            jM18570compositeOverOWjLjI = j;
        }
        long jM18524copywmQWz5c$default = (i2 & 2) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18524copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if ((i2 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            jM18570compositeOverOWjLjI2 = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(materialTheme2.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).m16680getSurface0d7_KjU());
        } else {
            jM18570compositeOverOWjLjI2 = j5;
        }
        long jM18524copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18570compositeOverOWjLjI3 = (i2 & 64) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), jM18570compositeOverOWjLjI) : j8;
        long jM18570compositeOverOWjLjI4 = (i2 & 128) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM18524copywmQWz5c$default) : j9;
        long jM18570compositeOverOWjLjI5 = (i2 & 256) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM18524copywmQWz5c$default2) : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, i, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:453)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM18570compositeOverOWjLjI, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18570compositeOverOWjLjI2, jM18524copywmQWz5c$default3, jM18524copywmQWz5c$default4, jM18570compositeOverOWjLjI3, jM18570compositeOverOWjLjI4, jM18570compositeOverOWjLjI5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m16658getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m16659getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    @Composable
    @JvmName(name = "getOutlinedBorder")
    @NotNull
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1650225597);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, i, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:541)");
        }
        BorderStroke borderStrokeM15436BorderStrokecXLIe8U = BorderStrokeKt.m15436BorderStrokecXLIe8U(OutlinedBorderSize, Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStrokeM15436BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m16660getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* JADX INFO: renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m16661getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m16662outlinedChipColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1763922662);
        long jM16680getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j;
        long jM18524copywmQWz5c$default = (i2 & 2) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18524copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j8 = (i2 & 8) != 0 ? jM16680getSurface0d7_KjU : j5;
        long jM18524copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, i, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:419)");
        }
        ChipColors chipColorsM16656chipColors5tl4gsc = m16656chipColors5tl4gsc(jM16680getSurface0d7_KjU, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, j8, jM18524copywmQWz5c$default3, jM18524copywmQWz5c$default4, composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColorsM16656chipColors5tl4gsc;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m16663outlinedFilterChipColorsJ08w3E(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(346878099);
        long jM16680getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU() : j;
        long jM18524copywmQWz5c$default = (i2 & 2) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18524copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j11 = (i2 & 8) != 0 ? jM16680getSurface0d7_KjU : j5;
        long jM18524copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18570compositeOverOWjLjI = (i2 & 64) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM16680getSurface0d7_KjU) : j8;
        long jM18570compositeOverOWjLjI2 = (i2 & 128) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM18524copywmQWz5c$default) : j9;
        long jM18570compositeOverOWjLjI3 = (i2 & 256) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM18524copywmQWz5c$default2) : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, i, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:504)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM16680getSurface0d7_KjU, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, j11, jM18524copywmQWz5c$default3, jM18524copywmQWz5c$default4, jM18570compositeOverOWjLjI, jM18570compositeOverOWjLjI2, jM18570compositeOverOWjLjI3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }
}
