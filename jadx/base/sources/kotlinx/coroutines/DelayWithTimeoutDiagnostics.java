package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Delay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@InternalCoroutinesApi
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "Lkotlinx/coroutines/Delay;", "timeoutMessage", "", "timeout", "Lkotlin/time/Duration;", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface DelayWithTimeoutDiagnostics extends Delay {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @Nullable
        public static Object delay(@NotNull DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, @NotNull Continuation<? super Unit> continuation) {
            Object objDelay = Delay.DefaultImpls.delay(delayWithTimeoutDiagnostics, j, continuation);
            return objDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
        }

        @NotNull
        public static DisposableHandle invokeOnTimeout(@NotNull DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return Delay.DefaultImpls.invokeOnTimeout(delayWithTimeoutDiagnostics, j, runnable, coroutineContext);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: timeoutMessage-LRDsOJo, reason: not valid java name */
    String mo23696timeoutMessageLRDsOJo(long timeout);
}
