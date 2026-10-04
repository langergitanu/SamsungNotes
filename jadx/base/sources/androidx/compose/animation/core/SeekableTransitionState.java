package androidx.compose.animation.core;

import androidx.annotation.FloatRange;
import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 X*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002XYB\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010<\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J*\u0010>\u001a\u00020\b2\b\b\u0002\u00101\u001a\u00028\u00002\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010@H\u0086@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\b\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020\bH\u0002J\r\u0010E\u001a\u00020\bH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\bH\u0000¢\u0006\u0002\bHJ\u0018\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u0007H\u0002J\u000e\u0010L\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\"\u0010M\u001a\u00020\b2\b\b\u0001\u0010#\u001a\u00020!2\b\b\u0002\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\bH\u0002J\u0016\u0010P\u001a\u00020\b2\u0006\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010QJ\u001b\u0010R\u001a\u00020\b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0010¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020\bH\u0010¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\u000e\u0010W\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u0004R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020!8G@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\b00X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00101\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\u0004R\u001a\u00105\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, m13886d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "(Ljava/lang/Object;)V", "animateOneFrameLambda", "Lkotlin/Function1;", "", "", "composedTargetState", "getComposedTargetState$animation_core_release", "()Ljava/lang/Object;", "setComposedTargetState$animation_core_release", "Ljava/lang/Object;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core_release", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core_release", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core_release", "()Lkotlinx/coroutines/sync/Mutex;", "currentAnimation", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "<set-?>", "currentState", "getCurrentState", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "durationScale", "", "firstFrameLambda", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "lastFrameTimeNanos", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos$animation_core_release", "()J", "setTotalDurationNanos$animation_core_release", "(J)V", "transition", "Landroidx/compose/animation/core/Transition;", "animateOneFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "endAllAnimations", "moveAnimationToInitialState", "observeTotalDuration", "observeTotalDuration$animation_core_release", "onTotalDurationChanged", "onTotalDurationChanged$animation_core_release", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "runAnimations", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToFraction", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core_release", "transitionRemoved", "transitionRemoved$animation_core_release", "waitForComposition", "waitForCompositionAfterTargetStateChange", "Companion", "SeekingAnimationState", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/SeekableTransitionState\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 SnapshotFloatState.kt\nandroidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt\n+ 4 Preconditions.kt\nandroidx/compose/animation/core/PreconditionsKt\n+ 5 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 6 ObjectList.kt\nandroidx/collection/MutableObjectList\n*L\n1#1,2185:1\n81#2:2186\n107#2,2:2187\n81#2:2189\n107#2,2:2190\n79#3:2192\n112#3,2:2193\n33#4,7:2195\n54#4,7:2226\n314#5,11:2202\n314#5,11:2213\n948#6,2:2224\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/SeekableTransitionState\n*L\n227#1:2186\n227#1:2187,2\n229#1:2189\n229#1:2190,2\n258#1:2192\n258#1:2193,2\n503#1:2195,7\n701#1:2226,7\n546#1:2202,11\n567#1:2213,11\n597#1:2224,2\n*E\n"})
public final class SeekableTransitionState<S> extends TransitionState<S> {

    @NotNull
    private final Function1<Long, Unit> animateOneFrameLambda;
    private S composedTargetState;

    @Nullable
    private CancellableContinuation<? super S> compositionContinuation;

    @NotNull
    private final Mutex compositionContinuationMutex;

    @Nullable
    private SeekingAnimationState currentAnimation;

