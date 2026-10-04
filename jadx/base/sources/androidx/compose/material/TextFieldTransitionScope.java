package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.colorspace.ColorSpace;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.save.SaveModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class TextFieldTransitionScope {

    @NotNull
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-1, reason: not valid java name */
    private static final float m16938Transition_DTcfvLk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-3, reason: not valid java name */
    private static final float m16939Transition_DTcfvLk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-5, reason: not valid java name */
    private static final long m16940Transition_DTcfvLk$lambda5(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-6, reason: not valid java name */
    private static final long m16941Transition_DTcfvLk$lambda6(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01bf  */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    /* JADX INFO: renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m16942TransitionDTcfvLk(@NotNull final InputPhase inputState, final long j, final long j2, @NotNull final Function3<? super InputPhase, ? super Composer, ? super Integer, Color> contentColor, final boolean z, @NotNull final Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        int i2;
        float f;
        Transition transition;
        int i4;
        int i5;
        float f4;
        int i6;
        float f5;
        int i7;
        ColorSpace colorSpaceM18529getColorSpaceimpl;
        boolean zChanged;
        Object objRememberedValue;
        ColorSpace colorSpaceM18529getColorSpaceimpl2;
        boolean zChanged2;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(inputState, "inputState");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1988729962);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(inputState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(contentColor) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(content) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1988729962, i2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:260)");
            }
            Transition transitionUpdateTransition = TransitionKt.updateTransition(inputState, "TextFieldInputState", composerStartRestartGroup, (i2 & 14) | 48, 0);
            TextFieldTransitionScope$Transition$labelProgress$2 textFieldTransitionScope$Transition$labelProgress$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                @Composable
                @NotNull
                public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<InputPhase> animateFloat, @Nullable Composer composer2, int i8) {
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(-611722692);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611722692, i8, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:280)");
                    }
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(floatCompanionObject);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            InputPhase inputPhase = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(-1158004136);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158004136, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:281)");
            }
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i8 = iArr[inputPhase.ordinal()];
            float f6 = 0.0f;
            if (i8 == 1) {
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf = Float.valueOf(f);
                InputPhase inputPhase2 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1158004136);
                if (ComposerKt.isTraceInProgress()) {
                    transition = transitionUpdateTransition;
                    i4 = -1;
                    ComposerKt.traceEventStart(-1158004136, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:281)");
                } else {
                    transition = transitionUpdateTransition;
                    i4 = -1;
                }
                i5 = iArr[inputPhase2.ordinal()];
                if (i5 == 1) {
                    f4 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Transition transition2 = transition;
                    State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, fValueOf, Float.valueOf(f4), textFieldTransitionScope$Transition$labelProgress$2.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, 196608);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        @Composable
                        @NotNull
                        public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<InputPhase> animateFloat, @Nullable Composer composer2, int i9) {
                            Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                            composer2.startReplaceableGroup(-1079955085);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1079955085, i9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:291)");
                            }
                            InputPhase inputPhase3 = InputPhase.Focused;
                            InputPhase inputPhase4 = InputPhase.UnfocusedEmpty;
                            FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = animateFloat.isTransitioningTo(inputPhase3, inputPhase4) ? AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null) : (animateFloat.isTransitioningTo(inputPhase4, inputPhase3) || animateFloat.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase4)) ? AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing()) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceableGroup();
                            return finiteAnimationSpecTween$default;
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(1399891485);
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                    composerStartRestartGroup.startReplaceableGroup(1847725064);
                    InputPhase inputPhase3 = (InputPhase) transition2.getCurrentState();
                    composerStartRestartGroup.startReplaceableGroup(-1376159017);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1376159017, 0, i4, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:309)");
                    }
                    i6 = iArr[inputPhase3.ordinal()];
                    if (i6 == 1) {
                        f5 = 1.0f;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Float fValueOf2 = Float.valueOf(f5);
                        InputPhase inputPhase4 = (InputPhase) transition2.getTargetState();
                        composerStartRestartGroup.startReplaceableGroup(-1376159017);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1376159017, 0, i4, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:309)");
                        }
                        i7 = iArr[inputPhase4.ordinal()];
                        if (i7 == 1) {
                            f6 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition2, fValueOf2, Float.valueOf(f6), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke(transition2.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, 196608);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                @Composable
                                @NotNull
                                public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<InputPhase> animateColor, @Nullable Composer composer2, int i9) {
                                    Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                                    composer2.startReplaceableGroup(-130058045);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-130058045, i9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:318)");
                                    }
                                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceableGroup();
                                    return tweenSpecTween$default;
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-1462136984);
                            InputPhase inputPhase5 = (InputPhase) transition2.getTargetState();
                            composerStartRestartGroup.startReplaceableGroup(-1490209928);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1490209928, 0, i4, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:320)");
                            }
                            long j3 = iArr[inputPhase5.ordinal()] != 1 ? j : j2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            colorSpaceM18529getColorSpaceimpl = Color.m18529getColorSpaceimpl(j3);
                            composerStartRestartGroup.startReplaceableGroup(-3686930);
                            zChanged = composerStartRestartGroup.changed(colorSpaceM18529getColorSpaceimpl);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM18529getColorSpaceimpl);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(1847725064);
                            InputPhase inputPhase6 = (InputPhase) transition2.getCurrentState();
                            composerStartRestartGroup.startReplaceableGroup(-1490209928);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1490209928, 0, i4, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:320)");
                            }
                            long j5 = iArr[inputPhase6.ordinal()] != 1 ? j : j2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Color colorM18515boximpl = Color.m18515boximpl(j5);
                            InputPhase inputPhase7 = (InputPhase) transition2.getTargetState();
                            composerStartRestartGroup.startReplaceableGroup(-1490209928);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1490209928, 0, i4, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:320)");
                            }
                            long j6 = iArr[inputPhase7.ordinal()] != 1 ? j : j2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(transition2, colorM18515boximpl, Color.m18515boximpl(j6), textFieldTransitionScope$Transition$labelTextStyleColor$2.invoke(transition2.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "LabelTextStyleColor", composerStartRestartGroup, 229376);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                @Composable
                                @NotNull
                                public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<InputPhase> animateColor, @Nullable Composer composer2, int i9) {
                                    Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                                    composer2.startReplaceableGroup(-32667848);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-32667848, i9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
                                    }
                                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceableGroup();
                                    return tweenSpecTween$default;
                                }
                            };
                            int i9 = (i2 & 7168) | 384;
                            composerStartRestartGroup.startReplaceableGroup(-1462136984);
                            colorSpaceM18529getColorSpaceimpl2 = Color.m18529getColorSpaceimpl(contentColor.invoke(transition2.getTargetState(), composerStartRestartGroup, Integer.valueOf((i9 >> 6) & 112)).m18535unboximpl());
                            composerStartRestartGroup.startReplaceableGroup(-3686930);
                            zChanged2 = composerStartRestartGroup.changed(colorSpaceM18529getColorSpaceimpl2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM18529getColorSpaceimpl2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i10 = ((i9 << 3) & 57344) | SaveModel.DEFAULT_SCREEN_OFF_CLOSE_STRATEGY;
                            composerStartRestartGroup.startReplaceableGroup(1847725064);
                            int i11 = (i10 >> 9) & 112;
                            State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(transition2, contentColor.invoke(transition2.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i11)), contentColor.invoke(transition2.getTargetState(), composerStartRestartGroup, Integer.valueOf(i11)), textFieldTransitionScope$Transition$labelContentColor$2.invoke(transition2.getSegment(), composerStartRestartGroup, 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            content.invoke(Float.valueOf(m16938Transition_DTcfvLk$lambda1(stateCreateTransitionAnimation)), Color.m18515boximpl(m16940Transition_DTcfvLk$lambda5(stateCreateTransitionAnimation3)), Color.m18515boximpl(m16941Transition_DTcfvLk$lambda6(stateCreateTransitionAnimation4)), Float.valueOf(m16939Transition_DTcfvLk$lambda3(stateCreateTransitionAnimation2)), composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            if (i7 != 2) {
                                if (i7 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if (!z) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            State stateCreateTransitionAnimation22 = TransitionKt.createTransitionAnimation(transition2, fValueOf2, Float.valueOf(f6), textFieldTransitionScope$Transition$placeholderOpacity$2.invoke(transition2.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, 196608);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            TextFieldTransitionScope$Transition$labelTextStyleColor$2 textFieldTransitionScope$Transition$labelTextStyleColor$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                @Composable
                                @NotNull
                                public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<InputPhase> animateColor, @Nullable Composer composer2, int i92) {
                                    Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                                    composer2.startReplaceableGroup(-130058045);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-130058045, i92, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:318)");
                                    }
                                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceableGroup();
                                    return tweenSpecTween$default;
                                }
                            };
                            composerStartRestartGroup.startReplaceableGroup(-1462136984);
                            InputPhase inputPhase52 = (InputPhase) transition2.getTargetState();
                            composerStartRestartGroup.startReplaceableGroup(-1490209928);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (iArr[inputPhase52.ordinal()] != 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            colorSpaceM18529getColorSpaceimpl = Color.m18529getColorSpaceimpl(j3);
                            composerStartRestartGroup.startReplaceableGroup(-3686930);
                            zChanged = composerStartRestartGroup.changed(colorSpaceM18529getColorSpaceimpl);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM18529getColorSpaceimpl);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                composerStartRestartGroup.endReplaceableGroup();
                                TwoWayConverter twoWayConverter2 = (TwoWayConverter) objRememberedValue;
                                composerStartRestartGroup.startReplaceableGroup(1847725064);
                                InputPhase inputPhase62 = (InputPhase) transition2.getCurrentState();
                                composerStartRestartGroup.startReplaceableGroup(-1490209928);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (iArr[inputPhase62.ordinal()] != 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                Color colorM18515boximpl2 = Color.m18515boximpl(j5);
                                InputPhase inputPhase72 = (InputPhase) transition2.getTargetState();
                                composerStartRestartGroup.startReplaceableGroup(-1490209928);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (iArr[inputPhase72.ordinal()] != 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                State stateCreateTransitionAnimation32 = TransitionKt.createTransitionAnimation(transition2, colorM18515boximpl2, Color.m18515boximpl(j6), textFieldTransitionScope$Transition$labelTextStyleColor$22.invoke(transition2.getSegment(), composerStartRestartGroup, 0), twoWayConverter2, "LabelTextStyleColor", composerStartRestartGroup, 229376);
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                TextFieldTransitionScope$Transition$labelContentColor$2 textFieldTransitionScope$Transition$labelContentColor$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                        return invoke(segment, composer2, num.intValue());
                                    }

                                    @Composable
                                    @NotNull
                                    public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<InputPhase> animateColor, @Nullable Composer composer2, int i92) {
                                        Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                                        composer2.startReplaceableGroup(-32667848);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-32667848, i92, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
                                        }
                                        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer2.endReplaceableGroup();
                                        return tweenSpecTween$default;
                                    }
                                };
                                int i92 = (i2 & 7168) | 384;
                                composerStartRestartGroup.startReplaceableGroup(-1462136984);
                                colorSpaceM18529getColorSpaceimpl2 = Color.m18529getColorSpaceimpl(contentColor.invoke(transition2.getTargetState(), composerStartRestartGroup, Integer.valueOf((i92 >> 6) & 112)).m18535unboximpl());
                                composerStartRestartGroup.startReplaceableGroup(-3686930);
                                zChanged2 = composerStartRestartGroup.changed(colorSpaceM18529getColorSpaceimpl2);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged2) {
                                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM18529getColorSpaceimpl2);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    composerStartRestartGroup.endReplaceableGroup();
                                    int i102 = ((i92 << 3) & 57344) | SaveModel.DEFAULT_SCREEN_OFF_CLOSE_STRATEGY;
                                    composerStartRestartGroup.startReplaceableGroup(1847725064);
                                    int i112 = (i102 >> 9) & 112;
                                    State stateCreateTransitionAnimation42 = TransitionKt.createTransitionAnimation(transition2, contentColor.invoke(transition2.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i112)), contentColor.invoke(transition2.getTargetState(), composerStartRestartGroup, Integer.valueOf(i112)), textFieldTransitionScope$Transition$labelContentColor$22.invoke(transition2.getSegment(), composerStartRestartGroup, 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, 229376);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceableGroup();
                                    composerStartRestartGroup.endReplaceableGroup();
                                    content.invoke(Float.valueOf(m16938Transition_DTcfvLk$lambda1(stateCreateTransitionAnimation)), Color.m18515boximpl(m16940Transition_DTcfvLk$lambda5(stateCreateTransitionAnimation32)), Color.m18515boximpl(m16941Transition_DTcfvLk$lambda6(stateCreateTransitionAnimation42)), Float.valueOf(m16939Transition_DTcfvLk$lambda3(stateCreateTransitionAnimation22)), composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 57344));
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                            }
                        }
                    } else {
                        if (i6 == 2) {
                            if (z) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Float fValueOf22 = Float.valueOf(f5);
                            InputPhase inputPhase42 = (InputPhase) transition2.getTargetState();
                            composerStartRestartGroup.startReplaceableGroup(-1376159017);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i7 = iArr[inputPhase42.ordinal()];
                            if (i7 == 1) {
                            }
                        } else if (i6 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        f5 = 0.0f;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Float fValueOf222 = Float.valueOf(f5);
                        InputPhase inputPhase422 = (InputPhase) transition2.getTargetState();
                        composerStartRestartGroup.startReplaceableGroup(-1376159017);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i7 = iArr[inputPhase422.ordinal()];
                        if (i7 == 1) {
                        }
                    }
                } else if (i5 != 2) {
                    if (i5 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f4 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Transition transition22 = transition;
                    State stateCreateTransitionAnimation5 = TransitionKt.createTransitionAnimation(transition22, fValueOf, Float.valueOf(f4), textFieldTransitionScope$Transition$labelProgress$2.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, 196608);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$22 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        @Composable
                        @NotNull
                        public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<InputPhase> animateFloat, @Nullable Composer composer2, int i93) {
                            Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                            composer2.startReplaceableGroup(-1079955085);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1079955085, i93, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:291)");
                            }
                            InputPhase inputPhase32 = InputPhase.Focused;
                            InputPhase inputPhase43 = InputPhase.UnfocusedEmpty;
                            FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = animateFloat.isTransitioningTo(inputPhase32, inputPhase43) ? AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null) : (animateFloat.isTransitioningTo(inputPhase43, inputPhase32) || animateFloat.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase43)) ? AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing()) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceableGroup();
                            return finiteAnimationSpecTween$default;
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(1399891485);
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                    composerStartRestartGroup.startReplaceableGroup(1847725064);
                    InputPhase inputPhase32 = (InputPhase) transition22.getCurrentState();
                    composerStartRestartGroup.startReplaceableGroup(-1376159017);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = iArr[inputPhase32.ordinal()];
                    if (i6 == 1) {
                    }
                } else {
                    f4 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Transition transition222 = transition;
                    State stateCreateTransitionAnimation52 = TransitionKt.createTransitionAnimation(transition222, fValueOf, Float.valueOf(f4), textFieldTransitionScope$Transition$labelProgress$2.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, 196608);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldTransitionScope$Transition$placeholderOpacity$2 textFieldTransitionScope$Transition$placeholderOpacity$222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        @Composable
                        @NotNull
                        public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<InputPhase> animateFloat, @Nullable Composer composer2, int i93) {
                            Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                            composer2.startReplaceableGroup(-1079955085);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1079955085, i93, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:291)");
                            }
                            InputPhase inputPhase322 = InputPhase.Focused;
                            InputPhase inputPhase43 = InputPhase.UnfocusedEmpty;
                            FiniteAnimationSpec<Float> finiteAnimationSpecTween$default = animateFloat.isTransitioningTo(inputPhase322, inputPhase43) ? AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null) : (animateFloat.isTransitioningTo(inputPhase43, inputPhase322) || animateFloat.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase43)) ? AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing()) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceableGroup();
                            return finiteAnimationSpecTween$default;
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(1399891485);
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                    composerStartRestartGroup.startReplaceableGroup(1847725064);
                    InputPhase inputPhase322 = (InputPhase) transition222.getCurrentState();
                    composerStartRestartGroup.startReplaceableGroup(-1376159017);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = iArr[inputPhase322.ordinal()];
                    if (i6 == 1) {
                    }
                }
            } else if (i8 != 2) {
                if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf3 = Float.valueOf(f);
                InputPhase inputPhase22 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1158004136);
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = iArr[inputPhase22.ordinal()];
                if (i5 == 1) {
                }
            } else {
                f = 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf32 = Float.valueOf(f);
                InputPhase inputPhase222 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceableGroup(-1158004136);
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = iArr[inputPhase222.ordinal()];
                if (i5 == 1) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$1
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

            public final void invoke(@Nullable Composer composer2, int i12) {
                this.$tmp0_rcvr.m16942TransitionDTcfvLk(inputState, j, j2, contentColor, z, content, composer2, i | 1);
            }
        });
    }
}
