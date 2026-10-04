package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0002j\u0002`\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0005H\u0016R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lkotlinx/coroutines/test/CancellableContinuationRunnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestDispatcher.kt\nkotlinx/coroutines/test/CancellableContinuationRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
final class CancellableContinuationRunnable implements Runnable {

    @JvmField
    @NotNull
    public final CancellableContinuation<Unit> continuation;

    @NotNull
    private final CoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationRunnable(@NotNull CancellableContinuation<? super Unit> cancellableContinuation, @NotNull CoroutineDispatcher coroutineDispatcher) {
        this.continuation = cancellableContinuation;
        this.dispatcher = coroutineDispatcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.continuation.resumeUndispatched(this.dispatcher, Unit.INSTANCE);
    }
}
