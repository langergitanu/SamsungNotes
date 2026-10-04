package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, m13886d2 = {"Landroidx/compose/material/MaterialRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class MaterialRippleTheme implements RippleTheme {

    @NotNull
    public static final MaterialRippleTheme INSTANCE = new MaterialRippleTheme();

    private MaterialRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    /* JADX INFO: renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public long mo16778defaultColorWaAFU9c(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(550536719);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(550536719, i, -1, "androidx.compose.material.MaterialRippleTheme.defaultColor (MaterialTheme.kt:127)");
        }
        long jM16979defaultRippleColor5vOe2sY = RippleTheme.INSTANCE.m16979defaultRippleColor5vOe2sY(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), MaterialTheme.INSTANCE.getColors(composer, 6).isLight());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM16979defaultRippleColor5vOe2sY;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    @NotNull
    public RippleAlpha rippleAlpha(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1419762518);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1419762518, i, -1, "androidx.compose.material.MaterialRippleTheme.rippleAlpha (MaterialTheme.kt:133)");
        }
        RippleAlpha rippleAlphaM16978defaultRippleAlphaDxMtmZc = RippleTheme.INSTANCE.m16978defaultRippleAlphaDxMtmZc(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), MaterialTheme.INSTANCE.getColors(composer, 6).isLight());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rippleAlphaM16978defaultRippleAlphaDxMtmZc;
    }
}