    /* JADX INFO: renamed from: currentState$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState currentState;
    private float durationScale;

    @NotNull
    private final Function1<Long, Unit> firstFrameLambda;

    /* JADX INFO: renamed from: fraction$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableFloatState fraction;

    @NotNull
    private final MutableObjectList<SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos;

    @NotNull
    private final MutatorMutex mutatorMutex;

    @NotNull
    private final Function0<Unit> recalculateTotalDurationNanos;

    /* JADX INFO: renamed from: targetState$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState targetState;
    private long totalDurationNanos;

    @Nullable
    private Transition<S> transition;

    @NotNull
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);

    @NotNull
    private static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "()V", "Target1", "Landroidx/compose/animation/core/AnimationVector1D;", "getTarget1", "()Landroidx/compose/animation/core/AnimationVector1D;", "ZeroVelocity", "getZeroVelocity", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }

        @NotNull
        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, m13886d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "()V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "animationSpecDuration", "", "getAnimationSpecDuration", "()J", "setAnimationSpecDuration", "(J)V", "durationNanos", "getDurationNanos", "setDurationNanos", "initialVelocity", "getInitialVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "setInitialVelocity", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "progressNanos", "getProgressNanos", "setProgressNanos", "start", "getStart", "setStart", "value", "", "getValue", "()F", "setValue", "(F)V", "toString", "", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SeekingAnimationState {
        public static final int $stable = 8;

        @Nullable
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;

        @Nullable
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;

        @NotNull
        private AnimationVector1D start = new AnimationVector1D(0.0f);
        private float value;

        @Nullable
        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        @Nullable
        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        @NotNull
        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final float getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: isComplete, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        public final void setAnimationSpec(@Nullable VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec) {
            this.animationSpec = vectorizedAnimationSpec;
        }

        public final void setAnimationSpecDuration(long j) {
            this.animationSpecDuration = j;
        }

        public final void setComplete(boolean z) {
            this.isComplete = z;
        }

        public final void setDurationNanos(long j) {
            this.durationNanos = j;
        }

        public final void setInitialVelocity(@Nullable AnimationVector1D animationVector1D) {
            this.initialVelocity = animationVector1D;
        }

        public final void setProgressNanos(long j) {
            this.progressNanos = j;
        }

        public final void setStart(@NotNull AnimationVector1D animationVector1D) {
            this.start = animationVector1D;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        @NotNull
        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "S"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", m14021f = "Transition.kt", m14022i = {}, m14023l = {623}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C07262 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", m14021f = "Transition.kt", m14022i = {0}, m14023l = {2191, 636, 638, 690, 692}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
        @SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/SeekableTransitionState$animateTo$2$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,2185:1\n120#2,10:2186\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/SeekableTransitionState$animateTo$2$1\n*L\n634#1:2186,10\n*E\n"})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = seekableTransitionState;
                this.$targetState = s;
                this.$transition = transition;
                this.$animationSpec = finiteAnimationSpec;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:74:0x01e8, code lost:
            
                if (r2.waitForComposition(r18) != r0) goto L76;
             */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) {
                Mutex mutex;
                SeekableTransitionState<S> seekableTransitionState;
                SeekableTransitionState<S> seekableTransitionState2;
                AnimationVector1D zeroVelocity;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        S targetState = this.this$0.getTargetState();
                        if (!Intrinsics.areEqual(this.$targetState, targetState)) {
                            this.this$0.moveAnimationToInitialState();
                            this.this$0.setFraction(0.0f);
                            this.$transition.updateTarget$animation_core_release(this.$targetState);
                            this.$transition.setPlayTimeNanos(0L);
                            this.this$0.setCurrentState$animation_core_release(targetState);
                            this.this$0.setTargetState$animation_core_release(this.$targetState);
                        }
                        Mutex compositionContinuationMutex = this.this$0.getCompositionContinuationMutex();
                        SeekableTransitionState<S> seekableTransitionState3 = this.this$0;
                        this.L$0 = compositionContinuationMutex;
                        this.L$1 = seekableTransitionState3;
                        this.label = 1;
                        if (compositionContinuationMutex.lock(null, this) != coroutine_suspended) {
                            mutex = compositionContinuationMutex;
                            seekableTransitionState = seekableTransitionState3;
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        seekableTransitionState = (SeekableTransitionState) this.L$1;
                        mutex = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            seekableTransitionState2 = this.this$0;
                            this.label = 3;
                            if (seekableTransitionState2.waitForCompositionAfterTargetStateChange(this) != coroutine_suspended) {
                                if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                                }
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                                if (this.this$0.getFraction() < 1.0f) {
                                    SeekingAnimationState seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                                    FiniteAnimationSpec<Float> finiteAnimationSpec = this.$animationSpec;
                                    VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpecVectorize = finiteAnimationSpec != null ? finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)) : null;
                                    if (seekingAnimationState == null || !Intrinsics.areEqual(vectorizedAnimationSpecVectorize, seekingAnimationState.getAnimationSpec())) {
                                        VectorizedAnimationSpec<AnimationVector1D> animationSpec = seekingAnimationState != null ? seekingAnimationState.getAnimationSpec() : null;
                                        if (animationSpec != null) {
                                            long progressNanos = seekingAnimationState.getProgressNanos();
                                            AnimationVector1D start = seekingAnimationState.getStart();
                                            AnimationVector1D target1 = SeekableTransitionState.Companion.getTarget1();
                                            AnimationVector1D initialVelocity = seekingAnimationState.getInitialVelocity();
                                            if (initialVelocity == null) {
                                                initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                            }
                                            zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos, start, target1, initialVelocity);
                                        } else if (seekingAnimationState == null || seekingAnimationState.getProgressNanos() == 0) {
                                            zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                        } else {
                                            long durationNanos = seekingAnimationState.getDurationNanos();
                                            if (durationNanos == Long.MIN_VALUE) {
                                                durationNanos = this.this$0.getTotalDurationNanos();
                                            }
                                            float f = durationNanos / 1.0E9f;
                                            zeroVelocity = f <= 0.0f ? SeekableTransitionState.Companion.getZeroVelocity() : new AnimationVector1D(1.0f / f);
                                        }
                                        if (seekingAnimationState == null) {
                                            seekingAnimationState = new SeekingAnimationState();
                                        }
                                        seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                        seekingAnimationState.setComplete(false);
                                        seekingAnimationState.setValue(this.this$0.getFraction());
                                        seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                        seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos());
                                        seekingAnimationState.setProgressNanos(0L);
                                        seekingAnimationState.setInitialVelocity(zeroVelocity);
                                        seekingAnimationState.setAnimationSpecDuration(vectorizedAnimationSpecVectorize != null ? vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity) : MathKt.roundToLong((1.0d - ((double) this.this$0.getFraction())) * this.this$0.getTotalDurationNanos()));
                                        ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                    }
                                }
                                SeekableTransitionState<S> seekableTransitionState4 = this.this$0;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 4;
                                if (seekableTransitionState4.runAnimations(this) != coroutine_suspended) {
                                    this.this$0.setCurrentState$animation_core_release(this.$targetState);
                                    SeekableTransitionState<S> seekableTransitionState5 = this.this$0;
                                    this.label = 5;
                                }
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        if (i != 4) {
                            if (i != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            this.this$0.setFraction(0.0f);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        this.this$0.setCurrentState$animation_core_release(this.$targetState);
                        SeekableTransitionState<S> seekableTransitionState52 = this.this$0;
                        this.label = 5;
                    }
                    S composedTargetState$animation_core_release = seekableTransitionState.getComposedTargetState$animation_core_release();
                    mutex.unlock(null);
                    if (!Intrinsics.areEqual(this.$targetState, composedTargetState$animation_core_release)) {
                        SeekableTransitionState<S> seekableTransitionState6 = this.this$0;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 2;
                        if (seekableTransitionState6.doOneFrame(this) != coroutine_suspended) {
                            seekableTransitionState2 = this.this$0;
                            this.label = 3;
                            if (seekableTransitionState2.waitForCompositionAfterTargetStateChange(this) != coroutine_suspended) {
                            }
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07262(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super C07262> continuation) {
            super(1, continuation);
            this.$transition = transition;
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new C07262(this.$transition, this.this$0, this.$targetState, this.$animationSpec, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$transition.onTransitionEnd$animation_core_release();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((C07262) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState", m14021f = "Transition.kt", m14022i = {0, 1}, m14023l = {370, 373}, m14024m = "runAnimations", m14025n = {"this", "this"}, m14026s = {"L$0", "L$0"})
    public static final class C07271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07271(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C07271> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runAnimations(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "S"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", m14021f = "Transition.kt", m14022i = {}, m14023l = {509}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C07283 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $fraction;
        final /* synthetic */ S $oldTargetState;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", m14021f = "Transition.kt", m14022i = {}, m14023l = {531}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ float $fraction;
            final /* synthetic */ S $oldTargetState;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1", m14021f = "Transition.kt", m14022i = {}, m14023l = {527}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SeekableTransitionState<S> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145241(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C145241> continuation) {
                    super(2, continuation);
                    this.this$0 = seekableTransitionState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C145241(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SeekableTransitionState<S> seekableTransitionState = this.this$0;
                        this.label = 1;
                        if (seekableTransitionState.runAnimations(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$targetState = s;
                this.$oldTargetState = s2;
                this.this$0 = seekableTransitionState;
                this.$transition = transition;
                this.$fraction = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    if (Intrinsics.areEqual(this.$targetState, this.$oldTargetState)) {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                        if (Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                            return Unit.INSTANCE;
                        }
                    } else {
                        this.this$0.moveAnimationToInitialState();
                    }
                    if (!Intrinsics.areEqual(this.$targetState, this.$oldTargetState)) {
                        this.$transition.updateTarget$animation_core_release(this.$targetState);
                        this.$transition.setPlayTimeNanos(0L);
                        this.this$0.setTargetState$animation_core_release(this.$targetState);
                        this.$transition.resetAnimationFraction$animation_core_release(this.$fraction);
                    }
                    this.this$0.setFraction(this.$fraction);
                    if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C145241(this.this$0, null), 3, null);
                    } else {
                        ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                    }
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    this.label = 1;
                    if (seekableTransitionState.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.seekToFraction();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07283(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super C07283> continuation) {
            super(1, continuation);
            this.$targetState = s;
            this.$oldTargetState = s2;
            this.this$0 = seekableTransitionState;
            this.$transition = transition;
            this.$fraction = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new C07283(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((C07283) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$snapTo$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "S"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", m14021f = "Transition.kt", m14022i = {}, m14023l = {477}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C07292 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07292(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, Continuation<? super C07292> continuation) {
            super(1, continuation);
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$transition = transition;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new C07292(this.this$0, this.$targetState, this.$transition, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.endAllAnimations();
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                this.this$0.setFraction(0.0f);
                S s = this.$targetState;
                float f = Intrinsics.areEqual(s, this.this$0.getCurrentState()) ? -4.0f : Intrinsics.areEqual(s, this.this$0.getTargetState()) ? -5.0f : -3.0f;
                this.$transition.updateTarget$animation_core_release(this.$targetState);
                this.$transition.setPlayTimeNanos(0L);
                this.this$0.setTargetState$animation_core_release(this.$targetState);
                this.this$0.setFraction(0.0f);
                this.this$0.setCurrentState$animation_core_release(this.$targetState);
                this.$transition.resetAnimationFraction$animation_core_release(f);
                if (f == -3.0f) {
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    this.label = 1;
                    if (seekableTransitionState.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$transition.onTransitionEnd$animation_core_release();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((C07292) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState", m14021f = "Transition.kt", m14022i = {0, 0, 1, 1}, m14023l = {566, 2186}, m14024m = "waitForComposition", m14025n = {"this", "expectedState", "this", "expectedState"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C07301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07301(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C07301> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForComposition(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.animation.core.SeekableTransitionState", m14021f = "Transition.kt", m14022i = {0, 0, 1, 1}, m14023l = {542, 2186}, m14024m = "waitForCompositionAfterTargetStateChange", m14025n = {"this", "expectedState", "this", "expectedState"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C07311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07311(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C07311> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForCompositionAfterTargetStateChange(this);
        }
    }

    public SeekableTransitionState(S s) {
        super(null);
        this.targetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.currentState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.composedTargetState = s;
        this.recalculateTotalDurationNanos = new Function0<Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$recalculateTotalDurationNanos$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SeekableTransitionState<S> seekableTransitionState = this.this$0;
                Transition transition = ((SeekableTransitionState) seekableTransitionState).transition;
                seekableTransitionState.setTotalDurationNanos$animation_core_release(transition != null ? transition.getTotalDurationNanos() : 0L);
            }
        };
        this.fraction = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.compositionContinuationMutex = MutexKt.Mutex$default(false, 1, null);
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList<>(0, 1, null);
        this.firstFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$firstFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j;
            }
        };
        this.animateOneFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$animateOneFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                long j2 = j - ((SeekableTransitionState) this.this$0).lastFrameTimeNanos;
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j;
                long jRoundToLong = MathKt.roundToLong(j2 / ((double) ((SeekableTransitionState) this.this$0).durationScale));
                if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                    MutableObjectList mutableObjectList = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    Object[] objArr = mutableObjectList.content;
                    int i = mutableObjectList._size;
                    int i2 = 0;
                    for (int i4 = 0; i4 < i; i4++) {
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i4];
                        seekableTransitionState.recalculateAnimationValue(seekingAnimationState, jRoundToLong);
                        seekingAnimationState.setComplete(true);
                    }
                    Transition transition = ((SeekableTransitionState) this.this$0).transition;
                    if (transition != null) {
                        transition.updateInitialValues$animation_core_release();
                    }
                    MutableObjectList mutableObjectList2 = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    int i5 = mutableObjectList2._size;
                    Object[] objArr2 = mutableObjectList2.content;
                    IntRange intRangeUntil = RangesKt.until(0, i5);
                    int first = intRangeUntil.getFirst();
                    int last = intRangeUntil.getLast();
                    if (first <= last) {
                        while (true) {
                            objArr2[first - i2] = objArr2[first];
                            if (((SeekableTransitionState.SeekingAnimationState) objArr2[first]).getIsComplete()) {
                                i2++;
                            }
                            if (first == last) {
                                break;
                            } else {
                                first++;
                            }
                        }
                    }
                    ArraysKt___ArraysJvmKt.fill(objArr2, (Object) null, i5 - i2, i5);
                    mutableObjectList2._size -= i2;
                }
                SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = ((SeekableTransitionState) this.this$0).currentAnimation;
                if (seekingAnimationState2 != null) {
                    seekingAnimationState2.setDurationNanos(this.this$0.getTotalDurationNanos());
                    this.this$0.recalculateAnimationValue(seekingAnimationState2, jRoundToLong);
                    this.this$0.setFraction(seekingAnimationState2.getValue());
                    if (seekingAnimationState2.getValue() == 1.0f) {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                    }
                    this.this$0.seekToFraction();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateOneFrame(Continuation<? super Unit> continuation) {
        float durationScale = SuspendAnimationKt.getDurationScale(continuation.getContext());
        if (durationScale <= 0.0f) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale;
        Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, continuation);
        return objWithFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.animateTo(obj, finiteAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doOneFrame(Continuation<? super Unit> continuation) {
        if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
            Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, continuation);
            return objWithFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
        }
        Object objAnimateOneFrame = animateOneFrame(continuation);
        return objAnimateOneFrame == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateOneFrame : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAllAnimations() {
        Transition<S> transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core_release();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveAnimationToInitialState() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = this.currentAnimation;
        if (seekingAnimationState == null) {
            if (this.totalDurationNanos <= 0 || getFraction() == 1.0f || Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                seekingAnimationState = null;
            } else {
                seekingAnimationState = new SeekingAnimationState();
                seekingAnimationState.setValue(getFraction());
                long j = this.totalDurationNanos;
                seekingAnimationState.setDurationNanos(j);
                seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong((1.0d - ((double) getFraction())) * j));
                seekingAnimationState.getStart().set$animation_core_release(0, getFraction());
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.setDurationNanos(this.totalDurationNanos);
            this.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core_release(seekingAnimationState);
        }
        this.currentAnimation = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recalculateAnimationValue(SeekingAnimationState animation, long deltaPlayTimeNanos) {
        long progressNanos = animation.getProgressNanos() + deltaPlayTimeNanos;
        animation.setProgressNanos(progressNanos);
        long animationSpecDuration = animation.getAnimationSpecDuration();
        if (progressNanos >= animationSpecDuration) {
            animation.setValue(1.0f);
            return;
        }
        VectorizedAnimationSpec<AnimationVector1D> animationSpec = animation.getAnimationSpec();
        if (animationSpec == null) {
            animation.setValue(VectorConvertersKt.lerp(animation.getStart().get$animation_core_release(0), 1.0f, progressNanos / animationSpecDuration));
            return;
        }
        AnimationVector1D start = animation.getStart();
        AnimationVector1D animationVector1D = Target1;
        AnimationVector1D initialVelocity = animation.getInitialVelocity();
        if (initialVelocity == null) {
            initialVelocity = ZeroVelocity;
        }
        animation.setValue(RangesKt.coerceIn(((AnimationVector1D) animationSpec.getValueFromNanos(progressNanos, start, animationVector1D, initialVelocity)).get$animation_core_release(0), 0.0f, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r10, r0) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runAnimations(Continuation<? super Unit> continuation) {
        C07271 c07271;
        SeekableTransitionState seekableTransitionState;
        if (continuation instanceof C07271) {
            c07271 = (C07271) continuation;
            int i = c07271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c07271.label = i - Integer.MIN_VALUE;
            } else {
                c07271 = new C07271(this, continuation);
            }
        }
        Object obj = c07271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07271.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.initialValueAnimations.isEmpty() && this.currentAnimation == null) {
                return Unit.INSTANCE;
            }
            if (SuspendAnimationKt.getDurationScale(c07271.getContext()) == 0.0f) {
                endAllAnimations();
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
            if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
                Function1<Long, Unit> function1 = this.firstFrameLambda;
                c07271.L$0 = this;
                c07271.label = 1;
            }
            seekableTransitionState = this;
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            seekableTransitionState = (SeekableTransitionState) c07271.L$0;
            ResultKt.throwOnFailure(obj);
        }
        do {
            if (!seekableTransitionState.initialValueAnimations.isNotEmpty() && seekableTransitionState.currentAnimation == null) {
                seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
            c07271.L$0 = seekableTransitionState;
            c07271.label = 2;
        } while (seekableTransitionState.animateOneFrame(c07271) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object seekTo$default(SeekableTransitionState seekableTransitionState, float f, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f, obj, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToFraction() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        transition.seekAnimations$animation_core_release(MathKt.roundToLong(((double) getFraction()) * transition.getTotalDurationNanos()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFraction(float f) {
        this.fraction.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForComposition(Continuation<? super Unit> continuation) {
        C07301 c07301;
        Object targetState;
        SeekableTransitionState seekableTransitionState;
        Object obj;
        SeekableTransitionState seekableTransitionState2;
        if (continuation instanceof C07301) {
            c07301 = (C07301) continuation;
            int i = c07301.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c07301.label = i - Integer.MIN_VALUE;
            } else {
                c07301 = new C07301(this, continuation);
            }
        }
        Object obj2 = c07301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07301.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            targetState = getTargetState();
            Mutex mutex = this.compositionContinuationMutex;
            c07301.L$0 = this;
            c07301.L$1 = targetState;
            c07301.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c07301, 1, null) != coroutine_suspended) {
                seekableTransitionState = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c07301.L$1;
            seekableTransitionState2 = (SeekableTransitionState) c07301.L$0;
            ResultKt.throwOnFailure(obj2);
            if (!Intrinsics.areEqual(obj2, obj)) {
                return Unit.INSTANCE;
            }
            seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
            throw new CancellationException("targetState while waiting for composition");
        }
        Object obj3 = c07301.L$1;
        seekableTransitionState = (SeekableTransitionState) c07301.L$0;
        ResultKt.throwOnFailure(obj2);
        targetState = obj3;
        c07301.L$0 = seekableTransitionState;
        c07301.L$1 = targetState;
        c07301.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c07301), 1);
        cancellableContinuationImpl.initCancellability();
        seekableTransitionState.setCompositionContinuation$animation_core_release(cancellableContinuationImpl);
        Mutex.DefaultImpls.unlock$default(seekableTransitionState.getCompositionContinuationMutex(), null, 1, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c07301);
        }
        if (result != coroutine_suspended) {
            obj = targetState;
            obj2 = result;
            seekableTransitionState2 = seekableTransitionState;
            if (!Intrinsics.areEqual(obj2, obj)) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForCompositionAfterTargetStateChange(Continuation<? super Unit> continuation) {
        C07311 c07311;
        Object targetState;
        SeekableTransitionState seekableTransitionState;
        Object obj;
        SeekableTransitionState seekableTransitionState2;
        if (continuation instanceof C07311) {
            c07311 = (C07311) continuation;
            int i = c07311.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c07311.label = i - Integer.MIN_VALUE;
            } else {
                c07311 = new C07311(this, continuation);
            }
        }
        Object obj2 = c07311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07311.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            targetState = getTargetState();
            Mutex mutex = this.compositionContinuationMutex;
            c07311.L$0 = this;
            c07311.L$1 = targetState;
            c07311.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c07311, 1, null) != coroutine_suspended) {
                seekableTransitionState = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c07311.L$1;
            seekableTransitionState2 = (SeekableTransitionState) c07311.L$0;
            ResultKt.throwOnFailure(obj2);
            if (!Intrinsics.areEqual(obj2, obj)) {
                seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
                throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
            }
            return Unit.INSTANCE;
        }
        Object obj3 = c07311.L$1;
        seekableTransitionState = (SeekableTransitionState) c07311.L$0;
        ResultKt.throwOnFailure(obj2);
        targetState = obj3;
        if (Intrinsics.areEqual(targetState, seekableTransitionState.composedTargetState)) {
            Mutex.DefaultImpls.unlock$default(seekableTransitionState.compositionContinuationMutex, null, 1, null);
            return Unit.INSTANCE;
        }
        c07311.L$0 = seekableTransitionState;
        c07311.L$1 = targetState;
        c07311.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c07311), 1);
        cancellableContinuationImpl.initCancellability();
        seekableTransitionState.setCompositionContinuation$animation_core_release(cancellableContinuationImpl);
        Mutex.DefaultImpls.unlock$default(seekableTransitionState.getCompositionContinuationMutex(), null, 1, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c07311);
        }
        if (result != coroutine_suspended) {
            obj = targetState;
            obj2 = result;
            seekableTransitionState2 = seekableTransitionState;
            if (!Intrinsics.areEqual(obj2, obj)) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @Nullable
    public final Object animateTo(S s, @Nullable FiniteAnimationSpec<Float> finiteAnimationSpec, @NotNull Continuation<? super Unit> continuation) {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C07262(transition, this, s, finiteAnimationSpec, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    public final S getComposedTargetState$animation_core_release() {
        return this.composedTargetState;
    }

    @Nullable
    public final CancellableContinuation<S> getCompositionContinuation$animation_core_release() {
        return this.compositionContinuation;
    }

    @NotNull
    /* JADX INFO: renamed from: getCompositionContinuationMutex$animation_core_release, reason: from getter */
    public final Mutex getCompositionContinuationMutex() {
        return this.compositionContinuationMutex;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState.getValue();
    }

    @FloatRange(from = 0.0d, m705to = 1.0d)
    public final float getFraction() {
        return this.fraction.getFloatValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState.getValue();
    }

    /* JADX INFO: renamed from: getTotalDurationNanos$animation_core_release, reason: from getter */
    public final long getTotalDurationNanos() {
        return this.totalDurationNanos;
    }

    public final void observeTotalDuration$animation_core_release() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
    }

    public final void onTotalDurationChanged$animation_core_release() {
        long j = this.totalDurationNanos;
        observeTotalDuration$animation_core_release();
        long j2 = this.totalDurationNanos;
        if (j != j2) {
            SeekingAnimationState seekingAnimationState = this.currentAnimation;
            if (seekingAnimationState == null) {
                if (j2 != 0) {
                    seekToFraction();
                }
            } else {
                seekingAnimationState.setDurationNanos(j2);
                if (seekingAnimationState.getAnimationSpec() == null) {
                    seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong((1.0d - ((double) seekingAnimationState.getStart().get$animation_core_release(0))) * this.totalDurationNanos));
                }
            }
        }
    }

    @Nullable
    public final Object seekTo(@FloatRange(from = 0.0d, m705to = 1.0d) float f, S s, @NotNull Continuation<? super Unit> continuation) {
        boolean z = false;
        if (0.0f <= f && f <= 1.0f) {
            z = true;
        }
        if (!z) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f);
        }
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C07283(s, getTargetState(), this, transition, f, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    public final void setComposedTargetState$animation_core_release(S s) {
        this.composedTargetState = s;
    }

    public final void setCompositionContinuation$animation_core_release(@Nullable CancellableContinuation<? super S> cancellableContinuation) {
        this.compositionContinuation = cancellableContinuation;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core_release(S s) {
        this.currentState.setValue(s);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setTargetState$animation_core_release(S s) {
        this.targetState.setValue(s);
    }

    public final void setTotalDurationNanos$animation_core_release(long j) {
        this.totalDurationNanos = j;
    }

    @Nullable
    public final Object snapTo(S s, @NotNull Continuation<? super Unit> continuation) {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(getCurrentState(), s) && Intrinsics.areEqual(getTargetState(), s)) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C07292(this, s, transition, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core_release(@NotNull Transition<S> transition) {
        Transition<S> transition2 = this.transition;
        if (!(transition2 == null || Intrinsics.areEqual(transition, transition2))) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }
}
