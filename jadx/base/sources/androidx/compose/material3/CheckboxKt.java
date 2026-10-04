package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.CornerRadiusKt;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.graphics.drawscope.Stroke;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.state.ToggleableState;
import androidx.compose.p109ui.state.ToggleableStateKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aA\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, m13886d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = C2256Dp.m20968constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = C2256Dp.m20968constructorimpl(f);
        StrokeWidth = C2256Dp.m20968constructorimpl(f);
        RadiusSize = C2256Dp.m20968constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x019f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0136  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, @Nullable final Function1<? super Boolean, Unit> function1, @Nullable Modifier modifier, boolean z2, @Nullable CheckboxColors checkboxColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        CheckboxColors checkboxColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        boolean z4;
        CheckboxColors checkboxColors3;
        Function0 function0;
        final Modifier modifier4;
        final boolean z5;
        final CheckboxColors checkboxColors4;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1406741137);
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
        int i7 = i2 & 4;
        if (i7 != 0) {
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
                        checkboxColors2 = checkboxColors;
                        int i8 = composerStartRestartGroup.changed(checkboxColors2) ? 16384 : 8192;
                        i4 |= i8;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i4 |= i8;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            Modifier modifier5 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i5 == 0 ? true : z3;
                            if ((i2 & 16) != 0) {
                                CheckboxColors checkboxColorsM17024colors5tl4gsc = CheckboxDefaults.INSTANCE.m17024colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i4 &= -57345;
                                checkboxColors2 = checkboxColorsM17024colors5tl4gsc;
                            }
                            if (i6 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                modifier3 = modifier5;
                                z4 = z6;
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier3 = modifier5;
                                z4 = z6;
                            }
                            checkboxColors3 = checkboxColors2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            z4 = z3;
                            checkboxColors3 = checkboxColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier3 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1406741137, i4, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
                        }
                        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                        if (function1 == null) {
                            Boolean boolValueOf = Boolean.valueOf(z);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(function1);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material3.CheckboxKt$Checkbox$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        function1.invoke(Boolean.valueOf(!z));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            function0 = (Function0) objRememberedValue2;
                        } else {
                            function0 = null;
                        }
                        TriStateCheckbox(ToggleableState, function0, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i4 & 524160, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z5 = z4;
                        checkboxColors4 = checkboxColors3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z3;
                        checkboxColors4 = checkboxColors2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt.Checkbox.3
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

                        public final void invoke(@Nullable Composer composer2, int i9) {
                            CheckboxKt.Checkbox(z, function1, modifier4, z5, checkboxColors4, mutableInteractionSource4, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i6 == 0) {
                        }
                        checkboxColors3 = checkboxColors2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                        if (function1 == null) {
                        }
                        TriStateCheckbox(ToggleableState2, function0, modifier3, z4, checkboxColors3, mutableInteractionSource3, composerStartRestartGroup, i4 & 524160, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z5 = z4;
                        checkboxColors4 = checkboxColors3;
                        mutableInteractionSource4 = mutableInteractionSource3;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0265 A[LOOP:0: B:111:0x0262->B:113:0x0265, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c7  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, Composer composer, final int i) {
        float f;
        Transition transition;
        Float f4;
        int i2;
        float f5;
        final State stateCreateTransitionAnimation;
        int i4;
        int i5;
        float f6;
        int i6;
        int i7;
        final State stateCreateTransitionAnimation2;
        Object objRememberedValue;
        final CheckDrawingCache checkDrawingCache;
        final State<Color> stateCheckmarkColor$material3_release;
        final State<Color> stateBoxColor$material3_release;
        final State<Color> stateBorderColor$material3_release;
        int i8;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2007131616);
        int i9 = (i & 14) == 0 ? (composerStartRestartGroup.changed(z) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i9 |= composerStartRestartGroup.changed(toggleableState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i9 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i9 |= composerStartRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        if ((i9 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007131616, i9, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:227)");
            }
            int i10 = i9 >> 3;
            int i11 = i10 & 14;
            int i12 = i9;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i11, 2);
            CheckboxKt$CheckboxImpl$checkDrawFraction$1 checkboxKt$CheckboxImpl$checkDrawFraction$1 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                @NotNull
                public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<ToggleableState> animateFloat, @Nullable Composer composer2, int i13) {
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(1373301606);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1373301606, i13, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:235)");
                    }
                    ToggleableState initialState = animateFloat.getInitialState();
                    ToggleableState toggleableState2 = ToggleableState.Off;
                    FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = initialState == toggleableState2 ? AnimationSpecKt.tween$default(100, 0, null, 6, null) : animateFloat.getTargetState() == toggleableState2 ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return finiteAnimationSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(floatCompanionObject);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            ToggleableState toggleableState2 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(1800065638);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:242)");
            }
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i13 = iArr[toggleableState2.ordinal()];
            float f7 = 0.0f;
            if (i13 == 1) {
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf = Float.valueOf(f);
                ToggleableState toggleableState3 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(1800065638);
                if (ComposerKt.isTraceInProgress()) {
                    transition = transitionUpdateTransition;
                    f4 = fValueOf;
                    ComposerKt.traceEventStart(1800065638, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:242)");
                } else {
                    transition = transitionUpdateTransition;
                    f4 = fValueOf;
                }
                i2 = iArr[toggleableState3.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        f5 = 0.0f;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Transition transition2 = transition;
                        stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, f4, Float.valueOf(f5), checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                                return invoke(segment, composer2, num.intValue());
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            @NotNull
                            public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<ToggleableState> animateFloat, @Nullable Composer composer2, int i14) {
                                Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                                composer2.startReplaceableGroup(-1324481169);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1324481169, i14, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:251)");
                                }
                                ToggleableState initialState = animateFloat.getInitialState();
                                ToggleableState toggleableState4 = ToggleableState.Off;
                                FiniteAnimationSpec<Float> finiteAnimationSpecSnap$default = initialState == toggleableState4 ? AnimationSpecKt.snap$default(0, 1, null) : animateFloat.getTargetState() == toggleableState4 ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2.endReplaceableGroup();
                                return finiteAnimationSpecSnap$default;
                            }
                        };
                        composerStartRestartGroup.startReplaceableGroup(1399891485);
                        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                        composerStartRestartGroup.startReplaceableGroup(1847725064);
                        ToggleableState toggleableState4 = (ToggleableState) transition2.getCurrentState();
                        composerStartRestartGroup.startReplaceableGroup(-1426969489);
                        if (ComposerKt.isTraceInProgress()) {
                            i4 = -1;
                        } else {
                            i4 = -1;
                            ComposerKt.traceEventStart(-1426969489, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:258)");
                        }
                        i5 = iArr[toggleableState4.ordinal()];
                        if (i5 != 1 || i5 == 2) {
                            f6 = 0.0f;
                        } else {
                            if (i5 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            f6 = 1.0f;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Float fValueOf2 = Float.valueOf(f6);
                        ToggleableState toggleableState5 = (ToggleableState) transition2.getTargetState();
                        composerStartRestartGroup.startReplaceableGroup(-1426969489);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1426969489, 0, i4, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:258)");
                        }
                        i6 = iArr[toggleableState5.ordinal()];
                        if (i6 == 1) {
                            i7 = 2;
                            if (i6 != 2) {
                                if (i6 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                f7 = 1.0f;
                            }
                        } else {
                            i7 = 2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i14 = i7;
                        stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition2, fValueOf2, Float.valueOf(f7), checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.invoke(transition2.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                        stateCheckmarkColor$material3_release = checkboxColors.checkmarkColor$material3_release(toggleableState, composerStartRestartGroup, i11 | ((i12 >> 6) & 112));
                        int i15 = (i12 & 126) | (i10 & 896);
                        stateBoxColor$material3_release = checkboxColors.boxColor$material3_release(z, toggleableState, composerStartRestartGroup, i15);
                        stateBorderColor$material3_release = checkboxColors.borderColor$material3_release(z, toggleableState, composerStartRestartGroup, i15);
                        Modifier modifierM15891requiredSize3ABfNKs = SizeKt.m15891requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, i14, null), CheckboxSize);
                        Object[] objArr = {stateBoxColor$material3_release, stateBorderColor$material3_release, stateCheckmarkColor$material3_release, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache};
                        composerStartRestartGroup.startReplaceableGroup(-568225417);
                        zChanged = false;
                        for (i8 = 0; i8 < 6; i8++) {
                            zChanged |= composerStartRestartGroup.changed(objArr[i8]);
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
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
                                    float fFloor = (float) Math.floor(Canvas.mo15546toPx0680j_4(CheckboxKt.StrokeWidth));
                                    CheckboxKt.m17027drawBox1wkBAMs(Canvas, stateBoxColor$material3_release.getValue().m18535unboximpl(), stateBorderColor$material3_release.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(CheckboxKt.RadiusSize), fFloor);
                                    CheckboxKt.m17028drawCheck3IgeMak(Canvas, stateCheckmarkColor$material3_release.getValue().m18535unboximpl(), stateCreateTransitionAnimation.getValue().floatValue(), stateCreateTransitionAnimation2.getValue().floatValue(), fFloor, checkDrawingCache);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(modifierM15891requiredSize3ABfNKs, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                f5 = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Transition transition22 = transition;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition22, f4, Float.valueOf(f5), checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$12 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    @NotNull
                    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<ToggleableState> animateFloat, @Nullable Composer composer2, int i142) {
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(-1324481169);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1324481169, i142, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:251)");
                        }
                        ToggleableState initialState = animateFloat.getInitialState();
                        ToggleableState toggleableState42 = ToggleableState.Off;
                        FiniteAnimationSpec<Float> finiteAnimationSpecSnap$default = initialState == toggleableState42 ? AnimationSpecKt.snap$default(0, 1, null) : animateFloat.getTargetState() == toggleableState42 ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return finiteAnimationSpecSnap$default;
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1399891485);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                composerStartRestartGroup.startReplaceableGroup(1847725064);
                ToggleableState toggleableState42 = (ToggleableState) transition22.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(-1426969489);
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = iArr[toggleableState42.ordinal()];
                if (i5 != 1) {
                    f6 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Float fValueOf22 = Float.valueOf(f6);
                    ToggleableState toggleableState52 = (ToggleableState) transition22.getTargetState();
                    composerStartRestartGroup.startReplaceableGroup(-1426969489);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = iArr[toggleableState52.ordinal()];
                    if (i6 == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i142 = i7;
                    stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition22, fValueOf22, Float.valueOf(f7), checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$12.invoke(transition22.getSegment(), composerStartRestartGroup, 0), vectorConverter22, "FloatAnimation", composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                    stateCheckmarkColor$material3_release = checkboxColors.checkmarkColor$material3_release(toggleableState, composerStartRestartGroup, i11 | ((i12 >> 6) & 112));
                    int i152 = (i12 & 126) | (i10 & 896);
                    stateBoxColor$material3_release = checkboxColors.boxColor$material3_release(z, toggleableState, composerStartRestartGroup, i152);
                    stateBorderColor$material3_release = checkboxColors.borderColor$material3_release(z, toggleableState, composerStartRestartGroup, i152);
                    Modifier modifierM15891requiredSize3ABfNKs2 = SizeKt.m15891requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, i142, null), CheckboxSize);
                    Object[] objArr2 = {stateBoxColor$material3_release, stateBorderColor$material3_release, stateCheckmarkColor$material3_release, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache};
                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                    zChanged = false;
                    while (i8 < 6) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
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
                                float fFloor = (float) Math.floor(Canvas.mo15546toPx0680j_4(CheckboxKt.StrokeWidth));
                                CheckboxKt.m17027drawBox1wkBAMs(Canvas, stateBoxColor$material3_release.getValue().m18535unboximpl(), stateBorderColor$material3_release.getValue().m18535unboximpl(), Canvas.mo15546toPx0680j_4(CheckboxKt.RadiusSize), fFloor);
                                CheckboxKt.m17028drawCheck3IgeMak(Canvas, stateCheckmarkColor$material3_release.getValue().m18535unboximpl(), stateCreateTransitionAnimation.getValue().floatValue(), stateCreateTransitionAnimation2.getValue().floatValue(), fFloor, checkDrawingCache);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(modifierM15891requiredSize3ABfNKs2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
            } else if (i13 != 2) {
                if (i13 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf3 = Float.valueOf(f);
                ToggleableState toggleableState32 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(1800065638);
                if (ComposerKt.isTraceInProgress()) {
                }
                i2 = iArr[toggleableState32.ordinal()];
                if (i2 != 1) {
                }
                f5 = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Transition transition222 = transition;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition222, f4, Float.valueOf(f5), checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$122 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    @NotNull
                    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<ToggleableState> animateFloat, @Nullable Composer composer2, int i1422) {
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(-1324481169);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1324481169, i1422, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:251)");
                        }
                        ToggleableState initialState = animateFloat.getInitialState();
                        ToggleableState toggleableState422 = ToggleableState.Off;
                        FiniteAnimationSpec<Float> finiteAnimationSpecSnap$default = initialState == toggleableState422 ? AnimationSpecKt.snap$default(0, 1, null) : animateFloat.getTargetState() == toggleableState422 ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return finiteAnimationSpecSnap$default;
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1399891485);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                composerStartRestartGroup.startReplaceableGroup(1847725064);
                ToggleableState toggleableState422 = (ToggleableState) transition222.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(-1426969489);
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = iArr[toggleableState422.ordinal()];
                if (i5 != 1) {
                }
            } else {
                f = 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf32 = Float.valueOf(f);
                ToggleableState toggleableState322 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(1800065638);
                if (ComposerKt.isTraceInProgress()) {
                }
                i2 = iArr[toggleableState322.ordinal()];
                if (i2 != 1) {
                }
                f5 = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Transition transition2222 = transition;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition2222, f4, Float.valueOf(f5), checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1222 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    @NotNull
                    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<ToggleableState> animateFloat, @Nullable Composer composer2, int i1422) {
                        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                        composer2.startReplaceableGroup(-1324481169);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1324481169, i1422, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:251)");
                        }
                        ToggleableState initialState = animateFloat.getInitialState();
                        ToggleableState toggleableState4222 = ToggleableState.Off;
                        FiniteAnimationSpec<Float> finiteAnimationSpecSnap$default = initialState == toggleableState4222 ? AnimationSpecKt.snap$default(0, 1, null) : animateFloat.getTargetState() == toggleableState4222 ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return finiteAnimationSpecSnap$default;
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(1399891485);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2222 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                composerStartRestartGroup.startReplaceableGroup(1847725064);
                ToggleableState toggleableState4222 = (ToggleableState) transition2222.getCurrentState();
                composerStartRestartGroup.startReplaceableGroup(-1426969489);
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = iArr[toggleableState4222.ordinal()];
                if (i5 != 1) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt.CheckboxImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i16) {
                CheckboxKt.CheckboxImpl(z, toggleableState, modifier, checkboxColors, composer2, i | 1);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(@NotNull final ToggleableState state, @Nullable final Function0<Unit> function0, @Nullable Modifier modifier, boolean z, @Nullable CheckboxColors checkboxColors, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        CheckboxColors checkboxColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        boolean z3;
        CheckboxColors checkboxColorsM17024colors5tl4gsc;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        CheckboxColors checkboxColors3;
        int i7;
        boolean z4;
        Modifier modifierM16114triStateToggleableO2vRcR0;
        final boolean z5;
        final CheckboxColors checkboxColors4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1608358065);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
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
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColors2 = checkboxColors;
                        int i9 = composerStartRestartGroup.changed(checkboxColors2) ? 16384 : 8192;
                        i4 |= i9;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i4 |= i9;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            Modifier modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            z3 = i5 == 0 ? true : z2;
                            if ((i2 & 16) == 0) {
                                checkboxColorsM17024colors5tl4gsc = CheckboxDefaults.INSTANCE.m17024colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i4 &= -57345;
                            } else {
                                checkboxColorsM17024colors5tl4gsc = checkboxColors2;
                            }
                            if (i6 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                modifier3 = modifier5;
                                checkboxColors3 = checkboxColorsM17024colors5tl4gsc;
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier3 = modifier5;
                                checkboxColors3 = checkboxColorsM17024colors5tl4gsc;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            modifier3 = modifier2;
                            z3 = z2;
                            checkboxColors3 = checkboxColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1608358065, i4, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:135)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(1797978036);
                        if (function0 == null) {
                            i7 = i4;
                            z4 = z3;
                            modifierM16114triStateToggleableO2vRcR0 = ToggleableKt.m16114triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource3, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(CheckboxTokens.INSTANCE.m17506getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m20259boximpl(Role.INSTANCE.m20267getCheckboxo7Vup1c()), function0);
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource3;
                            i7 = i4;
                            z4 = z3;
                            modifierM16114triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        boolean z6 = z4;
                        CheckboxColors checkboxColors5 = checkboxColors3;
                        CheckboxImpl(z6, state, PaddingKt.m15854padding3ABfNKs(modifier3.then(function0 == null ? TouchTargetKt.minimumTouchTargetSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(modifierM16114triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors5, composerStartRestartGroup, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 3) & 7168));
                        z5 = z6;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors4 = checkboxColors5;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z2;
                        checkboxColors4 = checkboxColors2;
                    }
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt.TriStateCheckbox.2
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
                            CheckboxKt.TriStateCheckbox(state, function0, modifier4, z5, checkboxColors4, mutableInteractionSource4, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((374491 & i4) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        if (i6 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.startReplaceableGroup(1797978036);
                        if (function0 == null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        boolean z62 = z4;
                        CheckboxColors checkboxColors52 = checkboxColors3;
                        CheckboxImpl(z62, state, PaddingKt.m15854padding3ABfNKs(modifier3.then(function0 == null ? TouchTargetKt.minimumTouchTargetSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(modifierM16114triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors52, composerStartRestartGroup, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 3) & 7168));
                        z5 = z62;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        checkboxColors4 = checkboxColors52;
                        modifier4 = modifier3;
                    }
                }
                final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((374491 & i4) == 74898) {
            }
            final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((374491 & i4) == 74898) {
        }
        final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m17027drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f4) {
        float f5 = f4 / 2.0f;
        Stroke stroke = new Stroke(f4, 0.0f, 0, 0, null, 30, null);
        float fM18353getWidthimpl = Size.m18353getWidthimpl(drawScope.mo19076getSizeNHjbRc());
        if (Color.m18526equalsimpl0(j, j2)) {
            DrawScope.m19072drawRoundRectuAw5IA$default(drawScope, j, 0L, androidx.compose.p109ui.geometry.SizeKt.Size(fM18353getWidthimpl, fM18353getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, JPEG.APP2, null);
            return;
        }
        float f6 = fM18353getWidthimpl - (2 * f4);
        DrawScope.m19072drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f4, f4), androidx.compose.p109ui.geometry.SizeKt.Size(f6, f6), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f4), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, JPEG.APP0, null);
        float f7 = fM18353getWidthimpl - f4;
        DrawScope.m19072drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f5, f5), androidx.compose.p109ui.geometry.SizeKt.Size(f7, f7), CornerRadiusKt.CornerRadius$default(f - f5, 0.0f, 2, null), stroke, 0.0f, null, 0, JPEG.APP0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m17028drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f4, float f5, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f5, 0.0f, StrokeCap.INSTANCE.m18880getSquareKaPHkGw(), 0, null, 26, null);
        float fM18353getWidthimpl = Size.m18353getWidthimpl(drawScope.mo19076getSizeNHjbRc());
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f4);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f4);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f4);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f4);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fM18353getWidthimpl, fLerp3 * fM18353getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fM18353getWidthimpl, fLerp2 * fM18353getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fM18353getWidthimpl, fM18353getWidthimpl * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m19066drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }
}
