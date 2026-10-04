package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0017\u0018\u0000 t*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001tBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ'\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010aJ)\u0010b\u001a\u00020^2\u0006\u0010O\u001a\u00028\u00002\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010dJ!\u0010e\u001a\u00020^2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0002\bgJ\u000e\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0006J\u0019\u0010j\u001a\u00020^2\u0006\u0010k\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010lJ;\u0010m\u001a\u00020^2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0080@ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ\u0019\u0010q\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010lJ\u0019\u0010r\u001a\u00020^2\u0006\u0010O\u001a\u00028\u0000H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010sR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR+\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R+\u0010-\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u001103X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u00107R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060<8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060<8F¢\u0006\u0006\u001a\u0004\bA\u0010>R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D8FX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u0010&\u001a\u0004\bF\u0010GR/\u0010I\u001a\u0004\u0018\u00010H2\b\u0010\u0010\u001a\u0004\u0018\u00010H8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010\u0018\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010O\u001a\u00028\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010&\u001a\u0004\bQ\u0010 RO\u0010S\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060R2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060R8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bX\u0010\u0018\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR+\u0010Y\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u0018\u001a\u0004\bZ\u0010(\"\u0004\b[\u00107\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006u"}, m13886d2 = {"Landroidx/compose/material/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "absoluteOffset", "Landroidx/compose/runtime/MutableState;", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getConfirmStateChange$material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "direction", "getDirection$annotations", "()V", "getDirection", "()F", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "maxBound", "getMaxBound$material_release", "setMaxBound$material_release", "(F)V", "minBound", "getMinBound$material_release", "setMinBound$material_release", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "offsetState", "overflow", "getOverflow", "overflowState", "progress", "Landroidx/compose/material/SwipeProgress;", "getProgress$annotations", "getProgress", "()Landroidx/compose/material/SwipeProgress;", "Landroidx/compose/material/ResistanceConfig;", "resistance", "getResistance$material_release", "()Landroidx/compose/material/ResistanceConfig;", "setResistance$material_release", "(Landroidx/compose/material/ResistanceConfig;)V", "resistance$delegate", "targetValue", "getTargetValue$annotations", "getTargetValue", "Lkotlin/Function2;", "thresholds", "getThresholds$material_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$material_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$material_release", "setVelocityThreshold$material_release", "velocityThreshold$delegate", "animateInternalToOffset", "", "target", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInit", "newAnchors", "ensureInit$material_release", "performDrag", "delta", "performFling", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "oldAnchors", "processNewAnchors$material_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapInternalToOffset", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@Stable
@ExperimentalMaterialApi
public class SwipeableState<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final MutableState<Float> absoluteOffset;

    /* JADX INFO: renamed from: anchors$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState anchors;

    @NotNull
    private final AnimationSpec<Float> animationSpec;

    @NotNull
    private final MutableState<Float> animationTarget;

    @NotNull
    private final Function1<T, Boolean> confirmStateChange;

    /* JADX INFO: renamed from: currentValue$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState currentValue;

    @NotNull
    private final DraggableState draggableState;

    /* JADX INFO: renamed from: isAnimationRunning$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState isAnimationRunning;

    @NotNull
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;

    @NotNull
    private final MutableState<Float> offsetState;

    @NotNull
    private final MutableState<Float> overflowState;

    /* JADX INFO: renamed from: resistance$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState resistance;

    /* JADX INFO: renamed from: thresholds$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState thresholds;

    /* JADX INFO: renamed from: velocityThreshold$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState velocityThreshold;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, m13886d2 = {"Landroidx/compose/material/SwipeableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> Saver<SwipeableState<T>, T> Saver(@NotNull final AnimationSpec<Float> animationSpec, @NotNull final Function1<? super T, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(new Function2<SaverScope, SwipeableState<T>, T>() { // from class: androidx.compose.material.SwipeableState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final T invoke(@NotNull SaverScope Saver, @NotNull SwipeableState<T> it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1<T, SwipeableState<T>>() { // from class: androidx.compose.material.SwipeableState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final SwipeableState<T> invoke(@NotNull T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SwipeableState<>(it, animationSpec, confirmStateChange);
                }
            });
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateInternalToOffset$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SwipeableState$animateInternalToOffset$2", m14021f = "Swipeable.kt", m14022i = {}, m14023l = {JPEG.EXP}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C16342 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $spec;
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16342(SwipeableState<T> swipeableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super C16342> continuation) {
            super(2, continuation);
            this.this$0 = swipeableState;
            this.$target = f;
            this.$spec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C16342 c16342 = new C16342(this.this$0, this.$target, this.$spec, continuation);
            c16342.L$0 = obj;
            return c16342;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C16342) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final DragScope dragScope = (DragScope) this.L$0;
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    floatRef.element = ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue();
                    ((SwipeableState) this.this$0).animationTarget.setValue(Boxing.boxFloat(this.$target));
                    this.this$0.setAnimationRunning(true);
                    Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(floatRef.element, 0.0f, 2, null);
                    Float fBoxFloat = Boxing.boxFloat(this.$target);
                    AnimationSpec<Float> animationSpec = this.$spec;
                    Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SwipeableState.animateInternalToOffset.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                            invoke2(animatable);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Animatable<Float, AnimationVector1D> animateTo) {
                            Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                            dragScope.dragBy(animateTo.getValue().floatValue() - floatRef.element);
                            floatRef.element = animateTo.getValue().floatValue();
                        }
                    };
                    this.label = 1;
                    if (Animatable.animateTo$default(animatableAnimatable$default, fBoxFloat, animationSpec, null, function1, this, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((SwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ((SwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateTo$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "anchors", "", ""}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class C16352 implements FlowCollector<Map<Float, ? extends T>> {
        final /* synthetic */ AnimationSpec<Float> $anim;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        public C16352(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
            this.$targetValue = t;
            this.this$0 = swipeableState;
            this.$anim = animationSpec;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Map) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation) throws Throwable {
            SwipeableState$animateTo$2$emit$1 swipeableState$animateTo$2$emit$1;
            C16352 c16352;
            Object objFirstOrNull;
            Object objFirstOrNull2;
            if (continuation instanceof SwipeableState$animateTo$2$emit$1) {
                swipeableState$animateTo$2$emit$1 = (SwipeableState$animateTo$2$emit$1) continuation;
                int i = swipeableState$animateTo$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    swipeableState$animateTo$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, continuation);
                }
            }
            Object obj = swipeableState$animateTo$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = swipeableState$animateTo$2$emit$1.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                map = (Map) swipeableState$animateTo$2$emit$1.L$1;
                c16352 = (C16352) swipeableState$animateTo$2$emit$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    float fFloatValue = ((Number) ((SwipeableState) c16352.this$0).absoluteOffset.getValue()).floatValue();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Float, ? extends T> entry : map.entrySet()) {
                        if (Math.abs(entry.getKey().floatValue() - fFloatValue) < 0.5f) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    objFirstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap.values());
                    if (objFirstOrNull2 == null) {
                        objFirstOrNull2 = c16352.this$0.getCurrentValue();
                    }
                    c16352.this$0.setCurrentValue(objFirstOrNull2);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    float fFloatValue2 = ((Number) ((SwipeableState) c16352.this$0).absoluteOffset.getValue()).floatValue();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    while (r7.hasNext()) {
                    }
                    objFirstOrNull = CollectionsKt.firstOrNull(linkedHashMap2.values());
                    if (objFirstOrNull == null) {
                    }
                    c16352.this$0.setCurrentValue(objFirstOrNull);
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            try {
                Float offset = SwipeableKt.getOffset(map, this.$targetValue);
                if (offset == null) {
                    throw new IllegalArgumentException("The target value must have an associated anchor.");
                }
                SwipeableState<T> swipeableState = this.this$0;
                float fFloatValue3 = offset.floatValue();
                AnimationSpec<Float> animationSpec = this.$anim;
                swipeableState$animateTo$2$emit$1.L$0 = this;
                swipeableState$animateTo$2$emit$1.L$1 = map;
                swipeableState$animateTo$2$emit$1.label = 1;
                if (swipeableState.animateInternalToOffset(fFloatValue3, animationSpec, swipeableState$animateTo$2$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c16352 = this;
                float fFloatValue4 = ((Number) ((SwipeableState) c16352.this$0).absoluteOffset.getValue()).floatValue();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                while (r7.hasNext()) {
                }
                objFirstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap3.values());
                if (objFirstOrNull2 == null) {
                }
                c16352.this$0.setCurrentValue(objFirstOrNull2);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                c16352 = this;
                float fFloatValue22 = ((Number) ((SwipeableState) c16352.this$0).absoluteOffset.getValue()).floatValue();
                LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                for (Map.Entry<Float, ? extends T> entry2 : map.entrySet()) {
                    if (Math.abs(entry2.getKey().floatValue() - fFloatValue22) < 0.5f) {
                        linkedHashMap22.put(entry2.getKey(), entry2.getValue());
                    }
                }
                objFirstOrNull = CollectionsKt.firstOrNull(linkedHashMap22.values());
                if (objFirstOrNull == null) {
                    objFirstOrNull = c16352.this$0.getCurrentValue();
                }
                c16352.this$0.setCurrentValue(objFirstOrNull);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapInternalToOffset$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.material.SwipeableState$snapInternalToOffset$2", m14021f = "Swipeable.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C16372 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16372(float f, SwipeableState<T> swipeableState, Continuation<? super C16372> continuation) {
            super(2, continuation);
            this.$target = f;
            this.this$0 = swipeableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C16372 c16372 = new C16372(this.$target, this.this$0, continuation);
            c16372.L$0 = obj;
            return c16372;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C16372) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((DragScope) this.L$0).dragBy(this.$target - ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapTo$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "anchors", "", ""}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class C16382 implements FlowCollector<Map<Float, ? extends T>> {
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        public C16382(T t, SwipeableState<T> swipeableState) {
            this.$targetValue = t;
            this.this$0 = swipeableState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Map) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation) {
            SwipeableState$snapTo$2$emit$1 swipeableState$snapTo$2$emit$1;
            C16382 c16382;
            if (continuation instanceof SwipeableState$snapTo$2$emit$1) {
                swipeableState$snapTo$2$emit$1 = (SwipeableState$snapTo$2$emit$1) continuation;
                int i = swipeableState$snapTo$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    swipeableState$snapTo$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, continuation);
                }
            }
            Object obj = swipeableState$snapTo$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = swipeableState$snapTo$2$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Float offset = SwipeableKt.getOffset(map, this.$targetValue);
                if (offset == null) {
                    throw new IllegalArgumentException("The target value must have an associated anchor.");
                }
                SwipeableState<T> swipeableState = this.this$0;
                float fFloatValue = offset.floatValue();
                swipeableState$snapTo$2$emit$1.L$0 = this;
                swipeableState$snapTo$2$emit$1.label = 1;
                if (swipeableState.snapInternalToOffset(fFloatValue, swipeableState$snapTo$2$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c16382 = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c16382 = (C16382) swipeableState$snapTo$2$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            c16382.this$0.setCurrentValue(c16382.$targetValue);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableState(T t, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super T, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = confirmStateChange;
        this.currentValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.isAnimationRunning = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        Float fValueOf = Float.valueOf(0.0f);
        this.offsetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.overflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.absoluteOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        final Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Map<Float, ? extends T>>(this) { // from class: androidx.compose.material.SwipeableState$latestNonEmptyAnchorsFlow$1
            final /* synthetic */ SwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Float, T> invoke() {
                return this.this$0.getAnchors$material_release();
            }
        });
        this.latestNonEmptyAnchorsFlow = FlowKt.take(new Flow<Map<Float, ? extends T>>() { // from class: androidx.compose.material.SwipeableState$special$$inlined$filter$1

            /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2 */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m13886d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
            public static final class C16392<T> implements FlowCollector, SuspendFunction {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.material.SwipeableState$special$$inlined$filter$1$2", m14021f = "Swipeable.kt", m14022i = {}, m14023l = {JPEG.APP0}, m14024m = "emit", m14025n = {}, m14026s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C16392.this.emit(null, this);
                    }
                }

                public C16392(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (!((Map) obj).isEmpty()) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowSnapshotFlow.collect(new C16392(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableState$thresholds$2
            @NotNull
            public final Float invoke(float f, float f4) {
                return Float.valueOf(0.0f);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(Float f, Float f4) {
                return invoke(f.floatValue(), f4.floatValue());
            }
        }, null, 2, null);
        this.velocityThreshold = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.resistance = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.compose.material.SwipeableState$draggableState$1
            final /* synthetic */ SwipeableState<T> this$0;

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
                float fFloatValue = ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue() + f;
                float fCoerceIn = RangesKt.coerceIn(fFloatValue, this.this$0.getMinBound(), this.this$0.getMaxBound());
                float f4 = fFloatValue - fCoerceIn;
                ResistanceConfig resistance$material_release = this.this$0.getResistance$material_release();
                ((SwipeableState) this.this$0).offsetState.setValue(Float.valueOf(fCoerceIn + (resistance$material_release != null ? resistance$material_release.computeResistance(f4) : 0.0f)));
                ((SwipeableState) this.this$0).overflowState.setValue(Float.valueOf(f4));
                ((SwipeableState) this.this$0).absoluteOffset.setValue(Float.valueOf(fFloatValue));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(this.draggableState, null, new C16342(this, f, animationSpec, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SwipeableState swipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i & 2) != 0) {
            animationSpec = swipeableState.animationSpec;
        }
        return swipeableState.animateTo(obj, animationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object snapInternalToOffset(float f, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(this.draggableState, null, new C16372(f, this, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object animateTo(T t, @NotNull AnimationSpec<Float> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C16352(t, this, animationSpec), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final void ensureInit$material_release(@NotNull Map<Float, ? extends T> newAnchors) {
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        if (getAnchors$material_release().isEmpty()) {
            Float offset = SwipeableKt.getOffset(newAnchors, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.");
            }
            this.offsetState.setValue(offset);
            this.absoluteOffset.setValue(offset);
        }
    }

    @NotNull
    public final Map<Float, T> getAnchors$material_release() {
        return (Map) this.anchors.getValue();
    }

    @NotNull
    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    @NotNull
    public final Function1<T, Boolean> getConfirmStateChange$material_release() {
        return this.confirmStateChange;
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    public final float getDirection() {
        Float offset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
        if (offset == null) {
            return 0.0f;
        }
        return Math.signum(getOffset().getValue().floatValue() - offset.floatValue());
    }

    @NotNull
    /* JADX INFO: renamed from: getDraggableState$material_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    /* JADX INFO: renamed from: getMaxBound$material_release, reason: from getter */
    public final float getMaxBound() {
        return this.maxBound;
    }

    /* JADX INFO: renamed from: getMinBound$material_release, reason: from getter */
    public final float getMinBound() {
        return this.minBound;
    }

    @NotNull
    public final State<Float> getOffset() {
        return this.offsetState;
    }

    @NotNull
    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    @NotNull
    public final SwipeProgress<T> getProgress() {
        Object currentValue;
        Object value;
        float fFloatValue;
        List listFindBounds = SwipeableKt.findBounds(getOffset().getValue().floatValue(), getAnchors$material_release().keySet());
        int size = listFindBounds.size();
        if (size == 0) {
            T currentValue2 = getCurrentValue();
            currentValue = getCurrentValue();
            value = currentValue2;
            fFloatValue = 1.0f;
        } else if (size != 1) {
            Pair pairM13893to = getDirection() > 0.0f ? TuplesKt.m13893to(listFindBounds.get(0), listFindBounds.get(1)) : TuplesKt.m13893to(listFindBounds.get(1), listFindBounds.get(0));
            float fFloatValue2 = ((Number) pairM13893to.component1()).floatValue();
            float fFloatValue3 = ((Number) pairM13893to.component2()).floatValue();
            value = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(fFloatValue2));
            currentValue = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(fFloatValue3));
            fFloatValue = (getOffset().getValue().floatValue() - fFloatValue2) / (fFloatValue3 - fFloatValue2);
        } else {
            Object value2 = MapsKt.getValue(getAnchors$material_release(), listFindBounds.get(0));
            currentValue = MapsKt.getValue(getAnchors$material_release(), listFindBounds.get(0));
            fFloatValue = 1.0f;
            value = value2;
        }
        return new SwipeProgress<>(value, currentValue, fFloatValue);
    }

    @Nullable
    public final ResistanceConfig getResistance$material_release() {
        return (ResistanceConfig) this.resistance.getValue();
    }

    public final T getTargetValue() {
        float fComputeTarget;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            fComputeTarget = value.floatValue();
        } else {
            float fFloatValue = getOffset().getValue().floatValue();
            Float offset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
            fComputeTarget = SwipeableKt.computeTarget(fFloatValue, offset != null ? offset.floatValue() : getOffset().getValue().floatValue(), getAnchors$material_release().keySet(), getThresholds$material_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t = getAnchors$material_release().get(Float.valueOf(fComputeTarget));
        return t == null ? getCurrentValue() : t;
    }

    @NotNull
    public final Function2<Float, Float, Float> getThresholds$material_release() {
        return (Function2) this.thresholds.getValue();
    }

    public final float getVelocityThreshold$material_release() {
        return ((Number) this.velocityThreshold.getValue()).floatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning.getValue()).booleanValue();
    }

    public final float performDrag(float delta) {
        float fCoerceIn = RangesKt.coerceIn(this.absoluteOffset.getValue().floatValue() + delta, this.minBound, this.maxBound) - this.absoluteOffset.getValue().floatValue();
        if (Math.abs(fCoerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(fCoerceIn);
        }
        return fCoerceIn;
    }

    @Nullable
    public final Object performFling(final float f, @NotNull Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new FlowCollector<Map<Float, ? extends T>>(this) { // from class: androidx.compose.material.SwipeableState.performFling.2
            final /* synthetic */ SwipeableState<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Map) obj, (Continuation<? super Unit>) continuation2);
            }

            @Nullable
            public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation2) {
                Float offset = SwipeableKt.getOffset(map, this.this$0.getCurrentValue());
                Intrinsics.checkNotNull(offset);
                float fFloatValue = offset.floatValue();
                T t = map.get(Boxing.boxFloat(SwipeableKt.computeTarget(this.this$0.getOffset().getValue().floatValue(), fFloatValue, map.keySet(), this.this$0.getThresholds$material_release(), f, this.this$0.getVelocityThreshold$material_release())));
                if (t != null && this.this$0.getConfirmStateChange$material_release().invoke(t).booleanValue()) {
                    Object objAnimateTo$default = SwipeableState.animateTo$default(this.this$0, t, null, continuation2, 2, null);
                    return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
                }
                SwipeableState<T> swipeableState = this.this$0;
                Object objAnimateInternalToOffset = swipeableState.animateInternalToOffset(fFloatValue, swipeableState.getAnimationSpec$material_release(), continuation2);
                return objAnimateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateInternalToOffset : Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (snapInternalToOffset(r10, r0) == r1) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0218  */
    /* JADX WARN: Type inference failed for: r10v21, types: [float] */
    /* JADX WARN: Type inference failed for: r10v76, types: [float] */
    /* JADX WARN: Type inference failed for: r10v78, types: [float] */
    /* JADX WARN: Type inference failed for: r10v89 */
    /* JADX WARN: Type inference failed for: r10v90 */
    /* JADX WARN: Type inference failed for: r10v91 */
    /* JADX WARN: Type inference failed for: r10v92 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processNewAnchors$material_release(@NotNull Map<Float, ? extends T> map, @NotNull Map<Float, ? extends T> map2, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        SwipeableState$processNewAnchors$1 swipeableState$processNewAnchors$1;
        SwipeableState swipeableState;
        SwipeableState swipeableState2;
        SwipeableState swipeableState3;
        SwipeableState swipeableState4;
        float f;
        float f4;
        if (continuation instanceof SwipeableState$processNewAnchors$1) {
            swipeableState$processNewAnchors$1 = (SwipeableState$processNewAnchors$1) continuation;
            int i = swipeableState$processNewAnchors$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                swipeableState$processNewAnchors$1.label = i - Integer.MIN_VALUE;
            } else {
                swipeableState$processNewAnchors$1 = new SwipeableState$processNewAnchors$1(this, continuation);
            }
        }
        Object obj = swipeableState$processNewAnchors$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = swipeableState$processNewAnchors$1.label;
        try {
            if (r2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (map.isEmpty()) {
                    Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMinOrNull);
                    this.minBound = fMinOrNull.floatValue();
                    Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMaxOrNull);
                    this.maxBound = fMaxOrNull.floatValue();
                    Float offset = SwipeableKt.getOffset(map2, getCurrentValue());
                    if (offset == null) {
                        throw new IllegalArgumentException("The initial value must have an associated anchor.");
                    }
                    float fFloatValue = offset.floatValue();
                    swipeableState$processNewAnchors$1.label = 1;
                } else if (!Intrinsics.areEqual(map2, map)) {
                    this.minBound = Float.NEGATIVE_INFINITY;
                    this.maxBound = Float.POSITIVE_INFINITY;
                    Float value = this.animationTarget.getValue();
                    Object next = null;
                    if (value != null) {
                        Float offset2 = SwipeableKt.getOffset(map2, map.get(value));
                        if (offset2 != null) {
                            map = (Map<Float, ? extends T>) offset2.floatValue();
                        } else {
                            Iterator<T> it = map2.keySet().iterator();
                            if (it.hasNext()) {
                                next = it.next();
                                if (it.hasNext()) {
                                    float fAbs = Math.abs(((Number) next).floatValue() - value.floatValue());
                                    do {
                                        Object next2 = it.next();
                                        float fAbs2 = Math.abs(((Number) next2).floatValue() - value.floatValue());
                                        if (Float.compare(fAbs, fAbs2) > 0) {
                                            next = next2;
                                            fAbs = fAbs2;
                                        }
                                    } while (it.hasNext());
                                }
                            }
                            Intrinsics.checkNotNull(next);
                            map = (Map<Float, ? extends T>) ((Number) next).floatValue();
                        }
                    } else {
                        T currentValue = map.get(getOffset().getValue());
                        if (Intrinsics.areEqual(currentValue, getCurrentValue())) {
                            currentValue = getCurrentValue();
                        }
                        Float offset3 = SwipeableKt.getOffset(map2, currentValue);
                        if (offset3 != null) {
                            map = offset3.floatValue();
                        } else {
                            Iterator<T> it2 = map2.keySet().iterator();
                            if (it2.hasNext()) {
                                next = it2.next();
                                if (it2.hasNext()) {
                                    float fAbs3 = Math.abs(((Number) next).floatValue() - getOffset().getValue().floatValue());
                                    do {
                                        Object next3 = it2.next();
                                        float fAbs4 = Math.abs(((Number) next3).floatValue() - getOffset().getValue().floatValue());
                                        if (Float.compare(fAbs3, fAbs4) > 0) {
                                            next = next3;
                                            fAbs3 = fAbs4;
                                        }
                                    } while (it2.hasNext());
                                }
                            }
                            Intrinsics.checkNotNull(next);
                            map = ((Number) next).floatValue();
                        }
                    }
                    try {
                        AnimationSpec<Float> animationSpec = this.animationSpec;
                        swipeableState$processNewAnchors$1.L$0 = this;
                        swipeableState$processNewAnchors$1.L$1 = map2;
                        swipeableState$processNewAnchors$1.F$0 = (float) map;
                        swipeableState$processNewAnchors$1.label = 2;
                        if (animateInternalToOffset((float) map, animationSpec, swipeableState$processNewAnchors$1) != coroutine_suspended) {
                            swipeableState3 = this;
                            f = map;
                            swipeableState3.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f)));
                            Float fMinOrNull2 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(fMinOrNull2);
                            swipeableState3.minBound = fMinOrNull2.floatValue();
                            Float fMaxOrNull2 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                            Intrinsics.checkNotNull(fMaxOrNull2);
                            swipeableState3.maxBound = fMaxOrNull2.floatValue();
                        }
                    } catch (CancellationException unused) {
                        swipeableState2 = this;
                        swipeableState$processNewAnchors$1.L$0 = swipeableState2;
                        swipeableState$processNewAnchors$1.L$1 = map2;
                        swipeableState$processNewAnchors$1.F$0 = map;
                        swipeableState$processNewAnchors$1.label = 3;
                        if (swipeableState2.snapInternalToOffset(map, swipeableState$processNewAnchors$1) != coroutine_suspended) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        swipeableState = this;
                        swipeableState.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(map)));
                        Float fMinOrNull3 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                        Intrinsics.checkNotNull(fMinOrNull3);
                        swipeableState.minBound = fMinOrNull3.floatValue();
                        Float fMaxOrNull3 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                        Intrinsics.checkNotNull(fMaxOrNull3);
                        swipeableState.maxBound = fMaxOrNull3.floatValue();
                        throw th;
                    }
                }
                return coroutine_suspended;
            }
            if (r2 == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (r2 == 2) {
                map = (Map<Float, ? extends T>) swipeableState$processNewAnchors$1.F$0;
                map2 = (Map) swipeableState$processNewAnchors$1.L$1;
                swipeableState2 = (SwipeableState) swipeableState$processNewAnchors$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    swipeableState3 = swipeableState2;
                    f = map;
                    swipeableState3.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f)));
                    Float fMinOrNull22 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMinOrNull22);
                    swipeableState3.minBound = fMinOrNull22.floatValue();
                    Float fMaxOrNull22 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMaxOrNull22);
                    swipeableState3.maxBound = fMaxOrNull22.floatValue();
                } catch (CancellationException unused2) {
                    swipeableState$processNewAnchors$1.L$0 = swipeableState2;
                    swipeableState$processNewAnchors$1.L$1 = map2;
                    swipeableState$processNewAnchors$1.F$0 = map;
                    swipeableState$processNewAnchors$1.label = 3;
                    if (swipeableState2.snapInternalToOffset(map, swipeableState$processNewAnchors$1) != coroutine_suspended) {
                        swipeableState4 = swipeableState2;
                        f4 = map;
                        swipeableState4.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f4)));
                        Float fMinOrNull4 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                        Intrinsics.checkNotNull(fMinOrNull4);
                        swipeableState4.minBound = fMinOrNull4.floatValue();
                        Float fMaxOrNull4 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                        Intrinsics.checkNotNull(fMaxOrNull4);
                        swipeableState4.maxBound = fMaxOrNull4.floatValue();
                    }
                    return coroutine_suspended;
                }
            } else {
                if (r2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                map = (Map<Float, ? extends T>) swipeableState$processNewAnchors$1.F$0;
                map2 = (Map) swipeableState$processNewAnchors$1.L$1;
                swipeableState = (SwipeableState) swipeableState$processNewAnchors$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    swipeableState4 = swipeableState;
                    f4 = map;
                    swipeableState4.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(f4)));
                    Float fMinOrNull42 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMinOrNull42);
                    swipeableState4.minBound = fMinOrNull42.floatValue();
                    Float fMaxOrNull42 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMaxOrNull42);
                    swipeableState4.maxBound = fMaxOrNull42.floatValue();
                } catch (Throwable th2) {
                    th = th2;
                    swipeableState.setCurrentValue(MapsKt.getValue(map2, Boxing.boxFloat(map)));
                    Float fMinOrNull32 = CollectionsKt.minOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMinOrNull32);
                    swipeableState.minBound = fMinOrNull32.floatValue();
                    Float fMaxOrNull32 = CollectionsKt.maxOrNull((Iterable<? extends Float>) map2.keySet());
                    Intrinsics.checkNotNull(fMaxOrNull32);
                    swipeableState.maxBound = fMaxOrNull32.floatValue();
                    throw th;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            swipeableState = r2;
        }
    }

    public final void setAnchors$material_release(@NotNull Map<Float, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors.setValue(map);
    }

    public final void setMaxBound$material_release(float f) {
        this.maxBound = f;
    }

    public final void setMinBound$material_release(float f) {
        this.minBound = f;
    }

    public final void setResistance$material_release(@Nullable ResistanceConfig resistanceConfig) {
        this.resistance.setValue(resistanceConfig);
    }

    public final void setThresholds$material_release(@NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.thresholds.setValue(function2);
    }

    public final void setVelocityThreshold$material_release(float f) {
        this.velocityThreshold.setValue(Float.valueOf(f));
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object snapTo(T t, @NotNull Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C16382(t, this), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getDirection$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getProgress$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getTargetValue$annotations() {
    }

    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(T t) {
                return Boolean.TRUE;
            }
        } : function1);
    }
}
