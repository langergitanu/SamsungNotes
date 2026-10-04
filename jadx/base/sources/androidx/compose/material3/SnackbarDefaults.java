package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
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
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/material3/SnackbarDefaults;", "", "()V", "actionColor", "Landroidx/compose/ui/graphics/Color;", "getActionColor", "(Landroidx/compose/runtime/Composer;I)J", "actionContentColor", "getActionContentColor", "color", "getColor", "contentColor", "getContentColor", "dismissActionContentColor", "getDismissActionContentColor", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SnackbarDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SnackbarDefaults INSTANCE = new SnackbarDefaults();

    private SnackbarDefaults() {
    }

    @Composable
    @JvmName(name = "getActionColor")
    public final long getActionColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(743425465);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(743425465, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionColor> (Snackbar.kt:414)");
        }
        long color = ColorSchemeKt.toColor(SnackbarTokens.INSTANCE.getActionLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getActionContentColor")
    public final long getActionContentColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1313141593);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1313141593, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionContentColor> (Snackbar.kt:417)");
        }
        long color = ColorSchemeKt.toColor(SnackbarTokens.INSTANCE.getActionLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getColor")
    public final long getColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(987938253);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(987938253, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-color> (Snackbar.kt:408)");
        }
        long color = ColorSchemeKt.toColor(SnackbarTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getContentColor")
    public final long getContentColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1021310823);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1021310823, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-contentColor> (Snackbar.kt:411)");
        }
        long color = ColorSchemeKt.toColor(SnackbarTokens.INSTANCE.getSupportingTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getDismissActionContentColor")
    public final long getDismissActionContentColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-528602817);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-528602817, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-dismissActionContentColor> (Snackbar.kt:420)");
        }
        long color = ColorSchemeKt.toColor(SnackbarTokens.INSTANCE.getIconColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getShape")
    @NotNull
    public final Shape getShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-551629101);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-551629101, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-shape> (Snackbar.kt:405)");
        }
        Shape shape = ShapesKt.toShape(SnackbarTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }
}
