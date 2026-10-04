package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000 f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001fBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ#\u0010S\u001a\u00020T2\u0006\u0010I\u001a\u00028\u00002\b\b\u0002\u0010U\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010VJe\u0010W\u001a\u00028\u00002\u0006\u00109\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u000026\u0010X\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00060=2\u0006\u0010U\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0006J\u0013\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00028\u0000¢\u0006\u0002\u0010^J\u0019\u0010_\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u0019\u0010a\u001a\u00020T2\u0006\u0010I\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ!\u0010c\u001a\u00020T2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000fH\u0000¢\u0006\u0002\beRC\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R+\u0010'\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0016\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u0010,\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0016\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00102\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b3\u0010.R\u001b\u00106\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u0010.R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u008b\u0001\u0010@\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00060=26\u0010\u000e\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00060=8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0016\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u00105\u001a\u0004\bG\u0010.R\u001b\u0010I\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u00105\u001a\u0004\bJ\u0010\u001dR\u001b\u0010L\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00105\u001a\u0004\bM\u0010.R+\u0010O\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010\u0016\u001a\u0004\bP\u0010.\"\u0004\bQ\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, m13886d2 = {"Landroidx/compose/material/SwipeableV2State;", "T", "", "initialState", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getConfirmStateChange", "()Lkotlin/jvm/functions/Function1;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState", "(Ljava/lang/Object;)V", "currentState$delegate", "dragPosition", "Landroidx/compose/runtime/MutableState;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "maxBound", "getMaxBound", "maxBound$delegate", "Landroidx/compose/runtime/State;", "minBound", "getMinBound", "minBound$delegate", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "Lkotlin/Function2;", "lower", "upper", "positionalThresholds", "getPositionalThresholds", "()Lkotlin/jvm/functions/Function2;", "setPositionalThresholds", "(Lkotlin/jvm/functions/Function2;)V", "positionalThresholds$delegate", "progress", "getProgress", "progress$delegate", "targetState", "getTargetState", "targetState$delegate", "unsafeOffset", "getUnsafeOffset", "unsafeOffset$delegate", "velocityThreshold", "getVelocityThreshold", "setVelocityThreshold", "velocityThreshold$delegate", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "thresholds", "(FLjava/lang/Object;Lkotlin/jvm/functions/Function2;FF)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForState", "state", "(Ljava/lang/Object;)Z", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnchors", "newAnchors", "updateAnchors$material_release", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@Stable
@ExperimentalMaterialApi
public final class SwipeableV2State<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: anchors$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState anchors;

    @NotNull
    private final AnimationSpec<Float> animationSpec;

    @NotNull
    private final Function1<T, Boolean> confirmStateChange;

    /* JADX INFO: renamed from: currentState$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState currentState;

    @NotNull
    private final MutableState<Float> dragPosition;

    @NotNull
    private final DraggableState draggableState;

    /* JADX INFO: renamed from: isAnimationRunning$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState isAnimationRunning;

    /* JADX INFO: renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState lastVelocity;

    /* JADX INFO: renamed from: maxBound$delegate, reason: from kotlin metadata */
    @NotNull
    private final State maxBound;

    /* JADX INFO: renamed from: minBound$delegate, reason: from kotlin metadata */
    @NotNull
    private final State minBound;

    @NotNull
    private final State<Float> offset;

    /* JADX INFO: renamed from: positionalThresholds$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState positionalThresholds;

    /* JADX INFO: renamed from: progress$delegate, reason: from kotlin metadata */
    @NotNull
    private final State progress;

    /* JADX INFO: renamed from: targetState$delegate, reason: from kotlin metadata */
    @NotNull
    private final State targetState;

    /* JADX INFO: renamed from: unsafeOffset$delegate, reason: from kotlin metadata */
    @NotNull
    private final State unsafeOffset;

    /* JADX INFO: renamed from: velocityThreshold$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState velocityThreshold;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, m13886d2 = {"Landroidx/compose/material/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> Saver<SwipeableV2State<T>, T> Saver(@NotNull final AnimationSpec<Float> animationSpec, @NotNull final Function1<? super T, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final T invoke(@NotNull SaverScope Saver, @NotNull SwipeableV2State<T> it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentState();
                }
            }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final SwipeableV2State<T> invoke(@NotNull T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SwipeableV2State<>(it, animationSpec, confirmStateChange);
                }
            });
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableV2State$animateTo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SwipeableV2State", m14021f = "SwipeableV2.kt", m14022i = {0}, m14023l = {250}, m14024m = "animateTo", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C16451 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16451(SwipeableV2State<T> swipeableV2State, Continuation<? super C16451> continuation) {
            super(continuation);
            this.this$0 = swipeableV2State;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.animateTo(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableV2State$animateTo$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SwipeableV2State$animateTo$2", m14021f = "SwipeableV2.kt", m14022i = {}, m14023l = {JPEG.COM}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C16462 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $targetOffset;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16462(SwipeableV2State<T> swipeableV2State, float f, float f4, Continuation<? super C16462> continuation) {
            super(2, continuation);
            this.this$0 = swipeableV2State;
            this.$targetOffset = f;
            this.$velocity = f4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C16462 c16462 = new C16462(this.this$0, this.$targetOffset, this.$velocity, continuation);
            c16462.L$0 = obj;
            return c16462;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C16462) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            C16462 c16462;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    ResultKt.throwOnFailure(obj);
                    c16462 = this;
                    c16462.this$0.setAnimationRunning(false);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    c16462 = this;
                    c16462.this$0.setAnimationRunning(false);
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            final DragScope dragScope = (DragScope) this.L$0;
            this.this$0.setAnimationRunning(true);
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            float fFloatValue = ((Number) ((SwipeableV2State) this.this$0).dragPosition.getValue()).floatValue();
            floatRef.element = fFloatValue;
            try {
                float f = this.$targetOffset;
                float f4 = this.$velocity;
                AnimationSpec<Float> animationSpec = this.this$0.getAnimationSpec();
                final SwipeableV2State<T> swipeableV2State = this.this$0;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.material.SwipeableV2State.animateTo.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Float f5, Float f6) {
                        invoke(f5.floatValue(), f6.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f5, float f6) {
                        dragScope.dragBy(f5 - floatRef.element);
                        floatRef.element = f5;
                        swipeableV2State.setLastVelocity(f6);
                    }
                };
                this.label = 1;
                c16462 = this;
                try {
                    if (SuspendAnimationKt.animate(fFloatValue, f, f4, animationSpec, function2, c16462) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c16462.this$0.setAnimationRunning(false);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    c16462.this$0.setAnimationRunning(false);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                c16462 = this;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableV2State$snapTo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SwipeableV2State", m14021f = "SwipeableV2.kt", m14022i = {0, 0}, m14023l = {JPEG.APP5}, m14024m = "snapTo", m14025n = {"this", "targetState"}, m14026s = {"L$0", "L$1"})
    public static final class C16471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16471(SwipeableV2State<T> swipeableV2State, Continuation<? super C16471> continuation) {
            super(continuation);
            this.this$0 = swipeableV2State;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.snapTo(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableV2State$snapTo$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SwipeableV2State$snapTo$2", m14021f = "SwipeableV2.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C16482 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $targetOffset;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16482(float f, SwipeableV2State<T> swipeableV2State, Continuation<? super C16482> continuation) {
            super(2, continuation);
            this.$targetOffset = f;
            this.this$0 = swipeableV2State;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C16482 c16482 = new C16482(this.$targetOffset, this.this$0, continuation);
            c16482.L$0 = obj;
            return c16482;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C16482) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((DragScope) this.L$0).dragBy(this.$targetOffset - this.this$0.getOffset().getValue().floatValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableV2State(T t, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super T, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = confirmStateChange;
        this.currentState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetState = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.SwipeableV2State$targetState$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return Float.isNaN(this.this$0.getUnsafeOffset()) ? this.this$0.getCurrentState() : (T) SwipeableV2Kt.closestState(this.this$0.getAnchors$material_release(), this.this$0.getUnsafeOffset());
            }
        });
        this.offset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$offset$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                if (Float.isNaN(this.this$0.getUnsafeOffset())) {
                    throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
                }
                return Float.valueOf(this.this$0.getUnsafeOffset());
            }
        });
        this.isAnimationRunning = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.progress = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$progress$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Float invoke() {
                float f;
                Float f4 = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getCurrentState());
                float fFloatValue = f4 != null ? f4.floatValue() : 0.0f;
                Float f5 = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getTargetState());
                float fFloatValue2 = (f5 != null ? f5.floatValue() : 0.0f) - fFloatValue;
                if (Math.abs(fFloatValue2) > 1.0E-6f) {
                    float fFloatValue3 = (this.this$0.getOffset().getValue().floatValue() - fFloatValue) / fFloatValue2;
                    f = fFloatValue3 >= 1.0E-6f ? fFloatValue3 > 0.999999f ? 1.0f : fFloatValue3 : 0.0f;
                }
                return Float.valueOf(f);
            }
        });
        Float fValueOf = Float.valueOf(0.0f);
        this.lastVelocity = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.dragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), null, 2, null);
        this.unsafeOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$unsafeOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(RangesKt.coerceIn(((Number) ((SwipeableV2State) this.this$0).dragPosition.getValue()).floatValue(), this.this$0.getMinBound(), this.this$0.getMaxBound()));
            }
        });
        this.minBound = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$minBound$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                Float fMinOrNull = SwipeableV2Kt.minOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(fMinOrNull != null ? fMinOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxBound = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$maxBound$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                Float fMaxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(fMaxOrNull != null ? fMaxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        this.positionalThresholds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function2<T, T, Float>() { // from class: androidx.compose.material.SwipeableV2State$positionalThresholds$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Float invoke(T t2, T t5) {
                return Float.valueOf(0.0f);
            }
        }, null, 2, null);
        this.velocityThreshold = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.compose.material.SwipeableV2State$draggableState$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                ((SwipeableV2State) this.this$0).dragPosition.setValue(Float.valueOf(((Number) ((SwipeableV2State) this.this$0).dragPosition.getValue()).floatValue() + f));
            }
        });
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Object] */
    private final T computeTarget(float offset, T currentState, Function2<? super T, ? super T, Float> thresholds, float velocity, float velocityThreshold) {
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        if (SwipeableV2Kt.requireAnchor(anchors$material_release, currentState) <= offset) {
            if (velocity >= velocityThreshold) {
                return (T) SwipeableV2Kt.closestState(anchors$material_release, offset, true);
            }
            ?? r6 = (Object) SwipeableV2Kt.closestState(anchors$material_release, offset, true);
            if (offset >= thresholds.invoke(currentState, r6).floatValue()) {
                return r6;
            }
        } else {
            if (velocity <= (-velocityThreshold)) {
                return (T) SwipeableV2Kt.closestState(anchors$material_release, offset, false);
            }
            ?? r62 = (Object) SwipeableV2Kt.closestState(anchors$material_release, offset, false);
            if (offset <= thresholds.invoke(currentState, r62).floatValue()) {
                return r62;
            }
        }
        return currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMaxBound() {
        return ((Number) this.maxBound.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMinBound() {
        return ((Number) this.minBound.getValue()).floatValue();
    }

    private final Function2<T, T, Float> getPositionalThresholds() {
        return (Function2) this.positionalThresholds.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getUnsafeOffset() {
        return ((Number) this.unsafeOffset.getValue()).floatValue();
    }

    private final float getVelocityThreshold() {
        return ((Number) this.velocityThreshold.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning.setValue(Boolean.valueOf(z));
    }

    private final void setCurrentState(T t) {
        this.currentState.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity.setValue(Float.valueOf(f));
    }

    private final void setPositionalThresholds(Function2<? super T, ? super T, Float> function2) {
        this.positionalThresholds.setValue(function2);
    }

    private final void setVelocityThreshold(float f) {
        this.velocityThreshold.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r10v6 */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateTo(T t, float f, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        C16451 c16451;
        Throwable th;
        SwipeableV2State swipeableV2State;
        SwipeableV2State swipeableV2State2;
        Iterator<T> it;
        T next;
        Object key;
        T next2;
        if (continuation instanceof C16451) {
            c16451 = (C16451) continuation;
            int i = c16451.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c16451.label = i - Integer.MIN_VALUE;
            } else {
                c16451 = new C16451(this, continuation);
            }
        }
        C16451 c164512 = c16451;
        Object obj = c164512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c164512.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            float fRequireAnchor = SwipeableV2Kt.requireAnchor(getAnchors$material_release(), t);
            try {
                DraggableState draggableState = this.draggableState;
                C16462 c16462 = new C16462(this, fRequireAnchor, f, null);
                c164512.L$0 = this;
                c164512.label = 1;
                if (DraggableState.drag$default(draggableState, null, c16462, c164512, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                swipeableV2State2 = this;
            } catch (Throwable th2) {
                th = th2;
                swipeableV2State = this;
                float fFloatValue = swipeableV2State.dragPosition.getValue().floatValue();
                it = swipeableV2State.getAnchors$material_release().entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                Map.Entry entry = (Map.Entry) next;
                if (entry != null) {
                }
                if (key == null) {
                }
                swipeableV2State.setCurrentState(key);
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            swipeableV2State2 = (SwipeableV2State) c164512.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                swipeableV2State2 = swipeableV2State2;
            } catch (Throwable th3) {
                th = th3;
                swipeableV2State = swipeableV2State2;
                float fFloatValue2 = swipeableV2State.dragPosition.getValue().floatValue();
                it = swipeableV2State.getAnchors$material_release().entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - fFloatValue2) < 0.5f) {
                        break;
                    }
                }
                Map.Entry entry2 = (Map.Entry) next;
                key = entry2 != null ? entry2.getKey() : null;
                if (key == null) {
                    key = swipeableV2State.getCurrentState();
                }
                swipeableV2State.setCurrentState(key);
                throw th;
            }
        }
        swipeableV2State2.setLastVelocity(0.0f);
        float fFloatValue3 = swipeableV2State2.dragPosition.getValue().floatValue();
        Iterator<T> it2 = swipeableV2State2.getAnchors$material_release().entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - fFloatValue3) < 0.5f) {
                break;
            }
        }
        Map.Entry entry3 = (Map.Entry) next2;
        key = entry3 != null ? entry3.getKey() : null;
        if (key == null) {
            key = swipeableV2State2.getCurrentState();
        }
        swipeableV2State2.setCurrentState(key);
        return Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float delta) {
        float fCoerceIn = RangesKt.coerceIn(this.dragPosition.getValue().floatValue() + delta, getMinBound(), getMaxBound()) - this.dragPosition.getValue().floatValue();
        if (Math.abs(fCoerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(fCoerceIn);
        }
        return fCoerceIn;
    }

    @NotNull
    public final Map<T, Float> getAnchors$material_release() {
        return (Map) this.anchors.getValue();
    }

    @NotNull
    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    @NotNull
    public final Function1<T, Boolean> getConfirmStateChange() {
        return this.confirmStateChange;
    }

    public final T getCurrentState() {
        return this.currentState.getValue();
    }

    @NotNull
    /* JADX INFO: renamed from: getDraggableState$material_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        return ((Number) this.lastVelocity.getValue()).floatValue();
    }

    @NotNull
    public final State<Float> getOffset() {
        return this.offset;
    }

    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    public final T getTargetState() {
        return (T) this.targetState.getValue();
    }

    public final boolean hasAnchorForState(T state) {
        return getAnchors$material_release().containsKey(state);
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning.getValue()).booleanValue();
    }

    public final void setAnchors$material_release(@NotNull Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors.setValue(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object settle(float f, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        Object currentState = getCurrentState();
        Object objComputeTarget = computeTarget(this.offset.getValue().floatValue(), currentState, getPositionalThresholds(), f, getVelocityThreshold());
        if (this.confirmStateChange.invoke((T) objComputeTarget).booleanValue()) {
            Object objAnimateTo = animateTo(objComputeTarget, f, continuation);
            return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
        }
        Object objAnimateTo2 = animateTo(currentState, f, continuation);
        return objAnimateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo2 : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object snapTo(T t, @NotNull Continuation<? super Unit> continuation) {
        C16471 c16471;
        SwipeableV2State<T> swipeableV2State;
        if (continuation instanceof C16471) {
            c16471 = (C16471) continuation;
            int i = c16471.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c16471.label = i - Integer.MIN_VALUE;
            } else {
                c16471 = new C16471(this, continuation);
            }
        }
        C16471 c164712 = c16471;
        Object obj = c164712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c164712.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            float fRequireAnchor = SwipeableV2Kt.requireAnchor(getAnchors$material_release(), t);
            DraggableState draggableState = this.draggableState;
            C16482 c16482 = new C16482(fRequireAnchor, this, null);
            c164712.L$0 = this;
            c164712.L$1 = t;
            c164712.label = 1;
            if (DraggableState.drag$default(draggableState, null, c16482, c164712, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            swipeableV2State = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t = (T) c164712.L$1;
            swipeableV2State = (SwipeableV2State) c164712.L$0;
            ResultKt.throwOnFailure(obj);
        }
        swipeableV2State.setCurrentState(t);
        return Unit.INSTANCE;
    }

    public final void updateAnchors$material_release(@NotNull Map<T, Float> newAnchors) {
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        boolean zIsEmpty = getAnchors$material_release().isEmpty();
        setAnchors$material_release(newAnchors);
        if (zIsEmpty) {
            this.dragPosition.setValue(Float.valueOf(SwipeableV2Kt.requireAnchor(getAnchors$material_release(), getCurrentState())));
        }
    }

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableV2State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(T t) {
                return Boolean.TRUE;
            }
        } : function1);
    }
}
