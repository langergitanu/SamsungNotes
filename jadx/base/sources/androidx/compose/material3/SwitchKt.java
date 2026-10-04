package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a|\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u0007\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0013\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\f\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, m13886d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwitchKt {

    @NotNull
    private static final TweenSpec<Float> AnimationSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float UncheckedThumbDiameter;

    static {
        SwitchTokens switchTokens = SwitchTokens.INSTANCE;
        float fM17906getSelectedHandleWidthD9Ej5fM = switchTokens.m17906getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = fM17906getSelectedHandleWidthD9Ej5fM;
        UncheckedThumbDiameter = switchTokens.m17913getUnselectedHandleWidthD9Ej5fM();
        float fM17911getTrackWidthD9Ej5fM = switchTokens.m17911getTrackWidthD9Ej5fM();
        SwitchWidth = fM17911getTrackWidthD9Ej5fM;
        float fM17909getTrackHeightD9Ej5fM = switchTokens.m17909getTrackHeightD9Ej5fM();
        SwitchHeight = fM17909getTrackHeightD9Ej5fM;
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(fM17909getTrackHeightD9Ej5fM - fM17906getSelectedHandleWidthD9Ej5fM) / 2);
        ThumbPadding = fM20968constructorimpl;
        ThumbPathLength = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(fM17911getTrackWidthD9Ej5fM - fM17906getSelectedHandleWidthD9Ej5fM) - fM20968constructorimpl);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, @Nullable final Function1<? super Boolean, Unit> function1, @Nullable Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, boolean z2, @Nullable SwitchColors switchColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i6;
        boolean z3;
        SwitchColors switchColors2;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        int i8;
        SwitchColors switchColorsM17337colorsV1nXRL4;
        int i9;
        MutableInteractionSource mutableInteractionSource3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        SwitchColors switchColors3;
        int i10;
        boolean z4;
        Modifier modifier3;
        final float fMo15546toPx0680j_4;
        final float fMo15546toPx0680j_42;
        boolean zChanged;
        Object objRememberedValue;
        Object objRememberedValue2;
        Composer.Companion companion;
        Composer.Companion companion2;
        Object objRememberedValue3;
        float f;
        float f4;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        ?? r8;
        Object obj;
        Animatable animatable;
        Modifier modifierM16110toggleableO2vRcR0;
        Composer composer3;
        final boolean z6;
        final Modifier modifier4;
        final SwitchColors switchColors4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final MutableInteractionSource mutableInteractionSource5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1580463220);
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
            i4 |= composerStartRestartGroup.changed(function1) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    function22 = function2;
                    i4 |= composerStartRestartGroup.changed(function22) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((57344 & i) == 0) {
                        z3 = z2;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((i & 458752) != 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            int i12 = composerStartRestartGroup.changed(switchColors2) ? 131072 : 65536;
                            i4 |= i12;
                        } else {
                            switchColors2 = switchColors;
                        }
                        i4 |= i12;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i7 = i2 & 64;
                    if (i7 != 0) {
                        if ((i & 3670016) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer3 = composerStartRestartGroup;
                            modifier4 = modifier2;
                            function24 = function22;
                            z6 = z3;
                            switchColors4 = switchColors2;
                            mutableInteractionSource5 = mutableInteractionSource2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            int i13 = i4;
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier5 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function25 = i5 == 0 ? null : function22;
                                boolean z7 = i6 == 0 ? true : z3;
                                if ((i2 & 32) == 0) {
                                    i8 = -492369756;
                                    switchColorsM17337colorsV1nXRL4 = SwitchDefaults.INSTANCE.m17337colorsV1nXRL4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                    composer2 = composerStartRestartGroup;
                                    i9 = i13 & (-458753);
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    i8 = -492369756;
                                    switchColorsM17337colorsV1nXRL4 = switchColors2;
                                    i9 = i13;
                                }
                                if (i7 == 0) {
                                    composer2.startReplaceableGroup(i8);
                                    Object objRememberedValue4 = composer2.rememberedValue();
                                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue4);
                                    }
                                    composer2.endReplaceableGroup();
                                    function23 = function25;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue4;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    function23 = function25;
                                }
                                switchColors3 = switchColorsM17337colorsV1nXRL4;
                                i10 = i9;
                                z4 = z7;
                                modifier3 = modifier5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    Function2<? super Composer, ? super Integer, Unit> function26 = function22;
                                    composer2 = composerStartRestartGroup;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    function23 = function26;
                                    i10 = i13 & (-458753);
                                    modifier3 = modifier2;
                                    z4 = z3;
                                    switchColors3 = switchColors2;
                                } else {
                                    Function2<? super Composer, ? super Integer, Unit> function27 = function22;
                                    composer2 = composerStartRestartGroup;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    function23 = function27;
                                    modifier3 = modifier2;
                                    z4 = z3;
                                    switchColors3 = switchColors2;
                                    i10 = i13;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1580463220, i10, -1, "androidx.compose.material3.Switch (Switch.kt:90)");
                            }
                            float f5 = function23 != null ? UncheckedThumbDiameter : ThumbDiameter;
                            float f6 = SwitchHeight;
                            float fM20968constructorimpl = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f6 - f5) / 2);
                            fMo15546toPx0680j_4 = ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM20968constructorimpl);
                            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            float f7 = ThumbPathLength;
                            fMo15546toPx0680j_42 = density.mo15546toPx0680j_4(f7);
                            Float fValueOf = Float.valueOf(fMo15546toPx0680j_4);
                            Float fValueOf2 = Float.valueOf(fMo15546toPx0680j_42);
                            composer2.startReplaceableGroup(511388516);
                            zChanged = composer2.changed(fValueOf2) | composer2.changed(fValueOf);
                            objRememberedValue = composer2.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @NotNull
                                    public final Float invoke(boolean z8) {
                                        return Float.valueOf(z8 ? fMo15546toPx0680j_42 : fMo15546toPx0680j_4);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Float invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            final float fFloatValue = ((Number) ((Function1) objRememberedValue).invoke(Boolean.valueOf(z))).floatValue();
                            composer2.startReplaceableGroup(-492369756);
                            objRememberedValue2 = composer2.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue2 != companion.getEmpty()) {
                                companion2 = companion;
                                objRememberedValue2 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                                composer2.updateRememberedValue(objRememberedValue2);
                            } else {
                                companion2 = companion;
                            }
                            composer2.endReplaceableGroup();
                            final Animatable animatable2 = (Animatable) objRememberedValue2;
                            composer2.startReplaceableGroup(773894976);
                            composer2.startReplaceableGroup(-492369756);
                            objRememberedValue3 = composer2.rememberedValue();
                            if (objRememberedValue3 == companion2.getEmpty()) {
                                objRememberedValue3 = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2), composer2);
                            }
                            composer2.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
                            composer2.endReplaceableGroup();
                            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt.Switch.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    Animatable.updateBounds$default(animatable2, Float.valueOf(fMo15546toPx0680j_4), null, 2, null);
                                }
                            }, composer2, 0);
                            EffectsKt.DisposableEffect(Boolean.valueOf(z), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt.Switch.3

                                /* JADX INFO: renamed from: androidx.compose.material3.SwitchKt$Switch$3$1, reason: invalid class name */
                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                @DebugMetadata(m14020c = "androidx.compose.material3.SwitchKt$Switch$3$1", m14021f = "Switch.kt", m14022i = {}, m14023l = {125}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                                    final /* synthetic */ float $targetValue;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$offset = animatable;
                                        this.$targetValue = f;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @NotNull
                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$offset, this.$targetValue, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                            Float fBoxFloat = Boxing.boxFloat(this.$targetValue);
                                            TweenSpec tweenSpec = SwitchKt.AnimationSpec;
                                            this.label = 1;
                                            if (Animatable.animateTo$default(animatable, fBoxFloat, tweenSpec, null, null, this, 12, null) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    @Nullable
                                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                    float fFloatValue2 = animatable2.getTargetValue().floatValue();
                                    float f8 = fFloatValue;
                                    if (fFloatValue2 != f8) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(animatable2, f8, null), 3, null);
                                    }
                                    return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                        }
                                    };
                                }
                            }, composer2, i10 & 14);
                            if (function1 == null) {
                                f4 = f7;
                                r8 = 0;
                                f = fM20968constructorimpl;
                                z5 = z4;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                obj = null;
                                animatable = animatable2;
                                modifierM16110toggleableO2vRcR0 = ToggleableKt.m16110toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m20259boximpl(Role.INSTANCE.m20271getSwitcho7Vup1c()), function1);
                            } else {
                                f = fM20968constructorimpl;
                                f4 = f7;
                                z5 = z4;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r8 = 0;
                                obj = null;
                                animatable = animatable2;
                                modifierM16110toggleableO2vRcR0 = Modifier.INSTANCE;
                            }
                            Modifier modifierMinimumTouchTargetSize = Modifier.INSTANCE;
                            if (function1 != null) {
                                modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifierMinimumTouchTargetSize);
                            }
                            Modifier modifierThen = modifier3.then(modifierMinimumTouchTargetSize).then(modifierM16110toggleableO2vRcR0);
                            Alignment.Companion companion3 = Alignment.INSTANCE;
                            Modifier modifierM15893requiredSizeVpY3zN4 = SizeKt.m15893requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen, companion3.getCenter(), r8, 2, obj), SwitchWidth, f6);
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, r8, composer2, r8, -1323940314);
                            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion4.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15893requiredSizeVpY3zN4);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density2));
                            AbstractC1038a.m1221v(r8, function3MaterializerOf, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            int i14 = i10;
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(1204996270);
                            int i15 = i14 >> 6;
                            Composer composer4 = composer2;
                            m17339SwitchImpl0DmnUew(boxScopeInstance, z, z5, switchColors3, animatable.asState(), function23, mutableInteractionSource4, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f5, f, f4, composer4, ((i14 << 3) & 112) | 6 | (i15 & 896) | (i15 & 7168) | ((i14 << 6) & 458752) | (i14 & 3670016), 6);
                            composer3 = composer4;
                            if (AbstractC1038a.m1225z(composer3)) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            modifier4 = modifier3;
                            switchColors4 = switchColors3;
                            function24 = function23;
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt.Switch.5
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

                            public final void invoke(@Nullable Composer composer5, int i16) {
                                SwitchKt.Switch(z, function1, modifier4, function24, z6, switchColors4, mutableInteractionSource5, composer5, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 1572864;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        int i132 = i4;
                        if ((i & 1) != 0) {
                            if (i11 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i7 == 0) {
                            }
                            switchColors3 = switchColorsM17337colorsV1nXRL4;
                            i10 = i9;
                            z4 = z7;
                            modifier3 = modifier5;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            float f52 = function23 != null ? UncheckedThumbDiameter : ThumbDiameter;
                            float f62 = SwitchHeight;
                            float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(f62 - f52) / 2);
                            fMo15546toPx0680j_4 = ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(fM20968constructorimpl2);
                            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            float f72 = ThumbPathLength;
                            fMo15546toPx0680j_42 = density3.mo15546toPx0680j_4(f72);
                            Float fValueOf3 = Float.valueOf(fMo15546toPx0680j_4);
                            Float fValueOf22 = Float.valueOf(fMo15546toPx0680j_42);
                            composer2.startReplaceableGroup(511388516);
                            zChanged = composer2.changed(fValueOf22) | composer2.changed(fValueOf3);
                            objRememberedValue = composer2.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @NotNull
                                    public final Float invoke(boolean z8) {
                                        return Float.valueOf(z8 ? fMo15546toPx0680j_42 : fMo15546toPx0680j_4);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Float invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                                composer2.endReplaceableGroup();
                                final float fFloatValue2 = ((Number) ((Function1) objRememberedValue).invoke(Boolean.valueOf(z))).floatValue();
                                composer2.startReplaceableGroup(-492369756);
                                objRememberedValue2 = composer2.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (objRememberedValue2 != companion.getEmpty()) {
                                }
                                composer2.endReplaceableGroup();
                                final Animatable<Float, AnimationVector1D> animatable22 = (Animatable) objRememberedValue2;
                                composer2.startReplaceableGroup(773894976);
                                composer2.startReplaceableGroup(-492369756);
                                objRememberedValue3 = composer2.rememberedValue();
                                if (objRememberedValue3 == companion2.getEmpty()) {
                                }
                                composer2.endReplaceableGroup();
                                final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
                                composer2.endReplaceableGroup();
                                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt.Switch.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        Animatable.updateBounds$default(animatable22, Float.valueOf(fMo15546toPx0680j_4), null, 2, null);
                                    }
                                }, composer2, 0);
                                EffectsKt.DisposableEffect(Boolean.valueOf(z), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt.Switch.3

                                    /* JADX INFO: renamed from: androidx.compose.material3.SwitchKt$Switch$3$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                    @DebugMetadata(m14020c = "androidx.compose.material3.SwitchKt$Switch$3$1", m14021f = "Switch.kt", m14022i = {}, m14023l = {125}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                                        final /* synthetic */ float $targetValue;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass1(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$offset = animatable;
                                            this.$targetValue = f;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @NotNull
                                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$offset, this.$targetValue, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                                Float fBoxFloat = Boxing.boxFloat(this.$targetValue);
                                                TweenSpec tweenSpec = SwitchKt.AnimationSpec;
                                                this.label = 1;
                                                if (Animatable.animateTo$default(animatable, fBoxFloat, tweenSpec, null, null, this, 12, null) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        @Nullable
                                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    @NotNull
                                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                        float fFloatValue22 = animatable22.getTargetValue().floatValue();
                                        float f8 = fFloatValue2;
                                        if (fFloatValue22 != f8) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(animatable22, f8, null), 3, null);
                                        }
                                        return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$invoke$$inlined$onDispose$1
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public void dispose() {
                                            }
                                        };
                                    }
                                }, composer2, i10 & 14);
                                if (function1 == null) {
                                }
                                Modifier modifierMinimumTouchTargetSize2 = Modifier.INSTANCE;
                                if (function1 != null) {
                                }
                                Modifier modifierThen2 = modifier3.then(modifierMinimumTouchTargetSize2).then(modifierM16110toggleableO2vRcR0);
                                Alignment.Companion companion32 = Alignment.INSTANCE;
                                Modifier modifierM15893requiredSizeVpY3zN42 = SizeKt.m15893requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifierThen2, companion32.getCenter(), r8, 2, obj), SwitchWidth, f62);
                                composer2.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion32, r8, composer2, r8, -1323940314);
                                Density density22 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion42.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15893requiredSizeVpY3zN42);
                                if (composer2.getApplier() == null) {
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                }
                                composer2.disableReusing();
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion42, composerM18018constructorimpl2, measurePolicyM1210k2, composerM18018constructorimpl2, density22));
                                AbstractC1038a.m1221v(r8, function3MaterializerOf2, AbstractC1038a.m1206g(companion42, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                int i142 = i10;
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(1204996270);
                                int i152 = i142 >> 6;
                                Composer composer42 = composer2;
                                m17339SwitchImpl0DmnUew(boxScopeInstance2, z, z5, switchColors3, animatable.asState(), function23, mutableInteractionSource4, ShapesKt.toShape(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), f52, f, f4, composer42, ((i142 << 3) & 112) | 6 | (i152 & 896) | (i152 & 7168) | ((i142 << 6) & 458752) | (i142 & 3670016), 6);
                                composer3 = composer42;
                                if (AbstractC1038a.m1225z(composer3)) {
                                }
                                z6 = z5;
                                modifier4 = modifier3;
                                switchColors4 = switchColors3;
                                function24 = function23;
                                mutableInteractionSource5 = mutableInteractionSource4;
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z2;
                if ((i & 458752) != 0) {
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((2995931 & i4) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function22 = function2;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z3 = z2;
            if ((i & 458752) != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((2995931 & i4) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function22 = function2;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z3 = z2;
        if ((i & 458752) != 0) {
        }
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((2995931 & i4) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: SwitchImpl-0DmnUew, reason: not valid java name */
    public static final void m17339SwitchImpl0DmnUew(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final State<Float> state, Function2<? super Composer, ? super Integer, Unit> function2, InteractionSource interactionSource, Shape shape, final float f, final float f4, final float f5, Composer composer, final int i, final int i2) {
        int i4;
        State<Float> state2;
        int i5;
        final float fFloatValue;
        InteractionSource interactionSource2;
        Shape shape2;
        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1968109941);
        if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            state2 = state;
            i4 |= composerStartRestartGroup.changed(state2) ? 16384 : 8192;
        } else {
            state2 = state;
        }
        if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
        }
        if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 1048576 : 524288;
        }
        if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(f5) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i4 & 1533916891) == 306783378 && (i5 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            interactionSource2 = interactionSource;
            shape2 = shape;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968109941, i4, i5, "androidx.compose.material3.SwitchImpl (Switch.kt:171)");
            }
            int i6 = ((i4 >> 6) & 14) | (i4 & 112) | ((i4 >> 3) & 896);
            State<Color> stateTrackColor$material3_release = switchColors.trackColor$material3_release(z2, z, composerStartRestartGroup, i6);
            State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, composerStartRestartGroup, (i4 >> 18) & 14);
            float fM17904getPressedHandleWidthD9Ej5fM = m17342SwitchImpl_0DmnUew$lambda7(stateCollectIsPressedAsState) ? SwitchTokens.INSTANCE.m17904getPressedHandleWidthD9Ej5fM() : C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl((C2256Dp.m20968constructorimpl(((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15542toDpu2uoSUM(state2.getValue().floatValue()) - f4) / C2256Dp.m20968constructorimpl(f5 - f4)) * C2256Dp.m20968constructorimpl(ThumbDiameter - f)) + f);
            composerStartRestartGroup.startReplaceableGroup(-993794194);
            if (m17342SwitchImpl_0DmnUew$lambda7(stateCollectIsPressedAsState)) {
                fFloatValue = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(z ? C2256Dp.m20968constructorimpl(ThumbPathLength - SwitchTokens.INSTANCE.m17910getTrackOutlineWidthD9Ej5fM()) : SwitchTokens.INSTANCE.m17910getTrackOutlineWidthD9Ej5fM());
            } else {
                fFloatValue = state2.getValue().floatValue();
            }
            composerStartRestartGroup.endReplaceableGroup();
            SwitchTokens switchTokens = SwitchTokens.INSTANCE;
            Shape shape3 = ShapesKt.toShape(switchTokens.getTrackShape(), composerStartRestartGroup, 6);
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            int i7 = i4;
            float f6 = fM17904getPressedHandleWidthD9Ej5fM;
            Modifier modifierM15408backgroundbw27NRU = BackgroundKt.m15408backgroundbw27NRU(BorderKt.m15420borderxT4_qwU(SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(boxScope.align(companion, companion2.getCenter()), SwitchWidth), SwitchHeight), switchTokens.m17910getTrackOutlineWidthD9Ej5fM(), switchColors.borderColor$material3_release(z2, z, composerStartRestartGroup, i6).getValue().m18535unboximpl(), shape3), m17341SwitchImpl_0DmnUew$lambda6(stateTrackColor$material3_release), shape3);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15408backgroundbw27NRU);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(968687813);
            long jM17340SwitchImpl_0DmnUew$lambda13$lambda10 = m17340SwitchImpl_0DmnUew$lambda13$lambda10(switchColors.thumbColor$material3_release(z2, z, composerStartRestartGroup, i6));
            Modifier modifierAlign = boxScopeInstance.align(companion, companion2.getCenterStart());
            Float fValueOf = Float.valueOf(fFloatValue);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(fValueOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                        return IntOffset.m21087boximpl(m17344invokeBjo55l4(density2));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m17344invokeBjo55l4(@NotNull Density offset) {
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(fFloatValue), 0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierOffset = OffsetKt.offset(modifierAlign, (Function1) objRememberedValue);
            Indication indicationM16977rememberRipple9IZ8Weo = RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(switchTokens.m17908getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4);
            interactionSource2 = interactionSource;
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierM15891requiredSize3ABfNKs = SizeKt.m15891requiredSize3ABfNKs(IndicationKt.indication(modifierOffset, interactionSource2, indicationM16977rememberRipple9IZ8Weo), f6);
            shape2 = shape;
            Modifier modifierM15408backgroundbw27NRU2 = BackgroundKt.m15408backgroundbw27NRU(modifierM15891requiredSize3ABfNKs, jM17340SwitchImpl_0DmnUew$lambda13$lambda10, shape2);
            Alignment center = companion2.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15408backgroundbw27NRU2);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            AbstractC1038a.m1220u(2058660585, -2137368960, composerStartRestartGroup, 881862015);
            if (function2 != null) {
                function22 = function2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(switchColors.iconColor$material3_release(z2, z, composerStartRestartGroup, i6).getValue())}, function22, composerStartRestartGroup, ((i7 >> 12) & 112) | 8);
            } else {
                function22 = function2;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Shape shape4 = shape2;
        final InteractionSource interactionSource3 = interactionSource2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$2
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

            public final void invoke(@Nullable Composer composer2, int i8) {
                SwitchKt.m17339SwitchImpl0DmnUew(boxScope, z, z2, switchColors, state, function22, interactionSource3, shape4, f, f4, f5, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: renamed from: SwitchImpl_0DmnUew$lambda-13$lambda-10, reason: not valid java name */
    private static final long m17340SwitchImpl_0DmnUew$lambda13$lambda10(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX INFO: renamed from: SwitchImpl_0DmnUew$lambda-6, reason: not valid java name */
    private static final long m17341SwitchImpl_0DmnUew$lambda6(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX INFO: renamed from: SwitchImpl_0DmnUew$lambda-7, reason: not valid java name */
    private static final boolean m17342SwitchImpl_0DmnUew$lambda7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
