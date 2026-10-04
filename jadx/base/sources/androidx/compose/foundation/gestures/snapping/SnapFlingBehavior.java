package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.p109ui.MotionDurationScale;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J:\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010!J.\u0010\"\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0096@¢\u0006\u0002\u0010!JQ\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u001a*\u00020\u001c2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010*JB\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0,*\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001fH\u0082@¢\u0006\u0002\u0010*R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "equals", "", "other", "", "hashCode", "", "isDecayApproachPossible", TypedValues.Cycle.S_WAVE_OFFSET, "velocity", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingScrollOffsetUpdate", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "onRemainingDistanceUpdated", "runApproach", "initialTargetOffset", "onAnimationStep", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryApproach", "Landroidx/compose/animation/core/AnimationState;", "updateRemainingScrollOffset", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Deprecated(message = "Please use the snapFlingBehavior function", replaceWith = @ReplaceWith(expression = "androidx.compose.foundation.gestures.snapping.snapFlingBehavior", imports = {}))
@ExperimentalFoundationApi
@SourceDebugExtension({"SMAP\nSnapFlingBehavior.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapFlingBehavior.kt\nandroidx/compose/foundation/gestures/snapping/SnapFlingBehavior\n+ 2 SnapFlingBehavior.kt\nandroidx/compose/foundation/gestures/snapping/SnapFlingBehaviorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,507:1\n503#2,4:508\n503#2,4:512\n503#2,4:516\n503#2,4:520\n1#3:524\n*S KotlinDebug\n*F\n+ 1 SnapFlingBehavior.kt\nandroidx/compose/foundation/gestures/snapping/SnapFlingBehavior\n*L\n112#1:508,4\n203#1:512,4\n206#1:516,4\n226#1:520,4\n*E\n"})
public final class SnapFlingBehavior implements TargetedFlingBehavior {
    public static final int $stable = 0;

    @NotNull
    private final DecayAnimationSpec<Float> decayAnimationSpec;

    @NotNull
    private MotionDurationScale motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();

    @NotNull
    private final AnimationSpec<Float> snapAnimationSpec;

    @NotNull
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", m14021f = "SnapFlingBehavior.kt", m14022i = {0}, m14023l = {123}, m14024m = "fling", m14025n = {"onRemainingScrollOffsetUpdate"}, m14026s = {"L$0"})
    public static final class C09391 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C09391(Continuation<? super C09391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.fling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", m14021f = "SnapFlingBehavior.kt", m14022i = {}, m14023l = {110}, m14024m = "performFling", m14025n = {}, m14026s = {})
    public static final class C09411 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C09411(Continuation<? super C09411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.performFling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", m14021f = "SnapFlingBehavior.kt", m14022i = {}, m14023l = {187}, m14024m = "tryApproach", m14025n = {}, m14026s = {})
    public static final class C09421 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C09421(Continuation<? super C09421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.tryApproach(null, 0.0f, 0.0f, null, this);
        }
    }

    public SnapFlingBehavior(@NotNull SnapLayoutInfoProvider snapLayoutInfoProvider, @NotNull DecayAnimationSpec<Float> decayAnimationSpec, @NotNull AnimationSpec<Float> animationSpec) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fling(ScrollScope scrollScope, float f, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        C09391 c09391;
        Function1<? super Float, Unit> function12;
        if (continuation instanceof C09391) {
            c09391 = (C09391) continuation;
            int i = c09391.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c09391.label = i - Integer.MIN_VALUE;
            } else {
                c09391 = new C09391(continuation);
            }
        }
        Object objWithContext = c09391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09391.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MotionDurationScale motionDurationScale = this.motionScaleDuration;
            SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(this, f, function1, scrollScope, null);
            c09391.L$0 = function1;
            c09391.label = 1;
            objWithContext = BuildersKt.withContext(motionDurationScale, snapFlingBehavior$fling$result$1, c09391);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            function12 = function1;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function12 = (Function1) c09391.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        AnimationResult animationResult = (AnimationResult) objWithContext;
        function12.invoke(Boxing.boxFloat(0.0f));
        return animationResult;
    }

    private final boolean isDecayApproachPossible(float offset, float velocity) {
        return Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, velocity)) >= Math.abs(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runApproach(ScrollScope scrollScope, float f, float f4, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return SnapFlingBehaviorKt.approach(scrollScope, f, f4, isDecayApproachPossible(f, f4) ? new DecayApproachAnimation(this.decayAnimationSpec) : new TargetApproachAnimation(this.snapAnimationSpec), function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryApproach(ScrollScope scrollScope, float f, float f4, Function1<? super Float, Unit> function1, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        C09421 c09421;
        SnapFlingBehavior snapFlingBehavior;
        if (continuation instanceof C09421) {
            c09421 = (C09421) continuation;
            int i = c09421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c09421.label = i - Integer.MIN_VALUE;
                snapFlingBehavior = this;
            } else {
                snapFlingBehavior = this;
                c09421 = snapFlingBehavior.new C09421(continuation);
            }
        }
        C09421 c094212 = c09421;
        Object objRunApproach = c094212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c094212.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRunApproach);
            if (Math.abs(f) == 0.0f || Math.abs(f4) == 0.0f) {
                return AnimationStateKt.AnimationState$default(f, f4, 0L, 0L, false, 28, null);
            }
            c094212.label = 1;
            objRunApproach = snapFlingBehavior.runApproach(scrollScope, f, f4, function1, c094212);
            if (objRunApproach == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRunApproach);
        }
        return ((AnimationResult) objRunApproach).getCurrentAnimationState();
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof SnapFlingBehavior) {
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) other;
            if (Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.snapLayoutInfoProvider, this.snapLayoutInfoProvider)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: getMotionScaleDuration$foundation_release, reason: from getter */
    public final MotionDurationScale getMotionScaleDuration() {
        return this.motionScaleDuration;
    }

    public int hashCode() {
        return this.snapLayoutInfoProvider.hashCode() + ((this.decayAnimationSpec.hashCode() + (this.snapAnimationSpec.hashCode() * 31)) * 31);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(@NotNull ScrollScope scrollScope, float f, @NotNull Function1<? super Float, Unit> function1, @NotNull Continuation<? super Float> continuation) {
        C09411 c09411;
        if (continuation instanceof C09411) {
            c09411 = (C09411) continuation;
            int i = c09411.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c09411.label = i - Integer.MIN_VALUE;
            } else {
                c09411 = new C09411(continuation);
            }
        }
        Object objFling = c09411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09411.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFling);
            c09411.label = 1;
            objFling = fling(scrollScope, f, function1, c09411);
            if (objFling == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFling);
        }
        AnimationResult animationResult = (AnimationResult) objFling;
        return Boxing.boxFloat(((Number) animationResult.component1()).floatValue() != 0.0f ? ((Number) animationResult.component2().getVelocity()).floatValue() : 0.0f);
    }

    public final void setMotionScaleDuration$foundation_release(@NotNull MotionDurationScale motionDurationScale) {
        this.motionScaleDuration = motionDurationScale;
    }
}
