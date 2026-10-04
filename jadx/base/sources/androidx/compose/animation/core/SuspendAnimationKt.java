package androidx.compose.animation.core;

import androidx.compose.p109ui.MotionDurationScale;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.exifinterface.media.ExifInterface;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0096\u0001\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u000b2\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\r\u001a\u0002H\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@¢\u0006\u0002\u0010\u0017\u001ap\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@¢\u0006\u0002\u0010\u0018\u001a^\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@¢\u0006\u0002\u0010\u001b\u001as\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0080@¢\u0006\u0002\u0010$\u001am\u0010\u0019\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070%2\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0086@¢\u0006\u0002\u0010(\u001aw\u0010)\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0006\u0010\r\u001a\u0002H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00102\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0086@¢\u0006\u0002\u0010*\u001aW\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\u0007\"\b\b\u0002\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H,0!H\u0082@¢\u0006\u0002\u0010/\u001a\u0085\u0001\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a\u0085\u0001\u00104\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010\u0000\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a<\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001cH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u00066"}, m13886d2 = {"durationScale", "", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animate", "", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "playTimeNanos", "anim", "state", "doAnimationFrameWithScale", "updateState", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSuspendAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuspendAnimation.kt\nandroidx/compose/animation/core/SuspendAnimationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Preconditions.kt\nandroidx/compose/animation/core/PreconditionsKt\n*L\n1#1,363:1\n1#2:364\n54#3,7:365\n*S KotlinDebug\n*F\n+ 1 SuspendAnimation.kt\nandroidx/compose/animation/core/SuspendAnimationKt\n*L\n312#1:365,7\n*E\n"})
public final class SuspendAnimationKt {

