package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006JU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/foundation/gestures/snapping/TargetApproachAnimation;", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;)V", "approachAnimation", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "scope", "Landroidx/compose/foundation/gestures/ScrollScope;", TypedValues.Cycle.S_WAVE_OFFSET, "velocity", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class TargetApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {

    @NotNull
    private final AnimationSpec<Float> animationSpec;

    public TargetApproachAnimation(@NotNull AnimationSpec<Float> animationSpec) {
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Float f, Float f4, Function1<? super Float, Unit> function1, Continuation continuation) {
        return approachAnimation(scrollScope, f.floatValue(), f4.floatValue(), function1, (Continuation<? super AnimationResult<Float, AnimationVector1D>>) continuation);
    }

    @Nullable
    public Object approachAnimation(@NotNull ScrollScope scrollScope, float f, float f4, @NotNull Function1<? super Float, Unit> function1, @NotNull Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        Object objAnimateWithTarget = SnapFlingBehaviorKt.animateWithTarget(scrollScope, Math.signum(f4) * Math.abs(f), f, AnimationStateKt.AnimationState$default(0.0f, f4, 0L, 0L, false, 28, null), this.animationSpec, function1, continuation);
        return objAnimateWithTarget == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateWithTarget : (AnimationResult) objAnimateWithTarget;
    }
}
