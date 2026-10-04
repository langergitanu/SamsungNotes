package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.p109ui.C2026R;
import androidx.compose.p109ui.platform.AbstractComposeView;
import androidx.compose.p109ui.platform.ComposeView;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.core.graphics.Insets;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0000\u001a\f\u0010V\u001a\u00020W*\u00020SH\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0010\"(\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\".\u0010\u0015\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0017\u0010\u001e\"\u0004\b\u0019\u0010\u001f\"\u0015\u0010 \u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b!\u0010\u0010\"\u0015\u0010\"\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b#\u0010\u0010\"\u001e\u0010$\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0010\"\u001e\u0010'\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0010\"\u001e\u0010*\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u001e\u0010,\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u001e\u0010.\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0015\u00100\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b1\u0010\u0010\"\u0015\u00102\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b3\u0010\u0010\"\u001e\u00104\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0010\"\u0015\u00107\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b8\u0010\u0010\"\u0015\u00109\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b:\u0010\u0010\"\u0015\u0010;\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b<\u0010\u0010\"\u0015\u0010=\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b>\u0010\u0010\"\u001e\u0010?\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0010\"\u0015\u0010B\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bC\u0010\u0010\"\u001e\u0010D\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0010\"\u0015\u0010G\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bH\u0010\u0010\"\u0015\u0010I\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bJ\u0010\u0010\"\u001e\u0010K\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0010\"\u0015\u0010N\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bO\u0010\u0010¨\u0006X"}, m13886d2 = {"areNavigationBarsVisible", "", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getAreNavigationBarsVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;)V", "getAreNavigationBarsVisible", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "areStatusBarsVisible", "getAreStatusBarsVisible$annotations", "getAreStatusBarsVisible", "areSystemBarsVisible", "getAreSystemBarsVisible$annotations", "getAreSystemBarsVisible", "captionBar", "Landroidx/compose/foundation/layout/WindowInsets;", "getCaptionBar", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility$annotations", "getCaptionBarIgnoringVisibility", "value", "consumeWindowInsets", "Landroidx/compose/ui/platform/AbstractComposeView;", "getConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;)Z", "setConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;Z)V", "Landroidx/compose/ui/platform/ComposeView;", "getConsumeWindowInsets$annotations", "(Landroidx/compose/ui/platform/ComposeView;)V", "(Landroidx/compose/ui/platform/ComposeView;)Z", "(Landroidx/compose/ui/platform/ComposeView;Z)V", "displayCutout", "getDisplayCutout", "ime", "getIme", "imeAnimationSource", "getImeAnimationSource$annotations", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget$annotations", "getImeAnimationTarget", "isCaptionBarVisible", "isCaptionBarVisible$annotations", "isImeVisible", "isImeVisible$annotations", "isTappableElementVisible", "isTappableElementVisible$annotations", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility$annotations", "getNavigationBarsIgnoringVisibility", "safeContent", "getSafeContent", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility$annotations", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility$annotations", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility$annotations", "getTappableElementIgnoringVisibility", "waterfall", "getWaterfall", "ValueInsets", "Landroidx/compose/foundation/layout/ValueInsets;", "insets", "Landroidx/core/graphics/Insets;", "name", "", "toInsetsValues", "Landroidx/compose/foundation/layout/InsetsValues;", "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class WindowInsets_androidKt {
    @NotNull
    public static final ValueInsets ValueInsets(@NotNull Insets insets, @NotNull String str) {
        return new ValueInsets(toInsetsValues(insets), str);
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "getAreNavigationBarsVisible")
    public static final boolean getAreNavigationBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(710310464, i, -1, "androidx.compose.foundation.layout.<get-areNavigationBarsVisible> (WindowInsets.android.kt:366)");
        }
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 6).getNavigationBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "getAreStatusBarsVisible")
    public static final boolean getAreStatusBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613283456, i, -1, "androidx.compose.foundation.layout.<get-areStatusBarsVisible> (WindowInsets.android.kt:354)");
        }
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 6).getStatusBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "getAreSystemBarsVisible")
    public static final boolean getAreSystemBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1985490720, i, -1, "androidx.compose.foundation.layout.<get-areSystemBarsVisible> (WindowInsets.android.kt:378)");
        }
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 6).getSystemBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zIsVisible;
    }

    @Composable
    @JvmName(name = "getCaptionBar")
    @NotNull
    public static final WindowInsets getCaptionBar(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1832025528, i, -1, "androidx.compose.foundation.layout.<get-captionBar> (WindowInsets.android.kt:142)");
        }
        AndroidWindowInsets captionBar = WindowInsetsHolder.INSTANCE.current(composer, 6).getCaptionBar();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return captionBar;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getCaptionBarIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getCaptionBarIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1731251574, i, -1, "androidx.compose.foundation.layout.<get-captionBarIgnoringVisibility> (WindowInsets.android.kt:266)");
        }
        ValueInsets captionBarIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 6).getCaptionBarIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return captionBarIgnoringVisibility;
    }

    public static final boolean getConsumeWindowInsets(@NotNull AbstractComposeView abstractComposeView) {
        Object tag = abstractComposeView.getTag(C2026R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Composable
    @JvmName(name = "getDisplayCutout")
    @NotNull
    public static final WindowInsets getDisplayCutout(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1324817724, i, -1, "androidx.compose.foundation.layout.<get-displayCutout> (WindowInsets.android.kt:151)");
        }
        AndroidWindowInsets displayCutout = WindowInsetsHolder.INSTANCE.current(composer, 6).getDisplayCutout();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return displayCutout;
    }

    @Composable
    @JvmName(name = "getIme")
    @NotNull
    public static final WindowInsets getIme(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1466917860, i, -1, "androidx.compose.foundation.layout.<get-ime> (WindowInsets.android.kt:165)");
        }
        AndroidWindowInsets ime = WindowInsetsHolder.INSTANCE.current(composer, 6).getIme();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ime;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getImeAnimationSource")
    @NotNull
    @Composable
    public static final WindowInsets getImeAnimationSource(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1126064918, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationSource> (WindowInsets.android.kt:404)");
        }
        ValueInsets imeAnimationSource = WindowInsetsHolder.INSTANCE.current(composer, 6).getImeAnimationSource();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imeAnimationSource;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getImeAnimationTarget")
    @NotNull
    @Composable
    public static final WindowInsets getImeAnimationTarget(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-466319786, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationTarget> (WindowInsets.android.kt:419)");
        }
        ValueInsets imeAnimationTarget = WindowInsetsHolder.INSTANCE.current(composer, 6).getImeAnimationTarget();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imeAnimationTarget;
    }

    @Composable
    @JvmName(name = "getMandatorySystemGestures")
    @NotNull
    public static final WindowInsets getMandatorySystemGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1369492988, i, -1, "androidx.compose.foundation.layout.<get-mandatorySystemGestures> (WindowInsets.android.kt:174)");
        }
        AndroidWindowInsets mandatorySystemGestures = WindowInsetsHolder.INSTANCE.current(composer, 6).getMandatorySystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mandatorySystemGestures;
    }

    @Composable
    @JvmName(name = "getNavigationBars")
    @NotNull
    public static final WindowInsets getNavigationBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1596175702, i, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:184)");
        }
        AndroidWindowInsets navigationBars = WindowInsetsHolder.INSTANCE.current(composer, 6).getNavigationBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return navigationBars;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getNavigationBarsIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getNavigationBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1990981160, i, -1, "androidx.compose.foundation.layout.<get-navigationBarsIgnoringVisibility> (WindowInsets.android.kt:280)");
        }
        ValueInsets navigationBarsIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 6).getNavigationBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return navigationBarsIgnoringVisibility;
    }

    @Composable
    @JvmName(name = "getSafeContent")
    @NotNull
    public static final WindowInsets getSafeContent(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026663876, i, -1, "androidx.compose.foundation.layout.<get-safeContent> (WindowInsets.android.kt:254)");
        }
        WindowInsets safeContent = WindowInsetsHolder.INSTANCE.current(composer, 6).getSafeContent();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return safeContent;
    }

    @Composable
    @JvmName(name = "getSafeDrawing")
    @NotNull
    public static final WindowInsets getSafeDrawing(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-49441252, i, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:234)");
        }
        WindowInsets safeDrawing = WindowInsetsHolder.INSTANCE.current(composer, 6).getSafeDrawing();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return safeDrawing;
    }

    @Composable
    @JvmName(name = "getSafeGestures")
    @NotNull
    public static final WindowInsets getSafeGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1594247780, i, -1, "androidx.compose.foundation.layout.<get-safeGestures> (WindowInsets.android.kt:245)");
        }
        WindowInsets safeGestures = WindowInsetsHolder.INSTANCE.current(composer, 6).getSafeGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return safeGestures;
    }

    @Composable
    @JvmName(name = "getStatusBars")
    @NotNull
    public static final WindowInsets getStatusBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-675090670, i, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:192)");
        }
        AndroidWindowInsets statusBars = WindowInsetsHolder.INSTANCE.current(composer, 6).getStatusBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return statusBars;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getStatusBarsIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getStatusBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(594020756, i, -1, "androidx.compose.foundation.layout.<get-statusBarsIgnoringVisibility> (WindowInsets.android.kt:292)");
        }
        ValueInsets statusBarsIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 6).getStatusBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return statusBarsIgnoringVisibility;
    }

    @Composable
    @JvmName(name = "getSystemBars")
    @NotNull
    public static final WindowInsets getSystemBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-282936756, i, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:200)");
        }
        AndroidWindowInsets systemBars = WindowInsetsHolder.INSTANCE.current(composer, 6).getSystemBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return systemBars;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getSystemBarsIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getSystemBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1564566798, i, -1, "androidx.compose.foundation.layout.<get-systemBarsIgnoringVisibility> (WindowInsets.android.kt:305)");
        }
        ValueInsets systemBarsIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 6).getSystemBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return systemBarsIgnoringVisibility;
    }

    @Composable
    @JvmName(name = "getSystemGestures")
    @NotNull
    public static final WindowInsets getSystemGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(989216224, i, -1, "androidx.compose.foundation.layout.<get-systemGestures> (WindowInsets.android.kt:208)");
        }
        AndroidWindowInsets systemGestures = WindowInsetsHolder.INSTANCE.current(composer, 6).getSystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return systemGestures;
    }

    @Composable
    @JvmName(name = "getTappableElement")
    @NotNull
    public static final WindowInsets getTappableElement(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994205284, i, -1, "androidx.compose.foundation.layout.<get-tappableElement> (WindowInsets.android.kt:216)");
        }
        AndroidWindowInsets tappableElement = WindowInsetsHolder.INSTANCE.current(composer, 6).getTappableElement();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return tappableElement;
    }

    @ExperimentalLayoutApi
    @JvmName(name = "getTappableElementIgnoringVisibility")
    @NotNull
    @Composable
    public static final WindowInsets getTappableElementIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1488788292, i, -1, "androidx.compose.foundation.layout.<get-tappableElementIgnoringVisibility> (WindowInsets.android.kt:318)");
        }
        ValueInsets tappableElementIgnoringVisibility = WindowInsetsHolder.INSTANCE.current(composer, 6).getTappableElementIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return tappableElementIgnoringVisibility;
    }

    @Composable
    @JvmName(name = "getWaterfall")
    @NotNull
    public static final WindowInsets getWaterfall(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1943241020, i, -1, "androidx.compose.foundation.layout.<get-waterfall> (WindowInsets.android.kt:224)");
        }
        ValueInsets waterfall = WindowInsetsHolder.INSTANCE.current(composer, 6).getWaterfall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return waterfall;
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "isCaptionBarVisible")
    public static final boolean isCaptionBarVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-501076620, i, -1, "androidx.compose.foundation.layout.<get-isCaptionBarVisible> (WindowInsets.android.kt:330)");
        }
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 6).getCaptionBar().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "isImeVisible")
    public static final boolean isImeVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1873571424, i, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:342)");
        }
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 6).getIme().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    @JvmName(name = "isTappableElementVisible")
    public static final boolean isTappableElementVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737201120, i, -1, "androidx.compose.foundation.layout.<get-isTappableElementVisible> (WindowInsets.android.kt:389)");
        }
        boolean zIsVisible = WindowInsetsHolder.INSTANCE.current(composer, 6).getTappableElement().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zIsVisible;
    }

    public static final void setConsumeWindowInsets(@NotNull AbstractComposeView abstractComposeView, boolean z) {
        abstractComposeView.setTag(C2026R.id.consume_window_insets_tag, Boolean.valueOf(z));
    }

    @NotNull
    public static final InsetsValues toInsetsValues(@NotNull Insets insets) {
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static final /* synthetic */ boolean getConsumeWindowInsets(ComposeView composeView) {
        Object tag = composeView.getTag(C2026R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreNavigationBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreStatusBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreSystemBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getCaptionBarIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use AbstractComposeView.consumeWindowInsets")
    public static /* synthetic */ void getConsumeWindowInsets$annotations(ComposeView composeView) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getImeAnimationSource$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getImeAnimationTarget$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getNavigationBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getStatusBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getSystemBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getTappableElementIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isCaptionBarVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isImeVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isTappableElementVisible$annotations(WindowInsets.Companion companion) {
    }
}
