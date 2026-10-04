package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ShadowKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.PointMode;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0014Jy\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, m13886d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/SliderColors;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    private SliderDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0221 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0134  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m17284Thumb9LiSoMs(@NotNull final MutableInteractionSource interactionSource, @Nullable Modifier modifier, @Nullable SliderColors sliderColors, boolean z, long j, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i5;
        boolean z2;
        int i6;
        long j2;
        Modifier modifier3;
        final boolean z3;
        long j3;
        Object objRememberedValue;
        Composer.Companion companion;
        SnapshotStateList snapshotStateList;
        boolean zChanged;
        Object objRememberedValue2;
        final Modifier modifier4;
        final SliderColors sliderColors3;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-290277409);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    int i8 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i4 |= i8;
                } else {
                    sliderColors2 = sliderColors;
                }
                i4 |= i8;
            } else {
                sliderColors2 = sliderColors;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((57344 & i) == 0) {
                        j2 = j;
                        i4 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            i4 |= composerStartRestartGroup.changed(this) ? 131072 : 65536;
                        }
                        if ((374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            sliderColors3 = sliderColors2;
                            z3 = z2;
                            j5 = j2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                if ((i2 & 4) != 0) {
                                    SliderColors sliderColorsM17285colorsq0g_0yA = m17285colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i4 >> 15) & 14, 1023);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    i4 &= -897;
                                    sliderColors2 = sliderColorsM17285colorsq0g_0yA;
                                }
                                z3 = i5 == 0 ? true : z;
                                j3 = i6 == 0 ? SliderKt.ThumbSize : j;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i4 &= -897;
                                }
                                modifier3 = modifier2;
                                z3 = z2;
                                j3 = j2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-290277409, i4, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:673)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            snapshotStateList = (SnapshotStateList) objRememberedValue;
                            int i9 = i4 & 14;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(interactionSource) | composerStartRestartGroup.changed(snapshotStateList);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new SliderDefaults$Thumb$1$1(interactionSource, snapshotStateList, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i9 | 64);
                            float f = snapshotStateList.isEmpty() ? SliderKt.ThumbPressedElevation : SliderKt.ThumbDefaultElevation;
                            SliderTokens sliderTokens = SliderTokens.INSTANCE;
                            Shape shape = ShapesKt.toShape(sliderTokens.getHandleShape(), composerStartRestartGroup, 6);
                            long j6 = j3;
                            SpacerKt.Spacer(BackgroundKt.m15408backgroundbw27NRU(ShadowKt.m18189shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m15900size6HolHcs(modifier3, j3), interactionSource, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(sliderTokens.m17884getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), interactionSource, false, 2, null), !z3 ? f : C2256Dp.m20968constructorimpl(0), shape, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i4 >> 3) & 112) | ((i4 >> 9) & 14)).getValue().m18535unboximpl(), shape), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            sliderColors3 = sliderColors2;
                            j5 = j6;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Thumb$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i10) {
                                this.$tmp0_rcvr.m17284Thumb9LiSoMs(interactionSource, modifier4, sliderColors3, z3, j5, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= 196608;
                    if ((374491 & i4) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 == 0) {
                            }
                            if ((i2 & 4) != 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            snapshotStateList = (SnapshotStateList) objRememberedValue;
                            int i92 = i4 & 14;
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(interactionSource) | composerStartRestartGroup.changed(snapshotStateList);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new SliderDefaults$Thumb$1$1(interactionSource, snapshotStateList, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                composerStartRestartGroup.endReplaceableGroup();
                                EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i92 | 64);
                                if (snapshotStateList.isEmpty()) {
                                }
                                SliderTokens sliderTokens2 = SliderTokens.INSTANCE;
                                Shape shape2 = ShapesKt.toShape(sliderTokens2.getHandleShape(), composerStartRestartGroup, 6);
                                long j62 = j3;
                                SpacerKt.Spacer(BackgroundKt.m15408backgroundbw27NRU(ShadowKt.m18189shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m15900size6HolHcs(modifier3, j3), interactionSource, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(sliderTokens2.m17884getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4)), interactionSource, false, 2, null), !z3 ? f : C2256Dp.m20968constructorimpl(0), shape2, false, 0L, 0L, 24, null), sliderColors2.thumbColor$material3_release(z3, composerStartRestartGroup, ((i4 >> 3) & 112) | ((i4 >> 9) & 14)).getValue().m18535unboximpl(), shape2), composerStartRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                sliderColors3 = sliderColors2;
                                j5 = j62;
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                j2 = j;
                if ((i2 & 32) != 0) {
                }
                if ((374491 & i4) == 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            j2 = j;
            if ((i2 & 32) != 0) {
            }
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        j2 = j;
        if ((i2 & 32) != 0) {
        }
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0191 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0155 A[LOOP:0: B:86:0x0152->B:88:0x0155, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0185  */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v8, types: [boolean, int] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(@NotNull final SliderPositions sliderPositions, @Nullable Modifier modifier, @Nullable SliderColors sliderColors, boolean z, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i5;
        boolean z2;
        Composer composer2;
        boolean z3;
        SliderColors sliderColorsM17285colorsq0g_0yA;
        boolean z4;
        SliderColors sliderColors3;
        Modifier modifier3;
        ?? r5;
        final State<Color> stateTrackColor$material3_release;
        final State<Color> stateTrackColor$material3_release2;
        final State<Color> stateTickColor$material3_release;
        final State<Color> stateTickColor$material3_release2;
        int i6;
        boolean zChanged;
        Object objRememberedValue;
        final Modifier modifier4;
        final SliderColors sliderColors4;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1546713545);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(sliderPositions) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    int i8 = composerStartRestartGroup.changed(sliderColors2) ? 256 : 128;
                    i4 |= i8;
                } else {
                    sliderColors2 = sliderColors;
                }
                i4 |= i8;
            } else {
                sliderColors2 = sliderColors;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i2 & 16) == 0) {
                    if ((57344 & i) == 0) {
                        i4 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                    }
                    if ((46811 & i4) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 4) == 0) {
                                z3 = true;
                                sliderColorsM17285colorsq0g_0yA = m17285colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, (i4 >> 12) & 14, 1023);
                                composer2 = composerStartRestartGroup;
                                i4 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                z3 = true;
                                sliderColorsM17285colorsq0g_0yA = sliderColors2;
                            }
                            if (i5 == 0) {
                                sliderColors3 = sliderColorsM17285colorsq0g_0yA;
                                modifier3 = modifier5;
                                z4 = z3 ? 1 : 0;
                                r5 = z3;
                            } else {
                                z4 = z;
                                sliderColors3 = sliderColorsM17285colorsq0g_0yA;
                                modifier3 = modifier5;
                                r5 = z3;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            sliderColors3 = sliderColors2;
                            z4 = z2;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier2;
                            r5 = 1;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1546713545, i4, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:731)");
                        }
                        int i9 = ((i4 >> 9) & 14) | 48 | (i4 & 896);
                        stateTrackColor$material3_release = sliderColors3.trackColor$material3_release(z4, false, composer2, i9);
                        stateTrackColor$material3_release2 = sliderColors3.trackColor$material3_release(z4, r5, composer2, i9);
                        stateTickColor$material3_release = sliderColors3.tickColor$material3_release(z4, false, composer2, i9);
                        stateTickColor$material3_release2 = sliderColors3.tickColor$material3_release(z4, r5, composer2, i9);
                        Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, r5, null), SliderKt.getTrackHeight());
                        Object[] objArr = {stateTrackColor$material3_release, sliderPositions, stateTrackColor$material3_release2, stateTickColor$material3_release, stateTickColor$material3_release2};
                        composer2.startReplaceableGroup(-568225417);
                        zChanged = false;
                        for (i6 = 0; i6 < 5; i6++) {
                            zChanged |= composer2.changed(objArr[i6]);
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            Function1<DrawScope, Unit> function1 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
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
                                    boolean z6 = Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                                    long jOffset = OffsetKt.Offset(0.0f, Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                                    long jOffset2 = OffsetKt.Offset(Size.m18353getWidthimpl(Canvas.mo19076getSizeNHjbRc()), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                                    long j = z6 ? jOffset2 : jOffset;
                                    long j2 = z6 ? jOffset : jOffset2;
                                    float fMo15546toPx0680j_4 = Canvas.mo15546toPx0680j_4(SliderKt.TickSize);
                                    float fMo15546toPx0680j_42 = Canvas.mo15546toPx0680j_4(SliderKt.getTrackHeight());
                                    long jM18535unboximpl = stateTrackColor$material3_release.getValue().m18535unboximpl();
                                    StrokeCap.Companion companion = StrokeCap.INSTANCE;
                                    DrawScope.m19062drawLineNGM6Ib0$default(Canvas, jM18535unboximpl, j, j2, fMo15546toPx0680j_42, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                    long j3 = j;
                                    long j5 = j2;
                                    DrawScope.m19062drawLineNGM6Ib0$default(Canvas, stateTrackColor$material3_release2.getValue().m18535unboximpl(), OffsetKt.Offset(((Offset.m18284getXimpl(j2) - Offset.m18284getXimpl(j)) * 0.0f) + Offset.m18284getXimpl(j), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), OffsetKt.Offset((sliderPositions.getPositionFraction() * (Offset.m18284getXimpl(j2) - Offset.m18284getXimpl(j))) + Offset.m18284getXimpl(j), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), fMo15546toPx0680j_42, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                    float[] tickFractions = sliderPositions.getTickFractions();
                                    SliderPositions sliderPositions2 = sliderPositions;
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    int length = tickFractions.length;
                                    for (int i10 = 0; i10 < length; i10++) {
                                        float f = tickFractions[i10];
                                        Boolean boolValueOf = Boolean.valueOf(f > sliderPositions2.getPositionFraction() || f < 0.0f);
                                        Object arrayList = linkedHashMap.get(boolValueOf);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                            linkedHashMap.put(boolValueOf, arrayList);
                                        }
                                        ((List) arrayList).add(Float.valueOf(f));
                                    }
                                    State<Color> state = stateTickColor$material3_release;
                                    State<Color> state2 = stateTickColor$material3_release2;
                                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                                        boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                                        List list = (List) entry.getValue();
                                        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(list));
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            arrayList2.add(Offset.m18273boximpl(OffsetKt.Offset(Offset.m18284getXimpl(OffsetKt.m18307lerpWko1d7g(j3, j5, ((Number) it.next()).floatValue())), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()))));
                                        }
                                        long j6 = j3;
                                        long j7 = j5;
                                        DrawScope.m19067drawPointsF8ZwMP8$default(Canvas, arrayList2, PointMode.INSTANCE.m18831getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m18535unboximpl(), fMo15546toPx0680j_4, StrokeCap.INSTANCE.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                        j3 = j6;
                                        j5 = j7;
                                    }
                                }
                            };
                            composer2.updateRememberedValue(function1);
                            objRememberedValue = function1;
                        }
                        composer2.endReplaceableGroup();
                        CanvasKt.Canvas(modifierM15885height3ABfNKs, (Function1) objRememberedValue, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        sliderColors4 = sliderColors3;
                        z5 = z4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        sliderColors4 = sliderColors2;
                        z5 = z2;
                        composer2 = composerStartRestartGroup;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults.Track.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i10) {
                            SliderDefaults.this.Track(sliderPositions, modifier4, sliderColors4, z5, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 24576;
                if ((46811 & i4) == 9362) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 == 0) {
                        }
                        if ((i2 & 4) == 0) {
                        }
                        if (i5 == 0) {
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = ((i4 >> 9) & 14) | 48 | (i4 & 896);
                        stateTrackColor$material3_release = sliderColors3.trackColor$material3_release(z4, false, composer2, i92);
                        stateTrackColor$material3_release2 = sliderColors3.trackColor$material3_release(z4, r5, composer2, i92);
                        stateTickColor$material3_release = sliderColors3.tickColor$material3_release(z4, false, composer2, i92);
                        stateTickColor$material3_release2 = sliderColors3.tickColor$material3_release(z4, r5, composer2, i92);
                        Modifier modifierM15885height3ABfNKs2 = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, r5, null), SliderKt.getTrackHeight());
                        Object[] objArr2 = {stateTrackColor$material3_release, sliderPositions, stateTrackColor$material3_release2, stateTickColor$material3_release, stateTickColor$material3_release2};
                        composer2.startReplaceableGroup(-568225417);
                        zChanged = false;
                        while (i6 < 5) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!zChanged) {
                            Function1<DrawScope, Unit> function12 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
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
                                    boolean z6 = Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                                    long jOffset = OffsetKt.Offset(0.0f, Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                                    long jOffset2 = OffsetKt.Offset(Size.m18353getWidthimpl(Canvas.mo19076getSizeNHjbRc()), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()));
                                    long j = z6 ? jOffset2 : jOffset;
                                    long j2 = z6 ? jOffset : jOffset2;
                                    float fMo15546toPx0680j_4 = Canvas.mo15546toPx0680j_4(SliderKt.TickSize);
                                    float fMo15546toPx0680j_42 = Canvas.mo15546toPx0680j_4(SliderKt.getTrackHeight());
                                    long jM18535unboximpl = stateTrackColor$material3_release.getValue().m18535unboximpl();
                                    StrokeCap.Companion companion = StrokeCap.INSTANCE;
                                    DrawScope.m19062drawLineNGM6Ib0$default(Canvas, jM18535unboximpl, j, j2, fMo15546toPx0680j_42, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                    long j3 = j;
                                    long j5 = j2;
                                    DrawScope.m19062drawLineNGM6Ib0$default(Canvas, stateTrackColor$material3_release2.getValue().m18535unboximpl(), OffsetKt.Offset(((Offset.m18284getXimpl(j2) - Offset.m18284getXimpl(j)) * 0.0f) + Offset.m18284getXimpl(j), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), OffsetKt.Offset((sliderPositions.getPositionFraction() * (Offset.m18284getXimpl(j2) - Offset.m18284getXimpl(j))) + Offset.m18284getXimpl(j), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0())), fMo15546toPx0680j_42, companion.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                    float[] tickFractions = sliderPositions.getTickFractions();
                                    SliderPositions sliderPositions2 = sliderPositions;
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    int length = tickFractions.length;
                                    for (int i10 = 0; i10 < length; i10++) {
                                        float f = tickFractions[i10];
                                        Boolean boolValueOf = Boolean.valueOf(f > sliderPositions2.getPositionFraction() || f < 0.0f);
                                        Object arrayList = linkedHashMap.get(boolValueOf);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                            linkedHashMap.put(boolValueOf, arrayList);
                                        }
                                        ((List) arrayList).add(Float.valueOf(f));
                                    }
                                    State<Color> state = stateTickColor$material3_release;
                                    State<Color> state2 = stateTickColor$material3_release2;
                                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                                        boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                                        List list = (List) entry.getValue();
                                        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(list));
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            arrayList2.add(Offset.m18273boximpl(OffsetKt.Offset(Offset.m18284getXimpl(OffsetKt.m18307lerpWko1d7g(j3, j5, ((Number) it.next()).floatValue())), Offset.m18285getYimpl(Canvas.mo19075getCenterF1C5BW0()))));
                                        }
                                        long j6 = j3;
                                        long j7 = j5;
                                        DrawScope.m19067drawPointsF8ZwMP8$default(Canvas, arrayList2, PointMode.INSTANCE.m18831getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m18535unboximpl(), fMo15546toPx0680j_4, StrokeCap.INSTANCE.m18879getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                        j3 = j6;
                                        j5 = j7;
                                    }
                                }
                            };
                            composer2.updateRememberedValue(function12);
                            objRememberedValue = function12;
                            composer2.endReplaceableGroup();
                            CanvasKt.Canvas(modifierM15885height3ABfNKs2, (Function1) objRememberedValue, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            sliderColors4 = sliderColors3;
                            z5 = z4;
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i2 & 16) == 0) {
            }
            if ((46811 & i4) == 9362) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 16) == 0) {
        }
        if ((46811 & i4) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m17285colorsq0g_0yA(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, @Nullable Composer composer, int i, int i2, int i4) {
        composer.startReplaceableGroup(885588574);
        long color = (i4 & 1) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getHandleColor(), composer, 6) : j;
        long color2 = (i4 & 2) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getActiveTrackColor(), composer, 6) : j2;
        long jM18524copywmQWz5c$default = (i4 & 4) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksActiveContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long color3 = (i4 & 8) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getInactiveTrackColor(), composer, 6) : j5;
        long jM18524copywmQWz5c$default2 = (i4 & 16) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksInactiveContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM18570compositeOverOWjLjI = (i4 & 32) != 0 ? ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m17062getSurface0d7_KjU()) : j7;
        long jM18524copywmQWz5c$default3 = (i4 & 64) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledActiveTrackColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long jM18524copywmQWz5c$default4 = (i4 & 128) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long jM18524copywmQWz5c$default5 = (i4 & 256) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledInactiveTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM18524copywmQWz5c$default6 = (i4 & 512) != 0 ? Color.m18524copywmQWz5c$default(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:618)");
        }
        SliderColors sliderColors = new SliderColors(color, color2, jM18524copywmQWz5c$default, color3, jM18524copywmQWz5c$default2, jM18570compositeOverOWjLjI, jM18524copywmQWz5c$default3, jM18524copywmQWz5c$default4, jM18524copywmQWz5c$default5, jM18524copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sliderColors;
    }
}
