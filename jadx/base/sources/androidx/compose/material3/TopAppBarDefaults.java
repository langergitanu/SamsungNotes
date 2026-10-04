package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallCenteredTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterial3Api
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010JK\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001dJK\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001dJG\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0010JG\u0010!\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0010J'\u0010#\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0002\u0010$JG\u0010%\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, m13886d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "()V", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "centerAlignedTopAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "enterAlwaysScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "smallTopAppBarColors", "smallTopAppBarColors-zjMxDiM", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TopAppBarDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();

    private TopAppBarDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: centerAlignedTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m17470centerAlignedTopAppBarColorszjMxDiM(long j, long j2, long j3, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1896017784);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17096applyTonalElevationHht5A8o = (i2 & 2) != 0 ? ColorSchemeKt.m17096applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), color, TopAppBarSmallTokens.INSTANCE.m17934getOnScrollContainerElevationD9Ej5fM()) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j3;
        long color3 = (i2 & 8) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getHeadlineColor(), composer, 6) : j5;
        long color4 = (i2 & 16) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896017784, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:583)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(color, jM17096applyTonalElevationHht5A8o, color2, color3, color4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }

    @Composable
    @ExperimentalMaterial3Api
    @NotNull
    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(@Nullable TopAppBarState topAppBarState, @Nullable Function0<Boolean> function0, @Nullable AnimationSpec<Float> animationSpec, @Nullable DecayAnimationSpec<Float> decayAnimationSpec, @Nullable Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(959086674);
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            };
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959086674, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:696)");
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return enterAlwaysScrollBehavior;
    }

    @Composable
    @ExperimentalMaterial3Api
    @NotNull
    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(@Nullable TopAppBarState topAppBarState, @Nullable Function0<Boolean> function0, @Nullable AnimationSpec<Float> animationSpec, @Nullable DecayAnimationSpec<Float> decayAnimationSpec, @Nullable Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-1757023234);
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            };
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1757023234, i, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:729)");
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = new ExitUntilCollapsedScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return exitUntilCollapsedScrollBehavior;
    }

    @Composable
    @JvmName(name = "getWindowInsets")
    @NotNull
    public final WindowInsets getWindowInsets(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(2143182847);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, i, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:568)");
        }
        WindowInsets systemBarsForVisualComponents = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 8);
        WindowInsetsSides.Companion companion = WindowInsetsSides.INSTANCE;
        WindowInsets windowInsetsM15925onlybOOhFvg = WindowInsetsKt.m15925onlybOOhFvg(systemBarsForVisualComponents, WindowInsetsSides.m15937plusgK_yJZ4(companion.m15947getHorizontalJoeWqyM(), companion.m15951getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return windowInsetsM15925onlybOOhFvg;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: largeTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m17471largeTopAppBarColorszjMxDiM(long j, long j2, long j3, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1471507700);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17096applyTonalElevationHht5A8o = (i2 & 2) != 0 ? ColorSchemeKt.m17096applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), color, TopAppBarSmallTokens.INSTANCE.m17934getOnScrollContainerElevationD9Ej5fM()) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j3;
        long color3 = (i2 & 8) != 0 ? ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getHeadlineColor(), composer, 6) : j5;
        long color4 = (i2 & 16) != 0 ? ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471507700, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:645)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(color, jM17096applyTonalElevationHht5A8o, color2, color3, color4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: mediumTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m17472mediumTopAppBarColorszjMxDiM(long j, long j2, long j3, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-582474442);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17096applyTonalElevationHht5A8o = (i2 & 2) != 0 ? ColorSchemeKt.m17096applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), color, TopAppBarSmallTokens.INSTANCE.m17934getOnScrollContainerElevationD9Ej5fM()) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j3;
        long color3 = (i2 & 8) != 0 ? ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getHeadlineColor(), composer, 6) : j5;
        long color4 = (i2 & 16) != 0 ? ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582474442, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:614)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(color, jM17096applyTonalElevationHht5A8o, color2, color3, color4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }

    @Composable
    @ExperimentalMaterial3Api
    @NotNull
    public final TopAppBarScrollBehavior pinnedScrollBehavior(@Nullable TopAppBarState topAppBarState, @Nullable Function0<Boolean> function0, @Nullable Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(286497075);
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286497075, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:674)");
        }
        PinnedScrollBehavior pinnedScrollBehavior = new PinnedScrollBehavior(topAppBarState, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return pinnedScrollBehavior;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: smallTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m17473smallTopAppBarColorszjMxDiM(long j, long j2, long j3, long j5, long j6, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1717201472);
        long color = (i2 & 1) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long jM17096applyTonalElevationHht5A8o = (i2 & 2) != 0 ? ColorSchemeKt.m17096applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer, 6), color, TopAppBarSmallTokens.INSTANCE.m17934getOnScrollContainerElevationD9Ej5fM()) : j2;
        long color2 = (i2 & 4) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j3;
        long color3 = (i2 & 8) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getHeadlineColor(), composer, 6) : j5;
        long color4 = (i2 & 16) != 0 ? ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1717201472, i, -1, "androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors (AppBar.kt:545)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(color, jM17096applyTonalElevationHht5A8o, color2, color3, color4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }
}
