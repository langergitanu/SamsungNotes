package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutModifierKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0091\u0001\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aa\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010 \u001a[\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010!\u001ak\u0010\"\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010#\u001am\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010$\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020%2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010&\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020%2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010'\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020(2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010)\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020(2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010*\u001a9\u0010+\u001a\u00020\u0003\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010,\u001a\u0002H\bH\u0003¢\u0006\u0002\u0010-\"\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006.²\u0006\"\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\"\u0004\b\u0000\u0010\bX\u008a\u0084\u0002²\u0006\u0010\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\bX\u008a\u0084\u0002"}, m13886d2 = {"exitFinished", "", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "AnimatedEnterExitImpl", "", "T", "transition", "visible", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "shouldDisposeBlock", "Lkotlin/Function2;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnimatedVisibility.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimatedVisibility.kt\nandroidx/compose/animation/AnimatedVisibilityKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Transition.kt\nandroidx/compose/animation/core/TransitionKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,885:1\n1225#2,6:886\n1225#2,6:894\n1225#2,6:903\n1225#2,6:909\n1225#2,6:915\n1225#2,6:921\n1225#2,6:958\n1813#3,2:892\n1815#3,3:900\n79#4,6:927\n86#4,4:942\n90#4,2:952\n94#4:957\n368#5,9:933\n377#5,3:954\n4034#6,6:946\n81#7:964\n81#7:965\n*S KotlinDebug\n*F\n+ 1 AnimatedVisibility.kt\nandroidx/compose/animation/AnimatedVisibilityKt\n*L\n698#1:886,6\n742#1:894,6\n753#1:903,6\n769#1:909,6\n776#1:915,6\n795#1:921,6\n869#1:958,6\n742#1:892,2\n742#1:900,3\n770#1:927,6\n770#1:942,4\n770#1:952,2\n770#1:957\n770#1:933,9\n770#1:954,3\n770#1:946,6\n746#1:964\n748#1:965\n*E\n"})
public final class AnimatedVisibilityKt {
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final <T> void AnimatedEnterExitImpl(@NotNull final Transition<T> transition, @NotNull final Function1<? super T, Boolean> function1, @NotNull final Modifier modifier, @NotNull final EnterTransition enterTransition, @NotNull final ExitTransition exitTransition, @NotNull final Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, @Nullable OnLookaheadMeasured onLookaheadMeasured, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        EnterTransition enterTransition2;
        ExitTransition exitTransition2;
        EnterExitState enterExitState;
        final OnLookaheadMeasured onLookaheadMeasured2;
        Composer composer2;
        Modifier modifierLayout;
        OnLookaheadMeasured onLookaheadMeasured3 = onLookaheadMeasured;
        Composer composerStartRestartGroup = composer.startRestartGroup(-891967166);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
            enterTransition2 = enterTransition;
        } else {
            enterTransition2 = enterTransition;
            if ((i & 3072) == 0) {
                i4 |= composerStartRestartGroup.changed(enterTransition2) ? 2048 : 1024;
            }
        }
        if ((i2 & 16) != 0) {
            i4 |= 24576;
            exitTransition2 = exitTransition;
        } else {
            exitTransition2 = exitTransition;
            if ((i & 24576) == 0) {
                i4 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i4 |= 196608;
        } else if ((i & 196608) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        int i5 = i2 & 64;
        int i6 = 1572864;
        if (i5 != 0) {
            i4 |= i6;
        } else if ((i & 1572864) == 0) {
            i6 = (i & 2097152) == 0 ? composerStartRestartGroup.changed(onLookaheadMeasured3) : composerStartRestartGroup.changedInstance(onLookaheadMeasured3) ? 1048576 : 524288;
            i4 |= i6;
        }
        if ((i2 & 128) != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i7 = i4;
        if ((4793491 & i7) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            onLookaheadMeasured2 = onLookaheadMeasured3;
            composer2 = composerStartRestartGroup;
        } else {
            if (i5 != 0) {
                onLookaheadMeasured3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891967166, i7, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:737)");
            }
            if (function1.invoke(transition.getTargetState()).booleanValue() || function1.invoke(transition.getCurrentState()).booleanValue() || transition.isSeeking() || transition.getHasInitialValueAnimations()) {
                composerStartRestartGroup.startReplaceGroup(1787977937);
                int i8 = i7 & 14;
                int i9 = i8 | 48;
                int i10 = i9 & 14;
                boolean z = ((i10 ^ 6) > 4 && composerStartRestartGroup.changed(transition)) || (i9 & 6) == 4;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = transition.getCurrentState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                if (transition.isSeeking()) {
                    objRememberedValue = transition.getCurrentState();
                }
                composerStartRestartGroup.startReplaceGroup(-466616829);
                OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                }
                int i11 = i7 & 126;
                EnterExitState enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, composerStartRestartGroup, i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                T targetState = transition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-466616829);
                if (ComposerKt.isTraceInProgress()) {
                    enterExitState = enterExitStateTargetEnterExit;
                    ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                } else {
                    enterExitState = enterExitStateTargetEnterExit;
                }
                EnterExitState enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, targetState, composerStartRestartGroup, i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                onLookaheadMeasured2 = onLookaheadMeasured4;
                Transition transitionCreateChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, enterExitState, enterExitStateTargetEnterExit2, "EnterExitTransition", composerStartRestartGroup, i10 | 3072);
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 15) & 14);
                Boolean boolInvoke = function2.invoke(transitionCreateChildTransitionInternal.getCurrentState(), transitionCreateChildTransitionInternal.getTargetState());
                boolean zChanged = composerStartRestartGroup.changed(transitionCreateChildTransitionInternal) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new C0634xd7829780(transitionCreateChildTransitionInternal, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                State stateProduceState = SnapshotStateKt.produceState(boolInvoke, (Function2) objRememberedValue2, composerStartRestartGroup, 0);
                if (getExitFinished(transitionCreateChildTransitionInternal) && AnimatedEnterExitImpl$lambda$4(stateProduceState)) {
                    composerStartRestartGroup.startReplaceGroup(1790256282);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1788869559);
                    boolean z2 = i8 == 4;
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new AnimatedVisibilityScopeImpl(transitionCreateChildTransitionInternal);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue3;
                    int i12 = i7 >> 6;
                    Modifier modifierCreateModifier = EnterExitTransitionKt.createModifier(transitionCreateChildTransitionInternal, enterTransition2, exitTransition2, null, "Built-in", composerStartRestartGroup, (i12 & 896) | (i12 & 112) | 24576, 4);
                    composer2 = composerStartRestartGroup;
                    if (onLookaheadMeasured2 != null) {
                        composer2.startReplaceGroup(1789227361);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        boolean z3 = (3670016 & i7) == 1048576 || ((i7 & 2097152) != 0 && composer2.changedInstance(onLookaheadMeasured2));
                        Object objRememberedValue4 = composer2.rememberedValue();
                        if (z3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                    return m15242invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                }

                                @NotNull
                                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m15242invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
                                    final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
                                    OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured2;
                                    if (measureScope.isLookingAhead()) {
                                        onLookaheadMeasured5.m15273invokeozmzZPI(IntSizeKt.IntSize(placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight()));
                                    }
                                    return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                            Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        modifierLayout = LayoutModifierKt.layout(companion, (Function3) objRememberedValue4);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(1581766416);
                        composer2.endReplaceGroup();
                        modifierLayout = Modifier.INSTANCE;
                    }
                    Modifier modifierThen = modifier.then(modifierCreateModifier.then(modifierLayout));
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) objRememberedValue5;
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierThen);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl, animatedEnterExitMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    function3.invoke(animatedVisibilityScopeImpl, composer2, Integer.valueOf((i7 >> 18) & 112));
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1790262234);
                composerStartRestartGroup.endReplaceGroup();
                onLookaheadMeasured2 = onLookaheadMeasured3;
                composer2 = composerStartRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl.4
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
                    AnimatedVisibilityKt.AnimatedEnterExitImpl(transition, function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured5, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$2(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(boolean z, @Nullable Modifier modifier, @Nullable EnterTransition enterTransition, @Nullable ExitTransition exitTransition, @Nullable String str, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        final boolean z2;
        int i4;
        Modifier modifier2;
        int i5;
        EnterTransition enterTransition2;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2088733774);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i4 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    enterTransition2 = enterTransition;
                    i4 |= composerStartRestartGroup.changed(enterTransition2) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        exitTransition2 = exitTransition;
                        i4 |= composerStartRestartGroup.changed(exitTransition2) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 != 0) {
                        if ((i & 24576) == 0) {
                            str2 = str;
                            i4 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
                        }
                        if ((i2 & 32) != 0) {
                            i4 |= 196608;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 196608) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                            }
                        }
                        if ((74899 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition3 = enterTransition2;
                            exitTransition3 = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            EnterTransition enterTransitionPlus = i5 == 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition2;
                            ExitTransition exitTransitionPlus = i6 == 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition2;
                            String str4 = i7 == 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2088733774, i4, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                            }
                            int i9 = i4 << 3;
                            Modifier modifier5 = modifier4;
                            EnterTransition enterTransition4 = enterTransitionPlus;
                            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                                @NotNull
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier5, enterTransition4, exitTransitionPlus, function32, composerStartRestartGroup, (i9 & 57344) | (i9 & 896) | 48 | (i9 & 7168) | (i4 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            modifier3 = modifier5;
                            enterTransition3 = enterTransition4;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
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

                                public final void invoke(@Nullable Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 24576;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    if ((74899 & i4) == 74898) {
                        if (i8 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i4 << 3;
                        Modifier modifier52 = modifier4;
                        EnterTransition enterTransition42 = enterTransitionPlus;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            @NotNull
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier52, enterTransition42, exitTransitionPlus, function32, composerStartRestartGroup, (i92 & 57344) | (i92 & 896) | 48 | (i92 & 7168) | (i4 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier52;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i7 = i2 & 16;
                if (i7 != 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                if ((74899 & i4) == 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            enterTransition2 = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            exitTransition2 = exitTransition;
            i7 = i2 & 16;
            if (i7 != 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            if ((74899 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        enterTransition2 = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        exitTransition2 = exitTransition;
        i7 = i2 & 16;
        if (i7 != 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        if ((74899 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void AnimatedVisibilityImpl(@NotNull final Transition<T> transition, @NotNull final Function1<? super T, Boolean> function1, @NotNull final Modifier modifier, @NotNull final EnterTransition enterTransition, @NotNull final ExitTransition exitTransition, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i) {
        int i2;
        ExitTransition exitTransition2;
        Composer composerStartRestartGroup = composer.startRestartGroup(429978603);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            exitTransition2 = exitTransition;
            i2 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
        } else {
            exitTransition2 = exitTransition;
        }
        if ((i & 196608) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429978603, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:693)");
            }
            int i4 = i2 & 112;
            int i5 = i2 & 14;
            boolean z = (i4 == 32) | (i5 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m15243invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @NotNull
                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m15243invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
                        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
                        long jIntSize = (!measureScope.isLookingAhead() || function1.invoke((T) transition.getTargetState()).booleanValue()) ? IntSizeKt.IntSize(placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight()) : IntSize.INSTANCE.m21143getZeroYbymL2g();
                        return MeasureScope.layout$default(measureScope, IntSize.m21138getWidthimpl(jIntSize), IntSize.m21137getHeightimpl(jIntSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AnimatedEnterExitImpl(transition, function1, LayoutModifierKt.layout(modifier, (Function3) objRememberedValue), enterTransition, exitTransition2, new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.2
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Boolean invoke(@NotNull EnterExitState enterExitState, @NotNull EnterExitState enterExitState2) {
                    return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.PostExit);
                }
            }, null, function3, composerStartRestartGroup, i4 | i5 | 196608 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.3
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        EnterExitState currentState = transition.getCurrentState();
        EnterExitState enterExitState = EnterExitState.PostExit;
        return currentState == enterExitState && transition.getTargetState() == enterExitState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Composable
    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:855)");
        }
        composer.startMovableGroup(-902048200, transition);
        if (transition.isSeeking()) {
            composer.startReplaceGroup(2101296683);
            composer.endReplaceGroup();
            enterExitState = function1.invoke(t).booleanValue() ? EnterExitState.Visible : function1.invoke(transition.getCurrentState()).booleanValue() ? EnterExitState.PostExit : EnterExitState.PreEnter;
        } else {
            composer.startReplaceGroup(2101530516);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
            enterExitState = function1.invoke(t).booleanValue() ? EnterExitState.Visible : ((Boolean) mutableState.getValue()).booleanValue() ? EnterExitState.PostExit : EnterExitState.PreEnter;
            composer.endReplaceGroup();
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return enterExitState;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(@NotNull final RowScope rowScope, boolean z, @Nullable Modifier modifier, @Nullable EnterTransition enterTransition, @Nullable ExitTransition exitTransition, @Nullable String str, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        final boolean z2;
        int i4;
        Modifier modifier2;
        int i5;
        EnterTransition enterTransitionPlus;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1741346906);
        if ((i2 & 1) != 0) {
            i4 = i | 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 48) == 0) {
                i4 = (composerStartRestartGroup.changed(z2) ? 32 : 16) | i;
            } else {
                i4 = i;
            }
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    i4 |= composerStartRestartGroup.changed(enterTransitionPlus) ? 2048 : 1024;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        i4 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    }
                    i7 = i2 & 16;
                    if (i7 != 0) {
                        if ((196608 & i) == 0) {
                            str2 = str;
                            i4 |= composerStartRestartGroup.changed(str2) ? 131072 : 65536;
                        }
                        if ((i2 & 32) != 0) {
                            i4 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if ((599185 & i4) == 599184 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                            }
                            ExitTransition exitTransitionPlus = i6 == 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null)) : exitTransition2;
                            String str4 = i7 == 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1741346906, i4, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:206)");
                            }
                            int i9 = i4 >> 3;
                            Modifier modifier5 = modifier4;
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, composerStartRestartGroup, (i9 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.3
                                @NotNull
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier5, enterTransition3, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i9));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            modifier3 = modifier5;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
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

                                public final void invoke(@Nullable Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(rowScope, z2, modifier3, enterTransition2, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 196608;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    if ((599185 & i4) == 599184) {
                        if (i8 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i4 >> 3;
                        Modifier modifier52 = modifier4;
                        EnterTransition enterTransition32 = enterTransitionPlus;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, composerStartRestartGroup, (i92 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.3
                            @NotNull
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier52, enterTransition32, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i92));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier52;
                        enterTransition2 = enterTransition32;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i7 = i2 & 16;
                if (i7 != 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                if ((599185 & i4) == 599184) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            exitTransition2 = exitTransition;
            i7 = i2 & 16;
            if (i7 != 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            if ((599185 & i4) == 599184) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        exitTransition2 = exitTransition;
        i7 = i2 & 16;
        if (i7 != 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        if ((599185 & i4) == 599184) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(@NotNull final ColumnScope columnScope, boolean z, @Nullable Modifier modifier, @Nullable EnterTransition enterTransition, @Nullable ExitTransition exitTransition, @Nullable String str, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        final boolean z2;
        int i4;
        Modifier modifier2;
        int i5;
        EnterTransition enterTransitionPlus;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1766503102);
        if ((i2 & 1) != 0) {
            i4 = i | 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 48) == 0) {
                i4 = (composerStartRestartGroup.changed(z2) ? 32 : 16) | i;
            } else {
                i4 = i;
            }
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    i4 |= composerStartRestartGroup.changed(enterTransitionPlus) ? 2048 : 1024;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        i4 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    }
                    i7 = i2 & 16;
                    if (i7 != 0) {
                        if ((196608 & i) == 0) {
                            str2 = str;
                            i4 |= composerStartRestartGroup.changed(str2) ? 131072 : 65536;
                        }
                        if ((i2 & 32) != 0) {
                            i4 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if ((599185 & i4) == 599184 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                            }
                            ExitTransition exitTransitionPlus = i6 == 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null)) : exitTransition2;
                            String str4 = i7 == 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1766503102, i4, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                            }
                            int i9 = i4 >> 3;
                            Modifier modifier5 = modifier4;
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, composerStartRestartGroup, (i9 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                                @NotNull
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier5, enterTransition3, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i9));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            modifier3 = modifier5;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
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

                                public final void invoke(@Nullable Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier3, enterTransition2, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 196608;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    if ((599185 & i4) == 599184) {
                        if (i8 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i4 >> 3;
                        Modifier modifier52 = modifier4;
                        EnterTransition enterTransition32 = enterTransitionPlus;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, composerStartRestartGroup, (i92 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            @NotNull
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier52, enterTransition32, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i92));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier52;
                        enterTransition2 = enterTransition32;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i7 = i2 & 16;
                if (i7 != 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                if ((599185 & i4) == 599184) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            exitTransition2 = exitTransition;
            i7 = i2 & 16;
            if (i7 != 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            if ((599185 & i4) == 599184) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        exitTransition2 = exitTransition;
        i7 = i2 & 16;
        if (i7 != 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        if ((599185 & i4) == 599184) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015d  */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(@NotNull final MutableTransitionState<Boolean> mutableTransitionState, @Nullable Modifier modifier, @Nullable EnterTransition enterTransition, @Nullable ExitTransition exitTransition, @Nullable String str, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        EnterTransition enterTransition2;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-222898426);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    enterTransition2 = enterTransition;
                    i4 |= composerStartRestartGroup.changed(enterTransition2) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        exitTransition2 = exitTransition;
                        i4 |= composerStartRestartGroup.changed(exitTransition2) ? 2048 : 1024;
                    }
                    i7 = i2 & 16;
                    if (i7 != 0) {
                        if ((i & 24576) == 0) {
                            str2 = str;
                            i4 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
                        }
                        if ((i2 & 32) != 0) {
                            i4 |= 196608;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 196608) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                            }
                        }
                        if ((74899 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition3 = enterTransition2;
                            exitTransition3 = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            EnterTransition enterTransitionPlus = i5 == 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition2;
                            ExitTransition exitTransitionPlus = i6 == 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null)) : exitTransition2;
                            String str4 = i7 == 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-222898426, i4, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:384)");
                            }
                            int i9 = i4 << 3;
                            Modifier modifier5 = modifier4;
                            EnterTransition enterTransition4 = enterTransitionPlus;
                            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str4, composerStartRestartGroup, MutableTransitionState.$stable | (i4 & 14) | ((i4 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.7
                                @NotNull
                                public final Boolean invoke(boolean z) {
                                    return Boolean.valueOf(z);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier5, enterTransition4, exitTransitionPlus, function32, composerStartRestartGroup, (i9 & 57344) | (i9 & 896) | 48 | (i9 & 7168) | (i4 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            modifier3 = modifier5;
                            enterTransition3 = enterTransition4;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
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

                                public final void invoke(@Nullable Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 24576;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    if ((74899 & i4) == 74898) {
                        if (i8 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i4 << 3;
                        Modifier modifier52 = modifier4;
                        EnterTransition enterTransition42 = enterTransitionPlus;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str4, composerStartRestartGroup, MutableTransitionState.$stable | (i4 & 14) | ((i4 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.7
                            @NotNull
                            public final Boolean invoke(boolean z) {
                                return Boolean.valueOf(z);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier52, enterTransition42, exitTransitionPlus, function32, composerStartRestartGroup, (i92 & 57344) | (i92 & 896) | 48 | (i92 & 7168) | (i4 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier52;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i7 = i2 & 16;
                if (i7 != 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                if ((74899 & i4) == 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            enterTransition2 = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            exitTransition2 = exitTransition;
            i7 = i2 & 16;
            if (i7 != 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            if ((74899 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        enterTransition2 = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        exitTransition2 = exitTransition;
        i7 = i2 & 16;
        if (i7 != 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        if ((74899 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(@NotNull final RowScope rowScope, @NotNull final MutableTransitionState<Boolean> mutableTransitionState, @Nullable Modifier modifier, @Nullable EnterTransition enterTransition, @Nullable ExitTransition exitTransition, @Nullable String str, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        EnterTransition enterTransitionPlus;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(836509870);
        if ((i2 & 1) != 0) {
            i4 = i | 48;
        } else if ((i & 48) == 0) {
            i4 = ((i & 64) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    i4 |= composerStartRestartGroup.changed(enterTransitionPlus) ? 2048 : 1024;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        i4 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    }
                    i7 = i2 & 16;
                    if (i7 != 0) {
                        if ((196608 & i) == 0) {
                            str2 = str;
                            i4 |= composerStartRestartGroup.changed(str2) ? 131072 : 65536;
                        }
                        if ((i2 & 32) != 0) {
                            i4 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if ((599185 & i4) == 599184 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            }
                            ExitTransition exitTransitionPlus = i6 == 0 ? EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition2;
                            String str4 = i7 == 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(836509870, i4, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:459)");
                            }
                            int i9 = i4 >> 3;
                            Modifier modifier5 = modifier4;
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str4, composerStartRestartGroup, MutableTransitionState.$stable | (i9 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.9
                                @NotNull
                                public final Boolean invoke(boolean z) {
                                    return Boolean.valueOf(z);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier5, enterTransition3, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i9));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            modifier3 = modifier5;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
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

                                public final void invoke(@Nullable Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 196608;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    if ((599185 & i4) == 599184) {
                        if (i8 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i4 >> 3;
                        Modifier modifier52 = modifier4;
                        EnterTransition enterTransition32 = enterTransitionPlus;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str4, composerStartRestartGroup, MutableTransitionState.$stable | (i92 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.9
                            @NotNull
                            public final Boolean invoke(boolean z) {
                                return Boolean.valueOf(z);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier52, enterTransition32, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i92));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier52;
                        enterTransition2 = enterTransition32;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i7 = i2 & 16;
                if (i7 != 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                if ((599185 & i4) == 599184) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            exitTransition2 = exitTransition;
            i7 = i2 & 16;
            if (i7 != 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            if ((599185 & i4) == 599184) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        exitTransition2 = exitTransition;
        i7 = i2 & 16;
        if (i7 != 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        if ((599185 & i4) == 599184) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(@NotNull final ColumnScope columnScope, @NotNull final MutableTransitionState<Boolean> mutableTransitionState, @Nullable Modifier modifier, @Nullable EnterTransition enterTransition, @Nullable ExitTransition exitTransition, @Nullable String str, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        EnterTransition enterTransitionPlus;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-850656618);
        if ((i2 & 1) != 0) {
            i4 = i | 48;
        } else if ((i & 48) == 0) {
            i4 = ((i & 64) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    i4 |= composerStartRestartGroup.changed(enterTransitionPlus) ? 2048 : 1024;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        i4 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    }
                    i7 = i2 & 16;
                    if (i7 != 0) {
                        if ((196608 & i) == 0) {
                            str2 = str;
                            i4 |= composerStartRestartGroup.changed(str2) ? 131072 : 65536;
                        }
                        if ((i2 & 32) != 0) {
                            i4 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if ((599185 & i4) == 599184 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            }
                            ExitTransition exitTransitionPlus = i6 == 0 ? EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition2;
                            String str4 = i7 == 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-850656618, i4, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:535)");
                            }
                            int i9 = i4 >> 3;
                            Modifier modifier5 = modifier4;
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str4, composerStartRestartGroup, MutableTransitionState.$stable | (i9 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.11
                                @NotNull
                                public final Boolean invoke(boolean z) {
                                    return Boolean.valueOf(z);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier5, enterTransition3, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i9));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            modifier3 = modifier5;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
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

                                public final void invoke(@Nullable Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 196608;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    if ((599185 & i4) == 599184) {
                        if (i8 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i4 >> 3;
                        Modifier modifier52 = modifier4;
                        EnterTransition enterTransition32 = enterTransitionPlus;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str4, composerStartRestartGroup, MutableTransitionState.$stable | (i92 & 14) | ((i4 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.11
                            @NotNull
                            public final Boolean invoke(boolean z) {
                                return Boolean.valueOf(z);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier52, enterTransition32, exitTransitionPlus, function32, composerStartRestartGroup, (i4 & 896) | 48 | (i4 & 7168) | (i4 & 57344) | (458752 & i92));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier52;
                        enterTransition2 = enterTransition32;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i7 = i2 & 16;
                if (i7 != 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                if ((599185 & i4) == 599184) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            exitTransition2 = exitTransition;
            i7 = i2 & 16;
            if (i7 != 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            if ((599185 & i4) == 599184) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        exitTransition2 = exitTransition;
        i7 = i2 & 16;
        if (i7 != 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        if ((599185 & i4) == 599184) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void AnimatedVisibility(@NotNull final Transition<T> transition, @NotNull final Function1<? super T, Boolean> function1, @Nullable Modifier modifier, @Nullable EnterTransition enterTransition, @Nullable ExitTransition exitTransition, @NotNull final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        Transition<T> transition2;
        int i4;
        Function1<? super T, Boolean> function12;
        final Modifier modifier2;
        int i5;
        EnterTransition enterTransition2;
        int i6;
        ExitTransition exitTransition2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1031950689);
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i4 = i | 6;
            transition2 = transition;
        } else {
            transition2 = transition;
            if ((i & 6) == 0) {
                i4 = (composerStartRestartGroup.changed(transition2) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i2 & 1) != 0) {
            i4 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    enterTransition2 = enterTransition;
                    i4 |= composerStartRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                }
                i6 = i2 & 8;
                if (i6 == 0) {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        i4 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    }
                    if ((i2 & 16) == 0) {
                        i4 |= 196608;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i & 196608) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                        }
                    }
                    if ((74899 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        Modifier modifier3 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                        EnterTransition enterTransitionPlus = i5 == 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition2;
                        ExitTransition exitTransitionPlus = i6 == 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1031950689, i4, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:609)");
                        }
                        Modifier modifier4 = modifier3;
                        EnterTransition enterTransition4 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transition2, function12, modifier4, enterTransition4, exitTransitionPlus, function32, composerStartRestartGroup, i4 & 524286);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                        enterTransition3 = enterTransition4;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
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
                                AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                exitTransition2 = exitTransition;
                if ((i2 & 16) == 0) {
                }
                if ((74899 & i4) == 74898) {
                    if (i7 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier modifier42 = modifier3;
                    EnterTransition enterTransition42 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transition2, function12, modifier42, enterTransition42, exitTransitionPlus, function32, composerStartRestartGroup, i4 & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier42;
                    enterTransition3 = enterTransition42;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i6 = i2 & 8;
            if (i6 == 0) {
            }
            exitTransition2 = exitTransition;
            if ((i2 & 16) == 0) {
            }
            if ((74899 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        enterTransition2 = enterTransition;
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        exitTransition2 = exitTransition;
        if ((i2 & 16) == 0) {
        }
        if ((74899 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
