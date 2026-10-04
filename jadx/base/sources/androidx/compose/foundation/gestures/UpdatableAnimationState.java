package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.p109ui.MotionDurationScale;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JJ\u0010\u0013\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/animation/core/AnimationSpec;)V", "isRunning", "", "lastFrameTime", "", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "value", "getValue", "()F", "setValue", "(F)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nUpdatableAnimationState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdatableAnimationState.kt\nandroidx/compose/foundation/gestures/UpdatableAnimationState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,170:1\n1#2:171\n*E\n"})
public final class UpdatableAnimationState {

    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;

    @NotNull
    private AnimationVector1D lastVelocity = ZeroVector;
    private float value;

    @NotNull
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;

    @NotNull
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u00020\n*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f) {
            return Math.abs(f) < 0.01f;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.UpdatableAnimationState", m14021f = "UpdatableAnimationState.kt", m14022i = {0, 0, 0, 0, 1, 1}, m14023l = {101, 147}, m14024m = "animateToZero", m14025n = {"this", "beforeFrame", "afterFrame", "durationScale", "this", "afterFrame"}, m14026s = {"L$0", "L$1", "L$2", "F$0", "L$0", "L$1"})
    public static final class C09331 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C09331(Continuation<? super C09331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdatableAnimationState.this.animateToZero(null, null, this);
        }
    }

    public UpdatableAnimationState(@NotNull AnimationSpec<Float> animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ce, code lost:
    
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r0, r2) == r1) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082 A[Catch: all -> 0x00ae, PHI: r0 r2 r12 r13 r14
      0x0082: PHI (r0v9 ??) = (r0v3 ??), (r0v15 ??) binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r2v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r2v2 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r2v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r12v7 float) = (r12v4 float), (r12v8 float) binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r13v7 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>) = 
      (r13v4 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
      (r13v8 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
     binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r14v15 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r14v9 androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r14v16 androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #2 {all -> 0x00ae, blocks: (B:36:0x00a2, B:31:0x0082, B:33:0x008c), top: B:59:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[Catch: all -> 0x00ae, TryCatch #2 {all -> 0x00ae, blocks: (B:36:0x00a2, B:31:0x0082, B:33:0x008c), top: B:59:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a9 A[PHI: r0 r2 r13 r14
      0x00a9: PHI (r0v4 ??) = (r0v16 ??), (r0v17 ??) binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r2v3 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r2v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r2v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r13v5 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>) = 
      (r13v7 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
      (r13v8 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
     binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r14v11 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r14v15 androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r14v16 androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v12, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function0<kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x009f -> B:59:0x00a2). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToZero(@NotNull Function1<? super Float, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        C09331 c09331;
        C09331 c093312;
        ?? r02;
        final Function1<? super Float, Unit> function12;
        final float f;
        UpdatableAnimationState updatableAnimationState;
        ?? r03;
        ?? r04;
        ?? r13;
        ?? r12;
        if (continuation instanceof C09331) {
            c09331 = (C09331) continuation;
            int i = c09331.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c09331.label = i - Integer.MIN_VALUE;
            } else {
                c09331 = new C09331(continuation);
            }
        }
        Object obj = c09331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09331.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.isRunning) {
                    throw new IllegalStateException("animateToZero called while previous animation is running");
                }
                MotionDurationScale motionDurationScale = (MotionDurationScale) c09331.getContext().get(MotionDurationScale.INSTANCE);
                float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
                this.isRunning = true;
                c093312 = c09331;
                r02 = function0;
                function12 = function1;
                f = scaleFactor;
                updatableAnimationState = this;
                r03 = r02;
                if (Companion.isZeroish(updatableAnimationState.value)) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Function0 function02 = (Function0) c09331.L$1;
                UpdatableAnimationState updatableAnimationState2 = (UpdatableAnimationState) c09331.L$0;
                ResultKt.throwOnFailure(obj);
                r12 = function02;
                function0 = updatableAnimationState2;
                r12.invoke();
                r13 = function0;
                r13.lastFrameTime = Long.MIN_VALUE;
                r13.lastVelocity = ZeroVector;
                r13.isRunning = false;
                return Unit.INSTANCE;
            }
            f = c09331.F$0;
            Function0 function03 = (Function0) c09331.L$2;
            Function1<? super Float, Unit> function13 = (Function1) c09331.L$1;
            UpdatableAnimationState updatableAnimationState3 = (UpdatableAnimationState) c09331.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                C09331 c093313 = c09331;
                r04 = function03;
                function12 = function13;
                c093312 = c093313;
                updatableAnimationState = updatableAnimationState3;
            } catch (Throwable th) {
                th = th;
                function0 = updatableAnimationState3;
                function0.lastFrameTime = Long.MIN_VALUE;
                function0.lastVelocity = ZeroVector;
                function0.isRunning = false;
                throw th;
            }
            try {
                r04.invoke();
                r02 = r04;
                r03 = r04;
                if (f == 0.0f) {
                    r03 = r02;
                    if (Companion.isZeroish(updatableAnimationState.value)) {
                        Function1<Long, Unit> function14 = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero.4
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

                            public final void invoke(long j) {
                                if (UpdatableAnimationState.this.lastFrameTime == Long.MIN_VALUE) {
                                    UpdatableAnimationState.this.lastFrameTime = j;
                                }
                                AnimationVector1D animationVector1D = new AnimationVector1D(UpdatableAnimationState.this.getValue());
                                long durationNanos = f == 0.0f ? UpdatableAnimationState.this.vectorizedSpec.getDurationNanos(new AnimationVector1D(UpdatableAnimationState.this.getValue()), UpdatableAnimationState.Companion.getZeroVector(), UpdatableAnimationState.this.lastVelocity) : MathKt.roundToLong((j - UpdatableAnimationState.this.lastFrameTime) / f);
                                float value = ((AnimationVector1D) UpdatableAnimationState.this.vectorizedSpec.getValueFromNanos(durationNanos, animationVector1D, UpdatableAnimationState.Companion.getZeroVector(), UpdatableAnimationState.this.lastVelocity)).getValue();
                                UpdatableAnimationState updatableAnimationState4 = UpdatableAnimationState.this;
                                updatableAnimationState4.lastVelocity = (AnimationVector1D) updatableAnimationState4.vectorizedSpec.getVelocityFromNanos(durationNanos, animationVector1D, UpdatableAnimationState.Companion.getZeroVector(), UpdatableAnimationState.this.lastVelocity);
                                UpdatableAnimationState.this.lastFrameTime = j;
                                float value2 = UpdatableAnimationState.this.getValue() - value;
                                UpdatableAnimationState.this.setValue(value);
                                function12.invoke(Float.valueOf(value2));
                            }
                        };
                        c093312.L$0 = updatableAnimationState;
                        c093312.L$1 = function12;
                        c093312.L$2 = r02;
                        c093312.F$0 = f;
                        c093312.label = 1;
                        r04 = r02;
                        if (MonotonicFrameClockKt.withFrameNanos(function14, c093312) == coroutine_suspended) {
                        }
                        r04.invoke();
                        r02 = r04;
                        r03 = r04;
                        if (f == 0.0f) {
                        }
                    }
                    return coroutine_suspended;
                }
                UpdatableAnimationState updatableAnimationState4 = updatableAnimationState;
                final Function1<? super Float, Unit> function15 = function12;
                UpdatableAnimationState updatableAnimationState5 = updatableAnimationState4;
                ?? r122 = r03;
                if (Math.abs(updatableAnimationState5.value) == 0.0f) {
                    r13 = updatableAnimationState5;
                } else {
                    Function1<Long, Unit> function16 = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero.5
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

                        public final void invoke(long j) {
                            float value = UpdatableAnimationState.this.getValue();
                            UpdatableAnimationState.this.setValue(0.0f);
                            function15.invoke(Float.valueOf(value));
                        }
                    };
                    c093312.L$0 = updatableAnimationState5;
                    c093312.L$1 = r122;
                    c093312.L$2 = null;
                    c093312.label = 2;
                    r12 = r122;
                    function0 = updatableAnimationState5;
                }
                r13.lastFrameTime = Long.MIN_VALUE;
                r13.lastVelocity = ZeroVector;
                r13.isRunning = false;
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                function0 = updatableAnimationState;
                function0.lastFrameTime = Long.MIN_VALUE;
                function0.lastVelocity = ZeroVector;
                function0.isRunning = false;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }
}
