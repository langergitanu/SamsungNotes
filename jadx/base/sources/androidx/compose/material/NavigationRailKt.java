package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
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
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.AlphaKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.layout.AlignmentLineKt;
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
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
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
@Metadata(m13885d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0091\u0001\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u001d2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\u0006\u0010+\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010,\u001aU\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2&\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a)\u00105\u001a\u000206*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u000206*\u0002072\u0006\u0010?\u001a\u0002092\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010+\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, m13886d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NavigationRailKt {
    private static final float HeaderPadding;
    private static final float NavigationRailPadding;

    @NotNull
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float NavigationRailItemSize = C2256Dp.m20968constructorimpl(72);
    private static final float NavigationRailItemCompactSize = C2256Dp.m20968constructorimpl(56);
    private static final float ItemLabelBaselineBottomOffset = C2256Dp.m20968constructorimpl(16);
    private static final float ItemIconTopOffset = C2256Dp.m20968constructorimpl(14);

    static {
        float f = 8;
        NavigationRailPadding = C2256Dp.m20968constructorimpl(f);
        HeaderPadding = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0195 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationRail-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16797NavigationRailHsRjFd4(@Nullable Modifier modifier, long j, long j2, float f, @Nullable Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        long j3;
        long j5;
        float fM16796getElevationD9Ej5fM;
        int i5;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        float f4;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        int i6;
        long j6;
        Modifier modifier3;
        long j7;
        Composer composer2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        final Modifier modifier4;
        final long j8;
        final long j9;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1790971523);
        int i8 = i2 & 1;
        if (i8 != 0) {
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
                j3 = j;
                int i9 = composerStartRestartGroup.changed(j3) ? 32 : 16;
                i4 |= i9;
            } else {
                j3 = j;
            }
            i4 |= i9;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            j5 = j2;
            i4 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(j5)) ? 256 : 128;
        } else {
            j5 = j2;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                fM16796getElevationD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM16796getElevationD9Ej5fM) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((57344 & i) == 0) {
                    function32 = function3;
                    i4 |= composerStartRestartGroup.changed(function32) ? 16384 : 8192;
                }
                if ((i2 & 32) == 0) {
                    i7 = (i & 458752) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                    if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                long jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                j3 = jM16680getSurface0d7_KjU;
                            }
                            if ((i2 & 4) != 0) {
                                long jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(j3, composerStartRestartGroup, (i4 >> 3) & 14);
                                i4 &= -897;
                                j5 = jM16694contentColorForek8zF_U;
                            }
                            if (i10 != 0) {
                                fM16796getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m16796getElevationD9Ej5fM();
                            }
                            if (i5 == 0) {
                                function33 = null;
                                long j10 = j5;
                                modifier3 = modifier5;
                                j7 = j10;
                                f4 = fM16796getElevationD9Ej5fM;
                                i6 = 1790971523;
                                j6 = j3;
                            } else {
                                f4 = fM16796getElevationD9Ej5fM;
                                function33 = function32;
                                i6 = 1790971523;
                                j6 = j3;
                                long j11 = j5;
                                modifier3 = modifier5;
                                j7 = j11;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            f4 = fM16796getElevationD9Ej5fM;
                            function33 = function32;
                            j6 = j3;
                            j7 = j5;
                            modifier3 = modifier2;
                            i6 = 1790971523;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i4, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:92)");
                        }
                        int i11 = i4 << 3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(modifier3, null, j6, j7, null, f4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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
                            public final void invoke(@Nullable Composer composer3, int i12) {
                                if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1571506489, i12, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:105)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function35 = function33;
                                int i13 = i4;
                                Function3<ColumnScope, Composer, Integer, Unit> function36 = content;
                                composer3.startReplaceableGroup(-483455358);
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
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
                                composer3.startReplaceableGroup(-497173955);
                                composer3.startReplaceableGroup(65525382);
                                if (function35 != null) {
                                    function35.invoke(columnScopeInstance, composer3, Integer.valueOf(((i13 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, NavigationRailKt.HeaderPadding), composer3, 6);
                                }
                                composer3.endReplaceableGroup();
                                function36.invoke(columnScopeInstance, composer3, Integer.valueOf(((i13 >> 12) & 112) | 6));
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
                        }), composer2, (i4 & 14) | 1572864 | (i11 & 896) | (i11 & 7168) | ((i4 << 6) & 458752), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function34 = function33;
                        modifier4 = modifier3;
                        j8 = j6;
                        j9 = j7;
                        f5 = f4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier2;
                        j8 = j3;
                        j9 = j5;
                        f5 = fM16796getElevationD9Ej5fM;
                        function34 = function32;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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
                            NavigationRailKt.m16797NavigationRailHsRjFd4(modifier4, j8, j9, f5, function34, content, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i7;
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 == 0) {
                        }
                        if ((i2 & 2) != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i112 = i4 << 3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m16872SurfaceFjzlyU(modifier3, null, j6, j7, null, f4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1571506489, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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
                            public final void invoke(@Nullable Composer composer3, int i12) {
                                if ((i12 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1571506489, i12, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:105)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m15856paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0.0f, NavigationRailKt.NavigationRailPadding, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function35 = function33;
                                int i13 = i4;
                                Function3<ColumnScope, Composer, Integer, Unit> function36 = content;
                                composer3.startReplaceableGroup(-483455358);
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
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
                                composer3.startReplaceableGroup(-497173955);
                                composer3.startReplaceableGroup(65525382);
                                if (function35 != null) {
                                    function35.invoke(columnScopeInstance, composer3, Integer.valueOf(((i13 >> 9) & 112) | 6));
                                    SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion, NavigationRailKt.HeaderPadding), composer3, 6);
                                }
                                composer3.endReplaceableGroup();
                                function36.invoke(columnScopeInstance, composer3, Integer.valueOf(((i13 >> 12) & 112) | 6));
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
                        }), composer2, (i4 & 14) | 1572864 | (i112 & 896) | (i112 & 7168) | ((i4 << 6) & 458752), 18);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function34 = function33;
                        modifier4 = modifier3;
                        j8 = j6;
                        j9 = j7;
                        f5 = f4;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function32 = function3;
            if ((i2 & 32) == 0) {
            }
            i4 |= i7;
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM16796getElevationD9Ej5fM = f;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        if ((i2 & 32) == 0) {
        }
        i4 |= i7;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0340 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: NavigationRailItem-0S3VyRs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16798NavigationRailItem0S3VyRs(final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> icon, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, boolean z3, @Nullable MutableInteractionSource mutableInteractionSource, long j, long j2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        int i7;
        final boolean z5;
        int i8;
        int i9;
        int i10;
        long jM18524copywmQWz5c$default;
        int i11;
        MutableInteractionSource mutableInteractionSource2;
        long jM16676getPrimary0d7_KjU;
        final int i12;
        final MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final long j3;
        final boolean z6;
        final Modifier modifier3;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1813548445);
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
        int i13 = i2 & 8;
        if (i13 != 0) {
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
                if ((57344 & i) == 0) {
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
                    } else {
                        if ((3670016 & i) == 0) {
                            z5 = z3;
                            i4 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 == 0) {
                            if ((i & 29360128) == 0) {
                                i9 = i8;
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                            }
                            if ((i & 234881024) != 0) {
                                i10 = i4 | (((i2 & 256) == 0 && composerStartRestartGroup.changed(j)) ? 67108864 : 33554432);
                            } else {
                                i10 = i4;
                            }
                            if ((i & 1879048192) != 0) {
                                jM18524copywmQWz5c$default = j2;
                                i10 |= ((i2 & 512) == 0 && composerStartRestartGroup.changed(jM18524copywmQWz5c$default)) ? 536870912 : 268435456;
                            } else {
                                jM18524copywmQWz5c$default = j2;
                            }
                            i11 = i10;
                            if ((i11 & 1533916891) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i13 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z4 = true;
                                    }
                                    if (i6 != 0) {
                                        function22 = null;
                                    }
                                    if (i7 != 0) {
                                        z5 = true;
                                    }
                                    if (i9 == 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    if ((i2 & 256) == 0) {
                                        jM16676getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16676getPrimary0d7_KjU();
                                        i12 = i11 & (-234881025);
                                    } else {
                                        jM16676getPrimary0d7_KjU = j;
                                        i12 = i11;
                                    }
                                    if ((i2 & 512) != 0) {
                                        jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                        i12 &= -1879048193;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    int i14 = (i2 & 256) != 0 ? i11 & (-234881025) : i11;
                                    if ((i2 & 512) != 0) {
                                        i14 &= -1879048193;
                                    }
                                    jM16676getPrimary0d7_KjU = j;
                                    i12 = i14;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1813548445, i12, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:146)");
                                }
                                final ComposableLambda composableLambda = function22 == null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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
                                    public final void invoke(@Nullable Composer composer3, int i15) {
                                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-180398615, i15, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:159)");
                                        }
                                        TextKt.ProvideTextStyle(TextStyle.m20465copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m20850boximpl(TextAlign.INSTANCE.m20857getCentere0LSkKk()), null, 0L, null, 245759, null), function22, composer3, (i12 >> 12) & 112);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(SelectableKt.m16105selectableO2vRcR0(modifier2, z, mutableInteractionSource4, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, jM16676getPrimary0d7_KjU, composerStartRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), function22 != null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                composerStartRestartGroup.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                                Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                long j6 = jM18524copywmQWz5c$default;
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Modifier modifier4 = modifier2;
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                if (composerStartRestartGroup.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.useNode();
                                } else {
                                    composerStartRestartGroup.createNode(constructor);
                                }
                                composerStartRestartGroup.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
                                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composerStartRestartGroup.startReplaceableGroup(-172871267);
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                                        invoke(f.floatValue(), composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(float f, @Nullable Composer composer3, int i15) {
                                        int i16;
                                        if ((i15 & 14) == 0) {
                                            i16 = (composer3.changed(f) ? 4 : 2) | i15;
                                        } else {
                                            i16 = i15;
                                        }
                                        if ((i16 & 91) == 18 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(670576792, i15, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:191)");
                                        }
                                        if (z5) {
                                            f = 1.0f;
                                        }
                                        NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda, f, composer3, (i12 >> 6) & 14);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                int i15 = i12 >> 24;
                                m16799NavigationRailTransitionKlgxPg(jM16676getPrimary0d7_KjU, j6, z, composableLambda2, composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 3072 | ((i12 << 6) & 896));
                                if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource3 = mutableInteractionSource4;
                                function23 = function22;
                                composer2 = composerStartRestartGroup;
                                j3 = j6;
                                z6 = z4;
                                modifier3 = modifier4;
                                j5 = jM16676getPrimary0d7_KjU;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                mutableInteractionSource3 = mutableInteractionSource;
                                composer2 = composerStartRestartGroup;
                                function23 = function22;
                                j3 = jM18524copywmQWz5c$default;
                                modifier3 = modifier2;
                                z6 = z4;
                                j5 = j;
                            }
                            final boolean z7 = z5;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                                public final void invoke(@Nullable Composer composer3, int i16) {
                                    NavigationRailKt.m16798NavigationRailItem0S3VyRs(z, onClick, icon, modifier3, z6, function23, z7, mutableInteractionSource3, j5, j3, composer3, i | 1, i2);
                                }
                            });
                            return;
                        }
                        i4 |= 12582912;
                        i9 = i8;
                        if ((i & 234881024) != 0) {
                        }
                        if ((i & 1879048192) != 0) {
                        }
                        i11 = i10;
                        if ((i11 & 1533916891) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i13 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if (i9 == 0) {
                                }
                                if ((i2 & 256) == 0) {
                                }
                                if ((i2 & 512) != 0) {
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (function22 == null) {
                                }
                                MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                Modifier modifierM15899size3ABfNKs2 = SizeKt.m15899size3ABfNKs(SelectableKt.m16105selectableO2vRcR0(modifier2, z, mutableInteractionSource42, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, jM16676getPrimary0d7_KjU, composerStartRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), function22 != null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                                Alignment center2 = Alignment.INSTANCE.getCenter();
                                composerStartRestartGroup.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                                Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                long j62 = jM18524copywmQWz5c$default;
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                Modifier modifier42 = modifier2;
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15899size3ABfNKs2);
                                if (composerStartRestartGroup.getApplier() == null) {
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                composerStartRestartGroup.disableReusing();
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl2, density2));
                                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
                                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                composerStartRestartGroup.startReplaceableGroup(-172871267);
                                ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                                        invoke(f.floatValue(), composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(float f, @Nullable Composer composer3, int i152) {
                                        int i16;
                                        if ((i152 & 14) == 0) {
                                            i16 = (composer3.changed(f) ? 4 : 2) | i152;
                                        } else {
                                            i16 = i152;
                                        }
                                        if ((i16 & 91) == 18 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(670576792, i152, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:191)");
                                        }
                                        if (z5) {
                                            f = 1.0f;
                                        }
                                        NavigationRailKt.NavigationRailItemBaselineLayout(icon, composableLambda, f, composer3, (i12 >> 6) & 14);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                int i152 = i12 >> 24;
                                m16799NavigationRailTransitionKlgxPg(jM16676getPrimary0d7_KjU, j62, z, composableLambda22, composerStartRestartGroup, (i152 & 112) | (i152 & 14) | 3072 | ((i12 << 6) & 896));
                                if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
                                }
                                mutableInteractionSource3 = mutableInteractionSource42;
                                function23 = function22;
                                composer2 = composerStartRestartGroup;
                                j3 = j62;
                                z6 = z4;
                                modifier3 = modifier42;
                                j5 = jM16676getPrimary0d7_KjU;
                            }
                        }
                        final boolean z72 = z5;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    z5 = z3;
                    i8 = i2 & 128;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    if ((i & 234881024) != 0) {
                    }
                    if ((i & 1879048192) != 0) {
                    }
                    i11 = i10;
                    if ((i11 & 1533916891) == 306783378) {
                    }
                    final boolean z722 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function22 = function2;
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                z5 = z3;
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i & 234881024) != 0) {
                }
                if ((i & 1879048192) != 0) {
                }
                i11 = i10;
                if ((i11 & 1533916891) == 306783378) {
                }
                final boolean z7222 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
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
            z5 = z3;
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i & 234881024) != 0) {
            }
            if ((i & 1879048192) != 0) {
            }
            i11 = i10;
            if ((i11 & 1533916891) == 306783378) {
            }
            final boolean z72222 = z5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
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
        function22 = function2;
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        z5 = z3;
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i & 234881024) != 0) {
        }
        if ((i & 1879048192) != 0) {
        }
        i11 = i10;
        if ((i11 & 1533916891) == 306783378) {
        }
        final boolean z722222 = z5;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationRailItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1903861684);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1903861684, i2, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:258)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.NavigationRailKt.NavigationRailItemBaselineLayout.2
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                    long j2;
                    Placeable placeableMo19855measureBRTryo0;
                    long j3 = j;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    for (Measurable measurable : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                            Placeable placeableMo19855measureBRTryo02 = measurable.mo19855measureBRTryo0(j);
                            if (function22 != null) {
                                for (Measurable measurable2 : list) {
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                                        j2 = j;
                                        placeableMo19855measureBRTryo0 = measurable2.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            j2 = j3;
                            placeableMo19855measureBRTryo0 = null;
                            if (function22 == null) {
                                return NavigationRailKt.m16805placeIcon3p2s80s(Layout, placeableMo19855measureBRTryo02, j);
                            }
                            Intrinsics.checkNotNull(placeableMo19855measureBRTryo0);
                            return NavigationRailKt.m16806placeLabelAndIconDIyivk0(Layout, placeableMo19855measureBRTryo0, placeableMo19855measureBRTryo02, j2, f);
                        }
                        j3 = j;
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
            composerStartRestartGroup.startReplaceableGroup(1943278197);
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
            composerStartRestartGroup.startReplaceableGroup(1405563567);
            AbstractC1038a.m1222w(composerStartRestartGroup, i2 & 14, function2);
            if (function22 != null) {
                Modifier modifierAlpha = AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), f);
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
                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 2107148020);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i2 >> 3) & 14, function22);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt.NavigationRailItemBaselineLayout.3
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
                NavigationRailKt.NavigationRailItemBaselineLayout(function2, function22, f, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: NavigationRailTransition-Klgx-Pg, reason: not valid java name */
    public static final void m16799NavigationRailTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-207161906);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 2048 : 1024;
        }
        final int i4 = i2;
        if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-207161906, i4, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:226)");
            }
            final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, null, composerStartRestartGroup, 48, 12);
            long jM18576lerpjxsXWHM = ColorKt.m18576lerpjxsXWHM(j2, j, m16800NavigationRailTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(Color.m18524copywmQWz5c$default(jM18576lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(jM18576lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1688205042, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailTransition$1
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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i5) {
                    if ((i5 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1688205042, i5, -1, "androidx.compose.material.NavigationRailTransition.<anonymous> (NavigationRail.kt:242)");
                    }
                    function3.invoke(Float.valueOf(NavigationRailKt.m16800NavigationRailTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState)), composer2, Integer.valueOf((i4 >> 6) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailTransition$2
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

            public final void invoke(@Nullable Composer composer2, int i5) {
                NavigationRailKt.m16799NavigationRailTransitionKlgxPg(j, j2, z, function3, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: NavigationRailTransition_Klgx_Pg$lambda-3, reason: not valid java name */
    public static final float m16800NavigationRailTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m16805placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        final int iMax = Math.max(0, (Constraints.m20921getMaxWidthimpl(j) - placeable.getWidth()) / 2);
        final int iMax2 = Math.max(0, (Constraints.m20920getMaxHeightimpl(j) - placeable.getHeight()) / 2);
        return MeasureScope.layout$default(measureScope, Constraints.m20921getMaxWidthimpl(j), Constraints.m20920getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.NavigationRailKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default(layout, placeable, iMax, iMax2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m16806placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        final int iM20920getMaxHeightimpl = (Constraints.m20920getMaxHeightimpl(j) - placeable.get(AlignmentLineKt.getLastBaseline())) - measureScope.mo15540roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        final int iM1205f = AbstractC1038a.m1205f(placeable, Constraints.m20921getMaxWidthimpl(j), 2);
        final int iMo15540roundToPx0680j_4 = measureScope.mo15540roundToPx0680j_4(ItemIconTopOffset);
        int iM1197B = AbstractC1038a.m1197B(placeable2, Constraints.m20920getMaxHeightimpl(j), 2);
        final int iM1205f2 = AbstractC1038a.m1205f(placeable2, Constraints.m20921getMaxWidthimpl(j), 2);
        final int iRoundToInt = MathKt.roundToInt((1 - f) * (iM1197B - iMo15540roundToPx0680j_4));
        return MeasureScope.layout$default(measureScope, Constraints.m20921getMaxWidthimpl(j), Constraints.m20920getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.NavigationRailKt$placeLabelAndIcon$1
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
                if (f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, iM1205f, iRoundToInt + iM20920getMaxHeightimpl, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM1205f2, iMo15540roundToPx0680j_4 + iRoundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