    /* JADX INFO: renamed from: androidx.compose.animation.core.SuspendAnimationKt$animate$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.SuspendAnimationKt", m14021f = "SuspendAnimation.kt", m14022i = {0, 0, 0, 0, 1, 1, 1, 1}, m14023l = {JPEG.APP15, 278}, m14024m = "animate", m14025n = {"$this$animate", "animation", "block", "lateInitScope", "$this$animate", "animation", "block", "lateInitScope"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class C07334<T, V extends AnimationVector> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C07334(Continuation<? super C07334> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendAnimationKt.animate(null, null, 0L, null, this);
        }
    }

    @Nullable
    public static final Object animate(float f, float f4, float f5, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function2<? super Float, ? super Float, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAnimate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(f), Boxing.boxFloat(f4), Boxing.boxFloat(f5), animationSpec, function2, continuation);
        return objAnimate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(float f, float f4, float f5, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            f5 = 0.0f;
        }
        if ((i & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f, f4, f5, animationSpec, function2, continuation);
    }

    @Nullable
    public static final Object animateDecay(float f, float f4, @NotNull FloatDecayAnimationSpec floatDecayAnimationSpec, @NotNull final Function2<? super Float, ? super Float, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAnimate$default = animate$default(AnimationStateKt.AnimationState$default(f, f4, 0L, 0L, false, 28, null), AnimationKt.DecayAnimation(floatDecayAnimationSpec, f, f4), 0L, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animateDecay.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                function2.invoke(animationScope.getValue(), Float.valueOf(((AnimationVector1D) animationScope.getVelocityVector()).getValue()));
            }
        }, continuation, 2, null);
        return objAnimate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animateDecay.4
                public final void invoke(@NotNull AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animateTo(@NotNull AnimationState<T, V> animationState, T t, @NotNull AnimationSpec<T> animationSpec, boolean z, @NotNull Function1<? super AnimationScope<T, V>, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        Object objAnimate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return objAnimate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animateTo.2
                public final void invoke(@NotNull AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((AnimationScope) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        return animateTo(animationState, obj, animationSpec2, z2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, final Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        return animation.getIsInfinite() ? InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation) : MonotonicFrameClockKt.withFrameNanos(new Function1<Long, R>() { // from class: androidx.compose.animation.core.SuspendAnimationKt.callWithFrameNanos.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Long l) {
                return invoke(l.longValue());
            }

            public final R invoke(long j) {
                return function1.invoke(Long.valueOf(j));
            }
        }, continuation);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j, long j2, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j2));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j2));
        if (animation.isFinishedFromNanos(j2)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j, float f, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        doAnimationFrame(animationScope, j, f == 0.0f ? animation.getDurationNanos() : (long) ((j - animationScope.getStartTimeNanos()) / f), animation, animationState, function1);
    }

    public static final float getDurationScale(@NotNull CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.INSTANCE);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (!(scaleFactor >= 0.0f)) {
            PreconditionsKt.throwIllegalStateException("negative scale factor");
        }
        return scaleFactor;
    }

    public static final <T, V extends AnimationVector> void updateState(@NotNull AnimationScope<T, V> animationScope, @NotNull AnimationState<T, V> animationState) {
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj4) {
        if ((i & 8) != 0) {
            obj3 = null;
        }
        if ((i & 16) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(twoWayConverter, obj, obj2, obj3, animationSpec, function2, continuation);
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animateDecay(@NotNull AnimationState<T, V> animationState, @NotNull DecayAnimationSpec<T> decayAnimationSpec, boolean z, @NotNull Function1<? super AnimationScope<T, V>, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        Object objAnimate = animate(animationState, new DecayAnimation((DecayAnimationSpec) decayAnimationSpec, (TwoWayConverter<T, AnimationVector>) animationState.getTypeConverter(), (Object) animationState.getValue(), animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return objAnimate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.5
                public final void invoke(@NotNull AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return animate(animationState, animation, j2, function1, continuation);
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animate(@NotNull final TwoWayConverter<T, V> twoWayConverter, T t, T t2, @Nullable T t5, @NotNull AnimationSpec<T> animationSpec, @NotNull final Function2<? super T, ? super T, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        V vNewInstance;
        if (t5 == null || (vNewInstance = twoWayConverter.getConvertToVector().invoke(t5)) == null) {
            vNewInstance = AnimationVectorsKt.newInstance(twoWayConverter.getConvertToVector().invoke(t));
        }
        AnimationVector animationVector = vNewInstance;
        Object objAnimate$default = animate$default(new AnimationState(twoWayConverter, t, animationVector, 0L, 0L, false, 56, null), new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, animationVector), 0L, new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((AnimationScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull AnimationScope<T, V> animationScope) {
                function2.invoke(animationScope.getValue(), twoWayConverter.getConvertFromVector().invoke(animationScope.getVelocityVector()));
            }
        }, continuation, 2, null);
        return objAnimate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimate$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, androidx.compose.animation.core.AnimationScope] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, V extends AnimationVector> Object animate(@NotNull final AnimationState<T, V> animationState, @NotNull Animation<T, V> animation, long j, @NotNull final Function1<? super AnimationScope<T, V>, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C07334 c07334;
        final Ref.ObjectRef objectRef;
        final AnimationState<T, V> animationState2;
        AnimationState<T, V> animationState3;
        final float durationScale;
        Ref.ObjectRef objectRef2;
        Function1<? super AnimationScope<T, V>, Unit> function12;
        AnimationScope animationScope;
        AnimationScope animationScope2;
        Function1<Long, Unit> function13;
        final Animation<T, V> animation2 = animation;
        if (continuation instanceof C07334) {
            c07334 = (C07334) continuation;
            int i = c07334.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c07334.label = i - Integer.MIN_VALUE;
            } else {
                c07334 = new C07334(continuation);
            }
        }
        C07334 c073342 = c07334;
        Object obj = c073342.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c073342.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final T valueFromNanos = animation2.getValueFromNanos(0L);
            final AnimationVector velocityVectorFromNanos = animation2.getVelocityVectorFromNanos(0L);
            objectRef = new Ref.ObjectRef();
            if (j == Long.MIN_VALUE) {
                try {
                    durationScale = getDurationScale(c073342.getContext());
                    animationState2 = animationState;
                } catch (CancellationException e) {
                    e = e;
                    animationState2 = animationState;
                }
                try {
                    Function1<Long, Unit> function14 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/internal/Ref$ObjectRef<Landroidx/compose/animation/core/AnimationScope<TT;TV;>;>;TT;Landroidx/compose/animation/core/Animation<TT;TV;>;TV;Landroidx/compose/animation/core/AnimationState<TT;TV;>;FLkotlin/jvm/functions/Function1<-Landroidx/compose/animation/core/AnimationScope<TT;TV;>;Lkotlin/Unit;>;)V */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.compose.animation.core.AnimationScope] */
                        public final void invoke(long j2) {
                            Ref.ObjectRef<AnimationScope<T, V>> objectRef3 = objectRef;
                            T t = valueFromNanos;
                            TwoWayConverter typeConverter = animation2.getTypeConverter();
                            AnimationVector animationVector = velocityVectorFromNanos;
                            Object targetValue = animation2.getTargetValue();
                            final AnimationState<T, V> animationState4 = animationState2;
                            ?? animationScope3 = new AnimationScope(t, typeConverter, animationVector, j2, targetValue, j2, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.6.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    animationState4.setRunning$animation_core_release(false);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }
                            });
                            SuspendAnimationKt.doAnimationFrameWithScale(animationScope3, j2, durationScale, animation2, animationState2, function1);
                            objectRef3.element = animationScope3;
                        }
                    };
                    objectRef2 = objectRef;
                    try {
                        c073342.L$0 = animationState2;
                        c073342.L$1 = animation2;
                        c073342.L$2 = function1;
                        c073342.L$3 = objectRef2;
                        c073342.label = 1;
                        if (callWithFrameNanos(animation2, function14, c073342) != coroutine_suspended) {
                            animationState3 = animationState2;
                            function12 = function1;
                            objectRef = objectRef2;
                        }
                        return coroutine_suspended;
                    } catch (CancellationException e2) {
                        e = e2;
                        animationState3 = animationState2;
                        objectRef = objectRef2;
                        animationScope = (AnimationScope) objectRef.element;
                        if (animationScope != null) {
                            animationScope.setRunning$animation_core_release(false);
                        }
                        animationScope2 = (AnimationScope) objectRef.element;
                        if (animationScope2 != null && animationScope2.getLastFrameTimeNanos() == animationState3.getLastFrameTimeNanos()) {
                            animationState3.setRunning$animation_core_release(false);
                        }
                        throw e;
                    }
                } catch (CancellationException e3) {
                    e = e3;
                    animationState3 = animationState2;
                    animationScope = (AnimationScope) objectRef.element;
                    if (animationScope != null) {
                    }
                    animationScope2 = (AnimationScope) objectRef.element;
                    if (animationScope2 != null) {
                    }
                    throw e;
                }
            }
            objectRef2 = objectRef;
            try {
                ?? r12 = (T) new AnimationScope(valueFromNanos, animation2.getTypeConverter(), velocityVectorFromNanos, j, animation2.getTargetValue(), j, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        animationState.setRunning$animation_core_release(false);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
                doAnimationFrameWithScale(r12, j, getDurationScale(c073342.getContext()), animation2, animationState, function1);
                objectRef2.element = r12;
                animationState3 = animationState;
                animation2 = animation;
                function12 = function1;
                objectRef = objectRef2;
            } catch (CancellationException e5) {
                e = e5;
                animationState3 = animationState;
                objectRef = objectRef2;
                animationScope = (AnimationScope) objectRef.element;
                if (animationScope != null) {
                }
                animationScope2 = (AnimationScope) objectRef.element;
                if (animationScope2 != null) {
                    animationState3.setRunning$animation_core_release(false);
                }
                throw e;
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c073342.L$3;
            function12 = (Function1) c073342.L$2;
            animation2 = (Animation) c073342.L$1;
            animationState3 = (AnimationState) c073342.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e6) {
                e = e6;
                animationScope = (AnimationScope) objectRef.element;
                if (animationScope != null) {
                }
                animationScope2 = (AnimationScope) objectRef.element;
                if (animationScope2 != null) {
                }
                throw e;
            }
        }
        do {
            T t = objectRef.element;
            Intrinsics.checkNotNull(t);
            if (((AnimationScope) t).isRunning()) {
                final float durationScale2 = getDurationScale(c073342.getContext());
                final Ref.ObjectRef objectRef3 = objectRef;
                final Function1<? super AnimationScope<T, V>, Unit> function15 = function12;
                final Animation<T, V> animation3 = animation2;
                final AnimationState<T, V> animationState4 = animationState3;
                try {
                    function13 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt.animate.9
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final void invoke(long j2) {
                            T t2 = objectRef3.element;
                            Intrinsics.checkNotNull(t2);
                            SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) t2, j2, durationScale2, animation3, animationState4, function15);
                        }
                    };
                    objectRef = objectRef3;
                    animation2 = animation3;
                    animationState3 = animationState4;
                    function12 = function15;
                    c073342.L$0 = animationState3;
                    c073342.L$1 = animation2;
                    c073342.L$2 = function12;
                    c073342.L$3 = objectRef;
                    c073342.label = 2;
                } catch (CancellationException e7) {
                    e = e7;
                    objectRef = objectRef3;
                    animationState3 = animationState4;
                    animationScope = (AnimationScope) objectRef.element;
                    if (animationScope != null) {
                    }
                    animationScope2 = (AnimationScope) objectRef.element;
                    if (animationScope2 != null) {
                    }
                    throw e;
                }
            } else {
                return Unit.INSTANCE;
            }
        } while (callWithFrameNanos(animation2, function13, c073342) != coroutine_suspended);
        return coroutine_suspended;
    }
}
