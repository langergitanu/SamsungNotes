package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m13886d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius = C2256Dp.m20968constructorimpl(24);
    private static final float RadioButtonSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;

    static {
        float f = 2;
        RadioButtonPadding = C2256Dp.m20968constructorimpl(f);
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(20);
        RadioButtonSize = fM20968constructorimpl;
        RadioRadius = C2256Dp.m20968constructorimpl(fM20968constructorimpl / f);
        RadioButtonDotSize = C2256Dp.m20968constructorimpl(12);
        RadioStrokeWidth = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0231 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0133  */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v16 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, @Nullable final Function0<Unit> function0, @Nullable Modifier modifier, boolean z2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable RadioButtonColors radioButtonColors, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        RadioButtonColors radioButtonColors2;
        Modifier modifier3;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        int i7;
        RadioButtonColors radioButtonColorsM16842colorsRGew2ao;
        MutableInteractionSource mutableInteractionSource4;
        int i8;
        final boolean z5;
        State state;
        State<Color> state2;
        ?? r9;
        Modifier modifier4;
        Modifier modifierM16105selectableO2vRcR0;
        final State<Color> state3;
        final State state4;
        boolean zChanged;
        Object objRememberedValue;
        final MutableInteractionSource mutableInteractionSource5;
        final Modifier modifier5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1314435585);
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
            i4 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
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
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 == 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            radioButtonColors2 = radioButtonColors;
                            int i10 = composerStartRestartGroup.changed(radioButtonColors2) ? 131072 : 65536;
                            i4 |= i10;
                        } else {
                            radioButtonColors2 = radioButtonColors;
                        }
                        i4 |= i10;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            z4 = i5 == 0 ? true : z3;
                            if (i6 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue2;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) == 0) {
                                composer2 = composerStartRestartGroup;
                                i7 = i4 & (-458753);
                                radioButtonColorsM16842colorsRGew2ao = RadioButtonDefaults.INSTANCE.m16842colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                            } else {
                                composer2 = composerStartRestartGroup;
                                i7 = i4;
                                radioButtonColorsM16842colorsRGew2ao = radioButtonColors2;
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            i7 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            composer2 = composerStartRestartGroup;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            radioButtonColorsM16842colorsRGew2ao = radioButtonColors2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1314435585, i7, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
                        }
                        composerStartRestartGroup = composer2;
                        State stateM15303animateDpAsStateKz89ssw = AnimateAsStateKt.m15303animateDpAsStateKz89ssw(!z ? C2256Dp.m20968constructorimpl(RadioButtonDotSize / 2) : C2256Dp.m20968constructorimpl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                        int i11 = i7 >> 9;
                        State<Color> stateRadioColor = radioButtonColorsM16842colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, (i11 & 896) | (i11 & 14) | ((i7 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(1941632354);
                        if (function0 == null) {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            int iM20270getRadioButtono7Vup1c = Role.INSTANCE.m20270getRadioButtono7Vup1c();
                            state = stateM15303animateDpAsStateKz89ssw;
                            state2 = stateRadioColor;
                            Indication indicationM16977rememberRipple9IZ8Weo = RippleKt.m16977rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4);
                            composerStartRestartGroup = composerStartRestartGroup;
                            radioButtonColors2 = radioButtonColorsM16842colorsRGew2ao;
                            i8 = 2;
                            z5 = z4;
                            modifier4 = modifier3;
                            r9 = 0;
                            modifierM16105selectableO2vRcR0 = SelectableKt.m16105selectableO2vRcR0(companion, z, mutableInteractionSource4, indicationM16977rememberRipple9IZ8Weo, z5, Role.m20259boximpl(iM20270getRadioButtono7Vup1c), function0);
                        } else {
                            radioButtonColors2 = radioButtonColorsM16842colorsRGew2ao;
                            i8 = 2;
                            z5 = z4;
                            state = stateM15303animateDpAsStateKz89ssw;
                            state2 = stateRadioColor;
                            r9 = 0;
                            modifier4 = modifier3;
                            modifierM16105selectableO2vRcR0 = Modifier.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierMinimumTouchTargetSize = Modifier.INSTANCE;
                        if (function0 != null) {
                            modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifierMinimumTouchTargetSize);
                        }
                        Modifier modifierM15891requiredSize3ABfNKs = SizeKt.m15891requiredSize3ABfNKs(PaddingKt.m15854padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumTouchTargetSize).then(modifierM16105selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r9, i8, null), RadioButtonPadding), RadioButtonSize);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        state3 = state2;
                        state4 = state;
                        zChanged = composerStartRestartGroup.changed(state3) | composerStartRestartGroup.changed(state4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                    float fMo15546toPx0680j_4 = Canvas.mo15546toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                    float f = fMo15546toPx0680j_4 / 2;
                                    DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state3.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(RadioButtonKt.RadioRadius) - f, 0L, 0.0f, new Stroke(fMo15546toPx0680j_4, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                    if (C2256Dp.m20967compareTo0680j_4(state4.getValue().m20982unboximpl(), C2256Dp.m20968constructorimpl(0)) > 0) {
                                        DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state3.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(state4.getValue().m20982unboximpl()) - f, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(modifierM15891requiredSize3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, r9);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                        modifier5 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier5 = modifier2;
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource2;
                    }
                    final RadioButtonColors radioButtonColors3 = radioButtonColors2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i12) {
                            RadioButtonKt.RadioButton(z, function0, modifier5, z5, mutableInteractionSource5, radioButtonColors3, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) != 0) {
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
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup = composer2;
                        State stateM15303animateDpAsStateKz89ssw2 = AnimateAsStateKt.m15303animateDpAsStateKz89ssw(!z ? C2256Dp.m20968constructorimpl(RadioButtonDotSize / 2) : C2256Dp.m20968constructorimpl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                        int i112 = i7 >> 9;
                        State<Color> stateRadioColor2 = radioButtonColorsM16842colorsRGew2ao.radioColor(z4, z, composerStartRestartGroup, (i112 & 896) | (i112 & 14) | ((i7 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(1941632354);
                        if (function0 == null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierMinimumTouchTargetSize2 = Modifier.INSTANCE;
                        if (function0 != null) {
                        }
                        Modifier modifierM15891requiredSize3ABfNKs2 = SizeKt.m15891requiredSize3ABfNKs(PaddingKt.m15854padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(modifierMinimumTouchTargetSize2).then(modifierM16105selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r9, i8, null), RadioButtonPadding), RadioButtonSize);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        state3 = state2;
                        state4 = state;
                        zChanged = composerStartRestartGroup.changed(state3) | composerStartRestartGroup.changed(state4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                    float fMo15546toPx0680j_4 = Canvas.mo15546toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                    float f = fMo15546toPx0680j_4 / 2;
                                    DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state3.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(RadioButtonKt.RadioRadius) - f, 0L, 0.0f, new Stroke(fMo15546toPx0680j_4, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                    if (C2256Dp.m20967compareTo0680j_4(state4.getValue().m20982unboximpl(), C2256Dp.m20968constructorimpl(0)) > 0) {
                                        DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state3.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(state4.getValue().m20982unboximpl()) - f, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            composerStartRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(modifierM15891requiredSize3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, r9);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource5 = mutableInteractionSource4;
                            modifier5 = modifier4;
                        }
                    }
                }
                final RadioButtonColors radioButtonColors32 = radioButtonColors2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) != 0) {
            }
            if ((374491 & i4) == 74898) {
            }
            final RadioButtonColors radioButtonColors322 = radioButtonColors2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) != 0) {
        }
        if ((374491 & i4) == 74898) {
        }
        final RadioButtonColors radioButtonColors3222 = radioButtonColors2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
