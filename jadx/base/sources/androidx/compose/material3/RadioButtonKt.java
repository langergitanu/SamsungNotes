package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
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
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m13886d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = C2256Dp.m20968constructorimpl(12);
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    static {
        float f = 2;
        RadioButtonPadding = C2256Dp.m20968constructorimpl(f);
        RadioStrokeWidth = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0135  */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v21 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, @Nullable final Function0<Unit> function0, @Nullable Modifier modifier, boolean z2, @Nullable RadioButtonColors radioButtonColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        RadioButtonColors radioButtonColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        boolean z4;
        RadioButtonColors radioButtonColorsM17279colorsro_MJ88;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        int i7;
        RadioButtonColors radioButtonColors3;
        ?? r10;
        int i8;
        final State<Color> state;
        final boolean z5;
        State state2;
        Object obj;
        RadioButtonColors radioButtonColors4;
        Modifier modifierM16105selectableO2vRcR0;
        final State state3;
        boolean zChanged;
        Object objRememberedValue;
        final MutableInteractionSource mutableInteractionSource4;
        final RadioButtonColors radioButtonColors5;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(408580840);
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
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        radioButtonColors2 = radioButtonColors;
                        int i10 = composerStartRestartGroup.changed(radioButtonColors2) ? 16384 : 8192;
                        i4 |= i10;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    i4 |= i10;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                    if ((458752 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((374491 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            z4 = i5 == 0 ? true : z3;
                            if ((i2 & 16) == 0) {
                                radioButtonColorsM17279colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m17279colorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i4 &= -57345;
                            } else {
                                radioButtonColorsM17279colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i6 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                modifier3 = modifier5;
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue2;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier3 = modifier5;
                            }
                            i7 = i4;
                            radioButtonColors3 = radioButtonColorsM17279colorsro_MJ88;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            i7 = i4;
                            modifier3 = modifier2;
                            z4 = z3;
                            radioButtonColors3 = radioButtonColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(408580840, i7, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:72)");
                        }
                        State stateM15303animateDpAsStateKz89ssw = AnimateAsStateKt.m15303animateDpAsStateKz89ssw(!z ? C2256Dp.m20968constructorimpl(RadioButtonDotSize / 2) : C2256Dp.m20968constructorimpl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                        State<Color> stateRadioColor$material3_release = radioButtonColors3.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i7 >> 6) & 896) | ((i7 >> 9) & 14) | ((i7 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(735546407);
                        if (function0 == null) {
                            state2 = stateM15303animateDpAsStateKz89ssw;
                            Composer composer2 = composerStartRestartGroup;
                            obj = null;
                            composerStartRestartGroup = composer2;
                            radioButtonColors4 = radioButtonColors3;
                            state = stateRadioColor$material3_release;
                            i8 = 2;
                            z5 = z4;
                            r10 = 0;
                            modifierM16105selectableO2vRcR0 = SelectableKt.m16105selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource3, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(RadioButtonTokens.INSTANCE.m17874getStateLayerSizeD9Ej5fM() / 2), 0L, composer2, 54, 4), z5, Role.m20259boximpl(Role.INSTANCE.m20270getRadioButtono7Vup1c()), function0);
                        } else {
                            r10 = 0;
                            i8 = 2;
                            state = stateRadioColor$material3_release;
                            z5 = z4;
                            state2 = stateM15303animateDpAsStateKz89ssw;
                            obj = null;
                            radioButtonColors4 = radioButtonColors3;
                            modifierM16105selectableO2vRcR0 = Modifier.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierM15891requiredSize3ABfNKs = SizeKt.m15891requiredSize3ABfNKs(PaddingKt.m15854padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(function0 == null ? TouchTargetKt.minimumTouchTargetSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(modifierM16105selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r10, i8, obj), RadioButtonPadding), RadioButtonTokens.INSTANCE.m17873getIconSizeD9Ej5fM());
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        state3 = state2;
                        zChanged = composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(state3);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$2$1
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
                                    float f = 2;
                                    float f4 = fMo15546toPx0680j_4 / f;
                                    DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(C2256Dp.m20968constructorimpl(RadioButtonTokens.INSTANCE.m17873getIconSizeD9Ej5fM() / f)) - f4, 0L, 0.0f, new Stroke(fMo15546toPx0680j_4, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                    if (C2256Dp.m20967compareTo0680j_4(state3.getValue().m20982unboximpl(), C2256Dp.m20968constructorimpl(0)) > 0) {
                                        DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(state3.getValue().m20982unboximpl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(modifierM15891requiredSize3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, r10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColors5 = radioButtonColors4;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z3;
                        radioButtonColors5 = radioButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.RadioButtonKt.RadioButton.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i11) {
                            RadioButtonKt.RadioButton(z, function0, modifier4, z5, radioButtonColors5, mutableInteractionSource4, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        if (i6 == 0) {
                        }
                        i7 = i4;
                        radioButtonColors3 = radioButtonColorsM17279colorsro_MJ88;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        State stateM15303animateDpAsStateKz89ssw2 = AnimateAsStateKt.m15303animateDpAsStateKz89ssw(!z ? C2256Dp.m20968constructorimpl(RadioButtonDotSize / 2) : C2256Dp.m20968constructorimpl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                        State<Color> stateRadioColor$material3_release2 = radioButtonColors3.radioColor$material3_release(z4, z, composerStartRestartGroup, ((i7 >> 6) & 896) | ((i7 >> 9) & 14) | ((i7 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(735546407);
                        if (function0 == null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierM15891requiredSize3ABfNKs2 = SizeKt.m15891requiredSize3ABfNKs(PaddingKt.m15854padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(function0 == null ? TouchTargetKt.minimumTouchTargetSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(modifierM16105selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r10, i8, obj), RadioButtonPadding), RadioButtonTokens.INSTANCE.m17873getIconSizeD9Ej5fM());
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        state3 = state2;
                        zChanged = composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(state3);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$2$1
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
                                    float f = 2;
                                    float f4 = fMo15546toPx0680j_4 / f;
                                    DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(C2256Dp.m20968constructorimpl(RadioButtonTokens.INSTANCE.m17873getIconSizeD9Ej5fM() / f)) - f4, 0L, 0.0f, new Stroke(fMo15546toPx0680j_4, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                    if (C2256Dp.m20967compareTo0680j_4(state3.getValue().m20982unboximpl(), C2256Dp.m20968constructorimpl(0)) > 0) {
                                        DrawScope.m19057drawCircleVaOC9Bg$default(Canvas, state.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(state3.getValue().m20982unboximpl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            composerStartRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(modifierM15891requiredSize3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, r10);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColors5 = radioButtonColors4;
                            modifier4 = modifier3;
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
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
        z3 = z2;
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
