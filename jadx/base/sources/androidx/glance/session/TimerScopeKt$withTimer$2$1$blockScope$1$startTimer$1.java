package androidx.glance.session;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.session.TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1", m14021f = "TimerScope.kt", m14022i = {}, m14023l = {115}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
    final /* synthetic */ TimeSource $timeSource;
    final /* synthetic */ CoroutineScope $timerScope;
    int label;
    final /* synthetic */ TimerScopeKt$withTimer$2$1$blockScope$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1(TimerScopeKt$withTimer$2$1$blockScope$1 timerScopeKt$withTimer$2$1$blockScope$1, TimeSource timeSource, CoroutineScope coroutineScope, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = timerScopeKt$withTimer$2$1$blockScope$1;
        this.$timeSource = timeSource;
        this.$timerScope = coroutineScope;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1(this.this$0, this.$timeSource, this.$timerScope, this.$block, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long timeLeft;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0 && i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        do {
            Object obj2 = this.this$0.deadline.get();
            Intrinsics.checkNotNull(obj2);
            if (((Number) obj2).longValue() <= this.$timeSource.markNow()) {
                CoroutineScopeKt.cancel(this.$timerScope, new TimeoutCancellationException("Timed out of executing block.", this.$block.hashCode()));
                return Unit.INSTANCE;
            }
            timeLeft = this.this$0.getTimeLeft();
            this.label = 1;
        } while (DelayKt.m23694delayVtjQ1oo(timeLeft, this) != coroutine_suspended);
        return coroutine_suspended;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
