package androidx.glance.appwidget.multiprocess;

import androidx.glance.oneui.common.GlanceLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.TimerScopeKt$withTimer$3$1$blockScope$1$startTimer$1", m14021f = "TimerScope.kt", m14022i = {}, m14023l = {34, 36}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class TimerScopeKt$withTimer$3$1$blockScope$1$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
    final /* synthetic */ long $initialTimeout;
    final /* synthetic */ String $key;
    final /* synthetic */ Function2<TimerScope, Continuation<? super Unit>, Object> $timerCallback;
    final /* synthetic */ CoroutineScope $timerScope;
    int label;
    final /* synthetic */ TimerScopeKt$withTimer$3$1$blockScope$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimerScopeKt$withTimer$3$1$blockScope$1$startTimer$1(String str, long j, Function2 function2, TimerScopeKt$withTimer$3$1$blockScope$1 timerScopeKt$withTimer$3$1$blockScope$1, CoroutineScope coroutineScope, Function2 function22, Continuation continuation) {
        super(2, continuation);
        this.$key = str;
        this.$initialTimeout = j;
        this.$timerCallback = function2;
        this.this$0 = timerScopeKt$withTimer$3$1$blockScope$1;
        this.$timerScope = coroutineScope;
        this.$block = function22;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TimerScopeKt$withTimer$3$1$blockScope$1$startTimer$1(this.$key, this.$initialTimeout, this.$timerCallback, this.this$0, this.$timerScope, this.$block, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
    
        if (r8.invoke(r1, r7) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlanceLog.INSTANCE.m2297d("GWT:TimerScope", this.$key + " Timer started");
            long j = this.$initialTimeout;
            this.label = 1;
            if (DelayKt.m23694delayVtjQ1oo(j, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.cancel(this.$timerScope, new TimeoutCancellationException("Timed out of executing block.", this.$block.hashCode()));
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        GlanceLog.INSTANCE.m2297d("GWT:TimerScope", this.$key + " Timer ended");
        Function2<TimerScope, Continuation<? super Unit>, Object> function2 = this.$timerCallback;
        TimerScopeKt$withTimer$3$1$blockScope$1 timerScopeKt$withTimer$3$1$blockScope$1 = this.this$0;
        this.label = 2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TimerScopeKt$withTimer$3$1$blockScope$1$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
