package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.p109ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", m14021f = "LazyLayoutItemAnimation.kt", m14022i = {0}, m14023l = {151, 158}, m14024m = "invokeSuspend", m14025n = {"finalSpec"}, m14026s = {"L$0"})
public final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutItemAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(1:40)|(1:(1:(5:6|7|34|35|36)(2:9|10))(2:11|12))(7:14|15|(2:17|(1:19)(1:20))(1:22)|21|23|(2:25|(1:27))(4:29|30|38|31)|33)|28|29|30|38|31) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12, r4, r5, null, r7, r8, 4, null) != r0) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        FiniteAnimationSpec finiteAnimationSpec;
        FiniteAnimationSpec finiteAnimationSpec2;
        LazyLayoutItemAnimation$animatePlacementDelta$1 lazyLayoutItemAnimation$animatePlacementDelta$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.placementDeltaAnimation.isRunning()) {
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec3 = this.$spec;
                finiteAnimationSpec = finiteAnimationSpec3 instanceof SpringSpec ? (SpringSpec) finiteAnimationSpec3 : LazyLayoutItemAnimationKt.InterruptionSpec;
            } else {
                finiteAnimationSpec = this.$spec;
            }
            finiteAnimationSpec2 = finiteAnimationSpec;
            if (this.this$0.placementDeltaAnimation.isRunning()) {
                FiniteAnimationSpec finiteAnimationSpec4 = finiteAnimationSpec2;
                final long jM21099minusqkQi6aY = IntOffset.m21099minusqkQi6aY(((IntOffset) this.this$0.placementDeltaAnimation.getValue()).getPackedValue(), this.$totalDelta);
                Animatable animatable = this.this$0.placementDeltaAnimation;
                IntOffset intOffsetM21087boximpl = IntOffset.m21087boximpl(jM21099minusqkQi6aY);
                final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
                Function1<Animatable<IntOffset, AnimationVector2D>, Unit> function1 = new Function1<Animatable<IntOffset, AnimationVector2D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Animatable<IntOffset, AnimationVector2D> animatable2) {
                        invoke2(animatable2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Animatable<IntOffset, AnimationVector2D> animatable2) {
                        lazyLayoutItemAnimation.m16009setPlacementDeltagyyYBs(IntOffset.m21099minusqkQi6aY(animatable2.getValue().getPackedValue(), jM21099minusqkQi6aY));
                        lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
                    }
                };
                this.L$0 = null;
                this.label = 2;
                lazyLayoutItemAnimation$animatePlacementDelta$1 = this;
            } else {
                Animatable animatable2 = this.this$0.placementDeltaAnimation;
                IntOffset intOffsetM21087boximpl2 = IntOffset.m21087boximpl(this.$totalDelta);
                this.L$0 = finiteAnimationSpec2;
                this.label = 1;
                if (animatable2.snapTo(intOffsetM21087boximpl2, this) == coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            lazyLayoutItemAnimation$animatePlacementDelta$1 = this;
            lazyLayoutItemAnimation$animatePlacementDelta$1.this$0.setPlacementAnimationInProgress(false);
            lazyLayoutItemAnimation$animatePlacementDelta$1.this$0.isRunningMovingAwayAnimation = false;
            return Unit.INSTANCE;
        }
        finiteAnimationSpec2 = (FiniteAnimationSpec) this.L$0;
        ResultKt.throwOnFailure(obj);
        this.this$0.onLayerPropertyChanged.invoke();
        FiniteAnimationSpec finiteAnimationSpec42 = finiteAnimationSpec2;
        final long jM21099minusqkQi6aY2 = IntOffset.m21099minusqkQi6aY(((IntOffset) this.this$0.placementDeltaAnimation.getValue()).getPackedValue(), this.$totalDelta);
        Animatable animatable3 = this.this$0.placementDeltaAnimation;
        IntOffset intOffsetM21087boximpl3 = IntOffset.m21087boximpl(jM21099minusqkQi6aY2);
        final LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.this$0;
        Function1<Animatable<IntOffset, AnimationVector2D>, Unit> function12 = new Function1<Animatable<IntOffset, AnimationVector2D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animatable<IntOffset, AnimationVector2D> animatable22) {
                invoke2(animatable22);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Animatable<IntOffset, AnimationVector2D> animatable22) {
                lazyLayoutItemAnimation2.m16009setPlacementDeltagyyYBs(IntOffset.m21099minusqkQi6aY(animatable22.getValue().getPackedValue(), jM21099minusqkQi6aY2));
                lazyLayoutItemAnimation2.onLayerPropertyChanged.invoke();
            }
        };
        this.L$0 = null;
        this.label = 2;
        lazyLayoutItemAnimation$animatePlacementDelta$1 = this;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
