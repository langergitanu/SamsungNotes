package androidx.compose.material3;

import androidx.compose.material3.tokens.FilterChipTokens;
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
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u008d\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJQ\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(JQ\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u008d\u0001\u00103\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u001eJQ\u00105\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010(R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, m13886d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "IconSize", "getIconSize-D9Ej5fM", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/material3/SelectableChipBorder;", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-gHcDVlo", "(JJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipBorder;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FilterChipDefaults {
    public static final int $stable = 0;
    private static final float Height;

    @NotNull
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float IconSize;

    static {
        FilterChipTokens filterChipTokens = FilterChipTokens.INSTANCE;
        Height = filterChipTokens.m17694getContainerHeightD9Ej5fM();
        IconSize = filterChipTokens.m17710getIconSizeD9Ej5fM();
    }

    private FilterChipDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedFilterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m17168elevatedFilterChipColorsXqyqHi0(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, @Nullable Composer composer, int i, int i2, int i4) {
        composer.startReplaceableGroup(-915841711);
        long color = (i4 & 1) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor(), composer, 6) : j;
        long color2 = (i4 & 2) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer, 6) : j2;
        long color3 = (i4 & 4) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j3;
        long jM18524copywmQWz5c$default = (i4 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM18524copywmQWz5c$default2 = (i4 & 16) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default3 = (i4 & 32) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long j14 = (i4 & 64) != 0 ? jM18524copywmQWz5c$default3 : j8;
        long color4 = (i4 & 128) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor(), composer, 6) : j9;
        long j15 = (i4 & 256) != 0 ? jM18524copywmQWz5c$default : j10;
        long color5 = (i4 & 512) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), composer, 6) : j11;
        long color6 = (i4 & 1024) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j12;
        long j16 = (i4 & 2048) != 0 ? color6 : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, i, i2, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:937)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(color, color2, color3, color3, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18524copywmQWz5c$default3, j14, color4, j15, color5, color6, j16, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedFilterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m17169elevatedFilterChipElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(684803697);
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m17696getElevatedContainerElevationD9Ej5fM();
        }
        float f9 = f;
        if ((i2 & 2) != 0) {
            f4 = FilterChipTokens.INSTANCE.m17700getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 4) != 0) {
            f5 = FilterChipTokens.INSTANCE.m17698getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        if ((i2 & 8) != 0) {
            f6 = FilterChipTokens.INSTANCE.m17699getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f12 = f6;
        float fM17695getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m17695getDraggedContainerElevationD9Ej5fM() : f7;
        float fM17697getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? FilterChipTokens.INSTANCE.m17697getElevatedDisabledContainerElevationD9Ej5fM() : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:982)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f9, f10, f11, f12, fM17695getDraggedContainerElevationD9Ej5fM, fM17697getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filterChipBorder-gHcDVlo, reason: not valid java name */
    public final SelectableChipBorder m17170filterChipBordergHcDVlo(long j, long j2, long j3, long j5, float f, float f4, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1884534961);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer, 6) : j;
        long jM18560getTransparent0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18560getTransparent0d7_KjU2 = (i2 & 8) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j5;
        float fM17708getFlatUnselectedOutlineWidthD9Ej5fM = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m17708getFlatUnselectedOutlineWidthD9Ej5fM() : f;
        float fM17704getFlatSelectedOutlineWidthD9Ej5fM = (i2 & 32) != 0 ? FilterChipTokens.INSTANCE.m17704getFlatSelectedOutlineWidthD9Ej5fM() : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1884534961, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:901)");
        }
        SelectableChipBorder selectableChipBorder = new SelectableChipBorder(color, jM18560getTransparent0d7_KjU, jM18524copywmQWz5c$default, jM18560getTransparent0d7_KjU2, fM17708getFlatUnselectedOutlineWidthD9Ej5fM, fM17704getFlatSelectedOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipBorder;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m17171filterChipColorsXqyqHi0(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, @Nullable Composer composer, int i, int i2, int i4) {
        composer.startReplaceableGroup(-1831479801);
        long jM18560getTransparent0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long color = (i4 & 2) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer, 6) : j2;
        long color2 = (i4 & 4) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j3;
        long jM18560getTransparent0d7_KjU2 = (i4 & 8) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j5;
        long jM18524copywmQWz5c$default = (i4 & 16) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default2 = (i4 & 32) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long j14 = (i4 & 64) != 0 ? jM18524copywmQWz5c$default2 : j8;
        long color3 = (i4 & 128) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatSelectedContainerColor(), composer, 6) : j9;
        long jM18524copywmQWz5c$default3 = (i4 & 256) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long color4 = (i4 & 512) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), composer, 6) : j11;
        long color5 = (i4 & 1024) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j12;
        long j15 = (i4 & 2048) != 0 ? color5 : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, i, i2, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:825)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(jM18560getTransparent0d7_KjU, color, color2, color2, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, j14, color3, jM18524copywmQWz5c$default3, color4, color5, j15, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m17172filterChipElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-757972185);
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m17701getFlatContainerElevationD9Ej5fM();
        }
        float f9 = f;
        if ((i2 & 2) != 0) {
            f4 = FilterChipTokens.INSTANCE.m17705getFlatSelectedPressedContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 4) != 0) {
            f5 = FilterChipTokens.INSTANCE.m17702getFlatSelectedFocusContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        if ((i2 & 8) != 0) {
            f6 = FilterChipTokens.INSTANCE.m17703getFlatSelectedHoverContainerElevationD9Ej5fM();
        }
        float f12 = f6;
        float fM17695getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m17695getDraggedContainerElevationD9Ej5fM() : f7;
        float f13 = (i2 & 32) != 0 ? f9 : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:871)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f9, f10, f11, f12, fM17695getDraggedContainerElevationD9Ej5fM, f13, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m17173getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17174getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @Composable
    @JvmName(name = "getShape")
    @NotNull
    public final Shape getShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1598643637);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, i, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:999)");
        }
        Shape shape = ShapesKt.toShape(FilterChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }
}
