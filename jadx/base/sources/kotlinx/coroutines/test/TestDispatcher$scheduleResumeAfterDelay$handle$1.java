package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
public /* synthetic */ class TestDispatcher$scheduleResumeAfterDelay$handle$1 extends FunctionReferenceImpl implements Function1<CancellableContinuationRunnable, Boolean> {
    public static final TestDispatcher$scheduleResumeAfterDelay$handle$1 INSTANCE = new TestDispatcher$scheduleResumeAfterDelay$handle$1();

    public TestDispatcher$scheduleResumeAfterDelay$handle$1() {
        super(1, TestDispatcherKt.class, "cancellableRunnableIsCancelled", "cancellableRunnableIsCancelled(Lkotlinx/coroutines/test/CancellableContinuationRunnable;)Z", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(CancellableContinuationRunnable cancellableContinuationRunnable) {
        return Boolean.valueOf(TestDispatcherKt.cancellableRunnableIsCancelled(cancellableContinuationRunnable));
    }
}
