package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.animation.core.TransitionKt$rememberTransition$1$1", m14021f = "Transition.kt", m14022i = {0}, m14023l = {2191}, m14024m = "invokeSuspend", m14025n = {"$this$withLock_u24default$iv"}, m14026s = {"L$0"})
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/TransitionKt$rememberTransition$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,2185:1\n120#2,10:2186\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/compose/animation/core/TransitionKt$rememberTransition$1$1\n*L\n828#1:2186,10\n*E\n"})
public final class TransitionKt$rememberTransition$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TransitionState<T> $transitionState;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransitionKt$rememberTransition$1$1(TransitionState<T> transitionState, Continuation<? super TransitionKt$rememberTransition$1$1> continuation) {
        super(2, continuation);
        this.$transitionState = transitionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TransitionKt$rememberTransition$1$1(this.$transitionState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Mutex compositionContinuationMutex;
        TransitionState transitionState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((SeekableTransitionState) this.$transitionState).observeTotalDuration$animation_core_release();
            compositionContinuationMutex = ((SeekableTransitionState) this.$transitionState).getCompositionContinuationMutex();
            TransitionState transitionState2 = this.$transitionState;
            this.L$0 = compositionContinuationMutex;
            this.L$1 = transitionState2;
            this.label = 1;
            if (compositionContinuationMutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            transitionState = transitionState2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            transitionState = (TransitionState) this.L$1;
            compositionContinuationMutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            ((SeekableTransitionState) transitionState).setComposedTargetState$animation_core_release(transitionState.getTargetState());
            CancellableContinuation compositionContinuation$animation_core_release = ((SeekableTransitionState) transitionState).getCompositionContinuation$animation_core_release();
            if (compositionContinuation$animation_core_release != null) {
                Result.Companion companion = Result.INSTANCE;
                compositionContinuation$animation_core_release.resumeWith(Result.m22215constructorimpl(transitionState.getTargetState()));
            }
            ((SeekableTransitionState) transitionState).setCompositionContinuation$animation_core_release(null);
            Unit unit = Unit.INSTANCE;
            compositionContinuationMutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            compositionContinuationMutex.unlock(null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransitionKt$rememberTransition$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
