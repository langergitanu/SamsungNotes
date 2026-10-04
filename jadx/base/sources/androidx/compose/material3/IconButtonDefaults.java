package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0011JQ\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J=\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0011JQ\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\u0010$J=\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0011J\u001f\u0010'\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020#H\u0007¢\u0006\u0002\u0010)JQ\u0010*\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, m13886d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "()V", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "filledIconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "filledIconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "filledIconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "iconButtonColors", "iconButtonColors-ro_MJ88", "iconToggleButtonColors", "iconToggleButtonColors-5tl4gsc", "outlinedIconButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "outlinedIconToggleButtonBorder", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class IconButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filledIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m17188filledIconButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-669858473);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17098contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, i & 14) : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669858473, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:608)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(color, jM17098contentColorForek8zF_U, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filledIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m17189filledIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1887173701);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getToggleUnselectedColor(), composer, 6) : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long color3 = (i2 & 16) != 0 ? ColorSchemeKt.toColor(FilledIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6) : j6;
        long jM17098contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color3, composer, (i >> 12) & 14) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1887173701, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:635)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(color, color2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, color3, jM17098contentColorForek8zF_U, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filledTonalIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m17190filledTonalIconButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-18532843);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17098contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, i & 14) : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-18532843, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:666)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(color, jM17098contentColorForek8zF_U, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filledTonalIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m17191filledTonalIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-19426557);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor(), composer, 6) : j;
        long jM17098contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, i & 14) : j2;
        long jM18524copywmQWz5c$default = (i2 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM18524copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getDisabledColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long color2 = (i2 & 16) != 0 ? ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6) : j6;
        long color3 = (i2 & 32) != 0 ? ColorSchemeKt.toColor(FilledTonalIconButtonTokens.INSTANCE.getToggleSelectedColor(), composer, 6) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-19426557, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:693)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(color, jM17098contentColorForek8zF_U, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, color2, color3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    @Composable
    @JvmName(name = "getFilledShape")
    @NotNull
    public final Shape getFilledShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1265841879);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1265841879, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:539)");
        }
        Shape shape = ShapesKt.toShape(FilledIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @JvmName(name = "getOutlinedShape")
    @NotNull
    public final Shape getOutlinedShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1327125527);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1327125527, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:543)");
        }
        Shape shape = ShapesKt.toShape(OutlinedIconButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m17192iconButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(999008085);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long jM18535unboximpl = (i2 & 2) != 0 ? ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl() : j2;
        long jM18560getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(jM18535unboximpl, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999008085, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:555)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(jM18560getTransparent0d7_KjU, jM18535unboximpl, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: iconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m17193iconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2020719549);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long jM18535unboximpl = (i2 & 2) != 0 ? ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl() : j2;
        long jM18560getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(jM18535unboximpl, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM18560getTransparent0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j6;
        long color = (i2 & 32) != 0 ? ColorSchemeKt.toColor(IconButtonTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020719549, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:581)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(jM18560getTransparent0d7_KjU, jM18535unboximpl, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, jM18560getTransparent0d7_KjU3, color, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }

    @Composable
    @NotNull
    public final BorderStroke outlinedIconButtonBorder(boolean z, @Nullable Composer composer, int i) {
        long jM18524copywmQWz5c$default;
        composer.startReplaceableGroup(-511461558);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511461558, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:789)");
        }
        if (z) {
            composer.startReplaceableGroup(1252615072);
            jM18524copywmQWz5c$default = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1252615127);
            jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            composer.endReplaceableGroup();
        }
        Color colorM18515boximpl = Color.m18515boximpl(jM18524copywmQWz5c$default);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(colorM18515boximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m15436BorderStrokecXLIe8U(OutlinedIconButtonTokens.INSTANCE.m17779getUnselectedOutlineWidthD9Ej5fM(), jM18524copywmQWz5c$default);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        BorderStroke borderStroke = (BorderStroke) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStroke;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m17194outlinedIconButtonColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1030517545);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long jM18535unboximpl = (i2 & 2) != 0 ? ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl() : j2;
        long jM18560getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(jM18535unboximpl, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030517545, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:723)");
        }
        IconButtonColors iconButtonColors = new IconButtonColors(jM18560getTransparent0d7_KjU, jM18535unboximpl, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconButtonColors;
    }

    @Composable
    @Nullable
    public final BorderStroke outlinedIconToggleButtonBorder(boolean z, boolean z2, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1244729690);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1244729690, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:776)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonBorder = outlinedIconButtonBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStrokeOutlinedIconButtonBorder;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m17195outlinedIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j5, long j6, long j7, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(2130592709);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long jM18535unboximpl = (i2 & 2) != 0 ? ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl() : j2;
        long jM18560getTransparent0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(jM18535unboximpl, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long color = (i2 & 16) != 0 ? ColorSchemeKt.toColor(OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor(), composer, 6) : j6;
        long jM17098contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, (i >> 12) & 14) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130592709, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:749)");
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(jM18560getTransparent0d7_KjU, jM18535unboximpl, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, color, jM17098contentColorForek8zF_U, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iconToggleButtonColors;
    }
}
