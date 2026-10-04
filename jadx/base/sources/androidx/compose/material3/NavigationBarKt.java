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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.AlphaKt;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.OnRemeasuredModifierKt;
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
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
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
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ae\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ak\u0010#\u001a\u00020\u00132\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0003¢\u0006\u0002\u0010-\u001a\u0083\u0001\u0010.\u001a\u00020\u0013*\u00020\u001e2\u0006\u0010/\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130%2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020*2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001a;\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aS\u0010B\u001a\u000208*\u0002092\u0006\u0010C\u001a\u00020;2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\r\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, m13886d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarItemVerticalPadding", "getNavigationBarItemVerticalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemBaselineLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, "Lkotlin/Function0;", NavigationBarKt.IndicatorLayoutIdTag, "icon", "label", "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NavigationBarKt {

    @NotNull
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;

    @NotNull
    private static final String IndicatorLayoutIdTag = "indicator";

    @NotNull
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset;
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;

    @NotNull
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight;
    private static final float NavigationBarItemHorizontalPadding;
    private static final float NavigationBarItemVerticalPadding;

    static {
        NavigationBarTokens navigationBarTokens = NavigationBarTokens.INSTANCE;
        NavigationBarHeight = navigationBarTokens.m17741getContainerHeightD9Ej5fM();
        NavigationBarItemHorizontalPadding = C2256Dp.m20968constructorimpl(8);
        NavigationBarItemVerticalPadding = C2256Dp.m20968constructorimpl(16);
        float f = 2;
        IndicatorHorizontalPadding = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(navigationBarTokens.m17739getActiveIndicatorWidthD9Ej5fM() - navigationBarTokens.m17742getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(navigationBarTokens.m17738getActiveIndicatorHeightD9Ej5fM() - navigationBarTokens.m17742getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalOffset = C2256Dp.m20968constructorimpl(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17226NavigationBarHsRjFd4(@Nullable Modifier modifier, long j, long j2, float f, @Nullable WindowInsets windowInsets, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        long containerColor;
        long jM17097contentColorFor4WTKRHQ;
        float fM17223getElevationD9Ej5fM;
        WindowInsets windowInsets2;
        float f4;
        final WindowInsets windowInsets3;
        long j3;
        long j5;
        Modifier modifier3;
        Composer composer2;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long j6;
        final long j7;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1596802123);
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
            jM17097contentColorFor4WTKRHQ = j2;
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM17097contentColorFor4WTKRHQ)) ? 256 : 128;
        } else {
            jM17097contentColorFor4WTKRHQ = j2;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                fM17223getElevationD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM17223getElevationD9Ej5fM) ? 2048 : 1024;
            }
            if ((i & 57344) != 0) {
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
                    j6 = containerColor;
                    j7 = jM17097contentColorFor4WTKRHQ;
                    f5 = fM17223getElevationD9Ej5fM;
                    windowInsets4 = windowInsets2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                        }
                        if ((i2 & 4) != 0) {
                            jM17097contentColorFor4WTKRHQ = ColorSchemeKt.m17097contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                            i4 &= -897;
                        }
                        if (i8 != 0) {
                            fM17223getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m17223getElevationD9Ej5fM();
                        }
                        if ((i2 & 16) == 0) {
                            windowInsets3 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -57345;
                            j5 = jM17097contentColorFor4WTKRHQ;
                            f4 = fM17223getElevationD9Ej5fM;
                            modifier3 = modifier5;
                        } else {
                            f4 = fM17223getElevationD9Ej5fM;
                            windowInsets3 = windowInsets2;
                            j3 = containerColor;
                            j5 = jM17097contentColorFor4WTKRHQ;
                            modifier3 = modifier5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1596802123, i4, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:98)");
                            }
                            int i10 = i4 << 3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m17325SurfaceT9BRK9s(modifier3, null, j3, j5, f4, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                                public final void invoke(@Nullable Composer composer3, int i11) {
                                    if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(105663120, i11, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:111)");
                                    }
                                    Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m15885height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets3), NavigationBarKt.NavigationBarHeight));
                                    Arrangement.HorizontalOrVertical horizontalOrVerticalM15734spacedBy0680j_4 = Arrangement.INSTANCE.m15734spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                                    Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                    int i12 = ((i4 >> 6) & 7168) | 48;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM15734spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer3, 6);
                                    composer3.startReplaceableGroup(-1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i12 >> 6) & 112) | 6));
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 12582912 | (i4 & 14) | (i10 & 896) | (i10 & 7168) | (i10 & 57344), 98);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets4 = windowInsets3;
                            modifier4 = modifier3;
                            j6 = j3;
                            j7 = j5;
                            f5 = f4;
                        }
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
                        long j8 = jM17097contentColorFor4WTKRHQ;
                        modifier3 = modifier2;
                        windowInsets3 = windowInsets2;
                        j5 = j8;
                        f4 = fM17223getElevationD9Ej5fM;
                    }
                    j3 = containerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i102 = i4 << 3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m17325SurfaceT9BRK9s(modifier3, null, j3, j5, f4, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                        public final void invoke(@Nullable Composer composer3, int i11) {
                            if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(105663120, i11, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:111)");
                            }
                            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m15885height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets3), NavigationBarKt.NavigationBarHeight));
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM15734spacedBy0680j_4 = Arrangement.INSTANCE.m15734spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                            Function3<RowScope, Composer, Integer, Unit> function3 = content;
                            int i12 = ((i4 >> 6) & 7168) | 48;
                            composer3.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM15734spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer3, 6);
                            composer3.startReplaceableGroup(-1323940314);
                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                            composer3.startReplaceableGroup(-678309503);
                            function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i12 >> 6) & 112) | 6));
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 12582912 | (i4 & 14) | (i102 & 896) | (i102 & 7168) | (i102 & 57344), 98);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    windowInsets4 = windowInsets3;
                    modifier4 = modifier3;
                    j6 = j3;
                    j7 = j5;
                    f5 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$2
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

                    public final void invoke(@Nullable Composer composer3, int i11) {
                        NavigationBarKt.m17226NavigationBarHsRjFd4(modifier4, j6, j7, f5, windowInsets4, content, composer3, i | 1, i2);
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
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        fM17223getElevationD9Ej5fM = f;
        if ((i & 57344) != 0) {
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0126  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationBarItem(@NotNull final RowScope rowScope, final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> icon, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, boolean z3, @Nullable NavigationBarItemColors navigationBarItemColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        int i7;
        boolean z5;
        final NavigationBarItemColors navigationBarItemColorsM17225colorszjMxDiM;
        int i8;
        int i9;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composer2;
        int i10;
        boolean z7;
        Object objRememberedValue;
        Composer.Companion companion;
        Modifier modifier4;
        final MutableState mutableState;
        MutableInteractionSource mutableInteractionSource3;
        boolean zChanged;
        Object objRememberedValue2;
        long jOffset;
        boolean zChanged2;
        Object objRememberedValue3;
        Composer composer3;
        final NavigationBarItemColors navigationBarItemColors2;
        final boolean z8;
        final boolean z9;
        final Modifier modifier5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-663510974);
        if ((Integer.MIN_VALUE & i2) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 2) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 256 : 128;
        }
        if ((i2 & 4) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(icon) ? 2048 : 1024;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i4 |= 24576;
        } else {
            if ((i & 57344) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 196608;
            } else {
                if ((458752 & i) == 0) {
                    z4 = z2;
                    i4 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i4 |= composerStartRestartGroup.changed(function2) ? 1048576 : 524288;
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                    i4 |= 12582912;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 29360128) == 0) {
                        i4 |= composerStartRestartGroup.changed(z5) ? 8388608 : 4194304;
                    }
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        navigationBarItemColorsM17225colorszjMxDiM = navigationBarItemColors;
                        int i12 = composerStartRestartGroup.changed(navigationBarItemColorsM17225colorszjMxDiM) ? 67108864 : 33554432;
                        i4 |= i12;
                    } else {
                        navigationBarItemColorsM17225colorszjMxDiM = navigationBarItemColors;
                    }
                    i4 |= i12;
                } else {
                    navigationBarItemColorsM17225colorszjMxDiM = navigationBarItemColors;
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                    if ((i & 1879048192) == 0) {
                        i9 = i8;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                    }
                    if ((i4 & 1533916891) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                            z6 = i5 == 0 ? true : z4;
                            function22 = i6 == 0 ? null : function2;
                            if (i7 != 0) {
                                z5 = true;
                            }
                            if ((i2 & 128) == 0) {
                                i10 = i9;
                                navigationBarItemColorsM17225colorszjMxDiM = NavigationBarItemDefaults.INSTANCE.m17225colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 196608, 31);
                                composer2 = composerStartRestartGroup;
                                i4 &= -234881025;
                            } else {
                                composer2 = composerStartRestartGroup;
                                i10 = i9;
                            }
                            if (i10 == 0) {
                                composer2.startReplaceableGroup(-492369756);
                                Object objRememberedValue4 = composer2.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue4);
                                }
                                composer2.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue4;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            z7 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 128) != 0) {
                                i4 &= -234881025;
                            }
                            function22 = function2;
                            z7 = z5;
                            modifier3 = modifier2;
                            z6 = z4;
                            composer2 = composerStartRestartGroup;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-663510974, i4, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:159)");
                        }
                        final NavigationBarItemColors navigationBarItemColors3 = navigationBarItemColorsM17225colorszjMxDiM;
                        final int i13 = i4;
                        final boolean z10 = z7;
                        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
                            private static final long m17237invoke$lambda0(State<Color> state) {
                                return state.getValue().m18535unboximpl();
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer4, int i14) {
                                if ((i14 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1419576100, i14, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:170)");
                                }
                                NavigationBarItemColors navigationBarItemColors4 = navigationBarItemColors3;
                                boolean z11 = z;
                                int i15 = i13;
                                State<Color> stateIconColor$material3_release = navigationBarItemColors4.iconColor$material3_release(z11, composer4, ((i15 >> 21) & 112) | ((i15 >> 3) & 14));
                                Modifier modifierClearAndSetSemantics = (function24 == null || !(z10 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                                int i16 = i13;
                                composer4.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer4, 0, -1323940314);
                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierClearAndSetSemantics);
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                composer4.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                composer4.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer4.startReplaceableGroup(2060475106);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m17237invoke$lambda0(stateIconColor$material3_release)))}, function25, composer4, ((i16 >> 6) & 112) | 8);
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        ComposableLambda composableLambda2 = function24 == null ? ComposableLambdaKt.composableLambda(composer2, 1644987592, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
                            private static final long m17238invoke$lambda0(State<Color> state) {
                                return state.getValue().m18535unboximpl();
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer4, int i14) {
                                if ((i14 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1644987592, i14, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:180)");
                                }
                                final TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer4, 6), NavigationBarTokens.INSTANCE.getLabelTextFont());
                                NavigationBarItemColors navigationBarItemColors4 = navigationBarItemColorsM17225colorszjMxDiM;
                                boolean z11 = z;
                                int i15 = i4;
                                ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m17238invoke$lambda0(navigationBarItemColors4.textColor$material3_release(z11, composer4, ((i15 >> 21) & 112) | ((i15 >> 3) & 14)))))};
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final int i16 = i4;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer4, 2061683080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1.1
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

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer5, int i17) {
                                        if ((i17 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2061683080, i17, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous>.<anonymous> (NavigationBar.kt:183)");
                                        }
                                        TextKt.ProvideTextStyle(textStyleFromToken, function25, composer5, (i16 >> 15) & 112);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer4, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        composer2.startReplaceableGroup(-492369756);
                        objRememberedValue = composer2.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue != companion.getEmpty()) {
                            modifier4 = modifier3;
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            modifier4 = modifier3;
                        }
                        composer2.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        Modifier modifier6 = modifier4;
                        Modifier modifierWeight$default = RowScope.weight$default(rowScope, SelectableKt.m16105selectableO2vRcR0(modifier4, z, mutableInteractionSource3, null, z6, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        composer2.startReplaceableGroup(1157296644);
                        zChanged = composer2.changed(mutableState);
                        objRememberedValue2 = composer2.rememberedValue();
                        if (!zChanged || objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m17236invokeozmzZPI(intSize.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m17236invokeozmzZPI(long j) {
                                    NavigationBarKt.m17228NavigationBarItem$lambda4(mutableState, IntSize.m21138getWidthimpl(j));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default, (Function1) objRememberedValue2);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        int i14 = i4;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierOnSizeChanged);
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
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(1796243068);
                        final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, composer2, 48, 12);
                        jOffset = OffsetKt.Offset((m17227NavigationBarItem$lambda3(mutableState) - r1.mo15540roundToPx0680j_4(NavigationBarTokens.INSTANCE.m17739getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(IndicatorVerticalOffset));
                        Unit unit = Unit.INSTANCE;
                        Offset offsetM18273boximpl = Offset.m18273boximpl(jOffset);
                        composer2.startReplaceableGroup(511388516);
                        zChanged2 = composer2.changed(offsetM18273boximpl) | composer2.changed(mutableInteractionSource3);
                        objRememberedValue3 = composer2.rememberedValue();
                        if (!zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) objRememberedValue3;
                        Composer composer4 = composer2;
                        NavigationBarItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
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
                            public final void invoke(@Nullable Composer composer5, int i15) {
                                if ((i15 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(691730997, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:229)");
                                }
                                BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.toShape(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer5, 6)), mappedInteractionSource, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer5, 0, 7)), composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), ComposableLambdaKt.composableLambda(composer2, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
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
                            public final void invoke(@Nullable Composer composer5, int i15) {
                                if ((i15 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-474426875, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:237)");
                                }
                                BoxKt.Box(BackgroundKt.m15408backgroundbw27NRU(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator"), Color.m18524copywmQWz5c$default(navigationBarItemColorsM17225colorszjMxDiM.getSelectedIndicatorColor(), NavigationBarKt.m17229NavigationBarItem$lambda9$lambda6(stateAnimateFloatAsState), 0.0f, 0.0f, 0.0f, 14, null), ShapesKt.toShape(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer5, 6)), composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composableLambda, composableLambda2, z7, m17229NavigationBarItem$lambda9$lambda6(stateAnimateFloatAsState), composer4, ((i14 >> 9) & 57344) | 438);
                        composer3 = composer4;
                        if (AbstractC1038a.m1225z(composer3)) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationBarItemColors2 = navigationBarItemColorsM17225colorszjMxDiM;
                        z8 = z6;
                        z9 = z7;
                        modifier5 = modifier6;
                        function23 = function24;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z9 = z5;
                        modifier5 = modifier2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        navigationBarItemColors2 = navigationBarItemColorsM17225colorszjMxDiM;
                        composer3 = composerStartRestartGroup;
                        z8 = z4;
                        function23 = function2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt.NavigationBarItem.4
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

                        public final void invoke(@Nullable Composer composer5, int i15) {
                            NavigationBarKt.NavigationBarItem(rowScope, z, onClick, icon, modifier5, z8, function23, z9, navigationBarItemColors2, mutableInteractionSource4, composer5, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= DriveFile.MODE_READ_WRITE;
                i9 = i8;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 == 0) {
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
                        z7 = z5;
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final NavigationBarItemColors navigationBarItemColors32 = navigationBarItemColorsM17225colorszjMxDiM;
                        final int i132 = i4;
                        final boolean z102 = z7;
                        final Function2<? super Composer, ? super Integer, Unit> function242 = function22;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer2, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
                            private static final long m17237invoke$lambda0(State<Color> state) {
                                return state.getValue().m18535unboximpl();
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer42, Integer num) {
                                invoke(composer42, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer42, int i142) {
                                if ((i142 & 11) == 2 && composer42.getSkipping()) {
                                    composer42.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1419576100, i142, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:170)");
                                }
                                NavigationBarItemColors navigationBarItemColors4 = navigationBarItemColors32;
                                boolean z11 = z;
                                int i15 = i132;
                                State<Color> stateIconColor$material3_release = navigationBarItemColors4.iconColor$material3_release(z11, composer42, ((i15 >> 21) & 112) | ((i15 >> 3) & 14));
                                Modifier modifierClearAndSetSemantics = (function242 == null || !(z102 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                                int i16 = i132;
                                composer42.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer42, 0, -1323940314);
                                Density density2 = (Density) composer42.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer42.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer42.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierClearAndSetSemantics);
                                if (composer42.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer42.startReusableNode();
                                if (composer42.getInserting()) {
                                    composer42.createNode(constructor2);
                                } else {
                                    composer42.useNode();
                                }
                                composer42.disableReusing();
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer42);
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion22, composerM18018constructorimpl2, viewConfiguration2, composer42, composer42), composer42, 2058660585);
                                composer42.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                composer42.startReplaceableGroup(2060475106);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m17237invoke$lambda0(stateIconColor$material3_release)))}, function25, composer42, ((i16 >> 6) & 112) | 8);
                                composer42.endReplaceableGroup();
                                composer42.endReplaceableGroup();
                                composer42.endReplaceableGroup();
                                composer42.endNode();
                                composer42.endReplaceableGroup();
                                composer42.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        if (function242 == null) {
                        }
                        composer2.startReplaceableGroup(-492369756);
                        objRememberedValue = composer2.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue != companion.getEmpty()) {
                        }
                        composer2.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        Modifier modifier62 = modifier4;
                        Modifier modifierWeight$default2 = RowScope.weight$default(rowScope, SelectableKt.m16105selectableO2vRcR0(modifier4, z, mutableInteractionSource3, null, z6, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        composer2.startReplaceableGroup(1157296644);
                        zChanged = composer2.changed(mutableState);
                        objRememberedValue2 = composer2.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m17236invokeozmzZPI(intSize.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m17236invokeozmzZPI(long j) {
                                    NavigationBarKt.m17228NavigationBarItem$lambda4(mutableState, IntSize.m21138getWidthimpl(j));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                            composer2.endReplaceableGroup();
                            Modifier modifierOnSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default2, (Function1) objRememberedValue2);
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
                            Density density2 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                            int i142 = i4;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierOnSizeChanged2);
                            if (composer2.getApplier() == null) {
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                            }
                            composer2.disableReusing();
                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl2, density2));
                            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion22, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(1796243068);
                            final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, composer2, 48, 12);
                            jOffset = OffsetKt.Offset((m17227NavigationBarItem$lambda3(mutableState) - r1.mo15540roundToPx0680j_4(NavigationBarTokens.INSTANCE.m17739getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(IndicatorVerticalOffset));
                            Unit unit2 = Unit.INSTANCE;
                            Offset offsetM18273boximpl2 = Offset.m18273boximpl(jOffset);
                            composer2.startReplaceableGroup(511388516);
                            zChanged2 = composer2.changed(offsetM18273boximpl2) | composer2.changed(mutableInteractionSource3);
                            objRememberedValue3 = composer2.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, jOffset, null);
                                composer2.updateRememberedValue(objRememberedValue3);
                                composer2.endReplaceableGroup();
                                final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) objRememberedValue3;
                                Composer composer42 = composer2;
                                NavigationBarItemBaselineLayout(ComposableLambdaKt.composableLambda(composer2, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
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
                                    public final void invoke(@Nullable Composer composer5, int i15) {
                                        if ((i15 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(691730997, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:229)");
                                        }
                                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.toShape(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer5, 6)), mappedInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer5, 0, 7)), composer5, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), ComposableLambdaKt.composableLambda(composer2, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
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
                                    public final void invoke(@Nullable Composer composer5, int i15) {
                                        if ((i15 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-474426875, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:237)");
                                        }
                                        BoxKt.Box(BackgroundKt.m15408backgroundbw27NRU(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator"), Color.m18524copywmQWz5c$default(navigationBarItemColorsM17225colorszjMxDiM.getSelectedIndicatorColor(), NavigationBarKt.m17229NavigationBarItem$lambda9$lambda6(stateAnimateFloatAsState2), 0.0f, 0.0f, 0.0f, 14, null), ShapesKt.toShape(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer5, 6)), composer5, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composableLambda3, composableLambda2, z7, m17229NavigationBarItem$lambda9$lambda6(stateAnimateFloatAsState2), composer42, ((i142 >> 9) & 57344) | 438);
                                composer3 = composer42;
                                if (AbstractC1038a.m1225z(composer3)) {
                                }
                                navigationBarItemColors2 = navigationBarItemColorsM17225colorszjMxDiM;
                                z8 = z6;
                                z9 = z7;
                                modifier5 = modifier62;
                                function23 = function242;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if ((i & 234881024) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i4 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
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
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if ((i & 234881024) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i4 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: NavigationBarItem$lambda-3, reason: not valid java name */
    private static final int m17227NavigationBarItem$lambda3(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: NavigationBarItem$lambda-4, reason: not valid java name */
    public static final void m17228NavigationBarItem$lambda4(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: NavigationBarItem$lambda-9$lambda-6, reason: not valid java name */
    public static final float m17229NavigationBarItem$lambda9$lambda6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationBarItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(591111291);
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
                ComposerKt.traceEventStart(591111291, i2, -1, "androidx.compose.material3.NavigationBarItemBaselineLayout (NavigationBar.kt:381)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt.NavigationBarItemBaselineLayout.2
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
                            int iMo15540roundToPx0680j_4 = Layout.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(NavigationBarKt.IndicatorHorizontalPadding * f4)) + placeableMo19855measureBRTryo02.getWidth();
                            int iRoundToInt = MathKt.roundToInt(iMo15540roundToPx0680j_4 * f);
                            int iMo15540roundToPx0680j_42 = Layout.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(NavigationBarKt.IndicatorVerticalPadding * f4)) + placeableMo19855measureBRTryo02.getHeight();
                            for (Measurable measurable2 : list) {
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), NavigationBarKt.IndicatorRippleLayoutIdTag)) {
                                    Placeable placeableMo19855measureBRTryo03 = measurable2.mo19855measureBRTryo0(Constraints.INSTANCE.m20931fixedJhjzzOo(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_42));
                                    Iterator<T> it = list.iterator();
                                    while (true) {
                                        placeableMo19855measureBRTryo0 = null;
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) next), NavigationBarKt.IndicatorLayoutIdTag)) {
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
                                        return NavigationBarKt.m17234placeIconX9ElhV4(Layout, placeableMo19855measureBRTryo02, placeableMo19855measureBRTryo03, placeableMo19855measureBRTryo04, j);
                                    }
                                    Intrinsics.checkNotNull(placeableMo19855measureBRTryo0);
                                    return NavigationBarKt.m17235placeLabelAndIconzUg2_y0(measureScope, placeableMo19855measureBRTryo0, placeableMo19855measureBRTryo02, placeableMo19855measureBRTryo03, placeableMo19855measureBRTryo04, j, z, f);
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
            composerStartRestartGroup.startReplaceableGroup(1170727090);
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            composerStartRestartGroup.startReplaceableGroup(-311736667);
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
            composerStartRestartGroup.startReplaceableGroup(-1237554120);
            AbstractC1038a.m1222w(composerStartRestartGroup, (i2 >> 6) & 14, function23);
            if (function24 != null) {
                Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), z ? 1.0f : f), C2256Dp.m20968constructorimpl(NavigationBarItemHorizontalPadding / 2), 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
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
                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 359627658);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt.NavigationBarItemBaselineLayout.3
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
                NavigationBarKt.NavigationBarItemBaselineLayout(function2, function22, function23, function24, z, f, composer2, i | 1);
            }
        });
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemVerticalPadding() {
        return NavigationBarItemVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m17234placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
        final int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        final int iM1205f = AbstractC1038a.m1205f(placeable, iM20921getMaxWidthimpl, 2);
        final int iM1197B = AbstractC1038a.m1197B(placeable, iM20920getMaxHeightimpl, 2);
        final int iM1205f2 = AbstractC1038a.m1205f(placeable2, iM20921getMaxWidthimpl, 2);
        final int iM1197B2 = AbstractC1038a.m1197B(placeable2, iM20920getMaxHeightimpl, 2);
        return MeasureScope.layout$default(measureScope, iM20921getMaxWidthimpl, iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
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
                    Placeable.PlacementScope.placeRelative$default(layout, placeable4, AbstractC1038a.m1205f(placeable4, iM20921getMaxWidthimpl, 2), AbstractC1038a.m1197B(placeable4, iM20920getMaxHeightimpl, 2), 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable, iM1205f, iM1197B, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM1205f2, iM1197B2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m17235placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        int height = iM20920getMaxHeightimpl - placeable.getHeight();
        float f4 = NavigationBarItemVerticalPadding;
        final int iMo15540roundToPx0680j_4 = height - measureScope.mo15540roundToPx0680j_4(f4);
        final int iMo15540roundToPx0680j_42 = measureScope.mo15540roundToPx0680j_4(f4);
        final int iRoundToInt = MathKt.roundToInt((1 - f) * ((z ? iMo15540roundToPx0680j_42 : AbstractC1038a.m1197B(placeable2, iM20920getMaxHeightimpl, 2)) - iMo15540roundToPx0680j_42));
        final int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
        final int iM1205f = AbstractC1038a.m1205f(placeable, iM20921getMaxWidthimpl, 2);
        final int iM1205f2 = AbstractC1038a.m1205f(placeable2, iM20921getMaxWidthimpl, 2);
        final int iM1205f3 = AbstractC1038a.m1205f(placeable3, iM20921getMaxWidthimpl, 2);
        final int iMo15540roundToPx0680j_43 = iMo15540roundToPx0680j_42 - measureScope.mo15540roundToPx0680j_4(IndicatorVerticalPadding);
        return MeasureScope.layout$default(measureScope, iM20921getMaxWidthimpl, iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
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
                    int i = iM20921getMaxWidthimpl;
                    int i2 = iMo15540roundToPx0680j_42;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.placeRelative$default(layout, placeable5, AbstractC1038a.m1205f(placeable5, i, 2), (i2 - measureScope2.mo15540roundToPx0680j_4(NavigationBarKt.IndicatorVerticalPadding)) + iRoundToInt, 0.0f, 4, null);
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
