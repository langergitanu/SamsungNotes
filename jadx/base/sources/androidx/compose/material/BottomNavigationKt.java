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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
@Metadata(m13885d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0017\u001a\u00020\t2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\u001c\u001aU\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0095\u0001\u0010'\u001a\u00020\t*\u00020\u00122\u0006\u0010 \u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020!2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u000202*\u0002032\u0006\u0010;\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, m13886d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "BottomNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BottomNavigationKt {

    @NotNull
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = C2256Dp.m20968constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;

    static {
        float f = 12;
        BottomNavigationItemHorizontalPadding = C2256Dp.m20968constructorimpl(f);
        CombinedItemTextBaseline = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0164 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0165  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16607BottomNavigationPEIptTM(@Nullable Modifier modifier, long j, long j2, float f, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final int i4;
        long primarySurface;
        long jM16694contentColorForek8zF_U;
        float f4;
        Modifier modifier3;
        long j3;
        float fM16606getElevationD9Ej5fM;
        long j5;
        Composer composer2;
        final Modifier modifier4;
        final long j6;
        final long j7;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(456489494);
        int i5 = i2 & 1;
        if (i5 != 0) {
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
                primarySurface = j;
                int i6 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i4 |= i6;
            } else {
                primarySurface = j;
            }
            i4 |= i6;
        } else {
            primarySurface = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM16694contentColorForek8zF_U = j2;
                int i7 = composerStartRestartGroup.changed(jM16694contentColorForek8zF_U) ? 256 : 128;
                i4 |= i7;
            } else {
                jM16694contentColorForek8zF_U = j2;
            }
            i4 |= i7;
        } else {
            jM16694contentColorForek8zF_U = j2;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 7168) == 0) {
                f4 = f;
                i4 |= composerStartRestartGroup.changed(f4) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i4 |= 24576;
            } else if ((57344 & i) == 0) {
                i4 |= composerStartRestartGroup.changed(content) ? 16384 : 8192;
            }
            if ((46811 & i4) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier modifier5 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    }
                    if ((i2 & 4) != 0) {
                        jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 3) & 14);
                        i4 &= -897;
                    }
                    if (i8 == 0) {
                        long j8 = jM16694contentColorForek8zF_U;
                        modifier3 = modifier5;
                        j3 = j8;
                        fM16606getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m16606getElevationD9Ej5fM();
                    } else {
                        long j9 = jM16694contentColorForek8zF_U;
                        modifier3 = modifier5;
                        j3 = j9;
                        fM16606getElevationD9Ej5fM = f4;
                    }
                    j5 = primarySurface;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                    }
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    fM16606getElevationD9Ej5fM = f4;
                    j5 = primarySurface;
                    j3 = jM16694contentColorForek8zF_U;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(456489494, i4, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
                }
                int i9 = i4 << 3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m16872SurfaceFjzlyU(modifier3, null, j5, j3, null, fM16606getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                            ComposerKt.traceEventStart(678339930, i10, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:101)");
                        }
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BottomNavigationKt.BottomNavigationHeight));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        int i11 = ((i4 >> 3) & 7168) | 48;
                        composer3.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer3, 6);
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
                        function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i11 >> 6) & 112) | 6));
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i4 & 14) | 1572864 | (i9 & 896) | (i9 & 7168) | ((i4 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                j6 = j5;
                j7 = j3;
                f5 = fM16606getElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier4 = modifier2;
                j6 = primarySurface;
                j7 = jM16694contentColorForek8zF_U;
                f5 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$2
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

                public final void invoke(@Nullable Composer composer3, int i10) {
                    BottomNavigationKt.m16607BottomNavigationPEIptTM(modifier4, j6, j7, f5, content, composer3, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 3072;
        f4 = f;
        if ((i2 & 16) == 0) {
        }
        if ((46811 & i4) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 2) != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i8 == 0) {
                }
                j5 = primarySurface;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i92 = i4 << 3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m16872SurfaceFjzlyU(modifier3, null, j5, j3, null, fM16606getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 678339930, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                            ComposerKt.traceEventStart(678339930, i10, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:101)");
                        }
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BottomNavigationKt.BottomNavigationHeight));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        int i11 = ((i4 >> 3) & 7168) | 48;
                        composer3.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer3, 6);
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
                        function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i11 >> 6) & 112) | 6));
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i4 & 14) | 1572864 | (i92 & 896) | (i92 & 7168) | ((i4 << 6) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j6 = j5;
                j7 = j3;
                f5 = fM16606getElevationD9Ej5fM;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0367 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0123  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16608BottomNavigationItemjY6E1Zs(@NotNull final RowScope BottomNavigationItem, final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> icon, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, boolean z3, @Nullable MutableInteractionSource mutableInteractionSource, long j, long j2, @Nullable Composer composer, final int i, final int i2, final int i4) {
        final int i5;
        boolean z4;
        int i6;
        Modifier modifier2;
        int i7;
        boolean z5;
        int i8;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        int i9;
        int i10;
        int i11;
        Modifier modifier3;
        final boolean z6;
        MutableInteractionSource mutableInteractionSource2;
        long jM18535unboximpl;
        long j3;
        long jM18524copywmQWz5c$default;
        int i12;
        Modifier modifier4;
        final ComposableLambda composableLambda;
        final boolean z7;
        final boolean z8;
        final MutableInteractionSource mutableInteractionSource3;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(BottomNavigationItem, "$this$BottomNavigationItem");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1473735525);
        if ((Integer.MIN_VALUE & i4) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(BottomNavigationItem) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 1) != 0) {
            i5 |= 48;
        } else {
            if ((i & 112) == 0) {
                z4 = z;
                i5 |= composerStartRestartGroup.changed(z4) ? 32 : 16;
            }
            if ((i4 & 2) == 0) {
                i5 |= 384;
            } else if ((i & 896) == 0) {
                i5 |= composerStartRestartGroup.changed(onClick) ? 256 : 128;
            }
            if ((i4 & 4) == 0) {
                i5 |= 3072;
            } else if ((i & 7168) == 0) {
                i5 |= composerStartRestartGroup.changed(icon) ? 2048 : 1024;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 24576;
            } else {
                if ((57344 & i) == 0) {
                    modifier2 = modifier;
                    i5 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                }
                i7 = i4 & 16;
                if (i7 == 0) {
                    if ((458752 & i) == 0) {
                        z5 = z2;
                        i5 |= composerStartRestartGroup.changed(z5) ? 131072 : 65536;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        function22 = function2;
                    } else {
                        function22 = function2;
                        if ((i & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(function22) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i5 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                    }
                    if ((i & 1879048192) == 0) {
                        i5 |= ((i4 & 512) == 0 && composerStartRestartGroup.changed(j)) ? 536870912 : 268435456;
                    }
                    if ((i2 & 14) != 0) {
                        i11 = i2 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(j2)) ? 4 : 2);
                    } else {
                        i11 = i2;
                    }
                    if ((i5 & 1533916891) != 306783378 && (i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z7 = z3;
                        mutableInteractionSource3 = mutableInteractionSource;
                        j3 = j;
                        z8 = z5;
                        j5 = j2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i7 != 0) {
                                z5 = true;
                            }
                            if (i8 != 0) {
                                function22 = null;
                            }
                            z6 = i9 == 0 ? true : z3;
                            if (i10 == 0) {
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
                            if ((i4 & 256) == 0) {
                                jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
                                i5 &= -1879048193;
                            } else {
                                jM18535unboximpl = j;
                            }
                            if ((i4 & 512) == 0) {
                                long j6 = jM18535unboximpl;
                                jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                j3 = j6;
                                i11 &= -15;
                            } else {
                                j3 = jM18535unboximpl;
                                jM18524copywmQWz5c$default = j2;
                            }
                            i12 = i11;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 256) != 0) {
                                i5 &= -1879048193;
                            }
                            if ((i4 & 512) != 0) {
                                i11 &= -15;
                            }
                            z6 = z3;
                            mutableInteractionSource2 = mutableInteractionSource;
                            j3 = j;
                            modifier3 = modifier2;
                            i12 = i11;
                            jM18524copywmQWz5c$default = j2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1473735525, i5, i12, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:146)");
                        }
                        if (function22 == null) {
                            modifier4 = modifier3;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i13) {
                                    if ((i13 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1343298261, i13, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:159)");
                                    }
                                    TextKt.ProvideTextStyle(TextStyle.m20465copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m20850boximpl(TextAlign.INSTANCE.m20857getCentere0LSkKk()), null, 0L, null, 245759, null), function22, composer2, (i5 >> 15) & 112);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                        } else {
                            modifier4 = modifier3;
                            composableLambda = null;
                        }
                        Modifier modifier5 = modifier4;
                        boolean z9 = z4;
                        Modifier modifierWeight$default = RowScope.weight$default(BottomNavigationItem, SelectableKt.m16105selectableO2vRcR0(modifier5, z9, mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, j3, composerStartRestartGroup, ((i5 >> 21) & 896) | 6, 2), z5, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        int i13 = i12;
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                        Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWeight$default);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        m16609BottomNavigationTransitionKlgxPg(j3, jM18524copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(float f, @Nullable Composer composer2, int i14) {
                                int i15;
                                if ((i14 & 14) == 0) {
                                    i15 = (composer2.changed(f) ? 4 : 2) | i14;
                                } else {
                                    i15 = i14;
                                }
                                if ((i15 & 91) == 18 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1411872801, i14, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:186)");
                                }
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i5 >> 9) & 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 27) & 14) | 3072 | ((i13 << 3) & 112) | ((i5 << 3) & 896));
                        if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
                            ComposerKt.traceEventEnd();
                        }
                        function22 = function23;
                        z7 = z6;
                        z8 = z5;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        j5 = jM18524copywmQWz5c$default;
                        modifier2 = modifier5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final Modifier modifier6 = modifier2;
                    final long j7 = j3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                        public final void invoke(@Nullable Composer composer2, int i14) {
                            BottomNavigationKt.m16608BottomNavigationItemjY6E1Zs(BottomNavigationItem, z, onClick, icon, modifier6, z8, function22, z7, mutableInteractionSource3, j7, j5, composer2, i | 1, i2, i4);
                        }
                    });
                    return;
                }
                i5 |= 196608;
                z5 = z2;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                if ((i & 1879048192) == 0) {
                }
                if ((i2 & 14) != 0) {
                }
                if ((i5 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i6 == 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if ((i4 & 256) == 0) {
                        }
                        if ((i4 & 512) == 0) {
                        }
                        i12 = i11;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (function22 == null) {
                        }
                        Modifier modifier52 = modifier4;
                        boolean z92 = z4;
                        Modifier modifierWeight$default2 = RowScope.weight$default(BottomNavigationItem, SelectableKt.m16105selectableO2vRcR0(modifier52, z92, mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, j3, composerStartRestartGroup, ((i5 >> 21) & 896) | 6, 2), z5, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                        Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        int i132 = i12;
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function2<? super Composer, ? super Integer, Unit> function232 = function22;
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default2);
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
                        composerStartRestartGroup.startReplaceableGroup(-1538530399);
                        m16609BottomNavigationTransitionKlgxPg(j3, jM18524copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                invoke(f.floatValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(float f, @Nullable Composer composer2, int i14) {
                                int i15;
                                if ((i14 & 14) == 0) {
                                    i15 = (composer2.changed(f) ? 4 : 2) | i14;
                                } else {
                                    i15 = i14;
                                }
                                if ((i15 & 91) == 18 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1411872801, i14, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:186)");
                                }
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, composableLambda, f, composer2, (i5 >> 9) & 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, ((i5 >> 27) & 14) | 3072 | ((i132 << 3) & 112) | ((i5 << 3) & 896));
                        if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
                        }
                        function22 = function232;
                        z7 = z6;
                        z8 = z5;
                        mutableInteractionSource3 = mutableInteractionSource42;
                        j5 = jM18524copywmQWz5c$default;
                        modifier2 = modifier52;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i7 = i4 & 16;
            if (i7 == 0) {
            }
            z5 = z2;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            if ((i2 & 14) != 0) {
            }
            if ((i5 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z4 = z;
        if ((i4 & 2) == 0) {
        }
        if ((i4 & 4) == 0) {
        }
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        z5 = z2;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        if ((i2 & 14) != 0) {
        }
        if ((i5 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void BottomNavigationItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1162995092);
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
                ComposerKt.traceEventStart(-1162995092, i2, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:253)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout.2
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
                                return BottomNavigationKt.m16615placeIcon3p2s80s(Layout, placeableMo19855measureBRTryo02, j);
                            }
                            Intrinsics.checkNotNull(placeableMo19855measureBRTryo0);
                            return BottomNavigationKt.m16616placeLabelAndIconDIyivk0(Layout, placeableMo19855measureBRTryo0, placeableMo19855measureBRTryo02, j2, f);
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
            composerStartRestartGroup.startReplaceableGroup(395677717);
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
            composerStartRestartGroup.startReplaceableGroup(-1943403697);
            AbstractC1038a.m1222w(composerStartRestartGroup, i2 & 14, function2);
            if (function22 != null) {
                Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), f), BottomNavigationItemHorizontalPadding, 0.0f, 2, null);
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
                AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 150842644);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout.3
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
                BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, function22, f, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    public static final void m16609BottomNavigationTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-985175058);
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
                ComposerKt.traceEventStart(-985175058, i4, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:221)");
            }
            final State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, null, composerStartRestartGroup, 48, 12);
            long jM18576lerpjxsXWHM = ColorKt.m18576lerpjxsXWHM(j2, j, m16610BottomNavigationTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(Color.m18524copywmQWz5c$default(jM18576lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(jM18576lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -138092754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$1
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
                        ComposerKt.traceEventStart(-138092754, i5, -1, "androidx.compose.material.BottomNavigationTransition.<anonymous> (BottomNavigation.kt:237)");
                    }
                    function3.invoke(Float.valueOf(BottomNavigationKt.m16610BottomNavigationTransition_Klgx_Pg$lambda3(stateAnimateFloatAsState)), composer2, Integer.valueOf((i4 >> 6) & 112));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$2
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
                BottomNavigationKt.m16609BottomNavigationTransitionKlgxPg(j, j2, z, function3, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomNavigationTransition_Klgx_Pg$lambda-3, reason: not valid java name */
    public static final float m16610BottomNavigationTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m16615placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        final int iM1197B = AbstractC1038a.m1197B(placeable, iM20920getMaxHeightimpl, 2);
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, iM1197B, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m16616placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
        int i = placeable.get(AlignmentLineKt.getLastBaseline());
        int iMo15540roundToPx0680j_4 = measureScope.mo15540roundToPx0680j_4(CombinedItemTextBaseline);
        final int i2 = (iM20920getMaxHeightimpl - i) - iMo15540roundToPx0680j_4;
        int iM1197B = AbstractC1038a.m1197B(placeable2, iM20920getMaxHeightimpl, 2);
        final int height = (iM20920getMaxHeightimpl - (iMo15540roundToPx0680j_4 * 2)) - placeable2.getHeight();
        int iMax = Math.max(placeable.getWidth(), placeable2.getWidth());
        final int iM1205f = AbstractC1038a.m1205f(placeable, iMax, 2);
        final int iM1205f2 = AbstractC1038a.m1205f(placeable2, iMax, 2);
        final int iRoundToInt = MathKt.roundToInt((1 - f) * (iM1197B - height));
        return MeasureScope.layout$default(measureScope, iMax, iM20920getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeLabelAndIcon$1
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
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, iM1205f, iRoundToInt + i2, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, iM1205f2, height + iRoundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
