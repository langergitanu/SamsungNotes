package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ=\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0013JQ\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u001eJ\u0017\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'J=\u0010(\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u0013JQ\u0010*\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u001eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, m13886d2 = {"Landroidx/compose/material3/CardDefaults;", "", "()V", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", VMetaDataKey.META_KEY_SHAPE, "getShape", "cardColors", "Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CardDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: cardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m17018cardColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        long jM18570compositeOverOWjLjI;
        composer.startReplaceableGroup(-1589582123);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilledCardTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17098contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            FilledCardTokens filledCardTokens = FilledCardTokens.INSTANCE;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(filledCardTokens.getDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m17103surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer, 6), filledCardTokens.m17670getDisabledContainerElevationD9Ej5fM()));
        } else {
            jM18570compositeOverOWjLjI = j3;
        }
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, i & 14), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589582123, i, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:455)");
        }
        CardColors cardColors = new CardColors(color, jM17098contentColorForek8zF_U, jM18570compositeOverOWjLjI, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: cardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m17019cardElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-574898487);
        if ((i2 & 1) != 0) {
            f = FilledCardTokens.INSTANCE.m17669getContainerElevationD9Ej5fM();
        }
        float f9 = f;
        if ((i2 & 2) != 0) {
            f4 = FilledCardTokens.INSTANCE.m17675getPressedContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 4) != 0) {
            f5 = FilledCardTokens.INSTANCE.m17672getFocusContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        if ((i2 & 8) != 0) {
            f6 = FilledCardTokens.INSTANCE.m17673getHoverContainerElevationD9Ej5fM();
        }
        float f12 = f6;
        float fM17671getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilledCardTokens.INSTANCE.m17671getDraggedContainerElevationD9Ej5fM() : f7;
        float fM17670getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? FilledCardTokens.INSTANCE.m17670getDisabledContainerElevationD9Ej5fM() : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-574898487, i, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:373)");
        }
        CardElevation cardElevation = new CardElevation(f9, f10, f11, f12, fM17671getDraggedContainerElevationD9Ej5fM, fM17670getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m17020elevatedCardColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        long jM18570compositeOverOWjLjI;
        composer.startReplaceableGroup(139558303);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(ElevatedCardTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17098contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            ElevatedCardTokens elevatedCardTokens = ElevatedCardTokens.INSTANCE;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(elevatedCardTokens.getDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m17103surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer, 6), elevatedCardTokens.m17586getDisabledContainerElevationD9Ej5fM()));
        } else {
            jM18570compositeOverOWjLjI = j3;
        }
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(jM17098contentColorForek8zF_U, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139558303, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:484)");
        }
        CardColors cardColors = new CardColors(color, jM17098contentColorForek8zF_U, jM18570compositeOverOWjLjI, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevatedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m17021elevatedCardElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1154241939);
        if ((i2 & 1) != 0) {
            f = ElevatedCardTokens.INSTANCE.m17585getContainerElevationD9Ej5fM();
        }
        float f9 = f;
        if ((i2 & 2) != 0) {
            f4 = ElevatedCardTokens.INSTANCE.m17591getPressedContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 4) != 0) {
            f5 = ElevatedCardTokens.INSTANCE.m17588getFocusContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        if ((i2 & 8) != 0) {
            f6 = ElevatedCardTokens.INSTANCE.m17589getHoverContainerElevationD9Ej5fM();
        }
        float f12 = f6;
        float fM17587getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? ElevatedCardTokens.INSTANCE.m17587getDraggedContainerElevationD9Ej5fM() : f7;
        float fM17586getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? ElevatedCardTokens.INSTANCE.m17586getDisabledContainerElevationD9Ej5fM() : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1154241939, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:401)");
        }
        CardElevation cardElevation = new CardElevation(f9, f10, f11, f12, fM17587getDraggedContainerElevationD9Ej5fM, fM17586getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    @Composable
    @JvmName(name = "getElevatedShape")
    @NotNull
    public final Shape getElevatedShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-133496185);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-133496185, i, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:357)");
        }
        Shape shape = ShapesKt.toShape(ElevatedCardTokens.INSTANCE.getContainerShape(), composer, 6);
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
        composer.startReplaceableGroup(1095404023);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095404023, i, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:360)");
        }
        Shape shape = ShapesKt.toShape(OutlinedCardTokens.INSTANCE.getContainerShape(), composer, 6);
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
        composer.startReplaceableGroup(1266660211);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1266660211, i, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:354)");
        }
        Shape shape = ShapesKt.toShape(FilledCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @NotNull
    public final BorderStroke outlinedCardBorder(boolean z, @Nullable Composer composer, int i, int i2) {
        long jM18570compositeOverOWjLjI;
        composer.startReplaceableGroup(-392936593);
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-392936593, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:533)");
        }
        if (z) {
            composer.startReplaceableGroup(-31428837);
            jM18570compositeOverOWjLjI = ColorSchemeKt.toColor(OutlinedCardTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-31428766);
            OutlinedCardTokens outlinedCardTokens = OutlinedCardTokens.INSTANCE;
            jM18570compositeOverOWjLjI = ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(outlinedCardTokens.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m17103surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer, 6), outlinedCardTokens.m17770getDisabledContainerElevationD9Ej5fM()));
            composer.endReplaceableGroup();
        }
        Color colorM18515boximpl = Color.m18515boximpl(jM18570compositeOverOWjLjI);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(colorM18515boximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m15436BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.m17775getOutlineWidthD9Ej5fM(), jM18570compositeOverOWjLjI);
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
    /* JADX INFO: renamed from: outlinedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m17022outlinedCardColorsro_MJ88(long j, long j2, long j3, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1112362409);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(OutlinedCardTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17098contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m17098contentColorForek8zF_U(color, composer, i & 14) : j2;
        long j6 = (i2 & 4) != 0 ? color : j3;
        long jM18524copywmQWz5c$default = (i2 & 8) != 0 ? Color.m18524copywmQWz5c$default(jM17098contentColorForek8zF_U, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112362409, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:514)");
        }
        CardColors cardColors = new CardColors(color, jM17098contentColorForek8zF_U, j6, jM18524copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m17023outlinedCardElevationaqJV_2Y(float f, float f4, float f5, float f6, float f7, float f8, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-97678773);
        if ((i2 & 1) != 0) {
            f = OutlinedCardTokens.INSTANCE.m17769getContainerElevationD9Ej5fM();
        }
        float f9 = f;
        float f10 = (i2 & 2) != 0 ? f9 : f4;
        float f11 = (i2 & 4) != 0 ? f9 : f5;
        float f12 = (i2 & 8) != 0 ? f9 : f6;
        float fM17771getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? OutlinedCardTokens.INSTANCE.m17771getDraggedContainerElevationD9Ej5fM() : f7;
        float fM17770getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? OutlinedCardTokens.INSTANCE.m17770getDisabledContainerElevationD9Ej5fM() : f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97678773, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:429)");
        }
        CardElevation cardElevation = new CardElevation(f9, f10, f11, f12, fM17771getDraggedContainerElevationD9Ej5fM, fM17770getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }
}
