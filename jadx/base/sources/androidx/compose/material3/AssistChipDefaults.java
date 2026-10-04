package androidx.compose.material3;

import androidx.compose.material3.tokens.AssistChipTokens;
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
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015Je\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!JQ\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+Je\u0010,\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010!JQ\u0010.\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010+R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, m13886d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "IconSize", "getIconSize-D9Ej5fM", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "assistChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "assistChipColors", "Landroidx/compose/material3/ChipColors;", "containerColor", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AssistChipDefaults {
    public static final int $stable = 0;
    private static final float Height;

    @NotNull
    public static final AssistChipDefaults INSTANCE = new AssistChipDefaults();
    private static final float IconSize;

    static {
        AssistChipTokens assistChipTokens = AssistChipTokens.INSTANCE;
        Height = assistChipTokens.m17481getContainerHeightD9Ej5fM();
        IconSize = assistChipTokens.m17490getIconSizeD9Ej5fM();
    }

    private AssistChipDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: assistChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m16997assistChipBorderd_3_b6Q(long j, long j2, float f, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(382372847);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM18524copywmQWz5c$default = (i2 & 2) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM17489getFlatOutlineWidthD9Ej5fM = (i2 & 4) != 0 ? AssistChipTokens.INSTANCE.m17489getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382372847, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:708)");
        }
        ChipBorder chipBorder = new ChipBorder(color, jM18524copywmQWz5c$default, fM17489getFlatOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipBorder;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: assistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m16998assistChipColorsoq7We08(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-391745725);
        long jM18560getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j;
        long color = (i2 & 2) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer, 6) : j3;
        long j10 = (i2 & 8) != 0 ? color2 : j5;
        long jM18560getTransparent0d7_KjU2 = (i2 & 16) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j6;
        long jM18524copywmQWz5c$default = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default2 = (i2 & 64) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long j11 = (i2 & 128) != 0 ? jM18524copywmQWz5c$default2 : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391745725, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:648)");
        }
        ChipColors chipColors = new ChipColors(jM18560getTransparent0d7_KjU, color, color2, j10, jM18560getTransparent0d7_KjU2, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, j11, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: assistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m16999assistChipElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(245366099);
        if ((i2 & 1) != 0) {
            f = AssistChipTokens.INSTANCE.m17488getFlatContainerElevationD9Ej5fM();
        }
        float f9 = f;
        float f10 = (i2 & 2) != 0 ? f9 : f4;
        float f11 = (i2 & 4) != 0 ? f9 : f5;
        float f12 = (i2 & 8) != 0 ? f9 : f6;
        float fM17482getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m17482getDraggedContainerElevationD9Ej5fM() : f7;
        float f13 = (i2 & 32) != 0 ? f9 : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245366099, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:684)");
        }
        ChipElevation chipElevation = new ChipElevation(f9, f10, f11, f12, fM17482getDraggedContainerElevationD9Ej5fM, f13, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedAssistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m17000elevatedAssistChipColorsoq7We08(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-535762675);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedContainerColor(), composer, 6) : j;
        long color2 = (i2 & 2) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer, 6) : j2;
        long color3 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer, 6) : j3;
        long j10 = (i2 & 8) != 0 ? color3 : j5;
        long jM18524copywmQWz5c$default = (i2 & 16) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18524copywmQWz5c$default2 = (i2 & 32) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default3 = (i2 & 64) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long j11 = (i2 & 128) != 0 ? jM18524copywmQWz5c$default3 : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-535762675, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:733)");
        }
        ChipColors chipColors = new ChipColors(color, color2, color3, j10, jM18524copywmQWz5c$default, jM18524copywmQWz5c$default2, jM18524copywmQWz5c$default3, j11, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedAssistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m17001elevatedAssistChipElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1457698077);
        if ((i2 & 1) != 0) {
            f = AssistChipTokens.INSTANCE.m17483getElevatedContainerElevationD9Ej5fM();
        }
        float f9 = f;
        if ((i2 & 2) != 0) {
            f4 = AssistChipTokens.INSTANCE.m17487getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 4) != 0) {
            f5 = AssistChipTokens.INSTANCE.m17485getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        if ((i2 & 8) != 0) {
            f6 = AssistChipTokens.INSTANCE.m17486getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f12 = f6;
        float fM17482getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m17482getDraggedContainerElevationD9Ej5fM() : f7;
        float fM17484getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? AssistChipTokens.INSTANCE.m17484getElevatedDisabledContainerElevationD9Ej5fM() : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457698077, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:770)");
        }
        ChipElevation chipElevation = new ChipElevation(f9, f10, f11, f12, fM17482getDraggedContainerElevationD9Ej5fM, fM17484getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m17002getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m17003getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @Composable
    @JvmName(name = "getShape")
    @NotNull
    public final Shape getShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1988153916);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1988153916, i, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:787)");
        }
        Shape shape = ShapesKt.toShape(AssistChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }
}
