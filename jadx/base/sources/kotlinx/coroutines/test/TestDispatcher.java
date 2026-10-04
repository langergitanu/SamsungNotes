package kotlinx.coroutines.test;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.time.Duration;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayWithTimeoutDiagnostics;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0016\u001a\u00060\u0018j\u0002`\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017¢\u0006\u0004\b \u0010!R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\""}, m13886d2 = {"Lkotlinx/coroutines/test/TestDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "<init>", "()V", "scheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "processEvent", "", "marker", "", "processEvent$kotlinx_coroutines_test", "scheduleResumeAfterDelay", "timeMillis", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "block", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "context", "Lkotlin/coroutines/CoroutineContext;", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "timeoutMessage", "", "timeout", "Lkotlin/time/Duration;", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class TestDispatcher extends CoroutineDispatcher implements Delay, DelayWithTimeoutDiagnostics {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeOnTimeout$lambda$0(Runnable runnable) {
        return false;
    }

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    @NotNull
    public abstract TestCoroutineScheduler getScheduler();

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return getScheduler().registerEvent$kotlinx_coroutines_test(this, timeMillis, block, context, new C13484a(4));
    }

    public final void processEvent$kotlinx_coroutines_test(@NotNull Object marker) {
        if (!(marker instanceof Runnable)) {
            throw new IllegalStateException("Check failed.");
        }
        ((Runnable) marker).run();
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo23764scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        CancellableContinuationKt.disposeOnCancellation(continuation, getScheduler().registerEvent$kotlinx_coroutines_test(this, timeMillis, new CancellableContinuationRunnable(continuation, this), continuation.getContext(), TestDispatcher$scheduleResumeAfterDelay$handle$1.INSTANCE));
    }

    @Override // kotlinx.coroutines.DelayWithTimeoutDiagnostics
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Is only needed internally")
    /* JADX INFO: renamed from: timeoutMessage-LRDsOJo */
    public /* synthetic */ String mo23696timeoutMessageLRDsOJo(long timeout) {
        return "Timed out after " + ((Object) Duration.m23594toStringimpl(timeout)) + " of _virtual_ (kotlinx.coroutines.test) time. To use the real time, wrap 'withTimeout' in 'withContext(Dispatchers.Default.limitedParallelism(1))'";
    }
}
