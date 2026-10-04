package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.AlphaKt;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u007f\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00104\u001ak\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0003¢\u0006\u0002\u0010:\u001a;\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aS\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\r\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0019\u0010\u0014\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006J"}, m13886d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NavigationRailKt {

    @NotNull
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;

    @NotNull
    private static final String IndicatorLayoutIdTag = "indicator";

    @NotNull
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;

    @NotNull
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailHeaderPadding = C2256Dp.m20968constructorimpl(8);
    private static final float NavigationRailItemHeight;
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailItemWidth;
    private static final float NavigationRailVerticalPadding;

    static {
        float f = 4;
        NavigationRailVerticalPadding = C2256Dp.m20968constructorimpl(f);
        NavigationRailTokens navigationRailTokens = NavigationRailTokens.INSTANCE;
        NavigationRailItemWidth = navigationRailTokens.m17752getContainerWidthD9Ej5fM();
        NavigationRailItemHeight = navigationRailTokens.m17755getNoLabelActiveIndicatorHeightD9Ej5fM();
        NavigationRailItemVerticalPadding = C2256Dp.m20968constructorimpl(f);
        float f4 = 2;
        IndicatorHorizontalPadding = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(navigationRailTokens.m17750getActiveIndicatorWidthD9Ej5fM() - navigationRailTokens.m17753getIconSizeD9Ej5fM()) / f4);
        IndicatorVerticalPaddingWithLabel = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(navigationRailTokens.m17749getActiveIndicatorHeightD9Ej5fM() - navigationRailTokens.m17753getIconSizeD9Ej5fM()) / f4);
        IndicatorVerticalPaddingNoLabel = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(navigationRailTokens.m17755getNoLabelActiveIndicatorHeightD9Ej5fM() - navigationRailTokens.m17753getIconSizeD9Ej5fM()) / f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0180 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0120  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17251NavigationRailqi6gXK8(@Nullable Modifier modifier, long j, long j2, @Nullable Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable WindowInsets windowInsets, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        long containerColor;
        long jM17098contentColorForek8zF_U;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        long j3;
        final WindowInsets windowInsets3;
        Modifier modifier3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        Composer composer2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(118552648);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                containerColor = j;
                int i7 = composerStartRestartGroup.changed(containerColor) ? 32 : 16;
                i4 |= i7;
            } else {
                containerColor = j;
            }
            i4 |= i7;
        } else {
            containerColor = j;
        }
        if ((i & 896) == 0) {
            jM17098contentColorForek8zF_U = j2;
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM17098contentColorForek8zF_U)) ? 256 : 128;
        } else {
            jM17098contentColorForek8zF_U = j2;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                function32 = function3;
                i4 |= composerStartRestartGroup.changed(function32) ? 2048 : 1024;
            }
            if ((57344 & i) != 0) {
                if ((i2 & 16) == 0) {
                    windowInsets2 = windowInsets;
                    int i9 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                    i4 |= i9;
                } else {
                    windowInsets2 = windowInsets;
                }
                i4 |= i9;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 32) != 0) {
                i5 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                if ((374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier2;
                    j5 = containerColor;
                    j6 = jM17098contentColorForek8zF_U;
                    function34 = function32;
                    windowInsets4 = windowInsets2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                        }
                        if ((i2 & 4) != 0) {
                            jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 3) & 14);
                            i4 &= -897;
                        }
                        if (i8 != 0) {
                            function32 = null;
                        }
                        if ((i2 & 16) == 0) {
                            windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -57345;
                            j3 = jM17098contentColorForek8zF_U;
                        } else {
                            j3 = jM17098contentColorForek8zF_U;
                            windowInsets3 = windowInsets2;
                        }
                        modifier3 = modifier5;
                        function33 = function32;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                        }
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i4 &= -57345;
                        }
                        j3 = jM17098contentColorForek8zF_U;
                        function33 = function32;
                        modifier3 = modifier2;
                        windowInsets3 = windowInsets2;
                    }
                    long j7 = containerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(118552648, i4, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:100)");
                    }
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i10) {
                            if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2092683357, i10, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:112)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.m15906widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), windowInsets3), NavigationRailTokens.INSTANCE.m17752getContainerWidthD9Ej5fM(), 0.0f, 2, null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM15734spacedBy0680j_4 = Arrangement.INSTANCE.m15734spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
                            Function3<ColumnScope, Composer, Integer, Unit> function35 = function33;
                            int i11 = i4;
                            Function3<ColumnScope, Composer, Integer, Unit> function36 = content;
                            composer3.startReplaceableGroup(-483455358);
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM15734spacedBy0680j_4, centerHorizontally, composer3, 54);
                            Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
                            if (composer3.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            composer3.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                            composer3.startReplaceableGroup(-1163856341);
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer3.startReplaceableGroup(-1267890579);
                            composer3.startReplaceableGroup(716053607);
                            if (function35 != null) {
                                function35.invoke(columnScopeInstance, composer3, Integer.valueOf(((i11 >> 6) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, NavigationRailKt.NavigationRailHeaderPadding), composer3, 6);
                            }
                            composer3.endReplaceableGroup();
                            function36.invoke(columnScopeInstance, composer3, Integer.valueOf(((i11 >> 12) & 112) | 6));
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i10 = (i4 & 14) | 12582912;
                    int i11 = i4 << 3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier3, null, j7, j3, 0.0f, 0.0f, null, composableLambda, composer2, i10 | (i11 & 896) | (i11 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function34 = function33;
                    windowInsets4 = windowInsets3;
                    modifier4 = modifier3;
                    j5 = j7;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer3, int i12) {
                        NavigationRailKt.m17251NavigationRailqi6gXK8(modifier4, j5, j6, function34, windowInsets4, content, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= i5;
            if ((374491 & i4) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 2) != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    modifier3 = modifier5;
                    function33 = function32;
                    long j72 = containerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2092683357, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i102) {
                            if ((i102 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2092683357, i102, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:112)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.m15906widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), windowInsets3), NavigationRailTokens.INSTANCE.m17752getContainerWidthD9Ej5fM(), 0.0f, 2, null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM15734spacedBy0680j_4 = Arrangement.INSTANCE.m15734spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
                            Function3<ColumnScope, Composer, Integer, Unit> function35 = function33;
                            int i112 = i4;
                            Function3<ColumnScope, Composer, Integer, Unit> function36 = content;
                            composer3.startReplaceableGroup(-483455358);
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM15734spacedBy0680j_4, centerHorizontally, composer3, 54);
                            Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierSelectableGroup);
                            if (composer3.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            composer3.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                            composer3.startReplaceableGroup(-1163856341);
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer3.startReplaceableGroup(-1267890579);
                            composer3.startReplaceableGroup(716053607);
                            if (function35 != null) {
                                function35.invoke(columnScopeInstance, composer3, Integer.valueOf(((i112 >> 6) & 112) | 6));
                                SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, NavigationRailKt.NavigationRailHeaderPadding), composer3, 6);
                            }
                            composer3.endReplaceableGroup();
                            function36.invoke(columnScopeInstance, composer3, Integer.valueOf(((i112 >> 12) & 112) | 6));
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i102 = (i4 & 14) | 12582912;
                    int i112 = i4 << 3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier3, null, j72, j3, 0.0f, 0.0f, null, composableLambda2, composer2, i102 | (i112 & 896) | (i112 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function34 = function33;
                    windowInsets4 = windowInsets3;
                    modifier4 = modifier3;
                    j5 = j72;
                    j6 = j3;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function32 = function3;
        if ((57344 & i) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        i4 |= i5;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x039d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationRailItem(final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> icon, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, boolean z3, @Nullable NavigationRailItemColors navigationRailItemColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        int i7;
        boolean z5;
        int i8;
        int i9;
        MutableInteractionSource mutableInteractionSource2;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        int i10;
        NavigationRailItemColors navigationRailItemColorsM17250colorszjMxDiM;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer3;
        long jOffset;
        boolean zChanged;
        Object objRememberedValue;
        final Shape shape;
        Composer composer4;
        final NavigationRailItemColors navigationRailItemColors2;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z7;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1533971045);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(icon) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i & 57344) == 0) {
                    z4 = z2;
                    i4 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        function22 = function2;
                        i4 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 3670016) == 0) {
                            i4 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 29360128) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(navigationRailItemColors)) ? 8388608 : 4194304;
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        if ((i & 234881024) == 0) {
                            i9 = i8;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                        }
                        if ((i4 & 191739611) == 38347922 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer4 = composerStartRestartGroup;
                            modifier3 = modifier2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            navigationRailItemColors2 = navigationRailItemColors;
                            z7 = z5;
                            z8 = z4;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                z6 = i5 == 0 ? true : z4;
                                function23 = i6 == 0 ? null : function22;
                                if (i7 != 0) {
                                    z5 = true;
                                }
                                if ((i2 & 128) == 0) {
                                    i10 = i9;
                                    navigationRailItemColorsM17250colorszjMxDiM = NavigationRailItemDefaults.INSTANCE.m17250colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196608, 31);
                                    composer2 = composerStartRestartGroup;
                                    i4 &= -29360129;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    i10 = i9;
                                    navigationRailItemColorsM17250colorszjMxDiM = navigationRailItemColors;
                                }
                                if (i10 == 0) {
                                    composer2.startReplaceableGroup(-492369756);
                                    Object objRememberedValue2 = composer2.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    composer2.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                z6 = z4;
                                function23 = function22;
                                composer2 = composerStartRestartGroup;
                                navigationRailItemColorsM17250colorszjMxDiM = navigationRailItemColors;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1533971045, i4, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:160)");
                            }
                            final int i12 = i4;
                            final boolean z9 = z5;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                            final NavigationRailItemColors navigationRailItemColors3 = navigationRailItemColorsM17250colorszjMxDiM;
                            function22 = function24;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
                                private static final long m17258invoke$lambda0(State<Color> state) {
                                    return state.getValue().m18535unboximpl();
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i13) {
                                    if ((i13 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1023357515, i13, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:171)");
                                    }
                                    NavigationRailItemColors navigationRailItemColors4 = navigationRailItemColors3;
                                    boolean z10 = z;
                                    int i14 = i12;
                                    State<Color> stateIconColor$material3_release = navigationRailItemColors4.iconColor$material3_release(z10, composer5, ((i14 >> 18) & 112) | (i14 & 14));
                                    Modifier modifierClearAndSetSemantics = (function24 == null || !(z9 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver clearAndSetSemantics) {
                                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function25 = icon;
                                    int i15 = i12;
                                    composer5.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer5, 0, -1323940314);
                                    Density density = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierClearAndSetSemantics);
                                    if (composer5.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer5.startReusableNode();
                                    if (composer5.getInserting()) {
                                        composer5.createNode(constructor);
                                    } else {
                                        composer5.useNode();
                                    }
                                    composer5.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer5);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer5, composer5), composer5, 2058660585);
                                    composer5.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer5.startReplaceableGroup(-1892243397);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m17258invoke$lambda0(stateIconColor$material3_release)))}, function25, composer5, ((i15 >> 3) & 112) | 8);
                                    composer5.endReplaceableGroup();
                                    composer5.endReplaceableGroup();
                                    composer5.endReplaceableGroup();
                                    composer5.endNode();
                                    composer5.endReplaceableGroup();
                                    composer5.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            ComposableLambda composableLambda2 = function22 == null ? ComposableLambdaKt.composableLambda(composer2, -105269599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
                                private static final long m17259invoke$lambda0(State<Color> state) {
                                    return state.getValue().m18535unboximpl();
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i13) {
                                    if ((i13 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-105269599, i13, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:181)");
                                    }
                                    final TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer5, 6), NavigationRailTokens.INSTANCE.getLabelTextFont());
                                    NavigationRailItemColors navigationRailItemColors4 = navigationRailItemColors3;
                                    boolean z10 = z;
                                    int i14 = i4;
                                    ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m17259invoke$lambda0(navigationRailItemColors4.textColor$material3_release(z10, composer5, ((i14 >> 18) & 112) | (i14 & 14)))))};
                                    final Function2<Composer, Integer, Unit> function25 = function22;
                                    final int i15 = i4;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer5, -288191647, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer6, int i16) {
                                            if ((i16 & 11) == 2 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-288191647, i16, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous>.<anonymous> (NavigationRail.kt:184)");
                                            }
                                            TextKt.ProvideTextStyle(textStyleFromToken, function25, composer6, (i15 >> 12) & 112);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer5, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : null;
                            boolean z10 = z6;
                            Modifier modifier4 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SelectableKt.m16105selectableO2vRcR0(modifier4, z, mutableInteractionSource3, null, z10, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), NavigationRailItemHeight);
                            float f = NavigationRailItemWidth;
                            Modifier modifierM15906widthInVpY3zN4$default = SizeKt.m15906widthInVpY3zN4$default(modifierM15885height3ABfNKs, f, 0.0f, 2, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                            Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            boolean z11 = z5;
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            ComposableLambda composableLambda3 = composableLambda2;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15906widthInVpY3zN4$default);
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.useNode();
                            } else {
                                composer2.createNode(constructor);
                            }
                            composer2.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(752355157);
                            composer3 = composer2;
                            final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, composer3, 48, 12);
                            int iMo15540roundToPx0680j_4 = ((Density) composer3.consume(CompositionLocalsKt.getLocalDensity())).mo15540roundToPx0680j_4(f);
                            NavigationRailTokens navigationRailTokens = NavigationRailTokens.INSTANCE;
                            jOffset = OffsetKt.Offset((iMo15540roundToPx0680j_4 - r1.mo15540roundToPx0680j_4(navigationRailTokens.m17750getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                            Unit unit = Unit.INSTANCE;
                            Offset offsetM18273boximpl = Offset.m18273boximpl(jOffset);
                            composer3.startReplaceableGroup(511388516);
                            zChanged = composer3.changed(offsetM18273boximpl) | composer3.changed(mutableInteractionSource3);
                            objRememberedValue = composer3.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) objRememberedValue;
                            if (function22 == null) {
                                composer3.startReplaceableGroup(1104516937);
                                shape = ShapesKt.toShape(navigationRailTokens.getActiveIndicatorShape(), composer3, 6);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(1104517018);
                                shape = ShapesKt.toShape(navigationRailTokens.getNoLabelActiveIndicatorShape(), composer3, 6);
                                composer3.endReplaceableGroup();
                            }
                            NavigationRailItemBaselineLayout(ComposableLambdaKt.composableLambda(composer3, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i13) {
                                    if ((i13 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(211026382, i13, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:230)");
                                    }
                                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), shape), mappedInteractionSource, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer5, 0, 7)), composer5, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), ComposableLambdaKt.composableLambda(composer3, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i13) {
                                    if ((i13 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1862011490, i13, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                                    }
                                    BoxKt.Box(BackgroundKt.m15408backgroundbw27NRU(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator"), Color.m18524copywmQWz5c$default(navigationRailItemColors3.getIndicatorColor(composer5, (i4 >> 21) & 14), NavigationRailKt.m17252NavigationRailItem$lambda5$lambda2(stateAnimateFloatAsState), 0.0f, 0.0f, 0.0f, 14, null), shape), composer5, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composableLambda, composableLambda3, z11, m17252NavigationRailItem$lambda5$lambda2(stateAnimateFloatAsState), composer3, ((i4 >> 6) & 57344) | 438);
                            if (AbstractC1038a.m1225z(composer3)) {
                                ComposerKt.traceEventEnd();
                            }
                            composer4 = composer3;
                            navigationRailItemColors2 = navigationRailItemColors3;
                            modifier3 = modifier4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            z7 = z11;
                            z8 = z10;
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                        scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItem.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer5, int i13) {
                                NavigationRailKt.NavigationRailItem(z, onClick, icon, modifier3, z8, function25, z7, navigationRailItemColors2, mutableInteractionSource4, composer5, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 100663296;
                    i9 = i8;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i4 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                            if (i10 == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final int i122 = i4;
                            final boolean z92 = z5;
                            final Function2<? super Composer, ? super Integer, Unit> function242 = function23;
                            final NavigationRailItemColors navigationRailItemColors32 = navigationRailItemColorsM17250colorszjMxDiM;
                            function22 = function242;
                            ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer2, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
                                private static final long m17258invoke$lambda0(State<Color> state) {
                                    return state.getValue().m18535unboximpl();
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i13) {
                                    if ((i13 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1023357515, i13, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:171)");
                                    }
                                    NavigationRailItemColors navigationRailItemColors4 = navigationRailItemColors32;
                                    boolean z102 = z;
                                    int i14 = i122;
                                    State<Color> stateIconColor$material3_release = navigationRailItemColors4.iconColor$material3_release(z102, composer5, ((i14 >> 18) & 112) | (i14 & 14));
                                    Modifier modifierClearAndSetSemantics = (function242 == null || !(z92 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver clearAndSetSemantics) {
                                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function252 = icon;
                                    int i15 = i122;
                                    composer5.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer5, 0, -1323940314);
                                    Density density2 = (Density) composer5.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierClearAndSetSemantics);
                                    if (composer5.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer5.startReusableNode();
                                    if (composer5.getInserting()) {
                                        composer5.createNode(constructor2);
                                    } else {
                                        composer5.useNode();
                                    }
                                    composer5.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer5);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer5, composer5), composer5, 2058660585);
                                    composer5.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                    composer5.startReplaceableGroup(-1892243397);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m17258invoke$lambda0(stateIconColor$material3_release)))}, function252, composer5, ((i15 >> 3) & 112) | 8);
                                    composer5.endReplaceableGroup();
                                    composer5.endReplaceableGroup();
                                    composer5.endReplaceableGroup();
                                    composer5.endNode();
                                    composer5.endReplaceableGroup();
                                    composer5.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            if (function22 == null) {
                            }
                            boolean z102 = z6;
                            Modifier modifier42 = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            Modifier modifierM15885height3ABfNKs2 = SizeKt.m15885height3ABfNKs(SelectableKt.m16105selectableO2vRcR0(modifier42, z, mutableInteractionSource3, null, z102, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), NavigationRailItemHeight);
                            float f4 = NavigationRailItemWidth;
                            Modifier modifierM15906widthInVpY3zN4$default2 = SizeKt.m15906widthInVpY3zN4$default(modifierM15885height3ABfNKs2, f4, 0.0f, 2, null);
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
                            Density density2 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            boolean z112 = z5;
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                            ComposableLambda composableLambda32 = composableLambda2;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15906widthInVpY3zN4$default2);
                            if (composer2.getApplier() == null) {
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                            }
                            composer2.disableReusing();
                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl2, density2));
                            AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(752355157);
                            composer3 = composer2;
                            final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, composer3, 48, 12);
                            int iMo15540roundToPx0680j_42 = ((Density) composer3.consume(CompositionLocalsKt.getLocalDensity())).mo15540roundToPx0680j_4(f4);
                            NavigationRailTokens navigationRailTokens2 = NavigationRailTokens.INSTANCE;
                            jOffset = OffsetKt.Offset((iMo15540roundToPx0680j_42 - r1.mo15540roundToPx0680j_4(navigationRailTokens2.m17750getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                            Unit unit2 = Unit.INSTANCE;
                            Offset offsetM18273boximpl2 = Offset.m18273boximpl(jOffset);
                            composer3.startReplaceableGroup(511388516);
                            zChanged = composer3.changed(offsetM18273boximpl2) | composer3.changed(mutableInteractionSource3);
                            objRememberedValue = composer3.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                                composer3.updateRememberedValue(objRememberedValue);
                                composer3.endReplaceableGroup();
                                final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) objRememberedValue;
                                if (function22 == null) {
                                }
                                NavigationRailItemBaselineLayout(ComposableLambdaKt.composableLambda(composer3, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer5, int i13) {
                                        if ((i13 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(211026382, i13, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:230)");
                                        }
                                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), shape), mappedInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer5, 0, 7)), composer5, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), ComposableLambdaKt.composableLambda(composer3, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer5, int i13) {
                                        if ((i13 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1862011490, i13, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                                        }
                                        BoxKt.Box(BackgroundKt.m15408backgroundbw27NRU(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator"), Color.m18524copywmQWz5c$default(navigationRailItemColors32.getIndicatorColor(composer5, (i4 >> 21) & 14), NavigationRailKt.m17252NavigationRailItem$lambda5$lambda2(stateAnimateFloatAsState2), 0.0f, 0.0f, 0.0f, 14, null), shape), composer5, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composableLambda4, composableLambda32, z112, m17252NavigationRailItem$lambda5$lambda2(stateAnimateFloatAsState2), composer3, ((i4 >> 6) & 57344) | 438);
                                if (AbstractC1038a.m1225z(composer3)) {
                                }
                                composer4 = composer3;
                                navigationRailItemColors2 = navigationRailItemColors32;
                                modifier3 = modifier42;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                z7 = z112;
                                z8 = z102;
                            }
                        }
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function252 = function22;
                    scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function22 = function2;
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i4 & 191739611) == 38347922) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function2522 = function22;
                scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            function22 = function2;
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i4 & 191739611) == 38347922) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function25222 = function22;
            scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        z4 = z2;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        function22 = function2;
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i4 & 191739611) == 38347922) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function252222 = function22;
        scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: NavigationRailItem$lambda-5$lambda-2, reason: not valid java name */
    public static final float m17252NavigationRailItem$lambda5$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationRailItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-876426901);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function23) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function24) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876426901, i2, -1, "androidx.compose.material3.NavigationRailItemBaselineLayout (NavigationRail.kt:381)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItemBaselineLayout.2
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j) {
                    Placeable placeableMo19855measureBRTryo0;
                    Object next;
                    MeasureScope Layout = measureScope;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    for (Measurable measurable : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                            long j2 = j;
                            Placeable placeableMo19855measureBRTryo02 = measurable.mo19855measureBRTryo0(j2);
                            float f4 = 2;
                            int iMo15540roundToPx0680j_4 = Layout.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(NavigationRailKt.IndicatorHorizontalPadding * f4)) + placeableMo19855measureBRTryo02.getWidth();
                            int iRoundToInt = MathKt.roundToInt(iMo15540roundToPx0680j_4 * f);
                            int iMo15540roundToPx0680j_42 = Layout.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl((function24 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * f4)) + placeableMo19855measureBRTryo02.getHeight();
                            for (Measurable measurable2 : list) {
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), NavigationRailKt.IndicatorRippleLayoutIdTag)) {
                                    Placeable placeableMo19855measureBRTryo03 = measurable2.mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_42));
                                    Iterator<T> it = list.iterator();
                                    while (true) {
                                        placeableMo19855measureBRTryo0 = null;
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next), NavigationRailKt.IndicatorLayoutIdTag)) {
                                            break;
                                        }
                                    }
                                    Measurable measurable3 = (Measurable) next;
                                    Placeable placeableMo19855measureBRTryo04 = measurable3 != null ? measurable3.mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(iRoundToInt, iMo15540roundToPx0680j_42)) : null;
                                    if (function24 != null) {
                                        for (Measurable measurable4 : list) {
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "label")) {
                                                placeableMo19855measureBRTryo0 = measurable4.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j2, 0, 0, 0, 0, 11, null));
                                            } else {
                                                j2 = j;
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    if (function24 == null) {
                                        return NavigationRailKt.m17256placeIconX9ElhV4(Layout, placeableMo19855measureBRTryo02, placeableMo19855measureBRTryo03, placeableMo19855measureBRTryo04, j);
                                    }
                                    Intrinsics.checkNotNull(placeableMo19855measureBRTryo0);
                                    return NavigationRailKt.m17257placeLabelAndIconzUg2_y0(measureScope, placeableMo19855measureBRTryo0, placeableMo19855measureBRTryo02, placeableMo19855measureBRTryo03, placeableMo19855measureBRTryo04, j, z, f);
                                }
                                Layout = measureScope;
                                j2 = j;
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        Layout = measureScope;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.INSTANCE;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion2.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(2083574754);
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.startReplaceableGroup(935754904);
            if (f > 0.0f) {
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "icon");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierLayoutId);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1582262808);
            AbstractC1038a.m1222w(composerStartRestartGroup, (i2 >> 6) & 14, function23);
            if (function24 != null) {
                Modifier modifierAlpha = AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), z ? 1.0f : f);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierAlpha);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 6101178);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i2 >> 9) & 14, function24);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItemBaselineLayout.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                NavigationRailKt.NavigationRailItemBaselineLayout(function2, function22, function23, function24, z, f, composer2, i | 1);
            }
        });
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m17256placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int iM20938constrainWidthK40F9xA = ConstraintsKt.m20938constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        final int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        final int iM1205f = AbstractC1038a.m1205f(placeable, iM20938constrainWidthK40F9xA, 2);
        final int iM1197B = AbstractC1038a.m1197B(placeable, iM20920getMaxHeightimpl, 2);
        final int iM1205f2 = AbstractC1038a.m1205f(placeable2, iM20938constrainWidthK40F9xA, 2);
        final int iM1197B2 = AbstractC1038a.m1197B(placeable2, iM20920getMaxHeightimpl, 2);
        return MeasureScope.layout$default(measureScope, iM20938constrainWidthK40F9xA, iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable placeable4 = placeable3;
                if (placeable4 != null) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable4, AbstractC1038a.m1205f(placeable4, iM20938constrainWidthK40F9xA, 2), AbstractC1038a.m1197B(placeable4, iM20920getMaxHeightimpl, 2), 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable, iM1205f, iM1197B, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM1205f2, iM1197B2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m17257placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        int height = iM20920getMaxHeightimpl - placeable.getHeight();
        float f4 = NavigationRailItemVerticalPadding;
        final int iMo15540roundToPx0680j_4 = height - measureScope.mo15540roundToPx0680j_4(f4);
        final int iMo15540roundToPx0680j_42 = measureScope.mo15540roundToPx0680j_4(f4);
        final int iRoundToInt = MathKt.roundToInt((1 - f) * ((z ? iMo15540roundToPx0680j_42 : AbstractC1038a.m1197B(placeable2, iM20920getMaxHeightimpl, 2)) - iMo15540roundToPx0680j_42));
        final int iM20938constrainWidthK40F9xA = ConstraintsKt.m20938constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        final int iM1205f = AbstractC1038a.m1205f(placeable, iM20938constrainWidthK40F9xA, 2);
        final int iM1205f2 = AbstractC1038a.m1205f(placeable2, iM20938constrainWidthK40F9xA, 2);
        final int iM1205f3 = AbstractC1038a.m1205f(placeable3, iM20938constrainWidthK40F9xA, 2);
        final int iMo15540roundToPx0680j_43 = iMo15540roundToPx0680j_42 - measureScope.mo15540roundToPx0680j_4(IndicatorVerticalPaddingWithLabel);
        return MeasureScope.layout$default(measureScope, iM20938constrainWidthK40F9xA, iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable placeable5 = placeable4;
                if (placeable5 != null) {
                    int i = iM20938constrainWidthK40F9xA;
                    int i2 = iMo15540roundToPx0680j_42;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.placeRelative$default(layout, placeable5, AbstractC1038a.m1205f(placeable5, i, 2), (i2 - measureScope2.mo15540roundToPx0680j_4(NavigationRailKt.IndicatorVerticalPaddingWithLabel)) + iRoundToInt, 0.0f, 4, null);
                }
                if (z || f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, iM1205f, iMo15540roundToPx0680j_4 + iRoundToInt, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM1205f2, iMo15540roundToPx0680j_42 + iRoundToInt, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(layout, placeable3, iM1205f3, iMo15540roundToPx0680j_43 + iRoundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
