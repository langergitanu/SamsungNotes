package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.material3.tokens.ScrimTokens;
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
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/material3/DrawerDefaults;", "", "()V", "DismissibleDrawerElevation", "Landroidx/compose/ui/unit/Dp;", "getDismissibleDrawerElevation-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "MaximumDrawerWidth", "getMaximumDrawerWidth-D9Ej5fM", "ModalDrawerElevation", "getModalDrawerElevation-D9Ej5fM", "PermanentDrawerElevation", "getPermanentDrawerElevation-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "scrimColor", "getScrimColor", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class DrawerDefaults {
    public static final int $stable = 0;
    private static final float DismissibleDrawerElevation;

    @NotNull
    public static final DrawerDefaults INSTANCE = new DrawerDefaults();
    private static final float MaximumDrawerWidth;
    private static final float ModalDrawerElevation;
    private static final float PermanentDrawerElevation;

    static {
        NavigationDrawerTokens navigationDrawerTokens = NavigationDrawerTokens.INSTANCE;
        ModalDrawerElevation = navigationDrawerTokens.m17747getModalContainerElevationD9Ej5fM();
        PermanentDrawerElevation = navigationDrawerTokens.m17748getStandardContainerElevationD9Ej5fM();
        DismissibleDrawerElevation = navigationDrawerTokens.m17748getStandardContainerElevationD9Ej5fM();
        MaximumDrawerWidth = navigationDrawerTokens.m17745getContainerWidthD9Ej5fM();
    }

    private DrawerDefaults() {
    }

    @Composable
    @JvmName(name = "getContainerColor")
    public final long getContainerColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1797317261);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1797317261, i, -1, "androidx.compose.material3.DrawerDefaults.<get-containerColor> (NavigationDrawer.kt:623)");
        }
        long color = ColorSchemeKt.toColor(NavigationDrawerTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    /* JADX INFO: renamed from: getDismissibleDrawerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17139getDismissibleDrawerElevationD9Ej5fM() {
        return DismissibleDrawerElevation;
    }

    /* JADX INFO: renamed from: getMaximumDrawerWidth-D9Ej5fM, reason: not valid java name */
    public final float m17140getMaximumDrawerWidthD9Ej5fM() {
        return MaximumDrawerWidth;
    }

    /* JADX INFO: renamed from: getModalDrawerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17141getModalDrawerElevationD9Ej5fM() {
        return ModalDrawerElevation;
    }

    /* JADX INFO: renamed from: getPermanentDrawerElevation-D9Ej5fM, reason: not valid java name */
    public final float m17142getPermanentDrawerElevationD9Ej5fM() {
        return PermanentDrawerElevation;
    }

    @Composable
    @JvmName(name = "getScrimColor")
    public final long getScrimColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1055074989);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1055074989, i, -1, "androidx.compose.material3.DrawerDefaults.<get-scrimColor> (NavigationDrawer.kt:620)");
        }
        long jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM18524copywmQWz5c$default;
    }

    @Composable
    @JvmName(name = "getShape")
    @NotNull
    public final Shape getShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(928378975);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(928378975, i, -1, "androidx.compose.material3.DrawerDefaults.<get-shape> (NavigationDrawer.kt:616)");
        }
        Shape shape = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @JvmName(name = "getWindowInsets")
    @NotNull
    public final WindowInsets getWindowInsets(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-909973510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-909973510, i, -1, "androidx.compose.material3.DrawerDefaults.<get-windowInsets> (NavigationDrawer.kt:633)");
        }
        WindowInsets systemBarsForVisualComponents = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 8);
        WindowInsetsSides.Companion companion = WindowInsetsSides.INSTANCE;
        WindowInsets windowInsetsM15925onlybOOhFvg = WindowInsetsKt.m15925onlybOOhFvg(systemBarsForVisualComponents, WindowInsetsSides.m15937plusgK_yJZ4(companion.m15952getVerticalJoeWqyM(), companion.m15950getStartJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return windowInsetsM15925onlybOOhFvg;
    }
}
