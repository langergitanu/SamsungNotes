package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ShadowKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
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
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a?\u0010!\u001a\u00020\u0014*\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010\u001c\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a1\u0010'\u001a\u00020\u0014*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\n\u0010\u000b\"\u0013\u0010\f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u000b\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, m13886d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "SwitchHeight", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Landroidx/compose/runtime/State;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwitchKt {

    @NotNull
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    static {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(34);
        TrackWidth = fM20968constructorimpl;
        TrackStrokeWidth = C2256Dp.m20968constructorimpl(14);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(20);
        ThumbDiameter = fM20968constructorimpl2;
        ThumbRippleRadius = C2256Dp.m20968constructorimpl(24);
        DefaultSwitchPadding = C2256Dp.m20968constructorimpl(2);
        SwitchWidth = fM20968constructorimpl;
        SwitchHeight = fM20968constructorimpl2;
        ThumbPathLength = C2256Dp.m20968constructorimpl(fM20968constructorimpl - fM20968constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = C2256Dp.m20968constructorimpl(1);
        ThumbPressedElevation = C2256Dp.m20968constructorimpl(6);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0153  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, @Nullable final Function1<? super Boolean, Unit> function1, @Nullable Modifier modifier, boolean z2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable SwitchColors switchColors, @Nullable Composer composer, final int i, final int i2) {
        boolean z3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        SwitchColors switchColors2;
        MutableInteractionSource mutableInteractionSource3;
        int i7;
        Modifier modifier3;
        final boolean z5;
        SwitchColors switchColors3;
        MutableInteractionSource mutableInteractionSource4;
        int i8;
        MutableInteractionSource mutableInteractionSource5;
        Modifier modifierM16110toggleableO2vRcR0;
        final Modifier modifier4;
        final SwitchColors switchColors4;
        final MutableInteractionSource mutableInteractionSource6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(25866825);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            z3 = z;
        } else if ((i & 14) == 0) {
            z3 = z;
            i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
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
                    z4 = z2;
                    i4 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 == 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((i & 458752) != 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            int i10 = composerStartRestartGroup.changed(switchColors2) ? 131072 : 65536;
                            i4 |= i10;
                        } else {
                            switchColors2 = switchColors;
                        }
                        i4 |= i10;
                    } else {
                        switchColors2 = switchColors;
                    }
                    if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i5 == 0 ? true : z4;
                            if (i6 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) == 0) {
                                SwitchColors switchColorsM16885colorsSQMK_m0 = SwitchDefaults.INSTANCE.m16885colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i7 = i4 & (-458753);
                                modifier3 = modifier5;
                                z5 = z6;
                                switchColors3 = switchColorsM16885colorsSQMK_m0;
                            } else {
                                i7 = i4;
                                modifier3 = modifier5;
                                z5 = z6;
                                switchColors3 = switchColors2;
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            i7 = i4;
                            modifier3 = modifier2;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            switchColors3 = switchColors2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(25866825, i7, -1, "androidx.compose.material.Switch (Switch.kt:89)");
                        }
                        float fMo15546toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(ThumbPathLength);
                        SwipeableState swipeableStateRememberSwipeableStateFor = SwipeableKt.rememberSwipeableStateFor(Boolean.valueOf(z3), function1 != null ? new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z7) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        } : function1, AnimationSpec, composerStartRestartGroup, (i7 & 14) | 384, 0);
                        boolean z7 = composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl;
                        if (function1 == null) {
                            i8 = 2;
                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                            modifierM16110toggleableO2vRcR0 = ToggleableKt.m16110toggleableO2vRcR0(Modifier.INSTANCE, z3, mutableInteractionSource7, null, z5, Role.m20259boximpl(Role.INSTANCE.m20271getSwitcho7Vup1c()), function1);
                            mutableInteractionSource5 = mutableInteractionSource7;
                        } else {
                            i8 = 2;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            modifierM16110toggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        Modifier modifierMinimumTouchTargetSize = Modifier.INSTANCE;
                        if (function1 != null) {
                            modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifierMinimumTouchTargetSize);
                        }
                        Modifier modifierThen = modifier3.then(modifierMinimumTouchTargetSize).then(modifierM16110toggleableO2vRcR0);
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(0.0f), Boolean.FALSE), TuplesKt.m13893to(Float.valueOf(fMo15546toPx0680j_4), Boolean.TRUE));
                        int i11 = i7;
                        Modifier modifierM16882swipeablepPrIpRY = SwipeableKt.m16882swipeablepPrIpRY(modifierThen, swipeableStateRememberSwipeableStateFor, mapMapOf, Orientation.Horizontal, (32 & 8) != 0 ? true : (z5 || function1 == null) ? false : true, (32 & 16) != 0 ? false : z7, (32 & 32) != 0 ? null : mutableInteractionSource5, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                            @Override // kotlin.jvm.functions.Function2
                            @NotNull
                            public final FixedThreshold invoke(Object obj, Object obj2) {
                                return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                            }
                        } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                                return invoke(bool.booleanValue(), bool2.booleanValue());
                            }

                            @NotNull
                            public final ThresholdConfig invoke(boolean z8, boolean z9) {
                                return new FractionalThreshold(0.5f);
                            }
                        }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
                        Alignment.Companion companion = Alignment.INSTANCE;
                        Modifier modifierM15893requiredSizeVpY3zN4 = SizeKt.m15893requiredSizeVpY3zN4(PaddingKt.m15854padding3ABfNKs(SizeKt.wrapContentSize$default(modifierM16882swipeablepPrIpRY, companion.getCenter(), false, i8, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composerStartRestartGroup, 0, -1323940314);
                        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15893requiredSizeVpY3zN4);
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
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(1571176015);
                        int i12 = i11 << 3;
                        Modifier modifier6 = modifier3;
                        Composer composer2 = composerStartRestartGroup;
                        SwitchColors switchColors5 = switchColors3;
                        SwitchImpl(boxScopeInstance, z, z5, switchColors5, swipeableStateRememberSwipeableStateFor.getOffset(), mutableInteractionSource5, composer2, ((i11 >> 6) & 7168) | (i12 & 112) | 6 | ((i11 >> 3) & 896) | (i12 & 458752));
                        composerStartRestartGroup = composer2;
                        if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier6;
                        switchColors4 = switchColors5;
                        mutableInteractionSource6 = mutableInteractionSource5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z4;
                        mutableInteractionSource6 = mutableInteractionSource2;
                        switchColors4 = switchColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                        public final void invoke(@Nullable Composer composer3, int i13) {
                            SwitchKt.Switch(z, function1, modifier4, z5, mutableInteractionSource6, switchColors4, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 458752) != 0) {
                }
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        float fMo15546toPx0680j_42 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo15546toPx0680j_4(ThumbPathLength);
                        SwipeableState swipeableStateRememberSwipeableStateFor2 = SwipeableKt.rememberSwipeableStateFor(Boolean.valueOf(z3), function1 != null ? new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z72) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        } : function1, AnimationSpec, composerStartRestartGroup, (i7 & 14) | 384, 0);
                        if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) {
                        }
                        if (function1 == null) {
                        }
                        Modifier modifierMinimumTouchTargetSize2 = Modifier.INSTANCE;
                        if (function1 != null) {
                        }
                        Modifier modifierThen2 = modifier3.then(modifierMinimumTouchTargetSize2).then(modifierM16110toggleableO2vRcR0);
                        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.m13893to(Float.valueOf(0.0f), Boolean.FALSE), TuplesKt.m13893to(Float.valueOf(fMo15546toPx0680j_42), Boolean.TRUE));
                        if (z5) {
                            int i112 = i7;
                            Modifier modifierM16882swipeablepPrIpRY2 = SwipeableKt.m16882swipeablepPrIpRY(modifierThen2, swipeableStateRememberSwipeableStateFor2, mapMapOf2, Orientation.Horizontal, (32 & 8) != 0 ? true : (z5 || function1 == null) ? false : true, (32 & 16) != 0 ? false : z7, (32 & 32) != 0 ? null : mutableInteractionSource5, (32 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                @Override // kotlin.jvm.functions.Function2
                                @NotNull
                                public final FixedThreshold invoke(Object obj, Object obj2) {
                                    return new FixedThreshold(C2256Dp.m20968constructorimpl(56), null);
                                }
                            } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                                    return invoke(bool.booleanValue(), bool2.booleanValue());
                                }

                                @NotNull
                                public final ThresholdConfig invoke(boolean z8, boolean z9) {
                                    return new FractionalThreshold(0.5f);
                                }
                            }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf2.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m16881getVelocityThresholdD9Ej5fM() : 0.0f);
                            Alignment.Companion companion3 = Alignment.INSTANCE;
                            Modifier modifierM15893requiredSizeVpY3zN42 = SizeKt.m15893requiredSizeVpY3zN4(PaddingKt.m15854padding3ABfNKs(SizeKt.wrapContentSize$default(modifierM16882swipeablepPrIpRY2, companion3.getCenter(), false, i8, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15893requiredSizeVpY3zN42);
                            if (composerStartRestartGroup.getApplier() == null) {
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion22, composerM18018constructorimpl2, measurePolicyM1210k2, composerM18018constructorimpl2, density2));
                            AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion22, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(1571176015);
                            int i122 = i112 << 3;
                            Modifier modifier62 = modifier3;
                            Composer composer22 = composerStartRestartGroup;
                            SwitchColors switchColors52 = switchColors3;
                            SwitchImpl(boxScopeInstance2, z, z5, switchColors52, swipeableStateRememberSwipeableStateFor2.getOffset(), mutableInteractionSource5, composer22, ((i112 >> 6) & 7168) | (i122 & 112) | 6 | ((i112 >> 3) & 896) | (i122 & 458752));
                            composerStartRestartGroup = composer22;
                            if (AbstractC1038a.m1225z(composerStartRestartGroup)) {
                            }
                            modifier4 = modifier62;
                            switchColors4 = switchColors52;
                            mutableInteractionSource6 = mutableInteractionSource5;
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 458752) != 0) {
            }
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z4 = z2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 458752) != 0) {
        }
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final State<Float> state, final InteractionSource interactionSource, Composer composer, final int i) {
        int i2;
        int i4;
        long jM16887SwitchImpl$lambda7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1834839253);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(state) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1834839253, i2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:174)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i5 = (i2 >> 15) & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(interactionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i5 | 64);
            float f = !snapshotStateList.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation;
            int i6 = ((i2 >> 6) & 14) | (i2 & 112) | ((i2 >> 3) & 896);
            final State<Color> stateTrackColor = switchColors.trackColor(z2, z, composerStartRestartGroup, i6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Alignment.Companion companion3 = Alignment.INSTANCE;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(companion2, companion3.getCenter()), 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(stateTrackColor);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        SwitchKt.m16890drawTrackRPmYEkk(Canvas, SwitchKt.m16886SwitchImpl$lambda5(stateTrackColor), Canvas.mo15546toPx0680j_4(SwitchKt.getTrackWidth()), Canvas.mo15546toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            State<Color> stateThumbColor = switchColors.thumbColor(z2, z, composerStartRestartGroup, i6);
            ElevationOverlay elevationOverlay = (ElevationOverlay) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalElevationOverlay());
            float fM20968constructorimpl = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + f);
            composerStartRestartGroup.startReplaceableGroup(-539245361);
            if (!Color.m18526equalsimpl0(m16887SwitchImpl$lambda7(stateThumbColor), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU()) || elevationOverlay == null) {
                i4 = 1157296644;
                jM16887SwitchImpl$lambda7 = m16887SwitchImpl$lambda7(stateThumbColor);
            } else {
                i4 = 1157296644;
                jM16887SwitchImpl$lambda7 = elevationOverlay.mo16710apply7g2Lkgo(m16887SwitchImpl$lambda7(stateThumbColor), fM20968constructorimpl, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = boxScope.align(companion2, companion3.getCenterStart());
            composerStartRestartGroup.startReplaceableGroup(i4);
            boolean zChanged3 = composerStartRestartGroup.changed(state);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m21087boximpl(m16891invokeBjo55l4(density));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m16891invokeBjo55l4(@NotNull Density offset) {
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(state.getValue().floatValue()), 0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m15408backgroundbw27NRU(ShadowKt.m18189shadows4CzXII$default(SizeKt.m15891requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) objRememberedValue4), interactionSource, RippleKt.m16977rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composerStartRestartGroup, 54, 4)), ThumbDiameter), f, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), jM16887SwitchImpl$lambda7, RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.SwitchImpl.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i7) {
                SwitchKt.SwitchImpl(boxScope, z, z2, switchColors, state, interactionSource, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SwitchImpl$lambda-5, reason: not valid java name */
    public static final long m16886SwitchImpl$lambda5(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX INFO: renamed from: SwitchImpl$lambda-7, reason: not valid java name */
    private static final long m16887SwitchImpl$lambda7(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m16890drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f4) {
        float f5 = f4 / 2;
        DrawScope.m19062drawLineNGM6Ib0$default(drawScope, j, androidx.compose.p109ui.geometry.OffsetKt.Offset(f5, Offset.m18285getYimpl(drawScope.mo19075getCenterF1C5BW0())), androidx.compose.p109ui.geometry.OffsetKt.Offset(f - f5, Offset.m18285getYimpl(drawScope.mo19075getCenterF1C5BW0())), f4, StrokeCap.INSTANCE.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }
}
